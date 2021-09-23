package c.a.r0.j2.k.e;

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
public class v extends c.a.q0.x.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbEditorData.ThreadData f20335a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.x.b f20336b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f20337c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f20338d;

    /* loaded from: classes3.dex */
    public class a implements c.a.q0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u f20339e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ v f20340f;

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
            this.f20340f = vVar;
            this.f20339e = uVar;
        }

        @Override // c.a.q0.x.b
        public void onAction(c.a.q0.x.a aVar) {
            u uVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (uVar = this.f20339e) == null || uVar.a() == null || aVar == null) {
                return;
            }
            if (this.f20340f.f20336b != null) {
                this.f20340f.f20336b.onAction(aVar);
            }
            int i2 = aVar.f15086a;
            if (i2 == 18) {
                if (aVar.f15088c != null) {
                    this.f20339e.m();
                    return;
                }
                int g2 = this.f20339e.g();
                if (g2 == 0) {
                    this.f20339e.l();
                } else if (g2 != 2) {
                } else {
                    this.f20339e.i();
                }
            } else if (i2 == 20) {
                c.a.r0.j3.n0.b.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i2 == 32) {
                this.f20339e.a().sendAction(new c.a.q0.x.a(1, 11, null));
            } else if (i2 == 36) {
                if (this.f20340f.h(this.f20339e.f().getPageContext(), 11040)) {
                    this.f20339e.n();
                }
            } else if (i2 == 43 && !c.a.q0.t0.b.c(this.f20339e.f().getPageContext(), true, false)) {
                HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.f20339e.f().getActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                if (this.f20340f.f20335a != null) {
                    hotSelectActivityConfig.setForumExtra(c.a.e.e.m.b.g(this.f20340f.f20335a.getForumId(), 0L), this.f20340f.f20335a.getFirstDir(), this.f20340f.f20335a.getSecondDir());
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
        this.f20337c = false;
        this.f20338d = false;
    }

    @Override // c.a.q0.x.c
    public c.a.q0.x.e b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            if (this.f20337c) {
                editorTools.setBarLauncherType(2);
            } else if (this.f20338d) {
                editorTools.setBarLauncherType(5);
            } else {
                editorTools.setBarLauncherType(3);
            }
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.showLinePositionTop(true);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.showLinePositionBottom(true);
            return new u(editorTools);
        }
        return (c.a.q0.x.e) invokeL.objValue;
    }

    @Override // c.a.q0.x.c
    public void c(c.a.q0.x.e eVar) {
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

    @Override // c.a.q0.x.c
    public void d(c.a.q0.x.e eVar) {
        CustomResponsedMessage runTask;
        c.a.q0.x.m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            EditorTools a2 = eVar.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            if (!this.f20337c) {
                arrayList.add(10);
                a2.addTool(new c.a.q0.x.r.d(a2.getContext(), 1));
            }
            if (!this.f20338d) {
                arrayList.add(6);
                arrayList.add(9);
                PbEditorData.ThreadData threadData = this.f20335a;
                String forumName = threadData != null ? threadData.getForumName() : "";
                if (c.a.r0.j3.q0.c.a() && c.a.r0.j3.v.a(forumName, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), c.a.q0.x.m.class)) != null && (mVar = (c.a.q0.x.m) runTask.getData()) != null) {
                    mVar.f15101j = 2;
                    a2.addTool(mVar);
                }
                a2.addTool(new c.a.q0.x.o.a(a2.getContext(), 4));
                if (!this.f20337c) {
                    CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), c.a.q0.x.m.class);
                    if (runTask2 != null && runTask2.getData() != null) {
                        c.a.q0.x.m mVar2 = (c.a.q0.x.m) runTask2.getData();
                        mVar2.f15101j = 6;
                        a2.addTool(mVar2);
                    }
                    CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), c.a.q0.x.m.class);
                    if (runTask3 != null && runTask3.getData() != null) {
                        c.a.q0.x.m mVar3 = (c.a.q0.x.m) runTask3.getData();
                        mVar3.f15101j = 7;
                        a2.addTool(mVar3);
                    }
                }
                if (!"PbChosenActivity".equals(a2.getContext().getClass().getSimpleName()) && !this.f20337c) {
                    a2.addTool(new c.a.q0.x.q.a(a2.getContext(), 5));
                }
            }
            if (!this.f20337c && !this.f20338d) {
                arrayList.add(8);
            }
            a2.collect(arrayList);
            c.a.q0.x.m findToolById = a2.findToolById(5);
            if (findToolById != null) {
                findToolById.f15101j = 3;
                if (this.f20338d) {
                    findToolById.f(false);
                }
            }
            a2.build();
            if (this.f20337c || this.f20338d) {
                a2.sendAction(new c.a.q0.x.a(35, 5, Boolean.FALSE));
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
            this.f20338d = z;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f20337c = z;
        }
    }

    public void k(c.a.q0.x.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f20336b = bVar;
        }
    }

    public void l(PbEditorData.ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, threadData) == null) {
            this.f20335a = threadData;
        }
    }
}
