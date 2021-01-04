package com.baidu.mobads.openad.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private i f3444a;

    /* renamed from: b  reason: collision with root package name */
    private String f3445b;

    public g(Context context) {
        this.f3444a = new i(context);
        this.f3445b = XAdSDKFoundationFacade.getInstance().getSystemUtils().getCurrentProcessName(context);
    }

    public boolean a(String str, String str2) {
        Cursor rawQuery = this.f3444a.getReadableDatabase().rawQuery("select count(*)  from download_info where url=? and local_file=? and process_name=?", new String[]{str, str2, this.f3445b});
        rawQuery.moveToFirst();
        int i = rawQuery.getInt(0);
        rawQuery.close();
        return i > 0;
    }

    public void a(List<h> list) {
        SQLiteDatabase writableDatabase = this.f3444a.getWritableDatabase();
        for (h hVar : list) {
            try {
                writableDatabase.execSQL("insert into download_info(thread_id,url,local_file,start_pos,end_pos,compelete_size,process_name) values (?,?,?,?,?,?,?)", new Object[]{Integer.valueOf(hVar.c()), hVar.b(), hVar.f(), Integer.valueOf(hVar.d()), Integer.valueOf(hVar.e()), Integer.valueOf(hVar.a()), this.f3445b});
            } catch (Exception e) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSqlLiteAccessObj", e.getMessage());
            }
        }
    }

    public List<h> b(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.f3444a.getReadableDatabase().rawQuery("select thread_id, url, local_file, start_pos, end_pos,compelete_size from download_info where url=? and local_file=? and process_name=?", new String[]{str, str2, this.f3445b});
        while (rawQuery.moveToNext()) {
            arrayList.add(new h(rawQuery.getInt(0), rawQuery.getString(1), rawQuery.getString(2), rawQuery.getInt(3), rawQuery.getInt(4), rawQuery.getInt(5)));
        }
        rawQuery.close();
        return arrayList;
    }

    public void b(List<h> list) {
        SQLiteDatabase readableDatabase = this.f3444a.getReadableDatabase();
        for (h hVar : list) {
            try {
                readableDatabase.execSQL("update download_info set compelete_size=? where thread_id=? and url=? and local_file=? and process_name=?", new Object[]{Integer.valueOf(hVar.a()), Integer.valueOf(hVar.c()), hVar.b(), hVar.f(), this.f3445b});
            } catch (Exception e) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSqlLiteAccessObj", e.getMessage());
            }
        }
    }
}
