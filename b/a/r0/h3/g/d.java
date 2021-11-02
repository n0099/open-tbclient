package b.a.r0.h3.g;

import b.a.e.e.p.k;
import b.a.q0.t.c.n0;
import b.a.r0.h3.g.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f17784a;

    /* renamed from: b  reason: collision with root package name */
    public String f17785b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f17786c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f17787d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f17788e;

    /* loaded from: classes4.dex */
    public class a implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f17789a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17789a = dVar;
        }

        @Override // b.a.r0.h3.g.c.a
        public void a(boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
                this.f17789a.f17786c = false;
                if (z) {
                    this.f17789a.f17785b = str;
                    b.a.q0.s.e0.b.j().x("key_video_splash_path", this.f17789a.f17785b);
                    this.f17789a.f17784a = str2;
                    b.a.q0.s.e0.b.j().x("key_video_splash_url", this.f17789a.f17784a);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f17790a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17790a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            String p = b.a.q0.s.e0.b.j().p("key_video_splash_config", "");
            n0 n0Var = new n0();
            n0Var.g(p);
            this.f17790a.n(n0Var.f());
        }
    }

    public d() {
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
        this.f17786c = false;
        this.f17787d = new a(this);
        this.f17788e = new b(this, 2001371);
        j();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || k.isEmpty(h())) {
            return;
        }
        FileHelper.deleteFileOrDir(new File(h()));
        this.f17785b = null;
        b.a.q0.s.e0.b.j().x("key_video_splash_path", this.f17785b);
        this.f17784a = null;
        b.a.q0.s.e0.b.j().x("key_video_splash_url", this.f17784a);
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
        }
        return (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17785b : (String) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f17786c = false;
            this.f17784a = b.a.q0.s.e0.b.j().p("key_video_splash_url", null);
            this.f17785b = b.a.q0.s.e0.b.j().p("key_video_splash_path", null);
            MessageManager.getInstance().registerListener(this.f17788e);
        }
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? (k.isEmpty(str) || str.equals(this.f17784a)) ? false : true : invokeL.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f17786c || k.isEmpty(i())) {
                return false;
            }
            if (new File(i()).exists()) {
                return true;
            }
            this.f17785b = null;
            b.a.q0.s.e0.b.j().x("key_video_splash_path", this.f17785b);
            this.f17784a = null;
            b.a.q0.s.e0.b.j().x("key_video_splash_url", this.f17784a);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f17786c = true;
            new c(h(), str, this.f17787d).execute(new Void[0]);
        }
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if ((b.a.q0.s.e0.b.j().k("key_video_splash_switch", 0) == 1) && !this.f17786c && k(str)) {
                m(str);
            }
        }
    }
}
