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
    private a cjU;
    private ArrayList<com.baidu.pyramid.runtime.multiprocess.components.a> cjV;
    private String mAuthority;
    private volatile boolean mIsInit = false;
    private final Object cjW = new Object();

    protected abstract String adu();

    protected abstract List<com.baidu.pyramid.runtime.multiprocess.components.a> adv();

    private com.baidu.pyramid.runtime.multiprocess.components.a hb(int i) {
        int i2;
        int i3;
        int i4 = 0;
        int size = this.cjV.size() - 1;
        while (i4 <= size) {
            int i5 = (i4 + size) / 2;
            com.baidu.pyramid.runtime.multiprocess.components.a aVar = this.cjV.get(i5);
            if (i < aVar.ads() || i > aVar.adt()) {
                if (i < aVar.ads()) {
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
        if (aVar.ads() > aVar.adt()) {
            throw new IllegalArgumentException();
        }
        int size = this.cjV.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3 = aVar.ads() > this.cjV.get(i).adt() ? i + 1 : i2;
            i++;
            i2 = i3;
        }
        if (i2 < size - 1 && aVar.adt() >= this.cjV.get(i2).ads()) {
            throw new IllegalArgumentException();
        }
        this.cjV.add(i2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class a extends UriMatcher {
        int cjX;
        int cjY;

        public a(int i) {
            super(i);
        }

        @Override // android.content.UriMatcher
        public void addURI(String str, String str2, int i) {
            hc(i);
            super.addURI(str, str2, i);
        }

        private void hc(int i) {
            if (i < this.cjY || i > this.cjX) {
                throw new IllegalArgumentException("The minCode is : " + this.cjY + "The maxCode is : " + this.cjX + "The error code is : " + i);
            }
        }
    }

    private void adw() {
        if (!this.mIsInit) {
            synchronized (this.cjW) {
                if (!this.mIsInit) {
                    this.mIsInit = true;
                    this.mAuthority = adu();
                    if (this.mAuthority == null) {
                        throw new IllegalStateException();
                    }
                    this.cjU = new a(-1);
                    this.cjV = new ArrayList<>();
                    List<com.baidu.pyramid.runtime.multiprocess.components.a> adv = adv();
                    if (adv != null) {
                        for (com.baidu.pyramid.runtime.multiprocess.components.a aVar : adv) {
                            a(aVar);
                            this.cjU.cjY = aVar.ads();
                            this.cjU.cjX = aVar.adt();
                            aVar.a(this.cjU, this.mAuthority);
                        }
                    }
                    Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.cjV.iterator();
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
        adw();
        int match = this.cjU.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a hb = hb(match);
        if (hb != null) {
            hb.b(uri, 0);
            return hb.a(match, uri, strArr, str, strArr2, str2);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        adw();
        int match = this.cjU.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a hb = hb(match);
        if (hb != null) {
            hb.b(uri, 0);
            return hb.a(match, uri, strArr, str, strArr2, str2, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        adw();
        int match = this.cjU.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a hb = hb(match);
        if (hb != null) {
            hb.b(uri, 4);
            return hb.a(match, uri);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        adw();
        int match = this.cjU.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a hb = hb(match);
        if (hb != null) {
            hb.b(uri, 1);
            return hb.a(match, uri, contentValues);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        adw();
        int match = this.cjU.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a hb = hb(match);
        if (hb != null) {
            hb.b(uri, 5);
            return hb.a(match, uri, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        adw();
        int match = this.cjU.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a hb = hb(match);
        if (hb != null) {
            hb.b(uri, 2);
            return hb.a(match, uri, contentValues, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        adw();
        int match = this.cjU.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a hb = hb(match);
        if (hb != null) {
            hb.b(uri, 6);
            return hb.a(match, uri, contentValuesArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        com.baidu.pyramid.runtime.multiprocess.components.a hb;
        adw();
        if (arrayList == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<ContentProviderOperation> it = arrayList.iterator();
        while (it.hasNext()) {
            ContentProviderOperation next = it.next();
            Uri uri = next.getUri();
            if (uri != null && (hb = hb(this.cjU.match(uri))) != null) {
                hb.b(uri, 0);
                ArrayList arrayList2 = (ArrayList) hashMap.get(hb);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    hashMap.put(hb, arrayList2);
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
        adw();
        int match = this.cjU.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a hb = hb(match);
        if (hb != null) {
            return hb.a(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        adw();
        int match = this.cjU.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a hb = hb(match);
        if (hb != null) {
            hb.b(uri, 7);
            return hb.b(match, uri, str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        adw();
        int match = this.cjU.match(uri);
        com.baidu.pyramid.runtime.multiprocess.components.a hb = hb(match);
        if (hb != null) {
            hb.b(uri, 7);
            return hb.a(match, uri, str, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        adw();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.cjV.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        adw();
        super.onConfigurationChanged(configuration);
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.cjV.iterator();
        while (it.hasNext()) {
            it.next().onConfigurationChanged(configuration);
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        adw();
        Iterator<com.baidu.pyramid.runtime.multiprocess.components.a> it = this.cjV.iterator();
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
