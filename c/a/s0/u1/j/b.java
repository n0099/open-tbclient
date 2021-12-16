package c.a.s0.u1.j;

import android.content.Context;
import c.a.d.f.p.m;
import c.a.r0.x.e;
import c.a.r0.x.r.d;
import c.a.r0.x.x.f;
import c.a.s0.v3.v;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class b extends c.a.r0.x.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f24539b;

    /* renamed from: c  reason: collision with root package name */
    public String f24540c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f24541d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f24542e;

    /* loaded from: classes8.dex */
    public class a implements c.a.r0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.u1.j.a f24543e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f24544f;

        public a(b bVar, c.a.s0.u1.j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24544f = bVar;
            this.f24543e = aVar;
        }

        @Override // c.a.r0.x.b
        public void onAction(c.a.r0.x.a aVar) {
            c.a.s0.u1.j.a aVar2;
            int size;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (aVar2 = this.f24543e) == null || aVar2.a() == null || aVar == null) {
                return;
            }
            int i2 = aVar.a;
            if (i2 == 4) {
                this.f24543e.m0(aVar.f14019c.toString());
                Object obj = aVar.f14019c;
                if (obj instanceof SpanGroupManager) {
                    this.f24543e.q0((SpanGroupManager) obj);
                }
                this.f24544f.f24541d = false;
            } else if (i2 == 18) {
                boolean g2 = c.a.r0.s.g0.b.j().g("key_post_thread_has_request_location", false);
                if (aVar.f14019c != null) {
                    if (g2) {
                        this.f24543e.Q();
                        return;
                    }
                    return;
                }
                int t = this.f24543e.t();
                if (t == 0) {
                    this.f24543e.J(g2);
                } else if (t != 2) {
                } else {
                    this.f24543e.A();
                }
            } else if (i2 == 20) {
                this.f24543e.a().sendAction(new c.a.r0.x.a(2, 7, null));
                c.a.s0.v3.o0.b.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i2 == 32) {
                this.f24543e.a().sendAction(new c.a.r0.x.a(1, 11, null));
            } else if (i2 == 36) {
                if (this.f24544f.j(this.f24543e.getContext(), 11040)) {
                    this.f24543e.Z();
                }
            } else if (i2 == 7) {
                m.L(TbadkCoreApplication.getInst().getContext(), R.string.over_limit_tip);
                this.f24544f.f24541d = true;
            } else if (i2 == 8) {
                if (this.f24544f.j(this.f24543e.getContext(), 11001)) {
                    this.f24543e.L(null, null);
                }
            } else if (i2 == 10) {
                Object obj2 = aVar.f14019c;
                if (obj2 instanceof VoiceData$VoiceModel) {
                    this.f24543e.t0((VoiceData$VoiceModel) obj2);
                    this.f24543e.z(true, null);
                }
            } else if (i2 != 11) {
                switch (i2) {
                    case 14:
                        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.f24543e.getContext().getPageActivity(), this.f24543e.y().toJsonString(), true, true);
                        if (!StringUtils.isNull(this.f24544f.f24539b, true)) {
                            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.f24544f.f24539b);
                        }
                        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                        if (c.a.r0.x.x.a.a().b() == 1) {
                            albumFloatActivityConfig.setRequestFrom(2);
                            if (this.f24543e.y() != null) {
                                this.f24543e.y().setMaxImagesAllowed(1);
                            }
                        } else if (this.f24543e.y() != null) {
                            this.f24543e.y().setMaxImagesAllowed(9);
                        }
                        m.w(this.f24543e.getContext().getPageActivity(), this.f24543e.getContext().getPageActivity().getCurrentFocus());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                        return;
                    case 15:
                        int intValue = ((Integer) aVar.f14019c).intValue();
                        if (this.f24543e.y() != null && this.f24543e.y().getChosedFiles() != null && (size = this.f24543e.y().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f24543e.getContext().getPageActivity(), 12012, this.f24543e.y(), intValue)));
                            return;
                        }
                        return;
                    case 16:
                        if (this.f24544f.f24541d) {
                            m.L(TbadkCoreApplication.getInst().getContext(), R.string.over_limit_tip);
                        }
                        if (this.f24544f.j(this.f24543e.getContext(), 11025)) {
                            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.f24543e.getContext().getPageActivity(), 12004, true);
                            if (this.f24543e.x() != null) {
                                atListActivityConfig.setSelectedAtList(this.f24543e.x().u());
                            }
                            atListActivityConfig.setFromTid(this.f24544f.f24540c);
                            atListActivityConfig.setFromFid(this.f24544f.f24539b);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem.addParam("tid", this.f24544f.f24540c);
                            statisticItem.addParam("fid", this.f24544f.f24539b);
                            TiebaStatic.log(statisticItem);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else {
                this.f24543e.t0(null);
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
                return;
            }
        }
        this.f24541d = false;
    }

    @Override // c.a.r0.x.c
    public e b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBarLauncherType(this.f24542e ? 2 : 3);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.setDeskBackgroundColorId(R.color.CAM_X0207);
            editorTools.showLinePositionTop(false);
            editorTools.setMoreButtonAtEnd(true);
            return new c.a.s0.u1.j.a(editorTools);
        }
        return (e) invokeL.objValue;
    }

    @Override // c.a.r0.x.c
    public void c(e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) && (eVar instanceof c.a.s0.u1.j.a)) {
            EditorTools a2 = eVar.a();
            a aVar = new a(this, (c.a.s0.u1.j.a) eVar);
            a2.setActionListener(5, aVar);
            a2.setActionListener(4, aVar);
            a2.setActionListener(7, aVar);
            a2.setActionListener(16, aVar);
            a2.setActionListener(14, aVar);
            a2.setActionListener(15, aVar);
            a2.setActionListener(8, aVar);
            a2.setActionListener(18, aVar);
            a2.setActionListener(20, aVar);
            a2.setActionListener(10, aVar);
            a2.setActionListener(11, aVar);
            a2.setActionListener(36, aVar);
            a2.setActionListener(32, aVar);
        }
    }

    @Override // c.a.r0.x.c
    public void d(e eVar) {
        CustomResponsedMessage runTask;
        c.a.r0.x.m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            EditorTools a2 = eVar.a();
            if (c.a.s0.v3.r0.c.a() && v.a(this.a, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), c.a.r0.x.m.class)) != null && (mVar = (c.a.r0.x.m) runTask.getData()) != null) {
                mVar.f14037j = 2;
                a2.addTool(mVar);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a2.collect(arrayList);
            c.a.r0.x.m findToolById = a2.findToolById(5);
            if (findToolById != null) {
                findToolById.e(!this.f24542e);
                findToolById.f14037j = this.f24542e ? 1 : 3;
            }
            c.a.r0.x.o.a aVar = new c.a.r0.x.o.a(a2.getContext(), 4);
            aVar.f14034g = false;
            a2.addTool(aVar);
            if (!this.f24542e) {
                a2.addTool(new d(a2.getContext(), 1));
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), c.a.r0.x.m.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    c.a.r0.x.m mVar2 = (c.a.r0.x.m) runTask2.getData();
                    mVar2.f14037j = 6;
                    a2.addTool(mVar2);
                }
                a2.addTool(new f(a2.getContext(), false, true, 12004));
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), c.a.r0.x.m.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    c.a.r0.x.m mVar3 = (c.a.r0.x.m) runTask3.getData();
                    mVar3.f14037j = 7;
                    a2.addTool(mVar3);
                }
                a2.addTool(new c.a.r0.x.q.a(a2.getContext(), 5));
            } else {
                a2.addTool(new f(a2.getContext(), false, false, 12004));
            }
            a2.build();
        }
    }

    public final boolean j(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i2)) == null) {
            if (c.a.r0.k0.f.k()) {
                return true;
            }
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
            return false;
        }
        return invokeLI.booleanValue;
    }

    public void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.a = str;
            this.f24539b = str2;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f24540c = str;
        }
    }
}
