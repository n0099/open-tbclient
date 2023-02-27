package com.baidu.searchbox.live.ubc;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.transition.Transition;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 (:\u0002()B\u0007¢\u0006\u0004\b'\u0010\u0012J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ'\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\tJ\r\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0012J\u0015\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0019\u0010\u0005R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0016\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u001dR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001d\u0010&\u001a\u00020!8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006*"}, d2 = {"Lcom/baidu/searchbox/live/ubc/LiveComponentStatusHelper;", "Lcom/baidu/searchbox/live/ubc/LiveComponentStatusHelper$ILiveComponentLoadFinish;", WebChromeClient.KEY_ARG_CALLBACK, "", "addComponentFinishCallback", "(Lcom/baidu/searchbox/live/ubc/LiveComponentStatusHelper$ILiveComponentLoadFinish;)V", "", "componentName", "addComponentFinished", "(Ljava/lang/String;)V", "Landroid/view/View;", "renderView", "addComponentLoadedEvent", "(Landroid/view/View;Ljava/lang/String;)V", "", "post", "(Landroid/view/View;Ljava/lang/String;Z)V", "attach", "()V", "clean", "dispatchCoresFinished", "dispatchSingleFinished", "hasCoreFinished", "()Z", "release", "removeComponentFinishCallback", "", "callbacks", "Ljava/util/List;", "Z", "", "mCoreComponents", "Ljava/util/Set;", "Landroid/os/Handler;", "sMainHandler$delegate", "Lkotlin/Lazy;", "getSMainHandler", "()Landroid/os/Handler;", "sMainHandler", "<init>", "Companion", "ILiveComponentLoadFinish", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveComponentStatusHelper {
    public static final String BOTTOM_LIVE_COMPONENT = "bottom_component_finish";
    public static final String IM_LIVE_COMPONENT = "im_component_finish";
    public static final int MATCH_MAIN_COMPONENT = 3;
    public static final String TOPBAR_LIVE_COMPONENT = "top_component_finish";
    public boolean hasCoreFinished;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveComponentStatusHelper.class), "sMainHandler", "getSMainHandler()Landroid/os/Handler;"))};
    public static final Companion Companion = new Companion(null);
    public static final Lazy instance$delegate = LazyKt__LazyJVMKt.lazy(new Function0<LiveComponentStatusHelper>() { // from class: com.baidu.searchbox.live.ubc.LiveComponentStatusHelper$Companion$instance$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LiveComponentStatusHelper invoke() {
            return new LiveComponentStatusHelper();
        }
    });
    public Set<String> mCoreComponents = new LinkedHashSet();
    public List<ILiveComponentLoadFinish> callbacks = new ArrayList();
    public final Lazy sMainHandler$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.baidu.searchbox.live.ubc.LiveComponentStatusHelper$sMainHandler$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/live/ubc/LiveComponentStatusHelper$ILiveComponentLoadFinish;", "Lkotlin/Any;", "", "onCoreFinished", "()V", "", "componentName", "onFinished", "(Ljava/lang/String;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface ILiveComponentLoadFinish {
        void onCoreFinished();

        void onFinished(String str);
    }

    private final Handler getSMainHandler() {
        Lazy lazy = this.sMainHandler$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (Handler) lazy.getValue();
    }

    public final void attach() {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u001d\u0010\u000e\u001a\u00020\t8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/live/ubc/LiveComponentStatusHelper$Companion;", "", "BOTTOM_LIVE_COMPONENT", "Ljava/lang/String;", "IM_LIVE_COMPONENT", "", "MATCH_MAIN_COMPONENT", "I", "TOPBAR_LIVE_COMPONENT", "Lcom/baidu/searchbox/live/ubc/LiveComponentStatusHelper;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/baidu/searchbox/live/ubc/LiveComponentStatusHelper;", Transition.MATCH_INSTANCE_STR, "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), Transition.MATCH_INSTANCE_STR, "getInstance()Lcom/baidu/searchbox/live/ubc/LiveComponentStatusHelper;"))};

        public final LiveComponentStatusHelper getInstance() {
            Lazy lazy = LiveComponentStatusHelper.instance$delegate;
            Companion companion = LiveComponentStatusHelper.Companion;
            KProperty kProperty = $$delegatedProperties[0];
            return (LiveComponentStatusHelper) lazy.getValue();
        }

        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchCoresFinished() {
        this.hasCoreFinished = true;
        List<ILiveComponentLoadFinish> list = this.callbacks;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (ILiveComponentLoadFinish iLiveComponentLoadFinish : list) {
            iLiveComponentLoadFinish.onCoreFinished();
            arrayList.add(Unit.INSTANCE);
        }
        this.mCoreComponents.clear();
    }

    public final void clean() {
        this.hasCoreFinished = false;
        this.mCoreComponents.clear();
    }

    public final boolean hasCoreFinished() {
        return this.hasCoreFinished;
    }

    public final void release() {
        this.mCoreComponents.clear();
        this.callbacks.clear();
    }

    public final void addComponentLoadedEvent(View view2, final String str) {
        if (view2 != null) {
            view2.post(new Runnable() { // from class: com.baidu.searchbox.live.ubc.LiveComponentStatusHelper$addComponentLoadedEvent$1
                @Override // java.lang.Runnable
                public final void run() {
                    Set set;
                    Set set2;
                    Set set3;
                    set = LiveComponentStatusHelper.this.mCoreComponents;
                    if (set.contains(str)) {
                        return;
                    }
                    set2 = LiveComponentStatusHelper.this.mCoreComponents;
                    set2.add(str);
                    LiveComponentStatusHelper.this.dispatchSingleFinished(str);
                    set3 = LiveComponentStatusHelper.this.mCoreComponents;
                    if (set3.size() != 3) {
                        return;
                    }
                    LiveComponentStatusHelper.this.dispatchCoresFinished();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addComponentFinished(String str) {
        if (!this.mCoreComponents.contains(str)) {
            this.mCoreComponents.add(str);
            dispatchSingleFinished(str);
            if (this.mCoreComponents.size() == 3) {
                dispatchCoresFinished();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchSingleFinished(String str) {
        List<ILiveComponentLoadFinish> list = this.callbacks;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (ILiveComponentLoadFinish iLiveComponentLoadFinish : list) {
            iLiveComponentLoadFinish.onFinished(str);
            arrayList.add(Unit.INSTANCE);
        }
    }

    public final void addComponentFinishCallback(ILiveComponentLoadFinish iLiveComponentLoadFinish) {
        this.callbacks.add(iLiveComponentLoadFinish);
    }

    public final void removeComponentFinishCallback(ILiveComponentLoadFinish iLiveComponentLoadFinish) {
        this.callbacks.remove(iLiveComponentLoadFinish);
    }

    public final void addComponentLoadedEvent(View view2, final String str, boolean z) {
        if (z) {
            getSMainHandler().postAtFrontOfQueue(new Runnable() { // from class: com.baidu.searchbox.live.ubc.LiveComponentStatusHelper$addComponentLoadedEvent$2
                @Override // java.lang.Runnable
                public final void run() {
                    LiveComponentStatusHelper.this.addComponentFinished(str);
                }
            });
        } else {
            addComponentFinished(str);
        }
    }
}
