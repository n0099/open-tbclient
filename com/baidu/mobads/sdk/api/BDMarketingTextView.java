package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.ar;
import com.baidu.mobads.sdk.internal.bq;
import com.baidu.mobads.sdk.internal.w;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BDMarketingTextView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View mAdView;
    public Context mContext;
    public ClassLoader mLoader;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BDMarketingTextView(Context context) {
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
        this.mContext = context;
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
                View view2 = (View) ar.a(w.f, a, new Class[]{Context.class}, objArr);
                this.mAdView = view2;
                if (view2 != null) {
                    addView(view2, new RelativeLayout.LayoutParams(-2, -2));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BDMarketingTextView(Context context, AttributeSet attributeSet) {
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
    public BDMarketingTextView(Context context, AttributeSet attributeSet, int i) {
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

    public void setAdData(NativeResponse nativeResponse, String str) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, nativeResponse, str) == null) && (view2 = this.mAdView) != null) {
            ar.a(w.f, view2, this.mLoader, "setAdData", new Class[]{Object.class, String.class}, nativeResponse, str);
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, truncateAt) == null) && (view2 = this.mAdView) != null) {
            ar.a(w.f, view2, this.mLoader, "setEllipsize", new Class[]{TextUtils.TruncateAt.class}, truncateAt);
        }
    }

    public void setLabelFontSizeSp(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (view2 = this.mAdView) != null) {
            ar.a(w.f, view2, this.mLoader, "setLabelFontSizeSp", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setLabelFontTypeFace(Typeface typeface) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, typeface) == null) && (view2 = this.mAdView) != null) {
            ar.a(w.f, view2, this.mLoader, "setLabelFontTypeFace", new Class[]{Typeface.class}, typeface);
        }
    }

    public void setLabelVisibility(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (view2 = this.mAdView) != null) {
            ar.a(w.f, view2, this.mLoader, "setLabelVisibility", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setLineSpacingExtra(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (view2 = this.mAdView) != null) {
            ar.a(w.f, view2, this.mLoader, "setLineSpacingExtra", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setTextFontColor(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && (view2 = this.mAdView) != null) {
            ar.a(w.f, view2, this.mLoader, "setTextFontColor", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setTextFontSizeSp(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (view2 = this.mAdView) != null) {
            ar.a(w.f, view2, this.mLoader, "setTextFontSizeSp", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setTextFontTypeFace(Typeface typeface) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, typeface) == null) && (view2 = this.mAdView) != null) {
            ar.a(w.f, view2, this.mLoader, "setTextFontTypeFace", new Class[]{Typeface.class}, typeface);
        }
    }

    public void setTextMaxLines(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && (view2 = this.mAdView) != null) {
            ar.a(w.f, view2, this.mLoader, "setTextMaxLines", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }
}
