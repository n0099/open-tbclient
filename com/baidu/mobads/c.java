package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.view.KeyEvent;
import com.baidu.mobads.component.XAdView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class c implements XAdView.Listener {
    final /* synthetic */ AdView aOv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AdView adView) {
        this.aOv = adView;
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onWindowVisibilityChanged(int i) {
        com.baidu.mobads.production.a.a aVar;
        aVar = this.aOv.aOB;
        aVar.a(i);
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onWindowFocusChanged(boolean z) {
        com.baidu.mobads.production.a.a aVar;
        aVar = this.aOv.aOB;
        aVar.a(z);
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onLayoutComplete(int i, int i2) {
        this.aOv.a();
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    @SuppressLint({"MissingSuperCall"})
    public void onDetachedFromWindow() {
        com.baidu.mobads.production.a.a aVar;
        aVar = this.aOv.aOB;
        aVar.o();
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onAttachedToWindow() {
        com.baidu.mobads.production.a.a aVar;
        this.aOv.a();
        aVar = this.aOv.aOB;
        aVar.n();
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.baidu.mobads.production.a.a aVar;
        aVar = this.aOv.aOB;
        return aVar.a(i, keyEvent);
    }
}
