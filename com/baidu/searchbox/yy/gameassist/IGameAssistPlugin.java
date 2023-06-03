package com.baidu.searchbox.yy.gameassist;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.live.interfaces.callback.ILiveDiskClearCacheCallback;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u001cH&¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/yy/gameassist/IGameAssistPlugin;", "Lkotlin/Any;", "Landroid/content/Context;", "packageContext", "", GameAssistConstKt.METHOD_CLEAR_ALL_CACHE, "(Landroid/content/Context;)V", "context", "", "key", "", "", "params", "dispatchHostEvent", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V", "", "getLiveResourceSize", "(Landroid/content/Context;)J", GameAssistConstKt.KEY_DISK_QUOTA, "", GameAssistConstKt.KEY_DISK_OLD_STATE, GameAssistConstKt.KEY_DISK_NEW_STATE, "Lcom/baidu/searchbox/live/interfaces/callback/ILiveDiskClearCacheCallback;", WebChromeClient.KEY_ARG_CALLBACK, GameAssistConstKt.METHOD_DISK_CLEAR_CACHE_CHANGE, "(JIILcom/baidu/searchbox/live/interfaces/callback/ILiveDiskClearCacheCallback;)V", "Landroid/app/Activity;", "act", "", "paramsMap", "startGameAssistActivity", "(Landroid/app/Activity;Ljava/util/Map;)V", "lib-gameassist-host_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface IGameAssistPlugin {
    void clearLiveResourceSize(Context context);

    void dispatchHostEvent(Context context, String str, Map<String, Object> map);

    long getLiveResourceSize(Context context);

    void onDiskClearCacheChange(long j, int i, int i2, ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback);

    void startGameAssistActivity(Activity activity, Map<String, String> map);
}
