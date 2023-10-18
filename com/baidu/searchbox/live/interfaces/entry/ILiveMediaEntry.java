package com.baidu.searchbox.live.interfaces.entry;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.live.goback.IYYGobackController;
import com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback;
import com.baidu.searchbox.live.interfaces.smallwindow.IYYSmallWindowController;
import com.baidu.searchbox.live.interfaces.storage.IYYStorageController;
import com.baidu.searchbox.live.interfaces.yy.YYStatInfo;
import com.baidu.searchbox.live.recommendmore.ILiveRecMoreController;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J5\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H&¢\u0006\u0004\b\n\u0010\u000bJ?\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H&¢\u0006\u0004\b\"\u0010#J!\u0010&\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010$H&¢\u0006\u0004\b&\u0010'J7\u0010&\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010%\u001a\u0004\u0018\u00010$H&¢\u0006\u0004\b&\u0010(J\u0019\u0010*\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b*\u0010+J)\u0010.\u001a\u00020\t2\u0006\u0010-\u001a\u00020,2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\t2\u0006\u00101\u001a\u000200H&¢\u0006\u0004\b2\u00103¨\u00064"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/entry/ILiveMediaEntry;", "Lkotlin/Any;", "Landroid/content/Context;", "context", "", "key", "", "", "params", "", "dispatchHostEvent", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V", "roomId", "source", "Landroid/net/Uri;", "uri", "enterLiveRoom", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;)V", "Lcom/baidu/searchbox/live/interfaces/entry/IMixShellEntry;", "getMixShellEntry", "()Lcom/baidu/searchbox/live/interfaces/entry/IMixShellEntry;", "Lcom/baidu/searchbox/live/recommendmore/ILiveRecMoreController;", "getRecMoreController", "(Landroid/content/Context;)Lcom/baidu/searchbox/live/recommendmore/ILiveRecMoreController;", "Lcom/baidu/searchbox/live/interfaces/storage/IYYStorageController;", "getStorageOptInfoHelperInterface", "()Lcom/baidu/searchbox/live/interfaces/storage/IYYStorageController;", "Lcom/baidu/searchbox/live/goback/IYYGobackController;", "getYYGobackController", "()Lcom/baidu/searchbox/live/goback/IYYGobackController;", "Lcom/baidu/searchbox/live/interfaces/smallwindow/IYYSmallWindowController;", "getYYSmallWindowController", "()Lcom/baidu/searchbox/live/interfaces/smallwindow/IYYSmallWindowController;", "", "isLoaded", "()Z", "Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;", WebChromeClient.KEY_ARG_CALLBACK, "loadMediaPlugin", "(Landroid/content/Context;Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;)V", "(Landroid/content/Context;Ljava/util/Map;Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;)V", "data", "onYYJoinChannelSuc", "(Ljava/lang/String;)V", "", "logType", "sendLog", "(ILandroid/content/Context;Ljava/lang/String;)V", "Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;", "statInfo", "updateStatInfo", "(Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface ILiveMediaEntry {
    void dispatchHostEvent(Context context, String str, Map<String, ? extends Object> map);

    void enterLiveRoom(Context context, String str, String str2, String str3, Uri uri);

    IMixShellEntry getMixShellEntry();

    ILiveRecMoreController getRecMoreController(Context context);

    IYYStorageController getStorageOptInfoHelperInterface();

    IYYGobackController getYYGobackController();

    IYYSmallWindowController getYYSmallWindowController();

    boolean isLoaded();

    void loadMediaPlugin(Context context, PluginLoadCallback pluginLoadCallback);

    void loadMediaPlugin(Context context, Map<String, ? extends Object> map, PluginLoadCallback pluginLoadCallback);

    void onYYJoinChannelSuc(String str);

    void sendLog(int i, Context context, String str);

    void updateStatInfo(YYStatInfo yYStatInfo);
}
