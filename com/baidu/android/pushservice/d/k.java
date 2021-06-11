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
/* loaded from: classes.dex */
public class k extends c {

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<String> f3043d;

    public k(i iVar, Context context) {
        super(iVar, context);
        this.f3043d = new ArrayList<>();
    }

    @Override // com.baidu.android.pushservice.d.a
    public void a(int i2, byte[] bArr) {
        Intent intent = new Intent();
        intent.setAction(((a) this).f3015b.f3030a.equals("method_list_sdk_tags") ? "com.baidu.android.pushservice.action.sdk.RECEIVE" : "com.baidu.android.pushservice.action.RECEIVE");
        intent.putExtra("method", ((a) this).f3015b.f3030a);
        intent.putExtra("error_msg", i2);
        intent.putExtra("content", bArr);
        if (!this.f3043d.isEmpty()) {
            intent.putStringArrayListExtra("tags_list", this.f3043d);
        }
        intent.setFlags(32);
        a(intent);
        if (TextUtils.isEmpty(((a) this).f3015b.f3033d)) {
            if (!((a) this).f3015b.f3030a.equals("method_list_sdk_tags")) {
                return;
            }
        } else if (!((a) this).f3015b.f3030a.equals("method_list_sdk_tags")) {
            intent.setPackage(((a) this).f3015b.f3033d);
        }
        com.baidu.android.pushservice.j.m.b(((a) this).f3014a, intent, intent.getAction(), intent.getPackage());
    }

    @Override // com.baidu.android.pushservice.d.a
    public String b(String str) {
        String b2 = super.b(str);
        try {
            JSONArray jSONArray = new JSONObject(b2).getJSONObject("response_params").getJSONArray("groups");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.f3043d.add(jSONArray.getJSONObject(i2).getString("name"));
            }
        } catch (JSONException e2) {
            new b.c(((a) this).f3014a).a(Log.getStackTraceString(e2)).a();
        }
        return b2;
    }

    @Override // com.baidu.android.pushservice.d.a
    public void b(HashMap<String, String> hashMap) {
        super.b(hashMap);
        hashMap.put("method", "glist");
    }
}
