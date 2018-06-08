package com.baidu.ar.util;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import java.io.File;
/* loaded from: classes3.dex */
public class MediaUtils {
    public static Bitmap getFrameAtTime(String str, long j, int i) {
        if (str != null) {
            try {
                if (new File(str).exists()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(str);
                    Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(j, i);
                    Log.d("bdar", "get first Frame of video spendTime is " + (System.currentTimeMillis() - currentTimeMillis));
                    return frameAtTime;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
