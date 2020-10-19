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
    private a bVK;
    private ArrayList<com.baidu.pyramid.runtime.multiprocess.components.a> bVL;
    private String mAuthority;
    private volatile boolean mIsInit = false;
    private final Object bVM = new Object();

    protected abstract String Zc();

    protected abstract List<com.baidu.pyramid.runtime.multiprocess.components.a> Zd();

    private com.baidu.pyramid.runtime.multiprocess.components.a gG(int i) {
        int i2;
        int i3;
        int i4 = 0;
        int size = this.bVL.size() - 1;
        while (i4 <= size) {
            int i5 = (i4 + size) / 2;
            com.baidu.pyramid.runtime.multiprocess.components.a aVar = this.bVL.get(i5);
            if (i < aVar.Za() || i > aVar.Zb()) {
                if (i < aVar.Za()) {
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
        if (aVar.Za() > aVar.Zb()) {
            throw new IllegalArgumentException();
        }
        int size = this.bVL.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3 = aVar.Za() > this.bVL.get(i).Zb() ? i + 1 : i2;
            i++;
            i2 = i3;
        }
        if (i2 < size - 1 && aVar.Zb() >= this.bVL.get(i2).Za()) {
            throw new IllegalArgumentException();
        }
        this.bVL.add(i2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class a extends UriMatcher {
        int bVN;
        int bVO;

        public a(int i) {
            super(i);
        }

        @Override // android.content.UriMatcher
        public void addURI(String str, String str2, int i) {
            gH(i);
            super.addURI(str, str2, i);
        }

        private void gH(int i) {
            if (i < this.bVO || i > this.bVN) {
                throw new IllegalArgumentException("The minCode is : " + this.bVO + "The maxCode is : " + this.bVN + "The error code is : " + i);
            }
        }
    }

    private void Ze() {
        if (!this.mIsInit) {
            synchronized (this.bVM) {
                if (!this.mIsInit) {
                    this.mIsInit = true;
                    this.mAuthority = Zc();
                    if (this.mAuthority == null) {
                        throw new IllegalStateException();
                    }
                    this.bVK = new a(-1);
                    this.bVL = new ArrayList<>();
                    List<com.baidu.pyramid.runtime.multiprocess.components.a> Zd = Zd();
                    if (Zd != null) {
                        for (com.baidu.pyramid.runtime.multiprocess.components.a aVar : Zd) {
                            a(aVar);
                            this.bVK.bVO = aVar.Za();
                            this.bVK.bVN = aVar.Zb();
                            aVar.a(this.bVK, this.mAuthority);
                        }
                    }
                    Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.bVL.iterator();
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
        Ze();
        int match = this.bVK.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a gG = gG(match);
        if (gG != null) {
            gG.b(uri, 0);
            return gG.a(match, uri, strArr, str, strArr2, str2);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        Ze();
        int match = this.bVK.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a gG = gG(match);
        if (gG != null) {
            gG.b(uri, 0);
            return gG.a(match, uri, strArr, str, strArr2, str2, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        Ze();
        int match = this.bVK.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a gG = gG(match);
        if (gG != null) {
            gG.b(uri, 4);
            return gG.a(match, uri);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Ze();
        int match = this.bVK.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a gG = gG(match);
        if (gG != null) {
            gG.b(uri, 1);
            return gG.a(match, uri, contentValues);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        Ze();
        int match = this.bVK.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a gG = gG(match);
        if (gG != null) {
            gG.b(uri, 5);
            return gG.a(match, uri, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Ze();
        int match = this.bVK.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a gG = gG(match);
        if (gG != null) {
            gG.b(uri, 2);
            return gG.a(match, uri, contentValues, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        Ze();
        int match = this.bVK.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a gG = gG(match);
        if (gG != null) {
            gG.b(uri, 6);
            return gG.a(match, uri, contentValuesArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        com.baidu.pyramid.runtime.multiprocess.components.a gG;
        Ze();
        if (arrayList == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<ContentProviderOperation> it = arrayList.iterator();
        while (it.hasNext()) {
            ContentProviderOperation next = it.next();
            Uri uri = next.getUri();
            if (uri != null && (gG = gG(this.bVK.match(uri))) != null) {
                gG.b(uri, 0);
                ArrayList arrayList2 = (ArrayList) hashMap.get(gG);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    hashMap.put(gG, arrayList2);
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
        Ze();
        int match = this.bVK.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a gG = gG(match);
        if (gG != null) {
            return gG.a(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        Ze();
        int match = this.bVK.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a gG = gG(match);
        if (gG != null) {
            gG.b(uri, 7);
            return gG.b(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        Ze();
        int match = this.bVK.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a gG = gG(match);
        if (gG != null) {
            gG.b(uri, 7);
            return gG.a(match, uri, str, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        Ze();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.bVL.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Ze();
        super.onConfigurationChanged(configuration);
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.bVL.iterator();
        while (it.hasNext()) {
            it.next().onConfigurationChanged(configuration);
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        Ze();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.bVL.iterator();
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
