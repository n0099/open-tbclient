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
    private static boolean akB;
    private static ArrayList<NoNetworkView> akz = new ArrayList<>();
    private TextView akA;
    private boolean akC;
    private int akD;
    private final ArrayList<a> akE;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void aK(boolean z);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akD = 0;
        this.akE = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akD = 0;
        this.akE = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.akD = 0;
        this.akE = new ArrayList<>();
        init(context, null);
    }

    public void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(getLayout(), this);
        this.akA = (TextView) findViewById(w.h.no_network_guide);
        setOnClickListener(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.noNetworkView);
            this.akC = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        try {
            if (com.baidu.adp.lib.util.i.he()) {
                aJ(false);
                setIsHasNetwork(true);
                return;
            }
            aJ(true);
            setIsHasNetwork(false);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    protected int getLayout() {
        return w.j.no_network_view;
    }

    public void a(a aVar) {
        if (aVar != null && !this.akE.contains(aVar)) {
            this.akE.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.akE.contains(aVar)) {
            this.akE.remove(aVar);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        akB = z;
        if (akB) {
            Iterator<NoNetworkView> it = akz.iterator();
            while (it.hasNext()) {
                it.next().aJ(false);
            }
            return;
        }
        Iterator<NoNetworkView> it2 = akz.iterator();
        while (it2.hasNext()) {
            it2.next().aJ(true);
        }
    }

    public void aJ(boolean z) {
        if (z) {
            if (1 != this.akD) {
                this.akD = 1;
                this.akA.setText(w.l.no_network_guide);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.akE.size(); i++) {
                    this.akE.get(i).aK(false);
                }
            }
        } else if (this.akC && !BdSocketLinkService.isAvailable()) {
            if (2 != this.akD) {
                this.akD = 2;
                this.akA.setText(w.l.offline_guide);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.akE.size(); i2++) {
                    this.akE.get(i2).aK(false);
                }
            }
        } else if (this.akD != 0) {
            this.akD = 0;
            if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.8f);
                alphaAnimation3.setFillAfter(true);
                alphaAnimation3.setDuration(500L);
                alphaAnimation3.setAnimationListener(new z(this));
                startAnimation(alphaAnimation3);
                for (int i3 = 0; i3 < this.akE.size(); i3++) {
                    this.akE.get(i3).aK(true);
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
        akz.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        akz.remove(this);
        this.akE.clear();
    }

    public void onChangeSkinType(com.baidu.adp.base.g<?> gVar, int i) {
        if (gVar instanceof TbPageContext) {
            ((TbPageContext) gVar).getLayoutMode().ah(i == 1);
            ((TbPageContext) gVar).getLayoutMode().t(this);
        }
        com.baidu.tbadk.core.util.aq.d(this, w.g.nonetworkview_bg_selector, i);
    }

    public static void wy() {
        if (com.baidu.adp.lib.util.i.he()) {
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
