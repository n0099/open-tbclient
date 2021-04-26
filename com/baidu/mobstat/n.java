package com.baidu.mobstat;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class n extends j {
    public n() {
        super("ap_list3", "Create table if not exists ap_list3(_id Integer primary key AUTOINCREMENT,time VARCHAR(50),content TEXT);");
    }

    @Override // com.baidu.mobstat.j
    public ArrayList<i> a(int i2, int i3) {
        Cursor a2 = a("time", i2, i3);
        ArrayList<i> a3 = a(a2);
        if (a2 != null) {
            a2.close();
        }
        return a3;
    }

    @Override // com.baidu.mobstat.j
    public boolean b(long j) {
        return a(j);
    }

    @Override // com.baidu.mobstat.j
    public long a(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("time", str);
        contentValues.put("content", str2);
        return a(contentValues);
    }

    private ArrayList<i> a(Cursor cursor) {
        ArrayList<i> arrayList = new ArrayList<>();
        if (cursor == null || cursor.getCount() == 0) {
            return arrayList;
        }
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("time");
        int columnIndex3 = cursor.getColumnIndex("content");
        while (cursor.moveToNext()) {
            arrayList.add(new i(cursor.getLong(columnIndex), cursor.getString(columnIndex2), cursor.getString(columnIndex3)));
        }
        return arrayList;
    }
}
