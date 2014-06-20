package com.baidu.android.nebula.c;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(b bVar, List list) {
        this.b = bVar;
        this.a = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        JSONArray jSONArray = new JSONArray();
        for (u uVar : this.a) {
            jSONArray.put(uVar.d());
        }
        try {
            String a = com.baidu.android.nebula.a.k.a(com.baidu.android.nebula.a.l.a("0925458709122426", "0925458709122426", jSONArray.toString().getBytes()), "utf-8");
            context = this.b.b;
            StringBuilder sb = new StringBuilder();
            context2 = this.b.b;
            SharedPreferences.Editor edit = context.getSharedPreferences(sb.append(context2.getPackageName()).append(".share_list").toString(), 1).edit();
            edit.putString("up_list", a);
            edit.putLong("up_stamp", System.currentTimeMillis());
            edit.commit();
        } catch (UnsupportedEncodingException e) {
        } catch (Exception e2) {
        }
    }
}
