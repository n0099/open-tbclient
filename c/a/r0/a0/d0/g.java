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
    public int f15581a;

    /* renamed from: b  reason: collision with root package name */
    public String f15582b;

    /* renamed from: c  reason: collision with root package name */
    public String f15583c;

    /* renamed from: d  reason: collision with root package name */
    public long f15584d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f15585e;

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
                return aVar.f13170d == this.f15584d && aVar.f13169c.equals(this.f15583c) && aVar.f13168b.equals(this.f15582b) && aVar.f13171e == this.f15585e && aVar.f13167a == this.f15581a;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "[HotForumInfoData:rank=" + this.f15581a + ",forumAvatar=" + this.f15582b + ",forumName=" + this.f15583c + ",forumId=" + this.f15584d + ",isLiked=" + this.f15585e + "," + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
