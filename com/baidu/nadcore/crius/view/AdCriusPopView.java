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
import com.baidu.tieba.az0;
import com.baidu.tieba.dg0;
import com.baidu.tieba.eg0;
import com.baidu.tieba.ih0;
import com.baidu.tieba.in0;
import com.baidu.tieba.oh0;
import com.baidu.tieba.sm0;
import com.baidu.tieba.t11;
import com.baidu.tieba.v81;
import com.baidu.tieba.vg0;
import com.baidu.tieba.vm0;
import com.baidu.tieba.x81;
import com.baidu.tieba.ym0;
import java.util.Map;
/* loaded from: classes3.dex */
public class AdCriusPopView extends AdCriusBaseView<CriusData> implements View.OnClickListener, x81<View> {
    public ih0 e;
    public Animation f;
    public Animation g;
    public v81 h;

    @Override // com.baidu.nadcore.crius.view.AdCriusBaseView
    public int d() {
        return R.id.nad_crius_container_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.x81
    public View getRealView() {
        return this;
    }

    @Override // com.baidu.nadcore.crius.view.AdCriusBaseView
    public int h() {
        return R.layout.nad_crius_pop_view;
    }

    @Override // com.baidu.nadcore.crius.view.AdCriusBaseView
    public int k() {
        return R.id.nad_crius_root_view;
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AdCriusPopView.this.e.m();
        }
    }

    @Override // com.baidu.tieba.x81
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

    public final void r() {
        if (this.f == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.nad_pop_view_fade_in);
            this.f = loadAnimation;
            loadAnimation.setDuration(480L);
            setVisibility(0);
            startAnimation(this.f);
            v81 v81Var = this.h;
            if (v81Var != null) {
                v81Var.c();
            }
        }
    }

    public AdCriusPopView(Context context) {
        this(context, null);
    }

    @Override // com.baidu.tieba.x81
    public void c(boolean z) {
        if (getVisibility() == 0) {
            return;
        }
        if (z) {
            r();
            return;
        }
        setVisibility(0);
        v81 v81Var = this.h;
        if (v81Var != null) {
            v81Var.c();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.getId() == R.id.nad_base_delete_id) {
            b("1", true);
        }
    }

    @Override // com.baidu.tieba.x81
    public void setCriusPopListener(@NonNull v81 v81Var) {
        this.h = v81Var;
    }

    @Override // com.baidu.tieba.x81
    public void setData(@NonNull ym0 ym0Var) {
        CriusData criusData;
        setTag(ym0Var);
        Object obj = ym0Var.c;
        if (!(obj instanceof dg0)) {
            return;
        }
        Map<String, dg0.a> map = ((dg0) obj).b;
        if (map == null) {
            setVisibility(8);
            return;
        }
        dg0.a aVar = map.get("crius_pop");
        if (aVar != null && (criusData = aVar.a) != null) {
            l(criusData, false);
            a();
            return;
        }
        setVisibility(8);
    }

    public AdCriusPopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.baidu.tieba.x81
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
            p(str, map);
        }
    }

    @Override // com.baidu.tieba.x81
    public void b(String str, boolean z) {
        vm0 vm0Var;
        this.f = null;
        if (z && this.g != null) {
            return;
        }
        v81 v81Var = this.h;
        if (v81Var != null) {
            v81Var.a(z, 480L);
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
        if (!(getTag() instanceof ym0) || (vm0Var = ((ym0) getTag()).e) == null) {
            return;
        }
        vm0Var.a();
        vm0Var.c = ClogBuilder.LogType.NAVIDEO_POP_CLOSE.type;
        vm0Var.g = str;
        q(vm0Var);
    }

    public final void p(String str, Map<String, String> map) {
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
            in0 in0Var = new in0();
            in0Var.a = str;
            in0Var.b = str2;
            in0Var.c = true;
            if (map != null) {
                TextUtils.equals("1", map.get(NativeConstants.CHARGE_TYPE));
            }
            this.h.b(in0Var);
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
            eg0 realDownloadView = ((ApkDownloadView) viewByComponent2).getRealDownloadView();
            if ((realDownloadView instanceof oh0) && (getTag() instanceof ym0)) {
                o((ym0) getTag(), (oh0) realDownloadView);
                return;
            } else {
                this.e = null;
                return;
            }
        }
        this.e = null;
    }

    public final void o(@NonNull ym0 ym0Var, oh0 oh0Var) {
        sm0 sm0Var = ym0Var.d;
        vm0 vm0Var = ym0Var.e;
        if (sm0Var != null && vm0Var != null) {
            ym0Var.a = 2;
            this.e = new ih0(vg0.d(sm0Var, vm0Var.d, ""), oh0Var);
            if (oh0Var instanceof NadCriusMiniVideoDownloadView) {
                NadCriusMiniVideoDownloadView nadCriusMiniVideoDownloadView = (NadCriusMiniVideoDownloadView) oh0Var;
                int a2 = t11.c.a(getContext(), 12.0f);
                nadCriusMiniVideoDownloadView.setImageViewLayout(new FrameLayout.LayoutParams(a2, a2));
                nadCriusMiniVideoDownloadView.setVisibility(0);
                nadCriusMiniVideoDownloadView.setOnClickListener(new b());
            }
        }
    }

    public final void q(vm0 vm0Var) {
        az0.e(new ClogBuilder().z(vm0Var.c).v(vm0Var.a).j(vm0Var.b).p(vm0Var.d).k(vm0Var.e).l(vm0Var.f).m(vm0Var.g));
    }
}
