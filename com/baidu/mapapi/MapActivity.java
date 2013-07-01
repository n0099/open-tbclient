package com.baidu.mapapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import java.util.List;
/* loaded from: classes.dex */
public abstract class MapActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private MapView f522a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(MapView mapView) {
        if (this.f522a != null) {
            throw new RuntimeException("A mapview has been created!!");
        }
        this.f522a = mapView;
        Mj.d = mapView;
        return true;
    }

    public boolean initMapActivity(BMapManager bMapManager) {
        if (bMapManager == null) {
            return false;
        }
        if (this.f522a == null) {
            throw new RuntimeException("A mapview has not been created!!");
        }
        if (Mj.InitMapControlCC(20, 40) == 1) {
            this.f522a.a();
            return true;
        }
        return false;
    }

    protected boolean isLocationDisplayed() {
        if (this.f522a != null) {
            return this.f522a.b.d();
        }
        return false;
    }

    protected abstract boolean isRouteDisplayed();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Mj.g = defaultDisplay.getWidth();
        Mj.h = defaultDisplay.getHeight();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.f522a != null) {
            List overlays = this.f522a.getOverlays();
            if (overlays != null) {
                for (int size = overlays.size() - 1; size >= 0; size--) {
                    Overlay overlay = (Overlay) overlays.get(size);
                    if (overlay instanceof MyLocationOverlay) {
                        MyLocationOverlay myLocationOverlay = (MyLocationOverlay) overlay;
                        myLocationOverlay.disableMyLocation();
                        myLocationOverlay.disableCompass();
                    }
                }
                overlays.clear();
            }
            this.f522a.b();
        }
        this.f522a = null;
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        if (Mj.d != this.f522a) {
            Mj.d = this.f522a;
            if (this.f522a != null) {
                this.f522a.b.a(this.f522a.getLeft(), this.f522a.getTop(), this.f522a.getRight(), this.f522a.getBottom());
            }
        }
        super.onResume();
    }
}
