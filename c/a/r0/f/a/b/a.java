package c.a.r0.f.a.b;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public interface a {

    /* renamed from: c.a.r0.f.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0690a implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final a a;

        public C0690a(a delegation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {delegation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(delegation, "delegation");
            this.a = delegation;
        }

        @Override // c.a.r0.f.a.b.a
        public String a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                return this.a.a(context);
            }
            return (String) invokeL.objValue;
        }

        @Override // c.a.r0.f.a.b.a
        public String b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                return this.a.b(context);
            }
            return (String) invokeL.objValue;
        }

        @Override // c.a.r0.f.a.b.a
        public String c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                return this.a.c(context);
            }
            return (String) invokeL.objValue;
        }

        @Override // c.a.r0.f.a.b.a
        public String d(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                return this.a.d(context);
            }
            return (String) invokeL.objValue;
        }

        @Override // c.a.r0.f.a.b.a
        public String getDeviceId(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                return this.a.getDeviceId(context);
            }
            return (String) invokeL.objValue;
        }
    }

    String a(Context context);

    String b(Context context);

    String c(Context context);

    String d(Context context);

    String getDeviceId(Context context);
}
