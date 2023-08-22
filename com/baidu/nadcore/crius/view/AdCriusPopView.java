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
import com.baidu.tieba.am0;
import com.baidu.tieba.br0;
import com.baidu.tieba.er0;
import com.baidu.tieba.hl0;
import com.baidu.tieba.hr0;
import com.baidu.tieba.m61;
import com.baidu.tieba.pk0;
import com.baidu.tieba.qk0;
import com.baidu.tieba.rd1;
import com.baidu.tieba.rr0;
import com.baidu.tieba.t31;
import com.baidu.tieba.td1;
import com.baidu.tieba.ul0;
import java.util.Map;
/* loaded from: classes3.dex */
public class AdCriusPopView extends AdCriusBaseView<CriusData> implements View.OnClickListener, td1<View> {
    public ul0 e;
    public Animation f;
    public Animation g;
    public rd1 h;
    public boolean i;

    @Override // com.baidu.nadcore.crius.view.AdCriusBaseView
    public int d() {
        return R.id.nad_crius_container_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.td1
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

    @Override // com.baidu.tieba.td1
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
            rd1 rd1Var = this.h;
            if (rd1Var != null) {
                rd1Var.c();
            }
            this.i = true;
        }
    }

    public AdCriusPopView(Context context) {
        this(context, null);
    }

    @Override // com.baidu.tieba.td1
    public void c(boolean z) {
        if (getVisibility() == 0) {
            return;
        }
        if (z) {
            q();
            return;
        }
        setVisibility(0);
        rd1 rd1Var = this.h;
        if (rd1Var != null) {
            rd1Var.c();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.getId() == R.id.nad_base_delete_id) {
            b("1", true);
        }
    }

    @Override // com.baidu.tieba.td1
    public void setCriusPopListener(@NonNull rd1 rd1Var) {
        this.h = rd1Var;
    }

    @Override // com.baidu.tieba.td1
    public void setData(@NonNull hr0 hr0Var) {
        CriusData criusData;
        setTag(hr0Var);
        Object obj = hr0Var.c;
        if (!(obj instanceof pk0)) {
            return;
        }
        Map<String, pk0.a> map = ((pk0) obj).b;
        if (map == null) {
            setVisibility(8);
            return;
        }
        pk0.a aVar = map.get("crius_pop");
        if (aVar != null && (criusData = aVar.a) != null) {
            k(criusData, false);
            a();
            return;
        }
        setVisibility(8);
    }

    public void update(int i) {
        int i2;
        if ((getTag() instanceof hr0) && (i2 = ((hr0) getTag()).b) >= 0 && !this.i && i >= i2) {
            q();
        }
    }

    public AdCriusPopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.baidu.tieba.td1
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

    @Override // com.baidu.tieba.td1
    public void b(String str, boolean z) {
        er0 er0Var;
        this.i = false;
        this.f = null;
        if (z && this.g != null) {
            return;
        }
        rd1 rd1Var = this.h;
        if (rd1Var != null) {
            rd1Var.a(z, 480L);
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
        if (!(getTag() instanceof hr0) || (er0Var = ((hr0) getTag()).e) == null) {
            return;
        }
        er0Var.a();
        er0Var.c = ClogBuilder.LogType.NAVIDEO_POP_CLOSE.type;
        er0Var.g = str;
        p(er0Var);
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
            rr0 rr0Var = new rr0();
            rr0Var.a = str;
            rr0Var.b = str2;
            rr0Var.c = true;
            if (map != null) {
                TextUtils.equals("1", map.get(NativeConstants.CHARGE_TYPE));
            }
            this.h.b(rr0Var);
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
            qk0 realDownloadView = ((ApkDownloadView) viewByComponent2).getRealDownloadView();
            if ((realDownloadView instanceof am0) && (getTag() instanceof hr0)) {
                n((hr0) getTag(), (am0) realDownloadView);
                return;
            } else {
                this.e = null;
                return;
            }
        }
        this.e = null;
    }

    public final void n(@NonNull hr0 hr0Var, am0 am0Var) {
        br0 br0Var = hr0Var.d;
        er0 er0Var = hr0Var.e;
        if (br0Var != null && er0Var != null) {
            hr0Var.a = 2;
            this.e = new ul0(hl0.d(br0Var, er0Var.d, ""), am0Var);
            if (am0Var instanceof NadCriusMiniVideoDownloadView) {
                NadCriusMiniVideoDownloadView nadCriusMiniVideoDownloadView = (NadCriusMiniVideoDownloadView) am0Var;
                int a2 = m61.c.a(getContext(), 12.0f);
                nadCriusMiniVideoDownloadView.setImageViewLayout(new FrameLayout.LayoutParams(a2, a2));
                nadCriusMiniVideoDownloadView.setVisibility(0);
                nadCriusMiniVideoDownloadView.setOnClickListener(new b());
            }
        }
    }

    public final void p(er0 er0Var) {
        t31.e(new ClogBuilder().z(er0Var.c).v(er0Var.a).j(er0Var.b).p(er0Var.d).k(er0Var.e).l(er0Var.f).m(er0Var.g));
    }
}
