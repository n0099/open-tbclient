package com.baidu.mobstat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class m extends j {
    public m(Context context) {
        super(context, "ap_list3", "Create table if not exists ap_list3(_id Integer primary key AUTOINCREMENT,time VARCHAR(50),content TEXT);");
    }

    @Override // com.baidu.mobstat.j
    public boolean b(long j) {
        return a(j);
    }

    private ArrayList<i> a(Cursor cursor) {
        ArrayList<i> arrayList = new ArrayList<>();
        if (cursor == null) {
            return arrayList;
        }
        if (cursor.getCount() == 0) {
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

    @Override // com.baidu.mobstat.j
    public long a(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("time", str);
        contentValues.put("content", str2);
        return a(contentValues);
    }

    @Override // com.baidu.mobstat.j
    public ArrayList<i> a(int i, int i2) {
        Cursor a = a("time", i, i2);
        ArrayList<i> a2 = a(a);
        if (a != null) {
            a.close();
        }
        return a2;
    }
}
