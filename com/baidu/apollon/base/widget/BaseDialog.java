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
/* loaded from: classes2.dex */
public abstract class BaseDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public TextView f3511a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f3512b;

    /* renamed from: c  reason: collision with root package name */
    public Button f3513c;

    /* renamed from: d  reason: collision with root package name */
    public Button f3514d;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f3515e;

    /* renamed from: f  reason: collision with root package name */
    public View f3516f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout.LayoutParams f3517g;

    /* renamed from: h  reason: collision with root package name */
    public LayoutInflater f3518h;
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
        this.f3512b.removeAllViews();
        this.f3512b.addView(view, this.f3517g);
    }

    public void hideButtons() {
        findViewById(ResUtils.id(this.mContext, "dialog_btns")).setVisibility(8);
    }

    public void hideNegativeButton() {
        Button button = this.f3514d;
        if (button != null) {
            button.setVisibility(8);
        }
        View view = this.f3516f;
        if (view != null) {
            view.setVisibility(8);
        }
        this.f3513c.setBackgroundResource(ResUtils.drawable(this.mContext, "wallet_base_dialog_btn_selector"));
    }

    public void hidePositiveButton() {
        Button button = this.f3513c;
        if (button != null) {
            button.setVisibility(8);
        }
        View view = this.f3516f;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void hideTitle() {
        this.f3511a.setVisibility(8);
    }

    public void hideTitleLine() {
        findViewById(ResUtils.id(this.mContext, "dialog_title_line")).setVisibility(8);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.mContext, "wallet_base_layout_dialog_base"));
        this.f3511a = (TextView) findViewById(ResUtils.id(this.mContext, "dialog_title"));
        this.f3513c = (Button) findViewById(ResUtils.id(this.mContext, "positive_btn"));
        this.f3514d = (Button) findViewById(ResUtils.id(this.mContext, "negative_btn"));
        this.f3515e = (ImageButton) findViewById(ResUtils.id(this.mContext, "dialog_title_close"));
        this.f3516f = findViewById(ResUtils.id(this.mContext, "btn_line"));
        this.f3513c.setOnClickListener(this.i);
        this.f3514d.setOnClickListener(this.i);
        this.f3515e.setOnClickListener(this.i);
        this.f3512b = (LinearLayout) findViewById(ResUtils.id(this.mContext, "dialog_content_layout"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.f3517g = layoutParams;
        layoutParams.gravity = 17;
        this.f3518h = LayoutInflater.from(this.mContext);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void setNegativeBtn(View.OnClickListener onClickListener) {
        Button button = this.f3514d;
        if (button != null) {
            if (onClickListener == null) {
                onClickListener = this.i;
            }
            button.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtn(View.OnClickListener onClickListener) {
        Button button = this.f3513c;
        if (button != null) {
            if (onClickListener == null) {
                onClickListener = this.i;
            }
            button.setOnClickListener(onClickListener);
        }
    }

    public void setTitleText(int i) {
        TextView textView = this.f3511a;
        if (textView == null) {
            return;
        }
        textView.setText(i);
    }

    public void setTitleTextBackgroud(int i) {
        TextView textView = this.f3511a;
        if (textView == null) {
            return;
        }
        textView.setBackgroundColor(i);
    }

    public void showCloseBtn(boolean z) {
        ImageButton imageButton = this.f3515e;
        if (imageButton != null) {
            imageButton.setVisibility(z ? 0 : 4);
        }
    }

    public void addContentView(View view, LinearLayout.LayoutParams layoutParams) {
        this.f3512b.removeAllViews();
        this.f3512b.addView(view, layoutParams);
    }

    public void setNegativeBtn(int i, View.OnClickListener onClickListener) {
        Button button = this.f3514d;
        if (button != null) {
            button.setText(i);
            Button button2 = this.f3514d;
            if (onClickListener == null) {
                onClickListener = this.i;
            }
            button2.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtn(int i, View.OnClickListener onClickListener) {
        Button button = this.f3513c;
        if (button != null) {
            button.setText(i);
            Button button2 = this.f3513c;
            if (onClickListener == null) {
                onClickListener = this.i;
            }
            button2.setOnClickListener(onClickListener);
        }
    }

    public void setTitleText(String str) {
        TextView textView = this.f3511a;
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
        this.f3512b.removeAllViews();
        this.f3512b.addView(this.f3518h.inflate(i, (ViewGroup) null), this.f3517g);
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        if (this.f3514d != null) {
            if (!TextUtils.isEmpty(str)) {
                this.f3514d.setText(str);
            }
            Button button = this.f3514d;
            if (onClickListener == null) {
                onClickListener = this.i;
            }
            button.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        Button button = this.f3513c;
        if (button != null) {
            button.setText(spannableString);
            Button button2 = this.f3513c;
            if (onClickListener == null) {
                onClickListener = this.i;
            }
            button2.setOnClickListener(onClickListener);
        }
    }

    public void addContentView(int i, LinearLayout.LayoutParams layoutParams) {
        this.f3512b.removeAllViews();
        this.f3512b.addView(this.f3518h.inflate(i, (ViewGroup) null), layoutParams);
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        if (this.f3513c != null) {
            if (!TextUtils.isEmpty(str)) {
                this.f3513c.setText(str);
            }
            Button button = this.f3513c;
            if (onClickListener == null) {
                onClickListener = this.i;
            }
            button.setOnClickListener(onClickListener);
        }
    }
}
