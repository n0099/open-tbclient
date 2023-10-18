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
import com.baidu.tieba.bm0;
import com.baidu.tieba.c11;
import com.baidu.tieba.e81;
import com.baidu.tieba.eg0;
import com.baidu.tieba.em0;
import com.baidu.tieba.g81;
import com.baidu.tieba.hm0;
import com.baidu.tieba.jy0;
import com.baidu.tieba.mf0;
import com.baidu.tieba.nf0;
import com.baidu.tieba.rg0;
import com.baidu.tieba.rm0;
import com.baidu.tieba.xg0;
import java.util.Map;
/* loaded from: classes3.dex */
public class AdCriusPopView extends AdCriusBaseView<CriusData> implements View.OnClickListener, g81<View> {
    public rg0 e;
    public Animation f;
    public Animation g;
    public e81 h;

    @Override // com.baidu.nadcore.crius.view.AdCriusBaseView
    public int d() {
        return R.id.nad_crius_container_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.g81
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

    @Override // com.baidu.tieba.g81
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
            e81 e81Var = this.h;
            if (e81Var != null) {
                e81Var.c();
            }
        }
    }

    public AdCriusPopView(Context context) {
        this(context, null);
    }

    @Override // com.baidu.tieba.g81
    public void c(boolean z) {
        if (getVisibility() == 0) {
            return;
        }
        if (z) {
            q();
            return;
        }
        setVisibility(0);
        e81 e81Var = this.h;
        if (e81Var != null) {
            e81Var.c();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.getId() == R.id.nad_base_delete_id) {
            b("1", true);
        }
    }

    @Override // com.baidu.tieba.g81
    public void setCriusPopListener(@NonNull e81 e81Var) {
        this.h = e81Var;
    }

    @Override // com.baidu.tieba.g81
    public void setData(@NonNull hm0 hm0Var) {
        CriusData criusData;
        setTag(hm0Var);
        Object obj = hm0Var.c;
        if (!(obj instanceof mf0)) {
            return;
        }
        Map<String, mf0.a> map = ((mf0) obj).b;
        if (map == null) {
            setVisibility(8);
            return;
        }
        mf0.a aVar = map.get("crius_pop");
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

    @Override // com.baidu.tieba.g81
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

    @Override // com.baidu.tieba.g81
    public void b(String str, boolean z) {
        em0 em0Var;
        this.f = null;
        if (z && this.g != null) {
            return;
        }
        e81 e81Var = this.h;
        if (e81Var != null) {
            e81Var.a(z, 480L);
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
        if (!(getTag() instanceof hm0) || (em0Var = ((hm0) getTag()).e) == null) {
            return;
        }
        em0Var.a();
        em0Var.c = ClogBuilder.LogType.NAVIDEO_POP_CLOSE.type;
        em0Var.g = str;
        p(em0Var);
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
            rm0 rm0Var = new rm0();
            rm0Var.a = str;
            rm0Var.b = str2;
            rm0Var.c = true;
            if (map != null) {
                TextUtils.equals("1", map.get(NativeConstants.CHARGE_TYPE));
            }
            this.h.b(rm0Var);
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
            nf0 realDownloadView = ((ApkDownloadView) viewByComponent2).getRealDownloadView();
            if ((realDownloadView instanceof xg0) && (getTag() instanceof hm0)) {
                n((hm0) getTag(), (xg0) realDownloadView);
                return;
            } else {
                this.e = null;
                return;
            }
        }
        this.e = null;
    }

    public final void n(@NonNull hm0 hm0Var, xg0 xg0Var) {
        bm0 bm0Var = hm0Var.d;
        em0 em0Var = hm0Var.e;
        if (bm0Var != null && em0Var != null) {
            hm0Var.a = 2;
            this.e = new rg0(eg0.d(bm0Var, em0Var.d, ""), xg0Var);
            if (xg0Var instanceof NadCriusMiniVideoDownloadView) {
                NadCriusMiniVideoDownloadView nadCriusMiniVideoDownloadView = (NadCriusMiniVideoDownloadView) xg0Var;
                int a2 = c11.c.a(getContext(), 12.0f);
                nadCriusMiniVideoDownloadView.setImageViewLayout(new FrameLayout.LayoutParams(a2, a2));
                nadCriusMiniVideoDownloadView.setVisibility(0);
                nadCriusMiniVideoDownloadView.setOnClickListener(new b());
            }
        }
    }

    public final void p(em0 em0Var) {
        jy0.e(new ClogBuilder().z(em0Var.c).v(em0Var.a).j(em0Var.b).p(em0Var.d).k(em0Var.e).l(em0Var.f).m(em0Var.g));
    }
}
