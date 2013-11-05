package com.baidu.android.systemmonitor.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f753a = b.class.getSimpleName();
    private final Context b;
    private final String c;
    private final SQLiteDatabase.CursorFactory d;
    private final int e;
    private SQLiteDatabase f = null;
    private boolean g = false;

    public b(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        if (i < 1) {
            throw new IllegalArgumentException("Version must be >= 1, was " + i);
        }
        this.b = context;
        this.c = str;
        this.d = cursorFactory;
        this.e = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0116 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003f A[Catch: Exception -> 0x017c, all -> 0x0183, TRY_LEAVE, TryCatch #12 {Exception -> 0x017c, all -> 0x0183, blocks: (B:24:0x0037, B:26:0x003f, B:30:0x004f, B:99:0x0178, B:100:0x017b, B:31:0x0052), top: B:126:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x016c A[Catch: all -> 0x0028, TryCatch #4 {, blocks: (B:4:0x0004, B:6:0x0008, B:8:0x0010, B:10:0x0018, B:13:0x001c, B:15:0x0020, B:16:0x0027, B:33:0x0056, B:35:0x005c, B:36:0x0061, B:92:0x0168, B:94:0x016c, B:95:0x016f), top: B:114:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized SQLiteDatabase a() {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase openOrCreateDatabase;
        boolean z;
        SQLiteDatabase openDatabase;
        File file;
        long j;
        int version;
        SQLiteDatabase sQLiteDatabase2 = null;
        boolean z2 = false;
        synchronized (this) {
            if (this.f != null && this.f.isOpen() && !this.f.isReadOnly()) {
                openOrCreateDatabase = this.f;
            } else if (this.g) {
                throw new IllegalStateException("getWritableDatabase called recursively");
            } else {
                try {
                    this.g = true;
                    if (this.c == null) {
                        openOrCreateDatabase = SQLiteDatabase.create(null);
                    } else {
                        long j2 = 0;
                        File file2 = null;
                        for (ResolveInfo resolveInfo : com.baidu.android.moplus.util.b.g(this.b)) {
                            if (!TextUtils.equals(resolveInfo.activityInfo.packageName, this.b.getPackageName())) {
                                try {
                                    file = this.b.createPackageContext(resolveInfo.activityInfo.packageName, 0).getDatabasePath(this.c);
                                } catch (PackageManager.NameNotFoundException e) {
                                    e.printStackTrace();
                                }
                                if (file.isFile()) {
                                    long lastModified = file.lastModified();
                                    if (lastModified > j2) {
                                        j = lastModified;
                                        j2 = j;
                                        file2 = file;
                                    }
                                }
                                file = file2;
                                j = j2;
                                j2 = j;
                                file2 = file;
                            }
                        }
                        File databasePath = this.b.getDatabasePath(this.c);
                        if (file2 != null && (!databasePath.isFile() || file2.lastModified() > databasePath.lastModified())) {
                            try {
                                openDatabase = SQLiteDatabase.openDatabase(file2.getPath(), null, 0);
                                Log.i(f753a, "--- Get sync db, version=" + openDatabase.getVersion() + ", curversion=" + this.e);
                            } catch (SQLiteException e2) {
                                e = e2;
                                z = false;
                            }
                            try {
                                if (openDatabase != null) {
                                    if (openDatabase.getVersion() == this.e) {
                                        z = true;
                                        openDatabase.close();
                                        z2 = z;
                                    }
                                }
                                openDatabase.close();
                                z2 = z;
                            } catch (SQLiteException e3) {
                                e = e3;
                                Log.e(f753a, "Oops! That's impossible : \r\n", e);
                                z2 = z;
                                if (z2) {
                                }
                                openOrCreateDatabase = this.b.openOrCreateDatabase(this.c, 1, this.d);
                                version = openOrCreateDatabase.getVersion();
                                if (version != this.e) {
                                }
                                b(openOrCreateDatabase);
                                this.g = false;
                                if (this.f != null) {
                                }
                                this.f = openOrCreateDatabase;
                                return openOrCreateDatabase;
                            }
                            z = false;
                        }
                        if (z2) {
                            try {
                                FileInputStream fileInputStream = new FileInputStream(file2);
                                FileOutputStream fileOutputStream = new FileOutputStream(databasePath);
                                byte[] bArr = new byte[100];
                                while (fileInputStream.read(bArr) > 0) {
                                    fileOutputStream.write(bArr);
                                }
                                fileOutputStream.flush();
                                fileInputStream.close();
                                fileOutputStream.close();
                            } catch (FileNotFoundException e4) {
                                e4.printStackTrace();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        openOrCreateDatabase = this.b.openOrCreateDatabase(this.c, 1, this.d);
                    }
                } catch (Exception e6) {
                    e = e6;
                    sQLiteDatabase = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    version = openOrCreateDatabase.getVersion();
                    if (version != this.e) {
                        openOrCreateDatabase.beginTransaction();
                        try {
                            if (version == 0) {
                                a(openOrCreateDatabase);
                            } else {
                                a(openOrCreateDatabase, version, this.e);
                            }
                            openOrCreateDatabase.setVersion(this.e);
                            openOrCreateDatabase.setTransactionSuccessful();
                        } finally {
                            openOrCreateDatabase.endTransaction();
                        }
                    }
                    b(openOrCreateDatabase);
                    this.g = false;
                    if (this.f != null) {
                        try {
                            this.f.close();
                        } catch (Exception e7) {
                        }
                    }
                    this.f = openOrCreateDatabase;
                } catch (Exception e8) {
                    sQLiteDatabase = openOrCreateDatabase;
                    e = e8;
                    try {
                        throw new SQLiteException(e.getMessage());
                    } catch (Throwable th2) {
                        th = th2;
                        sQLiteDatabase2 = sQLiteDatabase;
                        this.g = false;
                        if (sQLiteDatabase2 != null) {
                            sQLiteDatabase2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    sQLiteDatabase2 = openOrCreateDatabase;
                    th = th3;
                    this.g = false;
                    if (sQLiteDatabase2 != null) {
                    }
                    throw th;
                }
            }
        }
        return openOrCreateDatabase;
    }

    public abstract void a(SQLiteDatabase sQLiteDatabase);

    public abstract void a(SQLiteDatabase sQLiteDatabase, int i, int i2);

    public synchronized SQLiteDatabase b() {
        return (this.f == null || !this.f.isOpen()) ? a() : this.f;
    }

    public void b(SQLiteDatabase sQLiteDatabase) {
    }

    public synchronized void c() {
        if (this.g) {
            throw new IllegalStateException("Closed during initialization");
        }
        if (this.f != null && this.f.isOpen()) {
            this.f.close();
            this.f = null;
        }
    }
}
