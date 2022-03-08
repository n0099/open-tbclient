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
/* loaded from: classes4.dex */
public class BrowserStateView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f35858e;

    /* renamed from: f  reason: collision with root package name */
    public View f35859f;

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f35860g;

    /* renamed from: h  reason: collision with root package name */
    public int f35861h;

    /* renamed from: i  reason: collision with root package name */
    public int f35862i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f35863j;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
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

        public ViewState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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

    /* loaded from: classes4.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f35862i = R.layout.nad_widget_errorview;
            this.f35861h = R.layout.nad_widget_loadingview;
            this.f35860g = LayoutInflater.from(getContext());
            c();
            b();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = this.f35860g.inflate(this.f35862i, (ViewGroup) this, false);
            this.f35858e = inflate;
            addView(inflate, inflate.getLayoutParams());
            this.f35858e.setVisibility(8);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = this.f35860g.inflate(this.f35861h, (ViewGroup) this, false);
            this.f35859f = inflate;
            addView(inflate, inflate.getLayoutParams());
            this.f35859f.setVisibility(8);
        }
    }

    public void hideState(ViewState viewState) {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewState) == null) {
            int i2 = a.a[viewState.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 && (view = this.f35858e) != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            View view2 = this.f35859f;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void setErrorViewClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f35863j = onClickListener;
            View view = this.f35858e;
            if (view != null) {
                view.setOnClickListener(onClickListener);
            }
        }
    }

    public void setViewForState(int i2, ViewState viewState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, viewState) == null) {
            if (this.f35860g == null) {
                this.f35860g = LayoutInflater.from(getContext());
            }
            setViewForState(this.f35860g.inflate(i2, (ViewGroup) this, false), viewState);
        }
    }

    public void showState(ViewState viewState) {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, viewState) == null) {
            int i2 = a.a[viewState.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 && (view = this.f35858e) != null) {
                    view.setVisibility(0);
                    return;
                }
                return;
            }
            View view2 = this.f35859f;
            if (view2 != null) {
                view2.setVisibility(0);
            }
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
        a();
    }

    public void setViewForState(View view, ViewState viewState) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, view, viewState) == null) || view == null) {
            return;
        }
        int i2 = a.a[viewState.ordinal()];
        if (i2 == 1) {
            View view2 = this.f35859f;
            if (view2 != null) {
                removeView(view2);
            }
            this.f35859f = view;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            addView(this.f35859f, layoutParams);
        } else if (i2 == 2) {
            View view3 = this.f35858e;
            if (view3 != null) {
                removeView(view3);
            }
            this.f35858e = view;
            addView(view);
            this.f35858e.setOnClickListener(this.f35863j);
        }
        view.setVisibility(8);
    }
}
