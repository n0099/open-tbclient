package b.a.a.a.a;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.baidubce.http.Headers;
import com.kwad.sdk.collector.AppStatusRules;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class s extends Handler {
    private /* synthetic */ p AQ;

    /* renamed from: a  reason: collision with root package name */
    private int f1075a;

    /* renamed from: b  reason: collision with root package name */
    private long f1076b;
    private boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(p pVar, Looper looper) {
        super(looper);
        this.AQ = pVar;
        this.f1075a = 0;
        this.f1076b = 0L;
        this.c = false;
    }

    private void a(int i) {
        f fVar;
        int i2;
        ad adVar;
        ad adVar2;
        long j;
        boolean f;
        fVar = this.AQ.AG;
        Location hJ = fVar.hJ();
        if (hJ != aa.f1048a) {
            j = this.AQ.v;
            if (j == 0) {
                ae aeVar = new ae();
                aeVar.c = "network";
                ad hM = aeVar.f(hJ).hM();
                hM.a(hJ);
                f = this.AQ.f();
                if (f) {
                    return;
                }
                this.AQ.a(0, hM);
                return;
            }
        }
        i2 = this.AQ.z;
        if (i2 == 0) {
            adVar = this.AQ.AP;
            if (adVar != null) {
                long currentTimeMillis = System.currentTimeMillis();
                adVar2 = this.AQ.AP;
                if (currentTimeMillis - adVar2.getTime() < AppStatusRules.DEFAULT_GRANULARITY) {
                    return;
                }
            }
        }
        this.AQ.a(i, ad.Bg);
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (str.contains("latitude")) {
                return true;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("cells");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("wifis");
                return optJSONArray2 != null && optJSONArray2.length() > 0;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        boolean f;
        w wVar;
        u uVar;
        byte[] bArr;
        boolean d;
        int i;
        ai aiVar;
        long j;
        long j2;
        ai aiVar2;
        switch (message.what) {
            case 2001:
                d = this.AQ.d();
                if (!d) {
                    i = this.AQ.z;
                    if (i != 2) {
                        aiVar = this.AQ.AH;
                        if (aiVar != null) {
                            aiVar2 = this.AQ.AH;
                            aiVar2.a();
                        }
                        j = this.AQ.x;
                        long max = Math.max(j, 4000L);
                        long currentTimeMillis = System.currentTimeMillis();
                        j2 = this.AQ.v;
                        if (currentTimeMillis - j2 < max) {
                            return;
                        }
                    }
                }
                break;
            case 2002:
                break;
            case 2003:
                removeMessages(2004);
                Pair pair = (Pair) message.obj;
                String obj = pair.first.toString();
                ab abVar = (ab) ((v) pair.second).f1079a;
                this.AQ.AN = abVar.Bd;
                String str = abVar.a() ? "gps" : "network";
                ae aeVar = new ae();
                aeVar.f1052b = obj;
                aeVar.c = str;
                ad hM = aeVar.hM();
                if (hM == ad.Bg) {
                    a(404);
                    return;
                }
                f = this.AQ.f();
                if (!f || hM.a()) {
                    if (!hM.a()) {
                        ad.a(hM);
                    }
                    this.AQ.a(0, hM);
                }
                this.AQ.v = System.currentTimeMillis();
                this.AQ.AO = hM;
                return;
            case 2004:
                a(1);
                this.AQ.v = -1L;
                return;
            case 2005:
                this.AQ.AK = null;
                sendEmptyMessage(2002);
                return;
            default:
                return;
        }
        removeMessages(2002);
        ab h = p.h(this.AQ);
        if (h == null) {
            a(2);
            return;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (!h.a() || currentTimeMillis2 - this.f1076b <= AppStatusRules.DEFAULT_GRANULARITY) {
            this.c = false;
        } else {
            this.c = true;
            this.f1076b = currentTimeMillis2;
        }
        wVar = this.AQ.AA;
        String a2 = h.a(wVar, this.c);
        if (a(a2) ? false : true) {
            this.f1075a++;
            if (this.f1075a >= 2) {
                a(2);
                this.f1075a = 0;
                return;
            }
            return;
        }
        this.f1075a = 0;
        uVar = this.AQ.AI;
        try {
            byte[] a3 = u.a(a2.getBytes("GBK"));
            v vVar = new v(a3, l.a(a3) == null ? u.a(0) : u.a(1), h);
            vVar.f1080b = a2;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            bArr = vVar.f;
            if (bArr != null ? uVar.f1078b.offer(vVar) : false) {
                uVar.f = elapsedRealtime;
                return;
            }
            uVar.f1078b.clear();
            uVar.f1078b.offer(vVar);
            new StringBuilder("post").append(Headers.LOCATION).append("Request: failed to add request,because the queue has full,so we delete the first");
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
