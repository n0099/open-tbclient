package com.baidu.live.feed.search.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class LoadRecyclerView extends RecyclerView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public float b;
    public float c;
    public int d;
    public int e;
    public int f;
    public RecyclerView.LayoutManager g;
    public boolean h;
    public boolean i;
    public int j;
    public boolean k;
    public RecyclerView.OnScrollListener l;

    /* loaded from: classes2.dex */
    public interface b {
        void a(boolean z);

        void b(boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1162710450, "Lcom/baidu/live/feed/search/view/LoadRecyclerView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1162710450, "Lcom/baidu/live/feed/search/view/LoadRecyclerView;");
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ LoadRecyclerView b;

        public a(LoadRecyclerView loadRecyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loadRecyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = loadRecyclerView;
            this.a = false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (this.b.g.isSmoothScrolling()) {
                    this.b.k = true;
                }
                if (i != 0 || this.b.g.getChildCount() == 0) {
                    return;
                }
                if (this.b.g instanceof LinearLayoutManager) {
                    i2 = ((LinearLayoutManager) this.b.g).findLastVisibleItemPosition();
                } else if (this.b.g instanceof StaggeredGridLayoutManager) {
                    int[] findLastVisibleItemPositions = ((StaggeredGridLayoutManager) this.b.g).findLastVisibleItemPositions(null);
                    i2 = Math.max(findLastVisibleItemPositions[0], findLastVisibleItemPositions[1]);
                } else {
                    i2 = 0;
                }
                if (this.b.g instanceof LinearLayoutManager) {
                    i3 = ((LinearLayoutManager) this.b.g).findFirstVisibleItemPosition();
                } else if (this.b.g instanceof StaggeredGridLayoutManager) {
                    int[] findFirstVisibleItemPositions = ((StaggeredGridLayoutManager) this.b.g).findFirstVisibleItemPositions(null);
                    i3 = Math.min(findFirstVisibleItemPositions[0], findFirstVisibleItemPositions[1]);
                } else {
                    i3 = 0;
                }
                if (!this.a || i2 + this.b.f != this.b.g.getItemCount() - 1) {
                    if (i3 == 0) {
                        this.b.j();
                    }
                } else {
                    this.b.i();
                }
                this.b.k = false;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (i2 > 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.a = z;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadRecyclerView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = 0;
        this.j = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.l = new a(this);
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f = 0;
        this.j = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.l = new a(this);
        g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, layoutManager) == null) {
            this.g = layoutManager;
            super.setLayoutManager(layoutManager);
        }
    }

    public void setOnLoadListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.a = bVar;
        }
    }

    public void setPreloadLocation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.f = i + 1;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 2) {
                    float abs = Math.abs(this.b - motionEvent.getX());
                    float abs2 = Math.abs(this.c - motionEvent.getY());
                    if (abs2 > abs && abs2 >= this.j) {
                        if (motionEvent.getY() > this.c && this.d == 0) {
                            j();
                        } else if (motionEvent.getY() < this.c && this.e == this.g.getItemCount() - 1) {
                            i();
                        }
                    }
                }
            } else {
                this.c = motionEvent.getY();
                this.b = motionEvent.getX();
                RecyclerView.LayoutManager layoutManager = this.g;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.d = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                    this.e = ((LinearLayoutManager) this.g).findLastVisibleItemPosition();
                } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                    int[] findFirstVisibleItemPositions = ((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(null);
                    this.d = Math.min(findFirstVisibleItemPositions[0], findFirstVisibleItemPositions[1]);
                    int[] findLastVisibleItemPositions = ((StaggeredGridLayoutManager) this.g).findLastVisibleItemPositions(null);
                    this.e = Math.max(findLastVisibleItemPositions[0], findLastVisibleItemPositions[1]);
                }
            }
            try {
                return super.dispatchTouchEvent(motionEvent);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.i = false;
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !this.i) {
            this.i = true;
            b bVar = this.a;
            if (bVar != null) {
                bVar.a(this.k);
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !this.h) {
            this.h = true;
            b bVar = this.a;
            if (bVar != null) {
                bVar.b(this.k);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            addOnScrollListener(this.l);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            removeOnScrollListener(this.l);
            super.onDetachedFromWindow();
        }
    }
}
