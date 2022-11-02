package com.baidu.mapapi.map.offline;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.j;
import com.baidu.mapsdkplatform.comapi.map.n;
import com.baidu.mapsdkplatform.comapi.map.o;
import com.baidu.mapsdkplatform.comapi.map.q;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class MKOfflineMap {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_DOWNLOAD_UPDATE = 0;
    public static final int TYPE_NETWORK_ERROR = 2;
    public static final int TYPE_NEW_OFFLINE = 6;
    public static final int TYPE_VER_UPDATE = 4;
    public static final String a = "MKOfflineMap";
    public transient /* synthetic */ FieldHolder $fh;
    public o b;
    public MKOfflineMapListener c;

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.d(0);
            this.b.b((s) null);
            this.b.b();
            j.b();
        }
    }

    @Deprecated
    public int importOfflineData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return importOfflineData(false);
        }
        return invokeV.intValue;
    }

    public MKOLUpdateElement getUpdateInfo(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            r g = this.b.g(i);
            if (g == null) {
                return null;
            }
            return OfflineMapUtil.getUpdatElementFromLocalMapElement(g.a());
        }
        return (MKOLUpdateElement) invokeI.objValue;
    }

    public boolean init(MKOfflineMapListener mKOfflineMapListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, mKOfflineMapListener)) == null) {
            j.a();
            o a2 = o.a();
            this.b = a2;
            if (a2 == null) {
                return false;
            }
            a2.a(new a(this));
            this.c = mKOfflineMapListener;
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean pause(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return this.b.c(i);
        }
        return invokeI.booleanValue;
    }

    public boolean remove(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            return this.b.e(i);
        }
        return invokeI.booleanValue;
    }

    public ArrayList<MKOLUpdateElement> getAllUpdateInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<r> e = this.b.e();
            if (e == null) {
                return null;
            }
            ArrayList<MKOLUpdateElement> arrayList = new ArrayList<>();
            Iterator<r> it = e.iterator();
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
            ArrayList<n> c = this.b.c();
            if (c == null) {
                return null;
            }
            ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
            Iterator<n> it = c.iterator();
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
            ArrayList<n> d = this.b.d();
            if (d == null) {
                return null;
            }
            ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
            Iterator<n> it = d.iterator();
            while (it.hasNext()) {
                arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Deprecated
    public int importOfflineData(boolean z) {
        InterceptResult invokeZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            ArrayList<r> e = this.b.e();
            int i2 = 0;
            if (e != null) {
                i2 = e.size();
                i = i2;
            } else {
                i = 0;
            }
            this.b.a(z, true);
            ArrayList<r> e2 = this.b.e();
            if (e2 != null) {
                i = e2.size();
            }
            return i - i2;
        }
        return invokeZ.intValue;
    }

    public ArrayList<MKOLSearchRecord> searchCity(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            ArrayList<n> a2 = this.b.a(str);
            if (a2 == null) {
                return null;
            }
            ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
            Iterator<n> it = a2.iterator();
            while (it.hasNext()) {
                arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public boolean update(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            o oVar = this.b;
            if (oVar != null && oVar.e() != null) {
                Iterator<r> it = this.b.e().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    q qVar = it.next().a;
                    if (qVar.a == i) {
                        if (qVar.j) {
                            return this.b.f(i);
                        }
                    }
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean start(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            o oVar = this.b;
            if (oVar == null) {
                return false;
            }
            if (oVar.e() != null) {
                Iterator<r> it = this.b.e().iterator();
                while (it.hasNext()) {
                    q qVar = it.next().a;
                    if (qVar.a == i) {
                        if (!qVar.j && (i2 = qVar.l) != 2 && i2 != 3 && i2 != 6) {
                            return false;
                        }
                        return this.b.b(i);
                    }
                }
            }
            return this.b.a(i);
        }
        return invokeI.booleanValue;
    }
}
