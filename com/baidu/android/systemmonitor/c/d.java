package com.baidu.android.systemmonitor.c;

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
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f663a = d.class.getSimpleName();
    private final Context b;
    private final String c;
    private final SQLiteDatabase.CursorFactory d;
    private final int e;
    private SQLiteDatabase f = null;
    private boolean g = false;

    public d(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        if (i < 1) {
            throw new IllegalArgumentException("Version must be >= 1, was " + i);
        }
        this.b = context;
        this.c = str;
        this.d = cursorFactory;
        this.e = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0116 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003f A[Catch: all -> 0x0170, TRY_LEAVE, TryCatch #1 {all -> 0x0170, blocks: (B:24:0x0037, B:26:0x003f, B:30:0x004f, B:31:0x0052, B:28:0x0044, B:29:0x0047, B:92:0x0164), top: B:104:0x0037 }] */
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
                                Log.i(f663a, "--- Get sync db, version=" + openDatabase.getVersion() + ", curversion=" + this.e);
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
                                Log.e(f663a, "Oops! That's impossible : \r\n", e);
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
                    try {
                        version = openOrCreateDatabase.getVersion();
                        if (version != this.e) {
                            openOrCreateDatabase.beginTransaction();
                            if (version == 0) {
                                a(openOrCreateDatabase);
                            } else {
                                a(openOrCreateDatabase, version, this.e);
                            }
                            openOrCreateDatabase.setVersion(this.e);
                            openOrCreateDatabase.setTransactionSuccessful();
                            openOrCreateDatabase.endTransaction();
                        }
                        b(openOrCreateDatabase);
                        this.g = false;
                        if (this.f != null) {
                            try {
                                this.f.close();
                            } catch (Exception e6) {
                            }
                        }
                        this.f = openOrCreateDatabase;
                    } catch (Throwable th) {
                        sQLiteDatabase = openOrCreateDatabase;
                        th = th;
                        this.g = false;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase = null;
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
