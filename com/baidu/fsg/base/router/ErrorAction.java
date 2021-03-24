package com.baidu.fsg.base.router;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class ErrorAction implements RouterAction {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5248a = "Action not implement";

    @Override // com.baidu.fsg.base.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (routerCallback != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("result", f5248a);
            routerCallback.onResult(RouterCallback.CODE_NOT_IMPLEMENT, hashMap2);
        }
    }
}
