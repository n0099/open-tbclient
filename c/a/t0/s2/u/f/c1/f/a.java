package c.a.t0.s2.u.f.c1.f;

import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.t;
import c.a.s0.t.c.n0;
import c.a.s0.x.y.c;
import c.a.t0.s2.r.f;
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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public NewWriteModel f22738b;

    /* renamed from: c  reason: collision with root package name */
    public LocationModel f22739c;

    /* renamed from: d  reason: collision with root package name */
    public c f22740d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel.g f22741e;

    /* renamed from: f  reason: collision with root package name */
    public GetEmotionPidModel f22742f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionImageData f22743g;

    /* renamed from: h  reason: collision with root package name */
    public PbModel f22744h;

    /* renamed from: i  reason: collision with root package name */
    public f f22745i;

    /* renamed from: j  reason: collision with root package name */
    public final NewWriteModel.g f22746j;

    /* renamed from: c.a.t0.s2.u.f.c1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1402a implements GetEmotionPidModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionImageData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbModel f22747b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f22748c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f22749d;

        public C1402a(a aVar, EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
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
            this.f22749d = aVar;
            this.a = emotionImageData;
            this.f22747b = pbModel;
            this.f22748c = fVar;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(c.a.s0.d0.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || TextUtils.isEmpty(cVar.a)) {
                return;
            }
            this.a.setPicId(cVar.a);
            this.f22749d.l(this.a, this.f22747b, this.f22748c);
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f22749d.f22741e == null) {
                return;
            }
            this.f22749d.f22741e.callback(false, null, null, null, null);
        }
    }

    /* loaded from: classes8.dex */
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, n0 n0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, n0Var, writeData, antiData}) == null) {
                if (writeData == null) {
                    writeData = this.a.f22738b.Z();
                }
                if (z) {
                    this.a.j();
                } else if (writeData != null && n0Var != null && !TextUtils.isEmpty(n0Var.d())) {
                    writeData.setVcodeMD5(n0Var.b());
                    writeData.setVcodeUrl(n0Var.c());
                    writeData.setVcodeExtra(n0Var.a());
                    if (c.a.s0.f1.a.b(n0Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.a.getPageContext().getPageActivity(), 25017, writeData, false, n0Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.a.getPageContext().getPageActivity(), writeData, 25017)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.a.getPageContext().getPageActivity(), 25017, writeData, postWriteCallBackData.getAccessState())));
                }
                if (this.a.f22741e != null) {
                    this.a.f22741e.callback(z, postWriteCallBackData, n0Var, writeData, antiData);
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
        this.f22746j = new b(this);
        this.a = baseFragmentActivity;
        this.f22738b = new NewWriteModel(baseFragmentActivity);
        this.f22739c = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GetEmotionPidModel getEmotionPidModel = this.f22742f;
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
                    k(this.f22743g, this.f22744h, this.f22745i);
                }
            } else if (intent == null) {
            } else {
                NewWriteModel newWriteModel = this.f22738b;
                WriteData Z = newWriteModel != null ? newWriteModel.Z() : null;
                j();
                NewWriteModel.g gVar = this.f22741e;
                if (gVar != null) {
                    gVar.callback(true, null, null, Z, null);
                }
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f22743g = null;
            this.f22745i = null;
            this.f22744h = null;
            NewWriteModel newWriteModel = this.f22738b;
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
        this.f22743g = emotionImageData;
        this.f22744h = pbModel;
        this.f22745i = fVar;
        if (!l.z()) {
            this.a.showToast(c.a.t0.s2.l.neterror);
        } else if (g(this.a.getPageContext(), 11042)) {
            if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                if (TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                    return;
                }
                if (this.f22742f == null) {
                    this.f22742f = new GetEmotionPidModel();
                }
                c cVar = this.f22740d;
                if (cVar != null) {
                    cVar.a();
                }
                this.f22742f.x(emotionImageData.getPicUrl(), new C1402a(this, emotionImageData, pbModel, fVar));
                return;
            }
            c cVar2 = this.f22740d;
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
        if (this.f22738b.Z() == null && pbModel != null) {
            this.f22738b.setWriteData(pbModel.D(null));
        }
        if (this.f22738b.Z() == null) {
            return;
        }
        boolean z = true;
        if (fVar.O().o2()) {
            this.f22738b.Z().setCanNoForum(true);
            if (fVar.l() != null) {
                this.f22738b.Z().setVForumId(fVar.l().getId());
                this.f22738b.Z().setVForumName(fVar.l().getName());
            }
        } else {
            this.f22738b.Z().setCanNoForum(false);
            this.f22738b.Z().setVForumId("");
            this.f22738b.Z().setVForumName("");
        }
        WriteData Z = this.f22738b.Z();
        LocationModel locationModel = this.f22739c;
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
            this.f22738b.Z().setContent(str);
        } else {
            this.f22738b.Z().setContent(h(emotionImageData.getAuthorNameShow()) + str);
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
            this.f22738b.Z().setMemeContSign(emotionImageData.getMemeContSign());
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
            this.f22738b.Z().setMemeText(emotionImageData.getMemeText());
        }
        this.f22738b.l0(this.f22746j);
        if (!this.f22738b.p0()) {
        }
    }

    public void m(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
            this.f22741e = gVar;
        }
    }

    public void n(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f22740d = cVar;
        }
    }
}
