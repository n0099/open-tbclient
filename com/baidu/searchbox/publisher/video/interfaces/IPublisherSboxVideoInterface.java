package com.baidu.searchbox.publisher.video.interfaces;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.pyramid.runtime.service.d;
import com.baidu.searchbox.ugc.provider.listener.OnVideoClipListener;
import com.baidu.searchbox.ugc.provider.listener.OnVideoShareListener;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface IPublisherSboxVideoInterface {
    public static final String EXTRA_MAX_DURATION = "max_time";
    public static final String EXTRA_MIN_DURATION = "min_time";
    public static final String LAUNCH_FROM_PLUGIN = "plugin";
    public static final d SERVICE_REFERENCE = new d(UgcUBCUtils.UBC_DANGEROUS_PERMISSION_UGC_VIDEO_SOURCE, "UGC_VIDEO");
    public static final int UGC_VIDEO_PREVIEW_REQUEST = 32771;

    void clipVideo(String str, String str2, List<long[]> list, OnVideoClipListener onVideoClipListener);

    Runnable getUploadVideoTask(String str);

    void invokePluginForAlbumResult(Context context, String str, boolean z);

    void invokePluginForShareVideo(Context context, UgcSchemeModel ugcSchemeModel);

    void invokeVideoCapture(UgcSchemeModel ugcSchemeModel, Context context);

    boolean isVideoTask(Runnable runnable);

    void openLocalVideoCapturectivity(Activity activity, Intent intent);

    void openVideoPreviewActivity(Activity activity, Intent intent);

    void openVideoPreviewActivityForResult(Activity activity, Intent intent, int i);

    void shareVideo(Context context, JSONObject jSONObject, OnVideoShareListener onVideoShareListener);
}
