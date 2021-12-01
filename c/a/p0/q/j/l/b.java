package c.a.p0.q.j.l;

import c.a.p0.q.i.g;
import c.a.p0.q.i.h;
import c.a.p0.q.i.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<a> a;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f10776b;

        /* renamed from: c  reason: collision with root package name */
        public int f10777c;

        /* renamed from: d  reason: collision with root package name */
        public g f10778d;

        /* renamed from: e  reason: collision with root package name */
        public List<h> f10779e;

        /* renamed from: f  reason: collision with root package name */
        public List<i> f10780f;

        /* renamed from: g  reason: collision with root package name */
        public PMSAppInfo f10781g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f10782h;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            g gVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (super.equals(obj)) {
                    return true;
                }
                if (obj == null || (gVar = this.f10778d) == null || !(obj instanceof a)) {
                    return false;
                }
                return gVar.equals(((a) obj).f10778d);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                g gVar = this.f10778d;
                if (gVar == null) {
                    return super.hashCode();
                }
                return gVar.hashCode();
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("PMS Item: ");
                sb.append(this.f10776b);
                if (this.f10778d != null) {
                    sb.append(",pkgMain=");
                    sb.append(this.f10778d);
                }
                if (this.f10781g != null) {
                    sb.append(",appInfo=");
                    sb.append(this.f10781g);
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

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
            }
        }
    }
}
