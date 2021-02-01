package com.baidu.helios.a.a;

import android.content.Context;
import com.baidu.android.common.util.DeviceId;
/* loaded from: classes6.dex */
class d implements g {
    @Override // com.baidu.helios.a.a.g
    public String a(Context context) {
        if (context == null) {
            throw new NullPointerException("context should not be null");
        }
        return DeviceId.getCUID(context);
    }
}
