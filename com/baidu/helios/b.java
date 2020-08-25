package com.baidu.helios;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.ActivityChooserView;
import android.util.Pair;
import com.baidu.helios.bridge.a;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class b {
    private static volatile b auW;
    private ExecutorService auZ;
    private Context mContext;
    private com.baidu.helios.bridge.b auY = new com.baidu.helios.bridge.b(new com.baidu.helios.b.a());
    private com.baidu.helios.bridge.a auX = this.auY.zI();

    private b(Context context) {
        this.mContext = context.getApplicationContext();
        a.C0136a c0136a = new a.C0136a();
        c0136a.avg = new com.baidu.helios.b.c();
        c0136a.avh = new com.baidu.helios.b.b();
        c0136a.applicationContext = this.mContext;
        c0136a.avi = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        c0136a.avj = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.auZ = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.auX.a(c0136a);
        this.auX.a(new a.b());
    }

    public static synchronized b ag(Context context) {
        b bVar;
        synchronized (b.class) {
            if (auW == null) {
                auW = new b(context.getApplicationContext());
            }
            bVar = auW;
        }
        return bVar;
    }

    /* loaded from: classes12.dex */
    public static class c {
        public final String aid;
        public final String packageName;
        public final long priority;

        public c(String str, String str2, long j) {
            this.packageName = str;
            this.aid = str2;
            this.priority = j;
        }

        public String toString() {
            return "aid {packageName='" + this.packageName + "', aid='" + this.aid + "', priority=" + this.priority + '}';
        }
    }

    /* renamed from: com.baidu.helios.b$b  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C0135b {
        private List<c> avd = new ArrayList();

        public C0135b(List<c> list) {
            this.avd.addAll(list);
        }

        public List<c> zH() {
            return this.avd;
        }

        static C0135b fo(String str) {
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(new c(jSONObject.getString(Config.INPUT_DEF_PKG), jSONObject.getString("aid"), jSONObject.getLong("priority")));
                }
                return new C0135b(arrayList);
            } catch (JSONException e) {
                return null;
            }
        }

        public String toString() {
            return "sids {" + this.avd + '}';
        }
    }

    public String zC() {
        return this.auX.c("ssaid", null).id;
    }

    public String zD() {
        return this.auX.c("aid", null).id;
    }

    public String getIid() {
        return this.auX.c("iid", null).id;
    }

    public void a(com.baidu.helios.c<C0135b> cVar) {
        a(cVar, Looper.getMainLooper());
    }

    public void a(com.baidu.helios.c<C0135b> cVar, Looper looper) {
        final a aVar = new a(cVar, looper);
        this.auX.a("sids", null, new a.c<String>() { // from class: com.baidu.helios.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.helios.bridge.a.c
            /* renamed from: b */
            public void a(String str, Bundle bundle) {
                aVar.b(C0135b.fo(str), bundle);
            }

            @Override // com.baidu.helios.bridge.a.c
            public void a(int i, Exception exc, Bundle bundle) {
                aVar.b(i, exc, bundle);
            }
        });
    }

    public String zE() {
        return this.auX.c("oid", null).id;
    }

    public void b(com.baidu.helios.c<String> cVar) {
        a("oid", cVar, Looper.getMainLooper());
    }

    public void c(com.baidu.helios.c<String> cVar) {
        a("gaid", cVar, Looper.getMainLooper());
    }

    public boolean zF() {
        return this.auX.fp(this.mContext.getPackageName());
    }

    private void a(String str, com.baidu.helios.c<String> cVar, Looper looper) {
        final a aVar = new a(cVar, looper);
        this.auX.a(str, null, new a.c<String>() { // from class: com.baidu.helios.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.helios.bridge.a.c
            /* renamed from: b */
            public void a(String str2, Bundle bundle) {
                aVar.b(str2, bundle);
            }

            @Override // com.baidu.helios.bridge.a.c
            public void a(int i, Exception exc, Bundle bundle) {
                aVar.b(i, exc, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a<T> extends Handler {
        private com.baidu.helios.c<T> avc;

        public a(com.baidu.helios.c<T> cVar, Looper looper) {
            super(looper);
            this.avc = cVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.helios.c<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    Pair pair = (Pair) message.obj;
                    this.avc.a(pair.first, (Bundle) pair.second);
                    return;
                case 1:
                    Pair pair2 = (Pair) message.obj;
                    this.avc.a(message.arg1, (Throwable) pair2.first, (Bundle) pair2.second);
                    return;
                default:
                    return;
            }
        }

        public void b(T t, Bundle bundle) {
            obtainMessage(0, Pair.create(t, bundle)).sendToTarget();
        }

        public void b(int i, Exception exc, Bundle bundle) {
            obtainMessage(1, i, 0, Pair.create(exc, bundle)).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.helios.bridge.a zG() {
        return this.auX;
    }
}
