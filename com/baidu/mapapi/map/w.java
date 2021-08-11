package com.baidu.mapapi.map;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
/* loaded from: classes5.dex */
public class w implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f41483a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f41484b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f41485c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f41486d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TileOverlay f41487e;

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
        this.f41487e = tileOverlay;
        this.f41483a = i2;
        this.f41484b = i3;
        this.f41485c = i4;
        this.f41486d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TileProvider tileProvider;
        HashSet hashSet;
        String unused;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            tileProvider = this.f41487e.f41416g;
            Tile tile = ((FileTileProvider) tileProvider).getTile(this.f41483a, this.f41484b, this.f41485c);
            if (tile != null && tile.width == 256 && tile.height == 256) {
                this.f41487e.a(this.f41483a + "_" + this.f41484b + "_" + this.f41485c, tile);
            } else {
                unused = TileOverlay.f41410b;
            }
            hashSet = this.f41487e.f41415e;
            hashSet.remove(this.f41486d);
        }
    }
}
