package com.baidu.android.pushservice.ach;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.android.pushservice.manageach.components.BaseAchProvider;
import com.baidu.android.pushservice.z.c;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
/* loaded from: classes.dex */
public class PushAchProvider extends BaseAchProvider {
    public final String a = PushAchProvider.class.getName();

    /* loaded from: classes.dex */
    public class a extends c {
        public a() {
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15913, this, null);
        }
    }

    public static /* synthetic */ String a(PushAchProvider pushAchProvider) {
        return (String) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15916, null, pushAchProvider);
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchProvider
    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.i(-15915, this, uri, contentValues, str, strArr);
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchProvider
    public int a(Uri uri, String str, String[] strArr) {
        return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.i(-15910, this, uri, str, strArr);
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchProvider
    public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return (Cursor) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15909, this, uri, strArr, str, strArr2, str2);
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchProvider
    public Uri a(Uri uri, ContentValues contentValues) {
        return (Uri) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15912, this, uri, contentValues);
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchProvider
    public String a(Uri uri) {
        return (String) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15911, this, uri);
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchProvider
    public boolean a() {
        return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15906, this, null);
    }

    public final void b() {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15905, this, null);
    }
}
