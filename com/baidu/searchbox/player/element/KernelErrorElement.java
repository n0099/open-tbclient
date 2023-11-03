package com.baidu.searchbox.player.element;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class KernelErrorElement extends AbsElement {
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

    @Override // com.baidu.searchbox.player.element.AbsElement
    public void initElement() {
        LinearLayout linearLayout = (LinearLayout) View.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0173, null);
        this.mRootView = linearLayout;
        TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091d1e);
        this.mTextNetError = textView;
        textView.setOnClickListener(this.mParent);
    }

    private void onSwitchFullStyle() {
        Drawable[] compoundDrawables = this.mTextNetError.getCompoundDrawables();
        this.mTextNetError.setTextSize(0, getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0701c6));
        compoundDrawables[1].setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0701d6), getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0701d6));
        this.mTextNetError.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
    }

    private void onSwitchHalfStyle() {
        Drawable[] compoundDrawables = this.mTextNetError.getCompoundDrawables();
        this.mTextNetError.setTextSize(0, getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0701c4));
        compoundDrawables[1].setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0701d3), getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0701d3));
        this.mTextNetError.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
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
