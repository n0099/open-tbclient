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

    /* renamed from: b  reason: collision with root package name */
    public static final String f7034b = "TileOverlay";

    /* renamed from: f  reason: collision with root package name */
    public static int f7035f;

    /* renamed from: a  reason: collision with root package name */
    public BaiduMap f7036a;

    /* renamed from: g  reason: collision with root package name */
    public TileProvider f7040g;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, Tile> f7038d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f7039e = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f7037c = Executors.newFixedThreadPool(1);

    public TileOverlay(BaiduMap baiduMap, TileProvider tileProvider) {
        this.f7036a = baiduMap;
        this.f7040g = tileProvider;
    }

    private synchronized Tile a(String str) {
        if (this.f7038d.containsKey(str)) {
            Tile tile = this.f7038d.get(str);
            this.f7038d.remove(str);
            return tile;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, Tile tile) {
        this.f7038d.put(str, tile);
    }

    private synchronized boolean b(String str) {
        return this.f7039e.contains(str);
    }

    private synchronized void c(String str) {
        this.f7039e.add(str);
    }

    public Tile a(int i, int i2, int i3) {
        String str;
        String str2;
        String str3 = i + "_" + i2 + "_" + i3;
        Tile a2 = a(str3);
        if (a2 != null) {
            return a2;
        }
        BaiduMap baiduMap = this.f7036a;
        if (baiduMap != null && f7035f == 0) {
            WinRound winRound = baiduMap.getMapStatus().f6901a.j;
            f7035f = (((winRound.right - winRound.left) / 256) + 2) * (((winRound.bottom - winRound.top) / 256) + 2);
        }
        if (this.f7038d.size() > f7035f) {
            a();
        }
        if (b(str3) || this.f7037c.isShutdown()) {
            return null;
        }
        try {
            c(str3);
            this.f7037c.execute(new v(this, i, i2, i3, str3));
            return null;
        } catch (RejectedExecutionException unused) {
            str = f7034b;
            str2 = "ThreadPool excepiton";
            Log.e(str, str2);
            return null;
        } catch (Exception unused2) {
            str = f7034b;
            str2 = "fileDir is not legal";
            Log.e(str, str2);
            return null;
        }
    }

    public synchronized void a() {
        Logger.logE(f7034b, "clearTaskSet");
        this.f7039e.clear();
        this.f7038d.clear();
    }

    public void b() {
        this.f7037c.shutdownNow();
    }

    public boolean clearTileCache() {
        return this.f7036a.b();
    }

    public void removeTileOverlay() {
        BaiduMap baiduMap = this.f7036a;
        if (baiduMap == null) {
            return;
        }
        baiduMap.a(this);
    }
}
