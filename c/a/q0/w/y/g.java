package c.a.q0.w.y;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.q0.w.m;
import c.a.r0.y3.w;
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
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class g extends c.a.q0.w.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumData a;

    /* renamed from: b  reason: collision with root package name */
    public String f14057b;

    /* renamed from: c  reason: collision with root package name */
    public String f14058c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f14059d;

    /* renamed from: e  reason: collision with root package name */
    public DataModel<?> f14060e;

    /* loaded from: classes2.dex */
    public class a implements c.a.q0.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f14061e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorTools f14062f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f14063g;

        public a(g gVar, e eVar, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, eVar, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14063g = gVar;
            this.f14061e = eVar;
            this.f14062f = editorTools;
        }

        @Override // c.a.q0.w.b
        public void onAction(c.a.q0.w.a aVar) {
            e eVar;
            int size;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (eVar = this.f14061e) == null || eVar.a() == null || aVar == null) {
                return;
            }
            int i2 = aVar.a;
            if (i2 == 4) {
                this.f14061e.m0(aVar.f13989c.toString());
                Object obj = aVar.f13989c;
                if (obj instanceof SpanGroupManager) {
                    this.f14061e.q0((SpanGroupManager) obj);
                }
                this.f14063g.f14059d = false;
            } else if (i2 == 5) {
                if (this.f14062f.isToolVisible()) {
                    return;
                }
                TiebaStatic.eventStat(this.f14062f.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
            } else if (i2 == 7) {
                this.f14061e.getContext().showToast(R.string.over_limit_tip);
                this.f14063g.f14059d = true;
            } else if (i2 == 8) {
                if (this.f14063g.k(this.f14061e.getContext(), 11001)) {
                    this.f14061e.L(null, null);
                }
            } else if (i2 == 10) {
                Object obj2 = aVar.f13989c;
                if (obj2 instanceof VoiceData.VoiceModel) {
                    this.f14061e.t0((VoiceData.VoiceModel) obj2);
                    this.f14061e.z(true, null);
                }
            } else if (i2 == 11) {
                this.f14061e.t0(null);
            } else if (i2 == 18) {
                boolean h2 = c.a.q0.r.j0.b.k().h("key_post_thread_has_request_location", false);
                if (aVar.f13989c != null) {
                    if (h2) {
                        this.f14061e.Q();
                        return;
                    }
                    return;
                }
                int t = this.f14061e.t();
                if (t == 0) {
                    this.f14061e.J(h2);
                } else if (t != 2) {
                } else {
                    this.f14061e.A();
                }
            } else if (i2 == 20) {
                this.f14061e.a().sendAction(new c.a.q0.w.a(2, 7, null));
                c.a.r0.y3.p0.b.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i2 == 29) {
                this.f14061e.a().sendAction(new c.a.q0.w.a(2, 19, null));
                this.f14061e.a().sendAction(new c.a.q0.w.a(1, 2, null));
                this.f14061e.m();
            } else if (i2 == 32) {
                this.f14061e.a().sendAction(new c.a.q0.w.a(1, 11, null));
            } else if (i2 == 36) {
                if (this.f14063g.k(this.f14061e.getContext(), 11040)) {
                    this.f14061e.Z();
                }
            } else if (i2 != 43) {
                switch (i2) {
                    case 14:
                        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.f14061e.getContext().getPageActivity(), this.f14061e.y().toJsonString(), true, true);
                        if (!StringUtils.isNull(this.f14063g.f14058c, true)) {
                            albumFloatActivityConfig.getIntent().putExtra("from", this.f14063g.f14058c);
                        }
                        if (this.f14063g.a != null && !StringUtils.isNull(this.f14063g.a.getId(), true)) {
                            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.f14063g.a.getId());
                        }
                        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                        if (c.a.q0.w.y.a.a().b() == 1) {
                            albumFloatActivityConfig.setRequestFrom(2);
                            if (this.f14061e.y() != null) {
                                this.f14061e.y().setMaxImagesAllowed(1);
                            }
                        } else if (this.f14061e.y() != null) {
                            this.f14061e.y().setMaxImagesAllowed(9);
                        }
                        n.w(this.f14061e.getContext().getPageActivity(), this.f14061e.getContext().getPageActivity().getCurrentFocus());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                        return;
                    case 15:
                        int intValue = ((Integer) aVar.f13989c).intValue();
                        if (this.f14061e.y() != null && this.f14061e.y().getChosedFiles() != null && (size = this.f14061e.y().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f14061e.getContext().getPageActivity(), 12012, this.f14061e.y(), intValue)));
                            return;
                        }
                        return;
                    case 16:
                        if (this.f14063g.f14059d) {
                            this.f14061e.getContext().showToast(R.string.over_limit_tip);
                        }
                        if (this.f14063g.k(this.f14061e.getContext(), 11025)) {
                            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.f14061e.getContext().getPageActivity(), 12004, true);
                            if (this.f14061e.x() != null) {
                                atListActivityConfig.setSelectedAtList(this.f14061e.x().u());
                            }
                            if (this.f14063g.f14060e != null) {
                                atListActivityConfig.setFromTid(this.f14063g.f14060e.z());
                                atListActivityConfig.setFromFid(this.f14063g.f14060e.getForumId());
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                            if (this.f14063g.f14060e != null) {
                                statisticItem.addParam("tid", this.f14063g.f14060e.z());
                                statisticItem.addParam("fid", this.f14063g.f14060e.getForumId());
                            }
                            TiebaStatic.log(statisticItem);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else if (c.a.q0.t0.a.c(this.f14061e.getContext(), true, false)) {
            } else {
                HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.f14061e.getContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                if (this.f14063g.a != null) {
                    hotSelectActivityConfig.setForumExtra(c.a.d.f.m.b.g(this.f14063g.a.getId(), 0L), this.f14063g.a.getFirst_class(), this.f14063g.a.getSecond_class());
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
            }
        }
    }

    public g() {
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
        this.f14057b = null;
        this.f14058c = null;
        this.f14059d = false;
    }

    @Override // c.a.q0.w.c
    public c.a.q0.w.e b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBarLauncherType(3);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.showLinePositionTop(false);
            editorTools.setMoreButtonAtEnd(true);
            e eVar = new e(editorTools);
            eVar.j0(this.f14060e);
            return eVar;
        }
        return (c.a.q0.w.e) invokeL.objValue;
    }

    @Override // c.a.q0.w.c
    public void c(c.a.q0.w.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) && (eVar instanceof e)) {
            EditorTools a2 = eVar.a();
            a aVar = new a(this, (e) eVar, a2);
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
            a2.setActionListener(27, aVar);
            a2.setActionListener(29, aVar);
            a2.setActionListener(36, aVar);
            a2.setActionListener(32, aVar);
            a2.setActionListener(43, aVar);
            a2.setActionListener(45, aVar);
        }
    }

    @Override // c.a.q0.w.c
    public void d(c.a.q0.w.e eVar) {
        CustomResponsedMessage runTask;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            EditorTools a2 = eVar.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            arrayList.add(6);
            arrayList.add(9);
            a2.addTool(new c.a.q0.w.r.d(a2.getContext(), 1));
            if (c.a.r0.y3.s0.c.a() && w.a(this.f14057b, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
                mVar.f14006j = 2;
                a2.addTool(mVar);
            }
            c.a.q0.w.o.a aVar = new c.a.q0.w.o.a(a2.getContext(), 4);
            aVar.f14003g = false;
            a2.addTool(aVar);
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), m.class);
            if (runTask2 != null && runTask2.getData() != null) {
                m mVar2 = (m) runTask2.getData();
                mVar2.f14006j = 6;
                a2.addTool(mVar2);
            }
            a2.addTool(new f(a2.getContext(), false, true, 12004));
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), m.class);
            if (runTask3 != null && runTask3.getData() != null) {
                m mVar3 = (m) runTask3.getData();
                mVar3.f14006j = 7;
                a2.addTool(mVar3);
            }
            if (!"PbChosenActivity".equals(a2.getContext().getClass().getSimpleName())) {
                a2.addTool(new c.a.q0.w.q.a(a2.getContext(), 5));
            }
            a2.collect(arrayList);
            m findToolById = a2.findToolById(5);
            if (findToolById != null) {
                findToolById.f14006j = 3;
            }
            a2.build();
        }
    }

    public final boolean k(TbPageContext<?> tbPageContext, int i2) {
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

    public ForumData l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (ForumData) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14058c : (String) invokeV.objValue;
    }

    public DataModel<?> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f14060e : (DataModel) invokeV.objValue;
    }

    public void o(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, forumData) == null) {
            this.a = forumData;
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f14057b = str;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f14058c = str;
        }
    }

    public void r(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dataModel) == null) {
            this.f14060e = dataModel;
        }
    }
}
