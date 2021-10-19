package c.a.r0.k2.k.e.b1.f;

import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.q;
import c.a.q0.t.c.l0;
import c.a.q0.x.x.c;
import c.a.r0.k2.h.e;
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
    public BaseFragmentActivity f20096a;

    /* renamed from: b  reason: collision with root package name */
    public NewWriteModel f20097b;

    /* renamed from: c  reason: collision with root package name */
    public LocationModel f20098c;

    /* renamed from: d  reason: collision with root package name */
    public c f20099d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel.g f20100e;

    /* renamed from: f  reason: collision with root package name */
    public GetEmotionPidModel f20101f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionImageData f20102g;

    /* renamed from: h  reason: collision with root package name */
    public PbModel f20103h;

    /* renamed from: i  reason: collision with root package name */
    public e f20104i;

    /* renamed from: j  reason: collision with root package name */
    public final NewWriteModel.g f20105j;

    /* renamed from: c.a.r0.k2.k.e.b1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0960a implements GetEmotionPidModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionImageData f20106a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbModel f20107b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f20108c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f20109d;

        public C0960a(a aVar, EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
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
            this.f20109d = aVar;
            this.f20106a = emotionImageData;
            this.f20107b = pbModel;
            this.f20108c = eVar;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(c.a.q0.d0.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || TextUtils.isEmpty(cVar.f12862a)) {
                return;
            }
            this.f20106a.setPicId(cVar.f12862a);
            this.f20109d.l(this.f20106a, this.f20107b, this.f20108c);
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f20109d.f20100e == null) {
                return;
            }
            this.f20109d.f20100e.callback(false, null, null, null, null);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f20110a;

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
            this.f20110a = aVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, l0 l0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l0Var, writeData, antiData}) == null) {
                if (writeData == null) {
                    writeData = this.f20110a.f20097b.X();
                }
                if (z) {
                    this.f20110a.j();
                } else if (writeData != null && l0Var != null && !TextUtils.isEmpty(l0Var.d())) {
                    writeData.setVcodeMD5(l0Var.b());
                    writeData.setVcodeUrl(l0Var.c());
                    writeData.setVcodeExtra(l0Var.a());
                    if (c.a.q0.e1.a.b(l0Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.f20110a.f20096a.getPageContext().getPageActivity(), 25017, writeData, false, l0Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.f20110a.f20096a.getPageContext().getPageActivity(), writeData, 25017)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.f20110a.f20096a.getPageContext().getPageActivity(), 25017, writeData, postWriteCallBackData.getAccessState())));
                }
                if (this.f20110a.f20100e != null) {
                    this.f20110a.f20100e.callback(z, postWriteCallBackData, l0Var, writeData, antiData);
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
        this.f20105j = new b(this);
        this.f20096a = baseFragmentActivity;
        this.f20097b = new NewWriteModel(baseFragmentActivity);
        this.f20098c = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GetEmotionPidModel getEmotionPidModel = this.f20101f;
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
                    k(this.f20102g, this.f20103h, this.f20104i);
                }
            } else if (intent == null) {
            } else {
                NewWriteModel newWriteModel = this.f20097b;
                WriteData X = newWriteModel != null ? newWriteModel.X() : null;
                j();
                NewWriteModel.g gVar = this.f20100e;
                if (gVar != null) {
                    gVar.callback(true, null, null, X, null);
                }
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f20102g = null;
            this.f20104i = null;
            this.f20103h = null;
            NewWriteModel newWriteModel = this.f20097b;
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
        this.f20102g = emotionImageData;
        this.f20103h = pbModel;
        this.f20104i = eVar;
        if (!j.z()) {
            this.f20096a.showToast(R.string.neterror);
        } else if (g(this.f20096a.getPageContext(), 11042)) {
            if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                if (TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                    return;
                }
                if (this.f20101f == null) {
                    this.f20101f = new GetEmotionPidModel();
                }
                c cVar = this.f20099d;
                if (cVar != null) {
                    cVar.a();
                }
                this.f20101f.x(emotionImageData.getPicUrl(), new C0960a(this, emotionImageData, pbModel, eVar));
                return;
            }
            c cVar2 = this.f20099d;
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
        if (this.f20097b.X() == null && pbModel != null) {
            this.f20097b.setWriteData(pbModel.D(null));
        }
        if (this.f20097b.X() == null) {
            return;
        }
        boolean z = true;
        if (eVar.O().l2()) {
            this.f20097b.X().setCanNoForum(true);
            if (eVar.m() != null) {
                this.f20097b.X().setVForumId(eVar.m().getId());
                this.f20097b.X().setVForumName(eVar.m().getName());
            }
        } else {
            this.f20097b.X().setCanNoForum(false);
            this.f20097b.X().setVForumId("");
            this.f20097b.X().setVForumName("");
        }
        WriteData X = this.f20097b.X();
        LocationModel locationModel = this.f20098c;
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
            this.f20097b.X().setContent(str);
        } else {
            this.f20097b.X().setContent(h(emotionImageData.getAuthorNameShow()) + str);
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
            this.f20097b.X().setMemeContSign(emotionImageData.getMemeContSign());
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
            this.f20097b.X().setMemeText(emotionImageData.getMemeText());
        }
        this.f20097b.h0(this.f20105j);
        if (!this.f20097b.l0()) {
        }
    }

    public void m(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
            this.f20100e = gVar;
        }
    }

    public void n(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f20099d = cVar;
        }
    }
}
