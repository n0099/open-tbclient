package com.baidu.mobads.sdk.internal.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class RLRecyclerView extends SwipeRefreshLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView a;
    public int[] b;
    public int[] c;
    public int[] d;

    /* loaded from: classes3.dex */
    public static class NormalItemDecoration extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final int b;
        public final int c;
        public final int d;

        public NormalItemDecoration(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view2, recyclerView, state) == null) {
                rect.left = this.a;
                rect.top = this.b;
                rect.right = this.c;
                rect.bottom = this.d;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RLRecyclerView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new int[2];
        this.d = new int[2];
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RLRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new int[2];
        this.d = new int[2];
        a(context);
    }

    private int a(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, iArr)) == null) {
            if (iArr != null && iArr.length > 0) {
                int i = iArr[0];
                for (int i2 : iArr) {
                    if (i2 < i) {
                        i = i2;
                    }
                }
                return i;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    private int b(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, iArr)) == null) {
            if (iArr != null && iArr.length > 0) {
                int i = iArr[0];
                for (int i2 : iArr) {
                    if (i2 > i) {
                        i = i2;
                    }
                }
                return i;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, onScrollListener) == null) && (recyclerView = this.a) != null) {
            recyclerView.addOnScrollListener(onScrollListener);
        }
    }

    public int getChildAdapterPosition(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            RecyclerView recyclerView = this.a;
            if (recyclerView != null) {
                return recyclerView.getChildAdapterPosition(view2);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public View getRvChildAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            RecyclerView recyclerView = this.a;
            if (recyclerView != null) {
                return recyclerView.getChildAt(i);
            }
            return null;
        }
        return (View) invokeI.objValue;
    }

    public int indexOfRvChild(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            RecyclerView recyclerView = this.a;
            if (recyclerView != null) {
                return recyclerView.indexOfChild(view2);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void scrollToPosition(int i) {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (recyclerView = this.a) != null) {
            recyclerView.scrollToPosition(i);
        }
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adapter) == null) && (recyclerView = this.a) != null) {
            recyclerView.setAdapter(adapter);
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            this.a = new RecyclerView(context);
            addView(this.a, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public int[] findVisibleItemPositions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            RecyclerView recyclerView = this.a;
            if (recyclerView != null) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof GridLayoutManager) {
                    GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                    this.d[0] = gridLayoutManager.findFirstVisibleItemPosition();
                    this.d[1] = gridLayoutManager.findLastVisibleItemPosition();
                    return this.d;
                } else if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    this.d[0] = linearLayoutManager.findFirstVisibleItemPosition();
                    this.d[1] = linearLayoutManager.findLastVisibleItemPosition();
                    return this.d;
                } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                    StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                    if (this.b == null) {
                        this.b = new int[staggeredGridLayoutManager.getSpanCount()];
                    }
                    staggeredGridLayoutManager.findFirstVisibleItemPositions(this.b);
                    this.d[0] = a(this.b);
                    staggeredGridLayoutManager.findLastVisibleItemPositions(this.b);
                    this.d[1] = b(this.b);
                    return this.d;
                } else {
                    return null;
                }
            }
            return null;
        }
        return (int[]) invokeV.objValue;
    }

    public int[] getLayoutManagerCounts() {
        InterceptResult invokeV;
        RecyclerView.LayoutManager layoutManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            RecyclerView recyclerView = this.a;
            if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null) {
                this.c[0] = layoutManager.getItemCount();
                this.c[1] = layoutManager.getChildCount();
                return this.c;
            }
            return null;
        }
        return (int[]) invokeV.objValue;
    }

    public int getRvChildCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RecyclerView recyclerView = this.a;
            if (recyclerView != null) {
                return recyclerView.getChildCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void setItemDecoration(int i, int i2, int i3, int i4) {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048585, this, i, i2, i3, i4) == null) && (recyclerView = this.a) != null) {
            recyclerView.addItemDecoration(new NormalItemDecoration(i, i2, i3, i4));
        }
    }

    public void setRecyclerViewPadding(int i, int i2, int i3, int i4) {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048587, this, i, i2, i3, i4) == null) && (recyclerView = this.a) != null) {
            recyclerView.setPadding(i, i2, i3, i4);
        }
    }

    public void setLayoutManager(int i, int i2, int i3) {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048586, this, i, i2, i3) == null) && (recyclerView = this.a) != null) {
            if (1 == i) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            } else if (2 == i) {
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), i2));
            } else if (3 == i) {
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(i2, i3));
            }
        }
    }
}
