package com.baidu.android.pushservice.y.f;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.pushservice.a0.i;
import com.baidu.android.pushservice.j;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.l.d;
import com.baidu.android.pushservice.pull.ClientEventInfo;
import com.baidu.android.pushservice.pull.reportdata.EventData;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.android.pushservice.y.e.f;
import com.baidu.android.pushservice.y.e.g;
import com.baidu.android.pushservice.y.e.h;
import com.baidu.android.pushservice.z.c;
import com.baidu.android.pushservice.z.e;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.android.pushservice.y.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0044a extends c {
        public final /* synthetic */ Context c;
        public final /* synthetic */ List d;

        /* renamed from: com.baidu.android.pushservice.y.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0045a implements Callback {
            public C0045a(C0044a c0044a) {
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                String str = "Request error :" + iOException.getMessage();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
            }
        }

        public C0044a(Context context, List list) {
            this.c = context;
            this.d = list;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            try {
                if (d.d(this.c)) {
                    com.baidu.android.pushservice.y.a.a(this.c).a(a.c(this.c, this.d), a.e(this.c), new C0045a(this));
                }
            } catch (Exception unused) {
            }
        }
    }

    public static long a() {
        return (System.currentTimeMillis() & 2147483647L) | (-2147483648L);
    }

    public static void a(Context context, ClientEventInfo clientEventInfo) {
        if (context == null || clientEventInfo == null || clientEventInfo.getSource() != 3) {
            return;
        }
        a(context, new EventData("widget_start", clientEventInfo.getAction()));
    }

    public static void a(Context context, EventData eventData) {
        if (context == null || eventData == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(eventData);
        d(context, arrayList);
    }

    public static ByteString b(Context context, List<EventData> list) {
        g.b i = g.Z().d(b(context)).b(3).e(Utility.a(context, false)).g(context.getPackageName()).a(c(context)).c(d(context)).b(Utility.A(context)).c(Utility.p(context)).f(Build.VERSION.RELEASE).i(Utility.y(context));
        for (EventData eventData : list) {
            i.a(h.h().a(eventData.a()).b(eventData.b()).build());
        }
        return ByteString.copyFrom(i.build().toByteArray());
    }

    public static String b(Context context) {
        String a = j.a(context).a();
        return TextUtils.isEmpty(a) ? i.c(context, "cid") : a;
    }

    public static ByteString c(Context context) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cuid", DeviceId.getCUID(context));
            str = Base64.encodeToString(BaiduAppSSOJni.encryptAES(jSONObject.toString(), 1), 2);
        } catch (Exception unused) {
            str = "";
        }
        return ByteString.copyFromUtf8(str);
    }

    public static byte[] c(Context context, List<EventData> list) {
        return f.x().b(com.baidu.android.pushservice.w.h.MSG_ID_REPORT_DATA.a()).d(com.baidu.android.pushservice.a.a()).a(a()).a(Utility.n(context, context.getPackageName()) ? "BaiduApp" : "DevApp").a(-76508268).c(3).a(b(context, list)).build().toByteArray();
    }

    public static int d(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cuid", DeviceId.getCUID(context));
            return jSONObject.toString().length();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static void d(Context context, List<EventData> list) {
        if (context == null || list == null || list.isEmpty()) {
            return;
        }
        e.a().a(new C0044a(context, list));
    }

    public static String e(Context context) {
        com.baidu.android.pushservice.g.d(context);
        return com.baidu.android.pushservice.g.d() + "/datareport";
    }
}
