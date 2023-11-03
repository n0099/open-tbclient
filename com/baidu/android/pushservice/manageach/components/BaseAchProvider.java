package com.baidu.android.pushservice.manageach.components;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
/* loaded from: classes.dex */
public abstract class BaseAchProvider extends ContentProvider {
    public abstract int a(Uri uri, ContentValues contentValues, String str, String[] strArr);

    public abstract int a(Uri uri, String str, String[] strArr);

    public abstract Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    public abstract Uri a(Uri uri, ContentValues contentValues);

    public abstract String a(Uri uri);

    public abstract boolean a();

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        try {
            return a(uri, str, strArr);
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        try {
            return a(uri);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        try {
            return a(uri, contentValues);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        try {
            return a();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            return a(uri, strArr, str, strArr2, str2);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            return a(uri, contentValues, str, strArr);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
