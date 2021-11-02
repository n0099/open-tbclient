package b.a.r0.k1;

import GetSugTopic.TopicList;
import GetSugTopic.TopicListModule;
import b.a.e.e.p.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f18615a;

    /* renamed from: b  reason: collision with root package name */
    public int f18616b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f18617c;

    /* renamed from: d  reason: collision with root package name */
    public List<f> f18618d;

    public c() {
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
        this.f18616b = -1;
        this.f18617c = new ArrayList();
        this.f18618d = new ArrayList();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18615a : (String) invokeV.objValue;
    }

    public List<d> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18617c : (List) invokeV.objValue;
    }

    public List<f> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18618d : (List) invokeV.objValue;
    }

    public void d(TopicListModule topicListModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, topicListModule) == null) || topicListModule == null) {
            return;
        }
        this.f18615a = topicListModule.module_title;
        List<TopicList> list = topicListModule.topic_list;
        if (list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        for (int i2 = 0; i2 < count; i2++) {
            d dVar = new d();
            TopicList topicList = (TopicList) ListUtils.getItem(topicListModule.topic_list, i2);
            if (topicList != null) {
                dVar.c(topicList);
                if (!k.isEmptyStringAfterTrim(dVar.b())) {
                    this.f18617c.add(dVar);
                    this.f18618d.add(new f(topicList));
                }
            }
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f18615a = str;
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f18616b = i2;
        }
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f18616b : invokeV.intValue;
    }
}
