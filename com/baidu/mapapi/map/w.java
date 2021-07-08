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
    public final /* synthetic */ int f7199a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7200b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7201c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f7202d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TileOverlay f7203e;

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
        this.f7203e = tileOverlay;
        this.f7199a = i2;
        this.f7200b = i3;
        this.f7201c = i4;
        this.f7202d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TileProvider tileProvider;
        String str;
        String str2;
        HashSet hashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            tileProvider = this.f7203e.f7134g;
            Tile tile = ((FileTileProvider) tileProvider).getTile(this.f7199a, this.f7200b, this.f7201c);
            if (tile == null) {
                str = TileOverlay.f7128b;
                str2 = "FileTile pic is null";
            } else if (tile.width == 256 && tile.height == 256) {
                this.f7203e.a(this.f7199a + "_" + this.f7200b + "_" + this.f7201c, tile);
                hashSet = this.f7203e.f7133e;
                hashSet.remove(this.f7202d);
            } else {
                str = TileOverlay.f7128b;
                str2 = "FileTile pic must be 256 * 256";
            }
            Log.e(str, str2);
            hashSet = this.f7203e.f7133e;
            hashSet.remove(this.f7202d);
        }
    }
}
