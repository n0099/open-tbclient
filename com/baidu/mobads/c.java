package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.view.KeyEvent;
import com.baidu.mobads.component.XAdView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c implements XAdView.Listener {
    final /* synthetic */ AdView aKp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AdView adView) {
        this.aKp = adView;
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onWindowVisibilityChanged(int i) {
        com.baidu.mobads.production.a.a aVar;
        aVar = this.aKp.aKv;
        aVar.a(i);
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onWindowFocusChanged(boolean z) {
        com.baidu.mobads.production.a.a aVar;
        aVar = this.aKp.aKv;
        aVar.a(z);
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onLayoutComplete(int i, int i2) {
        this.aKp.a();
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    @SuppressLint({"MissingSuperCall"})
    public void onDetachedFromWindow() {
        com.baidu.mobads.production.a.a aVar;
        aVar = this.aKp.aKv;
        aVar.o();
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onAttachedToWindow() {
        com.baidu.mobads.production.a.a aVar;
        this.aKp.a();
        aVar = this.aKp.aKv;
        aVar.n();
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.baidu.mobads.production.a.a aVar;
        aVar = this.aKp.aKv;
        return aVar.a(i, keyEvent);
    }
}
