package com.baidu.pass.ecommerce.view;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class ScrollRecyclerView extends RecyclerView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CompositeScrollListener compositeScrollListener;

    /* loaded from: classes4.dex */
    public static class CompositeScrollListener extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<RecyclerView.OnScrollListener> scrollListenerList;

        public CompositeScrollListener() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.scrollListenerList = new ArrayList();
        }

        public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, onScrollListener) == null) || onScrollListener == null) {
                return;
            }
            for (RecyclerView.OnScrollListener onScrollListener2 : this.scrollListenerList) {
                if (onScrollListener == onScrollListener2) {
                    return;
                }
            }
            this.scrollListenerList.add(onScrollListener);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2) == null) {
                for (RecyclerView.OnScrollListener onScrollListener : new ArrayList(this.scrollListenerList)) {
                    onScrollListener.onScrollStateChanged(recyclerView, i2);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                for (RecyclerView.OnScrollListener onScrollListener : new ArrayList(this.scrollListenerList)) {
                    onScrollListener.onScrolled(recyclerView, i2, i3);
                }
            }
        }

        public void removeOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, onScrollListener) == null) || onScrollListener == null) {
                return;
            }
            Iterator<RecyclerView.OnScrollListener> it = this.scrollListenerList.iterator();
            while (it.hasNext()) {
                if (onScrollListener == it.next()) {
                    it.remove();
                    return;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface RecyclerViewItemClickListener<T> {
        void onItemClickListener(int i2, T t);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollRecyclerView(@NonNull Context context) {
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
        CompositeScrollListener compositeScrollListener = new CompositeScrollListener();
        this.compositeScrollListener = compositeScrollListener;
        super.addOnScrollListener(compositeScrollListener);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.baidu.pass.ecommerce.view.ScrollRecyclerView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ScrollRecyclerView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ViewGroup.LayoutParams layoutParams = this.this$0.getLayoutParams();
                    ViewParent parent = this.this$0.getParent();
                    while (true) {
                        if (parent == null) {
                            break;
                        } else if (parent instanceof ScrollLayout) {
                            ScrollLayout scrollLayout = (ScrollLayout) parent;
                            int measuredHeight = scrollLayout.getMeasuredHeight() - scrollLayout.openedOffset;
                            if (layoutParams.height == measuredHeight) {
                                return;
                            }
                            layoutParams.height = measuredHeight;
                        } else {
                            parent = parent.getParent();
                        }
                    }
                    this.this$0.setLayoutParams(layoutParams);
                }
            }
        });
    }

    private void throwIfNotOnMainThread() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Must be invoked from the main thread.");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onAttachedToWindow();
            for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof ScrollLayout) {
                    ((ScrollLayout) parent).setAssociatedRecyclerView(this);
                    return;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        CompositeScrollListener compositeScrollListener = new CompositeScrollListener();
        this.compositeScrollListener = compositeScrollListener;
        super.addOnScrollListener(compositeScrollListener);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.baidu.pass.ecommerce.view.ScrollRecyclerView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ScrollRecyclerView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ViewGroup.LayoutParams layoutParams = this.this$0.getLayoutParams();
                    ViewParent parent = this.this$0.getParent();
                    while (true) {
                        if (parent == null) {
                            break;
                        } else if (parent instanceof ScrollLayout) {
                            ScrollLayout scrollLayout = (ScrollLayout) parent;
                            int measuredHeight = scrollLayout.getMeasuredHeight() - scrollLayout.openedOffset;
                            if (layoutParams.height == measuredHeight) {
                                return;
                            }
                            layoutParams.height = measuredHeight;
                        } else {
                            parent = parent.getParent();
                        }
                    }
                    this.this$0.setLayoutParams(layoutParams);
                }
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        CompositeScrollListener compositeScrollListener = new CompositeScrollListener();
        this.compositeScrollListener = compositeScrollListener;
        super.addOnScrollListener(compositeScrollListener);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.baidu.pass.ecommerce.view.ScrollRecyclerView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ScrollRecyclerView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ViewGroup.LayoutParams layoutParams = this.this$0.getLayoutParams();
                    ViewParent parent = this.this$0.getParent();
                    while (true) {
                        if (parent == null) {
                            break;
                        } else if (parent instanceof ScrollLayout) {
                            ScrollLayout scrollLayout = (ScrollLayout) parent;
                            int measuredHeight = scrollLayout.getMeasuredHeight() - scrollLayout.openedOffset;
                            if (layoutParams.height == measuredHeight) {
                                return;
                            }
                            layoutParams.height = measuredHeight;
                        } else {
                            parent = parent.getParent();
                        }
                    }
                    this.this$0.setLayoutParams(layoutParams);
                }
            }
        });
    }
}
