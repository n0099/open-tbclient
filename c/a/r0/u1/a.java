package c.a.r0.u1;

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
    public Context f25139a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f25140b;

    /* renamed from: c  reason: collision with root package name */
    public String f25141c;

    /* renamed from: d  reason: collision with root package name */
    public a.d f25142d;

    /* renamed from: e  reason: collision with root package name */
    public b f25143e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f25144f;

    /* renamed from: g  reason: collision with root package name */
    public LocationClientOption f25145g;

    /* renamed from: h  reason: collision with root package name */
    public Address f25146h;

    /* renamed from: i  reason: collision with root package name */
    public long f25147i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f25148j;

    /* renamed from: c.a.r0.u1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1166a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1166a(int i2) {
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
        public final /* synthetic */ a f25149a;

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
            this.f25149a = aVar;
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
                if ((ApiUtil.shouldCheckPermission() && !PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) || bDLocation == null || bDLocation.getLocType() == 62 || bDLocation.getLocType() == 63 || bDLocation.getLocType() == 67 || bDLocation.getLocType() == 68 || bDLocation.getLocType() > 161) {
                    return;
                }
                this.f25149a.c();
                this.f25149a.f25146h = new Address(Locale.getDefault());
                this.f25149a.f25146h.setLatitude(bDLocation.getLatitude());
                this.f25149a.f25146h.setLongitude(bDLocation.getLongitude());
                c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
                j2.x("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + "," + bDLocation.getLongitude());
                this.f25149a.f25146h.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                bundle.putDouble("altitude", bDLocation.getAltitude());
                bundle.putFloat("speed", bDLocation.getSpeed());
                bundle.putString("cityCode", bDLocation.getCityCode());
                bundle.putString("street", bDLocation.getStreet());
                bundle.putString("streetNumber", bDLocation.getStreetNumber());
                bundle.putString("province", bDLocation.getProvince());
                this.f25149a.f25146h.setExtras(bundle);
                this.f25149a.f25147i = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    this.f25149a.f25146h.setAddressLine(0, stringBuffer.toString());
                }
                if (this.f25149a.f25142d != null) {
                    this.f25149a.f25142d.a(0, "", this.f25149a.f25146h, this.f25149a.f25147i, this.f25149a.f25148j);
                    c.a.r0.z2.j0.a.e().i(String.valueOf(this.f25149a.f25146h.getLatitude()));
                    c.a.r0.z2.j0.a.e().j(String.valueOf(this.f25149a.f25146h.getLongitude()));
                    c.a.r0.z2.j0.a.e().k(System.currentTimeMillis());
                }
            }
        }

        public /* synthetic */ b(a aVar, C1166a c1166a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1797688994, "Lc/a/r0/u1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1797688994, "Lc/a/r0/u1/a;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new C1166a(2001330));
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
        this.f25140b = true;
        this.f25141c = "";
        this.f25142d = null;
        this.f25147i = 0L;
        this.f25148j = false;
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
            if ((!ApiUtil.shouldCheckPermission() || PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.f25140b && this.f25144f != null) {
                try {
                    this.f25148j = z;
                    if (z) {
                        this.f25145g.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                    }
                    this.f25144f.setLocOption(this.f25145g);
                    if (!this.f25144f.isStarted()) {
                        this.f25144f.start();
                    }
                    this.f25144f.requestLocation();
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    c();
                    a.d dVar = this.f25142d;
                    if (dVar != null) {
                        dVar.a(5, "", this.f25146h, this.f25147i, this.f25148j);
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
            this.f25139a = context;
            this.f25142d = dVar;
            this.f25141c = PathUtils.DIRCTORY_BAIDU;
            if (this.f25140b) {
                try {
                    this.f25144f = new LocationClient(context);
                    LocationClientOption locationClientOption = new LocationClientOption();
                    this.f25145g = locationClientOption;
                    locationClientOption.setOpenGps(true);
                    this.f25145g.setIgnoreKillProcess(true);
                    this.f25145g.setProdName(this.f25141c);
                    this.f25145g.setAddrType("all");
                    this.f25145g.setCoorType("bd09ll");
                    b bVar = new b(this, null);
                    this.f25143e = bVar;
                    this.f25144f.registerLocationListener(bVar);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (locationClient = this.f25144f) != null && locationClient.isStarted()) {
            try {
                this.f25144f.stop();
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
