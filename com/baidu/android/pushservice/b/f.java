package com.baidu.android.pushservice.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.net.ConnectManager;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.util.j;
import com.baidu.android.pushservice.y;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private Context f688a;
    private c b;

    public f(Context context) {
        this.f688a = context;
        this.b = c.a(context);
    }

    private void a(Context context) {
        String c = y.a().c();
        String d = y.a().d();
        if (TextUtils.isEmpty(c) || TextUtils.isEmpty(d)) {
            if (com.baidu.android.pushservice.b.a(this.f688a)) {
                Log.e("StatisticsInfoManager", "Fail Send Msg result info. Token invalid!");
                return;
            }
            return;
        }
        SQLiteDatabase a2 = com.baidu.android.pushservice.util.e.a(context);
        if (a2 == null) {
            return;
        }
        List a3 = com.baidu.android.pushservice.util.e.a(a2);
        if (!ConnectManager.isNetworkConnected(this.f688a) || a3.size() <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a3.size()) {
                Thread thread = new Thread(new g(this, context, c, d, jSONArray.toString()));
                thread.setName("PushService-feedback");
                thread.start();
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PushConstants.EXTRA_MSGID, ((j) a3.get(i2)).b);
                jSONObject.put("appid", ((j) a3.get(i2)).c);
                jSONObject.put("resultCode", ((j) a3.get(i2)).d);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
            }
            i = i2 + 1;
        }
    }

    public void a() {
        a(this.f688a);
        if (this.b == null) {
            this.b = c.a(this.f688a);
        }
        this.b.e();
    }
}
