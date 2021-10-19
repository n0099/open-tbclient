package c.a.q0.x.x;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.s.q.d2;
import c.a.q0.s.s.a;
import c.a.q0.t.c.l0;
import c.a.r0.k3.z;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
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
import org.apache.commons.lang3.text.FormattableUtils;
/* loaded from: classes3.dex */
public class h extends c.a.q0.x.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f15195f;

    /* renamed from: g  reason: collision with root package name */
    public j f15196g;

    /* renamed from: h  reason: collision with root package name */
    public String f15197h;

    /* renamed from: i  reason: collision with root package name */
    public String f15198i;

    /* renamed from: j  reason: collision with root package name */
    public VoiceData$VoiceModel f15199j;
    public NewWriteModel k;
    public SpanGroupManager l;
    public DataModel<?> m;
    public boolean n;
    public c.a.q0.x.x.c o;
    public c.a.q0.x.x.b p;
    public NewWriteModel.g q;
    public String r;
    public f s;
    public d2 t;
    public z.e u;
    public boolean v;
    public int w;
    public int x;
    public NewWriteModel.g y;
    public AntiHelper.k z;

    /* loaded from: classes3.dex */
    public class a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f15200a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15200a = hVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, l0 l0Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l0Var, writeData, antiData}) == null) {
                if (this.f15200a.q != null) {
                    this.f15200a.q.callback(z, postWriteCallBackData, l0Var, writeData, antiData);
                }
                if (z) {
                    this.f15200a.f15196g = null;
                    this.f15200a.f15197h = null;
                    this.f15200a.L(true);
                    this.f15200a.q();
                }
                int i2 = -1;
                if (postWriteCallBackData != null) {
                    i2 = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (z && this.f15200a.t != null) {
                    StatisticItem statisticItem = new StatisticItem("c13563");
                    statisticItem.param("tid", this.f15200a.t.f0());
                    statisticItem.param("fid", this.f15200a.t.T());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("obj_type", 2);
                    c.a.q0.m0.c k = TbPageExtraHelper.k(this.f15200a.f15195f.getPageActivity());
                    if (k != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, k.a());
                    }
                    if (TbPageExtraHelper.m() != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
                    }
                    if (this.f15200a.x != 0) {
                        if (this.f15200a.x != 1) {
                            if (this.f15200a.x != 2) {
                                if (this.f15200a.x != 3) {
                                    if (this.f15200a.x != 4) {
                                        if (this.f15200a.x != 5) {
                                            if (this.f15200a.x == 6) {
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
                    TiebaStatic.log(statisticItem);
                }
                if (z && this.f15200a.t != null) {
                    StatisticItem statisticItem2 = new StatisticItem("c14303");
                    statisticItem2.param("tid", this.f15200a.t.f0());
                    statisticItem2.param("fid", this.f15200a.t.T());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_type", 2);
                    if (this.f15200a.x != 1) {
                        if (this.f15200a.x != 2) {
                            if (this.f15200a.x != 3) {
                                if (this.f15200a.x == 4) {
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
                    WriteData X = this.f15200a.k.X();
                    this.f15200a.k.setWriteData(null);
                    this.f15200a.k.d0(false);
                    this.f15200a.f15199j = null;
                    if (X == null || X == null || X.getType() != 2) {
                        return;
                    }
                    this.f15200a.m.H();
                } else if (i2 != 230277 && i2 != 230278 && i2 != 340016 && i2 != 1990032 && !AntiHelper.m(i2, str)) {
                    if (l0Var == null || writeData == null || StringUtils.isNull(l0Var.c())) {
                        if (postWriteCallBackData != null && i2 == 227001) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.f15200a.f15195f.getPageActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, postWriteCallBackData.getAccessState())));
                            return;
                        } else if (i2 == 238010 || c.a.r0.u3.a.c(i2)) {
                            return;
                        } else {
                            this.f15200a.t().showToast(str);
                            return;
                        }
                    }
                    writeData.setVcodeMD5(l0Var.b());
                    writeData.setVcodeUrl(l0Var.c());
                    writeData.setVcodeExtra(l0Var.a());
                    if (this.f15200a.t != null) {
                        writeData.setBaijiahaoData(this.f15200a.t.L());
                    }
                    if (c.a.q0.e1.a.b(l0Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.f15200a.t().getPageActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, false, l0Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.f15200a.t().getPageActivity(), writeData, CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE)));
                    }
                } else {
                    this.f15200a.e0(i2, str);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements z.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f15201e;

        public c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15201e = hVar;
        }

        @Override // c.a.r0.k3.z.e
        public void onDraftLoaded(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) {
                if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                    if (this.f15201e.f15196g == null) {
                        this.f15201e.f15196g = new j();
                    }
                    this.f15201e.f15196g.f15209a = writeData.getContent();
                    this.f15201e.f15196g.f15210b = writeData.getSubPbReplyPrefix();
                    this.f15201e.f15196g.f15212d = writeData.getPortrait();
                    this.f15201e.f15196g.f15213e = writeData.getName();
                    h hVar = this.f15201e;
                    hVar.M(hVar.f15196g);
                }
                if (this.f15201e.u != null) {
                    this.f15201e.u.onDraftLoaded(writeData);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f15202e;

        public d(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15202e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f15202e.r)) {
                return;
            }
            l.M(this.f15202e.t().getPageActivity(), this.f15202e.r);
        }
    }

    /* loaded from: classes3.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((EditorTools) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15197h = "";
        this.n = false;
        this.r = null;
        this.w = 0;
        this.x = 0;
        this.y = new a(this);
        this.z = new b(this);
        this.A = new d(this);
    }

    public void A(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        NewWriteModel newWriteModel = new NewWriteModel(tbPageContext);
        this.k = newWriteModel;
        newWriteModel.h0(this.y);
        z.l(this.m.y(), new c(this));
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public void C(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) || writeData == null) {
            return;
        }
        if (this.f15196g == null) {
            this.f15196g = new j();
        }
        this.f15196g.f15209a = writeData.getContent();
        this.f15196g.f15210b = writeData.getSubPbReplyPrefix();
        this.f15196g.f15212d = writeData.getPortrait();
        this.f15196g.f15213e = writeData.getName();
        M(this.f15196g);
    }

    public void D(int i2, int i3, Intent intent) {
        ArrayList<AtSelectData> parcelableArrayListExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) {
            PostWriteCallBackData postWriteCallBackData = null;
            if (i3 != -1) {
                if (i3 == 0 && i2 == 12006) {
                    if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    }
                    PostWriteCallBackData postWriteCallBackData2 = postWriteCallBackData;
                    NewWriteModel.g gVar = this.q;
                    if (gVar != null) {
                        gVar.callback(false, postWriteCallBackData2, null, this.k.X(), null);
                    }
                }
            } else if (i2 == 12005) {
                if (intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA)) == null) {
                    return;
                }
                K(parcelableArrayListExtra);
            } else if (i2 != 12006) {
            } else {
                if (a() != null) {
                    a().hide();
                }
                q();
                L(true);
                WriteData X = this.k.X();
                this.k.setWriteData(null);
                this.k.d0(false);
                if (X == null || X == null || X.getType() != 2) {
                    return;
                }
                this.m.H();
            }
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            J();
            this.k.cancelLoadData();
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void G() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.k.X() == null) {
                DataModel<?> dataModel = this.m;
                WriteData D = dataModel.D(dataModel.y());
                if (D != null && (d2Var = this.t) != null) {
                    D.setBaijiahaoData(d2Var.L());
                }
                this.k.setWriteData(D);
            }
            if (this.k.X() == null) {
                return;
            }
            this.k.setSpanGroupManager(this.l);
            if (this.f15196g != null) {
                this.k.X().setContent(this.f15196g.f15209a);
                this.k.X().setSubPbReplyPrefix(this.f15196g.f15210b);
                this.k.X().setPortrait(this.f15196g.f15212d);
                this.k.X().setName(this.f15196g.f15213e);
                if (this.t != null) {
                    this.k.X().setBaijiahaoData(this.t.L());
                }
            }
            this.k.X().setReplyId(this.f15197h);
            if (this.f15198i != null) {
                this.k.X().setRepostId(this.m.y());
            }
            VoiceData$VoiceModel voiceData$VoiceModel = this.f15199j;
            if (voiceData$VoiceModel != null) {
                if (voiceData$VoiceModel.getId() != null) {
                    this.k.X().setVoice(this.f15199j.getId());
                    this.k.X().setVoiceDuringTime(this.f15199j.duration);
                } else {
                    this.k.X().setVoice(null);
                    this.k.X().setVoiceDuringTime(-1);
                }
            } else {
                this.k.X().setVoice(null);
                this.k.X().setVoiceDuringTime(-1);
            }
            if (!this.k.U()) {
                t().showToast(R.string.write_img_limit);
                return;
            }
            c.a.q0.x.x.b bVar = this.p;
            if (bVar == null || !bVar.a()) {
                c.a.q0.x.x.c cVar = this.o;
                if (cVar != null) {
                    cVar.a();
                }
                s(this.k.X());
                r();
                if (!this.k.l0()) {
                }
            }
        }
    }

    public void H(AntiData antiData) {
        c.a.q0.x.h findLauncherById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, antiData) == null) || antiData == null) {
            return;
        }
        String voice_message = antiData.getVoice_message();
        this.r = voice_message;
        if (StringUtils.isNull(voice_message) || a() == null || (findLauncherById = a().findLauncherById(6)) == null || TextUtils.isEmpty(this.r)) {
            return;
        }
        ((View) findLauncherById).setOnClickListener(this.A);
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k.setWriteData(null);
            this.k.d0(false);
            this.f15199j = null;
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            WriteData writeData = new WriteData(2);
            j jVar = this.f15196g;
            if (jVar != null) {
                writeData.setContent(jVar.f15209a);
                writeData.setPortrait(this.f15196g.f15212d);
                writeData.setName(this.f15196g.f15213e);
                writeData.setSubPbReplyPrefix(this.f15196g.f15210b);
            }
            writeData.setReplyId(this.f15197h);
            writeData.setThreadId(this.f15198i);
            z.t(this.f15198i, writeData);
        }
    }

    public final void K(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, arrayList) == null) || a() == null) {
            return;
        }
        a().sendAction(new c.a.q0.x.a(17, 27, arrayList));
    }

    public final void L(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || a() == null) {
            return;
        }
        a().sendAction(new c.a.q0.x.a(9, -1, Boolean.valueOf(z)));
    }

    public final void M(j jVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, jVar) == null) || a() == null) {
            return;
        }
        a().sendAction(new c.a.q0.x.a(6, 27, jVar));
    }

    public void N(c.a.q0.x.x.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.p = bVar;
        }
    }

    public void O(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, tbPageContext) == null) {
            this.f15195f = tbPageContext;
        }
    }

    public void P(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.w = i2;
        }
    }

    public void Q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.x = i2;
        }
    }

    public void R(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, gVar) == null) {
            this.q = gVar;
        }
    }

    public void S(z.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, eVar) == null) {
            this.u = eVar;
        }
    }

    public void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            if (this.f15196g == null) {
                this.f15196g = new j();
            }
            this.f15196g.f15209a = str;
        }
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.f15198i = str;
        }
    }

    public void V(c.a.q0.x.x.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, cVar) == null) {
            this.o = cVar;
        }
    }

    public void W(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) || str == null) {
            return;
        }
        String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace(FormattableUtils.SIMPLEST_FORMAT, str);
        j jVar = this.f15196g;
        if (jVar != null) {
            if (TextUtils.isEmpty(jVar.f15210b) && TextUtils.isEmpty(this.f15196g.f15209a)) {
                k0(str, str2);
                return;
            } else if (!TextUtils.isEmpty(this.f15196g.f15210b) && this.f15196g.f15210b.equals(replace)) {
                g0(this.f15196g);
                return;
            } else {
                k0(str, str2);
                return;
            }
        }
        k0(str, str2);
    }

    public void X(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.f15197h = str;
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.n = z;
        }
    }

    public void Z(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, spanGroupManager) == null) {
            this.l = spanGroupManager;
        }
    }

    public void a0(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, jVar) == null) {
            this.f15196g = jVar;
        }
    }

    public void b0(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, dataModel) == null) {
            this.m = dataModel;
            if (dataModel != null) {
                this.f15198i = dataModel.y();
            }
        }
    }

    public void c0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, d2Var) == null) {
            this.t = d2Var;
            if (a() == null || this.t == null) {
                return;
            }
            a().setFid(this.t.T());
            a().setTid(this.t.s1());
        }
    }

    public void d0(VoiceData$VoiceModel voiceData$VoiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, voiceData$VoiceModel) == null) {
            this.f15199j = voiceData$VoiceModel;
        }
    }

    public void e0(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048606, this, i2, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(this.f15195f.getPageActivity(), str, i2, this.z) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
                }
            } else if (i2 != 230277 && i2 != 230278) {
                t().showToast(str);
            } else {
                i0(str);
            }
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            Y(true);
            a().display();
            a().performLauncherClick((View) a().findLauncherById(5));
        }
    }

    public final void g0(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, jVar) == null) {
            Y(true);
            a().display();
            M(jVar);
            TiebaStatic.eventStat(t().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            Y(true);
            a().display();
            a().performLauncherClick((View) a().findLauncherById(2));
        }
    }

    public final void i0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(t().getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new e(this));
            aVar.create(t()).show();
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            Y(true);
            a().display();
        }
    }

    public void k0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, str, str2) == null) {
            Y(true);
            a().display();
            if (str != null && str.length() != 0) {
                String replace = t().getResources().getString(R.string.reply_sub_floor).replace(FormattableUtils.SIMPLEST_FORMAT, str);
                j jVar = new j();
                jVar.f15210b = replace;
                jVar.f15212d = str2;
                jVar.f15213e = str;
                M(jVar);
            } else {
                j jVar2 = new j();
                jVar2.f15209a = "";
                M(jVar2);
            }
            TiebaStatic.eventStat(t().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, str) == null) || StringUtils.isNull(str) || a() == null) {
            return;
        }
        a().sendAction(new c.a.q0.x.a(45, 27, str));
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            z.t(this.f15198i, null);
        }
    }

    public final void r() {
        DataModel<?> dataModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || this.t == null || (dataModel = this.m) == null || !dataModel.F()) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_COMMENT);
        statisticItem.addParam("obj_locate", 2);
        if (this.t.F2()) {
            statisticItem.addParam("obj_type", 3);
        } else if (this.t.E2()) {
            statisticItem.addParam("obj_type", 2);
        } else {
            statisticItem.addParam("obj_type", 1);
        }
        statisticItem.addParam("tid", this.t.s1());
        statisticItem.addParam(TiebaStatic.Params.FID_1, this.t.T());
        statisticItem.addParam(TiebaStatic.Params.FID_2, this.m.w());
        TiebaStatic.log(statisticItem);
        c.a.q0.d.a.a(c.a.q0.d.a.f12832f, c.a.q0.d.a.f12829c, this.m.B(), this.m.C(), this.m.A(), this.m.x());
    }

    public void s(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, writeData) == null) || writeData == null) {
            return;
        }
        int i2 = 0;
        if (!TextUtils.isEmpty(writeData.getContent())) {
            int i3 = 0;
            while (TbPatternsCompat.EMOTION_PATTERRN.matcher(writeData.getContent()).find()) {
                i3++;
            }
            if (i3 > 0 && this.w > 0) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMALL_EMOTION_NUM);
                statisticItem.param("obj_type", i3);
                statisticItem.param("obj_source", this.w);
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
                i2++;
            }
        }
        if (i2 <= 0 || this.w <= 0) {
            return;
        }
        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_BIG_EMOTION_NUM);
        statisticItem2.param("obj_type", i2);
        statisticItem2.param("obj_source", this.w);
        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem2.param("tid", writeData.getThreadId());
        TiebaStatic.log(statisticItem2);
    }

    public TbPageContext<?> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.f15195f : (TbPageContext) invokeV.objValue;
    }

    public f u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (this.s == null && a() != null) {
                this.s = (f) a().findToolById(27);
            }
            return this.s;
        }
        return (f) invokeV.objValue;
    }

    public SpanGroupManager v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.l : (SpanGroupManager) invokeV.objValue;
    }

    public void w(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, postWriteCallBackData) == null) {
            PbEditorData pbEditorData = new PbEditorData();
            pbEditorData.setEditorType(1);
            j jVar = this.f15196g;
            if (jVar != null) {
                pbEditorData.setContent(jVar.f15209a);
                pbEditorData.setSubPbReplyPrefix(this.f15196g.f15210b);
            }
            pbEditorData.setVoiceModel(this.f15199j);
            pbEditorData.setThreadData(new PbEditorData.ThreadData());
            pbEditorData.setDisableVoiceMessage(this.r);
            pbEditorData.setOpenVoiceRecordButton(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.f15195f.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
        }
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            j jVar = this.f15196g;
            return (jVar == null || k.isEmpty(jVar.f15209a)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            VoiceData$VoiceModel voiceData$VoiceModel = this.f15199j;
            return (voiceData$VoiceModel == null || TextUtils.isEmpty(voiceData$VoiceModel.voiceId) || this.f15199j.duration <= 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            Y(false);
            a().hide();
        }
    }
}
