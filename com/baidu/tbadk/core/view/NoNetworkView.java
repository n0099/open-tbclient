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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.NoNetworkMoreActivity;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NoNetworkView extends RelativeLayout implements View.OnClickListener {
    private static ArrayList<NoNetworkView> agC = new ArrayList<>();
    private static boolean agE;
    private TextView agD;
    private boolean agF;
    private int agG;
    private final ArrayList<a> agH;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void aK(boolean z);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.agG = 0;
        this.agH = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agG = 0;
        this.agH = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.agG = 0;
        this.agH = new ArrayList<>();
        init(context, null);
    }

    public void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(getLayout(), this);
        this.agD = (TextView) findViewById(r.g.no_network_guide);
        setOnClickListener(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.l.noNetworkView);
            this.agF = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        try {
            if (com.baidu.adp.lib.util.i.gm()) {
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
        return r.h.no_network_view;
    }

    public void a(a aVar) {
        if (aVar != null && !this.agH.contains(aVar)) {
            this.agH.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.agH.contains(aVar)) {
            this.agH.remove(aVar);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        agE = z;
        if (agE) {
            Iterator<NoNetworkView> it = agC.iterator();
            while (it.hasNext()) {
                it.next().aJ(false);
            }
            return;
        }
        Iterator<NoNetworkView> it2 = agC.iterator();
        while (it2.hasNext()) {
            it2.next().aJ(true);
        }
    }

    public void aJ(boolean z) {
        if (z) {
            if (1 != this.agG) {
                this.agG = 1;
                this.agD.setText(r.j.no_network_guide);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.agH.size(); i++) {
                    this.agH.get(i).aK(false);
                }
            }
        } else if (this.agF && !BdSocketLinkService.isAvailable()) {
            if (2 != this.agG) {
                this.agG = 2;
                this.agD.setText(r.j.offline_guide);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.agH.size(); i2++) {
                    this.agH.get(i2).aK(false);
                }
            }
        } else if (this.agG != 0) {
            this.agG = 0;
            if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.8f);
                alphaAnimation3.setFillAfter(true);
                alphaAnimation3.setDuration(500L);
                alphaAnimation3.setAnimationListener(new x(this));
                startAnimation(alphaAnimation3);
                for (int i3 = 0; i3 < this.agH.size(); i3++) {
                    this.agH.get(i3).aK(true);
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
        agC.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        agC.remove(this);
        this.agH.clear();
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ai(i == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this);
        }
        at.d(this, r.f.nonetworkview_bg_selector, i);
    }

    public static void ww() {
        if (com.baidu.adp.lib.util.i.gm()) {
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
