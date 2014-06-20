package com.baidu.android.defense.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.nebula.a.h;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
/* loaded from: classes.dex */
public class c implements Runnable {
    protected Context a;
    protected a b;
    protected String c;
    private int d = 2;
    private int e = 0;
    private boolean f = false;

    public c(Context context, a aVar) {
        this.a = context.getApplicationContext();
        this.b = aVar;
    }

    private boolean a(InputStream inputStream) {
        if (com.baidu.android.systemmonitor.util.b.c() <= this.b.c * FileUtils.ONE_MB) {
            return false;
        }
        this.c = this.b.a();
        if (TextUtils.isEmpty(this.c)) {
            return false;
        }
        File file = new File(this.c);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException e) {
            }
            fileOutputStream.close();
            return true;
        } catch (IOException e2) {
            return false;
        }
    }

    private void b() {
        boolean c;
        if (this.b == null || TextUtils.isEmpty(this.b.a) || TextUtils.isEmpty(this.b.b) || !h.a(this.a)) {
            return;
        }
        do {
            c = c();
            if (this.f) {
                d();
            }
            if (this.d <= 0) {
                break;
            }
        } while (this.f);
        if (c) {
            a();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:48:0x00a1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:52:0x00a8 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:60:0x000a */
    private boolean c() {
        Throwable th;
        boolean z;
        InputStream inputStream;
        InputStream inputStream2 = null;
        com.baidu.android.nebula.a.a aVar = new com.baidu.android.nebula.a.a(this.a);
        try {
            try {
                HttpResponse execute = aVar.execute(new HttpGet(this.b.a));
                if (execute.getStatusLine().getStatusCode() == 200) {
                    InputStream content = execute.getEntity().getContent();
                    if (content != null) {
                        try {
                            if (a(content)) {
                                inputStream = content;
                                z = true;
                            }
                        } catch (IOException e) {
                            z = false;
                            inputStream = content;
                            this.f = true;
                            aVar.a();
                            try {
                                inputStream.close();
                                inputStream2 = inputStream;
                            } catch (Exception e2) {
                                PrintStream printStream = System.out;
                                String message = e2.getMessage();
                                printStream.println(message);
                                inputStream2 = message;
                            }
                            return z;
                        } catch (Exception e3) {
                            z = false;
                            inputStream = content;
                            this.f = false;
                            aVar.a();
                            try {
                                inputStream.close();
                                inputStream2 = inputStream;
                            } catch (Exception e4) {
                                PrintStream printStream2 = System.out;
                                String message2 = e4.getMessage();
                                printStream2.println(message2);
                                inputStream2 = message2;
                            }
                            return z;
                        } catch (Throwable th2) {
                            inputStream2 = content;
                            th = th2;
                            aVar.a();
                            try {
                                inputStream2.close();
                            } catch (Exception e5) {
                                System.out.println(e5.getMessage());
                            }
                            throw th;
                        }
                    }
                    z = false;
                    inputStream = content;
                } else {
                    z = false;
                    inputStream = null;
                }
                try {
                    this.e = 0;
                    this.f = false;
                    aVar.a();
                    try {
                        inputStream.close();
                        inputStream2 = inputStream;
                    } catch (Exception e6) {
                        PrintStream printStream3 = System.out;
                        String message3 = e6.getMessage();
                        printStream3.println(message3);
                        inputStream2 = message3;
                    }
                } catch (IOException e7) {
                    this.f = true;
                    aVar.a();
                    inputStream.close();
                    inputStream2 = inputStream;
                    return z;
                } catch (Exception e8) {
                    this.f = false;
                    aVar.a();
                    inputStream.close();
                    inputStream2 = inputStream;
                    return z;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e9) {
            z = false;
            inputStream = null;
        } catch (Exception e10) {
            z = false;
            inputStream = null;
        } catch (Throwable th4) {
            inputStream2 = null;
            th = th4;
        }
        return z;
    }

    private void d() {
        this.e++;
        if (this.e >= this.d) {
            this.f = false;
            return;
        }
        try {
            Thread.sleep((this.e + 1) * 30);
        } catch (InterruptedException e) {
        }
    }

    protected void a() {
    }

    @Override // java.lang.Runnable
    public void run() {
        b();
    }
}
