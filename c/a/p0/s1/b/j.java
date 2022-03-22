package c.a.p0.s1.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.TopicList.DataRes;
import tbclient.TopicList.NewTopicList;
import tbclient.TopicList.TabList;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes2.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public List<n> f18171b;

    /* renamed from: c  reason: collision with root package name */
    public m f18172c;

    /* renamed from: d  reason: collision with root package name */
    public List<c> f18173d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f18174e;

    /* renamed from: f  reason: collision with root package name */
    public List<TopicList> f18175f;

    /* renamed from: g  reason: collision with root package name */
    public List<NewTopicList> f18176g;

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public List<TopicList> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18175f : (List) invokeV.objValue;
    }

    public void b(DataRes dataRes) {
        List<TopicList> list;
        List<TopicList> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) || dataRes == null) {
            return;
        }
        List<TabList> list3 = dataRes.tab_list;
        if (list3 != null && !ListUtils.isEmpty(list3)) {
            this.f18171b = new ArrayList();
            for (TabList tabList : dataRes.tab_list) {
                n nVar = new n();
                nVar.a(tabList);
                this.f18171b.add(nVar);
            }
        }
        if (dataRes.media_topic != null) {
            m mVar = new m();
            this.f18172c = mVar;
            mVar.a(dataRes.media_topic);
        }
        TopicListModule topicListModule = dataRes.topic_manual;
        if (topicListModule != null && (list2 = topicListModule.topic_list) != null && list2.size() > 0) {
            this.f18174e = new ArrayList();
            for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                b bVar = new b();
                bVar.b(dataRes.topic_manual);
                bVar.a(dataRes.topic_manual.topic_list.get(i));
                this.f18174e.add(bVar);
            }
        }
        TopicListModule topicListModule2 = dataRes.topic_bang;
        if (topicListModule2 != null && (list = topicListModule2.topic_list) != null && list.size() > 0) {
            this.f18173d = new ArrayList();
            for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                c cVar = new c();
                cVar.b(dataRes.topic_bang);
                cVar.a(dataRes.topic_bang.topic_list.get(i2));
                this.f18173d.add(cVar);
            }
        }
        this.f18175f = dataRes.frs_tab_topic;
        this.f18176g = dataRes.topic_list;
    }
}
