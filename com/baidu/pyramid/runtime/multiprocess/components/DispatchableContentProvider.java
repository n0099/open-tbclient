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
    private a aif;
    private ArrayList<com.baidu.pyramid.runtime.multiprocess.components.a> aig;
    private volatile boolean aih = false;
    private final Object aii = new Object();
    private String mAuthority;

    protected abstract String getAuthority();

    protected abstract List<com.baidu.pyramid.runtime.multiprocess.components.a> ud();

    private com.baidu.pyramid.runtime.multiprocess.components.a bI(int i) {
        int i2;
        int i3;
        int i4 = 0;
        int size = this.aig.size() - 1;
        while (i4 <= size) {
            int i5 = (i4 + size) / 2;
            com.baidu.pyramid.runtime.multiprocess.components.a aVar = this.aig.get(i5);
            if (i < aVar.ub() || i > aVar.uc()) {
                if (i < aVar.ub()) {
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
        if (aVar.ub() > aVar.uc()) {
            throw new IllegalArgumentException();
        }
        int size = this.aig.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3 = aVar.ub() > this.aig.get(i).uc() ? i + 1 : i2;
            i++;
            i2 = i3;
        }
        if (i2 < size - 1 && aVar.uc() >= this.aig.get(i2).ub()) {
            throw new IllegalArgumentException();
        }
        this.aig.add(i2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends UriMatcher {
        int aij;
        int aik;

        public a(int i) {
            super(i);
        }

        @Override // android.content.UriMatcher
        public void addURI(String str, String str2, int i) {
            bJ(i);
            super.addURI(str, str2, i);
        }

        private void bJ(int i) {
            if (i < this.aik || i > this.aij) {
                throw new IllegalArgumentException("The minCode is : " + this.aik + "The maxCode is : " + this.aij + "The error code is : " + i);
            }
        }
    }

    private void ue() {
        if (!this.aih) {
            synchronized (this.aii) {
                if (!this.aih) {
                    this.aih = true;
                    this.mAuthority = getAuthority();
                    if (this.mAuthority == null) {
                        throw new IllegalStateException();
                    }
                    this.aif = new a(-1);
                    this.aig = new ArrayList<>();
                    List<com.baidu.pyramid.runtime.multiprocess.components.a> ud = ud();
                    if (ud != null) {
                        for (com.baidu.pyramid.runtime.multiprocess.components.a aVar : ud) {
                            a(aVar);
                            this.aif.aik = aVar.ub();
                            this.aif.aij = aVar.uc();
                            aVar.a(this.aif, this.mAuthority);
                        }
                    }
                    Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.aig.iterator();
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
        ue();
        int match = this.aif.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bI = bI(match);
        if (DEBUG) {
            Log.d("DispProvider", "[query] uri = " + uri + " code = " + match + " delegate = " + bI);
        }
        if (bI != null) {
            bI.a(uri, 0);
            return bI.a(match, uri, strArr, str, strArr2, str2);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        ue();
        int match = this.aif.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bI = bI(match);
        if (DEBUG) {
            Log.d("DispProvider", "[query] uri = " + uri + " code = " + match + " delegate = " + bI);
        }
        if (bI != null) {
            bI.a(uri, 0);
            return bI.a(match, uri, strArr, str, strArr2, str2, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        ue();
        int match = this.aif.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bI = bI(match);
        if (DEBUG) {
            Log.d("DispProvider", "[getType] uri = " + uri + " code = " + match + " delegate = " + bI);
        }
        if (bI != null) {
            bI.a(uri, 4);
            return bI.a(match, uri);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        ue();
        int match = this.aif.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bI = bI(match);
        if (bI != null) {
            bI.a(uri, 1);
            return bI.a(match, uri, contentValues);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        ue();
        int match = this.aif.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bI = bI(match);
        if (bI != null) {
            bI.a(uri, 5);
            return bI.a(match, uri, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        ue();
        int match = this.aif.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bI = bI(match);
        if (bI != null) {
            bI.a(uri, 2);
            return bI.a(match, uri, contentValues, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        ue();
        int match = this.aif.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bI = bI(match);
        if (DEBUG) {
            Log.d("DispProvider", "[bulkInsert] uri = " + uri + " code = " + match + " delegate = " + bI);
        }
        if (bI != null) {
            bI.a(uri, 6);
            return bI.a(match, uri, contentValuesArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        com.baidu.pyramid.runtime.multiprocess.components.a bI;
        ue();
        if (arrayList == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<ContentProviderOperation> it = arrayList.iterator();
        while (it.hasNext()) {
            ContentProviderOperation next = it.next();
            Uri uri = next.getUri();
            if (uri != null && (bI = bI(this.aif.match(uri))) != null) {
                bI.a(uri, 0);
                ArrayList arrayList2 = (ArrayList) hashMap.get(bI);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    hashMap.put(bI, arrayList2);
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
        ue();
        int match = this.aif.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bI = bI(match);
        if (bI != null) {
            return bI.a(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        ue();
        int match = this.aif.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bI = bI(match);
        if (bI != null) {
            bI.a(uri, 7);
            return bI.b(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        ue();
        int match = this.aif.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bI = bI(match);
        if (bI != null) {
            bI.a(uri, 7);
            return bI.a(match, uri, str, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        ue();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.aig.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        ue();
        super.onConfigurationChanged(configuration);
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.aig.iterator();
        while (it.hasNext()) {
            it.next().onConfigurationChanged(configuration);
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        ue();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.aig.iterator();
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
