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
import com.baidu.pyramid.runtime.multiprocess.i;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class DispatchableContentProvider extends ContentProvider {
    private static final boolean DEBUG = i.DEBUG;
    private a ahF;
    private ArrayList<com.baidu.pyramid.runtime.multiprocess.components.a> ahG;
    private String mAuthority;
    private volatile boolean Vt = false;
    private final Object ahH = new Object();

    protected abstract String getAuthority();

    protected abstract List<com.baidu.pyramid.runtime.multiprocess.components.a> uE();

    private com.baidu.pyramid.runtime.multiprocess.components.a bK(int i) {
        int i2;
        int i3;
        int i4 = 0;
        int size = this.ahG.size() - 1;
        while (i4 <= size) {
            int i5 = (i4 + size) / 2;
            com.baidu.pyramid.runtime.multiprocess.components.a aVar = this.ahG.get(i5);
            if (i < aVar.uC() || i > aVar.uD()) {
                if (i < aVar.uC()) {
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
        if (aVar.uC() > aVar.uD()) {
            throw new IllegalArgumentException();
        }
        int size = this.ahG.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3 = aVar.uC() > this.ahG.get(i).uD() ? i + 1 : i2;
            i++;
            i2 = i3;
        }
        if (i2 < size - 1 && aVar.uD() >= this.ahG.get(i2).uC()) {
            throw new IllegalArgumentException();
        }
        this.ahG.add(i2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends UriMatcher {
        int ahI;
        int ahJ;

        public a(int i) {
            super(i);
        }

        @Override // android.content.UriMatcher
        public void addURI(String str, String str2, int i) {
            bL(i);
            super.addURI(str, str2, i);
        }

        private void bL(int i) {
            if (i < this.ahJ || i > this.ahI) {
                throw new IllegalArgumentException("The minCode is : " + this.ahJ + "The maxCode is : " + this.ahI + "The error code is : " + i);
            }
        }
    }

    private void initIfNeed() {
        if (!this.Vt) {
            synchronized (this.ahH) {
                if (!this.Vt) {
                    this.Vt = true;
                    this.mAuthority = getAuthority();
                    if (this.mAuthority == null) {
                        throw new IllegalStateException();
                    }
                    this.ahF = new a(-1);
                    this.ahG = new ArrayList<>();
                    List<com.baidu.pyramid.runtime.multiprocess.components.a> uE = uE();
                    if (uE != null) {
                        for (com.baidu.pyramid.runtime.multiprocess.components.a aVar : uE) {
                            a(aVar);
                            this.ahF.ahJ = aVar.uC();
                            this.ahF.ahI = aVar.uD();
                            aVar.a(this.ahF, this.mAuthority);
                        }
                    }
                    Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.ahG.iterator();
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
        initIfNeed();
        int match = this.ahF.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bK = bK(match);
        if (DEBUG) {
            Log.d("DispProvider", "[query] uri = " + uri + " code = " + match + " delegate = " + bK);
        }
        if (bK != null) {
            bK.a(uri, 0);
            return bK.a(match, uri, strArr, str, strArr2, str2);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        initIfNeed();
        int match = this.ahF.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bK = bK(match);
        if (DEBUG) {
            Log.d("DispProvider", "[query] uri = " + uri + " code = " + match + " delegate = " + bK);
        }
        if (bK != null) {
            bK.a(uri, 0);
            return bK.a(match, uri, strArr, str, strArr2, str2, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        initIfNeed();
        int match = this.ahF.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bK = bK(match);
        if (DEBUG) {
            Log.d("DispProvider", "[getType] uri = " + uri + " code = " + match + " delegate = " + bK);
        }
        if (bK != null) {
            bK.a(uri, 4);
            return bK.a(match, uri);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        initIfNeed();
        int match = this.ahF.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bK = bK(match);
        if (bK != null) {
            bK.a(uri, 1);
            return bK.a(match, uri, contentValues);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        initIfNeed();
        int match = this.ahF.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bK = bK(match);
        if (bK != null) {
            bK.a(uri, 5);
            return bK.a(match, uri, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        initIfNeed();
        int match = this.ahF.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bK = bK(match);
        if (bK != null) {
            bK.a(uri, 2);
            return bK.a(match, uri, contentValues, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        initIfNeed();
        int match = this.ahF.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bK = bK(match);
        if (DEBUG) {
            Log.d("DispProvider", "[bulkInsert] uri = " + uri + " code = " + match + " delegate = " + bK);
        }
        if (bK != null) {
            bK.a(uri, 6);
            return bK.a(match, uri, contentValuesArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        com.baidu.pyramid.runtime.multiprocess.components.a bK;
        initIfNeed();
        if (arrayList == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<ContentProviderOperation> it = arrayList.iterator();
        while (it.hasNext()) {
            ContentProviderOperation next = it.next();
            Uri uri = next.getUri();
            if (uri != null && (bK = bK(this.ahF.match(uri))) != null) {
                bK.a(uri, 0);
                ArrayList arrayList2 = (ArrayList) hashMap.get(bK);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    hashMap.put(bK, arrayList2);
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
        initIfNeed();
        int match = this.ahF.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bK = bK(match);
        if (bK != null) {
            return bK.a(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        initIfNeed();
        int match = this.ahF.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bK = bK(match);
        if (bK != null) {
            bK.a(uri, 7);
            return bK.b(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        initIfNeed();
        int match = this.ahF.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a bK = bK(match);
        if (bK != null) {
            bK.a(uri, 7);
            return bK.a(match, uri, str, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        initIfNeed();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.ahG.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        initIfNeed();
        super.onConfigurationChanged(configuration);
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.ahG.iterator();
        while (it.hasNext()) {
            it.next().onConfigurationChanged(configuration);
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        initIfNeed();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.ahG.iterator();
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
