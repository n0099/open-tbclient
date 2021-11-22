package b.a.r0.c4.l;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.e.f.g.d;
import b.a.r0.c4.f;
import b.a.r0.c4.g;
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
    public String f16657a;

    /* renamed from: b  reason: collision with root package name */
    public String f16658b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.e.f.g.c f16659c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f16660d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.e.f.g.b f16661e;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f16662f;

    /* renamed from: g  reason: collision with root package name */
    public final Activity f16663g;

    /* renamed from: h  reason: collision with root package name */
    public final ViewGroup f16664h;

    /* renamed from: b.a.r0.c4.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0831a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16665e;

        public RunnableC0831a(a aVar) {
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
            this.f16665e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16665e.f16659c == null) {
                return;
            }
            this.f16665e.f16659c.e(this.f16665e.f16664h);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f16666a;

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
            this.f16666a = aVar;
        }

        @Override // b.a.e.f.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16666a.f16659c = null;
                this.f16666a.f16662f.removeCallbacks(this.f16666a.f16660d);
            }
        }

        @Override // b.a.e.f.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements b.a.e.f.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f16667a;

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
            this.f16667a = aVar;
        }

        @Override // b.a.e.f.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // b.a.e.f.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // b.a.e.f.g.b
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = LayoutInflater.from(this.f16667a.f16663g).inflate(g.warning_toast, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(f.toast_title);
                TextView textView2 = (TextView) inflate.findViewById(f.toast_tip);
                SkinManager.setViewTextColor(textView, b.a.r0.c4.c.CAM_X0101);
                SkinManager.setViewTextColor(textView2, b.a.r0.c4.c.CAM_X0101);
                ((ImageView) inflate.findViewById(f.toast_img)).setImageDrawable(WebPManager.getPureDrawable(b.a.r0.c4.e.icon_pure_toast_mistake_40, SkinManager.getColor(b.a.r0.c4.c.CAM_X0101), null));
                textView.setText(this.f16667a.f16657a);
                if (!StringUtils.isNull(this.f16667a.f16658b)) {
                    textView2.setText(this.f16667a.f16658b);
                } else {
                    textView2.setVisibility(8);
                }
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // b.a.e.f.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // b.a.e.f.g.b
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
        this.f16662f = new Handler();
        this.f16663g = activity;
        this.f16664h = viewGroup;
    }

    public final b.a.e.f.g.b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c(this) : (b.a.e.f.g.b) invokeV.objValue;
    }

    public void j() {
        b.a.e.f.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.f16659c) == null) {
            return;
        }
        cVar.e(this.f16664h);
        this.f16664h.setVisibility(8);
    }

    public a k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f16657a = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public void l() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (viewGroup = this.f16664h) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        b.a.e.f.g.c cVar = this.f16659c;
        if (cVar != null) {
            cVar.e(this.f16664h);
        }
        this.f16660d = new RunnableC0831a(this);
        b.a.e.f.g.d dVar = new b.a.e.f.g.d();
        dVar.d(true);
        dVar.g(new b(this));
        if (this.f16661e == null) {
            this.f16661e = i();
        }
        dVar.a(this.f16661e);
        b.a.e.f.g.c b2 = dVar.b();
        this.f16659c = b2;
        b2.q(this.f16663g, this.f16664h, false);
        this.f16662f.postDelayed(this.f16660d, 3000L);
    }
}
