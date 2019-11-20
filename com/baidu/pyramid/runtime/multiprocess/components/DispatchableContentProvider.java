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
    private a aCA;
    private ArrayList<com.baidu.pyramid.runtime.multiprocess.components.a> aCB;
    private String mAuthority;
    private volatile boolean mIsInit = false;
    private final Object aCC = new Object();

    protected abstract String An();

    protected abstract List<com.baidu.pyramid.runtime.multiprocess.components.a> Ao();

    private com.baidu.pyramid.runtime.multiprocess.components.a cF(int i) {
        int i2;
        int i3;
        int i4 = 0;
        int size = this.aCB.size() - 1;
        while (i4 <= size) {
            int i5 = (i4 + size) / 2;
            com.baidu.pyramid.runtime.multiprocess.components.a aVar = this.aCB.get(i5);
            if (i < aVar.Al() || i > aVar.Am()) {
                if (i < aVar.Al()) {
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
        if (aVar.Al() > aVar.Am()) {
            throw new IllegalArgumentException();
        }
        int size = this.aCB.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3 = aVar.Al() > this.aCB.get(i).Am() ? i + 1 : i2;
            i++;
            i2 = i3;
        }
        if (i2 < size - 1 && aVar.Am() >= this.aCB.get(i2).Al()) {
            throw new IllegalArgumentException();
        }
        this.aCB.add(i2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends UriMatcher {
        int aCD;
        int aCE;

        public a(int i) {
            super(i);
        }

        @Override // android.content.UriMatcher
        public void addURI(String str, String str2, int i) {
            cG(i);
            super.addURI(str, str2, i);
        }

        private void cG(int i) {
            if (i < this.aCE || i > this.aCD) {
                throw new IllegalArgumentException("The minCode is : " + this.aCE + "The maxCode is : " + this.aCD + "The error code is : " + i);
            }
        }
    }

    private void Ap() {
        if (!this.mIsInit) {
            synchronized (this.aCC) {
                if (!this.mIsInit) {
                    this.mIsInit = true;
                    this.mAuthority = An();
                    if (this.mAuthority == null) {
                        throw new IllegalStateException();
                    }
                    this.aCA = new a(-1);
                    this.aCB = new ArrayList<>();
                    List<com.baidu.pyramid.runtime.multiprocess.components.a> Ao = Ao();
                    if (Ao != null) {
                        for (com.baidu.pyramid.runtime.multiprocess.components.a aVar : Ao) {
                            a(aVar);
                            this.aCA.aCE = aVar.Al();
                            this.aCA.aCD = aVar.Am();
                            aVar.a(this.aCA, this.mAuthority);
                        }
                    }
                    Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.aCB.iterator();
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
        Ap();
        int match = this.aCA.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a cF = cF(match);
        if (cF != null) {
            cF.a(uri, 0);
            return cF.a(match, uri, strArr, str, strArr2, str2);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        Ap();
        int match = this.aCA.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a cF = cF(match);
        if (cF != null) {
            cF.a(uri, 0);
            return cF.a(match, uri, strArr, str, strArr2, str2, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        Ap();
        int match = this.aCA.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a cF = cF(match);
        if (cF != null) {
            cF.a(uri, 4);
            return cF.a(match, uri);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Ap();
        int match = this.aCA.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a cF = cF(match);
        if (cF != null) {
            cF.a(uri, 1);
            return cF.a(match, uri, contentValues);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        Ap();
        int match = this.aCA.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a cF = cF(match);
        if (cF != null) {
            cF.a(uri, 5);
            return cF.a(match, uri, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Ap();
        int match = this.aCA.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a cF = cF(match);
        if (cF != null) {
            cF.a(uri, 2);
            return cF.a(match, uri, contentValues, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        Ap();
        int match = this.aCA.match(uri);
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
        Ap();
        if (arrayList == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<ContentProviderOperation> it = arrayList.iterator();
        while (it.hasNext()) {
            ContentProviderOperation next = it.next();
            Uri uri = next.getUri();
            if (uri != null && (cF = cF(this.aCA.match(uri))) != null) {
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
        Ap();
        int match = this.aCA.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a cF = cF(match);
        if (cF != null) {
            return cF.a(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        Ap();
        int match = this.aCA.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a cF = cF(match);
        if (cF != null) {
            cF.a(uri, 7);
            return cF.b(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        Ap();
        int match = this.aCA.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a cF = cF(match);
        if (cF != null) {
            cF.a(uri, 7);
            return cF.a(match, uri, str, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        Ap();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.aCB.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Ap();
        super.onConfigurationChanged(configuration);
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.aCB.iterator();
        while (it.hasNext()) {
            it.next().onConfigurationChanged(configuration);
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        Ap();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.aCB.iterator();
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
