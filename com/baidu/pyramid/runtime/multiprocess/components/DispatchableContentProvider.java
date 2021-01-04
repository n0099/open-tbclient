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
    private a cvX;
    private ArrayList<com.baidu.pyramid.runtime.multiprocess.components.a> cvY;
    private String mAuthority;
    private volatile boolean mIsInit = false;
    private final Object cvZ = new Object();

    protected abstract String ahR();

    protected abstract List<com.baidu.pyramid.runtime.multiprocess.components.a> ahS();

    private com.baidu.pyramid.runtime.multiprocess.components.a hu(int i) {
        int i2;
        int i3 = 0;
        int size = this.cvY.size() - 1;
        while (i3 <= size) {
            int i4 = (i3 + size) / 2;
            com.baidu.pyramid.runtime.multiprocess.components.a aVar = this.cvY.get(i4);
            if (i < aVar.ahP() || i > aVar.ahQ()) {
                if (i < aVar.ahP()) {
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
        if (aVar.ahP() > aVar.ahQ()) {
            throw new IllegalArgumentException();
        }
        int size = this.cvY.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3 = aVar.ahP() > this.cvY.get(i).ahQ() ? i + 1 : i2;
            i++;
            i2 = i3;
        }
        if (i2 < size - 1 && aVar.ahQ() >= this.cvY.get(i2).ahP()) {
            throw new IllegalArgumentException();
        }
        this.cvY.add(i2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a extends UriMatcher {
        int cwa;
        int cwb;

        public a(int i) {
            super(i);
        }

        @Override // android.content.UriMatcher
        public void addURI(String str, String str2, int i) {
            hv(i);
            super.addURI(str, str2, i);
        }

        private void hv(int i) {
            if (i < this.cwb || i > this.cwa) {
                throw new IllegalArgumentException("The minCode is : " + this.cwb + "The maxCode is : " + this.cwa + "The error code is : " + i);
            }
        }
    }

    private void ahT() {
        if (!this.mIsInit) {
            synchronized (this.cvZ) {
                if (!this.mIsInit) {
                    this.mIsInit = true;
                    this.mAuthority = ahR();
                    if (this.mAuthority == null) {
                        throw new IllegalStateException();
                    }
                    this.cvX = new a(-1);
                    this.cvY = new ArrayList<>();
                    List<com.baidu.pyramid.runtime.multiprocess.components.a> ahS = ahS();
                    if (ahS != null) {
                        for (com.baidu.pyramid.runtime.multiprocess.components.a aVar : ahS) {
                            a(aVar);
                            this.cvX.cwb = aVar.ahP();
                            this.cvX.cwa = aVar.ahQ();
                            aVar.a(this.cvX, this.mAuthority);
                        }
                    }
                    Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.cvY.iterator();
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
        ahT();
        int match = this.cvX.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a hu = hu(match);
        if (hu != null) {
            hu.b(uri, 0);
            return hu.a(match, uri, strArr, str, strArr2, str2);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        ahT();
        int match = this.cvX.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a hu = hu(match);
        if (hu != null) {
            hu.b(uri, 0);
            return hu.a(match, uri, strArr, str, strArr2, str2, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        ahT();
        int match = this.cvX.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a hu = hu(match);
        if (hu != null) {
            hu.b(uri, 4);
            return hu.a(match, uri);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        ahT();
        int match = this.cvX.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a hu = hu(match);
        if (hu != null) {
            hu.b(uri, 1);
            return hu.a(match, uri, contentValues);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        ahT();
        int match = this.cvX.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a hu = hu(match);
        if (hu != null) {
            hu.b(uri, 5);
            return hu.a(match, uri, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        ahT();
        int match = this.cvX.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a hu = hu(match);
        if (hu != null) {
            hu.b(uri, 2);
            return hu.a(match, uri, contentValues, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        ahT();
        int match = this.cvX.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a hu = hu(match);
        if (hu != null) {
            hu.b(uri, 6);
            return hu.a(match, uri, contentValuesArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        com.baidu.pyramid.runtime.multiprocess.components.a hu;
        ahT();
        if (arrayList == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<ContentProviderOperation> it = arrayList.iterator();
        while (it.hasNext()) {
            ContentProviderOperation next = it.next();
            Uri uri = next.getUri();
            if (uri != null && (hu = hu(this.cvX.match(uri))) != null) {
                hu.b(uri, 0);
                ArrayList arrayList2 = (ArrayList) hashMap.get(hu);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    hashMap.put(hu, arrayList2);
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
        ahT();
        int match = this.cvX.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a hu = hu(match);
        if (hu != null) {
            return hu.a(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        ahT();
        int match = this.cvX.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a hu = hu(match);
        if (hu != null) {
            hu.b(uri, 7);
            return hu.b(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        ahT();
        int match = this.cvX.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a hu = hu(match);
        if (hu != null) {
            hu.b(uri, 7);
            return hu.a(match, uri, str, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        ahT();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.cvY.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        ahT();
        super.onConfigurationChanged(configuration);
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.cvY.iterator();
        while (it.hasNext()) {
            it.next().onConfigurationChanged(configuration);
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        ahT();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.cvY.iterator();
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
