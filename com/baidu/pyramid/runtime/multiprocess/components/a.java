package com.baidu.pyramid.runtime.multiprocess.components;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class a {
    private ContentProvider aRr;
    private final int aRs;
    public final int aRt;

    public abstract int a(int i, Uri uri, ContentValues contentValues, String str, String[] strArr);

    public abstract int a(int i, Uri uri, String str, String[] strArr);

    public abstract Cursor a(int i, Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    public abstract Uri a(int i, Uri uri, ContentValues contentValues);

    public abstract String a(int i, Uri uri);

    public abstract void a(UriMatcher uriMatcher, String str);

    public abstract boolean onCreate();

    public a(int i, int i2) {
        this.aRs = i;
        this.aRt = i2;
    }

    public final int CE() {
        return this.aRs;
    }

    public final int CF() {
        return this.aRt;
    }

    public void a(ContentProvider contentProvider) {
        if (this.aRr == null) {
            this.aRr = contentProvider;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Uri uri, int i) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public Cursor a(int i, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return a(i, uri, strArr, str, strArr2, str2);
    }

    public boolean b(String str, String str2, Bundle bundle) {
        return false;
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        return null;
    }

    public int a(int i, Uri uri, ContentValues[] contentValuesArr) {
        int length = contentValuesArr.length;
        for (ContentValues contentValues : contentValuesArr) {
            a(i, uri, contentValues);
        }
        return length;
    }

    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        int size = arrayList.size();
        ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[size];
        for (int i = 0; i < size; i++) {
            contentProviderResultArr[i] = arrayList.get(i).apply(this.aRr, contentProviderResultArr, i);
        }
        return contentProviderResultArr;
    }

    public ParcelFileDescriptor a(int i, Uri uri, String str) throws FileNotFoundException {
        throw new FileNotFoundException("No files supported by provider at " + uri);
    }

    public AssetFileDescriptor b(int i, Uri uri, String str) throws FileNotFoundException {
        ParcelFileDescriptor a = a(i, uri, str);
        if (a != null) {
            return new AssetFileDescriptor(a, 0L, -1L);
        }
        return null;
    }

    public AssetFileDescriptor a(int i, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return b(i, uri, str);
    }
}
