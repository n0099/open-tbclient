package cn.jiguang.g.b;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.io.Serializable;
import java.util.Map;
/* loaded from: classes3.dex */
public final class c {
    public static a a(ContentResolver contentResolver, String str, a aVar) {
        Cursor cursor;
        try {
            int b = aVar.b();
            if (b == 0) {
                return aVar;
            }
            String[] strArr = new String[b];
            String[] strArr2 = new String[b];
            int i = 0;
            for (Map.Entry<String, Serializable> entry : aVar.a()) {
                strArr[i] = entry.getKey();
                strArr2[i] = String.valueOf(a.b(entry.getValue()));
                i++;
            }
            cursor = contentResolver.query(Uri.parse(str), strArr, null, strArr2, null);
            try {
                a aVar2 = new a();
                if (cursor != null && aVar != null && aVar.b() != 0) {
                    for (int i2 = 0; i2 < cursor.getColumnCount(); i2++) {
                        String columnName = cursor.getColumnName(i2);
                        aVar2.a(columnName, a(cursor, i2, aVar.b(columnName, null)));
                    }
                }
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                return aVar2;
            } catch (Throwable th) {
                th = th;
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    private static <T extends Serializable> T a(Cursor cursor, int i, T t) {
        T t2 = null;
        try {
            cursor.moveToFirst();
            String string = cursor.getString(i);
            if (string != null) {
                switch (a.b(t)) {
                    case 0:
                        t2 = string;
                        break;
                    case 1:
                        t2 = string;
                        break;
                    case 2:
                        t2 = Integer.valueOf(cursor.getInt(i));
                        break;
                    case 3:
                        t2 = Boolean.valueOf(cursor.getInt(i) > 0);
                        break;
                    case 4:
                        t2 = Long.valueOf(cursor.getLong(i));
                        break;
                    case 5:
                        t2 = Float.valueOf(cursor.getFloat(i));
                        break;
                }
            }
        } catch (Throwable th) {
            Log.e("SpProviderHelper", "convert " + th.getMessage());
        }
        return t2 == null ? t : t2;
    }

    public static <T extends Serializable> boolean a(ContentResolver contentResolver, String str, String str2, T t) {
        return b(contentResolver, str, new a().a(str2, t));
    }

    public static boolean b(ContentResolver contentResolver, String str, a aVar) {
        ContentValues contentValues = new ContentValues();
        for (Map.Entry<String, Serializable> entry : aVar.a()) {
            switch (a.b(entry.getValue())) {
                case 0:
                    contentValues.put(entry.getKey(), (String) null);
                    break;
                case 1:
                    contentValues.put(entry.getKey(), (String) entry.getValue());
                    break;
                case 2:
                    contentValues.put(entry.getKey(), (Integer) entry.getValue());
                    break;
                case 3:
                    contentValues.put(entry.getKey(), (Boolean) entry.getValue());
                    break;
                case 4:
                    contentValues.put(entry.getKey(), (Long) entry.getValue());
                    break;
                case 5:
                    contentValues.put(entry.getKey(), (Float) entry.getValue());
                    break;
            }
        }
        return contentResolver.update(Uri.parse(str), contentValues, null, null) > 0;
    }
}
