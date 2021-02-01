package com.baidu.mobads.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.XAdNativeResponse;
import com.baidu.mobads.g.b;
import com.baidu.mobads.r;
import dalvik.system.DexClassLoader;
/* loaded from: classes5.dex */
public class FeedNativeView extends RelativeLayout {
    private View mAdView;
    private Context mContext;
    private DexClassLoader mLoader;
    private String mRemoteClassName;

    public FeedNativeView(Context context) {
        super(context);
        this.mRemoteClassName = "com.style.widget.RemoteNativeView";
        init(context);
    }

    public FeedNativeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRemoteClassName = "com.style.widget.RemoteNativeView";
        init(context);
    }

    public FeedNativeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRemoteClassName = "com.style.widget.RemoteNativeView";
        init(context);
    }

    public void setAdData(XAdNativeResponse xAdNativeResponse) {
        if (this.mAdView != null) {
            r.a(this.mRemoteClassName, this.mAdView, this.mLoader, "setAdResponse", new Class[]{Object.class}, xAdNativeResponse);
        }
    }

    public void changeViewLayoutParams(Object obj) {
        if (this.mAdView != null) {
            r.a(this.mRemoteClassName, this.mAdView, this.mLoader, "changeLayoutParams", new Class[]{Object.class}, obj);
        }
    }

    private void init(Context context) {
        this.mContext = context;
        Class[] clsArr = {Context.class};
        Object[] objArr = {this.mContext};
        this.mLoader = b.d();
        if (this.mLoader == null) {
            this.mLoader = r.a(this.mContext);
        }
        this.mAdView = (View) r.a(this.mRemoteClassName, this.mLoader, clsArr, objArr);
        if (this.mAdView != null) {
            addView(this.mAdView, new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public int getAdContainerWidth() {
        if (this.mAdView != null) {
            return ((Integer) r.a(this.mRemoteClassName, this.mAdView, this.mLoader, "getAdContainerWidth", new Class[0], new Object[0])).intValue();
        }
        return 0;
    }

    public int getAdContainerHeight() {
        if (this.mAdView != null) {
            return ((Integer) r.a(this.mRemoteClassName, this.mAdView, this.mLoader, "getAdContainerHeight", new Class[0], new Object[0])).intValue();
        }
        return 0;
    }

    public RelativeLayout getContainerView() {
        if (this.mAdView != null) {
            return (RelativeLayout) r.a(this.mRemoteClassName, this.mAdView, this.mLoader, "getAdView", new Class[0], new Object[0]);
        }
        return null;
    }
}
