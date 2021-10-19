package c.a.r0.k2.g.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.ExcPbPage.ExcContent;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class a implements c.a.r0.k2.g.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public UserInfo f19727e;

    /* renamed from: f  reason: collision with root package name */
    public ExcellentPbThreadInfo f19728f;

    /* renamed from: g  reason: collision with root package name */
    public List<Post> f19729g;

    /* renamed from: h  reason: collision with root package name */
    public List<User> f19730h;

    public a(UserInfo userInfo, ExcellentPbThreadInfo excellentPbThreadInfo, List<Post> list, List<User> list2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {userInfo, excellentPbThreadInfo, list, list2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19727e = userInfo;
        this.f19728f = excellentPbThreadInfo;
        this.f19729g = list;
        this.f19730h = list2;
    }

    @Override // c.a.r0.k2.g.c.a
    public int getErroCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.k2.g.c.a
    public String getErrorText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.k2.g.c.a
    public List<Post> getPostList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19729g : (List) invokeV.objValue;
    }

    @Override // c.a.r0.k2.g.c.a
    public ExcellentPbThreadInfo getThreadInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19728f : (ExcellentPbThreadInfo) invokeV.objValue;
    }

    @Override // c.a.r0.k2.g.c.a
    public UserInfo getUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19727e : (UserInfo) invokeV.objValue;
    }

    @Override // c.a.r0.k2.g.c.a
    public List<User> getUserList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f19730h : (List) invokeV.objValue;
    }

    @Override // c.a.r0.k2.g.c.a
    public boolean isEmpty() {
        InterceptResult invokeV;
        List<ExcContent> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ExcellentPbThreadInfo excellentPbThreadInfo = this.f19728f;
            return excellentPbThreadInfo == null || (list = excellentPbThreadInfo.content) == null || list.size() <= 0;
        }
        return invokeV.booleanValue;
    }
}
