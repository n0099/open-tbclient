package com.baidu.mapapi.favorite;

import android.util.Log;
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
/* loaded from: classes3.dex */
public class FavoriteManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static FavoriteManager f6825a;

    /* renamed from: b  reason: collision with root package name */
    public static com.baidu.mapsdkplatform.comapi.favrite.a f6826b;
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
            if (f6825a == null) {
                f6825a = new FavoriteManager();
            }
            return f6825a;
        }
        return (FavoriteManager) invokeV.objValue;
    }

    public int add(FavoritePoiInfo favoritePoiInfo) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, favoritePoiInfo)) == null) {
            if (f6826b == null) {
                str = "you may have not call init method!";
            } else if (favoritePoiInfo != null && favoritePoiInfo.f6829c != null) {
                String str2 = favoritePoiInfo.f6828b;
                if (str2 == null || str2.equals("")) {
                    Log.e("baidumapsdk", "poiName can not be null or empty!");
                    return -1;
                }
                FavSyncPoi a2 = a.a(favoritePoiInfo);
                int a3 = f6826b.a(a2.f7608b, a2);
                if (a3 == 1) {
                    favoritePoiInfo.f6827a = a2.f7607a;
                    favoritePoiInfo.f6833g = Long.parseLong(a2.f7614h);
                }
                return a3;
            } else {
                str = "object or pt can not be null!";
            }
            Log.e("baidumapsdk", str);
            return 0;
        }
        return invokeL.intValue;
    }

    public boolean clearAllFavPois() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            com.baidu.mapsdkplatform.comapi.favrite.a aVar = f6826b;
            if (aVar == null) {
                Log.e("baidumapsdk", "you may have not call init method!");
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
            if (f6826b == null) {
                Log.e("baidumapsdk", "you may have not call init method!");
                return false;
            } else if (str == null || str.equals("")) {
                return false;
            } else {
                return f6826b.a(str);
            }
        }
        return invokeL.booleanValue;
    }

    public void destroy() {
        com.baidu.mapsdkplatform.comapi.favrite.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = f6826b) == null) {
            return;
        }
        aVar.b();
        f6826b = null;
        BMapManager.destroy();
        i.b();
    }

    public List<FavoritePoiInfo> getAllFavPois() {
        InterceptResult invokeV;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            com.baidu.mapsdkplatform.comapi.favrite.a aVar = f6826b;
            if (aVar == null) {
                Log.e("baidumapsdk", "you may have not call init method!");
                return null;
            }
            String f2 = aVar.f();
            if (f2 != null && !f2.equals("")) {
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
            if (f6826b == null) {
                Log.e("baidumapsdk", "you may have not call init method!");
                return null;
            } else if (str == null || str.equals("") || (b2 = f6826b.b(str)) == null) {
                return null;
            } else {
                return a.a(b2);
            }
        }
        return (FavoritePoiInfo) invokeL.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && f6826b == null) {
            i.a();
            BMapManager.init();
            f6826b = com.baidu.mapsdkplatform.comapi.favrite.a.a();
        }
    }

    public boolean updateFavPoi(String str, FavoritePoiInfo favoritePoiInfo) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, favoritePoiInfo)) == null) {
            if (f6826b == null) {
                str2 = "you may have not call init method!";
            } else if (str == null || str.equals("") || favoritePoiInfo == null) {
                return false;
            } else {
                if (favoritePoiInfo == null || favoritePoiInfo.f6829c == null) {
                    str2 = "object or pt can not be null!";
                } else {
                    String str3 = favoritePoiInfo.f6828b;
                    if (str3 != null && !str3.equals("")) {
                        favoritePoiInfo.f6827a = str;
                        return f6826b.b(str, a.a(favoritePoiInfo));
                    }
                    str2 = "poiName can not be null or empty!";
                }
            }
            Log.e("baidumapsdk", str2);
            return false;
        }
        return invokeLL.booleanValue;
    }
}
