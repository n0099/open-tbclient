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
/* loaded from: classes14.dex */
public abstract class DispatchableContentProvider extends ContentProvider {
    private ArrayList<com.baidu.pyramid.runtime.multiprocess.components.a> cuA;
    private a cuz;
    private String mAuthority;
    private volatile boolean mIsInit = false;
    private final Object cuB = new Object();

    protected abstract String aes();

    protected abstract List<com.baidu.pyramid.runtime.multiprocess.components.a> aet();

    private com.baidu.pyramid.runtime.multiprocess.components.a fR(int i) {
        int i2;
        int i3 = 0;
        int size = this.cuA.size() - 1;
        while (i3 <= size) {
            int i4 = (i3 + size) / 2;
            com.baidu.pyramid.runtime.multiprocess.components.a aVar = this.cuA.get(i4);
            if (i < aVar.aeq() || i > aVar.aer()) {
                if (i < aVar.aeq()) {
                    i2 = i4 - 1;
                } else {
                    i3 = i4 + 1;
                    i2 = size;
                }
                size = i2;
            } else {
                return aVar;
            }
        }
        return null;
    }

    private void a(com.baidu.pyramid.runtime.multiprocess.components.a aVar) {
        if (aVar.aeq() > aVar.aer()) {
            throw new IllegalArgumentException();
        }
        int size = this.cuA.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3 = aVar.aeq() > this.cuA.get(i).aer() ? i + 1 : i2;
            i++;
            i2 = i3;
        }
        if (i2 < size - 1 && aVar.aer() >= this.cuA.get(i2).aeq()) {
            throw new IllegalArgumentException();
        }
        this.cuA.add(i2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static class a extends UriMatcher {
        int cuC;
        int cuD;

        public a(int i) {
            super(i);
        }

        @Override // android.content.UriMatcher
        public void addURI(String str, String str2, int i) {
            fS(i);
            super.addURI(str, str2, i);
        }

        private void fS(int i) {
            if (i < this.cuD || i > this.cuC) {
                throw new IllegalArgumentException("The minCode is : " + this.cuD + "The maxCode is : " + this.cuC + "The error code is : " + i);
            }
        }
    }

    private void aeu() {
        if (!this.mIsInit) {
            synchronized (this.cuB) {
                if (!this.mIsInit) {
                    this.mIsInit = true;
                    this.mAuthority = aes();
                    if (this.mAuthority == null) {
                        throw new IllegalStateException();
                    }
                    this.cuz = new a(-1);
                    this.cuA = new ArrayList<>();
                    List<com.baidu.pyramid.runtime.multiprocess.components.a> aet = aet();
                    if (aet != null) {
                        for (com.baidu.pyramid.runtime.multiprocess.components.a aVar : aet) {
                            a(aVar);
                            this.cuz.cuD = aVar.aeq();
                            this.cuz.cuC = aVar.aer();
                            aVar.a(this.cuz, this.mAuthority);
                        }
                    }
                    Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.cuA.iterator();
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
        aeu();
        int match = this.cuz.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a fR = fR(match);
        if (fR != null) {
            fR.b(uri, 0);
            return fR.a(match, uri, strArr, str, strArr2, str2);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        aeu();
        int match = this.cuz.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a fR = fR(match);
        if (fR != null) {
            fR.b(uri, 0);
            return fR.a(match, uri, strArr, str, strArr2, str2, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        aeu();
        int match = this.cuz.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a fR = fR(match);
        if (fR != null) {
            fR.b(uri, 4);
            return fR.a(match, uri);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        aeu();
        int match = this.cuz.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a fR = fR(match);
        if (fR != null) {
            fR.b(uri, 1);
            return fR.a(match, uri, contentValues);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        aeu();
        int match = this.cuz.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a fR = fR(match);
        if (fR != null) {
            fR.b(uri, 5);
            return fR.a(match, uri, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        aeu();
        int match = this.cuz.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a fR = fR(match);
        if (fR != null) {
            fR.b(uri, 2);
            return fR.a(match, uri, contentValues, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        aeu();
        int match = this.cuz.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a fR = fR(match);
        if (fR != null) {
            fR.b(uri, 6);
            return fR.a(match, uri, contentValuesArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        com.baidu.pyramid.runtime.multiprocess.components.a fR;
        aeu();
        if (arrayList == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<ContentProviderOperation> it = arrayList.iterator();
        while (it.hasNext()) {
            ContentProviderOperation next = it.next();
            Uri uri = next.getUri();
            if (uri != null && (fR = fR(this.cuz.match(uri))) != null) {
                fR.b(uri, 0);
                ArrayList arrayList2 = (ArrayList) hashMap.get(fR);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    hashMap.put(fR, arrayList2);
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
        aeu();
        int match = this.cuz.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a fR = fR(match);
        if (fR != null) {
            return fR.a(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        aeu();
        int match = this.cuz.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a fR = fR(match);
        if (fR != null) {
            fR.b(uri, 7);
            return fR.b(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        aeu();
        int match = this.cuz.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a fR = fR(match);
        if (fR != null) {
            fR.b(uri, 7);
            return fR.a(match, uri, str, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        aeu();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.cuA.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        aeu();
        super.onConfigurationChanged(configuration);
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.cuA.iterator();
        while (it.hasNext()) {
            it.next().onConfigurationChanged(configuration);
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        aeu();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.cuA.iterator();
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
