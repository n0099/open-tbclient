package c.a.r0.a0.d0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class g implements c.a.r0.h1.b.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f15572a;

    /* renamed from: b  reason: collision with root package name */
    public String f15573b;

    /* renamed from: c  reason: collision with root package name */
    public String f15574c;

    /* renamed from: d  reason: collision with root package name */
    public long f15575d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f15576e;

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
            if (obj instanceof c.a.q0.f1.g.a) {
                c.a.q0.f1.g.a aVar = (c.a.q0.f1.g.a) obj;
                return aVar.f13153d == this.f15575d && aVar.f13152c.equals(this.f15574c) && aVar.f13151b.equals(this.f15573b) && aVar.f13154e == this.f15576e && aVar.f13150a == this.f15572a;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "[HotForumInfoData:rank=" + this.f15572a + ",forumAvatar=" + this.f15573b + ",forumName=" + this.f15574c + ",forumId=" + this.f15575d + ",isLiked=" + this.f15576e + "," + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
