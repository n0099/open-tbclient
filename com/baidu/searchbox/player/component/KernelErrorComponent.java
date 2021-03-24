package com.baidu.searchbox.player.component;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.videoplayer.framework.R;
/* loaded from: classes3.dex */
public class KernelErrorComponent extends AbsComponent {
    public LinearLayout mRootView;
    public TextView mTextNetError;

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
        LinearLayout linearLayout = (LinearLayout) View.inflate(getContext(), R.layout.videoplayer_layout_kernel_error, null);
        this.mRootView = linearLayout;
        TextView textView = (TextView) linearLayout.findViewById(R.id.play_error_layout_retry);
        this.mTextNetError = textView;
        textView.setOnClickListener(this.mParent);
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
