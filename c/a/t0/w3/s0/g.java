package c.a.t0.w3.s0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.l1;
import c.a.s0.t.c.m0;
import c.a.t0.w3.a0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes8.dex */
public class g implements NewWriteModel.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NewWriteModel a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f25760b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f25761c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f25762d;

    /* renamed from: e  reason: collision with root package name */
    public String f25763e;

    /* renamed from: f  reason: collision with root package name */
    public int f25764f;

    /* renamed from: g  reason: collision with root package name */
    public String f25765g;

    /* renamed from: h  reason: collision with root package name */
    public String f25766h;

    /* renamed from: i  reason: collision with root package name */
    public String f25767i;

    /* renamed from: j  reason: collision with root package name */
    public NewWriteModel.g f25768j;

    /* loaded from: classes8.dex */
    public class a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        /* renamed from: c.a.t0.w3.s0.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1492a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ WriteData f25769e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f25770f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f25771g;

            public RunnableC1492a(a aVar, WriteData writeData, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, writeData, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25771g = aVar;
                this.f25769e = writeData;
                this.f25770f = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    l1.g(this.f25769e, 100).f(false);
                    if ((!c.a.d.f.p.m.isEmpty(this.f25770f.getVideoid()) && this.f25769e.getVideoInfo() != null) || (this.f25769e.getVideoInfo() != null && this.f25769e.getVideoInfo().hasUpload())) {
                        i.n(this.f25770f);
                    } else {
                        i.m(this.f25770f);
                    }
                    this.f25771g.a.f();
                    this.f25771g.a.g();
                    if (!c.a.d.f.p.m.isEmpty(this.f25770f.getVideoid()) && this.f25769e.getVideoInfo() != null) {
                        this.f25770f.mVideoMd5 = this.f25769e.getVideoInfo().getVideoMd5();
                        if (!c.a.d.f.p.m.isEmpty(this.f25769e.getForumName())) {
                            this.f25770f.mFrom = 2;
                        }
                    }
                    this.f25771g.a.u();
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
            this.a = gVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m0 m0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) || writeData == null) {
                return;
            }
            if (z) {
                WorkPostNotifyFlutterData f2 = WorkPostNotifyFlutterData.f(postWriteCallBackData.getVideoid());
                f2.j(writeData.getForumId());
                f2.k(writeData.getForumName());
                f2.l(writeData);
                f2.i(this.a.j());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, f2));
                int k2 = c.a.s0.s.g0.b.j().k("key_video_works_progress_bar_waiting_time", 3);
                c.a.d.f.m.e.a().postDelayed(new RunnableC1492a(this, writeData, postWriteCallBackData), ((k2 > 0 ? k2 : 3) + 1) * 1000);
                g.k().w(null);
                this.a.u();
            } else if (c.a.s0.f1.a.d(postWriteCallBackData, m0Var, writeData, antiData)) {
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, WorkPostNotifyFlutterData.e(postWriteCallBackData.getErrorString())));
                i.l(postWriteCallBackData, m0Var, writeData, antiData);
                g.k().w(null);
                this.a.u();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PostWriteCallBackData f25772e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ WriteData f25773f;

        public b(g gVar, PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, postWriteCallBackData, writeData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25772e = postWriteCallBackData;
            this.f25773f = writeData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if ((!c.a.d.f.p.m.isEmpty(this.f25772e.getVideoid()) && this.f25773f.getVideoInfo() != null) || (this.f25773f.getVideoInfo() != null && this.f25773f.getVideoInfo().hasUpload())) {
                    i.n(this.f25772e);
                } else {
                    i.m(this.f25772e);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final g a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1752848927, "Lc/a/t0/w3/s0/g$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1752848927, "Lc/a/t0/w3/s0/g$c;");
                    return;
                }
            }
            a = new g(null);
        }
    }

    public /* synthetic */ g(a aVar) {
        this();
    }

    public static g k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            h.a("AsyncWriteHelper.getInstance()");
            return c.a;
        }
        return (g) invokeV.objValue;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            h.a("AsyncWriteHelper.setHasImage = " + z);
            this.a.g0(z);
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.a.f0(z);
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f25765g = str;
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f25766h = str;
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f25767i = str;
        }
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.a.j0(z);
        }
    }

    public void G(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, spanGroupManager) == null) {
            h.a("AsyncWriteHelper.setSpanGroupManager()");
            this.a.a0();
            this.a.setSpanGroupManager(spanGroupManager);
        }
    }

    public void H(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, writeData) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.setWriteData = ");
            sb.append(writeData == null ? StringUtil.NULL_STRING : writeData.toDraftString());
            h.a(sb.toString());
            this.a.setWriteData(writeData);
            if (writeData != null && writeData.isWork() && this.f25761c == null) {
                this.a.l0(this.f25768j);
            } else {
                this.a.l0(this);
            }
        }
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            h.a("AsyncWriteHelper.startPostWrite()");
            this.a.a0();
            boolean n0 = this.a.n0();
            this.f25760b = n0;
            return n0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m0 m0Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) || writeData == null) {
            return;
        }
        if (z) {
            l1.g(writeData, 100).f(true);
            c.a.d.f.m.e.a().postDelayed(new b(this, postWriteCallBackData, writeData), 200L);
            f();
            g();
            v(postWriteCallBackData);
            if (!c.a.d.f.p.m.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) {
                postWriteCallBackData.mVideoMd5 = writeData.getVideoInfo().getVideoMd5();
                if (!c.a.d.f.p.m.isEmpty(writeData.getForumName())) {
                    postWriteCallBackData.mFrom = 2;
                }
            }
            l1.g(writeData, 100).f(false);
            k().w(null);
            u();
        } else if (c.a.s0.f1.a.d(postWriteCallBackData, m0Var, writeData, antiData)) {
        } else {
            l1.g(writeData, 100).f(false);
            i.l(postWriteCallBackData, m0Var, writeData, antiData);
            k().w(null);
            u();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            h.a("AsyncWriteHelper.cancelLoadData()");
            this.a.cancelLoadData();
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            h.a("AsyncWriteHelper.checkImageNum = " + this.a.W());
            return this.a.W();
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        WriteData o;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (o = o()) == null) {
            return;
        }
        if (o.getType() != 0 && o.getType() != 9 && o.getType() != 11) {
            if (o.getType() == 1) {
                a0.v(o.getThreadId(), null);
            }
        } else if (o.isLocalChannelDynamic()) {
            a0.t(null);
        } else if (o.isEvaluate()) {
            a0.q(o.getItem_id(), null);
        } else if (TextUtils.isEmpty(o.getTopicId())) {
            a0.s(o.getForumId(), o, true);
        } else {
            a0.x(o.getTopicId(), null);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            FileHelper.deleteFileOrDir(new File(c.a.t0.k4.c.f19295f));
            a0.u("");
        }
    }

    public void h(boolean z, PostWriteCallBackData postWriteCallBackData, m0 m0Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) {
            if (writeData != null && writeData.isWork() && this.f25761c == null) {
                this.f25768j.callback(z, postWriteCallBackData, m0Var, writeData, antiData);
            } else {
                callback(z, postWriteCallBackData, m0Var, writeData, antiData);
            }
        }
    }

    public BdUniqueId i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f25761c : (BdUniqueId) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f25763e : (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f25765g : (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f25766h : (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f25767i : (String) invokeV.objValue;
    }

    public WriteData o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.getWriteData = ");
            sb.append(this.a.Z() == null ? StringUtil.NULL_STRING : this.a.Z().toDraftString());
            h.a(sb.toString());
            return this.a.Z();
        }
        return (WriteData) invokeV.objValue;
    }

    public void p(@NonNull TbPageContextSupport tbPageContextSupport) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, tbPageContextSupport) == null) {
            h.a("AsyncWriteHelper.initWriteStatus()");
            this.a.m0(tbPageContextSupport.getPageContext());
            this.a.setWriteData(null);
            this.a.g0(false);
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f25760b : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f25762d : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f25764f == 8 : invokeV.booleanValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            h.a("AsyncWriteHelper.onWriteActClose()");
            this.a.m0(null);
            this.a.setSpanGroupManager(null);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            NewWriteModel newWriteModel = this.a;
            if (newWriteModel != null) {
                newWriteModel.setWriteData(null);
            }
            this.f25760b = false;
        }
    }

    public final void v(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, postWriteCallBackData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
        }
    }

    public void w(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bdUniqueId) == null) {
            this.f25761c = bdUniqueId;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.f25763e = str;
        }
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.f25764f = i2;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.f25762d = z;
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
        this.f25760b = false;
        this.f25761c = null;
        this.f25768j = new a(this);
        NewWriteModel newWriteModel = new NewWriteModel();
        this.a = newWriteModel;
        newWriteModel.l0(this);
    }
}
