package com.baidu.android.pushservice.p;

import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m extends c {
    public String f;

    public m(i iVar, Context context, String str) {
        super(iVar, context);
        this.f = str;
    }

    @Override // com.baidu.android.pushservice.p.a
    public void a(Intent intent) {
        super.a(intent);
        if (intent != null) {
            intent.getIntExtra(GameCodeGetResponseMsg.PARAM_ERROR_MSG, -1);
        }
    }

    @Override // com.baidu.android.pushservice.p.a
    public String b(String str) {
        return super.b(str);
    }

    @Override // com.baidu.android.pushservice.p.a
    public void b(HashMap<String, String> hashMap) {
        super.b(hashMap);
        hashMap.put("method", "settags");
        hashMap.put("tags", this.f);
    }
}
