package c.a.q0.a0.d0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class g implements c.a.q0.g1.b.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f15255a;

    /* renamed from: b  reason: collision with root package name */
    public String f15256b;

    /* renamed from: c  reason: collision with root package name */
    public String f15257c;

    /* renamed from: d  reason: collision with root package name */
    public long f15258d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f15259e;

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
            if (obj instanceof c.a.p0.d1.g.a) {
                c.a.p0.d1.g.a aVar = (c.a.p0.d1.g.a) obj;
                return aVar.f13120d == this.f15258d && aVar.f13119c.equals(this.f15257c) && aVar.f13118b.equals(this.f15256b) && aVar.f13121e == this.f15259e && aVar.f13117a == this.f15255a;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "[HotForumInfoData:rank=" + this.f15255a + ",forumAvatar=" + this.f15256b + ",forumName=" + this.f15257c + ",forumId=" + this.f15258d + ",isLiked=" + this.f15259e + "," + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
