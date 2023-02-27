package com.baidu.ar.statistic;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Scanner;
/* loaded from: classes.dex */
public class d extends ArrayList<a> {
    public boolean sM = false;
    public int wA;
    public int wB;
    public WeakReference<Context> wn;
    public String wz;

    public d(Context context, String str, int i, int i2) {
        this.wn = new WeakReference<>(context);
        this.wA = i;
        this.wz = str;
        this.wB = i2;
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0048 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x0067 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x0060 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.baidu.ar.statistic.d, java.util.ArrayList] */
    private void gm() {
        Context context;
        Closeable closeable;
        Throwable th;
        Scanner scanner;
        Exception e;
        a aG;
        if (this.wB > 0 && (context = this.wn.get()) != 0 && context.getFileStreamPath(this.wz).exists()) {
            try {
                try {
                    context = context.openFileInput(this.wz);
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    scanner = new Scanner((InputStream) context, IMAudioTransRequest.CHARSET);
                    while (scanner.hasNextLine()) {
                        try {
                            String nextLine = scanner.nextLine();
                            if (nextLine != null && !nextLine.isEmpty() && (aG = a.aG(nextLine)) != null) {
                                add(aG);
                            }
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            a(context);
                            a(scanner);
                        }
                    }
                } catch (Exception e3) {
                    scanner = null;
                    e = e3;
                } catch (Throwable th3) {
                    closeable = null;
                    th = th3;
                    a(context);
                    a(closeable);
                    throw th;
                }
            } catch (Exception e4) {
                scanner = null;
                e = e4;
                context = 0;
            } catch (Throwable th4) {
                closeable = null;
                th = th4;
                context = 0;
            }
            a(context);
            a(scanner);
        }
    }

    public void S(int i) {
        if (i > 0) {
            a[] aVarArr = new a[i];
            for (int i2 = 0; i2 < i; i2++) {
                aVarArr[i2] = get(i2);
            }
            removeRange(0, i);
            a.a(aVarArr);
        }
    }

    public void flush() {
        Context context;
        if (this.wB > 0 && (context = this.wn.get()) != null) {
            int size = size();
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    fileOutputStream = context.openFileOutput(this.wz, 0);
                    if (size > 0) {
                        if (size > this.wB) {
                            size = this.wB;
                        }
                        for (int i = 0; i < size; i++) {
                            fileOutputStream.write((a.b((a) get(i)) + "\n").getBytes(IMAudioTransRequest.CHARSET));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                a(fileOutputStream);
            }
        }
    }

    public void gl() {
        if (this.sM) {
            return;
        }
        gm();
        this.sM = true;
    }

    public void k(a aVar) {
        if (size() < this.wA) {
            add(aVar);
        }
    }
}
