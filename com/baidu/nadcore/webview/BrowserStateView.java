package com.baidu.nadcore.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BrowserStateView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public LayoutInflater c;
    public int d;
    public int e;
    public View.OnClickListener f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class ViewState {
        public static final /* synthetic */ ViewState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ViewState ERROR;
        public static final ViewState LOADING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1308122270, "Lcom/baidu/nadcore/webview/BrowserStateView$ViewState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1308122270, "Lcom/baidu/nadcore/webview/BrowserStateView$ViewState;");
                    return;
                }
            }
            LOADING = new ViewState("LOADING", 0);
            ViewState viewState = new ViewState("ERROR", 1);
            ERROR = viewState;
            $VALUES = new ViewState[]{LOADING, viewState};
        }

        public ViewState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ViewState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ViewState) Enum.valueOf(ViewState.class, str) : (ViewState) invokeL.objValue;
        }

        public static ViewState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ViewState[]) $VALUES.clone() : (ViewState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1334989165, "Lcom/baidu/nadcore/webview/BrowserStateView$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1334989165, "Lcom/baidu/nadcore/webview/BrowserStateView$a;");
                    return;
                }
            }
            int[] iArr = new int[ViewState.values().length];
            a = iArr;
            try {
                iArr[ViewState.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ViewState.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BrowserStateView(@NonNull Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(ViewState viewState) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, viewState) == null) {
            int i = a.a[viewState.ordinal()];
            if (i != 1) {
                if (i == 2 && (view2 = this.a) != null) {
                    view2.setVisibility(8);
                    return;
                }
                return;
            }
            View view3 = this.b;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e = R.layout.obfuscated_res_0x7f0d05cb;
            this.d = R.layout.obfuscated_res_0x7f0d05cc;
            this.c = LayoutInflater.from(getContext());
            d();
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = this.c.inflate(this.e, (ViewGroup) this, false);
            this.a = inflate;
            addView(inflate, inflate.getLayoutParams());
            this.a.setVisibility(8);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = this.c.inflate(this.d, (ViewGroup) this, false);
            this.b = inflate;
            addView(inflate, inflate.getLayoutParams());
            this.b.setVisibility(8);
        }
    }

    public void e(ViewState viewState) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, viewState) == null) {
            int i = a.a[viewState.ordinal()];
            if (i != 1) {
                if (i == 2 && (view2 = this.a) != null) {
                    view2.setVisibility(0);
                    return;
                }
                return;
            }
            View view3 = this.b;
            if (view3 != null) {
                view3.setVisibility(0);
            }
        }
    }

    public void setErrorViewClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.f = onClickListener;
            View view2 = this.a;
            if (view2 != null) {
                view2.setOnClickListener(onClickListener);
            }
        }
    }

    public void setViewForState(int i, ViewState viewState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, viewState) == null) {
            if (this.c == null) {
                this.c = LayoutInflater.from(getContext());
            }
            setViewForState(this.c.inflate(i, (ViewGroup) this, false), viewState);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrowserStateView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        b();
    }

    public void setViewForState(View view2, ViewState viewState) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, view2, viewState) == null) || view2 == null) {
            return;
        }
        int i = a.a[viewState.ordinal()];
        if (i == 1) {
            View view3 = this.b;
            if (view3 != null) {
                removeView(view3);
            }
            this.b = view2;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            addView(this.b, layoutParams);
        } else if (i == 2) {
            View view4 = this.a;
            if (view4 != null) {
                removeView(view4);
            }
            this.a = view2;
            addView(view2);
            this.a.setOnClickListener(this.f);
        }
        view2.setVisibility(8);
    }
}
