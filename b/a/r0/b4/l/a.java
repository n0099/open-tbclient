package b.a.r0.b4.l;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.e.e.g.d;
import b.a.r0.b4.f;
import b.a.r0.b4.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f15029a;

    /* renamed from: b  reason: collision with root package name */
    public String f15030b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.e.e.g.c f15031c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f15032d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.e.e.g.b f15033e;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f15034f;

    /* renamed from: g  reason: collision with root package name */
    public final Activity f15035g;

    /* renamed from: h  reason: collision with root package name */
    public final ViewGroup f15036h;

    /* renamed from: b.a.r0.b4.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0757a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15037e;

        public RunnableC0757a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15037e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15037e.f15031c == null) {
                return;
            }
            this.f15037e.f15031c.e(this.f15037e.f15036h);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f15038a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15038a = aVar;
        }

        @Override // b.a.e.e.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15038a.f15031c = null;
                this.f15038a.f15034f.removeCallbacks(this.f15038a.f15032d);
            }
        }

        @Override // b.a.e.e.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements b.a.e.e.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f15039a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15039a = aVar;
        }

        @Override // b.a.e.e.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // b.a.e.e.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // b.a.e.e.g.b
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = LayoutInflater.from(this.f15039a.f15035g).inflate(g.warning_toast, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(f.toast_title);
                TextView textView2 = (TextView) inflate.findViewById(f.toast_tip);
                SkinManager.setViewTextColor(textView, b.a.r0.b4.c.CAM_X0101);
                SkinManager.setViewTextColor(textView2, b.a.r0.b4.c.CAM_X0101);
                ((ImageView) inflate.findViewById(f.toast_img)).setImageDrawable(WebPManager.getPureDrawable(b.a.r0.b4.e.icon_pure_toast_mistake_40, SkinManager.getColor(b.a.r0.b4.c.CAM_X0101), null));
                textView.setText(this.f15039a.f15029a);
                if (!StringUtils.isNull(this.f15039a.f15030b)) {
                    textView2.setText(this.f15039a.f15030b);
                } else {
                    textView2.setVisibility(8);
                }
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // b.a.e.e.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // b.a.e.e.g.b
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    public a(Activity activity, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15034f = new Handler();
        this.f15035g = activity;
        this.f15036h = viewGroup;
    }

    public final b.a.e.e.g.b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c(this) : (b.a.e.e.g.b) invokeV.objValue;
    }

    public void j() {
        b.a.e.e.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.f15031c) == null) {
            return;
        }
        cVar.e(this.f15036h);
        this.f15036h.setVisibility(8);
    }

    public a k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f15029a = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public void l() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (viewGroup = this.f15036h) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        b.a.e.e.g.c cVar = this.f15031c;
        if (cVar != null) {
            cVar.e(this.f15036h);
        }
        this.f15032d = new RunnableC0757a(this);
        b.a.e.e.g.d dVar = new b.a.e.e.g.d();
        dVar.d(true);
        dVar.g(new b(this));
        if (this.f15033e == null) {
            this.f15033e = i();
        }
        dVar.a(this.f15033e);
        b.a.e.e.g.c b2 = dVar.b();
        this.f15031c = b2;
        b2.q(this.f15035g, this.f15036h, false);
        this.f15034f.postDelayed(this.f15032d, 3000L);
    }
}
