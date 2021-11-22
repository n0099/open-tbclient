package b.a.q0.y;

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
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static d m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f15080a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f15081b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f15082c;

    /* renamed from: d  reason: collision with root package name */
    public View f15083d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.q0.y.c f15084e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15085f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f15086g;

    /* renamed from: h  reason: collision with root package name */
    public int f15087h;

    /* renamed from: i  reason: collision with root package name */
    public int f15088i;
    public CustomMessageListener j;
    public CustomMessageListener k;
    public CustomMessageListener l;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f15089a;

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
            this.f15089a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    this.f15089a.f15085f = true;
                    if (this.f15089a.f15080a != null) {
                        d dVar = this.f15089a;
                        dVar.f15081b = dVar.f15080a;
                    }
                    this.f15089a.i(true);
                    return;
                }
                this.f15089a.f15085f = false;
                if (this.f15089a.f15081b != null) {
                    d dVar2 = this.f15089a;
                    dVar2.f15080a = dVar2.f15081b;
                    this.f15089a.f15081b = null;
                    if (b.a.e.a.b.g().j(this.f15089a.f15080a) != -1) {
                        this.f15089a.j();
                        this.f15089a.o(false);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f15090a;

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
            this.f15090a = dVar;
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
            if ("BarBroadcastEdit".equals((String) map.get("name"))) {
                if (("0".equals(str) || "1".equals(str)) && (this.f15090a.f15084e instanceof b.a.q0.y.a)) {
                    this.f15090a.i(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f15091a;

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
            this.f15091a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001304 || !(customResponsedMessage.getData() instanceof Integer) || this.f15091a.f15083d == null || this.f15091a.f15084e == null) {
                return;
            }
            this.f15091a.f15084e.changeSkin();
        }
    }

    /* renamed from: b.a.q0.y.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC0754d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15092e;

        public View$OnClickListenerC0754d(d dVar) {
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
            this.f15092e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int j;
            int h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f15092e.f15080a != null && (j = b.a.e.a.b.g().j(this.f15092e.f15080a)) != -1 && j < b.a.e.a.b.g().h() && (h2 = b.a.e.a.b.g().h() - j) >= 0) {
                    b.a.e.a.b.g().n(h2);
                }
                if (this.f15092e.f15084e != null) {
                    this.f15092e.f15084e.onClick();
                }
                this.f15092e.i(false);
            }
        }
    }

    /* loaded from: classes4.dex */
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(274819830, "Lb/a/q0/y/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(274819830, "Lb/a/q0/y/d;");
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
        this.f15087h = 85;
        this.f15088i = 0;
        this.j = new a(this, 2001011);
        this.k = new b(this, 2921478);
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
            if (this.f15082c == null) {
                this.f15082c = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
            }
            View view = this.f15083d;
            if (view == null || view.getParent() == null) {
                return;
            }
            try {
                if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                    if (this.f15082c != null && this.f15083d != null) {
                        this.f15082c.removeView(this.f15083d);
                    }
                    this.f15082c = null;
                    this.f15083d = null;
                    return;
                }
                this.f15082c.removeView(this.f15083d);
                this.f15083d = null;
                this.f15082c = null;
                if (z || this.f15085f) {
                    return;
                }
                this.f15086g = new e(this);
                b.a.e.f.m.e.a().postDelayed(this.f15086g, 300L);
            } catch (SecurityException unused) {
                this.f15082c = null;
                this.f15083d = null;
            }
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.a.q0.y.c cVar = this.f15084e;
            if (cVar == null) {
                return false;
            }
            View view = this.f15083d;
            if (view != null) {
                return view.getParent() == null;
            }
            View view2 = cVar.getView();
            this.f15083d = view2;
            view2.setOnClickListener(new View$OnClickListenerC0754d(this));
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        View view;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.f15082c == null || (view = this.f15083d) == null || view.getParent() == null) ? false : true : invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            i(false);
            this.f15081b = null;
            this.f15080a = null;
            this.f15084e = null;
            this.f15083d = null;
            m = null;
            if (this.f15086g != null) {
                b.a.e.f.m.e.a().removeCallbacks(this.f15086g);
            }
        }
    }

    public void m(b.a.q0.y.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f15084e = cVar;
        }
    }

    public void n(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048581, this, i2, i3, i4) == null) {
            this.f15087h = i2;
            this.f15088i = i3;
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = b.a.r0.y3.d.a(2002);
            layoutParams.flags = 65800;
            layoutParams.format = -3;
            int i2 = this.f15088i;
            layoutParams.x = i2;
            layoutParams.y = i2;
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = this.f15087h;
            if (this.f15082c == null) {
                this.f15082c = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
            }
            try {
                if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                    this.f15082c = null;
                    this.f15083d = null;
                } else if (j()) {
                    if (this.f15083d != null && this.f15083d.getParent() == null) {
                        this.f15082c.addView(this.f15083d, layoutParams);
                        if (z) {
                            this.f15080a = b.a.e.a.b.g().b();
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    MessageManager.getInstance().registerListener(this.j);
                    MessageManager.getInstance().registerListener(this.l);
                    MessageManager.getInstance().registerListener(this.k);
                }
            } catch (SecurityException unused) {
                this.f15082c = null;
                this.f15083d = null;
            }
        }
    }
}
