package com.baidu.mapapi.map;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
/* loaded from: classes3.dex */
public class w implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7182a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7183b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7184c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f7185d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TileOverlay f7186e;

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
        this.f7186e = tileOverlay;
        this.f7182a = i2;
        this.f7183b = i3;
        this.f7184c = i4;
        this.f7185d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TileProvider tileProvider;
        String str;
        String str2;
        HashSet hashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            tileProvider = this.f7186e.f7117g;
            Tile tile = ((FileTileProvider) tileProvider).getTile(this.f7182a, this.f7183b, this.f7184c);
            if (tile == null) {
                str = TileOverlay.f7111b;
                str2 = "FileTile pic is null";
            } else if (tile.width == 256 && tile.height == 256) {
                this.f7186e.a(this.f7182a + "_" + this.f7183b + "_" + this.f7184c, tile);
                hashSet = this.f7186e.f7116e;
                hashSet.remove(this.f7185d);
            } else {
                str = TileOverlay.f7111b;
                str2 = "FileTile pic must be 256 * 256";
            }
            Log.e(str, str2);
            hashSet = this.f7186e.f7116e;
            hashSet.remove(this.f7185d);
        }
    }
}
