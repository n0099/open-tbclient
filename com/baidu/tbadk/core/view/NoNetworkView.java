package com.baidu.tbadk.core.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.NoNetworkMoreActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import d.a.c.a.f;
import d.a.c.e.p.j;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class NoNetworkView extends RelativeLayout implements View.OnClickListener {
    public static ArrayList<NoNetworkView> j = new ArrayList<>();
    public static boolean k;

    /* renamed from: e  reason: collision with root package name */
    public TextView f12284e;

    /* renamed from: f  reason: collision with root package name */
    public Context f12285f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12286g;

    /* renamed from: h  reason: collision with root package name */
    public int f12287h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<b> f12288i;

    /* loaded from: classes3.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            NoNetworkView.this.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void b(boolean z);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12287h = 0;
        this.f12288i = new ArrayList<>();
        b(context, attributeSet);
    }

    public static void f() {
        if (j.z()) {
            setIsHasNetwork(true);
        } else {
            setIsHasNetwork(false);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        k = z;
        if (z) {
            Iterator<NoNetworkView> it = j.iterator();
            while (it.hasNext()) {
                it.next().e(false);
            }
            return;
        }
        Iterator<NoNetworkView> it2 = j.iterator();
        while (it2.hasNext()) {
            it2.next().e(true);
        }
    }

    public void a(b bVar) {
        if (bVar == null || this.f12288i.contains(bVar)) {
            return;
        }
        this.f12288i.add(bVar);
    }

    public void b(Context context, AttributeSet attributeSet) {
        this.f12285f = context;
        LayoutInflater.from(context).inflate(getLayout(), this);
        this.f12284e = (TextView) findViewById(R.id.no_network_guide);
        setOnClickListener(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.noNetworkView);
            this.f12286g = obtainStyledAttributes.getBoolean(R$styleable.noNetworkView_is_support_offline, false);
            obtainStyledAttributes.recycle();
        }
        try {
            if (j.z()) {
                e(false);
                setIsHasNetwork(true);
                return;
            }
            e(true);
            setIsHasNetwork(false);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void c(f<?> fVar, int i2) {
        if (fVar instanceof TbPageContext) {
            TbPageContext tbPageContext = (TbPageContext) fVar;
            tbPageContext.getLayoutMode().k(i2 == 1);
            tbPageContext.getLayoutMode().j(this);
        }
        SkinManager.setBackgroundResource(this, R.drawable.nonetworkview_bg_selector, i2);
    }

    public void d(b bVar) {
        if (bVar != null && this.f12288i.contains(bVar)) {
            this.f12288i.remove(bVar);
        }
    }

    public void e(boolean z) {
        if (z) {
            if (1 == this.f12287h) {
                return;
            }
            this.f12287h = 1;
            this.f12284e.setText(R.string.no_network_guide);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setDuration(500L);
            setVisibility(0);
            startAnimation(alphaAnimation);
            for (int i2 = 0; i2 < this.f12288i.size(); i2++) {
                this.f12288i.get(i2).b(false);
            }
        } else if (this.f12286g && !BdSocketLinkService.isAvailable()) {
            if (2 == this.f12287h) {
                return;
            }
            this.f12287h = 2;
            this.f12284e.setText(R.string.offline_guide);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation2.setFillAfter(true);
            alphaAnimation2.setDuration(500L);
            setVisibility(0);
            startAnimation(alphaAnimation2);
            for (int i3 = 0; i3 < this.f12288i.size(); i3++) {
                this.f12288i.get(i3).b(false);
            }
        } else if (this.f12287h != 0) {
            this.f12287h = 0;
            if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.8f);
                alphaAnimation3.setFillAfter(true);
                alphaAnimation3.setDuration(500L);
                alphaAnimation3.setAnimationListener(new a());
                startAnimation(alphaAnimation3);
                for (int i4 = 0; i4 < this.f12288i.size(); i4++) {
                    this.f12288i.get(i4).b(true);
                }
            }
        }
    }

    public int getLayout() {
        return R.layout.no_network_view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.add(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this && getVisibility() == 0) {
            Intent intent = new Intent(this.f12285f, NoNetworkMoreActivity.class);
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            this.f12285f.startActivity(intent);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j.remove(this);
        this.f12288i.clear();
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        clearAnimation();
        super.setVisibility(i2);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12287h = 0;
        this.f12288i = new ArrayList<>();
        b(context, attributeSet);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.f12287h = 0;
        this.f12288i = new ArrayList<>();
        b(context, null);
    }
}
