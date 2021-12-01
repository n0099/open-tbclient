package c.a.r0.a2;

import android.content.Context;
import android.location.Address;
import android.os.Bundle;
import c.a.d.f.i.a;
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
public class a implements c.a.d.f.i.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static a f14581k;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f14582b;

    /* renamed from: c  reason: collision with root package name */
    public String f14583c;

    /* renamed from: d  reason: collision with root package name */
    public a.d f14584d;

    /* renamed from: e  reason: collision with root package name */
    public b f14585e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f14586f;

    /* renamed from: g  reason: collision with root package name */
    public LocationClientOption f14587g;

    /* renamed from: h  reason: collision with root package name */
    public Address f14588h;

    /* renamed from: i  reason: collision with root package name */
    public long f14589i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f14590j;

    /* renamed from: c.a.r0.a2.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0884a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0884a(int i2) {
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
                        c.a.d.f.i.a.n().r(a.j());
                    } else {
                        c.a.d.f.i.a.n().v(a.j());
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BDLocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
                if ((ApiUtil.shouldCheckPermission() && !PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) || bDLocation == null || bDLocation.getLocType() == 62 || bDLocation.getLocType() == 63 || bDLocation.getLocType() == 67 || bDLocation.getLocType() == 68 || bDLocation.getLocType() > 161) {
                    return;
                }
                this.a.c();
                this.a.f14588h = new Address(Locale.getDefault());
                this.a.f14588h.setLatitude(bDLocation.getLatitude());
                this.a.f14588h.setLongitude(bDLocation.getLongitude());
                c.a.q0.s.e0.b j2 = c.a.q0.s.e0.b.j();
                j2.x("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + "," + bDLocation.getLongitude());
                this.a.f14588h.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                bundle.putDouble("altitude", bDLocation.getAltitude());
                bundle.putFloat("speed", bDLocation.getSpeed());
                bundle.putString("cityCode", bDLocation.getCityCode());
                bundle.putString("street", bDLocation.getStreet());
                bundle.putString("streetNumber", bDLocation.getStreetNumber());
                bundle.putString("province", bDLocation.getProvince());
                this.a.f14588h.setExtras(bundle);
                this.a.f14589i = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    this.a.f14588h.setAddressLine(0, stringBuffer.toString());
                }
                if (this.a.f14584d != null) {
                    this.a.f14584d.a(0, "", this.a.f14588h, this.a.f14589i, this.a.f14590j);
                    c.a.r0.h3.j0.a.e().i(String.valueOf(this.a.f14588h.getLatitude()));
                    c.a.r0.h3.j0.a.e().j(String.valueOf(this.a.f14588h.getLongitude()));
                    c.a.r0.h3.j0.a.e().k(System.currentTimeMillis());
                }
            }
        }

        public /* synthetic */ b(a aVar, C0884a c0884a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1779248365, "Lc/a/r0/a2/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1779248365, "Lc/a/r0/a2/a;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new C0884a(2001330));
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
        this.f14582b = true;
        this.f14583c = "";
        this.f14584d = null;
        this.f14589i = 0L;
        this.f14590j = false;
    }

    public static a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (f14581k == null) {
                synchronized (a.class) {
                    if (f14581k == null) {
                        f14581k = new a();
                    }
                }
            }
            return f14581k;
        }
        return (a) invokeV.objValue;
    }

    @Override // c.a.d.f.i.b
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if ((!ApiUtil.shouldCheckPermission() || PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.f14582b && this.f14586f != null) {
                try {
                    this.f14590j = z;
                    if (z) {
                        this.f14587g.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                    }
                    this.f14586f.setLocOption(this.f14587g);
                    if (!this.f14586f.isStarted()) {
                        this.f14586f.start();
                    }
                    this.f14586f.requestLocation();
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    c();
                    a.d dVar = this.f14584d;
                    if (dVar != null) {
                        dVar.a(5, "", this.f14588h, this.f14589i, this.f14590j);
                    }
                }
            }
        }
    }

    @Override // c.a.d.f.i.b
    public void b(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            this.a = context;
            this.f14584d = dVar;
            this.f14583c = "baidu";
            if (this.f14582b) {
                try {
                    this.f14586f = new LocationClient(context);
                    LocationClientOption locationClientOption = new LocationClientOption();
                    this.f14587g = locationClientOption;
                    locationClientOption.setOpenGps(true);
                    this.f14587g.setIgnoreKillProcess(true);
                    this.f14587g.setProdName(this.f14583c);
                    this.f14587g.setAddrType("all");
                    this.f14587g.setCoorType("bd09ll");
                    b bVar = new b(this, null);
                    this.f14585e = bVar;
                    this.f14586f.registerLocationListener(bVar);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    @Override // c.a.d.f.i.b
    public void c() {
        LocationClient locationClient;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (locationClient = this.f14586f) != null && locationClient.isStarted()) {
            try {
                this.f14586f.stop();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // c.a.d.f.i.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c();
        }
    }
}
