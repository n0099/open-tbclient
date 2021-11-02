package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import b.a.p0.a.a0.a.j.f;
import b.a.p0.a.a0.a.j.f0;
import b.a.p0.a.a0.a.j.k;
import b.a.p0.a.v2.q0;
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
/* loaded from: classes8.dex */
public class CanvasView extends AbsCanvasView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f43571h;

    /* renamed from: i  reason: collision with root package name */
    public final DrawFilter f43572i;
    public int j;
    public HashMap<String, Bitmap> k;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CanvasView f43573e;

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
            this.f43573e = canvasView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f43573e.b();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<b.a.p0.a.a0.a.j.a> f43574a;

        /* renamed from: b  reason: collision with root package name */
        public b.a.p0.a.a0.a.j.b f43575b;

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

    /* loaded from: classes8.dex */
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

    public void addDrawActionList(List<b.a.p0.a.a0.a.j.a> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) || list == null || this.f43571h.contains(list)) {
            return;
        }
        if (!z) {
            this.f43571h.clear();
        }
        int size = this.f43571h.size();
        boolean z2 = z && size > 0;
        b bVar = new b(null);
        if (z2) {
            b bVar2 = this.f43571h.get(size - 1);
            bVar.f43575b = bVar2.f43575b;
            List<b.a.p0.a.a0.a.j.a> list2 = bVar2.f43574a;
            bVar.f43574a = list2;
            list2.addAll(list);
        } else {
            bVar.f43575b = new b.a.p0.a.a0.a.j.b(this);
            bVar.f43574a = list;
        }
        this.f43571h.add(bVar);
        q0.b0(new a(this));
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.j;
            if (this.f43571h.size() > 0) {
                for (b bVar : this.f43571h) {
                    Iterator<b.a.p0.a.a0.a.j.a> it = bVar.f43574a.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            b.a.p0.a.a0.a.j.a next = it.next();
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

    public b.a.p0.a.a0.a.j.b getCanvasContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f43571h.size() > 0) {
                List<b> list = this.f43571h;
                return list.get(list.size() - 1).f43575b;
            }
            return null;
        }
        return (b.a.p0.a.a0.a.j.b) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f43571h.size() > 0) {
                int save = canvas.save();
                canvas.setDrawFilter(this.f43572i);
                for (b bVar : this.f43571h) {
                    List<b.a.p0.a.a0.a.j.a> list = bVar.f43574a;
                    b.a.p0.a.a0.a.j.b bVar2 = bVar.f43575b;
                    bVar2.e();
                    for (b.a.p0.a.a0.a.j.a aVar : list) {
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
        this.f43571h = new ArrayList();
        this.f43572i = new PaintFlagsDrawFilter(0, 3);
        this.j = 0;
        this.k = new HashMap<>();
        this.j = getLayerType();
    }
}
