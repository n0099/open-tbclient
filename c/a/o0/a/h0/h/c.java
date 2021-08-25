package c.a.o0.a.h0.h;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final FrameLayout.LayoutParams f5967f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f5968a;

    /* renamed from: b  reason: collision with root package name */
    public View f5969b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f5970c;

    /* renamed from: d  reason: collision with root package name */
    public int f5971d;

    /* renamed from: e  reason: collision with root package name */
    public a f5972e;

    /* loaded from: classes.dex */
    public interface a {
        void onCustomViewHidden();
    }

    /* loaded from: classes.dex */
    public static class b extends FrameLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            setBackgroundColor(context.getResources().getColor(17170444));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(957815792, "Lc/a/o0/a/h0/h/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(957815792, "Lc/a/o0/a/h0/h/c;");
                return;
            }
        }
        f5967f = new FrameLayout.LayoutParams(-1, -1);
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5968a = context;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f5969b == null) {
            return;
        }
        Context context = this.f5968a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            b(activity, false);
            ((FrameLayout) activity.getWindow().getDecorView()).removeView(this.f5970c);
            this.f5970c = null;
            this.f5969b = null;
            this.f5972e.onCustomViewHidden();
            activity.setRequestedOrientation(this.f5971d);
        }
    }

    public void b(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, z) == null) {
            activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
        }
    }

    public void c(View view, int i2, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, view, i2, aVar) == null) {
            Context context = this.f5968a;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                if (this.f5969b != null) {
                    aVar.onCustomViewHidden();
                    return;
                }
                this.f5971d = activity.getRequestedOrientation();
                b bVar = new b(activity);
                this.f5970c = bVar;
                bVar.addView(view, f5967f);
                ((FrameLayout) activity.getWindow().getDecorView()).addView(this.f5970c, f5967f);
                this.f5969b = view;
                b(activity, true);
                this.f5972e = aVar;
                activity.setRequestedOrientation(i2);
            }
        }
    }
}
