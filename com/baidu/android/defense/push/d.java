package com.baidu.android.defense.push;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.systemmonitor.localapp.AppManager;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends h {
    private com.baidu.android.a.m e;
    private ArrayList f;

    public d() {
    }

    public d(String str, Context context) {
        super(str, context);
    }

    private boolean c() {
        com.baidu.android.systemmonitor.localapp.a aVar = (com.baidu.android.systemmonitor.localapp.a) AppManager.a(this.d).a().get(this.e.a());
        if (aVar == null || (this.e.g() != 0 && aVar.f != this.e.g())) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.android.defense.push.h
    public void a() {
        if (this.b != null) {
            try {
                JSONArray jSONArray = this.b.getJSONArray("params");
                if (jSONArray == null || jSONArray.length() == 0) {
                    this.c = false;
                    return;
                }
                this.f = new ArrayList();
                int length = jSONArray.length();
                new JSONObject();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                    if (jSONObject != null) {
                        this.e = new com.baidu.android.a.m();
                        String string = jSONObject.getString("title");
                        String string2 = jSONObject.getString("description");
                        String string3 = jSONObject.getString("url");
                        this.e.c(string);
                        this.e.d(string2);
                        this.e.e(string3);
                        this.f.add(this.e);
                    }
                }
            } catch (JSONException e) {
                this.c = false;
                this.e = null;
            }
        }
    }

    public void a(Context context, ArrayList arrayList) {
        if (this.d == null) {
            this.d = context;
        }
        this.e = (com.baidu.android.a.m) arrayList.get(0);
        if (c() && !TextUtils.isEmpty(this.e.f())) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.e.f()));
            intent.addFlags(268435456);
            PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 0);
            String e = this.e.e();
            if (TextUtils.isEmpty(e) || TextUtils.isEmpty(this.e.d())) {
                return;
            }
            Notification notification = new Notification(17301543, e, System.currentTimeMillis());
            notification.setLatestEventInfo(context, this.e.d(), this.e.e(), activity);
            notification.sound = RingtoneManager.getDefaultUri(2);
            notificationManager.notify((int) System.currentTimeMillis(), notification);
        }
    }

    @Override // com.baidu.android.defense.push.h, com.baidu.android.defense.push.n
    public boolean b() {
        if (this.e == null || this.f == null || this.f.size() == 0) {
            return false;
        }
        if (c()) {
            a(this.d, this.f);
            return true;
        }
        return true;
    }
}
