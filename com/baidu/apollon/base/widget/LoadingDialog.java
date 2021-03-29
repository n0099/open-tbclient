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
    public static final String f3526a = "LoadingDialog";

    /* renamed from: b  reason: collision with root package name */
    public TextView f3527b;

    /* renamed from: c  reason: collision with root package name */
    public String f3528c;

    /* renamed from: d  reason: collision with root package name */
    public Context f3529d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f3530e;

    public LoadingDialog(Context context) {
        super(context, ResUtils.style(context, "ApollonPromptDialog"));
        this.f3529d = null;
        this.f3529d = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.f3529d, "wallet_base_layout_loading_dialog"));
        this.f3527b = (TextView) findViewById(ResUtils.id(this.f3529d, "dialog_msg"));
        if (!TextUtils.isEmpty(this.f3528c)) {
            this.f3527b.setText(this.f3528c);
        }
        ImageView imageView = (ImageView) findViewById(ResUtils.id(this.f3529d, "img_anim"));
        this.f3530e = imageView;
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.stop();
        animationDrawable.start();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void setMessage(int i) {
        TextView textView = this.f3527b;
        if (textView == null) {
            return;
        }
        textView.setText(i);
    }

    public void setMessage(String str) {
        TextView textView = this.f3527b;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public LoadingDialog(Context context, String str) {
        super(context, ResUtils.style(context, "ApollonPromptDialog"));
        this.f3529d = null;
        this.f3528c = str;
        this.f3529d = context;
    }

    public LoadingDialog(Context context, int i) {
        super(context, i);
        this.f3529d = null;
    }
}
