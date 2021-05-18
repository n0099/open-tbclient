package com.baidu.sdk.container.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
/* loaded from: classes2.dex */
public class AdView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public a f10081e;

    /* loaded from: classes2.dex */
    public interface a {
        void c(int i2, int i3);

        void onAttachedToWindow();

        @SuppressLint({"MissingSuperCall"})
        void onDetachedFromWindow();

        boolean onKeyDown(int i2, KeyEvent keyEvent);

        void onWindowFocusChanged(boolean z);

        void onWindowVisibilityChanged(int i2);
    }

    public AdView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f10081e;
        if (aVar != null) {
            aVar.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f10081e;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        a aVar = this.f10081e;
        if (aVar != null) {
            return aVar.onKeyDown(i2, keyEvent);
        }
        super.onKeyDown(i2, keyEvent);
        return false;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        a aVar;
        super.onLayout(z, i2, i3, i4, i5);
        if (!z || (aVar = this.f10081e) == null) {
            return;
        }
        aVar.c(getWidth(), getHeight());
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        a aVar = this.f10081e;
        if (aVar != null) {
            aVar.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        a aVar = this.f10081e;
        if (aVar != null) {
            aVar.onWindowVisibilityChanged(i2);
        }
    }

    public void setListener(a aVar) {
        this.f10081e = aVar;
    }
}
