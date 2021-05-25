package com.baidu.pass.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
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
/* loaded from: classes2.dex */
public class CommonDialog extends Dialog implements com.baidu.pass.a {

    /* loaded from: classes2.dex */
    public static class Builder implements com.baidu.pass.a {

        /* renamed from: a  reason: collision with root package name */
        public Context f9216a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f9217b;

        /* renamed from: c  reason: collision with root package name */
        public String f9218c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f9219d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f9220e = false;

        /* renamed from: f  reason: collision with root package name */
        public String f9221f;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f9222g;

        /* renamed from: h  reason: collision with root package name */
        public String f9223h;

        /* renamed from: i  reason: collision with root package name */
        public View.OnClickListener f9224i;
        public int j;

        public Builder(Context context) {
            this.f9216a = context;
        }

        public CommonDialog build() {
            View inflate = LayoutInflater.from(this.f9216a).inflate(R.layout.pass_sdk_base_ui_common_dialog, (ViewGroup) null);
            CommonDialog commonDialog = new CommonDialog(this.f9216a, R.style.pass_base_ui_common_dialog_style);
            TextView textView = (TextView) inflate.findViewById(R.id.pass_base_ui_dialog_title);
            TextView textView2 = (TextView) inflate.findViewById(R.id.pass_base_ui_dialog_content);
            View findViewById = inflate.findViewById(R.id.pass_base_ui_dialog_horizontal_split_line);
            TextView textView3 = (TextView) inflate.findViewById(R.id.negative_btn);
            TextView textView4 = (TextView) inflate.findViewById(R.id.positive_btn);
            View findViewById2 = inflate.findViewById(R.id.pass_base_ui_dialog_vertical_split_line);
            textView.setText(this.f9218c);
            textView2.setText(TextUtils.isEmpty(this.f9217b) ? "" : this.f9217b);
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            textView2.setHighlightColor(0);
            int i2 = this.j;
            if (i2 > 0) {
                textView2.setGravity(i2);
            }
            textView3.setText(this.f9223h);
            textView3.setOnClickListener(new a(this, commonDialog));
            textView4.setText(this.f9221f);
            textView4.setOnClickListener(new b(this, commonDialog));
            commonDialog.setContentView(inflate);
            commonDialog.setCancelable(this.f9220e);
            commonDialog.setCanceledOnTouchOutside(this.f9220e);
            Window window = commonDialog.getWindow();
            window.setGravity(17);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 30;
            attributes.y = 30;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            if (this.f9219d) {
                inflate.findViewById(R.id.pass_base_ui_dialog_root_view).setBackgroundResource(R.drawable.pass_base_ui_common_dialog_dark_bg);
                textView.setTextColor(this.f9216a.getResources().getColor(R.color.pass_base_ui_dialog_title_dark_text_color));
                textView2.setTextColor(this.f9216a.getResources().getColor(R.color.pass_base_ui_dialog_content_text_dark_color));
                findViewById.setBackgroundColor(this.f9216a.getResources().getColor(R.color.pass_base_ui_dialog_split_line_dark_color));
                textView3.setTextColor(this.f9216a.getResources().getColor(R.color.pass_base_ui_dialog_negative_btn_text_dark_color));
                textView4.setTextColor(this.f9216a.getResources().getColor(R.color.pass_base_ui_dialog_positive_btn_text_dark_color));
                findViewById2.setBackgroundColor(this.f9216a.getResources().getColor(R.color.pass_base_ui_dialog_split_line_dark_color));
            }
            Context context = this.f9216a;
            if (context instanceof Activity) {
                Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
                WindowManager.LayoutParams attributes2 = commonDialog.getWindow().getAttributes();
                attributes.width = defaultDisplay.getWidth();
                attributes.height = -2;
                commonDialog.getWindow().setAttributes(attributes2);
            }
            return commonDialog;
        }

        public Builder setCancelable(boolean z) {
            this.f9220e = z;
            return this;
        }

        public Builder setDarkMode(boolean z) {
            this.f9219d = z;
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.f9217b = charSequence;
            return this;
        }

        public Builder setMessageGravity(int i2) {
            this.j = i2;
            return this;
        }

        public Builder setNegativeButton(String str, View.OnClickListener onClickListener) {
            this.f9223h = str;
            this.f9224i = onClickListener;
            return this;
        }

        public Builder setPositiveBtn(String str, View.OnClickListener onClickListener) {
            this.f9221f = str;
            this.f9222g = onClickListener;
            return this;
        }

        public Builder setTitle(String str) {
            this.f9218c = str;
            return this;
        }
    }

    public CommonDialog(Context context, int i2) {
        super(context, i2);
    }
}
