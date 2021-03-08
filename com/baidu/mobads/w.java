package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.view.KeyEvent;
import com.baidu.mobads.component.XAdView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class w implements XAdView.Listener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SplashAd f2508a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(SplashAd splashAd) {
        this.f2508a = splashAd;
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onWindowVisibilityChanged(int i) {
        com.baidu.mobads.production.f.a aVar;
        com.baidu.mobads.production.f.a aVar2;
        aVar = this.f2508a.f2354a;
        if (aVar != null) {
            aVar2 = this.f2508a.f2354a;
            aVar2.b(i);
        }
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onWindowFocusChanged(boolean z) {
        com.baidu.mobads.production.f.a aVar;
        com.baidu.mobads.production.f.a aVar2;
        aVar = this.f2508a.f2354a;
        if (aVar != null) {
            aVar2 = this.f2508a.f2354a;
            aVar2.a(z);
        }
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onLayoutComplete(int i, int i2) {
        com.baidu.mobads.production.f.a aVar;
        com.baidu.mobads.production.f.a aVar2;
        com.baidu.mobads.production.f.a aVar3;
        aVar = this.f2508a.f2354a;
        if (aVar != null) {
            aVar2 = this.f2508a.f2354a;
            aVar2.A = false;
            aVar3 = this.f2508a.f2354a;
            aVar3.c();
            return;
        }
        this.f2508a.a("展现失败，请检查splashAd参数是否正确");
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    @SuppressLint({"MissingSuperCall"})
    public void onDetachedFromWindow() {
        com.baidu.mobads.production.f.a aVar;
        com.baidu.mobads.production.f.a aVar2;
        aVar = this.f2508a.f2354a;
        if (aVar != null) {
            aVar2 = this.f2508a.f2354a;
            aVar2.o();
        }
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onAttachedToWindow() {
        com.baidu.mobads.production.f.a aVar;
        com.baidu.mobads.production.f.a aVar2;
        aVar = this.f2508a.f2354a;
        if (aVar != null) {
            aVar2 = this.f2508a.f2354a;
            aVar2.n();
        }
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }
}
