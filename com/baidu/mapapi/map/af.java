package com.baidu.mapapi.map;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class af implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ TileOverlay e;

    public af(TileOverlay tileOverlay, int i, int i2, int i3, String str) {
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
        this.e = tileOverlay;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TileProvider tileProvider;
        String str;
        HashSet hashSet;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        tileProvider = this.e.g;
        Tile tile = ((FileTileProvider) tileProvider).getTile(this.a, this.b, this.c);
        if (tile != null) {
            if (tile.width == 256 && tile.height == 256) {
                this.e.a(this.a + "_" + this.b + "_" + this.c, tile);
            } else {
                str2 = TileOverlay.b;
                Log.e(str2, "FileTile pic must be 256 * 256");
            }
        } else {
            str = TileOverlay.b;
            Log.e(str, "FileTile pic is null");
        }
        hashSet = this.e.e;
        hashSet.remove(this.d);
    }
}
