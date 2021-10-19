package com.baidu.swan.apps.media.chooser.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class SwanAppThumbnailClickListener implements RecyclerView.OnItemTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public GestureDetectorCompat f46112a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f46113b;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppThumbnailClickListener f46114e;

        public b(SwanAppThumbnailClickListener swanAppThumbnailClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppThumbnailClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46114e = swanAppThumbnailClickListener;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View findChildViewUnder;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) || (findChildViewUnder = this.f46114e.f46113b.findChildViewUnder(motionEvent.getX(), motionEvent.getY())) == null) {
                return;
            }
            this.f46114e.onItemLongClick(this.f46114e.f46113b.getChildViewHolder(findChildViewUnder));
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                View findChildViewUnder = this.f46114e.f46113b.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if (findChildViewUnder != null) {
                    this.f46114e.onItemClick(this.f46114e.f46113b.getChildViewHolder(findChildViewUnder));
                    return true;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ b(SwanAppThumbnailClickListener swanAppThumbnailClickListener, a aVar) {
            this(swanAppThumbnailClickListener);
        }
    }

    public SwanAppThumbnailClickListener(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {recyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f46113b = recyclerView;
        this.f46112a = new GestureDetectorCompat(recyclerView.getContext(), new b(this, null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, recyclerView, motionEvent)) == null) {
            this.f46112a.onTouchEvent(motionEvent);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public abstract void onItemClick(RecyclerView.ViewHolder viewHolder);

    public abstract void onItemLongClick(RecyclerView.ViewHolder viewHolder);

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, recyclerView, motionEvent) == null) {
            this.f46112a.onTouchEvent(motionEvent);
        }
    }
}
