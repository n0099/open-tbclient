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
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.coreExtra.NoNetworkMoreActivity;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NoNetworkView extends RelativeLayout implements View.OnClickListener {
    private static ArrayList<NoNetworkView> alr = new ArrayList<>();
    private static boolean alt;
    private TextView als;
    private boolean alu;
    private int alv;
    private final ArrayList<a> alw;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void aL(boolean z);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alv = 0;
        this.alw = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alv = 0;
        this.alw = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.alv = 0;
        this.alw = new ArrayList<>();
        init(context, null);
    }

    public void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(getLayout(), this);
        this.als = (TextView) findViewById(d.h.no_network_guide);
        setOnClickListener(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.noNetworkView);
            this.alu = obtainStyledAttributes.getBoolean(d.n.noNetworkView_is_support_offline, false);
            obtainStyledAttributes.recycle();
        }
        try {
            if (com.baidu.adp.lib.util.j.hh()) {
                aK(false);
                setIsHasNetwork(true);
                return;
            }
            aK(true);
            setIsHasNetwork(false);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    protected int getLayout() {
        return d.j.no_network_view;
    }

    public void a(a aVar) {
        if (aVar != null && !this.alw.contains(aVar)) {
            this.alw.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.alw.contains(aVar)) {
            this.alw.remove(aVar);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        alt = z;
        if (alt) {
            Iterator<NoNetworkView> it = alr.iterator();
            while (it.hasNext()) {
                it.next().aK(false);
            }
            return;
        }
        Iterator<NoNetworkView> it2 = alr.iterator();
        while (it2.hasNext()) {
            it2.next().aK(true);
        }
    }

    public void aK(boolean z) {
        if (z) {
            if (1 != this.alv) {
                this.alv = 1;
                this.als.setText(d.l.no_network_guide);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.alw.size(); i++) {
                    this.alw.get(i).aL(false);
                }
            }
        } else if (this.alu && !BdSocketLinkService.isAvailable()) {
            if (2 != this.alv) {
                this.alv = 2;
                this.als.setText(d.l.offline_guide);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.alw.size(); i2++) {
                    this.alw.get(i2).aL(false);
                }
            }
        } else if (this.alv != 0) {
            this.alv = 0;
            if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.8f);
                alphaAnimation3.setFillAfter(true);
                alphaAnimation3.setDuration(500L);
                alphaAnimation3.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.core.view.NoNetworkView.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        NoNetworkView.this.setVisibility(8);
                    }
                });
                startAnimation(alphaAnimation3);
                for (int i3 = 0; i3 < this.alw.size(); i3++) {
                    this.alw.get(i3).aL(true);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this && getVisibility() == 0) {
            Intent intent = new Intent(this.mContext, NoNetworkMoreActivity.class);
            intent.addFlags(268435456);
            this.mContext.startActivity(intent);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        alr.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        alr.remove(this);
        this.alw.clear();
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().ah(i == 1);
            ((TbPageContext) eVar).getLayoutMode().t(this);
        }
        aj.d(this, d.g.nonetworkview_bg_selector, i);
    }

    public static void wg() {
        if (com.baidu.adp.lib.util.j.hh()) {
            setIsHasNetwork(true);
        } else {
            setIsHasNetwork(false);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        clearAnimation();
        super.setVisibility(i);
    }
}
