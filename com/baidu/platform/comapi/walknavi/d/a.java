package com.baidu.platform.comapi.walknavi.d;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.wnplatform.walkmap.WNaviBaiduMap;
/* loaded from: classes4.dex */
public class a extends FrameLayout {
    private static final String a = a.class.getName();
    private TextureMapView b;

    public a(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.b = new TextureMapView(context);
        this.b.showZoomControls(false);
        this.b.showScaleControl(false);
        this.b.getMap().setCompassEnable(false);
    }

    public void a() {
        Log.d(a, "showMapView");
        addView(this.b, new FrameLayout.LayoutParams(-1, -1));
    }

    public TextureMapView b() {
        return this.b;
    }

    public void c() {
        this.b.onDestroy();
        this.b = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        BaiduMap map;
        super.onAttachedToWindow();
        Log.d(a, "onAttachedToWindow");
        try {
            if (this.b != null && (map = this.b.getMap()) != null) {
                b.a().a(WNaviBaiduMap.getId());
                MapStatus.Builder builder = new MapStatus.Builder();
                builder.overlook(0.0f);
                map.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
                a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d(a, "onDetachedFromWindow");
        b.a().j();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
