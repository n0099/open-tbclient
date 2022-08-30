package com.baidu.adp.widget.ListView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dn;
import com.baidu.tieba.fn;
import com.baidu.tieba.h9;
import com.baidu.tieba.i9;
import com.baidu.tieba.qn;
import com.baidu.tieba.rn;
import com.baidu.tieba.tn;
import com.baidu.tieba.xk;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class BdRecyclerView extends RecyclerView implements rn<BdRecyclerView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdRecyclerAdapter a;
    public h9 b;
    public i c;
    public j d;
    public BdListView.m e;
    public BdListView.l f;
    public BdListView.p g;
    public BdListView.s h;
    public BdListView.o i;
    public long j;
    public dn k;
    public dn l;
    public View m;
    public boolean n;
    public boolean o;
    public Runnable p;
    public Runnable q;
    public Runnable r;
    public tn s;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdRecyclerView a;

        public a(BdRecyclerView bdRecyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdRecyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdRecyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.i == null) {
                return;
            }
            int firstVisiblePosition = this.a.getFirstVisiblePosition();
            int lastVisiblePosition = this.a.getLastVisiblePosition();
            int i = 0;
            int i2 = -1;
            if (this.a.a == null || this.a.a.p() == null || this.a.a.p().getItemCount() <= 0) {
                i = -1;
            } else {
                int o = firstVisiblePosition - this.a.a.o();
                i2 = o < 0 ? 0 : o;
                int o2 = lastVisiblePosition - this.a.a.o();
                if (o2 >= this.a.a.p().getItemCount()) {
                    o2 = this.a.a.p().getItemCount() - 1;
                }
                if (o2 >= 0) {
                    i = o2;
                }
            }
            this.a.i.onScrollStop(i2, i);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdRecyclerView a;

        public b(BdRecyclerView bdRecyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdRecyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdRecyclerView;
        }

        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            if (view2 instanceof xk) {
                ((xk) view2).refresh();
            }
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(viewGroup.getChildAt(i));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int childCount = this.a.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(this.a.getChildAt(i));
                }
                this.a.r.run();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdRecyclerView a;

        public c(BdRecyclerView bdRecyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdRecyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdRecyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            h9 c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.b != null) {
                    c = this.a.b;
                } else {
                    c = i9.c(this.a.getContext());
                }
                if (c != null) {
                    c.onPreLoad(this.a.s);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdRecyclerView a;

        public d(BdRecyclerView bdRecyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdRecyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdRecyclerView;
        }

        @Override // com.baidu.tieba.tn
        public void cancelRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BdRecyclerView bdRecyclerView = this.a;
                bdRecyclerView.removeCallbacks(bdRecyclerView.q);
            }
        }

        @Override // com.baidu.tieba.tn
        public qn getAdapter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.a : (qn) invokeV.objValue;
        }

        @Override // com.baidu.tieba.tn
        public int getFirstVisiblePosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getFirstVisiblePosition() : invokeV.intValue;
        }

        @Override // com.baidu.tieba.tn
        public int getLastVisiblePosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.getLastVisiblePosition() : invokeV.intValue;
        }
    }

    /* loaded from: classes.dex */
    public class e implements fn.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdRecyclerView a;

        public e(BdRecyclerView bdRecyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdRecyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdRecyclerView;
        }

        @Override // com.baidu.tieba.fn.a
        public void onPreLoad() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BdRecyclerView bdRecyclerView = this.a;
                bdRecyclerView.removeCallbacks(bdRecyclerView.r);
                BdRecyclerView bdRecyclerView2 = this.a;
                bdRecyclerView2.postDelayed(bdRecyclerView2.r, 100L);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdRecyclerView a;

        public f(BdRecyclerView bdRecyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdRecyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdRecyclerView;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view2, Object obj, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                int headerViewsCount = this.a.getHeaderViewsCount();
                if (i < headerViewsCount) {
                    if (this.a.k == null || view2 != this.a.k.b()) {
                        if (this.a.e != null) {
                            this.a.e.onClick(view2);
                            return;
                        }
                        return;
                    }
                    this.a.k.c();
                    return;
                }
                int i2 = i - headerViewsCount;
                RecyclerView.Adapter p = this.a.a.p();
                if (p == null || i2 >= p.getItemCount()) {
                    if (this.a.l == null || view2 != this.a.l.b()) {
                        if (this.a.f != null) {
                            this.a.f.onClick(view2);
                            return;
                        }
                        return;
                    }
                    this.a.l.c();
                } else if (this.a.c != null) {
                    this.a.c.b(viewGroup, view2, obj, i2, j);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdRecyclerView a;

        public g(BdRecyclerView bdRecyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdRecyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdRecyclerView;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.j
        public boolean a(ViewGroup viewGroup, View view2, Object obj, int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view2, obj, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                int headerViewsCount = i - this.a.getHeaderViewsCount();
                RecyclerView.Adapter p = this.a.a.p();
                if (p == null || headerViewsCount >= p.getItemCount() || this.a.d == null) {
                    return false;
                }
                return this.a.d.a(viewGroup, view2, obj, headerViewsCount, j);
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class h extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdRecyclerView a;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.g == null) {
                    return;
                }
                this.a.a.g.onScrollToBottom();
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public b(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.h == null) {
                    return;
                }
                this.a.a.h.onScrollToTop();
            }
        }

        public h(BdRecyclerView bdRecyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdRecyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdRecyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            h9 c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (this.a.b != null) {
                    c = this.a.b;
                } else {
                    c = i9.c(this.a.getContext());
                }
                if (c != null) {
                    if (i == 2) {
                        BdRecyclerView bdRecyclerView = this.a;
                        bdRecyclerView.removeCallbacks(bdRecyclerView.q);
                        c.setIsScroll(true);
                    } else if (c.isScroll()) {
                        c.setIsScroll(false);
                        BdRecyclerView bdRecyclerView2 = this.a;
                        bdRecyclerView2.removeCallbacks(bdRecyclerView2.q);
                        BdRecyclerView bdRecyclerView3 = this.a;
                        bdRecyclerView3.postDelayed(bdRecyclerView3.q, 100L);
                    } else if (i == 0) {
                        BdRecyclerView bdRecyclerView4 = this.a;
                        bdRecyclerView4.removeCallbacks(bdRecyclerView4.r);
                        BdRecyclerView bdRecyclerView5 = this.a;
                        bdRecyclerView5.postDelayed(bdRecyclerView5.r, 100L);
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                boolean canScrollVertically = this.a.canScrollVertically(1);
                boolean canScrollVertically2 = this.a.canScrollVertically(-1);
                if (!canScrollVertically && canScrollVertically2 && Math.abs(i2) > 0) {
                    if (this.a.g != null) {
                        recyclerView.post(new a(this));
                    }
                } else if (!canScrollVertically2 && canScrollVertically && Math.abs(i2) > 0 && this.a.h != null) {
                    recyclerView.post(new b(this));
                }
                if (this.a.i == null || this.a.j <= 0) {
                    return;
                }
                this.a.getHandler().removeCallbacks(this.a.p);
                this.a.getHandler().postDelayed(this.a.p, this.a.j);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface i<T> {
        void b(ViewGroup viewGroup, View view2, T t, int i, long j);
    }

    /* loaded from: classes.dex */
    public interface j<T> {
        boolean a(ViewGroup viewGroup, View view2, T t, int i, long j);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdRecyclerView(Context context) {
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
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = 100L;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = true;
        this.o = true;
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this);
        this.s = new d(this);
        x();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.n = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            try {
                super.dispatchDraw(canvas);
            } catch (NullPointerException e2) {
                BdLog.detailException(e2);
                if (getContext() instanceof Activity) {
                    ((Activity) getContext()).finish();
                }
            } catch (OutOfMemoryError unused) {
                BdBaseApplication.getInst().onAppMemoryLow();
                if (getContext() instanceof Activity) {
                    ((Activity) getContext()).finish();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2, Integer.valueOf(i4)})) == null) {
            if (this.o || i4 == 0) {
                return super.dispatchNestedPreScroll(i2, i3, iArr, iArr2, i4);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr, Integer.valueOf(i6)})) == null) {
            if (this.o || i6 == 0) {
                return super.dispatchNestedScroll(i2, i3, i4, i5, iArr, i6);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tieba.rn
    public int getContentViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (getWrappedAdapter() != null) {
                return getWrappedAdapter().getItemCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getFirstCompletelyVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager == null) {
                return 0;
            }
            if (layoutManager instanceof LinearLayoutManager) {
                return ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
            }
            if (layoutManager instanceof GridLayoutManager) {
                return ((GridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
            }
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
                staggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(iArr);
                return w(iArr);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getFirstVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager == null) {
                return 0;
            }
            if (layoutManager instanceof LinearLayoutManager) {
                return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            }
            if (layoutManager instanceof GridLayoutManager) {
                return ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
            }
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
                staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr);
                return w(iArr);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rn
    public int getFooterViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.n() : invokeV.intValue;
    }

    @Override // com.baidu.tieba.rn
    public int getHeaderViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.o() : invokeV.intValue;
    }

    public int getLastVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager == null) {
                return 0;
            }
            if (layoutManager instanceof LinearLayoutManager) {
                return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            }
            if (layoutManager instanceof GridLayoutManager) {
                return ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
            }
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
                staggeredGridLayoutManager.findLastVisibleItemPositions(iArr);
                return v(iArr);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public qn getListAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (qn) getAdapter() : (qn) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    public BdRecyclerView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this : (BdRecyclerView) invokeV.objValue;
    }

    public tn getPreLoadHandle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.s : (tn) invokeV.objValue;
    }

    public RecyclerView.Adapter getWrappedAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            BdRecyclerAdapter bdRecyclerAdapter = this.a;
            if (bdRecyclerAdapter != null) {
                return bdRecyclerAdapter.p();
            }
            return null;
        }
        return (RecyclerView.Adapter) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            try {
                super.onDetachedFromWindow();
                getHandler().removeCallbacks(this.p);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void r(View view2) {
        BdRecyclerAdapter bdRecyclerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, view2) == null) || (bdRecyclerAdapter = this.a) == null) {
            return;
        }
        bdRecyclerAdapter.g(view2);
    }

    @Override // com.baidu.tieba.rn
    public boolean removeHeaderView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, view2)) == null) {
            BdRecyclerAdapter bdRecyclerAdapter = this.a;
            if (bdRecyclerAdapter == null) {
                return false;
            }
            return bdRecyclerAdapter.r(view2);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.n) {
            super.requestLayout();
        }
    }

    public void s(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view2) == null) {
            this.a.i(view2, -1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, adapter) == null) {
            super.setAdapter(null);
            this.a.s(adapter);
            super.setAdapter(this.a);
        }
    }

    public void setCanFling(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.o = z;
        }
    }

    public void setFooterView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view2) == null) {
            this.a.t(view2, null, true, true, -1);
        }
    }

    public void setHeaderView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            this.a.u(view2, null, true, true, -1);
        }
    }

    public void setNextPage(dn dnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, dnVar) == null) {
            dn dnVar2 = this.l;
            if (dnVar2 == null || dnVar2 != dnVar) {
                dn dnVar3 = this.l;
                if (dnVar3 != null && dnVar3 != dnVar) {
                    y(dnVar3.b());
                    this.l = null;
                }
                if (dnVar != null) {
                    this.a.h(dnVar.b(), null, true, 0);
                    this.l = dnVar;
                }
            }
        }
    }

    public void setNoData(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, str) == null) || str == null) {
            return;
        }
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setTextSize(16.0f);
        textView.setGravity(17);
        setNoData(textView);
    }

    public void setOnHeaderClickListener(BdListView.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, mVar) == null) {
            this.e = mVar;
        }
    }

    public void setOnItemClickListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, iVar) == null) {
            this.c = iVar;
        }
    }

    public void setOnItemLongClickListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, jVar) == null) {
            this.d = jVar;
        }
    }

    public void setOnScrollStopDelayedListener(BdListView.o oVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048607, this, oVar, j2) == null) {
            this.i = oVar;
            this.j = j2;
        }
    }

    public void setOnSrollToBottomListener(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, pVar) == null) {
            this.g = pVar;
        }
    }

    public void setScrollable(h9 h9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, h9Var) == null) {
            this.b = h9Var;
        }
    }

    public void setSelection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            scrollToPosition(i2);
        }
    }

    public void t(View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048611, this, view2, i2) == null) {
            this.a.i(view2, i2);
        }
    }

    public void u(View view2, Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048612, this, view2, obj, z) == null) {
            this.a.j(view2, obj, z, true, -1);
        }
    }

    public final int v(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, iArr)) == null) {
            if (iArr == null) {
                return 0;
            }
            int i2 = iArr[0];
            for (int i3 : iArr) {
                if (i3 > i2) {
                    i2 = i3;
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public final int w(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, iArr)) == null) {
            if (iArr == null) {
                return 0;
            }
            int i2 = iArr[0];
            for (int i3 : iArr) {
                if (i3 < i2) {
                    i2 = i3;
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            setFadingEdgeLength(0);
            BdRecyclerAdapter bdRecyclerAdapter = new BdRecyclerAdapter(getContext());
            this.a = bdRecyclerAdapter;
            bdRecyclerAdapter.v(new e(this));
            this.a.w(new f(this));
            this.a.x(new g(this));
            addOnScrollListener(new h(this));
        }
    }

    public boolean y(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, view2)) == null) {
            BdRecyclerAdapter bdRecyclerAdapter = this.a;
            if (bdRecyclerAdapter == null) {
                return false;
            }
            return bdRecyclerAdapter.q(view2);
        }
        return invokeL.booleanValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.n = false;
        }
    }

    public void setHeaderView(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048600, this, view2, z) == null) {
            this.a.u(view2, null, true, z, -1);
        }
    }

    public void setNoData(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, view2) == null) {
            View view3 = this.m;
            if (view3 != null) {
                removeHeaderView(view3);
                this.m = null;
            }
            if (view2 != null) {
                u(view2, null, false);
                this.m = view2;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = 100L;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = true;
        this.o = true;
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this);
        this.s = new d(this);
        x();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = 100L;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = true;
        this.o = true;
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this);
        this.s = new d(this);
        x();
    }
}
