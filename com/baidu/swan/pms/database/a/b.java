package com.baidu.swan.pms.database.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class b<T> {
    public abstract ContentValues U(T t);

    public abstract <T> List<T> j(Cursor cursor) throws SQLException;

    public abstract <T> T l(Cursor cursor) throws SQLException;

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(Cursor cursor, com.baidu.swan.pms.model.e eVar) {
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndex("bundle_id");
            int columnIndex2 = cursor.getColumnIndex("category");
            int columnIndex3 = cursor.getColumnIndex("version_name");
            int columnIndex4 = cursor.getColumnIndex("version_code");
            int columnIndex5 = cursor.getColumnIndex("size");
            int columnIndex6 = cursor.getColumnIndex("md5");
            int columnIndex7 = cursor.getColumnIndex("sign");
            int columnIndex8 = cursor.getColumnIndex("downloadUrl");
            int columnIndex9 = cursor.getColumnIndex("_id");
            int columnIndex10 = cursor.getColumnIndex("file_path");
            int columnIndex11 = cursor.getColumnIndex("current_size");
            int columnIndex12 = cursor.getColumnIndex("create_time");
            int columnIndex13 = cursor.getColumnIndex("update_time");
            int columnIndex14 = cursor.getColumnIndex(WXLoginActivity.KEY_BASE_RESP_STATE);
            String string = cursor.getString(columnIndex);
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            eVar.bsc = string;
            eVar.category = cursor.getInt(columnIndex2);
            eVar.versionName = cursor.getString(columnIndex3);
            eVar.versionCode = cursor.getInt(columnIndex4);
            eVar.size = cursor.getLong(columnIndex5);
            eVar.md5 = cursor.getString(columnIndex6);
            eVar.sign = cursor.getString(columnIndex7);
            eVar.downloadUrl = cursor.getString(columnIndex8);
            eVar.filePath = cursor.getString(columnIndex10);
            eVar.currentSize = cursor.getLong(columnIndex11);
            eVar.createTime = cursor.getLong(columnIndex12);
            eVar.updateTime = cursor.getLong(columnIndex13);
            eVar.aaA = cursor.getLong(columnIndex9);
            eVar.state = cursor.getInt(columnIndex14);
            return true;
        }
        return false;
    }

    public ContentValues g(com.baidu.swan.pms.model.e eVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("bundle_id", eVar.bsc);
        contentValues.put("category", Integer.valueOf(eVar.category));
        contentValues.put("version_name", eVar.versionName);
        contentValues.put("version_code", Integer.valueOf(eVar.versionCode));
        contentValues.put("size", Long.valueOf(eVar.size));
        contentValues.put("md5", eVar.md5);
        contentValues.put("sign", eVar.sign);
        contentValues.put("downloadUrl", eVar.downloadUrl);
        contentValues.put("file_path", eVar.filePath);
        contentValues.put("current_size", Long.valueOf(eVar.currentSize));
        contentValues.put("create_time", Long.valueOf(eVar.createTime));
        contentValues.put("update_time", Long.valueOf(eVar.updateTime));
        contentValues.put(WXLoginActivity.KEY_BASE_RESP_STATE, Integer.valueOf(eVar.state));
        return contentValues;
    }
}
