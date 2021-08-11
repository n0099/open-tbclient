package com.baidu.searchbox.live.interfaces.entry;

import android.content.Context;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J5\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0007H&¢\u0006\u0004\b\u0013\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0014\u0010\u000fJ'\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H&¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010 \u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0016H&¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/live/interfaces/entry/ILiveShowEntry;", "Lkotlin/Any;", "", "clearLiveShowResource", "()V", "Landroid/content/Context;", "context", "", "key", "", "", "params", "dispatchHostEvent", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V", "enterLiveShowRoom", "(Landroid/content/Context;Ljava/lang/String;)V", "enterPatronagePage", "(Landroid/content/Context;)V", "uid", "enterPatrons", "enterPayPage", "userId", "", "sex", "openFansListPage", "(Landroid/content/Context;Ljava/lang/String;I)V", "charmValue", "openGuardianListPage", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "", "currentExp", "currentLevel", "openLiveExpPage", "(Landroid/content/Context;JI)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes5.dex */
public interface ILiveShowEntry {
    void clearLiveShowResource();

    void dispatchHostEvent(Context context, String str, Map<String, ? extends Object> map);

    void enterLiveShowRoom(Context context, String str);

    void enterPatronagePage(Context context);

    void enterPatrons(Context context, String str);

    void enterPayPage(Context context, String str);

    void openFansListPage(Context context, String str, int i2);

    void openGuardianListPage(Context context, String str, String str2);

    void openLiveExpPage(Context context, long j2, int i2);
}
