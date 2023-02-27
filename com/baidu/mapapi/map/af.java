package com.baidu.mapapi.map;

import android.util.Log;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class af implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ TileOverlay e;

    public af(TileOverlay tileOverlay, int i, int i2, int i3, String str) {
        this.e = tileOverlay;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TileProvider tileProvider;
        String str;
        HashSet hashSet;
        String str2;
        tileProvider = this.e.g;
        Tile tile = ((FileTileProvider) tileProvider).getTile(this.a, this.b, this.c);
        if (tile != null) {
            if (tile.width == 256 && tile.height == 256) {
                this.e.a(this.a + "_" + this.b + "_" + this.c, tile);
            } else {
                str2 = TileOverlay.b;
                Log.e(str2, "FileTile pic must be 256 * 256");
            }
        } else {
            str = TileOverlay.b;
            Log.e(str, "FileTile pic is null");
        }
        hashSet = this.e.e;
        hashSet.remove(this.d);
    }
}
