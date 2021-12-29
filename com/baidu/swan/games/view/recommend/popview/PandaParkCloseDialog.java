package com.baidu.swan.games.view.recommend.popview;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import c.a.r0.h.f;
import c.a.r0.h.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/baidu/swan/games/view/recommend/popview/PandaParkCloseDialog;", "Landroid/app/Dialog;", "Landroid/view/View$OnTouchListener;", "alphaChange", "()Landroid/view/View$OnTouchListener;", "", "init", "()V", "initClickListener", "Lcom/baidu/swan/games/view/recommend/popview/PandaParkCloseDialog$IOnClickListener;", "onClickListener", "setOnClickListener", "(Lcom/baidu/swan/games/view/recommend/popview/PandaParkCloseDialog$IOnClickListener;)V", "mOnClickListener", "Lcom/baidu/swan/games/view/recommend/popview/PandaParkCloseDialog$IOnClickListener;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "IOnClickListener", "common_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes11.dex */
public final class PandaParkCloseDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f41247e;

    /* loaded from: classes11.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    /* loaded from: classes11.dex */
    public static final class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final b f41248e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(591477865, "Lcom/baidu/swan/games/view/recommend/popview/PandaParkCloseDialog$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(591477865, "Lcom/baidu/swan/games/view/recommend/popview/PandaParkCloseDialog$b;");
                    return;
                }
            }
            f41248e = new b();
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View v, MotionEvent event) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, v, event)) == null) {
                Intrinsics.checkNotNullExpressionValue(event, "event");
                int action = event.getAction();
                if (action == 0) {
                    Intrinsics.checkNotNullExpressionValue(v, "v");
                    v.setAlpha(0.2f);
                    return false;
                } else if (action == 1 || action == 3) {
                    Intrinsics.checkNotNullExpressionValue(v, "v");
                    v.setAlpha(1.0f);
                    return false;
                } else {
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public static final class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PandaParkCloseDialog f41249e;

        public c(PandaParkCloseDialog pandaParkCloseDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pandaParkCloseDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41249e = pandaParkCloseDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f41249e.f41247e) == null) {
                return;
            }
            aVar.c();
        }
    }

    /* loaded from: classes11.dex */
    public static final class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PandaParkCloseDialog f41250e;

        public d(PandaParkCloseDialog pandaParkCloseDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pandaParkCloseDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41250e = pandaParkCloseDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f41250e.f41247e) == null) {
                return;
            }
            aVar.b();
        }
    }

    /* loaded from: classes11.dex */
    public static final class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PandaParkCloseDialog f41251e;

        public e(PandaParkCloseDialog pandaParkCloseDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pandaParkCloseDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41251e = pandaParkCloseDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f41251e.f41247e) == null) {
                return;
            }
            aVar.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PandaParkCloseDialog(Context context) {
        super(context, h.SwanGameNoTitleDialog);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        b();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final View.OnTouchListener a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b.f41248e : (View.OnTouchListener) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setContentView(f.aiapps_pandapark_close_dialog);
            setCanceledOnTouchOutside(false);
            c();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ((Button) findViewById(c.a.r0.h.e.exit_button)).setOnTouchListener(a());
            ((Button) findViewById(c.a.r0.h.e.exit_button)).setOnClickListener(new c(this));
            ((ImageView) findViewById(c.a.r0.h.e.image_close)).setOnTouchListener(a());
            ((ImageView) findViewById(c.a.r0.h.e.image_close)).setOnClickListener(new d(this));
            ((Button) findViewById(c.a.r0.h.e.continue_button)).setOnTouchListener(a());
            ((Button) findViewById(c.a.r0.h.e.continue_button)).setOnClickListener(new e(this));
        }
    }

    public final void setOnClickListener(a onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
            this.f41247e = onClickListener;
        }
    }
}
