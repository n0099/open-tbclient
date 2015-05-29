package com.baidu.tbadk.core.frameworkData;

import android.support.v4.widget.ExploreByTouchHelper;
import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class NetAutoPolicyStatic {
    static {
        d dVar = new d(0);
        dVar.setPriority(ExploreByTouchHelper.INVALID_ID);
        MessageManager.getInstance().addMessageRule(dVar);
        MessageManager.getInstance().addResponsedMessageRule(new e(0));
        f fVar = new f(2000999);
        fVar.setPriority(ExploreByTouchHelper.INVALID_ID);
        MessageManager.getInstance().registerListener(fVar);
    }
}
