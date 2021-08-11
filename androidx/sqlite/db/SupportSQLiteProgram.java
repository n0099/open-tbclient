package androidx.sqlite.db;

import java.io.Closeable;
/* loaded from: classes.dex */
public interface SupportSQLiteProgram extends Closeable {
    void bindBlob(int i2, byte[] bArr);

    void bindDouble(int i2, double d2);

    void bindLong(int i2, long j2);

    void bindNull(int i2);

    void bindString(int i2, String str);

    void clearBindings();
}
