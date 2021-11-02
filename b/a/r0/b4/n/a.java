package b.a.r0.b4.n;

import android.content.Intent;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.s.a;
import b.a.q0.t.c.m0;
import b.a.q0.x.e;
import b.a.r0.b4.i;
import b.a.r0.l3.s0.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public NewWriteModel f15063f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.d4.c f15064g;

    /* renamed from: h  reason: collision with root package name */
    public String f15065h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<?> f15066i;
    public String j;
    public String k;
    public String l;
    public VideoItemData m;
    public d n;
    public final NewWriteModel.g o;
    public TextWatcher p;

    /* renamed from: b.a.r0.b4.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0758a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f15067a;

        public C0758a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15067a = aVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m0 m0Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) || this.f15067a.f15063f == null) {
                return;
            }
            if (this.f15067a.a() != null) {
                this.f15067a.a().hide();
            }
            if (this.f15067a.n != null) {
                this.f15067a.n.a(false);
            }
            if (writeData == null) {
                writeData = this.f15067a.f15063f.X();
            }
            WriteData writeData2 = writeData;
            if (z) {
                String str2 = null;
                this.f15067a.f15064g.n(null);
                this.f15067a.f15064g.i(null);
                this.f15067a.f15064g.k(false);
                this.f15067a.q();
                this.f15067a.p();
                if (writeData2 != null) {
                    String string = this.f15067a.getContext().getResources().getString(i.replay_success);
                    if (postWriteCallBackData != null) {
                        str2 = postWriteCallBackData.getPreMsg();
                        String colorMsg = postWriteCallBackData.getColorMsg();
                        String errorString = postWriteCallBackData.getErrorString();
                        str = colorMsg;
                        string = errorString;
                    } else {
                        str = null;
                    }
                    if (writeData2.getType() != 7) {
                        m.b(this.f15067a.getContext().getPageActivity(), string, str2, str);
                    }
                }
            } else if (writeData2 != null && m0Var != null && !TextUtils.isEmpty(m0Var.d())) {
                writeData2.setVcodeMD5(m0Var.b());
                writeData2.setVcodeUrl(m0Var.c());
                writeData2.setVcodeExtra(m0Var.a());
                if (b.a.q0.e1.a.b(m0Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.f15067a.f15066i.getPageActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData2, false, m0Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.f15067a.f15066i.getPageActivity(), writeData2, CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.f15067a.f15066i.getPageActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData2, postWriteCallBackData.getAccessState())));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                this.f15067a.z(postWriteCallBackData.getErrorString());
                this.f15067a.f15064g.i(postWriteCallBackData.getSensitiveWords());
                this.f15067a.f15064g.n(postWriteCallBackData.getErrorString());
                if (ListUtils.isEmpty(this.f15067a.f15064g.a())) {
                    return;
                }
                this.f15067a.k(true);
            } else if (postWriteCallBackData == null || !b.a.r0.v3.a.c(postWriteCallBackData.getErrorCode())) {
                if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.l(postWriteCallBackData.getErrorCode()))) {
                    this.f15067a.w(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                } else if (postWriteCallBackData != null) {
                    this.f15067a.z(postWriteCallBackData.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
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

    /* loaded from: classes4.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15068e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15068e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.f15068e.f15064g == null) {
                return;
            }
            if (!this.f15068e.f15064g.e()) {
                this.f15068e.k(false);
            }
            this.f15068e.f15064g.l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(EditorTools editorTools) {
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
        this.f15065h = "";
        this.j = null;
        this.o = new C0758a(this);
        this.p = new c(this);
        editorTools.showLinePositionBottom(true);
        b.a.r0.d4.c cVar = new b.a.r0.d4.c();
        this.f15064g = cVar;
        cVar.h(b.a.r0.b4.c.cp_cont_h_alpha85);
        this.f15064g.j(b.a.r0.b4.c.CAM_X0101);
    }

    public TbPageContext<?> getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15066i : (TbPageContext) invokeV.objValue;
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || a() == null || !(a().findToolById(28) instanceof b.a.r0.b4.n.c) || ((b.a.r0.b4.n.c) a().findToolById(28)).f() == null || ((b.a.r0.b4.n.c) a().findToolById(28)).f().getText() == null) {
            return;
        }
        EditText f2 = ((b.a.r0.b4.n.c) a().findToolById(28)).f();
        int selectionEnd = f2.getSelectionEnd();
        SpannableStringBuilder f3 = this.f15064g.f(f2.getText());
        if (f3 != null) {
            this.f15064g.l(true);
            f2.setText(f3);
            if (z && this.f15064g.b() >= 0) {
                f2.requestFocus();
                f2.setSelection(this.f15064g.b());
            } else {
                f2.setSelection(selectionEnd);
            }
            b.a.r0.d4.c cVar = this.f15064g;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || a() == null || !(a().findToolById(28) instanceof b.a.r0.b4.n.c) || ((b.a.r0.b4.n.c) a().findToolById(28)).f() == null || ((b.a.r0.b4.n.c) a().findToolById(28)).f().getText() == null) {
            return;
        }
        ((b.a.r0.b4.n.c) a().findToolById(28)).f().setText("");
    }

    public void m(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) && i2 == 12006) {
            if (i3 != 0) {
                if (i3 == -1) {
                    q();
                    return;
                }
                return;
            }
            PostWriteCallBackData postWriteCallBackData = null;
            if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
            }
            this.o.callback(false, postWriteCallBackData, null, this.f15063f.X(), null);
        }
    }

    public void n() {
        NewWriteModel newWriteModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (newWriteModel = this.f15063f) == null) {
            return;
        }
        newWriteModel.cancelLoadData();
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f15063f == null) {
                NewWriteModel newWriteModel = new NewWriteModel(this.f15066i);
                this.f15063f = newWriteModel;
                newWriteModel.h0(this.o);
            }
            WriteData writeData = new WriteData();
            writeData.setType(1);
            writeData.setThreadId(this.j);
            writeData.setForumId(this.k);
            writeData.setForumName(this.l);
            writeData.setContent(this.f15065h);
            VideoItemData videoItemData = this.m;
            if (videoItemData != null && videoItemData.baijiahaoData != null) {
                writeData.setIsBJHPost(true);
                writeData.setBaijiahaoData(this.m.baijiahaoData);
            }
            this.f15063f.setWriteData(writeData);
            this.f15063f.l0();
        }
    }

    public final void p() {
        NewWriteModel newWriteModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (newWriteModel = this.f15063f) == null) {
            return;
        }
        newWriteModel.setWriteData(null);
        this.f15063f.d0(false);
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (a() != null) {
                a().sendAction(new b.a.q0.x.a(9, -1, Boolean.TRUE));
                a().sendAction(new b.a.q0.x.a(4, -1, ""));
                a().hide();
            }
            d dVar = this.n;
            if (dVar != null) {
                dVar.a(true);
            }
        }
    }

    public void r(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext) == null) {
            this.f15066i = tbPageContext;
        }
    }

    public void s(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, str, str2, str3) == null) {
            this.j = str;
            this.k = str2;
            this.l = str3;
            if (a() == null || !(a().findToolById(28) instanceof b.a.r0.b4.n.c) || ((b.a.r0.b4.n.c) a().findToolById(28)).f() == null) {
                return;
            }
            EditText f2 = ((b.a.r0.b4.n.c) a().findToolById(28)).f();
            f2.removeTextChangedListener(this.p);
            f2.addTextChangedListener(this.p);
        }
    }

    public void t(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            this.n = dVar;
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f15065h = str;
        }
    }

    public void v(VideoItemData videoItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, videoItemData) == null) {
            this.m = videoItemData;
        }
    }

    public final void w(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i2, str) == null) {
            if (AntiHelper.m(i2, str)) {
                AntiHelper.w(this.f15066i.getPageActivity(), str, i2, null);
            } else if (i2 != 230277 && i2 != 230278) {
                z(str);
            } else {
                x(str);
            }
        }
    }

    public final void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(getContext().getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(i.know, new b(this));
            aVar.create(getContext()).show();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13026");
            statisticItem.param("tid", this.j);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.k);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, str) == null) || this.f15066i == null || StringUtils.isNull(str)) {
            return;
        }
        this.f15066i.showToast(str);
    }
}
