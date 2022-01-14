package c.a.t0.o1.k.b.c;

import c.a.d.n.e.n;
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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public String f20670b;

    /* renamed from: c  reason: collision with root package name */
    public String f20671c;

    /* renamed from: d  reason: collision with root package name */
    public String f20672d;

    /* renamed from: e  reason: collision with root package name */
    public b f20673e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f20674f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f20675g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20676h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20677i;

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
        this.f20677i = false;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20677i : invokeV.booleanValue;
    }

    public void b(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f20676h = false;
        TopicDetail topicDetail = dataRes.topic_info;
        if (topicDetail != null) {
            this.a = topicDetail.topic_id.longValue();
            TopicDetail topicDetail2 = dataRes.topic_info;
            this.f20670b = topicDetail2.topic_name;
            this.f20671c = topicDetail2.share_title;
            this.f20672d = topicDetail2.share_pic;
            b bVar = new b();
            this.f20673e = bVar;
            bVar.a(dataRes.topic_info);
            if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                this.f20676h = true;
            }
        }
        if (dataRes.pk_module != null) {
            this.f20677i = true;
            this.f20676h = true;
            if (this.f20673e == null) {
                this.f20673e = new b();
            }
            this.f20673e.b(dataRes.pk_module);
        } else {
            this.f20677i = false;
        }
        if (dataRes.time_line != null) {
            this.f20676h = true;
            if (this.f20673e == null) {
                this.f20673e = new b();
            }
            this.f20673e.c(dataRes.time_line);
        }
        this.f20674f = new ArrayList();
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.f20676h = true;
            int i2 = 1;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (specialTopic != null && !ListUtils.isEmpty(specialTopic.thread_list)) {
                    boolean z = false;
                    for (ThreadInfo threadInfo : specialTopic.thread_list) {
                        if (threadInfo != null) {
                            d dVar = new d();
                            if (!z) {
                                dVar.f20690e = true;
                                dVar.f20693h = specialTopic.title;
                                z = true;
                            }
                            dVar.f20691f = i2;
                            dVar.f20692g = this.a;
                            dVar.g(threadInfo);
                            this.f20674f.add(dVar);
                            i2++;
                        }
                    }
                }
            }
        }
        if (this.f20676h) {
            c.a.t0.o1.k.c.c.c cVar = new c.a.t0.o1.k.c.c.c();
            cVar.f20732e = R.dimen.tbds78;
            cVar.f20733f = R.color.CAM_X0201;
            this.f20674f.add(cVar);
        }
        RelateThread relateThread = dataRes.relate_thread;
        if (relateThread == null || ListUtils.isEmpty(relateThread.thread_list)) {
            return;
        }
        c.a.t0.o1.k.c.c.c cVar2 = new c.a.t0.o1.k.c.c.c();
        cVar2.f20732e = R.dimen.tbds16;
        this.f20674f.add(cVar2);
        this.f20675g = dataRes.relate_thread.has_more.intValue() == 1;
        for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
            if (topicThread != null) {
                c cVar3 = new c();
                cVar3.g(topicThread);
                cVar3.f20685g = this.a;
                cVar3.f20688j = this.f20677i;
                this.f20674f.add(cVar3);
            }
        }
    }
}
