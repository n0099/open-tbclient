package c.a.s0.y;

import android.app.Activity;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static d m;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f14623b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f14624c;

    /* renamed from: d  reason: collision with root package name */
    public View f14625d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.y.c f14626e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14627f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f14628g;

    /* renamed from: h  reason: collision with root package name */
    public int f14629h;

    /* renamed from: i  reason: collision with root package name */
    public int f14630i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f14631j;

    /* renamed from: k  reason: collision with root package name */
    public CustomMessageListener f14632k;
    public CustomMessageListener l;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2) {
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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    this.a.f14627f = true;
                    if (this.a.a != null) {
                        d dVar = this.a;
                        dVar.f14623b = dVar.a;
                    }
                    this.a.i(true);
                    return;
                }
                this.a.f14627f = false;
                if (this.a.f14623b != null) {
                    d dVar2 = this.a;
                    dVar2.a = dVar2.f14623b;
                    this.a.f14623b = null;
                    if (c.a.d.a.b.g().j(this.a.a) != -1) {
                        this.a.j();
                        this.a.o(false);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Map map;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || (map = (Map) customResponsedMessage.getData()) == null) {
                return;
            }
            String str = (String) map.get("lifeCycle");
            if ("BarBroadcastEditPage".equals((String) map.get("name"))) {
                if (("0".equals(str) || "1".equals(str)) && (this.a.f14626e instanceof c.a.s0.y.a)) {
                    this.a.i(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d dVar, int i2) {
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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001304 || !(customResponsedMessage.getData() instanceof Integer) || this.a.f14625d == null || this.a.f14626e == null) {
                return;
            }
            this.a.f14626e.changeSkin();
        }
    }

    /* renamed from: c.a.s0.y.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0897d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f14633e;

        public View$OnClickListenerC0897d(d dVar) {
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
            this.f14633e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int j2;
            int h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f14633e.a != null && (j2 = c.a.d.a.b.g().j(this.f14633e.a)) != -1 && j2 < c.a.d.a.b.g().h() && (h2 = c.a.d.a.b.g().h() - j2) >= 0) {
                    c.a.d.a.b.g().n(h2);
                }
                if (this.f14633e.f14626e != null) {
                    this.f14633e.f14626e.onClick();
                }
                this.f14633e.i(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(d dVar) {
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
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 1));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(252875833, "Lc/a/s0/y/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(252875833, "Lc/a/s0/y/d;");
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f14629h = 85;
        this.f14630i = 0;
        this.f14631j = new a(this, 2001011);
        this.f14632k = new b(this, 2921478);
        this.l = new c(this, 2001304);
    }

    public static d h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (m == null) {
                m = new d();
            }
            return m;
        }
        return (d) invokeV.objValue;
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (this.f14624c == null) {
                this.f14624c = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
            }
            View view = this.f14625d;
            if (view == null || view.getParent() == null) {
                return;
            }
            try {
                if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                    if (this.f14624c != null && this.f14625d != null) {
                        this.f14624c.removeView(this.f14625d);
                    }
                    this.f14624c = null;
                    this.f14625d = null;
                    return;
                }
                this.f14624c.removeView(this.f14625d);
                this.f14625d = null;
                this.f14624c = null;
                if (z || this.f14627f) {
                    return;
                }
                this.f14628g = new e(this);
                c.a.d.f.m.e.a().postDelayed(this.f14628g, 300L);
            } catch (SecurityException unused) {
                this.f14624c = null;
                this.f14625d = null;
            }
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.s0.y.c cVar = this.f14626e;
            if (cVar == null) {
                return false;
            }
            View view = this.f14625d;
            if (view != null) {
                return view.getParent() == null;
            }
            View view2 = cVar.getView();
            this.f14625d = view2;
            view2.setOnClickListener(new View$OnClickListenerC0897d(this));
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        View view;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.f14624c == null || (view = this.f14625d) == null || view.getParent() == null) ? false : true : invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            i(false);
            this.f14623b = null;
            this.a = null;
            this.f14626e = null;
            this.f14625d = null;
            m = null;
            if (this.f14628g != null) {
                c.a.d.f.m.e.a().removeCallbacks(this.f14628g);
            }
        }
    }

    public void m(c.a.s0.y.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f14626e = cVar;
        }
    }

    public void n(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048581, this, i2, i3, i4) == null) {
            this.f14629h = i2;
            this.f14630i = i3;
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = c.a.t0.i4.d.a(2002);
            layoutParams.flags = 65800;
            layoutParams.format = -3;
            int i2 = this.f14630i;
            layoutParams.x = i2;
            layoutParams.y = i2;
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = this.f14629h;
            if (this.f14624c == null) {
                this.f14624c = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
            }
            try {
                if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                    this.f14624c = null;
                    this.f14625d = null;
                } else if (j()) {
                    if (this.f14625d != null && this.f14625d.getParent() == null) {
                        this.f14624c.addView(this.f14625d, layoutParams);
                        if (z) {
                            this.a = c.a.d.a.b.g().b();
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    MessageManager.getInstance().registerListener(this.f14631j);
                    MessageManager.getInstance().registerListener(this.l);
                    MessageManager.getInstance().registerListener(this.f14632k);
                }
            } catch (SecurityException unused) {
                this.f14624c = null;
                this.f14625d = null;
            }
        }
    }
}
