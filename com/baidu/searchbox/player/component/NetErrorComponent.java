package com.baidu.searchbox.player.component;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.videoplayer.framework.R;
/* loaded from: classes7.dex */
public class NetErrorComponent extends AbsComponent {
    private Button mBtnRetry;
    private LinearLayout mRootView;
    private TextView mTextNetError;

    @Override // com.baidu.searchbox.player.component.AbsComponent
    public void initComponent() {
        if (this.mRootView == null) {
            this.mRootView = (LinearLayout) View.inflate(getContext(), R.layout.videoplayer_layout_net_error, null);
        }
        this.mTextNetError = (TextView) this.mRootView.findViewById(R.id.tv_error);
        this.mBtnRetry = (Button) this.mRootView.findViewById(R.id.bt_retry);
        this.mBtnRetry.setOnClickListener(this.mParent);
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBtnRetry.getLayoutParams();
        this.mTextNetError.setTextSize(0, getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_dimens_14dp));
        this.mBtnRetry.setTextSize(0, getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_dimens_14dp));
        layoutParams.width = getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_dimens_102dp);
        layoutParams.height = getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_dimens_32dp);
        layoutParams.topMargin = getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_dimens_31dp);
        this.mBtnRetry.setLayoutParams(layoutParams);
    }

    private void onSwitchHalfStyle() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBtnRetry.getLayoutParams();
        this.mTextNetError.setTextSize(0, getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_dimens_12dp));
        this.mBtnRetry.setTextSize(0, getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_dimens_12dp));
        layoutParams.width = getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_dimens_66dp);
        layoutParams.height = getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_dimens_24_33dp);
        layoutParams.topMargin = getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_dimens_24dp);
        this.mBtnRetry.setLayoutParams(layoutParams);
    }
}
