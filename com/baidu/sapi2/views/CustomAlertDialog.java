package com.baidu.sapi2.views;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.baidu.d.a.a;
import com.baidu.sapi2.SapiAccountManager;
/* loaded from: classes2.dex */
public class CustomAlertDialog extends Dialog {
    private TextView msgText;
    private TextView negativeBtn;
    private TextView neutralBtn;
    private TextView positiveBtn;
    private TextView titleText;
    private ViewSwitcher viewSwitcher;

    public CustomAlertDialog(Context context) {
        super(context, a.g.SapiSdkBeautyDialog);
        init();
    }

    public CustomAlertDialog(Context context, int i) {
        super(context, i);
        init();
    }

    public CustomAlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        init();
    }

    private void init() {
        setContentView(a.e.layout_sapi_sdk_dialog_alert);
        setCanceledOnTouchOutside(false);
        this.viewSwitcher = (ViewSwitcher) findViewById(a.d.view_switcher);
        this.titleText = (TextView) findViewById(a.d.title_text);
        this.msgText = (TextView) findViewById(a.d.msg_text);
        this.positiveBtn = (TextView) findViewById(a.d.positive_btn);
        this.negativeBtn = (TextView) findViewById(a.d.negative_btn);
        this.neutralBtn = (TextView) findViewById(a.d.neutral_btn);
        if (SapiAccountManager.getInstance().getSapiConfiguration().isNightMode) {
            ((ViewGroup) this.titleText.getRootView()).addView(((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(a.e.layout_sapi_sdk_night_mode_mask, (ViewGroup) null), new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
        }
    }

    public void setBtnCount(int i) {
        if (i < 1) {
            i = 1;
        } else if (i > 2) {
            i = 2;
        }
        if (i == 2) {
            this.viewSwitcher.setDisplayedChild(0);
        } else {
            this.viewSwitcher.setDisplayedChild(1);
        }
    }

    public void setTitleText(String str) {
        this.titleText.setText(str);
    }

    public void setTitleVisible(int i) {
        this.titleText.setVisibility(i);
    }

    public void setMessageText(String str) {
        this.msgText.setText(str);
    }

    public void setMessageVisible(int i) {
        this.msgText.setVisibility(i);
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        this.positiveBtn.setText(str);
        this.positiveBtn.setOnClickListener(onClickListener);
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        this.negativeBtn.setText(str);
        this.negativeBtn.setOnClickListener(onClickListener);
    }

    public void setNeutralBtn(String str, View.OnClickListener onClickListener) {
        this.neutralBtn.setText(str);
        this.neutralBtn.setOnClickListener(onClickListener);
    }
}
