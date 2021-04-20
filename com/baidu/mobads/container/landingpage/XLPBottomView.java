package com.baidu.mobads.container.landingpage;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mobads.container.util.ScreenUtils;
/* loaded from: classes2.dex */
public class XLPBottomView extends LinearLayout {
    public static final int GAP_FIRST = 2;
    public static final int GAP_SECOND = 4;
    public Context mAppCtx;
    public OnBottomButtonClickListener mListener;

    /* loaded from: classes2.dex */
    public class CustomButton extends TextView {
        public static final int BUTTON_HEIGHT = 50;

        public CustomButton(Context context, String str) {
            super(context);
            initTextView(str);
        }

        private void initTextView(String str) {
            setText(str);
            setTextColor(-16777216);
            setGravity(17);
            setBackgroundColor(-1);
            setTextSize(19.0f);
            setLayoutParams(new LinearLayout.LayoutParams(-1, ScreenUtils.getPixel(XLPBottomView.this.mAppCtx, 50)));
        }
    }

    /* loaded from: classes2.dex */
    public interface OnBottomButtonClickListener {
        void onCancel();

        void onCopyUrl();

        void onRefresh();
    }

    public XLPBottomView(Context context) {
        super(context);
        this.mAppCtx = context.getApplicationContext();
        setBackgroundColor(-2236963);
        setOrientation(1);
        CustomButton customButton = new CustomButton(this.mAppCtx, "刷新");
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) customButton.getLayoutParams();
        layoutParams.bottomMargin = ScreenUtils.getPixel(this.mAppCtx, 2);
        addView(customButton, layoutParams);
        CustomButton customButton2 = new CustomButton(this.mAppCtx, "复制网址");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) customButton2.getLayoutParams();
        layoutParams2.bottomMargin = ScreenUtils.getPixel(this.mAppCtx, 4);
        addView(customButton2, layoutParams2);
        CustomButton customButton3 = new CustomButton(this.mAppCtx, "取消");
        addView(customButton3);
        customButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.container.landingpage.XLPBottomView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnBottomButtonClickListener onBottomButtonClickListener = XLPBottomView.this.mListener;
                if (onBottomButtonClickListener != null) {
                    onBottomButtonClickListener.onRefresh();
                }
            }
        });
        customButton2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.container.landingpage.XLPBottomView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnBottomButtonClickListener onBottomButtonClickListener = XLPBottomView.this.mListener;
                if (onBottomButtonClickListener != null) {
                    onBottomButtonClickListener.onCopyUrl();
                }
            }
        });
        customButton3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.container.landingpage.XLPBottomView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnBottomButtonClickListener onBottomButtonClickListener = XLPBottomView.this.mListener;
                if (onBottomButtonClickListener != null) {
                    onBottomButtonClickListener.onCancel();
                }
            }
        });
    }

    public void setOnBottomButtonClickListener(OnBottomButtonClickListener onBottomButtonClickListener) {
        this.mListener = onBottomButtonClickListener;
    }
}
