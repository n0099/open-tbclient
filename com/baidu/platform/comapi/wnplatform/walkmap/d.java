package com.baidu.platform.comapi.wnplatform.walkmap;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.inner.MapBound;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.kwad.sdk.core.config.item.TipsConfigItem;
import java.lang.ref.SoftReference;
/* loaded from: classes2.dex */
public class d extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: b  reason: collision with root package name */
    public e f10317b;

    /* renamed from: c  reason: collision with root package name */
    public a f10318c = null;

    /* renamed from: a  reason: collision with root package name */
    public SoftReference<View> f10316a = null;

    public d() {
        this.f10317b = null;
        this.f10317b = new e();
    }

    public MapView a() {
        SoftReference<View> softReference = this.f10316a;
        if (softReference == null) {
            return null;
        }
        return (MapView) softReference.get();
    }

    public void b() {
        a aVar = this.f10318c;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void b(boolean z) {
    }

    public boolean c() {
        e eVar = this.f10317b;
        if (eVar != null) {
            return eVar.b();
        }
        return false;
    }

    public boolean d() {
        e eVar = this.f10317b;
        if (eVar != null) {
            return eVar.c();
        }
        return false;
    }

    public boolean e() {
        e eVar = this.f10317b;
        if (eVar != null) {
            return eVar.d();
        }
        return false;
    }

    public boolean f() {
        e eVar = this.f10317b;
        if (eVar != null) {
            return eVar.e();
        }
        return false;
    }

    public boolean g() {
        e eVar = this.f10317b;
        if (eVar != null) {
            return eVar.f();
        }
        return false;
    }

    public float h() {
        e eVar = this.f10317b;
        if (eVar != null) {
            return eVar.g();
        }
        return -1.0f;
    }

    public MapStatus i() {
        a aVar = this.f10318c;
        if (aVar != null) {
            return aVar.c();
        }
        return null;
    }

    public MapStatus j() {
        MapStatus i2 = com.baidu.platform.comapi.walknavi.b.a().G().i();
        if (i2 != null) {
            WinRound winRound = i2.winRound;
            int i3 = (winRound.left + winRound.right) / 2;
            int abs = Math.abs(winRound.bottom + winRound.top) / 2;
            WinRound winRound2 = i2.winRound;
            WinRound winRound3 = i2.winRound;
            return new MapStatus.Builder(i2).targetScreen(new Point((winRound2.right + winRound2.left) / 2, ((winRound3.top + winRound3.bottom) / 2) - (0 - ((Math.abs(winRound2.bottom - winRound2.top) * 2) / 10)))).build();
        }
        return i2;
    }

    public float k() {
        a aVar = this.f10318c;
        if (aVar != null) {
            return aVar.d();
        }
        return 3.0f;
    }

    public void l() {
        a aVar = this.f10318c;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        a(0);
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        a(0);
        e eVar = this.f10317b;
        if (eVar != null) {
            eVar.a();
            this.f10317b = null;
        }
        a aVar = this.f10318c;
        if (aVar != null) {
            aVar.a();
            this.f10318c = null;
        }
    }

    public void a(Context context, MapView mapView) {
        this.f10316a = new SoftReference<>(mapView);
        a aVar = this.f10318c;
        if (aVar == null) {
            this.f10318c = new a(mapView);
        } else {
            aVar.a(mapView);
        }
        this.f10318c.a(false);
    }

    public boolean b(int[] iArr, int[] iArr2) {
        e eVar = this.f10317b;
        if (eVar != null) {
            return eVar.b(iArr, iArr2);
        }
        return false;
    }

    public boolean a(boolean z) {
        e eVar = this.f10317b;
        if (eVar != null) {
            return eVar.a(z);
        }
        return false;
    }

    public void a(int i2) {
        e eVar = this.f10317b;
        if (eVar == null) {
            return;
        }
        if (i2 == 0) {
            eVar.b(0);
            this.f10317b.b(1);
            this.f10317b.b(2);
            this.f10317b.b(3);
            this.f10317b.b(4);
        } else if (i2 != 1) {
        } else {
            eVar.a(0);
            this.f10317b.a(1);
            this.f10317b.a(2);
            if (com.baidu.platform.comapi.wnplatform.a.a().f()) {
                this.f10317b.b(3);
            } else if (com.baidu.platform.comapi.wnplatform.a.a().g()) {
                this.f10317b.a(3);
            }
            this.f10317b.a(4);
        }
    }

    public boolean a(int[] iArr, int[] iArr2) {
        e eVar = this.f10317b;
        if (eVar != null) {
            return eVar.a(iArr, iArr2);
        }
        return false;
    }

    public void a(MapStatus mapStatus) {
        a aVar = this.f10318c;
        if (aVar != null) {
            aVar.a(com.baidu.platform.comapi.wnplatform.o.e.a(mapStatus));
        }
    }

    public void a(MapStatus mapStatus, int i2) {
        a aVar = this.f10318c;
        if (aVar != null) {
            aVar.a(mapStatus, i2);
        }
    }

    public void a(int i2, int i3) {
        a aVar = this.f10318c;
        if (aVar != null) {
            aVar.a(i2, i3);
        }
    }

    public float a(MapBound mapBound, int i2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt(CustomDialogData.POS_LEFT, mapBound.ptLB.getmPtx());
        bundle.putInt(TipsConfigItem.TipConfigData.BOTTOM, mapBound.ptLB.getmPty());
        bundle.putInt("right", mapBound.ptRT.getmPtx());
        bundle.putInt("top", mapBound.ptRT.getmPty());
        a aVar = this.f10318c;
        if (aVar != null) {
            return aVar.a(bundle, i2, i3);
        }
        return 15.0f;
    }

    public void a(f fVar) {
        a aVar = this.f10318c;
        if (aVar != null) {
            aVar.a(fVar);
        }
    }
}
