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
/* loaded from: classes4.dex */
public class MKOfflineMap {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_DOWNLOAD_UPDATE = 0;
    public static final int TYPE_NETWORK_ERROR = 2;
    public static final int TYPE_NEW_OFFLINE = 6;
    public static final int TYPE_VER_UPDATE = 4;
    public static final String a = "MKOfflineMap";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public r f26342b;

    /* renamed from: c  reason: collision with root package name */
    public MKOfflineMapListener f26343c;

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
            this.f26342b.d(0);
            this.f26342b.b((v) null);
            this.f26342b.b();
            i.b();
        }
    }

    public ArrayList<MKOLUpdateElement> getAllUpdateInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<u> e2 = this.f26342b.e();
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
            ArrayList<q> c2 = this.f26342b.c();
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
            ArrayList<q> d2 = this.f26342b.d();
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

    public MKOLUpdateElement getUpdateInfo(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            u g2 = this.f26342b.g(i);
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
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            ArrayList<u> e2 = this.f26342b.e();
            int i2 = 0;
            if (e2 != null) {
                i2 = e2.size();
                i = i2;
            } else {
                i = 0;
            }
            this.f26342b.a(z, true);
            ArrayList<u> e3 = this.f26342b.e();
            if (e3 != null) {
                i = e3.size();
            }
            return i - i2;
        }
        return invokeZ.intValue;
    }

    public boolean init(MKOfflineMapListener mKOfflineMapListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, mKOfflineMapListener)) == null) {
            i.a();
            r a2 = r.a();
            this.f26342b = a2;
            if (a2 == null) {
                return false;
            }
            a2.a(new a(this));
            this.f26343c = mKOfflineMapListener;
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean pause(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? this.f26342b.c(i) : invokeI.booleanValue;
    }

    public boolean remove(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? this.f26342b.e(i) : invokeI.booleanValue;
    }

    public ArrayList<MKOLSearchRecord> searchCity(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            ArrayList<q> a2 = this.f26342b.a(str);
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

    public boolean start(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            r rVar = this.f26342b;
            if (rVar == null) {
                return false;
            }
            if (rVar.e() != null) {
                Iterator<u> it = this.f26342b.e().iterator();
                while (it.hasNext()) {
                    t tVar = it.next().a;
                    if (tVar.a == i) {
                        if (tVar.j || (i2 = tVar.l) == 2 || i2 == 3 || i2 == 6) {
                            return this.f26342b.b(i);
                        }
                        return false;
                    }
                }
            }
            return this.f26342b.a(i);
        }
        return invokeI.booleanValue;
    }

    public boolean update(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            r rVar = this.f26342b;
            if (rVar != null && rVar.e() != null) {
                Iterator<u> it = this.f26342b.e().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    t tVar = it.next().a;
                    if (tVar.a == i) {
                        if (tVar.j) {
                            return this.f26342b.f(i);
                        }
                    }
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }
}
