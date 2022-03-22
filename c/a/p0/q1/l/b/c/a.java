package c.a.p0.q1.l.b.c;

import c.a.d.o.e.n;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public String f17546b;

    /* renamed from: c  reason: collision with root package name */
    public String f17547c;

    /* renamed from: d  reason: collision with root package name */
    public String f17548d;

    /* renamed from: e  reason: collision with root package name */
    public b f17549e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f17550f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17551g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17552h;
    public boolean i;

    public a() {
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
        this.i = false;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.i : invokeV.booleanValue;
    }

    public void b(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f17552h = false;
        TopicDetail topicDetail = dataRes.topic_info;
        if (topicDetail != null) {
            this.a = topicDetail.topic_id.longValue();
            TopicDetail topicDetail2 = dataRes.topic_info;
            this.f17546b = topicDetail2.topic_name;
            this.f17547c = topicDetail2.share_title;
            this.f17548d = topicDetail2.share_pic;
            b bVar = new b();
            this.f17549e = bVar;
            bVar.a(dataRes.topic_info);
            if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                this.f17552h = true;
            }
        }
        if (dataRes.pk_module != null) {
            this.i = true;
            this.f17552h = true;
            if (this.f17549e == null) {
                this.f17549e = new b();
            }
            this.f17549e.b(dataRes.pk_module);
        } else {
            this.i = false;
        }
        if (dataRes.time_line != null) {
            this.f17552h = true;
            if (this.f17549e == null) {
                this.f17549e = new b();
            }
            this.f17549e.c(dataRes.time_line);
        }
        this.f17550f = new ArrayList();
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.f17552h = true;
            int i = 1;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (specialTopic != null && !ListUtils.isEmpty(specialTopic.thread_list)) {
                    boolean z = false;
                    for (ThreadInfo threadInfo : specialTopic.thread_list) {
                        if (threadInfo != null) {
                            d dVar = new d();
                            if (!z) {
                                dVar.a = true;
                                dVar.f17567d = specialTopic.title;
                                z = true;
                            }
                            dVar.f17565b = i;
                            dVar.f17566c = this.a;
                            dVar.e(threadInfo);
                            this.f17550f.add(dVar);
                            i++;
                        }
                    }
                }
            }
        }
        if (this.f17552h) {
            c.a.p0.q1.l.c.c.c cVar = new c.a.p0.q1.l.c.c.c();
            cVar.a = R.dimen.tbds78;
            cVar.f17601b = R.color.CAM_X0201;
            this.f17550f.add(cVar);
        }
        RelateThread relateThread = dataRes.relate_thread;
        if (relateThread == null || ListUtils.isEmpty(relateThread.thread_list)) {
            return;
        }
        c.a.p0.q1.l.c.c.c cVar2 = new c.a.p0.q1.l.c.c.c();
        cVar2.a = R.dimen.tbds16;
        this.f17550f.add(cVar2);
        this.f17551g = dataRes.relate_thread.has_more.intValue() == 1;
        for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
            if (topicThread != null) {
                c cVar3 = new c();
                cVar3.e(topicThread);
                cVar3.f17560c = this.a;
                cVar3.f17563f = this.i;
                this.f17550f.add(cVar3);
            }
        }
    }
}
