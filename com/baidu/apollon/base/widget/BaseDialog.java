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
    public TextView f3547a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f3548b;

    /* renamed from: c  reason: collision with root package name */
    public Button f3549c;

    /* renamed from: d  reason: collision with root package name */
    public Button f3550d;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f3551e;

    /* renamed from: f  reason: collision with root package name */
    public View f3552f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout.LayoutParams f3553g;

    /* renamed from: h  reason: collision with root package name */
    public LayoutInflater f3554h;
    public View.OnClickListener i;
    public Context mContext;

    public BaseDialog(Context context) {
        super(context, ResUtils.style(context, "ApollonPromptDialog"));
        this.i = new View.OnClickListener() { // from class: com.baidu.apollon.base.widget.BaseDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseDialog.this.dismiss();
            }
        };
        this.mContext = context;
    }

    public void addContentView(View view) {
        this.f3548b.removeAllViews();
        this.f3548b.addView(view, this.f3553g);
    }

    public void hideButtons() {
        findViewById(ResUtils.id(this.mContext, "dialog_btns")).setVisibility(8);
    }

    public void hideNegativeButton() {
        Button button = this.f3550d;
        if (button != null) {
            button.setVisibility(8);
        }
        View view = this.f3552f;
        if (view != null) {
            view.setVisibility(8);
        }
        this.f3549c.setBackgroundResource(ResUtils.drawable(this.mContext, "wallet_base_dialog_btn_selector"));
    }

    public void hidePositiveButton() {
        Button button = this.f3549c;
        if (button != null) {
            button.setVisibility(8);
        }
        View view = this.f3552f;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void hideTitle() {
        this.f3547a.setVisibility(8);
    }

    public void hideTitleLine() {
        findViewById(ResUtils.id(this.mContext, "dialog_title_line")).setVisibility(8);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.mContext, "wallet_base_layout_dialog_base"));
        this.f3547a = (TextView) findViewById(ResUtils.id(this.mContext, "dialog_title"));
        this.f3549c = (Button) findViewById(ResUtils.id(this.mContext, "positive_btn"));
        this.f3550d = (Button) findViewById(ResUtils.id(this.mContext, "negative_btn"));
        this.f3551e = (ImageButton) findViewById(ResUtils.id(this.mContext, "dialog_title_close"));
        this.f3552f = findViewById(ResUtils.id(this.mContext, "btn_line"));
        this.f3549c.setOnClickListener(this.i);
        this.f3550d.setOnClickListener(this.i);
        this.f3551e.setOnClickListener(this.i);
        this.f3548b = (LinearLayout) findViewById(ResUtils.id(this.mContext, "dialog_content_layout"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.f3553g = layoutParams;
        layoutParams.gravity = 17;
        this.f3554h = LayoutInflater.from(this.mContext);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void setNegativeBtn(View.OnClickListener onClickListener) {
        Button button = this.f3550d;
        if (button != null) {
            if (onClickListener == null) {
                onClickListener = this.i;
            }
            button.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtn(View.OnClickListener onClickListener) {
        Button button = this.f3549c;
        if (button != null) {
            if (onClickListener == null) {
                onClickListener = this.i;
            }
            button.setOnClickListener(onClickListener);
        }
    }

    public void setTitleText(int i) {
        TextView textView = this.f3547a;
        if (textView == null) {
            return;
        }
        textView.setText(i);
    }

    public void setTitleTextBackgroud(int i) {
        TextView textView = this.f3547a;
        if (textView == null) {
            return;
        }
        textView.setBackgroundColor(i);
    }

    public void showCloseBtn(boolean z) {
        ImageButton imageButton = this.f3551e;
        if (imageButton != null) {
            imageButton.setVisibility(z ? 0 : 4);
        }
    }

    public void addContentView(View view, LinearLayout.LayoutParams layoutParams) {
        this.f3548b.removeAllViews();
        this.f3548b.addView(view, layoutParams);
    }

    public void setNegativeBtn(int i, View.OnClickListener onClickListener) {
        Button button = this.f3550d;
        if (button != null) {
            button.setText(i);
            Button button2 = this.f3550d;
            if (onClickListener == null) {
                onClickListener = this.i;
            }
            button2.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtn(int i, View.OnClickListener onClickListener) {
        Button button = this.f3549c;
        if (button != null) {
            button.setText(i);
            Button button2 = this.f3549c;
            if (onClickListener == null) {
                onClickListener = this.i;
            }
            button2.setOnClickListener(onClickListener);
        }
    }

    public void setTitleText(String str) {
        TextView textView = this.f3547a;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public BaseDialog(Context context, int i) {
        super(context, i);
        this.i = new View.OnClickListener() { // from class: com.baidu.apollon.base.widget.BaseDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseDialog.this.dismiss();
            }
        };
        this.mContext = context;
    }

    public void addContentView(int i) {
        this.f3548b.removeAllViews();
        this.f3548b.addView(this.f3554h.inflate(i, (ViewGroup) null), this.f3553g);
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        if (this.f3550d != null) {
            if (!TextUtils.isEmpty(str)) {
                this.f3550d.setText(str);
            }
            Button button = this.f3550d;
            if (onClickListener == null) {
                onClickListener = this.i;
            }
            button.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        Button button = this.f3549c;
        if (button != null) {
            button.setText(spannableString);
            Button button2 = this.f3549c;
            if (onClickListener == null) {
                onClickListener = this.i;
            }
            button2.setOnClickListener(onClickListener);
        }
    }

    public void addContentView(int i, LinearLayout.LayoutParams layoutParams) {
        this.f3548b.removeAllViews();
        this.f3548b.addView(this.f3554h.inflate(i, (ViewGroup) null), layoutParams);
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        if (this.f3549c != null) {
            if (!TextUtils.isEmpty(str)) {
                this.f3549c.setText(str);
            }
            Button button = this.f3549c;
            if (onClickListener == null) {
                onClickListener = this.i;
            }
            button.setOnClickListener(onClickListener);
        }
    }
}
