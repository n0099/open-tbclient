package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.ar;
import com.baidu.mobads.sdk.internal.bq;
import com.baidu.mobads.sdk.internal.w;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class FeedNativeView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View mAdView;
    public Context mContext;
    public ClassLoader mLoader;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedNativeView(Context context) {
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
        init(context);
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            this.mContext = context;
            Object[] objArr = {context};
            ClassLoader a = bq.a(context);
            this.mLoader = a;
            View view2 = (View) ar.a(w.e, a, new Class[]{Context.class}, objArr);
            this.mAdView = view2;
            if (view2 != null) {
                addView(view2, new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedNativeView(Context context, AttributeSet attributeSet) {
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
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedNativeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        init(context);
    }

    public void changeViewLayoutParams(Object obj) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (view2 = this.mAdView) != null) {
            ar.a(w.e, view2, this.mLoader, "changeLayoutParams", new Class[]{Object.class}, obj);
        }
    }

    public void setAdData(XAdNativeResponse xAdNativeResponse) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, xAdNativeResponse) == null) && (view2 = this.mAdView) != null) {
            ar.a(w.e, view2, this.mLoader, "setAdResponse", new Class[]{Object.class}, xAdNativeResponse);
        }
    }

    public int getAdContainerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view2 = this.mAdView;
            if (view2 != null) {
                Object a = ar.a(w.e, view2, this.mLoader, "getAdContainerHeight", new Class[0], new Object[0]);
                if (a instanceof Number) {
                    return ((Integer) a).intValue();
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getAdContainerWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            View view2 = this.mAdView;
            if (view2 != null) {
                Object a = ar.a(w.e, view2, this.mLoader, "getAdContainerWidth", new Class[0], new Object[0]);
                if (a instanceof Number) {
                    return ((Integer) a).intValue();
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public RelativeLayout getContainerView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View view2 = this.mAdView;
            if (view2 != null) {
                return (RelativeLayout) ar.a(w.e, view2, this.mLoader, "getAdView", new Class[0], new Object[0]);
            }
            return null;
        }
        return (RelativeLayout) invokeV.objValue;
    }
}
