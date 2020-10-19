package com.baidu.searchbox.player.component;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.videoplayer.framework.R;
/* loaded from: classes7.dex */
public class KernelErrorComponent extends AbsComponent {
    private LinearLayout mRootView;
    private TextView mTextNetError;

    @Override // com.baidu.searchbox.player.component.AbsComponent
    public void initComponent() {
        this.mRootView = (LinearLayout) View.inflate(getContext(), R.layout.videoplayer_layout_kernel_error, null);
        this.mTextNetError = (TextView) this.mRootView.findViewById(R.id.play_error_layout_retry);
        this.mTextNetError.setOnClickListener(this.mParent);
    }

    @Override // com.baidu.searchbox.player.component.IComponent
    public View getContentView() {
        return this.mRootView;
    }

    @Override // com.baidu.searchbox.player.component.AbsComponent
    public boolean attachToRootAtOnce() {
        return false;
    }

    @Override // com.baidu.searchbox.player.component.AbsComponent, com.baidu.searchbox.player.component.IComponent
    public void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
    }

    @Override // com.baidu.searchbox.player.component.AbsComponent, com.baidu.searchbox.player.component.IComponent
    public void onEventNotify(@NonNull VideoEvent videoEvent) {
        String action = videoEvent.getAction();
        char c = 65535;
        switch (action.hashCode()) {
            case -552621273:
                if (action.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                    c = 0;
                    break;
                }
                break;
            case -552580917:
                if (action.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                onSwitchFullStyle();
                return;
            case 1:
                onSwitchHalfStyle();
                return;
            default:
                return;
        }
    }

    private void onSwitchFullStyle() {
        Drawable[] compoundDrawables = this.mTextNetError.getCompoundDrawables();
        this.mTextNetError.setTextSize(0, getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_dimens_14dp));
        compoundDrawables[1].setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_dimens_47dp), getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_dimens_47dp));
        this.mTextNetError.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
    }

    private void onSwitchHalfStyle() {
        Drawable[] compoundDrawables = this.mTextNetError.getCompoundDrawables();
        this.mTextNetError.setTextSize(0, getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_dimens_12dp));
        compoundDrawables[1].setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_dimens_42dp), getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_dimens_42dp));
        this.mTextNetError.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
    }
}
