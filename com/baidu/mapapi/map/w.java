package com.baidu.mapapi.map;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class w implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f34111b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f34112c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f34113d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TileOverlay f34114e;

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
        this.f34114e = tileOverlay;
        this.a = i2;
        this.f34111b = i3;
        this.f34112c = i4;
        this.f34113d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TileProvider tileProvider;
        HashSet hashSet;
        String unused;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            tileProvider = this.f34114e.f34073g;
            Tile tile = ((FileTileProvider) tileProvider).getTile(this.a, this.f34111b, this.f34112c);
            if (tile != null && tile.width == 256 && tile.height == 256) {
                this.f34114e.a(this.a + "_" + this.f34111b + "_" + this.f34112c, tile);
            } else {
                unused = TileOverlay.f34068b;
            }
            hashSet = this.f34114e.f34072e;
            hashSet.remove(this.f34113d);
        }
    }
}
