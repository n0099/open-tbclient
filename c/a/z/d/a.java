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
    public String[] f31162e;

    /* renamed from: f  reason: collision with root package name */
    public String f31163f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f31164g;

    /* renamed from: h  reason: collision with root package name */
    public String f31165h;

    /* renamed from: i  reason: collision with root package name */
    public C1441a f31166i;

    /* renamed from: j  reason: collision with root package name */
    public b f31167j;

    /* renamed from: c.a.z.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1441a implements Cloneable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f31168e;

        /* renamed from: f  reason: collision with root package name */
        public float f31169f;

        /* renamed from: g  reason: collision with root package name */
        public float f31170g;

        public C1441a() {
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
            this.f31168e = 0;
            this.f31169f = 0.0f;
            this.f31170g = 0.0f;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: d */
        public C1441a clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                C1441a c1441a = (C1441a) super.clone();
                c1441a.f31168e = this.f31168e;
                c1441a.f31169f = this.f31169f;
                c1441a.f31170g = this.f31170g;
                return c1441a;
            }
            return (C1441a) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.f31168e;
                if (i2 < 0 || i2 > 1) {
                    return false;
                }
                float f2 = this.f31169f;
                if (f2 < 0.0f || f2 > 16.0f) {
                    return false;
                }
                float f3 = this.f31170g;
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
        public int f31171e;

        /* renamed from: f  reason: collision with root package name */
        public int f31172f;

        /* renamed from: g  reason: collision with root package name */
        public int f31173g;

        /* renamed from: h  reason: collision with root package name */
        public int f31174h;

        /* renamed from: i  reason: collision with root package name */
        public float f31175i;

        /* renamed from: j  reason: collision with root package name */
        public float f31176j;

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
            this.f31174h = 0;
            this.f31175i = 0.0f;
            this.f31176j = 0.0f;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: d */
        public b clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                b bVar = (b) super.clone();
                bVar.f31171e = this.f31171e;
                bVar.f31172f = this.f31172f;
                bVar.f31173g = this.f31173g;
                bVar.f31174h = this.f31174h;
                bVar.f31175i = this.f31175i;
                bVar.f31176j = this.f31176j;
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
        this.f31163f = null;
        this.f31164g = false;
        this.f31165h = null;
        this.f31166i = new C1441a();
        this.f31167j = new b();
        this.f31165h = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: d */
    public a clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = (a) super.clone();
            String[] strArr = this.f31162e;
            aVar.f31162e = strArr != null ? (String[]) strArr.clone() : null;
            aVar.f31163f = new String(this.f31163f);
            aVar.f31164g = this.f31164g;
            aVar.f31166i = this.f31166i.clone();
            aVar.f31167j = this.f31167j.clone();
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            C1441a c1441a = this.f31166i;
            return (c1441a != null ? Boolean.valueOf(c1441a.e()) : null).booleanValue();
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n======================");
            sb.append(this.f31165h);
            sb.append(" Player Server config information====================== \n");
            sb.append("host : \n");
            int i2 = 0;
            while (true) {
                String[] strArr = this.f31162e;
                if (strArr == null || i2 >= strArr.length) {
                    break;
                }
                sb.append("    " + this.f31162e[i2] + StringUtils.LF);
                i2++;
            }
            sb.append("cntlId : \n    " + this.f31163f + ";\n");
            sb.append("pcdnSwitch : \n    " + this.f31164g + ";\n");
            sb.append("CdnConfig : \n    ");
            sb.append("sle : " + this.f31166i.f31168e + ", sl_rate : " + this.f31166i.f31169f + ", split_rate : " + this.f31166i.f31170g + ";\n");
            sb.append("PrefetchConfig : \n    ");
            sb.append("duration : " + this.f31167j.f31171e + " pcdnEnable : " + this.f31167j.f31172f + " p2pEnable : " + this.f31167j.f31173g + " sl : " + this.f31167j.f31174h + " sle : " + this.f31167j.f31175i + " split_rate : " + this.f31167j.f31176j + ";\n");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
