package com.baidu.mobads.sdk.internal.concrete;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.b;
import com.baidu.mobads.sdk.internal.a.c;
import com.baidu.mobads.sdk.internal.widget.RLRecyclerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes3.dex */
public class RLRecyclerViewDelegate extends RLRecyclerView implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c a;
    public final b b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RLRecyclerViewDelegate(IAdInterListener iAdInterListener, Object[] objArr) {
        super((Context) objArr[0]);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {iAdInterListener, objArr};
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
        b bVar = new b();
        this.b = bVar;
        setLayoutManager(bVar.a(objArr, 1, 1), this.b.a(objArr, 2, 1), this.b.a(objArr, 3, 0));
        this.a = c.a(iAdInterListener, this);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
            this.a.setTarget(obj);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a.getCode();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a.getData();
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a.getDelegator();
        }
        return (IAdInterListener) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a.getMessage();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a.getTarget();
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.getType();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, objArr)) == null) {
            if (ViewPager2Delegate.q.equals(str2)) {
                setAdapter((RecyclerView.Adapter) objArr[0]);
                return null;
            } else if ("setRefreshing".equals(str2)) {
                setRefreshing(((Boolean) objArr[0]).booleanValue());
                return null;
            } else if ("setItemDecoration".equals(str2)) {
                setItemDecoration(this.b.a(objArr, 0, 4), this.b.a(objArr, 1, 10), this.b.a(objArr, 2, 4), this.b.a(objArr, 3, 10));
                return null;
            } else if ("setRvPadding".equals(str2)) {
                setRecyclerViewPadding(this.b.a(objArr, 0, 6), this.b.a(objArr, 1, 0), this.b.a(objArr, 2, 6), this.b.a(objArr, 3, 0));
                return null;
            } else if ("setRefreshEnable".equals(str2)) {
                setEnabled(((Boolean) objArr[0]).booleanValue());
                return null;
            } else if ("scrollToPosition".equals(str2)) {
                scrollToPosition(this.b.a(objArr, 0, 0));
                return null;
            } else if ("addOnScrollListener".equals(str2)) {
                addOnScrollListener(new RecyclerView.OnScrollListener(this, objArr[0]) { // from class: com.baidu.mobads.sdk.internal.concrete.RLRecyclerViewDelegate.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Object a;
                    public final /* synthetic */ RLRecyclerViewDelegate b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr2 = {this, r7};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = this;
                        this.a = r7;
                    }

                    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, recyclerView, i) == null) {
                            super.onScrollStateChanged(recyclerView, i);
                            this.b.a.a("onScrollStateChanged", this.a, Integer.valueOf(i));
                        }
                    }

                    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                    public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                            super.onScrolled(recyclerView, i, i2);
                            this.b.a.a("onScrolled", this.a, Integer.valueOf(i), Integer.valueOf(i2));
                        }
                    }
                });
                return null;
            } else if ("setOnRefreshListener".equals(str2)) {
                setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(this) { // from class: com.baidu.mobads.sdk.internal.concrete.RLRecyclerViewDelegate.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ RLRecyclerViewDelegate a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr2 = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                    public void onRefresh() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.a.a("onRefresh");
                        }
                    }
                });
                return null;
            } else if ("findVisibleItemPositions".equals(str2)) {
                return findVisibleItemPositions();
            } else {
                if ("getLayoutManagerCounts".equals(str2)) {
                    return getLayoutManagerCounts();
                }
                if ("getRvChildAt".equals(str2)) {
                    return getRvChildAt(this.b.a(objArr, 0, -1));
                }
                if ("getRvChildCount".equals(str2)) {
                    return Integer.valueOf(getRvChildCount());
                }
                if ("indexOfRvChild".equals(str2)) {
                    return Integer.valueOf(indexOfRvChild((View) objArr[0]));
                }
                if ("getChildAdapterPosition".equals(str2)) {
                    return Integer.valueOf(getChildAdapterPosition((View) objArr[0]));
                }
                return null;
            }
        }
        return invokeLLL.objValue;
    }
}
