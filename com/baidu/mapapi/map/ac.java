package com.baidu.mapapi.map;

import android.util.Log;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.HashSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2902a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f2903b;
    final /* synthetic */ int c;
    final /* synthetic */ String d;
    final /* synthetic */ TileOverlay e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(TileOverlay tileOverlay, int i, int i2, int i3, String str) {
        this.e = tileOverlay;
        this.f2902a = i;
        this.f2903b = i2;
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
        Tile tile = ((FileTileProvider) tileProvider).getTile(this.f2902a, this.f2903b, this.c);
        if (tile == null) {
            str = TileOverlay.f2887b;
            Log.e(str, "FileTile pic is null");
        } else if (tile.width == 256 && tile.height == 256) {
            this.e.a(this.f2902a + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.f2903b + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.c, tile);
        } else {
            str2 = TileOverlay.f2887b;
            Log.e(str2, "FileTile pic must be 256 * 256");
        }
        hashSet = this.e.e;
        hashSet.remove(this.d);
    }
}
