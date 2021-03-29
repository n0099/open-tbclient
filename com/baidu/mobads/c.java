package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.view.KeyEvent;
import com.baidu.mobads.component.XAdView;
/* loaded from: classes2.dex */
public class c implements XAdView.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdView f8169a;

    public c(AdView adView) {
        this.f8169a = adView;
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onAttachedToWindow() {
        com.baidu.mobads.production.a.a aVar;
        this.f8169a.a();
        aVar = this.f8169a.f8104c;
        aVar.n();
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    @SuppressLint({"MissingSuperCall"})
    public void onDetachedFromWindow() {
        com.baidu.mobads.production.a.a aVar;
        aVar = this.f8169a.f8104c;
        aVar.o();
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.baidu.mobads.production.a.a aVar;
        aVar = this.f8169a.f8104c;
        return aVar.a(i, keyEvent);
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onLayoutComplete(int i, int i2) {
        this.f8169a.a();
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onWindowFocusChanged(boolean z) {
        com.baidu.mobads.production.a.a aVar;
        aVar = this.f8169a.f8104c;
        aVar.a(z);
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onWindowVisibilityChanged(int i) {
        com.baidu.mobads.production.a.a aVar;
        aVar = this.f8169a.f8104c;
        aVar.b(i);
    }
}
