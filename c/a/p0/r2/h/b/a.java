package c.a.p0.r2.h.b;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import c.a.o0.e1.e.a;
import c.a.o0.e1.e.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.dragsort.SimpleDragSortListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SimpleDragSortListView a;

    /* renamed from: b  reason: collision with root package name */
    public final C1360a f18063b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.o0.e1.e.a f18064c;

    /* renamed from: c.a.p0.r2.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1360a extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int F;
        public int G;
        public ListView H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1360a(c.a.o0.e1.e.a aVar, ListView listView) {
            super(aVar, listView, 0, 2, 0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, listView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((c.a.o0.e1.e.a) objArr2[0], (ListView) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.F = 0;
            this.G = Integer.MAX_VALUE;
            s(false);
            this.H = listView;
        }

        public void A(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.F = i;
                this.G = i2;
            }
        }

        @Override // c.a.o0.e1.e.e, c.a.o0.e1.e.a.j
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            }
        }

        @Override // c.a.o0.e1.e.b, c.a.o0.e1.e.a.j
        public void c(View view, Point point, Point point2) {
            int top;
            int top2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, view, point, point2) == null) {
                int firstVisiblePosition = this.H.getFirstVisiblePosition();
                int dividerHeight = this.H.getDividerHeight();
                int headerViewsCount = (this.F - firstVisiblePosition) + this.H.getHeaderViewsCount();
                int headerViewsCount2 = (this.G - firstVisiblePosition) + this.H.getHeaderViewsCount();
                int childCount = this.H.getChildCount();
                View view2 = null;
                View childAt = (headerViewsCount < 0 || headerViewsCount >= childCount) ? null : this.H.getChildAt(headerViewsCount);
                if (headerViewsCount2 >= 0 && headerViewsCount2 < childCount) {
                    view2 = this.H.getChildAt(headerViewsCount2);
                }
                if (childAt != null && point.y < (top2 = childAt.getTop())) {
                    point.y = top2;
                }
                if (view2 == null || point.y <= (top = (view2.getTop() - dividerHeight) - view.getHeight())) {
                    return;
                }
                point.y = top;
            }
        }

        @Override // c.a.o0.e1.e.b
        public int w(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                int o = super.o(motionEvent);
                int headerViewsCount = o - this.H.getHeaderViewsCount();
                if (headerViewsCount < this.F || headerViewsCount >= this.G) {
                    return -1;
                }
                return o;
            }
            return invokeL.intValue;
        }
    }

    public a(SimpleDragSortListView simpleDragSortListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {simpleDragSortListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = simpleDragSortListView;
        c.a.o0.e1.e.a aVar = new c.a.o0.e1.e.a(simpleDragSortListView, simpleDragSortListView.getViewSuperMethods());
        this.f18064c = aVar;
        simpleDragSortListView.setDragSortViewEventDelegate(aVar);
        C1360a c1360a = new C1360a(this.f18064c, simpleDragSortListView);
        this.f18063b = c1360a;
        c1360a.d(-1);
        this.f18064c.s0(this.f18063b);
        this.f18064c.u0(this.f18063b);
        simpleDragSortListView.setOnTouchListener(this.f18063b);
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f18064c.o0(z);
        }
    }

    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            this.f18063b.A(i, i2);
        }
    }

    public void c(a.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iVar) == null) {
            this.f18064c.t0(iVar);
        }
    }
}
