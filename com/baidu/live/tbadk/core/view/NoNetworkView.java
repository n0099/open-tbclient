package com.baidu.live.tbadk.core.view;

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
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.coreextra.NoNetworkMoreActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class NoNetworkView extends RelativeLayout implements View.OnClickListener {
    private static final int GONE = 0;
    private static final int SHOW_NO_NET = 1;
    private static final int SHOW_OFFLINE = 2;
    private static boolean mHasNetwork;
    private static ArrayList<NoNetworkView> mViews = new ArrayList<>();
    private int currentState;
    private boolean isSupportOffline;
    private Context mContext;
    private TextView mGuide;
    private final ArrayList<NetworkChangeListener> networkChangeListeners;

    /* loaded from: classes2.dex */
    public interface NetworkChangeListener {
        void onNetworkChange(boolean z);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentState = 0;
        this.networkChangeListeners = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentState = 0;
        this.networkChangeListeners = new ArrayList<>();
        init(context, attributeSet);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.currentState = 0;
        this.networkChangeListeners = new ArrayList<>();
        init(context, null);
    }

    public void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(getLayout(), this);
        this.mGuide = (TextView) findViewById(a.g.no_network_guide);
        setOnClickListener(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_noNetworkView);
            this.isSupportOffline = obtainStyledAttributes.getBoolean(a.k.sdk_noNetworkView_is_support_offline, false);
            obtainStyledAttributes.recycle();
        }
        try {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                update(false);
                setIsHasNetwork(true);
                return;
            }
            update(true);
            setIsHasNetwork(false);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    protected int getLayout() {
        return a.h.sdk_no_network_view;
    }

    public void addNetworkChangeListener(NetworkChangeListener networkChangeListener) {
        if (networkChangeListener != null && !this.networkChangeListeners.contains(networkChangeListener)) {
            this.networkChangeListeners.add(networkChangeListener);
        }
    }

    public void removeNetworkChangeListener(NetworkChangeListener networkChangeListener) {
        if (networkChangeListener != null && this.networkChangeListeners.contains(networkChangeListener)) {
            this.networkChangeListeners.remove(networkChangeListener);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        mHasNetwork = z;
        if (mHasNetwork) {
            Iterator<NoNetworkView> it = mViews.iterator();
            while (it.hasNext()) {
                it.next().update(false);
            }
            return;
        }
        Iterator<NoNetworkView> it2 = mViews.iterator();
        while (it2.hasNext()) {
            it2.next().update(true);
        }
    }

    public void update(boolean z) {
        if (z) {
            if (1 != this.currentState) {
                this.currentState = 1;
                this.mGuide.setText(a.i.sdk_no_network_guide);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.networkChangeListeners.size(); i++) {
                    this.networkChangeListeners.get(i).onNetworkChange(false);
                }
            }
        } else if (this.isSupportOffline && !BdSocketLinkService.isAvailable()) {
            if (2 != this.currentState) {
                this.currentState = 2;
                this.mGuide.setText(a.i.sdk_offline_guide);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.networkChangeListeners.size(); i2++) {
                    this.networkChangeListeners.get(i2).onNetworkChange(false);
                }
            }
        } else if (this.currentState != 0) {
            this.currentState = 0;
            if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.8f);
                alphaAnimation3.setFillAfter(true);
                alphaAnimation3.setDuration(500L);
                alphaAnimation3.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.tbadk.core.view.NoNetworkView.1
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
                for (int i3 = 0; i3 < this.networkChangeListeners.size(); i3++) {
                    this.networkChangeListeners.get(i3).onNetworkChange(true);
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
        this.networkChangeListeners.clear();
    }

    public void onChangeSkinType(BdPageContext<?> bdPageContext, int i) {
        if (bdPageContext instanceof TbPageContext) {
            ((TbPageContext) bdPageContext).getLayoutMode().setNightMode(i == 1);
            ((TbPageContext) bdPageContext).getLayoutMode().onModeChanged(this);
        }
        SkinManager.setBackgroundResource(this, a.f.sdk_nonetworkview_bg_selector, i);
    }

    public static void updateUI() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
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
