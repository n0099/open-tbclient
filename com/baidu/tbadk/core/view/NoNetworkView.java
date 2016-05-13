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
    private static ArrayList<NoNetworkView> abI = new ArrayList<>();
    private static boolean abK;
    private TextView abJ;
    private boolean abL;
    private int abM;
    private final ArrayList<a> abN;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void aF(boolean z);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abM = 0;
        this.abN = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abM = 0;
        this.abN = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.abM = 0;
        this.abN = new ArrayList<>();
        init(context, null);
    }

    public void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(t.h.no_network_view, this);
        this.abJ = (TextView) findViewById(t.g.no_network_guide);
        setOnClickListener(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.l.noNetworkView);
            this.abL = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        try {
            if (com.baidu.adp.lib.util.i.fq()) {
                aE(false);
                setIsHasNetwork(true);
                return;
            }
            aE(true);
            setIsHasNetwork(false);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void a(a aVar) {
        if (aVar != null && !this.abN.contains(aVar)) {
            this.abN.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.abN.contains(aVar)) {
            this.abN.remove(aVar);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        abK = z;
        if (abK) {
            Iterator<NoNetworkView> it = abI.iterator();
            while (it.hasNext()) {
                it.next().aE(false);
            }
            return;
        }
        Iterator<NoNetworkView> it2 = abI.iterator();
        while (it2.hasNext()) {
            it2.next().aE(true);
        }
    }

    public void aE(boolean z) {
        if (z) {
            if (1 != this.abM) {
                this.abM = 1;
                this.abJ.setText(t.j.no_network_guide);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.abN.size(); i++) {
                    this.abN.get(i).aF(false);
                }
            }
        } else if (this.abL && !BdSocketLinkService.isAvailable()) {
            if (2 != this.abM) {
                this.abM = 2;
                this.abJ.setText(t.j.offline_guide);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.abN.size(); i2++) {
                    this.abN.get(i2).aF(false);
                }
            }
        } else if (this.abM != 0) {
            this.abM = 0;
            if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.8f);
                alphaAnimation3.setFillAfter(true);
                alphaAnimation3.setDuration(500L);
                alphaAnimation3.setAnimationListener(new r(this));
                startAnimation(alphaAnimation3);
                for (int i3 = 0; i3 < this.abN.size(); i3++) {
                    this.abN.get(i3).aF(true);
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
        abI.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        abI.remove(this);
        this.abN.clear();
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ae(i == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this);
        }
        com.baidu.tbadk.core.util.at.d(this, t.f.nonetworkview_bg_selector, i);
    }

    public static void uY() {
        if (com.baidu.adp.lib.util.i.fq()) {
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
