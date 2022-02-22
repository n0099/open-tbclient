package c.a.u0.p1.l.c.c;

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
    public long f20927b;

    /* renamed from: c  reason: collision with root package name */
    public long f20928c;

    /* renamed from: d  reason: collision with root package name */
    public a f20929d;

    /* renamed from: e  reason: collision with root package name */
    public a f20930e;

    /* renamed from: f  reason: collision with root package name */
    public int f20931f;

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public String f20932b;

        /* renamed from: c  reason: collision with root package name */
        public String f20933c;

        /* renamed from: d  reason: collision with root package name */
        public String f20934d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f20935e;

        /* renamed from: f  reason: collision with root package name */
        public long f20936f;

        /* renamed from: g  reason: collision with root package name */
        public String f20937g;

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
        this.f20927b = pkModule.pk_id.longValue();
        this.f20928c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f20929d = aVar;
        aVar.a = pkModule.agree.pk_num.longValue();
        this.f20929d.f20932b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f20929d;
        PkItem pkItem = pkModule.agree;
        aVar2.f20933c = pkItem.last_username;
        aVar2.f20934d = pkItem.pk_icon;
        aVar2.f20935e = pkItem.has_clicked.longValue() == 1;
        this.f20929d.f20936f = pkModule.agree.pk_index.longValue();
        this.f20929d.f20937g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f20930e = aVar3;
        aVar3.a = pkModule.disagree.pk_num.longValue();
        this.f20930e.f20932b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f20930e;
        PkItem pkItem2 = pkModule.disagree;
        aVar4.f20933c = pkItem2.last_username;
        aVar4.f20934d = pkItem2.pk_icon;
        aVar4.f20935e = pkItem2.has_clicked.longValue() == 1;
        this.f20930e.f20936f = pkModule.disagree.pk_index.longValue();
        this.f20930e.f20937g = pkModule.disagree.pk_icon_after;
    }

    public void b(tbclient.NewTopicList.PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f20927b = pkModule.pk_id.longValue();
        this.f20928c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f20929d = aVar;
        aVar.a = pkModule.agree.pk_num.longValue();
        this.f20929d.f20932b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f20929d;
        tbclient.NewTopicList.PkItem pkItem = pkModule.agree;
        aVar2.f20933c = pkItem.last_username;
        aVar2.f20934d = pkItem.pk_icon;
        aVar2.f20935e = pkItem.has_clicked.longValue() == 1;
        this.f20929d.f20936f = pkModule.agree.pk_index.longValue();
        this.f20929d.f20937g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f20930e = aVar3;
        aVar3.a = pkModule.disagree.pk_num.longValue();
        this.f20930e.f20932b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f20930e;
        tbclient.NewTopicList.PkItem pkItem2 = pkModule.disagree;
        aVar4.f20933c = pkItem2.last_username;
        aVar4.f20934d = pkItem2.pk_icon;
        aVar4.f20935e = pkItem2.has_clicked.longValue() == 1;
        this.f20930e.f20936f = pkModule.disagree.pk_index.longValue();
        this.f20930e.f20937g = pkModule.disagree.pk_icon_after;
    }

    public void c(tbclient.PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f20927b = pkModule.pk_id.longValue();
        this.f20928c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f20929d = aVar;
        aVar.a = pkModule.agree.pk_num.longValue();
        this.f20929d.f20932b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f20929d;
        tbclient.PkItem pkItem = pkModule.agree;
        aVar2.f20933c = pkItem.last_username;
        aVar2.f20934d = pkItem.pk_icon;
        aVar2.f20935e = pkItem.has_clicked.longValue() == 1;
        this.f20929d.f20936f = pkModule.agree.pk_index.longValue();
        this.f20929d.f20937g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f20930e = aVar3;
        aVar3.a = pkModule.disagree.pk_num.longValue();
        this.f20930e.f20932b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f20930e;
        tbclient.PkItem pkItem2 = pkModule.disagree;
        aVar4.f20933c = pkItem2.last_username;
        aVar4.f20934d = pkItem2.pk_icon;
        aVar4.f20935e = pkItem2.has_clicked.longValue() == 1;
        this.f20930e.f20936f = pkModule.disagree.pk_index.longValue();
        this.f20930e.f20937g = pkModule.disagree.pk_icon_after;
    }
}
