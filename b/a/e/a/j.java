package b.a.e.a;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static f<?> a(Context context) {
        InterceptResult invokeL;
        Object a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof f) {
                return (f) context;
            }
            if (context instanceof g) {
                return ((g) context).getPageContext();
            }
            Field b2 = b.a.e.f.p.b.b(context.getClass(), i.class);
            if (b2 == null || (a2 = b.a.e.f.p.b.a(context, b2)) == null || !(a2 instanceof i) || !(a2 instanceof g)) {
                return null;
            }
            return ((g) a2).getPageContext();
        }
        return (f) invokeL.objValue;
    }

    public static g<?> b(Context context) {
        InterceptResult invokeL;
        Object a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof g) {
                return (g) context;
            }
            Field b2 = b.a.e.f.p.b.b(context.getClass(), i.class);
            if (b2 == null || (a2 = b.a.e.f.p.b.a(context, b2)) == null || !(a2 instanceof i) || !(a2 instanceof g)) {
                return null;
            }
            return (g) a2;
        }
        return (g) invokeL.objValue;
    }

    public static i c(Context context) {
        InterceptResult invokeL;
        Object a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof i) {
                return (i) context;
            }
            if (context instanceof g) {
                Object orignalPage = ((g) context).getPageContext().getOrignalPage();
                if (orignalPage instanceof i) {
                    return (i) orignalPage;
                }
            }
            Field b2 = b.a.e.f.p.b.b(context.getClass(), i.class);
            if (b2 == null || (a2 = b.a.e.f.p.b.a(context, b2)) == null || !(a2 instanceof i)) {
                return null;
            }
            return (i) a2;
        }
        return (i) invokeL.objValue;
    }
}
