package c.a.p0.p4.f;

import android.content.Intent;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.t.a;
import c.a.o0.s.c.l0;
import c.a.o0.w.e;
import c.a.p0.a4.t0.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public NewWriteModel f17055b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.s4.c f17056c;

    /* renamed from: d  reason: collision with root package name */
    public String f17057d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f17058e;

    /* renamed from: f  reason: collision with root package name */
    public String f17059f;

    /* renamed from: g  reason: collision with root package name */
    public String f17060g;

    /* renamed from: h  reason: collision with root package name */
    public String f17061h;
    public VideoItemData i;
    public d j;
    public final NewWriteModel.g k;
    public TextWatcher l;

    /* renamed from: c.a.p0.p4.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1279a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1279a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, l0 l0Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l0Var, writeData, antiData}) == null) || this.a.f17055b == null) {
                return;
            }
            if (this.a.a() != null) {
                this.a.a().o();
            }
            if (this.a.j != null) {
                this.a.j.a(false);
            }
            if (writeData == null) {
                writeData = this.a.f17055b.b0();
            }
            WriteData writeData2 = writeData;
            if (z) {
                String str2 = null;
                this.a.f17056c.n(null);
                this.a.f17056c.i(null);
                this.a.f17056c.k(false);
                this.a.q();
                this.a.p();
                if (writeData2 != null) {
                    String string = this.a.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0f86);
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
                        h.b(this.a.getContext().getPageActivity(), string, str2, str);
                    }
                }
            } else if (writeData2 != null && l0Var != null && !TextUtils.isEmpty(l0Var.d())) {
                writeData2.setVcodeMD5(l0Var.b());
                writeData2.setVcodeUrl(l0Var.c());
                writeData2.setVcodeExtra(l0Var.a());
                if (c.a.o0.d1.a.b(l0Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.f17058e.getPageActivity(), 12006, writeData2, false, l0Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.f17058e.getPageActivity(), writeData2, 12006)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.f17058e.getPageActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                this.a.z(postWriteCallBackData.getErrorString());
                this.a.f17056c.i(postWriteCallBackData.getSensitiveWords());
                this.a.f17056c.n(postWriteCallBackData.getErrorString());
                if (ListUtils.isEmpty(this.a.f17056c.a())) {
                    return;
                }
                this.a.k(true);
            } else if (postWriteCallBackData == null || !c.a.p0.j4.a.c(postWriteCallBackData.getErrorCode())) {
                if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.l(postWriteCallBackData.getErrorCode()))) {
                    this.a.w(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                } else if (postWriteCallBackData != null) {
                    this.a.z(postWriteCallBackData.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.a.f17056c == null) {
                return;
            }
            if (!this.a.f17056c.e()) {
                this.a.k(false);
            }
            this.a.f17056c.l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((EditorTools) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17057d = "";
        this.f17059f = null;
        this.k = new C1279a(this);
        this.l = new c(this);
        editorTools.C(true);
        c.a.p0.s4.c cVar = new c.a.p0.s4.c();
        this.f17056c = cVar;
        cVar.h(R.color.cp_cont_h_alpha85);
        this.f17056c.j(R.color.CAM_X0101);
    }

    public TbPageContext<?> getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17058e : (TbPageContext) invokeV.objValue;
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || a() == null || !(a().n(28) instanceof c.a.p0.p4.f.c) || ((c.a.p0.p4.f.c) a().n(28)).f() == null || ((c.a.p0.p4.f.c) a().n(28)).f().getText() == null) {
            return;
        }
        EditText f2 = ((c.a.p0.p4.f.c) a().n(28)).f();
        int selectionEnd = f2.getSelectionEnd();
        SpannableStringBuilder f3 = this.f17056c.f(f2.getText());
        if (f3 != null) {
            this.f17056c.l(true);
            f2.setText(f3);
            if (z && this.f17056c.b() >= 0) {
                f2.requestFocus();
                f2.setSelection(this.f17056c.b());
            } else {
                f2.setSelection(selectionEnd);
            }
            c.a.p0.s4.c cVar = this.f17056c;
            cVar.k(cVar.b() >= 0);
        }
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17057d : (String) invokeV.objValue;
    }

    public void m(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) && i == 12006) {
            if (i2 != 0) {
                if (i2 == -1) {
                    q();
                    return;
                }
                return;
            }
            PostWriteCallBackData postWriteCallBackData = null;
            if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
            }
            this.k.callback(false, postWriteCallBackData, null, this.f17055b.b0(), null);
        }
    }

    public void n() {
        NewWriteModel newWriteModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (newWriteModel = this.f17055b) == null) {
            return;
        }
        newWriteModel.cancelLoadData();
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f17055b == null) {
                NewWriteModel newWriteModel = new NewWriteModel(this.f17058e);
                this.f17055b = newWriteModel;
                newWriteModel.n0(this.k);
            }
            WriteData writeData = new WriteData();
            writeData.setType(1);
            writeData.setThreadId(this.f17059f);
            writeData.setForumId(this.f17060g);
            writeData.setForumName(this.f17061h);
            writeData.setContent(this.f17057d);
            VideoItemData videoItemData = this.i;
            if (videoItemData != null && videoItemData.baijiahaoData != null) {
                writeData.setIsBJHPost(true);
                writeData.setBaijiahaoData(this.i.baijiahaoData);
            }
            this.f17055b.setWriteData(writeData);
            this.f17055b.r0();
        }
    }

    public final void p() {
        NewWriteModel newWriteModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (newWriteModel = this.f17055b) == null) {
            return;
        }
        newWriteModel.setWriteData(null);
        this.f17055b.i0(false);
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (a() != null) {
                a().A(new c.a.o0.w.a(9, -1, Boolean.TRUE));
                a().A(new c.a.o0.w.a(4, -1, ""));
                a().o();
            }
            d dVar = this.j;
            if (dVar != null) {
                dVar.a(true);
            }
        }
    }

    public void r(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext) == null) {
            this.f17058e = tbPageContext;
        }
    }

    public void s(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, str, str2, str3, str4) == null) {
            this.f17059f = str;
            this.f17060g = str2;
            this.f17061h = str3;
            if (a() == null || !(a().n(28) instanceof c.a.p0.p4.f.c) || ((c.a.p0.p4.f.c) a().n(28)).f() == null) {
                return;
            }
            EditText f2 = ((c.a.p0.p4.f.c) a().n(28)).f();
            f2.removeTextChangedListener(this.l);
            f2.addTextChangedListener(this.l);
            f2.setText(str4);
        }
    }

    public void t(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            this.j = dVar;
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f17057d = str;
        }
    }

    public void v(VideoItemData videoItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, videoItemData) == null) {
            this.i = videoItemData;
        }
    }

    public final void w(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i, str) == null) {
            if (AntiHelper.m(i, str)) {
                AntiHelper.w(this.f17058e.getPageActivity(), str, i, null);
            } else if (i != 230277 && i != 230278) {
                z(str);
            } else {
                x(str);
            }
        }
    }

    public final void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(getContext().getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f0984, new b(this));
            aVar.create(getContext()).show();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13026");
            statisticItem.param("tid", this.f17059f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.f17060g);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, str) == null) || this.f17058e == null || StringUtils.isNull(str)) {
            return;
        }
        this.f17058e.showToast(str);
    }
}
