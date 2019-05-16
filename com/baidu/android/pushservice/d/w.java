package com.baidu.android.pushservice.d;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class w extends e {
    protected String d;
    protected String e;
    protected String f;
    protected String g;

    public w(l lVar, Context context, String str, String str2, String str3, String str4) {
        super(lVar, context);
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.d.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put("method", "sendmsgtouser");
        hashMap.put("appid", this.d);
        hashMap.put("user_id", this.e);
        if (this.g == null || this.f == null) {
            return;
        }
        StringBuilder sb = new StringBuilder("[\"");
        sb.append(this.f).append("\"]");
        StringBuilder sb2 = new StringBuilder("[\"");
        sb2.append(this.g).append("\"]");
        hashMap.put("msg_keys", sb.toString());
        hashMap.put("messages", sb2.toString());
    }
}
