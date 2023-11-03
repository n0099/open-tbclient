package com.baidu.android.pushservice.ach.receiver;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.pushservice.manageach.components.BaseAchReceiver;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
/* loaded from: classes.dex */
public class PushScreenReceiver extends BaseAchReceiver {
    public a a;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z);
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchReceiver
    public void a(Context context, Intent intent) {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-16044, this, context, intent);
    }

    public void a(a aVar) {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-16043, this, aVar);
    }
}
