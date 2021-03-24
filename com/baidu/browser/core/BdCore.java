package com.baidu.browser.core;

import android.content.Context;
import com.baidu.browser.core.util.BdLog;
/* loaded from: classes2.dex */
public final class BdCore {

    /* renamed from: c  reason: collision with root package name */
    public static BdCore f4303c;

    /* renamed from: a  reason: collision with root package name */
    public Context f4304a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4305b;

    /* loaded from: classes2.dex */
    public enum EditTextType {
        DEFAULT,
        WEB_EDIT,
        ADD_BAR,
        BD_EDIT,
        BD_RSS_WEB
    }

    public BdCore() {
        EditTextType editTextType = EditTextType.DEFAULT;
        this.f4305b = false;
    }

    public static synchronized BdCore b() {
        BdCore bdCore;
        synchronized (BdCore.class) {
            if (f4303c == null) {
                f4303c = new BdCore();
            }
            bdCore = f4303c;
        }
        return bdCore;
    }

    public Context a() {
        Context context = this.f4304a;
        if (context != null) {
            return context;
        }
        throw new RuntimeException("context is null");
    }

    public void c(Context context, boolean z) {
        if (this.f4305b) {
            return;
        }
        BdLog.f(z);
        this.f4304a = context.getApplicationContext();
        this.f4305b = true;
    }
}
