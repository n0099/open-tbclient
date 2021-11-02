package b.a.e.a.k;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: b.a.e.a.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0023a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    boolean dropDatabase(Context context);

    SQLiteDatabase getWritableDatabase();

    void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3);

    void setOnCreateCallback(InterfaceC0023a interfaceC0023a);
}
