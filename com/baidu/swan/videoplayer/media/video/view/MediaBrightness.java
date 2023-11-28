package com.baidu.swan.videoplayer.media.video.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.baidu.tieba.fg3;
/* loaded from: classes4.dex */
public final class MediaBrightness extends FrameLayout {
    public View a;
    public ImageView b;
    public TextView c;
    public int d;
    public int e;
    public float f;

    public float b() {
        return 1.0f;
    }

    public MediaBrightness(@NonNull Context context) {
        this(context, null);
    }

    public void f(float f) {
        if (f >= 1.0f) {
            f = 1.0f;
        } else if (f <= 0.0f) {
            f = 0.0f;
        }
        fg3.c().e((Activity) getContext(), f);
    }

    public void g(int i) {
        this.e = i;
    }

    public void h(int i) {
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        this.d = i;
    }

    public MediaBrightness(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaBrightness(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context);
    }

    public float a() {
        return this.f;
    }

    public void d() {
        this.f = fg3.c().a((Activity) getContext());
    }

    public void e() {
        this.b.setImageResource(this.e);
        this.c.setText(String.format("%d%%", Integer.valueOf(this.d)));
        setVisibility(0);
    }

    public final void c(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0975, (ViewGroup) this, true);
        this.a = inflate;
        this.b = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091086);
        this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091531);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070880);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.gravity = 17;
        this.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f081504);
        this.a.setLayoutParams(layoutParams);
    }
}
