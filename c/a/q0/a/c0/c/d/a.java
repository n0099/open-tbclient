package c.a.q0.a.c0.c.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import c.a.q0.a.e0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class a extends c.a.q0.a.c0.b.a<CanvasView, c.a.q0.a.a0.b.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public CanvasView f4697i;

    /* renamed from: c.a.q0.a.c0.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0218a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CanvasView.c f4698e;

        public RunnableC0218a(a aVar, CanvasView.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4698e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            CanvasView.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f4698e) == null) {
                return;
            }
            cVar.a();
        }
    }

    /* loaded from: classes.dex */
    public class b extends c.a.q0.a.a3.g.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, String str, String str2, String str3, boolean z) {
            super(str, str2, str3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2, str3, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = z;
        }

        @Override // c.a.q0.a.a3.g.b.b, android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.n && super.onTouch(view, motionEvent) : invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context, @NonNull c.a.q0.a.a0.b.a aVar) {
        super(context, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (c.a.q0.a.c0.b.b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        CanvasView canvasView = new CanvasView(context);
        this.f4697i = canvasView;
        canvasView.setInterceptTouchEvent(aVar.n);
        this.f4697i.setHide(aVar.f4690j);
        this.f4697i.setGesture(aVar.f4691k);
        if (aVar.f4691k) {
            this.f4697i.setInterceptTouchEvent(false);
        }
    }

    public boolean F(c.a.q0.a.a0.b.a aVar, CanvasView.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, cVar)) == null) {
            if (aVar != null && (aVar instanceof c.a.q0.a.a0.b.b)) {
                c.a.q0.a.a0.b.a n = n();
                if (!TextUtils.equals(n.f4686f, aVar.f4686f) || !TextUtils.equals(n.f4687g, aVar.f4687g)) {
                    c.a.q0.a.c0.g.a.a("Component-Canvas", "drawCanvas with illegal ids!");
                }
                c.a.q0.a.a0.b.b bVar = (c.a.q0.a.a0.b.b) aVar;
                this.f4697i.addDrawActionList(bVar.i(), bVar.j());
                this.f4697i.postInvalidate();
                this.f4697i.post(new RunnableC0218a(this, cVar));
                return true;
            }
            d.c("Component-Canvas", "some params is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.a.c0.b.a
    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: G */
    public void r(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull c.a.q0.a.a0.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppComponentContainerView, aVar) == null) {
            swanAppComponentContainerView.setOnTouchListener(new b(this, aVar.f4687g, aVar.f4686f, aVar.f4685e, aVar.f4691k));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.a.c0.b.a
    @NonNull
    /* renamed from: H */
    public CanvasView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? this.f4697i : (CanvasView) invokeL.objValue;
    }

    @Override // c.a.q0.a.c0.b.a
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.z();
            this.f4697i.onRelease();
        }
    }
}
