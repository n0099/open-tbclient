package c.a.p0.i3.q0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.s.q.k1;
import c.a.o0.s.q.m2;
import c.a.o0.t.c.k0;
import c.a.p0.i3.y;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class g implements NewWriteModel.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final NewWriteModel f20192a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f20193b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f20194c;

    /* renamed from: d  reason: collision with root package name */
    public String f20195d;

    /* renamed from: e  reason: collision with root package name */
    public String f20196e;

    /* renamed from: f  reason: collision with root package name */
    public String f20197f;

    /* renamed from: g  reason: collision with root package name */
    public NewWriteModel.g f20198g;

    /* loaded from: classes3.dex */
    public class a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f20199a;

        /* renamed from: c.a.p0.i3.q0.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0946a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f20200e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ WriteData f20201f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f20202g;

            public RunnableC0946a(a aVar, PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, postWriteCallBackData, writeData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f20202g = aVar;
                this.f20200e = postWriteCallBackData;
                this.f20201f = writeData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if ((!c.a.e.e.p.k.isEmpty(this.f20200e.getVideoid()) && this.f20201f.getVideoInfo() != null) || (this.f20201f.getVideoInfo() != null && this.f20201f.getVideoInfo().hasUpload())) {
                        i.n(this.f20200e);
                    } else {
                        i.m(this.f20200e);
                    }
                    if (this.f20201f.isWorkDraft()) {
                        y.r("");
                    }
                    if (!c.a.e.e.p.k.isEmpty(this.f20200e.getVideoid()) && this.f20201f.getVideoInfo() != null) {
                        this.f20200e.mVideoMd5 = this.f20201f.getVideoInfo().getVideoMd5();
                        if (!c.a.e.e.p.k.isEmpty(this.f20201f.getForumName())) {
                            this.f20200e.mFrom = 2;
                        }
                    }
                    this.f20202g.f20199a.o();
                }
            }
        }

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20199a = gVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, k0 k0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) || writeData == null) {
                return;
            }
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, m2.b(postWriteCallBackData.getVideoid())));
                int k = c.a.o0.s.d0.b.j().k("key_video_works_progress_bar_waiting_time", 3);
                c.a.e.e.m.e.a().postDelayed(new RunnableC0946a(this, postWriteCallBackData, writeData), ((k > 0 ? k : 3) + 1) * 1000);
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, m2.a(postWriteCallBackData.getErrorString())));
            i.l(postWriteCallBackData, k0Var, writeData, antiData);
            this.f20199a.o();
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final g f20203a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(396944778, "Lc/a/p0/i3/q0/g$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(396944778, "Lc/a/p0/i3/q0/g$b;");
                    return;
                }
            }
            f20203a = new g(null);
        }
    }

    public /* synthetic */ g(a aVar) {
        this();
    }

    public static g g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            h.a("AsyncWriteHelper.getInstance()");
            return b.f20203a;
        }
        return (g) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h.a("AsyncWriteHelper.cancelLoadData()");
            this.f20192a.cancelLoadData();
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            h.a("AsyncWriteHelper.checkImageNum = " + this.f20192a.U());
            return this.f20192a.U();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, k0 k0Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) || writeData == null) {
            return;
        }
        if (z) {
            k1.h(writeData, 100).f(true);
            if ((!c.a.e.e.p.k.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) || (writeData.getVideoInfo() != null && writeData.getVideoInfo().hasUpload())) {
                i.n(postWriteCallBackData);
            } else {
                i.m(postWriteCallBackData);
            }
            d();
            e();
            p(postWriteCallBackData);
            if (!c.a.e.e.p.k.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) {
                postWriteCallBackData.mVideoMd5 = writeData.getVideoInfo().getVideoMd5();
                if (!c.a.e.e.p.k.isEmpty(writeData.getForumName())) {
                    postWriteCallBackData.mFrom = 2;
                }
            }
            k1.h(writeData, 100).f(false);
        } else {
            k1.h(writeData, 100).f(false);
            i.l(postWriteCallBackData, k0Var, writeData, antiData);
        }
        NewWriteModel newWriteModel = this.f20192a;
        if (newWriteModel != null) {
            newWriteModel.setWriteData(null);
        }
        this.f20193b = false;
    }

    public final void d() {
        WriteData k;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (k = k()) == null) {
            return;
        }
        if (k.getType() != 0 && k.getType() != 9 && k.getType() != 11) {
            if (k.getType() == 1) {
                y.s(k.getThreadId(), null);
            }
        } else if (k.isEvaluate()) {
            y.o(k.getItem_id(), null);
        } else if (TextUtils.isEmpty(k.getTopicId())) {
            y.q(k.getForumId(), k, true);
        } else {
            y.u(k.getTopicId(), null);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            FileHelper.deleteFileOrDir(new File(c.a.p0.w3.c.f27859f));
        }
    }

    public BdUniqueId f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20194c : (BdUniqueId) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f20195d : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f20196e : (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f20197f : (String) invokeV.objValue;
    }

    public WriteData k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.getWriteData = ");
            sb.append(this.f20192a.X() == null ? StringUtil.NULL_STRING : this.f20192a.X().toDraftString());
            h.a(sb.toString());
            return this.f20192a.X();
        }
        return (WriteData) invokeV.objValue;
    }

    public void l(@NonNull TbPageContextSupport tbPageContextSupport) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tbPageContextSupport) == null) {
            h.a("AsyncWriteHelper.initWriteStatus()");
            this.f20192a.i0(tbPageContextSupport.getPageContext());
            this.f20192a.setWriteData(null);
            this.f20192a.d0(false);
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f20193b : invokeV.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            h.a("AsyncWriteHelper.onWriteActClose()");
            this.f20192a.i0(null);
            this.f20192a.setSpanGroupManager(null);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            NewWriteModel newWriteModel = this.f20192a;
            if (newWriteModel != null) {
                newWriteModel.setWriteData(null);
            }
            this.f20193b = false;
        }
    }

    public final void p(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, postWriteCallBackData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bdUniqueId) == null) {
            this.f20194c = bdUniqueId;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            h.a("AsyncWriteHelper.setHasImage = " + z);
            this.f20192a.d0(z);
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.f20195d = str;
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.f20196e = str;
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f20197f = str;
        }
    }

    public void v(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, spanGroupManager) == null) {
            h.a("AsyncWriteHelper.setSpanGroupManager()");
            this.f20192a.Y();
            this.f20192a.setSpanGroupManager(spanGroupManager);
        }
    }

    public void w(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, writeData) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.setWriteData = ");
            sb.append(writeData == null ? StringUtil.NULL_STRING : writeData.toDraftString());
            h.a(sb.toString());
            this.f20192a.setWriteData(writeData);
            if (writeData != null && writeData.isWork()) {
                this.f20192a.h0(this.f20198g);
            } else {
                this.f20192a.h0(this);
            }
        }
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            h.a("AsyncWriteHelper.startPostWrite()");
            this.f20192a.Y();
            boolean j0 = this.f20192a.j0();
            this.f20193b = j0;
            return j0;
        }
        return invokeV.booleanValue;
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20193b = false;
        this.f20194c = null;
        this.f20198g = new a(this);
        NewWriteModel newWriteModel = new NewWriteModel();
        this.f20192a = newWriteModel;
        newWriteModel.h0(this);
    }
}
