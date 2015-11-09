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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.NoNetworkMoreActivity;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NoNetworkView extends RelativeLayout implements View.OnClickListener {
    private static ArrayList<NoNetworkView> aem = new ArrayList<>();
    private static boolean aeo;
    private TextView aen;
    private boolean aep;
    private int aeq;
    private final ArrayList<a> aer;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void ax(boolean z);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aeq = 0;
        this.aer = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeq = 0;
        this.aer = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.aeq = 0;
        this.aer = new ArrayList<>();
        init(context, null);
    }

    public void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(i.g.no_network_view, this);
        this.aen = (TextView) findViewById(i.f.no_network_guide);
        setOnClickListener(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.j.noNetworkView);
            this.aep = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        try {
            if (com.baidu.adp.lib.util.i.iN()) {
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
        if (aVar != null && !this.aer.contains(aVar)) {
            this.aer.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.aer.contains(aVar)) {
            this.aer.remove(aVar);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        aeo = z;
        if (aeo) {
            Iterator<NoNetworkView> it = aem.iterator();
            while (it.hasNext()) {
                it.next().aw(false);
            }
            return;
        }
        Iterator<NoNetworkView> it2 = aem.iterator();
        while (it2.hasNext()) {
            it2.next().aw(true);
        }
    }

    public void aw(boolean z) {
        if (z) {
            if (1 != this.aeq) {
                this.aeq = 1;
                this.aen.setText(i.h.no_network_guide);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.aer.size(); i++) {
                    this.aer.get(i).ax(false);
                }
            }
        } else if (this.aep && !BdSocketLinkService.isAvailable()) {
            if (2 != this.aeq) {
                this.aeq = 2;
                this.aen.setText(i.h.offline_guide);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.aer.size(); i2++) {
                    this.aer.get(i2).ax(false);
                }
            }
        } else if (this.aeq != 0) {
            this.aeq = 0;
            if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.8f);
                alphaAnimation3.setFillAfter(true);
                alphaAnimation3.setDuration(500L);
                alphaAnimation3.setAnimationListener(new n(this));
                startAnimation(alphaAnimation3);
                for (int i3 = 0; i3 < this.aer.size(); i3++) {
                    this.aer.get(i3).ax(true);
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
        aem.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aem.remove(this);
        this.aer.clear();
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ad(i == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this);
        }
        an.c(this, i.e.nonetworkview_bg_selector, i);
    }

    public static void vx() {
        if (com.baidu.adp.lib.util.i.iN()) {
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
