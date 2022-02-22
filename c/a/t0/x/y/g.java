package c.a.t0.x.y;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.t0.x.m;
import c.a.u0.z3.w;
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
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
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
/* loaded from: classes6.dex */
public class g extends c.a.t0.x.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumData a;

    /* renamed from: b  reason: collision with root package name */
    public String f14662b;

    /* renamed from: c  reason: collision with root package name */
    public String f14663c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f14664d;

    /* renamed from: e  reason: collision with root package name */
    public DataModel<?> f14665e;

    /* loaded from: classes6.dex */
    public class a implements c.a.t0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f14666e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorTools f14667f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f14668g;

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
            this.f14668g = gVar;
            this.f14666e = eVar;
            this.f14667f = editorTools;
        }

        @Override // c.a.t0.x.b
        public void onAction(c.a.t0.x.a aVar) {
            e eVar;
            int size;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (eVar = this.f14666e) == null || eVar.a() == null || aVar == null) {
                return;
            }
            int i2 = aVar.a;
            if (i2 == 4) {
                this.f14666e.m0(aVar.f14594c.toString());
                Object obj = aVar.f14594c;
                if (obj instanceof SpanGroupManager) {
                    this.f14666e.q0((SpanGroupManager) obj);
                }
                this.f14668g.f14664d = false;
            } else if (i2 == 5) {
                if (this.f14667f.isToolVisible()) {
                    return;
                }
                TiebaStatic.eventStat(this.f14667f.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
            } else if (i2 == 7) {
                this.f14666e.getContext().showToast(R.string.over_limit_tip);
                this.f14668g.f14664d = true;
            } else if (i2 == 8) {
                if (this.f14668g.k(this.f14666e.getContext(), 11001)) {
                    this.f14666e.L(null, null);
                }
            } else if (i2 == 10) {
                Object obj2 = aVar.f14594c;
                if (obj2 instanceof VoiceData$VoiceModel) {
                    this.f14666e.t0((VoiceData$VoiceModel) obj2);
                    this.f14666e.z(true, null);
                }
            } else if (i2 == 11) {
                this.f14666e.t0(null);
            } else if (i2 == 18) {
                boolean h2 = c.a.t0.s.j0.b.k().h("key_post_thread_has_request_location", false);
                if (aVar.f14594c != null) {
                    if (h2) {
                        this.f14666e.Q();
                        return;
                    }
                    return;
                }
                int t = this.f14666e.t();
                if (t == 0) {
                    this.f14666e.J(h2);
                } else if (t != 2) {
                } else {
                    this.f14666e.A();
                }
            } else if (i2 == 20) {
                this.f14666e.a().sendAction(new c.a.t0.x.a(2, 7, null));
                c.a.u0.z3.p0.b.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i2 == 29) {
                this.f14666e.a().sendAction(new c.a.t0.x.a(2, 19, null));
                this.f14666e.a().sendAction(new c.a.t0.x.a(1, 2, null));
                this.f14666e.m();
            } else if (i2 == 32) {
                this.f14666e.a().sendAction(new c.a.t0.x.a(1, 11, null));
            } else if (i2 == 36) {
                if (this.f14668g.k(this.f14666e.getContext(), 11040)) {
                    this.f14666e.Z();
                }
            } else if (i2 != 43) {
                switch (i2) {
                    case 14:
                        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.f14666e.getContext().getPageActivity(), this.f14666e.y().toJsonString(), true, true);
                        if (!StringUtils.isNull(this.f14668g.f14663c, true)) {
                            albumFloatActivityConfig.getIntent().putExtra("from", this.f14668g.f14663c);
                        }
                        if (this.f14668g.a != null && !StringUtils.isNull(this.f14668g.a.getId(), true)) {
                            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.f14668g.a.getId());
                        }
                        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                        if (c.a.t0.x.y.a.a().b() == 1) {
                            albumFloatActivityConfig.setRequestFrom(2);
                            if (this.f14666e.y() != null) {
                                this.f14666e.y().setMaxImagesAllowed(1);
                            }
                        } else if (this.f14666e.y() != null) {
                            this.f14666e.y().setMaxImagesAllowed(9);
                        }
                        n.w(this.f14666e.getContext().getPageActivity(), this.f14666e.getContext().getPageActivity().getCurrentFocus());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                        return;
                    case 15:
                        int intValue = ((Integer) aVar.f14594c).intValue();
                        if (this.f14666e.y() != null && this.f14666e.y().getChosedFiles() != null && (size = this.f14666e.y().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f14666e.getContext().getPageActivity(), 12012, this.f14666e.y(), intValue)));
                            return;
                        }
                        return;
                    case 16:
                        if (this.f14668g.f14664d) {
                            this.f14666e.getContext().showToast(R.string.over_limit_tip);
                        }
                        if (this.f14668g.k(this.f14666e.getContext(), 11025)) {
                            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.f14666e.getContext().getPageActivity(), 12004, true);
                            if (this.f14666e.x() != null) {
                                atListActivityConfig.setSelectedAtList(this.f14666e.x().u());
                            }
                            if (this.f14668g.f14665e != null) {
                                atListActivityConfig.setFromTid(this.f14668g.f14665e.z());
                                atListActivityConfig.setFromFid(this.f14668g.f14665e.getForumId());
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                            if (this.f14668g.f14665e != null) {
                                statisticItem.addParam("tid", this.f14668g.f14665e.z());
                                statisticItem.addParam("fid", this.f14668g.f14665e.getForumId());
                            }
                            TiebaStatic.log(statisticItem);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else if (c.a.t0.u0.a.c(this.f14666e.getContext(), true, false)) {
            } else {
                HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.f14666e.getContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                if (this.f14668g.a != null) {
                    hotSelectActivityConfig.setForumExtra(c.a.d.f.m.b.g(this.f14668g.a.getId(), 0L), this.f14668g.a.getFirst_class(), this.f14668g.a.getSecond_class());
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
        this.f14662b = null;
        this.f14663c = null;
        this.f14664d = false;
    }

    @Override // c.a.t0.x.c
    public c.a.t0.x.e b(Context context) {
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
            eVar.j0(this.f14665e);
            return eVar;
        }
        return (c.a.t0.x.e) invokeL.objValue;
    }

    @Override // c.a.t0.x.c
    public void c(c.a.t0.x.e eVar) {
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

    @Override // c.a.t0.x.c
    public void d(c.a.t0.x.e eVar) {
        CustomResponsedMessage runTask;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            EditorTools a2 = eVar.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            arrayList.add(6);
            arrayList.add(9);
            a2.addTool(new c.a.t0.x.r.d(a2.getContext(), 1));
            if (c.a.u0.z3.s0.c.a() && w.a(this.f14662b, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
                mVar.f14611j = 2;
                a2.addTool(mVar);
            }
            c.a.t0.x.o.a aVar = new c.a.t0.x.o.a(a2.getContext(), 4);
            aVar.f14608g = false;
            a2.addTool(aVar);
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), m.class);
            if (runTask2 != null && runTask2.getData() != null) {
                m mVar2 = (m) runTask2.getData();
                mVar2.f14611j = 6;
                a2.addTool(mVar2);
            }
            a2.addTool(new f(a2.getContext(), false, true, 12004));
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), m.class);
            if (runTask3 != null && runTask3.getData() != null) {
                m mVar3 = (m) runTask3.getData();
                mVar3.f14611j = 7;
                a2.addTool(mVar3);
            }
            if (!"PbChosenActivity".equals(a2.getContext().getClass().getSimpleName())) {
                a2.addTool(new c.a.t0.x.q.a(a2.getContext(), 5));
            }
            a2.collect(arrayList);
            m findToolById = a2.findToolById(5);
            if (findToolById != null) {
                findToolById.f14611j = 3;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14663c : (String) invokeV.objValue;
    }

    public DataModel<?> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f14665e : (DataModel) invokeV.objValue;
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
            this.f14662b = str;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f14663c = str;
        }
    }

    public void r(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dataModel) == null) {
            this.f14665e = dataModel;
        }
    }
}
