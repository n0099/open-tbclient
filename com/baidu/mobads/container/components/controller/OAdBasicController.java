package com.baidu.mobads.container.components.controller;

import android.content.Context;
import com.baidu.mobads.container.util.XAdRemoteEventDispatcher;
/* loaded from: classes2.dex */
public abstract class OAdBasicController extends XAdRemoteEventDispatcher {
    public Context mContext;

    public OAdBasicController(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public abstract void startListener();

    public abstract void stopListeners();
}
