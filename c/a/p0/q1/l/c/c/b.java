package c.a.p0.q1.l.c.c;

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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f17589b;

    /* renamed from: c  reason: collision with root package name */
    public long f17590c;

    /* renamed from: d  reason: collision with root package name */
    public a f17591d;

    /* renamed from: e  reason: collision with root package name */
    public a f17592e;

    /* renamed from: f  reason: collision with root package name */
    public int f17593f;

    /* loaded from: classes2.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public String f17594b;

        /* renamed from: c  reason: collision with root package name */
        public String f17595c;

        /* renamed from: d  reason: collision with root package name */
        public String f17596d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f17597e;

        /* renamed from: f  reason: collision with root package name */
        public long f17598f;

        /* renamed from: g  reason: collision with root package name */
        public String f17599g;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.f17589b = pkModule.pk_id.longValue();
        this.f17590c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f17591d = aVar;
        aVar.a = pkModule.agree.pk_num.longValue();
        this.f17591d.f17594b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1403) : pkModule.agree.pk_desc;
        a aVar2 = this.f17591d;
        PkItem pkItem = pkModule.agree;
        aVar2.f17595c = pkItem.last_username;
        aVar2.f17596d = pkItem.pk_icon;
        aVar2.f17597e = pkItem.has_clicked.longValue() == 1;
        this.f17591d.f17598f = pkModule.agree.pk_index.longValue();
        this.f17591d.f17599g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f17592e = aVar3;
        aVar3.a = pkModule.disagree.pk_num.longValue();
        this.f17592e.f17594b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1402) : pkModule.disagree.pk_desc;
        a aVar4 = this.f17592e;
        PkItem pkItem2 = pkModule.disagree;
        aVar4.f17595c = pkItem2.last_username;
        aVar4.f17596d = pkItem2.pk_icon;
        aVar4.f17597e = pkItem2.has_clicked.longValue() == 1;
        this.f17592e.f17598f = pkModule.disagree.pk_index.longValue();
        this.f17592e.f17599g = pkModule.disagree.pk_icon_after;
    }

    public void b(tbclient.NewTopicList.PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f17589b = pkModule.pk_id.longValue();
        this.f17590c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f17591d = aVar;
        aVar.a = pkModule.agree.pk_num.longValue();
        this.f17591d.f17594b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1403) : pkModule.agree.pk_desc;
        a aVar2 = this.f17591d;
        tbclient.NewTopicList.PkItem pkItem = pkModule.agree;
        aVar2.f17595c = pkItem.last_username;
        aVar2.f17596d = pkItem.pk_icon;
        aVar2.f17597e = pkItem.has_clicked.longValue() == 1;
        this.f17591d.f17598f = pkModule.agree.pk_index.longValue();
        this.f17591d.f17599g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f17592e = aVar3;
        aVar3.a = pkModule.disagree.pk_num.longValue();
        this.f17592e.f17594b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1402) : pkModule.disagree.pk_desc;
        a aVar4 = this.f17592e;
        tbclient.NewTopicList.PkItem pkItem2 = pkModule.disagree;
        aVar4.f17595c = pkItem2.last_username;
        aVar4.f17596d = pkItem2.pk_icon;
        aVar4.f17597e = pkItem2.has_clicked.longValue() == 1;
        this.f17592e.f17598f = pkModule.disagree.pk_index.longValue();
        this.f17592e.f17599g = pkModule.disagree.pk_icon_after;
    }

    public void c(tbclient.PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f17589b = pkModule.pk_id.longValue();
        this.f17590c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f17591d = aVar;
        aVar.a = pkModule.agree.pk_num.longValue();
        this.f17591d.f17594b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1403) : pkModule.agree.pk_desc;
        a aVar2 = this.f17591d;
        tbclient.PkItem pkItem = pkModule.agree;
        aVar2.f17595c = pkItem.last_username;
        aVar2.f17596d = pkItem.pk_icon;
        aVar2.f17597e = pkItem.has_clicked.longValue() == 1;
        this.f17591d.f17598f = pkModule.agree.pk_index.longValue();
        this.f17591d.f17599g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f17592e = aVar3;
        aVar3.a = pkModule.disagree.pk_num.longValue();
        this.f17592e.f17594b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1402) : pkModule.disagree.pk_desc;
        a aVar4 = this.f17592e;
        tbclient.PkItem pkItem2 = pkModule.disagree;
        aVar4.f17595c = pkItem2.last_username;
        aVar4.f17596d = pkItem2.pk_icon;
        aVar4.f17597e = pkItem2.has_clicked.longValue() == 1;
        this.f17592e.f17598f = pkModule.disagree.pk_index.longValue();
        this.f17592e.f17599g = pkModule.disagree.pk_icon_after;
    }
}
