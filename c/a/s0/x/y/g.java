package c.a.s0.x.y;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.s0.x.m;
import c.a.t0.w3.v;
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
public class g extends c.a.s0.x.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumData a;

    /* renamed from: b  reason: collision with root package name */
    public String f14591b;

    /* renamed from: c  reason: collision with root package name */
    public String f14592c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f14593d;

    /* renamed from: e  reason: collision with root package name */
    public DataModel<?> f14594e;

    /* loaded from: classes6.dex */
    public class a implements c.a.s0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f14595e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorTools f14596f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f14597g;

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
            this.f14597g = gVar;
            this.f14595e = eVar;
            this.f14596f = editorTools;
        }

        @Override // c.a.s0.x.b
        public void onAction(c.a.s0.x.a aVar) {
            e eVar;
            int size;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (eVar = this.f14595e) == null || eVar.a() == null || aVar == null) {
                return;
            }
            int i2 = aVar.a;
            if (i2 == 4) {
                this.f14595e.m0(aVar.f14519c.toString());
                Object obj = aVar.f14519c;
                if (obj instanceof SpanGroupManager) {
                    this.f14595e.q0((SpanGroupManager) obj);
                }
                this.f14597g.f14593d = false;
            } else if (i2 == 5) {
                if (this.f14596f.isToolVisible()) {
                    return;
                }
                TiebaStatic.eventStat(this.f14596f.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
            } else if (i2 == 7) {
                this.f14595e.getContext().showToast(R.string.over_limit_tip);
                this.f14597g.f14593d = true;
            } else if (i2 == 8) {
                if (this.f14597g.k(this.f14595e.getContext(), 11001)) {
                    this.f14595e.L(null, null);
                }
            } else if (i2 == 10) {
                Object obj2 = aVar.f14519c;
                if (obj2 instanceof VoiceData$VoiceModel) {
                    this.f14595e.t0((VoiceData$VoiceModel) obj2);
                    this.f14595e.z(true, null);
                }
            } else if (i2 == 11) {
                this.f14595e.t0(null);
            } else if (i2 == 18) {
                boolean g2 = c.a.s0.s.g0.b.j().g("key_post_thread_has_request_location", false);
                if (aVar.f14519c != null) {
                    if (g2) {
                        this.f14595e.Q();
                        return;
                    }
                    return;
                }
                int t = this.f14595e.t();
                if (t == 0) {
                    this.f14595e.J(g2);
                } else if (t != 2) {
                } else {
                    this.f14595e.A();
                }
            } else if (i2 == 20) {
                this.f14595e.a().sendAction(new c.a.s0.x.a(2, 7, null));
                c.a.t0.w3.o0.b.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i2 == 29) {
                this.f14595e.a().sendAction(new c.a.s0.x.a(2, 19, null));
                this.f14595e.a().sendAction(new c.a.s0.x.a(1, 2, null));
                this.f14595e.m();
            } else if (i2 == 32) {
                this.f14595e.a().sendAction(new c.a.s0.x.a(1, 11, null));
            } else if (i2 == 36) {
                if (this.f14597g.k(this.f14595e.getContext(), 11040)) {
                    this.f14595e.Z();
                }
            } else if (i2 != 43) {
                switch (i2) {
                    case 14:
                        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.f14595e.getContext().getPageActivity(), this.f14595e.y().toJsonString(), true, true);
                        if (!StringUtils.isNull(this.f14597g.f14592c, true)) {
                            albumFloatActivityConfig.getIntent().putExtra("from", this.f14597g.f14592c);
                        }
                        if (this.f14597g.a != null && !StringUtils.isNull(this.f14597g.a.getId(), true)) {
                            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.f14597g.a.getId());
                        }
                        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                        if (c.a.s0.x.y.a.a().b() == 1) {
                            albumFloatActivityConfig.setRequestFrom(2);
                            if (this.f14595e.y() != null) {
                                this.f14595e.y().setMaxImagesAllowed(1);
                            }
                        } else if (this.f14595e.y() != null) {
                            this.f14595e.y().setMaxImagesAllowed(9);
                        }
                        n.w(this.f14595e.getContext().getPageActivity(), this.f14595e.getContext().getPageActivity().getCurrentFocus());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                        return;
                    case 15:
                        int intValue = ((Integer) aVar.f14519c).intValue();
                        if (this.f14595e.y() != null && this.f14595e.y().getChosedFiles() != null && (size = this.f14595e.y().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f14595e.getContext().getPageActivity(), 12012, this.f14595e.y(), intValue)));
                            return;
                        }
                        return;
                    case 16:
                        if (this.f14597g.f14593d) {
                            this.f14595e.getContext().showToast(R.string.over_limit_tip);
                        }
                        if (this.f14597g.k(this.f14595e.getContext(), 11025)) {
                            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.f14595e.getContext().getPageActivity(), 12004, true);
                            if (this.f14595e.x() != null) {
                                atListActivityConfig.setSelectedAtList(this.f14595e.x().u());
                            }
                            if (this.f14597g.f14594e != null) {
                                atListActivityConfig.setFromTid(this.f14597g.f14594e.z());
                                atListActivityConfig.setFromFid(this.f14597g.f14594e.getForumId());
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                            if (this.f14597g.f14594e != null) {
                                statisticItem.addParam("tid", this.f14597g.f14594e.z());
                                statisticItem.addParam("fid", this.f14597g.f14594e.getForumId());
                            }
                            TiebaStatic.log(statisticItem);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else if (c.a.s0.u0.a.c(this.f14595e.getContext(), true, false)) {
            } else {
                HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.f14595e.getContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                if (this.f14597g.a != null) {
                    hotSelectActivityConfig.setForumExtra(c.a.d.f.m.b.g(this.f14597g.a.getId(), 0L), this.f14597g.a.getFirst_class(), this.f14597g.a.getSecond_class());
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
        this.f14591b = null;
        this.f14592c = null;
        this.f14593d = false;
    }

    @Override // c.a.s0.x.c
    public c.a.s0.x.e b(Context context) {
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
            eVar.j0(this.f14594e);
            return eVar;
        }
        return (c.a.s0.x.e) invokeL.objValue;
    }

    @Override // c.a.s0.x.c
    public void c(c.a.s0.x.e eVar) {
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

    @Override // c.a.s0.x.c
    public void d(c.a.s0.x.e eVar) {
        CustomResponsedMessage runTask;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            EditorTools a2 = eVar.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            arrayList.add(6);
            arrayList.add(9);
            a2.addTool(new c.a.s0.x.r.d(a2.getContext(), 1));
            if (c.a.t0.w3.r0.c.a() && v.a(this.f14591b, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
                mVar.f14537j = 2;
                a2.addTool(mVar);
            }
            c.a.s0.x.o.a aVar = new c.a.s0.x.o.a(a2.getContext(), 4);
            aVar.f14534g = false;
            a2.addTool(aVar);
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), m.class);
            if (runTask2 != null && runTask2.getData() != null) {
                m mVar2 = (m) runTask2.getData();
                mVar2.f14537j = 6;
                a2.addTool(mVar2);
            }
            a2.addTool(new f(a2.getContext(), false, true, 12004));
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), m.class);
            if (runTask3 != null && runTask3.getData() != null) {
                m mVar3 = (m) runTask3.getData();
                mVar3.f14537j = 7;
                a2.addTool(mVar3);
            }
            if (!"PbChosenActivity".equals(a2.getContext().getClass().getSimpleName())) {
                a2.addTool(new c.a.s0.x.q.a(a2.getContext(), 5));
            }
            a2.collect(arrayList);
            m findToolById = a2.findToolById(5);
            if (findToolById != null) {
                findToolById.f14537j = 3;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14592c : (String) invokeV.objValue;
    }

    public DataModel<?> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f14594e : (DataModel) invokeV.objValue;
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
            this.f14591b = str;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f14592c = str;
        }
    }

    public void r(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dataModel) == null) {
            this.f14594e = dataModel;
        }
    }
}
