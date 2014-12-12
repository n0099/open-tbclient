package com.baidu.channelrtc.medialivesender;

import android.hardware.Camera;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceHolder;
import com.baidu.channelrtc.medialivesender.LiveNativeSender;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class LiveSenderControl {
    private static final String TAG = "LiveSenderController";
    private static final JSONArray devices = getDeviceInfo();
    boolean loadLibrary;
    private String mPublishToken;
    private double mbitRateLevel;
    private int mcameraId;
    private int mrecorderMode;
    private boolean mPubInited = false;
    private LiveNativeSender mNativeSender = new LiveNativeSender();

    /* loaded from: classes.dex */
    public class LiveSenderChannel {
        public static final int LAYOUT_MONO = 1;
        public static final int LAYOUT_STEREO = 2;

        public LiveSenderChannel() {
        }
    }

    /* loaded from: classes.dex */
    public class LiveSenderRecordMode {
        public static final int AUDIO_MODE = 1;
        public static final int DEFAULT_MODE = 0;
        public static final int VIDEO_MODE = 2;

        public LiveSenderRecordMode() {
        }
    }

    /* loaded from: classes.dex */
    public class LiveSenderSampleRate {
        public static final int SAMPLINGRATE_11_025 = 11025;
        public static final int SAMPLINGRATE_12 = 12000;
        public static final int SAMPLINGRATE_16 = 16000;
        public static final int SAMPLINGRATE_22_05 = 22050;
        public static final int SAMPLINGRATE_24 = 24000;
        public static final int SAMPLINGRATE_32 = 32000;
        public static final int SAMPLINGRATE_44_1 = 44100;
        public static final int SAMPLINGRATE_48 = 48000;
        public static final int SAMPLINGRATE_64 = 64000;
        public static final int SAMPLINGRATE_8 = 8000;

        public LiveSenderSampleRate() {
        }
    }

    /* loaded from: classes.dex */
    public class LiveSenderVideoLevel {
        public static final int HIGH = 3;
        public static final int LOW = 1;
        public static final int Middle = 2;

        public LiveSenderVideoLevel() {
        }
    }

    public static boolean checkSDKCap() {
        if (Build.VERSION.SDK_INT >= 10) {
            String upperCase = System.getProperty("os.arch").substring(0, 3).toUpperCase();
            return TextUtils.equals(upperCase, "ARM") || TextUtils.equals(upperCase, "X86");
        }
        return false;
    }

    private static JSONArray getDeviceInfo() {
        try {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i, cameraInfo);
                JSONObject jSONObject = new JSONObject();
                jSONArray.put(jSONObject);
                try {
                    Camera open = Camera.open(i);
                    Camera.Parameters parameters = open.getParameters();
                    List<Camera.Size> supportedPreviewSizes = Build.VERSION.SDK_INT > 10 ? parameters.getSupportedPreviewSizes() : parameters.getSupportedPreviewSizes();
                    open.release();
                    JSONArray jSONArray2 = new JSONArray();
                    for (Camera.Size size : supportedPreviewSizes) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("width", size.width);
                        jSONObject2.put("height", size.height);
                        jSONArray2.put(jSONObject2);
                    }
                    jSONObject.put("front_facing", cameraInfo.facing == 1).put("orientation", cameraInfo.orientation).put("sizes", jSONArray2);
                    Log.i("TAG", jSONObject.toString());
                } catch (RuntimeException e) {
                    Log.e("fff", "Failed to open camera");
                }
            }
            return jSONArray;
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    private JSONObject getSuitableInfo(int i, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("sizes");
            switch (i) {
                case 1:
                    jSONObject2.put("bitrate", (int) (512000.0d * this.mbitRateLevel));
                    jSONObject2.put("size", getSuitablesize(jSONArray, 320));
                    break;
                case 2:
                    jSONObject2.put("bitrate", (int) (1048576.0d * this.mbitRateLevel));
                    jSONObject2.put("size", getSuitablesize(jSONArray, 720));
                    break;
                case 3:
                    jSONObject2.put("bitrate", (int) (3145728.0d * this.mbitRateLevel));
                    jSONObject2.put("size", getSuitablesize(jSONArray, 1280));
                    break;
            }
            return jSONObject2;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private JSONObject getSuitablesize(JSONArray jSONArray, int i) {
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                int i3 = jSONObject.getInt("width");
                int i4 = jSONObject.getInt("height");
                if (i3 > i4) {
                    if (i3 == i) {
                        return jSONObject;
                    }
                } else if (i4 == i) {
                    return jSONObject;
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        int i5 = 0;
        boolean z = false;
        JSONObject jSONObject2 = null;
        while (i5 < jSONArray.length()) {
            JSONObject jSONObject3 = (JSONObject) jSONArray.get(i5);
            if (jSONObject2 != null) {
                z = jSONObject3.getInt("width") > jSONObject2.getInt("width");
            }
            int i6 = jSONObject3.getInt("width");
            int i7 = jSONObject3.getInt("height");
            if (i6 > i7) {
                if (jSONObject3 == null || !z) {
                    if (i6 < i) {
                        return jSONObject3;
                    }
                } else if (i6 > i) {
                    return jSONObject3;
                }
            } else if (jSONObject3 == null || !z) {
                if (i7 < i) {
                    return jSONObject3;
                }
            } else if (i7 > i) {
                return jSONObject3;
            }
            i5++;
            jSONObject2 = jSONObject3;
        }
        return !z ? (JSONObject) jSONArray.get(0) : (JSONObject) jSONArray.get(jSONArray.length() - 1);
    }

    public static void setLibraryPath(String str) {
        LiveNativeSender.setLibraryPath(str);
    }

    public void close() {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.close();
    }

    public int connect(String str) {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return -1;
        }
        return this.mNativeSender.connect(str);
    }

    public void disableAECM() {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.disableAECM();
    }

    public void disableQOS() {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.disableQOS();
    }

    public void enableAEC(boolean z) {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.enableAEC(z);
    }

    public void enableAECM() {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.enableAECM();
    }

    public void enableAECM(boolean z) {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.enableAECM(z);
    }

    public void enableAGC(boolean z) {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.enableAGC(z);
    }

    public void enableNS(boolean z) {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.enableNS(z);
    }

    public void enableQOS() {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.enableQOS();
    }

    public void enableVAD(boolean z) {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.enableVAD(z);
    }

    public void pause() {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.pause();
    }

    public void pauseSrc(int i) {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.pausePub(i);
    }

    public void prepare() {
        Log.i(TAG, "prepare---->");
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        Log.i(TAG, "prepare");
        this.mNativeSender.init();
    }

    public int querySignalStrength() {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return -1;
        }
        return this.mNativeSender.querySignalStrength();
    }

    public void resume() {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.resume();
    }

    public void resumeSrc(int i) {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.resumePub(i);
    }

    public int sendUserCmd(String str, String str2) {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return -1;
        }
        return this.mNativeSender.sendUserCmd(str, str2);
    }

    public int sendUserCmd(String str, String str2, LiveNativeSender.OnCommandResultListener onCommandResultListener) {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return -1;
        }
        return this.mNativeSender.sendUserCmdCallback(str, str2, onCommandResultListener);
    }

    public void setAudioParams(int i, int i2) {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.setAudioParams(i, i2);
    }

    public void setBitRateLevel(double d) {
        this.mbitRateLevel = d;
    }

    public void setEventListener(OnStatusEventListener onStatusEventListener) {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.setOnStatusEventListner(onStatusEventListener);
    }

    public void setLogLevel(int i) {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.setLogLevel(i);
    }

    public void setLogType(int i) {
        Log.i(TAG, "setLogType");
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.setLogType(i);
    }

    public void setLoginInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.setLoginInfo(str, str2, str3, str4, str5, str6);
        this.mPublishToken = str2;
    }

    public void setLoginInfo(Map<String, String> map) {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.setLoginInfoMap(map);
        this.mPublishToken = map.get("publishtoken");
    }

    public void setOption(String str, String str2) {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.setOptions(str, str2);
    }

    public void setRecordMode(int i) {
        this.mrecorderMode = i;
        this.mNativeSender.setRecordMode(i);
    }

    public void setUserCmdListener(OnUserCmdEventListener onUserCmdEventListener) {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.setOnUsercommandCallbackEventListner(onUserCmdEventListener);
    }

    public void setVideoDevice(Camera camera, SurfaceHolder surfaceHolder, int i) {
        this.mcameraId = i;
        VideoRecorder.getInstance().setCamera(camera);
        VideoRecorder.getInstance().setSurfaceHolder(surfaceHolder);
    }

    public void setVideoLevel(int i) {
        JSONObject suitableInfo;
        if (devices == null) {
            throw new RuntimeException();
        }
        try {
            JSONObject jSONObject = (JSONObject) devices.get(this.mcameraId);
            switch (i) {
                case 1:
                    suitableInfo = getSuitableInfo(1, jSONObject);
                    break;
                case 2:
                    suitableInfo = getSuitableInfo(2, jSONObject);
                    break;
                case 3:
                    suitableInfo = getSuitableInfo(3, jSONObject);
                    break;
                default:
                    suitableInfo = null;
                    break;
            }
            try {
                VideoRecorder.getInstance().setVideoEncodingBitRate(suitableInfo.getInt("bitrate"));
                JSONObject jSONObject2 = suitableInfo.getJSONObject("size");
                VideoRecorder.getInstance().setVideoSize(jSONObject2.getInt("width"), jSONObject2.getInt("height"));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void shutdown() {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.shutdown();
        if (this.mrecorderMode == 2 || this.mrecorderMode == 0) {
            VideoRecorder.getInstance().releaseAll();
        }
    }

    public void start() {
        if (this.mNativeSender.isLoadLibraryfailed() || this.mPubInited) {
            return;
        }
        if (this.mrecorderMode != 1) {
            VideoRecorder.getInstance().prepareServer(this.mNativeSender);
        }
        this.mNativeSender.startPub(this.mPublishToken, 16);
        this.mPubInited = true;
    }

    public void startSrc(int i) {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        Log.i(TAG, "enter startSrc");
        if ((i & 1) == 0) {
            this.mNativeSender.startPub(this.mPublishToken, i);
            return;
        }
        this.mNativeSender.startPub(this.mPublishToken, i);
        VideoRecorder.getInstance().start();
    }

    public void stop() {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        this.mNativeSender.stopPub(16);
        this.mPubInited = false;
    }

    public void stopSrc(int i) {
        if (this.mNativeSender.isLoadLibraryfailed()) {
            return;
        }
        if ((i & 1) != 0) {
            VideoRecorder.getInstance().releaseAll();
        }
        this.mNativeSender.stopPub(i);
    }
}
