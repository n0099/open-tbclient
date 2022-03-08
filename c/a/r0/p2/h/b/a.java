package c.a.r0.p2.h.b;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import c.a.q0.e1.e.a;
import c.a.q0.e1.e.b;
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
    public final C1307a f20865b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.q0.e1.e.a f20866c;

    /* renamed from: c.a.r0.p2.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1307a extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int J;
        public int K;
        public ListView L;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1307a(c.a.q0.e1.e.a aVar, ListView listView) {
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
                    super((c.a.q0.e1.e.a) objArr2[0], (ListView) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.J = 0;
            this.K = Integer.MAX_VALUE;
            v(false);
            this.L = listView;
        }

        public void C(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.J = i2;
                this.K = i3;
            }
        }

        @Override // c.a.q0.e1.e.e, c.a.q0.e1.e.a.j
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            }
        }

        @Override // c.a.q0.e1.e.b, c.a.q0.e1.e.a.j
        public void d(View view, Point point, Point point2) {
            int top;
            int top2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, view, point, point2) == null) {
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

        @Override // c.a.q0.e1.e.b
        public int z(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                int r = super.r(motionEvent);
                int headerViewsCount = r - this.L.getHeaderViewsCount();
                if (headerViewsCount < this.J || headerViewsCount >= this.K) {
                    return -1;
                }
                return r;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = simpleDragSortListView;
        c.a.q0.e1.e.a aVar = new c.a.q0.e1.e.a(simpleDragSortListView, simpleDragSortListView.getViewSuperMethods());
        this.f20866c = aVar;
        simpleDragSortListView.setDragSortViewEventDelegate(aVar);
        C1307a c1307a = new C1307a(this.f20866c, simpleDragSortListView);
        this.f20865b = c1307a;
        c1307a.e(-1);
        this.f20866c.s0(this.f20865b);
        this.f20866c.u0(this.f20865b);
        simpleDragSortListView.setOnTouchListener(this.f20865b);
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f20866c.o0(z);
        }
    }

    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            this.f20865b.C(i2, i3);
        }
    }

    public void c(a.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iVar) == null) {
            this.f20866c.t0(iVar);
        }
    }
}
