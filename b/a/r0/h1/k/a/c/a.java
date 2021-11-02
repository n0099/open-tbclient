package b.a.r0.h1.k.a.c;

import b.a.e.l.e.n;
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
    public long f17581a;

    /* renamed from: b  reason: collision with root package name */
    public String f17582b;

    /* renamed from: c  reason: collision with root package name */
    public String f17583c;

    /* renamed from: d  reason: collision with root package name */
    public String f17584d;

    /* renamed from: e  reason: collision with root package name */
    public b f17585e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f17586f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17587g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17588h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f17589i;

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
        this.f17589i = false;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17589i : invokeV.booleanValue;
    }

    public void b(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f17588h = false;
        TopicDetail topicDetail = dataRes.topic_info;
        if (topicDetail != null) {
            this.f17581a = topicDetail.topic_id.longValue();
            TopicDetail topicDetail2 = dataRes.topic_info;
            this.f17582b = topicDetail2.topic_name;
            this.f17583c = topicDetail2.share_title;
            this.f17584d = topicDetail2.share_pic;
            b bVar = new b();
            this.f17585e = bVar;
            bVar.a(dataRes.topic_info);
            if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                this.f17588h = true;
            }
        }
        if (dataRes.pk_module != null) {
            this.f17589i = true;
            this.f17588h = true;
            if (this.f17585e == null) {
                this.f17585e = new b();
            }
            this.f17585e.b(dataRes.pk_module);
        } else {
            this.f17589i = false;
        }
        if (dataRes.time_line != null) {
            this.f17588h = true;
            if (this.f17585e == null) {
                this.f17585e = new b();
            }
            this.f17585e.c(dataRes.time_line);
        }
        this.f17586f = new ArrayList();
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.f17588h = true;
            int i2 = 1;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (specialTopic != null && !ListUtils.isEmpty(specialTopic.thread_list)) {
                    boolean z = false;
                    for (ThreadInfo threadInfo : specialTopic.thread_list) {
                        if (threadInfo != null) {
                            d dVar = new d();
                            if (!z) {
                                dVar.f17601e = true;
                                dVar.f17604h = specialTopic.title;
                                z = true;
                            }
                            dVar.f17602f = i2;
                            dVar.f17603g = this.f17581a;
                            dVar.g(threadInfo);
                            this.f17586f.add(dVar);
                            i2++;
                        }
                    }
                }
            }
        }
        if (this.f17588h) {
            b.a.r0.h1.k.b.c.c cVar = new b.a.r0.h1.k.b.c.c();
            cVar.f17653e = R.dimen.tbds78;
            cVar.f17654f = R.color.CAM_X0201;
            this.f17586f.add(cVar);
        }
        RelateThread relateThread = dataRes.relate_thread;
        if (relateThread == null || ListUtils.isEmpty(relateThread.thread_list)) {
            return;
        }
        b.a.r0.h1.k.b.c.c cVar2 = new b.a.r0.h1.k.b.c.c();
        cVar2.f17653e = R.dimen.tbds16;
        this.f17586f.add(cVar2);
        this.f17587g = dataRes.relate_thread.has_more.intValue() == 1;
        for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
            if (topicThread != null) {
                c cVar3 = new c();
                cVar3.g(topicThread);
                cVar3.f17598g = this.f17581a;
                cVar3.j = this.f17589i;
                this.f17586f.add(cVar3);
            }
        }
    }
}
