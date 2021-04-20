package com.baidu.mobads.container;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler;
import com.baidu.mobads.container.bridge.ExpandedLayout;
import com.baidu.mobads.container.util.AdResource;
/* loaded from: classes2.dex */
public abstract class XBaseHtmlAdContainer extends XBaseAdContainer {
    public static final String TAG = "XBaseHtmlAdContainer";
    public ExpandedLayout.OnCloseListener expandCloseListener;
    public ExpandedLayout expandedLayout;
    public BaseHtmlBridgeHandler mBridgeHandler;
    public ViewGroup mRootView;
    public XMyWebView mWebView;
    public boolean shouldUseCustomUse;

    public XBaseHtmlAdContainer(XAdContainerContext xAdContainerContext) {
        super(xAdContainerContext);
        this.expandCloseListener = new ExpandedLayout.OnCloseListener() { // from class: com.baidu.mobads.container.XBaseHtmlAdContainer.1
            @Override // com.baidu.mobads.container.bridge.ExpandedLayout.OnCloseListener
            public void onClose() {
                XBaseHtmlAdContainer.this.closeExpand();
            }
        };
    }

    @TargetApi(19)
    private ViewGroup getRootView() {
        if (this.mRootView == null) {
            if (Build.VERSION.SDK_INT >= 19 && !this.mAdContainerCxt.getAdProdBase().isAttachedToWindow()) {
                return null;
            }
            this.mRootView = (ViewGroup) this.mAdContainerCxt.getAdProdBase().getRootView().findViewById(16908290);
        }
        return this.mRootView;
    }

    public void closeExpand() {
        try {
            getRootView().removeView(this.expandedLayout);
            this.expandedLayout.removeAllViews();
            this.expandedLayout = null;
            this.mAdContainerCxt.getAdProdBase().addView(this.mWebView, new RelativeLayout.LayoutParams(-1, -1));
            this.mBridgeHandler.expandCloseSuccess();
        } catch (Exception e2) {
            this.mAdLogger.d(e2);
        }
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void destroy() {
        XMyWebView xMyWebView = this.mWebView;
        if (xMyWebView != null) {
            xMyWebView.destroy();
        }
    }

    public BaseHtmlBridgeHandler getBridge() {
        return this.mBridgeHandler;
    }

    public XMyWebView getWebView() {
        return this.mWebView;
    }

    public void handleExpand(boolean z) {
        try {
            if (getRootView() == null) {
                return;
            }
            ExpandedLayout expandedLayout = new ExpandedLayout(this.mAppContext, AdResource.getInterstitialVideoClose());
            this.expandedLayout = expandedLayout;
            expandedLayout.setOnCloseListener(this.expandCloseListener);
            this.mAdContainerCxt.getAdProdBase().removeView(this.mWebView);
            this.expandedLayout.addView(this.mWebView, new FrameLayout.LayoutParams(-1, -1));
            getRootView().addView(this.expandedLayout, new ViewGroup.LayoutParams(-1, -1));
            this.expandedLayout.setKeyDownListener(new ExpandedLayout.KeyDownListener() { // from class: com.baidu.mobads.container.XBaseHtmlAdContainer.2
                @Override // com.baidu.mobads.container.bridge.ExpandedLayout.KeyDownListener
                public boolean handleKeyDown(int i, KeyEvent keyEvent) {
                    Boolean valueOf = Boolean.valueOf(i == 4);
                    if (valueOf.booleanValue()) {
                        XBaseHtmlAdContainer.this.closeExpand();
                    }
                    return valueOf.booleanValue();
                }
            });
            this.expandedLayout.setFocusableInTouchMode(true);
            this.expandedLayout.setFocusable(true);
            this.expandedLayout.requestFocus();
            this.mBridgeHandler.expandSuccess();
        } catch (Exception e2) {
            this.mAdLogger.d(e2);
        }
    }

    public void handleUseCustomClose(boolean z) {
        try {
            this.shouldUseCustomUse = z;
            if (this.expandedLayout != null) {
                this.expandedLayout.setCloseVisible(!z);
            }
        } catch (Exception e2) {
            this.mAdLogger.d(e2);
        }
    }

    public abstract void initBridgeHandler();
}
