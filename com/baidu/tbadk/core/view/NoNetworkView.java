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
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NoNetworkView extends RelativeLayout implements View.OnClickListener {
    private static ArrayList<NoNetworkView> akO = new ArrayList<>();
    private static boolean akQ;
    private TextView akP;
    private boolean akR;
    private int akS;
    private final ArrayList<a> akT;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void aL(boolean z);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akS = 0;
        this.akT = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akS = 0;
        this.akT = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.akS = 0;
        this.akT = new ArrayList<>();
        init(context, null);
    }

    public void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(getLayout(), this);
        this.akP = (TextView) findViewById(w.h.no_network_guide);
        setOnClickListener(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.noNetworkView);
            this.akR = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        try {
            if (com.baidu.adp.lib.util.i.hj()) {
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
        return w.j.no_network_view;
    }

    public void a(a aVar) {
        if (aVar != null && !this.akT.contains(aVar)) {
            this.akT.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.akT.contains(aVar)) {
            this.akT.remove(aVar);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        akQ = z;
        if (akQ) {
            Iterator<NoNetworkView> it = akO.iterator();
            while (it.hasNext()) {
                it.next().aK(false);
            }
            return;
        }
        Iterator<NoNetworkView> it2 = akO.iterator();
        while (it2.hasNext()) {
            it2.next().aK(true);
        }
    }

    public void aK(boolean z) {
        if (z) {
            if (1 != this.akS) {
                this.akS = 1;
                this.akP.setText(w.l.no_network_guide);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.akT.size(); i++) {
                    this.akT.get(i).aL(false);
                }
            }
        } else if (this.akR && !BdSocketLinkService.isAvailable()) {
            if (2 != this.akS) {
                this.akS = 2;
                this.akP.setText(w.l.offline_guide);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.akT.size(); i2++) {
                    this.akT.get(i2).aL(false);
                }
            }
        } else if (this.akS != 0) {
            this.akS = 0;
            if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.8f);
                alphaAnimation3.setFillAfter(true);
                alphaAnimation3.setDuration(500L);
                alphaAnimation3.setAnimationListener(new z(this));
                startAnimation(alphaAnimation3);
                for (int i3 = 0; i3 < this.akT.size(); i3++) {
                    this.akT.get(i3).aL(true);
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
        akO.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        akO.remove(this);
        this.akT.clear();
    }

    public void onChangeSkinType(com.baidu.adp.base.g<?> gVar, int i) {
        if (gVar instanceof TbPageContext) {
            ((TbPageContext) gVar).getLayoutMode().ah(i == 1);
            ((TbPageContext) gVar).getLayoutMode().t(this);
        }
        com.baidu.tbadk.core.util.as.d(this, w.g.nonetworkview_bg_selector, i);
    }

    public static void ww() {
        if (com.baidu.adp.lib.util.i.hj()) {
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
