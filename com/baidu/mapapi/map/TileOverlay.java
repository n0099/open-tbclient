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
    public static final String f7138b = "TileOverlay";

    /* renamed from: f  reason: collision with root package name */
    public static int f7139f;

    /* renamed from: a  reason: collision with root package name */
    public BaiduMap f7140a;

    /* renamed from: g  reason: collision with root package name */
    public TileProvider f7144g;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, Tile> f7142d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f7143e = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f7141c = Executors.newFixedThreadPool(1);

    public TileOverlay(BaiduMap baiduMap, TileProvider tileProvider) {
        this.f7140a = baiduMap;
        this.f7144g = tileProvider;
    }

    private synchronized Tile a(String str) {
        if (this.f7142d.containsKey(str)) {
            Tile tile = this.f7142d.get(str);
            this.f7142d.remove(str);
            return tile;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, Tile tile) {
        this.f7142d.put(str, tile);
    }

    private synchronized boolean b(String str) {
        return this.f7143e.contains(str);
    }

    private synchronized void c(String str) {
        this.f7143e.add(str);
    }

    public Tile a(int i2, int i3, int i4) {
        String str;
        String str2;
        String str3 = i2 + "_" + i3 + "_" + i4;
        Tile a2 = a(str3);
        if (a2 != null) {
            return a2;
        }
        BaiduMap baiduMap = this.f7140a;
        if (baiduMap != null && f7139f == 0) {
            WinRound winRound = baiduMap.getMapStatus().f6994a.j;
            f7139f = (((winRound.right - winRound.left) / 256) + 2) * (((winRound.bottom - winRound.top) / 256) + 2);
        }
        if (this.f7142d.size() > f7139f) {
            a();
        }
        if (b(str3) || this.f7141c.isShutdown()) {
            return null;
        }
        try {
            c(str3);
            this.f7141c.execute(new w(this, i2, i3, i4, str3));
            return null;
        } catch (RejectedExecutionException unused) {
            str = f7138b;
            str2 = "ThreadPool excepiton";
            Log.e(str, str2);
            return null;
        } catch (Exception unused2) {
            str = f7138b;
            str2 = "fileDir is not legal";
            Log.e(str, str2);
            return null;
        }
    }

    public synchronized void a() {
        Logger.logE(f7138b, "clearTaskSet");
        this.f7143e.clear();
        this.f7142d.clear();
    }

    public void b() {
        this.f7141c.shutdownNow();
    }

    public boolean clearTileCache() {
        BaiduMap baiduMap = this.f7140a;
        if (baiduMap == null) {
            return false;
        }
        return baiduMap.b();
    }

    public void removeTileOverlay() {
        BaiduMap baiduMap = this.f7140a;
        if (baiduMap == null) {
            return;
        }
        baiduMap.a(this);
    }
}
