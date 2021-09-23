package c.a.r0.g1.k.b.c;

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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f18542a;

    /* renamed from: b  reason: collision with root package name */
    public long f18543b;

    /* renamed from: c  reason: collision with root package name */
    public long f18544c;

    /* renamed from: d  reason: collision with root package name */
    public a f18545d;

    /* renamed from: e  reason: collision with root package name */
    public a f18546e;

    /* renamed from: f  reason: collision with root package name */
    public int f18547f;

    /* loaded from: classes3.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f18548a;

        /* renamed from: b  reason: collision with root package name */
        public String f18549b;

        /* renamed from: c  reason: collision with root package name */
        public String f18550c;

        /* renamed from: d  reason: collision with root package name */
        public String f18551d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f18552e;

        /* renamed from: f  reason: collision with root package name */
        public long f18553f;

        /* renamed from: g  reason: collision with root package name */
        public String f18554g;

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
        this.f18543b = pkModule.pk_id.longValue();
        this.f18544c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f18545d = aVar;
        aVar.f18548a = pkModule.agree.pk_num.longValue();
        this.f18545d.f18549b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f18545d;
        PkItem pkItem = pkModule.agree;
        aVar2.f18550c = pkItem.last_username;
        aVar2.f18551d = pkItem.pk_icon;
        aVar2.f18552e = pkItem.has_clicked.longValue() == 1;
        this.f18545d.f18553f = pkModule.agree.pk_index.longValue();
        this.f18545d.f18554g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f18546e = aVar3;
        aVar3.f18548a = pkModule.disagree.pk_num.longValue();
        this.f18546e.f18549b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f18546e;
        PkItem pkItem2 = pkModule.disagree;
        aVar4.f18550c = pkItem2.last_username;
        aVar4.f18551d = pkItem2.pk_icon;
        aVar4.f18552e = pkItem2.has_clicked.longValue() == 1;
        this.f18546e.f18553f = pkModule.disagree.pk_index.longValue();
        this.f18546e.f18554g = pkModule.disagree.pk_icon_after;
    }

    public void b(tbclient.NewTopicList.PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f18543b = pkModule.pk_id.longValue();
        this.f18544c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f18545d = aVar;
        aVar.f18548a = pkModule.agree.pk_num.longValue();
        this.f18545d.f18549b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f18545d;
        tbclient.NewTopicList.PkItem pkItem = pkModule.agree;
        aVar2.f18550c = pkItem.last_username;
        aVar2.f18551d = pkItem.pk_icon;
        aVar2.f18552e = pkItem.has_clicked.longValue() == 1;
        this.f18545d.f18553f = pkModule.agree.pk_index.longValue();
        this.f18545d.f18554g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f18546e = aVar3;
        aVar3.f18548a = pkModule.disagree.pk_num.longValue();
        this.f18546e.f18549b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f18546e;
        tbclient.NewTopicList.PkItem pkItem2 = pkModule.disagree;
        aVar4.f18550c = pkItem2.last_username;
        aVar4.f18551d = pkItem2.pk_icon;
        aVar4.f18552e = pkItem2.has_clicked.longValue() == 1;
        this.f18546e.f18553f = pkModule.disagree.pk_index.longValue();
        this.f18546e.f18554g = pkModule.disagree.pk_icon_after;
    }

    public void c(tbclient.PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f18543b = pkModule.pk_id.longValue();
        this.f18544c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f18545d = aVar;
        aVar.f18548a = pkModule.agree.pk_num.longValue();
        this.f18545d.f18549b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f18545d;
        tbclient.PkItem pkItem = pkModule.agree;
        aVar2.f18550c = pkItem.last_username;
        aVar2.f18551d = pkItem.pk_icon;
        aVar2.f18552e = pkItem.has_clicked.longValue() == 1;
        this.f18545d.f18553f = pkModule.agree.pk_index.longValue();
        this.f18545d.f18554g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f18546e = aVar3;
        aVar3.f18548a = pkModule.disagree.pk_num.longValue();
        this.f18546e.f18549b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f18546e;
        tbclient.PkItem pkItem2 = pkModule.disagree;
        aVar4.f18550c = pkItem2.last_username;
        aVar4.f18551d = pkItem2.pk_icon;
        aVar4.f18552e = pkItem2.has_clicked.longValue() == 1;
        this.f18546e.f18553f = pkModule.disagree.pk_index.longValue();
        this.f18546e.f18554g = pkModule.disagree.pk_icon_after;
    }
}
