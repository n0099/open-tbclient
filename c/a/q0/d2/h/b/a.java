package c.a.q0.d2.h.b;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import c.a.p0.d1.e.a;
import c.a.p0.d1.e.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.dragsort.SimpleDragSortListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SimpleDragSortListView f16829a;

    /* renamed from: b  reason: collision with root package name */
    public final C0812a f16830b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.p0.d1.e.a f16831c;

    /* renamed from: c.a.q0.d2.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0812a extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int J;
        public int K;
        public ListView L;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0812a(c.a.p0.d1.e.a aVar, ListView listView) {
            super(aVar, listView, 0, 2, 0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, listView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((c.a.p0.d1.e.a) objArr2[0], (ListView) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.J = 0;
            this.K = Integer.MAX_VALUE;
            r(false);
            this.L = listView;
        }

        @Override // c.a.p0.d1.e.e, c.a.p0.d1.e.a.j
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }

        @Override // c.a.p0.d1.e.b, c.a.p0.d1.e.a.j
        public void c(View view, Point point, Point point2) {
            int top;
            int top2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, point, point2) == null) {
                int firstVisiblePosition = this.L.getFirstVisiblePosition();
                int dividerHeight = this.L.getDividerHeight();
                int headerViewsCount = (this.J - firstVisiblePosition) + this.L.getHeaderViewsCount();
                int headerViewsCount2 = (this.K - firstVisiblePosition) + this.L.getHeaderViewsCount();
                int childCount = this.L.getChildCount();
                View view2 = null;
                View childAt = (headerViewsCount < 0 || headerViewsCount >= childCount) ? null : this.L.getChildAt(headerViewsCount);
                if (headerViewsCount2 >= 0 && headerViewsCount2 < childCount) {
                    view2 = this.L.getChildAt(headerViewsCount2);
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

        @Override // c.a.p0.d1.e.b
        public int v(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                int n = super.n(motionEvent);
                int headerViewsCount = n - this.L.getHeaderViewsCount();
                if (headerViewsCount < this.J || headerViewsCount >= this.K) {
                    return -1;
                }
                return n;
            }
            return invokeL.intValue;
        }

        public void y(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
                this.J = i2;
                this.K = i3;
            }
        }
    }

    public a(SimpleDragSortListView simpleDragSortListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {simpleDragSortListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16829a = simpleDragSortListView;
        c.a.p0.d1.e.a aVar = new c.a.p0.d1.e.a(simpleDragSortListView, simpleDragSortListView.getViewSuperMethods());
        this.f16831c = aVar;
        simpleDragSortListView.setDragSortViewEventDelegate(aVar);
        C0812a c0812a = new C0812a(this.f16831c, simpleDragSortListView);
        this.f16830b = c0812a;
        c0812a.d(-1);
        this.f16831c.s0(this.f16830b);
        this.f16831c.u0(this.f16830b);
        simpleDragSortListView.setOnTouchListener(this.f16830b);
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f16831c.o0(z);
        }
    }

    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            this.f16830b.y(i2, i3);
        }
    }

    public void c(a.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iVar) == null) {
            this.f16831c.t0(iVar);
        }
    }
}
