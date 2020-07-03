package com.baidu.swan.pms.database.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import java.util.List;
/* loaded from: classes11.dex */
public abstract class b<T> {
    public abstract ContentValues af(T t);

    public abstract <T> List<T> h(Cursor cursor) throws SQLException;

    public abstract <T> T j(Cursor cursor) throws SQLException;

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(Cursor cursor, com.baidu.swan.pms.model.e eVar) {
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndex("bundle_id");
            int columnIndex2 = cursor.getColumnIndex("category");
            int columnIndex3 = cursor.getColumnIndex(SharedPrefConfig.VERSION_NAME);
            int columnIndex4 = cursor.getColumnIndex("version_code");
            int columnIndex5 = cursor.getColumnIndex(TiebaInitialize.LogFields.SIZE);
            int columnIndex6 = cursor.getColumnIndex("md5");
            int columnIndex7 = cursor.getColumnIndex("sign");
            int columnIndex8 = cursor.getColumnIndex("downloadUrl");
            int columnIndex9 = cursor.getColumnIndex(IMConstants.MSG_ROW_ID);
            int columnIndex10 = cursor.getColumnIndex("file_path");
            int columnIndex11 = cursor.getColumnIndex("current_size");
            int columnIndex12 = cursor.getColumnIndex("create_time");
            int columnIndex13 = cursor.getColumnIndex("update_time");
            int columnIndex14 = cursor.getColumnIndex("state");
            String string = cursor.getString(columnIndex);
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            eVar.dqi = string;
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
            eVar.dqj = cursor.getLong(columnIndex9);
            eVar.state = cursor.getInt(columnIndex14);
            return true;
        }
        return false;
    }

    public ContentValues e(com.baidu.swan.pms.model.e eVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("bundle_id", eVar.dqi);
        contentValues.put("category", Integer.valueOf(eVar.category));
        contentValues.put(SharedPrefConfig.VERSION_NAME, eVar.versionName);
        contentValues.put("version_code", Integer.valueOf(eVar.versionCode));
        contentValues.put(TiebaInitialize.LogFields.SIZE, Long.valueOf(eVar.size));
        contentValues.put("md5", eVar.md5);
        contentValues.put("sign", eVar.sign);
        contentValues.put("downloadUrl", eVar.downloadUrl);
        contentValues.put("file_path", eVar.filePath);
        contentValues.put("current_size", Long.valueOf(eVar.currentSize));
        contentValues.put("create_time", Long.valueOf(eVar.createTime));
        contentValues.put("update_time", Long.valueOf(eVar.updateTime));
        contentValues.put("state", Integer.valueOf(eVar.state));
        return contentValues;
    }
}
