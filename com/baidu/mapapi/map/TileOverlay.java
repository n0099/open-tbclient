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
    public static final String f7038b = "TileOverlay";

    /* renamed from: f  reason: collision with root package name */
    public static int f7039f;

    /* renamed from: a  reason: collision with root package name */
    public BaiduMap f7040a;

    /* renamed from: g  reason: collision with root package name */
    public TileProvider f7044g;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, Tile> f7042d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f7043e = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f7041c = Executors.newFixedThreadPool(1);

    public TileOverlay(BaiduMap baiduMap, TileProvider tileProvider) {
        this.f7040a = baiduMap;
        this.f7044g = tileProvider;
    }

    private synchronized Tile a(String str) {
        if (this.f7042d.containsKey(str)) {
            Tile tile = this.f7042d.get(str);
            this.f7042d.remove(str);
            return tile;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, Tile tile) {
        this.f7042d.put(str, tile);
    }

    private synchronized boolean b(String str) {
        return this.f7043e.contains(str);
    }

    private synchronized void c(String str) {
        this.f7043e.add(str);
    }

    public Tile a(int i2, int i3, int i4) {
        String str;
        String str2;
        String str3 = i2 + "_" + i3 + "_" + i4;
        Tile a2 = a(str3);
        if (a2 != null) {
            return a2;
        }
        BaiduMap baiduMap = this.f7040a;
        if (baiduMap != null && f7039f == 0) {
            WinRound winRound = baiduMap.getMapStatus().f6894a.j;
            f7039f = (((winRound.right - winRound.left) / 256) + 2) * (((winRound.bottom - winRound.top) / 256) + 2);
        }
        if (this.f7042d.size() > f7039f) {
            a();
        }
        if (b(str3) || this.f7041c.isShutdown()) {
            return null;
        }
        try {
            c(str3);
            this.f7041c.execute(new w(this, i2, i3, i4, str3));
            return null;
        } catch (RejectedExecutionException unused) {
            str = f7038b;
            str2 = "ThreadPool excepiton";
            Log.e(str, str2);
            return null;
        } catch (Exception unused2) {
            str = f7038b;
            str2 = "fileDir is not legal";
            Log.e(str, str2);
            return null;
        }
    }

    public synchronized void a() {
        Logger.logE(f7038b, "clearTaskSet");
        this.f7043e.clear();
        this.f7042d.clear();
    }

    public void b() {
        this.f7041c.shutdownNow();
    }

    public boolean clearTileCache() {
        BaiduMap baiduMap = this.f7040a;
        if (baiduMap == null) {
            return false;
        }
        return baiduMap.b();
    }

    public void removeTileOverlay() {
        BaiduMap baiduMap = this.f7040a;
        if (baiduMap == null) {
            return;
        }
        baiduMap.a(this);
    }
}
