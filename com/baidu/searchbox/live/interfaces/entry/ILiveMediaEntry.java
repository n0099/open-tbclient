package com.baidu.searchbox.live.interfaces.entry;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J5\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H&¢\u0006\u0004\b\n\u0010\u000bJ;\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/entry/ILiveMediaEntry;", "Lkotlin/Any;", "Landroid/content/Context;", "context", "", "key", "", "", "params", "", "dispatchHostEvent", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V", ILiveNPSPlugin.PARAMS_ROOM_ID, "source", "Landroid/net/Uri;", "uri", "enterLiveRoom", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface ILiveMediaEntry {
    void dispatchHostEvent(Context context, String str, Map<String, ? extends Object> map);

    void enterLiveRoom(Context context, String str, String str2, String str3, Uri uri);
}
