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
    public static final String f3624a = "LoadingDialog";

    /* renamed from: b  reason: collision with root package name */
    public TextView f3625b;

    /* renamed from: c  reason: collision with root package name */
    public String f3626c;

    /* renamed from: d  reason: collision with root package name */
    public Context f3627d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f3628e;

    public LoadingDialog(Context context) {
        super(context, ResUtils.style(context, "ApollonPromptDialog"));
        this.f3627d = null;
        this.f3627d = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.f3627d, "wallet_base_layout_loading_dialog"));
        this.f3625b = (TextView) findViewById(ResUtils.id(this.f3627d, "dialog_msg"));
        if (!TextUtils.isEmpty(this.f3626c)) {
            this.f3625b.setText(this.f3626c);
        }
        ImageView imageView = (ImageView) findViewById(ResUtils.id(this.f3627d, "img_anim"));
        this.f3628e = imageView;
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.stop();
        animationDrawable.start();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void setMessage(int i2) {
        TextView textView = this.f3625b;
        if (textView == null) {
            return;
        }
        textView.setText(i2);
    }

    public void setMessage(String str) {
        TextView textView = this.f3625b;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public LoadingDialog(Context context, String str) {
        super(context, ResUtils.style(context, "ApollonPromptDialog"));
        this.f3627d = null;
        this.f3626c = str;
        this.f3627d = context;
    }

    public LoadingDialog(Context context, int i2) {
        super(context, i2);
        this.f3627d = null;
    }
}
