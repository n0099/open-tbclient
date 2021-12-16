package c.a.s0.s2.u.f.c1.f;

import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.k;
import c.a.d.f.p.r;
import c.a.r0.t.c.m0;
import c.a.r0.x.x.c;
import c.a.s0.s2.l;
import c.a.s0.s2.r.f;
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
    public NewWriteModel f22873b;

    /* renamed from: c  reason: collision with root package name */
    public LocationModel f22874c;

    /* renamed from: d  reason: collision with root package name */
    public c f22875d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel.g f22876e;

    /* renamed from: f  reason: collision with root package name */
    public GetEmotionPidModel f22877f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionImageData f22878g;

    /* renamed from: h  reason: collision with root package name */
    public PbModel f22879h;

    /* renamed from: i  reason: collision with root package name */
    public f f22880i;

    /* renamed from: j  reason: collision with root package name */
    public final NewWriteModel.g f22881j;

    /* renamed from: c.a.s0.s2.u.f.c1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1359a implements GetEmotionPidModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionImageData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbModel f22882b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f22883c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f22884d;

        public C1359a(a aVar, EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
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
            this.f22884d = aVar;
            this.a = emotionImageData;
            this.f22882b = pbModel;
            this.f22883c = fVar;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(c.a.r0.d0.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || TextUtils.isEmpty(cVar.a)) {
                return;
            }
            this.a.setPicId(cVar.a);
            this.f22884d.l(this.a, this.f22882b, this.f22883c);
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f22884d.f22876e == null) {
                return;
            }
            this.f22884d.f22876e.callback(false, null, null, null, null);
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m0 m0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) {
                if (writeData == null) {
                    writeData = this.a.f22873b.Y();
                }
                if (z) {
                    this.a.j();
                } else if (writeData != null && m0Var != null && !TextUtils.isEmpty(m0Var.d())) {
                    writeData.setVcodeMD5(m0Var.b());
                    writeData.setVcodeUrl(m0Var.c());
                    writeData.setVcodeExtra(m0Var.a());
                    if (c.a.r0.e1.a.b(m0Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.a.getPageContext().getPageActivity(), 25017, writeData, false, m0Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.a.getPageContext().getPageActivity(), writeData, 25017)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.a.getPageContext().getPageActivity(), 25017, writeData, postWriteCallBackData.getAccessState())));
                }
                if (this.a.f22876e != null) {
                    this.a.f22876e.callback(z, postWriteCallBackData, m0Var, writeData, antiData);
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
        this.f22881j = new b(this);
        this.a = baseFragmentActivity;
        this.f22873b = new NewWriteModel(baseFragmentActivity);
        this.f22874c = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GetEmotionPidModel getEmotionPidModel = this.f22877f;
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
                    k(this.f22878g, this.f22879h, this.f22880i);
                }
            } else if (intent == null) {
            } else {
                NewWriteModel newWriteModel = this.f22873b;
                WriteData Y = newWriteModel != null ? newWriteModel.Y() : null;
                j();
                NewWriteModel.g gVar = this.f22876e;
                if (gVar != null) {
                    gVar.callback(true, null, null, Y, null);
                }
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f22878g = null;
            this.f22880i = null;
            this.f22879h = null;
            NewWriteModel newWriteModel = this.f22873b;
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
        this.f22878g = emotionImageData;
        this.f22879h = pbModel;
        this.f22880i = fVar;
        if (!k.z()) {
            this.a.showToast(l.neterror);
        } else if (g(this.a.getPageContext(), 11042)) {
            if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                if (TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                    return;
                }
                if (this.f22877f == null) {
                    this.f22877f = new GetEmotionPidModel();
                }
                c cVar = this.f22875d;
                if (cVar != null) {
                    cVar.a();
                }
                this.f22877f.x(emotionImageData.getPicUrl(), new C1359a(this, emotionImageData, pbModel, fVar));
                return;
            }
            c cVar2 = this.f22875d;
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
        if (this.f22873b.Y() == null && pbModel != null) {
            this.f22873b.setWriteData(pbModel.D(null));
        }
        if (this.f22873b.Y() == null) {
            return;
        }
        boolean z = true;
        if (fVar.O().o2()) {
            this.f22873b.Y().setCanNoForum(true);
            if (fVar.l() != null) {
                this.f22873b.Y().setVForumId(fVar.l().getId());
                this.f22873b.Y().setVForumName(fVar.l().getName());
            }
        } else {
            this.f22873b.Y().setCanNoForum(false);
            this.f22873b.Y().setVForumId("");
            this.f22873b.Y().setVForumName("");
        }
        WriteData Y = this.f22873b.Y();
        LocationModel locationModel = this.f22874c;
        Y.setHasLocationData((locationModel == null || !locationModel.z()) ? false : false);
        StringBuilder sb = new StringBuilder(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX_SHORT);
        sb.append(emotionImageData.getPicId());
        sb.append(",");
        sb.append(emotionImageData.getWidth());
        sb.append(",");
        sb.append(emotionImageData.getHeight());
        sb.append(",");
        String str = SmallTailInfo.EMOTION_PREFIX + sb.toString() + r.c(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + SmallTailInfo.EMOTION_SUFFIX;
        if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
            this.f22873b.Y().setContent(str);
        } else {
            this.f22873b.Y().setContent(h(emotionImageData.getAuthorNameShow()) + str);
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
            this.f22873b.Y().setMemeContSign(emotionImageData.getMemeContSign());
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
            this.f22873b.Y().setMemeText(emotionImageData.getMemeText());
        }
        this.f22873b.j0(this.f22881j);
        if (!this.f22873b.n0()) {
        }
    }

    public void m(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
            this.f22876e = gVar;
        }
    }

    public void n(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f22875d = cVar;
        }
    }
}
