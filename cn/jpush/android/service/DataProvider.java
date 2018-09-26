package cn.jpush.android.service;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.fsg.base.armor.RimArmor;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class DataProvider extends ContentProvider {
    private static final String TAG = "DataProvider";

    private String getName(Uri uri) {
        String path;
        if (uri != null) {
            try {
                path = uri.getPath();
            } catch (Throwable th) {
                return null;
            }
        } else {
            path = null;
        }
        if (path == null) {
            path = null;
        } else if (path.charAt(0) == '/') {
            path = path.substring(1);
        }
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        return path;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        cn.jiguang.g.b.d O;
        String name = getName(uri);
        return (name == null || (O = cn.jiguang.g.b.d.O(getContext(), name)) == null || !O.a()) ? 0 : 1;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        String str;
        String str2;
        int i;
        String name = getName(uri);
        if (name == null) {
            return null;
        }
        try {
            str = uri.getQueryParameter(RimArmor.KEY);
        } catch (Throwable th) {
            str = null;
        }
        try {
            str2 = str;
            i = Integer.valueOf(uri.getQueryParameter("type")).intValue();
        } catch (Throwable th2) {
            str2 = str;
            i = -1;
            return i < 0 ? null : null;
        }
        if (i < 0 && i <= 6) {
            cn.jiguang.g.b.d O = cn.jiguang.g.b.d.O(getContext(), name);
            Serializable g = O != null ? O.g(str2, i) : null;
            if (g != null) {
                return g.toString();
            }
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return uri;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String name;
        if (strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0 || strArr.length != strArr2.length || (name = getName(uri)) == null) {
            return null;
        }
        try {
            cn.jiguang.g.b.d O = cn.jiguang.g.b.d.O(getContext(), name);
            if (O != null) {
                int length = strArr.length;
                MatrixCursor matrixCursor = new MatrixCursor(strArr, 1);
                Object[] objArr = new Object[length];
                for (int i = 0; i < length; i++) {
                    try {
                        objArr[i] = O.g(strArr[i], Integer.valueOf(strArr2[i]).intValue());
                        if (objArr[i] != null) {
                            if (objArr[i].equals(false)) {
                                objArr[i] = 0;
                            } else if (objArr[i].equals(true)) {
                                objArr[i] = 1;
                            }
                        }
                    } catch (NumberFormatException e) {
                        Log.e(TAG, "selectionArgs should be int");
                    }
                }
                matrixCursor.addRow(objArr);
                return matrixCursor;
            }
            return null;
        } catch (Throwable th) {
            Log.e(TAG, th.getMessage());
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String name;
        cn.jiguang.g.b.d O;
        if (contentValues == null || contentValues.size() == 0 || (name = getName(uri)) == null || (O = cn.jiguang.g.b.d.O(getContext(), name)) == null || !O.b(contentValues)) {
            return 0;
        }
        return contentValues.size();
    }
}
