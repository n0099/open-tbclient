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
    private a ajw;
    private ArrayList<com.baidu.pyramid.runtime.multiprocess.components.a> ajx;
    private volatile boolean ajy = false;
    private final Object ajz = new Object();
    private String mAuthority;

    protected abstract String vs();

    protected abstract List<com.baidu.pyramid.runtime.multiprocess.components.a> vt();

    private com.baidu.pyramid.runtime.multiprocess.components.a bJ(int i) {
        int i2;
        int i3;
        int i4 = 0;
        int size = this.ajx.size() - 1;
        while (i4 <= size) {
            int i5 = (i4 + size) / 2;
            com.baidu.pyramid.runtime.multiprocess.components.a aVar = this.ajx.get(i5);
            if (i < aVar.vq() || i > aVar.vr()) {
                if (i < aVar.vq()) {
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
        if (aVar.vq() > aVar.vr()) {
            throw new IllegalArgumentException();
        }
        int size = this.ajx.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3 = aVar.vq() > this.ajx.get(i).vr() ? i + 1 : i2;
            i++;
            i2 = i3;
        }
        if (i2 < size - 1 && aVar.vr() >= this.ajx.get(i2).vq()) {
            throw new IllegalArgumentException();
        }
        this.ajx.add(i2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends UriMatcher {
        int ajA;
        int ajB;

        public a(int i) {
            super(i);
        }

        @Override // android.content.UriMatcher
        public void addURI(String str, String str2, int i) {
            bK(i);
            super.addURI(str, str2, i);
        }

        private void bK(int i) {
            if (i < this.ajB || i > this.ajA) {
                throw new IllegalArgumentException("The minCode is : " + this.ajB + "The maxCode is : " + this.ajA + "The error code is : " + i);
            }
        }
    }

    private void vu() {
        if (!this.ajy) {
            synchronized (this.ajz) {
                if (!this.ajy) {
                    this.ajy = true;
                    this.mAuthority = vs();
                    if (this.mAuthority == null) {
                        throw new IllegalStateException();
                    }
                    this.ajw = new a(-1);
                    this.ajx = new ArrayList<>();
                    List<com.baidu.pyramid.runtime.multiprocess.components.a> vt = vt();
                    if (vt != null) {
                        for (com.baidu.pyramid.runtime.multiprocess.components.a aVar : vt) {
                            a(aVar);
                            this.ajw.ajB = aVar.vq();
                            this.ajw.ajA = aVar.vr();
                            aVar.a(this.ajw, this.mAuthority);
                        }
                    }
                    Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.ajx.iterator();
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
        vu();
        int match = this.ajw.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bJ = bJ(match);
        if (bJ != null) {
            bJ.a(uri, 0);
            return bJ.a(match, uri, strArr, str, strArr2, str2);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        vu();
        int match = this.ajw.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bJ = bJ(match);
        if (bJ != null) {
            bJ.a(uri, 0);
            return bJ.a(match, uri, strArr, str, strArr2, str2, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        vu();
        int match = this.ajw.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bJ = bJ(match);
        if (bJ != null) {
            bJ.a(uri, 4);
            return bJ.a(match, uri);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        vu();
        int match = this.ajw.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bJ = bJ(match);
        if (bJ != null) {
            bJ.a(uri, 1);
            return bJ.a(match, uri, contentValues);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        vu();
        int match = this.ajw.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bJ = bJ(match);
        if (bJ != null) {
            bJ.a(uri, 5);
            return bJ.a(match, uri, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        vu();
        int match = this.ajw.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bJ = bJ(match);
        if (bJ != null) {
            bJ.a(uri, 2);
            return bJ.a(match, uri, contentValues, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        vu();
        int match = this.ajw.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bJ = bJ(match);
        if (bJ != null) {
            bJ.a(uri, 6);
            return bJ.a(match, uri, contentValuesArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        com.baidu.pyramid.runtime.multiprocess.components.a bJ;
        vu();
        if (arrayList == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<ContentProviderOperation> it = arrayList.iterator();
        while (it.hasNext()) {
            ContentProviderOperation next = it.next();
            Uri uri = next.getUri();
            if (uri != null && (bJ = bJ(this.ajw.match(uri))) != null) {
                bJ.a(uri, 0);
                ArrayList arrayList2 = (ArrayList) hashMap.get(bJ);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    hashMap.put(bJ, arrayList2);
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
        vu();
        int match = this.ajw.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bJ = bJ(match);
        if (bJ != null) {
            return bJ.a(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        vu();
        int match = this.ajw.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bJ = bJ(match);
        if (bJ != null) {
            bJ.a(uri, 7);
            return bJ.b(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        vu();
        int match = this.ajw.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bJ = bJ(match);
        if (bJ != null) {
            bJ.a(uri, 7);
            return bJ.a(match, uri, str, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        vu();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.ajx.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        vu();
        super.onConfigurationChanged(configuration);
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.ajx.iterator();
        while (it.hasNext()) {
            it.next().onConfigurationChanged(configuration);
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        vu();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.ajx.iterator();
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
