package com.baidu.android.pushservice.c;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.pushservice.PushConstants;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class w extends c {
    protected String d;

    public w(l lVar, Context context, String str) {
        super(lVar, context);
        this.d = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.c.a
    public void a(Intent intent) {
        super.a(intent);
        if (intent != null) {
            intent.getIntExtra(PushConstants.EXTRA_ERROR_CODE, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.c.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put(PushConstants.EXTRA_METHOD, "settags");
        hashMap.put("tags", this.d);
        com.baidu.android.pushservice.e.a.c("SetTags", "SetTags param -- " + b.a(hashMap));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.c.a
    public String b(String str) {
        return super.b(str);
    }
}
