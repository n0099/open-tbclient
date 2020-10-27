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
/* loaded from: classes16.dex */
public abstract class DispatchableContentProvider extends ContentProvider {
    private a cej;
    private ArrayList<com.baidu.pyramid.runtime.multiprocess.components.a> cek;
    private String mAuthority;
    private volatile boolean mIsInit = false;
    private final Object cel = new Object();

    protected abstract String aaV();

    protected abstract List<com.baidu.pyramid.runtime.multiprocess.components.a> aaW();

    private com.baidu.pyramid.runtime.multiprocess.components.a gR(int i) {
        int i2;
        int i3;
        int i4 = 0;
        int size = this.cek.size() - 1;
        while (i4 <= size) {
            int i5 = (i4 + size) / 2;
            com.baidu.pyramid.runtime.multiprocess.components.a aVar = this.cek.get(i5);
            if (i < aVar.aaT() || i > aVar.aaU()) {
                if (i < aVar.aaT()) {
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
        if (aVar.aaT() > aVar.aaU()) {
            throw new IllegalArgumentException();
        }
        int size = this.cek.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3 = aVar.aaT() > this.cek.get(i).aaU() ? i + 1 : i2;
            i++;
            i2 = i3;
        }
        if (i2 < size - 1 && aVar.aaU() >= this.cek.get(i2).aaT()) {
            throw new IllegalArgumentException();
        }
        this.cek.add(i2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class a extends UriMatcher {
        int cem;
        int cen;

        public a(int i) {
            super(i);
        }

        @Override // android.content.UriMatcher
        public void addURI(String str, String str2, int i) {
            gS(i);
            super.addURI(str, str2, i);
        }

        private void gS(int i) {
            if (i < this.cen || i > this.cem) {
                throw new IllegalArgumentException("The minCode is : " + this.cen + "The maxCode is : " + this.cem + "The error code is : " + i);
            }
        }
    }

    private void aaX() {
        if (!this.mIsInit) {
            synchronized (this.cel) {
                if (!this.mIsInit) {
                    this.mIsInit = true;
                    this.mAuthority = aaV();
                    if (this.mAuthority == null) {
                        throw new IllegalStateException();
                    }
                    this.cej = new a(-1);
                    this.cek = new ArrayList<>();
                    List<com.baidu.pyramid.runtime.multiprocess.components.a> aaW = aaW();
                    if (aaW != null) {
                        for (com.baidu.pyramid.runtime.multiprocess.components.a aVar : aaW) {
                            a(aVar);
                            this.cej.cen = aVar.aaT();
                            this.cej.cem = aVar.aaU();
                            aVar.a(this.cej, this.mAuthority);
                        }
                    }
                    Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.cek.iterator();
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
        aaX();
        int match = this.cej.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a gR = gR(match);
        if (gR != null) {
            gR.b(uri, 0);
            return gR.a(match, uri, strArr, str, strArr2, str2);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        aaX();
        int match = this.cej.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a gR = gR(match);
        if (gR != null) {
            gR.b(uri, 0);
            return gR.a(match, uri, strArr, str, strArr2, str2, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        aaX();
        int match = this.cej.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a gR = gR(match);
        if (gR != null) {
            gR.b(uri, 4);
            return gR.a(match, uri);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        aaX();
        int match = this.cej.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a gR = gR(match);
        if (gR != null) {
            gR.b(uri, 1);
            return gR.a(match, uri, contentValues);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        aaX();
        int match = this.cej.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a gR = gR(match);
        if (gR != null) {
            gR.b(uri, 5);
            return gR.a(match, uri, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        aaX();
        int match = this.cej.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a gR = gR(match);
        if (gR != null) {
            gR.b(uri, 2);
            return gR.a(match, uri, contentValues, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        aaX();
        int match = this.cej.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a gR = gR(match);
        if (gR != null) {
            gR.b(uri, 6);
            return gR.a(match, uri, contentValuesArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        com.baidu.pyramid.runtime.multiprocess.components.a gR;
        aaX();
        if (arrayList == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<ContentProviderOperation> it = arrayList.iterator();
        while (it.hasNext()) {
            ContentProviderOperation next = it.next();
            Uri uri = next.getUri();
            if (uri != null && (gR = gR(this.cej.match(uri))) != null) {
                gR.b(uri, 0);
                ArrayList arrayList2 = (ArrayList) hashMap.get(gR);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    hashMap.put(gR, arrayList2);
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
        aaX();
        int match = this.cej.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a gR = gR(match);
        if (gR != null) {
            return gR.a(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        aaX();
        int match = this.cej.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a gR = gR(match);
        if (gR != null) {
            gR.b(uri, 7);
            return gR.b(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        aaX();
        int match = this.cej.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a gR = gR(match);
        if (gR != null) {
            gR.b(uri, 7);
            return gR.a(match, uri, str, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        aaX();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.cek.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        aaX();
        super.onConfigurationChanged(configuration);
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.cek.iterator();
        while (it.hasNext()) {
            it.next().onConfigurationChanged(configuration);
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        aaX();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.cek.iterator();
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
