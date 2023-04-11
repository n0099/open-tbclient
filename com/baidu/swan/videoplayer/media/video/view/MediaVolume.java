package com.baidu.swan.videoplayer.media.video.view;

import android.content.Context;
import android.media.AudioManager;
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
/* loaded from: classes3.dex */
public final class MediaVolume extends FrameLayout {
    public View a;
    public ImageView b;
    public TextView c;
    public AudioManager d;
    public int e;
    public int f;
    public int g;
    public float h;

    public MediaVolume(@NonNull Context context) {
        this(context, null);
    }

    public final int a(float f) {
        int i = this.e;
        if (i == 0) {
            return 100;
        }
        float f2 = 100.0f;
        float f3 = (f / i) * 100.0f;
        if (f3 <= 0.0f) {
            f2 = 0.0f;
        } else if (f < 100.0f) {
            f2 = f3;
        }
        return (int) f2;
    }

    public void g(int i) {
        this.g = i;
    }

    public void h(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else {
            int i = this.e;
            if (f >= i) {
                f = i;
            }
        }
        this.h = f;
        this.d.setStreamVolume(3, (int) f, 0);
    }

    public MediaVolume(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaVolume(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d(context);
    }

    public int b() {
        return this.f;
    }

    public int c() {
        return this.e;
    }

    public void e() {
        this.f = this.d.getStreamVolume(3);
    }

    public void f() {
        this.b.setImageResource(this.g);
        this.c.setText(String.format("%d%%", Integer.valueOf(a(this.h))));
        setVisibility(0);
    }

    public final void d(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d08a7, (ViewGroup) this, true);
        this.a = inflate;
        this.b = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090f81);
        this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0913c0);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0706f1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.gravity = 17;
        this.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f081274);
        this.a.setLayoutParams(layoutParams);
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        this.d = audioManager;
        this.e = audioManager.getStreamMaxVolume(3);
    }
}
