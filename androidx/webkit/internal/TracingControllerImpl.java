package androidx.webkit.internal;

import android.annotation.SuppressLint;
import android.webkit.TracingConfig;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.webkit.TracingConfig;
import androidx.webkit.TracingController;
import java.io.OutputStream;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.TracingControllerBoundaryInterface;
/* loaded from: classes.dex */
public class TracingControllerImpl extends TracingController {
    public TracingControllerBoundaryInterface mBoundaryInterface;
    public android.webkit.TracingController mFrameworksImpl;

    @SuppressLint({"NewApi"})
    public TracingControllerImpl() {
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.TRACING_CONTROLLER_BASIC_USAGE;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            this.mFrameworksImpl = android.webkit.TracingController.getInstance();
            this.mBoundaryInterface = null;
        } else if (webViewFeatureInternal.isSupportedByWebView()) {
            this.mFrameworksImpl = null;
            this.mBoundaryInterface = WebViewGlueCommunicator.getFactory().getTracingController();
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    private TracingControllerBoundaryInterface getBoundaryInterface() {
        if (this.mBoundaryInterface == null) {
            this.mBoundaryInterface = WebViewGlueCommunicator.getFactory().getTracingController();
        }
        return this.mBoundaryInterface;
    }

    @RequiresApi(28)
    private android.webkit.TracingController getFrameworksImpl() {
        if (this.mFrameworksImpl == null) {
            this.mFrameworksImpl = android.webkit.TracingController.getInstance();
        }
        return this.mFrameworksImpl;
    }

    @Override // androidx.webkit.TracingController
    @SuppressLint({"NewApi"})
    public boolean isTracing() {
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.TRACING_CONTROLLER_BASIC_USAGE;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            return getFrameworksImpl().isTracing();
        }
        if (webViewFeatureInternal.isSupportedByWebView()) {
            return getBoundaryInterface().isTracing();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.TracingController
    @SuppressLint({"NewApi"})
    public void start(@NonNull TracingConfig tracingConfig) {
        if (tracingConfig != null) {
            WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.TRACING_CONTROLLER_BASIC_USAGE;
            if (webViewFeatureInternal.isSupportedByFramework()) {
                getFrameworksImpl().start(new TracingConfig.Builder().addCategories(tracingConfig.getPredefinedCategories()).addCategories(tracingConfig.getCustomIncludedCategories()).setTracingMode(tracingConfig.getTracingMode()).build());
                return;
            } else if (webViewFeatureInternal.isSupportedByWebView()) {
                getBoundaryInterface().start(tracingConfig.getPredefinedCategories(), tracingConfig.getCustomIncludedCategories(), tracingConfig.getTracingMode());
                return;
            } else {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
        }
        throw new IllegalArgumentException("Tracing config must be non null");
    }

    @Override // androidx.webkit.TracingController
    @SuppressLint({"NewApi"})
    public boolean stop(OutputStream outputStream, Executor executor) {
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.TRACING_CONTROLLER_BASIC_USAGE;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            return getFrameworksImpl().stop(outputStream, executor);
        }
        if (webViewFeatureInternal.isSupportedByWebView()) {
            return getBoundaryInterface().stop(outputStream, executor);
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
