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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.NoNetworkMoreActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NoNetworkView extends RelativeLayout implements View.OnClickListener {
    private static ArrayList<NoNetworkView> YJ = new ArrayList<>();
    private static boolean YL;
    private TextView YK;
    private boolean YM;
    private int YN;
    private final ArrayList<y> YO;
    private Context mContext;

    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.YN = 0;
        this.YO = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YN = 0;
        this.YO = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.YN = 0;
        this.YO = new ArrayList<>();
        init(context, null);
    }

    public void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.hH().inflate(context, com.baidu.tieba.w.no_network_view, this);
        this.YK = (TextView) findViewById(com.baidu.tieba.v.no_network_guide);
        setOnClickListener(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.tieba.aa.noNetworkView);
            this.YM = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                am(false);
                setIsHasNetwork(true);
                return;
            }
            am(true);
            setIsHasNetwork(false);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void a(y yVar) {
        if (yVar != null && !this.YO.contains(yVar)) {
            this.YO.add(yVar);
        }
    }

    public void b(y yVar) {
        if (yVar != null && this.YO.contains(yVar)) {
            this.YO.remove(yVar);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        YL = z;
        if (YL) {
            Iterator<NoNetworkView> it = YJ.iterator();
            while (it.hasNext()) {
                it.next().am(false);
            }
            return;
        }
        Iterator<NoNetworkView> it2 = YJ.iterator();
        while (it2.hasNext()) {
            it2.next().am(true);
        }
    }

    public void am(boolean z) {
        if (z) {
            if (1 != this.YN) {
                this.YN = 1;
                this.YK.setText(com.baidu.tieba.y.no_network_guide);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.YO.size(); i++) {
                    this.YO.get(i).an(false);
                }
            }
        } else if (this.YM && !BdSocketLinkService.isAvailable()) {
            if (2 != this.YN) {
                this.YN = 2;
                this.YK.setText(com.baidu.tieba.y.offline_guide);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.YO.size(); i2++) {
                    this.YO.get(i2).an(false);
                }
            }
        } else if (this.YN != 0) {
            this.YN = 0;
            if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation3.setFillAfter(true);
                alphaAnimation3.setDuration(500L);
                alphaAnimation3.setAnimationListener(new x(this));
                startAnimation(alphaAnimation3);
                for (int i3 = 0; i3 < this.YO.size(); i3++) {
                    this.YO.get(i3).an(true);
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
        YJ.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        YJ.remove(this);
        this.YO.clear();
    }

    public void onChangeSkinType(com.baidu.adp.base.j<?> jVar, int i) {
        if (jVar instanceof TbPageContext) {
            ((TbPageContext) jVar).getLayoutMode().X(i == 1);
            ((TbPageContext) jVar).getLayoutMode().h(this);
        }
        ba.c(this, com.baidu.tieba.u.nonetworkview_bg_selector, i);
    }

    public static void tM() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) TbadkCoreApplication.m411getInst().getApp().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            setIsHasNetwork(true);
        } else {
            setIsHasNetwork(false);
        }
    }
}
