package com.baidu.swan.videoplayer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class MediaTipStateLayer implements View.OnClickListener {
    public Context a;
    public SwanVideoView b;
    public View c;
    public View d;
    public View e;
    public TextView f;
    public TextView g;
    public TipState h;
    public ImageView i;
    public TextView j;
    public ImageView k;
    public boolean l;

    /* loaded from: classes3.dex */
    public enum TipState {
        NORMAL,
        ERROR,
        NO_WIFI,
        NO_NETWORK,
        END
    }

    public MediaTipStateLayer(Context context) {
        this.a = context;
        e();
        d();
    }

    public void a(SwanVideoView swanVideoView) {
        this.b = swanVideoView;
    }

    public void g(boolean z) {
        int i;
        this.l = z;
        ImageView imageView = this.k;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        imageView.setVisibility(i);
    }

    public void h(TipState tipState) {
        this.h = tipState;
        f();
    }

    public View b() {
        return this.c;
    }

    public TipState c() {
        return this.h;
    }

    public final void d() {
        this.f.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.k.setOnClickListener(this);
    }

    public final void e() {
        View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d08af, (ViewGroup) null, false);
        this.c = inflate;
        this.e = inflate.findViewById(R.id.obfuscated_res_0x7f0921c9);
        this.k = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0921c2);
        this.f = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0921b1);
        this.g = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0921b2);
        this.d = this.c.findViewById(R.id.obfuscated_res_0x7f0921d1);
        this.i = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0921d0);
        this.j = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0921d2);
        h(TipState.NORMAL);
    }

    public void f() {
        Resources resources = this.a.getResources();
        TipState tipState = this.h;
        if (tipState == TipState.ERROR) {
            this.i.setImageResource(R.drawable.obfuscated_res_0x7f0812a9);
            this.j.setText(this.a.getText(R.string.obfuscated_res_0x7f0f142d));
            this.c.setVisibility(0);
            this.d.setVisibility(0);
            this.e.setVisibility(8);
        } else if (tipState == TipState.NO_WIFI) {
            this.c.setVisibility(0);
            this.d.setVisibility(8);
            this.e.setVisibility(0);
            this.g.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060983));
            this.g.setText(R.string.obfuscated_res_0x7f0f1422);
            this.f.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812a0);
        } else if (tipState == TipState.NO_NETWORK) {
            this.c.setVisibility(0);
            this.d.setVisibility(8);
            this.e.setVisibility(0);
            this.g.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060982));
            this.g.setText(R.string.obfuscated_res_0x7f0f1424);
            this.f.setText(R.string.obfuscated_res_0x7f0f141f);
            this.f.setBackgroundResource(R.drawable.obfuscated_res_0x7f08129f);
        } else if (tipState == TipState.END) {
            this.i.setImageResource(R.drawable.obfuscated_res_0x7f0812aa);
            this.j.setText(this.a.getText(R.string.obfuscated_res_0x7f0f142e));
            this.c.setVisibility(0);
            this.d.setVisibility(0);
            this.e.setVisibility(8);
        } else if (tipState == TipState.NORMAL) {
            this.c.setVisibility(8);
            this.e.setVisibility(8);
            this.d.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        SwanVideoView swanVideoView;
        int id = view2.getId();
        if (id != R.id.obfuscated_res_0x7f0921b1 && id != R.id.obfuscated_res_0x7f0921d1) {
            if (id == R.id.obfuscated_res_0x7f0921c2 && (swanVideoView = this.b) != null && swanVideoView.getVideoPlayerCallback() != null) {
                this.b.getVideoPlayerCallback().d(!this.l);
                return;
            }
            return;
        }
        SwanVideoView swanVideoView2 = this.b;
        if (swanVideoView2 != null) {
            swanVideoView2.Y();
        }
        h(TipState.NORMAL);
    }
}
