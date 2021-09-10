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
    public String[] f31269e;

    /* renamed from: f  reason: collision with root package name */
    public String f31270f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f31271g;

    /* renamed from: h  reason: collision with root package name */
    public String f31272h;

    /* renamed from: i  reason: collision with root package name */
    public C1441a f31273i;

    /* renamed from: j  reason: collision with root package name */
    public b f31274j;

    /* renamed from: c.a.z.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1441a implements Cloneable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f31275e;

        /* renamed from: f  reason: collision with root package name */
        public float f31276f;

        /* renamed from: g  reason: collision with root package name */
        public float f31277g;

        /* renamed from: h  reason: collision with root package name */
        public int f31278h;

        /* renamed from: i  reason: collision with root package name */
        public String f31279i;

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
            this.f31275e = 0;
            this.f31276f = 0.0f;
            this.f31277g = 0.0f;
            this.f31278h = 0;
            this.f31279i = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: d */
        public C1441a clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                C1441a c1441a = (C1441a) super.clone();
                c1441a.f31275e = this.f31275e;
                c1441a.f31276f = this.f31276f;
                c1441a.f31277g = this.f31277g;
                c1441a.f31278h = this.f31278h;
                c1441a.f31279i = new String(this.f31279i);
                return c1441a;
            }
            return (C1441a) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.f31275e;
                if (i2 < 0 || i2 > 1) {
                    return false;
                }
                float f2 = this.f31276f;
                if (f2 < 0.0f || f2 > 16.0f) {
                    return false;
                }
                float f3 = this.f31277g;
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
        public int f31280e;

        /* renamed from: f  reason: collision with root package name */
        public int f31281f;

        /* renamed from: g  reason: collision with root package name */
        public int f31282g;

        /* renamed from: h  reason: collision with root package name */
        public int f31283h;

        /* renamed from: i  reason: collision with root package name */
        public float f31284i;

        /* renamed from: j  reason: collision with root package name */
        public float f31285j;
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
            this.f31283h = 0;
            this.f31284i = 0.0f;
            this.f31285j = 0.0f;
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
                bVar.f31280e = this.f31280e;
                bVar.f31281f = this.f31281f;
                bVar.f31282g = this.f31282g;
                bVar.f31283h = this.f31283h;
                bVar.f31284i = this.f31284i;
                bVar.f31285j = this.f31285j;
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
        this.f31270f = null;
        this.f31271g = false;
        this.f31272h = null;
        this.f31273i = new C1441a();
        this.f31274j = new b();
        this.f31272h = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: d */
    public a clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = (a) super.clone();
            String[] strArr = this.f31269e;
            aVar.f31269e = strArr != null ? (String[]) strArr.clone() : null;
            aVar.f31270f = new String(this.f31270f);
            aVar.f31271g = this.f31271g;
            aVar.f31273i = this.f31273i.clone();
            aVar.f31274j = this.f31274j.clone();
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            C1441a c1441a = this.f31273i;
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
            sb.append(this.f31272h);
            sb.append(" Player Server config information====================== \n");
            sb.append("host : \n");
            int i2 = 0;
            while (true) {
                String[] strArr = this.f31269e;
                if (strArr == null || i2 >= strArr.length) {
                    break;
                }
                sb.append("    " + this.f31269e[i2] + StringUtils.LF);
                i2++;
            }
            sb.append("cntlId : \n    " + this.f31270f + ";\n");
            sb.append("pcdnSwitch : \n    " + this.f31271g + ";\n");
            sb.append("CdnConfig : \n    ");
            sb.append("key : " + this.f31273i.f31279i + ", level : " + this.f31273i.f31278h + ", sle : " + this.f31273i.f31275e + ", sl_rate : " + this.f31273i.f31276f + ", split_rate : " + this.f31273i.f31277g + ";\n");
            sb.append("PrefetchConfig : \n    ");
            sb.append("duration : " + this.f31274j.f31280e + " pcdnEnable : " + this.f31274j.f31281f + " p2pEnable : " + this.f31274j.f31282g + " key : " + this.f31274j.l + " level : " + this.f31274j.k + " sl : " + this.f31274j.f31283h + " sle : " + this.f31274j.f31284i + " split_rate : " + this.f31274j.f31285j + ";\n");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
