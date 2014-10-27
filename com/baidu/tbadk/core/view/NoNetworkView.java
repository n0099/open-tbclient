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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.NoNetworkMoreActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NoNetworkView extends RelativeLayout implements View.OnClickListener {
    private static ArrayList<NoNetworkView> Il = new ArrayList<>();
    private static boolean In;
    private TextView Im;
    private boolean Io;
    private int Ip;
    private final ArrayList<u> Iq;
    private Context mContext;

    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ip = 0;
        this.Iq = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ip = 0;
        this.Iq = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.Ip = 0;
        this.Iq = new ArrayList<>();
        init(context, null);
    }

    public void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.w.no_network_view, this);
        this.Im = (TextView) findViewById(com.baidu.tieba.v.no_network_guide);
        setOnClickListener(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.tieba.aa.noNetworkView);
            this.Io = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                Z(false);
                setIsHasNetwork(true);
                return;
            }
            Z(true);
            setIsHasNetwork(false);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void a(u uVar) {
        if (uVar != null && !this.Iq.contains(uVar)) {
            this.Iq.add(uVar);
        }
    }

    public void b(u uVar) {
        if (uVar != null && this.Iq.contains(uVar)) {
            this.Iq.remove(uVar);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        In = z;
        if (In) {
            Iterator<NoNetworkView> it = Il.iterator();
            while (it.hasNext()) {
                it.next().Z(false);
            }
            return;
        }
        Iterator<NoNetworkView> it2 = Il.iterator();
        while (it2.hasNext()) {
            it2.next().Z(true);
        }
    }

    public void Z(boolean z) {
        if (z) {
            if (1 != this.Ip) {
                this.Ip = 1;
                this.Im.setText(com.baidu.tieba.y.no_network_guide);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.Iq.size(); i++) {
                    this.Iq.get(i).aa(false);
                }
            }
        } else if (this.Io && !BdSocketLinkService.isAvailable()) {
            if (2 != this.Ip) {
                this.Ip = 2;
                this.Im.setText(com.baidu.tieba.y.offline_guide);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.Iq.size(); i2++) {
                    this.Iq.get(i2).aa(false);
                }
            }
        } else if (this.Ip != 0) {
            this.Ip = 0;
            if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation3.setFillAfter(true);
                alphaAnimation3.setDuration(500L);
                alphaAnimation3.setAnimationListener(new t(this));
                startAnimation(alphaAnimation3);
                for (int i3 = 0; i3 < this.Iq.size(); i3++) {
                    this.Iq.get(i3).aa(true);
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
        Il.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Il.remove(this);
        this.Iq.clear();
    }

    public void onChangeSkinType(int i) {
        if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).getLayoutMode().L(i == 1);
            ((BaseActivity) this.mContext).getLayoutMode().h(this);
        } else if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).getLayoutMode().L(i == 1);
            ((BaseFragmentActivity) this.mContext).getLayoutMode().h(this);
        }
        aw.c(this, com.baidu.tieba.u.nonetworkview_bg_selector, i);
    }

    public static void nx() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) TbadkApplication.m251getInst().getApp().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            setIsHasNetwork(true);
        } else {
            setIsHasNetwork(false);
        }
    }
}
