package c.a.r0.j3.r0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.l1;
import c.a.q0.s.q.o2;
import c.a.q0.t.c.k0;
import c.a.r0.j3.y;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
    public final NewWriteModel f21090a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f21091b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f21092c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f21093d;

    /* renamed from: e  reason: collision with root package name */
    public String f21094e;

    /* renamed from: f  reason: collision with root package name */
    public String f21095f;

    /* renamed from: g  reason: collision with root package name */
    public String f21096g;

    /* renamed from: h  reason: collision with root package name */
    public String f21097h;

    /* renamed from: i  reason: collision with root package name */
    public NewWriteModel.g f21098i;

    /* loaded from: classes3.dex */
    public class a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f21099a;

        /* renamed from: c.a.r0.j3.r0.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0990a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f21100e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ WriteData f21101f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f21102g;

            public RunnableC0990a(a aVar, PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
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
                this.f21102g = aVar;
                this.f21100e = postWriteCallBackData;
                this.f21101f = writeData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if ((!c.a.e.e.p.k.isEmpty(this.f21100e.getVideoid()) && this.f21101f.getVideoInfo() != null) || (this.f21101f.getVideoInfo() != null && this.f21101f.getVideoInfo().hasUpload())) {
                        i.n(this.f21100e);
                    } else {
                        i.m(this.f21100e);
                    }
                    this.f21102g.f21099a.f();
                    this.f21102g.f21099a.g();
                    if (!c.a.e.e.p.k.isEmpty(this.f21100e.getVideoid()) && this.f21101f.getVideoInfo() != null) {
                        this.f21100e.mVideoMd5 = this.f21101f.getVideoInfo().getVideoMd5();
                        if (!c.a.e.e.p.k.isEmpty(this.f21101f.getForumName())) {
                            this.f21100e.mFrom = 2;
                        }
                    }
                    this.f21102g.f21099a.s();
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
            this.f21099a = gVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, k0 k0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) || writeData == null) {
                return;
            }
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, o2.b(postWriteCallBackData.getVideoid())));
                int k = c.a.q0.s.d0.b.j().k("key_video_works_progress_bar_waiting_time", 3);
                c.a.e.e.m.e.a().postDelayed(new RunnableC0990a(this, postWriteCallBackData, writeData), ((k > 0 ? k : 3) + 1) * 1000);
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, o2.a(postWriteCallBackData.getErrorString())));
            i.l(postWriteCallBackData, k0Var, writeData, antiData);
            this.f21099a.s();
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final g f21103a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(501128940, "Lc/a/r0/j3/r0/g$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(501128940, "Lc/a/r0/j3/r0/g$b;");
                    return;
                }
            }
            f21103a = new g(null);
        }
    }

    public /* synthetic */ g(a aVar) {
        this();
    }

    public static g i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            h.a("AsyncWriteHelper.getInstance()");
            return b.f21103a;
        }
        return (g) invokeV.objValue;
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f21094e = str;
        }
    }

    public void B(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, spanGroupManager) == null) {
            h.a("AsyncWriteHelper.setSpanGroupManager()");
            this.f21090a.Y();
            this.f21090a.setSpanGroupManager(spanGroupManager);
        }
    }

    public void C(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.setWriteData = ");
            sb.append(writeData == null ? StringUtil.NULL_STRING : writeData.toDraftString());
            h.a(sb.toString());
            this.f21090a.setWriteData(writeData);
            if (writeData != null && writeData.isWork() && this.f21092c == null) {
                this.f21090a.h0(this.f21098i);
            } else {
                this.f21090a.h0(this);
            }
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            h.a("AsyncWriteHelper.startPostWrite()");
            this.f21090a.Y();
            boolean j0 = this.f21090a.j0();
            this.f21091b = j0;
            return j0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, k0 k0Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) || writeData == null) {
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
            t(postWriteCallBackData);
            if (!c.a.e.e.p.k.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) {
                postWriteCallBackData.mVideoMd5 = writeData.getVideoInfo().getVideoMd5();
                if (!c.a.e.e.p.k.isEmpty(writeData.getForumName())) {
                    postWriteCallBackData.mFrom = 2;
                }
            }
            l1.h(writeData, 100).f(false);
        } else {
            l1.h(writeData, 100).f(false);
            i.l(postWriteCallBackData, k0Var, writeData, antiData);
        }
        NewWriteModel newWriteModel = this.f21090a;
        if (newWriteModel != null) {
            newWriteModel.setWriteData(null);
        }
        this.f21091b = false;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h.a("AsyncWriteHelper.cancelLoadData()");
            this.f21090a.cancelLoadData();
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            h.a("AsyncWriteHelper.checkImageNum = " + this.f21090a.U());
            return this.f21090a.U();
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        WriteData n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (n = n()) == null) {
            return;
        }
        if (n.getType() != 0 && n.getType() != 9 && n.getType() != 11) {
            if (n.getType() == 1) {
                y.s(n.getThreadId(), null);
            }
        } else if (n.isEvaluate()) {
            y.o(n.getItem_id(), null);
        } else if (TextUtils.isEmpty(n.getTopicId())) {
            y.q(n.getForumId(), n, true);
        } else {
            y.u(n.getTopicId(), null);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            FileHelper.deleteFileOrDir(new File(c.a.r0.x3.c.f28885f));
            y.r("");
        }
    }

    public BdUniqueId h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f21092c : (BdUniqueId) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f21095f : (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f21096g : (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f21097h : (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f21094e : (String) invokeV.objValue;
    }

    public WriteData n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.getWriteData = ");
            sb.append(this.f21090a.X() == null ? StringUtil.NULL_STRING : this.f21090a.X().toDraftString());
            h.a(sb.toString());
            return this.f21090a.X();
        }
        return (WriteData) invokeV.objValue;
    }

    public void o(@NonNull TbPageContextSupport tbPageContextSupport) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, tbPageContextSupport) == null) {
            h.a("AsyncWriteHelper.initWriteStatus()");
            this.f21090a.i0(tbPageContextSupport.getPageContext());
            this.f21090a.setWriteData(null);
            this.f21090a.d0(false);
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f21091b : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f21093d : invokeV.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            h.a("AsyncWriteHelper.onWriteActClose()");
            this.f21090a.i0(null);
            this.f21090a.setSpanGroupManager(null);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            NewWriteModel newWriteModel = this.f21090a;
            if (newWriteModel != null) {
                newWriteModel.setWriteData(null);
            }
            this.f21091b = false;
        }
    }

    public final void t(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, postWriteCallBackData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
        }
    }

    public void u(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bdUniqueId) == null) {
            this.f21092c = bdUniqueId;
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f21093d = z;
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            h.a("AsyncWriteHelper.setHasImage = " + z);
            this.f21090a.d0(z);
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.f21095f = str;
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.f21096g = str;
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.f21097h = str;
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
        this.f21091b = false;
        this.f21092c = null;
        this.f21098i = new a(this);
        NewWriteModel newWriteModel = new NewWriteModel();
        this.f21090a = newWriteModel;
        newWriteModel.h0(this);
    }
}
