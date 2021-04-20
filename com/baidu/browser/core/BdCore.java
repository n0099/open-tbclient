package com.baidu.browser.core;

import android.content.Context;
import com.baidu.browser.core.util.BdLog;
/* loaded from: classes.dex */
public final class BdCore {

    /* renamed from: c  reason: collision with root package name */
    public static BdCore f4339c;

    /* renamed from: a  reason: collision with root package name */
    public Context f4340a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4341b;

    /* loaded from: classes.dex */
    public enum EditTextType {
        DEFAULT,
        WEB_EDIT,
        ADD_BAR,
        BD_EDIT,
        BD_RSS_WEB
    }

    public BdCore() {
        EditTextType editTextType = EditTextType.DEFAULT;
        this.f4341b = false;
    }

    public static synchronized BdCore b() {
        BdCore bdCore;
        synchronized (BdCore.class) {
            if (f4339c == null) {
                f4339c = new BdCore();
            }
            bdCore = f4339c;
        }
        return bdCore;
    }

    public Context a() {
        Context context = this.f4340a;
        if (context != null) {
            return context;
        }
        throw new RuntimeException("context is null");
    }

    public void c(Context context, boolean z) {
        if (this.f4341b) {
            return;
        }
        BdLog.f(z);
        this.f4340a = context.getApplicationContext();
        this.f4341b = true;
    }
}
