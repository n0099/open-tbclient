package c.a.q0.z3;

import c.a.e.e.p.k;
import c.a.p0.t.c.l0;
import c.a.q0.z3.b;
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
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f29366a;

    /* renamed from: b  reason: collision with root package name */
    public String f29367b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29368c;

    /* renamed from: d  reason: collision with root package name */
    public b.a f29369d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f29370e;

    /* loaded from: classes4.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f29371a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29371a = cVar;
        }

        @Override // c.a.q0.z3.b.a
        public void a(boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
                this.f29371a.f29368c = false;
                if (z) {
                    this.f29371a.f29367b = str;
                    c.a.p0.s.d0.b.j().x("key_video_splash_path", this.f29371a.f29367b);
                    this.f29371a.f29366a = str2;
                    c.a.p0.s.d0.b.j().x("key_video_splash_url", this.f29371a.f29366a);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f29372a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.f29372a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            String p = c.a.p0.s.d0.b.j().p("key_video_splash_config", "");
            l0 l0Var = new l0();
            l0Var.g(p);
            this.f29372a.n(l0Var.f());
        }
    }

    public c() {
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
        this.f29368c = false;
        this.f29369d = new a(this);
        this.f29370e = new b(this, 2001371);
        j();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || k.isEmpty(h())) {
            return;
        }
        FileHelper.deleteFileOrDir(new File(h()));
        this.f29367b = null;
        c.a.p0.s.d0.b.j().x("key_video_splash_path", this.f29367b);
        this.f29366a = null;
        c.a.p0.s.d0.b.j().x("key_video_splash_url", this.f29366a);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29367b : (String) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f29368c = false;
            this.f29366a = c.a.p0.s.d0.b.j().p("key_video_splash_url", null);
            this.f29367b = c.a.p0.s.d0.b.j().p("key_video_splash_path", null);
            MessageManager.getInstance().registerListener(this.f29370e);
        }
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? (k.isEmpty(str) || str.equals(this.f29366a)) ? false : true : invokeL.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f29368c || k.isEmpty(i())) {
                return false;
            }
            if (new File(i()).exists()) {
                return true;
            }
            this.f29367b = null;
            c.a.p0.s.d0.b.j().x("key_video_splash_path", this.f29367b);
            this.f29366a = null;
            c.a.p0.s.d0.b.j().x("key_video_splash_url", this.f29366a);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f29368c = true;
            new c.a.q0.z3.b(h(), str, this.f29369d).execute(new Void[0]);
        }
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if ((c.a.p0.s.d0.b.j().k("key_video_splash_switch", 0) == 1) && !this.f29368c && k(str)) {
                m(str);
            }
        }
    }
}
