package c.a.p0.a.c0.c.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import c.a.p0.a.e0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class a extends c.a.p0.a.c0.b.a<CanvasView, c.a.p0.a.a0.b.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public CanvasView f4677i;

    /* renamed from: c.a.p0.a.c0.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0125a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CanvasView.c f4678e;

        public RunnableC0125a(a aVar, CanvasView.c cVar) {
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
            this.f4678e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            CanvasView.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f4678e) == null) {
                return;
            }
            cVar.a();
        }
    }

    /* loaded from: classes.dex */
    public class b extends c.a.p0.a.w2.g.b.b {
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

        @Override // c.a.p0.a.w2.g.b.b, android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.n && super.onTouch(view, motionEvent) : invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context, @NonNull c.a.p0.a.a0.b.a aVar) {
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
                super((Context) objArr2[0], (c.a.p0.a.c0.b.b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        CanvasView canvasView = new CanvasView(context);
        this.f4677i = canvasView;
        canvasView.setInterceptTouchEvent(aVar.n);
        this.f4677i.setHide(aVar.f4669j);
        this.f4677i.setGesture(aVar.k);
        if (aVar.k) {
            this.f4677i.setInterceptTouchEvent(false);
        }
    }

    @Override // c.a.p0.a.c0.b.a
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.A();
            this.f4677i.onRelease();
        }
    }

    public boolean H(c.a.p0.a.a0.b.a aVar, CanvasView.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, cVar)) == null) {
            if (aVar != null && (aVar instanceof c.a.p0.a.a0.b.b)) {
                c.a.p0.a.a0.b.a n = n();
                if (!TextUtils.equals(n.f4665f, aVar.f4665f) || !TextUtils.equals(n.f4666g, aVar.f4666g)) {
                    c.a.p0.a.c0.g.a.a("Component-Canvas", "drawCanvas with illegal ids!");
                }
                c.a.p0.a.a0.b.b bVar = (c.a.p0.a.a0.b.b) aVar;
                this.f4677i.addDrawActionList(bVar.j(), bVar.k());
                this.f4677i.postInvalidate();
                this.f4677i.post(new RunnableC0125a(this, cVar));
                return true;
            }
            d.b("Component-Canvas", "some params is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.c0.b.a
    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: I */
    public void r(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull c.a.p0.a.a0.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, swanAppComponentContainerView, aVar) == null) {
            swanAppComponentContainerView.setOnTouchListener(new b(this, aVar.f4666g, aVar.f4665f, aVar.f4664e, aVar.k));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.c0.b.a
    @NonNull
    /* renamed from: J */
    public CanvasView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? this.f4677i : (CanvasView) invokeL.objValue;
    }
}
