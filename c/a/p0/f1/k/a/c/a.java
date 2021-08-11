package c.a.p0.f1.k.a.c;

import c.a.e.k.e.n;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewHottopic.DataRes;
import tbclient.NewHottopic.RelateThread;
import tbclient.NewHottopic.SpecialTopic;
import tbclient.NewHottopic.TopicDetail;
import tbclient.NewHottopic.TopicThread;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f17605a;

    /* renamed from: b  reason: collision with root package name */
    public String f17606b;

    /* renamed from: c  reason: collision with root package name */
    public String f17607c;

    /* renamed from: d  reason: collision with root package name */
    public String f17608d;

    /* renamed from: e  reason: collision with root package name */
    public b f17609e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f17610f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17611g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17612h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f17613i;

    public a() {
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
        this.f17613i = false;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17613i : invokeV.booleanValue;
    }

    public void b(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f17612h = false;
        TopicDetail topicDetail = dataRes.topic_info;
        if (topicDetail != null) {
            this.f17605a = topicDetail.topic_id.longValue();
            TopicDetail topicDetail2 = dataRes.topic_info;
            this.f17606b = topicDetail2.topic_name;
            this.f17607c = topicDetail2.share_title;
            this.f17608d = topicDetail2.share_pic;
            b bVar = new b();
            this.f17609e = bVar;
            bVar.a(dataRes.topic_info);
            if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                this.f17612h = true;
            }
        }
        if (dataRes.pk_module != null) {
            this.f17613i = true;
            this.f17612h = true;
            if (this.f17609e == null) {
                this.f17609e = new b();
            }
            this.f17609e.b(dataRes.pk_module);
        } else {
            this.f17613i = false;
        }
        if (dataRes.time_line != null) {
            this.f17612h = true;
            if (this.f17609e == null) {
                this.f17609e = new b();
            }
            this.f17609e.c(dataRes.time_line);
        }
        this.f17610f = new ArrayList();
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.f17612h = true;
            int i2 = 1;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (specialTopic != null && !ListUtils.isEmpty(specialTopic.thread_list)) {
                    boolean z = false;
                    for (ThreadInfo threadInfo : specialTopic.thread_list) {
                        if (threadInfo != null) {
                            d dVar = new d();
                            if (!z) {
                                dVar.f17627e = true;
                                dVar.f17630h = specialTopic.title;
                                z = true;
                            }
                            dVar.f17628f = i2;
                            dVar.f17629g = this.f17605a;
                            dVar.g(threadInfo);
                            this.f17610f.add(dVar);
                            i2++;
                        }
                    }
                }
            }
        }
        if (this.f17612h) {
            c.a.p0.f1.k.b.c.c cVar = new c.a.p0.f1.k.b.c.c();
            cVar.f17680e = R.dimen.tbds78;
            cVar.f17681f = R.color.CAM_X0201;
            this.f17610f.add(cVar);
        }
        RelateThread relateThread = dataRes.relate_thread;
        if (relateThread == null || ListUtils.isEmpty(relateThread.thread_list)) {
            return;
        }
        c.a.p0.f1.k.b.c.c cVar2 = new c.a.p0.f1.k.b.c.c();
        cVar2.f17680e = R.dimen.tbds16;
        this.f17610f.add(cVar2);
        this.f17611g = dataRes.relate_thread.has_more.intValue() == 1;
        for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
            if (topicThread != null) {
                c cVar3 = new c();
                cVar3.g(topicThread);
                cVar3.f17622g = this.f17605a;
                cVar3.f17625j = this.f17613i;
                this.f17610f.add(cVar3);
            }
        }
    }
}
