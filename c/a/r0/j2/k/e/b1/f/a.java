package c.a.r0.j2.k.e.b1.f;

import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.q;
import c.a.q0.t.c.k0;
import c.a.q0.x.w.c;
import c.a.r0.j2.h.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.tnc.TNCManager;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f19919a;

    /* renamed from: b  reason: collision with root package name */
    public NewWriteModel f19920b;

    /* renamed from: c  reason: collision with root package name */
    public LocationModel f19921c;

    /* renamed from: d  reason: collision with root package name */
    public c f19922d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel.g f19923e;

    /* renamed from: f  reason: collision with root package name */
    public GetEmotionPidModel f19924f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionImageData f19925g;

    /* renamed from: h  reason: collision with root package name */
    public PbModel f19926h;

    /* renamed from: i  reason: collision with root package name */
    public e f19927i;

    /* renamed from: j  reason: collision with root package name */
    public final NewWriteModel.g f19928j;

    /* renamed from: c.a.r0.j2.k.e.b1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0951a implements GetEmotionPidModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionImageData f19929a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbModel f19930b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f19931c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f19932d;

        public C0951a(a aVar, EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, emotionImageData, pbModel, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19932d = aVar;
            this.f19929a = emotionImageData;
            this.f19930b = pbModel;
            this.f19931c = eVar;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(c.a.q0.d0.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || TextUtils.isEmpty(cVar.f12856a)) {
                return;
            }
            this.f19929a.setPicId(cVar.f12856a);
            this.f19932d.l(this.f19929a, this.f19930b, this.f19931c);
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f19932d.f19923e == null) {
                return;
            }
            this.f19932d.f19923e.callback(false, null, null, null, null);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f19933a;

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
                    return;
                }
            }
            this.f19933a = aVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, k0 k0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) {
                if (writeData == null) {
                    writeData = this.f19933a.f19920b.X();
                }
                if (z) {
                    this.f19933a.j();
                } else if (writeData != null && k0Var != null && !TextUtils.isEmpty(k0Var.d())) {
                    writeData.setVcodeMD5(k0Var.b());
                    writeData.setVcodeUrl(k0Var.c());
                    writeData.setVcodeExtra(k0Var.a());
                    if (c.a.q0.e1.a.b(k0Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.f19933a.f19919a.getPageContext().getPageActivity(), 25017, writeData, false, k0Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.f19933a.f19919a.getPageContext().getPageActivity(), writeData, 25017)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.f19933a.f19919a.getPageContext().getPageActivity(), 25017, writeData, postWriteCallBackData.getAccessState())));
                }
                if (this.f19933a.f19923e != null) {
                    this.f19933a.f19923e.callback(z, postWriteCallBackData, k0Var, writeData, antiData);
                }
            }
        }
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19928j = new b(this);
        this.f19919a = baseFragmentActivity;
        this.f19920b = new NewWriteModel(baseFragmentActivity);
        this.f19921c = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GetEmotionPidModel getEmotionPidModel = this.f19924f;
            if (getEmotionPidModel != null) {
                getEmotionPidModel.cancelLoadData();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean g(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return TNCManager.TNC_PROBE_HEADER_SECEPTOR + str + " ";
        }
        return (String) invokeL.objValue;
    }

    public void i(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) && i3 == -1) {
            if (i2 != 25017) {
                if (i2 == 11042) {
                    k(this.f19925g, this.f19926h, this.f19927i);
                }
            } else if (intent == null) {
            } else {
                NewWriteModel newWriteModel = this.f19920b;
                WriteData X = newWriteModel != null ? newWriteModel.X() : null;
                j();
                NewWriteModel.g gVar = this.f19923e;
                if (gVar != null) {
                    gVar.callback(true, null, null, X, null);
                }
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f19925g = null;
            this.f19927i = null;
            this.f19926h = null;
            NewWriteModel newWriteModel = this.f19920b;
            if (newWriteModel != null) {
                newWriteModel.setWriteData(null);
            }
        }
    }

    public void k(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, emotionImageData, pbModel, eVar) == null) || emotionImageData == null || eVar == null) {
            return;
        }
        this.f19925g = emotionImageData;
        this.f19926h = pbModel;
        this.f19927i = eVar;
        if (!j.z()) {
            this.f19919a.showToast(R.string.neterror);
        } else if (g(this.f19919a.getPageContext(), 11042)) {
            if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                if (TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                    return;
                }
                if (this.f19924f == null) {
                    this.f19924f = new GetEmotionPidModel();
                }
                c cVar = this.f19922d;
                if (cVar != null) {
                    cVar.a();
                }
                this.f19924f.x(emotionImageData.getPicUrl(), new C0951a(this, emotionImageData, pbModel, eVar));
                return;
            }
            c cVar2 = this.f19922d;
            if (cVar2 != null) {
                cVar2.a();
            }
            l(emotionImageData, pbModel, eVar);
        }
    }

    public final void l(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, emotionImageData, pbModel, eVar) == null) || emotionImageData == null || eVar == null) {
            return;
        }
        if (this.f19920b.X() == null && pbModel != null) {
            this.f19920b.setWriteData(pbModel.D(null));
        }
        if (this.f19920b.X() == null) {
            return;
        }
        boolean z = true;
        if (eVar.O().l2()) {
            this.f19920b.X().setCanNoForum(true);
            if (eVar.m() != null) {
                this.f19920b.X().setVForumId(eVar.m().getId());
                this.f19920b.X().setVForumName(eVar.m().getName());
            }
        } else {
            this.f19920b.X().setCanNoForum(false);
            this.f19920b.X().setVForumId("");
            this.f19920b.X().setVForumName("");
        }
        WriteData X = this.f19920b.X();
        LocationModel locationModel = this.f19921c;
        X.setHasLocationData((locationModel == null || !locationModel.z()) ? false : false);
        StringBuilder sb = new StringBuilder(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX_SHORT);
        sb.append(emotionImageData.getPicId());
        sb.append(",");
        sb.append(emotionImageData.getWidth());
        sb.append(",");
        sb.append(emotionImageData.getHeight());
        sb.append(",");
        String str = SmallTailInfo.EMOTION_PREFIX + sb.toString() + q.c(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + SmallTailInfo.EMOTION_SUFFIX;
        if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
            this.f19920b.X().setContent(str);
        } else {
            this.f19920b.X().setContent(h(emotionImageData.getAuthorNameShow()) + str);
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
            this.f19920b.X().setMemeContSign(emotionImageData.getMemeContSign());
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
            this.f19920b.X().setMemeText(emotionImageData.getMemeText());
        }
        this.f19920b.h0(this.f19928j);
        if (!this.f19920b.l0()) {
        }
    }

    public void m(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
            this.f19923e = gVar;
        }
    }

    public void n(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f19922d = cVar;
        }
    }
}
