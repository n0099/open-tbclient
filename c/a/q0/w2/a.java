package c.a.q0.w2;

import android.content.Intent;
import android.net.Uri;
import c.a.e.e.p.l;
import c.a.q0.a4.g;
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
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f28171c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f28172a;

    /* renamed from: b  reason: collision with root package name */
    public PersonInfoMoreDialog f28173b;

    /* renamed from: c.a.q0.w2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1312a implements g.InterfaceC0738g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f28174a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f28175b;

        public C1312a(a aVar, TbPageContext tbPageContext) {
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
            this.f28175b = aVar;
            this.f28174a = tbPageContext;
        }

        @Override // c.a.q0.a4.g.InterfaceC0738g
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f28175b.f28173b == null) {
                return;
            }
            this.f28175b.f28173b.dismiss();
            this.f28175b.f28173b = null;
            this.f28175b.f28172a = i2;
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_CLICK_STAR).param("obj_type", this.f28175b.f28172a));
            this.f28175b.o(this.f28174a);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements g.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f28176a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f28177b;

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
            this.f28177b = aVar;
            this.f28176a = tbPageContext;
        }

        @Override // c.a.q0.a4.g.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f28177b.f28173b == null) {
                return;
            }
            this.f28177b.f28173b.dismiss();
            this.f28177b.f28173b = null;
            if (this.f28177b.f28172a == 1 || this.f28177b.f28172a == 2) {
                this.f28177b.h(this.f28176a);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_CLICK_FEEDBACK));
                return;
            }
            this.f28177b.i(this.f28176a);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_CLICK_SCORE));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements g.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28178a;

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
            this.f28178a = aVar;
        }

        @Override // c.a.q0.a4.g.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f28178a.f28173b == null) {
                return;
            }
            this.f28178a.f28173b.dismiss();
            this.f28178a.f28173b = null;
            if (this.f28178a.f28172a != 1 && this.f28178a.f28172a != 2) {
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
        this.f28172a = 0;
    }

    public static a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f28171c == null) {
                synchronized (a.class) {
                    if (f28171c == null) {
                        f28171c = new a();
                    }
                }
            }
            return f28171c;
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
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + TbadkCoreApplication.getInst().getPackageName()));
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
            if (version.equals(c.a.p0.s.d0.b.j().p("key_rate_version", ""))) {
                return;
            }
            c.a.p0.s.d0.b.j().x("key_rate_version", version);
            c.a.p0.s.d0.b.j().w("key_rate_version_time", new Date().getTime());
        }
    }

    public final void k(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbPageContext) == null) || tbPageContext == null || TbConfig.getVersionType() == 2) {
            return;
        }
        if (Long.valueOf(new Date().getTime()).longValue() - c.a.p0.s.d0.b.j().l("key_rate_version_time", 0L) < 86400000) {
            return;
        }
        String version = TbConfig.getVersion();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        c.a.p0.s.d0.b j2 = c.a.p0.s.d0.b.j();
        if (j2.g("key_rate_same_version_is_score" + version + currentAccount, false)) {
            return;
        }
        c.a.p0.s.d0.b j3 = c.a.p0.s.d0.b.j();
        j3.t("key_rate_same_version_is_score" + version + currentAccount, true);
        n(tbPageContext);
    }

    public void l(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        c.a.p0.s.d0.b j2 = c.a.p0.s.d0.b.j();
        int k = j2.k("key_rate_like_count" + currentAccount, 0) + 1;
        if (k < 3) {
            if (k == 1) {
                Long valueOf = Long.valueOf(new Date().getTime());
                c.a.p0.s.d0.b j3 = c.a.p0.s.d0.b.j();
                j3.w("key_rate_first_like_time" + currentAccount, valueOf.longValue());
                c.a.p0.s.d0.b j4 = c.a.p0.s.d0.b.j();
                j4.v("key_rate_like_count" + currentAccount, k);
                return;
            }
            c.a.p0.s.d0.b j5 = c.a.p0.s.d0.b.j();
            j5.v("key_rate_like_count" + currentAccount, k);
            return;
        }
        c.a.p0.s.d0.b j6 = c.a.p0.s.d0.b.j();
        if (Long.valueOf(new Date().getTime()).longValue() - j6.l("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
            c.a.p0.s.d0.b j7 = c.a.p0.s.d0.b.j();
            j7.v("key_rate_like_count" + currentAccount, 0);
            k(tbPageContext);
            return;
        }
        c.a.p0.s.d0.b j8 = c.a.p0.s.d0.b.j();
        j8.v("key_rate_like_count" + currentAccount, 0);
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
        gVar.y(tbPageContext.getContext().getString(R.string.is_tieba_pleased));
        gVar.o(8);
        gVar.s(0);
        int g2 = l.g(tbPageContext.getContext(), R.dimen.ds86);
        int g3 = l.g(tbPageContext.getContext(), R.dimen.ds138);
        int g4 = l.g(tbPageContext.getContext(), R.dimen.ds27);
        gVar.x(R.dimen.ds28);
        gVar.w(0, g2, 0, g4);
        gVar.q(0, 0, 0, g3);
        gVar.p(true);
        gVar.v(new C1312a(this, tbPageContext));
        PersonInfoMoreDialog personInfoMoreDialog = new PersonInfoMoreDialog(tbPageContext.getContext(), gVar.j());
        this.f28173b = personInfoMoreDialog;
        personInfoMoreDialog.setWindowDimAmount(0.7f);
        c.a.e.e.m.g.j(this.f28173b, tbPageContext);
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_DIALOG_SHOW));
    }

    public void o(TbPageContext tbPageContext) {
        g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        g gVar = new g(tbPageContext.getContext());
        int i2 = this.f28172a;
        if (i2 != 1 && i2 != 2) {
            gVar.y(tbPageContext.getContext().getString(R.string.go_shop_give_me_comment));
            cVar = new g.c(tbPageContext.getContext().getString(R.string.go_score), gVar);
        } else {
            gVar.y(tbPageContext.getContext().getString(R.string.help_my_improving_experience));
            cVar = new g.c(tbPageContext.getContext().getString(R.string.go_feedback), gVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        gVar.r(this.f28172a);
        gVar.s(0);
        gVar.o(0);
        gVar.p(false);
        l.g(tbPageContext.getContext(), R.dimen.ds42);
        int g2 = l.g(tbPageContext.getContext(), R.dimen.ds32);
        l.g(tbPageContext.getContext(), R.dimen.ds51);
        gVar.w(0, l.g(tbPageContext.getContext(), R.dimen.ds21), 0, 0);
        gVar.q(0, g2, 0, g2);
        cVar.h(new b(this, tbPageContext));
        gVar.u(new c(this));
        gVar.t(arrayList);
        PersonInfoMoreDialog personInfoMoreDialog = new PersonInfoMoreDialog(tbPageContext.getContext(), gVar.j());
        this.f28173b = personInfoMoreDialog;
        personInfoMoreDialog.setWindowDimAmount(0.7f);
        c.a.e.e.m.g.j(this.f28173b, tbPageContext);
        int i3 = this.f28172a;
        if (i3 != 1 && i3 != 2) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_DIALOG_SHOW));
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_DIALOG_SHOW));
        }
    }
}
