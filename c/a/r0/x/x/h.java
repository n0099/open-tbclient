package c.a.r0.x.x;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.r0.s.r.d2;
import c.a.r0.s.t.a;
import c.a.r0.t.c.m0;
import c.a.s0.v3.a0;
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
/* loaded from: classes6.dex */
public class h extends c.a.r0.x.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f14088f;

    /* renamed from: g  reason: collision with root package name */
    public j f14089g;

    /* renamed from: h  reason: collision with root package name */
    public String f14090h;

    /* renamed from: i  reason: collision with root package name */
    public String f14091i;

    /* renamed from: j  reason: collision with root package name */
    public VoiceData$VoiceModel f14092j;

    /* renamed from: k  reason: collision with root package name */
    public NewWriteModel f14093k;
    public SpanGroupManager l;
    public DataModel<?> m;
    public boolean n;
    public c.a.r0.x.x.c o;
    public c.a.r0.x.x.b p;
    public NewWriteModel.g q;
    public String r;
    public f s;
    public d2 t;
    public a0.e u;
    public boolean v;
    public int w;
    public int x;
    public NewWriteModel.g y;
    public AntiHelper.k z;

    /* loaded from: classes6.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m0 m0Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) {
                if (this.a.q != null) {
                    this.a.q.callback(z, postWriteCallBackData, m0Var, writeData, antiData);
                }
                if (z) {
                    this.a.f14089g = null;
                    this.a.f14090h = null;
                    this.a.K(true);
                    this.a.q();
                }
                int i2 = -1;
                if (postWriteCallBackData != null) {
                    i2 = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (z && this.a.t != null) {
                    StatisticItem statisticItem = new StatisticItem("c13563");
                    statisticItem.param("tid", this.a.t.g0());
                    statisticItem.param("fid", this.a.t.U());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("obj_type", 2);
                    c.a.r0.n0.c k2 = TbPageExtraHelper.k(this.a.f14088f.getPageActivity());
                    if (k2 != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, k2.a());
                    }
                    if (TbPageExtraHelper.m() != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
                    }
                    if (this.a.x != 0) {
                        if (this.a.x != 1) {
                            if (this.a.x != 2) {
                                if (this.a.x != 3) {
                                    if (this.a.x != 4) {
                                        if (this.a.x != 5) {
                                            if (this.a.x == 6) {
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
                if (z && this.a.t != null) {
                    StatisticItem statisticItem2 = new StatisticItem("c14303");
                    statisticItem2.param("tid", this.a.t.g0());
                    statisticItem2.param("fid", this.a.t.U());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_type", 2);
                    if (this.a.x != 1) {
                        if (this.a.x != 2) {
                            if (this.a.x != 3) {
                                if (this.a.x == 4) {
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
                    WriteData Y = this.a.f14093k.Y();
                    this.a.f14093k.setWriteData(null);
                    this.a.f14093k.e0(false);
                    this.a.f14092j = null;
                    if (Y == null || Y == null || Y.getType() != 2) {
                        return;
                    }
                    this.a.m.H();
                } else if (i2 != 230277 && i2 != 230278 && i2 != 340016 && i2 != 1990032 && !AntiHelper.m(i2, str)) {
                    if (m0Var == null || writeData == null || StringUtils.isNull(m0Var.c())) {
                        if (postWriteCallBackData != null && i2 == 227001) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.f14088f.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                            return;
                        } else if (i2 == 238010 || c.a.s0.f4.a.c(i2)) {
                            return;
                        } else {
                            this.a.getContext().showToast(str);
                            return;
                        }
                    }
                    writeData.setVcodeMD5(m0Var.b());
                    writeData.setVcodeUrl(m0Var.c());
                    writeData.setVcodeExtra(m0Var.a());
                    if (this.a.t != null) {
                        writeData.setBaijiahaoData(this.a.t.L());
                    }
                    if (c.a.r0.e1.a.b(m0Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.getContext().getPageActivity(), 12006, writeData, false, m0Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.getContext().getPageActivity(), writeData, 12006)));
                    }
                } else {
                    this.a.d0(i2, str);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
        public void onNavigationButtonClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements a0.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f14094e;

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
            this.f14094e = hVar;
        }

        @Override // c.a.s0.v3.a0.e
        public void onDraftLoaded(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) {
                if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                    if (this.f14094e.f14089g == null) {
                        this.f14094e.f14089g = new j();
                    }
                    this.f14094e.f14089g.a = writeData.getContent();
                    this.f14094e.f14089g.f14101b = writeData.getSubPbReplyPrefix();
                    this.f14094e.f14089g.f14103d = writeData.getPortrait();
                    this.f14094e.f14089g.f14104e = writeData.getName();
                    h hVar = this.f14094e;
                    hVar.L(hVar.f14089g);
                }
                if (this.f14094e.u != null) {
                    this.f14094e.u.onDraftLoaded(writeData);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f14095e;

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
            this.f14095e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f14095e.r)) {
                return;
            }
            m.M(this.f14095e.getContext().getPageActivity(), this.f14095e.r);
        }
    }

    /* loaded from: classes6.dex */
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

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
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
        this.f14090h = "";
        this.n = false;
        this.r = null;
        this.w = 0;
        this.x = 0;
        this.y = new a(this);
        this.z = new b(this);
        this.A = new d(this);
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public void B(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeData) == null) || writeData == null) {
            return;
        }
        if (this.f14089g == null) {
            this.f14089g = new j();
        }
        this.f14089g.a = writeData.getContent();
        this.f14089g.f14101b = writeData.getSubPbReplyPrefix();
        this.f14089g.f14103d = writeData.getPortrait();
        this.f14089g.f14104e = writeData.getName();
        L(this.f14089g);
    }

    public void C(int i2, int i3, Intent intent) {
        ArrayList<AtSelectData> parcelableArrayListExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) {
            PostWriteCallBackData postWriteCallBackData = null;
            if (i3 != -1) {
                if (i3 == 0 && i2 == 12006) {
                    if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    }
                    PostWriteCallBackData postWriteCallBackData2 = postWriteCallBackData;
                    NewWriteModel.g gVar = this.q;
                    if (gVar != null) {
                        gVar.callback(false, postWriteCallBackData2, null, this.f14093k.Y(), null);
                    }
                }
            } else if (i2 == 12005) {
                if (intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA)) == null) {
                    return;
                }
                J(parcelableArrayListExtra);
            } else if (i2 != 12006) {
            } else {
                if (a() != null) {
                    a().hide();
                }
                q();
                K(true);
                WriteData Y = this.f14093k.Y();
                this.f14093k.setWriteData(null);
                this.f14093k.e0(false);
                if (Y == null || Y == null || Y.getType() != 2) {
                    return;
                }
                this.m.H();
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            I();
            this.f14093k.cancelLoadData();
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void F() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f14093k.Y() == null) {
                DataModel<?> dataModel = this.m;
                WriteData D = dataModel.D(dataModel.y());
                if (D != null && (d2Var = this.t) != null) {
                    D.setBaijiahaoData(d2Var.L());
                }
                this.f14093k.setWriteData(D);
            }
            if (this.f14093k.Y() == null) {
                return;
            }
            this.f14093k.setSpanGroupManager(this.l);
            if (this.f14089g != null) {
                this.f14093k.Y().setContent(this.f14089g.a);
                this.f14093k.Y().setSubPbReplyPrefix(this.f14089g.f14101b);
                this.f14093k.Y().setPortrait(this.f14089g.f14103d);
                this.f14093k.Y().setName(this.f14089g.f14104e);
                if (this.t != null) {
                    this.f14093k.Y().setBaijiahaoData(this.t.L());
                }
            }
            this.f14093k.Y().setReplyId(this.f14090h);
            if (this.f14091i != null) {
                this.f14093k.Y().setRepostId(this.m.y());
            }
            VoiceData$VoiceModel voiceData$VoiceModel = this.f14092j;
            if (voiceData$VoiceModel != null) {
                if (voiceData$VoiceModel.getId() != null) {
                    this.f14093k.Y().setVoice(this.f14092j.getId());
                    this.f14093k.Y().setVoiceDuringTime(this.f14092j.duration);
                } else {
                    this.f14093k.Y().setVoice(null);
                    this.f14093k.Y().setVoiceDuringTime(-1);
                }
            } else {
                this.f14093k.Y().setVoice(null);
                this.f14093k.Y().setVoiceDuringTime(-1);
            }
            if (!this.f14093k.V()) {
                getContext().showToast(R.string.write_img_limit);
                return;
            }
            c.a.r0.x.x.b bVar = this.p;
            if (bVar == null || !bVar.a()) {
                c.a.r0.x.x.c cVar = this.o;
                if (cVar != null) {
                    cVar.a();
                }
                s(this.f14093k.Y());
                r();
                if (!this.f14093k.n0()) {
                }
            }
        }
    }

    public void G(AntiData antiData) {
        c.a.r0.x.h findLauncherById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, antiData) == null) || antiData == null) {
            return;
        }
        String voice_message = antiData.getVoice_message();
        this.r = voice_message;
        if (StringUtils.isNull(voice_message) || a() == null || (findLauncherById = a().findLauncherById(6)) == null || TextUtils.isEmpty(this.r)) {
            return;
        }
        ((View) findLauncherById).setOnClickListener(this.A);
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f14093k.setWriteData(null);
            this.f14093k.e0(false);
            this.f14092j = null;
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            WriteData writeData = new WriteData(2);
            j jVar = this.f14089g;
            if (jVar != null) {
                writeData.setContent(jVar.a);
                writeData.setPortrait(this.f14089g.f14103d);
                writeData.setName(this.f14089g.f14104e);
                writeData.setSubPbReplyPrefix(this.f14089g.f14101b);
            }
            writeData.setReplyId(this.f14090h);
            writeData.setThreadId(this.f14091i);
            a0.t(this.f14091i, writeData);
        }
    }

    public final void J(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, arrayList) == null) || a() == null) {
            return;
        }
        a().sendAction(new c.a.r0.x.a(17, 27, arrayList));
    }

    public final void K(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || a() == null) {
            return;
        }
        a().sendAction(new c.a.r0.x.a(9, -1, Boolean.valueOf(z)));
    }

    public final void L(j jVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, jVar) == null) || a() == null) {
            return;
        }
        a().sendAction(new c.a.r0.x.a(6, 27, jVar));
    }

    public void M(c.a.r0.x.x.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.p = bVar;
        }
    }

    public void N(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, tbPageContext) == null) {
            this.f14088f = tbPageContext;
        }
    }

    public void O(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.w = i2;
        }
    }

    public void P(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.x = i2;
        }
    }

    public void Q(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, gVar) == null) {
            this.q = gVar;
        }
    }

    public void R(a0.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, eVar) == null) {
            this.u = eVar;
        }
    }

    public void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            if (this.f14089g == null) {
                this.f14089g = new j();
            }
            this.f14089g.a = str;
        }
    }

    public void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f14091i = str;
        }
    }

    public void U(c.a.r0.x.x.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, cVar) == null) {
            this.o = cVar;
        }
    }

    public void V(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) || str == null) {
            return;
        }
        String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace(FormattableUtils.SIMPLEST_FORMAT, str);
        j jVar = this.f14089g;
        if (jVar != null) {
            if (TextUtils.isEmpty(jVar.f14101b) && TextUtils.isEmpty(this.f14089g.a)) {
                j0(str, str2);
                return;
            } else if (!TextUtils.isEmpty(this.f14089g.f14101b) && this.f14089g.f14101b.equals(replace)) {
                f0(this.f14089g);
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
            this.f14090h = str;
        }
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.n = z;
        }
    }

    public void Y(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, spanGroupManager) == null) {
            this.l = spanGroupManager;
        }
    }

    public void Z(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, jVar) == null) {
            this.f14089g = jVar;
        }
    }

    public void a0(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, dataModel) == null) {
            this.m = dataModel;
            if (dataModel != null) {
                this.f14091i = dataModel.y();
            }
        }
    }

    public void b0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, d2Var) == null) {
            this.t = d2Var;
            if (a() == null || this.t == null) {
                return;
            }
            a().setFid(this.t.U());
            a().setTid(this.t.v1());
        }
    }

    public void c0(VoiceData$VoiceModel voiceData$VoiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, voiceData$VoiceModel) == null) {
            this.f14092j = voiceData$VoiceModel;
        }
    }

    public void d0(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048605, this, i2, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(this.f14088f.getPageActivity(), str, i2, this.z) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
                }
            } else if (i2 != 230277 && i2 != 230278) {
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
            a().display();
            a().performLauncherClick((View) a().findLauncherById(5));
        }
    }

    public final void f0(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, jVar) == null) {
            X(true);
            a().display();
            L(jVar);
            TiebaStatic.eventStat(getContext().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            X(true);
            a().display();
            a().performLauncherClick((View) a().findLauncherById(2));
        }
    }

    public TbPageContext<?> getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f14088f : (TbPageContext) invokeV.objValue;
    }

    public final void h0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(getContext().getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new e(this));
            aVar.create(getContext()).show();
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            X(true);
            a().display();
        }
    }

    public void j0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, str, str2) == null) {
            X(true);
            a().display();
            if (str != null && str.length() != 0) {
                String replace = getContext().getResources().getString(R.string.reply_sub_floor).replace(FormattableUtils.SIMPLEST_FORMAT, str);
                j jVar = new j();
                jVar.f14101b = replace;
                jVar.f14103d = str2;
                jVar.f14104e = str;
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
        a().sendAction(new c.a.r0.x.a(45, 27, str));
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            a0.t(this.f14091i, null);
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
        if (this.t.I2()) {
            statisticItem.addParam("obj_type", 3);
        } else if (this.t.H2()) {
            statisticItem.addParam("obj_type", 2);
        } else {
            statisticItem.addParam("obj_type", 1);
        }
        statisticItem.addParam("tid", this.t.v1());
        statisticItem.addParam(TiebaStatic.Params.FID_1, this.t.U());
        statisticItem.addParam(TiebaStatic.Params.FID_2, this.m.w());
        TiebaStatic.log(statisticItem);
        c.a.r0.d.a.a(c.a.r0.d.a.f12118f, c.a.r0.d.a.f12115c, this.m.B(), this.m.C(), this.m.A(), this.m.x());
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

    public f t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.s == null && a() != null) {
                this.s = (f) a().findToolById(27);
            }
            return this.s;
        }
        return (f) invokeV.objValue;
    }

    public SpanGroupManager u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.l : (SpanGroupManager) invokeV.objValue;
    }

    public void v(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, postWriteCallBackData) == null) {
            PbEditorData pbEditorData = new PbEditorData();
            pbEditorData.setEditorType(1);
            j jVar = this.f14089g;
            if (jVar != null) {
                pbEditorData.setContent(jVar.a);
                pbEditorData.setSubPbReplyPrefix(this.f14089g.f14101b);
            }
            pbEditorData.setVoiceModel(this.f14092j);
            pbEditorData.setThreadData(new PbEditorData.ThreadData());
            pbEditorData.setDisableVoiceMessage(this.r);
            pbEditorData.setOpenVoiceRecordButton(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.f14088f.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            j jVar = this.f14089g;
            return (jVar == null || l.isEmpty(jVar.a)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            VoiceData$VoiceModel voiceData$VoiceModel = this.f14092j;
            return (voiceData$VoiceModel == null || TextUtils.isEmpty(voiceData$VoiceModel.voiceId) || this.f14092j.duration <= 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            X(false);
            a().hide();
        }
    }

    public void z(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        NewWriteModel newWriteModel = new NewWriteModel(tbPageContext);
        this.f14093k = newWriteModel;
        newWriteModel.j0(this.y);
        a0.l(this.m.y(), new c(this));
    }
}
