package com.baidu.searchbox.ui.bubble.views;

import android.view.View;
import android.widget.TextView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class BubbleButtonView extends BubbleTextView {
    public static final String TAG = "BubbleButtonView";
    public CharSequence mBtnText;
    public TextView mBubbleBtn;
    public int mBtnTextUnit = -1;
    public float mBtnTextSize = -1.0f;

    @Override // com.baidu.searchbox.ui.bubble.views.BubbleTextView, com.baidu.searchbox.ui.bubble.views.BubbleBaseView
    public int getBubbleViewResId() {
        return R.layout.obfuscated_res_0x7f0d0189;
    }

    @Override // com.baidu.searchbox.ui.bubble.views.BubbleTextView, com.baidu.searchbox.ui.bubble.views.BubbleBaseView
    public boolean initViewIfNeed() {
        if (super.initViewIfNeed()) {
            this.mBubbleBtn = (TextView) this.mBubbleView.findViewById(R.id.obfuscated_res_0x7f0904fa);
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.ui.bubble.views.BubbleTextView, com.baidu.searchbox.ui.bubble.views.BubbleBaseView
    public void resetAll() {
        super.resetAll();
        this.mBubbleBtn = null;
        this.mBtnText = null;
    }

    public void setBtnClick(View.OnClickListener onClickListener) {
        TextView textView = this.mBubbleBtn;
        if (textView == null) {
            return;
        }
        textView.setOnClickListener(onClickListener);
    }

    public void setBtnFontSizew(int i, float f) {
        this.mBtnTextUnit = i;
        this.mBtnTextSize = f;
    }

    public void setBtnText(CharSequence charSequence, int i, int i2, float f) {
        TextView textView = this.mBubbleBtn;
        if (textView == null) {
            return;
        }
        if (i2 >= 0 && f > 0.0f) {
            textView.setTextSize(i2, f);
        }
        this.mBubbleBtn.setTextColor(i);
        this.mBubbleBtn.setText(charSequence);
        this.mBubbleBtn.setBackground(AppRuntime.getAppContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080563));
        this.mBubbleBtn.setVisibility(0);
    }
}
