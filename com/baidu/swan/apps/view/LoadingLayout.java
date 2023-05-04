package com.baidu.swan.apps.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class LoadingLayout extends LinearLayout {
    public ImageView a;
    public TextView b;

    public LoadingLayout(Context context) {
        super(context);
    }

    public void b(boolean z) {
        if (z) {
            setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f01014d);
            this.a.setImageResource(R.drawable.obfuscated_res_0x7f08124f);
            this.a.startAnimation(loadAnimation);
            return;
        }
        setVisibility(8);
    }

    public LoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d089d, (ViewGroup) null);
        inflate.setBackgroundColor(-1);
        this.a = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09024d);
        this.b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09024e);
        addView(inflate);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        a();
    }
}
