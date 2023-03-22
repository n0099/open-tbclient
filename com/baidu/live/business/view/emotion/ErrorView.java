package com.baidu.live.business.view.emotion;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.tieba.R;
import com.baidu.tieba.i90;
import com.baidu.tieba.q90;
import com.baidu.tieba.zb0;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes2.dex */
public class ErrorView extends LinearLayout {
    public TextView a;
    public SimpleDraweeView b;
    public TextView c;
    public q90 d;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!i90.f(ErrorView.this.getContext())) {
                Toast.makeText(ErrorView.this.getContext(), (int) R.string.obfuscated_res_0x7f0f0abb, 1).show();
            } else if (ErrorView.this.d != null) {
                ErrorView.this.d.a(view2);
            }
        }
    }

    public ErrorView(Context context) {
        this(context, null);
    }

    public void d(int i) {
        e(i, LiveFeedPageSdk.HOST_LIVE_TAB);
    }

    public void setActionCallback(q90 q90Var) {
        this.d = q90Var;
    }

    public void setImageResource(int i) {
        if (i != -1) {
            this.b.setActualImageResource(i);
        }
    }

    public ErrorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void e(int i, String str) {
        super.setVisibility(i);
        if (i == 0) {
            c(str);
        }
    }

    public ErrorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d057b, this);
        setOrientation(1);
        setGravity(17);
        this.b = (SimpleDraweeView) findViewById(R.id.errorview_img);
        this.a = (TextView) findViewById(R.id.errorview_clickreload);
        this.c = (TextView) findViewById(R.id.errorview_desc);
        b();
    }

    public void b() {
        this.a.setOnClickListener(new a());
    }

    public void c(String str) {
        if (i90.f(getContext())) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.width = i90.b(getContext(), EmotionStrategy.getInstance().errorWidth);
            layoutParams.height = i90.b(getContext(), EmotionStrategy.getInstance().errorHeight);
            this.b.setLayoutParams(layoutParams);
            setImageResource(zb0.f().c(str));
            this.c.setText(R.string.obfuscated_res_0x7f0f0aba);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams2.width = i90.b(getContext(), EmotionStrategy.getInstance().networkWidth);
            layoutParams2.height = i90.b(getContext(), EmotionStrategy.getInstance().networkHeight);
            this.b.setLayoutParams(layoutParams2);
            setImageResource(zb0.f().d(str));
            this.c.setText(R.string.obfuscated_res_0x7f0f0abb);
        }
        this.c.setTextColor(zb0.f().a(getContext(), str, "color_8585852"));
        this.a.setTextColor(zb0.f().a(getContext(), str, "color_5252522"));
        this.a.setBackground(zb0.f().o(getContext(), str));
    }
}
