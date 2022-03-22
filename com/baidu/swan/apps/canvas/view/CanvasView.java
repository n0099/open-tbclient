package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import c.a.n0.a.p2.q0;
import c.a.n0.a.q.a.j.f;
import c.a.n0.a.q.a.j.f0;
import c.a.n0.a.q.a.j.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class CanvasView extends AbsCanvasView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f28800b;

    /* renamed from: c  reason: collision with root package name */
    public final DrawFilter f28801c;

    /* renamed from: d  reason: collision with root package name */
    public int f28802d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, Bitmap> f28803e;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CanvasView a;

        public a(CanvasView canvasView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {canvasView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = canvasView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<c.a.n0.a.q.a.j.a> a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.n0.a.q.a.j.b f28804b;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CanvasView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void c(List<c.a.n0.a.q.a.j.a> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) || list == null || this.f28800b.contains(list)) {
            return;
        }
        if (!z) {
            this.f28800b.clear();
        }
        int size = this.f28800b.size();
        boolean z2 = z && size > 0;
        b bVar = new b(null);
        if (z2) {
            b bVar2 = this.f28800b.get(size - 1);
            bVar.f28804b = bVar2.f28804b;
            List<c.a.n0.a.q.a.j.a> list2 = bVar2.a;
            bVar.a = list2;
            list2.addAll(list);
        } else {
            bVar.f28804b = new c.a.n0.a.q.a.j.b(this);
            bVar.a = list;
        }
        this.f28800b.add(bVar);
        q0.e0(new a(this));
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i = this.f28802d;
            if (this.f28800b.size() > 0) {
                for (b bVar : this.f28800b) {
                    Iterator<c.a.n0.a.q.a.j.a> it = bVar.a.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            c.a.n0.a.q.a.j.a next = it.next();
                            if (next instanceof f) {
                                i = 2;
                            } else if (next instanceof f0) {
                                i = 1;
                                break;
                            }
                        }
                    }
                }
            }
            if (getLayerType() != i) {
                setLayerType(i, null);
            }
        }
    }

    public Bitmap e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.f28803e.get(str);
        }
        return (Bitmap) invokeL.objValue;
    }

    public synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.f28803e.clear();
            }
        }
    }

    public c.a.n0.a.q.a.j.b getCanvasContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f28800b.size() > 0) {
                List<b> list = this.f28800b;
                return list.get(list.size() - 1).f28804b;
            }
            return null;
        }
        return (c.a.n0.a.q.a.j.b) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f28800b.size() > 0) {
                int save = canvas.save();
                canvas.setDrawFilter(this.f28801c);
                for (b bVar : this.f28800b) {
                    List<c.a.n0.a.q.a.j.a> list = bVar.a;
                    c.a.n0.a.q.a.j.b bVar2 = bVar.f28804b;
                    bVar2.d();
                    for (c.a.n0.a.q.a.j.a aVar : list) {
                        aVar.a(bVar2, canvas);
                        if (aVar instanceof k) {
                            ((k) aVar).e(this.f28803e);
                        }
                    }
                }
                if (canvas.getSaveCount() > 0) {
                    canvas.restoreToCount(save);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) ? a() || super.onTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f28800b = new ArrayList();
        this.f28801c = new PaintFlagsDrawFilter(0, 3);
        this.f28802d = 0;
        this.f28803e = new HashMap<>();
        this.f28802d = getLayerType();
    }
}
