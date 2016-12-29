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
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NoNetworkView extends RelativeLayout implements View.OnClickListener {
    private static ArrayList<NoNetworkView> afU = new ArrayList<>();
    private static boolean afW;
    private TextView afV;
    private boolean afX;
    private int afY;
    private final ArrayList<a> afZ;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void aL(boolean z);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.afY = 0;
        this.afZ = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afY = 0;
        this.afZ = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.afY = 0;
        this.afZ = new ArrayList<>();
        init(context, null);
    }

    public void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(getLayout(), this);
        this.afV = (TextView) findViewById(r.g.no_network_guide);
        setOnClickListener(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.l.noNetworkView);
            this.afX = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        try {
            if (com.baidu.adp.lib.util.i.gm()) {
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
        return r.h.no_network_view;
    }

    public void a(a aVar) {
        if (aVar != null && !this.afZ.contains(aVar)) {
            this.afZ.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.afZ.contains(aVar)) {
            this.afZ.remove(aVar);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        afW = z;
        if (afW) {
            Iterator<NoNetworkView> it = afU.iterator();
            while (it.hasNext()) {
                it.next().aK(false);
            }
            return;
        }
        Iterator<NoNetworkView> it2 = afU.iterator();
        while (it2.hasNext()) {
            it2.next().aK(true);
        }
    }

    public void aK(boolean z) {
        if (z) {
            if (1 != this.afY) {
                this.afY = 1;
                this.afV.setText(r.j.no_network_guide);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.afZ.size(); i++) {
                    this.afZ.get(i).aL(false);
                }
            }
        } else if (this.afX && !BdSocketLinkService.isAvailable()) {
            if (2 != this.afY) {
                this.afY = 2;
                this.afV.setText(r.j.offline_guide);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.afZ.size(); i2++) {
                    this.afZ.get(i2).aL(false);
                }
            }
        } else if (this.afY != 0) {
            this.afY = 0;
            if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.8f);
                alphaAnimation3.setFillAfter(true);
                alphaAnimation3.setDuration(500L);
                alphaAnimation3.setAnimationListener(new x(this));
                startAnimation(alphaAnimation3);
                for (int i3 = 0; i3 < this.afZ.size(); i3++) {
                    this.afZ.get(i3).aL(true);
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
        afU.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        afU.remove(this);
        this.afZ.clear();
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ai(i == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this);
        }
        com.baidu.tbadk.core.util.ar.d(this, r.f.nonetworkview_bg_selector, i);
    }

    public static void wg() {
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
