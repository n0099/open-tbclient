package com.baidu.tbadk.core.util.videoPreload;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.bumptech.glide.load.engine.GlideException;
import d.b.b.j.e.o;
import d.b.b.j.e.q;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PreLoadVideoHelper {
    public static void load(q qVar, BdUniqueId bdUniqueId, IVideoNeedPreload iVideoNeedPreload) {
        o adapter;
        VideoPreLoadLog.log("video preload start ");
        if (qVar == null) {
            return;
        }
        if (iVideoNeedPreload != null && !iVideoNeedPreload.videoNeedPreload()) {
            VideoPreLoadLog.log("this page don't preload ");
            return;
        }
        VideoPreLoadLog.log("video preload switch  " + PreLoadVideoSwitchManager.getInstance().isOpen() + " num " + PreLoadVideoSwitchManager.getInstance().getMaxPreLoadNum() + " size " + PreLoadVideoSwitchManager.getInstance().getSize());
        if (PreLoadVideoSwitchManager.getInstance().isOpen() && (adapter = qVar.getAdapter()) != null) {
            boolean z = qVar.getFirstVisiblePosition() == 0;
            int lastVisiblePosition = qVar.getLastVisiblePosition();
            ArrayList arrayList = new ArrayList();
            VideoPreLoadLog.log("video preload  end=  " + lastVisiblePosition + GlideException.IndentedAppendable.INDENT + adapter.getCount());
            if (lastVisiblePosition < 0 || adapter.getCount() <= 0) {
                return;
            }
            for (int i = z ? 0 : lastVisiblePosition; i < adapter.getCount() && i < lastVisiblePosition + 10 && arrayList.size() <= PreLoadVideoSwitchManager.getInstance().getMaxPreLoadNum(); i++) {
                VideoPreLoadLog.log("video preload  i=  " + i);
                Object item = adapter.getItem(i);
                if (item instanceof IVideoData) {
                    IVideoData iVideoData = (IVideoData) item;
                    if (!TextUtils.isEmpty(iVideoData.getVideoUrl())) {
                        VideoPreLoadLog.log("url: " + iVideoData.getVideoUrl());
                        CyberPlayerManager.prefetch(iVideoData.getVideoUrl(), null, null, PreLoadVideoSwitchManager.getInstance().getSize(), null);
                    }
                }
            }
        }
    }
}
