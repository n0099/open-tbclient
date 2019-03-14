package com.baidu.mobstat;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.util.ArrayList;
/* loaded from: classes6.dex */
class w extends q {
    public w() {
        super("app_change3", "Create table if not exists app_change3(_id Integer primary key AUTOINCREMENT,time VARCHAR(50),content TEXT);");
    }

    @Override // com.baidu.mobstat.q
    public ArrayList<p> a(int i, int i2) {
        Cursor a = a(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, i, i2);
        ArrayList<p> a2 = a(a);
        if (a != null) {
            a.close();
        }
        return a2;
    }

    @Override // com.baidu.mobstat.q
    public long a(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, str);
        contentValues.put("content", str2);
        return a(contentValues);
    }

    @Override // com.baidu.mobstat.q
    public boolean b(long j) {
        return a(j);
    }

    private ArrayList<p> a(Cursor cursor) {
        ArrayList<p> arrayList = new ArrayList<>();
        if (cursor != null && cursor.getCount() != 0) {
            int columnIndex = cursor.getColumnIndex("_id");
            int columnIndex2 = cursor.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            int columnIndex3 = cursor.getColumnIndex("content");
            while (cursor.moveToNext()) {
                arrayList.add(new p(cursor.getLong(columnIndex), cursor.getString(columnIndex2), cursor.getString(columnIndex3)));
            }
        }
        return arrayList;
    }
}
