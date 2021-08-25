package c.a.q0.h1.c;

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
/* loaded from: classes3.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f18638a;

    /* renamed from: b  reason: collision with root package name */
    public List<p> f18639b;

    /* renamed from: c  reason: collision with root package name */
    public o f18640c;

    /* renamed from: d  reason: collision with root package name */
    public List<c> f18641d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f18642e;

    /* renamed from: f  reason: collision with root package name */
    public List<TopicList> f18643f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c.a.e.l.e.n> f18644g;

    /* renamed from: h  reason: collision with root package name */
    public List<NewTopicList> f18645h;

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
        this.f18644g = null;
    }

    public List<TopicList> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18643f : (List) invokeV.objValue;
    }

    public ArrayList<c.a.e.l.e.n> b() {
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
            this.f18639b = new ArrayList();
            for (TabList tabList : dataRes.tab_list) {
                p pVar = new p();
                pVar.b(tabList);
                this.f18639b.add(pVar);
            }
        }
        if (dataRes.media_topic != null) {
            o oVar = new o();
            this.f18640c = oVar;
            oVar.b(dataRes.media_topic);
        }
        TopicListModule topicListModule = dataRes.topic_manual;
        if (topicListModule != null && (list2 = topicListModule.topic_list) != null && list2.size() > 0) {
            this.f18642e = new ArrayList();
            for (int i2 = 0; i2 < dataRes.topic_manual.topic_list.size(); i2++) {
                b bVar = new b();
                bVar.k(dataRes.topic_manual);
                bVar.i(dataRes.topic_manual.topic_list.get(i2));
                this.f18642e.add(bVar);
            }
        }
        TopicListModule topicListModule2 = dataRes.topic_bang;
        if (topicListModule2 != null && (list = topicListModule2.topic_list) != null && list.size() > 0) {
            this.f18641d = new ArrayList();
            for (int i3 = 0; i3 < dataRes.topic_bang.topic_list.size(); i3++) {
                c cVar = new c();
                cVar.o(dataRes.topic_bang);
                cVar.n(dataRes.topic_bang.topic_list.get(i3));
                this.f18641d.add(cVar);
            }
        }
        this.f18643f = dataRes.frs_tab_topic;
        this.f18645h = dataRes.topic_list;
    }

    public final ArrayList<c.a.e.l.e.n> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.f18644g = new ArrayList<>();
            o oVar = this.f18640c;
            if (oVar != null && (!StringUtils.isNull(oVar.f18661g) || !StringUtils.isNull(this.f18640c.f18662h))) {
                this.f18644g.add(this.f18640c);
            }
            List<b> list = this.f18642e;
            int i2 = 0;
            if (list != null && list.size() > 0) {
                int size = this.f18642e.size() == 1 ? this.f18642e.size() : 1;
                for (int i3 = 0; i3 < size; i3++) {
                    b bVar = this.f18642e.get(i3);
                    if (bVar != null && (!StringUtils.isNull(bVar.h()) || !StringUtils.isNull(bVar.g()) || !StringUtils.isNull(bVar.d()))) {
                        this.f18644g.add(this.f18642e.get(i3));
                    }
                }
            }
            List<c> list2 = this.f18641d;
            if (list2 != null && list2.size() > 0) {
                int size2 = this.f18641d.size() <= 20 ? this.f18641d.size() : 20;
                while (i2 < size2) {
                    c cVar = this.f18641d.get(i2);
                    i2++;
                    cVar.p(i2);
                    this.f18644g.add(cVar);
                }
            }
            return this.f18644g;
        }
        return (ArrayList) invokeV.objValue;
    }
}
