package com.baidu.searchbox.player.element;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class NetErrorElement extends AbsElement {
    public Button mBtnRetry;
    public LinearLayout mRootView;
    public TextView mTextNetError;

    @Override // com.baidu.searchbox.player.element.AbsElement
    public boolean attachToRootAtOnce() {
        return false;
    }

    @Override // com.baidu.searchbox.player.element.AbsElement, com.baidu.searchbox.player.element.IElement
    public void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
    }

    @Override // com.baidu.searchbox.player.element.IElement
    @NonNull
    public View getContentView() {
        return this.mRootView;
    }

    private void onSwitchFullStyle() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBtnRetry.getLayoutParams();
        this.mTextNetError.setTextSize(0, getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0701ca));
        this.mBtnRetry.setTextSize(0, getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0701ca));
        layoutParams.width = getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0701c5);
        layoutParams.height = getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0701d7);
        layoutParams.topMargin = getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0701d6);
        this.mBtnRetry.setLayoutParams(layoutParams);
    }

    private void onSwitchHalfStyle() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBtnRetry.getLayoutParams();
        this.mTextNetError.setTextSize(0, getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0701c8));
        this.mBtnRetry.setTextSize(0, getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0701c8));
        layoutParams.width = getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0701dd);
        layoutParams.height = getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0701d0);
        layoutParams.topMargin = getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0701d1);
        this.mBtnRetry.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.searchbox.player.element.AbsElement
    public void initElement() {
        if (this.mRootView == null) {
            this.mRootView = (LinearLayout) View.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0174, null);
        }
        this.mTextNetError = (TextView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f09275d);
        Button button = (Button) this.mRootView.findViewById(R.id.obfuscated_res_0x7f0904a6);
        this.mBtnRetry = button;
        button.setOnClickListener(this.mParent);
    }

    @Override // com.baidu.searchbox.player.element.AbsElement, com.baidu.searchbox.player.element.IElement
    public void onEventNotify(@NonNull VideoEvent videoEvent) {
        char c;
        String action = videoEvent.getAction();
        int hashCode = action.hashCode();
        if (hashCode != -552621273) {
            if (hashCode == -552580917 && action.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                c = 1;
            }
            c = 65535;
        } else {
            if (action.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                c = 0;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c == 1) {
                onSwitchHalfStyle();
                return;
            }
            return;
        }
        onSwitchFullStyle();
    }
}
