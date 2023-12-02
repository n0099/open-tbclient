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
import com.baidu.tieba.a91;
import com.baidu.tieba.an0;
import com.baidu.tieba.c91;
import com.baidu.tieba.dz0;
import com.baidu.tieba.eg0;
import com.baidu.tieba.fg0;
import com.baidu.tieba.jh0;
import com.baidu.tieba.kn0;
import com.baidu.tieba.ph0;
import com.baidu.tieba.tm0;
import com.baidu.tieba.w11;
import com.baidu.tieba.wg0;
import com.baidu.tieba.wm0;
import java.util.Map;
/* loaded from: classes3.dex */
public class AdCriusPopView extends AdCriusBaseView<CriusData> implements View.OnClickListener, c91<View> {
    public jh0 e;
    public Animation f;
    public Animation g;
    public a91 h;

    @Override // com.baidu.nadcore.crius.view.AdCriusBaseView
    public int d() {
        return R.id.nad_crius_container_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.c91
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
            AdCriusPopView.this.e.l();
        }
    }

    @Override // com.baidu.tieba.c91
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
            a91 a91Var = this.h;
            if (a91Var != null) {
                a91Var.c();
            }
        }
    }

    public AdCriusPopView(Context context) {
        this(context, null);
    }

    @Override // com.baidu.tieba.c91
    public void c(boolean z) {
        if (getVisibility() == 0) {
            return;
        }
        if (z) {
            r();
            return;
        }
        setVisibility(0);
        a91 a91Var = this.h;
        if (a91Var != null) {
            a91Var.c();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.getId() == R.id.nad_base_delete_id) {
            b("1", true);
        }
    }

    @Override // com.baidu.tieba.c91
    public void setCriusPopListener(@NonNull a91 a91Var) {
        this.h = a91Var;
    }

    @Override // com.baidu.tieba.c91
    public void setData(@NonNull an0 an0Var) {
        CriusData criusData;
        setTag(an0Var);
        Object obj = an0Var.c;
        if (!(obj instanceof eg0)) {
            return;
        }
        Map<String, eg0.a> map = ((eg0) obj).b;
        if (map == null) {
            setVisibility(8);
            return;
        }
        eg0.a aVar = map.get("crius_pop");
        if (aVar != null && (criusData = aVar.a) != null) {
            k(criusData, false);
            a();
            return;
        }
        setVisibility(8);
    }

    public AdCriusPopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.baidu.tieba.c91
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

    @Override // com.baidu.tieba.c91
    public void b(String str, boolean z) {
        wm0 wm0Var;
        this.f = null;
        if (z && this.g != null) {
            return;
        }
        a91 a91Var = this.h;
        if (a91Var != null) {
            a91Var.a(z, 480L);
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
        if (!(getTag() instanceof an0) || (wm0Var = ((an0) getTag()).e) == null) {
            return;
        }
        wm0Var.a();
        wm0Var.c = ClogBuilder.LogType.NAVIDEO_POP_CLOSE.type;
        wm0Var.g = str;
        q(wm0Var);
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
            kn0 kn0Var = new kn0();
            kn0Var.a = str;
            kn0Var.b = str2;
            kn0Var.c = true;
            if (map != null) {
                TextUtils.equals("1", map.get(NativeConstants.CHARGE_TYPE));
            }
            this.h.b(kn0Var);
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
            fg0 realDownloadView = ((ApkDownloadView) viewByComponent2).getRealDownloadView();
            if ((realDownloadView instanceof ph0) && (getTag() instanceof an0)) {
                o((an0) getTag(), (ph0) realDownloadView);
                return;
            } else {
                this.e = null;
                return;
            }
        }
        this.e = null;
    }

    public final void o(@NonNull an0 an0Var, ph0 ph0Var) {
        tm0 tm0Var = an0Var.d;
        wm0 wm0Var = an0Var.e;
        if (tm0Var != null && wm0Var != null) {
            an0Var.a = 2;
            this.e = new jh0(wg0.d(tm0Var, wm0Var.d, ""), ph0Var);
            if (ph0Var instanceof NadCriusMiniVideoDownloadView) {
                NadCriusMiniVideoDownloadView nadCriusMiniVideoDownloadView = (NadCriusMiniVideoDownloadView) ph0Var;
                int a2 = w11.c.a(getContext(), 12.0f);
                nadCriusMiniVideoDownloadView.setImageViewLayout(new FrameLayout.LayoutParams(a2, a2));
                nadCriusMiniVideoDownloadView.setVisibility(0);
                nadCriusMiniVideoDownloadView.setOnClickListener(new b());
            }
        }
    }

    public final void q(wm0 wm0Var) {
        dz0.e(new ClogBuilder().z(wm0Var.c).v(wm0Var.a).j(wm0Var.b).p(wm0Var.d).k(wm0Var.e).l(wm0Var.f).m(wm0Var.g));
    }
}
