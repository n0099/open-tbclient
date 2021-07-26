package com.baidu.mapapi.map;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class w implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7225a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7226b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7227c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f7228d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TileOverlay f7229e;

    public w(TileOverlay tileOverlay, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tileOverlay, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7229e = tileOverlay;
        this.f7225a = i2;
        this.f7226b = i3;
        this.f7227c = i4;
        this.f7228d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TileProvider tileProvider;
        String str;
        String str2;
        HashSet hashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            tileProvider = this.f7229e.f7160g;
            Tile tile = ((FileTileProvider) tileProvider).getTile(this.f7225a, this.f7226b, this.f7227c);
            if (tile == null) {
                str = TileOverlay.f7154b;
                str2 = "FileTile pic is null";
            } else if (tile.width == 256 && tile.height == 256) {
                this.f7229e.a(this.f7225a + "_" + this.f7226b + "_" + this.f7227c, tile);
                hashSet = this.f7229e.f7159e;
                hashSet.remove(this.f7228d);
            } else {
                str = TileOverlay.f7154b;
                str2 = "FileTile pic must be 256 * 256";
            }
            Log.e(str, str2);
            hashSet = this.f7229e.f7159e;
            hashSet.remove(this.f7228d);
        }
    }
}
