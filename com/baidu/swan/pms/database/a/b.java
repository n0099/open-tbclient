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
    public boolean a(Cursor cursor, com.baidu.swan.pms.model.f fVar) {
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
            fVar.blZ = string;
            fVar.category = cursor.getInt(columnIndex2);
            fVar.versionName = cursor.getString(columnIndex3);
            fVar.versionCode = cursor.getInt(columnIndex4);
            fVar.size = cursor.getLong(columnIndex5);
            fVar.md5 = cursor.getString(columnIndex6);
            fVar.sign = cursor.getString(columnIndex7);
            fVar.downloadUrl = cursor.getString(columnIndex8);
            fVar.filePath = cursor.getString(columnIndex10);
            fVar.currentSize = cursor.getLong(columnIndex11);
            fVar.createTime = cursor.getLong(columnIndex12);
            fVar.updateTime = cursor.getLong(columnIndex13);
            fVar.acM = cursor.getLong(columnIndex9);
            fVar.state = cursor.getInt(columnIndex14);
            return true;
        }
        return false;
    }

    public ContentValues e(com.baidu.swan.pms.model.f fVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("bundle_id", fVar.blZ);
        contentValues.put("category", Integer.valueOf(fVar.category));
        contentValues.put("version_name", fVar.versionName);
        contentValues.put("version_code", Integer.valueOf(fVar.versionCode));
        contentValues.put("size", Long.valueOf(fVar.size));
        contentValues.put("md5", fVar.md5);
        contentValues.put("sign", fVar.sign);
        contentValues.put("downloadUrl", fVar.downloadUrl);
        contentValues.put("file_path", fVar.filePath);
        contentValues.put("current_size", Long.valueOf(fVar.currentSize));
        contentValues.put("create_time", Long.valueOf(fVar.createTime));
        contentValues.put("update_time", Long.valueOf(fVar.updateTime));
        contentValues.put(WXLoginActivity.KEY_BASE_RESP_STATE, Integer.valueOf(fVar.state));
        return contentValues;
    }
}
