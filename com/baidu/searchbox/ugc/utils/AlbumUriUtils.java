package com.baidu.searchbox.ugc.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ugc.album.R;
import com.baidu.searchbox.ugc.model.ImageStruct;
import java.io.File;
/* loaded from: classes13.dex */
public class AlbumUriUtils {
    public static Uri getUri(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX) || str.startsWith("file://")) {
            return Uri.parse(str);
        }
        if (str.startsWith("/")) {
            return Uri.fromFile(new File(str));
        }
        return null;
    }

    public static boolean isImageLegal(ImageStruct imageStruct) {
        if (SelectUtil.supportGifLongImg) {
            if (imageStruct.isGif() || SelectUtil.isLargeImage(imageStruct)) {
                if (SelectUtil.isTooBigImage(imageStruct.size)) {
                    UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_album_select_photo_too_big).showToastBottom();
                    return false;
                } else if (SelectUtil.isWideHighLegal(imageStruct)) {
                    UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_album_select_photo_not_accord).showToastBottom();
                    return false;
                }
            } else if (!SelectUtil.isScaleLegal(imageStruct)) {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_album_select_photo_not_accord).showToastBottom();
                return false;
            }
        } else if (!SelectUtil.isScaleLegal(imageStruct)) {
            UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_album_select_photo_not_accord_old).showToastBottom();
            return false;
        }
        return true;
    }
}
