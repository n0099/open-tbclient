package c.a.e0.k.k;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.poly.a.l.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.e0.k.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0063a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f3238e;

        public RunnableC0063a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3238e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.c(this.f3238e);
            }
        }
    }

    public static c a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{viewGroup, layoutParams, str, Long.valueOf(j2)})) == null) {
            if (viewGroup == null) {
                return null;
            }
            c cVar = new c(viewGroup.getContext());
            if (!TextUtils.isEmpty(str)) {
                cVar.setText(str);
            }
            b(viewGroup, layoutParams, cVar, j2);
            return cVar;
        }
        return (c) invokeCommon.objValue;
    }

    public static void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, c cVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{viewGroup, layoutParams, cVar, Long.valueOf(j2)}) == null) {
            if (cVar.getParent() instanceof ViewGroup) {
                ((ViewGroup) cVar.getParent()).removeView(cVar);
            }
            viewGroup.addView(cVar, layoutParams);
            cVar.setLoading(true);
            if (j2 != -1) {
                viewGroup.postDelayed(new RunnableC0063a(cVar), j2);
            }
        }
    }

    public static void c(c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, cVar) == null) && cVar != null && (cVar.getParent() instanceof ViewGroup)) {
            ((ViewGroup) cVar.getParent()).removeView(cVar);
            cVar.setLoading(false);
        }
    }
}
