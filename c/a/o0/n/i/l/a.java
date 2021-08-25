package c.a.o0.n.i.l;

import c.a.o0.n.h.f;
import c.a.o0.n.h.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<C0621a> f11927a;

    /* renamed from: c.a.o0.n.i.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0621a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f11928a;

        /* renamed from: b  reason: collision with root package name */
        public String f11929b;

        /* renamed from: c  reason: collision with root package name */
        public int f11930c;

        /* renamed from: d  reason: collision with root package name */
        public f f11931d;

        /* renamed from: e  reason: collision with root package name */
        public List<g> f11932e;

        /* renamed from: f  reason: collision with root package name */
        public PMSAppInfo f11933f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f11934g;

        public C0621a() {
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
            f fVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (super.equals(obj)) {
                    return true;
                }
                if (obj == null || (fVar = this.f11931d) == null || !(obj instanceof C0621a)) {
                    return false;
                }
                return fVar.equals(((C0621a) obj).f11931d);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                f fVar = this.f11931d;
                if (fVar == null) {
                    return super.hashCode();
                }
                return fVar.hashCode();
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("PMS Item: ");
                sb.append(this.f11929b);
                if (this.f11931d != null) {
                    sb.append(",pkgMain=");
                    sb.append(this.f11931d);
                }
                if (this.f11933f != null) {
                    sb.append(",appInfo=");
                    sb.append(this.f11933f);
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

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
}
