package com.baidu.tbadk.core.frameworkData;

import android.support.v4.widget.ExploreByTouchHelper;
import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class d {
    public static void init() {
        e eVar = new e(0);
        eVar.setPriority(ExploreByTouchHelper.INVALID_ID);
        MessageManager.getInstance().addMessageRule(eVar);
        MessageManager.getInstance().addResponsedMessageRule(new f(0));
        g gVar = new g(2000999);
        gVar.setPriority(ExploreByTouchHelper.INVALID_ID);
        MessageManager.getInstance().registerListener(gVar);
    }
}
