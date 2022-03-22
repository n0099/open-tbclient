package com.baidu.mapapi.map;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.common.Logger;
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
/* loaded from: classes4.dex */
public final class TileOverlay {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String f26308b = "TileOverlay";

    /* renamed from: f  reason: collision with root package name */
    public static int f26309f;
    public transient /* synthetic */ FieldHolder $fh;
    public BaiduMap a;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f26310c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, Tile> f26311d;

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f26312e;

    /* renamed from: g  reason: collision with root package name */
    public TileProvider f26313g;

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = baiduMap;
        this.f26313g = tileProvider;
        this.f26311d = new HashMap<>();
        this.f26312e = new HashSet<>();
        this.f26310c = Executors.newFixedThreadPool(1);
    }

    private synchronized Tile a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            synchronized (this) {
                if (this.f26311d.containsKey(str)) {
                    Tile tile = this.f26311d.get(str);
                    this.f26311d.remove(str);
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
        if (interceptable == null || interceptable.invokeLL(65541, this, str, tile) == null) {
            synchronized (this) {
                this.f26311d.put(str, tile);
            }
        }
    }

    private synchronized boolean b(String str) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) {
            synchronized (this) {
                contains = this.f26312e.contains(str);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    private synchronized void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, str) == null) {
            synchronized (this) {
                this.f26312e.add(str);
            }
        }
    }

    public Tile a(int i, int i2, int i3) {
        InterceptResult invokeIII;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048576, this, i, i2, i3)) == null) {
            String str3 = i + "_" + i2 + "_" + i3;
            Tile a = a(str3);
            if (a != null) {
                return a;
            }
            BaiduMap baiduMap = this.a;
            if (baiduMap != null && f26309f == 0) {
                WinRound winRound = baiduMap.getMapStatus().a.j;
                f26309f = (((winRound.right - winRound.left) / 256) + 2) * (((winRound.bottom - winRound.top) / 256) + 2);
            }
            if (this.f26311d.size() > f26309f) {
                a();
            }
            if (b(str3) || this.f26310c.isShutdown()) {
                return null;
            }
            try {
                c(str3);
                this.f26310c.execute(new w(this, i, i2, i3, str3));
                return null;
            } catch (RejectedExecutionException unused) {
                str = f26308b;
                str2 = "ThreadPool excepiton";
                Log.e(str, str2);
                return null;
            } catch (Exception unused2) {
                str = f26308b;
                str2 = "fileDir is not legal";
                Log.e(str, str2);
                return null;
            }
        }
        return (Tile) invokeIII.objValue;
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                Logger.logE(f26308b, "clearTaskSet");
                this.f26312e.clear();
                this.f26311d.clear();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f26310c.shutdownNow();
        }
    }

    public boolean clearTileCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            BaiduMap baiduMap = this.a;
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (baiduMap = this.a) == null) {
            return;
        }
        baiduMap.a(this);
    }
}
