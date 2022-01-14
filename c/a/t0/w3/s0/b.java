package c.a.t0.w3.s0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.s0.s.q.l1;
import c.a.s0.t.c.n0;
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
public class b implements NewWriteModel.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NewWriteModel a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f25003b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f25004c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f25005d;

    /* renamed from: e  reason: collision with root package name */
    public String f25006e;

    /* renamed from: f  reason: collision with root package name */
    public int f25007f;

    /* renamed from: g  reason: collision with root package name */
    public String f25008g;

    /* renamed from: h  reason: collision with root package name */
    public String f25009h;

    /* renamed from: i  reason: collision with root package name */
    public String f25010i;

    /* renamed from: j  reason: collision with root package name */
    public NewWriteModel.g f25011j;

    /* loaded from: classes8.dex */
    public class a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* renamed from: c.a.t0.w3.s0.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1507a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ WriteData f25012e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f25013f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f25014g;

            public RunnableC1507a(a aVar, WriteData writeData, PostWriteCallBackData postWriteCallBackData) {
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
                this.f25014g = aVar;
                this.f25012e = writeData;
                this.f25013f = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    l1.g(this.f25012e, 100).f(false);
                    if ((!m.isEmpty(this.f25013f.getVideoid()) && this.f25012e.getVideoInfo() != null) || (this.f25012e.getVideoInfo() != null && this.f25012e.getVideoInfo().hasUpload())) {
                        d.n(this.f25013f);
                    } else {
                        d.m(this.f25013f);
                    }
                    this.f25014g.a.f();
                    this.f25014g.a.g();
                    if (!m.isEmpty(this.f25013f.getVideoid()) && this.f25012e.getVideoInfo() != null) {
                        this.f25013f.mVideoMd5 = this.f25012e.getVideoInfo().getVideoMd5();
                        if (!m.isEmpty(this.f25012e.getForumName())) {
                            this.f25013f.mFrom = 2;
                        }
                    }
                    this.f25014g.a.u();
                }
            }
        }

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, n0 n0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, n0Var, writeData, antiData}) == null) || writeData == null) {
                return;
            }
            if (z) {
                WorkPostNotifyFlutterData f2 = WorkPostNotifyFlutterData.f(postWriteCallBackData.getVideoid());
                f2.j(writeData.getForumId());
                f2.k(writeData.getForumName());
                f2.l(writeData);
                f2.i(this.a.j());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, f2));
                int l = c.a.s0.s.h0.b.k().l("key_video_works_progress_bar_waiting_time", 3);
                c.a.d.f.m.e.a().postDelayed(new RunnableC1507a(this, writeData, postWriteCallBackData), ((l > 0 ? l : 3) + 1) * 1000);
                b.k().w(null);
                this.a.u();
            } else if (c.a.s0.f1.a.d(postWriteCallBackData, n0Var, writeData, antiData)) {
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, WorkPostNotifyFlutterData.e(postWriteCallBackData.getErrorString())));
                d.l(postWriteCallBackData, n0Var, writeData, antiData);
                b.k().w(null);
                this.a.u();
            }
        }
    }

    /* renamed from: c.a.t0.w3.s0.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1508b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PostWriteCallBackData f25015e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ WriteData f25016f;

        public RunnableC1508b(b bVar, PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, postWriteCallBackData, writeData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25015e = postWriteCallBackData;
            this.f25016f = writeData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if ((!m.isEmpty(this.f25015e.getVideoid()) && this.f25016f.getVideoInfo() != null) || (this.f25016f.getVideoInfo() != null && this.f25016f.getVideoInfo().hasUpload())) {
                    d.n(this.f25015e);
                } else {
                    d.m(this.f25015e);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1752997882, "Lc/a/t0/w3/s0/b$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1752997882, "Lc/a/t0/w3/s0/b$c;");
                    return;
                }
            }
            a = new b(null);
        }
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            c.a.t0.w3.s0.c.a("AsyncWriteHelper.getInstance()");
            return c.a;
        }
        return (b) invokeV.objValue;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            c.a.t0.w3.s0.c.a("AsyncWriteHelper.setHasImage = " + z);
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
            this.f25008g = str;
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f25009h = str;
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f25010i = str;
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
            c.a.t0.w3.s0.c.a("AsyncWriteHelper.setSpanGroupManager()");
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
            c.a.t0.w3.s0.c.a(sb.toString());
            this.a.setWriteData(writeData);
            if (writeData != null && writeData.isWork() && this.f25004c == null) {
                this.a.l0(this.f25011j);
            } else {
                this.a.l0(this);
            }
        }
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c.a.t0.w3.s0.c.a("AsyncWriteHelper.startPostWrite()");
            this.a.a0();
            boolean n0 = this.a.n0();
            this.f25003b = n0;
            return n0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, n0 n0Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, n0Var, writeData, antiData}) == null) || writeData == null) {
            return;
        }
        if (z) {
            l1.g(writeData, 100).f(true);
            c.a.d.f.m.e.a().postDelayed(new RunnableC1508b(this, postWriteCallBackData, writeData), 200L);
            f();
            g();
            v(postWriteCallBackData);
            if (!m.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) {
                postWriteCallBackData.mVideoMd5 = writeData.getVideoInfo().getVideoMd5();
                if (!m.isEmpty(writeData.getForumName())) {
                    postWriteCallBackData.mFrom = 2;
                }
            }
            l1.g(writeData, 100).f(false);
            k().w(null);
            u();
        } else if (c.a.s0.f1.a.d(postWriteCallBackData, n0Var, writeData, antiData)) {
        } else {
            l1.g(writeData, 100).f(false);
            d.l(postWriteCallBackData, n0Var, writeData, antiData);
            k().w(null);
            u();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.t0.w3.s0.c.a("AsyncWriteHelper.cancelLoadData()");
            this.a.cancelLoadData();
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            c.a.t0.w3.s0.c.a("AsyncWriteHelper.checkImageNum = " + this.a.W());
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
                a0.y(o.getThreadId(), null);
            }
        } else if (o.isLocalChannelDynamic()) {
            a0.v(null);
        } else if (o.isEvaluate()) {
            a0.s(o.getItem_id(), null);
        } else if (TextUtils.isEmpty(o.getTopicId())) {
            a0.u(o.getForumId(), o, true);
        } else {
            a0.A(o.getTopicId(), null);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            FileHelper.deleteFileOrDir(new File(c.a.t0.k4.c.f18799f));
            a0.x("");
        }
    }

    public void h(boolean z, PostWriteCallBackData postWriteCallBackData, n0 n0Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, n0Var, writeData, antiData}) == null) {
            if (writeData != null && writeData.isWork() && this.f25004c == null) {
                this.f25011j.callback(z, postWriteCallBackData, n0Var, writeData, antiData);
            } else {
                callback(z, postWriteCallBackData, n0Var, writeData, antiData);
            }
        }
    }

    public BdUniqueId i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f25004c : (BdUniqueId) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f25006e : (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f25008g : (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f25009h : (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f25010i : (String) invokeV.objValue;
    }

    public WriteData o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.getWriteData = ");
            sb.append(this.a.Z() == null ? StringUtil.NULL_STRING : this.a.Z().toDraftString());
            c.a.t0.w3.s0.c.a(sb.toString());
            return this.a.Z();
        }
        return (WriteData) invokeV.objValue;
    }

    public void p(@NonNull TbPageContextSupport tbPageContextSupport) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, tbPageContextSupport) == null) {
            c.a.t0.w3.s0.c.a("AsyncWriteHelper.initWriteStatus()");
            this.a.m0(tbPageContextSupport.getPageContext());
            this.a.setWriteData(null);
            this.a.g0(false);
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f25003b : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f25005d : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f25007f == 8 : invokeV.booleanValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            c.a.t0.w3.s0.c.a("AsyncWriteHelper.onWriteActClose()");
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
            this.f25003b = false;
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
            this.f25004c = bdUniqueId;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.f25006e = str;
        }
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.f25007f = i2;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.f25005d = z;
        }
    }

    public b() {
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
        this.f25003b = false;
        this.f25004c = null;
        this.f25011j = new a(this);
        NewWriteModel newWriteModel = new NewWriteModel();
        this.a = newWriteModel;
        newWriteModel.l0(this);
    }
}
