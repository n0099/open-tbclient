package com.baidu.mapapi.map;

import android.util.Log;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.HashSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class ac implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ String d;
    final /* synthetic */ TileOverlay e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(TileOverlay tileOverlay, int i, int i2, int i3, String str) {
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
        if (tile == null) {
            str = TileOverlay.b;
            Log.e(str, "FileTile pic is null");
        } else if (tile.width == 256 && tile.height == 256) {
            this.e.a(this.a + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.b + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.c, tile);
        } else {
            str2 = TileOverlay.b;
            Log.e(str2, "FileTile pic must be 256 * 256");
        }
        hashSet = this.e.e;
        hashSet.remove(this.d);
    }
}
