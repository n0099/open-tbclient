package com.baidu.nadcore.crius.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.crius.uiwidget.ApkDownloadView;
import com.baidu.nadcore.crius.uiwidget.NadCriusMiniVideoDownloadView;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.tieba.R;
import com.baidu.tieba.ej0;
import com.baidu.tieba.fj0;
import com.baidu.tieba.fp0;
import com.baidu.tieba.ip0;
import com.baidu.tieba.jk0;
import com.baidu.tieba.k11;
import com.baidu.tieba.kc1;
import com.baidu.tieba.lp0;
import com.baidu.tieba.mc1;
import com.baidu.tieba.pk0;
import com.baidu.tieba.tp0;
import com.baidu.tieba.wj0;
import com.baidu.tieba.z31;
import java.util.Map;
/* loaded from: classes2.dex */
public class AdCriusPopView extends AdCriusBaseView<CriusData> implements View.OnClickListener, mc1<View> {
    public jk0 e;
    public Animation f;
    public Animation g;
    public kc1 h;
    public boolean i;

    @Override // com.baidu.nadcore.crius.view.AdCriusBaseView
    public int d() {
        return R.id.nad_crius_container_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.mc1
    public View getRealView() {
        return this;
    }

    @Override // com.baidu.nadcore.crius.view.AdCriusBaseView
    public int h() {
        return R.layout.nad_crius_pop_view;
    }

    @Override // com.baidu.nadcore.crius.view.AdCriusBaseView
    public int j() {
        return R.id.nad_crius_root_view;
    }

    /* loaded from: classes2.dex */
    public class a implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            AdCriusPopView.this.setVisibility(8);
            AdCriusPopView.this.g = null;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AdCriusPopView.this.e.m();
        }
    }

    @Override // com.baidu.tieba.mc1
    public void a() {
        Animation animation = this.f;
        if (animation != null) {
            animation.cancel();
            this.f = null;
        }
        Animation animation2 = this.g;
        if (animation2 != null) {
            animation2.cancel();
            this.g = null;
        }
    }

    public final void q() {
        if (this.f == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.nad_pop_view_fade_in);
            this.f = loadAnimation;
            loadAnimation.setDuration(480L);
            setVisibility(0);
            startAnimation(this.f);
            kc1 kc1Var = this.h;
            if (kc1Var != null) {
                kc1Var.c();
            }
            this.i = true;
        }
    }

    public AdCriusPopView(Context context) {
        this(context, null);
    }

    @Override // com.baidu.tieba.mc1
    public void c(boolean z) {
        if (getVisibility() == 0) {
            return;
        }
        if (z) {
            q();
            return;
        }
        setVisibility(0);
        kc1 kc1Var = this.h;
        if (kc1Var != null) {
            kc1Var.c();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.getId() == R.id.nad_base_delete_id) {
            b("1", true);
        }
    }

    @Override // com.baidu.tieba.mc1
    public void setCriusPopListener(@NonNull kc1 kc1Var) {
        this.h = kc1Var;
    }

    @Override // com.baidu.tieba.mc1
    public void setData(@NonNull lp0 lp0Var) {
        CriusData criusData;
        setTag(lp0Var);
        Object obj = lp0Var.c;
        if (!(obj instanceof ej0)) {
            return;
        }
        Map<String, ej0.a> map = ((ej0) obj).b;
        if (map == null) {
            setVisibility(8);
            return;
        }
        ej0.a aVar = map.get("crius_pop");
        if (aVar != null && (criusData = aVar.a) != null) {
            k(criusData, false);
            a();
            return;
        }
        setVisibility(8);
    }

    public void update(int i) {
        int i2;
        if ((getTag() instanceof lp0) && (i2 = ((lp0) getTag()).b) >= 0 && !this.i && i >= i2) {
            q();
        }
    }

    public AdCriusPopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.baidu.tieba.mc1
    public void setContainer(@Nullable ViewGroup viewGroup, @Nullable ViewGroup.LayoutParams layoutParams) {
        if (viewGroup == null) {
            return;
        }
        View view2 = (View) getParent();
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).removeView(this);
        }
        if (layoutParams != null) {
            viewGroup.addView(this, layoutParams);
        } else {
            viewGroup.addView(this);
        }
        setVisibility(8);
    }

    public AdCriusPopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d.setIgnoreImageNightMode(true);
    }

    @Override // com.baidu.nadcore.crius.view.AdCriusBaseView
    public void f(View view2, String str, Map<String, String> map) {
        if (view2.getId() == R.id.nad_base_delete_id) {
            b("1", true);
        } else {
            o(str, map);
        }
    }

    @Override // com.baidu.tieba.mc1
    public void b(String str, boolean z) {
        ip0 ip0Var;
        this.i = false;
        this.f = null;
        if (z && this.g != null) {
            return;
        }
        kc1 kc1Var = this.h;
        if (kc1Var != null) {
            kc1Var.a(z, 480L);
        }
        if (z) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.nad_pop_view_fade_out);
            this.g = loadAnimation;
            loadAnimation.setDuration(480L);
            this.g.setAnimationListener(new a());
            startAnimation(this.g);
        } else {
            setVisibility(8);
        }
        if (!(getTag() instanceof lp0) || (ip0Var = ((lp0) getTag()).e) == null) {
            return;
        }
        ip0Var.a();
        ip0Var.c = ClogBuilder.LogType.NAVIDEO_POP_CLOSE.type;
        ip0Var.g = str;
        p(ip0Var);
    }

    public final void o(String str, Map<String, String> map) {
        String str2;
        if (map != null && !TextUtils.isEmpty(map.get(NativeConstants.URL_STAT))) {
            map.get(NativeConstants.URL_STAT);
        }
        if (map != null && !TextUtils.isEmpty(map.get(NativeConstants.ALS_STAT))) {
            str2 = map.get(NativeConstants.ALS_STAT);
        } else {
            str2 = ClogBuilder.Area.HOTAREA.type;
        }
        if (this.h != null) {
            tp0 tp0Var = new tp0();
            tp0Var.a = str;
            tp0Var.b = str2;
            tp0Var.c = true;
            if (map != null) {
                TextUtils.equals("1", map.get(NativeConstants.CHARGE_TYPE));
            }
            this.h.b(tp0Var);
        }
    }

    @Override // com.baidu.nadcore.crius.view.AdCriusBaseView
    public void e(CriusData criusData) {
        View viewByComponent = this.d.getViewByComponent(NativeConstants.COMPONENT_CLOSEAD);
        if (viewByComponent instanceof ImageView) {
            ImageView imageView = (ImageView) viewByComponent;
            imageView.setImageResource(R.drawable.nad_pop_close_btn);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setOnClickListener(this);
        }
        View viewByComponent2 = this.d.getViewByComponent("download");
        if (viewByComponent2 instanceof ApkDownloadView) {
            fj0 realDownloadView = ((ApkDownloadView) viewByComponent2).getRealDownloadView();
            if ((realDownloadView instanceof pk0) && (getTag() instanceof lp0)) {
                n((lp0) getTag(), (pk0) realDownloadView);
                return;
            } else {
                this.e = null;
                return;
            }
        }
        this.e = null;
    }

    public final void n(@NonNull lp0 lp0Var, pk0 pk0Var) {
        fp0 fp0Var = lp0Var.d;
        ip0 ip0Var = lp0Var.e;
        if (fp0Var != null && ip0Var != null) {
            lp0Var.a = 2;
            this.e = new jk0(wj0.d(fp0Var, ip0Var.d, ""), pk0Var);
            if (pk0Var instanceof NadCriusMiniVideoDownloadView) {
                NadCriusMiniVideoDownloadView nadCriusMiniVideoDownloadView = (NadCriusMiniVideoDownloadView) pk0Var;
                int a2 = z31.c.a(getContext(), 12.0f);
                nadCriusMiniVideoDownloadView.setImageViewLayout(new FrameLayout.LayoutParams(a2, a2));
                nadCriusMiniVideoDownloadView.setVisibility(0);
                nadCriusMiniVideoDownloadView.setOnClickListener(new b());
            }
        }
    }

    public final void p(ip0 ip0Var) {
        k11.b(new ClogBuilder().z(ip0Var.c).v(ip0Var.a).j(ip0Var.b).p(ip0Var.d).k(ip0Var.e).l(ip0Var.f).m(ip0Var.g));
    }
}
