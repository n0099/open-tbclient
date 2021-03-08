package a.a.a.a.v.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e extends d {
    public final Handler b;
    public final String c;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f1010a;
        public final JSONObject b;
        public final long c = System.currentTimeMillis();

        public a(String str, JSONObject jSONObject) {
            this.f1010a = str;
            this.b = jSONObject;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends Handler {
        public b(@NonNull Looper looper) {
            super(looper);
        }

        public final void a(JSONObject jSONObject) {
            a.a.a.a.b.f hv = new a.a.a.a.b.c(e.this.c, new a.a.a.a.b.e(jSONObject)).hv();
            if (hv == null) {
                throw new IOException("no response received");
            }
            String str = hv.b;
            try {
                if (new JSONObject(str).getJSONObject("responseHeader").optInt("status", -1) != 200) {
                    a.a.a.a.v.d.b("failed report with content:" + str, new Object[0]);
                }
            } catch (JSONException e) {
                a.a.a.a.v.d.a(e);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what == 0) {
                a aVar = (a) message.obj;
                a.a.a.a.v.d.c("report key:" + aVar.f1010a + " content:" + aVar.b, new Object[0]);
                String str = aVar.f1010a;
                JSONObject jSONObject = aVar.b;
                long j = aVar.c;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    c.a(jSONObject2);
                    jSONObject2.put("key", str);
                    jSONObject2.put("content", jSONObject);
                    jSONObject2.put("occur_t", j);
                } catch (JSONException e) {
                }
                try {
                    a(jSONObject2);
                } catch (IOException e2) {
                    a.a.a.a.v.d.a(e2);
                }
            }
        }
    }

    public e(String str) {
        HandlerThread handlerThread = new HandlerThread("rep");
        handlerThread.start();
        this.b = new b(handlerThread.getLooper());
        this.c = str;
    }
}
