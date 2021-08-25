package c.a.p0.s.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes3.dex */
public class j1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PrivatePopInfo f14278a;

    /* renamed from: b  reason: collision with root package name */
    public PrivateForumInfo f14279b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f14280c;

    public j1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14278a = null;
        this.f14279b = null;
        this.f14280c = null;
    }

    public PrivateForumInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14279b : (PrivateForumInfo) invokeV.objValue;
    }

    public Integer b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14280c : (Integer) invokeV.objValue;
    }

    public PrivatePopInfo c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14278a : (PrivatePopInfo) invokeV.objValue;
    }

    public void d(PrivateForumTotalInfo privateForumTotalInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, privateForumTotalInfo) == null) || privateForumTotalInfo == null) {
            return;
        }
        try {
            PrivateForumShareinfo privateForumShareinfo = privateForumTotalInfo.private_forum_shareinfo;
            this.f14279b = privateForumTotalInfo.private_forum_info;
            this.f14280c = privateForumTotalInfo.private_forum_taskpercent;
            this.f14278a = privateForumTotalInfo.private_forum_popinfo;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
