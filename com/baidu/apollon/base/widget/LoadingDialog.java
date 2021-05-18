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
    public static final String f3602a = "LoadingDialog";

    /* renamed from: b  reason: collision with root package name */
    public TextView f3603b;

    /* renamed from: c  reason: collision with root package name */
    public String f3604c;

    /* renamed from: d  reason: collision with root package name */
    public Context f3605d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f3606e;

    public LoadingDialog(Context context) {
        super(context, ResUtils.style(context, "ApollonPromptDialog"));
        this.f3605d = null;
        this.f3605d = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.f3605d, "wallet_base_layout_loading_dialog"));
        this.f3603b = (TextView) findViewById(ResUtils.id(this.f3605d, "dialog_msg"));
        if (!TextUtils.isEmpty(this.f3604c)) {
            this.f3603b.setText(this.f3604c);
        }
        ImageView imageView = (ImageView) findViewById(ResUtils.id(this.f3605d, "img_anim"));
        this.f3606e = imageView;
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.stop();
        animationDrawable.start();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void setMessage(int i2) {
        TextView textView = this.f3603b;
        if (textView == null) {
            return;
        }
        textView.setText(i2);
    }

    public void setMessage(String str) {
        TextView textView = this.f3603b;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public LoadingDialog(Context context, String str) {
        super(context, ResUtils.style(context, "ApollonPromptDialog"));
        this.f3605d = null;
        this.f3604c = str;
        this.f3605d = context;
    }

    public LoadingDialog(Context context, int i2) {
        super(context, i2);
        this.f3605d = null;
    }
}
