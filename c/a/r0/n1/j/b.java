package c.a.r0.n1.j;

import android.content.Context;
import c.a.e.e.p.l;
import c.a.q0.x.e;
import c.a.q0.x.m;
import c.a.q0.x.r.d;
import c.a.q0.x.x.f;
import c.a.r0.k3.v;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
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
/* loaded from: classes3.dex */
public class b extends c.a.q0.x.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f22445a;

    /* renamed from: b  reason: collision with root package name */
    public String f22446b;

    /* renamed from: c  reason: collision with root package name */
    public String f22447c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22448d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22449e;

    /* loaded from: classes3.dex */
    public class a implements c.a.q0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.n1.j.a f22450e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f22451f;

        public a(b bVar, c.a.r0.n1.j.a aVar) {
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
            this.f22451f = bVar;
            this.f22450e = aVar;
        }

        @Override // c.a.q0.x.b
        public void onAction(c.a.q0.x.a aVar) {
            c.a.r0.n1.j.a aVar2;
            int size;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (aVar2 = this.f22450e) == null || aVar2.a() == null || aVar == null) {
                return;
            }
            int i2 = aVar.f15109a;
            if (i2 == 4) {
                this.f22450e.o0(aVar.f15111c.toString());
                Object obj = aVar.f15111c;
                if (obj instanceof SpanGroupManager) {
                    this.f22450e.s0((SpanGroupManager) obj);
                }
                this.f22451f.f22448d = false;
            } else if (i2 == 18) {
                if (aVar.f15111c != null) {
                    this.f22450e.S();
                    return;
                }
                int u = this.f22450e.u();
                if (u == 0) {
                    this.f22450e.L();
                } else if (u != 2) {
                } else {
                    this.f22450e.C();
                }
            } else if (i2 == 20) {
                this.f22450e.a().sendAction(new c.a.q0.x.a(2, 7, null));
                c.a.r0.k3.n0.b.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i2 == 32) {
                this.f22450e.a().sendAction(new c.a.q0.x.a(1, 11, null));
            } else if (i2 == 36) {
                if (this.f22451f.j(this.f22450e.s(), 11040)) {
                    this.f22450e.b0();
                }
            } else if (i2 == 7) {
                l.L(TbadkCoreApplication.getInst().getContext(), R.string.over_limit_tip);
                this.f22451f.f22448d = true;
            } else if (i2 == 8) {
                if (this.f22451f.j(this.f22450e.s(), CyberPlayerManager.MEDIA_INFO_DISABLE_FILECACHE)) {
                    this.f22450e.N(null, null);
                }
            } else if (i2 == 10) {
                Object obj2 = aVar.f15111c;
                if (obj2 instanceof VoiceData$VoiceModel) {
                    this.f22450e.v0((VoiceData$VoiceModel) obj2);
                    this.f22450e.B(true, null);
                }
            } else if (i2 != 11) {
                switch (i2) {
                    case 14:
                        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.f22450e.s().getPageActivity(), this.f22450e.A().toJsonString(), true, true);
                        if (!StringUtils.isNull(this.f22451f.f22446b, true)) {
                            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.f22451f.f22446b);
                        }
                        albumFloatActivityConfig.setRequestCode(12002);
                        if (c.a.q0.x.x.a.a().b() == 1) {
                            albumFloatActivityConfig.setRequestFrom(2);
                            if (this.f22450e.A() != null) {
                                this.f22450e.A().setMaxImagesAllowed(1);
                            }
                        } else if (this.f22450e.A() != null) {
                            this.f22450e.A().setMaxImagesAllowed(9);
                        }
                        l.x(this.f22450e.s().getPageActivity(), this.f22450e.s().getPageActivity().getCurrentFocus());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                        return;
                    case 15:
                        int intValue = ((Integer) aVar.f15111c).intValue();
                        if (this.f22450e.A() != null && this.f22450e.A().getChosedFiles() != null && (size = this.f22450e.A().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f22450e.s().getPageActivity(), 12012, this.f22450e.A(), intValue)));
                            return;
                        }
                        return;
                    case 16:
                        if (this.f22451f.f22448d) {
                            l.L(TbadkCoreApplication.getInst().getContext(), R.string.over_limit_tip);
                        }
                        if (this.f22451f.j(this.f22450e.s(), 11025)) {
                            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.f22450e.s().getPageActivity(), 12004, true);
                            if (this.f22450e.y() != null) {
                                atListActivityConfig.setSelectedAtList(this.f22450e.y().w());
                            }
                            atListActivityConfig.setFromTid(this.f22451f.f22447c);
                            atListActivityConfig.setFromFid(this.f22451f.f22446b);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem.addParam("tid", this.f22451f.f22447c);
                            statisticItem.addParam("fid", this.f22451f.f22446b);
                            TiebaStatic.log(statisticItem);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else {
                this.f22450e.v0(null);
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
        this.f22448d = false;
    }

    @Override // c.a.q0.x.c
    public e b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBarLauncherType(this.f22449e ? 2 : 3);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.setDeskBackgroundColorId(R.color.CAM_X0207);
            editorTools.showLinePositionTop(false);
            editorTools.setMoreButtonAtEnd(true);
            return new c.a.r0.n1.j.a(editorTools);
        }
        return (e) invokeL.objValue;
    }

    @Override // c.a.q0.x.c
    public void c(e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) && (eVar instanceof c.a.r0.n1.j.a)) {
            EditorTools a2 = eVar.a();
            a aVar = new a(this, (c.a.r0.n1.j.a) eVar);
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

    @Override // c.a.q0.x.c
    public void d(e eVar) {
        CustomResponsedMessage runTask;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            EditorTools a2 = eVar.a();
            if (c.a.r0.k3.q0.c.a() && v.a(this.f22445a, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
                mVar.f15132j = 2;
                a2.addTool(mVar);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a2.collect(arrayList);
            m findToolById = a2.findToolById(5);
            if (findToolById != null) {
                findToolById.f(!this.f22449e);
                findToolById.f15132j = this.f22449e ? 1 : 3;
            }
            c.a.q0.x.o.a aVar = new c.a.q0.x.o.a(a2.getContext(), 4);
            aVar.f15129g = false;
            a2.addTool(aVar);
            if (!this.f22449e) {
                a2.addTool(new d(a2.getContext(), 1));
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), m.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    m mVar2 = (m) runTask2.getData();
                    mVar2.f15132j = 6;
                    a2.addTool(mVar2);
                }
                a2.addTool(new f(a2.getContext(), false, true, 12004));
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), m.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    m mVar3 = (m) runTask3.getData();
                    mVar3.f15132j = 7;
                    a2.addTool(mVar3);
                }
                a2.addTool(new c.a.q0.x.q.a(a2.getContext(), 5));
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
            if (c.a.q0.j0.f.k()) {
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
            this.f22445a = str;
            this.f22446b = str2;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f22447c = str;
        }
    }
}
