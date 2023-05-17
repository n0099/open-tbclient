package com.baidu.searchbox.player.helper;

import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.BDPlayerConfig;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class VideoAsyncHostHelper {
    public static final String KEY_VIDEO_MPD_HOST = "key_video_mpd_hosts";
    public static final String SP_FILE_NAME = "com.baidu.searchbox_bdvideoplayer";
    public static volatile ArrayList<String> sVideoHostWhiteList = new ArrayList<>();

    public static synchronized boolean isVideoUrlNeedAsyncRequest(@Nullable String str) {
        synchronized (VideoAsyncHostHelper.class) {
            if (str == null) {
                return false;
            }
            if (sVideoHostWhiteList.isEmpty()) {
                updateVideoHostWhiteList();
            }
            Iterator<String> it = sVideoHostWhiteList.iterator();
            while (it.hasNext()) {
                if (str.contains(it.next())) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void setHostConfig(String str) {
        SharedPreferences sharedPreferences = BDPlayerConfig.getAppContext().getSharedPreferences(SP_FILE_NAME, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(KEY_VIDEO_MPD_HOST, str).apply();
        }
    }

    public static void updateVideoHostWhiteList() {
        String string = BDPlayerConfig.getAppContext().getSharedPreferences(SP_FILE_NAME, 0).getString(KEY_VIDEO_MPD_HOST, "");
        try {
            sVideoHostWhiteList.clear();
            JSONArray jSONArray = new JSONArray(string);
            for (int i = 0; i < jSONArray.length(); i++) {
                sVideoHostWhiteList.add(jSONArray.opt(i).toString());
            }
        } catch (Exception e) {
            if (BDPlayerConfig.isDebug()) {
                e.printStackTrace();
            }
        }
    }
}
