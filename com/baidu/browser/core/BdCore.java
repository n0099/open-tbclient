package com.baidu.browser.core;

import android.content.Context;
import com.baidu.browser.core.util.BdLog;
/* loaded from: classes2.dex */
public final class BdCore {
    private static BdCore UQ;
    private EditTextType UR = EditTextType.DEFAULT;
    private boolean US = false;
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

    public static synchronized BdCore qi() {
        BdCore bdCore;
        synchronized (BdCore.class) {
            if (UQ == null) {
                UQ = new BdCore();
            }
            bdCore = UQ;
        }
        return bdCore;
    }

    public void init(Context context, boolean z) {
        if (!this.US) {
            BdLog.setDebug(z);
            this.mContext = context.getApplicationContext();
            this.US = true;
        }
    }

    public Context getContext() {
        if (this.mContext == null) {
            throw new RuntimeException("context is null");
        }
        return this.mContext;
    }
}
