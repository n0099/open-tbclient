package com.baidu.mapapi.map;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
/* loaded from: classes10.dex */
public class w implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f35502b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f35503c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f35504d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TileOverlay f35505e;

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
        this.f35505e = tileOverlay;
        this.a = i2;
        this.f35502b = i3;
        this.f35503c = i4;
        this.f35504d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TileProvider tileProvider;
        HashSet hashSet;
        String unused;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            tileProvider = this.f35505e.f35464g;
            Tile tile = ((FileTileProvider) tileProvider).getTile(this.a, this.f35502b, this.f35503c);
            if (tile != null && tile.width == 256 && tile.height == 256) {
                this.f35505e.a(this.a + "_" + this.f35502b + "_" + this.f35503c, tile);
            } else {
                unused = TileOverlay.f35459b;
            }
            hashSet = this.f35505e.f35463e;
            hashSet.remove(this.f35504d);
        }
    }
}
