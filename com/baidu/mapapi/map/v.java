package com.baidu.mapapi.map;

import android.util.Log;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7099a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7100b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7101c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f7102d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TileOverlay f7103e;

    public v(TileOverlay tileOverlay, int i, int i2, int i3, String str) {
        this.f7103e = tileOverlay;
        this.f7099a = i;
        this.f7100b = i2;
        this.f7101c = i3;
        this.f7102d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TileProvider tileProvider;
        String str;
        String str2;
        HashSet hashSet;
        tileProvider = this.f7103e.f7039g;
        Tile tile = ((FileTileProvider) tileProvider).getTile(this.f7099a, this.f7100b, this.f7101c);
        if (tile == null) {
            str = TileOverlay.f7033b;
            str2 = "FileTile pic is null";
        } else if (tile.width == 256 && tile.height == 256) {
            this.f7103e.a(this.f7099a + "_" + this.f7100b + "_" + this.f7101c, tile);
            hashSet = this.f7103e.f7038e;
            hashSet.remove(this.f7102d);
        } else {
            str = TileOverlay.f7033b;
            str2 = "FileTile pic must be 256 * 256";
        }
        Log.e(str, str2);
        hashSet = this.f7103e.f7038e;
        hashSet.remove(this.f7102d);
    }
}
