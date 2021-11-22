package b.a.r0.h1.k.a.c;

import b.a.e.m.e.n;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f19050a;

    /* renamed from: b  reason: collision with root package name */
    public String f19051b;

    /* renamed from: c  reason: collision with root package name */
    public String f19052c;

    /* renamed from: d  reason: collision with root package name */
    public String f19053d;

    /* renamed from: e  reason: collision with root package name */
    public b f19054e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f19055f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19056g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19057h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19058i;

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
        this.f19058i = false;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19058i : invokeV.booleanValue;
    }

    public void b(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f19057h = false;
        TopicDetail topicDetail = dataRes.topic_info;
        if (topicDetail != null) {
            this.f19050a = topicDetail.topic_id.longValue();
            TopicDetail topicDetail2 = dataRes.topic_info;
            this.f19051b = topicDetail2.topic_name;
            this.f19052c = topicDetail2.share_title;
            this.f19053d = topicDetail2.share_pic;
            b bVar = new b();
            this.f19054e = bVar;
            bVar.a(dataRes.topic_info);
            if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                this.f19057h = true;
            }
        }
        if (dataRes.pk_module != null) {
            this.f19058i = true;
            this.f19057h = true;
            if (this.f19054e == null) {
                this.f19054e = new b();
            }
            this.f19054e.b(dataRes.pk_module);
        } else {
            this.f19058i = false;
        }
        if (dataRes.time_line != null) {
            this.f19057h = true;
            if (this.f19054e == null) {
                this.f19054e = new b();
            }
            this.f19054e.c(dataRes.time_line);
        }
        this.f19055f = new ArrayList();
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.f19057h = true;
            int i2 = 1;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (specialTopic != null && !ListUtils.isEmpty(specialTopic.thread_list)) {
                    boolean z = false;
                    for (ThreadInfo threadInfo : specialTopic.thread_list) {
                        if (threadInfo != null) {
                            d dVar = new d();
                            if (!z) {
                                dVar.f19070e = true;
                                dVar.f19073h = specialTopic.title;
                                z = true;
                            }
                            dVar.f19071f = i2;
                            dVar.f19072g = this.f19050a;
                            dVar.g(threadInfo);
                            this.f19055f.add(dVar);
                            i2++;
                        }
                    }
                }
            }
        }
        if (this.f19057h) {
            b.a.r0.h1.k.b.c.c cVar = new b.a.r0.h1.k.b.c.c();
            cVar.f19122e = R.dimen.tbds78;
            cVar.f19123f = R.color.CAM_X0201;
            this.f19055f.add(cVar);
        }
        RelateThread relateThread = dataRes.relate_thread;
        if (relateThread == null || ListUtils.isEmpty(relateThread.thread_list)) {
            return;
        }
        b.a.r0.h1.k.b.c.c cVar2 = new b.a.r0.h1.k.b.c.c();
        cVar2.f19122e = R.dimen.tbds16;
        this.f19055f.add(cVar2);
        this.f19056g = dataRes.relate_thread.has_more.intValue() == 1;
        for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
            if (topicThread != null) {
                c cVar3 = new c();
                cVar3.g(topicThread);
                cVar3.f19067g = this.f19050a;
                cVar3.j = this.f19058i;
                this.f19055f.add(cVar3);
            }
        }
    }
}
