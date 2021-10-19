package c.a.r0.h1.k.a.c;

import c.a.e.l.e.n;
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
    public long f18652a;

    /* renamed from: b  reason: collision with root package name */
    public String f18653b;

    /* renamed from: c  reason: collision with root package name */
    public String f18654c;

    /* renamed from: d  reason: collision with root package name */
    public String f18655d;

    /* renamed from: e  reason: collision with root package name */
    public b f18656e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f18657f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18658g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18659h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f18660i;

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
        this.f18660i = false;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18660i : invokeV.booleanValue;
    }

    public void b(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f18659h = false;
        TopicDetail topicDetail = dataRes.topic_info;
        if (topicDetail != null) {
            this.f18652a = topicDetail.topic_id.longValue();
            TopicDetail topicDetail2 = dataRes.topic_info;
            this.f18653b = topicDetail2.topic_name;
            this.f18654c = topicDetail2.share_title;
            this.f18655d = topicDetail2.share_pic;
            b bVar = new b();
            this.f18656e = bVar;
            bVar.a(dataRes.topic_info);
            if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                this.f18659h = true;
            }
        }
        if (dataRes.pk_module != null) {
            this.f18660i = true;
            this.f18659h = true;
            if (this.f18656e == null) {
                this.f18656e = new b();
            }
            this.f18656e.b(dataRes.pk_module);
        } else {
            this.f18660i = false;
        }
        if (dataRes.time_line != null) {
            this.f18659h = true;
            if (this.f18656e == null) {
                this.f18656e = new b();
            }
            this.f18656e.c(dataRes.time_line);
        }
        this.f18657f = new ArrayList();
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.f18659h = true;
            int i2 = 1;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (specialTopic != null && !ListUtils.isEmpty(specialTopic.thread_list)) {
                    boolean z = false;
                    for (ThreadInfo threadInfo : specialTopic.thread_list) {
                        if (threadInfo != null) {
                            d dVar = new d();
                            if (!z) {
                                dVar.f18674e = true;
                                dVar.f18677h = specialTopic.title;
                                z = true;
                            }
                            dVar.f18675f = i2;
                            dVar.f18676g = this.f18652a;
                            dVar.g(threadInfo);
                            this.f18657f.add(dVar);
                            i2++;
                        }
                    }
                }
            }
        }
        if (this.f18659h) {
            c.a.r0.h1.k.b.c.c cVar = new c.a.r0.h1.k.b.c.c();
            cVar.f18727e = R.dimen.tbds78;
            cVar.f18728f = R.color.CAM_X0201;
            this.f18657f.add(cVar);
        }
        RelateThread relateThread = dataRes.relate_thread;
        if (relateThread == null || ListUtils.isEmpty(relateThread.thread_list)) {
            return;
        }
        c.a.r0.h1.k.b.c.c cVar2 = new c.a.r0.h1.k.b.c.c();
        cVar2.f18727e = R.dimen.tbds16;
        this.f18657f.add(cVar2);
        this.f18658g = dataRes.relate_thread.has_more.intValue() == 1;
        for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
            if (topicThread != null) {
                c cVar3 = new c();
                cVar3.g(topicThread);
                cVar3.f18669g = this.f18652a;
                cVar3.f18672j = this.f18660i;
                this.f18657f.add(cVar3);
            }
        }
    }
}
