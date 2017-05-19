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
    private static ArrayList<NoNetworkView> akl = new ArrayList<>();
    private static boolean akn;
    private TextView akm;
    private boolean ako;
    private int akp;
    private final ArrayList<a> akq;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void aL(boolean z);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akp = 0;
        this.akq = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akp = 0;
        this.akq = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.akp = 0;
        this.akq = new ArrayList<>();
        init(context, null);
    }

    public void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(getLayout(), this);
        this.akm = (TextView) findViewById(w.h.no_network_guide);
        setOnClickListener(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.noNetworkView);
            this.ako = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        try {
            if (com.baidu.adp.lib.util.i.hk()) {
                aK(false);
                setIsHasNetwork(true);
                return;
            }
            aK(true);
            setIsHasNetwork(false);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    protected int getLayout() {
        return w.j.no_network_view;
    }

    public void a(a aVar) {
        if (aVar != null && !this.akq.contains(aVar)) {
            this.akq.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.akq.contains(aVar)) {
            this.akq.remove(aVar);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        akn = z;
        if (akn) {
            Iterator<NoNetworkView> it = akl.iterator();
            while (it.hasNext()) {
                it.next().aK(false);
            }
            return;
        }
        Iterator<NoNetworkView> it2 = akl.iterator();
        while (it2.hasNext()) {
            it2.next().aK(true);
        }
    }

    public void aK(boolean z) {
        if (z) {
            if (1 != this.akp) {
                this.akp = 1;
                this.akm.setText(w.l.no_network_guide);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.akq.size(); i++) {
                    this.akq.get(i).aL(false);
                }
            }
        } else if (this.ako && !BdSocketLinkService.isAvailable()) {
            if (2 != this.akp) {
                this.akp = 2;
                this.akm.setText(w.l.offline_guide);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.akq.size(); i2++) {
                    this.akq.get(i2).aL(false);
                }
            }
        } else if (this.akp != 0) {
            this.akp = 0;
            if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.8f);
                alphaAnimation3.setFillAfter(true);
                alphaAnimation3.setDuration(500L);
                alphaAnimation3.setAnimationListener(new z(this));
                startAnimation(alphaAnimation3);
                for (int i3 = 0; i3 < this.akq.size(); i3++) {
                    this.akq.get(i3).aL(true);
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
        akl.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        akl.remove(this);
        this.akq.clear();
    }

    public void onChangeSkinType(com.baidu.adp.base.g<?> gVar, int i) {
        if (gVar instanceof TbPageContext) {
            ((TbPageContext) gVar).getLayoutMode().ai(i == 1);
            ((TbPageContext) gVar).getLayoutMode().t(this);
        }
        com.baidu.tbadk.core.util.aq.d(this, w.g.nonetworkview_bg_selector, i);
    }

    public static void wh() {
        if (com.baidu.adp.lib.util.i.hk()) {
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
