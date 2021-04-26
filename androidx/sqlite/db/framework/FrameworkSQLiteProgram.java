package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;
/* loaded from: classes.dex */
public class FrameworkSQLiteProgram implements SupportSQLiteProgram {
    public final SQLiteProgram mDelegate;

    public FrameworkSQLiteProgram(SQLiteProgram sQLiteProgram) {
        this.mDelegate = sQLiteProgram;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i2, byte[] bArr) {
        this.mDelegate.bindBlob(i2, bArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i2, double d2) {
        this.mDelegate.bindDouble(i2, d2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i2, long j) {
        this.mDelegate.bindLong(i2, j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i2) {
        this.mDelegate.bindNull(i2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i2, String str) {
        this.mDelegate.bindString(i2, str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.mDelegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mDelegate.close();
    }
}
