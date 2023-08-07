package com.baidu.searchbox.live.interfaces.entry;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.live.host2live.publish.ILive2PublishHostInterface;
import com.baidu.searchbox.live.host2live.publish.ILiveMasterActInterface;
import com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 '2\u00020\u0001:\u0002'(J5\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H&¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H&¢\u0006\u0004\b\r\u0010\u000bJ%\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020 H&¢\u0006\u0004\b!\u0010\"J+\u0010$\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020#2\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0004\b$\u0010%J+\u0010&\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0004\b&\u0010\u0018¨\u0006)"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/entry/ILiveBjhEntry;", "Lkotlin/Any;", "Landroid/content/Context;", "context", "", "key", "", "", "params", "", "dispatchHostEvent", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V", "path", "dispatchLiveMasterRouter", "Landroid/app/Activity;", "activity", "Lcom/baidu/searchbox/live/host2live/publish/ILive2PublishHostInterface;", "live2LivePublish", "Lcom/baidu/searchbox/live/host2live/publish/ILiveMasterActInterface;", "getLiveMasterProxyImpl", "(Landroid/app/Activity;Lcom/baidu/searchbox/live/host2live/publish/ILive2PublishHostInterface;)Lcom/baidu/searchbox/live/host2live/publish/ILiveMasterActInterface;", "Landroid/net/Uri;", "uri", "initBjhLiveSdk", "(Landroid/content/Context;Ljava/lang/String;Landroid/net/Uri;)V", "", "isLoaded", "()Z", "Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;", WebChromeClient.KEY_ARG_CALLBACK, "loadBjhPlugin", "(Landroid/content/Context;Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;)V", "Lcom/baidu/searchbox/live/interfaces/entry/ILiveBjhEntry$LoadInstanceCallback;", "loadInstance", "(Lcom/baidu/searchbox/live/interfaces/entry/ILiveBjhEntry$LoadInstanceCallback;)V", "Landroid/app/Application;", "startLiveMasterActivity", "(Landroid/app/Application;Ljava/lang/String;Landroid/net/Uri;)V", "startLiveMasterActivityNew", "Companion", "LoadInstanceCallback", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface ILiveBjhEntry {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String HOST_IM_LOGIN_NOTICE = "host_im_login_notice";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/entry/ILiveBjhEntry$Companion;", "", "HOST_IM_LOGIN_NOTICE", "Ljava/lang/String;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String HOST_IM_LOGIN_NOTICE = "host_im_login_notice";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/entry/ILiveBjhEntry$LoadInstanceCallback;", "Lkotlin/Any;", "", "onInstanceLoad", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public interface LoadInstanceCallback {
        void onInstanceLoad();
    }

    void dispatchHostEvent(Context context, String str, Map<String, ? extends Object> map);

    void dispatchLiveMasterRouter(Context context, String str, Map<String, ? extends Object> map);

    ILiveMasterActInterface getLiveMasterProxyImpl(Activity activity, ILive2PublishHostInterface iLive2PublishHostInterface);

    void initBjhLiveSdk(Context context, String str, Uri uri);

    boolean isLoaded();

    void loadBjhPlugin(Context context, PluginLoadCallback pluginLoadCallback);

    void loadInstance(LoadInstanceCallback loadInstanceCallback);

    void startLiveMasterActivity(Application application, String str, Uri uri);

    void startLiveMasterActivityNew(Context context, String str, Uri uri);
}
