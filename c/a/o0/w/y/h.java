package c.a.o0.w.y;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.c1.o0;
import c.a.o0.r.t.a;
import c.a.o0.s.c.l0;
import c.a.p0.a4.b0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class h extends c.a.o0.w.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f11564b;

    /* renamed from: c  reason: collision with root package name */
    public j f11565c;

    /* renamed from: d  reason: collision with root package name */
    public String f11566d;

    /* renamed from: e  reason: collision with root package name */
    public String f11567e;

    /* renamed from: f  reason: collision with root package name */
    public VoiceData.VoiceModel f11568f;

    /* renamed from: g  reason: collision with root package name */
    public NewWriteModel f11569g;

    /* renamed from: h  reason: collision with root package name */
    public SpanGroupManager f11570h;
    public DataModel<?> i;
    public boolean j;
    public c.a.o0.w.y.c k;
    public c.a.o0.w.y.b l;
    public NewWriteModel.g m;
    public String n;
    public f o;
    public ThreadData p;
    public b0.f q;
    public boolean r;
    public int s;
    public int t;
    public NewWriteModel.g u;
    public AntiHelper.k v;
    public View.OnClickListener w;

    /* loaded from: classes2.dex */
    public class a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, l0 l0Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l0Var, writeData, antiData}) == null) {
                if (this.a.m != null) {
                    this.a.m.callback(z, postWriteCallBackData, l0Var, writeData, antiData);
                }
                if (z) {
                    this.a.f11565c = null;
                    this.a.f11566d = null;
                    this.a.K(true);
                    this.a.q();
                }
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (z && this.a.p != null) {
                    StatisticItem statisticItem = new StatisticItem("c13563");
                    statisticItem.param("tid", this.a.p.getId());
                    statisticItem.param("fid", this.a.p.getFid());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("obj_type", 2);
                    c.a.o0.n0.c currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this.a.f11564b.getPageActivity());
                    if (currentVisiblePageExtra != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                    }
                    if (TbPageExtraHelper.getPrePageKey() != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                    }
                    if (this.a.t != 0) {
                        if (this.a.t != 1) {
                            if (this.a.t != 2) {
                                if (this.a.t != 3) {
                                    if (this.a.t != 4) {
                                        if (this.a.t != 5) {
                                            if (this.a.t == 6) {
                                                statisticItem.param("obj_locate", 7);
                                            }
                                        } else {
                                            statisticItem.param("obj_locate", 1);
                                        }
                                    } else {
                                        statisticItem.param("obj_locate", 3);
                                    }
                                } else {
                                    statisticItem.param("obj_locate", 2);
                                }
                            } else {
                                statisticItem.param("obj_locate", 5);
                            }
                        } else {
                            statisticItem.param("obj_locate", 4);
                        }
                    } else {
                        statisticItem.param("obj_locate", 6);
                    }
                    if (this.a.p.isVideoThreadType()) {
                        String content = writeData != null ? writeData.getContent() : "";
                        if (o0.d(content) > 40) {
                            content = o0.n(content, 40);
                        }
                        statisticItem.param(TiebaStatic.Params.POST_CONTENT, content);
                    }
                    TiebaStatic.log(statisticItem);
                }
                if (z && this.a.p != null) {
                    StatisticItem statisticItem2 = new StatisticItem("c14303");
                    statisticItem2.param("tid", this.a.p.getId());
                    statisticItem2.param("fid", this.a.p.getFid());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_type", 2);
                    if (this.a.t != 1) {
                        if (this.a.t != 2) {
                            if (this.a.t != 3) {
                                if (this.a.t == 4) {
                                    statisticItem2.param("obj_locate", 4);
                                }
                            } else {
                                statisticItem2.param("obj_locate", 3);
                            }
                        } else {
                            statisticItem2.param("obj_locate", 2);
                        }
                    } else {
                        statisticItem2.param("obj_locate", 1);
                    }
                    TiebaStatic.log(statisticItem2);
                }
                if (z) {
                    WriteData b0 = this.a.f11569g.b0();
                    this.a.f11569g.setWriteData(null);
                    this.a.f11569g.i0(false);
                    this.a.f11568f = null;
                    if (b0 == null || b0 == null || b0.getType() != 2) {
                        return;
                    }
                    this.a.i.J();
                } else if (i != 230277 && i != 230278 && i != 340016 && i != 1990032 && !AntiHelper.m(i, str)) {
                    if (l0Var == null || writeData == null || StringUtils.isNull(l0Var.c())) {
                        if (postWriteCallBackData != null && i == 227001) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.f11564b.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                            return;
                        } else if (i == 238010 || c.a.p0.j4.a.c(i)) {
                            return;
                        } else {
                            this.a.getContext().showToast(str);
                            return;
                        }
                    }
                    writeData.setVcodeMD5(l0Var.b());
                    writeData.setVcodeUrl(l0Var.c());
                    writeData.setVcodeExtra(l0Var.a());
                    if (this.a.p != null) {
                        writeData.setBaijiahaoData(this.a.p.getBaijiahaoData());
                    }
                    if (c.a.o0.d1.a.b(l0Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.getContext().getPageActivity(), 12006, writeData, false, l0Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.getContext().getPageActivity(), writeData, 12006)));
                    }
                } else {
                    this.a.d0(i, str);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements b0.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // c.a.p0.a4.b0.f
        public void onDraftLoaded(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) {
                if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                    if (this.a.f11565c == null) {
                        this.a.f11565c = new j();
                    }
                    this.a.f11565c.a = writeData.getContent();
                    this.a.f11565c.f11575b = writeData.getSubPbReplyPrefix();
                    this.a.f11565c.f11577d = writeData.getPortrait();
                    this.a.f11565c.f11578e = writeData.getName();
                    h hVar = this.a;
                    hVar.L(hVar.f11565c);
                }
                if (this.a.q != null) {
                    this.a.q.onDraftLoaded(writeData);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public d(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.a.n)) {
                return;
            }
            n.N(this.a.getContext().getPageActivity(), this.a.n);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(EditorTools editorTools) {
        super(editorTools);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {editorTools};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((EditorTools) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11566d = "";
        this.j = false;
        this.n = null;
        this.s = 0;
        this.t = 0;
        this.u = new a(this);
        this.v = new b(this);
        this.w = new d(this);
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public void B(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeData) == null) || writeData == null) {
            return;
        }
        if (this.f11565c == null) {
            this.f11565c = new j();
        }
        this.f11565c.a = writeData.getContent();
        this.f11565c.f11575b = writeData.getSubPbReplyPrefix();
        this.f11565c.f11577d = writeData.getPortrait();
        this.f11565c.f11578e = writeData.getName();
        L(this.f11565c);
    }

    public void C(int i, int i2, Intent intent) {
        ArrayList<AtSelectData> parcelableArrayListExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            PostWriteCallBackData postWriteCallBackData = null;
            if (i2 != -1) {
                if (i2 == 0 && i == 12006) {
                    if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    }
                    PostWriteCallBackData postWriteCallBackData2 = postWriteCallBackData;
                    NewWriteModel.g gVar = this.m;
                    if (gVar != null) {
                        gVar.callback(false, postWriteCallBackData2, null, this.f11569g.b0(), null);
                    }
                }
            } else if (i == 12005) {
                if (intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA)) == null) {
                    return;
                }
                J(parcelableArrayListExtra);
            } else if (i != 12006) {
            } else {
                if (a() != null) {
                    a().o();
                }
                q();
                K(true);
                WriteData b0 = this.f11569g.b0();
                this.f11569g.setWriteData(null);
                this.f11569g.i0(false);
                if (b0 == null || b0 == null || b0.getType() != 2) {
                    return;
                }
                this.i.J();
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            I();
            this.f11569g.cancelLoadData();
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void F() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f11569g.b0() == null) {
                DataModel<?> dataModel = this.i;
                WriteData F = dataModel.F(dataModel.A());
                if (F != null && (threadData = this.p) != null) {
                    F.setBaijiahaoData(threadData.getBaijiahaoData());
                }
                this.f11569g.setWriteData(F);
            }
            if (this.f11569g.b0() == null) {
                return;
            }
            this.f11569g.setSpanGroupManager(this.f11570h);
            if (this.f11565c != null) {
                this.f11569g.b0().setContent(this.f11565c.a);
                this.f11569g.b0().setSubPbReplyPrefix(this.f11565c.f11575b);
                this.f11569g.b0().setPortrait(this.f11565c.f11577d);
                this.f11569g.b0().setName(this.f11565c.f11578e);
                if (this.p != null) {
                    this.f11569g.b0().setBaijiahaoData(this.p.getBaijiahaoData());
                }
            }
            this.f11569g.b0().setReplyId(this.f11566d);
            if (this.f11567e != null) {
                this.f11569g.b0().setRepostId(this.i.A());
            }
            VoiceData.VoiceModel voiceModel = this.f11568f;
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.f11569g.b0().setVoice(this.f11568f.getId());
                    this.f11569g.b0().setVoiceDuringTime(this.f11568f.duration);
                } else {
                    this.f11569g.b0().setVoice(null);
                    this.f11569g.b0().setVoiceDuringTime(-1);
                }
            } else {
                this.f11569g.b0().setVoice(null);
                this.f11569g.b0().setVoiceDuringTime(-1);
            }
            if (!this.f11569g.Y()) {
                getContext().showToast((int) R.string.obfuscated_res_0x7f0f1580);
                return;
            }
            c.a.o0.w.y.b bVar = this.l;
            if (bVar == null || !bVar.a()) {
                c.a.o0.w.y.c cVar = this.k;
                if (cVar != null) {
                    cVar.a();
                }
                s(this.f11569g.b0());
                r();
                if (!this.f11569g.r0()) {
                }
            }
        }
    }

    public void G(AntiData antiData) {
        c.a.o0.w.h m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, antiData) == null) || antiData == null) {
            return;
        }
        String voice_message = antiData.getVoice_message();
        this.n = voice_message;
        if (StringUtils.isNull(voice_message) || a() == null || (m = a().m(6)) == null || TextUtils.isEmpty(this.n)) {
            return;
        }
        ((View) m).setOnClickListener(this.w);
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f11569g.setWriteData(null);
            this.f11569g.i0(false);
            this.f11568f = null;
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            WriteData writeData = new WriteData(2);
            j jVar = this.f11565c;
            if (jVar != null) {
                writeData.setContent(jVar.a);
                writeData.setPortrait(this.f11565c.f11577d);
                writeData.setName(this.f11565c.f11578e);
                writeData.setSubPbReplyPrefix(this.f11565c.f11575b);
            }
            writeData.setReplyId(this.f11566d);
            writeData.setThreadId(this.f11567e);
            b0.z(this.f11567e, writeData);
        }
    }

    public final void J(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, arrayList) == null) || a() == null) {
            return;
        }
        a().A(new c.a.o0.w.a(17, 27, arrayList));
    }

    public final void K(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || a() == null) {
            return;
        }
        a().A(new c.a.o0.w.a(9, -1, Boolean.valueOf(z)));
    }

    public final void L(j jVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, jVar) == null) || a() == null) {
            return;
        }
        a().A(new c.a.o0.w.a(6, 27, jVar));
    }

    public void M(c.a.o0.w.y.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.l = bVar;
        }
    }

    public void N(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, tbPageContext) == null) {
            this.f11564b = tbPageContext;
        }
    }

    public void O(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.s = i;
        }
    }

    public void P(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.t = i;
        }
    }

    public void Q(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, gVar) == null) {
            this.m = gVar;
        }
    }

    public void R(b0.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, fVar) == null) {
            this.q = fVar;
        }
    }

    public void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            if (this.f11565c == null) {
                this.f11565c = new j();
            }
            this.f11565c.a = str;
        }
    }

    public void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f11567e = str;
        }
    }

    public void U(c.a.o0.w.y.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, cVar) == null) {
            this.k = cVar;
        }
    }

    public void V(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) || str == null) {
            return;
        }
        String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0f97).replace("%s", str);
        j jVar = this.f11565c;
        if (jVar != null) {
            if (TextUtils.isEmpty(jVar.f11575b) && TextUtils.isEmpty(this.f11565c.a)) {
                j0(str, str2);
                return;
            } else if (!TextUtils.isEmpty(this.f11565c.f11575b) && this.f11565c.f11575b.equals(replace)) {
                f0(this.f11565c);
                return;
            } else {
                j0(str, str2);
                return;
            }
        }
        j0(str, str2);
    }

    public void W(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.f11566d = str;
        }
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.j = z;
        }
    }

    public void Y(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, spanGroupManager) == null) {
            this.f11570h = spanGroupManager;
        }
    }

    public void Z(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, jVar) == null) {
            this.f11565c = jVar;
        }
    }

    public void a0(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, dataModel) == null) {
            this.i = dataModel;
            if (dataModel != null) {
                this.f11567e = dataModel.A();
            }
        }
    }

    public void b0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, threadData) == null) {
            this.p = threadData;
            if (a() == null || this.p == null) {
                return;
            }
            a().setFid(this.p.getFid());
            a().setTid(this.p.getTid());
        }
    }

    public void c0(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, voiceModel) == null) {
            this.f11568f = voiceModel;
        }
    }

    public void d0(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048605, this, i, str) == null) {
            if (AntiHelper.m(i, str)) {
                if (AntiHelper.w(this.f11564b.getPageActivity(), str, i, this.v) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
                }
            } else if (i != 230277 && i != 230278) {
                getContext().showToast(str);
            } else {
                h0(str);
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            X(true);
            a().j();
            a().x((View) a().m(5));
        }
    }

    public final void f0(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, jVar) == null) {
            X(true);
            a().j();
            L(jVar);
            TiebaStatic.eventStat(getContext().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            X(true);
            a().j();
            a().x((View) a().m(2));
        }
    }

    public TbPageContext<?> getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f11564b : (TbPageContext) invokeV.objValue;
    }

    public final void h0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(getContext().getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f0984, new e(this));
            aVar.create(getContext()).show();
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            X(true);
            a().j();
        }
    }

    public void j0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, str, str2) == null) {
            X(true);
            a().j();
            if (str != null && str.length() != 0) {
                String replace = getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0f97).replace("%s", str);
                j jVar = new j();
                jVar.f11575b = replace;
                jVar.f11577d = str2;
                jVar.f11578e = str;
                L(jVar);
            } else {
                j jVar2 = new j();
                jVar2.a = "";
                L(jVar2);
            }
            TiebaStatic.eventStat(getContext().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, str) == null) || StringUtils.isNull(str) || a() == null) {
            return;
        }
        a().A(new c.a.o0.w.a(45, 27, str));
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            b0.z(this.f11567e, null);
        }
    }

    public final void r() {
        DataModel<?> dataModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || this.p == null || (dataModel = this.i) == null || !dataModel.H()) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_COMMENT);
        statisticItem.addParam("obj_locate", 2);
        if (this.p.isVideoWorksInfo()) {
            statisticItem.addParam("obj_type", 3);
        } else if (this.p.isVideoThreadType()) {
            statisticItem.addParam("obj_type", 2);
        } else {
            statisticItem.addParam("obj_type", 1);
        }
        statisticItem.addParam("tid", this.p.getTid());
        statisticItem.addParam(TiebaStatic.Params.FID_1, this.p.getFid());
        statisticItem.addParam(TiebaStatic.Params.FID_2, this.i.y());
        statisticItem.addParam("order_id", this.i.D());
        TiebaStatic.log(statisticItem);
        c.a.o0.c.a.a(c.a.o0.c.a.f9871f, c.a.o0.c.a.f9868c, this.i.D(), this.i.E(), this.i.C(), this.i.z());
    }

    public void s(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, writeData) == null) || writeData == null) {
            return;
        }
        int i = 0;
        if (!TextUtils.isEmpty(writeData.getContent())) {
            int i2 = 0;
            while (TbPatternsCompat.EMOTION_PATTERRN.matcher(writeData.getContent()).find()) {
                i2++;
            }
            if (i2 > 0 && this.s > 0) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMALL_EMOTION_NUM);
                statisticItem.param("obj_type", i2);
                statisticItem.param("obj_source", this.s);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", writeData.getThreadId());
                TiebaStatic.log(statisticItem);
            }
        }
        if (writeData.getWriteImagesInfo() == null || ListUtils.isEmpty(writeData.getWriteImagesInfo().getChosedFiles())) {
            return;
        }
        for (ImageFileInfo imageFileInfo : writeData.getWriteImagesInfo().getChosedFiles()) {
            if (imageFileInfo.getImageType() == 1) {
                i++;
            }
        }
        if (i <= 0 || this.s <= 0) {
            return;
        }
        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_BIG_EMOTION_NUM);
        statisticItem2.param("obj_type", i);
        statisticItem2.param("obj_source", this.s);
        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem2.param("tid", writeData.getThreadId());
        TiebaStatic.log(statisticItem2);
    }

    public f t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.o == null && a() != null) {
                this.o = (f) a().n(27);
            }
            return this.o;
        }
        return (f) invokeV.objValue;
    }

    public SpanGroupManager u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.f11570h : (SpanGroupManager) invokeV.objValue;
    }

    public void v(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, postWriteCallBackData) == null) {
            PbEditorData pbEditorData = new PbEditorData();
            pbEditorData.setEditorType(1);
            j jVar = this.f11565c;
            if (jVar != null) {
                pbEditorData.setContent(jVar.a);
                pbEditorData.setSubPbReplyPrefix(this.f11565c.f11575b);
            }
            pbEditorData.setVoiceModel(this.f11568f);
            pbEditorData.setThreadData(new PbEditorData.ThreadData());
            pbEditorData.setDisableVoiceMessage(this.n);
            pbEditorData.setOpenVoiceRecordButton(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.f11564b.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            j jVar = this.f11565c;
            return (jVar == null || m.isEmpty(jVar.a)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            VoiceData.VoiceModel voiceModel = this.f11568f;
            return (voiceModel == null || TextUtils.isEmpty(voiceModel.voiceId) || this.f11568f.duration <= 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            X(false);
            a().o();
        }
    }

    public void z(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        NewWriteModel newWriteModel = new NewWriteModel(tbPageContext);
        this.f11569g = newWriteModel;
        newWriteModel.n0(this.u);
        b0.p(this.i.A(), new c(this));
    }
}
