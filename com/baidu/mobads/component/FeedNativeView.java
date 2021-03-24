package com.baidu.mobads.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.XAdNativeResponse;
import com.baidu.mobads.g.b;
import com.baidu.mobads.r;
import dalvik.system.DexClassLoader;
/* loaded from: classes2.dex */
public class FeedNativeView extends RelativeLayout {
    public View mAdView;
    public Context mContext;
    public DexClassLoader mLoader;
    public String mRemoteClassName;

    public FeedNativeView(Context context) {
        super(context);
        this.mRemoteClassName = "com.style.widget.RemoteNativeView";
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        Class[] clsArr = {Context.class};
        Object[] objArr = {context};
        DexClassLoader d2 = b.d();
        this.mLoader = d2;
        if (d2 == null) {
            this.mLoader = r.a(this.mContext);
        }
        View view = (View) r.a(this.mRemoteClassName, this.mLoader, clsArr, objArr);
        this.mAdView = view;
        if (view != null) {
            addView(view, new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void changeViewLayoutParams(Object obj) {
        View view = this.mAdView;
        if (view != null) {
            r.a(this.mRemoteClassName, view, this.mLoader, "changeLayoutParams", new Class[]{Object.class}, obj);
        }
    }

    public int getAdContainerHeight() {
        View view = this.mAdView;
        if (view != null) {
            return ((Integer) r.a(this.mRemoteClassName, view, this.mLoader, "getAdContainerHeight", new Class[0], new Object[0])).intValue();
        }
        return 0;
    }

    public int getAdContainerWidth() {
        View view = this.mAdView;
        if (view != null) {
            return ((Integer) r.a(this.mRemoteClassName, view, this.mLoader, "getAdContainerWidth", new Class[0], new Object[0])).intValue();
        }
        return 0;
    }

    public RelativeLayout getContainerView() {
        View view = this.mAdView;
        if (view != null) {
            return (RelativeLayout) r.a(this.mRemoteClassName, view, this.mLoader, "getAdView", new Class[0], new Object[0]);
        }
        return null;
    }

    public void setAdData(XAdNativeResponse xAdNativeResponse) {
        View view = this.mAdView;
        if (view != null) {
            r.a(this.mRemoteClassName, view, this.mLoader, "setAdResponse", new Class[]{Object.class}, xAdNativeResponse);
        }
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
}
