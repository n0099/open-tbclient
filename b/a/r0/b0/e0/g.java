package b.a.r0.b0.e0;

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
    public int f14757a;

    /* renamed from: b  reason: collision with root package name */
    public String f14758b;

    /* renamed from: c  reason: collision with root package name */
    public String f14759c;

    /* renamed from: d  reason: collision with root package name */
    public long f14760d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14761e;

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
            if (obj instanceof b.a.q0.f1.g.a) {
                b.a.q0.f1.g.a aVar = (b.a.q0.f1.g.a) obj;
                return aVar.f12327d == this.f14760d && aVar.f12326c.equals(this.f14759c) && aVar.f12325b.equals(this.f14758b) && aVar.f12328e == this.f14761e && aVar.f12324a == this.f14757a;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "[HotForumInfoData:rank=" + this.f14757a + ",forumAvatar=" + this.f14758b + ",forumName=" + this.f14759c + ",forumId=" + this.f14760d + ",isLiked=" + this.f14761e + "," + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
