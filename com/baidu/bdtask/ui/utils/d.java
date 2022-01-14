package com.baidu.bdtask.ui.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import c.a.j.h.b.f.b;
import c.a.j.h.d.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J?\u0010\u0006\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\u0006\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/baidu/bdtask/ui/utils/ViewUtils;", "", "url", "Landroid/view/View;", "view", "", "loadImageAsync", "(Ljava/lang/String;Landroid/view/View;)V", "Lkotlin/Function0;", "nextAction", "errorAction", "(Ljava/lang/String;Landroid/view/View;Lkotlin/Function0;Lkotlin/Function0;)V", "<init>", "()V", "lib-bdtask-ui-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public static final d a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static final class a implements c.a.j.h.b.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Function0 a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f33012b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Function0 f33013c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.j.j.d.a f33014d;

        /* renamed from: com.baidu.bdtask.ui.utils.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static final class RunnableC1792a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f33015e;

            public RunnableC1792a(a aVar) {
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
                this.f33015e = aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f33015e.a.invoke();
                }
            }
        }

        /* loaded from: classes10.dex */
        public static final class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f33016e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Bitmap f33017f;

            public b(a aVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33016e = aVar;
                this.f33017f = bitmap;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f33017f.isRecycled()) {
                        this.f33016e.a.invoke();
                        return;
                    }
                    View view = this.f33016e.f33012b;
                    if (Intrinsics.areEqual(view, (ImageView) (!(view instanceof ImageView) ? null : view))) {
                        ((ImageView) this.f33016e.f33012b).setImageBitmap(this.f33017f);
                        this.f33016e.f33013c.invoke();
                        return;
                    }
                    this.f33016e.f33012b.setBackground(new BitmapDrawable(this.f33016e.f33014d.h().getAppContext().getResources(), this.f33017f));
                    this.f33016e.f33013c.invoke();
                }
            }
        }

        public a(Function0 function0, View view, Function0 function02, c.a.j.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {function0, view, function02, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = function0;
            this.f33012b = view;
            this.f33013c = function02;
            this.f33014d = aVar;
        }

        @Override // c.a.j.h.b.f.a
        public void a(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) {
                e.c(new b(this, bitmap));
            }
        }

        @Override // c.a.j.h.b.f.a
        public void onError() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                e.c(new RunnableC1792a(this));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-762449450, "Lcom/baidu/bdtask/ui/utils/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-762449450, "Lcom/baidu/bdtask/ui/utils/d;");
                return;
            }
        }
        a = new d();
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
            }
        }
    }

    public final void a(String str, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, view) == null) {
            b(str, view, ViewUtils$loadImageAsync$1.INSTANCE, ViewUtils$loadImageAsync$2.INSTANCE);
        }
    }

    public final void b(String str, View view, Function0<Unit> function0, Function0<Unit> function02) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view, function0, function02) == null) {
            if (TextUtils.isEmpty(str)) {
                function02.invoke();
            } else if (view == null) {
                function02.invoke();
            } else {
                c.a.j.j.d.a v = BDPTask.m.v();
                if (v == null) {
                    function02.invoke();
                    return;
                }
                b i2 = v.i();
                if (str == null) {
                    Intrinsics.throwNpe();
                }
                i2.a(str, new a(function02, view, function0, v));
            }
        }
    }
}
