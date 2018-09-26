package cn.jiguang.a.a.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class d {
    HandlerThread a;
    Handler b;
    private int c;
    private String d;

    public d(String str, int i) {
        this.a = null;
        this.b = null;
        this.c = i;
        this.d = str;
        this.a = new HandlerThread("ping timer");
        this.a.start();
        this.b = new Handler(this.a.getLooper(), new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(byte[] bArr, int i, int i2) {
        Process process = null;
        byte[] bArr2 = {bArr[0], bArr[1], bArr[2], 0};
        Thread currentThread = Thread.currentThread();
        while (i < i2) {
            bArr2[3] = (byte) i;
            if (bArr2[3] != bArr[3]) {
                try {
                    String a = c.a(bArr2);
                    if (!a.equalsIgnoreCase(this.d)) {
                        this.b.removeCallbacksAndMessages(null);
                        Message obtainMessage = this.b.obtainMessage(1);
                        obtainMessage.obj = currentThread;
                        Bundle bundle = new Bundle();
                        bundle.putString("ip", a);
                        obtainMessage.setData(bundle);
                        this.b.sendMessageDelayed(obtainMessage, this.c);
                        process = c.B("ping -c 1 -w 1 " + a);
                        if (process != null) {
                            try {
                                process.exitValue();
                            } catch (Exception e) {
                                try {
                                    process.destroy();
                                } catch (Exception e2) {
                                }
                            }
                        }
                    } else if (process != null) {
                        try {
                            process.exitValue();
                        } catch (Exception e3) {
                            try {
                                process.destroy();
                            } catch (Exception e4) {
                            }
                        }
                    }
                } catch (Throwable th) {
                    if (process != null) {
                        try {
                            process.exitValue();
                        } catch (Exception e5) {
                            try {
                                process.destroy();
                            } catch (Exception e6) {
                            }
                        }
                    }
                    throw th;
                }
            }
            i++;
        }
    }

    public final void a(byte[] bArr, int i, int i2) {
        b(bArr, 0, 255);
        this.a.quit();
    }
}
