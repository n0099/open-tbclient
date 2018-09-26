package cn.jpush.android.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
/* loaded from: classes3.dex */
public abstract class f extends SQLiteOpenHelper {
    private volatile int a;
    private volatile int b;
    private volatile SQLiteDatabase c;
    private volatile SQLiteDatabase d;
    private final Object e;
    private final Object f;
    private final Context g;
    private final String h;
    private final int i;
    private final SQLiteDatabase.CursorFactory j;

    public f(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.a = 0;
        this.b = 0;
        this.e = new Object();
        this.f = new Object();
        this.g = context;
        this.h = str;
        this.i = 1;
        this.j = null;
    }

    public final boolean a(boolean z) {
        try {
            if (z) {
                synchronized (this.e) {
                    getWritableDatabase();
                    this.b++;
                }
            } else {
                synchronized (this.f) {
                    getReadableDatabase();
                    this.a++;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
        if (r3 <= 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0047, code lost:
        if (r3 <= 0) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(boolean z) {
        boolean z2 = false;
        if (z) {
            synchronized (this.e) {
                if (this.d != null && this.d.isOpen()) {
                    int i = this.b - 1;
                    this.b = i;
                }
                z2 = true;
                if (z2) {
                    this.b = 0;
                    if (this.d != null) {
                        this.d.close();
                    }
                    this.d = null;
                }
            }
            return;
        }
        synchronized (this.f) {
            if (this.c != null && this.c.isOpen()) {
                int i2 = this.a - 1;
                this.a = i2;
            }
            z2 = true;
            if (z2) {
                this.a = 0;
                if (this.c != null) {
                    this.c.close();
                }
                this.c = null;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    @Deprecated
    public void close() {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        if (this.c == null || !this.c.isOpen()) {
            synchronized (this.f) {
                if (this.c == null || !this.c.isOpen()) {
                    try {
                        getWritableDatabase();
                    } catch (SQLiteException e) {
                    }
                    String path = this.g.getDatabasePath(this.h).getPath();
                    this.c = SQLiteDatabase.openDatabase(path, this.j, 1);
                    if (this.c.getVersion() != this.i) {
                        throw new SQLiteException("Can't upgrade read-only database from version " + this.c.getVersion() + " to " + this.i + ": " + path);
                    }
                    this.a = 0;
                    onOpen(this.c);
                }
            }
        }
        return this.c;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        if (this.d == null || !this.d.isOpen()) {
            synchronized (this.e) {
                if (this.d == null || !this.d.isOpen()) {
                    this.b = 0;
                    this.d = super.getWritableDatabase();
                    if (Build.VERSION.SDK_INT >= 11) {
                        this.d.enableWriteAheadLogging();
                    }
                }
            }
        }
        return this.d;
    }
}
