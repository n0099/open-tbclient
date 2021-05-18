package com.baidu.android.pushservice.d;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m extends c {

    /* renamed from: d  reason: collision with root package name */
    public String f3031d;

    public m(i iVar, Context context, String str) {
        super(iVar, context);
        this.f3031d = str;
    }

    @Override // com.baidu.android.pushservice.d.a
    public void a(Intent intent) {
        super.a(intent);
        if (intent != null) {
            intent.getIntExtra("error_msg", -1);
        }
    }

    @Override // com.baidu.android.pushservice.d.a
    public String b(String str) {
        return super.b(str);
    }

    @Override // com.baidu.android.pushservice.d.a
    public void b(HashMap<String, String> hashMap) {
        super.b(hashMap);
        hashMap.put("method", "settags");
        hashMap.put(CommandMessage.TYPE_TAGS, this.f3031d);
    }
}
