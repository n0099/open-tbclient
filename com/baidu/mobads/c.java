package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.view.KeyEvent;
import com.baidu.mobads.component.XAdView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class c implements XAdView.Listener {
    final /* synthetic */ AdView bkA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AdView adView) {
        this.bkA = adView;
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onWindowVisibilityChanged(int i) {
        com.baidu.mobads.production.a.a aVar;
        aVar = this.bkA.bkG;
        aVar.a(i);
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onWindowFocusChanged(boolean z) {
        com.baidu.mobads.production.a.a aVar;
        aVar = this.bkA.bkG;
        aVar.a(z);
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onLayoutComplete(int i, int i2) {
        this.bkA.a();
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    @SuppressLint({"MissingSuperCall"})
    public void onDetachedFromWindow() {
        com.baidu.mobads.production.a.a aVar;
        aVar = this.bkA.bkG;
        aVar.o();
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onAttachedToWindow() {
        com.baidu.mobads.production.a.a aVar;
        this.bkA.a();
        aVar = this.bkA.bkG;
        aVar.n();
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.baidu.mobads.production.a.a aVar;
        aVar = this.bkA.bkG;
        return aVar.a(i, keyEvent);
    }
}
