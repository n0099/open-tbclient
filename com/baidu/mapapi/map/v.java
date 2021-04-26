package com.baidu.mapapi.map;

import android.util.Log;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7390a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7391b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7392c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f7393d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TileOverlay f7394e;

    public v(TileOverlay tileOverlay, int i2, int i3, int i4, String str) {
        this.f7394e = tileOverlay;
        this.f7390a = i2;
        this.f7391b = i3;
        this.f7392c = i4;
        this.f7393d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TileProvider tileProvider;
        String str;
        String str2;
        HashSet hashSet;
        tileProvider = this.f7394e.f7328g;
        Tile tile = ((FileTileProvider) tileProvider).getTile(this.f7390a, this.f7391b, this.f7392c);
        if (tile == null) {
            str = TileOverlay.f7322b;
            str2 = "FileTile pic is null";
        } else if (tile.width == 256 && tile.height == 256) {
            this.f7394e.a(this.f7390a + "_" + this.f7391b + "_" + this.f7392c, tile);
            hashSet = this.f7394e.f7327e;
            hashSet.remove(this.f7393d);
        } else {
            str = TileOverlay.f7322b;
            str2 = "FileTile pic must be 256 * 256";
        }
        Log.e(str, str2);
        hashSet = this.f7394e.f7327e;
        hashSet.remove(this.f7393d);
    }
}
