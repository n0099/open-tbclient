package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.view.KeyEvent;
import com.baidu.mobads.component.XAdView;
/* loaded from: classes2.dex */
public class w implements XAdView.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SplashAd f8633a;

    public w(SplashAd splashAd) {
        this.f8633a = splashAd;
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onAttachedToWindow() {
        com.baidu.mobads.production.f.a aVar;
        com.baidu.mobads.production.f.a aVar2;
        aVar = this.f8633a.f8151a;
        if (aVar != null) {
            aVar2 = this.f8633a.f8151a;
            aVar2.n();
        }
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    @SuppressLint({"MissingSuperCall"})
    public void onDetachedFromWindow() {
        com.baidu.mobads.production.f.a aVar;
        com.baidu.mobads.production.f.a aVar2;
        aVar = this.f8633a.f8151a;
        if (aVar != null) {
            aVar2 = this.f8633a.f8151a;
            aVar2.o();
        }
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onLayoutComplete(int i, int i2) {
        boolean z;
        com.baidu.mobads.production.f.a aVar;
        com.baidu.mobads.production.f.a aVar2;
        com.baidu.mobads.production.f.a aVar3;
        z = this.f8633a.f8153c;
        if (z) {
            aVar = this.f8633a.f8151a;
            if (aVar != null) {
                aVar2 = this.f8633a.f8151a;
                aVar2.A = false;
                this.f8633a.f8153c = false;
                aVar3 = this.f8633a.f8151a;
                aVar3.c();
                return;
            }
            this.f8633a.a("展现失败，请检查splashAd参数是否正确");
        }
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onWindowFocusChanged(boolean z) {
        com.baidu.mobads.production.f.a aVar;
        com.baidu.mobads.production.f.a aVar2;
        aVar = this.f8633a.f8151a;
        if (aVar != null) {
            aVar2 = this.f8633a.f8151a;
            aVar2.a(z);
        }
    }

    @Override // com.baidu.mobads.component.XAdView.Listener
    public void onWindowVisibilityChanged(int i) {
        com.baidu.mobads.production.f.a aVar;
        com.baidu.mobads.production.f.a aVar2;
        aVar = this.f8633a.f8151a;
        if (aVar != null) {
            aVar2 = this.f8633a.f8151a;
            aVar2.b(i);
        }
    }
}
