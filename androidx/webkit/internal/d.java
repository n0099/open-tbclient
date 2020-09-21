package androidx.webkit.internal;

import android.os.Build;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
/* loaded from: classes17.dex */
public class d {

    /* loaded from: classes17.dex */
    private static class a {
        static final g zS = new g(d.hS().hM());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static class b {
        static final e zT = d.hV();
    }

    public static e hS() {
        return b.zT;
    }

    public static g hT() {
        return a.zS;
    }

    private static InvocationHandler hU() throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {
        return (InvocationHandler) Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, getWebViewClassLoader()).getDeclaredMethod("createWebViewProviderFactory", new Class[0]).invoke(null, new Object[0]);
    }

    static e hV() {
        if (Build.VERSION.SDK_INT < 21) {
            return new androidx.webkit.internal.a();
        }
        try {
            return new f((WebViewProviderFactoryBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebViewProviderFactoryBoundaryInterface.class, hU()));
        } catch (ClassNotFoundException e) {
            return new androidx.webkit.internal.a();
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    public static ClassLoader getWebViewClassLoader() {
        return Build.VERSION.SDK_INT >= 28 ? WebView.getWebViewClassLoader() : hW().getClass().getClassLoader();
    }

    private static Object hW() {
        try {
            Method declaredMethod = WebView.class.getDeclaredMethod("getFactory", new Class[0]);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }
}
