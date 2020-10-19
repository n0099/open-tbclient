package com.baidu.browser.core;

import android.content.Context;
import com.baidu.browser.core.util.BdLog;
/* loaded from: classes10.dex */
public final class BdCore {
    private static BdCore aeu;
    private Context mContext;
    private EditTextType aev = EditTextType.DEFAULT;
    private boolean mHasInit = false;

    /* loaded from: classes10.dex */
    public enum EditTextType {
        DEFAULT,
        WEB_EDIT,
        ADD_BAR,
        BD_EDIT,
        BD_RSS_WEB
    }

    private BdCore() {
    }

    public static synchronized BdCore tg() {
        BdCore bdCore;
        synchronized (BdCore.class) {
            if (aeu == null) {
                aeu = new BdCore();
            }
            bdCore = aeu;
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
