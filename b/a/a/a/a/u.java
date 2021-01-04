package b.a.a.a.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
/* loaded from: classes3.dex */
public final class u implements Runnable {
    final w AU;
    volatile Handler d;
    long e;
    long f;

    /* renamed from: b  reason: collision with root package name */
    final LinkedBlockingQueue f1078b = new LinkedBlockingQueue(3);

    /* renamed from: a  reason: collision with root package name */
    volatile boolean f1077a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(w wVar) {
        this.AU = wVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://lbs.map.qq.com/loc");
        sb.append("?c=1");
        sb.append("&mars=0");
        sb.append("&obs=").append(i);
        return sb.toString();
    }

    private void a(v vVar) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        if (vVar == null) {
            return;
        }
        v.e(vVar);
        Iterator it = this.f1078b.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            i3 = ((v) it.next()).e;
            i4 = vVar.e;
            if (i3 == i4) {
                z = true;
                break;
            }
        }
        i = vVar.h;
        if (i <= 0 || z) {
            return;
        }
        StringBuilder sb = new StringBuilder("retryIfNeed: times=");
        i2 = vVar.h;
        sb.append(i2);
        this.f1078b.offer(vVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        try {
            deflaterOutputStream.write(bArr, 0, bArr.length);
            deflaterOutputStream.finish();
            deflaterOutputStream.flush();
            try {
                deflaterOutputStream.close();
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
            try {
                deflaterOutputStream.close();
            } catch (Throwable th3) {
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private void b() {
        this.e = 0L;
        this.f = 0L;
    }

    private static byte[] b(byte[] bArr) {
        byte[] bArr2;
        int i = 0;
        if (bArr == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
        byte[] bArr3 = new byte[0];
        byte[] bArr4 = new byte[1024];
        while (true) {
            try {
                int read = inflaterInputStream.read(bArr4);
                if (read > 0) {
                    i += read;
                    bArr2 = new byte[i];
                    System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
                    System.arraycopy(bArr4, 0, bArr2, bArr3.length, read);
                } else {
                    bArr2 = bArr3;
                }
                if (read <= 0) {
                    try {
                        byteArrayInputStream.close();
                        inflaterInputStream.close();
                        return bArr2;
                    } catch (IOException e) {
                        return null;
                    }
                }
                bArr3 = bArr2;
            } catch (Exception e2) {
                return null;
            }
        }
    }

    public final void a() {
        if (this.f1077a) {
            this.f1077a = false;
            this.f1078b.clear();
            this.f1078b.offer(v.AV);
            this.d = null;
            b();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        v vVar;
        long j;
        String str;
        byte[] bArr;
        int i;
        int i2;
        LinkedBlockingQueue linkedBlockingQueue = this.f1078b;
        while (this.f1077a) {
            try {
                try {
                    vVar = (v) linkedBlockingQueue.take();
                    try {
                    } catch (IOException e) {
                        j = 0;
                    }
                } catch (IOException e2) {
                    vVar = null;
                    j = 0;
                }
            } catch (InterruptedException e3) {
            } catch (Throwable th) {
            }
            if (v.AV == vVar) {
                return;
            }
            new StringBuilder("request:").append(vVar.f1080b);
            j = System.currentTimeMillis();
            try {
                str = vVar.g;
                bArr = vVar.f;
                Bundle d = o.d(str, bArr);
                byte[] byteArray = d.getByteArray("data_bytes");
                i = vVar.e;
                if (i == 1 && byteArray != null) {
                    byteArray = b(byteArray);
                }
                String str2 = byteArray != null ? new String(byteArray, d.getString("data_charset")) : "{}";
                d.remove("data_charset");
                d.remove("data_bytes");
                d.putString("result", str2);
                String string = d.getString("result");
                long currentTimeMillis = System.currentTimeMillis() - j;
                new StringBuilder("cost:").append(currentTimeMillis).append(",result:").append(string);
                vVar.c = j;
                i2 = vVar.e;
                if (1 != i2) {
                    continue;
                } else if ("{}".equals(string)) {
                    throw new IOException("loc result is \"{}\"");
                    break;
                } else if (this.d != null) {
                    Message obtainMessage = this.d.obtainMessage(2003);
                    obtainMessage.arg1 = (int) currentTimeMillis;
                    obtainMessage.obj = Pair.create(string, vVar);
                    obtainMessage.sendToTarget();
                }
            } catch (IOException e4) {
                new StringBuilder("cost:").append(System.currentTimeMillis() - j).append(",run: io error");
                a(vVar);
                if (this.d != null) {
                    this.d.sendEmptyMessageDelayed(2004, 0L);
                }
            }
        }
    }
}
