package c.a.g0.t.e;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.poly.widget.toast.ToastLoadingView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.g0.t.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0124a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ToastLoadingView f3302e;

        public RunnableC0124a(ToastLoadingView toastLoadingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {toastLoadingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3302e = toastLoadingView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.b(this.f3302e);
            }
        }
    }

    public static void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, ToastLoadingView toastLoadingView, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{viewGroup, layoutParams, toastLoadingView, Long.valueOf(j2)}) == null) {
            if (toastLoadingView.getParent() instanceof ViewGroup) {
                ((ViewGroup) toastLoadingView.getParent()).removeView(toastLoadingView);
            }
            viewGroup.addView(toastLoadingView, layoutParams);
            toastLoadingView.setLoading(true);
            if (j2 != -1) {
                viewGroup.postDelayed(new RunnableC0124a(toastLoadingView), j2);
            }
        }
    }

    public static void b(ToastLoadingView toastLoadingView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, toastLoadingView) == null) && toastLoadingView != null && (toastLoadingView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) toastLoadingView.getParent()).removeView(toastLoadingView);
            toastLoadingView.setLoading(false);
        }
    }

    public static ToastLoadingView c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{viewGroup, layoutParams, str, Long.valueOf(j2)})) == null) {
            if (viewGroup == null) {
                return null;
            }
            ToastLoadingView toastLoadingView = new ToastLoadingView(viewGroup.getContext());
            if (!TextUtils.isEmpty(str)) {
                toastLoadingView.setText(str);
            }
            a(viewGroup, layoutParams, toastLoadingView, j2);
            return toastLoadingView;
        }
        return (ToastLoadingView) invokeCommon.objValue;
    }
}
