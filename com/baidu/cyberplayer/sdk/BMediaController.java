package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.cyberplayer.sdk.internal.IVideoViewControllerBridge;
/* loaded from: classes.dex */
public class BMediaController extends RelativeLayout {
    private View a;

    /* renamed from: a  reason: collision with other field name */
    private IVideoViewControllerBridge f1a;

    public BMediaController(Context context) {
        super(context);
        this.f1a = null;
        this.a = null;
        this.f1a = BCyberPlayerFactory.a(context, this);
        a();
    }

    public BMediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1a = null;
        this.a = null;
        this.f1a = BCyberPlayerFactory.a(context, attributeSet, this);
        a();
    }

    public BMediaController(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f1a = null;
        this.a = null;
        this.f1a = BCyberPlayerFactory.a(context, attributeSet, i, this);
        a();
    }

    private void a() {
        addView(this.f1a.getVideoViewController());
    }

    public RelativeLayout getVideoView() {
        if (this.f1a != null) {
            return this.f1a.getVideoViewController();
        }
        return null;
    }

    public IVideoViewControllerBridge getVideoViewControllerBridge() {
        return this.f1a;
    }

    public void show() {
        this.f1a.show();
    }

    public void hide() {
        this.f1a.hide();
    }

    public boolean isShowing() {
        return this.f1a.isShowing();
    }

    public void setPreNextListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f1a.setPreNextListener(onClickListener, onClickListener2);
    }

    public void setAnchorView(View view) {
        this.a = view;
    }
}
