package a.a.a.a.x.f;

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
    public final Handler f1374b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1375c;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f1376a;

        /* renamed from: b  reason: collision with root package name */
        public final JSONObject f1377b;

        /* renamed from: c  reason: collision with root package name */
        public final long f1378c = System.currentTimeMillis();

        public a(String str, JSONObject jSONObject) {
            this.f1376a = str;
            this.f1377b = jSONObject;
        }
    }

    /* loaded from: classes.dex */
    public class b extends Handler {
        public b(@NonNull Looper looper) {
            super(looper);
        }

        public final void a(JSONObject jSONObject) {
            a.a.a.a.v.f a2 = new a.a.a.a.v.c(e.this.f1375c, new a.a.a.a.v.e(jSONObject)).a();
            if (a2 == null) {
                throw new IOException("no response received");
            }
            String str = a2.f1353b;
            try {
                if (new JSONObject(str).getJSONObject("responseHeader").optInt("status", -1) != 200) {
                    a.a.a.a.x.d.b("failed report with content:" + str, new Object[0]);
                }
            } catch (JSONException e2) {
                a.a.a.a.x.d.a(e2);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what != 0) {
                return;
            }
            a aVar = (a) message.obj;
            a.a.a.a.x.d.c("report key:" + aVar.f1376a + " content:" + aVar.f1377b, new Object[0]);
            String str = aVar.f1376a;
            JSONObject jSONObject = aVar.f1377b;
            long j = aVar.f1378c;
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
                a.a.a.a.x.d.a(e2);
            }
        }
    }

    public e(String str) {
        HandlerThread handlerThread = new HandlerThread("rep");
        handlerThread.start();
        this.f1374b = new b(handlerThread.getLooper());
        this.f1375c = str;
    }

    @Override // a.a.a.a.x.f.d
    public void a(String str, String str2, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str2, obj);
        } catch (JSONException unused) {
        }
        this.f1374b.obtainMessage(0, new a(str, jSONObject)).sendToTarget();
    }
}
