package com.baidu.searchbox.live.video;

import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService;
import com.baidu.searchbox.live.video.LiveActInterfaceImpl;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/live/host2live/video/IVideoInsertLiveService;", "", "msg", "", LocalFilesFilterKt.FILTER_NAME_LOG, "(Lcom/baidu/searchbox/live/host2live/video/IVideoInsertLiveService;Ljava/lang/String;)V", "lib-live-mini-shell_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class VideoInsertLiveServiceImplKt {
    public static final void log(IVideoInsertLiveService iVideoInsertLiveService, String str) {
        LiveActInterfaceImpl.Companion companion = LiveActInterfaceImpl.Companion;
        companion.log(iVideoInsertLiveService.getClass().getSimpleName() + WebvttCueParser.CHAR_SPACE + str);
    }
}
