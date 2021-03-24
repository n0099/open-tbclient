package com.baidu.searchbox.live.interfaces.entry;

import android.content.Context;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J5\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H&¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\rJ\u001f\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\rJ'\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0014H&¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/live/interfaces/entry/ILiveShowEntry;", "Lkotlin/Any;", "Landroid/content/Context;", "context", "", "key", "", "", "params", "", "dispatchHostEvent", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V", "enterLiveShowRoom", "(Landroid/content/Context;Ljava/lang/String;)V", "enterPatronagePage", "(Landroid/content/Context;)V", "uid", "enterPatrons", "enterPayPage", "userId", "", "sex", "openFansListPage", "(Landroid/content/Context;Ljava/lang/String;I)V", "charmValue", "openGuardianListPage", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "", "currentExp", "currentLevel", "openLiveExpPage", "(Landroid/content/Context;JI)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface ILiveShowEntry {
    void dispatchHostEvent(Context context, String str, Map<String, ? extends Object> map);

    void enterLiveShowRoom(Context context, String str);

    void enterPatronagePage(Context context);

    void enterPatrons(Context context, String str);

    void enterPayPage(Context context, String str);

    void openFansListPage(Context context, String str, int i);

    void openGuardianListPage(Context context, String str, String str2);

    void openLiveExpPage(Context context, long j, int i);
}
