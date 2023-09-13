package com.baidu.searchbox.toolbar;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeImageViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class CommentTextLayout extends RelativeLayout implements IFontSizeViewListener {
    public static final float NORMAL_ALPHA = 1.0f;
    public static final float PRESSED_ALPHA = 0.3f;
    public static final float TEXT_SIZE = 14.0f;
    public ImageView mCommentIcon;
    public TextView mCommentText;
    public boolean mIsResponseFontSize;
    public final int mItemSize;

    public CommentTextLayout(Context context) {
        super(context);
        this.mItemSize = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070267);
        initLayout();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    Log.d("ACTION_UP", "ACTION_UP");
                    setAlpha(1.0f);
                }
            } else {
                Log.d("ACTION_DOWN", "ACTION_DOWN");
                setAlpha(0.3f);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener
    public void setIsResponseFontSize(boolean z) {
        this.mIsResponseFontSize = z;
        onFontSizeChange();
    }

    private void initLayout() {
        ImageView imageView = new ImageView(getContext());
        this.mCommentIcon = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.mCommentIcon.setImageResource(R.drawable.obfuscated_res_0x7f080532);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(FontSizeHelper.getScaledSize(0, this.mItemSize, 2), FontSizeHelper.getScaledSize(0, this.mItemSize, 2));
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        this.mCommentIcon.setLayoutParams(layoutParams);
        addView(this.mCommentIcon);
        TextView textView = new TextView(getContext());
        this.mCommentText = textView;
        textView.setText(getResources().getText(R.string.obfuscated_res_0x7f0f04a5));
        this.mCommentText.setGravity(16);
        this.mCommentText.setTextSize(1, FontSizeHelper.getScaledSize(0, 14.0f, 2));
        this.mCommentText.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0601cb));
        this.mCommentText.setPadding(0, 0, 0, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070259));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, this.mItemSize);
        layoutParams2.leftMargin = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07025a);
        layoutParams2.rightMargin = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07025b);
        layoutParams2.addRule(10);
        layoutParams2.addRule(9);
        this.mCommentText.setLayoutParams(layoutParams2);
        addView(this.mCommentText);
    }

    @Override // com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener
    public boolean isResponseFontSize() {
        return this.mIsResponseFontSize;
    }

    @Override // com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener
    public void onFontSizeChange() {
        if (!isResponseFontSize()) {
            return;
        }
        FontSizeViewExtKt.setScaledSizeRes(this.mCommentIcon, 0, R.dimen.obfuscated_res_0x7f070267, R.dimen.obfuscated_res_0x7f070267);
        FontSizeImageViewExtKt.setScaledImageDrawableRes(this.mCommentIcon, 0, R.drawable.obfuscated_res_0x7f080532);
        FontSizeTextViewExtKt.setScaledSizeRes(this.mCommentText, 0, R.dimen.obfuscated_res_0x7f0702e9);
        FontSizeViewExtKt.setScaledHeightRes(this.mCommentText, 0, R.dimen.obfuscated_res_0x7f070267);
        FontSizeViewExtKt.setScaledLeftMarginRes(this.mCommentText, 0, R.dimen.obfuscated_res_0x7f07025a);
    }

    public void updateColor() {
        this.mCommentIcon.setImageResource(R.drawable.obfuscated_res_0x7f080532);
        this.mCommentText.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0601cb));
        onFontSizeChange();
    }
}
