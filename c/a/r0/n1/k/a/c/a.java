package c.a.r0.n1.k.a.c;

import c.a.d.m.e.n;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public String f20649b;

    /* renamed from: c  reason: collision with root package name */
    public String f20650c;

    /* renamed from: d  reason: collision with root package name */
    public String f20651d;

    /* renamed from: e  reason: collision with root package name */
    public b f20652e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f20653f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f20654g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20655h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20656i;

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
        this.f20656i = false;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20656i : invokeV.booleanValue;
    }

    public void b(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f20655h = false;
        TopicDetail topicDetail = dataRes.topic_info;
        if (topicDetail != null) {
            this.a = topicDetail.topic_id.longValue();
            TopicDetail topicDetail2 = dataRes.topic_info;
            this.f20649b = topicDetail2.topic_name;
            this.f20650c = topicDetail2.share_title;
            this.f20651d = topicDetail2.share_pic;
            b bVar = new b();
            this.f20652e = bVar;
            bVar.a(dataRes.topic_info);
            if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                this.f20655h = true;
            }
        }
        if (dataRes.pk_module != null) {
            this.f20656i = true;
            this.f20655h = true;
            if (this.f20652e == null) {
                this.f20652e = new b();
            }
            this.f20652e.b(dataRes.pk_module);
        } else {
            this.f20656i = false;
        }
        if (dataRes.time_line != null) {
            this.f20655h = true;
            if (this.f20652e == null) {
                this.f20652e = new b();
            }
            this.f20652e.c(dataRes.time_line);
        }
        this.f20653f = new ArrayList();
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.f20655h = true;
            int i2 = 1;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (specialTopic != null && !ListUtils.isEmpty(specialTopic.thread_list)) {
                    boolean z = false;
                    for (ThreadInfo threadInfo : specialTopic.thread_list) {
                        if (threadInfo != null) {
                            d dVar = new d();
                            if (!z) {
                                dVar.f20670e = true;
                                dVar.f20673h = specialTopic.title;
                                z = true;
                            }
                            dVar.f20671f = i2;
                            dVar.f20672g = this.a;
                            dVar.g(threadInfo);
                            this.f20653f.add(dVar);
                            i2++;
                        }
                    }
                }
            }
        }
        if (this.f20655h) {
            c.a.r0.n1.k.b.c.c cVar = new c.a.r0.n1.k.b.c.c();
            cVar.f20713e = R.dimen.tbds78;
            cVar.f20714f = R.color.CAM_X0201;
            this.f20653f.add(cVar);
        }
        RelateThread relateThread = dataRes.relate_thread;
        if (relateThread == null || ListUtils.isEmpty(relateThread.thread_list)) {
            return;
        }
        c.a.r0.n1.k.b.c.c cVar2 = new c.a.r0.n1.k.b.c.c();
        cVar2.f20713e = R.dimen.tbds16;
        this.f20653f.add(cVar2);
        this.f20654g = dataRes.relate_thread.has_more.intValue() == 1;
        for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
            if (topicThread != null) {
                c cVar3 = new c();
                cVar3.g(topicThread);
                cVar3.f20665g = this.a;
                cVar3.f20668j = this.f20656i;
                this.f20653f.add(cVar3);
            }
        }
    }
}
