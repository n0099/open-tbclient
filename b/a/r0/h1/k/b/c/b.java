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
    public long f19108a;

    /* renamed from: b  reason: collision with root package name */
    public long f19109b;

    /* renamed from: c  reason: collision with root package name */
    public long f19110c;

    /* renamed from: d  reason: collision with root package name */
    public a f19111d;

    /* renamed from: e  reason: collision with root package name */
    public a f19112e;

    /* renamed from: f  reason: collision with root package name */
    public int f19113f;

    /* loaded from: classes4.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f19114a;

        /* renamed from: b  reason: collision with root package name */
        public String f19115b;

        /* renamed from: c  reason: collision with root package name */
        public String f19116c;

        /* renamed from: d  reason: collision with root package name */
        public String f19117d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f19118e;

        /* renamed from: f  reason: collision with root package name */
        public long f19119f;

        /* renamed from: g  reason: collision with root package name */
        public String f19120g;

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
        this.f19109b = pkModule.pk_id.longValue();
        this.f19110c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f19111d = aVar;
        aVar.f19114a = pkModule.agree.pk_num.longValue();
        this.f19111d.f19115b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f19111d;
        PkItem pkItem = pkModule.agree;
        aVar2.f19116c = pkItem.last_username;
        aVar2.f19117d = pkItem.pk_icon;
        aVar2.f19118e = pkItem.has_clicked.longValue() == 1;
        this.f19111d.f19119f = pkModule.agree.pk_index.longValue();
        this.f19111d.f19120g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f19112e = aVar3;
        aVar3.f19114a = pkModule.disagree.pk_num.longValue();
        this.f19112e.f19115b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f19112e;
        PkItem pkItem2 = pkModule.disagree;
        aVar4.f19116c = pkItem2.last_username;
        aVar4.f19117d = pkItem2.pk_icon;
        aVar4.f19118e = pkItem2.has_clicked.longValue() == 1;
        this.f19112e.f19119f = pkModule.disagree.pk_index.longValue();
        this.f19112e.f19120g = pkModule.disagree.pk_icon_after;
    }

    public void b(tbclient.NewTopicList.PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f19109b = pkModule.pk_id.longValue();
        this.f19110c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f19111d = aVar;
        aVar.f19114a = pkModule.agree.pk_num.longValue();
        this.f19111d.f19115b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f19111d;
        tbclient.NewTopicList.PkItem pkItem = pkModule.agree;
        aVar2.f19116c = pkItem.last_username;
        aVar2.f19117d = pkItem.pk_icon;
        aVar2.f19118e = pkItem.has_clicked.longValue() == 1;
        this.f19111d.f19119f = pkModule.agree.pk_index.longValue();
        this.f19111d.f19120g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f19112e = aVar3;
        aVar3.f19114a = pkModule.disagree.pk_num.longValue();
        this.f19112e.f19115b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f19112e;
        tbclient.NewTopicList.PkItem pkItem2 = pkModule.disagree;
        aVar4.f19116c = pkItem2.last_username;
        aVar4.f19117d = pkItem2.pk_icon;
        aVar4.f19118e = pkItem2.has_clicked.longValue() == 1;
        this.f19112e.f19119f = pkModule.disagree.pk_index.longValue();
        this.f19112e.f19120g = pkModule.disagree.pk_icon_after;
    }

    public void c(tbclient.PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f19109b = pkModule.pk_id.longValue();
        this.f19110c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f19111d = aVar;
        aVar.f19114a = pkModule.agree.pk_num.longValue();
        this.f19111d.f19115b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f19111d;
        tbclient.PkItem pkItem = pkModule.agree;
        aVar2.f19116c = pkItem.last_username;
        aVar2.f19117d = pkItem.pk_icon;
        aVar2.f19118e = pkItem.has_clicked.longValue() == 1;
        this.f19111d.f19119f = pkModule.agree.pk_index.longValue();
        this.f19111d.f19120g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f19112e = aVar3;
        aVar3.f19114a = pkModule.disagree.pk_num.longValue();
        this.f19112e.f19115b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f19112e;
        tbclient.PkItem pkItem2 = pkModule.disagree;
        aVar4.f19116c = pkItem2.last_username;
        aVar4.f19117d = pkItem2.pk_icon;
        aVar4.f19118e = pkItem2.has_clicked.longValue() == 1;
        this.f19112e.f19119f = pkModule.disagree.pk_index.longValue();
        this.f19112e.f19120g = pkModule.disagree.pk_icon_after;
    }
}
