package com.baidu.nadcore.download.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.R;
import com.baidu.tieba.d61;
import com.baidu.tieba.ko0;
import com.baidu.tieba.lo0;
import com.baidu.tieba.pm0;
import com.baidu.tieba.rm0;
/* loaded from: classes2.dex */
public class AdInstallTipsView extends LinearLayout implements rm0, View.OnClickListener {
    public ImageView a;
    public TextView b;
    public FrameLayout c;
    public TextView d;
    public CountDownTextView e;
    public FrameLayout f;
    public TextView g;
    public CountDownTextView h;
    public pm0<AdInstallTipsView> i;
    public b j;

    /* loaded from: classes2.dex */
    public interface b {
        void a(ClogBuilder.Area area, boolean z, long j, long j2);

        void onCancel();
    }

    /* loaded from: classes2.dex */
    public class a implements lo0 {
        @Override // com.baidu.tieba.lo0
        public void a() {
        }

        public a() {
        }

        @Override // com.baidu.tieba.lo0
        public void b(Bitmap bitmap) {
            AdInstallTipsView.this.a.setImageBitmap(bitmap);
        }
    }

    public AdInstallTipsView(Context context) {
        this(context, null);
    }

    @Override // com.baidu.tieba.rm0
    public void a(long j) {
        boolean z;
        ClogBuilder.Area area;
        e().a(j);
        if (this.h.getVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            area = ClogBuilder.Area.INSTALL_NOW_BUTTON;
        } else {
            area = ClogBuilder.Area.INSTALL_LATER_BUTTON;
        }
        ClogBuilder.Area area2 = area;
        b bVar = this.j;
        if (bVar != null) {
            bVar.a(area2, false, this.i.e(), this.i.j());
        }
    }

    public void setAction(b bVar) {
        this.j = bVar;
    }

    public AdInstallTipsView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.baidu.tieba.rm0
    public void b(long j, long j2) {
        e().b(j, j2);
    }

    @Override // com.baidu.tieba.rm0
    public void c(long j, long j2) {
        e().c(j, j2);
        b bVar = this.j;
        if (bVar != null) {
            bVar.onCancel();
        }
    }

    @Override // com.baidu.tieba.rm0
    public void onProgress(long j, long j2) {
        e().onProgress(j, j2);
    }

    public AdInstallTipsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        f();
    }

    public final CountDownTextView e() {
        if (this.h.getVisibility() == 0) {
            return this.h;
        }
        return this.e;
    }

    public final void f() {
        g(LayoutInflater.from(getContext()).inflate(R.layout.nad_install_tips_view, this));
        setBackground(getResources().getDrawable(R.drawable.nad_install_tips_bg));
        setOrientation(0);
        setGravity(16);
        this.i = new pm0<>(this);
    }

    public final void g(View view2) {
        this.a = (ImageView) view2.findViewById(R.id.ad_install_tips_apk_icon);
        this.b = (TextView) view2.findViewById(R.id.ad_install_tips_apk_name);
        this.d = (TextView) view2.findViewById(R.id.ad_install_tips_delay_install_text);
        this.e = (CountDownTextView) view2.findViewById(R.id.ad_install_tips_delay_install_count_down);
        this.g = (TextView) view2.findViewById(R.id.ad_install_tips_install_now_text);
        this.h = (CountDownTextView) view2.findViewById(R.id.ad_install_tips_install_now_count_down);
        this.c = (FrameLayout) findViewById(R.id.ad_install_tips_delay_install_layout);
        this.f = (FrameLayout) findViewById(R.id.ad_install_tips_install_now_layout);
        this.e.setLabelText(getResources().getString(R.string.nad_apk_delay_install));
        this.h.setLabelText(getResources().getString(R.string.nad_button_install));
        this.e.setTimerTextFormat(null, "s");
        this.h.setTimerTextFormat(null, "s");
        this.e.setTextColor(Color.parseColor("#FF4141"));
        this.h.setTextColor(Color.parseColor("#FFFFFF"));
        this.e.setTextSize(12);
        this.h.setTextSize(12);
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.f.setOnClickListener(this);
        setOnClickListener(this);
        d61.a(getContext(), this.c, 10.0f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        ClogBuilder.Area area;
        int id = view2.getId();
        if (id == R.id.ad_install_tips_apk_icon) {
            area = ClogBuilder.Area.ICON;
        } else if (id == R.id.ad_install_tips_apk_name) {
            area = ClogBuilder.Area.NAME;
        } else if (id != R.id.ad_install_tips_delay_install_text && id != R.id.ad_install_tips_delay_install_count_down && id != R.id.ad_install_tips_delay_install_layout) {
            if (id != R.id.ad_install_tips_install_now_text && id != R.id.ad_install_tips_install_now_count_down && id != R.id.ad_install_tips_install_now_layout) {
                area = ClogBuilder.Area.HOTAREA;
            } else {
                area = ClogBuilder.Area.INSTALL_NOW_BUTTON;
            }
        } else {
            area = ClogBuilder.Area.INSTALL_LATER_BUTTON;
        }
        ClogBuilder.Area area2 = area;
        b bVar = this.j;
        if (bVar != null) {
            bVar.a(area2, true, this.i.e(), this.i.j());
        }
    }

    public void update(String str, String str2, long j, boolean z) {
        ko0.a().c(str, new a());
        this.b.setText(str2);
        if (z) {
            this.d.setVisibility(8);
            this.e.setVisibility(0);
            this.g.setVisibility(0);
            this.h.setVisibility(8);
        } else {
            this.d.setVisibility(0);
            this.e.setVisibility(8);
            this.g.setVisibility(8);
            this.h.setVisibility(0);
        }
        this.i.h(j);
    }
}
