package b.a.r0.r3;

import b.a.q0.s.s.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f23068e;

        public a(b.a.q0.s.s.a aVar) {
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
            this.f23068e = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f23068e.dismiss();
            }
        }
    }

    /* renamed from: b.a.r0.r3.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1130b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f23069e;

        public C1130b(b.a.q0.s.s.a aVar) {
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
            this.f23069e = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f23069e.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f23070e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f23071f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f23072g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f23073h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f23074i;
        public final /* synthetic */ String j;

        public c(b.a.q0.s.s.a aVar, int i2, TbPageContext tbPageContext, int i3, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), tbPageContext, Integer.valueOf(i3), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23070e = aVar;
            this.f23071f = i2;
            this.f23072g = tbPageContext;
            this.f23073h = i3;
            this.f23074i = str;
            this.j = str2;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f23070e.dismiss();
                int i3 = this.f23071f;
                String str = null;
                if (i3 == 1) {
                    i2 = 10;
                    TiebaStatic.log("c10271");
                    str = "4011001001";
                } else if (i3 == 2) {
                    i2 = 13;
                    TiebaStatic.log("c10282");
                    str = "4012001001";
                } else if (i3 == 3) {
                    i2 = 11;
                    TiebaStatic.log("c10276");
                    str = "4011001002";
                } else if (i3 == 4) {
                    i2 = 14;
                    TiebaStatic.log("c10285");
                    str = "4012001002";
                } else if (i3 != 5) {
                    i2 = i3 != 7 ? 0 : 22;
                } else {
                    i2 = 18;
                    TiebaStatic.log("c10767");
                }
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.f23072g.getPageActivity(), TbadkCoreApplication.getCurrentMemberType(), "", i2);
                if (!StringUtils.isNULL(str)) {
                    memberPayActivityConfig.setSceneId(str);
                }
                memberPayActivityConfig.setFromScence(this.f23073h);
                memberPayActivityConfig.setReferPageClickZone(this.f23074i, this.j);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f23075e;

        public d(b.a.q0.s.s.a aVar) {
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
            this.f23075e = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f23075e.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f23076e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f23077f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f23078g;

        public e(b.a.q0.s.s.a aVar, String str, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23076e = aVar;
            this.f23077f = str;
            this.f23078g = tbPageContext;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f23076e.dismiss();
                if (this.f23077f == null) {
                    return;
                }
                TbadkCoreApplication.getInst().setThemeWebviewOpen(true);
                b.a.q0.m.a.k(this.f23078g.getPageActivity(), this.f23077f);
            }
        }
    }

    public static boolean a(DressItemData dressItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, dressItemData)) == null) {
            int freeUserLevel = dressItemData.getFreeUserLevel();
            if (dressItemData.isDefault() || freeUserLevel == 0) {
                return true;
            }
            return freeUserLevel == 100 ? dressItemData.getActivityFinish() != 0 : freeUserLevel == 101 ? TbadkCoreApplication.getCurrentMemberType() == 3 : TbadkCoreApplication.getCurrentMemberType() >= 2 && TbadkCoreApplication.getCurrentVipLevel() >= freeUserLevel;
        }
        return invokeL.booleanValue;
    }

    public static void b(TbPageContext<?> tbPageContext, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65537, null, tbPageContext, i2, str) == null) || tbPageContext == null) {
            return;
        }
        b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(tbPageContext.getPageActivity());
        aVar.setMessageId(R.string.tip_download_activity_require);
        aVar.setNegativeButton(R.string.cancel, new d(aVar));
        aVar.setPositiveButton(R.string.tip_download_activity_in, new e(aVar, str, tbPageContext));
        aVar.create(tbPageContext);
        aVar.show();
    }

    public static void c(TbPageContext<?> tbPageContext, int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{tbPageContext, Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) || tbPageContext == null) {
            return;
        }
        b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(tbPageContext.getPageActivity());
        aVar.setButtonTextColor(R.color.CAM_X0305);
        aVar.setTitle(str);
        a aVar2 = new a(aVar);
        aVar.setNegativeButton(R.string.cancel, aVar2);
        aVar.setPositiveButton(R.string.know, aVar2);
        aVar.create(tbPageContext);
        aVar.show();
    }

    public static void d(TbPageContext<?> tbPageContext, int i2, String str, int i3, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{tbPageContext, Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3}) == null) || tbPageContext == null) {
            return;
        }
        b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(tbPageContext.getPageActivity());
        aVar.setButtonTextColor(R.color.CAM_X0305);
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.cancel, new C1130b(aVar));
        aVar.setPositiveButton(R.string.open_now, new c(aVar, i2, tbPageContext, i3, str2, str3));
        aVar.create(tbPageContext);
        aVar.show();
    }
}
