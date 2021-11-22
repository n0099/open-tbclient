package b.a.r0.b0.f0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g implements b.a.r0.i1.b.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f16244a;

    /* renamed from: b  reason: collision with root package name */
    public String f16245b;

    /* renamed from: c  reason: collision with root package name */
    public String f16246c;

    /* renamed from: d  reason: collision with root package name */
    public long f16247d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16248e;

    public g() {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b.a.q0.e1.g.a) {
                b.a.q0.e1.g.a aVar = (b.a.q0.e1.g.a) obj;
                return aVar.f13035d == this.f16247d && aVar.f13034c.equals(this.f16246c) && aVar.f13033b.equals(this.f16245b) && aVar.f13036e == this.f16248e && aVar.f13032a == this.f16244a;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "[HotForumInfoData:rank=" + this.f16244a + ",forumAvatar=" + this.f16245b + ",forumName=" + this.f16246c + ",forumId=" + this.f16247d + ",isLiked=" + this.f16248e + "," + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
