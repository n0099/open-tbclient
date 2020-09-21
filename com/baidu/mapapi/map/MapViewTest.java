package com.baidu.mapapi.map;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidubce.services.bos.BosClientConfiguration;
import java.io.File;
/* loaded from: classes3.dex */
public class MapViewTest extends ViewGroup {
    MapSurfaceView a;
    MapController b;

    public MapViewTest(Context context) {
        super(context);
        a(context);
    }

    private int a() {
        return 52428800;
    }

    private void a(Context context) {
        this.a = new MapSurfaceView(context);
        if (this.b == null) {
            this.b = new MapController();
            this.b.initBaseMap();
            a(this.b);
        }
        this.b.onResume();
        this.a.setMapController(this.b);
        addView(this.a);
    }

    private void a(MapController mapController) {
        if (!com.baidu.platform.comapi.b.a()) {
            synchronized (com.baidu.platform.comapi.b.class) {
            }
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", 12.0d);
        bundle.putDouble("centerptx", 1.295815798E7d);
        bundle.putDouble("centerpty", 4825999.74d);
        bundle.putDouble("centerptz", 0.0d);
        bundle.putInt("left", 0);
        bundle.putInt(VerticalTranslateLayout.TOP, 0);
        int screenHeight = SysOSUtil.getInstance().getScreenHeight();
        bundle.putInt(HorizontalTranslateLayout.DIRECTION_RIGHT, SysOSUtil.getInstance().getScreenWidth());
        bundle.putInt(VerticalTranslateLayout.BOTTOM, screenHeight);
        String str = SysOSUtil.getInstance().getSdcardPath() + File.separator + "baidusdkdemo";
        String str2 = str + File.separator + "cache";
        bundle.putString("modulePath", SysOSUtil.getInstance().getOutputDirPath());
        bundle.putString("appSdcardPath", str);
        bundle.putString("appCachePath", str2);
        bundle.putString("appSecondCachePath", str2);
        bundle.putInt("mapTmpMax", a());
        bundle.putInt("domTmpMax", b());
        bundle.putInt("itsTmpMax", c());
        bundle.putInt("ssgTmpMax", d());
        mapController.initMapResources(bundle);
    }

    private int b() {
        return 52428800;
    }

    private int c() {
        return BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE;
    }

    private int d() {
        return 52428800;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.a.layout(0, 0, getWidth(), getHeight());
    }
}
