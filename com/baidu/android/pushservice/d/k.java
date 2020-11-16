package com.baidu.android.pushservice.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class k extends c {
    private ArrayList<String> d;

    public k(i iVar, Context context) {
        super(iVar, context);
        this.d = new ArrayList<>();
    }

    @Override // com.baidu.android.pushservice.d.a
    protected void a(int i, byte[] bArr) {
        Intent intent = new Intent();
        if (this.b.f1062a.equals("method_list_sdk_tags")) {
            intent.setAction("com.baidu.android.pushservice.action.sdk.RECEIVE");
        } else {
            intent.setAction("com.baidu.android.pushservice.action.RECEIVE");
        }
        intent.putExtra("method", this.b.f1062a);
        intent.putExtra("error_msg", i);
        intent.putExtra("content", bArr);
        if (!this.d.isEmpty()) {
            intent.putStringArrayListExtra("tags_list", this.d);
        }
        intent.setFlags(32);
        a(intent);
        if (TextUtils.isEmpty(this.b.d)) {
            if (!this.b.f1062a.equals("method_list_sdk_tags")) {
                return;
            }
        } else if (!this.b.f1062a.equals("method_list_sdk_tags")) {
            intent.setPackage(this.b.d);
        }
        com.baidu.android.pushservice.i.m.b(this.f1058a, intent, intent.getAction(), intent.getPackage());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.d.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put("method", "glist");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.d.a
    public String b(String str) {
        String b = super.b(str);
        try {
            JSONArray jSONArray = new JSONObject(b).getJSONObject("response_params").getJSONArray("groups");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.d.add(jSONArray.getJSONObject(i).getString("name"));
            }
        } catch (JSONException e) {
            new b.c(this.f1058a).a(Log.getStackTraceString(e)).a();
        }
        return b;
    }
}
