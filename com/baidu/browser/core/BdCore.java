package com.baidu.browser.core;

import android.content.Context;
import com.baidu.browser.core.util.BdLog;
/* loaded from: classes11.dex */
public final class BdCore {
    private static BdCore Ia;
    private Context mContext;
    private EditTextType Ib = EditTextType.DEFAULT;
    private boolean mHasInit = false;

    /* loaded from: classes11.dex */
    public enum EditTextType {
        DEFAULT,
        WEB_EDIT,
        ADD_BAR,
        BD_EDIT,
        BD_RSS_WEB
    }

    private BdCore() {
    }

    public static synchronized BdCore mo() {
        BdCore bdCore;
        synchronized (BdCore.class) {
            if (Ia == null) {
                Ia = new BdCore();
            }
            bdCore = Ia;
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
