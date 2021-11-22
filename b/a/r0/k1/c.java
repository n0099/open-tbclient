package b.a.r0.k1;

import GetSugTopic.TopicList;
import GetSugTopic.TopicListModule;
import b.a.e.f.p.k;
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
    public String f20151a;

    /* renamed from: b  reason: collision with root package name */
    public int f20152b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f20153c;

    /* renamed from: d  reason: collision with root package name */
    public List<f> f20154d;

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
        this.f20152b = -1;
        this.f20153c = new ArrayList();
        this.f20154d = new ArrayList();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20151a : (String) invokeV.objValue;
    }

    public List<d> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20153c : (List) invokeV.objValue;
    }

    public List<f> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20154d : (List) invokeV.objValue;
    }

    public void d(TopicListModule topicListModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, topicListModule) == null) || topicListModule == null) {
            return;
        }
        this.f20151a = topicListModule.module_title;
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
                    this.f20153c.add(dVar);
                    this.f20154d.add(new f(topicList));
                }
            }
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f20151a = str;
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f20152b = i2;
        }
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f20152b : invokeV.intValue;
    }
}
