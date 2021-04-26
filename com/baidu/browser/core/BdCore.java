package com.baidu.browser.core;

import android.content.Context;
import com.baidu.browser.core.util.BdLog;
/* loaded from: classes.dex */
public final class BdCore {

    /* renamed from: c  reason: collision with root package name */
    public static BdCore f4417c;

    /* renamed from: a  reason: collision with root package name */
    public Context f4418a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4419b;

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
        this.f4419b = false;
    }

    public static synchronized BdCore b() {
        BdCore bdCore;
        synchronized (BdCore.class) {
            if (f4417c == null) {
                f4417c = new BdCore();
            }
            bdCore = f4417c;
        }
        return bdCore;
    }

    public Context a() {
        Context context = this.f4418a;
        if (context != null) {
            return context;
        }
        throw new RuntimeException("context is null");
    }

    public void c(Context context, boolean z) {
        if (this.f4419b) {
            return;
        }
        BdLog.f(z);
        this.f4418a = context.getApplicationContext();
        this.f4419b = true;
    }
}
