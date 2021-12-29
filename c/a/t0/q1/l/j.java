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
    public List<p> f22162b;

    /* renamed from: c  reason: collision with root package name */
    public o f22163c;

    /* renamed from: d  reason: collision with root package name */
    public List<c> f22164d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f22165e;

    /* renamed from: f  reason: collision with root package name */
    public List<TopicList> f22166f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c.a.d.n.e.n> f22167g;

    /* renamed from: h  reason: collision with root package name */
    public List<NewTopicList> f22168h;

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
        this.f22167g = null;
    }

    public List<TopicList> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22166f : (List) invokeV.objValue;
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
            this.f22162b = new ArrayList();
            for (TabList tabList : dataRes.tab_list) {
                p pVar = new p();
                pVar.a(tabList);
                this.f22162b.add(pVar);
            }
        }
        if (dataRes.media_topic != null) {
            o oVar = new o();
            this.f22163c = oVar;
            oVar.a(dataRes.media_topic);
        }
        TopicListModule topicListModule = dataRes.topic_manual;
        if (topicListModule != null && (list2 = topicListModule.topic_list) != null && list2.size() > 0) {
            this.f22165e = new ArrayList();
            for (int i2 = 0; i2 < dataRes.topic_manual.topic_list.size(); i2++) {
                b bVar = new b();
                bVar.k(dataRes.topic_manual);
                bVar.i(dataRes.topic_manual.topic_list.get(i2));
                this.f22165e.add(bVar);
            }
        }
        TopicListModule topicListModule2 = dataRes.topic_bang;
        if (topicListModule2 != null && (list = topicListModule2.topic_list) != null && list.size() > 0) {
            this.f22164d = new ArrayList();
            for (int i3 = 0; i3 < dataRes.topic_bang.topic_list.size(); i3++) {
                c cVar = new c();
                cVar.o(dataRes.topic_bang);
                cVar.n(dataRes.topic_bang.topic_list.get(i3));
                this.f22164d.add(cVar);
            }
        }
        this.f22166f = dataRes.frs_tab_topic;
        this.f22168h = dataRes.topic_list;
    }

    public final ArrayList<c.a.d.n.e.n> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.f22167g = new ArrayList<>();
            o oVar = this.f22163c;
            if (oVar != null && (!StringUtils.isNull(oVar.f22184g) || !StringUtils.isNull(this.f22163c.f22185h))) {
                this.f22167g.add(this.f22163c);
            }
            List<b> list = this.f22165e;
            int i2 = 0;
            if (list != null && list.size() > 0) {
                int size = this.f22165e.size() == 1 ? this.f22165e.size() : 1;
                for (int i3 = 0; i3 < size; i3++) {
                    b bVar = this.f22165e.get(i3);
                    if (bVar != null && (!StringUtils.isNull(bVar.h()) || !StringUtils.isNull(bVar.g()) || !StringUtils.isNull(bVar.e()))) {
                        this.f22167g.add(this.f22165e.get(i3));
                    }
                }
            }
            List<c> list2 = this.f22164d;
            if (list2 != null && list2.size() > 0) {
                int size2 = this.f22164d.size() <= 20 ? this.f22164d.size() : 20;
                while (i2 < size2) {
                    c cVar = this.f22164d.get(i2);
                    i2++;
                    cVar.p(i2);
                    this.f22167g.add(cVar);
                }
            }
            return this.f22167g;
        }
        return (ArrayList) invokeV.objValue;
    }
}
