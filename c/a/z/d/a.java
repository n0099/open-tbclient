package c.a.z.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes4.dex */
public class a implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String[] f31290e;

    /* renamed from: f  reason: collision with root package name */
    public String f31291f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f31292g;

    /* renamed from: h  reason: collision with root package name */
    public String f31293h;

    /* renamed from: i  reason: collision with root package name */
    public C1439a f31294i;

    /* renamed from: j  reason: collision with root package name */
    public b f31295j;

    /* renamed from: c.a.z.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1439a implements Cloneable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f31296e;

        /* renamed from: f  reason: collision with root package name */
        public float f31297f;

        /* renamed from: g  reason: collision with root package name */
        public float f31298g;

        /* renamed from: h  reason: collision with root package name */
        public int f31299h;

        /* renamed from: i  reason: collision with root package name */
        public String f31300i;

        public C1439a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31296e = 0;
            this.f31297f = 0.0f;
            this.f31298g = 0.0f;
            this.f31299h = 0;
            this.f31300i = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: d */
        public C1439a clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                C1439a c1439a = (C1439a) super.clone();
                c1439a.f31296e = this.f31296e;
                c1439a.f31297f = this.f31297f;
                c1439a.f31298g = this.f31298g;
                c1439a.f31299h = this.f31299h;
                c1439a.f31300i = new String(this.f31300i);
                return c1439a;
            }
            return (C1439a) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.f31296e;
                if (i2 < 0 || i2 > 1) {
                    return false;
                }
                float f2 = this.f31297f;
                if (f2 < 0.0f || f2 > 16.0f) {
                    return false;
                }
                float f3 = this.f31298g;
                return f3 >= 0.0f && f3 <= 24.0f;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements Cloneable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f31301e;

        /* renamed from: f  reason: collision with root package name */
        public int f31302f;

        /* renamed from: g  reason: collision with root package name */
        public int f31303g;

        /* renamed from: h  reason: collision with root package name */
        public int f31304h;

        /* renamed from: i  reason: collision with root package name */
        public float f31305i;

        /* renamed from: j  reason: collision with root package name */
        public float f31306j;
        public int k;
        public String l;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31304h = 0;
            this.f31305i = 0.0f;
            this.f31306j = 0.0f;
            this.k = 0;
            this.l = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: d */
        public b clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                b bVar = (b) super.clone();
                bVar.f31301e = this.f31301e;
                bVar.f31302f = this.f31302f;
                bVar.f31303g = this.f31303g;
                bVar.f31304h = this.f31304h;
                bVar.f31305i = this.f31305i;
                bVar.f31306j = this.f31306j;
                bVar.k = this.k;
                bVar.l = new String(this.l);
                return bVar;
            }
            return (b) invokeV.objValue;
        }
    }

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31291f = null;
        this.f31292g = false;
        this.f31293h = null;
        this.f31294i = new C1439a();
        this.f31295j = new b();
        this.f31293h = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: d */
    public a clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = (a) super.clone();
            String[] strArr = this.f31290e;
            aVar.f31290e = strArr != null ? (String[]) strArr.clone() : null;
            aVar.f31291f = new String(this.f31291f);
            aVar.f31292g = this.f31292g;
            aVar.f31294i = this.f31294i.clone();
            aVar.f31295j = this.f31295j.clone();
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            C1439a c1439a = this.f31294i;
            return (c1439a != null ? Boolean.valueOf(c1439a.e()) : null).booleanValue();
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n======================");
            sb.append(this.f31293h);
            sb.append(" Player Server config information====================== \n");
            sb.append("host : \n");
            int i2 = 0;
            while (true) {
                String[] strArr = this.f31290e;
                if (strArr == null || i2 >= strArr.length) {
                    break;
                }
                sb.append("    " + this.f31290e[i2] + StringUtils.LF);
                i2++;
            }
            sb.append("cntlId : \n    " + this.f31291f + ";\n");
            sb.append("pcdnSwitch : \n    " + this.f31292g + ";\n");
            sb.append("CdnConfig : \n    ");
            sb.append("key : " + this.f31294i.f31300i + ", level : " + this.f31294i.f31299h + ", sle : " + this.f31294i.f31296e + ", sl_rate : " + this.f31294i.f31297f + ", split_rate : " + this.f31294i.f31298g + ";\n");
            sb.append("PrefetchConfig : \n    ");
            sb.append("duration : " + this.f31295j.f31301e + " pcdnEnable : " + this.f31295j.f31302f + " p2pEnable : " + this.f31295j.f31303g + " key : " + this.f31295j.l + " level : " + this.f31295j.k + " sl : " + this.f31295j.f31304h + " sle : " + this.f31295j.f31305i + " split_rate : " + this.f31295j.f31306j + ";\n");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
