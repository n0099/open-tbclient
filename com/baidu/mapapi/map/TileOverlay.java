package com.baidu.mapapi.map;

import android.util.Log;
import com.baidu.mapapi.common.Logger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes2.dex */
public final class TileOverlay {
    public static final String b = "TileOverlay";
    public static int f;
    public BaiduMap a;
    public TileProvider g;
    public HashMap<String, Tile> d = new HashMap<>();
    public HashSet<String> e = new HashSet<>();
    public ExecutorService c = Executors.newFixedThreadPool(1);

    public TileOverlay(BaiduMap baiduMap, TileProvider tileProvider) {
        this.a = baiduMap;
        this.g = tileProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, Tile tile) {
        this.d.put(str, tile);
    }

    private synchronized Tile a(String str) {
        if (this.d.containsKey(str)) {
            Tile tile = this.d.get(str);
            this.d.remove(str);
            return tile;
        }
        return null;
    }

    private synchronized void c(String str) {
        this.e.add(str);
    }

    private synchronized boolean b(String str) {
        return this.e.contains(str);
    }

    public synchronized void a() {
        Logger.logE(b, "clearTaskSet");
        this.e.clear();
        this.d.clear();
    }

    public void b() {
        this.c.shutdownNow();
    }

    public boolean clearTileCache() {
        BaiduMap baiduMap = this.a;
        if (baiduMap == null) {
            return false;
        }
        return baiduMap.b();
    }

    public void removeTileOverlay() {
        BaiduMap baiduMap = this.a;
        if (baiduMap == null) {
            return;
        }
        baiduMap.a(this);
    }

    public Tile a(int i, int i2, int i3) {
        String str = i + "_" + i2 + "_" + i3;
        Tile a = a(str);
        if (a != null) {
            return a;
        }
        BaiduMap baiduMap = this.a;
        if (baiduMap != null && f == 0) {
            WinRound winRound = baiduMap.getMapStatus().a.j;
            f = (((winRound.right - winRound.left) / 256) + 2) * (((winRound.bottom - winRound.top) / 256) + 2);
        }
        if (this.d.size() > f) {
            a();
        }
        if (!b(str) && !this.c.isShutdown()) {
            try {
                c(str);
                this.c.execute(new af(this, i, i2, i3, str));
                return null;
            } catch (RejectedExecutionException unused) {
                Log.e(b, "ThreadPool excepiton");
                return null;
            } catch (Exception unused2) {
                Log.e(b, "fileDir is not legal");
                return null;
            }
        }
        return null;
    }
}
