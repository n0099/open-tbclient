package c.a.q0.s1;

import android.content.Context;
import android.location.Address;
import android.os.Bundle;
import c.a.e.e.i.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.PathUtils;
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
/* loaded from: classes3.dex */
public class a implements c.a.e.e.i.b {
    public static /* synthetic */ Interceptable $ic;
    public static a k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f24277a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f24278b;

    /* renamed from: c  reason: collision with root package name */
    public String f24279c;

    /* renamed from: d  reason: collision with root package name */
    public a.d f24280d;

    /* renamed from: e  reason: collision with root package name */
    public b f24281e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f24282f;

    /* renamed from: g  reason: collision with root package name */
    public LocationClientOption f24283g;

    /* renamed from: h  reason: collision with root package name */
    public Address f24284h;

    /* renamed from: i  reason: collision with root package name */
    public long f24285i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f24286j;

    /* renamed from: c.a.q0.s1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1121a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1121a(int i2) {
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
                        c.a.e.e.i.a.l().p(a.j());
                    } else {
                        c.a.e.e.i.a.l().t(a.j());
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BDLocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f24287a;

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
            this.f24287a = aVar;
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
                if ((ApiUtil.shouldCheckPermission() && !PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) || bDLocation == null || bDLocation.getLocType() == 62 || bDLocation.getLocType() == 63 || bDLocation.getLocType() == 67 || bDLocation.getLocType() == 68 || bDLocation.getLocType() > 161) {
                    return;
                }
                this.f24287a.c();
                this.f24287a.f24284h = new Address(Locale.getDefault());
                this.f24287a.f24284h.setLatitude(bDLocation.getLatitude());
                this.f24287a.f24284h.setLongitude(bDLocation.getLongitude());
                c.a.p0.s.d0.b j2 = c.a.p0.s.d0.b.j();
                j2.x("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + "," + bDLocation.getLongitude());
                this.f24287a.f24284h.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                bundle.putDouble("altitude", bDLocation.getAltitude());
                bundle.putFloat("speed", bDLocation.getSpeed());
                bundle.putString("cityCode", bDLocation.getCityCode());
                bundle.putString("street", bDLocation.getStreet());
                bundle.putString("streetNumber", bDLocation.getStreetNumber());
                bundle.putString("province", bDLocation.getProvince());
                this.f24287a.f24284h.setExtras(bundle);
                this.f24287a.f24285i = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    this.f24287a.f24284h.setAddressLine(0, stringBuffer.toString());
                }
                if (this.f24287a.f24280d != null) {
                    this.f24287a.f24280d.a(0, "", this.f24287a.f24284h, this.f24287a.f24285i, this.f24287a.f24286j);
                    c.a.q0.x2.j0.a.e().i(String.valueOf(this.f24287a.f24284h.getLatitude()));
                    c.a.q0.x2.j0.a.e().j(String.valueOf(this.f24287a.f24284h.getLongitude()));
                    c.a.q0.x2.j0.a.e().k(System.currentTimeMillis());
                }
            }
        }

        public /* synthetic */ b(a aVar, C1121a c1121a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(53031617, "Lc/a/q0/s1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(53031617, "Lc/a/q0/s1/a;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new C1121a(2001330));
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
        this.f24278b = true;
        this.f24279c = "";
        this.f24280d = null;
        this.f24285i = 0L;
        this.f24286j = false;
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

    @Override // c.a.e.e.i.b
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if ((!ApiUtil.shouldCheckPermission() || PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.f24278b && this.f24282f != null) {
                try {
                    this.f24286j = z;
                    if (z) {
                        this.f24283g.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                    }
                    this.f24282f.setLocOption(this.f24283g);
                    if (!this.f24282f.isStarted()) {
                        this.f24282f.start();
                    }
                    this.f24282f.requestLocation();
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    c();
                    a.d dVar = this.f24280d;
                    if (dVar != null) {
                        dVar.a(5, "", this.f24284h, this.f24285i, this.f24286j);
                    }
                }
            }
        }
    }

    @Override // c.a.e.e.i.b
    public void b(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            this.f24277a = context;
            this.f24280d = dVar;
            this.f24279c = PathUtils.DIRCTORY_BAIDU;
            if (this.f24278b) {
                try {
                    this.f24282f = new LocationClient(context);
                    LocationClientOption locationClientOption = new LocationClientOption();
                    this.f24283g = locationClientOption;
                    locationClientOption.setOpenGps(true);
                    this.f24283g.setIgnoreKillProcess(true);
                    this.f24283g.setProdName(this.f24279c);
                    this.f24283g.setAddrType("all");
                    this.f24283g.setCoorType("bd09ll");
                    b bVar = new b(this, null);
                    this.f24281e = bVar;
                    this.f24282f.registerLocationListener(bVar);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    @Override // c.a.e.e.i.b
    public void c() {
        LocationClient locationClient;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (locationClient = this.f24282f) != null && locationClient.isStarted()) {
            try {
                this.f24282f.stop();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // c.a.e.e.i.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c();
        }
    }
}
