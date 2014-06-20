package com.baidu.android.defense.push;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import com.baidu.android.systemmonitor.localapp.AppManager;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k extends h {
    private ArrayList e;

    public k() {
    }

    public k(String str, Context context) {
        super(str, context);
    }

    private boolean a(com.baidu.android.a.m mVar) {
        com.baidu.android.systemmonitor.localapp.a aVar = (com.baidu.android.systemmonitor.localapp.a) AppManager.a(this.d).a().get(mVar.a());
        if (aVar == null || (mVar.g() != 0 && aVar.f != mVar.g())) {
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
                this.e = new ArrayList();
                int length = jSONArray.length();
                new JSONObject();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                    if (jSONObject != null) {
                        com.baidu.android.a.m mVar = new com.baidu.android.a.m();
                        String string = jSONObject.getString("name");
                        String string2 = jSONObject.getString("title");
                        String string3 = jSONObject.getString("description");
                        String string4 = jSONObject.getString("versioncode");
                        mVar.c(string2);
                        mVar.a(string);
                        mVar.d(string3);
                        mVar.f(string4);
                        this.e.add(mVar);
                    }
                }
            } catch (JSONException e) {
                this.c = false;
                this.e = null;
            }
        }
    }

    public void a(Context context, ArrayList arrayList) {
        Intent intent;
        Exception e;
        JSONArray jSONArray;
        if (this.d == null) {
            this.d = context;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message_type", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            jSONObject.put(com.baidu.tbadk.core.frameworkData.a.CMD, new String("appuninstall"));
            jSONArray = new JSONArray();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.android.a.m mVar = (com.baidu.android.a.m) it.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("packagename", mVar.a());
                jSONObject2.put("versioncode", mVar.g());
                if (a(mVar)) {
                    jSONArray.put(jSONObject2);
                }
            }
        } catch (Exception e2) {
            intent = null;
            e = e2;
        }
        if (jSONArray.length() > 0) {
            jSONObject.put("params", jSONArray);
            String a = com.baidu.android.nebula.a.k.a(com.baidu.android.nebula.a.l.a("0102030405060708", "moplus@appsearch", jSONObject.toString().getBytes()), "utf-8");
            intent = new Intent("com.baidu.android.pushservice.action.SDK_MESSAGE");
            try {
                intent.putExtra("message", a.getBytes());
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 0);
                String e4 = ((com.baidu.android.a.m) arrayList.get(0)).e();
                Notification notification = new Notification(17301543, e4, System.currentTimeMillis());
                notification.setLatestEventInfo(context, ((com.baidu.android.a.m) arrayList.get(0)).d(), e4, broadcast);
                notification.sound = RingtoneManager.getDefaultUri(2);
                notificationManager.notify((int) System.currentTimeMillis(), notification);
            }
            PendingIntent broadcast2 = PendingIntent.getBroadcast(context, 0, intent, 0);
            String e42 = ((com.baidu.android.a.m) arrayList.get(0)).e();
            Notification notification2 = new Notification(17301543, e42, System.currentTimeMillis());
            notification2.setLatestEventInfo(context, ((com.baidu.android.a.m) arrayList.get(0)).d(), e42, broadcast2);
            notification2.sound = RingtoneManager.getDefaultUri(2);
            notificationManager.notify((int) System.currentTimeMillis(), notification2);
        }
    }

    @Override // com.baidu.android.defense.push.h, com.baidu.android.defense.push.n
    public boolean b() {
        if (this.e == null || this.e.size() == 0) {
            return false;
        }
        a(this.d, this.e);
        return true;
    }
}
