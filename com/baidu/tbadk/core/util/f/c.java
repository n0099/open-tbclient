package com.baidu.tbadk.core.util.f;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.t;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    public static void a(t tVar, BdUniqueId bdUniqueId, b bVar) {
        r adapter;
        e.log("video preload start ");
        if (tVar != null) {
            if (bVar != null && !bVar.videoNeedPreload()) {
                e.log("this page don't preload ");
                return;
            }
            e.log("video preload switch  " + d.buK().isOpen() + " num " + d.buK().buL() + " size " + d.buK().getSize());
            if (d.buK().isOpen() && (adapter = tVar.getAdapter()) != null) {
                boolean z = tVar.getFirstVisiblePosition() == 0;
                int lastVisiblePosition = tVar.getLastVisiblePosition();
                ArrayList arrayList = new ArrayList();
                e.log("video preload  end=  " + lastVisiblePosition + "  " + adapter.getCount());
                if (lastVisiblePosition >= 0 && adapter.getCount() > 0) {
                    for (int i = z ? 0 : lastVisiblePosition; i < adapter.getCount() && i < lastVisiblePosition + 10 && arrayList.size() <= d.buK().buL(); i++) {
                        e.log("video preload  i=  " + i);
                        Object item = adapter.getItem(i);
                        if (item instanceof a) {
                            a aVar = (a) item;
                            if (!TextUtils.isEmpty(aVar.getVideoUrl())) {
                                e.log("url: " + aVar.getVideoUrl());
                                CyberPlayerManager.prefetch(aVar.getVideoUrl(), null, null, d.buK().getSize(), null);
                            }
                        }
                    }
                }
            }
        }
    }
}
