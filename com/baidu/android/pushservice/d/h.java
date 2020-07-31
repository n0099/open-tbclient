package com.baidu.android.pushservice.d;

import android.content.Context;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class h extends c {
    protected String d;

    public h(i iVar, Context context, String str) {
        super(iVar, context);
        this.d = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.d.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put("method", "deltags");
        hashMap.put(CommandMessage.TYPE_TAGS, this.d);
    }
}
