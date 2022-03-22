package c.a.p0.t1;

import c.a.d.f.p.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetSugTopic.TopicList;
import tbclient.GetSugTopic.TopicListModule;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f18585b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f18586c;

    /* renamed from: d  reason: collision with root package name */
    public List<f> f18587d;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18585b = -1;
        this.f18586c = new ArrayList();
        this.f18587d = new ArrayList();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public List<d> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18586c : (List) invokeV.objValue;
    }

    public List<f> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18587d : (List) invokeV.objValue;
    }

    public void d(TopicListModule topicListModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, topicListModule) == null) || topicListModule == null) {
            return;
        }
        this.a = topicListModule.module_title;
        List<TopicList> list = topicListModule.topic_list;
        if (list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        for (int i = 0; i < count; i++) {
            d dVar = new d();
            TopicList topicList = (TopicList) ListUtils.getItem(topicListModule.topic_list, i);
            if (topicList != null) {
                dVar.c(topicList);
                if (!m.isEmptyStringAfterTrim(dVar.b())) {
                    this.f18586c.add(dVar);
                    this.f18587d.add(new f(topicList));
                }
            }
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.a = str;
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f18585b = i;
        }
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f18585b : invokeV.intValue;
    }
}
