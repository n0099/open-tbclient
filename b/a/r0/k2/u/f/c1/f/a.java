package b.a.r0.k2.u.f.c1.f;

import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.j;
import b.a.e.f.p.q;
import b.a.q0.t.c.m0;
import b.a.q0.x.x.c;
import b.a.r0.k2.l;
import b.a.r0.k2.r.f;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f20671a;

    /* renamed from: b  reason: collision with root package name */
    public NewWriteModel f20672b;

    /* renamed from: c  reason: collision with root package name */
    public LocationModel f20673c;

    /* renamed from: d  reason: collision with root package name */
    public c f20674d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel.g f20675e;

    /* renamed from: f  reason: collision with root package name */
    public GetEmotionPidModel f20676f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionImageData f20677g;

    /* renamed from: h  reason: collision with root package name */
    public PbModel f20678h;

    /* renamed from: i  reason: collision with root package name */
    public f f20679i;
    public final NewWriteModel.g j;

    /* renamed from: b.a.r0.k2.u.f.c1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1031a implements GetEmotionPidModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionImageData f20680a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbModel f20681b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f20682c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f20683d;

        public C1031a(a aVar, EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, emotionImageData, pbModel, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20683d = aVar;
            this.f20680a = emotionImageData;
            this.f20681b = pbModel;
            this.f20682c = fVar;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(b.a.q0.d0.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || TextUtils.isEmpty(cVar.f12904a)) {
                return;
            }
            this.f20680a.setPicId(cVar.f12904a);
            this.f20683d.l(this.f20680a, this.f20681b, this.f20682c);
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f20683d.f20675e == null) {
                return;
            }
            this.f20683d.f20675e.callback(false, null, null, null, null);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f20684a;

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
            this.f20684a = aVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m0 m0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) {
                if (writeData == null) {
                    writeData = this.f20684a.f20672b.X();
                }
                if (z) {
                    this.f20684a.j();
                } else if (writeData != null && m0Var != null && !TextUtils.isEmpty(m0Var.d())) {
                    writeData.setVcodeMD5(m0Var.b());
                    writeData.setVcodeUrl(m0Var.c());
                    writeData.setVcodeExtra(m0Var.a());
                    if (b.a.q0.d1.a.b(m0Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.f20684a.f20671a.getPageContext().getPageActivity(), 25017, writeData, false, m0Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.f20684a.f20671a.getPageContext().getPageActivity(), writeData, 25017)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.f20684a.f20671a.getPageContext().getPageActivity(), 25017, writeData, postWriteCallBackData.getAccessState())));
                }
                if (this.f20684a.f20675e != null) {
                    this.f20684a.f20675e.callback(z, postWriteCallBackData, m0Var, writeData, antiData);
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
        this.j = new b(this);
        this.f20671a = baseFragmentActivity;
        this.f20672b = new NewWriteModel(baseFragmentActivity);
        this.f20673c = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GetEmotionPidModel getEmotionPidModel = this.f20676f;
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
            return "@" + str + " ";
        }
        return (String) invokeL.objValue;
    }

    public void i(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) && i3 == -1) {
            if (i2 != 25017) {
                if (i2 == 11042) {
                    k(this.f20677g, this.f20678h, this.f20679i);
                }
            } else if (intent == null) {
            } else {
                NewWriteModel newWriteModel = this.f20672b;
                WriteData X = newWriteModel != null ? newWriteModel.X() : null;
                j();
                NewWriteModel.g gVar = this.f20675e;
                if (gVar != null) {
                    gVar.callback(true, null, null, X, null);
                }
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f20677g = null;
            this.f20679i = null;
            this.f20678h = null;
            NewWriteModel newWriteModel = this.f20672b;
            if (newWriteModel != null) {
                newWriteModel.setWriteData(null);
            }
        }
    }

    public void k(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, emotionImageData, pbModel, fVar) == null) || emotionImageData == null || fVar == null) {
            return;
        }
        this.f20677g = emotionImageData;
        this.f20678h = pbModel;
        this.f20679i = fVar;
        if (!j.z()) {
            this.f20671a.showToast(l.neterror);
        } else if (g(this.f20671a.getPageContext(), 11042)) {
            if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                if (TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                    return;
                }
                if (this.f20676f == null) {
                    this.f20676f = new GetEmotionPidModel();
                }
                c cVar = this.f20674d;
                if (cVar != null) {
                    cVar.a();
                }
                this.f20676f.x(emotionImageData.getPicUrl(), new C1031a(this, emotionImageData, pbModel, fVar));
                return;
            }
            c cVar2 = this.f20674d;
            if (cVar2 != null) {
                cVar2.a();
            }
            l(emotionImageData, pbModel, fVar);
        }
    }

    public final void l(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, emotionImageData, pbModel, fVar) == null) || emotionImageData == null || fVar == null) {
            return;
        }
        if (this.f20672b.X() == null && pbModel != null) {
            this.f20672b.setWriteData(pbModel.D(null));
        }
        if (this.f20672b.X() == null) {
            return;
        }
        boolean z = true;
        if (fVar.O().n2()) {
            this.f20672b.X().setCanNoForum(true);
            if (fVar.l() != null) {
                this.f20672b.X().setVForumId(fVar.l().getId());
                this.f20672b.X().setVForumName(fVar.l().getName());
            }
        } else {
            this.f20672b.X().setCanNoForum(false);
            this.f20672b.X().setVForumId("");
            this.f20672b.X().setVForumName("");
        }
        WriteData X = this.f20672b.X();
        LocationModel locationModel = this.f20673c;
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
            this.f20672b.X().setContent(str);
        } else {
            this.f20672b.X().setContent(h(emotionImageData.getAuthorNameShow()) + str);
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
            this.f20672b.X().setMemeContSign(emotionImageData.getMemeContSign());
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
            this.f20672b.X().setMemeText(emotionImageData.getMemeText());
        }
        this.f20672b.h0(this.j);
        if (!this.f20672b.l0()) {
        }
    }

    public void m(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
            this.f20675e = gVar;
        }
    }

    public void n(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f20674d = cVar;
        }
    }
}
