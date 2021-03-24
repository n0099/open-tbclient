package com.baidu.android.pushservice.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k extends c {

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<String> f2970d;

    public k(i iVar, Context context) {
        super(iVar, context);
        this.f2970d = new ArrayList<>();
    }

    @Override // com.baidu.android.pushservice.d.a
    public void a(int i, byte[] bArr) {
        Intent intent = new Intent();
        intent.setAction(((a) this).f2943b.f2958a.equals("method_list_sdk_tags") ? "com.baidu.android.pushservice.action.sdk.RECEIVE" : "com.baidu.android.pushservice.action.RECEIVE");
        intent.putExtra("method", ((a) this).f2943b.f2958a);
        intent.putExtra("error_msg", i);
        intent.putExtra("content", bArr);
        if (!this.f2970d.isEmpty()) {
            intent.putStringArrayListExtra("tags_list", this.f2970d);
        }
        intent.setFlags(32);
        a(intent);
        if (TextUtils.isEmpty(((a) this).f2943b.f2961d)) {
            if (!((a) this).f2943b.f2958a.equals("method_list_sdk_tags")) {
                return;
            }
        } else if (!((a) this).f2943b.f2958a.equals("method_list_sdk_tags")) {
            intent.setPackage(((a) this).f2943b.f2961d);
        }
        com.baidu.android.pushservice.j.m.b(((a) this).f2942a, intent, intent.getAction(), intent.getPackage());
    }

    @Override // com.baidu.android.pushservice.d.a
    public String b(String str) {
        String b2 = super.b(str);
        try {
            JSONArray jSONArray = new JSONObject(b2).getJSONObject("response_params").getJSONArray("groups");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.f2970d.add(jSONArray.getJSONObject(i).getString("name"));
            }
        } catch (JSONException e2) {
            new b.c(((a) this).f2942a).a(Log.getStackTraceString(e2)).a();
        }
        return b2;
    }

    @Override // com.baidu.android.pushservice.d.a
    public void b(HashMap<String, String> hashMap) {
        super.b(hashMap);
        hashMap.put("method", "glist");
    }
}
