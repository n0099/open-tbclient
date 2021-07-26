package com.baidu.tbadk.core.util.videoPreload;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import d.a.d.k.e.o;
import d.a.d.k.e.q;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PreLoadVideoHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PreLoadVideoHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void load(q qVar, BdUniqueId bdUniqueId, IVideoNeedPreload iVideoNeedPreload) {
        o adapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, qVar, bdUniqueId, iVideoNeedPreload) == null) {
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
                for (int i2 = z ? 0 : lastVisiblePosition; i2 < adapter.getCount() && i2 < lastVisiblePosition + 10 && arrayList.size() <= PreLoadVideoSwitchManager.getInstance().getMaxPreLoadNum(); i2++) {
                    VideoPreLoadLog.log("video preload  i=  " + i2);
                    Object item = adapter.getItem(i2);
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
}
