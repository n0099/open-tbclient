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
import com.baidu.tbadk.coreExtra.NoNetworkMoreActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NoNetworkView extends RelativeLayout implements View.OnClickListener {
    private static ArrayList<NoNetworkView> a = new ArrayList<>();
    private static boolean c;
    private TextView b;
    private Context d;
    private boolean e;
    private int f;
    private final ArrayList<r> g;

    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 0;
        this.g = new ArrayList<>();
        a(context, attributeSet);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 0;
        this.g = new ArrayList<>();
        a(context, attributeSet);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.f = 0;
        this.g = new ArrayList<>();
        a(context, null);
    }

    public void a(Context context, AttributeSet attributeSet) {
        this.d = context;
        com.baidu.adp.lib.e.b.a().a(context, com.baidu.tieba.v.no_network_view, this);
        this.b = (TextView) findViewById(com.baidu.tieba.u.no_network_guide);
        setOnClickListener(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.tieba.z.noNetworkView);
            this.e = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                a(false);
                setIsHasNetwork(true);
                return;
            }
            a(true);
            setIsHasNetwork(false);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void a(r rVar) {
        if (rVar != null && !this.g.contains(rVar)) {
            this.g.add(rVar);
        }
    }

    public void b(r rVar) {
        if (rVar != null && this.g.contains(rVar)) {
            this.g.remove(rVar);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        c = z;
        if (c) {
            Iterator<NoNetworkView> it = a.iterator();
            while (it.hasNext()) {
                it.next().a(false);
            }
            return;
        }
        Iterator<NoNetworkView> it2 = a.iterator();
        while (it2.hasNext()) {
            it2.next().a(true);
        }
    }

    public void a(boolean z) {
        if (z) {
            if (1 != this.f) {
                this.f = 1;
                this.b.setText(com.baidu.tieba.x.no_network_guide);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.g.size(); i++) {
                    this.g.get(i).a(false);
                }
            }
        } else if (this.e && !BdSocketLinkService.isAvailable()) {
            if (2 != this.f) {
                this.f = 2;
                this.b.setText(com.baidu.tieba.x.offline_guide);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.g.size(); i2++) {
                    this.g.get(i2).a(false);
                }
            }
        } else if (this.f != 0) {
            this.f = 0;
            if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation3.setFillAfter(true);
                alphaAnimation3.setDuration(500L);
                alphaAnimation3.setAnimationListener(new q(this));
                startAnimation(alphaAnimation3);
                for (int i3 = 0; i3 < this.g.size(); i3++) {
                    this.g.get(i3).a(true);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this && getVisibility() == 0) {
            Intent intent = new Intent(this.d, NoNetworkMoreActivity.class);
            intent.addFlags(268435456);
            this.d.startActivity(intent);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a.remove(this);
        this.g.clear();
    }

    public void a(int i) {
        if (this.d instanceof BaseActivity) {
            ((BaseActivity) this.d).getLayoutMode().a(i == 1);
            ((BaseActivity) this.d).getLayoutMode().a((View) this);
        } else if (this.d instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.d).c().a(i == 1);
            ((BaseFragmentActivity) this.d).c().a((View) this);
        }
        if (i == 1) {
            setBackgroundResource(com.baidu.tieba.t.nonetworkview_bg_selector_1);
        } else {
            setBackgroundResource(com.baidu.tieba.t.nonetworkview_bg_selector);
        }
    }

    public static void a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) TbadkApplication.m252getInst().getApp().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            setIsHasNetwork(true);
        } else {
            setIsHasNetwork(false);
        }
    }
}
