package com.baidu.mobads.container.components.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
/* loaded from: classes2.dex */
public abstract class OAdBasicReceivableController extends OAdBasicController {
    public OAdBasicReceivableController(Context context) {
        super(context);
    }

    public abstract void setBroadcastReceiver(BroadcastReceiver broadcastReceiver);
}
