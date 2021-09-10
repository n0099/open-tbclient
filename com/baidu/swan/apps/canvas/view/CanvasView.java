package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import c.a.p0.a.a0.a.j.f;
import c.a.p0.a.a0.a.j.f0;
import c.a.p0.a.a0.a.j.k;
import c.a.p0.a.v2.q0;
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
/* loaded from: classes6.dex */
public class CanvasView extends AbsCanvasView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f45836h;

    /* renamed from: i  reason: collision with root package name */
    public final DrawFilter f45837i;

    /* renamed from: j  reason: collision with root package name */
    public int f45838j;
    public HashMap<String, Bitmap> k;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CanvasView f45839e;

        public a(CanvasView canvasView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {canvasView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45839e = canvasView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45839e.b();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<c.a.p0.a.a0.a.j.a> f45840a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.p0.a.a0.a.j.b f45841b;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void addDrawActionList(List<c.a.p0.a.a0.a.j.a> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) || list == null || this.f45836h.contains(list)) {
            return;
        }
        if (!z) {
            this.f45836h.clear();
        }
        int size = this.f45836h.size();
        boolean z2 = z && size > 0;
        b bVar = new b(null);
        if (z2) {
            b bVar2 = this.f45836h.get(size - 1);
            bVar.f45841b = bVar2.f45841b;
            List<c.a.p0.a.a0.a.j.a> list2 = bVar2.f45840a;
            bVar.f45840a = list2;
            list2.addAll(list);
        } else {
            bVar.f45841b = new c.a.p0.a.a0.a.j.b(this);
            bVar.f45840a = list;
        }
        this.f45836h.add(bVar);
        q0.b0(new a(this));
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.f45838j;
            if (this.f45836h.size() > 0) {
                for (b bVar : this.f45836h) {
                    Iterator<c.a.p0.a.a0.a.j.a> it = bVar.f45840a.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            c.a.p0.a.a0.a.j.a next = it.next();
                            if (next instanceof f) {
                                i2 = 2;
                            } else if (next instanceof f0) {
                                i2 = 1;
                                break;
                            }
                        }
                    }
                }
            }
            if (getLayerType() != i2) {
                setLayerType(i2, null);
            }
        }
    }

    public Bitmap getBitmapByUrlKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.k.get(str);
        }
        return (Bitmap) invokeL.objValue;
    }

    public c.a.p0.a.a0.a.j.b getCanvasContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f45836h.size() > 0) {
                List<b> list = this.f45836h;
                return list.get(list.size() - 1).f45841b;
            }
            return null;
        }
        return (c.a.p0.a.a0.a.j.b) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f45836h.size() > 0) {
                int save = canvas.save();
                canvas.setDrawFilter(this.f45837i);
                for (b bVar : this.f45836h) {
                    List<c.a.p0.a.a0.a.j.a> list = bVar.f45840a;
                    c.a.p0.a.a0.a.j.b bVar2 = bVar.f45841b;
                    bVar2.g();
                    for (c.a.p0.a.a0.a.j.a aVar : list) {
                        aVar.a(bVar2, canvas);
                        if (aVar instanceof k) {
                            ((k) aVar).e(this.k);
                        }
                    }
                }
                if (canvas.getSaveCount() > 0) {
                    canvas.restoreToCount(save);
                }
            }
        }
    }

    public synchronized void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                this.k.clear();
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) ? isInterceptTouchEvent() || super.onTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    public void setOnDrawCompleteLinstener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CanvasView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f45836h = new ArrayList();
        this.f45837i = new PaintFlagsDrawFilter(0, 3);
        this.f45838j = 0;
        this.k = new HashMap<>();
        this.f45838j = getLayerType();
    }
}
