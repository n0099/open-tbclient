package com.baidu.ar.statistic;

import android.content.Context;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Scanner;
/* loaded from: classes11.dex */
class d extends ArrayList<a> {
    private boolean rQ = false;
    private WeakReference<Context> uW;
    private String vi;
    private int vj;
    private int vk;

    public d(Context context, String str, int i, int i2) {
        this.uW = new WeakReference<>(context);
        this.vj = i;
        this.vi = str;
        this.vk = i2;
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    private void eY() {
        Context context;
        Scanner scanner;
        FileInputStream fileInputStream;
        a az;
        FileInputStream fileInputStream2 = null;
        if (this.vk <= 0 || (context = this.uW.get()) == null || !context.getFileStreamPath(this.vi).exists()) {
            return;
        }
        try {
            fileInputStream = context.openFileInput(this.vi);
            try {
                scanner = new Scanner(fileInputStream, "utf-8");
                while (scanner.hasNextLine()) {
                    try {
                        String nextLine = scanner.nextLine();
                        if (nextLine != null && !nextLine.isEmpty() && (az = a.az(nextLine)) != null) {
                            add(az);
                        }
                    } catch (Exception e) {
                        e = e;
                        fileInputStream2 = fileInputStream;
                        try {
                            e.printStackTrace();
                            a(fileInputStream2);
                            a(scanner);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            a(fileInputStream);
                            a(scanner);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        a(fileInputStream);
                        a(scanner);
                        throw th;
                    }
                }
                a(fileInputStream);
                a(scanner);
            } catch (Exception e2) {
                e = e2;
                scanner = null;
                fileInputStream2 = fileInputStream;
            } catch (Throwable th3) {
                th = th3;
                scanner = null;
            }
        } catch (Exception e3) {
            e = e3;
            scanner = null;
        } catch (Throwable th4) {
            th = th4;
            scanner = null;
            fileInputStream = null;
        }
    }

    public void N(int i) {
        if (i > 0) {
            a[] aVarArr = new a[i];
            for (int i2 = 0; i2 < i; i2++) {
                aVarArr[i2] = get(i2);
            }
            removeRange(0, i);
            a.a(aVarArr);
        }
    }

    public void eX() {
        if (this.rQ) {
            return;
        }
        eY();
        this.rQ = true;
    }

    public void flush() {
        Context context;
        Closeable closeable;
        if (this.vk <= 0 || (context = this.uW.get()) == null) {
            return;
        }
        int size = size();
        Closeable closeable2 = null;
        try {
            try {
                FileOutputStream openFileOutput = context.openFileOutput(this.vi, 0);
                if (size > 0) {
                    try {
                        if (size > this.vk) {
                            size = this.vk;
                        }
                        for (int i = 0; i < size; i++) {
                            openFileOutput.write((a.b((a) get(i)) + "\n").getBytes("utf-8"));
                        }
                    } catch (Exception e) {
                        e = e;
                        closeable = openFileOutput;
                        try {
                            e.printStackTrace();
                            a(closeable);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            closeable2 = closeable;
                            a(closeable2);
                            throw th;
                        }
                    }
                }
                a(openFileOutput);
            } catch (Throwable th2) {
                th = th2;
                a(closeable2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            closeable = null;
        }
    }

    public void k(a aVar) {
        if (size() < this.vj) {
            add(aVar);
        }
    }
}
