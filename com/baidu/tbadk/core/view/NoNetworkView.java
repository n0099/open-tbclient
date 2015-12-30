package com.baidu.tbadk.core.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.NoNetworkMoreActivity;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NoNetworkView extends RelativeLayout implements View.OnClickListener {
    private static ArrayList<NoNetworkView> afV = new ArrayList<>();
    private static boolean afX;
    private TextView afW;
    private boolean afY;
    private int afZ;
    private final ArrayList<a> aga;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void ax(boolean z);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.afZ = 0;
        this.aga = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afZ = 0;
        this.aga = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.afZ = 0;
        this.aga = new ArrayList<>();
        init(context, null);
    }

    public void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(n.h.no_network_view, this);
        this.afW = (TextView) findViewById(n.g.no_network_guide);
        setOnClickListener(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n.l.noNetworkView);
            this.afY = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        try {
            if (com.baidu.adp.lib.util.i.iQ()) {
                aw(false);
                setIsHasNetwork(true);
                return;
            }
            aw(true);
            setIsHasNetwork(false);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void a(a aVar) {
        if (aVar != null && !this.aga.contains(aVar)) {
            this.aga.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.aga.contains(aVar)) {
            this.aga.remove(aVar);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        afX = z;
        if (afX) {
            Iterator<NoNetworkView> it = afV.iterator();
            while (it.hasNext()) {
                it.next().aw(false);
            }
            return;
        }
        Iterator<NoNetworkView> it2 = afV.iterator();
        while (it2.hasNext()) {
            it2.next().aw(true);
        }
    }

    public void aw(boolean z) {
        if (z) {
            if (1 != this.afZ) {
                this.afZ = 1;
                this.afW.setText(n.j.no_network_guide);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.aga.size(); i++) {
                    this.aga.get(i).ax(false);
                }
            }
        } else if (this.afY && !BdSocketLinkService.isAvailable()) {
            if (2 != this.afZ) {
                this.afZ = 2;
                this.afW.setText(n.j.offline_guide);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.aga.size(); i2++) {
                    this.aga.get(i2).ax(false);
                }
            }
        } else if (this.afZ != 0) {
            this.afZ = 0;
            if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.8f);
                alphaAnimation3.setFillAfter(true);
                alphaAnimation3.setDuration(500L);
                alphaAnimation3.setAnimationListener(new p(this));
                startAnimation(alphaAnimation3);
                for (int i3 = 0; i3 < this.aga.size(); i3++) {
                    this.aga.get(i3).ax(true);
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
        afV.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        afV.remove(this);
        this.aga.clear();
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ac(i == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this);
        }
        as.c(this, n.f.nonetworkview_bg_selector, i);
    }

    public static void vN() {
        if (com.baidu.adp.lib.util.i.iQ()) {
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
