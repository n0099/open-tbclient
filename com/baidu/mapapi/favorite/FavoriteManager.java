package com.baidu.mapapi.favorite;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import com.baidu.mapsdkplatform.comapi.map.j;
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
/* loaded from: classes2.dex */
public class FavoriteManager {
    public static /* synthetic */ Interceptable $ic;
    public static FavoriteManager a;
    public static com.baidu.mapsdkplatform.comapi.favrite.a b;
    public transient /* synthetic */ FieldHolder $fh;

    public FavoriteManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public boolean clearAllFavPois() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            com.baidu.mapsdkplatform.comapi.favrite.a aVar = b;
            if (aVar == null) {
                Log.e("baidumapsdk", "you may have not call init method!");
                return false;
            }
            return aVar.c();
        }
        return invokeV.booleanValue;
    }

    public void destroy() {
        com.baidu.mapsdkplatform.comapi.favrite.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (aVar = b) != null) {
            aVar.b();
            b = null;
            BMapManager.destroy();
            j.b();
        }
    }

    public void init() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && b == null) {
            j.a();
            BMapManager.init();
            b = com.baidu.mapsdkplatform.comapi.favrite.a.a();
        }
    }

    public int add(FavoritePoiInfo favoritePoiInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, favoritePoiInfo)) == null) {
            if (b == null) {
                Log.e("baidumapsdk", "you may have not call init method!");
                return 0;
            } else if (favoritePoiInfo != null && favoritePoiInfo.c != null) {
                String str = favoritePoiInfo.b;
                if (str != null && !str.equals("")) {
                    FavSyncPoi a2 = a.a(favoritePoiInfo);
                    int a3 = b.a(a2.b, a2);
                    if (a3 == 1) {
                        favoritePoiInfo.a = a2.a;
                        favoritePoiInfo.g = Long.parseLong(a2.h);
                    }
                    return a3;
                }
                Log.e("baidumapsdk", "poiName can not be null or empty!");
                return -1;
            } else {
                Log.e("baidumapsdk", "object or pt can not be null!");
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public boolean deleteFavPoi(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (b == null) {
                Log.e("baidumapsdk", "you may have not call init method!");
                return false;
            } else if (str == null || str.equals("")) {
                return false;
            } else {
                return b.a(str);
            }
        }
        return invokeL.booleanValue;
    }

    public List<FavoritePoiInfo> getAllFavPois() {
        InterceptResult invokeV;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            com.baidu.mapsdkplatform.comapi.favrite.a aVar = b;
            if (aVar == null) {
                Log.e("baidumapsdk", "you may have not call init method!");
                return null;
            }
            String f = aVar.f();
            if (f != null && !f.equals("")) {
                try {
                    JSONObject jSONObject = new JSONObject(f);
                    if (jSONObject.optInt("favpoinum") != 0 && (optJSONArray = jSONObject.optJSONArray("favcontents")) != null && optJSONArray.length() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                            if (jSONObject2 != null) {
                                arrayList.add(a.a(jSONObject2));
                            }
                        }
                        return arrayList;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
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
            if (b == null) {
                Log.e("baidumapsdk", "you may have not call init method!");
                return null;
            } else if (str == null || str.equals("") || (b2 = b.b(str)) == null) {
                return null;
            } else {
                return a.a(b2);
            }
        }
        return (FavoritePoiInfo) invokeL.objValue;
    }

    public boolean updateFavPoi(String str, FavoritePoiInfo favoritePoiInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, favoritePoiInfo)) == null) {
            if (b == null) {
                Log.e("baidumapsdk", "you may have not call init method!");
                return false;
            }
            if (str != null && !str.equals("") && favoritePoiInfo != null) {
                if (favoritePoiInfo != null && favoritePoiInfo.c != null) {
                    String str2 = favoritePoiInfo.b;
                    if (str2 != null && !str2.equals("")) {
                        favoritePoiInfo.a = str;
                        return b.b(str, a.a(favoritePoiInfo));
                    }
                    Log.e("baidumapsdk", "poiName can not be null or empty!");
                    return false;
                }
                Log.e("baidumapsdk", "object or pt can not be null!");
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
