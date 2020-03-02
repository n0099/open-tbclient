package com.baidu.pyramid.runtime.multiprocess.internal;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.pyramid.runtime.multiprocess.b;
import com.baidu.pyramid.runtime.multiprocess.c;
/* loaded from: classes.dex */
public class a extends com.baidu.pyramid.runtime.multiprocess.components.a {
    public a() {
        super(0, 100);
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.a
    public void a(UriMatcher uriMatcher, String str) {
        uriMatcher.addURI(str, "ipc_manager/method/get_service_handler", 1);
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.a
    public boolean onCreate() {
        return false;
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.a
    public Cursor a(int i, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (i == 1) {
            return new c(b.a.EU());
        }
        return null;
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.a
    public String a(int i, Uri uri) {
        return null;
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.a
    public Uri a(int i, Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.a
    public int a(int i, Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.a
    public int a(int i, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.pyramid.runtime.multiprocess.components.a
    public void b(Uri uri, int i) {
        if (i != 3) {
            super.b(uri, i);
        }
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.a
    public boolean b(String str, String str2, Bundle bundle) {
        return "_get_service_handler".equals(str);
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.a
    public Bundle call(String str, String str2, Bundle bundle) {
        if ("_get_service_handler".equals(str)) {
            return b.a.EU();
        }
        return null;
    }
}
