package com.baidu.searchbox.ng.ai.apps.res.ui;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.searchbox.ng.ai.apps.R;
/* loaded from: classes2.dex */
public class NetworkErrorView extends CommonEmptyView {
    public static final int THEME_CLASIC = 0;
    public static final int THEME_NIGHT = 2;
    private int mMode;

    public NetworkErrorView(Context context) {
        super(context);
        this.mRefreshTextBtn.setVisibility(0);
    }

    public NetworkErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRefreshTextBtn.setVisibility(0);
    }

    public NetworkErrorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRefreshTextBtn.setVisibility(0);
    }

    public void updateUI(int i) {
        this.mMode = i;
        if (i == 2) {
            setBackgroundColor(-16777216);
            this.mIcon.setAlpha(0.5f);
            this.mTitle.setTextColor(getResources().getColor(R.color.aiapps_emptyview_title_text_color_night));
            this.mSubTitle.setTextColor(getResources().getColor(R.color.aiapps_emptyview_subtitle_text_color_night));
            if (Build.VERSION.SDK_INT >= 23) {
                this.mRefreshTextBtn.setTextColor(getResources().getColorStateList(R.color.aiapps_emptyview_btn_text_color_night, null));
            } else {
                this.mRefreshTextBtn.setTextColor(getResources().getColorStateList(R.color.aiapps_emptyview_btn_text_color_night));
            }
        } else {
            setBackgroundColor(-1);
            this.mIcon.setAlpha(1.0f);
            this.mTitle.setTextColor(getResources().getColor(R.color.aiapps_emptyview_title_text_color));
            this.mSubTitle.setTextColor(getResources().getColor(R.color.aiapps_emptyview_subtitle_text_color));
            if (Build.VERSION.SDK_INT >= 23) {
                this.mRefreshTextBtn.setTextColor(getResources().getColorStateList(R.color.aiapps_emptyview_btn_text_color, null));
            } else {
                this.mRefreshTextBtn.setTextColor(getResources().getColorStateList(R.color.aiapps_emptyview_btn_text_color));
            }
        }
        this.mIcon.setImageDrawable(getContext().getResources().getDrawable(R.drawable.aiapps_empty_icon_network));
        this.mRefreshTextBtn.setBackground(getContext().getResources().getDrawable(R.drawable.aiapps_emptyview_btn_bg));
    }

    public void setReloadClickListener(View.OnClickListener onClickListener) {
        setTextButtonClickListener(onClickListener);
    }

    public void setEmptyViewVisiblity(int i) {
        this.mIcon.setVisibility(i);
    }

    public void setEmptyButtonVisiblity(int i) {
        this.mRefreshTextBtn.setVisibility(i);
    }

    public void setNetworkButtonShow(boolean z) {
        if (this.mLinkText != null) {
            this.mLinkText.setVisibility(z ? 0 : 4);
        }
    }

    public void setBottomLayout(View.OnClickListener onClickListener, View view, RelativeLayout.LayoutParams layoutParams) {
        if (this.mBottomLayout != null && view != null) {
            this.mBottomLayout.setVisibility(0);
            this.mBottomLayout.addView(view);
            if (layoutParams != null) {
                this.mBottomLayout.setLayoutParams(layoutParams);
            }
            this.mBottomLayout.setOnClickListener(onClickListener);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 0) {
            postErrorViewShowEvent(this);
        }
        super.setVisibility(i);
    }

    public boolean isNight() {
        return this.mMode == 2;
    }

    public static void postErrorViewShowEvent(View view) {
        ErrorViewEvent errorViewEvent = new ErrorViewEvent(1);
        errorViewEvent.arg0 = 1;
        errorViewEvent.obj = view;
        EventBusWrapper.post(errorViewEvent);
    }

    /* loaded from: classes2.dex */
    public static class ErrorViewEvent {
        public static final int MESSAGE_ID_SHOW = 1;
        public static final int MESSAGE_SHOW_ARG0_NA = 1;
        public static final int MESSAGE_SHOW_ARG0_WEB = 2;
        public static final int MSG_INVALID = -1;
        public int arg0;
        public int arg1;
        public int messageId;
        public Object obj;

        public ErrorViewEvent(int i) {
            this.messageId = i;
        }
    }
}
