package c.a.t0.o1.k.c.c;

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
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f21283b;

    /* renamed from: c  reason: collision with root package name */
    public long f21284c;

    /* renamed from: d  reason: collision with root package name */
    public a f21285d;

    /* renamed from: e  reason: collision with root package name */
    public a f21286e;

    /* renamed from: f  reason: collision with root package name */
    public int f21287f;

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public String f21288b;

        /* renamed from: c  reason: collision with root package name */
        public String f21289c;

        /* renamed from: d  reason: collision with root package name */
        public String f21290d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f21291e;

        /* renamed from: f  reason: collision with root package name */
        public long f21292f;

        /* renamed from: g  reason: collision with root package name */
        public String f21293g;

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
        this.f21283b = pkModule.pk_id.longValue();
        this.f21284c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f21285d = aVar;
        aVar.a = pkModule.agree.pk_num.longValue();
        this.f21285d.f21288b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f21285d;
        PkItem pkItem = pkModule.agree;
        aVar2.f21289c = pkItem.last_username;
        aVar2.f21290d = pkItem.pk_icon;
        aVar2.f21291e = pkItem.has_clicked.longValue() == 1;
        this.f21285d.f21292f = pkModule.agree.pk_index.longValue();
        this.f21285d.f21293g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f21286e = aVar3;
        aVar3.a = pkModule.disagree.pk_num.longValue();
        this.f21286e.f21288b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f21286e;
        PkItem pkItem2 = pkModule.disagree;
        aVar4.f21289c = pkItem2.last_username;
        aVar4.f21290d = pkItem2.pk_icon;
        aVar4.f21291e = pkItem2.has_clicked.longValue() == 1;
        this.f21286e.f21292f = pkModule.disagree.pk_index.longValue();
        this.f21286e.f21293g = pkModule.disagree.pk_icon_after;
    }

    public void b(tbclient.NewTopicList.PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f21283b = pkModule.pk_id.longValue();
        this.f21284c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f21285d = aVar;
        aVar.a = pkModule.agree.pk_num.longValue();
        this.f21285d.f21288b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f21285d;
        tbclient.NewTopicList.PkItem pkItem = pkModule.agree;
        aVar2.f21289c = pkItem.last_username;
        aVar2.f21290d = pkItem.pk_icon;
        aVar2.f21291e = pkItem.has_clicked.longValue() == 1;
        this.f21285d.f21292f = pkModule.agree.pk_index.longValue();
        this.f21285d.f21293g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f21286e = aVar3;
        aVar3.a = pkModule.disagree.pk_num.longValue();
        this.f21286e.f21288b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f21286e;
        tbclient.NewTopicList.PkItem pkItem2 = pkModule.disagree;
        aVar4.f21289c = pkItem2.last_username;
        aVar4.f21290d = pkItem2.pk_icon;
        aVar4.f21291e = pkItem2.has_clicked.longValue() == 1;
        this.f21286e.f21292f = pkModule.disagree.pk_index.longValue();
        this.f21286e.f21293g = pkModule.disagree.pk_icon_after;
    }

    public void c(tbclient.PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f21283b = pkModule.pk_id.longValue();
        this.f21284c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f21285d = aVar;
        aVar.a = pkModule.agree.pk_num.longValue();
        this.f21285d.f21288b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f21285d;
        tbclient.PkItem pkItem = pkModule.agree;
        aVar2.f21289c = pkItem.last_username;
        aVar2.f21290d = pkItem.pk_icon;
        aVar2.f21291e = pkItem.has_clicked.longValue() == 1;
        this.f21285d.f21292f = pkModule.agree.pk_index.longValue();
        this.f21285d.f21293g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f21286e = aVar3;
        aVar3.a = pkModule.disagree.pk_num.longValue();
        this.f21286e.f21288b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f21286e;
        tbclient.PkItem pkItem2 = pkModule.disagree;
        aVar4.f21289c = pkItem2.last_username;
        aVar4.f21290d = pkItem2.pk_icon;
        aVar4.f21291e = pkItem2.has_clicked.longValue() == 1;
        this.f21286e.f21292f = pkModule.disagree.pk_index.longValue();
        this.f21286e.f21293g = pkModule.disagree.pk_icon_after;
    }
}
