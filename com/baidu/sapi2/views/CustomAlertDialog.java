package com.baidu.sapi2.views;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.baidu.b.a.a;
/* loaded from: classes2.dex */
public class CustomAlertDialog extends Dialog {
    private Spinner domainSpinner;
    private TextView msgText;
    private Button negativeBtn;
    private Button neutralBtn;
    private Button positiveBtn;
    private LinearLayout spinnerLayout;
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
        this.msgText = (TextView) findViewById(a.d.msg_text);
        this.positiveBtn = (Button) findViewById(a.d.positive_btn);
        this.negativeBtn = (Button) findViewById(a.d.negative_btn);
        this.neutralBtn = (Button) findViewById(a.d.neutral_btn);
        this.spinnerLayout = (LinearLayout) findViewById(a.d.spinner_layout);
        this.domainSpinner = (Spinner) findViewById(a.d.domain_spinner);
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

    public void setMessageText(String str) {
        this.msgText.setText(str);
    }

    public void setMessageIcon(int i) {
        this.msgText.setText(i);
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

    public void setSpinnerVisible(ArrayAdapter arrayAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener, int i) {
        this.spinnerLayout.setVisibility(0);
        this.domainSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
        this.domainSpinner.setOnItemSelectedListener(onItemSelectedListener);
        this.domainSpinner.setSelection(i);
    }
}
