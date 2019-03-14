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
import android.util.Log;
import com.baidu.pyramid.runtime.multiprocess.h;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class DispatchableContentProvider extends ContentProvider {
    private static final boolean DEBUG = h.DEBUG;
    private a aia;
    private ArrayList<com.baidu.pyramid.runtime.multiprocess.components.a> aib;
    private volatile boolean aic = false;
    private final Object aid = new Object();
    private String mAuthority;

    protected abstract String getAuthority();

    protected abstract List<com.baidu.pyramid.runtime.multiprocess.components.a> ue();

    private com.baidu.pyramid.runtime.multiprocess.components.a bJ(int i) {
        int i2;
        int i3;
        int i4 = 0;
        int size = this.aib.size() - 1;
        while (i4 <= size) {
            int i5 = (i4 + size) / 2;
            com.baidu.pyramid.runtime.multiprocess.components.a aVar = this.aib.get(i5);
            if (i < aVar.uc() || i > aVar.ud()) {
                if (i < aVar.uc()) {
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
        if (aVar.uc() > aVar.ud()) {
            throw new IllegalArgumentException();
        }
        int size = this.aib.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3 = aVar.uc() > this.aib.get(i).ud() ? i + 1 : i2;
            i++;
            i2 = i3;
        }
        if (i2 < size - 1 && aVar.ud() >= this.aib.get(i2).uc()) {
            throw new IllegalArgumentException();
        }
        this.aib.add(i2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends UriMatcher {
        int aie;
        int aif;

        public a(int i) {
            super(i);
        }

        @Override // android.content.UriMatcher
        public void addURI(String str, String str2, int i) {
            bK(i);
            super.addURI(str, str2, i);
        }

        private void bK(int i) {
            if (i < this.aif || i > this.aie) {
                throw new IllegalArgumentException("The minCode is : " + this.aif + "The maxCode is : " + this.aie + "The error code is : " + i);
            }
        }
    }

    private void uf() {
        if (!this.aic) {
            synchronized (this.aid) {
                if (!this.aic) {
                    this.aic = true;
                    this.mAuthority = getAuthority();
                    if (this.mAuthority == null) {
                        throw new IllegalStateException();
                    }
                    this.aia = new a(-1);
                    this.aib = new ArrayList<>();
                    List<com.baidu.pyramid.runtime.multiprocess.components.a> ue = ue();
                    if (ue != null) {
                        for (com.baidu.pyramid.runtime.multiprocess.components.a aVar : ue) {
                            a(aVar);
                            this.aia.aif = aVar.uc();
                            this.aia.aie = aVar.ud();
                            aVar.a(this.aia, this.mAuthority);
                        }
                    }
                    Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.aib.iterator();
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
        uf();
        int match = this.aia.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bJ = bJ(match);
        if (DEBUG) {
            Log.d("DispProvider", "[query] uri = " + uri + " code = " + match + " delegate = " + bJ);
        }
        if (bJ != null) {
            bJ.a(uri, 0);
            return bJ.a(match, uri, strArr, str, strArr2, str2);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        uf();
        int match = this.aia.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bJ = bJ(match);
        if (DEBUG) {
            Log.d("DispProvider", "[query] uri = " + uri + " code = " + match + " delegate = " + bJ);
        }
        if (bJ != null) {
            bJ.a(uri, 0);
            return bJ.a(match, uri, strArr, str, strArr2, str2, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        uf();
        int match = this.aia.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bJ = bJ(match);
        if (DEBUG) {
            Log.d("DispProvider", "[getType] uri = " + uri + " code = " + match + " delegate = " + bJ);
        }
        if (bJ != null) {
            bJ.a(uri, 4);
            return bJ.a(match, uri);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        uf();
        int match = this.aia.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bJ = bJ(match);
        if (bJ != null) {
            bJ.a(uri, 1);
            return bJ.a(match, uri, contentValues);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        uf();
        int match = this.aia.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bJ = bJ(match);
        if (bJ != null) {
            bJ.a(uri, 5);
            return bJ.a(match, uri, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        uf();
        int match = this.aia.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bJ = bJ(match);
        if (bJ != null) {
            bJ.a(uri, 2);
            return bJ.a(match, uri, contentValues, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        uf();
        int match = this.aia.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bJ = bJ(match);
        if (DEBUG) {
            Log.d("DispProvider", "[bulkInsert] uri = " + uri + " code = " + match + " delegate = " + bJ);
        }
        if (bJ != null) {
            bJ.a(uri, 6);
            return bJ.a(match, uri, contentValuesArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        com.baidu.pyramid.runtime.multiprocess.components.a bJ;
        uf();
        if (arrayList == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<ContentProviderOperation> it = arrayList.iterator();
        while (it.hasNext()) {
            ContentProviderOperation next = it.next();
            Uri uri = next.getUri();
            if (uri != null && (bJ = bJ(this.aia.match(uri))) != null) {
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
        uf();
        int match = this.aia.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bJ = bJ(match);
        if (bJ != null) {
            return bJ.a(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        uf();
        int match = this.aia.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bJ = bJ(match);
        if (bJ != null) {
            bJ.a(uri, 7);
            return bJ.b(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        uf();
        int match = this.aia.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bJ = bJ(match);
        if (bJ != null) {
            bJ.a(uri, 7);
            return bJ.a(match, uri, str, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        uf();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.aib.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        uf();
        super.onConfigurationChanged(configuration);
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.aib.iterator();
        while (it.hasNext()) {
            it.next().onConfigurationChanged(configuration);
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        uf();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.aib.iterator();
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
