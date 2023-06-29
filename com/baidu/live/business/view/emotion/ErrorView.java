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
import com.baidu.tieba.ge0;
import com.baidu.tieba.pb0;
import com.baidu.tieba.xb0;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes3.dex */
public class ErrorView extends LinearLayout {
    public TextView a;
    public SimpleDraweeView b;
    public TextView c;
    public xb0 d;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!pb0.f(ErrorView.this.getContext())) {
                Toast.makeText(ErrorView.this.getContext(), (int) R.string.obfuscated_res_0x7f0f0b8c, 1).show();
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

    public void setActionCallback(xb0 xb0Var) {
        this.d = xb0Var;
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
        LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05ae, this);
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
        if (pb0.f(getContext())) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.width = pb0.b(getContext(), EmotionStrategy.getInstance().errorWidth);
            layoutParams.height = pb0.b(getContext(), EmotionStrategy.getInstance().errorHeight);
            this.b.setLayoutParams(layoutParams);
            setImageResource(ge0.f().c(str));
            this.c.setText(R.string.obfuscated_res_0x7f0f0b8b);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams2.width = pb0.b(getContext(), EmotionStrategy.getInstance().networkWidth);
            layoutParams2.height = pb0.b(getContext(), EmotionStrategy.getInstance().networkHeight);
            this.b.setLayoutParams(layoutParams2);
            setImageResource(ge0.f().d(str));
            this.c.setText(R.string.obfuscated_res_0x7f0f0b8c);
        }
        this.c.setTextColor(ge0.f().a(getContext(), str, "color_8585852"));
        this.a.setTextColor(ge0.f().a(getContext(), str, "color_5252522"));
        this.a.setBackground(ge0.f().o(getContext(), str));
    }
}
