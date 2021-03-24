package com.baidu.searchbox.player.component;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.videoplayer.framework.R;
/* loaded from: classes3.dex */
public class NetErrorComponent extends AbsComponent {
    public Button mBtnRetry;
    public LinearLayout mRootView;
    public TextView mTextNetError;

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

    @Override // com.baidu.searchbox.player.component.AbsComponent
    public boolean attachToRootAtOnce() {
        return false;
    }

    @Override // com.baidu.searchbox.player.component.IComponent
    public View getContentView() {
        return this.mRootView;
    }

    @Override // com.baidu.searchbox.player.component.AbsComponent
    public void initComponent() {
        if (this.mRootView == null) {
            this.mRootView = (LinearLayout) View.inflate(getContext(), R.layout.videoplayer_layout_net_error, null);
        }
        this.mTextNetError = (TextView) this.mRootView.findViewById(R.id.tv_error);
        Button button = (Button) this.mRootView.findViewById(R.id.bt_retry);
        this.mBtnRetry = button;
        button.setOnClickListener(this.mParent);
    }

    @Override // com.baidu.searchbox.player.component.AbsComponent, com.baidu.searchbox.player.component.IComponent
    public void onEventNotify(@NonNull VideoEvent videoEvent) {
        char c2;
        String action = videoEvent.getAction();
        int hashCode = action.hashCode();
        if (hashCode != -552621273) {
            if (hashCode == -552580917 && action.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (action.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                c2 = 0;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            onSwitchFullStyle();
        } else if (c2 != 1) {
        } else {
            onSwitchHalfStyle();
        }
    }

    @Override // com.baidu.searchbox.player.component.AbsComponent, com.baidu.searchbox.player.component.IComponent
    public void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
    }
}
