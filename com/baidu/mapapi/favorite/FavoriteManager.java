package com.baidu.mapapi.favorite;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import com.baidu.mapsdkplatform.comapi.map.i;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class FavoriteManager {
    public static /* synthetic */ Interceptable $ic;
    public static FavoriteManager a;

    /* renamed from: b  reason: collision with root package name */
    public static com.baidu.mapsdkplatform.comapi.favrite.a f35731b;
    public transient /* synthetic */ FieldHolder $fh;

    public FavoriteManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static FavoriteManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                a = new FavoriteManager();
            }
            return a;
        }
        return (FavoriteManager) invokeV.objValue;
    }

    public int add(FavoritePoiInfo favoritePoiInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, favoritePoiInfo)) == null) {
            if (f35731b == null || favoritePoiInfo == null || favoritePoiInfo.f35733c == null) {
                return 0;
            }
            String str = favoritePoiInfo.f35732b;
            if (str == null || str.equals("")) {
                return -1;
            }
            FavSyncPoi a2 = a.a(favoritePoiInfo);
            int a3 = f35731b.a(a2.f36358b, a2);
            if (a3 == 1) {
                favoritePoiInfo.a = a2.a;
                favoritePoiInfo.f35737g = Long.parseLong(a2.f36364h);
            }
            return a3;
        }
        return invokeL.intValue;
    }

    public boolean clearAllFavPois() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            com.baidu.mapsdkplatform.comapi.favrite.a aVar = f35731b;
            if (aVar == null) {
                return false;
            }
            return aVar.c();
        }
        return invokeV.booleanValue;
    }

    public boolean deleteFavPoi(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (f35731b == null || str == null || str.equals("")) {
                return false;
            }
            return f35731b.a(str);
        }
        return invokeL.booleanValue;
    }

    public void destroy() {
        com.baidu.mapsdkplatform.comapi.favrite.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = f35731b) == null) {
            return;
        }
        aVar.b();
        f35731b = null;
        BMapManager.destroy();
        i.b();
    }

    public List<FavoritePoiInfo> getAllFavPois() {
        InterceptResult invokeV;
        String f2;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            com.baidu.mapsdkplatform.comapi.favrite.a aVar = f35731b;
            if (aVar != null && (f2 = aVar.f()) != null && !f2.equals("")) {
                try {
                    JSONObject jSONObject = new JSONObject(f2);
                    if (jSONObject.optInt("favpoinum") != 0 && (optJSONArray = jSONObject.optJSONArray("favcontents")) != null && optJSONArray.length() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                            if (jSONObject2 != null) {
                                arrayList.add(a.a(jSONObject2));
                            }
                        }
                        return arrayList;
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public FavoritePoiInfo getFavPoi(String str) {
        InterceptResult invokeL;
        FavSyncPoi b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (f35731b == null || str == null || str.equals("") || (b2 = f35731b.b(str)) == null) {
                return null;
            }
            return a.a(b2);
        }
        return (FavoritePoiInfo) invokeL.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && f35731b == null) {
            i.a();
            BMapManager.init();
            f35731b = com.baidu.mapsdkplatform.comapi.favrite.a.a();
        }
    }

    public boolean updateFavPoi(String str, FavoritePoiInfo favoritePoiInfo) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, favoritePoiInfo)) == null) {
            if (f35731b == null || str == null || str.equals("") || favoritePoiInfo == null || favoritePoiInfo == null || favoritePoiInfo.f35733c == null || (str2 = favoritePoiInfo.f35732b) == null || str2.equals("")) {
                return false;
            }
            favoritePoiInfo.a = str;
            return f35731b.b(str, a.a(favoritePoiInfo));
        }
        return invokeLL.booleanValue;
    }
}
