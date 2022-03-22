package com.baidu.adp.widget.ListView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import c.a.d.o.e.d;
import c.a.d.o.e.o;
import c.a.d.o.e.p;
import c.a.d.o.e.q;
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
/* loaded from: classes3.dex */
public class BdRecyclerView extends RecyclerView implements p<BdRecyclerView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdRecyclerAdapter a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.d.a.i f23975b;

    /* renamed from: c  reason: collision with root package name */
    public i f23976c;

    /* renamed from: d  reason: collision with root package name */
    public j f23977d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView.m f23978e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView.l f23979f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f23980g;

    /* renamed from: h  reason: collision with root package name */
    public BdListView.s f23981h;
    public BdListView.o i;
    public long j;
    public c.a.d.o.e.b k;
    public c.a.d.o.e.b l;
    public View m;
    public boolean n;
    public boolean o;
    public Runnable p;
    public Runnable q;
    public Runnable r;
    public q s;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

        public final void a(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view instanceof c.a.d.h.a.h) {
                ((c.a.d.h.a.h) view).refresh();
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
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

    /* loaded from: classes3.dex */
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
            c.a.d.a.i c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f23975b != null) {
                    c2 = this.a.f23975b;
                } else {
                    c2 = c.a.d.a.j.c(this.a.getContext());
                }
                if (c2 != null) {
                    c2.onPreLoad(this.a.s);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements q {
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

        @Override // c.a.d.o.e.q
        public void cancelRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BdRecyclerView bdRecyclerView = this.a;
                bdRecyclerView.removeCallbacks(bdRecyclerView.q);
            }
        }

        @Override // c.a.d.o.e.q
        public o getAdapter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.a : (o) invokeV.objValue;
        }

        @Override // c.a.d.o.e.q
        public int getFirstVisiblePosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getFirstVisiblePosition() : invokeV.intValue;
        }

        @Override // c.a.d.o.e.q
        public int getLastVisiblePosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.getLastVisiblePosition() : invokeV.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a {
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

        @Override // c.a.d.o.e.d.a
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

    /* loaded from: classes3.dex */
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
        public void b(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                int headerViewsCount = this.a.getHeaderViewsCount();
                if (i < headerViewsCount) {
                    if (this.a.k == null || view != this.a.k.b()) {
                        if (this.a.f23978e != null) {
                            this.a.f23978e.onClick(view);
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
                    if (this.a.l == null || view != this.a.l.b()) {
                        if (this.a.f23979f != null) {
                            this.a.f23979f.onClick(view);
                            return;
                        }
                        return;
                    }
                    this.a.l.c();
                } else if (this.a.f23976c != null) {
                    this.a.f23976c.b(viewGroup, view, obj, i2, j);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public boolean a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                int headerViewsCount = i - this.a.getHeaderViewsCount();
                RecyclerView.Adapter p = this.a.a.p();
                if (p == null || headerViewsCount >= p.getItemCount() || this.a.f23977d == null) {
                    return false;
                }
                return this.a.f23977d.a(viewGroup, view, obj, headerViewsCount, j);
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class h extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdRecyclerView a;

        /* loaded from: classes3.dex */
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.f23980g == null) {
                    return;
                }
                this.a.a.f23980g.onScrollToBottom();
            }
        }

        /* loaded from: classes3.dex */
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.f23981h == null) {
                    return;
                }
                this.a.a.f23981h.onScrollToTop();
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
            c.a.d.a.i c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (this.a.f23975b != null) {
                    c2 = this.a.f23975b;
                } else {
                    c2 = c.a.d.a.j.c(this.a.getContext());
                }
                if (c2 != null) {
                    if (i == 2) {
                        BdRecyclerView bdRecyclerView = this.a;
                        bdRecyclerView.removeCallbacks(bdRecyclerView.q);
                        c2.setIsScroll(true);
                    } else if (c2.isScroll()) {
                        c2.setIsScroll(false);
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
                    if (this.a.f23980g != null) {
                        recyclerView.post(new a(this));
                    }
                } else if (!canScrollVertically2 && canScrollVertically && Math.abs(i2) > 0 && this.a.f23981h != null) {
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

    /* loaded from: classes3.dex */
    public interface i<T> {
        void b(ViewGroup viewGroup, View view, T t, int i, long j);
    }

    /* loaded from: classes3.dex */
    public interface j<T> {
        boolean a(ViewGroup viewGroup, View view, T t, int i, long j);
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
        this.f23975b = null;
        this.f23976c = null;
        this.f23977d = null;
        this.f23978e = null;
        this.f23979f = null;
        this.f23980g = null;
        this.f23981h = null;
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
        y();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.n = false;
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.n = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2, Integer.valueOf(i4)})) == null) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr, Integer.valueOf(i6)})) == null) {
            if (this.o || i6 == 0) {
                return super.dispatchNestedScroll(i2, i3, i4, i5, iArr, i6);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // c.a.d.o.e.p
    public int getContentViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
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
                return x(iArr);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getFirstVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
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
                return x(iArr);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.d.o.e.p
    public int getFooterViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.n() : invokeV.intValue;
    }

    @Override // c.a.d.o.e.p
    public int getHeaderViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a.o() : invokeV.intValue;
    }

    public int getLastCompletelyVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
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
                return w(iArr);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getLastVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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
                return w(iArr);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public o getListAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (o) getAdapter() : (o) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.p
    public BdRecyclerView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this : (BdRecyclerView) invokeV.objValue;
    }

    public q getPreLoadHandle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.s : (q) invokeV.objValue;
    }

    public RecyclerView.Adapter getWrappedAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            try {
                super.onDetachedFromWindow();
                getHandler().removeCallbacks(this.p);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void r(View view) {
        BdRecyclerAdapter bdRecyclerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, view) == null) || (bdRecyclerAdapter = this.a) == null) {
            return;
        }
        bdRecyclerAdapter.addFooterView(view);
    }

    @Override // c.a.d.o.e.p
    public boolean removeHeaderView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, view)) == null) {
            BdRecyclerAdapter bdRecyclerAdapter = this.a;
            if (bdRecyclerAdapter == null) {
                return false;
            }
            return bdRecyclerAdapter.r(view);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.n) {
            super.requestLayout();
        }
    }

    public void s(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view) == null) {
            this.a.h(view, -1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, adapter) == null) {
            super.setAdapter(null);
            this.a.s(adapter);
            super.setAdapter(this.a);
        }
    }

    public void setCanFling(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.o = z;
        }
    }

    public void setFooterView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, view) == null) {
            this.a.t(view, null, true, true, -1);
        }
    }

    public void setHeaderView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view) == null) {
            this.a.u(view, null, true, true, -1);
        }
    }

    public void setNextPage(c.a.d.o.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bVar) == null) {
            c.a.d.o.e.b bVar2 = this.l;
            if (bVar2 == null || bVar2 != bVar) {
                c.a.d.o.e.b bVar3 = this.l;
                if (bVar3 != null && bVar3 != bVar) {
                    z(bVar3.b());
                    this.l = null;
                }
                if (bVar != null) {
                    this.a.g(bVar.b(), null, true, 0);
                    this.l = bVar;
                }
            }
        }
    }

    public void setNoData(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, str) == null) || str == null) {
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
        if (interceptable == null || interceptable.invokeL(1048606, this, lVar) == null) {
            this.f23979f = lVar;
        }
    }

    public void setOnHeaderClickListener(BdListView.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, mVar) == null) {
            this.f23978e = mVar;
        }
    }

    public void setOnItemClickListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, iVar) == null) {
            this.f23976c = iVar;
        }
    }

    public void setOnItemLongClickListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, jVar) == null) {
            this.f23977d = jVar;
        }
    }

    public void setOnScrollStopDelayedListener(BdListView.o oVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048610, this, oVar, j2) == null) {
            this.i = oVar;
            this.j = j2;
        }
    }

    public void setOnSrollToBottomListener(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, pVar) == null) {
            this.f23980g = pVar;
        }
    }

    public void setOnSrollToTopListener(BdListView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, sVar) == null) {
            this.f23981h = sVar;
        }
    }

    public void setPrePage(c.a.d.o.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, bVar) == null) {
            c.a.d.o.e.b bVar2 = this.k;
            if (bVar2 == null || bVar2 != bVar) {
                c.a.d.o.e.b bVar3 = this.k;
                if (bVar3 != null) {
                    removeHeaderView(bVar3.b());
                    this.k = null;
                }
                if (bVar != null) {
                    s(bVar.b());
                    this.k = bVar;
                }
            }
        }
    }

    public void setScrollable(c.a.d.a.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, iVar) == null) {
            this.f23975b = iVar;
        }
    }

    public void setSelection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            scrollToPosition(i2);
        }
    }

    public void t(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048616, this, view, i2) == null) {
            this.a.h(view, i2);
        }
    }

    public void u(View view, Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048617, this, view, obj, z) == null) {
            this.a.i(view, obj, z, true, -1);
        }
    }

    @Nullable
    public View v(@NonNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, obj)) == null) ? this.a.l(obj) : (View) invokeL.objValue;
    }

    public final int w(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, iArr)) == null) {
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

    public final int x(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, iArr)) == null) {
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

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            setFadingEdgeLength(0);
            BdRecyclerAdapter bdRecyclerAdapter = new BdRecyclerAdapter(getContext());
            this.a = bdRecyclerAdapter;
            bdRecyclerAdapter.v(new e(this));
            this.a.w(new f(this));
            this.a.x(new g(this));
            addOnScrollListener(new h(this));
        }
    }

    public boolean z(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, view)) == null) {
            BdRecyclerAdapter bdRecyclerAdapter = this.a;
            if (bdRecyclerAdapter == null) {
                return false;
            }
            return bdRecyclerAdapter.q(view);
        }
        return invokeL.booleanValue;
    }

    public void setHeaderView(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048602, this, view, z) == null) {
            this.a.u(view, null, true, z, -1);
        }
    }

    public void setNoData(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, view) == null) {
            View view2 = this.m;
            if (view2 != null) {
                removeHeaderView(view2);
                this.m = null;
            }
            if (view != null) {
                u(view, null, false);
                this.m = view;
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
        this.f23975b = null;
        this.f23976c = null;
        this.f23977d = null;
        this.f23978e = null;
        this.f23979f = null;
        this.f23980g = null;
        this.f23981h = null;
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
        y();
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
        this.f23975b = null;
        this.f23976c = null;
        this.f23977d = null;
        this.f23978e = null;
        this.f23979f = null;
        this.f23980g = null;
        this.f23981h = null;
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
        y();
    }
}
