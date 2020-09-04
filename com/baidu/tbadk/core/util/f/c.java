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
            e.log("video preload switch  " + d.bkb().isOpen() + " num " + d.bkb().bkc() + " size " + d.bkb().getSize());
            if (d.bkb().isOpen() && (adapter = tVar.getAdapter()) != null) {
                boolean z = tVar.getFirstVisiblePosition() == 0;
                int lastVisiblePosition = tVar.getLastVisiblePosition();
                ArrayList arrayList = new ArrayList();
                e.log("video preload  end=  " + lastVisiblePosition + "  " + adapter.getCount());
                if (lastVisiblePosition >= 0 && adapter.getCount() > 0) {
                    for (int i = z ? 0 : lastVisiblePosition; i < adapter.getCount() && i < lastVisiblePosition + 10 && arrayList.size() <= d.bkb().bkc(); i++) {
                        e.log("video preload  i=  " + i);
                        Object item = adapter.getItem(i);
                        if (item instanceof a) {
                            a aVar = (a) item;
                            if (!TextUtils.isEmpty(aVar.getVideoUrl())) {
                                e.log("url: " + aVar.getVideoUrl());
                                CyberPlayerManager.prefetch(aVar.getVideoUrl(), null, null, d.bkb().getSize(), null);
                            }
                        }
                    }
                }
            }
        }
    }
}
