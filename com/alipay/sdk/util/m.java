package com.alipay.sdk.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.app.EnvUtils;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2020a = "content://com.alipay.android.app.settings.data.ServerProvider/current_server";

    public static String a(Context context) {
        if (EnvUtils.isSandBox()) {
            return com.alipay.sdk.cons.a.f1869b;
        }
        if (context == null) {
            return com.alipay.sdk.cons.a.f1868a;
        }
        String str = com.alipay.sdk.cons.a.f1868a;
        return TextUtils.isEmpty(str) ? com.alipay.sdk.cons.a.f1868a : str;
    }

    public static String b(Context context) {
        Cursor query = context.getContentResolver().query(Uri.parse(f2020a), null, null, null, null);
        if (query != null && query.getCount() > 0) {
            r0 = query.moveToFirst() ? query.getString(query.getColumnIndex("url")) : null;
            query.close();
        }
        return r0;
    }
}
