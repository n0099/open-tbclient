package com.baidu.pyramid.runtime.multiprocess.components;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class DispatchableContentProvider extends ContentProvider {
    private a bCk;
    private ArrayList<com.baidu.pyramid.runtime.multiprocess.components.a> bCl;
    private String mAuthority;
    private volatile boolean mIsInit = false;
    private final Object bCm = new Object();

    protected abstract String Pf();

    protected abstract List<com.baidu.pyramid.runtime.multiprocess.components.a> Pg();

    private com.baidu.pyramid.runtime.multiprocess.components.a dV(int i) {
        int i2;
        int i3;
        int i4 = 0;
        int size = this.bCl.size() - 1;
        while (i4 <= size) {
            int i5 = (i4 + size) / 2;
            com.baidu.pyramid.runtime.multiprocess.components.a aVar = this.bCl.get(i5);
            if (i < aVar.Pd() || i > aVar.Pe()) {
                if (i < aVar.Pd()) {
                    i3 = i5 - 1;
                    i2 = i4;
                } else {
                    int i6 = size;
                    i2 = i5 + 1;
                    i3 = i6;
                }
                i4 = i2;
                size = i3;
            } else {
                return aVar;
            }
        }
        return null;
    }

    private void a(com.baidu.pyramid.runtime.multiprocess.components.a aVar) {
        if (aVar.Pd() > aVar.Pe()) {
            throw new IllegalArgumentException();
        }
        int size = this.bCl.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3 = aVar.Pd() > this.bCl.get(i).Pe() ? i + 1 : i2;
            i++;
            i2 = i3;
        }
        if (i2 < size - 1 && aVar.Pe() >= this.bCl.get(i2).Pd()) {
            throw new IllegalArgumentException();
        }
        this.bCl.add(i2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends UriMatcher {
        int bCn;
        int bCo;

        public a(int i) {
            super(i);
        }

        @Override // android.content.UriMatcher
        public void addURI(String str, String str2, int i) {
            dW(i);
            super.addURI(str, str2, i);
        }

        private void dW(int i) {
            if (i < this.bCo || i > this.bCn) {
                throw new IllegalArgumentException("The minCode is : " + this.bCo + "The maxCode is : " + this.bCn + "The error code is : " + i);
            }
        }
    }

    private void Ph() {
        if (!this.mIsInit) {
            synchronized (this.bCm) {
                if (!this.mIsInit) {
                    this.mIsInit = true;
                    this.mAuthority = Pf();
                    if (this.mAuthority == null) {
                        throw new IllegalStateException();
                    }
                    this.bCk = new a(-1);
                    this.bCl = new ArrayList<>();
                    List<com.baidu.pyramid.runtime.multiprocess.components.a> Pg = Pg();
                    if (Pg != null) {
                        for (com.baidu.pyramid.runtime.multiprocess.components.a aVar : Pg) {
                            a(aVar);
                            this.bCk.bCo = aVar.Pd();
                            this.bCk.bCn = aVar.Pe();
                            aVar.a(this.bCk, this.mAuthority);
                        }
                    }
                    Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.bCl.iterator();
                    while (it.hasNext()) {
                        it.next().onCreate();
                    }
                }
            }
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Ph();
        int match = this.bCk.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a dV = dV(match);
        if (dV != null) {
            dV.b(uri, 0);
            return dV.a(match, uri, strArr, str, strArr2, str2);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        Ph();
        int match = this.bCk.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a dV = dV(match);
        if (dV != null) {
            dV.b(uri, 0);
            return dV.a(match, uri, strArr, str, strArr2, str2, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        Ph();
        int match = this.bCk.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a dV = dV(match);
        if (dV != null) {
            dV.b(uri, 4);
            return dV.a(match, uri);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Ph();
        int match = this.bCk.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a dV = dV(match);
        if (dV != null) {
            dV.b(uri, 1);
            return dV.a(match, uri, contentValues);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        Ph();
        int match = this.bCk.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a dV = dV(match);
        if (dV != null) {
            dV.b(uri, 5);
            return dV.a(match, uri, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Ph();
        int match = this.bCk.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a dV = dV(match);
        if (dV != null) {
            dV.b(uri, 2);
            return dV.a(match, uri, contentValues, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        Ph();
        int match = this.bCk.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a dV = dV(match);
        if (dV != null) {
            dV.b(uri, 6);
            return dV.a(match, uri, contentValuesArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        com.baidu.pyramid.runtime.multiprocess.components.a dV;
        Ph();
        if (arrayList == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<ContentProviderOperation> it = arrayList.iterator();
        while (it.hasNext()) {
            ContentProviderOperation next = it.next();
            Uri uri = next.getUri();
            if (uri != null && (dV = dV(this.bCk.match(uri))) != null) {
                dV.b(uri, 0);
                ArrayList arrayList2 = (ArrayList) hashMap.get(dV);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    hashMap.put(dV, arrayList2);
                }
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            ContentProviderResult[] applyBatch = ((com.baidu.pyramid.runtime.multiprocess.components.a) entry.getKey()).applyBatch((ArrayList) entry.getValue());
            for (ContentProviderResult contentProviderResult : applyBatch) {
                arrayList3.add(contentProviderResult);
            }
        }
        if (arrayList3.size() > 0) {
            ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[arrayList3.size()];
            arrayList3.toArray(contentProviderResultArr);
            return contentProviderResultArr;
        }
        return super.applyBatch(arrayList);
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        Ph();
        int match = this.bCk.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a dV = dV(match);
        if (dV != null) {
            return dV.a(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        Ph();
        int match = this.bCk.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a dV = dV(match);
        if (dV != null) {
            dV.b(uri, 7);
            return dV.b(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        Ph();
        int match = this.bCk.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a dV = dV(match);
        if (dV != null) {
            dV.b(uri, 7);
            return dV.a(match, uri, str, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        Ph();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.bCl.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Ph();
        super.onConfigurationChanged(configuration);
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.bCl.iterator();
        while (it.hasNext()) {
            it.next().onConfigurationChanged(configuration);
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        Ph();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.bCl.iterator();
        while (it.hasNext()) {
            com.baidu.pyramid.runtime.multiprocess.components.a next = it.next();
            if (next.b(str, str2, bundle)) {
                next.b(null, 3);
                return next.call(str, str2, bundle);
            }
        }
        return null;
    }
}
