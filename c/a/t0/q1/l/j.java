package c.a.t0.q1.l;

import com.baidu.adp.lib.util.StringUtils;
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
/* loaded from: classes8.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public List<p> f21557b;

    /* renamed from: c  reason: collision with root package name */
    public o f21558c;

    /* renamed from: d  reason: collision with root package name */
    public List<c> f21559d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f21560e;

    /* renamed from: f  reason: collision with root package name */
    public List<TopicList> f21561f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c.a.d.n.e.n> f21562g;

    /* renamed from: h  reason: collision with root package name */
    public List<NewTopicList> f21563h;

    public j() {
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
        this.f21562g = null;
    }

    public List<TopicList> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21561f : (List) invokeV.objValue;
    }

    public ArrayList<c.a.d.n.e.n> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d() : (ArrayList) invokeV.objValue;
    }

    public void c(DataRes dataRes) {
        List<TopicList> list;
        List<TopicList> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataRes) == null) || dataRes == null) {
            return;
        }
        List<TabList> list3 = dataRes.tab_list;
        if (list3 != null && !ListUtils.isEmpty(list3)) {
            this.f21557b = new ArrayList();
            for (TabList tabList : dataRes.tab_list) {
                p pVar = new p();
                pVar.a(tabList);
                this.f21557b.add(pVar);
            }
        }
        if (dataRes.media_topic != null) {
            o oVar = new o();
            this.f21558c = oVar;
            oVar.a(dataRes.media_topic);
        }
        TopicListModule topicListModule = dataRes.topic_manual;
        if (topicListModule != null && (list2 = topicListModule.topic_list) != null && list2.size() > 0) {
            this.f21560e = new ArrayList();
            for (int i2 = 0; i2 < dataRes.topic_manual.topic_list.size(); i2++) {
                b bVar = new b();
                bVar.k(dataRes.topic_manual);
                bVar.i(dataRes.topic_manual.topic_list.get(i2));
                this.f21560e.add(bVar);
            }
        }
        TopicListModule topicListModule2 = dataRes.topic_bang;
        if (topicListModule2 != null && (list = topicListModule2.topic_list) != null && list.size() > 0) {
            this.f21559d = new ArrayList();
            for (int i3 = 0; i3 < dataRes.topic_bang.topic_list.size(); i3++) {
                c cVar = new c();
                cVar.o(dataRes.topic_bang);
                cVar.n(dataRes.topic_bang.topic_list.get(i3));
                this.f21559d.add(cVar);
            }
        }
        this.f21561f = dataRes.frs_tab_topic;
        this.f21563h = dataRes.topic_list;
    }

    public final ArrayList<c.a.d.n.e.n> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.f21562g = new ArrayList<>();
            o oVar = this.f21558c;
            if (oVar != null && (!StringUtils.isNull(oVar.f21577g) || !StringUtils.isNull(this.f21558c.f21578h))) {
                this.f21562g.add(this.f21558c);
            }
            List<b> list = this.f21560e;
            int i2 = 0;
            if (list != null && list.size() > 0) {
                int size = this.f21560e.size() == 1 ? this.f21560e.size() : 1;
                for (int i3 = 0; i3 < size; i3++) {
                    b bVar = this.f21560e.get(i3);
                    if (bVar != null && (!StringUtils.isNull(bVar.h()) || !StringUtils.isNull(bVar.g()) || !StringUtils.isNull(bVar.e()))) {
                        this.f21562g.add(this.f21560e.get(i3));
                    }
                }
            }
            List<c> list2 = this.f21559d;
            if (list2 != null && list2.size() > 0) {
                int size2 = this.f21559d.size() <= 20 ? this.f21559d.size() : 20;
                while (i2 < size2) {
                    c cVar = this.f21559d.get(i2);
                    i2++;
                    cVar.p(i2);
                    this.f21562g.add(cVar);
                }
            }
            return this.f21562g;
        }
        return (ArrayList) invokeV.objValue;
    }
}
