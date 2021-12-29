package c.a.t0.b2;

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
/* loaded from: classes6.dex */
public class a implements c.a.d.f.i.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static a f15580k;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f15581b;

    /* renamed from: c  reason: collision with root package name */
    public String f15582c;

    /* renamed from: d  reason: collision with root package name */
    public a.d f15583d;

    /* renamed from: e  reason: collision with root package name */
    public b f15584e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f15585f;

    /* renamed from: g  reason: collision with root package name */
    public LocationClientOption f15586g;

    /* renamed from: h  reason: collision with root package name */
    public Address f15587h;

    /* renamed from: i  reason: collision with root package name */
    public long f15588i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f15589j;

    /* renamed from: c.a.t0.b2.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0961a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0961a(int i2) {
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

    /* loaded from: classes6.dex */
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
                this.a.f15587h = new Address(Locale.getDefault());
                this.a.f15587h.setLatitude(bDLocation.getLatitude());
                this.a.f15587h.setLongitude(bDLocation.getLongitude());
                c.a.s0.s.g0.b j2 = c.a.s0.s.g0.b.j();
                j2.x("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + "," + bDLocation.getLongitude());
                this.a.f15587h.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                bundle.putDouble("altitude", bDLocation.getAltitude());
                bundle.putFloat("speed", bDLocation.getSpeed());
                bundle.putString("cityCode", bDLocation.getCityCode());
                bundle.putString("street", bDLocation.getStreet());
                bundle.putString("streetNumber", bDLocation.getStreetNumber());
                bundle.putString("province", bDLocation.getProvince());
                this.a.f15587h.setExtras(bundle);
                this.a.f15588i = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    this.a.f15587h.setAddressLine(0, stringBuffer.toString());
                }
                if (this.a.f15583d != null) {
                    this.a.f15583d.a(0, "", this.a.f15587h, this.a.f15588i, this.a.f15589j);
                    c.a.t0.j3.j0.a.e().i(String.valueOf(this.a.f15587h.getLatitude()));
                    c.a.t0.j3.j0.a.e().j(String.valueOf(this.a.f15587h.getLongitude()));
                    c.a.t0.j3.j0.a.e().k(System.currentTimeMillis());
                }
            }
        }

        public /* synthetic */ b(a aVar, C0961a c0961a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(970825260, "Lc/a/t0/b2/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(970825260, "Lc/a/t0/b2/a;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new C0961a(2001330));
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
        this.f15581b = true;
        this.f15582c = "";
        this.f15583d = null;
        this.f15588i = 0L;
        this.f15589j = false;
    }

    public static a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (f15580k == null) {
                synchronized (a.class) {
                    if (f15580k == null) {
                        f15580k = new a();
                    }
                }
            }
            return f15580k;
        }
        return (a) invokeV.objValue;
    }

    @Override // c.a.d.f.i.b
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if ((!ApiUtil.shouldCheckPermission() || PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.f15581b && this.f15585f != null) {
                try {
                    this.f15589j = z;
                    if (z) {
                        this.f15586g.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                    }
                    this.f15585f.setLocOption(this.f15586g);
                    if (!this.f15585f.isStarted()) {
                        this.f15585f.start();
                    }
                    this.f15585f.requestLocation();
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    c();
                    a.d dVar = this.f15583d;
                    if (dVar != null) {
                        dVar.a(5, "", this.f15587h, this.f15588i, this.f15589j);
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
            this.f15583d = dVar;
            this.f15582c = "baidu";
            if (this.f15581b) {
                try {
                    this.f15585f = new LocationClient(context);
                    LocationClientOption locationClientOption = new LocationClientOption();
                    this.f15586g = locationClientOption;
                    locationClientOption.setOpenGps(true);
                    this.f15586g.setIgnoreKillProcess(true);
                    this.f15586g.setProdName(this.f15582c);
                    this.f15586g.setAddrType("all");
                    this.f15586g.setCoorType("bd09ll");
                    b bVar = new b(this, null);
                    this.f15584e = bVar;
                    this.f15585f.registerLocationListener(bVar);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (locationClient = this.f15585f) != null && locationClient.isStarted()) {
            try {
                this.f15585f.stop();
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
