package com.baidu.tbadk.core.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.NoNetworkMoreActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NoNetworkView extends RelativeLayout implements View.OnClickListener {
    private static boolean mHasNetwork;
    private static ArrayList<NoNetworkView> mViews = new ArrayList<>();
    private TextView caP;
    private boolean caQ;
    private final ArrayList<a> caR;
    private int currentState;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void es(boolean z);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentState = 0;
        this.caR = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentState = 0;
        this.caR = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.currentState = 0;
        this.caR = new ArrayList<>();
        init(context, null);
    }

    public void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(getLayout(), this);
        this.caP = (TextView) findViewById(R.id.no_network_guide);
        setOnClickListener(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.noNetworkView);
            this.caQ = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        try {
            if (com.baidu.adp.lib.util.j.kc()) {
                er(false);
                setIsHasNetwork(true);
                return;
            }
            er(true);
            setIsHasNetwork(false);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    protected int getLayout() {
        return R.layout.no_network_view;
    }

    public void a(a aVar) {
        if (aVar != null && !this.caR.contains(aVar)) {
            this.caR.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.caR.contains(aVar)) {
            this.caR.remove(aVar);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        mHasNetwork = z;
        if (mHasNetwork) {
            Iterator<NoNetworkView> it = mViews.iterator();
            while (it.hasNext()) {
                it.next().er(false);
            }
            return;
        }
        Iterator<NoNetworkView> it2 = mViews.iterator();
        while (it2.hasNext()) {
            it2.next().er(true);
        }
    }

    public void er(boolean z) {
        if (z) {
            if (1 != this.currentState) {
                this.currentState = 1;
                this.caP.setText(R.string.no_network_guide);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.caR.size(); i++) {
                    this.caR.get(i).es(false);
                }
            }
        } else if (this.caQ && !BdSocketLinkService.isAvailable()) {
            if (2 != this.currentState) {
                this.currentState = 2;
                this.caP.setText(R.string.offline_guide);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.caR.size(); i2++) {
                    this.caR.get(i2).es(false);
                }
            }
        } else if (this.currentState != 0) {
            this.currentState = 0;
            if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.8f);
                alphaAnimation3.setFillAfter(true);
                alphaAnimation3.setDuration(500L);
                alphaAnimation3.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.core.view.NoNetworkView.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        NoNetworkView.this.setVisibility(8);
                    }
                });
                startAnimation(alphaAnimation3);
                for (int i3 = 0; i3 < this.caR.size(); i3++) {
                    this.caR.get(i3).es(true);
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
        mViews.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mViews.remove(this);
        this.caR.clear();
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().setNightMode(i == 1);
            ((TbPageContext) eVar).getLayoutMode().onModeChanged(this);
        }
        am.g(this, R.drawable.nonetworkview_bg_selector, i);
    }

    public static void JW() {
        if (com.baidu.adp.lib.util.j.kc()) {
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
