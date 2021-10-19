package c.a.r0.b0.e0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class g implements c.a.r0.i1.b.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f15731a;

    /* renamed from: b  reason: collision with root package name */
    public String f15732b;

    /* renamed from: c  reason: collision with root package name */
    public String f15733c;

    /* renamed from: d  reason: collision with root package name */
    public long f15734d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f15735e;

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
                return aVar.f13175d == this.f15734d && aVar.f13174c.equals(this.f15733c) && aVar.f13173b.equals(this.f15732b) && aVar.f13176e == this.f15735e && aVar.f13172a == this.f15731a;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "[HotForumInfoData:rank=" + this.f15731a + ",forumAvatar=" + this.f15732b + ",forumName=" + this.f15733c + ",forumId=" + this.f15734d + ",isLiked=" + this.f15735e + "," + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
