package c.a.s0.l4.o;

import android.content.Intent;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.s.t.a;
import c.a.r0.t.c.m0;
import c.a.r0.x.e;
import c.a.s0.l4.i;
import c.a.s0.n4.m;
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
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public NewWriteModel f19220f;

    /* renamed from: g  reason: collision with root package name */
    public m f19221g;

    /* renamed from: h  reason: collision with root package name */
    public String f19222h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<?> f19223i;

    /* renamed from: j  reason: collision with root package name */
    public String f19224j;

    /* renamed from: k  reason: collision with root package name */
    public String f19225k;
    public String l;
    public VideoItemData m;
    public d n;
    public final NewWriteModel.g o;
    public TextWatcher p;

    /* renamed from: c.a.s0.l4.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1160a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1160a(a aVar) {
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
            this.a = aVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m0 m0Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) || this.a.f19220f == null) {
                return;
            }
            if (this.a.a() != null) {
                this.a.a().hide();
            }
            if (this.a.n != null) {
                this.a.n.a(false);
            }
            if (writeData == null) {
                writeData = this.a.f19220f.Y();
            }
            WriteData writeData2 = writeData;
            if (z) {
                String str2 = null;
                this.a.f19221g.n(null);
                this.a.f19221g.i(null);
                this.a.f19221g.k(false);
                this.a.q();
                this.a.p();
                if (writeData2 != null) {
                    String string = this.a.getContext().getResources().getString(i.replay_success);
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
                        c.a.s0.v3.s0.m.b(this.a.getContext().getPageActivity(), string, str2, str);
                    }
                }
            } else if (writeData2 != null && m0Var != null && !TextUtils.isEmpty(m0Var.d())) {
                writeData2.setVcodeMD5(m0Var.b());
                writeData2.setVcodeUrl(m0Var.c());
                writeData2.setVcodeExtra(m0Var.a());
                if (c.a.r0.e1.a.b(m0Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.f19223i.getPageActivity(), 12006, writeData2, false, m0Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.f19223i.getPageActivity(), writeData2, 12006)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.f19223i.getPageActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                this.a.z(postWriteCallBackData.getErrorString());
                this.a.f19221g.i(postWriteCallBackData.getSensitiveWords());
                this.a.f19221g.n(postWriteCallBackData.getErrorString());
                if (ListUtils.isEmpty(this.a.f19221g.a())) {
                    return;
                }
                this.a.k(true);
            } else if (postWriteCallBackData == null || !c.a.s0.f4.a.c(postWriteCallBackData.getErrorCode())) {
                if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.l(postWriteCallBackData.getErrorCode()))) {
                    this.a.w(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                } else if (postWriteCallBackData != null) {
                    this.a.z(postWriteCallBackData.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19226e;

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
            this.f19226e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.f19226e.f19221g == null) {
                return;
            }
            if (!this.f19226e.f19221g.e()) {
                this.f19226e.k(false);
            }
            this.f19226e.f19221g.l(false);
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

    /* loaded from: classes7.dex */
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
        this.f19222h = "";
        this.f19224j = null;
        this.o = new C1160a(this);
        this.p = new c(this);
        editorTools.showLinePositionBottom(true);
        m mVar = new m();
        this.f19221g = mVar;
        mVar.h(c.a.s0.l4.c.cp_cont_h_alpha85);
        this.f19221g.j(c.a.s0.l4.c.CAM_X0101);
    }

    public TbPageContext<?> getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19223i : (TbPageContext) invokeV.objValue;
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || a() == null || !(a().findToolById(28) instanceof c.a.s0.l4.o.c) || ((c.a.s0.l4.o.c) a().findToolById(28)).f() == null || ((c.a.s0.l4.o.c) a().findToolById(28)).f().getText() == null) {
            return;
        }
        EditText f2 = ((c.a.s0.l4.o.c) a().findToolById(28)).f();
        int selectionEnd = f2.getSelectionEnd();
        SpannableStringBuilder f3 = this.f19221g.f(f2.getText());
        if (f3 != null) {
            this.f19221g.l(true);
            f2.setText(f3);
            if (z && this.f19221g.b() >= 0) {
                f2.requestFocus();
                f2.setSelection(this.f19221g.b());
            } else {
                f2.setSelection(selectionEnd);
            }
            m mVar = this.f19221g;
            mVar.k(mVar.b() >= 0);
        }
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19222h : (String) invokeV.objValue;
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
            this.o.callback(false, postWriteCallBackData, null, this.f19220f.Y(), null);
        }
    }

    public void n() {
        NewWriteModel newWriteModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (newWriteModel = this.f19220f) == null) {
            return;
        }
        newWriteModel.cancelLoadData();
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f19220f == null) {
                NewWriteModel newWriteModel = new NewWriteModel(this.f19223i);
                this.f19220f = newWriteModel;
                newWriteModel.j0(this.o);
            }
            WriteData writeData = new WriteData();
            writeData.setType(1);
            writeData.setThreadId(this.f19224j);
            writeData.setForumId(this.f19225k);
            writeData.setForumName(this.l);
            writeData.setContent(this.f19222h);
            VideoItemData videoItemData = this.m;
            if (videoItemData != null && videoItemData.baijiahaoData != null) {
                writeData.setIsBJHPost(true);
                writeData.setBaijiahaoData(this.m.baijiahaoData);
            }
            this.f19220f.setWriteData(writeData);
            this.f19220f.n0();
        }
    }

    public final void p() {
        NewWriteModel newWriteModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (newWriteModel = this.f19220f) == null) {
            return;
        }
        newWriteModel.setWriteData(null);
        this.f19220f.e0(false);
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (a() != null) {
                a().sendAction(new c.a.r0.x.a(9, -1, Boolean.TRUE));
                a().sendAction(new c.a.r0.x.a(4, -1, ""));
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
            this.f19223i = tbPageContext;
        }
    }

    public void s(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, str, str2, str3, str4) == null) {
            this.f19224j = str;
            this.f19225k = str2;
            this.l = str3;
            if (a() == null || !(a().findToolById(28) instanceof c.a.s0.l4.o.c) || ((c.a.s0.l4.o.c) a().findToolById(28)).f() == null) {
                return;
            }
            EditText f2 = ((c.a.s0.l4.o.c) a().findToolById(28)).f();
            f2.removeTextChangedListener(this.p);
            f2.addTextChangedListener(this.p);
            f2.setText(str4);
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
            this.f19222h = str;
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
                AntiHelper.w(this.f19223i.getPageActivity(), str, i2, null);
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
            c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(getContext().getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(i.know, new b(this));
            aVar.create(getContext()).show();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13026");
            statisticItem.param("tid", this.f19224j);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.f19225k);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, str) == null) || this.f19223i == null || StringUtils.isNull(str)) {
            return;
        }
        this.f19223i.showToast(str);
    }
}
