package com.baidu.mapapi.map;

import android.util.Log;
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
    public final /* synthetic */ int f26347b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f26348c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f26349d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TileOverlay f26350e;

    public w(TileOverlay tileOverlay, int i, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tileOverlay, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26350e = tileOverlay;
        this.a = i;
        this.f26347b = i2;
        this.f26348c = i3;
        this.f26349d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TileProvider tileProvider;
        String str;
        String str2;
        HashSet hashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            tileProvider = this.f26350e.f26313g;
            Tile tile = ((FileTileProvider) tileProvider).getTile(this.a, this.f26347b, this.f26348c);
            if (tile == null) {
                str = TileOverlay.f26308b;
                str2 = "FileTile pic is null";
            } else if (tile.width == 256 && tile.height == 256) {
                this.f26350e.a(this.a + "_" + this.f26347b + "_" + this.f26348c, tile);
                hashSet = this.f26350e.f26312e;
                hashSet.remove(this.f26349d);
            } else {
                str = TileOverlay.f26308b;
                str2 = "FileTile pic must be 256 * 256";
            }
            Log.e(str, str2);
            hashSet = this.f26350e.f26312e;
            hashSet.remove(this.f26349d);
        }
    }
}
