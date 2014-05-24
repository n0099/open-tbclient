package com.baidu.android.defense;

import android.content.Context;
import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class b extends Thread {
    private static final String a = b.class.getSimpleName();
    private Context b;

    public b(Context context, String str) {
        setName("moplus UninstallAPKBySUThread");
        this.b = context;
        a(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str) {
        boolean z;
        boolean z2 = true;
        boolean z3 = false;
        if (str == null) {
            return;
        }
        Process process = null;
        try {
            try {
                process = Runtime.getRuntime().exec("su");
                OutputStream outputStream = process.getOutputStream();
                if (outputStream != null) {
                    DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                    dataOutputStream.writeBytes("export LD_LIBRARY_PATH=/vendor/lib:/system/lib\n");
                    dataOutputStream.flush();
                    dataOutputStream.write(("pm uninstall " + str + IOUtils.LINE_SEPARATOR_UNIX).getBytes("utf-8"));
                    dataOutputStream.flush();
                    dataOutputStream.writeBytes("exit\n");
                    dataOutputStream.flush();
                    if (process.waitFor() == 0) {
                        try {
                            DataInputStream dataInputStream = new DataInputStream(process.getInputStream());
                            while (true) {
                                String readLine = dataInputStream.readLine();
                                if (readLine == null) {
                                    z = false;
                                    break;
                                } else if (readLine.toLowerCase().contains(ImagesInvalidReceiver.SUCCESS)) {
                                    z = true;
                                    break;
                                }
                            }
                            dataInputStream.close();
                        } catch (IOException e) {
                            e = e;
                            z2 = false;
                            e.printStackTrace();
                            if (process != null && z2) {
                                try {
                                    Thread.sleep(3000L);
                                    process.destroy();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if (z3) {
                            }
                        } catch (InterruptedException e3) {
                            e = e3;
                            z2 = false;
                            e.printStackTrace();
                            if (process != null && z2) {
                                try {
                                    Thread.sleep(3000L);
                                    process.destroy();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (z3) {
                            }
                        } catch (Exception e5) {
                            e = e5;
                            z2 = false;
                            e.printStackTrace();
                            if (process != null && z2) {
                                try {
                                    Thread.sleep(3000L);
                                    process.destroy();
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                }
                            }
                            if (z3) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            z2 = false;
                            if (process != null && z2) {
                                try {
                                    Thread.sleep(3000L);
                                    process.destroy();
                                } catch (Exception e7) {
                                    e7.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } else {
                        z = false;
                    }
                    dataOutputStream.close();
                    z2 = false;
                    z3 = z;
                }
                if (process != null && z2) {
                    try {
                        Thread.sleep(3000L);
                        process.destroy();
                    } catch (Exception e8) {
                        e8.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e9) {
            e = e9;
        } catch (InterruptedException e10) {
            e = e10;
        } catch (Exception e11) {
            e = e11;
        }
        if (z3) {
            com.baidu.android.systemmonitor.c.c.d(this.b, str);
        }
    }
}
