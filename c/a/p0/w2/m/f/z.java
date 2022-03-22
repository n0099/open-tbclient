package c.a.p0.w2.m.f;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class z extends c.a.o0.w.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbEditorData.ThreadData a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.o0.w.b f20352b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f20353c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f20354d;

    /* loaded from: classes3.dex */
    public class a implements c.a.o0.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f20355b;

        public a(z zVar, y yVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar, yVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20355b = zVar;
            this.a = yVar;
        }

        @Override // c.a.o0.w.b
        public void onAction(c.a.o0.w.a aVar) {
            y yVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (yVar = this.a) == null || yVar.a() == null || aVar == null) {
                return;
            }
            if (this.f20355b.f20352b != null) {
                this.f20355b.f20352b.onAction(aVar);
            }
            int i = aVar.a;
            if (i == 18) {
                if (aVar.f11499c != null) {
                    this.a.l();
                    return;
                }
                int f2 = this.a.f();
                if (f2 == 0) {
                    this.a.k();
                } else if (f2 != 2) {
                } else {
                    this.a.h();
                }
            } else if (i == 20) {
                c.a.p0.a4.p0.b.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i == 32) {
                this.a.a().A(new c.a.o0.w.a(1, 11, null));
            } else if (i == 36) {
                if (this.f20355b.h(this.a.getContext().getPageContext(), 11040)) {
                    this.a.m();
                }
            } else if (i == 43 && !c.a.o0.t0.a.c(this.a.getContext().getPageContext(), true, false)) {
                HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.a.getContext().getActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                if (this.f20355b.a != null) {
                    hotSelectActivityConfig.setForumExtra(c.a.d.f.m.b.g(this.f20355b.a.getForumId(), 0L), this.f20355b.a.getFirstDir(), this.f20355b.a.getSecondDir());
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
            }
        }
    }

    public z() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20353c = false;
        this.f20354d = false;
    }

    @Override // c.a.o0.w.c
    public c.a.o0.w.e b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            if (this.f20353c) {
                editorTools.setBarLauncherType(2);
            } else if (this.f20354d) {
                editorTools.setBarLauncherType(5);
            } else {
                editorTools.setBarLauncherType(3);
            }
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.D(true);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.C(true);
            return new y(editorTools);
        }
        return (c.a.o0.w.e) invokeL.objValue;
    }

    @Override // c.a.o0.w.c
    public void c(c.a.o0.w.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) && (eVar instanceof y)) {
            EditorTools a2 = eVar.a();
            a aVar = new a(this, (y) eVar);
            a2.setActionListener(16, aVar);
            a2.setActionListener(14, aVar);
            a2.setActionListener(15, aVar);
            a2.setActionListener(24, aVar);
            a2.setActionListener(3, aVar);
            a2.setActionListener(18, aVar);
            a2.setActionListener(20, aVar);
            a2.setActionListener(10, aVar);
            a2.setActionListener(11, aVar);
            a2.setActionListener(36, aVar);
            a2.setActionListener(32, aVar);
            a2.setActionListener(43, aVar);
            a2.setActionListener(45, aVar);
        }
    }

    @Override // c.a.o0.w.c
    public void d(c.a.o0.w.e eVar) {
        CustomResponsedMessage runTask;
        c.a.o0.w.m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            EditorTools a2 = eVar.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            if (!this.f20353c) {
                arrayList.add(10);
                a2.d(new c.a.o0.w.r.d(a2.getContext(), 1));
            }
            if (!this.f20354d) {
                arrayList.add(6);
                arrayList.add(9);
                PbEditorData.ThreadData threadData = this.a;
                String forumName = threadData != null ? threadData.getForumName() : "";
                if (c.a.p0.a4.s0.c.a() && c.a.p0.a4.w.a(forumName, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), c.a.o0.w.m.class)) != null && (mVar = (c.a.o0.w.m) runTask.getData()) != null) {
                    mVar.j = 2;
                    a2.d(mVar);
                }
                a2.d(new c.a.o0.w.o.a(a2.getContext(), 4));
                if (!this.f20353c) {
                    CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), c.a.o0.w.m.class);
                    if (runTask2 != null && runTask2.getData() != null) {
                        c.a.o0.w.m mVar2 = (c.a.o0.w.m) runTask2.getData();
                        mVar2.j = 6;
                        a2.d(mVar2);
                    }
                    CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), c.a.o0.w.m.class);
                    if (runTask3 != null && runTask3.getData() != null) {
                        c.a.o0.w.m mVar3 = (c.a.o0.w.m) runTask3.getData();
                        mVar3.j = 7;
                        a2.d(mVar3);
                    }
                }
                if (!"PbChosenActivity".equals(a2.getContext().getClass().getSimpleName()) && !this.f20353c) {
                    a2.d(new c.a.o0.w.q.a(a2.getContext(), 5));
                }
            }
            if (!this.f20353c && !this.f20354d) {
                arrayList.add(8);
            }
            a2.h(arrayList);
            c.a.o0.w.m n = a2.n(5);
            if (n != null) {
                n.j = 3;
                if (this.f20354d) {
                    n.e(false);
                }
            }
            a2.f();
            if (this.f20353c || this.f20354d) {
                a2.A(new c.a.o0.w.a(35, 5, Boolean.FALSE));
            }
        }
    }

    public final boolean h(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f20354d = z;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f20353c = z;
        }
    }

    public void k(c.a.o0.w.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f20352b = bVar;
        }
    }

    public void l(PbEditorData.ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, threadData) == null) {
            this.a = threadData;
        }
    }
}
