package c.a.q0.y;

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
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static d m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f15224a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f15225b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f15226c;

    /* renamed from: d  reason: collision with root package name */
    public View f15227d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.y.c f15228e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15229f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f15230g;

    /* renamed from: h  reason: collision with root package name */
    public int f15231h;

    /* renamed from: i  reason: collision with root package name */
    public int f15232i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f15233j;
    public CustomMessageListener k;
    public CustomMessageListener l;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f15234a;

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
            this.f15234a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    this.f15234a.f15229f = true;
                    if (this.f15234a.f15224a != null) {
                        d dVar = this.f15234a;
                        dVar.f15225b = dVar.f15224a;
                    }
                    this.f15234a.i(true);
                    return;
                }
                this.f15234a.f15229f = false;
                if (this.f15234a.f15225b != null) {
                    d dVar2 = this.f15234a;
                    dVar2.f15224a = dVar2.f15225b;
                    this.f15234a.f15225b = null;
                    if (c.a.e.a.b.g().j(this.f15234a.f15224a) != -1) {
                        this.f15234a.j();
                        this.f15234a.o(false);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f15235a;

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
            this.f15235a = dVar;
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
                if (("0".equals(str) || "1".equals(str)) && (this.f15235a.f15228e instanceof c.a.q0.y.a)) {
                    this.f15235a.i(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f15236a;

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
            this.f15236a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001304 || !(customResponsedMessage.getData() instanceof Integer) || this.f15236a.f15227d == null || this.f15236a.f15228e == null) {
                return;
            }
            this.f15236a.f15228e.changeSkin();
        }
    }

    /* renamed from: c.a.q0.y.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0721d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15237e;

        public View$OnClickListenerC0721d(d dVar) {
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
            this.f15237e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int j2;
            int h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f15237e.f15224a != null && (j2 = c.a.e.a.b.g().j(this.f15237e.f15224a)) != -1 && j2 < c.a.e.a.b.g().h() && (h2 = c.a.e.a.b.g().h() - j2) >= 0) {
                    c.a.e.a.b.g().n(h2);
                }
                if (this.f15237e.f15228e != null) {
                    this.f15237e.f15228e.onClick();
                }
                this.f15237e.i(false);
            }
        }
    }

    /* loaded from: classes3.dex */
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1522131529, "Lc/a/q0/y/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1522131529, "Lc/a/q0/y/d;");
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
        this.f15231h = 85;
        this.f15232i = 0;
        this.f15233j = new a(this, 2001011);
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
            if (this.f15226c == null) {
                this.f15226c = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
            }
            View view = this.f15227d;
            if (view == null || view.getParent() == null) {
                return;
            }
            try {
                if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                    if (this.f15226c != null && this.f15227d != null) {
                        this.f15226c.removeView(this.f15227d);
                    }
                    this.f15226c = null;
                    this.f15227d = null;
                    return;
                }
                this.f15226c.removeView(this.f15227d);
                this.f15227d = null;
                this.f15226c = null;
                if (z || this.f15229f) {
                    return;
                }
                this.f15230g = new e(this);
                c.a.e.e.m.e.a().postDelayed(this.f15230g, 300L);
            } catch (SecurityException unused) {
                this.f15226c = null;
                this.f15227d = null;
            }
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.q0.y.c cVar = this.f15228e;
            if (cVar == null) {
                return false;
            }
            View view = this.f15227d;
            if (view != null) {
                return view.getParent() == null;
            }
            View view2 = cVar.getView();
            this.f15227d = view2;
            view2.setOnClickListener(new View$OnClickListenerC0721d(this));
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        View view;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.f15226c == null || (view = this.f15227d) == null || view.getParent() == null) ? false : true : invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            i(false);
            this.f15225b = null;
            this.f15224a = null;
            this.f15228e = null;
            this.f15227d = null;
            m = null;
            if (this.f15230g != null) {
                c.a.e.e.m.e.a().removeCallbacks(this.f15230g);
            }
        }
    }

    public void m(c.a.q0.y.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f15228e = cVar;
        }
    }

    public void n(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048581, this, i2, i3, i4) == null) {
            this.f15231h = i2;
            this.f15232i = i3;
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = c.a.r0.w3.c.a(2002);
            layoutParams.flags = 65800;
            layoutParams.format = -3;
            int i2 = this.f15232i;
            layoutParams.x = i2;
            layoutParams.y = i2;
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = this.f15231h;
            if (this.f15226c == null) {
                this.f15226c = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
            }
            try {
                if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                    this.f15226c = null;
                    this.f15227d = null;
                } else if (j()) {
                    if (this.f15227d != null && this.f15227d.getParent() == null) {
                        this.f15226c.addView(this.f15227d, layoutParams);
                        if (z) {
                            this.f15224a = c.a.e.a.b.g().b();
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    MessageManager.getInstance().registerListener(this.f15233j);
                    MessageManager.getInstance().registerListener(this.l);
                    MessageManager.getInstance().registerListener(this.k);
                }
            } catch (SecurityException unused) {
                this.f15226c = null;
                this.f15227d = null;
            }
        }
    }
}
