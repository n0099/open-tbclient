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
    public final /* synthetic */ int f41763a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f41764b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f41765c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f41766d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TileOverlay f41767e;

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
        this.f41767e = tileOverlay;
        this.f41763a = i2;
        this.f41764b = i3;
        this.f41765c = i4;
        this.f41766d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TileProvider tileProvider;
        HashSet hashSet;
        String unused;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            tileProvider = this.f41767e.f41696g;
            Tile tile = ((FileTileProvider) tileProvider).getTile(this.f41763a, this.f41764b, this.f41765c);
            if (tile != null && tile.width == 256 && tile.height == 256) {
                this.f41767e.a(this.f41763a + "_" + this.f41764b + "_" + this.f41765c, tile);
            } else {
                unused = TileOverlay.f41690b;
            }
            hashSet = this.f41767e.f41695e;
            hashSet.remove(this.f41766d);
        }
    }
}
