package com.baidu.apollon.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes.dex */
public abstract class BaseDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public TextView f3587a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f3588b;

    /* renamed from: c  reason: collision with root package name */
    public Button f3589c;

    /* renamed from: d  reason: collision with root package name */
    public Button f3590d;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f3591e;

    /* renamed from: f  reason: collision with root package name */
    public View f3592f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout.LayoutParams f3593g;

    /* renamed from: h  reason: collision with root package name */
    public LayoutInflater f3594h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f3595i;
    public Context mContext;

    public BaseDialog(Context context) {
        super(context, ResUtils.style(context, "ApollonPromptDialog"));
        this.f3595i = new View.OnClickListener() { // from class: com.baidu.apollon.base.widget.BaseDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseDialog.this.dismiss();
            }
        };
        this.mContext = context;
    }

    public void addContentView(View view) {
        this.f3588b.removeAllViews();
        this.f3588b.addView(view, this.f3593g);
    }

    public void hideButtons() {
        findViewById(ResUtils.id(this.mContext, "dialog_btns")).setVisibility(8);
    }

    public void hideNegativeButton() {
        Button button = this.f3590d;
        if (button != null) {
            button.setVisibility(8);
        }
        View view = this.f3592f;
        if (view != null) {
            view.setVisibility(8);
        }
        this.f3589c.setBackgroundResource(ResUtils.drawable(this.mContext, "wallet_base_dialog_btn_selector"));
    }

    public void hidePositiveButton() {
        Button button = this.f3589c;
        if (button != null) {
            button.setVisibility(8);
        }
        View view = this.f3592f;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void hideTitle() {
        this.f3587a.setVisibility(8);
    }

    public void hideTitleLine() {
        findViewById(ResUtils.id(this.mContext, "dialog_title_line")).setVisibility(8);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.mContext, "wallet_base_layout_dialog_base"));
        this.f3587a = (TextView) findViewById(ResUtils.id(this.mContext, "dialog_title"));
        this.f3589c = (Button) findViewById(ResUtils.id(this.mContext, "positive_btn"));
        this.f3590d = (Button) findViewById(ResUtils.id(this.mContext, "negative_btn"));
        this.f3591e = (ImageButton) findViewById(ResUtils.id(this.mContext, "dialog_title_close"));
        this.f3592f = findViewById(ResUtils.id(this.mContext, "btn_line"));
        this.f3589c.setOnClickListener(this.f3595i);
        this.f3590d.setOnClickListener(this.f3595i);
        this.f3591e.setOnClickListener(this.f3595i);
        this.f3588b = (LinearLayout) findViewById(ResUtils.id(this.mContext, "dialog_content_layout"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.f3593g = layoutParams;
        layoutParams.gravity = 17;
        this.f3594h = LayoutInflater.from(this.mContext);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void setNegativeBtn(View.OnClickListener onClickListener) {
        Button button = this.f3590d;
        if (button != null) {
            if (onClickListener == null) {
                onClickListener = this.f3595i;
            }
            button.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtn(View.OnClickListener onClickListener) {
        Button button = this.f3589c;
        if (button != null) {
            if (onClickListener == null) {
                onClickListener = this.f3595i;
            }
            button.setOnClickListener(onClickListener);
        }
    }

    public void setTitleText(int i2) {
        TextView textView = this.f3587a;
        if (textView == null) {
            return;
        }
        textView.setText(i2);
    }

    public void setTitleTextBackgroud(int i2) {
        TextView textView = this.f3587a;
        if (textView == null) {
            return;
        }
        textView.setBackgroundColor(i2);
    }

    public void showCloseBtn(boolean z) {
        ImageButton imageButton = this.f3591e;
        if (imageButton != null) {
            imageButton.setVisibility(z ? 0 : 4);
        }
    }

    public void addContentView(View view, LinearLayout.LayoutParams layoutParams) {
        this.f3588b.removeAllViews();
        this.f3588b.addView(view, layoutParams);
    }

    public void setNegativeBtn(int i2, View.OnClickListener onClickListener) {
        Button button = this.f3590d;
        if (button != null) {
            button.setText(i2);
            Button button2 = this.f3590d;
            if (onClickListener == null) {
                onClickListener = this.f3595i;
            }
            button2.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtn(int i2, View.OnClickListener onClickListener) {
        Button button = this.f3589c;
        if (button != null) {
            button.setText(i2);
            Button button2 = this.f3589c;
            if (onClickListener == null) {
                onClickListener = this.f3595i;
            }
            button2.setOnClickListener(onClickListener);
        }
    }

    public void setTitleText(String str) {
        TextView textView = this.f3587a;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public BaseDialog(Context context, int i2) {
        super(context, i2);
        this.f3595i = new View.OnClickListener() { // from class: com.baidu.apollon.base.widget.BaseDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseDialog.this.dismiss();
            }
        };
        this.mContext = context;
    }

    public void addContentView(int i2) {
        this.f3588b.removeAllViews();
        this.f3588b.addView(this.f3594h.inflate(i2, (ViewGroup) null), this.f3593g);
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        if (this.f3590d != null) {
            if (!TextUtils.isEmpty(str)) {
                this.f3590d.setText(str);
            }
            Button button = this.f3590d;
            if (onClickListener == null) {
                onClickListener = this.f3595i;
            }
            button.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        Button button = this.f3589c;
        if (button != null) {
            button.setText(spannableString);
            Button button2 = this.f3589c;
            if (onClickListener == null) {
                onClickListener = this.f3595i;
            }
            button2.setOnClickListener(onClickListener);
        }
    }

    public void addContentView(int i2, LinearLayout.LayoutParams layoutParams) {
        this.f3588b.removeAllViews();
        this.f3588b.addView(this.f3594h.inflate(i2, (ViewGroup) null), layoutParams);
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        if (this.f3589c != null) {
            if (!TextUtils.isEmpty(str)) {
                this.f3589c.setText(str);
            }
            Button button = this.f3589c;
            if (onClickListener == null) {
                onClickListener = this.f3595i;
            }
            button.setOnClickListener(onClickListener);
        }
    }
}
