package cn.jiguang.d.b;

import android.content.Context;
import android.net.http.Headers;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.beans.BeanDataCache;
import java.util.Deque;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
/* loaded from: classes3.dex */
public final class h {
    private static h lI;
    private Handler d;
    private Context e;
    private Map<String, i> a = new ConcurrentHashMap();
    private Deque<i> lG = new LinkedBlockingDeque();
    private Deque<i> lH = new LinkedBlockingDeque();

    private synchronized i K(String str) {
        i iVar;
        iVar = null;
        for (i iVar2 : this.lH) {
            if (str.equals(iVar2.a())) {
                this.lH.remove(iVar2);
            } else {
                iVar2 = iVar;
            }
            iVar = iVar2;
        }
        return iVar;
    }

    private synchronized void a(i iVar) {
        boolean z;
        if (iVar != null) {
            Iterator<i> it = this.lH.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().a().equals(iVar.a())) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                this.lH.offerLast(iVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(long j, String str) {
        return j + "|" + str;
    }

    private void b(i iVar) {
        if (iVar == null) {
            return;
        }
        this.a.remove(iVar.a());
        this.lG.remove(iVar);
        this.d.removeMessages(7403, iVar);
    }

    public static h bP() {
        if (lI == null) {
            lI = new h();
        }
        return lI;
    }

    private void c(i iVar) {
        if (iVar == null) {
            return;
        }
        this.d.removeMessages(7404, iVar);
    }

    private void f(i iVar) {
        if (iVar == null) {
            return;
        }
        try {
            byte[] a = cn.jiguang.d.e.a.a.b.a(cn.jiguang.d.e.a.a.b.a(cn.jiguang.d.a.d.a(), cn.jiguang.d.a.d.c(null), iVar.d), 1);
            if (a == null) {
                cn.jiguang.e.c.c("RequestCacheManager", "sendCommandWithLoggedIn failed:sendData is null");
            } else if (g.a.get() == 0) {
                cn.jiguang.e.c.c("RequestCacheManager", "sendCommandWithLoggedIn failed: tcp not connect");
            } else if (cn.jiguang.d.g.c.cf().cg().j(a) == 6026) {
                c(iVar);
                b(iVar);
                cn.jiguang.d.d.e.bT().a(this.e, iVar.f, iVar.c, iVar.e, 6026);
                return;
            }
        } catch (Throwable th) {
        }
        a(iVar);
        if (iVar != null) {
            this.d.sendMessageDelayed(Message.obtain(this.d, 7404, iVar), 9800L);
        }
    }

    public final void a(long j, String str, Object obj) {
        if (obj != null && (obj instanceof cn.jiguang.d.e.a.a.c)) {
            g.a.get();
            i K = K(b(((cn.jiguang.d.e.a.a.c) obj).cb().longValue(), str));
            if (K != null) {
                c(K);
                i iVar = this.a.get(K.a());
                if (iVar != null) {
                    b(iVar);
                }
            }
        }
    }

    public final void a(Context context, Handler handler) {
        this.e = context;
        this.d = handler;
    }

    public final void a(String str, Object obj) {
        Message obtain = Message.obtain(this.d, 7402, obj);
        Bundle bundle = new Bundle();
        bundle.putLong(Headers.CONN_DIRECTIVE, g.a.get());
        bundle.putString("request_sdktype", str);
        obtain.setData(bundle);
        obtain.sendToTarget();
    }

    public final void a(byte[] bArr, String str, int i) {
        if (bArr == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("request_timeout", i);
        bundle.putByteArray(BeanDataCache.KEY, bArr);
        bundle.putString("request_sdktype", str);
        Message obtain = Message.obtain(this.d, 7401);
        obtain.setData(bundle);
        obtain.sendToTarget();
    }

    public final void b() {
        this.d.removeMessages(7404);
        while (true) {
            i pollLast = this.lH.pollLast();
            if (pollLast == null) {
                return;
            }
            this.lG.offerFirst(pollLast);
        }
    }

    public final void b(byte[] bArr, String str, int i) {
        cn.jiguang.e.c.a("RequestCacheManager", "Action - sendRequestInternal - connection:" + g.a.get() + ", timeout:" + i + ",sdkType:" + str + ", threadId:" + Thread.currentThread().getId());
        if (bArr == null) {
            return;
        }
        if (this.a.size() > 200) {
            cn.jiguang.e.c.c("RequestCacheManager", "sendRequestInternal failed,cache is full");
            return;
        }
        i iVar = new i(bArr, str, i);
        this.a.put(iVar.a(), iVar);
        if (i > 10000) {
            this.d.sendMessageDelayed(Message.obtain(this.d, 7403, iVar), iVar.a);
        }
        f(iVar);
    }

    public final void c() {
        while (true) {
            i pollFirst = this.lG.pollFirst();
            if (pollFirst == null) {
                return;
            }
            if (pollFirst.e == 2) {
                this.lG.remove(pollFirst);
                this.a.remove(pollFirst.a());
            } else {
                f(pollFirst);
            }
        }
    }

    public final void d(i iVar) {
        if (iVar == null || K(iVar.a()) == null) {
            return;
        }
        if (iVar.a <= 0) {
            e(iVar);
            return;
        }
        d.bN();
        if (d.d()) {
            iVar.a -= 10000;
            iVar.b++;
            f(iVar);
        } else {
            this.lG.offerFirst(iVar);
        }
        if (iVar.b >= 2) {
            this.d.sendEmptyMessageDelayed(1005, 2000L);
        }
    }

    public final void e(i iVar) {
        if (iVar == null) {
            return;
        }
        b(iVar);
        cn.jiguang.d.d.e.bT();
        Context context = this.e;
        String str = iVar.f;
        long j = iVar.c;
        int i = iVar.e;
        if (TextUtils.isEmpty(str)) {
            cn.jiguang.d.d.e.b(context, j, i);
            return;
        }
        cn.jiguang.api.b bVar = cn.jiguang.d.d.e.a.get(str);
        if (bVar == null) {
            cn.jiguang.d.d.e.b(context, j, i);
        } else {
            bVar.dispatchTimeOutMessage(context, g.a.get(), j, i);
        }
    }
}
