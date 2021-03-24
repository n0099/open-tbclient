package com.baidu.searchbox.live.interfaces.entry;

import android.content.Context;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ?\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/entry/ILiveYuYinEntry;", "Lkotlin/Any;", "Landroid/content/Context;", "context", "", "jsonParams", "", "startYuYinCreateLiveRoomActivity", "(Landroid/content/Context;Ljava/lang/String;)V", "scheme", "otherParams", "", "", "params", "startYuYinLiveActivity", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface ILiveYuYinEntry {
    void startYuYinCreateLiveRoomActivity(Context context, String str);

    void startYuYinLiveActivity(Context context, String str, String str2, Map<String, ? extends Object> map);
}
