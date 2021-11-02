package b.a.r0.h1.k.b.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.NewHottopic.PkItem;
import tbclient.NewHottopic.PkModule;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f17639a;

    /* renamed from: b  reason: collision with root package name */
    public long f17640b;

    /* renamed from: c  reason: collision with root package name */
    public long f17641c;

    /* renamed from: d  reason: collision with root package name */
    public a f17642d;

    /* renamed from: e  reason: collision with root package name */
    public a f17643e;

    /* renamed from: f  reason: collision with root package name */
    public int f17644f;

    /* loaded from: classes4.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f17645a;

        /* renamed from: b  reason: collision with root package name */
        public String f17646b;

        /* renamed from: c  reason: collision with root package name */
        public String f17647c;

        /* renamed from: d  reason: collision with root package name */
        public String f17648d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f17649e;

        /* renamed from: f  reason: collision with root package name */
        public long f17650f;

        /* renamed from: g  reason: collision with root package name */
        public String f17651g;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f17640b = pkModule.pk_id.longValue();
        this.f17641c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f17642d = aVar;
        aVar.f17645a = pkModule.agree.pk_num.longValue();
        this.f17642d.f17646b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f17642d;
        PkItem pkItem = pkModule.agree;
        aVar2.f17647c = pkItem.last_username;
        aVar2.f17648d = pkItem.pk_icon;
        aVar2.f17649e = pkItem.has_clicked.longValue() == 1;
        this.f17642d.f17650f = pkModule.agree.pk_index.longValue();
        this.f17642d.f17651g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f17643e = aVar3;
        aVar3.f17645a = pkModule.disagree.pk_num.longValue();
        this.f17643e.f17646b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f17643e;
        PkItem pkItem2 = pkModule.disagree;
        aVar4.f17647c = pkItem2.last_username;
        aVar4.f17648d = pkItem2.pk_icon;
        aVar4.f17649e = pkItem2.has_clicked.longValue() == 1;
        this.f17643e.f17650f = pkModule.disagree.pk_index.longValue();
        this.f17643e.f17651g = pkModule.disagree.pk_icon_after;
    }

    public void b(tbclient.NewTopicList.PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f17640b = pkModule.pk_id.longValue();
        this.f17641c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f17642d = aVar;
        aVar.f17645a = pkModule.agree.pk_num.longValue();
        this.f17642d.f17646b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f17642d;
        tbclient.NewTopicList.PkItem pkItem = pkModule.agree;
        aVar2.f17647c = pkItem.last_username;
        aVar2.f17648d = pkItem.pk_icon;
        aVar2.f17649e = pkItem.has_clicked.longValue() == 1;
        this.f17642d.f17650f = pkModule.agree.pk_index.longValue();
        this.f17642d.f17651g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f17643e = aVar3;
        aVar3.f17645a = pkModule.disagree.pk_num.longValue();
        this.f17643e.f17646b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f17643e;
        tbclient.NewTopicList.PkItem pkItem2 = pkModule.disagree;
        aVar4.f17647c = pkItem2.last_username;
        aVar4.f17648d = pkItem2.pk_icon;
        aVar4.f17649e = pkItem2.has_clicked.longValue() == 1;
        this.f17643e.f17650f = pkModule.disagree.pk_index.longValue();
        this.f17643e.f17651g = pkModule.disagree.pk_icon_after;
    }

    public void c(tbclient.PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f17640b = pkModule.pk_id.longValue();
        this.f17641c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f17642d = aVar;
        aVar.f17645a = pkModule.agree.pk_num.longValue();
        this.f17642d.f17646b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f17642d;
        tbclient.PkItem pkItem = pkModule.agree;
        aVar2.f17647c = pkItem.last_username;
        aVar2.f17648d = pkItem.pk_icon;
        aVar2.f17649e = pkItem.has_clicked.longValue() == 1;
        this.f17642d.f17650f = pkModule.agree.pk_index.longValue();
        this.f17642d.f17651g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f17643e = aVar3;
        aVar3.f17645a = pkModule.disagree.pk_num.longValue();
        this.f17643e.f17646b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f17643e;
        tbclient.PkItem pkItem2 = pkModule.disagree;
        aVar4.f17647c = pkItem2.last_username;
        aVar4.f17648d = pkItem2.pk_icon;
        aVar4.f17649e = pkItem2.has_clicked.longValue() == 1;
        this.f17643e.f17650f = pkModule.disagree.pk_index.longValue();
        this.f17643e.f17651g = pkModule.disagree.pk_icon_after;
    }
}
