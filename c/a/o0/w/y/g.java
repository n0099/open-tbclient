package c.a.o0.w.y;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.w.m;
import c.a.p0.a4.w;
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
public class g extends c.a.o0.w.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumData a;

    /* renamed from: b  reason: collision with root package name */
    public String f11558b;

    /* renamed from: c  reason: collision with root package name */
    public String f11559c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f11560d;

    /* renamed from: e  reason: collision with root package name */
    public DataModel<?> f11561e;

    /* loaded from: classes2.dex */
    public class a implements c.a.o0.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EditorTools f11562b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f11563c;

        public a(g gVar, e eVar, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, eVar, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11563c = gVar;
            this.a = eVar;
            this.f11562b = editorTools;
        }

        @Override // c.a.o0.w.b
        public void onAction(c.a.o0.w.a aVar) {
            e eVar;
            int size;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (eVar = this.a) == null || eVar.a() == null || aVar == null) {
                return;
            }
            int i = aVar.a;
            if (i == 4) {
                this.a.m0(aVar.f11499c.toString());
                Object obj = aVar.f11499c;
                if (obj instanceof SpanGroupManager) {
                    this.a.q0((SpanGroupManager) obj);
                }
                this.f11563c.f11560d = false;
            } else if (i == 5) {
                if (this.f11562b.u()) {
                    return;
                }
                TiebaStatic.eventStat(this.f11562b.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
            } else if (i == 7) {
                this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0cee);
                this.f11563c.f11560d = true;
            } else if (i == 8) {
                if (this.f11563c.k(this.a.getContext(), 11001)) {
                    this.a.L(null, null);
                }
            } else if (i == 10) {
                Object obj2 = aVar.f11499c;
                if (obj2 instanceof VoiceData.VoiceModel) {
                    this.a.t0((VoiceData.VoiceModel) obj2);
                    this.a.z(true, null);
                }
            } else if (i == 11) {
                this.a.t0(null);
            } else if (i == 18) {
                boolean h2 = c.a.o0.r.j0.b.k().h("key_post_thread_has_request_location", false);
                if (aVar.f11499c != null) {
                    if (h2) {
                        this.a.Q();
                        return;
                    }
                    return;
                }
                int t = this.a.t();
                if (t == 0) {
                    this.a.J(h2);
                } else if (t != 2) {
                } else {
                    this.a.A();
                }
            } else if (i == 20) {
                this.a.a().A(new c.a.o0.w.a(2, 7, null));
                c.a.p0.a4.p0.b.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i == 29) {
                this.a.a().A(new c.a.o0.w.a(2, 19, null));
                this.a.a().A(new c.a.o0.w.a(1, 2, null));
                this.a.m();
            } else if (i == 32) {
                this.a.a().A(new c.a.o0.w.a(1, 11, null));
            } else if (i == 36) {
                if (this.f11563c.k(this.a.getContext(), 11040)) {
                    this.a.Z();
                }
            } else if (i != 43) {
                switch (i) {
                    case 14:
                        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.getContext().getPageActivity(), this.a.y().toJsonString(), true, true);
                        if (!StringUtils.isNull(this.f11563c.f11559c, true)) {
                            albumFloatActivityConfig.getIntent().putExtra("from", this.f11563c.f11559c);
                        }
                        if (this.f11563c.a != null && !StringUtils.isNull(this.f11563c.a.getId(), true)) {
                            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.f11563c.a.getId());
                        }
                        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                        if (c.a.o0.w.y.a.a().b() == 1) {
                            albumFloatActivityConfig.setRequestFrom(2);
                            if (this.a.y() != null) {
                                this.a.y().setMaxImagesAllowed(1);
                            }
                        } else if (this.a.y() != null) {
                            this.a.y().setMaxImagesAllowed(9);
                        }
                        n.w(this.a.getContext().getPageActivity(), this.a.getContext().getPageActivity().getCurrentFocus());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                        return;
                    case 15:
                        int intValue = ((Integer) aVar.f11499c).intValue();
                        if (this.a.y() != null && this.a.y().getChosedFiles() != null && (size = this.a.y().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.getContext().getPageActivity(), 12012, this.a.y(), intValue)));
                            return;
                        }
                        return;
                    case 16:
                        if (this.f11563c.f11560d) {
                            this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0cee);
                        }
                        if (this.f11563c.k(this.a.getContext(), 11025)) {
                            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getContext().getPageActivity(), 12004, true);
                            if (this.a.x() != null) {
                                atListActivityConfig.setSelectedAtList(this.a.x().u());
                            }
                            if (this.f11563c.f11561e != null) {
                                atListActivityConfig.setFromTid(this.f11563c.f11561e.B());
                                atListActivityConfig.setFromFid(this.f11563c.f11561e.getForumId());
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                            if (this.f11563c.f11561e != null) {
                                statisticItem.addParam("tid", this.f11563c.f11561e.B());
                                statisticItem.addParam("fid", this.f11563c.f11561e.getForumId());
                            }
                            TiebaStatic.log(statisticItem);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else if (c.a.o0.t0.a.c(this.a.getContext(), true, false)) {
            } else {
                HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.a.getContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                if (this.f11563c.a != null) {
                    hotSelectActivityConfig.setForumExtra(c.a.d.f.m.b.g(this.f11563c.a.getId(), 0L), this.f11563c.a.getFirst_class(), this.f11563c.a.getSecond_class());
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11558b = null;
        this.f11559c = null;
        this.f11560d = false;
    }

    @Override // c.a.o0.w.c
    public c.a.o0.w.e b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBarLauncherType(3);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.D(false);
            editorTools.setMoreButtonAtEnd(true);
            e eVar = new e(editorTools);
            eVar.j0(this.f11561e);
            return eVar;
        }
        return (c.a.o0.w.e) invokeL.objValue;
    }

    @Override // c.a.o0.w.c
    public void c(c.a.o0.w.e eVar) {
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

    @Override // c.a.o0.w.c
    public void d(c.a.o0.w.e eVar) {
        CustomResponsedMessage runTask;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            EditorTools a2 = eVar.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            arrayList.add(6);
            arrayList.add(9);
            a2.d(new c.a.o0.w.r.d(a2.getContext(), 1));
            if (c.a.p0.a4.s0.c.a() && w.a(this.f11558b, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
                mVar.j = 2;
                a2.d(mVar);
            }
            c.a.o0.w.o.a aVar = new c.a.o0.w.o.a(a2.getContext(), 4);
            aVar.f11513g = false;
            a2.d(aVar);
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), m.class);
            if (runTask2 != null && runTask2.getData() != null) {
                m mVar2 = (m) runTask2.getData();
                mVar2.j = 6;
                a2.d(mVar2);
            }
            a2.d(new f(a2.getContext(), false, true, 12004));
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), m.class);
            if (runTask3 != null && runTask3.getData() != null) {
                m mVar3 = (m) runTask3.getData();
                mVar3.j = 7;
                a2.d(mVar3);
            }
            if (!"PbChosenActivity".equals(a2.getContext().getClass().getSimpleName())) {
                a2.d(new c.a.o0.w.q.a(a2.getContext(), 5));
            }
            a2.h(arrayList);
            m n = a2.n(5);
            if (n != null) {
                n.j = 3;
            }
            a2.f();
        }
    }

    public final boolean k(TbPageContext<?> tbPageContext, int i) {
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

    public ForumData l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (ForumData) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f11559c : (String) invokeV.objValue;
    }

    public DataModel<?> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f11561e : (DataModel) invokeV.objValue;
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
            this.f11558b = str;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f11559c = str;
        }
    }

    public void r(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dataModel) == null) {
            this.f11561e = dataModel;
        }
    }
}
