package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.ar;
import com.baidu.mobads.sdk.internal.bq;
import com.baidu.mobads.sdk.internal.w;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BDRefinedActButton extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View mAdView;
    public Context mContext;
    public ClassLoader mLoader;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BDRefinedActButton(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BDRefinedActButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BDRefinedActButton(Context context, AttributeSet attributeSet, int i) {
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
        initView(context);
    }

    private void initView(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            try {
                this.mContext = context;
                Object[] objArr = {context};
                ClassLoader a = bq.a(context);
                this.mLoader = a;
                View view2 = (View) ar.a(w.h, a, new Class[]{Context.class}, objArr);
                this.mAdView = view2;
                if (view2 != null) {
                    addView(view2, new RelativeLayout.LayoutParams(-2, -2));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setAdData(NativeResponse nativeResponse) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, nativeResponse) == null) && (view2 = this.mAdView) != null) {
            ar.a(w.h, view2, this.mLoader, "setAdData", new Class[]{Object.class}, nativeResponse);
        }
    }

    public void setButtonBackgroundColor(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (view2 = this.mAdView) != null) {
            ar.a(w.h, view2, this.mLoader, "setButtonBackgroundColor", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setButtonFontSizeSp(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (view2 = this.mAdView) != null) {
            ar.a(w.h, view2, this.mLoader, "setButtonFontSizeSp", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setButtonFontTypeFace(Typeface typeface) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, typeface) == null) && (view2 = this.mAdView) != null) {
            ar.a(w.h, view2, this.mLoader, "setButtonFontTypeFace", new Class[]{Typeface.class}, typeface);
        }
    }

    public void setButtonTextColor(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (view2 = this.mAdView) != null) {
            ar.a(w.h, view2, this.mLoader, "setButtonTextColor", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setIsShowDialog(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (view2 = this.mAdView) != null) {
            ar.a(w.h, view2, this.mLoader, "setIsShowDialog", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }
}
