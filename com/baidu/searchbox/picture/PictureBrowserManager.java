package com.baidu.searchbox.picture;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.pyramid.runtime.service.d;
import com.baidu.searchbox.picture.params.LaunchParams;
import com.tencent.open.SocialConstants;
import java.util.List;
/* loaded from: classes12.dex */
public interface PictureBrowserManager {
    public static final d SERVICE_REFERENCE = new d(SocialConstants.PARAM_AVATAR_URI, "light_picture_browser");

    void open(Context context, @NonNull LaunchParams launchParams);

    void open(Context context, @NonNull String str);

    void open(Context context, @NonNull List<String> list);
}
