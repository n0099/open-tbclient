package com.baidu.nadcore.player.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.video.videoplayer.ui.full.BdThumbSeekBar;
import com.baidu.nadcore.video.videoplayer.widget.BdTextProgressView;
import com.baidu.tieba.R;
import com.baidu.tieba.a41;
import com.baidu.tieba.k51;
import com.baidu.tieba.u31;
import com.baidu.tieba.vv0;
/* loaded from: classes2.dex */
public class BdLayerSeekBar extends FrameLayout implements View.OnClickListener, BdThumbSeekBar.b {
    public final Context a;
    public BdThumbSeekBar b;
    public BdTextProgressView c;
    public BdTextProgressView d;
    public boolean e;
    public vv0 f;

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }

    public BdLayerSeekBar(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.baidu.nadcore.video.videoplayer.ui.full.BdThumbSeekBar.b
    public void b(BdThumbSeekBar bdThumbSeekBar) {
        this.e = false;
        vv0 vv0Var = this.f;
        if (vv0Var != null) {
            vv0Var.b(bdThumbSeekBar);
        }
    }

    @Override // com.baidu.nadcore.video.videoplayer.ui.full.BdThumbSeekBar.b
    public void c(BdThumbSeekBar bdThumbSeekBar) {
        this.e = true;
        vv0 vv0Var = this.f;
        if (vv0Var != null) {
            vv0Var.c(bdThumbSeekBar);
        }
    }

    public void setBufferingPosition(int i) {
        BdThumbSeekBar bdThumbSeekBar = this.b;
        if (bdThumbSeekBar != null) {
            bdThumbSeekBar.setBufferingProgress(i);
        }
    }

    public void setDuration(int i) {
        BdThumbSeekBar bdThumbSeekBar = this.b;
        if (bdThumbSeekBar != null) {
            bdThumbSeekBar.setMax(i);
        }
        if (this.d != null) {
            String a = u31.a(i, false);
            if (!TextUtils.isEmpty(a)) {
                this.d.setPositionText(a);
            }
        }
    }

    public void setDurationViewMarginRight(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams.rightMargin = i;
        this.d.setLayoutParams(layoutParams);
    }

    public void setPosition(int i) {
        BdThumbSeekBar bdThumbSeekBar = this.b;
        if (bdThumbSeekBar != null) {
            bdThumbSeekBar.setProgress(i);
        }
        boolean z = false;
        BdThumbSeekBar bdThumbSeekBar2 = this.b;
        if (bdThumbSeekBar2 != null && bdThumbSeekBar2.getMax() >= 3600.0f) {
            z = true;
        }
        String a = u31.a(i, z);
        if (this.c != null && !TextUtils.isEmpty(a)) {
            this.c.setPositionText(a);
        }
    }

    public void setProgressViewMarginLeft(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams.leftMargin = i;
        this.c.setLayoutParams(layoutParams);
    }

    public void setSeekBarHolderListener(vv0 vv0Var) {
        this.f = vv0Var;
    }

    public void setSeekBarStyle(@NonNull BdThumbSeekBar.BdSeekBarStyle bdSeekBarStyle) {
        BdThumbSeekBar bdThumbSeekBar = this.b;
        if (bdThumbSeekBar != null) {
            bdThumbSeekBar.setStyle(bdSeekBarStyle);
        }
    }

    public void setSeekBarTraceHeight(int i) {
        BdThumbSeekBar bdThumbSeekBar = this.b;
        if (bdThumbSeekBar != null) {
            bdThumbSeekBar.setUiTraceHeight(i);
        }
    }

    public void setSeeking(boolean z) {
        this.e = z;
    }

    public BdLayerSeekBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = false;
        this.a = context;
        d();
    }

    public static void setSeekBarIcon(Context context, BdThumbSeekBar bdThumbSeekBar) {
        if (bdThumbSeekBar == null) {
            return;
        }
        float b = a41.c.b(context);
        Matrix matrix = new Matrix();
        float f = b / 3.0f;
        matrix.postScale(f, f);
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.nad_videoplayer_new_player_seekbar_thumb_new);
        bdThumbSeekBar.setThumbBitmap(Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, true));
        Bitmap decodeResource2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.nad_videoplayer_new_player_seekbar_thumb_big);
        bdThumbSeekBar.setScaleThumbBitmap(Bitmap.createBitmap(decodeResource2, 0, 0, decodeResource2.getWidth(), decodeResource2.getHeight(), matrix, true));
    }

    @Override // com.baidu.nadcore.video.videoplayer.ui.full.BdThumbSeekBar.b
    public void a(BdThumbSeekBar bdThumbSeekBar, int i, boolean z) {
        setPosition(i);
        vv0 vv0Var = this.f;
        if (vv0Var != null) {
            vv0Var.a(bdThumbSeekBar, i, z);
        }
    }

    public void g(int i, int i2, int i3) {
        if (this.e) {
            return;
        }
        setPosition(i);
        setDuration(i2);
        setBufferingPosition(i3);
    }

    public final void d() {
        LayoutInflater.from(this.a).inflate(R.layout.nad_bd_layer_seek_bar, this);
        this.c = (BdTextProgressView) findViewById(R.id.nad_main_progress_text);
        this.d = (BdTextProgressView) findViewById(R.id.nad_main_duration_text);
        BdThumbSeekBar bdThumbSeekBar = (BdThumbSeekBar) findViewById(R.id.obfuscated_res_0x7f091604);
        this.b = bdThumbSeekBar;
        bdThumbSeekBar.setOnSeekBarChangeListener(this);
    }

    public void f() {
        this.c.setTextSize(k51.b(10.0f));
        this.d.setTextSize(k51.b(10.0f));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.leftMargin = k51.b(3.0f);
        layoutParams.rightMargin = k51.b(3.0f);
        this.b.setLayoutParams(layoutParams);
    }

    public int getSeekBarMax() {
        BdThumbSeekBar bdThumbSeekBar = this.b;
        if (bdThumbSeekBar != null) {
            return (int) bdThumbSeekBar.getMax();
        }
        return -1;
    }

    public void setSeekBarIcon() {
        setSeekBarIcon(getContext(), this.b);
    }

    public void e() {
        this.c.setTextSize(k51.b(12.0f));
        this.d.setTextSize(k51.b(12.0f));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.leftMargin = k51.b(3.0f);
        layoutParams.rightMargin = k51.b(1.0f);
        this.b.setLayoutParams(layoutParams);
    }
}
