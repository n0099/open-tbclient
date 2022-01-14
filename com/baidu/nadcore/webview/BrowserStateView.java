package com.baidu.nadcore.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.c0.j0.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class BrowserStateView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f37197e;

    /* renamed from: f  reason: collision with root package name */
    public View f37198f;

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f37199g;

    /* renamed from: h  reason: collision with root package name */
    public int f37200h;

    /* renamed from: i  reason: collision with root package name */
    public int f37201i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f37202j;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
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
            this.f37201i = h.nad_widget_errorview;
            this.f37200h = h.nad_widget_loadingview;
            this.f37199g = LayoutInflater.from(getContext());
            c();
            b();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = this.f37199g.inflate(this.f37201i, (ViewGroup) this, false);
            this.f37197e = inflate;
            addView(inflate, inflate.getLayoutParams());
            this.f37197e.setVisibility(8);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = this.f37199g.inflate(this.f37200h, (ViewGroup) this, false);
            this.f37198f = inflate;
            addView(inflate, inflate.getLayoutParams());
            this.f37198f.setVisibility(8);
        }
    }

    public void hideState(ViewState viewState) {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewState) == null) {
            int i2 = a.a[viewState.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 && (view = this.f37197e) != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            View view2 = this.f37198f;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void setErrorViewClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f37202j = onClickListener;
            View view = this.f37197e;
            if (view != null) {
                view.setOnClickListener(onClickListener);
            }
        }
    }

    public void setViewForState(int i2, ViewState viewState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, viewState) == null) {
            if (this.f37199g == null) {
                this.f37199g = LayoutInflater.from(getContext());
            }
            setViewForState(this.f37199g.inflate(i2, (ViewGroup) this, false), viewState);
        }
    }

    public void showState(ViewState viewState) {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, viewState) == null) {
            int i2 = a.a[viewState.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 && (view = this.f37197e) != null) {
                    view.setVisibility(0);
                    return;
                }
                return;
            }
            View view2 = this.f37198f;
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
            View view2 = this.f37198f;
            if (view2 != null) {
                removeView(view2);
            }
            this.f37198f = view;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            addView(this.f37198f, layoutParams);
        } else if (i2 == 2) {
            View view3 = this.f37197e;
            if (view3 != null) {
                removeView(view3);
            }
            this.f37197e = view;
            addView(view);
            this.f37197e.setOnClickListener(this.f37202j);
        }
        view.setVisibility(8);
    }
}
