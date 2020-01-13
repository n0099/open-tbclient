package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.view.KeyEvent;
import com.baidu.mobads.component.XAdView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class p implements XAdView.Listener {
    final /* synthetic */ InterstitialAd aLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(InterstitialAd interstitialAd) {
        this.aLc = interstitialAd;
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
        aVar = this.aLc.aKL;
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
