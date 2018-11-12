package com.baidu.browser.core;

import android.content.Context;
import com.baidu.browser.core.util.BdLog;
/* loaded from: classes2.dex */
public final class BdCore {
    private static BdCore UG;
    private EditTextType UH = EditTextType.DEFAULT;
    private boolean UI = false;
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

    public static synchronized BdCore qf() {
        BdCore bdCore;
        synchronized (BdCore.class) {
            if (UG == null) {
                UG = new BdCore();
            }
            bdCore = UG;
        }
        return bdCore;
    }

    public void init(Context context, boolean z) {
        if (!this.UI) {
            BdLog.setDebug(z);
            this.mContext = context.getApplicationContext();
            this.UI = true;
        }
    }

    public Context getContext() {
        if (this.mContext == null) {
            throw new RuntimeException("context is null");
        }
        return this.mContext;
    }
}
