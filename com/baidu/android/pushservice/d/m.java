package com.baidu.android.pushservice.d;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class m extends c {
    protected String d;

    public m(i iVar, Context context, String str) {
        super(iVar, context);
        this.d = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.d.a
    public void a(Intent intent) {
        super.a(intent);
        if (intent != null) {
            intent.getIntExtra("error_msg", -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.d.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put("method", "settags");
        hashMap.put(CommandMessage.TYPE_TAGS, this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.d.a
    public String b(String str) {
        return super.b(str);
    }
}
