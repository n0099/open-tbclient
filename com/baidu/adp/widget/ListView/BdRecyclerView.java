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
import b.a.e.m.e.d;
import b.a.e.m.e.o;
import b.a.e.m.e.p;
import b.a.e.m.e.q;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class BdRecyclerView extends RecyclerView implements p<BdRecyclerView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdRecyclerAdapter f35431e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.e.a.i f35432f;

    /* renamed from: g  reason: collision with root package name */
    public i f35433g;

    /* renamed from: h  reason: collision with root package name */
    public j f35434h;

    /* renamed from: i  reason: collision with root package name */
    public BdListView.m f35435i;
    public BdListView.l j;
    public BdListView.p k;
    public BdListView.s l;
    public BdListView.o m;
    public long n;
    public b.a.e.m.e.b o;
    public b.a.e.m.e.b p;
    public View q;
    public boolean r;
    public boolean s;
    public Runnable t;
    public Runnable u;
    public Runnable v;
    public q w;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdRecyclerView f35436e;

        public a(BdRecyclerView bdRecyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdRecyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35436e = bdRecyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f35436e.m == null) {
                return;
            }
            int firstVisiblePosition = this.f35436e.getFirstVisiblePosition();
            int lastVisiblePosition = this.f35436e.getLastVisiblePosition();
            int i2 = 0;
            int i3 = -1;
            if (this.f35436e.f35431e == null || this.f35436e.f35431e.getWrappedAdapter() == null || this.f35436e.f35431e.getWrappedAdapter().getItemCount() <= 0) {
                i2 = -1;
            } else {
                int headersCount = firstVisiblePosition - this.f35436e.f35431e.getHeadersCount();
                i3 = headersCount < 0 ? 0 : headersCount;
                int headersCount2 = lastVisiblePosition - this.f35436e.f35431e.getHeadersCount();
                if (headersCount2 >= this.f35436e.f35431e.getWrappedAdapter().getItemCount()) {
                    headersCount2 = this.f35436e.f35431e.getWrappedAdapter().getItemCount() - 1;
                }
                if (headersCount2 >= 0) {
                    i2 = headersCount2;
                }
            }
            this.f35436e.m.onScrollStop(i3, i2);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdRecyclerView f35437e;

        public b(BdRecyclerView bdRecyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdRecyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35437e = bdRecyclerView;
        }

        public final void a(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view instanceof b.a.e.g.a.h) {
                ((b.a.e.g.a.h) view).refresh();
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    a(viewGroup.getChildAt(i2));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int childCount = this.f35437e.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    a(this.f35437e.getChildAt(i2));
                }
                this.f35437e.v.run();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdRecyclerView f35438e;

        public c(BdRecyclerView bdRecyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdRecyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35438e = bdRecyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a.e.a.i c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f35438e.f35432f != null) {
                    c2 = this.f35438e.f35432f;
                } else {
                    c2 = b.a.e.a.j.c(this.f35438e.getContext());
                }
                if (c2 != null) {
                    c2.onPreLoad(this.f35438e.w);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BdRecyclerView f35439a;

        public d(BdRecyclerView bdRecyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdRecyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35439a = bdRecyclerView;
        }

        @Override // b.a.e.m.e.q
        public void cancelRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BdRecyclerView bdRecyclerView = this.f35439a;
                bdRecyclerView.removeCallbacks(bdRecyclerView.u);
            }
        }

        @Override // b.a.e.m.e.q
        public o getAdapter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f35439a.f35431e : (o) invokeV.objValue;
        }

        @Override // b.a.e.m.e.q
        public int getFirstVisiblePosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f35439a.getFirstVisiblePosition() : invokeV.intValue;
        }

        @Override // b.a.e.m.e.q
        public int getLastVisiblePosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f35439a.getLastVisiblePosition() : invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BdRecyclerView f35440a;

        public e(BdRecyclerView bdRecyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdRecyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35440a = bdRecyclerView;
        }

        @Override // b.a.e.m.e.d.a
        public void onPreLoad() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BdRecyclerView bdRecyclerView = this.f35440a;
                bdRecyclerView.removeCallbacks(bdRecyclerView.v);
                BdRecyclerView bdRecyclerView2 = this.f35440a;
                bdRecyclerView2.postDelayed(bdRecyclerView2.v, 100L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdRecyclerView f35441e;

        public f(BdRecyclerView bdRecyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdRecyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35441e = bdRecyclerView;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                int headerViewsCount = this.f35441e.getHeaderViewsCount();
                if (i2 < headerViewsCount) {
                    if (this.f35441e.o == null || view != this.f35441e.o.b()) {
                        if (this.f35441e.f35435i != null) {
                            this.f35441e.f35435i.onClick(view);
                            return;
                        }
                        return;
                    }
                    this.f35441e.o.c();
                    return;
                }
                int i3 = i2 - headerViewsCount;
                RecyclerView.Adapter wrappedAdapter = this.f35441e.f35431e.getWrappedAdapter();
                if (wrappedAdapter == null || i3 >= wrappedAdapter.getItemCount()) {
                    if (this.f35441e.p == null || view != this.f35441e.p.b()) {
                        if (this.f35441e.j != null) {
                            this.f35441e.j.onClick(view);
                            return;
                        }
                        return;
                    }
                    this.f35441e.p.c();
                } else if (this.f35441e.f35433g != null) {
                    this.f35441e.f35433g.b(viewGroup, view, obj, i3, j);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BdRecyclerView f35442a;

        public g(BdRecyclerView bdRecyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdRecyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35442a = bdRecyclerView;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.j
        public boolean a(ViewGroup viewGroup, View view, Object obj, int i2, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
                int headerViewsCount = i2 - this.f35442a.getHeaderViewsCount();
                RecyclerView.Adapter wrappedAdapter = this.f35442a.f35431e.getWrappedAdapter();
                if (wrappedAdapter == null || headerViewsCount >= wrappedAdapter.getItemCount() || this.f35442a.f35434h == null) {
                    return false;
                }
                return this.f35442a.f35434h.a(viewGroup, view, obj, headerViewsCount, j);
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class h extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BdRecyclerView f35443a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f35444e;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f35444e = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f35444e.f35443a.k == null) {
                    return;
                }
                this.f35444e.f35443a.k.onScrollToBottom();
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f35445e;

            public b(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f35445e = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f35445e.f35443a.l == null) {
                    return;
                }
                this.f35445e.f35443a.l.onScrollToTop();
            }
        }

        public h(BdRecyclerView bdRecyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdRecyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35443a = bdRecyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            b.a.e.a.i c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (this.f35443a.f35432f != null) {
                    c2 = this.f35443a.f35432f;
                } else {
                    c2 = b.a.e.a.j.c(this.f35443a.getContext());
                }
                if (c2 != null) {
                    if (i2 == 2) {
                        BdRecyclerView bdRecyclerView = this.f35443a;
                        bdRecyclerView.removeCallbacks(bdRecyclerView.u);
                        c2.setIsScroll(true);
                    } else if (c2.isScroll()) {
                        c2.setIsScroll(false);
                        BdRecyclerView bdRecyclerView2 = this.f35443a;
                        bdRecyclerView2.removeCallbacks(bdRecyclerView2.u);
                        BdRecyclerView bdRecyclerView3 = this.f35443a;
                        bdRecyclerView3.postDelayed(bdRecyclerView3.u, 100L);
                    } else if (i2 == 0) {
                        BdRecyclerView bdRecyclerView4 = this.f35443a;
                        bdRecyclerView4.removeCallbacks(bdRecyclerView4.v);
                        BdRecyclerView bdRecyclerView5 = this.f35443a;
                        bdRecyclerView5.postDelayed(bdRecyclerView5.v, 100L);
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                boolean canScrollVertically = this.f35443a.canScrollVertically(1);
                boolean canScrollVertically2 = this.f35443a.canScrollVertically(-1);
                if (!canScrollVertically && canScrollVertically2 && Math.abs(i3) > 0) {
                    if (this.f35443a.k != null) {
                        recyclerView.post(new a(this));
                    }
                } else if (!canScrollVertically2 && canScrollVertically && Math.abs(i3) > 0 && this.f35443a.l != null) {
                    recyclerView.post(new b(this));
                }
                if (this.f35443a.m == null || this.f35443a.n <= 0) {
                    return;
                }
                this.f35443a.getHandler().removeCallbacks(this.f35443a.t);
                this.f35443a.getHandler().postDelayed(this.f35443a.t, this.f35443a.n);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface i<T> {
        void b(ViewGroup viewGroup, View view, T t, int i2, long j);
    }

    /* loaded from: classes6.dex */
    public interface j<T> {
        boolean a(ViewGroup viewGroup, View view, T t, int i2, long j);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1385633956, "Lcom/baidu/adp/widget/ListView/BdRecyclerView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1385633956, "Lcom/baidu/adp/widget/ListView/BdRecyclerView;");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdRecyclerView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35432f = null;
        this.f35433g = null;
        this.f35434h = null;
        this.f35435i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = 100L;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = true;
        this.s = true;
        this.t = new a(this);
        this.u = new b(this);
        this.v = new c(this);
        this.w = new d(this);
        s();
    }

    public void addFooterView(View view) {
        BdRecyclerAdapter bdRecyclerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (bdRecyclerAdapter = this.f35431e) == null) {
            return;
        }
        bdRecyclerAdapter.addFooterView(view);
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, view, obj, z) == null) {
            this.f35431e.addHeaderView(view, obj, z, true, -1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2, Integer.valueOf(i4)})) == null) {
            if (this.s || i4 == 0) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr, Integer.valueOf(i6)})) == null) {
            if (this.s || i6 == 0) {
                return super.dispatchNestedScroll(i2, i3, i4, i5, iArr, i6);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // b.a.e.m.e.p
    public int getContentViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
                return r(iArr);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getFirstVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
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
                return r(iArr);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // b.a.e.m.e.p
    public int getFooterViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f35431e.getFootersCount() : invokeV.intValue;
    }

    @Override // b.a.e.m.e.p
    public int getHeaderViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f35431e.getHeadersCount() : invokeV.intValue;
    }

    public int getLastCompletelyVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager == null) {
                return 0;
            }
            if (layoutManager instanceof LinearLayoutManager) {
                return ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
            }
            if (layoutManager instanceof GridLayoutManager) {
                return ((GridLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
            }
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
                staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(iArr);
                return q(iArr);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getLastVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
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
                return q(iArr);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public o getListAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (o) getAdapter() : (o) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.p
    public BdRecyclerView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this : (BdRecyclerView) invokeV.objValue;
    }

    public q getPreLoadHandle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.w : (q) invokeV.objValue;
    }

    public RecyclerView.Adapter getWrappedAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            BdRecyclerAdapter bdRecyclerAdapter = this.f35431e;
            if (bdRecyclerAdapter != null) {
                return bdRecyclerAdapter.getWrappedAdapter();
            }
            return null;
        }
        return (RecyclerView.Adapter) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            try {
                super.onDetachedFromWindow();
                getHandler().removeCallbacks(this.t);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final int q(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, iArr)) == null) {
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

    public final int r(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, iArr)) == null) {
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

    public boolean removeFooterView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, view)) == null) {
            BdRecyclerAdapter bdRecyclerAdapter = this.f35431e;
            if (bdRecyclerAdapter == null) {
                return false;
            }
            return bdRecyclerAdapter.removeFooter(view);
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.e.m.e.p
    public boolean removeHeaderView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, view)) == null) {
            BdRecyclerAdapter bdRecyclerAdapter = this.f35431e;
            if (bdRecyclerAdapter == null) {
                return false;
            }
            return bdRecyclerAdapter.removeHeader(view);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.r) {
            super.requestLayout();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            setFadingEdgeLength(0);
            BdRecyclerAdapter bdRecyclerAdapter = new BdRecyclerAdapter(getContext());
            this.f35431e = bdRecyclerAdapter;
            bdRecyclerAdapter.setListPreLoad(new e(this));
            this.f35431e.setOnItemClickListener(new f(this));
            this.f35431e.setOnItemLongClickListener(new g(this));
            addOnScrollListener(new h(this));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, adapter) == null) {
            super.setAdapter(null);
            this.f35431e.setAdapter(adapter);
            super.setAdapter(this.f35431e);
        }
    }

    public void setCanFling(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.s = z;
        }
    }

    public void setFooterView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, view) == null) {
            this.f35431e.setFooterView(view, null, true, true, -1);
        }
    }

    public void setHeaderView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, view) == null) {
            this.f35431e.setHeaderView(view, null, true, true, -1);
        }
    }

    public void setNextPage(b.a.e.m.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bVar) == null) {
            b.a.e.m.e.b bVar2 = this.p;
            if (bVar2 == null || bVar2 != bVar) {
                b.a.e.m.e.b bVar3 = this.p;
                if (bVar3 != null && bVar3 != bVar) {
                    removeFooterView(bVar3.b());
                    this.p = null;
                }
                if (bVar != null) {
                    this.f35431e.addFooterView(bVar.b(), null, true, 0);
                    this.p = bVar;
                }
            }
        }
    }

    public void setNoData(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, str) == null) || str == null) {
            return;
        }
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setTextSize(16.0f);
        textView.setGravity(17);
        setNoData(textView);
    }

    public void setOnFooterClickListener(BdListView.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, lVar) == null) {
            this.j = lVar;
        }
    }

    public void setOnHeaderClickListener(BdListView.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, mVar) == null) {
            this.f35435i = mVar;
        }
    }

    public void setOnItemClickListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, iVar) == null) {
            this.f35433g = iVar;
        }
    }

    public void setOnItemLongClickListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, jVar) == null) {
            this.f35434h = jVar;
        }
    }

    public void setOnScrollStopDelayedListener(BdListView.o oVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048615, this, oVar, j2) == null) {
            this.m = oVar;
            this.n = j2;
        }
    }

    public void setOnSrollToBottomListener(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, pVar) == null) {
            this.k = pVar;
        }
    }

    public void setOnSrollToTopListener(BdListView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, sVar) == null) {
            this.l = sVar;
        }
    }

    public void setPrePage(b.a.e.m.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bVar) == null) {
            b.a.e.m.e.b bVar2 = this.o;
            if (bVar2 == null || bVar2 != bVar) {
                b.a.e.m.e.b bVar3 = this.o;
                if (bVar3 != null) {
                    removeHeaderView(bVar3.b());
                    this.o = null;
                }
                if (bVar != null) {
                    addHeaderView(bVar.b());
                    this.o = bVar;
                }
            }
        }
    }

    public void setScrollable(b.a.e.a.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, iVar) == null) {
            this.f35432f = iVar;
        }
    }

    public void setSelection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            scrollToPosition(i2);
        }
    }

    public void smoothScrollToPosition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048621, this, i2, i3) == null) {
            smoothScrollToPosition(i2);
        }
    }

    public void startInterceptLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.r = false;
        }
    }

    public void stopIntercerceptLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            this.r = true;
        }
    }

    public void addHeaderView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            this.f35431e.addHeaderView(view, -1);
        }
    }

    public void setHeaderView(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048607, this, view, z) == null) {
            this.f35431e.setHeaderView(view, null, true, z, -1);
        }
    }

    public void smoothScrollToPosition(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048622, this, i2, i3, i4) == null) {
            smoothScrollToPosition(i2);
        }
    }

    public void addFooterView(View view, Object obj, boolean z) {
        BdRecyclerAdapter bdRecyclerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, obj, z) == null) || (bdRecyclerAdapter = this.f35431e) == null) {
            return;
        }
        bdRecyclerAdapter.addFooterView(view, obj, z, -1);
    }

    public void addHeaderView(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, view, i2) == null) {
            this.f35431e.addHeaderView(view, i2);
        }
    }

    public void setNoData(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, view) == null) {
            View view2 = this.q;
            if (view2 != null) {
                removeHeaderView(view2);
                this.q = null;
            }
            if (view != null) {
                addHeaderView(view, null, false);
                this.q = view;
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
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f35432f = null;
        this.f35433g = null;
        this.f35434h = null;
        this.f35435i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = 100L;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = true;
        this.s = true;
        this.t = new a(this);
        this.u = new b(this);
        this.v = new c(this);
        this.w = new d(this);
        s();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f35432f = null;
        this.f35433g = null;
        this.f35434h = null;
        this.f35435i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = 100L;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = true;
        this.s = true;
        this.t = new a(this);
        this.u = new b(this);
        this.v = new c(this);
        this.w = new d(this);
        s();
    }
}
