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
    private static ArrayList<NoNetworkView> afj = new ArrayList<>();
    private static boolean afl;
    private TextView afk;
    private boolean afm;
    private int afn;
    private final ArrayList<a> afo;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void aA(boolean z);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.afn = 0;
        this.afo = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afn = 0;
        this.afo = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.afn = 0;
        this.afo = new ArrayList<>();
        init(context, null);
    }

    public void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(n.g.no_network_view, this);
        this.afk = (TextView) findViewById(n.f.no_network_guide);
        setOnClickListener(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n.k.noNetworkView);
            this.afm = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        try {
            if (com.baidu.adp.lib.util.i.iP()) {
                az(false);
                setIsHasNetwork(true);
                return;
            }
            az(true);
            setIsHasNetwork(false);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void a(a aVar) {
        if (aVar != null && !this.afo.contains(aVar)) {
            this.afo.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.afo.contains(aVar)) {
            this.afo.remove(aVar);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        afl = z;
        if (afl) {
            Iterator<NoNetworkView> it = afj.iterator();
            while (it.hasNext()) {
                it.next().az(false);
            }
            return;
        }
        Iterator<NoNetworkView> it2 = afj.iterator();
        while (it2.hasNext()) {
            it2.next().az(true);
        }
    }

    public void az(boolean z) {
        if (z) {
            if (1 != this.afn) {
                this.afn = 1;
                this.afk.setText(n.i.no_network_guide);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.afo.size(); i++) {
                    this.afo.get(i).aA(false);
                }
            }
        } else if (this.afm && !BdSocketLinkService.isAvailable()) {
            if (2 != this.afn) {
                this.afn = 2;
                this.afk.setText(n.i.offline_guide);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.afo.size(); i2++) {
                    this.afo.get(i2).aA(false);
                }
            }
        } else if (this.afn != 0) {
            this.afn = 0;
            if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.8f);
                alphaAnimation3.setFillAfter(true);
                alphaAnimation3.setDuration(500L);
                alphaAnimation3.setAnimationListener(new o(this));
                startAnimation(alphaAnimation3);
                for (int i3 = 0; i3 < this.afo.size(); i3++) {
                    this.afo.get(i3).aA(true);
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
        afj.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        afj.remove(this);
        this.afo.clear();
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().af(i == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this);
        }
        as.c(this, n.e.nonetworkview_bg_selector, i);
    }

    public static void wd() {
        if (com.baidu.adp.lib.util.i.iP()) {
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
