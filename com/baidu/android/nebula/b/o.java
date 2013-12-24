package com.baidu.android.nebula.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.common.security.AESUtil;
import com.baidu.android.common.security.Base64;
import com.baidu.browser.core.util.BdUtil;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(d dVar, List list) {
        this.b = dVar;
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
            String encode = Base64.encode(AESUtil.encrypt("0925458709122426", "0925458709122426", jSONArray.toString().getBytes()), BdUtil.UTF8);
            context = this.b.b;
            StringBuilder sb = new StringBuilder();
            context2 = this.b.b;
            SharedPreferences.Editor edit = context.getSharedPreferences(sb.append(context2.getPackageName()).append(".share_list").toString(), 1).edit();
            edit.putString("up_list", encode);
            edit.putLong("up_stamp", System.currentTimeMillis());
            edit.commit();
        } catch (UnsupportedEncodingException e) {
        } catch (Exception e2) {
        }
    }
}
