package com.baidu.mapapi.map;

import android.util.Log;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7135a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7136b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7137c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f7138d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TileOverlay f7139e;

    public v(TileOverlay tileOverlay, int i, int i2, int i3, String str) {
        this.f7139e = tileOverlay;
        this.f7135a = i;
        this.f7136b = i2;
        this.f7137c = i3;
        this.f7138d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TileProvider tileProvider;
        String str;
        String str2;
        HashSet hashSet;
        tileProvider = this.f7139e.f7075g;
        Tile tile = ((FileTileProvider) tileProvider).getTile(this.f7135a, this.f7136b, this.f7137c);
        if (tile == null) {
            str = TileOverlay.f7069b;
            str2 = "FileTile pic is null";
        } else if (tile.width == 256 && tile.height == 256) {
            this.f7139e.a(this.f7135a + "_" + this.f7136b + "_" + this.f7137c, tile);
            hashSet = this.f7139e.f7074e;
            hashSet.remove(this.f7138d);
        } else {
            str = TileOverlay.f7069b;
            str2 = "FileTile pic must be 256 * 256";
        }
        Log.e(str, str2);
        hashSet = this.f7139e.f7074e;
        hashSet.remove(this.f7138d);
    }
}
