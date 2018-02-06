package com.baidu.android.pushservice.e;

import android.content.Context;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class h extends c {
    public h(l lVar, Context context) {
        super(lVar, context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.e.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put("method", WBPageConstants.ParamKey.COUNT);
    }
}
