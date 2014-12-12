package com.baidu.tbadk.core.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.NoNetworkMoreActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NoNetworkView extends RelativeLayout implements View.OnClickListener {
    private static ArrayList<NoNetworkView> Nf = new ArrayList<>();
    private static boolean Nh;
    private TextView Ng;
    private boolean Ni;
    private int Nj;
    private final ArrayList<ad> Nk;
    private Context mContext;

    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Nj = 0;
        this.Nk = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Nj = 0;
        this.Nk = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.Nj = 0;
        this.Nk = new ArrayList<>();
        init(context, null);
    }

    public void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.x.no_network_view, this);
        this.Ng = (TextView) findViewById(com.baidu.tieba.w.no_network_guide);
        setOnClickListener(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.tieba.ab.noNetworkView);
            this.Ni = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                aq(false);
                setIsHasNetwork(true);
                return;
            }
            aq(true);
            setIsHasNetwork(false);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void a(ad adVar) {
        if (adVar != null && !this.Nk.contains(adVar)) {
            this.Nk.add(adVar);
        }
    }

    public void b(ad adVar) {
        if (adVar != null && this.Nk.contains(adVar)) {
            this.Nk.remove(adVar);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        Nh = z;
        if (Nh) {
            Iterator<NoNetworkView> it = Nf.iterator();
            while (it.hasNext()) {
                it.next().aq(false);
            }
            return;
        }
        Iterator<NoNetworkView> it2 = Nf.iterator();
        while (it2.hasNext()) {
            it2.next().aq(true);
        }
    }

    public void aq(boolean z) {
        if (z) {
            if (1 != this.Nj) {
                this.Nj = 1;
                this.Ng.setText(com.baidu.tieba.z.no_network_guide);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.Nk.size(); i++) {
                    this.Nk.get(i).ar(false);
                }
            }
        } else if (this.Ni && !BdSocketLinkService.isAvailable()) {
            if (2 != this.Nj) {
                this.Nj = 2;
                this.Ng.setText(com.baidu.tieba.z.offline_guide);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.Nk.size(); i2++) {
                    this.Nk.get(i2).ar(false);
                }
            }
        } else if (this.Nj != 0) {
            this.Nj = 0;
            if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation3.setFillAfter(true);
                alphaAnimation3.setDuration(500L);
                alphaAnimation3.setAnimationListener(new ac(this));
                startAnimation(alphaAnimation3);
                for (int i3 = 0; i3 < this.Nk.size(); i3++) {
                    this.Nk.get(i3).ar(true);
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
        Nf.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Nf.remove(this);
        this.Nk.clear();
    }

    public void onChangeSkinType(com.baidu.adp.base.j<?> jVar, int i) {
        if (jVar instanceof TbPageContext) {
            ((TbPageContext) jVar).getLayoutMode().ab(i == 1);
            ((TbPageContext) jVar).getLayoutMode().h(this);
        }
        com.baidu.tbadk.core.util.ax.c(this, com.baidu.tieba.v.nonetworkview_bg_selector, i);
    }

    public static void qw() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) TbadkCoreApplication.m255getInst().getApp().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            setIsHasNetwork(true);
        } else {
            setIsHasNetwork(false);
        }
    }
}
