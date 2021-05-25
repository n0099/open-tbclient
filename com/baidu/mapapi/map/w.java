package com.baidu.mapapi.map;

import android.util.Log;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7109a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7110b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7111c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f7112d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TileOverlay f7113e;

    public w(TileOverlay tileOverlay, int i2, int i3, int i4, String str) {
        this.f7113e = tileOverlay;
        this.f7109a = i2;
        this.f7110b = i3;
        this.f7111c = i4;
        this.f7112d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TileProvider tileProvider;
        String str;
        String str2;
        HashSet hashSet;
        tileProvider = this.f7113e.f7044g;
        Tile tile = ((FileTileProvider) tileProvider).getTile(this.f7109a, this.f7110b, this.f7111c);
        if (tile == null) {
            str = TileOverlay.f7038b;
            str2 = "FileTile pic is null";
        } else if (tile.width == 256 && tile.height == 256) {
            this.f7113e.a(this.f7109a + "_" + this.f7110b + "_" + this.f7111c, tile);
            hashSet = this.f7113e.f7043e;
            hashSet.remove(this.f7112d);
        } else {
            str = TileOverlay.f7038b;
            str2 = "FileTile pic must be 256 * 256";
        }
        Log.e(str, str2);
        hashSet = this.f7113e.f7043e;
        hashSet.remove(this.f7112d);
    }
}
