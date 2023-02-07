package com.baidu.tbadk.core.util.videoPreload;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tieba.eo;
import com.baidu.tieba.ho;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void load(ho hoVar, BdUniqueId bdUniqueId, IVideoNeedPreload iVideoNeedPreload) {
        eo adapter;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, hoVar, bdUniqueId, iVideoNeedPreload) == null) {
            VideoPreLoadLog.log("video preload start ");
            if (hoVar == null) {
                return;
            }
            if (iVideoNeedPreload != null && !iVideoNeedPreload.videoNeedPreload()) {
                VideoPreLoadLog.log("this page don't preload ");
                return;
            }
            VideoPreLoadLog.log("video preload switch  " + PreLoadVideoSwitchManager.getInstance().isOpen() + " num " + PreLoadVideoSwitchManager.getInstance().getMaxPreLoadNum() + " size " + PreLoadVideoSwitchManager.getInstance().getSize());
            if (!PreLoadVideoSwitchManager.getInstance().isOpen() || (adapter = hoVar.getAdapter()) == null) {
                return;
            }
            int i = 0;
            if (hoVar.getFirstVisiblePosition() == 0) {
                z = true;
            } else {
                z = false;
            }
            int lastVisiblePosition = hoVar.getLastVisiblePosition();
            ArrayList arrayList = new ArrayList();
            VideoPreLoadLog.log("video preload  end=  " + lastVisiblePosition + GlideException.IndentedAppendable.INDENT + adapter.getCount());
            if (lastVisiblePosition >= 0 && adapter.getCount() > 0) {
                if (!z) {
                    i = lastVisiblePosition;
                }
                while (i < adapter.getCount() && i < lastVisiblePosition + 10 && arrayList.size() <= PreLoadVideoSwitchManager.getInstance().getMaxPreLoadNum()) {
                    VideoPreLoadLog.log("video preload  i=  " + i);
                    Object item = adapter.getItem(i);
                    if (item instanceof IVideoData) {
                        IVideoData iVideoData = (IVideoData) item;
                        if (!TextUtils.isEmpty(iVideoData.getVideoUrl())) {
                            VideoPreLoadLog.log("url: " + iVideoData.getVideoUrl());
                            CyberPlayerManager.prefetch(iVideoData.getVideoUrl(), null, null, PreLoadVideoSwitchManager.getInstance().getSize(), null);
                        }
                    }
                    i++;
                }
            }
        }
    }
}
