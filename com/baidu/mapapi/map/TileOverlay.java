package com.baidu.mapapi.map;

import android.util.Log;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.mapapi.common.Logger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes8.dex */
public final class TileOverlay {
    private static final String b = TileOverlay.class.getSimpleName();
    private static int f = 0;
    BaiduMap a;
    private TileProvider g;
    private HashMap<String, Tile> d = new HashMap<>();
    private HashSet<String> e = new HashSet<>();
    private ExecutorService c = Executors.newFixedThreadPool(1);

    public TileOverlay(BaiduMap baiduMap, TileProvider tileProvider) {
        this.a = baiduMap;
        this.g = tileProvider;
    }

    private synchronized Tile a(String str) {
        Tile tile;
        if (this.d.containsKey(str)) {
            tile = this.d.get(str);
            this.d.remove(str);
        } else {
            tile = null;
        }
        return tile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, Tile tile) {
        this.d.put(str, tile);
    }

    private synchronized boolean b(String str) {
        return this.e.contains(str);
    }

    private synchronized void c(String str) {
        this.e.add(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tile a(int i, int i2, int i3) {
        String str = i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i3;
        Tile a = a(str);
        if (a != null) {
            return a;
        }
        if (this.a != null && f == 0) {
            MapStatus mapStatus = this.a.getMapStatus();
            f = (((mapStatus.a.j.bottom - mapStatus.a.j.f994top) / 256) + 2) * (((mapStatus.a.j.right - mapStatus.a.j.left) / 256) + 2);
        }
        if (this.d.size() > f) {
            a();
        }
        if (!b(str) && !this.c.isShutdown()) {
            try {
                c(str);
                this.c.execute(new v(this, i, i2, i3, str));
            } catch (RejectedExecutionException e) {
                Log.e(b, "ThreadPool excepiton");
            } catch (Exception e2) {
                Log.e(b, "fileDir is not legal");
            }
        }
        return null;
    }

    synchronized void a() {
        Logger.logE(b, "clearTaskSet");
        this.e.clear();
        this.d.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.c.shutdownNow();
    }

    public boolean clearTileCache() {
        return this.a.b();
    }

    public void removeTileOverlay() {
        if (this.a == null) {
            return;
        }
        this.a.a(this);
    }
}
