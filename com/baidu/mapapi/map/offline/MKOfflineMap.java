package com.baidu.mapapi.map.offline;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.i;
import com.baidu.mapsdkplatform.comapi.map.q;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mapsdkplatform.comapi.map.t;
import com.baidu.mapsdkplatform.comapi.map.u;
import com.baidu.mapsdkplatform.comapi.map.v;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class MKOfflineMap {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_DOWNLOAD_UPDATE = 0;
    public static final int TYPE_NETWORK_ERROR = 2;
    public static final int TYPE_NEW_OFFLINE = 6;
    public static final int TYPE_VER_UPDATE = 4;
    public static final String a = "MKOfflineMap";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public r f35703b;

    /* renamed from: c  reason: collision with root package name */
    public MKOfflineMapListener f35704c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1464527294, "Lcom/baidu/mapapi/map/offline/MKOfflineMap;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1464527294, "Lcom/baidu/mapapi/map/offline/MKOfflineMap;");
        }
    }

    public MKOfflineMap() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f35703b.d(0);
            this.f35703b.b((v) null);
            this.f35703b.b();
            i.b();
        }
    }

    public ArrayList<MKOLUpdateElement> getAllUpdateInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<u> e2 = this.f35703b.e();
            if (e2 == null) {
                return null;
            }
            ArrayList<MKOLUpdateElement> arrayList = new ArrayList<>();
            Iterator<u> it = e2.iterator();
            while (it.hasNext()) {
                arrayList.add(OfflineMapUtil.getUpdatElementFromLocalMapElement(it.next().a()));
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ArrayList<MKOLSearchRecord> getHotCityList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList<q> c2 = this.f35703b.c();
            if (c2 == null) {
                return null;
            }
            ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
            Iterator<q> it = c2.iterator();
            while (it.hasNext()) {
                arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ArrayList<MKOLSearchRecord> getOfflineCityList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<q> d2 = this.f35703b.d();
            if (d2 == null) {
                return null;
            }
            ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
            Iterator<q> it = d2.iterator();
            while (it.hasNext()) {
                arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public MKOLUpdateElement getUpdateInfo(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            u g2 = this.f35703b.g(i2);
            if (g2 == null) {
                return null;
            }
            return OfflineMapUtil.getUpdatElementFromLocalMapElement(g2.a());
        }
        return (MKOLUpdateElement) invokeI.objValue;
    }

    @Deprecated
    public int importOfflineData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? importOfflineData(false) : invokeV.intValue;
    }

    @Deprecated
    public int importOfflineData(boolean z) {
        InterceptResult invokeZ;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            ArrayList<u> e2 = this.f35703b.e();
            int i3 = 0;
            if (e2 != null) {
                i3 = e2.size();
                i2 = i3;
            } else {
                i2 = 0;
            }
            this.f35703b.a(z, true);
            ArrayList<u> e3 = this.f35703b.e();
            if (e3 != null) {
                i2 = e3.size();
            }
            return i2 - i3;
        }
        return invokeZ.intValue;
    }

    public boolean init(MKOfflineMapListener mKOfflineMapListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, mKOfflineMapListener)) == null) {
            i.a();
            r a2 = r.a();
            this.f35703b = a2;
            if (a2 == null) {
                return false;
            }
            a2.a(new a(this));
            this.f35704c = mKOfflineMapListener;
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean pause(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? this.f35703b.c(i2) : invokeI.booleanValue;
    }

    public boolean remove(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? this.f35703b.e(i2) : invokeI.booleanValue;
    }

    public ArrayList<MKOLSearchRecord> searchCity(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            ArrayList<q> a2 = this.f35703b.a(str);
            if (a2 == null) {
                return null;
            }
            ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
            Iterator<q> it = a2.iterator();
            while (it.hasNext()) {
                arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public boolean start(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            r rVar = this.f35703b;
            if (rVar == null) {
                return false;
            }
            if (rVar.e() != null) {
                Iterator<u> it = this.f35703b.e().iterator();
                while (it.hasNext()) {
                    t tVar = it.next().a;
                    if (tVar.a == i2) {
                        if (tVar.f36153j || (i3 = tVar.l) == 2 || i3 == 3 || i3 == 6) {
                            return this.f35703b.b(i2);
                        }
                        return false;
                    }
                }
            }
            return this.f35703b.a(i2);
        }
        return invokeI.booleanValue;
    }

    public boolean update(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            r rVar = this.f35703b;
            if (rVar != null && rVar.e() != null) {
                Iterator<u> it = this.f35703b.e().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    t tVar = it.next().a;
                    if (tVar.a == i2) {
                        if (tVar.f36153j) {
                            return this.f35703b.f(i2);
                        }
                    }
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }
}
