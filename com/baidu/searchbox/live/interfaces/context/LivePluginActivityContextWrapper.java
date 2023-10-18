package com.baidu.searchbox.live.interfaces.context;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001a\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/live/interfaces/context/LivePluginActivityContextWrapper;", "Landroid/content/ContextWrapper;", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "Landroid/content/res/AssetManager;", "getAssets", "()Landroid/content/res/AssetManager;", "Ljava/lang/ClassLoader;", "getClassLoader", "()Ljava/lang/ClassLoader;", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "", "name", "", "getSystemService", "(Ljava/lang/String;)Ljava/lang/Object;", "act", "Landroid/app/Activity;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/LayoutInflater;", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "kotlin.jvm.PlatformType", "pluginService", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "activity", "<init>", "(Landroid/app/Activity;)V", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class LivePluginActivityContextWrapper extends ContextWrapper {
    public static final Companion Companion = new Companion(null);
    public static final String LIVE_PKG_NAME = "com.baidu.searchbox.livenps";
    public final Activity act;
    public LayoutInflater inflater;
    public final PluginInvokeService pluginService;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/context/LivePluginActivityContextWrapper$Companion;", "", "LIVE_PKG_NAME", "Ljava/lang/String;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LivePluginActivityContextWrapper(Activity activity) {
        super(activity);
        this.pluginService = (PluginInvokeService) ServiceManager.getService(PluginInvokeService.Companion.getSERVICE_REFERENCE());
        this.act = activity;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (Intrinsics.areEqual(str, "layout_inflater")) {
            if (this.inflater == null) {
                this.inflater = LayoutInflater.from(this.act).cloneInContext(this);
            }
            LayoutInflater layoutInflater = this.inflater;
            if (layoutInflater != null) {
                return layoutInflater;
            }
        }
        Object systemService = super.getSystemService(str);
        Intrinsics.checkExpressionValueIsNotNull(systemService, "super.getSystemService(name)");
        return systemService;
    }

    public final Activity getActivity() {
        return this.act;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        AssetManager pluginAssets;
        PluginInvokeService pluginInvokeService = this.pluginService;
        if (pluginInvokeService != null && (pluginAssets = pluginInvokeService.getPluginAssets("com.baidu.searchbox.livenps")) != null) {
            return pluginAssets;
        }
        AssetManager assets = super.getAssets();
        Intrinsics.checkExpressionValueIsNotNull(assets, "super.getAssets()");
        return assets;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        ClassLoader pluginClassLoader;
        PluginInvokeService pluginInvokeService = this.pluginService;
        if (pluginInvokeService != null && (pluginClassLoader = pluginInvokeService.getPluginClassLoader("com.baidu.searchbox.livenps")) != null) {
            return pluginClassLoader;
        }
        ClassLoader classLoader = super.getClassLoader();
        Intrinsics.checkExpressionValueIsNotNull(classLoader, "super.getClassLoader()");
        return classLoader;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources pluginResource;
        PluginInvokeService pluginInvokeService = this.pluginService;
        if (pluginInvokeService != null && (pluginResource = pluginInvokeService.getPluginResource("com.baidu.searchbox.livenps")) != null) {
            return pluginResource;
        }
        Resources resources = super.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "super.getResources()");
        return resources;
    }
}
