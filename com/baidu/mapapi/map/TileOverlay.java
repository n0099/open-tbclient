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
    public static final String f7033b = "TileOverlay";

    /* renamed from: f  reason: collision with root package name */
    public static int f7034f;

    /* renamed from: a  reason: collision with root package name */
    public BaiduMap f7035a;

    /* renamed from: g  reason: collision with root package name */
    public TileProvider f7039g;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, Tile> f7037d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f7038e = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f7036c = Executors.newFixedThreadPool(1);

    public TileOverlay(BaiduMap baiduMap, TileProvider tileProvider) {
        this.f7035a = baiduMap;
        this.f7039g = tileProvider;
    }

    private synchronized Tile a(String str) {
        if (this.f7037d.containsKey(str)) {
            Tile tile = this.f7037d.get(str);
            this.f7037d.remove(str);
            return tile;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, Tile tile) {
        this.f7037d.put(str, tile);
    }

    private synchronized boolean b(String str) {
        return this.f7038e.contains(str);
    }

    private synchronized void c(String str) {
        this.f7038e.add(str);
    }

    public Tile a(int i, int i2, int i3) {
        String str;
        String str2;
        String str3 = i + "_" + i2 + "_" + i3;
        Tile a2 = a(str3);
        if (a2 != null) {
            return a2;
        }
        BaiduMap baiduMap = this.f7035a;
        if (baiduMap != null && f7034f == 0) {
            WinRound winRound = baiduMap.getMapStatus().f6900a.j;
            f7034f = (((winRound.right - winRound.left) / 256) + 2) * (((winRound.bottom - winRound.top) / 256) + 2);
        }
        if (this.f7037d.size() > f7034f) {
            a();
        }
        if (b(str3) || this.f7036c.isShutdown()) {
            return null;
        }
        try {
            c(str3);
            this.f7036c.execute(new v(this, i, i2, i3, str3));
            return null;
        } catch (RejectedExecutionException unused) {
            str = f7033b;
            str2 = "ThreadPool excepiton";
            Log.e(str, str2);
            return null;
        } catch (Exception unused2) {
            str = f7033b;
            str2 = "fileDir is not legal";
            Log.e(str, str2);
            return null;
        }
    }

    public synchronized void a() {
        Logger.logE(f7033b, "clearTaskSet");
        this.f7038e.clear();
        this.f7037d.clear();
    }

    public void b() {
        this.f7036c.shutdownNow();
    }

    public boolean clearTileCache() {
        return this.f7035a.b();
    }

    public void removeTileOverlay() {
        BaiduMap baiduMap = this.f7035a;
        if (baiduMap == null) {
            return;
        }
        baiduMap.a(this);
    }
}
