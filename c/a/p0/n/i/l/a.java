package c.a.p0.n.i.l;

import c.a.p0.n.h.f;
import c.a.p0.n.h.g;
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
    public List<C0623a> f11955a;

    /* renamed from: c.a.p0.n.i.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0623a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f11956a;

        /* renamed from: b  reason: collision with root package name */
        public String f11957b;

        /* renamed from: c  reason: collision with root package name */
        public int f11958c;

        /* renamed from: d  reason: collision with root package name */
        public f f11959d;

        /* renamed from: e  reason: collision with root package name */
        public List<g> f11960e;

        /* renamed from: f  reason: collision with root package name */
        public PMSAppInfo f11961f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f11962g;

        public C0623a() {
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
                if (obj == null || (fVar = this.f11959d) == null || !(obj instanceof C0623a)) {
                    return false;
                }
                return fVar.equals(((C0623a) obj).f11959d);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                f fVar = this.f11959d;
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
                sb.append(this.f11957b);
                if (this.f11959d != null) {
                    sb.append(",pkgMain=");
                    sb.append(this.f11959d);
                }
                if (this.f11961f != null) {
                    sb.append(",appInfo=");
                    sb.append(this.f11961f);
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
