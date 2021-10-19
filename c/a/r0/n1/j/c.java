package c.a.r0.n1.j;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.s.s.a;
import c.a.q0.t.c.l0;
import c.a.q0.x.m;
import c.a.q0.x.n;
import c.a.q0.x.w.d.b;
import c.a.r0.k2.k.e.u0;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.mutiprocess.showreplyinpb.ShowReplyInPbEvent;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f22452a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f22453b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.n1.j.b f22454c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.n1.j.a f22455d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.n1.j.a f22456e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.n1.j.a f22457f;

    /* renamed from: g  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f22458g;

    /* renamed from: h  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f22459h;

    /* renamed from: i  reason: collision with root package name */
    public int f22460i;

    /* renamed from: j  reason: collision with root package name */
    public String f22461j;
    public ImageUrlData k;
    public String l;
    public boolean m;
    public int n;
    public u0 o;
    public ReplyPrivacyCheckController p;
    public View.OnClickListener q;
    public c.a.q0.x.x.b r;
    public final NewWriteModel.g s;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22462e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22462e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f22462e.f22461j)) {
                return;
            }
            l.M(this.f22462e.f22452a.getPageActivity(), this.f22462e.f22461j);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.q0.x.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f22463a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22463a = cVar;
        }

        @Override // c.a.q0.x.x.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f22463a.k == null) {
                    return false;
                }
                c cVar = this.f22463a;
                if (cVar.o != null) {
                    c.a.r0.d4.c e2 = cVar.k.isFirstPost ? this.f22463a.o.e() : this.f22463a.o.g();
                    if (e2 != null && e2.d()) {
                        this.f22463a.f22452a.showToast(e2.c());
                        if (this.f22463a.f22455d != null && (this.f22463a.f22455d.D() || this.f22463a.f22455d.F())) {
                            this.f22463a.f22455d.B(false, this.f22463a.o.h());
                        }
                        if (this.f22463a.k.isFirstPost) {
                            this.f22463a.o.a(true);
                        } else {
                            this.f22463a.o.b(true);
                        }
                        return true;
                    }
                }
                return !this.f22463a.p.showToastForPrivacy(this.f22463a.f22460i);
            }
            return invokeV.booleanValue;
        }
    }

    /* renamed from: c.a.r0.n1.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1050c implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f22464a;

        /* renamed from: c.a.r0.n1.j.c$c$a */
        /* loaded from: classes3.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(C1050c c1050c) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1050c};
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

        /* renamed from: c.a.r0.n1.j.c$c$b */
        /* loaded from: classes3.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1050c f22465e;

            public b(C1050c c1050c) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1050c};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f22465e = c1050c;
            }

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f22465e.f22464a.f22452a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f22465e.f22464a.f22452a.getPageActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public C1050c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22464a = cVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, l0 l0Var, WriteData writeData, AntiData antiData) {
            String str;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l0Var, writeData, antiData}) == null) {
                if (postWriteCallBackData != null) {
                    i2 = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                    i2 = -1;
                }
                if (z) {
                    this.f22464a.k();
                    if (this.f22464a.f22452a != null && (this.f22464a.f22452a.getPageActivity() instanceof BaseActivity)) {
                        ShowReplyInPbEvent showReplyInPbEvent = new ShowReplyInPbEvent();
                        showReplyInPbEvent.writeData = postWriteCallBackData;
                        showReplyInPbEvent.isSubPbReply = writeData.isSubFloor();
                        ((BaseActivity) this.f22464a.f22452a.getPageActivity()).publishEvent(showReplyInPbEvent);
                    }
                    if (postWriteCallBackData != null) {
                        TiebaStatic.log(new StatisticItem("c13970").param("tid", postWriteCallBackData.getThreadId()).param("fid", writeData.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", writeData.getType()));
                    }
                } else if (i2 == 220015) {
                    this.f22464a.f22452a.showToast(str);
                    if (this.f22464a.f22455d != null && (this.f22464a.f22455d.D() || this.f22464a.f22455d.F())) {
                        this.f22464a.f22455d.B(false, postWriteCallBackData);
                        this.f22464a.k();
                    }
                    if (this.f22464a.k.isFirstPost) {
                        this.f22464a.o.k(postWriteCallBackData);
                    } else {
                        this.f22464a.o.l(postWriteCallBackData);
                    }
                } else if (i2 == 238010) {
                    if (!k.isEmpty(str)) {
                        this.f22464a.f22452a.showToast(str);
                    } else {
                        this.f22464a.f22452a.showToast(R.string.message_privacy_fans_can_reply);
                    }
                    this.f22464a.k();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (!k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.makeText(this.f22464a.f22452a.getPageActivity(), postWriteCallBackData.getErrorString(), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.makeText(this.f22464a.f22452a.getPageActivity(), this.f22464a.f22452a.getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f22464a.f22452a.getPageActivity());
                    if (k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.f22464a.f22452a.getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.cancel, new a(this));
                    aVar.setPositiveButton(R.string.open_now, new b(this));
                    aVar.create(this.f22464a.f22452a).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (c.a.r0.u3.a.c(i2)) {
                    this.f22464a.k();
                } else if (l0Var != null || i2 == 227001) {
                } else {
                    this.f22464a.t(i2, str);
                    this.f22464a.k();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22466e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22466e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent == null || motionEvent.getAction() != 0) {
                    return true;
                }
                this.f22466e.k();
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
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
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
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

    /* loaded from: classes3.dex */
    public class g implements b.InterfaceC0719b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f22467a;

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22467a = cVar;
        }

        @Override // c.a.q0.x.w.d.b.InterfaceC0719b
        public void onKeyboardShowing(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.f22467a.f22456e.a().mED.hideWhenKeyboardNotShow();
                } else {
                    this.f22467a.f22456e.a().mED.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements b.InterfaceC0719b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f22468a;

        public h(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22468a = cVar;
        }

        @Override // c.a.q0.x.w.d.b.InterfaceC0719b
        public void onKeyboardShowing(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.f22468a.f22457f.a().mED.hideWhenKeyboardNotShow();
                } else {
                    this.f22468a.f22457f.a().mED.setVisibility(0);
                }
            }
        }
    }

    public c(TbPageContext tbPageContext, LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, linearLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.q = new a(this);
        this.r = new b(this);
        this.s = new C1050c(this);
        this.f22452a = tbPageContext;
        this.f22453b = linearLayout;
        linearLayout.setOnTouchListener(new d(this));
        this.f22453b.setVisibility(8);
        this.p = new ReplyPrivacyCheckController(tbPageContext);
    }

    public final void j(int i2, Intent intent) {
        n nVar;
        c.a.r0.n1.j.a aVar;
        n nVar2;
        c.a.r0.n1.j.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, intent) == null) {
            if (i2 == 0 && (aVar2 = this.f22455d) != null) {
                aVar2.a().hideTools();
            } else {
                k();
            }
            if (intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                int editorType = pbEditorData.getEditorType();
                if (editorType != 0) {
                    if (editorType == 1 && (aVar = this.f22457f) != null) {
                        aVar.I(writeData);
                        this.f22457f.v0(pbEditorData.getVoiceModel());
                        m findToolById = this.f22457f.a().findToolById(6);
                        if (findToolById != null && (nVar2 = findToolById.k) != null) {
                            nVar2.onAction(new c.a.q0.x.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i2 == -1) {
                            this.f22457f.N(null, null);
                            return;
                        }
                        return;
                    }
                    return;
                }
                c.a.r0.n1.j.a aVar3 = this.f22456e;
                if (aVar3 != null) {
                    aVar3.U();
                    this.f22456e.v0(pbEditorData.getVoiceModel());
                    this.f22456e.I(writeData);
                    m findToolById2 = this.f22456e.a().findToolById(6);
                    if (findToolById2 != null && (nVar = findToolById2.k) != null) {
                        nVar.onAction(new c.a.q0.x.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        this.f22456e.N(null, null);
                    }
                }
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.r0.n1.j.a aVar = this.f22455d;
            if (aVar != null && aVar.a() != null) {
                this.f22455d.a().hide();
            }
            l.x(this.f22452a.getPageActivity(), this.f22453b);
            this.f22453b.setVisibility(8);
        }
    }

    public void l(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) {
            this.m = true;
            c.a.r0.n1.j.a aVar = this.f22455d;
            if (aVar != null) {
                if (i2 == 25035) {
                    j(i3, intent);
                    k();
                    return;
                }
                aVar.J(i2, i3, intent);
            }
        }
    }

    public void m(int i2) {
        c.a.r0.n1.j.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (aVar = this.f22455d) == null) {
            return;
        }
        aVar.a().onChangeSkinType(i2);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ReplyPrivacyCheckController replyPrivacyCheckController = this.p;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            if (this.f22458g != null) {
                c.a.q0.x.w.d.b.c(this.f22452a.getPageActivity(), this.f22458g);
            }
            if (this.f22459h != null) {
                c.a.q0.x.w.d.b.c(this.f22452a.getPageActivity(), this.f22459h);
            }
        }
    }

    public void o() {
        c.a.r0.n1.j.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.k == null || (aVar = this.f22455d) == null) {
            return;
        }
        aVar.W(this.k.threadId + "");
    }

    public void p() {
        c.a.r0.n1.j.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.k == null || (aVar = this.f22455d) == null) {
            return;
        }
        if (this.m) {
            this.m = false;
            return;
        }
        aVar.l();
        c.a.r0.n1.j.a aVar2 = this.f22455d;
        aVar2.t(this.k.threadId + "");
        this.f22455d.a().hideTools();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01a8 A[Catch: Exception -> 0x01b1, TRY_LEAVE, TryCatch #0 {Exception -> 0x01b1, blocks: (B:48:0x01a0, B:50:0x01a8), top: B:88:0x01a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0267  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(ImageUrlData imageUrlData, c.a.r0.n1.b bVar) {
        boolean z;
        JSONArray jSONArray;
        ImageUrlData imageUrlData2;
        c.a.q0.x.h findLauncherById;
        ImageUrlData imageUrlData3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, imageUrlData, bVar) == null) || imageUrlData == null || bVar == null) {
            return;
        }
        if (this.f22454c == null) {
            c.a.r0.n1.j.b bVar2 = new c.a.r0.n1.j.b();
            this.f22454c = bVar2;
            bVar2.k(imageUrlData.forumName, imageUrlData.forumId);
            this.f22454c.l(String.valueOf(imageUrlData.threadId));
        }
        if (imageUrlData.isFirstPost && this.f22456e == null) {
            c.a.r0.n1.j.b bVar3 = this.f22454c;
            bVar3.f22449e = false;
            this.f22456e = (c.a.r0.n1.j.a) bVar3.a(this.f22452a.getPageActivity());
            this.f22458g = c.a.q0.x.w.d.b.b(this.f22452a.getPageActivity(), this.f22456e.a().mED, new g(this));
        } else if (!imageUrlData.isFirstPost && this.f22457f == null) {
            c.a.r0.n1.j.b bVar4 = this.f22454c;
            bVar4.f22449e = true;
            this.f22457f = (c.a.r0.n1.j.a) bVar4.a(this.f22452a.getPageActivity());
            this.f22459h = c.a.q0.x.w.d.b.b(this.f22452a.getPageActivity(), this.f22457f.a().mED, new h(this));
        } else {
            z = false;
            c.a.r0.n1.j.a aVar = !imageUrlData.isFirstPost ? this.f22456e : this.f22457f;
            this.f22455d = aVar;
            jSONArray = null;
            if (z) {
                aVar.g0(this.f22452a);
                this.f22455d.p0(this.s);
                this.f22455d.f0(this.r);
                this.f22455d.H(this.f22452a, null);
                this.f22455d.P(bVar.P, null);
                this.f22455d.j0(bVar.O);
                this.f22455d.G();
                c.a.r0.n1.j.a aVar2 = this.f22455d;
                aVar2.Q = this.l;
                MetaData metaData = bVar.M;
                if (metaData == null) {
                    aVar2.u0(imageUrlData.threadId + "");
                } else {
                    aVar2.Q(metaData, imageUrlData.threadId + "", bVar.N);
                }
                if (imageUrlData.isFirstPost) {
                    this.f22455d.R();
                }
                this.f22455d.a().mEB.setPadding(0, 0, 0, 0);
                this.f22455d.a().sendAction(new c.a.q0.x.a(45, 27, null));
                this.f22455d.a().onChangeSkinType(this.n);
            }
            imageUrlData2 = this.k;
            if (imageUrlData2 != null || imageUrlData.postId != imageUrlData2.postId) {
                if (this.k != null) {
                    c.a.r0.n1.j.a aVar3 = this.f22455d;
                    aVar3.W(this.k.threadId + "");
                }
                this.f22455d.l();
                this.f22455d.U();
                c.a.r0.n1.j.a aVar4 = this.f22455d;
                aVar4.N = !imageUrlData.isFirstPost;
                aVar4.O = imageUrlData.postId + "";
                c.a.r0.n1.j.a aVar5 = this.f22455d;
                aVar5.P = imageUrlData.userId;
                if (!imageUrlData.isFirstPost && aVar5.a() != null) {
                    String string = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title);
                    try {
                        if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
                            jSONArray = new JSONArray(imageUrlData.richTextArray);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    this.f22455d.a().sendAction(new c.a.q0.x.a(45, 27, String.format(string, imageUrlData.userNameShow, (jSONArray != null || jSONArray.length() <= 0) ? "" : TbRichTextView.parse((Context) this.f22452a.getPageActivity(), jSONArray, false).toString())));
                }
                this.f22460i = bVar.L;
                this.f22461j = bVar.K;
                if (this.f22455d.a() != null && !StringUtils.isNull(this.f22461j) && (findLauncherById = this.f22455d.a().findLauncherById(6)) != null && !TextUtils.isEmpty(this.f22461j)) {
                    ((View) findLauncherById).setOnClickListener(this.q);
                }
                c.a.r0.n1.j.a aVar6 = this.f22455d;
                aVar6.t(imageUrlData.threadId + "");
            }
            imageUrlData3 = this.k;
            if (imageUrlData3 != null || imageUrlData3.isFirstPost != imageUrlData.isFirstPost) {
                if (this.f22455d.a() != null) {
                    this.f22453b.removeAllViews();
                    this.f22453b.addView(this.f22455d.a());
                }
                if (this.o == null) {
                    this.o = new u0();
                }
                if (this.f22455d.w() != null) {
                    this.o.m(this.f22455d.w().i());
                }
            }
            this.k = imageUrlData;
        }
        z = true;
        if (!imageUrlData.isFirstPost) {
        }
        this.f22455d = aVar;
        jSONArray = null;
        if (z) {
        }
        imageUrlData2 = this.k;
        if (imageUrlData2 != null) {
        }
        if (this.k != null) {
        }
        this.f22455d.l();
        this.f22455d.U();
        c.a.r0.n1.j.a aVar42 = this.f22455d;
        aVar42.N = !imageUrlData.isFirstPost;
        aVar42.O = imageUrlData.postId + "";
        c.a.r0.n1.j.a aVar52 = this.f22455d;
        aVar52.P = imageUrlData.userId;
        if (!imageUrlData.isFirstPost) {
            String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title);
            if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
            }
            this.f22455d.a().sendAction(new c.a.q0.x.a(45, 27, String.format(string2, imageUrlData.userNameShow, (jSONArray != null || jSONArray.length() <= 0) ? "" : TbRichTextView.parse((Context) this.f22452a.getPageActivity(), jSONArray, false).toString())));
        }
        this.f22460i = bVar.L;
        this.f22461j = bVar.K;
        if (this.f22455d.a() != null) {
            ((View) findLauncherById).setOnClickListener(this.q);
        }
        c.a.r0.n1.j.a aVar62 = this.f22455d;
        aVar62.t(imageUrlData.threadId + "");
        imageUrlData3 = this.k;
        if (imageUrlData3 != null) {
        }
        if (this.f22455d.a() != null) {
        }
        if (this.o == null) {
        }
        if (this.f22455d.w() != null) {
        }
        this.k = imageUrlData;
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.l = str;
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.n = i2;
        }
    }

    public final void t(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) {
            if (AntiHelper.m(i2, str)) {
                AntiHelper.w(this.f22452a.getPageActivity(), str, i2, new e(this));
            } else if (i2 == 230277) {
                v(str);
            } else {
                this.f22452a.showToast(str);
            }
        }
    }

    public void u(ImageUrlData imageUrlData, c.a.r0.n1.b bVar) {
        ReplyPrivacyCheckController replyPrivacyCheckController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, imageUrlData, bVar) == null) || (replyPrivacyCheckController = this.p) == null || imageUrlData == null || bVar == null || !replyPrivacyCheckController.checkPrivacyBeforeInvokeEditor(bVar.L)) {
            return;
        }
        ImageUrlData imageUrlData2 = this.k;
        if (imageUrlData2 == null || imageUrlData2.postId != imageUrlData.postId || this.f22455d == null) {
            q(imageUrlData, bVar);
        }
        c.a.r0.n1.j.a aVar = this.f22455d;
        if (aVar != null) {
            if (!aVar.D() && !this.f22455d.F()) {
                this.f22453b.setVisibility(0);
                if (this.f22455d.a() != null) {
                    this.f22455d.a().display();
                    this.f22455d.a().hideTools();
                    return;
                }
                return;
            }
            this.f22455d.B(false, null);
        }
    }

    public final void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            if (str == null) {
                str = "";
            }
            TbPageContext tbPageContext = this.f22452a;
            if (tbPageContext == null) {
                return;
            }
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(tbPageContext.getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new f(this));
            aVar.create(this.f22452a).show();
        }
    }
}
