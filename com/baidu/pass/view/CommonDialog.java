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
        public Context f9346a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f9347b;

        /* renamed from: c  reason: collision with root package name */
        public String f9348c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f9349d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f9350e = false;

        /* renamed from: f  reason: collision with root package name */
        public String f9351f;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f9352g;

        /* renamed from: h  reason: collision with root package name */
        public String f9353h;
        public View.OnClickListener i;
        public int j;

        public Builder(Context context) {
            this.f9346a = context;
        }

        public CommonDialog build() {
            View inflate = LayoutInflater.from(this.f9346a).inflate(R.layout.pass_sdk_base_ui_common_dialog, (ViewGroup) null);
            CommonDialog commonDialog = new CommonDialog(this.f9346a, R.style.pass_base_ui_common_dialog_style);
            TextView textView = (TextView) inflate.findViewById(R.id.pass_base_ui_dialog_title);
            TextView textView2 = (TextView) inflate.findViewById(R.id.pass_base_ui_dialog_content);
            View findViewById = inflate.findViewById(R.id.pass_base_ui_dialog_horizontal_split_line);
            TextView textView3 = (TextView) inflate.findViewById(R.id.negative_btn);
            TextView textView4 = (TextView) inflate.findViewById(R.id.positive_btn);
            View findViewById2 = inflate.findViewById(R.id.pass_base_ui_dialog_vertical_split_line);
            textView.setText(this.f9348c);
            textView2.setText(TextUtils.isEmpty(this.f9347b) ? "" : this.f9347b);
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            textView2.setHighlightColor(0);
            int i = this.j;
            if (i > 0) {
                textView2.setGravity(i);
            }
            textView3.setText(this.f9353h);
            textView3.setOnClickListener(new a(this, commonDialog));
            textView4.setText(this.f9351f);
            textView4.setOnClickListener(new b(this, commonDialog));
            commonDialog.setContentView(inflate);
            commonDialog.setCancelable(this.f9350e);
            commonDialog.setCanceledOnTouchOutside(this.f9350e);
            Window window = commonDialog.getWindow();
            window.setGravity(17);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 30;
            attributes.y = 30;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            if (this.f9349d) {
                inflate.findViewById(R.id.pass_base_ui_dialog_root_view).setBackgroundResource(R.drawable.pass_base_ui_common_dialog_dark_bg);
                textView.setTextColor(this.f9346a.getResources().getColor(R.color.pass_base_ui_dialog_title_dark_text_color));
                textView2.setTextColor(this.f9346a.getResources().getColor(R.color.pass_base_ui_dialog_content_text_dark_color));
                findViewById.setBackgroundColor(this.f9346a.getResources().getColor(R.color.pass_base_ui_dialog_split_line_dark_color));
                textView3.setTextColor(this.f9346a.getResources().getColor(R.color.pass_base_ui_dialog_negative_btn_text_dark_color));
                textView4.setTextColor(this.f9346a.getResources().getColor(R.color.pass_base_ui_dialog_positive_btn_text_dark_color));
                findViewById2.setBackgroundColor(this.f9346a.getResources().getColor(R.color.pass_base_ui_dialog_split_line_dark_color));
            }
            Context context = this.f9346a;
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
            this.f9350e = z;
            return this;
        }

        public Builder setDarkMode(boolean z) {
            this.f9349d = z;
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.f9347b = charSequence;
            return this;
        }

        public Builder setMessageGravity(int i) {
            this.j = i;
            return this;
        }

        public Builder setNegativeButton(String str, View.OnClickListener onClickListener) {
            this.f9353h = str;
            this.i = onClickListener;
            return this;
        }

        public Builder setPositiveBtn(String str, View.OnClickListener onClickListener) {
            this.f9351f = str;
            this.f9352g = onClickListener;
            return this;
        }

        public Builder setTitle(String str) {
            this.f9348c = str;
            return this;
        }
    }

    public CommonDialog(Context context, int i) {
        super(context, i);
    }
}
