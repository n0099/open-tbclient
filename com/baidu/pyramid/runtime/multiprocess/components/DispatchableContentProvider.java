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
    private a aCS;
    private ArrayList<com.baidu.pyramid.runtime.multiprocess.components.a> aCT;
    private String mAuthority;
    private volatile boolean mIsInit = false;
    private final Object aCU = new Object();

    protected abstract String Am();

    protected abstract List<com.baidu.pyramid.runtime.multiprocess.components.a> An();

    private com.baidu.pyramid.runtime.multiprocess.components.a cF(int i) {
        int i2;
        int i3;
        int i4 = 0;
        int size = this.aCT.size() - 1;
        while (i4 <= size) {
            int i5 = (i4 + size) / 2;
            com.baidu.pyramid.runtime.multiprocess.components.a aVar = this.aCT.get(i5);
            if (i < aVar.Ak() || i > aVar.Al()) {
                if (i < aVar.Ak()) {
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
        if (aVar.Ak() > aVar.Al()) {
            throw new IllegalArgumentException();
        }
        int size = this.aCT.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3 = aVar.Ak() > this.aCT.get(i).Al() ? i + 1 : i2;
            i++;
            i2 = i3;
        }
        if (i2 < size - 1 && aVar.Al() >= this.aCT.get(i2).Ak()) {
            throw new IllegalArgumentException();
        }
        this.aCT.add(i2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends UriMatcher {
        int aCV;
        int aCW;

        public a(int i) {
            super(i);
        }

        @Override // android.content.UriMatcher
        public void addURI(String str, String str2, int i) {
            cG(i);
            super.addURI(str, str2, i);
        }

        private void cG(int i) {
            if (i < this.aCW || i > this.aCV) {
                throw new IllegalArgumentException("The minCode is : " + this.aCW + "The maxCode is : " + this.aCV + "The error code is : " + i);
            }
        }
    }

    private void Ao() {
        if (!this.mIsInit) {
            synchronized (this.aCU) {
                if (!this.mIsInit) {
                    this.mIsInit = true;
                    this.mAuthority = Am();
                    if (this.mAuthority == null) {
                        throw new IllegalStateException();
                    }
                    this.aCS = new a(-1);
                    this.aCT = new ArrayList<>();
                    List<com.baidu.pyramid.runtime.multiprocess.components.a> An = An();
                    if (An != null) {
                        for (com.baidu.pyramid.runtime.multiprocess.components.a aVar : An) {
                            a(aVar);
                            this.aCS.aCW = aVar.Ak();
                            this.aCS.aCV = aVar.Al();
                            aVar.a(this.aCS, this.mAuthority);
                        }
                    }
                    Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.aCT.iterator();
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
        Ao();
        int match = this.aCS.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a cF = cF(match);
        if (cF != null) {
            cF.a(uri, 0);
            return cF.a(match, uri, strArr, str, strArr2, str2);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        Ao();
        int match = this.aCS.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a cF = cF(match);
        if (cF != null) {
            cF.a(uri, 0);
            return cF.a(match, uri, strArr, str, strArr2, str2, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        Ao();
        int match = this.aCS.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a cF = cF(match);
        if (cF != null) {
            cF.a(uri, 4);
            return cF.a(match, uri);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Ao();
        int match = this.aCS.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a cF = cF(match);
        if (cF != null) {
            cF.a(uri, 1);
            return cF.a(match, uri, contentValues);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        Ao();
        int match = this.aCS.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a cF = cF(match);
        if (cF != null) {
            cF.a(uri, 5);
            return cF.a(match, uri, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Ao();
        int match = this.aCS.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a cF = cF(match);
        if (cF != null) {
            cF.a(uri, 2);
            return cF.a(match, uri, contentValues, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        Ao();
        int match = this.aCS.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a cF = cF(match);
        if (cF != null) {
            cF.a(uri, 6);
            return cF.a(match, uri, contentValuesArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        com.baidu.pyramid.runtime.multiprocess.components.a cF;
        Ao();
        if (arrayList == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<ContentProviderOperation> it = arrayList.iterator();
        while (it.hasNext()) {
            ContentProviderOperation next = it.next();
            Uri uri = next.getUri();
            if (uri != null && (cF = cF(this.aCS.match(uri))) != null) {
                cF.a(uri, 0);
                ArrayList arrayList2 = (ArrayList) hashMap.get(cF);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    hashMap.put(cF, arrayList2);
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
        Ao();
        int match = this.aCS.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a cF = cF(match);
        if (cF != null) {
            return cF.a(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        Ao();
        int match = this.aCS.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a cF = cF(match);
        if (cF != null) {
            cF.a(uri, 7);
            return cF.b(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        Ao();
        int match = this.aCS.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a cF = cF(match);
        if (cF != null) {
            cF.a(uri, 7);
            return cF.a(match, uri, str, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        Ao();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.aCT.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Ao();
        super.onConfigurationChanged(configuration);
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.aCT.iterator();
        while (it.hasNext()) {
            it.next().onConfigurationChanged(configuration);
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        Ao();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.aCT.iterator();
        while (it.hasNext()) {
            com.baidu.pyramid.runtime.multiprocess.components.a next = it.next();
            if (next.b(str, str2, bundle)) {
                next.a((Uri) null, 3);
                return next.call(str, str2, bundle);
            }
        }
        return null;
    }
}
