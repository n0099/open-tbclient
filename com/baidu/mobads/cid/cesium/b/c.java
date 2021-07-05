package com.baidu.mobads.cid.cesium.b;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.cid.cesium.b.a;
import com.baidu.mobads.cid.cesium.e.a;
import com.baidu.mobads.cid.cesium.g;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends com.baidu.mobads.cid.cesium.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C0125a f8213d;

    /* renamed from: e  reason: collision with root package name */
    public a f8214e;

    /* loaded from: classes3.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f8215a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.mobads.cid.cesium.f.b f8216b;

        /* renamed from: c  reason: collision with root package name */
        public long f8217c;

        /* renamed from: d  reason: collision with root package name */
        public g.a f8218d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f8219e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f8220f;

        /* renamed from: g  reason: collision with root package name */
        public int f8221g;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8215a = cVar;
            this.f8216b = new com.baidu.mobads.cid.cesium.f.b();
            this.f8220f = true;
        }

        private boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        this.f8217c = jSONObject.getLong("pub_lst_ts");
                        this.f8218d = g.a(jSONObject.getString("pub_info"));
                        this.f8221g = jSONObject.getInt("d_form_ver");
                        this.f8219e = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f8217c : invokeV.longValue;
        }

        public boolean a(PackageInfo packageInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, packageInfo)) == null) {
                String a2 = this.f8215a.f8213d.a(new File(packageInfo.applicationInfo.dataDir)).a("pub.dat", true);
                this.f8220f = false;
                return a(a2);
            }
            return invokeL.booleanValue;
        }

        public g.a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f8218d : (g.a) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f8222a;

        /* renamed from: b  reason: collision with root package name */
        public int f8223b;

        /* renamed from: c  reason: collision with root package name */
        public String f8224c;

        /* renamed from: d  reason: collision with root package name */
        public long f8225d;

        /* renamed from: e  reason: collision with root package name */
        public long f8226e;

        /* renamed from: f  reason: collision with root package name */
        public long f8227f;

        /* renamed from: g  reason: collision with root package name */
        public g.a f8228g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, String str) {
            super(cVar.f8213d, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a.C0125a) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8222a = cVar;
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                a(aVar.b());
                b(aVar.a());
            }
        }

        @Override // com.baidu.mobads.cid.cesium.b.a.b
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                this.f8224c = jSONObject.getString("pkg");
                this.f8226e = jSONObject.getInt("tar_pkg_lst_pub_ts");
                this.f8225d = jSONObject.getLong("last_fe_ts");
                this.f8228g = g.a(jSONObject.getString("info"));
                this.f8227f = jSONObject.getLong("tar_pkg_lst_up_ts");
                this.f8223b = jSONObject.getInt("d_form_ver");
            }
        }

        public boolean a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
                if (this.f8225d != j) {
                    this.f8225d = j;
                    a(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public boolean a(g.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
                if (aVar.equals(this.f8228g)) {
                    return false;
                }
                this.f8228g = aVar;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                if (str.equals(this.f8224c)) {
                    return false;
                }
                this.f8224c = str;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.mobads.cid.cesium.b.a.b
        public void b(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
                jSONObject.put("pkg", this.f8224c);
                jSONObject.put("last_fe_ts", this.f8225d);
                jSONObject.put("tar_pkg_lst_pub_ts", this.f8226e);
                jSONObject.put("info", this.f8228g.b());
                jSONObject.put("tar_pkg_lst_up_ts", this.f8227f);
                jSONObject.put("d_form_ver", 1);
            }
        }

        public boolean b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                if (this.f8226e != j) {
                    this.f8226e = j;
                    a(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f8224c : (String) invokeV.objValue;
        }

        public boolean c(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
                if (this.f8227f != j) {
                    this.f8227f = j;
                    a(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public g.a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f8228g : (g.a) invokeV.objValue;
        }

        public long e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f8227f : invokeV.longValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c() {
        super("isc", 8000000L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], ((Long) objArr[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f8214e = new a(this);
    }

    @Override // com.baidu.mobads.cid.cesium.b.a
    public a.e a(String str, a.d dVar) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        g.a b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, dVar)) == null) {
            b bVar = null;
            try {
                packageInfo = this.f8197a.f8201a.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return a.e.a(-2);
            }
            if (dVar.f8207a) {
                bVar = new b(this, str);
                bVar.a();
                if (str.equals(bVar.c()) && packageInfo.lastUpdateTime == bVar.e()) {
                    b2 = bVar.d();
                    return a.e.a(b2);
                }
            }
            a aVar = new a(this);
            if (aVar.a(packageInfo)) {
                if (dVar.f8207a && bVar != null) {
                    bVar.a(aVar);
                    bVar.a(System.currentTimeMillis());
                    bVar.c(packageInfo.lastUpdateTime);
                    bVar.a(str);
                    bVar.b();
                }
                b2 = aVar.b();
                return a.e.a(b2);
            }
            return a.e.a(-2);
        }
        return (a.e) invokeLL.objValue;
    }

    @Override // com.baidu.mobads.cid.cesium.b.a
    public void a(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f8213d = this.f8198b.a("isc");
        }
    }
}
