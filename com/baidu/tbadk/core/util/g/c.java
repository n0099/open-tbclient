package com.baidu.tbadk.core.util.g;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.q;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    public static void a(q qVar, BdUniqueId bdUniqueId, b bVar) {
        o adapter;
        e.log("video preload start ");
        if (qVar != null) {
            if (bVar != null && !bVar.videoNeedPreload()) {
                e.log("this page don't preload ");
                return;
            }
            e.log("video preload switch  " + d.bxg().isOpen() + " num " + d.bxg().bxh() + " size " + d.bxg().getSize());
            if (d.bxg().isOpen() && (adapter = qVar.getAdapter()) != null) {
                boolean z = qVar.getFirstVisiblePosition() == 0;
                int lastVisiblePosition = qVar.getLastVisiblePosition();
                ArrayList arrayList = new ArrayList();
                e.log("video preload  end=  " + lastVisiblePosition + "  " + adapter.getCount());
                if (lastVisiblePosition >= 0 && adapter.getCount() > 0) {
                    for (int i = z ? 0 : lastVisiblePosition; i < adapter.getCount() && i < lastVisiblePosition + 10 && arrayList.size() <= d.bxg().bxh(); i++) {
                        e.log("video preload  i=  " + i);
                        Object item = adapter.getItem(i);
                        if (item instanceof a) {
                            a aVar = (a) item;
                            if (!TextUtils.isEmpty(aVar.getVideoUrl())) {
                                e.log("url: " + aVar.getVideoUrl());
                                CyberPlayerManager.prefetch(aVar.getVideoUrl(), null, null, d.bxg().getSize(), null);
                            }
                        }
                    }
                }
            }
        }
    }
}
