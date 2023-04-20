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
import com.baidu.tieba.f9;
import com.baidu.tieba.g9;
import com.baidu.tieba.jn;
import com.baidu.tieba.kn;
import com.baidu.tieba.mn;
import com.baidu.tieba.qk;
import com.baidu.tieba.vp5;
import com.baidu.tieba.wm;
import com.baidu.tieba.ym;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class BdRecyclerView extends RecyclerView implements kn<BdRecyclerView> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REFRESH_DELAY = 100;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean canFling;
    public boolean isAllowLayout;
    public BdRecyclerAdapter mAdapter;
    public Runnable mDelayedRunnable;
    public wm mNextPage;
    public View mNoDataView;
    public BdListView.l mOnFooterClickListener;
    public BdListView.m mOnHeaderClickListener;
    public i mOnItemClickListener;
    public j mOnItemLongClickListener;
    public BdListView.p mOnScrollToBottomListener;
    public BdListView.s mOnScrollToTopListener;
    public BdListView.o mOnScrolledDelayedListener;
    public long mOnScrolledDelayedMillis;
    public mn mPreLoadListView;
    public wm mPrePage;
    public f9 mScrollable;
    public Runnable preLoadRunnable;
    public Runnable refreshRunnable;

    /* loaded from: classes.dex */
    public interface i<T> {
        void b(ViewGroup viewGroup, View view2, T t, int i, long j);
    }

    /* loaded from: classes.dex */
    public interface j<T> {
        boolean a(ViewGroup viewGroup, View view2, T t, int i, long j);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    public BdRecyclerView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this : (BdRecyclerView) invokeV.objValue;
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.mOnScrollToBottomListener != null) {
                    this.a.a.mOnScrollToBottomListener.onScrollToBottom();
                }
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.mOnScrollToTopListener != null) {
                    this.a.a.mOnScrollToTopListener.onScrollToTop();
                }
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
            f9 c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (this.a.mScrollable == null) {
                    c = g9.c(this.a.getContext());
                } else {
                    c = this.a.mScrollable;
                }
                if (c != null) {
                    if (i == 2) {
                        BdRecyclerView bdRecyclerView = this.a;
                        bdRecyclerView.removeCallbacks(bdRecyclerView.refreshRunnable);
                        c.setIsScroll(true);
                    } else if (c.isScroll()) {
                        c.setIsScroll(false);
                        BdRecyclerView bdRecyclerView2 = this.a;
                        bdRecyclerView2.removeCallbacks(bdRecyclerView2.refreshRunnable);
                        BdRecyclerView bdRecyclerView3 = this.a;
                        bdRecyclerView3.postDelayed(bdRecyclerView3.refreshRunnable, 100L);
                    } else if (i == 0) {
                        BdRecyclerView bdRecyclerView4 = this.a;
                        bdRecyclerView4.removeCallbacks(bdRecyclerView4.preLoadRunnable);
                        BdRecyclerView bdRecyclerView5 = this.a;
                        bdRecyclerView5.postDelayed(bdRecyclerView5.preLoadRunnable, 100L);
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
                    if (this.a.mOnScrollToBottomListener != null) {
                        recyclerView.post(new a(this));
                    }
                } else if (!canScrollVertically2 && canScrollVertically && Math.abs(i2) > 0 && this.a.mOnScrollToTopListener != null) {
                    recyclerView.post(new b(this));
                }
                if (this.a.mOnScrolledDelayedListener != null && this.a.mOnScrolledDelayedMillis > 0) {
                    this.a.getHandler().removeCallbacks(this.a.mDelayedRunnable);
                    this.a.getHandler().postDelayed(this.a.mDelayedRunnable, this.a.mOnScrolledDelayedMillis);
                }
            }
        }
    }

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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.mOnScrolledDelayedListener != null) {
                int firstVisiblePosition = this.a.getFirstVisiblePosition();
                int lastVisiblePosition = this.a.getLastVisiblePosition();
                int i = 0;
                int i2 = -1;
                if (this.a.mAdapter != null && this.a.mAdapter.y() != null && this.a.mAdapter.y().getItemCount() > 0) {
                    int x = firstVisiblePosition - this.a.mAdapter.x();
                    if (x < 0) {
                        i2 = 0;
                    } else {
                        i2 = x;
                    }
                    int x2 = lastVisiblePosition - this.a.mAdapter.x();
                    if (x2 >= this.a.mAdapter.y().getItemCount()) {
                        x2 = this.a.mAdapter.y().getItemCount() - 1;
                    }
                    if (x2 >= 0) {
                        i = x2;
                    }
                } else {
                    i = -1;
                }
                this.a.mOnScrolledDelayedListener.onScrollStop(i2, i);
            }
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            if (view2 instanceof qk) {
                ((qk) view2).refresh();
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
                this.a.preLoadRunnable.run();
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
            f9 c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.mScrollable == null) {
                    c = g9.c(this.a.getContext());
                } else {
                    c = this.a.mScrollable;
                }
                if (c != null) {
                    c.onPreLoad(this.a.mPreLoadListView);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements mn {
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

        @Override // com.baidu.tieba.mn
        public void cancelRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BdRecyclerView bdRecyclerView = this.a;
                bdRecyclerView.removeCallbacks(bdRecyclerView.refreshRunnable);
            }
        }

        @Override // com.baidu.tieba.mn
        public jn getAdapter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                return (jn) invokeV.objValue;
            }
            return this.a.mAdapter;
        }

        @Override // com.baidu.tieba.mn
        public int getFirstVisiblePosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a.getFirstVisiblePosition();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.mn
        public int getLastVisiblePosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a.getLastVisiblePosition();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes.dex */
    public class e implements ym.a {
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

        @Override // com.baidu.tieba.ym.a
        public void onPreLoad() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BdRecyclerView bdRecyclerView = this.a;
                bdRecyclerView.removeCallbacks(bdRecyclerView.preLoadRunnable);
                BdRecyclerView bdRecyclerView2 = this.a;
                bdRecyclerView2.postDelayed(bdRecyclerView2.preLoadRunnable, 100L);
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
                    if (this.a.mPrePage != null && view2 == this.a.mPrePage.c()) {
                        this.a.mPrePage.d();
                        return;
                    } else if (this.a.mOnHeaderClickListener != null) {
                        this.a.mOnHeaderClickListener.onClick(view2);
                        return;
                    } else {
                        return;
                    }
                }
                int i2 = i - headerViewsCount;
                RecyclerView.Adapter y = this.a.mAdapter.y();
                if (y != null && i2 < y.getItemCount()) {
                    if (this.a.mOnItemClickListener != null) {
                        this.a.mOnItemClickListener.b(viewGroup, view2, obj, i2, j);
                    }
                } else if (this.a.mNextPage != null && view2 == this.a.mNextPage.c()) {
                    this.a.mNextPage.d();
                } else if (this.a.mOnFooterClickListener != null) {
                    this.a.mOnFooterClickListener.onClick(view2);
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
                RecyclerView.Adapter y = this.a.mAdapter.y();
                if (y != null && headerViewsCount < y.getItemCount() && this.a.mOnItemLongClickListener != null) {
                    return this.a.mOnItemLongClickListener.a(viewGroup, view2, obj, headerViewsCount, j);
                }
                return false;
            }
            return invokeCommon.booleanValue;
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
        this.mScrollable = null;
        this.mOnItemClickListener = null;
        this.mOnItemLongClickListener = null;
        this.mOnHeaderClickListener = null;
        this.mOnFooterClickListener = null;
        this.mOnScrollToBottomListener = null;
        this.mOnScrollToTopListener = null;
        this.mOnScrolledDelayedListener = null;
        this.mOnScrolledDelayedMillis = 100L;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.isAllowLayout = true;
        this.canFling = true;
        this.mDelayedRunnable = new a(this);
        this.refreshRunnable = new b(this);
        this.preLoadRunnable = new c(this);
        this.mPreLoadListView = new d(this);
        initial();
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
        this.mScrollable = null;
        this.mOnItemClickListener = null;
        this.mOnItemLongClickListener = null;
        this.mOnHeaderClickListener = null;
        this.mOnFooterClickListener = null;
        this.mOnScrollToBottomListener = null;
        this.mOnScrollToTopListener = null;
        this.mOnScrolledDelayedListener = null;
        this.mOnScrolledDelayedMillis = 100L;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.isAllowLayout = true;
        this.canFling = true;
        this.mDelayedRunnable = new a(this);
        this.refreshRunnable = new b(this);
        this.preLoadRunnable = new c(this);
        this.mPreLoadListView = new d(this);
        initial();
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
        this.mScrollable = null;
        this.mOnItemClickListener = null;
        this.mOnItemLongClickListener = null;
        this.mOnHeaderClickListener = null;
        this.mOnFooterClickListener = null;
        this.mOnScrollToBottomListener = null;
        this.mOnScrollToTopListener = null;
        this.mOnScrolledDelayedListener = null;
        this.mOnScrolledDelayedMillis = 100L;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.isAllowLayout = true;
        this.canFling = true;
        this.mDelayedRunnable = new a(this);
        this.refreshRunnable = new b(this);
        this.preLoadRunnable = new c(this);
        this.mPreLoadListView = new d(this);
        initial();
    }

    private int findMax(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, iArr)) == null) {
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

    private int findMin(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, this, iArr)) == null) {
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

    public void addFooterView(View view2) {
        BdRecyclerAdapter bdRecyclerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || (bdRecyclerAdapter = this.mAdapter) == null) {
            return;
        }
        bdRecyclerAdapter.n(view2);
    }

    public void addHeaderView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            this.mAdapter.p(view2, -1);
        }
    }

    public boolean removeFooterView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, view2)) == null) {
            BdRecyclerAdapter bdRecyclerAdapter = this.mAdapter;
            if (bdRecyclerAdapter == null) {
                return false;
            }
            return bdRecyclerAdapter.z(view2);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.kn
    public boolean removeHeaderView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, view2)) == null) {
            BdRecyclerAdapter bdRecyclerAdapter = this.mAdapter;
            if (bdRecyclerAdapter == null) {
                return false;
            }
            return bdRecyclerAdapter.B(view2);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            try {
                super.removeViewAt(i2);
            } catch (NullPointerException e2) {
                vp5.a(this, i2, e2);
                throw e2;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, adapter) == null) {
            super.setAdapter(null);
            this.mAdapter.D(adapter);
            super.setAdapter(this.mAdapter);
        }
    }

    public void setCanFling(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.canFling = z;
        }
    }

    public void setFooterView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, view2) == null) {
            this.mAdapter.E(view2, null, true, true, -1);
        }
    }

    public void setHeaderView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, view2) == null) {
            this.mAdapter.F(view2, null, true, true, -1);
        }
    }

    public void setNoData(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, view2) == null) {
            View view3 = this.mNoDataView;
            if (view3 != null) {
                removeHeaderView(view3);
                this.mNoDataView = null;
            }
            if (view2 != null) {
                addHeaderView(view2, null, false);
                this.mNoDataView = view2;
            }
        }
    }

    public void setOnHeaderClickListener(BdListView.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, mVar) == null) {
            this.mOnHeaderClickListener = mVar;
        }
    }

    public void setOnItemClickListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, iVar) == null) {
            this.mOnItemClickListener = iVar;
        }
    }

    public void setOnItemLongClickListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, jVar) == null) {
            this.mOnItemLongClickListener = jVar;
        }
    }

    public void setOnScrollToTopListener(@Nullable BdListView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, sVar) == null) {
            this.mOnScrollToTopListener = sVar;
        }
    }

    public void setOnSrollToBottomListener(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, pVar) == null) {
            this.mOnScrollToBottomListener = pVar;
        }
    }

    public void setScrollable(f9 f9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, f9Var) == null) {
            this.mScrollable = f9Var;
        }
    }

    public void setSelection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            scrollToPosition(i2);
        }
    }

    private void initial() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            setFadingEdgeLength(0);
            BdRecyclerAdapter bdRecyclerAdapter = new BdRecyclerAdapter(getContext());
            this.mAdapter = bdRecyclerAdapter;
            bdRecyclerAdapter.G(new e(this));
            this.mAdapter.H(new f(this));
            this.mAdapter.I(new g(this));
            addOnScrollListener(new h(this));
        }
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
            if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
                return 0;
            }
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
            staggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(iArr);
            return findMin(iArr);
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
            if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
                return 0;
            }
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
            staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr);
            return findMin(iArr);
        }
        return invokeV.intValue;
    }

    public int getLastVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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
            if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
                return 0;
            }
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
            staggeredGridLayoutManager.findLastVisibleItemPositions(iArr);
            return findMax(iArr);
        }
        return invokeV.intValue;
    }

    public void addFooterView(View view2, Object obj, boolean z) {
        BdRecyclerAdapter bdRecyclerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, obj, z) != null) || (bdRecyclerAdapter = this.mAdapter) == null) {
            return;
        }
        bdRecyclerAdapter.o(view2, obj, z, -1);
    }

    public void addHeaderView(View view2, Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, view2, obj, z) == null) {
            this.mAdapter.q(view2, obj, z, true, -1);
        }
    }

    public void smoothScrollToPosition(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048620, this, i2, i3, i4) == null) {
            smoothScrollToPosition(i2);
        }
    }

    public void addHeaderView(View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, view2, i2) == null) {
            this.mAdapter.p(view2, i2);
        }
    }

    public boolean removeFooterViewByPos(View view2, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048597, this, view2, i2)) == null) {
            BdRecyclerAdapter bdRecyclerAdapter = this.mAdapter;
            if (bdRecyclerAdapter == null) {
                return false;
            }
            return bdRecyclerAdapter.A(view2, i2);
        }
        return invokeLI.booleanValue;
    }

    public boolean removeHeaderViewByPos(View view2, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, view2, i2)) == null) {
            BdRecyclerAdapter bdRecyclerAdapter = this.mAdapter;
            if (bdRecyclerAdapter == null) {
                return false;
            }
            return bdRecyclerAdapter.C(view2, i2);
        }
        return invokeLI.booleanValue;
    }

    public void setHeaderView(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048606, this, view2, z) == null) {
            this.mAdapter.F(view2, null, true, z, -1);
        }
    }

    public void setOnScrollStopDelayedListener(BdListView.o oVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048613, this, oVar, j2) == null) {
            this.mOnScrolledDelayedListener = oVar;
            this.mOnScrolledDelayedMillis = j2;
        }
    }

    public void smoothScrollToPosition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048619, this, i2, i3) == null) {
            smoothScrollToPosition(i2);
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

    public void setPrePage(wm wmVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, wmVar) == null) {
            wm wmVar2 = this.mPrePage;
            if (wmVar2 != null && wmVar2 == wmVar) {
                return;
            }
            wm wmVar3 = this.mPrePage;
            if (wmVar3 != null) {
                int b2 = wmVar3.b();
                if (b2 >= 0) {
                    removeHeaderViewByPos(this.mPrePage.c(), b2);
                } else {
                    removeHeaderView(this.mPrePage.c());
                }
                this.mPrePage = null;
            }
            if (wmVar != null) {
                this.mAdapter.p(wmVar.c(), 0);
                this.mPrePage = wmVar;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2, Integer.valueOf(i4)})) == null) {
            if (!this.canFling && i4 != 0) {
                return false;
            }
            return super.dispatchNestedPreScroll(i2, i3, iArr, iArr2, i4);
        }
        return invokeCommon.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr, Integer.valueOf(i6)})) == null) {
            if (!this.canFling && i6 != 0) {
                return false;
            }
            return super.dispatchNestedScroll(i2, i3, i4, i5, iArr, i6);
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tieba.kn
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

    @Override // com.baidu.tieba.kn
    public int getFooterViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mAdapter.u();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.kn
    public int getHeaderViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mAdapter.x();
        }
        return invokeV.intValue;
    }

    public jn getListAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return (jn) getAdapter();
        }
        return (jn) invokeV.objValue;
    }

    public mn getPreLoadHandle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mPreLoadListView;
        }
        return (mn) invokeV.objValue;
    }

    public RecyclerView.Adapter getWrappedAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            BdRecyclerAdapter bdRecyclerAdapter = this.mAdapter;
            if (bdRecyclerAdapter != null) {
                return bdRecyclerAdapter.y();
            }
            return null;
        }
        return (RecyclerView.Adapter) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            try {
                super.onDetachedFromWindow();
                getHandler().removeCallbacks(this.mDelayedRunnable);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.isAllowLayout) {
            super.requestLayout();
        }
    }

    public void startInterceptLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.isAllowLayout = false;
        }
    }

    public void stopIntercerceptLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.isAllowLayout = true;
        }
    }

    public void setNextPage(wm wmVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, wmVar) == null) {
            wm wmVar2 = this.mNextPage;
            if (wmVar2 != null && wmVar2 == wmVar) {
                return;
            }
            wm wmVar3 = this.mNextPage;
            if (wmVar3 != null) {
                int b2 = wmVar3.b();
                if (b2 >= 0) {
                    removeFooterViewByPos(this.mNextPage.c(), b2);
                } else {
                    removeFooterView(this.mNextPage.c());
                }
                removeFooterView(this.mNextPage.c());
                this.mNextPage = null;
            }
            if (wmVar != null) {
                this.mAdapter.o(wmVar.c(), null, true, 0);
                this.mNextPage = wmVar;
            }
        }
    }

    public void setNoData(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, str) == null) && str != null) {
            TextView textView = new TextView(getContext());
            textView.setText(str);
            textView.setTextSize(16.0f);
            textView.setGravity(17);
            setNoData(textView);
        }
    }
}
