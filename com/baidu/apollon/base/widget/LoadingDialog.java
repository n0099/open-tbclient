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
    public static final String f3601a = "LoadingDialog";

    /* renamed from: b  reason: collision with root package name */
    public TextView f3602b;

    /* renamed from: c  reason: collision with root package name */
    public String f3603c;

    /* renamed from: d  reason: collision with root package name */
    public Context f3604d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f3605e;

    public LoadingDialog(Context context) {
        super(context, ResUtils.style(context, "ApollonPromptDialog"));
        this.f3604d = null;
        this.f3604d = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.f3604d, "wallet_base_layout_loading_dialog"));
        this.f3602b = (TextView) findViewById(ResUtils.id(this.f3604d, "dialog_msg"));
        if (!TextUtils.isEmpty(this.f3603c)) {
            this.f3602b.setText(this.f3603c);
        }
        ImageView imageView = (ImageView) findViewById(ResUtils.id(this.f3604d, "img_anim"));
        this.f3605e = imageView;
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.stop();
        animationDrawable.start();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void setMessage(int i2) {
        TextView textView = this.f3602b;
        if (textView == null) {
            return;
        }
        textView.setText(i2);
    }

    public void setMessage(String str) {
        TextView textView = this.f3602b;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public LoadingDialog(Context context, String str) {
        super(context, ResUtils.style(context, "ApollonPromptDialog"));
        this.f3604d = null;
        this.f3603c = str;
        this.f3604d = context;
    }

    public LoadingDialog(Context context, int i2) {
        super(context, i2);
        this.f3604d = null;
    }
}
