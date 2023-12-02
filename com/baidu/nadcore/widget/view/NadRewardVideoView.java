package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.nadcore.widget.uitemplate.NadRewardVolumeView;
import com.baidu.tieba.R;
import com.baidu.tieba.aq0;
import com.baidu.tieba.on0;
/* loaded from: classes3.dex */
public abstract class NadRewardVideoView extends NadRewardBaseView {
    public aq0 l;
    public ViewGroup m;
    public NadRewardVolumeView n;

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void h(LayoutInflater layoutInflater, on0 on0Var) {
    }

    /* loaded from: classes3.dex */
    public class a implements NadRewardVolumeView.b {
        public a() {
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardVolumeView.b
        public void a(boolean z) {
            aq0 aq0Var = NadRewardVideoView.this.l;
            if (aq0Var != null) {
                aq0Var.mute(z);
            }
        }
    }

    public NadRewardVideoView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowVisibilityChanged(int i) {
        boolean z;
        super.dispatchWindowVisibilityChanged(i);
        if (this.l == null) {
            return;
        }
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.l.isPause()) {
            this.l.resume();
        }
        if (!z && this.l.isPlaying()) {
            this.l.pause();
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void i(Context context) {
        this.m = (ViewGroup) findViewById(R.id.reward_ad_video_container);
    }

    public NadRewardVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NadRewardVideoView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public NadRewardVideoView(Context context, AttributeSet attributeSet, int i, on0 on0Var) {
        super(context, attributeSet, i, on0Var);
        NadRewardVolumeView nadRewardVolumeView = (NadRewardVolumeView) findViewById(R.id.nad_reward_volumn_icon);
        this.n = nadRewardVolumeView;
        nadRewardVolumeView.setVolumeListener(new a());
    }
}
