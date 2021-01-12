package com.baidu.browser.core;

import android.content.Context;
import com.baidu.browser.core.util.BdLog;
/* loaded from: classes4.dex */
public final class BdCore {
    private static BdCore afh;
    private Context mContext;
    private EditTextType afi = EditTextType.DEFAULT;
    private boolean mHasInit = false;

    /* loaded from: classes4.dex */
    public enum EditTextType {
        DEFAULT,
        WEB_EDIT,
        ADD_BAR,
        BD_EDIT,
        BD_RSS_WEB
    }

    private BdCore() {
    }

    public static synchronized BdCore sy() {
        BdCore bdCore;
        synchronized (BdCore.class) {
            if (afh == null) {
                afh = new BdCore();
            }
            bdCore = afh;
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
