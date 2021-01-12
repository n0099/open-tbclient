package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.view.KeyEvent;
import com.baidu.mobads.component.XAdView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class p implements XAdView.Listener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ InterstitialAd f3426a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(InterstitialAd interstitialAd) {
        this.f3426a = interstitialAd;
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onWindowVisibilityChanged(int i) {
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onWindowFocusChanged(boolean z) {
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onLayoutComplete(int i, int i2) {
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.baidu.mobads.production.f.a aVar;
        aVar = this.f3426a.c;
        return aVar.a(i, keyEvent);
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    @SuppressLint({"MissingSuperCall"})
    public void onDetachedFromWindow() {
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onAttachedToWindow() {
    }
}
