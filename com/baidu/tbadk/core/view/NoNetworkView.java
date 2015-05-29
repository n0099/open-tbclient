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
    private static ArrayList<NoNetworkView> ZK = new ArrayList<>();
    private static boolean ZM;
    private TextView ZL;
    private boolean ZN;
    private int ZO;
    private final ArrayList<ad> ZP;
    private Context mContext;

    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ZO = 0;
        this.ZP = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZO = 0;
        this.ZP = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.ZO = 0;
        this.ZP = new ArrayList<>();
        init(context, null);
    }

    public void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.hr().inflate(context, com.baidu.tieba.r.no_network_view, this);
        this.ZL = (TextView) findViewById(com.baidu.tieba.q.no_network_guide);
        setOnClickListener(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.tieba.v.noNetworkView);
            this.ZN = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                at(false);
                setIsHasNetwork(true);
                return;
            }
            at(true);
            setIsHasNetwork(false);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void a(ad adVar) {
        if (adVar != null && !this.ZP.contains(adVar)) {
            this.ZP.add(adVar);
        }
    }

    public void b(ad adVar) {
        if (adVar != null && this.ZP.contains(adVar)) {
            this.ZP.remove(adVar);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        ZM = z;
        if (ZM) {
            Iterator<NoNetworkView> it = ZK.iterator();
            while (it.hasNext()) {
                it.next().at(false);
            }
            return;
        }
        Iterator<NoNetworkView> it2 = ZK.iterator();
        while (it2.hasNext()) {
            it2.next().at(true);
        }
    }

    public void at(boolean z) {
        if (z) {
            if (1 != this.ZO) {
                this.ZO = 1;
                this.ZL.setText(com.baidu.tieba.t.no_network_guide);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.ZP.size(); i++) {
                    this.ZP.get(i).au(false);
                }
            }
        } else if (this.ZN && !BdSocketLinkService.isAvailable()) {
            if (2 != this.ZO) {
                this.ZO = 2;
                this.ZL.setText(com.baidu.tieba.t.offline_guide);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.ZP.size(); i2++) {
                    this.ZP.get(i2).au(false);
                }
            }
        } else if (this.ZO != 0) {
            this.ZO = 0;
            if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation3.setFillAfter(true);
                alphaAnimation3.setDuration(500L);
                alphaAnimation3.setAnimationListener(new ac(this));
                startAnimation(alphaAnimation3);
                for (int i3 = 0; i3 < this.ZP.size(); i3++) {
                    this.ZP.get(i3).au(true);
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
        ZK.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ZK.remove(this);
        this.ZP.clear();
    }

    public void onChangeSkinType(com.baidu.adp.base.j<?> jVar, int i) {
        if (jVar instanceof TbPageContext) {
            ((TbPageContext) jVar).getLayoutMode().ab(i == 1);
            ((TbPageContext) jVar).getLayoutMode().j(this);
        }
        com.baidu.tbadk.core.util.ay.c(this, com.baidu.tieba.p.nonetworkview_bg_selector, i);
    }

    public static void uv() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) TbadkCoreApplication.m411getInst().getApp().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            setIsHasNetwork(true);
        } else {
            setIsHasNetwork(false);
        }
    }
}
