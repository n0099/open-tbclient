package com.baidu.tbadk.core.util.e;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.p;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {
    public static void a(p pVar, BdUniqueId bdUniqueId, c cVar) {
        n adapter;
        g.log("video preload start ");
        if (pVar != null) {
            if (cVar != null && !cVar.videoNeedPreload()) {
                g.log("this page don't preload ");
                return;
            }
            g.log("video preload switch  " + e.aiV().isOpen() + " num " + e.aiV().aiW() + " size " + e.aiV().getSize());
            if (e.aiV().isOpen() && (adapter = pVar.getAdapter()) != null) {
                boolean z = pVar.getFirstVisiblePosition() == 0;
                int lastVisiblePosition = pVar.getLastVisiblePosition();
                ArrayList arrayList = new ArrayList();
                g.log("video preload  end=  " + lastVisiblePosition + "  " + adapter.getCount());
                if (lastVisiblePosition >= 0 && adapter.getCount() > 0) {
                    for (int i = z ? 0 : lastVisiblePosition; i < adapter.getCount() && i < lastVisiblePosition + 10 && arrayList.size() <= e.aiV().aiW(); i++) {
                        g.log("video preload  i=  " + i);
                        Object item = adapter.getItem(i);
                        if (item instanceof a) {
                            a aVar = (a) item;
                            if (!TextUtils.isEmpty(aVar.getVideoUrl())) {
                                g.log("url: " + aVar.getVideoUrl());
                                arrayList.add(aVar.getVideoUrl());
                            }
                        }
                    }
                    g.log("video preload  urls size   " + arrayList.size());
                    if (arrayList.size() > 0) {
                        h.aiX().ac(arrayList);
                    }
                }
            }
        }
    }
}
