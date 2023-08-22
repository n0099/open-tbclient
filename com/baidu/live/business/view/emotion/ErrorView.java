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
import com.baidu.tieba.id0;
import com.baidu.tieba.ra0;
import com.baidu.tieba.za0;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes3.dex */
public class ErrorView extends LinearLayout {
    public TextView a;
    public SimpleDraweeView b;
    public TextView c;
    public za0 d;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!ra0.f(ErrorView.this.getContext())) {
                Toast.makeText(ErrorView.this.getContext(), (int) R.string.obfuscated_res_0x7f0f0ba1, 1).show();
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

    public void setActionCallback(za0 za0Var) {
        this.d = za0Var;
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
        LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05c6, this);
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
        if (ra0.f(getContext())) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.width = ra0.b(getContext(), EmotionStrategy.getInstance().errorWidth);
            layoutParams.height = ra0.b(getContext(), EmotionStrategy.getInstance().errorHeight);
            this.b.setLayoutParams(layoutParams);
            setImageResource(id0.f().c(str));
            this.c.setText(R.string.obfuscated_res_0x7f0f0ba0);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams2.width = ra0.b(getContext(), EmotionStrategy.getInstance().networkWidth);
            layoutParams2.height = ra0.b(getContext(), EmotionStrategy.getInstance().networkHeight);
            this.b.setLayoutParams(layoutParams2);
            setImageResource(id0.f().d(str));
            this.c.setText(R.string.obfuscated_res_0x7f0f0ba1);
        }
        this.c.setTextColor(id0.f().a(getContext(), str, "color_8585852"));
        this.a.setTextColor(id0.f().a(getContext(), str, "color_5252522"));
        this.a.setBackground(id0.f().o(getContext(), str));
    }
}
