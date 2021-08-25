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
    public final /* synthetic */ int f41590a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f41591b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f41592c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f41593d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TileOverlay f41594e;

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
        this.f41594e = tileOverlay;
        this.f41590a = i2;
        this.f41591b = i3;
        this.f41592c = i4;
        this.f41593d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TileProvider tileProvider;
        HashSet hashSet;
        String unused;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            tileProvider = this.f41594e.f41523g;
            Tile tile = ((FileTileProvider) tileProvider).getTile(this.f41590a, this.f41591b, this.f41592c);
            if (tile != null && tile.width == 256 && tile.height == 256) {
                this.f41594e.a(this.f41590a + "_" + this.f41591b + "_" + this.f41592c, tile);
            } else {
                unused = TileOverlay.f41517b;
            }
            hashSet = this.f41594e.f41522e;
            hashSet.remove(this.f41593d);
        }
    }
}
