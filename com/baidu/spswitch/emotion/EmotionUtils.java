package com.baidu.spswitch.emotion;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.spswitch.R;
import com.baidu.spswitch.emotion.resource.EmotionDownloadRuntime;
import com.baidu.spswitch.emotion.resource.IResourceProvider;
import com.baidu.spswitch.utils.SPConfig;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class EmotionUtils {
    public static final boolean CACHE_DEBUG = false;
    public static final String EMOTION_INFO_FILE = "emotion_info.json";
    public static final String KEY_EMOJI_BUNDLE_TIP = "emoji_bundle_tip";
    public static final int OFTEN_SIZE = 7;
    public static final String TAG = "EmotionUtils";
    public static final long THRESHOLD_MS = 10000;
    public static final long WAITING_FOR_LOAD_DEFAULT_MS = 350;
    public static volatile EmotionUtils sInstance;
    public MediaPlayer mMediaPlayer;
    public static final boolean DEBUG = SPConfig.isDebug();
    public static long sLastTimeStampMS = 0;
    public Map<String, EmotionClassic> mEmotionClassicList = new ConcurrentHashMap();
    public List<String> mEmotionPanelList = new CopyOnWriteArrayList();
    public List<String> mRecommendEmotionPanelList = new CopyOnWriteArrayList();
    public Map<String, Bitmap> mEmotionBitmapMap = new HashMap();
    public Semaphore mSync = new Semaphore(0);
    public String mOftenZoneTitle = AppRuntime.getAppContext().getResources().getString(R.string.often_zone_title_default);
    public String mAllZoneTitle = AppRuntime.getAppContext().getResources().getString(R.string.all_zone_title_default);

    /* renamed from: com.baidu.spswitch.emotion.EmotionUtils$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$spswitch$emotion$EmotionType;

        static {
            int[] iArr = new int[EmotionType.values().length];
            $SwitchMap$com$baidu$spswitch$emotion$EmotionType = iArr;
            try {
                iArr[EmotionType.EMOTION_CLASSIC_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class EmotionClassic {
        public File file;
        public String id;
        public String name;

        public EmotionClassic(String str, String str2, File file) {
            this.id = str;
            this.name = str2;
            this.file = file;
        }
    }

    private void freeEmotionSound() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }

    public static EmotionUtils getInstance() {
        if (sInstance == null) {
            synchronized (EmotionUtils.class) {
                if (sInstance == null) {
                    sInstance = new EmotionUtils();
                }
            }
        }
        return sInstance;
    }

    private void initEmotionBitmapCache() {
        Map<String, EmotionClassic> map;
        List<String> list = this.mEmotionPanelList;
        if (list == null || list.isEmpty() || (map = this.mEmotionClassicList) == null || map.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.mEmotionPanelList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (getEmotionBitmapByName(EmotionType.EMOTION_CLASSIC_TYPE, str) == null) {
                it.remove();
                this.mEmotionClassicList.remove(str);
            }
        }
        this.mEmotionPanelList = new CopyOnWriteArrayList(arrayList);
        this.mSync.release();
        if (DEBUG) {
            Log.d(TAG, "thread:" + Thread.currentThread() + "-------initEmotionBitmapCache, release signal-------");
        }
    }

    private void initEmotionSound(IResourceProvider iResourceProvider) {
        if (iResourceProvider == null || iResourceProvider.getEmotionSoundFile() == null || !iResourceProvider.getEmotionSoundFile().exists() || this.mMediaPlayer != null) {
            return;
        }
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mMediaPlayer = mediaPlayer;
            mediaPlayer.setLooping(false);
            this.mMediaPlayer.setDataSource(iResourceProvider.getEmotionSoundFile().getPath());
            this.mMediaPlayer.prepare();
        } catch (Exception unused) {
            this.mMediaPlayer = null;
        }
    }

    private String queryEmotionNameById(String str) {
        return queryEmotionNameById(this.mEmotionClassicList, str);
    }

    public String getAllZoneTitle() {
        return TextUtils.isEmpty(this.mAllZoneTitle) ? AppRuntime.getAppContext().getResources().getString(R.string.all_zone_title_default) : this.mAllZoneTitle;
    }

    public Bitmap getEmotionBitmapByName(EmotionType emotionType, String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Bitmap bitmap = this.mEmotionBitmapMap.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        File emotionFileByName = getEmotionFileByName(emotionType, str);
        if (emotionFileByName != null && emotionFileByName.exists()) {
            try {
                fileInputStream = new FileInputStream(emotionFileByName);
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inDensity = 480;
                    options.inTargetDensity = AppRuntime.getAppContext().getResources().getDisplayMetrics().densityDpi;
                    Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream, null, options);
                    if (decodeStream == null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return null;
                    }
                    this.mEmotionBitmapMap.put(str, decodeStream);
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    return decodeStream;
                } catch (Exception unused) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    public File getEmotionFileByName(EmotionType emotionType, String str) {
        EmotionClassic emotionClassic;
        if (AnonymousClass1.$SwitchMap$com$baidu$spswitch$emotion$EmotionType[emotionType.ordinal()] == 1 && (emotionClassic = this.mEmotionClassicList.get(str)) != null) {
            return emotionClassic.file;
        }
        return null;
    }

    public String getEmotionIdByName(EmotionType emotionType, String str) {
        EmotionClassic emotionClassic = AnonymousClass1.$SwitchMap$com$baidu$spswitch$emotion$EmotionType[emotionType.ordinal()] != 1 ? null : this.mEmotionClassicList.get(str);
        return emotionClassic == null ? "" : emotionClassic.id;
    }

    public String getOftenZoneTitle() {
        return TextUtils.isEmpty(this.mOftenZoneTitle) ? AppRuntime.getAppContext().getResources().getString(R.string.often_zone_title_default) : this.mOftenZoneTitle;
    }

    public List<String> getPanelEmotionList() {
        return this.mEmotionPanelList;
    }

    public List<String> getPanelOftenEmotionList() {
        List<String> emotionUsageList = EmotionUsageUtil.getEmotionUsageList(this.mEmotionClassicList);
        if (emotionUsageList == null) {
            emotionUsageList = new ArrayList<>();
        }
        int i = 0;
        int size = this.mRecommendEmotionPanelList.size();
        while (emotionUsageList.size() < 7 && size > 0) {
            int i2 = i + 1;
            String str = this.mRecommendEmotionPanelList.get(i);
            Map<String, EmotionClassic> map = this.mEmotionClassicList;
            if (map != null && map.containsKey(str) && !TextUtils.isEmpty(str) && emotionUsageList.indexOf(str) == -1) {
                emotionUsageList.add(str);
            }
            size--;
            i = i2;
        }
        return emotionUsageList;
    }

    public boolean isEmotionLoaded(EmotionType emotionType) {
        return isEmotionLoaded(emotionType, true);
    }

    public boolean loadEmotionInfo(IResourceProvider iResourceProvider) {
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        if (iResourceProvider == null) {
            return false;
        }
        String emotionConfigContent = iResourceProvider.getEmotionConfigContent();
        if (TextUtils.isEmpty(emotionConfigContent)) {
            return false;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        try {
            optJSONArray = new JSONObject(emotionConfigContent).optJSONArray("packages");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return false;
        }
        JSONArray optJSONArray2 = optJSONObject.optJSONArray("emoticons");
        if (optJSONArray2 != null) {
            int length = optJSONArray2.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = (JSONObject) optJSONArray2.get(i);
                String optString = jSONObject.optString("id");
                String optString2 = jSONObject.optString("text");
                String optString3 = jSONObject.optString("icon");
                if (!TextUtils.isEmpty(optString3)) {
                    concurrentHashMap.put(optString2, new EmotionClassic(optString, optString2, iResourceProvider.getEmotionIconResFile(optString3)));
                }
            }
        }
        if (concurrentHashMap.isEmpty()) {
            return false;
        }
        JSONArray optJSONArray3 = optJSONObject.optJSONArray("recommend");
        if (optJSONArray3 != null) {
            int length2 = optJSONArray3.length();
            for (int i2 = 0; i2 < length2; i2++) {
                String queryEmotionNameById = queryEmotionNameById(concurrentHashMap, (String) optJSONArray3.get(i2));
                if (!TextUtils.isEmpty(queryEmotionNameById)) {
                    copyOnWriteArrayList2.add(queryEmotionNameById);
                }
            }
        }
        if (!copyOnWriteArrayList2.isEmpty() && copyOnWriteArrayList2.size() >= 7) {
            JSONArray optJSONArray4 = optJSONObject.optJSONArray("panel_emoticons");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i3 = 0; i3 < length3; i3++) {
                    String queryEmotionNameById2 = queryEmotionNameById(concurrentHashMap, (String) optJSONArray4.get(i3));
                    if (!TextUtils.isEmpty(queryEmotionNameById2)) {
                        copyOnWriteArrayList.add(queryEmotionNameById2);
                    }
                }
            }
            if (copyOnWriteArrayList.isEmpty()) {
                return false;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("title");
            if (optJSONObject2 != null) {
                this.mOftenZoneTitle = optJSONObject2.optString("often", AppRuntime.getAppContext().getResources().getString(R.string.often_zone_title_default));
                this.mAllZoneTitle = optJSONObject2.optString("all", AppRuntime.getAppContext().getResources().getString(R.string.all_zone_title_default));
            }
            EmotionLoader.getInstance().invalidCache();
            this.mEmotionBitmapMap.clear();
            this.mEmotionClassicList.clear();
            this.mEmotionClassicList = concurrentHashMap;
            this.mRecommendEmotionPanelList.clear();
            this.mRecommendEmotionPanelList = copyOnWriteArrayList2;
            this.mEmotionPanelList.clear();
            this.mEmotionPanelList = copyOnWriteArrayList;
            initEmotionSound(iResourceProvider);
            initEmotionBitmapCache();
            return true;
        }
        return false;
    }

    public void playEmotionClickSound() {
        int streamVolume;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || mediaPlayer.isPlaying() || (streamVolume = ((AudioManager) AppRuntime.getAppContext().getSystemService("audio")).getStreamVolume(2)) <= 0) {
            return;
        }
        float f2 = streamVolume;
        this.mMediaPlayer.setVolume(f2, f2);
        this.mMediaPlayer.start();
    }

    public void waitForEmotionLoadedIfNeeded(long j) {
        if (isEmotionLoaded(EmotionType.EMOTION_CLASSIC_TYPE)) {
            return;
        }
        if (j <= 0) {
            j = 350;
        }
        if (DEBUG) {
            Log.d(TAG, "thread:" + Thread.currentThread() + "-------waitForEmotionLoaded begin-------");
        }
        try {
            this.mSync.tryAcquire(j, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        if (DEBUG) {
            Log.d(TAG, "thread:" + Thread.currentThread() + "-------waitForEmotionLoaded end-------");
        }
    }

    private String queryEmotionNameById(Map<String, EmotionClassic> map, String str) {
        String str2 = "";
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, EmotionClassic> entry : map.entrySet()) {
                String key = entry.getKey();
                if (str.equals(entry.getValue().id)) {
                    return key;
                }
                str2 = key;
            }
        }
        return str2;
    }

    public boolean isEmotionLoaded(EmotionType emotionType, boolean z) {
        boolean z2 = false;
        if (emotionType == EmotionType.EMOTION_CLASSIC_TYPE && this.mEmotionClassicList.size() > 0 && this.mEmotionPanelList.size() > 0 && this.mRecommendEmotionPanelList.size() > 0) {
            z2 = true;
        }
        if (z && !z2) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - sLastTimeStampMS >= 10000) {
                sLastTimeStampMS = currentTimeMillis;
                if (EmotionDownloadRuntime.getDownloadImpl() != null) {
                    EmotionDownloadRuntime.getDownloadImpl().downloadRetryIfNeeded("from isEmotionLoaded");
                }
            }
        }
        return z2;
    }
}
