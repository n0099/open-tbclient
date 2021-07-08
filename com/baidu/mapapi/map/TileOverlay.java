package com.baidu.mapapi.map;

import android.util.Log;
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
/* loaded from: classes2.dex */
public final class TileOverlay {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String f7128b = "TileOverlay";

    /* renamed from: f  reason: collision with root package name */
    public static int f7129f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaiduMap f7130a;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f7131c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, Tile> f7132d;

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f7133e;

    /* renamed from: g  reason: collision with root package name */
    public TileProvider f7134g;

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
        this.f7130a = baiduMap;
        this.f7134g = tileProvider;
        this.f7132d = new HashMap<>();
        this.f7133e = new HashSet<>();
        this.f7131c = Executors.newFixedThreadPool(1);
    }

    private synchronized Tile a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            synchronized (this) {
                if (this.f7132d.containsKey(str)) {
                    Tile tile = this.f7132d.get(str);
                    this.f7132d.remove(str);
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
                this.f7132d.put(str, tile);
            }
        }
    }

    private synchronized boolean b(String str) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) {
            synchronized (this) {
                contains = this.f7133e.contains(str);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    private synchronized void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, str) == null) {
            synchronized (this) {
                this.f7133e.add(str);
            }
        }
    }

    public Tile a(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048576, this, i2, i3, i4)) == null) {
            String str3 = i2 + "_" + i3 + "_" + i4;
            Tile a2 = a(str3);
            if (a2 != null) {
                return a2;
            }
            BaiduMap baiduMap = this.f7130a;
            if (baiduMap != null && f7129f == 0) {
                WinRound winRound = baiduMap.getMapStatus().f6984a.j;
                f7129f = (((winRound.right - winRound.left) / 256) + 2) * (((winRound.bottom - winRound.top) / 256) + 2);
            }
            if (this.f7132d.size() > f7129f) {
                a();
            }
            if (b(str3) || this.f7131c.isShutdown()) {
                return null;
            }
            try {
                c(str3);
                this.f7131c.execute(new w(this, i2, i3, i4, str3));
                return null;
            } catch (RejectedExecutionException unused) {
                str = f7128b;
                str2 = "ThreadPool excepiton";
                Log.e(str, str2);
                return null;
            } catch (Exception unused2) {
                str = f7128b;
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
                Logger.logE(f7128b, "clearTaskSet");
                this.f7133e.clear();
                this.f7132d.clear();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f7131c.shutdownNow();
        }
    }

    public boolean clearTileCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            BaiduMap baiduMap = this.f7130a;
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (baiduMap = this.f7130a) == null) {
            return;
        }
        baiduMap.a(this);
    }
}
