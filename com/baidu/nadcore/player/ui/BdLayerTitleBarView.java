package com.baidu.nadcore.player.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.video.videoplayer.ui.full.BdVideoBattery;
import com.baidu.nadcore.video.videoplayer.widget.BdTextProgressView;
import com.baidu.tieba.R;
import com.baidu.tieba.jx0;
import java.util.Calendar;
import java.util.Locale;
/* loaded from: classes3.dex */
public class BdLayerTitleBarView extends FrameLayout implements View.OnClickListener {
    public final Context a;
    public RelativeLayout b;
    public ImageView c;
    public TextView d;
    public BdVideoBattery e;
    public BdTextProgressView f;
    public a g;
    public View h;

    /* loaded from: classes3.dex */
    public interface a {
        void onBack();
    }

    public BdLayerTitleBarView(@NonNull Context context) {
        this(context, null);
    }

    public void a(boolean z) {
        if (z) {
            startAnimation(jx0.d());
        }
        setVisibility(4);
    }

    public void c(boolean z) {
        if (z) {
            startAnimation(jx0.c());
        }
        f();
        setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        a aVar;
        if (view2.equals(this.c) && (aVar = this.g) != null) {
            aVar.onBack();
        }
    }

    public void setBatteryHullVisible(boolean z) {
        int i;
        BdVideoBattery bdVideoBattery = this.e;
        if (bdVideoBattery != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            bdVideoBattery.setVisibility(i);
        }
    }

    public void setListener(a aVar) {
        this.g = aVar;
    }

    public void setOnlyShowBackIcon(boolean z) {
        int i;
        View view2 = this.h;
        if (view2 != null) {
            if (z) {
                i = 8;
            } else {
                i = 0;
            }
            view2.setVisibility(i);
        }
    }

    public void setSystemTimeVisible(boolean z) {
        int i;
        BdTextProgressView bdTextProgressView = this.f;
        if (bdTextProgressView != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            bdTextProgressView.setVisibility(i);
        }
    }

    public BdLayerTitleBarView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = context;
        b();
    }

    public void d(boolean z, boolean z2) {
        if (z2) {
            this.b.setBackgroundColor(getContext().getResources().getColor(R.color.nad_videoplayer_transparent));
        } else {
            this.b.setBackground(getContext().getResources().getDrawable(R.drawable.nad_videoplayer_control_title_background));
        }
        c(z);
    }

    public void setVideoTitle(String str, int i) {
        this.d.setText(str);
        this.d.setTypeface(Typeface.DEFAULT_BOLD);
        this.d.setTextSize(0, i);
    }

    public final void b() {
        LayoutInflater.from(this.a).cloneInContext(this.a).inflate(R.layout.nad_videoplayer_bd_layer_control_titlebar_layout, this);
        this.b = (RelativeLayout) findViewById(R.id.main_container);
        ImageView imageView = (ImageView) findViewById(R.id.main_title_back_button);
        this.c = imageView;
        imageView.setOnClickListener(this);
        this.d = (TextView) findViewById(R.id.main_title_text);
        BdVideoBattery bdVideoBattery = (BdVideoBattery) findViewById(R.id.main_battery_view);
        this.e = bdVideoBattery;
        bdVideoBattery.setImage(R.drawable.nad_videoplayer_player_batteryhull);
        this.f = (BdTextProgressView) findViewById(R.id.main_system_time_text);
        f();
        this.h = findViewById(R.id.top_function_container);
    }

    public void e(boolean z, boolean z2, boolean z3) {
        d(z, z2);
        setOnlyShowBackIcon(z3);
    }

    public void f() {
        this.f.setTimeText(String.format(Locale.US, "%02d:%02d", Integer.valueOf(Calendar.getInstance().get(11)), Integer.valueOf(Calendar.getInstance().get(12))));
    }
}
