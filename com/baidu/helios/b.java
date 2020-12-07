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
/* loaded from: classes19.dex */
public class b {
    private static volatile b avx;
    private ExecutorService avA;
    private Context mContext;
    private com.baidu.helios.bridge.b avz = new com.baidu.helios.bridge.b(new com.baidu.helios.b.a());
    private com.baidu.helios.bridge.a avy = this.avz.zn();

    private b(Context context) {
        this.mContext = context.getApplicationContext();
        a.C0137a c0137a = new a.C0137a();
        c0137a.avH = new com.baidu.helios.b.c();
        c0137a.avI = new com.baidu.helios.b.b();
        c0137a.applicationContext = this.mContext;
        c0137a.avJ = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        c0137a.avK = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.avA = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.avy.a(c0137a);
        this.avy.a(new a.b());
    }

    public static synchronized b al(Context context) {
        b bVar;
        synchronized (b.class) {
            if (avx == null) {
                avx = new b(context.getApplicationContext());
            }
            bVar = avx;
        }
        return bVar;
    }

    /* loaded from: classes19.dex */
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
    /* loaded from: classes19.dex */
    public static class C0136b {
        private List<c> avE = new ArrayList();

        public C0136b(List<c> list) {
            this.avE.addAll(list);
        }

        public List<c> zm() {
            return this.avE;
        }

        static C0136b fu(String str) {
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(new c(jSONObject.getString(Config.INPUT_DEF_PKG), jSONObject.getString("aid"), jSONObject.getLong("priority")));
                }
                return new C0136b(arrayList);
            } catch (JSONException e) {
                return null;
            }
        }

        public String toString() {
            return "sids {" + this.avE + '}';
        }
    }

    public String zh() {
        return this.avy.c("ssaid", null).id;
    }

    public String zi() {
        return this.avy.c("aid", null).id;
    }

    public String getIid() {
        return this.avy.c("iid", null).id;
    }

    public void a(com.baidu.helios.c<C0136b> cVar) {
        a(cVar, Looper.getMainLooper());
    }

    public void a(com.baidu.helios.c<C0136b> cVar, Looper looper) {
        final a aVar = new a(cVar, looper);
        this.avy.a("sids", null, new a.c<String>() { // from class: com.baidu.helios.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.helios.bridge.a.c
            /* renamed from: b */
            public void a(String str, Bundle bundle) {
                aVar.b(C0136b.fu(str), bundle);
            }

            @Override // com.baidu.helios.bridge.a.c
            public void a(int i, Exception exc, Bundle bundle) {
                aVar.b(i, exc, bundle);
            }
        });
    }

    public String zj() {
        return this.avy.c("oid", null).id;
    }

    public void b(com.baidu.helios.c<String> cVar) {
        a("oid", cVar, Looper.getMainLooper());
    }

    public void c(com.baidu.helios.c<String> cVar) {
        a("gaid", cVar, Looper.getMainLooper());
    }

    public boolean zk() {
        return this.avy.fv(this.mContext.getPackageName());
    }

    private void a(String str, com.baidu.helios.c<String> cVar, Looper looper) {
        final a aVar = new a(cVar, looper);
        this.avy.a(str, null, new a.c<String>() { // from class: com.baidu.helios.b.2
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
    /* loaded from: classes19.dex */
    public static class a<T> extends Handler {
        private com.baidu.helios.c<T> avD;

        public a(com.baidu.helios.c<T> cVar, Looper looper) {
            super(looper);
            this.avD = cVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.helios.c<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    Pair pair = (Pair) message.obj;
                    this.avD.a(pair.first, (Bundle) pair.second);
                    return;
                case 1:
                    Pair pair2 = (Pair) message.obj;
                    this.avD.a(message.arg1, (Throwable) pair2.first, (Bundle) pair2.second);
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
    public com.baidu.helios.bridge.a zl() {
        return this.avy;
    }
}
