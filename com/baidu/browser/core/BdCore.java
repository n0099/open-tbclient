package com.baidu.browser.core;

import android.content.Context;
import com.baidu.browser.core.util.BdLog;
/* loaded from: classes6.dex */
public final class BdCore {
    private static BdCore afa;
    private Context mContext;
    private EditTextType afb = EditTextType.DEFAULT;
    private boolean mHasInit = false;

    /* loaded from: classes6.dex */
    public enum EditTextType {
        DEFAULT,
        WEB_EDIT,
        ADD_BAR,
        BD_EDIT,
        BD_RSS_WEB
    }

    private BdCore() {
    }

    public static synchronized BdCore sv() {
        BdCore bdCore;
        synchronized (BdCore.class) {
            if (afa == null) {
                afa = new BdCore();
            }
            bdCore = afa;
        }
        return bdCore;
    }

    public void init(Context context, boolean z) {
        if (!this.mHasInit) {
            BdLog.setDebug(z);
            this.mContext = context.getApplicationContext();
            this.mHasInit = true;
        }
    }

    public Context getContext() {
        if (this.mContext == null) {
            throw new RuntimeException("context is null");
        }
        return this.mContext;
    }
}
