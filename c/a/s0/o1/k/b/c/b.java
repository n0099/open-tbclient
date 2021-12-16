package c.a.s0.o1.k.b.c;

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
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f21225b;

    /* renamed from: c  reason: collision with root package name */
    public long f21226c;

    /* renamed from: d  reason: collision with root package name */
    public a f21227d;

    /* renamed from: e  reason: collision with root package name */
    public a f21228e;

    /* renamed from: f  reason: collision with root package name */
    public int f21229f;

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public String f21230b;

        /* renamed from: c  reason: collision with root package name */
        public String f21231c;

        /* renamed from: d  reason: collision with root package name */
        public String f21232d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f21233e;

        /* renamed from: f  reason: collision with root package name */
        public long f21234f;

        /* renamed from: g  reason: collision with root package name */
        public String f21235g;

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
        this.f21225b = pkModule.pk_id.longValue();
        this.f21226c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f21227d = aVar;
        aVar.a = pkModule.agree.pk_num.longValue();
        this.f21227d.f21230b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f21227d;
        PkItem pkItem = pkModule.agree;
        aVar2.f21231c = pkItem.last_username;
        aVar2.f21232d = pkItem.pk_icon;
        aVar2.f21233e = pkItem.has_clicked.longValue() == 1;
        this.f21227d.f21234f = pkModule.agree.pk_index.longValue();
        this.f21227d.f21235g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f21228e = aVar3;
        aVar3.a = pkModule.disagree.pk_num.longValue();
        this.f21228e.f21230b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f21228e;
        PkItem pkItem2 = pkModule.disagree;
        aVar4.f21231c = pkItem2.last_username;
        aVar4.f21232d = pkItem2.pk_icon;
        aVar4.f21233e = pkItem2.has_clicked.longValue() == 1;
        this.f21228e.f21234f = pkModule.disagree.pk_index.longValue();
        this.f21228e.f21235g = pkModule.disagree.pk_icon_after;
    }

    public void b(tbclient.NewTopicList.PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f21225b = pkModule.pk_id.longValue();
        this.f21226c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f21227d = aVar;
        aVar.a = pkModule.agree.pk_num.longValue();
        this.f21227d.f21230b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f21227d;
        tbclient.NewTopicList.PkItem pkItem = pkModule.agree;
        aVar2.f21231c = pkItem.last_username;
        aVar2.f21232d = pkItem.pk_icon;
        aVar2.f21233e = pkItem.has_clicked.longValue() == 1;
        this.f21227d.f21234f = pkModule.agree.pk_index.longValue();
        this.f21227d.f21235g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f21228e = aVar3;
        aVar3.a = pkModule.disagree.pk_num.longValue();
        this.f21228e.f21230b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f21228e;
        tbclient.NewTopicList.PkItem pkItem2 = pkModule.disagree;
        aVar4.f21231c = pkItem2.last_username;
        aVar4.f21232d = pkItem2.pk_icon;
        aVar4.f21233e = pkItem2.has_clicked.longValue() == 1;
        this.f21228e.f21234f = pkModule.disagree.pk_index.longValue();
        this.f21228e.f21235g = pkModule.disagree.pk_icon_after;
    }

    public void c(tbclient.PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f21225b = pkModule.pk_id.longValue();
        this.f21226c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f21227d = aVar;
        aVar.a = pkModule.agree.pk_num.longValue();
        this.f21227d.f21230b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f21227d;
        tbclient.PkItem pkItem = pkModule.agree;
        aVar2.f21231c = pkItem.last_username;
        aVar2.f21232d = pkItem.pk_icon;
        aVar2.f21233e = pkItem.has_clicked.longValue() == 1;
        this.f21227d.f21234f = pkModule.agree.pk_index.longValue();
        this.f21227d.f21235g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f21228e = aVar3;
        aVar3.a = pkModule.disagree.pk_num.longValue();
        this.f21228e.f21230b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f21228e;
        tbclient.PkItem pkItem2 = pkModule.disagree;
        aVar4.f21231c = pkItem2.last_username;
        aVar4.f21232d = pkItem2.pk_icon;
        aVar4.f21233e = pkItem2.has_clicked.longValue() == 1;
        this.f21228e.f21234f = pkModule.disagree.pk_index.longValue();
        this.f21228e.f21235g = pkModule.disagree.pk_icon_after;
    }
}
