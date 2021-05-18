package com.baidu.mapapi.map;

import android.util.Log;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7209a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7210b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7211c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f7212d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TileOverlay f7213e;

    public w(TileOverlay tileOverlay, int i2, int i3, int i4, String str) {
        this.f7213e = tileOverlay;
        this.f7209a = i2;
        this.f7210b = i3;
        this.f7211c = i4;
        this.f7212d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TileProvider tileProvider;
        String str;
        String str2;
        HashSet hashSet;
        tileProvider = this.f7213e.f7144g;
        Tile tile = ((FileTileProvider) tileProvider).getTile(this.f7209a, this.f7210b, this.f7211c);
        if (tile == null) {
            str = TileOverlay.f7138b;
            str2 = "FileTile pic is null";
        } else if (tile.width == 256 && tile.height == 256) {
            this.f7213e.a(this.f7209a + "_" + this.f7210b + "_" + this.f7211c, tile);
            hashSet = this.f7213e.f7143e;
            hashSet.remove(this.f7212d);
        } else {
            str = TileOverlay.f7138b;
            str2 = "FileTile pic must be 256 * 256";
        }
        Log.e(str, str2);
        hashSet = this.f7213e.f7143e;
        hashSet.remove(this.f7212d);
    }
}
