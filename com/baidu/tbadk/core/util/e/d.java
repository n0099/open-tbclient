package com.baidu.tbadk.core.util.e;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.k;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {
    public static void a(k kVar, BdUniqueId bdUniqueId, c cVar) {
        i adapter;
        g.log("video preload start ");
        if (kVar != null) {
            if (cVar != null && !cVar.videoNeedPreload()) {
                g.log("this page don't preload ");
                return;
            }
            g.log("video preload switch  " + e.EP().isOpen() + " num " + e.EP().EQ() + " size " + e.EP().getSize());
            if (e.EP().isOpen() && (adapter = kVar.getAdapter()) != null) {
                boolean z = kVar.getFirstVisiblePosition() == 0;
                int lastVisiblePosition = kVar.getLastVisiblePosition();
                ArrayList arrayList = new ArrayList();
                g.log("video preload  end=  " + lastVisiblePosition + "  " + adapter.getCount());
                if (lastVisiblePosition >= 0 && adapter.getCount() > 0) {
                    for (int i = z ? 0 : lastVisiblePosition; i < adapter.getCount() && i < lastVisiblePosition + 10 && arrayList.size() <= e.EP().EQ(); i++) {
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
                        h.ER().K(arrayList);
                    }
                }
            }
        }
    }
}
