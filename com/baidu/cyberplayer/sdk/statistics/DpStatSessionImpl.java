package com.baidu.cyberplayer.sdk.statistics;

import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.MediaPlayerImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DpStatSessionImpl {
    public static final String TAG = "DpStatSessionImpl";
    public static boolean sIsFirstPlayerSession;
    public boolean mIsUpload = false;
    public DpStatPlaySession mPlaySession = new DpStatPlaySession();
    public boolean mIsGrayRelease = false;
    public boolean mIsBaiduUrl = false;
    public boolean mIsUserStarted = false;

    public synchronized void clear() {
        if (this.mPlaySession != null) {
            this.mPlaySession.clear();
        }
        this.mIsUpload = false;
    }

    public synchronized boolean getIsBaiduUrl() {
        return this.mIsBaiduUrl;
    }

    public synchronized boolean getIsGrayRelease() {
        return this.mIsGrayRelease;
    }

    public synchronized boolean getIsUpload() {
        return this.mIsUpload;
    }

    public synchronized boolean getIsUserStarted() {
        return this.mIsUserStarted;
    }

    public synchronized void release() {
        if (this.mPlaySession != null) {
            this.mPlaySession.release();
            this.mPlaySession = null;
        }
        this.mPlaySession = null;
    }

    private void checkIsBaiduUrl(String str) {
        String[] strArr = {"(.*)bdstatic.com(.*)", "(.*)baidu.com(.*)", "(.*)baidubce.com(.*)", "(.*)bcebos.com(.*)", "(.*)bcevod.com(.*)"};
        this.mIsBaiduUrl = false;
        for (int i = 0; i < 5; i++) {
            if (str.matches(strArr[i])) {
                this.mIsBaiduUrl = true;
                return;
            }
        }
    }

    private void checkIsGrayRelease(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        if (str.length() - lastIndexOf == 2) {
            this.mIsGrayRelease = true;
        } else if (str.length() - lastIndexOf == 3) {
            this.mIsGrayRelease = false;
        }
    }

    private void checkIsUserStart(String str) {
        if ("1".equals(str)) {
            this.mIsUserStarted = true;
        } else if ("0".equals(str)) {
            this.mIsUserStarted = false;
        }
    }

    public synchronized void collectMediaFormatInfo(MediaPlayerImpl mediaPlayerImpl) {
        if (this.mPlaySession != null && mediaPlayerImpl != null) {
            this.mPlaySession.add(DpStatConstants.SESSION_TYPE_MEDIA_FORMAT_INFO, "width", String.valueOf(mediaPlayerImpl.getVideoWidth()));
            this.mPlaySession.add(DpStatConstants.SESSION_TYPE_MEDIA_FORMAT_INFO, "height", String.valueOf(mediaPlayerImpl.getVideoHeight()));
        }
    }

    public synchronized void add(int i, String str, int i2) {
        if (this.mPlaySession != null) {
            this.mPlaySession.add(i, str, String.valueOf(i2));
        }
    }

    public synchronized void add(int i, String str, long j) {
        if (this.mPlaySession != null) {
            this.mPlaySession.add(i, str, String.valueOf(j));
        }
    }

    public synchronized void add(int i, String str, String str2) {
        if (this.mPlaySession != null) {
            this.mPlaySession.add(i, str, str2);
        }
    }

    public synchronized String getAllSessionDataWithServerType(String str) {
        String str2 = null;
        if (this.mPlaySession == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            DpInitKernelSession.getInstance().toJson(jSONObject);
            jSONObject.put(DpStatConstants.KEY_SERVER_TYPE, str);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.mPlaySession.toJson());
            jSONObject.put("items", jSONArray);
            str2 = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jSONObject.remove("cuid");
        CyberLog.i(TAG, "all session = " + jSONObject.toString());
        return str2;
    }

    public synchronized String getMediaPlayerSessionDataForUBC(String str) {
        String str2 = null;
        if (this.mPlaySession == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject json = this.mPlaySession.toJson();
            DpInitKernelSession.getInstance().toJson(json);
            json.put(DpStatConstants.KEY_SERVER_TYPE, str);
            if (json.has("url")) {
                checkIsBaiduUrl(json.getString("url"));
            }
            if (json.has("app_version")) {
                checkIsGrayRelease(json.getString("app_version"));
            }
            if (json.has(DpStatConstants.KEY_IS_USER_STARTED)) {
                checkIsUserStart(json.getString(DpStatConstants.KEY_IS_USER_STARTED));
            }
            json.remove("abtest_sid");
            json.remove("app_name");
            json.remove("app_version");
            json.remove("cuid");
            jSONObject2.put("items", json);
            jSONObject.put("ext", jSONObject2);
            jSONObject.put("from", "cyber");
            jSONObject.put("page", "vod");
            str2 = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return str2;
    }

    public synchronized void initPlaySessionCommon(MediaPlayerImpl mediaPlayerImpl) {
        String str;
        String str2;
        if (this.mPlaySession != null && mediaPlayerImpl != null) {
            this.mPlaySession.add(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_CURRENT_POSITION, String.valueOf(mediaPlayerImpl.getCurrentPosition()));
            this.mPlaySession.add(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "decode_mode", String.valueOf(mediaPlayerImpl.getDecodeMode()));
            this.mPlaySession.add(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_FILE_CACHE, "0");
            this.mPlaySession.add(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_P_ID, String.valueOf(mediaPlayerImpl.getStartPlayTime()));
            this.mPlaySession.add(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "network", DpNetworkUtils.getNetworkStatisticsNoOperator(CyberPlayerManager.getApplicationContext()));
            this.mPlaySession.add(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_NETWORK_STATUS, DpNetworkUtils.getNetworkStatus(CyberPlayerManager.getApplicationContext()));
            this.mPlaySession.add(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "url", mediaPlayerImpl.getUrl());
            this.mPlaySession.add(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "timestamp", String.valueOf(System.currentTimeMillis()));
            this.mPlaySession.add(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "duration", String.valueOf(mediaPlayerImpl.getDuration()));
            this.mPlaySession.add(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_REAL_PLAY_TIME, String.valueOf(mediaPlayerImpl.getPlayedTime()));
            DpStatPlaySession dpStatPlaySession = this.mPlaySession;
            if (mediaPlayerImpl.isUserClickStart()) {
                str = "1";
            } else {
                str = "0";
            }
            dpStatPlaySession.add(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_IS_USER_STARTED, str);
            DpStatPlaySession dpStatPlaySession2 = this.mPlaySession;
            if (mediaPlayerImpl.isAudioMuted()) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            dpStatPlaySession2.add(20488, DpStatConstants.KEY_IS_AUDIO_MUTED, str2);
            if (!sIsFirstPlayerSession) {
                sIsFirstPlayerSession = true;
                this.mPlaySession.add(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "is_first_session", "1");
            }
        }
    }

    public synchronized void uploadSessionWithServerType(MediaPlayerImpl mediaPlayerImpl, String str) {
        String allSessionDataWithServerType;
        if (mediaPlayerImpl != null) {
            if (this.mPlaySession != null && (allSessionDataWithServerType = getAllSessionDataWithServerType(str)) != null) {
                this.mIsUpload = true;
                DpSessionDatasUploader.getInstance().upload(allSessionDataWithServerType, "sailor_monitor");
            }
        }
    }
}
