package com.baidu.android.pushservice.e;

import android.content.Context;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
        hashMap.put(PushConstants.EXTRA_METHOD, ImageViewerConfig.COUNT);
        com.baidu.android.pushservice.g.a.c("Count", "Count param -- " + b.a(hashMap));
    }
}
