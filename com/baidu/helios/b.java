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
/* loaded from: classes6.dex */
public class b {
    private static volatile b aoK;
    private ExecutorService aoN;
    private Context mContext;
    private com.baidu.helios.bridge.b aoM = new com.baidu.helios.bridge.b(new com.baidu.helios.b.a());
    private com.baidu.helios.bridge.a aoL = this.aoM.tT();

    private b(Context context) {
        this.mContext = context.getApplicationContext();
        a.C0129a c0129a = new a.C0129a();
        c0129a.aoU = new com.baidu.helios.b.c();
        c0129a.aoV = new com.baidu.helios.b.b();
        c0129a.applicationContext = this.mContext;
        c0129a.aoW = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        c0129a.aoX = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.aoN = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.aoL.a(c0129a);
        this.aoL.a(new a.b());
    }

    public static synchronized b ae(Context context) {
        b bVar;
        synchronized (b.class) {
            if (aoK == null) {
                aoK = new b(context.getApplicationContext());
            }
            bVar = aoK;
        }
        return bVar;
    }

    /* loaded from: classes6.dex */
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
    /* loaded from: classes6.dex */
    public static class C0128b {
        private List<c> aoR = new ArrayList();

        public C0128b(List<c> list) {
            this.aoR.addAll(list);
        }

        public List<c> tS() {
            return this.aoR;
        }

        static C0128b dU(String str) {
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(new c(jSONObject.getString(Config.INPUT_DEF_PKG), jSONObject.getString("aid"), jSONObject.getLong("priority")));
                }
                return new C0128b(arrayList);
            } catch (JSONException e) {
                return null;
            }
        }

        public String toString() {
            return "sids {" + this.aoR + '}';
        }
    }

    public String tO() {
        return this.aoL.d("ssaid", null).id;
    }

    public String tP() {
        return this.aoL.d("aid", null).id;
    }

    public String getIid() {
        return this.aoL.d("iid", null).id;
    }

    public void a(com.baidu.helios.c<C0128b> cVar) {
        a(cVar, Looper.getMainLooper());
    }

    public void a(com.baidu.helios.c<C0128b> cVar, Looper looper) {
        final a aVar = new a(cVar, looper);
        this.aoL.a("sids", null, new a.c<String>() { // from class: com.baidu.helios.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.helios.bridge.a.c
            /* renamed from: c */
            public void a(String str, Bundle bundle) {
                aVar.b(C0128b.dU(str), bundle);
            }

            @Override // com.baidu.helios.bridge.a.c
            public void a(int i, Exception exc, Bundle bundle) {
                aVar.b(i, exc, bundle);
            }
        });
    }

    public void b(com.baidu.helios.c<String> cVar) {
        a("oid", cVar, Looper.getMainLooper());
    }

    public void c(com.baidu.helios.c<String> cVar) {
        a("gaid", cVar, Looper.getMainLooper());
    }

    public boolean tQ() {
        return this.aoL.dV(this.mContext.getPackageName());
    }

    private void a(String str, com.baidu.helios.c<String> cVar, Looper looper) {
        final a aVar = new a(cVar, looper);
        this.aoL.a(str, null, new a.c<String>() { // from class: com.baidu.helios.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.helios.bridge.a.c
            /* renamed from: c */
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
    /* loaded from: classes6.dex */
    public static class a<T> extends Handler {
        private com.baidu.helios.c<T> aoQ;

        public a(com.baidu.helios.c<T> cVar, Looper looper) {
            super(looper);
            this.aoQ = cVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.helios.c<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    Pair pair = (Pair) message.obj;
                    this.aoQ.a(pair.first, (Bundle) pair.second);
                    return;
                case 1:
                    Pair pair2 = (Pair) message.obj;
                    this.aoQ.a(message.arg1, (Throwable) pair2.first, (Bundle) pair2.second);
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
    public com.baidu.helios.bridge.a tR() {
        return this.aoL;
    }
}
