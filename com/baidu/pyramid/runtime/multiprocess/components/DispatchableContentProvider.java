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
/* loaded from: classes2.dex */
public abstract class DispatchableContentProvider extends ContentProvider {
    public static final boolean DEBUG = false;
    public static final String TAG = "DispProvider";
    public String mAuthority;
    public ArrayList<d.a.c0.b.a.i.a> mContentProviderDelegates;
    public a mUriMatcher;
    public volatile boolean mIsInit = false;
    public final Object mInitLocker = new Object();

    /* loaded from: classes2.dex */
    public static class a extends UriMatcher {

        /* renamed from: a  reason: collision with root package name */
        public int f9506a;

        /* renamed from: b  reason: collision with root package name */
        public int f9507b;

        public a(int i2) {
            super(i2);
        }

        public final void a(int i2) {
            if (i2 < this.f9507b || i2 > this.f9506a) {
                throw new IllegalArgumentException("The minCode is : " + this.f9507b + "The maxCode is : " + this.f9506a + "The error code is : " + i2);
            }
        }

        @Override // android.content.UriMatcher
        public void addURI(String str, String str2, int i2) {
            a(i2);
            super.addURI(str, str2, i2);
        }
    }

    private d.a.c0.b.a.i.a findContentProviderDelegate(int i2) {
        int size = this.mContentProviderDelegates.size() - 1;
        int i3 = 0;
        while (i3 <= size) {
            int i4 = (i3 + size) / 2;
            d.a.c0.b.a.i.a aVar = this.mContentProviderDelegates.get(i4);
            if (i2 >= aVar.l() && i2 <= aVar.k()) {
                return aVar;
            }
            if (i2 < aVar.l()) {
                size = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return null;
    }

    private void initIfNeed() {
        if (this.mIsInit) {
            return;
        }
        synchronized (this.mInitLocker) {
            if (this.mIsInit) {
                return;
            }
            this.mIsInit = true;
            String authority = getAuthority();
            this.mAuthority = authority;
            if (authority != null) {
                this.mUriMatcher = new a(-1);
                this.mContentProviderDelegates = new ArrayList<>();
                List<d.a.c0.b.a.i.a> contentProviderDelegates = getContentProviderDelegates();
                if (contentProviderDelegates != null) {
                    for (d.a.c0.b.a.i.a aVar : contentProviderDelegates) {
                        insertContentProviderDelegate(aVar);
                        this.mUriMatcher.f9507b = aVar.l();
                        this.mUriMatcher.f9506a = aVar.k();
                        aVar.h(this.mUriMatcher, this.mAuthority);
                    }
                }
                Iterator<d.a.c0.b.a.i.a> it = this.mContentProviderDelegates.iterator();
                while (it.hasNext()) {
                    it.next().n();
                }
                return;
            }
            throw new IllegalStateException();
        }
    }

    private void insertContentProviderDelegate(d.a.c0.b.a.i.a aVar) {
        if (aVar.l() <= aVar.k()) {
            int size = this.mContentProviderDelegates.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (aVar.l() > this.mContentProviderDelegates.get(i3).k()) {
                    i2 = i3 + 1;
                }
            }
            if (i2 < size - 1 && aVar.k() >= this.mContentProviderDelegates.get(i2).l()) {
                throw new IllegalArgumentException();
            }
            this.mContentProviderDelegates.add(i2, aVar);
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        d.a.c0.b.a.i.a findContentProviderDelegate;
        initIfNeed();
        if (arrayList == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<ContentProviderOperation> it = arrayList.iterator();
        while (it.hasNext()) {
            ContentProviderOperation next = it.next();
            Uri uri = next.getUri();
            if (uri != null && (findContentProviderDelegate = findContentProviderDelegate(this.mUriMatcher.match(uri))) != null) {
                findContentProviderDelegate.g(uri, 0);
                ArrayList arrayList2 = (ArrayList) hashMap.get(findContentProviderDelegate);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    hashMap.put(findContentProviderDelegate, arrayList2);
                }
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            for (ContentProviderResult contentProviderResult : ((d.a.c0.b.a.i.a) entry.getKey()).a((ArrayList) entry.getValue())) {
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
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        initIfNeed();
        Iterator<d.a.c0.b.a.i.a> it = this.mContentProviderDelegates.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        initIfNeed();
        int match = this.mUriMatcher.match(uri);
        d.a.c0.b.a.i.a findContentProviderDelegate = findContentProviderDelegate(match);
        if (findContentProviderDelegate != null) {
            findContentProviderDelegate.g(uri, 6);
            return findContentProviderDelegate.c(match, uri, contentValuesArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        initIfNeed();
        Iterator<d.a.c0.b.a.i.a> it = this.mContentProviderDelegates.iterator();
        while (it.hasNext()) {
            d.a.c0.b.a.i.a next = it.next();
            if (next.e(str, str2, bundle)) {
                next.g(null, 3);
                return next.d(str, str2, bundle);
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        initIfNeed();
        int match = this.mUriMatcher.match(uri);
        d.a.c0.b.a.i.a findContentProviderDelegate = findContentProviderDelegate(match);
        if (findContentProviderDelegate != null) {
            findContentProviderDelegate.g(uri, 5);
            return findContentProviderDelegate.f(match, uri, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    public abstract String getAuthority();

    public abstract List<d.a.c0.b.a.i.a> getContentProviderDelegates();

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        initIfNeed();
        int match = this.mUriMatcher.match(uri);
        d.a.c0.b.a.i.a findContentProviderDelegate = findContentProviderDelegate(match);
        if (findContentProviderDelegate != null) {
            findContentProviderDelegate.g(uri, 4);
            return findContentProviderDelegate.i(match, uri);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        initIfNeed();
        int match = this.mUriMatcher.match(uri);
        d.a.c0.b.a.i.a findContentProviderDelegate = findContentProviderDelegate(match);
        if (findContentProviderDelegate != null) {
            findContentProviderDelegate.g(uri, 1);
            return findContentProviderDelegate.j(match, uri, contentValues);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        initIfNeed();
        super.onConfigurationChanged(configuration);
        Iterator<d.a.c0.b.a.i.a> it = this.mContentProviderDelegates.iterator();
        while (it.hasNext()) {
            it.next().m(configuration);
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        initIfNeed();
        int match = this.mUriMatcher.match(uri);
        d.a.c0.b.a.i.a findContentProviderDelegate = findContentProviderDelegate(match);
        if (findContentProviderDelegate != null) {
            findContentProviderDelegate.g(uri, 7);
            findContentProviderDelegate.o(match, uri, str);
            throw null;
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        initIfNeed();
        int match = this.mUriMatcher.match(uri);
        d.a.c0.b.a.i.a findContentProviderDelegate = findContentProviderDelegate(match);
        if (findContentProviderDelegate != null) {
            findContentProviderDelegate.q(match, uri, str);
            throw null;
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        initIfNeed();
        int match = this.mUriMatcher.match(uri);
        d.a.c0.b.a.i.a findContentProviderDelegate = findContentProviderDelegate(match);
        if (findContentProviderDelegate != null) {
            findContentProviderDelegate.g(uri, 0);
            return findContentProviderDelegate.r(match, uri, strArr, str, strArr2, str2);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        initIfNeed();
        int match = this.mUriMatcher.match(uri);
        d.a.c0.b.a.i.a findContentProviderDelegate = findContentProviderDelegate(match);
        if (findContentProviderDelegate != null) {
            findContentProviderDelegate.g(uri, 2);
            return findContentProviderDelegate.t(match, uri, contentValues, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        initIfNeed();
        int match = this.mUriMatcher.match(uri);
        d.a.c0.b.a.i.a findContentProviderDelegate = findContentProviderDelegate(match);
        if (findContentProviderDelegate != null) {
            findContentProviderDelegate.g(uri, 7);
            findContentProviderDelegate.p(match, uri, str, cancellationSignal);
            throw null;
        }
        throw new IllegalArgumentException();
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        initIfNeed();
        int match = this.mUriMatcher.match(uri);
        d.a.c0.b.a.i.a findContentProviderDelegate = findContentProviderDelegate(match);
        if (findContentProviderDelegate != null) {
            findContentProviderDelegate.g(uri, 0);
            return findContentProviderDelegate.s(match, uri, strArr, str, strArr2, str2, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }
}
