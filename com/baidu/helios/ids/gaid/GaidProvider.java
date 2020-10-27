package com.baidu.helios.ids.gaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.text.TextUtils;
import com.baidu.helios.common.c.a;
import com.baidu.helios.ids.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GaidProvider extends com.baidu.helios.ids.a {
    private b ayA;
    private e ayB;
    private a ayC;
    private f ayD;
    private a.C0153a ayz;
    private List<a.c<String>> i;

    /* loaded from: classes7.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        AtomicBoolean f1813a = new AtomicBoolean(false);

        public a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class b {
        private long g;
        private String j;
        private int m;
        private boolean h = true;
        private com.baidu.helios.common.b.a.e axt = new com.baidu.helios.common.b.a.e();
        private ArrayList<String> l = new ArrayList<>();

        b() {
        }

        public String a() {
            return this.j;
        }

        public void a(long j, long j2) {
            if (this.axt.d(j, j2)) {
                this.h = true;
            }
        }

        public void a(String str) {
            if (this.j == str) {
                return;
            }
            if (str == null || !str.equals(this.j)) {
                this.j = str;
                this.h = true;
            }
        }

        public long b() {
            return this.g;
        }

        public void b(long j) {
            if (this.g != j) {
                this.g = j;
                this.h = true;
            }
        }

        public void b(String str) {
            if (this.l.contains(str)) {
                return;
            }
            this.l.add(str);
            this.h = true;
        }

        public boolean c() {
            String q = GaidProvider.this.ayz.q("cache.dat", true);
            if (TextUtils.isEmpty(q)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(q);
                this.j = jSONObject.optString("form_id");
                this.g = jSONObject.getLong("lst_fe_ts");
                this.m = jSONObject.getInt("c_form_ver");
                this.axt.R(jSONObject.getLong("flags"));
                this.l.clear();
                JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                if (optJSONObject != null) {
                    int i = optJSONObject.getInt("count");
                    for (int i2 = 0; i2 < i; i2++) {
                        String string = optJSONObject.getString("id_" + i2);
                        if (TextUtils.isEmpty(string)) {
                            this.l.clear();
                            return false;
                        }
                        this.l.add(string);
                    }
                }
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        public boolean d() {
            if (this.h) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.j);
                    jSONObject.put("lst_fe_ts", this.g);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.axt.AA());
                    int size = this.l.size();
                    if (size > 0) {
                        int min = Math.min(size, 5);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject.put("his_form_ids", jSONObject2);
                        jSONObject2.put("count", min);
                        for (int i = 0; i < min; i++) {
                            jSONObject2.put("id_" + i, this.l.get((size - min) + i));
                        }
                    }
                    GaidProvider.this.ayz.d("cache.dat", jSONObject.toString(), true);
                    this.h = false;
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
            return false;
        }
    }

    /* loaded from: classes7.dex */
    class c implements ServiceConnection {
        c() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            GaidProvider.this.ayp.awx.submit(new Runnable() { // from class: com.baidu.helios.ids.gaid.GaidProvider.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d dVar = new d(iBinder);
                        final String a2 = dVar.a();
                        final boolean a3 = dVar.a(false);
                        if (GaidProvider.this.ayD != null) {
                            GaidProvider.this.ayD.removeMessages(0);
                        }
                        GaidProvider.this.ayp.aww.submit(new Runnable() { // from class: com.baidu.helios.ids.gaid.GaidProvider.c.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (!GaidProvider.this.ayC.f1813a.get()) {
                                    GaidProvider.this.a();
                                    GaidProvider.this.ayC.f1813a.set(true);
                                }
                                GaidProvider.this.ayA.a(a3 ? 1L : 2L, 3L);
                                if (!TextUtils.isEmpty(a2)) {
                                    try {
                                        String ag = com.baidu.helios.ids.a.ag("A20", new com.baidu.helios.common.b.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(a2.getBytes("UTF-8")));
                                        GaidProvider.this.ayA.a(ag);
                                        GaidProvider.this.ayA.b(ag);
                                    } catch (Exception e) {
                                    }
                                }
                                GaidProvider.this.ayA.d();
                            }
                        });
                        GaidProvider.this.ayp.applicationContext.unbindService(c.this);
                    } catch (Exception e) {
                    }
                }
            });
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes7.dex */
    static class d implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f1816a;
        private String b;

        public d(IBinder iBinder) {
            this.f1816a = iBinder;
            try {
                this.b = com.baidu.helios.ids.gaid.c.a(com.baidu.helios.ids.gaid.a.c());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(this.b);
                this.f1816a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean a(boolean z) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(this.b);
                obtain.writeInt(z ? 1 : 0);
                this.f1816a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f1816a;
        }
    }

    /* loaded from: classes7.dex */
    private static class e {

        /* renamed from: a  reason: collision with root package name */
        private String f1817a;
        private String b;

        private e() {
            try {
                this.f1817a = com.baidu.helios.ids.gaid.c.a(com.baidu.helios.ids.gaid.a.a());
                this.b = com.baidu.helios.ids.gaid.c.a(com.baidu.helios.ids.gaid.a.b());
            } catch (Exception e) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a() {
            return this.f1817a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String b() {
            return this.b;
        }
    }

    /* loaded from: classes7.dex */
    class f extends Handler {
        public f(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    GaidProvider.this.ayp.aww.submit(new Runnable() { // from class: com.baidu.helios.ids.gaid.GaidProvider.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GaidProvider.this.ayC.f1813a.get()) {
                                return;
                            }
                            GaidProvider.this.ayC.f1813a.set(true);
                            GaidProvider.this.a();
                        }
                    });
                    return;
                default:
                    return;
            }
        }
    }

    public GaidProvider() {
        super("gaid");
        this.ayA = new b();
        this.i = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a.c<String> cVar) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(this.ayA.a())) {
            cVar.a(-1, null, bundle);
        } else {
            cVar.a(this.ayA.a(), bundle);
        }
    }

    @Override // com.baidu.helios.ids.a
    public String AI() {
        return this.ayA.a();
    }

    void a() {
        for (a.c<String> cVar : this.i) {
            b(cVar);
        }
        this.i.clear();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0023 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0069 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.util.concurrent.atomic.AtomicBoolean */
    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: java.util.concurrent.atomic.AtomicBoolean */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0079 -> B:25:0x0031). Please submit an issue!!! */
    @Override // com.baidu.helios.ids.a
    public void a(a.b bVar) {
        a aVar = new a();
        this.ayC = aVar;
        this.ayz = this.ayo.fD("gaid");
        Context context = this.ayp.applicationContext;
        this.ayB = new e();
        PackageManager packageManager = context.getPackageManager();
        try {
            String a2 = this.ayB.a();
            if (a2 == null) {
                aVar.f1813a.set(true);
                aVar = aVar;
            } else {
                packageManager.getPackageInfo(a2, 0);
                this.ayA.c();
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.ayA.b()) <= 604800000) {
                    AtomicBoolean atomicBoolean = aVar.f1813a;
                    atomicBoolean.set(true);
                    aVar = atomicBoolean;
                } else {
                    this.ayA.b(currentTimeMillis);
                    this.ayA.d();
                    try {
                        String b2 = this.ayB.b();
                        if (b2 == null) {
                            aVar.f1813a.set(true);
                            aVar = aVar;
                        } else if (context.bindService(new Intent(b2).setPackage(a2), new c(), 1)) {
                            this.ayD = new f(Looper.getMainLooper());
                            this.ayD.sendEmptyMessageDelayed(0, 50000L);
                            aVar = aVar;
                        } else {
                            aVar.f1813a.set(true);
                            aVar = aVar;
                        }
                    } catch (Exception e2) {
                        AtomicBoolean atomicBoolean2 = aVar.f1813a;
                        atomicBoolean2.set(true);
                        aVar = atomicBoolean2;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e3) {
            aVar.f1813a.set(true);
        }
    }

    @Override // com.baidu.helios.ids.a
    public void a(final a.c<String> cVar) {
        this.ayp.aww.submit(new Runnable() { // from class: com.baidu.helios.ids.gaid.GaidProvider.1
            @Override // java.lang.Runnable
            public void run() {
                if (GaidProvider.this.ayC.f1813a.get()) {
                    GaidProvider.this.b(cVar);
                } else {
                    GaidProvider.this.i.add(cVar);
                }
            }
        });
    }
}
