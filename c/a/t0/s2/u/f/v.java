package c.a.t0.s2.u.f;

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
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class v extends c.a.s0.x.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbEditorData.ThreadData a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.s0.x.b f23078b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23079c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23080d;

    /* loaded from: classes8.dex */
    public class a implements c.a.s0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u f23081e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ v f23082f;

        public a(v vVar, u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar, uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23082f = vVar;
            this.f23081e = uVar;
        }

        @Override // c.a.s0.x.b
        public void onAction(c.a.s0.x.a aVar) {
            u uVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (uVar = this.f23081e) == null || uVar.a() == null || aVar == null) {
                return;
            }
            if (this.f23082f.f23078b != null) {
                this.f23082f.f23078b.onAction(aVar);
            }
            int i2 = aVar.a;
            if (i2 == 18) {
                if (aVar.f14180c != null) {
                    this.f23081e.l();
                    return;
                }
                int f2 = this.f23081e.f();
                if (f2 == 0) {
                    this.f23081e.k();
                } else if (f2 != 2) {
                } else {
                    this.f23081e.h();
                }
            } else if (i2 == 20) {
                c.a.t0.w3.o0.b.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i2 == 32) {
                this.f23081e.a().sendAction(new c.a.s0.x.a(1, 11, null));
            } else if (i2 == 36) {
                if (this.f23082f.h(this.f23081e.getContext().getPageContext(), 11040)) {
                    this.f23081e.m();
                }
            } else if (i2 == 43 && !c.a.s0.u0.a.c(this.f23081e.getContext().getPageContext(), true, false)) {
                HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.f23081e.getContext().getActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                if (this.f23082f.a != null) {
                    hotSelectActivityConfig.setForumExtra(c.a.d.f.m.b.g(this.f23082f.a.getForumId(), 0L), this.f23082f.a.getFirstDir(), this.f23082f.a.getSecondDir());
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
            }
        }
    }

    public v() {
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
        this.f23079c = false;
        this.f23080d = false;
    }

    @Override // c.a.s0.x.c
    public c.a.s0.x.e b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            if (this.f23079c) {
                editorTools.setBarLauncherType(2);
            } else if (this.f23080d) {
                editorTools.setBarLauncherType(5);
            } else {
                editorTools.setBarLauncherType(3);
            }
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(c.a.t0.s2.f.CAM_X0207);
            editorTools.showLinePositionTop(true);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.showLinePositionBottom(true);
            return new u(editorTools);
        }
        return (c.a.s0.x.e) invokeL.objValue;
    }

    @Override // c.a.s0.x.c
    public void c(c.a.s0.x.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) && (eVar instanceof u)) {
            EditorTools a2 = eVar.a();
            a aVar = new a(this, (u) eVar);
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

    @Override // c.a.s0.x.c
    public void d(c.a.s0.x.e eVar) {
        CustomResponsedMessage runTask;
        c.a.s0.x.m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            EditorTools a2 = eVar.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            if (!this.f23079c) {
                arrayList.add(10);
                a2.addTool(new c.a.s0.x.r.d(a2.getContext(), 1));
            }
            if (!this.f23080d) {
                arrayList.add(6);
                arrayList.add(9);
                PbEditorData.ThreadData threadData = this.a;
                String forumName = threadData != null ? threadData.getForumName() : "";
                if (c.a.t0.w3.r0.c.a() && c.a.t0.w3.v.a(forumName, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), c.a.s0.x.m.class)) != null && (mVar = (c.a.s0.x.m) runTask.getData()) != null) {
                    mVar.f14197j = 2;
                    a2.addTool(mVar);
                }
                a2.addTool(new c.a.s0.x.o.a(a2.getContext(), 4));
                if (!this.f23079c) {
                    CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), c.a.s0.x.m.class);
                    if (runTask2 != null && runTask2.getData() != null) {
                        c.a.s0.x.m mVar2 = (c.a.s0.x.m) runTask2.getData();
                        mVar2.f14197j = 6;
                        a2.addTool(mVar2);
                    }
                    CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), c.a.s0.x.m.class);
                    if (runTask3 != null && runTask3.getData() != null) {
                        c.a.s0.x.m mVar3 = (c.a.s0.x.m) runTask3.getData();
                        mVar3.f14197j = 7;
                        a2.addTool(mVar3);
                    }
                }
                if (!"PbChosenActivity".equals(a2.getContext().getClass().getSimpleName()) && !this.f23079c) {
                    a2.addTool(new c.a.s0.x.q.a(a2.getContext(), 5));
                }
            }
            if (!this.f23079c && !this.f23080d) {
                arrayList.add(8);
            }
            a2.collect(arrayList);
            c.a.s0.x.m findToolById = a2.findToolById(5);
            if (findToolById != null) {
                findToolById.f14197j = 3;
                if (this.f23080d) {
                    findToolById.e(false);
                }
            }
            a2.build();
            if (this.f23079c || this.f23080d) {
                a2.sendAction(new c.a.s0.x.a(35, 5, Boolean.FALSE));
            }
        }
    }

    public final boolean h(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f23080d = z;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f23079c = z;
        }
    }

    public void k(c.a.s0.x.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f23078b = bVar;
        }
    }

    public void l(PbEditorData.ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, threadData) == null) {
            this.a = threadData;
        }
    }
}
