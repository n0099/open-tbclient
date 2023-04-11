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
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class CommonDialog extends Dialog implements com.baidu.pass.a {

    /* loaded from: classes2.dex */
    public static class Builder implements com.baidu.pass.a {
        public Context a;
        public CharSequence b;
        public String c;
        public boolean d;
        public boolean e = false;
        public String f;
        public View.OnClickListener g;
        public String h;
        public View.OnClickListener i;
        public int j;

        public Builder(Context context) {
            this.a = context;
        }

        public Builder setCancelable(boolean z) {
            this.e = z;
            return this;
        }

        public Builder setDarkMode(boolean z) {
            this.d = z;
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.b = charSequence;
            return this;
        }

        public Builder setMessageGravity(int i) {
            this.j = i;
            return this;
        }

        public Builder setTitle(String str) {
            this.c = str;
            return this;
        }

        public CommonDialog build() {
            CharSequence charSequence;
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d06f2, (ViewGroup) null);
            CommonDialog commonDialog = new CommonDialog(this.a, R.style.obfuscated_res_0x7f1003dc);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09192b);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091928);
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f091929);
            TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0917fa);
            TextView textView4 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091bc2);
            View findViewById2 = inflate.findViewById(R.id.obfuscated_res_0x7f09192c);
            textView.setText(this.c);
            if (TextUtils.isEmpty(this.b)) {
                charSequence = "";
            } else {
                charSequence = this.b;
            }
            textView2.setText(charSequence);
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            textView2.setHighlightColor(0);
            int i = this.j;
            if (i > 0) {
                textView2.setGravity(i);
            }
            textView3.setText(this.h);
            textView3.setOnClickListener(new a(this, commonDialog));
            textView4.setText(this.f);
            textView4.setOnClickListener(new b(this, commonDialog));
            commonDialog.setContentView(inflate);
            commonDialog.setCancelable(this.e);
            commonDialog.setCanceledOnTouchOutside(this.e);
            Window window = commonDialog.getWindow();
            window.setGravity(17);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 30;
            attributes.y = 30;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            if (this.d) {
                inflate.findViewById(R.id.obfuscated_res_0x7f09192a).setBackgroundResource(R.drawable.obfuscated_res_0x7f080f07);
                textView.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06077e));
                textView2.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060777));
                findViewById.setBackgroundColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06077d));
                textView3.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060779));
                textView4.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06077b));
                findViewById2.setBackgroundColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06077d));
            }
            Context context = this.a;
            if (context instanceof Activity) {
                Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
                WindowManager.LayoutParams attributes2 = commonDialog.getWindow().getAttributes();
                attributes.width = defaultDisplay.getWidth();
                attributes.height = -2;
                commonDialog.getWindow().setAttributes(attributes2);
            }
            return commonDialog;
        }

        public Builder setNegativeButton(String str, View.OnClickListener onClickListener) {
            this.h = str;
            this.i = onClickListener;
            return this;
        }

        public Builder setPositiveBtn(String str, View.OnClickListener onClickListener) {
            this.f = str;
            this.g = onClickListener;
            return this;
        }
    }

    public CommonDialog(Context context, int i) {
        super(context, i);
    }
}
