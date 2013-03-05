package com.baidu.mapapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import java.util.List;
/* loaded from: classes.dex */
public abstract class MapActivity extends Activity {
    private MapView a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(MapView mapView) {
        if (this.a != null) {
            throw new RuntimeException("A mapview has been created!!");
        }
        this.a = mapView;
        Mj.d = mapView;
        return true;
    }

    public boolean initMapActivity(BMapManager bMapManager) {
        if (bMapManager == null) {
            return false;
        }
        if (this.a == null) {
            throw new RuntimeException("A mapview has not been created!!");
        }
        if (Mj.InitMapControlCC(20, 40) == 1) {
            this.a.a();
            return true;
        }
        return false;
    }

    protected boolean isLocationDisplayed() {
        if (this.a != null) {
            return this.a.b.d();
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
        if (this.a != null) {
            List overlays = this.a.getOverlays();
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
            this.a.b();
        }
        this.a = null;
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
        if (Mj.d != this.a) {
            Mj.d = this.a;
            if (this.a != null) {
                this.a.b.a(this.a.getLeft(), this.a.getTop(), this.a.getRight(), this.a.getBottom());
            }
        }
        super.onResume();
    }
}
