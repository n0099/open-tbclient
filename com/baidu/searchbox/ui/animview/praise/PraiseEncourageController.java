package com.baidu.searchbox.ui.animview.praise;

import android.content.Context;
import com.baidu.searchbox.ui.animview.praise.data.ComboPraiseUBC;
import com.baidu.searchbox.ui.animview.praise.ioc.InteractionEncourageRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0002J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/ui/animview/praise/PraiseEncourageController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "configRequestParams", "", "", "ubc", "Lcom/baidu/searchbox/ui/animview/praise/data/ComboPraiseUBC;", "hotPraiseAnimationConfig", "showEasterEgg", "", "updatePraiseClickNum", "", "updatePraiseTime", "lib-praise_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PraiseEncourageController {
    public final Context context;

    public PraiseEncourageController(Context context) {
        this.context = context;
    }

    private final Map<String, String> configRequestParams(ComboPraiseUBC comboPraiseUBC, String str) {
        HashMap hashMap = new HashMap();
        if (comboPraiseUBC != null) {
            String nid = comboPraiseUBC.getNid();
            String str2 = "";
            if (nid == null) {
                nid = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(nid, "ubc.nid ?: \"\"");
            }
            hashMap.put(ComboPraiseManager.PRAISE_NID, nid);
            String uBCSource = comboPraiseUBC.getUBCSource();
            if (uBCSource != null) {
                Intrinsics.checkNotNullExpressionValue(uBCSource, "ubc.ubcSource ?: \"\"");
                str2 = uBCSource;
            }
            hashMap.put(ComboPraiseManager.PRAISE_SOURCE, str2);
        }
        if (str != null) {
            hashMap.put(ComboPraiseManager.HOT_PRAISE_ANIM_CONFIG, str);
        }
        return hashMap;
    }

    public final boolean showEasterEgg(ComboPraiseUBC comboPraiseUBC, String str) {
        boolean showEasterEgg = InteractionEncourageRuntime.get().showEasterEgg(this.context, configRequestParams(comboPraiseUBC, str));
        updatePraiseTime();
        return showEasterEgg;
    }

    public final void updatePraiseClickNum() {
        InteractionEncourageRuntime.get().updatePraiseClickNum();
    }

    public final void updatePraiseTime() {
        InteractionEncourageRuntime.get().updatePraiseTime();
    }
}
