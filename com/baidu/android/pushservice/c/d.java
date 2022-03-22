package com.baidu.android.pushservice.c;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.android.pushservice.c.c;
import com.baidu.android.pushservice.i.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context, String str) {
        InterceptResult invokeLL;
        int p;
        ContentResolver contentResolver;
        int columnIndex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            int i = 0;
            Cursor cursor = null;
            try {
                p = m.p(context, str);
            } catch (Throwable unused) {
            }
            if (p > 0) {
                return p;
            }
            try {
                contentResolver = context.getContentResolver();
            } catch (Throwable unused2) {
                i = p;
            }
            if (contentResolver != null) {
                cursor = contentResolver.query(Uri.parse("content://" + str + ".bdpush/pushinfo_v3"), new String[]{c.g.f24329c.name()}, null, null, null);
                if (cursor == null) {
                    cursor = contentResolver.query(Uri.parse("content://" + str + ".bdpush/pushinfo"), new String[]{c.g.f24329c.name()}, null, null, null);
                    if (cursor != null && cursor.moveToFirst()) {
                        columnIndex = cursor.getColumnIndex(c.g.f24329c.name());
                        p = cursor.getInt(columnIndex);
                    }
                } else if (cursor.moveToFirst()) {
                    columnIndex = cursor.getColumnIndex(c.g.f24329c.name());
                    p = cursor.getInt(columnIndex);
                }
                i = p;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused3) {
                    }
                }
                return i;
            }
            if (cursor != null) {
                try {
                    cursor.close();
                    return p;
                } catch (Exception unused4) {
                    return p;
                }
            }
            return p;
        }
        return invokeLL.intValue;
    }
}
