package com.baidu.live.business.view.emotion;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.dc0;
import com.baidu.tieba.m90;
import com.baidu.tieba.u90;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes2.dex */
public class MinorView extends LinearLayout {
    public SimpleDraweeView a;
    public AppCompatTextView b;
    public AppCompatTextView c;
    public AppCompatTextView d;
    public u90 e;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!m90.f(MinorView.this.getContext())) {
                Toast.makeText(MinorView.this.getContext(), (int) R.string.obfuscated_res_0x7f0f0acc, 1).show();
            } else if (MinorView.this.e != null) {
                MinorView.this.e.a(view2);
            }
        }
    }

    public MinorView(Context context) {
        this(context, null);
    }

    public void setActionCallback(u90 u90Var) {
        this.e = u90Var;
    }

    public void setImageResource(int i) {
        if (i != -1) {
            this.a.setActualImageResource(i);
        }
    }

    public void setText(int i) {
        this.b.setText(i);
    }

    public MinorView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MinorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d058d, this);
        setOrientation(1);
        setGravity(17);
        this.a = (SimpleDraweeView) findViewById(R.id.obfuscated_res_0x7f0916c6);
        this.b = (AppCompatTextView) findViewById(R.id.obfuscated_res_0x7f0916c8);
        this.c = (AppCompatTextView) findViewById(R.id.obfuscated_res_0x7f0916c5);
        this.d = (AppCompatTextView) findViewById(R.id.obfuscated_res_0x7f090aaa);
        b();
    }

    public void b() {
        this.d.setOnClickListener(new a());
    }

    public void c(String str) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.getLayoutParams();
        layoutParams.width = m90.b(getContext(), EmotionStrategy.getInstance().minorWidth);
        layoutParams.height = m90.b(getContext(), EmotionStrategy.getInstance().minorHeight);
        this.a.setLayoutParams(layoutParams);
        setImageResource(dc0.f().i(str));
        this.b.setTextColor(dc0.f().a(getContext(), str, "color_8585853"));
        this.c.setTextColor(dc0.f().a(getContext(), str, "color_B8B8B8"));
        this.d.setTextColor(dc0.f().a(getContext(), str, "color_4367B4"));
    }

    public void setText(CharSequence charSequence) {
        this.b.setText(charSequence);
    }
}
