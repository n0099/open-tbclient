package c.a.r0.u2.k.f.d1.f;

import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.t;
import c.a.q0.s.c.l0;
import c.a.q0.w.y.c;
import c.a.r0.u2.h.f;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public NewWriteModel f23451b;

    /* renamed from: c  reason: collision with root package name */
    public LocationModel f23452c;

    /* renamed from: d  reason: collision with root package name */
    public c f23453d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel.g f23454e;

    /* renamed from: f  reason: collision with root package name */
    public GetEmotionPidModel f23455f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionImageData f23456g;

    /* renamed from: h  reason: collision with root package name */
    public PbModel f23457h;

    /* renamed from: i  reason: collision with root package name */
    public f f23458i;

    /* renamed from: j  reason: collision with root package name */
    public final NewWriteModel.g f23459j;

    /* renamed from: c.a.r0.u2.k.f.d1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1453a implements GetEmotionPidModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionImageData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbModel f23460b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f23461c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f23462d;

        public C1453a(a aVar, EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
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
            this.f23462d = aVar;
            this.a = emotionImageData;
            this.f23460b = pbModel;
            this.f23461c = fVar;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(c.a.q0.c0.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || TextUtils.isEmpty(cVar.a)) {
                return;
            }
            this.a.setPicId(cVar.a);
            this.f23462d.l(this.a, this.f23460b, this.f23461c);
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f23462d.f23454e == null) {
                return;
            }
            this.f23462d.f23454e.callback(false, null, null, null, null);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, l0 l0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l0Var, writeData, antiData}) == null) {
                if (writeData == null) {
                    writeData = this.a.f23451b.Z();
                }
                if (z) {
                    this.a.j();
                } else if (writeData != null && l0Var != null && !TextUtils.isEmpty(l0Var.d())) {
                    writeData.setVcodeMD5(l0Var.b());
                    writeData.setVcodeUrl(l0Var.c());
                    writeData.setVcodeExtra(l0Var.a());
                    if (c.a.q0.d1.a.b(l0Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.a.getPageContext().getPageActivity(), 25017, writeData, false, l0Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.a.getPageContext().getPageActivity(), writeData, 25017)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.a.getPageContext().getPageActivity(), 25017, writeData, postWriteCallBackData.getAccessState())));
                }
                if (this.a.f23454e != null) {
                    this.a.f23454e.callback(z, postWriteCallBackData, l0Var, writeData, antiData);
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
        this.f23459j = new b(this);
        this.a = baseFragmentActivity;
        this.f23451b = new NewWriteModel(baseFragmentActivity);
        this.f23452c = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GetEmotionPidModel getEmotionPidModel = this.f23455f;
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
                    k(this.f23456g, this.f23457h, this.f23458i);
                }
            } else if (intent == null) {
            } else {
                NewWriteModel newWriteModel = this.f23451b;
                WriteData Z = newWriteModel != null ? newWriteModel.Z() : null;
                j();
                NewWriteModel.g gVar = this.f23454e;
                if (gVar != null) {
                    gVar.callback(true, null, null, Z, null);
                }
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f23456g = null;
            this.f23458i = null;
            this.f23457h = null;
            NewWriteModel newWriteModel = this.f23451b;
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
        this.f23456g = emotionImageData;
        this.f23457h = pbModel;
        this.f23458i = fVar;
        if (!l.z()) {
            this.a.showToast(R.string.neterror);
        } else if (g(this.a.getPageContext(), 11042)) {
            if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                if (TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                    return;
                }
                if (this.f23455f == null) {
                    this.f23455f = new GetEmotionPidModel();
                }
                c cVar = this.f23453d;
                if (cVar != null) {
                    cVar.a();
                }
                this.f23455f.x(emotionImageData.getPicUrl(), new C1453a(this, emotionImageData, pbModel, fVar));
                return;
            }
            c cVar2 = this.f23453d;
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
        if (this.f23451b.Z() == null && pbModel != null) {
            this.f23451b.setWriteData(pbModel.D(null));
        }
        if (this.f23451b.Z() == null) {
            return;
        }
        boolean z = true;
        if (fVar.O().p2()) {
            this.f23451b.Z().setCanNoForum(true);
            if (fVar.l() != null) {
                this.f23451b.Z().setVForumId(fVar.l().getId());
                this.f23451b.Z().setVForumName(fVar.l().getName());
            }
        } else {
            this.f23451b.Z().setCanNoForum(false);
            this.f23451b.Z().setVForumId("");
            this.f23451b.Z().setVForumName("");
        }
        WriteData Z = this.f23451b.Z();
        LocationModel locationModel = this.f23452c;
        Z.setHasLocationData((locationModel == null || !locationModel.z()) ? false : false);
        StringBuilder sb = new StringBuilder(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX_SHORT);
        sb.append(emotionImageData.getPicId());
        sb.append(",");
        sb.append(emotionImageData.getWidth());
        sb.append(",");
        sb.append(emotionImageData.getHeight());
        sb.append(",");
        String str = SmallTailInfo.EMOTION_PREFIX + sb.toString() + t.c(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + SmallTailInfo.EMOTION_SUFFIX;
        if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
            this.f23451b.Z().setContent(str);
        } else {
            this.f23451b.Z().setContent(h(emotionImageData.getAuthorNameShow()) + str);
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
            this.f23451b.Z().setMemeContSign(emotionImageData.getMemeContSign());
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
            this.f23451b.Z().setMemeText(emotionImageData.getMemeText());
        }
        this.f23451b.l0(this.f23459j);
        if (!this.f23451b.p0()) {
        }
    }

    public void m(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
            this.f23454e = gVar;
        }
    }

    public void n(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f23453d = cVar;
        }
    }
}
