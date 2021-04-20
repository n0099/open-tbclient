package com.baidu.mobads.container.landingpage;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.video.CpuLpVideoLayout;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class NativePlayerJsBridgeHandler implements CpuLpVideoLayout.OnVideoStatusListener {
    public static final String CB_CUR_VIDEO_ID = "curvideoid";
    public static final String CB_CUR_VIDEO_INDEX = "curvideoindex";
    public static final String CB_CUR_VIDEO_STATUS = "curvieostatus";
    public static final String CB_CUR_VIDEO_TIME = "curvideotime";
    public static final String CB_PARAM_PREFIX = "javascript:";
    public static final String CB_PREROLLS_ID = "prerollsid";
    public static final String CB_USER_ACTION = "useraction";
    public static final String PREROLLS_BRIDGE_SCHEME = "prerolls";
    public static final String TAG = "NativePlayerJsBridgeHandler";
    public static final String TYPE_CHANGE_NEXT = "nextplayer";
    public static final String TYPE_CHANGE_PREV = "prevplayer";
    public static final String TYPE_PAUSE_PLAY = "pauseplayer";
    public static final String TYPE_REPLAY = "replay";
    public static final String TYPE_RESUME_PLAY = "resumeplayer";
    public static final String TYPE_RIGISTER = "register";
    public static final String TYPE_START_PLAY = "startplayer";
    public static final String VIDEO_BRIDGE_SCHEME = "nativeplayer";
    public final Context mAppCtx;
    public PlayerCallBack mPlayerCallBack;
    public final WebView mWebView;

    /* loaded from: classes2.dex */
    public interface PlayerCallBack {
        void changeVideoUrl(JsWithPlayerData jsWithPlayerData);

        void clickPreroll();

        void createAdView(JsWithPlayerData jsWithPlayerData);

        void createVideoView(JsWithPlayerData jsWithPlayerData);

        void isFullScreenStatus(boolean z);

        void setVideoLocation(boolean z);

        void videoNotVisible();
    }

    public NativePlayerJsBridgeHandler(Context context, WebView webView, CpuLpVideoLayout cpuLpVideoLayout) {
        this.mAppCtx = context;
        this.mWebView = webView;
        if (cpuLpVideoLayout != null) {
            cpuLpVideoLayout.setOnVideoStatusListener(this);
        }
    }

    private void runJsCallBack(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && jSONObject != null && this.mWebView != null) {
            String str2 = "javascript:" + str + "(\"" + jSONObject.toString().replace("\"", "\\\"") + "\")";
            RemoteXAdLogger.getInstance().d(TAG, str2);
            this.mWebView.loadUrl(str2);
            return;
        }
        RemoteXAdLogger.getInstance().d(TAG, "callback is null");
    }

    @Override // com.baidu.mobads.container.video.CpuLpVideoLayout.OnVideoStatusListener
    public void chooseNextVideo(JsWithPlayerData jsWithPlayerData) {
        String str = jsWithPlayerData.callJsfunc;
        String str2 = jsWithPlayerData.videoId;
        String str3 = jsWithPlayerData.videoIndex;
        String curVideoStatus = jsWithPlayerData.getCurVideoStatus();
        String curVideoUserAction = jsWithPlayerData.getCurVideoUserAction();
        String curVideoPlayTime = jsWithPlayerData.getCurVideoPlayTime();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CB_CUR_VIDEO_ID, str2);
            jSONObject.put(CB_CUR_VIDEO_INDEX, str3);
            jSONObject.put(CB_CUR_VIDEO_STATUS, curVideoStatus);
            jSONObject.put(CB_CUR_VIDEO_TIME, curVideoPlayTime);
            jSONObject.put(CB_USER_ACTION, curVideoUserAction);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        runJsCallBack(str, jSONObject);
    }

    @Override // com.baidu.mobads.container.video.CpuLpVideoLayout.OnVideoStatusListener
    public void choosePrevVideo(JsWithPlayerData jsWithPlayerData) {
        String str = jsWithPlayerData.callJsfunc;
        String str2 = jsWithPlayerData.videoId;
        String str3 = jsWithPlayerData.videoIndex;
        String curVideoStatus = jsWithPlayerData.getCurVideoStatus();
        String curVideoUserAction = jsWithPlayerData.getCurVideoUserAction();
        String curVideoPlayTime = jsWithPlayerData.getCurVideoPlayTime();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CB_CUR_VIDEO_ID, str2);
            jSONObject.put(CB_CUR_VIDEO_INDEX, str3);
            jSONObject.put(CB_CUR_VIDEO_STATUS, curVideoStatus);
            jSONObject.put(CB_CUR_VIDEO_TIME, curVideoPlayTime);
            jSONObject.put(CB_USER_ACTION, curVideoUserAction);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        runJsCallBack(str, jSONObject);
    }

    @Override // com.baidu.mobads.container.video.CpuLpVideoLayout.OnVideoStatusListener
    public void clickPrerolls(JsWithPlayerData jsWithPlayerData) {
        String str = jsWithPlayerData.callJsfunc;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CB_PREROLLS_ID, jsWithPlayerData.mPrerolls_Id);
            jSONObject.put(CB_USER_ACTION, "clickprerolls");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        runJsCallBack(str, jSONObject);
        this.mPlayerCallBack.clickPreroll();
    }

    @Override // com.baidu.mobads.container.video.CpuLpVideoLayout.OnVideoStatusListener
    public void closePrerolls(JsWithPlayerData jsWithPlayerData) {
        String str = jsWithPlayerData.callJsfunc;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CB_PREROLLS_ID, jsWithPlayerData.mPrerolls_Id);
            jSONObject.put(CB_USER_ACTION, "closeprerolls");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        runJsCallBack(str, jSONObject);
    }

    @Override // com.baidu.mobads.container.video.CpuLpVideoLayout.OnVideoStatusListener
    public void completeVideoPlay(JsWithPlayerData jsWithPlayerData) {
        String str = jsWithPlayerData.callJsfunc;
        String str2 = jsWithPlayerData.videoId;
        String str3 = jsWithPlayerData.videoIndex;
        String curVideoStatus = jsWithPlayerData.getCurVideoStatus();
        String curVideoUserAction = jsWithPlayerData.getCurVideoUserAction();
        String curVideoPlayTime = jsWithPlayerData.getCurVideoPlayTime();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CB_CUR_VIDEO_ID, str2);
            jSONObject.put(CB_CUR_VIDEO_INDEX, str3);
            jSONObject.put(CB_CUR_VIDEO_STATUS, curVideoStatus);
            jSONObject.put(CB_CUR_VIDEO_TIME, curVideoPlayTime);
            jSONObject.put(CB_USER_ACTION, curVideoUserAction);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        runJsCallBack(str, jSONObject);
    }

    @Override // com.baidu.mobads.container.video.CpuLpVideoLayout.OnVideoStatusListener
    public void fiveSecondsLeft(JsWithPlayerData jsWithPlayerData) {
        if (TextUtils.isEmpty(jsWithPlayerData.nextVideoTitle)) {
            return;
        }
        Context context = this.mAppCtx;
        Toast.makeText(context, "即将播放:" + jsWithPlayerData.nextVideoTitle, 0).show();
    }

    public void handleShouldOverrideUrlLoading(String str) {
        PlayerCallBack playerCallBack;
        JsWithPlayerData createObjFromUrl = JsWithPlayerData.createObjFromUrl(str);
        if ("register".equals(createObjFromUrl.interactivetype)) {
            PlayerCallBack playerCallBack2 = this.mPlayerCallBack;
            if (playerCallBack2 != null) {
                playerCallBack2.createVideoView(createObjFromUrl);
            }
        } else if (TYPE_PAUSE_PLAY.equals(createObjFromUrl.interactivetype)) {
            PlayerCallBack playerCallBack3 = this.mPlayerCallBack;
            if (playerCallBack3 != null) {
                playerCallBack3.createAdView(createObjFromUrl);
            }
        } else if (TYPE_CHANGE_PREV.equals(createObjFromUrl.interactivetype)) {
            PlayerCallBack playerCallBack4 = this.mPlayerCallBack;
            if (playerCallBack4 != null) {
                playerCallBack4.changeVideoUrl(createObjFromUrl);
            }
        } else if (TYPE_CHANGE_NEXT.equals(createObjFromUrl.interactivetype)) {
            PlayerCallBack playerCallBack5 = this.mPlayerCallBack;
            if (playerCallBack5 != null) {
                playerCallBack5.changeVideoUrl(createObjFromUrl);
            }
        } else if (!TYPE_REPLAY.equals(createObjFromUrl.interactivetype) || (playerCallBack = this.mPlayerCallBack) == null) {
        } else {
            playerCallBack.changeVideoUrl(createObjFromUrl);
        }
    }

    @Override // com.baidu.mobads.container.video.CpuLpVideoLayout.OnVideoStatusListener
    public void isFullScreenStatus(boolean z) {
        PlayerCallBack playerCallBack = this.mPlayerCallBack;
        if (playerCallBack != null) {
            playerCallBack.isFullScreenStatus(z);
        }
    }

    public boolean isNativePlayerScheme(String str) {
        return str.startsWith(VIDEO_BRIDGE_SCHEME) || str.startsWith(PREROLLS_BRIDGE_SCHEME);
    }

    @Override // com.baidu.mobads.container.video.CpuLpVideoLayout.OnVideoStatusListener
    public void occurErrorVideoPlay(JsWithPlayerData jsWithPlayerData) {
        String str = jsWithPlayerData.callJsfunc;
        String str2 = jsWithPlayerData.videoId;
        String str3 = jsWithPlayerData.videoIndex;
        String curVideoStatus = jsWithPlayerData.getCurVideoStatus();
        String curVideoUserAction = jsWithPlayerData.getCurVideoUserAction();
        String curVideoPlayTime = jsWithPlayerData.getCurVideoPlayTime();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CB_CUR_VIDEO_ID, str2);
            jSONObject.put(CB_CUR_VIDEO_INDEX, str3);
            jSONObject.put(CB_CUR_VIDEO_STATUS, curVideoStatus);
            jSONObject.put(CB_CUR_VIDEO_TIME, curVideoPlayTime);
            jSONObject.put(CB_USER_ACTION, curVideoUserAction);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        runJsCallBack(str, jSONObject);
    }

    @Override // com.baidu.mobads.container.video.CpuLpVideoLayout.OnVideoStatusListener
    public void pauseVideoPlay(JsWithPlayerData jsWithPlayerData) {
        String str = jsWithPlayerData.callJsfunc;
        String str2 = jsWithPlayerData.videoId;
        String str3 = jsWithPlayerData.videoIndex;
        String curVideoStatus = jsWithPlayerData.getCurVideoStatus();
        String curVideoUserAction = jsWithPlayerData.getCurVideoUserAction();
        String curVideoPlayTime = jsWithPlayerData.getCurVideoPlayTime();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CB_CUR_VIDEO_ID, str2);
            jSONObject.put(CB_CUR_VIDEO_INDEX, str3);
            jSONObject.put(CB_CUR_VIDEO_STATUS, curVideoStatus);
            jSONObject.put(CB_CUR_VIDEO_TIME, curVideoPlayTime);
            jSONObject.put(CB_USER_ACTION, curVideoUserAction);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        runJsCallBack(str, jSONObject);
    }

    @Override // com.baidu.mobads.container.video.CpuLpVideoLayout.OnVideoStatusListener
    public void resumeVideoPlay(JsWithPlayerData jsWithPlayerData) {
        String str = jsWithPlayerData.callJsfunc;
        String str2 = jsWithPlayerData.videoId;
        String str3 = jsWithPlayerData.videoIndex;
        String curVideoStatus = jsWithPlayerData.getCurVideoStatus();
        String curVideoUserAction = jsWithPlayerData.getCurVideoUserAction();
        String curVideoPlayTime = jsWithPlayerData.getCurVideoPlayTime();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CB_CUR_VIDEO_ID, str2);
            jSONObject.put(CB_CUR_VIDEO_INDEX, str3);
            jSONObject.put(CB_CUR_VIDEO_STATUS, curVideoStatus);
            jSONObject.put(CB_CUR_VIDEO_TIME, curVideoPlayTime);
            jSONObject.put(CB_USER_ACTION, curVideoUserAction);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        runJsCallBack(str, jSONObject);
    }

    public void setPlayerCallBack(PlayerCallBack playerCallBack) {
        this.mPlayerCallBack = playerCallBack;
    }

    @Override // com.baidu.mobads.container.video.CpuLpVideoLayout.OnVideoStatusListener
    public void setVideoLocation(boolean z) {
        PlayerCallBack playerCallBack = this.mPlayerCallBack;
        if (playerCallBack != null) {
            playerCallBack.setVideoLocation(z);
        }
    }

    @Override // com.baidu.mobads.container.video.CpuLpVideoLayout.OnVideoStatusListener
    public void videoNotVisible() {
        PlayerCallBack playerCallBack = this.mPlayerCallBack;
        if (playerCallBack != null) {
            playerCallBack.videoNotVisible();
        }
    }
}
