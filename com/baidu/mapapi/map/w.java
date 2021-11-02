package com.baidu.mapapi.map;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
/* loaded from: classes7.dex */
public class w implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f39605a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f39606b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f39607c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f39608d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TileOverlay f39609e;

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
        this.f39609e = tileOverlay;
        this.f39605a = i2;
        this.f39606b = i3;
        this.f39607c = i4;
        this.f39608d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TileProvider tileProvider;
        HashSet hashSet;
        String unused;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            tileProvider = this.f39609e.f39540g;
            Tile tile = ((FileTileProvider) tileProvider).getTile(this.f39605a, this.f39606b, this.f39607c);
            if (tile != null && tile.width == 256 && tile.height == 256) {
                this.f39609e.a(this.f39605a + "_" + this.f39606b + "_" + this.f39607c, tile);
            } else {
                unused = TileOverlay.f39534b;
            }
            hashSet = this.f39609e.f39539e;
            hashSet.remove(this.f39608d);
        }
    }
}
