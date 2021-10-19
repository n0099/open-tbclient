package c.a.r0.a4.e;

import android.content.Intent;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.s.a;
import c.a.q0.t.c.l0;
import c.a.q0.x.e;
import c.a.r0.k3.r0.m;
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
/* loaded from: classes3.dex */
public class a extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public NewWriteModel f15686f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.d4.c f15687g;

    /* renamed from: h  reason: collision with root package name */
    public String f15688h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<?> f15689i;

    /* renamed from: j  reason: collision with root package name */
    public String f15690j;
    public String k;
    public String l;
    public VideoItemData m;
    public d n;
    public final NewWriteModel.g o;
    public TextWatcher p;

    /* renamed from: c.a.r0.a4.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0752a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f15691a;

        public C0752a(a aVar) {
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
            this.f15691a = aVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, l0 l0Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l0Var, writeData, antiData}) == null) || this.f15691a.f15686f == null) {
                return;
            }
            if (this.f15691a.a() != null) {
                this.f15691a.a().hide();
            }
            if (this.f15691a.n != null) {
                this.f15691a.n.a(false);
            }
            if (writeData == null) {
                writeData = this.f15691a.f15686f.X();
            }
            WriteData writeData2 = writeData;
            if (z) {
                String str2 = null;
                this.f15691a.f15687g.n(null);
                this.f15691a.f15687g.i(null);
                this.f15691a.f15687g.k(false);
                this.f15691a.r();
                this.f15691a.q();
                if (writeData2 != null) {
                    String string = this.f15691a.m().getResources().getString(R.string.replay_success);
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
                        m.b(this.f15691a.m().getPageActivity(), string, str2, str);
                    }
                }
            } else if (writeData2 != null && l0Var != null && !TextUtils.isEmpty(l0Var.d())) {
                writeData2.setVcodeMD5(l0Var.b());
                writeData2.setVcodeUrl(l0Var.c());
                writeData2.setVcodeExtra(l0Var.a());
                if (c.a.q0.e1.a.b(l0Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.f15691a.f15689i.getPageActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData2, false, l0Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.f15691a.f15689i.getPageActivity(), writeData2, CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.f15691a.f15689i.getPageActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData2, postWriteCallBackData.getAccessState())));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                this.f15691a.A(postWriteCallBackData.getErrorString());
                this.f15691a.f15687g.i(postWriteCallBackData.getSensitiveWords());
                this.f15691a.f15687g.n(postWriteCallBackData.getErrorString());
                if (ListUtils.isEmpty(this.f15691a.f15687g.a())) {
                    return;
                }
                this.f15691a.k(true);
            } else if (postWriteCallBackData == null || !c.a.r0.u3.a.c(postWriteCallBackData.getErrorCode())) {
                if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.l(postWriteCallBackData.getErrorCode()))) {
                    this.f15691a.x(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                } else if (postWriteCallBackData != null) {
                    this.f15691a.A(postWriteCallBackData.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15692e;

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
            this.f15692e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.f15692e.f15687g == null) {
                return;
            }
            if (!this.f15692e.f15687g.e()) {
                this.f15692e.k(false);
            }
            this.f15692e.f15687g.l(false);
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

    /* loaded from: classes3.dex */
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
        this.f15688h = "";
        this.f15690j = null;
        this.o = new C0752a(this);
        this.p = new c(this);
        editorTools.showLinePositionBottom(true);
        c.a.r0.d4.c cVar = new c.a.r0.d4.c();
        this.f15687g = cVar;
        cVar.h(R.color.cp_cont_h_alpha85);
        this.f15687g.j(R.color.CAM_X0101);
    }

    public final void A(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f15689i == null || StringUtils.isNull(str)) {
            return;
        }
        this.f15689i.showToast(str);
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || a() == null || !(a().findToolById(28) instanceof c.a.r0.a4.e.c) || ((c.a.r0.a4.e.c) a().findToolById(28)).g() == null || ((c.a.r0.a4.e.c) a().findToolById(28)).g().getText() == null) {
            return;
        }
        EditText g2 = ((c.a.r0.a4.e.c) a().findToolById(28)).g();
        int selectionEnd = g2.getSelectionEnd();
        SpannableStringBuilder f2 = this.f15687g.f(g2.getText());
        if (f2 != null) {
            this.f15687g.l(true);
            g2.setText(f2);
            if (z && this.f15687g.b() >= 0) {
                g2.requestFocus();
                g2.setSelection(this.f15687g.b());
            } else {
                g2.setSelection(selectionEnd);
            }
            c.a.r0.d4.c cVar = this.f15687g;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || a() == null || !(a().findToolById(28) instanceof c.a.r0.a4.e.c) || ((c.a.r0.a4.e.c) a().findToolById(28)).g() == null || ((c.a.r0.a4.e.c) a().findToolById(28)).g().getText() == null) {
            return;
        }
        ((c.a.r0.a4.e.c) a().findToolById(28)).g().setText("");
    }

    public TbPageContext<?> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15689i : (TbPageContext) invokeV.objValue;
    }

    public void n(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, intent) == null) && i2 == 12006) {
            if (i3 != 0) {
                if (i3 == -1) {
                    r();
                    return;
                }
                return;
            }
            PostWriteCallBackData postWriteCallBackData = null;
            if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
            }
            this.o.callback(false, postWriteCallBackData, null, this.f15686f.X(), null);
        }
    }

    public void o() {
        NewWriteModel newWriteModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (newWriteModel = this.f15686f) == null) {
            return;
        }
        newWriteModel.cancelLoadData();
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f15686f == null) {
                NewWriteModel newWriteModel = new NewWriteModel(this.f15689i);
                this.f15686f = newWriteModel;
                newWriteModel.h0(this.o);
            }
            WriteData writeData = new WriteData();
            writeData.setType(1);
            writeData.setThreadId(this.f15690j);
            writeData.setForumId(this.k);
            writeData.setForumName(this.l);
            writeData.setContent(this.f15688h);
            VideoItemData videoItemData = this.m;
            if (videoItemData != null && videoItemData.baijiahaoData != null) {
                writeData.setIsBJHPost(true);
                writeData.setBaijiahaoData(this.m.baijiahaoData);
            }
            this.f15686f.setWriteData(writeData);
            this.f15686f.l0();
        }
    }

    public final void q() {
        NewWriteModel newWriteModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (newWriteModel = this.f15686f) == null) {
            return;
        }
        newWriteModel.setWriteData(null);
        this.f15686f.d0(false);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (a() != null) {
                a().sendAction(new c.a.q0.x.a(9, -1, Boolean.TRUE));
                a().sendAction(new c.a.q0.x.a(4, -1, ""));
                a().hide();
            }
            d dVar = this.n;
            if (dVar != null) {
                dVar.a(true);
            }
        }
    }

    public void s(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tbPageContext) == null) {
            this.f15689i = tbPageContext;
        }
    }

    public void t(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, str, str2, str3) == null) {
            this.f15690j = str;
            this.k = str2;
            this.l = str3;
            if (a() == null || !(a().findToolById(28) instanceof c.a.r0.a4.e.c) || ((c.a.r0.a4.e.c) a().findToolById(28)).g() == null) {
                return;
            }
            EditText g2 = ((c.a.r0.a4.e.c) a().findToolById(28)).g();
            g2.removeTextChangedListener(this.p);
            g2.addTextChangedListener(this.p);
        }
    }

    public void u(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.n = dVar;
        }
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f15688h = str;
        }
    }

    public void w(VideoItemData videoItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, videoItemData) == null) {
            this.m = videoItemData;
        }
    }

    public final void x(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i2, str) == null) {
            if (AntiHelper.m(i2, str)) {
                AntiHelper.w(this.f15689i.getPageActivity(), str, i2, null);
            } else if (i2 != 230277 && i2 != 230278) {
                A(str);
            } else {
                y(str);
            }
        }
    }

    public final void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(m().getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new b(this));
            aVar.create(m()).show();
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13026");
            statisticItem.param("tid", this.f15690j);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.k);
            TiebaStatic.log(statisticItem);
        }
    }
}
