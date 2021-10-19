package c.a.r0.k3.r0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.l1;
import c.a.q0.t.c.l0;
import c.a.r0.k3.z;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.WorkPostNotifyFlutterData;
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
    public final NewWriteModel f21281a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f21282b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f21283c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f21284d;

    /* renamed from: e  reason: collision with root package name */
    public String f21285e;

    /* renamed from: f  reason: collision with root package name */
    public int f21286f;

    /* renamed from: g  reason: collision with root package name */
    public String f21287g;

    /* renamed from: h  reason: collision with root package name */
    public String f21288h;

    /* renamed from: i  reason: collision with root package name */
    public String f21289i;

    /* renamed from: j  reason: collision with root package name */
    public NewWriteModel.g f21290j;

    /* loaded from: classes3.dex */
    public class a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f21291a;

        /* renamed from: c.a.r0.k3.r0.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0997a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f21292e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ WriteData f21293f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f21294g;

            public RunnableC0997a(a aVar, PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
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
                this.f21294g = aVar;
                this.f21292e = postWriteCallBackData;
                this.f21293f = writeData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if ((!c.a.e.e.p.k.isEmpty(this.f21292e.getVideoid()) && this.f21293f.getVideoInfo() != null) || (this.f21293f.getVideoInfo() != null && this.f21293f.getVideoInfo().hasUpload())) {
                        i.n(this.f21292e);
                    } else {
                        i.m(this.f21292e);
                    }
                    this.f21294g.f21291a.f();
                    this.f21294g.f21291a.g();
                    if (!c.a.e.e.p.k.isEmpty(this.f21292e.getVideoid()) && this.f21293f.getVideoInfo() != null) {
                        this.f21292e.mVideoMd5 = this.f21293f.getVideoInfo().getVideoMd5();
                        if (!c.a.e.e.p.k.isEmpty(this.f21293f.getForumName())) {
                            this.f21292e.mFrom = 2;
                        }
                    }
                    this.f21294g.f21291a.t();
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
            this.f21291a = gVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, l0 l0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l0Var, writeData, antiData}) == null) || writeData == null) {
                return;
            }
            if (z) {
                WorkPostNotifyFlutterData f2 = WorkPostNotifyFlutterData.f(postWriteCallBackData.getVideoid());
                f2.j(writeData.getForumId());
                f2.k(writeData.getForumName());
                f2.l(writeData);
                f2.i(this.f21291a.i());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, f2));
                int k = c.a.q0.s.d0.b.j().k("key_video_works_progress_bar_waiting_time", 3);
                c.a.e.e.m.e.a().postDelayed(new RunnableC0997a(this, postWriteCallBackData, writeData), ((k > 0 ? k : 3) + 1) * 1000);
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, WorkPostNotifyFlutterData.e(postWriteCallBackData.getErrorString())));
            i.l(postWriteCallBackData, l0Var, writeData, antiData);
            this.f21291a.t();
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final g f21295a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(304615435, "Lc/a/r0/k3/r0/g$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(304615435, "Lc/a/r0/k3/r0/g$b;");
                    return;
                }
            }
            f21295a = new g(null);
        }
    }

    public /* synthetic */ g(a aVar) {
        this();
    }

    public static g j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            h.a("AsyncWriteHelper.getInstance()");
            return b.f21295a;
        }
        return (g) invokeV.objValue;
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f21287g = str;
        }
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f21288h = str;
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f21289i = str;
        }
    }

    public void D(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, spanGroupManager) == null) {
            h.a("AsyncWriteHelper.setSpanGroupManager()");
            this.f21281a.Y();
            this.f21281a.setSpanGroupManager(spanGroupManager);
        }
    }

    public void E(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.setWriteData = ");
            sb.append(writeData == null ? StringUtil.NULL_STRING : writeData.toDraftString());
            h.a(sb.toString());
            this.f21281a.setWriteData(writeData);
            if (writeData != null && writeData.isWork() && this.f21283c == null) {
                this.f21281a.h0(this.f21290j);
            } else {
                this.f21281a.h0(this);
            }
        }
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            h.a("AsyncWriteHelper.startPostWrite()");
            this.f21281a.Y();
            boolean j0 = this.f21281a.j0();
            this.f21282b = j0;
            return j0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, l0 l0Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l0Var, writeData, antiData}) == null) || writeData == null) {
            return;
        }
        if (z) {
            l1.h(writeData, 100).f(true);
            if ((!c.a.e.e.p.k.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) || (writeData.getVideoInfo() != null && writeData.getVideoInfo().hasUpload())) {
                i.n(postWriteCallBackData);
            } else {
                i.m(postWriteCallBackData);
            }
            f();
            g();
            u(postWriteCallBackData);
            if (!c.a.e.e.p.k.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) {
                postWriteCallBackData.mVideoMd5 = writeData.getVideoInfo().getVideoMd5();
                if (!c.a.e.e.p.k.isEmpty(writeData.getForumName())) {
                    postWriteCallBackData.mFrom = 2;
                }
            }
            l1.h(writeData, 100).f(false);
        } else {
            l1.h(writeData, 100).f(false);
            i.l(postWriteCallBackData, l0Var, writeData, antiData);
        }
        NewWriteModel newWriteModel = this.f21281a;
        if (newWriteModel != null) {
            newWriteModel.setWriteData(null);
        }
        this.f21282b = false;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            h.a("AsyncWriteHelper.cancelLoadData()");
            this.f21281a.cancelLoadData();
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            h.a("AsyncWriteHelper.checkImageNum = " + this.f21281a.U());
            return this.f21281a.U();
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        WriteData n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (n = n()) == null) {
            return;
        }
        if (n.getType() != 0 && n.getType() != 9 && n.getType() != 11) {
            if (n.getType() == 1) {
                z.s(n.getThreadId(), null);
            }
        } else if (n.isEvaluate()) {
            z.o(n.getItem_id(), null);
        } else if (TextUtils.isEmpty(n.getTopicId())) {
            z.q(n.getForumId(), n, true);
        } else {
            z.u(n.getTopicId(), null);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            FileHelper.deleteFileOrDir(new File(c.a.r0.y3.c.f29081f));
            z.r("");
        }
    }

    public BdUniqueId h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f21283c : (BdUniqueId) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f21285e : (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f21287g : (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f21288h : (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f21289i : (String) invokeV.objValue;
    }

    public WriteData n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.getWriteData = ");
            sb.append(this.f21281a.X() == null ? StringUtil.NULL_STRING : this.f21281a.X().toDraftString());
            h.a(sb.toString());
            return this.f21281a.X();
        }
        return (WriteData) invokeV.objValue;
    }

    public void o(@NonNull TbPageContextSupport tbPageContextSupport) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, tbPageContextSupport) == null) {
            h.a("AsyncWriteHelper.initWriteStatus()");
            this.f21281a.i0(tbPageContextSupport.getPageContext());
            this.f21281a.setWriteData(null);
            this.f21281a.d0(false);
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f21282b : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f21284d : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f21286f == 8 : invokeV.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            h.a("AsyncWriteHelper.onWriteActClose()");
            this.f21281a.i0(null);
            this.f21281a.setSpanGroupManager(null);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            NewWriteModel newWriteModel = this.f21281a;
            if (newWriteModel != null) {
                newWriteModel.setWriteData(null);
            }
            this.f21282b = false;
        }
    }

    public final void u(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, postWriteCallBackData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bdUniqueId) == null) {
            this.f21283c = bdUniqueId;
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.f21285e = str;
        }
    }

    public void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.f21286f = i2;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.f21284d = z;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            h.a("AsyncWriteHelper.setHasImage = " + z);
            this.f21281a.d0(z);
        }
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
        this.f21282b = false;
        this.f21283c = null;
        this.f21290j = new a(this);
        NewWriteModel newWriteModel = new NewWriteModel();
        this.f21281a = newWriteModel;
        newWriteModel.h0(this);
    }
}
