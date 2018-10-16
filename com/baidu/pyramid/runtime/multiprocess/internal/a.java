package com.baidu.pyramid.runtime.multiprocess.internal;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.baidu.pyramid.runtime.multiprocess.d;
import com.baidu.pyramid.runtime.multiprocess.e;
import com.baidu.pyramid.runtime.multiprocess.i;
/* loaded from: classes2.dex */
public class a extends com.baidu.pyramid.runtime.multiprocess.components.a {
    private static final boolean DEBUG = i.DEBUG;

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
            return new e(d.a.uk());
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
    public void a(Uri uri, int i) {
        if (i != 3) {
            super.a(uri, i);
        }
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.a
    public boolean a(String str, String str2, Bundle bundle) {
        return "_get_service_handler".equals(str);
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.a
    public Bundle call(String str, String str2, Bundle bundle) {
        if (DEBUG) {
            Log.d("ServiceManagerChannel", "call " + str);
        }
        if ("_get_service_handler".equals(str)) {
            return d.a.uk();
        }
        return null;
    }
}
