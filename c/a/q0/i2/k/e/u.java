package c.a.q0.i2.k.e;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
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
public class u extends c.a.p0.x.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbEditorData.ThreadData f19620a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.x.b f19621b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f19622c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f19623d;

    /* loaded from: classes3.dex */
    public class a implements c.a.p0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t f19624e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ u f19625f;

        public a(u uVar, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19625f = uVar;
            this.f19624e = tVar;
        }

        @Override // c.a.p0.x.b
        public void onAction(c.a.p0.x.a aVar) {
            t tVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (tVar = this.f19624e) == null || tVar.a() == null || aVar == null) {
                return;
            }
            if (this.f19625f.f19621b != null) {
                this.f19625f.f19621b.onAction(aVar);
            }
            int i2 = aVar.f15086a;
            if (i2 == 16) {
                if (this.f19625f.h(this.f19624e.f().getPageContext(), 11025)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.f19624e.f().getActivity(), 12004, true)));
                }
            } else if (i2 == 18) {
                if (aVar.f15088c != null) {
                    this.f19624e.m();
                    return;
                }
                int g2 = this.f19624e.g();
                if (g2 == 0) {
                    this.f19624e.l();
                } else if (g2 != 2) {
                } else {
                    this.f19624e.i();
                }
            } else if (i2 == 20) {
                c.a.q0.i3.n0.b.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i2 == 32) {
                this.f19624e.a().sendAction(new c.a.p0.x.a(1, 11, null));
            } else if (i2 == 36) {
                if (this.f19625f.h(this.f19624e.f().getPageContext(), 11040)) {
                    this.f19624e.n();
                }
            } else if (i2 == 43 && !c.a.p0.r0.b.c(this.f19624e.f().getPageContext(), true, false)) {
                HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.f19624e.f().getActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                if (this.f19625f.f19620a != null) {
                    hotSelectActivityConfig.setForumExtra(c.a.e.e.m.b.f(this.f19625f.f19620a.getForumId(), 0L), this.f19625f.f19620a.getFirstDir(), this.f19625f.f19620a.getSecondDir());
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
            }
        }
    }

    public u() {
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
        this.f19622c = false;
        this.f19623d = false;
    }

    @Override // c.a.p0.x.c
    public c.a.p0.x.e b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            if (this.f19622c) {
                editorTools.setBarLauncherType(2);
            } else if (this.f19623d) {
                editorTools.setBarLauncherType(5);
            } else {
                editorTools.setBarLauncherType(3);
            }
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.showLinePositionTop(true);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.showLinePositionBottom(true);
            return new t(editorTools);
        }
        return (c.a.p0.x.e) invokeL.objValue;
    }

    @Override // c.a.p0.x.c
    public void c(c.a.p0.x.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) && (eVar instanceof t)) {
            EditorTools a2 = eVar.a();
            a aVar = new a(this, (t) eVar);
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

    @Override // c.a.p0.x.c
    public void d(c.a.p0.x.e eVar) {
        CustomResponsedMessage runTask;
        c.a.p0.x.m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            EditorTools a2 = eVar.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            if (!this.f19622c) {
                arrayList.add(10);
                a2.addTool(new c.a.p0.x.r.d(a2.getContext(), 1));
            }
            if (!this.f19623d) {
                arrayList.add(6);
                arrayList.add(9);
                PbEditorData.ThreadData threadData = this.f19620a;
                String forumName = threadData != null ? threadData.getForumName() : "";
                if (c.a.q0.i3.q0.c.a() && c.a.q0.i3.u.a(forumName, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), c.a.p0.x.m.class)) != null && (mVar = (c.a.p0.x.m) runTask.getData()) != null) {
                    mVar.f15101j = 2;
                    a2.addTool(mVar);
                }
                a2.addTool(new c.a.p0.x.o.a(a2.getContext(), 4));
                if (!this.f19622c) {
                    CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), c.a.p0.x.m.class);
                    if (runTask2 != null && runTask2.getData() != null) {
                        c.a.p0.x.m mVar2 = (c.a.p0.x.m) runTask2.getData();
                        mVar2.f15101j = 6;
                        a2.addTool(mVar2);
                    }
                    CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), c.a.p0.x.m.class);
                    if (runTask3 != null && runTask3.getData() != null) {
                        c.a.p0.x.m mVar3 = (c.a.p0.x.m) runTask3.getData();
                        mVar3.f15101j = 7;
                        a2.addTool(mVar3);
                    }
                }
                if (!"PbChosenActivity".equals(a2.getContext().getClass().getSimpleName()) && !this.f19622c) {
                    a2.addTool(new c.a.p0.x.q.a(a2.getContext(), 5));
                }
            }
            if (!this.f19622c && !this.f19623d) {
                arrayList.add(8);
            }
            a2.collect(arrayList);
            c.a.p0.x.m findToolById = a2.findToolById(5);
            if (findToolById != null) {
                findToolById.f15101j = 3;
                if (this.f19623d) {
                    findToolById.f(false);
                }
            }
            a2.build();
            if (this.f19622c || this.f19623d) {
                a2.sendAction(new c.a.p0.x.a(35, 5, Boolean.FALSE));
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
            this.f19623d = z;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f19622c = z;
        }
    }

    public void k(c.a.p0.x.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f19621b = bVar;
        }
    }

    public void l(PbEditorData.ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, threadData) == null) {
            this.f19620a = threadData;
        }
    }
}
