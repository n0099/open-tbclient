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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.NoNetworkMoreActivity;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NoNetworkView extends RelativeLayout implements View.OnClickListener {
    private static ArrayList<NoNetworkView> acM = new ArrayList<>();
    private static boolean acO;
    private TextView acN;
    private boolean acP;
    private int acQ;
    private final ArrayList<a> acR;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void aG(boolean z);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.acQ = 0;
        this.acR = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acQ = 0;
        this.acR = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.acQ = 0;
        this.acR = new ArrayList<>();
        init(context, null);
    }

    public void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(getLayout(), this);
        this.acN = (TextView) findViewById(u.g.no_network_guide);
        setOnClickListener(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u.l.noNetworkView);
            this.acP = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        try {
            if (com.baidu.adp.lib.util.i.fq()) {
                aF(false);
                setIsHasNetwork(true);
                return;
            }
            aF(true);
            setIsHasNetwork(false);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    protected int getLayout() {
        return u.h.no_network_view;
    }

    public void a(a aVar) {
        if (aVar != null && !this.acR.contains(aVar)) {
            this.acR.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.acR.contains(aVar)) {
            this.acR.remove(aVar);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        acO = z;
        if (acO) {
            Iterator<NoNetworkView> it = acM.iterator();
            while (it.hasNext()) {
                it.next().aF(false);
            }
            return;
        }
        Iterator<NoNetworkView> it2 = acM.iterator();
        while (it2.hasNext()) {
            it2.next().aF(true);
        }
    }

    public void aF(boolean z) {
        if (z) {
            if (1 != this.acQ) {
                this.acQ = 1;
                this.acN.setText(u.j.no_network_guide);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.acR.size(); i++) {
                    this.acR.get(i).aG(false);
                }
            }
        } else if (this.acP && !BdSocketLinkService.isAvailable()) {
            if (2 != this.acQ) {
                this.acQ = 2;
                this.acN.setText(u.j.offline_guide);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.acR.size(); i2++) {
                    this.acR.get(i2).aG(false);
                }
            }
        } else if (this.acQ != 0) {
            this.acQ = 0;
            if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.8f);
                alphaAnimation3.setFillAfter(true);
                alphaAnimation3.setDuration(500L);
                alphaAnimation3.setAnimationListener(new r(this));
                startAnimation(alphaAnimation3);
                for (int i3 = 0; i3 < this.acR.size(); i3++) {
                    this.acR.get(i3).aG(true);
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
        acM.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        acM.remove(this);
        this.acR.clear();
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().af(i == 1);
            ((TbPageContext) hVar).getLayoutMode().w(this);
        }
        av.d(this, u.f.nonetworkview_bg_selector, i);
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
