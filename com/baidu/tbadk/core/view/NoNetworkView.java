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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.NoNetworkMoreActivity;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NoNetworkView extends RelativeLayout implements View.OnClickListener {
    private static ArrayList<NoNetworkView> aeK = new ArrayList<>();
    private static boolean aeM;
    private TextView aeL;
    private boolean aeN;
    private int aeO;
    private final ArrayList<a> aeP;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void ay(boolean z);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aeO = 0;
        this.aeP = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeO = 0;
        this.aeP = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.aeO = 0;
        this.aeP = new ArrayList<>();
        init(context, null);
    }

    public void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(i.g.no_network_view, this);
        this.aeL = (TextView) findViewById(i.f.no_network_guide);
        setOnClickListener(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.k.noNetworkView);
            this.aeN = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        try {
            if (com.baidu.adp.lib.util.i.iO()) {
                ax(false);
                setIsHasNetwork(true);
                return;
            }
            ax(true);
            setIsHasNetwork(false);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void a(a aVar) {
        if (aVar != null && !this.aeP.contains(aVar)) {
            this.aeP.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.aeP.contains(aVar)) {
            this.aeP.remove(aVar);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        aeM = z;
        if (aeM) {
            Iterator<NoNetworkView> it = aeK.iterator();
            while (it.hasNext()) {
                it.next().ax(false);
            }
            return;
        }
        Iterator<NoNetworkView> it2 = aeK.iterator();
        while (it2.hasNext()) {
            it2.next().ax(true);
        }
    }

    public void ax(boolean z) {
        if (z) {
            if (1 != this.aeO) {
                this.aeO = 1;
                this.aeL.setText(i.C0057i.no_network_guide);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.aeP.size(); i++) {
                    this.aeP.get(i).ay(false);
                }
            }
        } else if (this.aeN && !BdSocketLinkService.isAvailable()) {
            if (2 != this.aeO) {
                this.aeO = 2;
                this.aeL.setText(i.C0057i.offline_guide);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.aeP.size(); i2++) {
                    this.aeP.get(i2).ay(false);
                }
            }
        } else if (this.aeO != 0) {
            this.aeO = 0;
            if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.8f);
                alphaAnimation3.setFillAfter(true);
                alphaAnimation3.setDuration(500L);
                alphaAnimation3.setAnimationListener(new v(this));
                startAnimation(alphaAnimation3);
                for (int i3 = 0; i3 < this.aeP.size(); i3++) {
                    this.aeP.get(i3).ay(true);
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
        aeK.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aeK.remove(this);
        this.aeP.clear();
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ad(i == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this);
        }
        al.c(this, i.e.nonetworkview_bg_selector, i);
    }

    public static void vz() {
        if (com.baidu.adp.lib.util.i.iO()) {
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
