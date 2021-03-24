package com.baidu.android.lbspay.view;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.statusbar.ImmersiveStatusBarManager;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes2.dex */
public class TitleBar extends LinearLayout {
    public LinearLayout leftBtn;
    public View mStatusBarTop;
    public ImageView rightBtn;
    public TextView titleTv;

    public TitleBar(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.titleTv = (TextView) findViewById(ResUtils.id(getContext(), "title_tv"));
        this.leftBtn = (LinearLayout) findViewById(ResUtils.id(getContext(), "left_btn_container"));
        this.rightBtn = (ImageView) findViewById(ResUtils.id(getContext(), "title_right_btn"));
        this.mStatusBarTop = findViewById(ResUtils.id(getContext(), "titlebar_statusbar_top"));
        setTop();
    }

    public void setLeftButton(View.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.leftBtn.setVisibility(8);
            return;
        }
        this.leftBtn.setVisibility(0);
        this.leftBtn.setOnClickListener(onClickListener);
    }

    public void setRightButton(View.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.rightBtn.setVisibility(8);
            return;
        }
        this.rightBtn.setVisibility(0);
        this.rightBtn.setOnClickListener(onClickListener);
    }

    public void setTitle(String str) {
        this.titleTv.setText(str);
    }

    public void setTop() {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        Activity activity = getContext() instanceof Activity ? (Activity) getContext() : null;
        if (activity == null) {
            return;
        }
        this.mStatusBarTop.setLayoutParams(new LinearLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(activity)));
        ImmersiveStatusBarManager.setTopBar(activity, this.mStatusBarTop, true);
    }

    public TitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
