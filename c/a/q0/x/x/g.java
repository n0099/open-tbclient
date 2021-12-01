package c.a.q0.x.x;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.q0.x.m;
import c.a.r0.t3.v;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes5.dex */
public class g extends c.a.q0.x.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumData a;

    /* renamed from: b  reason: collision with root package name */
    public String f13741b;

    /* renamed from: c  reason: collision with root package name */
    public String f13742c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f13743d;

    /* renamed from: e  reason: collision with root package name */
    public DataModel<?> f13744e;

    /* loaded from: classes5.dex */
    public class a implements c.a.q0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f13745e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorTools f13746f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f13747g;

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
            this.f13747g = gVar;
            this.f13745e = eVar;
            this.f13746f = editorTools;
        }

        @Override // c.a.q0.x.b
        public void onAction(c.a.q0.x.a aVar) {
            e eVar;
            int size;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (eVar = this.f13745e) == null || eVar.a() == null || aVar == null) {
                return;
            }
            int i2 = aVar.a;
            if (i2 == 4) {
                this.f13745e.m0(aVar.f13679c.toString());
                Object obj = aVar.f13679c;
                if (obj instanceof SpanGroupManager) {
                    this.f13745e.q0((SpanGroupManager) obj);
                }
                this.f13747g.f13743d = false;
            } else if (i2 == 5) {
                if (this.f13746f.isToolVisible()) {
                    return;
                }
                TiebaStatic.eventStat(this.f13746f.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
            } else if (i2 == 7) {
                this.f13745e.getContext().showToast(R.string.over_limit_tip);
                this.f13747g.f13743d = true;
            } else if (i2 == 8) {
                if (this.f13747g.k(this.f13745e.getContext(), 11001)) {
                    this.f13745e.L(null, null);
                }
            } else if (i2 == 10) {
                Object obj2 = aVar.f13679c;
                if (obj2 instanceof VoiceData$VoiceModel) {
                    this.f13745e.t0((VoiceData$VoiceModel) obj2);
                    this.f13745e.z(true, null);
                }
            } else if (i2 == 11) {
                this.f13745e.t0(null);
            } else if (i2 == 18) {
                boolean g2 = c.a.q0.s.e0.b.j().g("key_post_thread_has_request_location", false);
                if (aVar.f13679c != null) {
                    if (g2) {
                        this.f13745e.Q();
                        return;
                    }
                    return;
                }
                int t = this.f13745e.t();
                if (t == 0) {
                    this.f13745e.J(g2);
                } else if (t != 2) {
                } else {
                    this.f13745e.A();
                }
            } else if (i2 == 20) {
                this.f13745e.a().sendAction(new c.a.q0.x.a(2, 7, null));
                c.a.r0.t3.o0.b.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i2 == 29) {
                this.f13745e.a().sendAction(new c.a.q0.x.a(2, 19, null));
                this.f13745e.a().sendAction(new c.a.q0.x.a(1, 2, null));
                this.f13745e.m();
            } else if (i2 == 32) {
                this.f13745e.a().sendAction(new c.a.q0.x.a(1, 11, null));
            } else if (i2 == 36) {
                if (this.f13747g.k(this.f13745e.getContext(), 11040)) {
                    this.f13745e.Z();
                }
            } else if (i2 != 43) {
                switch (i2) {
                    case 14:
                        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.f13745e.getContext().getPageActivity(), this.f13745e.y().toJsonString(), true, true);
                        if (!StringUtils.isNull(this.f13747g.f13742c, true)) {
                            albumFloatActivityConfig.getIntent().putExtra("from", this.f13747g.f13742c);
                        }
                        if (this.f13747g.a != null && !StringUtils.isNull(this.f13747g.a.getId(), true)) {
                            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.f13747g.a.getId());
                        }
                        albumFloatActivityConfig.setRequestCode(12002);
                        if (c.a.q0.x.x.a.a().b() == 1) {
                            albumFloatActivityConfig.setRequestFrom(2);
                            if (this.f13745e.y() != null) {
                                this.f13745e.y().setMaxImagesAllowed(1);
                            }
                        } else if (this.f13745e.y() != null) {
                            this.f13745e.y().setMaxImagesAllowed(9);
                        }
                        l.w(this.f13745e.getContext().getPageActivity(), this.f13745e.getContext().getPageActivity().getCurrentFocus());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                        return;
                    case 15:
                        int intValue = ((Integer) aVar.f13679c).intValue();
                        if (this.f13745e.y() != null && this.f13745e.y().getChosedFiles() != null && (size = this.f13745e.y().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f13745e.getContext().getPageActivity(), 12012, this.f13745e.y(), intValue)));
                            return;
                        }
                        return;
                    case 16:
                        if (this.f13747g.f13743d) {
                            this.f13745e.getContext().showToast(R.string.over_limit_tip);
                        }
                        if (this.f13747g.k(this.f13745e.getContext(), 11025)) {
                            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.f13745e.getContext().getPageActivity(), 12004, true);
                            if (this.f13745e.x() != null) {
                                atListActivityConfig.setSelectedAtList(this.f13745e.x().u());
                            }
                            if (this.f13747g.f13744e != null) {
                                atListActivityConfig.setFromTid(this.f13747g.f13744e.z());
                                atListActivityConfig.setFromFid(this.f13747g.f13744e.getForumId());
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                            if (this.f13747g.f13744e != null) {
                                statisticItem.addParam("tid", this.f13747g.f13744e.z());
                                statisticItem.addParam("fid", this.f13747g.f13744e.getForumId());
                            }
                            TiebaStatic.log(statisticItem);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else if (c.a.q0.t0.b.c(this.f13745e.getContext(), true, false)) {
            } else {
                HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.f13745e.getContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                if (this.f13747g.a != null) {
                    hotSelectActivityConfig.setForumExtra(c.a.d.f.m.b.g(this.f13747g.a.getId(), 0L), this.f13747g.a.getFirst_class(), this.f13747g.a.getSecond_class());
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
        this.f13741b = null;
        this.f13742c = null;
        this.f13743d = false;
    }

    @Override // c.a.q0.x.c
    public c.a.q0.x.e b(Context context) {
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
            eVar.j0(this.f13744e);
            return eVar;
        }
        return (c.a.q0.x.e) invokeL.objValue;
    }

    @Override // c.a.q0.x.c
    public void c(c.a.q0.x.e eVar) {
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

    @Override // c.a.q0.x.c
    public void d(c.a.q0.x.e eVar) {
        CustomResponsedMessage runTask;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            EditorTools a2 = eVar.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            arrayList.add(6);
            arrayList.add(9);
            a2.addTool(new c.a.q0.x.r.d(a2.getContext(), 1));
            if (c.a.r0.t3.r0.c.a() && v.a(this.f13741b, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
                mVar.f13697j = 2;
                a2.addTool(mVar);
            }
            c.a.q0.x.o.a aVar = new c.a.q0.x.o.a(a2.getContext(), 4);
            aVar.f13694g = false;
            a2.addTool(aVar);
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), m.class);
            if (runTask2 != null && runTask2.getData() != null) {
                m mVar2 = (m) runTask2.getData();
                mVar2.f13697j = 6;
                a2.addTool(mVar2);
            }
            a2.addTool(new f(a2.getContext(), false, true, 12004));
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), m.class);
            if (runTask3 != null && runTask3.getData() != null) {
                m mVar3 = (m) runTask3.getData();
                mVar3.f13697j = 7;
                a2.addTool(mVar3);
            }
            if (!"PbChosenActivity".equals(a2.getContext().getClass().getSimpleName())) {
                a2.addTool(new c.a.q0.x.q.a(a2.getContext(), 5));
            }
            a2.collect(arrayList);
            m findToolById = a2.findToolById(5);
            if (findToolById != null) {
                findToolById.f13697j = 3;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f13742c : (String) invokeV.objValue;
    }

    public DataModel<?> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f13744e : (DataModel) invokeV.objValue;
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
            this.f13741b = str;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f13742c = str;
        }
    }

    public void r(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dataModel) == null) {
            this.f13744e = dataModel;
        }
    }
}
