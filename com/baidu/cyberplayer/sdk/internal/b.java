package com.baidu.cyberplayer.sdk.internal;

import android.content.Context;
import com.baidu.cyberplayer.sdk.BEngineManager;
/* loaded from: classes.dex */
class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private String f717a;
    private String b;

    public b(Context context, String str, CyberPlayerEngineManager cyberPlayerEngineManager, BEngineManager.OnEngineListener onEngineListener, boolean z) {
        super(context, cyberPlayerEngineManager, onEngineListener, z);
        this.f717a = null;
        this.b = null;
        this.f717a = str;
    }

    @Override // com.baidu.cyberplayer.sdk.internal.a
    protected boolean a() {
        if (this.f717a != null) {
            this.b = this.f717a.substring("file://".length());
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.internal.a
    protected boolean b() {
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.internal.a
    protected String a() {
        return this.b;
    }

    @Override // com.baidu.cyberplayer.sdk.internal.a
    protected void b() {
    }
}
