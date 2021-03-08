package com.baidu.live.alablmsdk.d.b;

import android.content.Context;
import android.view.View;
import com.thunder.livesdk.video.ThunderPlayerTextureView;
/* loaded from: classes10.dex */
public class c implements View.OnAttachStateChangeListener, com.baidu.live.alablmsdk.c.b.c {
    private ThunderPlayerTextureView aBs;

    public c(Context context) {
        this.aBs = new ThunderPlayerTextureView(context);
        this.aBs.addOnAttachStateChangeListener(this);
    }

    @Override // com.baidu.live.alablmsdk.c.b.c
    public boolean xP() {
        return this.aBs != null;
    }

    @Override // com.baidu.live.alablmsdk.c.b.c
    public void a(com.baidu.live.alablmsdk.c.b.d dVar) {
    }

    @Override // com.baidu.live.alablmsdk.c.b.c
    public View yk() {
        return this.aBs;
    }

    @Override // com.baidu.live.alablmsdk.c.b.c
    public void release() {
    }

    public String toString() {
        return "YYExternalTextureInfo: mThunderPlayerView is " + this.aBs;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        com.baidu.live.alablmsdk.a.b.a.d(" YYExternalTextureInfo AttachedToWindow");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        com.baidu.live.alablmsdk.a.b.a.d(" YYExternalTextureInfo DetachedFromWindow");
    }
}
