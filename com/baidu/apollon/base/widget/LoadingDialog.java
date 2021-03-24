package com.baidu.apollon.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes2.dex */
public class LoadingDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3525a = "LoadingDialog";

    /* renamed from: b  reason: collision with root package name */
    public TextView f3526b;

    /* renamed from: c  reason: collision with root package name */
    public String f3527c;

    /* renamed from: d  reason: collision with root package name */
    public Context f3528d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f3529e;

    public LoadingDialog(Context context) {
        super(context, ResUtils.style(context, "ApollonPromptDialog"));
        this.f3528d = null;
        this.f3528d = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.f3528d, "wallet_base_layout_loading_dialog"));
        this.f3526b = (TextView) findViewById(ResUtils.id(this.f3528d, "dialog_msg"));
        if (!TextUtils.isEmpty(this.f3527c)) {
            this.f3526b.setText(this.f3527c);
        }
        ImageView imageView = (ImageView) findViewById(ResUtils.id(this.f3528d, "img_anim"));
        this.f3529e = imageView;
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.stop();
        animationDrawable.start();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void setMessage(int i) {
        TextView textView = this.f3526b;
        if (textView == null) {
            return;
        }
        textView.setText(i);
    }

    public void setMessage(String str) {
        TextView textView = this.f3526b;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public LoadingDialog(Context context, String str) {
        super(context, ResUtils.style(context, "ApollonPromptDialog"));
        this.f3528d = null;
        this.f3527c = str;
        this.f3528d = context;
    }

    public LoadingDialog(Context context, int i) {
        super(context, i);
        this.f3528d = null;
    }
}
