package com.baidu.mapapi.map;

import android.util.Log;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7152a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7153b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7154c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f7155d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TileOverlay f7156e;

    public w(TileOverlay tileOverlay, int i2, int i3, int i4, String str) {
        this.f7156e = tileOverlay;
        this.f7152a = i2;
        this.f7153b = i3;
        this.f7154c = i4;
        this.f7155d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TileProvider tileProvider;
        String str;
        String str2;
        HashSet hashSet;
        tileProvider = this.f7156e.f7087g;
        Tile tile = ((FileTileProvider) tileProvider).getTile(this.f7152a, this.f7153b, this.f7154c);
        if (tile == null) {
            str = TileOverlay.f7081b;
            str2 = "FileTile pic is null";
        } else if (tile.width == 256 && tile.height == 256) {
            this.f7156e.a(this.f7152a + "_" + this.f7153b + "_" + this.f7154c, tile);
            hashSet = this.f7156e.f7086e;
            hashSet.remove(this.f7155d);
        } else {
            str = TileOverlay.f7081b;
            str2 = "FileTile pic must be 256 * 256";
        }
        Log.e(str, str2);
        hashSet = this.f7156e.f7086e;
        hashSet.remove(this.f7155d);
    }
}
