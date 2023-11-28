package com.baidu.nadcore.download.view;

import android.content.Context;
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
import com.baidu.tieba.li0;
import com.baidu.tieba.ni0;
import com.baidu.tieba.s21;
/* loaded from: classes3.dex */
public class AdInstallTipsView extends LinearLayout implements ni0, View.OnClickListener {
    public ImageView a;
    public TextView b;
    public FrameLayout c;
    public TextView d;
    public CountDownTextView e;
    public FrameLayout f;
    public TextView g;
    public CountDownTextView h;
    public li0<AdInstallTipsView> i;
    public a j;

    /* loaded from: classes3.dex */
    public interface a {
        void a(ClogBuilder.Area area, boolean z, long j, long j2);
    }

    public AdInstallTipsView(Context context) {
        this(context, null);
    }

    public void setAction(a aVar) {
        this.j = aVar;
    }

    public AdInstallTipsView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdInstallTipsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public final void a() {
        b(LayoutInflater.from(getContext()).inflate(R.layout.nad_install_tips_view, this));
        setBackground(getResources().getDrawable(R.drawable.nad_install_tips_bg));
        setOrientation(0);
        setGravity(16);
        this.i = new li0<>(this);
    }

    public final void b(View view2) {
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
        s21.a(getContext(), this.c, 10.0f);
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
        a aVar = this.j;
        if (aVar != null) {
            aVar.a(area2, true, this.i.a(), this.i.b());
        }
    }
}
