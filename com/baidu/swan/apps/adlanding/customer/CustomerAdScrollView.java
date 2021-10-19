package com.baidu.swan.apps.adlanding.customer;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
import c.a.p0.a.q.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class CustomerAdScrollView extends ScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45571e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f45572f;

    /* renamed from: g  reason: collision with root package name */
    public float f45573g;

    /* renamed from: h  reason: collision with root package name */
    public a f45574h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomerAdScrollView(Context context) {
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
        this.f45571e = false;
        this.f45572f = false;
        this.f45574h = null;
        setVerticalScrollBarEnabled(false);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f45573g = y;
            } else if (action == 2) {
                if (y - this.f45573g < 0.0f) {
                    if (!this.f45571e || this.f45572f) {
                        return false;
                    }
                } else if (!this.f45572f) {
                    return false;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) {
            super.onScrollChanged(i2, i3, i4, i5);
            a aVar = this.f45574h;
            if (aVar != null) {
                aVar.onScrollChanged(i2, i3, i4, i5);
            }
        }
    }

    public void setIsFooterLayoutShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f45572f = z;
        }
    }

    public void setIsWebViewOnBottom(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f45571e = z;
        }
    }

    public void setScrollViewListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f45574h = aVar;
        }
    }
}
