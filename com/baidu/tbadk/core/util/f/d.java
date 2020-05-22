package com.baidu.tbadk.core.util.f;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.p;
import com.baidu.adp.widget.ListView.r;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {
    public static void a(r rVar, BdUniqueId bdUniqueId, c cVar) {
        p adapter;
        g.log("video preload start ");
        if (rVar != null) {
            if (cVar != null && !cVar.videoNeedPreload()) {
                g.log("this page don't preload ");
                return;
            }
            g.log("video preload switch  " + e.aVJ().isOpen() + " num " + e.aVJ().aVK() + " size " + e.aVJ().getSize());
            if (e.aVJ().isOpen() && (adapter = rVar.getAdapter()) != null) {
                boolean z = rVar.getFirstVisiblePosition() == 0;
                int lastVisiblePosition = rVar.getLastVisiblePosition();
                ArrayList arrayList = new ArrayList();
                g.log("video preload  end=  " + lastVisiblePosition + "  " + adapter.getCount());
                if (lastVisiblePosition >= 0 && adapter.getCount() > 0) {
                    for (int i = z ? 0 : lastVisiblePosition; i < adapter.getCount() && i < lastVisiblePosition + 10 && arrayList.size() <= e.aVJ().aVK(); i++) {
                        g.log("video preload  i=  " + i);
                        Object item = adapter.getItem(i);
                        if (item instanceof a) {
                            a aVar = (a) item;
                            if (!TextUtils.isEmpty(aVar.getVideoUrl())) {
                                g.log("url: " + aVar.getVideoUrl());
                                if (cVar.isCyberVideoUsedThisPage()) {
                                    CyberPlayerManager.prefetch(aVar.getVideoUrl(), null, null, e.aVJ().getSize(), null);
                                } else {
                                    arrayList.add(aVar.getVideoUrl());
                                }
                            }
                        }
                    }
                    g.log("video preload  urls size   " + arrayList.size());
                    if (arrayList.size() > 0) {
                        h.aVL().aG(arrayList);
                    }
                }
            }
        }
    }
}
