package com.baidu.android.pushservice.p;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k extends c {
    public ArrayList<String> f;

    public k(i iVar, Context context) {
        super(iVar, context);
        this.f = new ArrayList<>();
    }

    @Override // com.baidu.android.pushservice.p.a
    public void a(int i, byte[] bArr) {
        Intent intent = new Intent();
        intent.setAction(this.d.a.equals("method_list_sdk_tags") ? "com.baidu.android.pushservice.action.sdk.RECEIVE" : "com.baidu.android.pushservice.action.RECEIVE");
        intent.putExtra("method", this.d.a);
        intent.putExtra(GameCodeGetResponseMsg.PARAM_ERROR_MSG, i);
        intent.putExtra("content", bArr);
        if (!this.f.isEmpty()) {
            intent.putStringArrayListExtra("tags_list", this.f);
        }
        intent.setFlags(32);
        a(intent);
        if (TextUtils.isEmpty(this.d.c)) {
            if (!this.d.a.equals("method_list_sdk_tags")) {
                return;
            }
        } else if (!this.d.a.equals("method_list_sdk_tags")) {
            intent.setPackage(this.d.c);
        }
        Utility.c(this.c, intent, intent.getAction(), intent.getPackage());
    }

    @Override // com.baidu.android.pushservice.p.a
    public String b(String str) {
        String b = super.b(str);
        try {
            JSONArray jSONArray = new JSONObject(b).getJSONObject("response_params").getJSONArray("groups");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.f.add(jSONArray.getJSONObject(i).getString("name"));
            }
        } catch (JSONException unused) {
        }
        return b;
    }

    @Override // com.baidu.android.pushservice.p.a
    public void b(HashMap<String, String> hashMap) {
        super.b(hashMap);
        hashMap.put("method", "glist");
    }
}
