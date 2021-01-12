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
/* loaded from: classes6.dex */
public abstract class DispatchableContentProvider extends ContentProvider {
    private a crg;
    private ArrayList<com.baidu.pyramid.runtime.multiprocess.components.a> crh;
    private String mAuthority;
    private volatile boolean mIsInit = false;
    private final Object cri = new Object();

    protected abstract String adY();

    protected abstract List<com.baidu.pyramid.runtime.multiprocess.components.a> adZ();

    private com.baidu.pyramid.runtime.multiprocess.components.a fN(int i) {
        int i2;
        int i3 = 0;
        int size = this.crh.size() - 1;
        while (i3 <= size) {
            int i4 = (i3 + size) / 2;
            com.baidu.pyramid.runtime.multiprocess.components.a aVar = this.crh.get(i4);
            if (i < aVar.adW() || i > aVar.adX()) {
                if (i < aVar.adW()) {
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
        if (aVar.adW() > aVar.adX()) {
            throw new IllegalArgumentException();
        }
        int size = this.crh.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3 = aVar.adW() > this.crh.get(i).adX() ? i + 1 : i2;
            i++;
            i2 = i3;
        }
        if (i2 < size - 1 && aVar.adX() >= this.crh.get(i2).adW()) {
            throw new IllegalArgumentException();
        }
        this.crh.add(i2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a extends UriMatcher {
        int crj;
        int crk;

        public a(int i) {
            super(i);
        }

        @Override // android.content.UriMatcher
        public void addURI(String str, String str2, int i) {
            fO(i);
            super.addURI(str, str2, i);
        }

        private void fO(int i) {
            if (i < this.crk || i > this.crj) {
                throw new IllegalArgumentException("The minCode is : " + this.crk + "The maxCode is : " + this.crj + "The error code is : " + i);
            }
        }
    }

    private void aea() {
        if (!this.mIsInit) {
            synchronized (this.cri) {
                if (!this.mIsInit) {
                    this.mIsInit = true;
                    this.mAuthority = adY();
                    if (this.mAuthority == null) {
                        throw new IllegalStateException();
                    }
                    this.crg = new a(-1);
                    this.crh = new ArrayList<>();
                    List<com.baidu.pyramid.runtime.multiprocess.components.a> adZ = adZ();
                    if (adZ != null) {
                        for (com.baidu.pyramid.runtime.multiprocess.components.a aVar : adZ) {
                            a(aVar);
                            this.crg.crk = aVar.adW();
                            this.crg.crj = aVar.adX();
                            aVar.a(this.crg, this.mAuthority);
                        }
                    }
                    Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.crh.iterator();
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
        aea();
        int match = this.crg.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a fN = fN(match);
        if (fN != null) {
            fN.b(uri, 0);
            return fN.a(match, uri, strArr, str, strArr2, str2);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        aea();
        int match = this.crg.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a fN = fN(match);
        if (fN != null) {
            fN.b(uri, 0);
            return fN.a(match, uri, strArr, str, strArr2, str2, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        aea();
        int match = this.crg.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a fN = fN(match);
        if (fN != null) {
            fN.b(uri, 4);
            return fN.a(match, uri);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        aea();
        int match = this.crg.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a fN = fN(match);
        if (fN != null) {
            fN.b(uri, 1);
            return fN.a(match, uri, contentValues);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        aea();
        int match = this.crg.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a fN = fN(match);
        if (fN != null) {
            fN.b(uri, 5);
            return fN.a(match, uri, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        aea();
        int match = this.crg.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a fN = fN(match);
        if (fN != null) {
            fN.b(uri, 2);
            return fN.a(match, uri, contentValues, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        aea();
        int match = this.crg.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a fN = fN(match);
        if (fN != null) {
            fN.b(uri, 6);
            return fN.a(match, uri, contentValuesArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        com.baidu.pyramid.runtime.multiprocess.components.a fN;
        aea();
        if (arrayList == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<ContentProviderOperation> it = arrayList.iterator();
        while (it.hasNext()) {
            ContentProviderOperation next = it.next();
            Uri uri = next.getUri();
            if (uri != null && (fN = fN(this.crg.match(uri))) != null) {
                fN.b(uri, 0);
                ArrayList arrayList2 = (ArrayList) hashMap.get(fN);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    hashMap.put(fN, arrayList2);
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
        aea();
        int match = this.crg.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a fN = fN(match);
        if (fN != null) {
            return fN.a(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        aea();
        int match = this.crg.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a fN = fN(match);
        if (fN != null) {
            fN.b(uri, 7);
            return fN.b(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        aea();
        int match = this.crg.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a fN = fN(match);
        if (fN != null) {
            fN.b(uri, 7);
            return fN.a(match, uri, str, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        aea();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.crh.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        aea();
        super.onConfigurationChanged(configuration);
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.crh.iterator();
        while (it.hasNext()) {
            it.next().onConfigurationChanged(configuration);
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        aea();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.crh.iterator();
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
