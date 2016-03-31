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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NoNetworkView extends RelativeLayout implements View.OnClickListener {
    private static ArrayList<NoNetworkView> agj = new ArrayList<>();
    private static boolean agl;
    private TextView agk;
    private boolean agm;
    private int agn;
    private final ArrayList<a> ago;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void aA(boolean z);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.agn = 0;
        this.ago = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agn = 0;
        this.ago = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.agn = 0;
        this.ago = new ArrayList<>();
        init(context, null);
    }

    public void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(t.h.no_network_view, this);
        this.agk = (TextView) findViewById(t.g.no_network_guide);
        setOnClickListener(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.l.noNetworkView);
            this.agm = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        try {
            if (com.baidu.adp.lib.util.i.jf()) {
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
        if (aVar != null && !this.ago.contains(aVar)) {
            this.ago.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.ago.contains(aVar)) {
            this.ago.remove(aVar);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        agl = z;
        if (agl) {
            Iterator<NoNetworkView> it = agj.iterator();
            while (it.hasNext()) {
                it.next().az(false);
            }
            return;
        }
        Iterator<NoNetworkView> it2 = agj.iterator();
        while (it2.hasNext()) {
            it2.next().az(true);
        }
    }

    public void az(boolean z) {
        if (z) {
            if (1 != this.agn) {
                this.agn = 1;
                this.agk.setText(t.j.no_network_guide);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.ago.size(); i++) {
                    this.ago.get(i).aA(false);
                }
            }
        } else if (this.agm && !BdSocketLinkService.isAvailable()) {
            if (2 != this.agn) {
                this.agn = 2;
                this.agk.setText(t.j.offline_guide);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.ago.size(); i2++) {
                    this.ago.get(i2).aA(false);
                }
            }
        } else if (this.agn != 0) {
            this.agn = 0;
            if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.8f);
                alphaAnimation3.setFillAfter(true);
                alphaAnimation3.setDuration(500L);
                alphaAnimation3.setAnimationListener(new q(this));
                startAnimation(alphaAnimation3);
                for (int i3 = 0; i3 < this.ago.size(); i3++) {
                    this.ago.get(i3).aA(true);
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
        agj.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        agj.remove(this);
        this.ago.clear();
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ab(i == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this);
        }
        at.c(this, t.f.nonetworkview_bg_selector, i);
    }

    public static void xo() {
        if (com.baidu.adp.lib.util.i.jf()) {
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
