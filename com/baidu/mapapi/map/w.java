package com.baidu.mapapi.map;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
/* loaded from: classes8.dex */
public class w implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f36038b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f36039c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f36040d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TileOverlay f36041e;

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
        this.f36041e = tileOverlay;
        this.a = i2;
        this.f36038b = i3;
        this.f36039c = i4;
        this.f36040d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TileProvider tileProvider;
        HashSet hashSet;
        String unused;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            tileProvider = this.f36041e.f35999g;
            Tile tile = ((FileTileProvider) tileProvider).getTile(this.a, this.f36038b, this.f36039c);
            if (tile != null && tile.width == 256 && tile.height == 256) {
                this.f36041e.a(this.a + "_" + this.f36038b + "_" + this.f36039c, tile);
            } else {
                unused = TileOverlay.f35994b;
            }
            hashSet = this.f36041e.f35998e;
            hashSet.remove(this.f36040d);
        }
    }
}
