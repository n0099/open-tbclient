package b.a.r0.n1.j;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.k;
import b.a.e.e.p.l;
import b.a.q0.s.s.a;
import b.a.q0.t.c.m0;
import b.a.q0.x.m;
import b.a.q0.x.n;
import b.a.q0.x.w.d.b;
import b.a.r0.k2.u.f.u0;
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
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f21354a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f21355b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.n1.j.b f21356c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.n1.j.a f21357d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.n1.j.a f21358e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.n1.j.a f21359f;

    /* renamed from: g  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f21360g;

    /* renamed from: h  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f21361h;

    /* renamed from: i  reason: collision with root package name */
    public int f21362i;
    public String j;
    public ImageUrlData k;
    public String l;
    public boolean m;
    public int n;
    public u0 o;
    public ReplyPrivacyCheckController p;
    public View.OnClickListener q;
    public b.a.q0.x.x.b r;
    public final NewWriteModel.g s;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21363e;

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
            this.f21363e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f21363e.j)) {
                return;
            }
            l.M(this.f21363e.f21354a.getPageActivity(), this.f21363e.j);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements b.a.q0.x.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f21364a;

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
            this.f21364a = cVar;
        }

        @Override // b.a.q0.x.x.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f21364a.k == null) {
                    return false;
                }
                c cVar = this.f21364a;
                if (cVar.o != null) {
                    b.a.r0.d4.c e2 = cVar.k.isFirstPost ? this.f21364a.o.e() : this.f21364a.o.g();
                    if (e2 != null && e2.d()) {
                        this.f21364a.f21354a.showToast(e2.c());
                        if (this.f21364a.f21357d != null && (this.f21364a.f21357d.C() || this.f21364a.f21357d.E())) {
                            this.f21364a.f21357d.A(false, this.f21364a.o.h());
                        }
                        if (this.f21364a.k.isFirstPost) {
                            this.f21364a.o.a(true);
                        } else {
                            this.f21364a.o.b(true);
                        }
                        return true;
                    }
                }
                return !this.f21364a.p.showToastForPrivacy(this.f21364a.f21362i);
            }
            return invokeV.booleanValue;
        }
    }

    /* renamed from: b.a.r0.n1.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1050c implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f21365a;

        /* renamed from: b.a.r0.n1.j.c$c$a */
        /* loaded from: classes5.dex */
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

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* renamed from: b.a.r0.n1.j.c$c$b */
        /* loaded from: classes5.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1050c f21366e;

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
                this.f21366e = c1050c;
            }

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f21366e.f21365a.f21354a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f21366e.f21365a.f21354a.getPageActivity(), 0, 26, 2)));
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
            this.f21365a = cVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m0 m0Var, WriteData writeData, AntiData antiData) {
            String str;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) {
                if (postWriteCallBackData != null) {
                    i2 = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                    i2 = -1;
                }
                if (z) {
                    this.f21365a.k();
                    if (this.f21365a.f21354a != null && (this.f21365a.f21354a.getPageActivity() instanceof BaseActivity)) {
                        ShowReplyInPbEvent showReplyInPbEvent = new ShowReplyInPbEvent();
                        showReplyInPbEvent.writeData = postWriteCallBackData;
                        showReplyInPbEvent.isSubPbReply = writeData.isSubFloor();
                        ((BaseActivity) this.f21365a.f21354a.getPageActivity()).publishEvent(showReplyInPbEvent);
                    }
                    if (postWriteCallBackData != null) {
                        TiebaStatic.log(new StatisticItem("c13970").param("tid", postWriteCallBackData.getThreadId()).param("fid", writeData.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", writeData.getType()));
                    }
                } else if (i2 == 220015) {
                    this.f21365a.f21354a.showToast(str);
                    if (this.f21365a.f21357d != null && (this.f21365a.f21357d.C() || this.f21365a.f21357d.E())) {
                        this.f21365a.f21357d.A(false, postWriteCallBackData);
                        this.f21365a.k();
                    }
                    if (this.f21365a.k.isFirstPost) {
                        this.f21365a.o.k(postWriteCallBackData);
                    } else {
                        this.f21365a.o.l(postWriteCallBackData);
                    }
                } else if (i2 == 238010) {
                    if (!k.isEmpty(str)) {
                        this.f21365a.f21354a.showToast(str);
                    } else {
                        this.f21365a.f21354a.showToast(R.string.message_privacy_fans_can_reply);
                    }
                    this.f21365a.k();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (!k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.makeText(this.f21365a.f21354a.getPageActivity(), postWriteCallBackData.getErrorString(), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.makeText(this.f21365a.f21354a.getPageActivity(), this.f21365a.f21354a.getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f21365a.f21354a.getPageActivity());
                    if (k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.f21365a.f21354a.getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.cancel, new a(this));
                    aVar.setPositiveButton(R.string.open_now, new b(this));
                    aVar.create(this.f21365a.f21354a).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (b.a.r0.v3.a.c(i2)) {
                    this.f21365a.k();
                } else if (m0Var != null || i2 == 227001) {
                } else {
                    this.f21365a.t(i2, str);
                    this.f21365a.k();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21367e;

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
            this.f21367e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent == null || motionEvent.getAction() != 0) {
                    return true;
                }
                this.f21367e.k();
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
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
        public void onNavigationButtonClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements b.InterfaceC0715b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f21368a;

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
            this.f21368a = cVar;
        }

        @Override // b.a.q0.x.w.d.b.InterfaceC0715b
        public void onKeyboardShowing(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.f21368a.f21358e.a().mED.hideWhenKeyboardNotShow();
                } else {
                    this.f21368a.f21358e.a().mED.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements b.InterfaceC0715b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f21369a;

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
            this.f21369a = cVar;
        }

        @Override // b.a.q0.x.w.d.b.InterfaceC0715b
        public void onKeyboardShowing(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.f21369a.f21359f.a().mED.hideWhenKeyboardNotShow();
                } else {
                    this.f21369a.f21359f.a().mED.setVisibility(0);
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
        this.f21354a = tbPageContext;
        this.f21355b = linearLayout;
        linearLayout.setOnTouchListener(new d(this));
        this.f21355b.setVisibility(8);
        this.p = new ReplyPrivacyCheckController(tbPageContext);
    }

    public final void j(int i2, Intent intent) {
        n nVar;
        b.a.r0.n1.j.a aVar;
        n nVar2;
        b.a.r0.n1.j.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, intent) == null) {
            if (i2 == 0 && (aVar2 = this.f21357d) != null) {
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
                    if (editorType == 1 && (aVar = this.f21359f) != null) {
                        aVar.H(writeData);
                        this.f21359f.u0(pbEditorData.getVoiceModel());
                        m findToolById = this.f21359f.a().findToolById(6);
                        if (findToolById != null && (nVar2 = findToolById.k) != null) {
                            nVar2.onAction(new b.a.q0.x.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i2 == -1) {
                            this.f21359f.M(null, null);
                            return;
                        }
                        return;
                    }
                    return;
                }
                b.a.r0.n1.j.a aVar3 = this.f21358e;
                if (aVar3 != null) {
                    aVar3.T();
                    this.f21358e.u0(pbEditorData.getVoiceModel());
                    this.f21358e.H(writeData);
                    m findToolById2 = this.f21358e.a().findToolById(6);
                    if (findToolById2 != null && (nVar = findToolById2.k) != null) {
                        nVar.onAction(new b.a.q0.x.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        this.f21358e.M(null, null);
                    }
                }
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.r0.n1.j.a aVar = this.f21357d;
            if (aVar != null && aVar.a() != null) {
                this.f21357d.a().hide();
            }
            l.x(this.f21354a.getPageActivity(), this.f21355b);
            this.f21355b.setVisibility(8);
        }
    }

    public void l(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) {
            this.m = true;
            b.a.r0.n1.j.a aVar = this.f21357d;
            if (aVar != null) {
                if (i2 == 25035) {
                    j(i3, intent);
                    k();
                    return;
                }
                aVar.I(i2, i3, intent);
            }
        }
    }

    public void m(int i2) {
        b.a.r0.n1.j.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (aVar = this.f21357d) == null) {
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
            if (this.f21360g != null) {
                b.a.q0.x.w.d.b.c(this.f21354a.getPageActivity(), this.f21360g);
            }
            if (this.f21361h != null) {
                b.a.q0.x.w.d.b.c(this.f21354a.getPageActivity(), this.f21361h);
            }
        }
    }

    public void o() {
        b.a.r0.n1.j.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.k == null || (aVar = this.f21357d) == null) {
            return;
        }
        aVar.V(this.k.threadId + "");
    }

    public void p() {
        b.a.r0.n1.j.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.k == null || (aVar = this.f21357d) == null) {
            return;
        }
        if (this.m) {
            this.m = false;
            return;
        }
        aVar.l();
        b.a.r0.n1.j.a aVar2 = this.f21357d;
        aVar2.s(this.k.threadId + "");
        this.f21357d.a().hideTools();
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
    public void q(ImageUrlData imageUrlData, b.a.r0.n1.b bVar) {
        boolean z;
        JSONArray jSONArray;
        ImageUrlData imageUrlData2;
        b.a.q0.x.h findLauncherById;
        ImageUrlData imageUrlData3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, imageUrlData, bVar) == null) || imageUrlData == null || bVar == null) {
            return;
        }
        if (this.f21356c == null) {
            b.a.r0.n1.j.b bVar2 = new b.a.r0.n1.j.b();
            this.f21356c = bVar2;
            bVar2.k(imageUrlData.forumName, imageUrlData.forumId);
            this.f21356c.l(String.valueOf(imageUrlData.threadId));
        }
        if (imageUrlData.isFirstPost && this.f21358e == null) {
            b.a.r0.n1.j.b bVar3 = this.f21356c;
            bVar3.f21351e = false;
            this.f21358e = (b.a.r0.n1.j.a) bVar3.a(this.f21354a.getPageActivity());
            this.f21360g = b.a.q0.x.w.d.b.b(this.f21354a.getPageActivity(), this.f21358e.a().mED, new g(this));
        } else if (!imageUrlData.isFirstPost && this.f21359f == null) {
            b.a.r0.n1.j.b bVar4 = this.f21356c;
            bVar4.f21351e = true;
            this.f21359f = (b.a.r0.n1.j.a) bVar4.a(this.f21354a.getPageActivity());
            this.f21361h = b.a.q0.x.w.d.b.b(this.f21354a.getPageActivity(), this.f21359f.a().mED, new h(this));
        } else {
            z = false;
            b.a.r0.n1.j.a aVar = !imageUrlData.isFirstPost ? this.f21358e : this.f21359f;
            this.f21357d = aVar;
            jSONArray = null;
            if (z) {
                aVar.f0(this.f21354a);
                this.f21357d.o0(this.s);
                this.f21357d.e0(this.r);
                this.f21357d.G(this.f21354a, null);
                this.f21357d.O(bVar.P, null);
                this.f21357d.i0(bVar.O);
                this.f21357d.F();
                b.a.r0.n1.j.a aVar2 = this.f21357d;
                aVar2.Q = this.l;
                MetaData metaData = bVar.M;
                if (metaData == null) {
                    aVar2.t0(imageUrlData.threadId + "");
                } else {
                    aVar2.P(metaData, imageUrlData.threadId + "", bVar.N);
                }
                if (imageUrlData.isFirstPost) {
                    this.f21357d.Q();
                }
                this.f21357d.a().mEB.setPadding(0, 0, 0, 0);
                this.f21357d.a().sendAction(new b.a.q0.x.a(45, 27, null));
                this.f21357d.a().onChangeSkinType(this.n);
            }
            imageUrlData2 = this.k;
            if (imageUrlData2 != null || imageUrlData.postId != imageUrlData2.postId) {
                if (this.k != null) {
                    b.a.r0.n1.j.a aVar3 = this.f21357d;
                    aVar3.V(this.k.threadId + "");
                }
                this.f21357d.l();
                this.f21357d.T();
                b.a.r0.n1.j.a aVar4 = this.f21357d;
                aVar4.N = !imageUrlData.isFirstPost;
                aVar4.O = imageUrlData.postId + "";
                b.a.r0.n1.j.a aVar5 = this.f21357d;
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
                    this.f21357d.a().sendAction(new b.a.q0.x.a(45, 27, String.format(string, imageUrlData.userNameShow, (jSONArray != null || jSONArray.length() <= 0) ? "" : TbRichTextView.parse((Context) this.f21354a.getPageActivity(), jSONArray, false).toString())));
                }
                this.f21362i = bVar.L;
                this.j = bVar.K;
                if (this.f21357d.a() != null && !StringUtils.isNull(this.j) && (findLauncherById = this.f21357d.a().findLauncherById(6)) != null && !TextUtils.isEmpty(this.j)) {
                    ((View) findLauncherById).setOnClickListener(this.q);
                }
                b.a.r0.n1.j.a aVar6 = this.f21357d;
                aVar6.s(imageUrlData.threadId + "");
            }
            imageUrlData3 = this.k;
            if (imageUrlData3 != null || imageUrlData3.isFirstPost != imageUrlData.isFirstPost) {
                if (this.f21357d.a() != null) {
                    this.f21355b.removeAllViews();
                    this.f21355b.addView(this.f21357d.a());
                }
                if (this.o == null) {
                    this.o = new u0();
                }
                if (this.f21357d.v() != null) {
                    this.o.m(this.f21357d.v().h());
                }
            }
            this.k = imageUrlData;
        }
        z = true;
        if (!imageUrlData.isFirstPost) {
        }
        this.f21357d = aVar;
        jSONArray = null;
        if (z) {
        }
        imageUrlData2 = this.k;
        if (imageUrlData2 != null) {
        }
        if (this.k != null) {
        }
        this.f21357d.l();
        this.f21357d.T();
        b.a.r0.n1.j.a aVar42 = this.f21357d;
        aVar42.N = !imageUrlData.isFirstPost;
        aVar42.O = imageUrlData.postId + "";
        b.a.r0.n1.j.a aVar52 = this.f21357d;
        aVar52.P = imageUrlData.userId;
        if (!imageUrlData.isFirstPost) {
            String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title);
            if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
            }
            this.f21357d.a().sendAction(new b.a.q0.x.a(45, 27, String.format(string2, imageUrlData.userNameShow, (jSONArray != null || jSONArray.length() <= 0) ? "" : TbRichTextView.parse((Context) this.f21354a.getPageActivity(), jSONArray, false).toString())));
        }
        this.f21362i = bVar.L;
        this.j = bVar.K;
        if (this.f21357d.a() != null) {
            ((View) findLauncherById).setOnClickListener(this.q);
        }
        b.a.r0.n1.j.a aVar62 = this.f21357d;
        aVar62.s(imageUrlData.threadId + "");
        imageUrlData3 = this.k;
        if (imageUrlData3 != null) {
        }
        if (this.f21357d.a() != null) {
        }
        if (this.o == null) {
        }
        if (this.f21357d.v() != null) {
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
                AntiHelper.w(this.f21354a.getPageActivity(), str, i2, new e(this));
            } else if (i2 == 230277) {
                v(str);
            } else {
                this.f21354a.showToast(str);
            }
        }
    }

    public void u(ImageUrlData imageUrlData, b.a.r0.n1.b bVar) {
        ReplyPrivacyCheckController replyPrivacyCheckController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, imageUrlData, bVar) == null) || (replyPrivacyCheckController = this.p) == null || imageUrlData == null || bVar == null || !replyPrivacyCheckController.checkPrivacyBeforeInvokeEditor(bVar.L)) {
            return;
        }
        ImageUrlData imageUrlData2 = this.k;
        if (imageUrlData2 == null || imageUrlData2.postId != imageUrlData.postId || this.f21357d == null) {
            q(imageUrlData, bVar);
        }
        b.a.r0.n1.j.a aVar = this.f21357d;
        if (aVar != null) {
            if (!aVar.C() && !this.f21357d.E()) {
                this.f21355b.setVisibility(0);
                if (this.f21357d.a() != null) {
                    this.f21357d.a().display();
                    this.f21357d.a().hideTools();
                    return;
                }
                return;
            }
            this.f21357d.A(false, null);
        }
    }

    public final void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            if (str == null) {
                str = "";
            }
            TbPageContext tbPageContext = this.f21354a;
            if (tbPageContext == null) {
                return;
            }
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(tbPageContext.getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new f(this));
            aVar.create(this.f21354a).show();
        }
    }
}
