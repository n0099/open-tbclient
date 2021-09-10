package com.baidu.mapapi.map;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.common.Logger;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes5.dex */
public final class TileOverlay {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String f41628b = "TileOverlay";

    /* renamed from: f  reason: collision with root package name */
    public static int f41629f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaiduMap f41630a;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f41631c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, Tile> f41632d;

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f41633e;

    /* renamed from: g  reason: collision with root package name */
    public TileProvider f41634g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(424751247, "Lcom/baidu/mapapi/map/TileOverlay;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(424751247, "Lcom/baidu/mapapi/map/TileOverlay;");
        }
    }

    public TileOverlay(BaiduMap baiduMap, TileProvider tileProvider) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baiduMap, tileProvider};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41630a = baiduMap;
        this.f41634g = tileProvider;
        this.f41632d = new HashMap<>();
        this.f41633e = new HashSet<>();
        this.f41631c = Executors.newFixedThreadPool(1);
    }

    private synchronized Tile a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            synchronized (this) {
                if (this.f41632d.containsKey(str)) {
                    Tile tile = this.f41632d.get(str);
                    this.f41632d.remove(str);
                    return tile;
                }
                return null;
            }
        }
        return (Tile) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, Tile tile) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, tile) == null) {
            synchronized (this) {
                this.f41632d.put(str, tile);
            }
        }
    }

    private synchronized boolean b(String str) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) {
            synchronized (this) {
                contains = this.f41633e.contains(str);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    private synchronized void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, str) == null) {
            synchronized (this) {
                this.f41633e.add(str);
            }
        }
    }

    public Tile a(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048576, this, i2, i3, i4)) == null) {
            String str = i2 + "_" + i3 + "_" + i4;
            Tile a2 = a(str);
            if (a2 != null) {
                return a2;
            }
            BaiduMap baiduMap = this.f41630a;
            if (baiduMap != null && f41629f == 0) {
                WinRound winRound = baiduMap.getMapStatus().f41474a.f42183j;
                f41629f = (((winRound.right - winRound.left) / 256) + 2) * (((winRound.bottom - winRound.top) / 256) + 2);
            }
            if (this.f41632d.size() > f41629f) {
                a();
            }
            if (b(str) || this.f41631c.isShutdown()) {
                return null;
            }
            try {
                c(str);
                this.f41631c.execute(new w(this, i2, i3, i4, str));
                return null;
            } catch (RejectedExecutionException | Exception unused) {
                return null;
            }
        }
        return (Tile) invokeIII.objValue;
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                Logger.logE(f41628b, "clearTaskSet");
                this.f41633e.clear();
                this.f41632d.clear();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f41631c.shutdownNow();
        }
    }

    public boolean clearTileCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            BaiduMap baiduMap = this.f41630a;
            if (baiduMap == null) {
                return false;
            }
            return baiduMap.b();
        }
        return invokeV.booleanValue;
    }

    public void removeTileOverlay() {
        BaiduMap baiduMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (baiduMap = this.f41630a) == null) {
            return;
        }
        baiduMap.a(this);
    }
}
