package com.baidu.apollon.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes.dex */
public class LoadingDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3561a = "LoadingDialog";

    /* renamed from: b  reason: collision with root package name */
    public TextView f3562b;

    /* renamed from: c  reason: collision with root package name */
    public String f3563c;

    /* renamed from: d  reason: collision with root package name */
    public Context f3564d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f3565e;

    public LoadingDialog(Context context) {
        super(context, ResUtils.style(context, "ApollonPromptDialog"));
        this.f3564d = null;
        this.f3564d = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.f3564d, "wallet_base_layout_loading_dialog"));
        this.f3562b = (TextView) findViewById(ResUtils.id(this.f3564d, "dialog_msg"));
        if (!TextUtils.isEmpty(this.f3563c)) {
            this.f3562b.setText(this.f3563c);
        }
        ImageView imageView = (ImageView) findViewById(ResUtils.id(this.f3564d, "img_anim"));
        this.f3565e = imageView;
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.stop();
        animationDrawable.start();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void setMessage(int i) {
        TextView textView = this.f3562b;
        if (textView == null) {
            return;
        }
        textView.setText(i);
    }

    public void setMessage(String str) {
        TextView textView = this.f3562b;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public LoadingDialog(Context context, String str) {
        super(context, ResUtils.style(context, "ApollonPromptDialog"));
        this.f3564d = null;
        this.f3563c = str;
        this.f3564d = context;
    }

    public LoadingDialog(Context context, int i) {
        super(context, i);
        this.f3564d = null;
    }
}
