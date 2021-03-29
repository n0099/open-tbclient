package com.baidu.mapapi.map;

import android.util.Log;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7100a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7101b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7102c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f7103d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TileOverlay f7104e;

    public v(TileOverlay tileOverlay, int i, int i2, int i3, String str) {
        this.f7104e = tileOverlay;
        this.f7100a = i;
        this.f7101b = i2;
        this.f7102c = i3;
        this.f7103d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TileProvider tileProvider;
        String str;
        String str2;
        HashSet hashSet;
        tileProvider = this.f7104e.f7040g;
        Tile tile = ((FileTileProvider) tileProvider).getTile(this.f7100a, this.f7101b, this.f7102c);
        if (tile == null) {
            str = TileOverlay.f7034b;
            str2 = "FileTile pic is null";
        } else if (tile.width == 256 && tile.height == 256) {
            this.f7104e.a(this.f7100a + "_" + this.f7101b + "_" + this.f7102c, tile);
            hashSet = this.f7104e.f7039e;
            hashSet.remove(this.f7103d);
        } else {
            str = TileOverlay.f7034b;
            str2 = "FileTile pic must be 256 * 256";
        }
        Log.e(str, str2);
        hashSet = this.f7104e.f7039e;
        hashSet.remove(this.f7103d);
    }
}
