package c.a.r0.j1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes3.dex */
public class b implements c.a.e.l.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final BdUniqueId f19443j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f19444e;

    /* renamed from: f  reason: collision with root package name */
    public long f19445f;

    /* renamed from: g  reason: collision with root package name */
    public String f19446g;

    /* renamed from: h  reason: collision with root package name */
    public String f19447h;

    /* renamed from: i  reason: collision with root package name */
    public String f19448i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-170284510, "Lc/a/r0/j1/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-170284510, "Lc/a/r0/j1/c/b;");
                return;
            }
        }
        f19443j = BdUniqueId.gen();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19445f : invokeV.longValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19444e : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19446g : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19447h : (String) invokeV.objValue;
    }

    @Override // c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? f19443j : (BdUniqueId) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f19448i : (String) invokeV.objValue;
    }

    public void i(TopicList topicList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, topicList) == null) || topicList == null) {
            return;
        }
        this.f19445f = topicList.topic_id.longValue();
        this.f19446g = topicList.topic_name;
        topicList.tag.intValue();
        topicList.discuss_num.longValue();
        this.f19447h = topicList.topic_desc;
        this.f19448i = topicList.topic_pic;
    }

    public void k(TopicListModule topicListModule) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, topicListModule) == null) {
            try {
                this.f19444e = topicListModule.module_title;
                String str = topicListModule.tips;
                String str2 = topicListModule.rule_jump_url;
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
        }
    }
}
