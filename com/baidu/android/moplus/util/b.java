package com.baidu.android.moplus.util;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public final class b {
    private static final String b = b.class.getSimpleName();
    private static b c;
    Process a = null;
    private boolean d = false;
    private DataOutputStream e;
    private DataInputStream f;

    private b(Context context) {
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (c == null) {
                c = new b(context);
            }
            bVar = c;
        }
        return bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0097, code lost:
        r0 = "ERROR_" + r1.substring(r1.indexOf("[") + 1, r1.indexOf("]"));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String a(String str) {
        String str2;
        str2 = "fail";
        if (this.a != null && this.d) {
            try {
                if (this.e == null) {
                    this.e = new DataOutputStream(this.a.getOutputStream());
                }
                if (this.e != null) {
                    this.e.write((str + IOUtils.LINE_SEPARATOR_UNIX).getBytes("utf-8"));
                    this.e.flush();
                    if (this.f == null) {
                        this.f = new DataInputStream(this.a.getInputStream());
                    }
                    while (true) {
                        String readLine = this.f.readLine();
                        if (readLine != null) {
                            if (!readLine.toLowerCase().contains(ImagesInvalidReceiver.SUCCESS)) {
                                if (!readLine.toLowerCase().contains("failure")) {
                                    if (!TextUtils.isEmpty(readLine) && readLine.toLowerCase().contains("fault")) {
                                        str2 = "fail";
                                        break;
                                    } else if (!TextUtils.isEmpty(readLine) && readLine.toLowerCase().contains("no such file or directory")) {
                                        str2 = "fail";
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                str2 = ImagesInvalidReceiver.SUCCESS;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                str2 = "fail";
            }
            if (!str2.equals(ImagesInvalidReceiver.SUCCESS) && str2.indexOf("ERROR_") < 0) {
                c();
            }
        }
        return str2;
    }

    public synchronized boolean a() {
        boolean z = true;
        synchronized (this) {
            if (!b()) {
                try {
                    if (this.e != null) {
                        try {
                            this.e.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        this.e = null;
                    }
                    if (this.f != null) {
                        try {
                            this.f.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        this.f = null;
                    }
                    this.a = new ProcessBuilder(new String[0]).command("su").redirectErrorStream(true).start();
                    OutputStream outputStream = this.a.getOutputStream();
                    InputStream inputStream = this.a.getInputStream();
                    if (outputStream != null && inputStream != null) {
                        this.e = new DataOutputStream(outputStream);
                        this.f = new DataInputStream(inputStream);
                        this.e.writeBytes("id\n");
                        this.e.flush();
                        this.d = false;
                        while (true) {
                            String readLine = this.f.readLine();
                            if (readLine != null) {
                                if (!readLine.toLowerCase().contains("uid=0")) {
                                    if (!TextUtils.isEmpty(readLine)) {
                                        this.d = false;
                                        break;
                                    }
                                } else {
                                    this.d = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (this.d) {
                            this.e.writeBytes("export LD_LIBRARY_PATH=/vendor/lib:/system/lib\n");
                            this.e.flush();
                        }
                    }
                } catch (Exception e3) {
                    this.d = false;
                    e3.printStackTrace();
                }
                if (!this.d) {
                    c();
                }
                z = this.d;
            }
        }
        return z;
    }

    public boolean b() {
        if (this.a == null) {
            this.d = false;
        }
        return this.d;
    }

    public synchronized void c() {
        try {
            if (this.e != null) {
                this.e.close();
                this.e = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (this.f != null) {
                this.f.close();
                this.f = null;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (this.a != null) {
            try {
                Thread.sleep(3000L);
                this.a.destroy();
                this.a = null;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }
}
