package com.baidu.mobads.sdk.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.ax;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.cp;
import com.baidu.mobads.sdk.internal.cq;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public final class AdView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean AUTOPLAY = true;
    public static final float HEIGHT_FACTOR = 0.15f;
    public static final String P_VERSION = "3.61";
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicBoolean hasCalledRequestMethod;
    public cq mAdProd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdView(Context context) {
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
        this.hasCalledRequestMethod = new AtomicBoolean(false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdView(Context context, AttributeSet attributeSet, boolean z, AdSize adSize, String str) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Boolean.valueOf(z), adSize, str};
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
        this.hasCalledRequestMethod = new AtomicBoolean(false);
        cp cpVar = new cp(context);
        this.mAdProd = new cq(this, context, cpVar, str, z);
        cpVar.a(new cp.a(this) { // from class: com.baidu.mobads.sdk.api.AdView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.mobads.sdk.internal.cp.a
            public void onWindowFocusChanged(boolean z2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048580, this, z2) == null) {
                    this.this$0.mAdProd.a(z2);
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cp.a
            public void onWindowVisibilityChanged(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i3) == null) {
                    this.this$0.mAdProd.b(i3);
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cp.a
            public void onAttachedToWindow() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                    return;
                }
                this.this$0.callRequest();
                this.this$0.mAdProd.o();
            }

            @Override // com.baidu.mobads.sdk.internal.cp.a
            @SuppressLint({"MissingSuperCall"})
            public void onDetachedFromWindow() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.this$0.mAdProd.p();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cp.a
            public boolean onKeyDown(int i3, KeyEvent keyEvent) {
                InterceptResult invokeIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIL = interceptable2.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i3, keyEvent)) == null) {
                    return this.this$0.mAdProd.a(i3, keyEvent);
                }
                return invokeIL.booleanValue;
            }

            @Override // com.baidu.mobads.sdk.internal.cp.a
            public void onLayoutComplete(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeII(1048579, this, i3, i4) != null) {
                    return;
                }
                this.this$0.callRequest();
            }
        });
        addView(cpVar, new ViewGroup.LayoutParams(-1, -1));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdView(Context context, AdSize adSize, String str) {
        this(context, true, adSize, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adSize, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), (AdSize) objArr2[2], (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdView(Context context, String str) {
        this(context, true, AdSize.Banner, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), (AdSize) objArr2[2], (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdView(Context context, boolean z, AdSize adSize, String str) {
        this(context, null, z, adSize, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), adSize, str};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), (AdSize) objArr2[3], (String) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    public void setAppSid(String str) {
        cq cqVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (cqVar = this.mAdProd) != null) {
            cqVar.h(str);
        }
    }

    public void setListener(AdViewListener adViewListener) {
        cq cqVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, adViewListener) == null) && (cqVar = this.mAdProd) != null) {
            cqVar.a(adViewListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callRequest() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && !this.hasCalledRequestMethod.get()) {
            this.hasCalledRequestMethod.set(true);
            this.mAdProd.a();
        }
    }

    public void destroy() {
        cq cqVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (cqVar = this.mAdProd) != null) {
            cqVar.e();
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutParams) == null) {
            br.a().a("AdView.setLayoutParams=", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            DisplayMetrics f = ax.f(getContext());
            int i3 = f.widthPixels;
            int i4 = f.heightPixels;
            float f2 = f.density;
            br.a().a("AdView.setLayoutParams", Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2));
            if (i <= 0) {
                i = Math.min(i3, i4);
            } else if (i > 0) {
                float f3 = 200.0f * f2;
                if (i < f3) {
                    i = (int) f3;
                }
            }
            if (i2 <= 0) {
                i2 = (int) (Math.min(i3, i4) * 0.15f);
            } else if (i2 > 0) {
                float f4 = f2 * 30.0f;
                if (i2 < f4) {
                    i2 = (int) f4;
                }
            }
            layoutParams.width = i;
            layoutParams.height = i2;
            cq cqVar = this.mAdProd;
            if (cqVar != null) {
                cqVar.a(i);
                this.mAdProd.c(i2);
            }
            br.a().a("AdView.setLayoutParams adapter", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
            super.setLayoutParams(layoutParams);
        }
    }
}
