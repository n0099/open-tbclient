package com.baidu.browser.core;

import android.content.Context;
import com.baidu.browser.core.util.BdLog;
/* loaded from: classes2.dex */
public final class BdCore {
    private static BdCore UE;
    private EditTextType UF = EditTextType.DEFAULT;
    private boolean UG = false;
    private Context mContext;

    /* loaded from: classes2.dex */
    public enum EditTextType {
        DEFAULT,
        WEB_EDIT,
        ADD_BAR,
        BD_EDIT,
        BD_RSS_WEB
    }

    private BdCore() {
    }

    public static synchronized BdCore qh() {
        BdCore bdCore;
        synchronized (BdCore.class) {
            if (UE == null) {
                UE = new BdCore();
            }
            bdCore = UE;
        }
        return bdCore;
    }

    public void init(Context context, boolean z) {
        if (!this.UG) {
            BdLog.setDebug(z);
            this.mContext = context.getApplicationContext();
            this.UG = true;
        }
    }

    public Context getContext() {
        if (this.mContext == null) {
            throw new RuntimeException("context is null");
        }
        return this.mContext;
    }
}
