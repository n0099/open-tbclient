package c.a.p0.a0.d0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class g implements c.a.p0.g1.b.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f14969a;

    /* renamed from: b  reason: collision with root package name */
    public String f14970b;

    /* renamed from: c  reason: collision with root package name */
    public String f14971c;

    /* renamed from: d  reason: collision with root package name */
    public long f14972d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14973e;

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
            if (obj instanceof c.a.o0.d1.g.a) {
                c.a.o0.d1.g.a aVar = (c.a.o0.d1.g.a) obj;
                return aVar.f12839d == this.f14972d && aVar.f12838c.equals(this.f14971c) && aVar.f12837b.equals(this.f14970b) && aVar.f12840e == this.f14973e && aVar.f12836a == this.f14969a;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "[HotForumInfoData:rank=" + this.f14969a + ",forumAvatar=" + this.f14970b + ",forumName=" + this.f14971c + ",forumId=" + this.f14972d + ",isLiked=" + this.f14973e + "," + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
