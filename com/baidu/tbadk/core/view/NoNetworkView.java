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
import com.baidu.tbadk.coreExtra.NoNetworkMoreActivity;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NoNetworkView extends RelativeLayout implements View.OnClickListener {
    private static ArrayList<NoNetworkView> afC = new ArrayList<>();
    private static boolean afE;
    private TextView afD;
    private boolean afF;
    private int afG;
    private final ArrayList<a> afH;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void aH(boolean z);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.afG = 0;
        this.afH = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afG = 0;
        this.afH = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.afG = 0;
        this.afH = new ArrayList<>();
        init(context, null);
    }

    public void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(getLayout(), this);
        this.afD = (TextView) findViewById(t.g.no_network_guide);
        setOnClickListener(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.l.noNetworkView);
            this.afF = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        try {
            if (com.baidu.adp.lib.util.i.gm()) {
                aG(false);
                setIsHasNetwork(true);
                return;
            }
            aG(true);
            setIsHasNetwork(false);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    protected int getLayout() {
        return t.h.no_network_view;
    }

    public void a(a aVar) {
        if (aVar != null && !this.afH.contains(aVar)) {
            this.afH.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.afH.contains(aVar)) {
            this.afH.remove(aVar);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        afE = z;
        if (afE) {
            Iterator<NoNetworkView> it = afC.iterator();
            while (it.hasNext()) {
                it.next().aG(false);
            }
            return;
        }
        Iterator<NoNetworkView> it2 = afC.iterator();
        while (it2.hasNext()) {
            it2.next().aG(true);
        }
    }

    public void aG(boolean z) {
        if (z) {
            if (1 != this.afG) {
                this.afG = 1;
                this.afD.setText(t.j.no_network_guide);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.afH.size(); i++) {
                    this.afH.get(i).aH(false);
                }
            }
        } else if (this.afF && !BdSocketLinkService.isAvailable()) {
            if (2 != this.afG) {
                this.afG = 2;
                this.afD.setText(t.j.offline_guide);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.afH.size(); i2++) {
                    this.afH.get(i2).aH(false);
                }
            }
        } else if (this.afG != 0) {
            this.afG = 0;
            if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.8f);
                alphaAnimation3.setFillAfter(true);
                alphaAnimation3.setDuration(500L);
                alphaAnimation3.setAnimationListener(new r(this));
                startAnimation(alphaAnimation3);
                for (int i3 = 0; i3 < this.afH.size(); i3++) {
                    this.afH.get(i3).aH(true);
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
        afC.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        afC.remove(this);
        this.afH.clear();
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ah(i == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this);
        }
        com.baidu.tbadk.core.util.av.d(this, t.f.nonetworkview_bg_selector, i);
    }

    public static void wc() {
        if (com.baidu.adp.lib.util.i.gm()) {
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
