package com.baidu.pass.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.pass.R;
import com.baidu.pass.utils.CommonViewUtility;
import java.util.List;
/* loaded from: classes10.dex */
public class ConfirmDialog extends Dialog implements com.baidu.pass.a {

    /* loaded from: classes10.dex */
    public static class Builder implements com.baidu.pass.a {

        /* renamed from: a  reason: collision with root package name */
        private Context f2806a;
        private String b;
        private String c;
        private boolean d;
        private boolean e = false;
        private View f;
        private View g;
        private String h;
        private View.OnClickListener i;
        private String j;
        private View.OnClickListener k;
        private String l;
        private View.OnClickListener m;
        private SpannableStringBuilder n;
        private List<String> o;
        private int p;

        public Builder(Context context) {
            this.f2806a = context;
        }

        public ConfirmDialog build() {
            View inflate = LayoutInflater.from(this.f2806a).inflate(R.layout.layout_pass_confirm_dialog, (ViewGroup) null);
            ConfirmDialog confirmDialog = new ConfirmDialog(this.f2806a, R.style.style_pass_dialog, this.d);
            this.f = inflate.findViewById(R.id.first_style_btn);
            this.g = inflate.findViewById(R.id.second_style_btn);
            TextView textView = (TextView) inflate.findViewById(R.id.title);
            AlignPartTextView alignPartTextView = (AlignPartTextView) inflate.findViewById(R.id.message);
            TextView textView2 = (TextView) inflate.findViewById(R.id.negative_btn);
            TextView textView3 = (TextView) inflate.findViewById(R.id.positive_btn);
            TextView textView4 = (TextView) inflate.findViewById(R.id.next_btn);
            CommonViewUtility.setViewClickAlpha(textView2, 0.2f);
            CommonViewUtility.setViewClickAlpha(textView3, 0.2f);
            CommonViewUtility.setViewClickAlpha(textView4, 0.2f);
            textView.setText(this.c);
            if (!TextUtils.isEmpty(this.b)) {
                alignPartTextView.setText(this.b);
            } else {
                SpannableStringBuilder spannableStringBuilder = this.n;
                if (spannableStringBuilder != null) {
                    alignPartTextView.setText(spannableStringBuilder);
                    alignPartTextView.a(this.o, this.p);
                    alignPartTextView.setMovementMethod(LinkMovementMethod.getInstance());
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                alignPartTextView.setLetterSpacing(0.2f);
            }
            textView4.setText(this.h);
            textView4.setOnClickListener(new a(this, confirmDialog));
            textView2.setText(this.l);
            textView2.setOnClickListener(new b(this, confirmDialog));
            textView3.setText(this.j);
            textView3.setOnClickListener(new c(this, confirmDialog));
            if (this.i == null) {
                this.f.setVisibility(0);
                this.g.setVisibility(8);
            } else {
                this.f.setVisibility(8);
                this.g.setVisibility(0);
            }
            confirmDialog.setContentView(inflate);
            confirmDialog.setCancelable(this.e);
            confirmDialog.setCanceledOnTouchOutside(this.e);
            Window window = confirmDialog.getWindow();
            window.setGravity(17);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 30;
            attributes.y = 30;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            if (this.d) {
                inflate.findViewById(R.id.root_view).setBackgroundResource(R.drawable.drawable_pass_dialog_rounded_corner_night);
                textView.setTextColor(this.f2806a.getResources().getColor(R.color.pass_httpclient_permissions_dialog_title_text_color_night));
                alignPartTextView.setTextColor(this.f2806a.getResources().getColor(R.color.pass_httpclient_permissions_dialog_content_text_color_night));
                textView2.setBackground(this.f2806a.getResources().getDrawable(R.drawable.pass_httpclient_permissions_dialog_negative_btn_bg_night));
                textView2.setTextColor(this.f2806a.getResources().getColor(R.color.pass_httpclient_permissions_dialog_negative_btn_text_color_night));
                textView3.setBackground(this.f2806a.getResources().getDrawable(R.drawable.pass_httpclient_permissions_dialog_positive_btn_bg_night));
                textView3.setTextColor(this.f2806a.getResources().getColor(R.color.pass_httpclient_permissions_dialog_positive_btn_text_color_night));
                textView4.setBackground(this.f2806a.getResources().getDrawable(R.drawable.pass_httpclient_permissions_dialog_negative_btn_bg_night));
                textView4.setTextColor(this.f2806a.getResources().getColor(R.color.pass_httpclient_permissions_dialog_negative_btn_text_color_night));
            }
            Context context = this.f2806a;
            if (context instanceof Activity) {
                Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
                WindowManager.LayoutParams attributes2 = confirmDialog.getWindow().getAttributes();
                attributes.width = defaultDisplay.getWidth();
                attributes.height = -2;
                confirmDialog.getWindow().setAttributes(attributes2);
            }
            return confirmDialog;
        }

        public Builder setCancelable(boolean z) {
            this.e = z;
            return this;
        }

        public Builder setDarkMode(boolean z) {
            this.d = z;
            return this;
        }

        public Builder setMessage(String str) {
            this.b = str;
            return this;
        }

        public Builder setNegativeButton(String str, View.OnClickListener onClickListener) {
            this.l = str;
            this.m = onClickListener;
            return this;
        }

        public Builder setNextButton(String str, View.OnClickListener onClickListener) {
            this.h = str;
            this.i = onClickListener;
            return this;
        }

        public Builder setPositiveBtn(String str, View.OnClickListener onClickListener) {
            this.j = str;
            this.k = onClickListener;
            return this;
        }

        public Builder setTitle(String str) {
            this.c = str;
            return this;
        }

        public Builder setMessage(SpannableStringBuilder spannableStringBuilder, List<String> list, int i) {
            this.n = spannableStringBuilder;
            this.o = list;
            this.p = i;
            return this;
        }
    }

    public ConfirmDialog(Context context, int i, boolean z) {
        super(context, i);
    }
}
