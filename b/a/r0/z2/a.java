package b.a.r0.z2;

import android.content.Intent;
import android.net.Uri;
import b.a.e.f.p.l;
import b.a.r0.d4.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.person.PersonInfoMoreDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f29414c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f29415a;

    /* renamed from: b  reason: collision with root package name */
    public PersonInfoMoreDialog f29416b;

    /* renamed from: b.a.r0.z2.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1430a implements g.InterfaceC0852g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f29417a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f29418b;

        public C1430a(a aVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29418b = aVar;
            this.f29417a = tbPageContext;
        }

        @Override // b.a.r0.d4.g.InterfaceC0852g
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f29418b.f29416b == null) {
                return;
            }
            this.f29418b.f29416b.dismiss();
            this.f29418b.f29416b = null;
            this.f29418b.f29415a = i2;
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_CLICK_STAR).param("obj_type", this.f29418b.f29415a));
            this.f29418b.o(this.f29417a);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements g.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f29419a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f29420b;

        public b(a aVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29420b = aVar;
            this.f29419a = tbPageContext;
        }

        @Override // b.a.r0.d4.g.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f29420b.f29416b == null) {
                return;
            }
            this.f29420b.f29416b.dismiss();
            this.f29420b.f29416b = null;
            if (this.f29420b.f29415a == 1 || this.f29420b.f29415a == 2) {
                this.f29420b.h(this.f29419a);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_CLICK_FEEDBACK));
                return;
            }
            this.f29420b.i(this.f29419a);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_CLICK_SCORE));
        }
    }

    /* loaded from: classes6.dex */
    public class c implements g.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f29421a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29421a = aVar;
        }

        @Override // b.a.r0.d4.g.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f29421a.f29416b == null) {
                return;
            }
            this.f29421a.f29416b.dismiss();
            this.f29421a.f29416b = null;
            if (this.f29421a.f29415a != 1 && this.f29421a.f29415a != 2) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_CLICK_CANCEL));
            } else {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_CLICK_CANCEL));
            }
        }
    }

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
        this.f29415a = 0;
    }

    public static a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f29414c == null) {
                synchronized (a.class) {
                    if (f29414c == null) {
                        f29414c = new a();
                    }
                }
            }
            return f29414c;
        }
        return (a) invokeV.objValue;
    }

    public final void h(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink((TbPageContext<?>) tbPageContext, new String[]{TbConfig.URL_FEED_BACK}, true);
    }

    public final void i(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + TbadkCoreApplication.getInst().getPackageName()));
                intent.addFlags(268435456);
                tbPageContext.getContext().startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String version = TbConfig.getVersion();
            if (version.equals(b.a.q0.s.e0.b.j().p("key_rate_version", ""))) {
                return;
            }
            b.a.q0.s.e0.b.j().x("key_rate_version", version);
            b.a.q0.s.e0.b.j().w("key_rate_version_time", new Date().getTime());
        }
    }

    public final void k(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbPageContext) == null) || tbPageContext == null || TbConfig.getVersionType() == 2) {
            return;
        }
        if (Long.valueOf(new Date().getTime()).longValue() - b.a.q0.s.e0.b.j().l("key_rate_version_time", 0L) < 86400000) {
            return;
        }
        String version = TbConfig.getVersion();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        b.a.q0.s.e0.b j = b.a.q0.s.e0.b.j();
        if (j.g("key_rate_same_version_is_score" + version + currentAccount, false)) {
            return;
        }
        b.a.q0.s.e0.b j2 = b.a.q0.s.e0.b.j();
        j2.t("key_rate_same_version_is_score" + version + currentAccount, true);
        n(tbPageContext);
    }

    public void l(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        b.a.q0.s.e0.b j = b.a.q0.s.e0.b.j();
        int k = j.k("key_rate_like_count" + currentAccount, 0) + 1;
        if (k < 3) {
            if (k == 1) {
                Long valueOf = Long.valueOf(new Date().getTime());
                b.a.q0.s.e0.b j2 = b.a.q0.s.e0.b.j();
                j2.w("key_rate_first_like_time" + currentAccount, valueOf.longValue());
                b.a.q0.s.e0.b j3 = b.a.q0.s.e0.b.j();
                j3.v("key_rate_like_count" + currentAccount, k);
                return;
            }
            b.a.q0.s.e0.b j4 = b.a.q0.s.e0.b.j();
            j4.v("key_rate_like_count" + currentAccount, k);
            return;
        }
        b.a.q0.s.e0.b j5 = b.a.q0.s.e0.b.j();
        if (Long.valueOf(new Date().getTime()).longValue() - j5.l("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
            b.a.q0.s.e0.b j6 = b.a.q0.s.e0.b.j();
            j6.v("key_rate_like_count" + currentAccount, 0);
            k(tbPageContext);
            return;
        }
        b.a.q0.s.e0.b j7 = b.a.q0.s.e0.b.j();
        j7.v("key_rate_like_count" + currentAccount, 0);
    }

    public void m(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        k(tbPageContext);
    }

    public void n(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        g gVar = new g(tbPageContext.getContext());
        gVar.x(tbPageContext.getContext().getString(R.string.is_tieba_pleased));
        gVar.n(8);
        gVar.r(0);
        int g2 = l.g(tbPageContext.getContext(), R.dimen.ds86);
        int g3 = l.g(tbPageContext.getContext(), R.dimen.ds138);
        int g4 = l.g(tbPageContext.getContext(), R.dimen.ds27);
        gVar.w(R.dimen.ds28);
        gVar.v(0, g2, 0, g4);
        gVar.p(0, 0, 0, g3);
        gVar.o(true);
        gVar.u(new C1430a(this, tbPageContext));
        PersonInfoMoreDialog personInfoMoreDialog = new PersonInfoMoreDialog(tbPageContext.getContext(), gVar.j());
        this.f29416b = personInfoMoreDialog;
        personInfoMoreDialog.setWindowDimAmount(0.7f);
        b.a.e.f.m.g.j(this.f29416b, tbPageContext);
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_DIALOG_SHOW));
    }

    public void o(TbPageContext tbPageContext) {
        g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        g gVar = new g(tbPageContext.getContext());
        int i2 = this.f29415a;
        if (i2 != 1 && i2 != 2) {
            gVar.x(tbPageContext.getContext().getString(R.string.go_shop_give_me_comment));
            cVar = new g.c(tbPageContext.getContext().getString(R.string.go_score), gVar);
        } else {
            gVar.x(tbPageContext.getContext().getString(R.string.help_my_improving_experience));
            cVar = new g.c(tbPageContext.getContext().getString(R.string.go_feedback), gVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        gVar.q(this.f29415a);
        gVar.r(0);
        gVar.n(0);
        gVar.o(false);
        l.g(tbPageContext.getContext(), R.dimen.ds42);
        int g2 = l.g(tbPageContext.getContext(), R.dimen.ds32);
        l.g(tbPageContext.getContext(), R.dimen.ds51);
        gVar.v(0, l.g(tbPageContext.getContext(), R.dimen.ds21), 0, 0);
        gVar.p(0, g2, 0, g2);
        cVar.h(new b(this, tbPageContext));
        gVar.t(new c(this));
        gVar.s(arrayList);
        PersonInfoMoreDialog personInfoMoreDialog = new PersonInfoMoreDialog(tbPageContext.getContext(), gVar.j());
        this.f29416b = personInfoMoreDialog;
        personInfoMoreDialog.setWindowDimAmount(0.7f);
        b.a.e.f.m.g.j(this.f29416b, tbPageContext);
        int i3 = this.f29415a;
        if (i3 != 1 && i3 != 2) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_DIALOG_SHOW));
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_DIALOG_SHOW));
        }
    }
}
