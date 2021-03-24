package com.baidu.android.pushservice.d;

import android.content.Context;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class h extends c {

    /* renamed from: d  reason: collision with root package name */
    public String f2957d;

    public h(i iVar, Context context, String str) {
        super(iVar, context);
        this.f2957d = str;
    }

    @Override // com.baidu.android.pushservice.d.a
    public void b(HashMap<String, String> hashMap) {
        super.b(hashMap);
        hashMap.put("method", "deltags");
        hashMap.put(CommandMessage.TYPE_TAGS, this.f2957d);
    }
}
