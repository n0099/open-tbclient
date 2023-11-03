package com.baidu.swan.videoplayer.media.video.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.videoplayer.widget.MediaController;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public final class MediaFastForward extends FrameLayout {
    public View a;
    public ImageView b;
    public TextView c;
    public ProgressBar d;
    public int e;
    public int f;
    public int g;
    public int h;

    public MediaFastForward(@NonNull Context context) {
        this(context, null);
    }

    public void g(int i) {
        this.e = i;
    }

    public void h(int i) {
        int i2 = this.h;
        if (i > i2) {
            i = i2;
        } else if (i < 0) {
            i = 0;
        }
        this.g = i;
    }

    public MediaFastForward(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void e(int i, int i2) {
        this.f = i;
        this.h = i2;
    }

    public MediaFastForward(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d(context);
    }

    public int a() {
        return this.g;
    }

    public int b() {
        return this.f;
    }

    public int c() {
        return this.h;
    }

    public final void d(Context context) {
        Resources resources = getResources();
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d095a, (ViewGroup) this, true);
        this.a = inflate;
        this.b = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09105e);
        this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0914bf);
        this.d = (ProgressBar) this.a.findViewById(R.id.obfuscated_res_0x7f091df6);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070878), resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070877));
        layoutParams.gravity = 17;
        this.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f0814e1);
        this.a.setLayoutParams(layoutParams);
    }

    public void f() {
        this.b.setImageResource(this.e);
        this.c.setText(String.format("%s / %s", MediaController.j(this.g), MediaController.j(this.h)));
        this.d.setProgress(this.g);
        this.d.setMax(this.h);
        setVisibility(0);
    }
}
