package com.baidu.android.pushservice.e;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.pushservice.PushConstants;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class x extends c {
    protected String d;

    public x(l lVar, Context context, String str) {
        super(lVar, context);
        this.d = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.e.a
    public void a(Intent intent) {
        super.a(intent);
        if (intent != null) {
            intent.getIntExtra(PushConstants.EXTRA_ERROR_CODE, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.e.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put("method", "settags");
        hashMap.put("tags", this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.e.a
    public String b(String str) {
        return super.b(str);
    }
}
