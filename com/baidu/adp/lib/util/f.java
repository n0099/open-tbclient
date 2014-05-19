package com.baidu.adp.lib.util;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(String str) {
        this.a = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008e A[Catch: Exception -> 0x0092, TRY_LEAVE, TryCatch #6 {Exception -> 0x0092, blocks: (B:25:0x0089, B:27:0x008e), top: B:48:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        BufferedWriter bufferedWriter;
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        File d = c.d("log_" + g.a(new Date()));
        if (d != null) {
            try {
                fileWriter = new FileWriter(d, true);
                try {
                    bufferedWriter = new BufferedWriter(fileWriter);
                    try {
                        bufferedWriter.write(String.valueOf(g.a(currentTimeMillis)) + "\t\t" + this.a);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    } catch (Exception e) {
                        e = e;
                        fileWriter2 = fileWriter;
                        try {
                            Log.d("BaiduLog", e.getMessage());
                            if (fileWriter2 != null) {
                                try {
                                    fileWriter2.close();
                                } catch (Exception e2) {
                                    Log.d("BaiduLog", e2.getMessage());
                                    return;
                                }
                            }
                            if (bufferedWriter != null) {
                                bufferedWriter.close();
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            fileWriter = fileWriter2;
                            if (fileWriter != null) {
                                try {
                                    fileWriter.close();
                                } catch (Exception e3) {
                                    Log.d("BaiduLog", e3.getMessage());
                                    throw th;
                                }
                            }
                            if (bufferedWriter != null) {
                                bufferedWriter.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileWriter != null) {
                        }
                        if (bufferedWriter != null) {
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    bufferedWriter = null;
                    fileWriter2 = fileWriter;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedWriter = null;
                }
            } catch (Exception e5) {
                e = e5;
                bufferedWriter = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedWriter = null;
                fileWriter = null;
            }
        } else {
            bufferedWriter = null;
            fileWriter = null;
        }
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (Exception e6) {
                Log.d("BaiduLog", e6.getMessage());
                return;
            }
        }
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
    }
}
