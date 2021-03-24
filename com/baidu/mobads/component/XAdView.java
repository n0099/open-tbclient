package com.baidu.mobads.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
/* loaded from: classes2.dex */
public class XAdView extends RelativeLayout {
    public static final String TAG = "BDAdView";
    public Listener mListener;

    /* loaded from: classes2.dex */
    public interface Listener {
        void onAttachedToWindow();

        @SuppressLint({"MissingSuperCall"})
        void onDetachedFromWindow();

        boolean onKeyDown(int i, KeyEvent keyEvent);

        void onLayoutComplete(int i, int i2);

        void onWindowFocusChanged(boolean z);

        void onWindowVisibilityChanged(int i);
    }

    public XAdView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onDetachedFromWindow();
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Listener listener = this.mListener;
        if (listener != null) {
            return listener.onKeyDown(i, keyEvent);
        }
        super.onKeyDown(i, keyEvent);
        return false;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Listener listener;
        super.onLayout(z, i, i2, i3, i4);
        if (!z || (listener = this.mListener) == null) {
            return;
        }
        listener.onLayoutComplete(getWidth(), getHeight());
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onWindowVisibilityChanged(i);
        }
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }
}
