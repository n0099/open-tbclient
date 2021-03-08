package com.baidu.sofire.m;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f3566a;

    public b(Context context) {
        this.f3566a = context;
    }

    public final String a() {
        Cursor query = this.f3566a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
        if (query != null) {
            r2 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
            query.close();
        } else {
            Log.d("VMS_IDLG_SDK_DB", "return cursor is null,return");
        }
        return r2;
    }
}
