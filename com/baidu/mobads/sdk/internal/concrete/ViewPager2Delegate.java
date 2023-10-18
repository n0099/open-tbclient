package com.baidu.mobads.sdk.internal.concrete;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.c;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class ViewPager2Delegate extends ViewPager2 implements a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String m = "getScrollState";
    public static final String n = "getCurrentItem";
    public static final String o = "setCurrentItem";
    public static final String p = "setOrientation";
    public static final String q = "setAdapter";
    public static final String r = "setOffscreenPageLimit";
    public transient /* synthetic */ FieldHolder $fh;
    public final c s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPager2Delegate(IAdInterListener iAdInterListener, Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iAdInterListener, context};
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
        this.s = c.a(iAdInterListener, this);
        setOnOverScrollListener(new ViewPager2.OnOverScrollListener(this) { // from class: com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ViewPager2Delegate a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener
            public void onOverScrollEnd() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.s.a("onOverScrollEnd");
                }
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener
            public void onOverScrollStart() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.s.a("onOverScrollStart");
                }
            }
        });
        registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback(this) { // from class: com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ViewPager2Delegate a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                    this.a.s.a("onPageScrollStateChanged", Integer.valueOf(i3));
                }
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i3) == null) {
                    this.a.s.a("onPageSelected", Integer.valueOf(i3));
                }
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int i3, float f, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i3), Float.valueOf(f), Integer.valueOf(i4)}) == null) {
                    this.a.s.a("onPageScrolled", Integer.valueOf(i3), Float.valueOf(f), Integer.valueOf(i4));
                }
            }
        });
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
            this.s.setTarget(obj);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.s.getCode();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.s.getData();
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.s.getDelegator();
        }
        return (IAdInterListener) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.s.getMessage();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.s.getTarget();
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.s.getType();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, objArr)) == null) {
            if (m.equals(str2)) {
                return Integer.valueOf(getScrollState());
            }
            if (n.equals(str2)) {
                return Integer.valueOf(getCurrentItem());
            }
            if (o.equals(str2) && c.a(objArr, Integer.class)) {
                setCurrentItem(((Integer) objArr[0]).intValue());
                return null;
            } else if (p.equals(str2) && c.a(objArr, Integer.class)) {
                setOrientation(((Integer) objArr[0]).intValue());
                return null;
            } else if (q.equals(str2) && c.a(objArr, RecyclerView.Adapter.class)) {
                setAdapter((RecyclerView.Adapter) objArr[0]);
                return null;
            } else if (r.equals(str2) && c.a(objArr, Integer.class)) {
                setOffscreenPageLimit(((Integer) objArr[0]).intValue());
                return null;
            } else {
                return null;
            }
        }
        return invokeLLL.objValue;
    }
}
