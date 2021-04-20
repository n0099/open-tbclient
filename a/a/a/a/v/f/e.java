package a.a.a.a.v.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends d {

    /* renamed from: b  reason: collision with root package name */
    public final Handler f1358b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1359c;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f1360a;

        /* renamed from: b  reason: collision with root package name */
        public final JSONObject f1361b;

        /* renamed from: c  reason: collision with root package name */
        public final long f1362c = System.currentTimeMillis();

        public a(String str, JSONObject jSONObject) {
            this.f1360a = str;
            this.f1361b = jSONObject;
        }
    }

    /* loaded from: classes.dex */
    public class b extends Handler {
        public b(@NonNull Looper looper) {
            super(looper);
        }

        public final void a(JSONObject jSONObject) {
            a.a.a.a.t.f a2 = new a.a.a.a.t.c(e.this.f1359c, new a.a.a.a.t.e(jSONObject)).a();
            if (a2 == null) {
                throw new IOException("no response received");
            }
            String str = a2.f1338b;
            try {
                if (new JSONObject(str).getJSONObject("responseHeader").optInt("status", -1) != 200) {
                    a.a.a.a.v.d.b("failed report with content:" + str, new Object[0]);
                }
            } catch (JSONException e2) {
                a.a.a.a.v.d.a(e2);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what != 0) {
                return;
            }
            a aVar = (a) message.obj;
            a.a.a.a.v.d.c("report key:" + aVar.f1360a + " content:" + aVar.f1361b, new Object[0]);
            String str = aVar.f1360a;
            JSONObject jSONObject = aVar.f1361b;
            long j = aVar.f1362c;
            JSONObject jSONObject2 = new JSONObject();
            try {
                c.a(jSONObject2);
                jSONObject2.put("key", str);
                jSONObject2.put("content", jSONObject);
                jSONObject2.put("occur_t", j);
            } catch (JSONException unused) {
            }
            try {
                a(jSONObject2);
            } catch (IOException e2) {
                a.a.a.a.v.d.a(e2);
            }
        }
    }

    public e(String str) {
        HandlerThread handlerThread = new HandlerThread("rep");
        handlerThread.start();
        this.f1358b = new b(handlerThread.getLooper());
        this.f1359c = str;
    }
}
