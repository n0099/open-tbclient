package b.a.p0.q.j.l;

import b.a.p0.q.i.g;
import b.a.p0.q.i.h;
import b.a.p0.q.i.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<a> f11846a;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f11847a;

        /* renamed from: b  reason: collision with root package name */
        public String f11848b;

        /* renamed from: c  reason: collision with root package name */
        public int f11849c;

        /* renamed from: d  reason: collision with root package name */
        public g f11850d;

        /* renamed from: e  reason: collision with root package name */
        public List<h> f11851e;

        /* renamed from: f  reason: collision with root package name */
        public List<i> f11852f;

        /* renamed from: g  reason: collision with root package name */
        public PMSAppInfo f11853g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f11854h;

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
                if (obj == null || (gVar = this.f11850d) == null || !(obj instanceof a)) {
                    return false;
                }
                return gVar.equals(((a) obj).f11850d);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                g gVar = this.f11850d;
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
                sb.append(this.f11848b);
                if (this.f11850d != null) {
                    sb.append(",pkgMain=");
                    sb.append(this.f11850d);
                }
                if (this.f11853g != null) {
                    sb.append(",appInfo=");
                    sb.append(this.f11853g);
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
