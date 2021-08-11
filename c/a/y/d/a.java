package c.a.y.d;

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
    public String[] f30821e;

    /* renamed from: f  reason: collision with root package name */
    public String f30822f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f30823g;

    /* renamed from: h  reason: collision with root package name */
    public String f30824h;

    /* renamed from: i  reason: collision with root package name */
    public C1431a f30825i;

    /* renamed from: j  reason: collision with root package name */
    public b f30826j;

    /* renamed from: c.a.y.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1431a implements Cloneable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f30827e;

        /* renamed from: f  reason: collision with root package name */
        public float f30828f;

        /* renamed from: g  reason: collision with root package name */
        public float f30829g;

        public C1431a() {
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
            this.f30827e = 0;
            this.f30828f = 0.0f;
            this.f30829g = 0.0f;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: d */
        public C1431a clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                C1431a c1431a = (C1431a) super.clone();
                c1431a.f30827e = this.f30827e;
                c1431a.f30828f = this.f30828f;
                c1431a.f30829g = this.f30829g;
                return c1431a;
            }
            return (C1431a) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.f30827e;
                if (i2 < 0 || i2 > 1) {
                    return false;
                }
                float f2 = this.f30828f;
                if (f2 < 0.0f || f2 > 16.0f) {
                    return false;
                }
                float f3 = this.f30829g;
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
        public int f30830e;

        /* renamed from: f  reason: collision with root package name */
        public int f30831f;

        /* renamed from: g  reason: collision with root package name */
        public int f30832g;

        /* renamed from: h  reason: collision with root package name */
        public int f30833h;

        /* renamed from: i  reason: collision with root package name */
        public float f30834i;

        /* renamed from: j  reason: collision with root package name */
        public float f30835j;

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
            this.f30833h = 0;
            this.f30834i = 0.0f;
            this.f30835j = 0.0f;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: d */
        public b clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                b bVar = (b) super.clone();
                bVar.f30830e = this.f30830e;
                bVar.f30831f = this.f30831f;
                bVar.f30832g = this.f30832g;
                bVar.f30833h = this.f30833h;
                bVar.f30834i = this.f30834i;
                bVar.f30835j = this.f30835j;
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
        this.f30822f = null;
        this.f30823g = false;
        this.f30824h = null;
        this.f30825i = new C1431a();
        this.f30826j = new b();
        this.f30824h = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: d */
    public a clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = (a) super.clone();
            String[] strArr = this.f30821e;
            aVar.f30821e = strArr != null ? (String[]) strArr.clone() : null;
            aVar.f30822f = new String(this.f30822f);
            aVar.f30823g = this.f30823g;
            aVar.f30825i = this.f30825i.clone();
            aVar.f30826j = this.f30826j.clone();
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            C1431a c1431a = this.f30825i;
            return (c1431a != null ? Boolean.valueOf(c1431a.e()) : null).booleanValue();
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n======================");
            sb.append(this.f30824h);
            sb.append(" Player Server config information====================== \n");
            sb.append("host : \n");
            int i2 = 0;
            while (true) {
                String[] strArr = this.f30821e;
                if (strArr == null || i2 >= strArr.length) {
                    break;
                }
                sb.append("    " + this.f30821e[i2] + StringUtils.LF);
                i2++;
            }
            sb.append("cntlId : \n    " + this.f30822f + ";\n");
            sb.append("pcdnSwitch : \n    " + this.f30823g + ";\n");
            sb.append("CdnConfig : \n    ");
            sb.append("sle : " + this.f30825i.f30827e + ", sl_rate : " + this.f30825i.f30828f + ", split_rate : " + this.f30825i.f30829g + ";\n");
            sb.append("PrefetchConfig : \n    ");
            sb.append("duration : " + this.f30826j.f30830e + " pcdnEnable : " + this.f30826j.f30831f + " p2pEnable : " + this.f30826j.f30832g + " sl : " + this.f30826j.f30833h + " sle : " + this.f30826j.f30834i + " split_rate : " + this.f30826j.f30835j + ";\n");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
