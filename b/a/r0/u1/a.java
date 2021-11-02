package b.a.r0.u1;

import android.content.Context;
import android.location.Address;
import android.os.Bundle;
import b.a.e.e.i.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.permissionhelper.ApiUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes5.dex */
public class a implements b.a.e.e.i.b {
    public static /* synthetic */ Interceptable $ic;
    public static a k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f23983a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23984b;

    /* renamed from: c  reason: collision with root package name */
    public String f23985c;

    /* renamed from: d  reason: collision with root package name */
    public a.d f23986d;

    /* renamed from: e  reason: collision with root package name */
    public b f23987e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f23988f;

    /* renamed from: g  reason: collision with root package name */
    public LocationClientOption f23989g;

    /* renamed from: h  reason: collision with root package name */
    public Address f23990h;

    /* renamed from: i  reason: collision with root package name */
    public long f23991i;
    public boolean j;

    /* renamed from: b.a.r0.u1.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1165a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1165a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                if ((!ApiUtil.shouldCheckPermission() || PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        b.a.e.e.i.a.n().r(a.j());
                    } else {
                        b.a.e.e.i.a.n().v(a.j());
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BDLocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f23992a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23992a = aVar;
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
                if ((ApiUtil.shouldCheckPermission() && !PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) || bDLocation == null || bDLocation.getLocType() == 62 || bDLocation.getLocType() == 63 || bDLocation.getLocType() == 67 || bDLocation.getLocType() == 68 || bDLocation.getLocType() > 161) {
                    return;
                }
                this.f23992a.c();
                this.f23992a.f23990h = new Address(Locale.getDefault());
                this.f23992a.f23990h.setLatitude(bDLocation.getLatitude());
                this.f23992a.f23990h.setLongitude(bDLocation.getLongitude());
                b.a.q0.s.e0.b j = b.a.q0.s.e0.b.j();
                j.x("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + "," + bDLocation.getLongitude());
                this.f23992a.f23990h.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                bundle.putDouble("altitude", bDLocation.getAltitude());
                bundle.putFloat("speed", bDLocation.getSpeed());
                bundle.putString("cityCode", bDLocation.getCityCode());
                bundle.putString("street", bDLocation.getStreet());
                bundle.putString("streetNumber", bDLocation.getStreetNumber());
                bundle.putString("province", bDLocation.getProvince());
                this.f23992a.f23990h.setExtras(bundle);
                this.f23992a.f23991i = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    this.f23992a.f23990h.setAddressLine(0, stringBuffer.toString());
                }
                if (this.f23992a.f23986d != null) {
                    this.f23992a.f23986d.a(0, "", this.f23992a.f23990h, this.f23992a.f23991i, this.f23992a.j);
                    b.a.r0.z2.j0.a.e().i(String.valueOf(this.f23992a.f23990h.getLatitude()));
                    b.a.r0.z2.j0.a.e().j(String.valueOf(this.f23992a.f23990h.getLongitude()));
                    b.a.r0.z2.j0.a.e().k(System.currentTimeMillis());
                }
            }
        }

        public /* synthetic */ b(a aVar, C1165a c1165a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1668606275, "Lb/a/r0/u1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1668606275, "Lb/a/r0/u1/a;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new C1165a(2001330));
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f23984b = true;
        this.f23985c = "";
        this.f23986d = null;
        this.f23991i = 0L;
        this.j = false;
    }

    public static a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (k == null) {
                synchronized (a.class) {
                    if (k == null) {
                        k = new a();
                    }
                }
            }
            return k;
        }
        return (a) invokeV.objValue;
    }

    @Override // b.a.e.e.i.b
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if ((!ApiUtil.shouldCheckPermission() || PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.f23984b && this.f23988f != null) {
                try {
                    this.j = z;
                    if (z) {
                        this.f23989g.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                    }
                    this.f23988f.setLocOption(this.f23989g);
                    if (!this.f23988f.isStarted()) {
                        this.f23988f.start();
                    }
                    this.f23988f.requestLocation();
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    c();
                    a.d dVar = this.f23986d;
                    if (dVar != null) {
                        dVar.a(5, "", this.f23990h, this.f23991i, this.j);
                    }
                }
            }
        }
    }

    @Override // b.a.e.e.i.b
    public void b(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            this.f23983a = context;
            this.f23986d = dVar;
            this.f23985c = "baidu";
            if (this.f23984b) {
                try {
                    this.f23988f = new LocationClient(context);
                    LocationClientOption locationClientOption = new LocationClientOption();
                    this.f23989g = locationClientOption;
                    locationClientOption.setOpenGps(true);
                    this.f23989g.setIgnoreKillProcess(true);
                    this.f23989g.setProdName(this.f23985c);
                    this.f23989g.setAddrType("all");
                    this.f23989g.setCoorType("bd09ll");
                    b bVar = new b(this, null);
                    this.f23987e = bVar;
                    this.f23988f.registerLocationListener(bVar);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    @Override // b.a.e.e.i.b
    public void c() {
        LocationClient locationClient;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (locationClient = this.f23988f) != null && locationClient.isStarted()) {
            try {
                this.f23988f.stop();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // b.a.e.e.i.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c();
        }
    }
}
