package c.a.a0.k0.i;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.container.base.AbsContainer;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public interface i {
    public static final ServiceReference a = new ServiceReference("nad.core", "navBarTool");

    /* renamed from: b  reason: collision with root package name */
    public static final i f1311b = new a();

    /* loaded from: classes.dex */
    public static class a implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c.a.a0.k0.i.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class View$OnClickListenerC0044a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AbsContainer a;

            public View$OnClickListenerC0044a(a aVar, AbsContainer absContainer) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, absContainer};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = absContainer;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AbsContainer absContainer;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (absContainer = this.a) == null) {
                    return;
                }
                absContainer.q();
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.a0.k0.i.i
        public int[] a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new int[]{R.drawable.obfuscated_res_0x7f080e10} : (int[]) invokeV.objValue;
        }

        @Override // c.a.a0.k0.i.i
        public void b(View view, AbsContainer absContainer) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, absContainer) == null) && ((Integer) view.getTag()).intValue() == R.drawable.obfuscated_res_0x7f080e10) {
                view.setOnClickListener(new View$OnClickListenerC0044a(this, absContainer));
            }
        }

        @Override // c.a.a0.k0.i.i
        public int[] c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new int[]{R.drawable.obfuscated_res_0x7f080e12} : (int[]) invokeV.objValue;
        }
    }

    int[] a();

    void b(View view, AbsContainer absContainer);

    int[] c();
}
