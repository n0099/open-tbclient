package com.baidu.spswitch.emotion;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.spswitch.emotion.resource.EmotionDownloadRuntime;
import com.baidu.spswitch.emotion.resource.IResourceProvider;
import com.baidu.spswitch.utils.SPConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
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
/* loaded from: classes4.dex */
public class EmotionUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean CACHE_DEBUG = false;
    public static final boolean DEBUG;
    public static final String EMOTION_EFFECT_INFO_FILE = "effect_info.json";
    public static final String EMOTION_INFO_FILE = "emotion_info.json";
    public static final int FIXED_SIZE = 2;
    public static final String KEY_EMOJI_BUNDLE_TIP = "emoji_bundle_tip";
    public static final int OFTEN_SIZE = 7;
    public static final String TAG = "EmotionUtils";
    public static final long THRESHOLD_MS = 10000;
    public static final long WAITING_FOR_LOAD_DEFAULT_MS = 350;
    public static volatile EmotionUtils sInstance;
    public static long sLastTimeStampMS;
    public transient /* synthetic */ FieldHolder $fh;
    public String mAllZoneTitle;
    public Map<String, String> mDynamicEmotionList;
    public Map<String, Bitmap> mEmotionBitmapMap;
    public Map<String, EmotionClassic> mEmotionClassicList;
    public List<String> mEmotionPanelList;
    public List<String> mFixedEmotionPanelList;
    public MediaPlayer mMediaPlayer;
    public String mOftenZoneTitle;
    public List<String> mRecommendEmotionPanelList;
    public String mSoundSourcePath;
    public Semaphore mSync;

    /* renamed from: com.baidu.spswitch.emotion.EmotionUtils$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$spswitch$emotion$EmotionType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1913742957, "Lcom/baidu/spswitch/emotion/EmotionUtils$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1913742957, "Lcom/baidu/spswitch/emotion/EmotionUtils$2;");
                    return;
                }
            }
            int[] iArr = new int[EmotionType.values().length];
            $SwitchMap$com$baidu$spswitch$emotion$EmotionType = iArr;
            try {
                iArr[EmotionType.EMOTION_CLASSIC_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class EmotionClassic {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public File file;
        public String id;
        public String name;

        public EmotionClassic(String str, String str2, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.id = str;
            this.name = str2;
            this.file = file;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1580129761, "Lcom/baidu/spswitch/emotion/EmotionUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1580129761, "Lcom/baidu/spswitch/emotion/EmotionUtils;");
                return;
            }
        }
        DEBUG = SPConfig.isDebug();
        sLastTimeStampMS = 0L;
    }

    public static EmotionUtils getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (sInstance == null) {
                synchronized (EmotionUtils.class) {
                    if (sInstance == null) {
                        sInstance = new EmotionUtils();
                    }
                }
            }
            return sInstance;
        }
        return (EmotionUtils) invokeV.objValue;
    }

    public void freeEmotionSound() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (mediaPlayer = this.mMediaPlayer) != null) {
            mediaPlayer.stop();
            this.mMediaPlayer.reset();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
    }

    public String getAllZoneTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(this.mAllZoneTitle)) {
                return AppRuntime.getAppContext().getResources().getString(R.string.all_zone_title_default);
            }
            return this.mAllZoneTitle;
        }
        return (String) invokeV.objValue;
    }

    public List<String> getFixedEmotionPanelList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mFixedEmotionPanelList;
        }
        return (List) invokeV.objValue;
    }

    public String getOftenZoneTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (TextUtils.isEmpty(this.mOftenZoneTitle)) {
                return AppRuntime.getAppContext().getResources().getString(R.string.often_zone_title_default);
            }
            return this.mOftenZoneTitle;
        }
        return (String) invokeV.objValue;
    }

    public List<String> getPanelEmotionList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mEmotionPanelList;
        }
        return (List) invokeV.objValue;
    }

    public EmotionUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mEmotionClassicList = new ConcurrentHashMap();
        this.mEmotionPanelList = new CopyOnWriteArrayList();
        this.mRecommendEmotionPanelList = new CopyOnWriteArrayList();
        this.mFixedEmotionPanelList = Collections.synchronizedList(new ArrayList());
        this.mDynamicEmotionList = new ConcurrentHashMap();
        this.mEmotionBitmapMap = new HashMap();
        this.mSync = new Semaphore(0);
        this.mOftenZoneTitle = AppRuntime.getAppContext().getResources().getString(R.string.often_zone_title_default);
        this.mAllZoneTitle = AppRuntime.getAppContext().getResources().getString(R.string.all_zone_title_default);
    }

    private void initEmotionBitmapCache() {
        List<String> list;
        Map<String, EmotionClassic> map;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && (list = this.mEmotionPanelList) != null && !list.isEmpty() && (map = this.mEmotionClassicList) != null && !map.isEmpty()) {
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
    }

    public void playEmotionClickSound() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if ((mediaPlayer != null && mediaPlayer.isPlaying()) || TextUtils.isEmpty(this.mSoundSourcePath)) {
                return;
            }
            try {
                int streamVolume = ((AudioManager) AppRuntime.getAppContext().getSystemService("audio")).getStreamVolume(2);
                if (this.mMediaPlayer == null) {
                    MediaPlayer mediaPlayer2 = new MediaPlayer();
                    this.mMediaPlayer = mediaPlayer2;
                    mediaPlayer2.setLooping(false);
                    this.mMediaPlayer.setDataSource(this.mSoundSourcePath);
                    this.mMediaPlayer.prepare();
                    this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener(this, streamVolume) { // from class: com.baidu.spswitch.emotion.EmotionUtils.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ EmotionUtils this$0;
                        public final /* synthetic */ int val$currentVolume;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(streamVolume)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$currentVolume = streamVolume;
                        }

                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer3) {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 != null && interceptable2.invokeL(1048576, this, mediaPlayer3) != null) || this.val$currentVolume <= 0) {
                                return;
                            }
                            MediaPlayer mediaPlayer4 = this.this$0.mMediaPlayer;
                            int i = this.val$currentVolume;
                            mediaPlayer4.setVolume(i, i);
                            this.this$0.mMediaPlayer.start();
                        }
                    });
                } else if (streamVolume > 0) {
                    float f = streamVolume;
                    this.mMediaPlayer.setVolume(f, f);
                    this.mMediaPlayer.start();
                }
            } catch (Exception unused) {
                this.mMediaPlayer = null;
            }
        }
    }

    private void initEmotionSound(IResourceProvider iResourceProvider) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, this, iResourceProvider) == null) && iResourceProvider != null && iResourceProvider.getEmotionSoundFile() != null && iResourceProvider.getEmotionSoundFile().exists()) {
            this.mSoundSourcePath = iResourceProvider.getEmotionSoundFile().getPath();
        }
    }

    private String queryEmotionNameById(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, str)) == null) {
            return queryEmotionNameById(this.mEmotionClassicList, str);
        }
        return (String) invokeL.objValue;
    }

    public String getEmotionEffectPathByName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return this.mDynamicEmotionList.get(str);
        }
        return (String) invokeL.objValue;
    }

    public boolean isEmotionLoaded(EmotionType emotionType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, emotionType)) == null) {
            return isEmotionLoaded(emotionType, true);
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getScreenWidth(Context context) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.getWindow() != null) {
                    Point point = new Point();
                    activity.getWindow().getWindowManager().getDefaultDisplay().getSize(point);
                    i = point.x;
                    int i2 = point.y;
                    if (DeviceUtils.ScreenInfo.isScreenLand()) {
                        i = i2;
                    }
                    if (i > 0) {
                        if (DeviceUtils.ScreenInfo.isScreenLand()) {
                            return DeviceUtils.ScreenInfo.getDisplayHeight(AppRuntime.getAppContext());
                        }
                        return DeviceUtils.ScreenInfo.getDisplayWidth(AppRuntime.getAppContext());
                    }
                    return i;
                }
            }
            i = 0;
            if (i > 0) {
            }
        } else {
            return invokeL.intValue;
        }
    }

    private void loadEmotionEffectInfo(IResourceProvider iResourceProvider) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65543, this, iResourceProvider) != null) || iResourceProvider == null) {
            return;
        }
        String emotionEffectInfoContent = iResourceProvider.getEmotionEffectInfoContent();
        if (TextUtils.isEmpty(emotionEffectInfoContent)) {
            return;
        }
        try {
            JSONArray optJSONArray = new JSONObject(emotionEffectInfoContent).optJSONArray("emoticons");
            if (optJSONArray == null) {
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("text");
                    String optString2 = optJSONObject.optString("anim");
                    String emotionEffectBasePath = iResourceProvider.getEmotionEffectBasePath();
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(emotionEffectBasePath)) {
                        String str = emotionEffectBasePath + "/" + optString2;
                        if (FileUtils.exists(str)) {
                            this.mDynamicEmotionList.put(optString, str);
                        }
                    }
                }
            }
        } catch (Exception e) {
            if (SPConfig.isDebug()) {
                e.printStackTrace();
            }
        }
    }

    public void waitForEmotionLoadedIfNeeded(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048591, this, j) != null) || isEmotionLoaded(EmotionType.EMOTION_CLASSIC_TYPE)) {
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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (DEBUG) {
            Log.d(TAG, "thread:" + Thread.currentThread() + "-------waitForEmotionLoaded end-------");
        }
    }

    private String queryEmotionNameById(Map<String, EmotionClassic> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, map, str)) == null) {
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
        return (String) invokeLL.objValue;
    }

    public boolean isEmotionLoaded(EmotionType emotionType, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, emotionType, z)) == null) {
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
        return invokeLZ.booleanValue;
    }

    @Nullable
    public Bitmap getEmotionBitmapByName(EmotionType emotionType, String str) {
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, emotionType, str)) == null) {
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
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return null;
                        }
                        this.mEmotionBitmapMap.put(str, decodeStream);
                        try {
                            fileInputStream.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return decodeStream;
                    } catch (Exception unused) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
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
        return (Bitmap) invokeLL.objValue;
    }

    @Nullable
    public File getEmotionFileByName(EmotionType emotionType, String str) {
        InterceptResult invokeLL;
        EmotionClassic emotionClassic;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, emotionType, str)) == null) {
            if (AnonymousClass2.$SwitchMap$com$baidu$spswitch$emotion$EmotionType[emotionType.ordinal()] == 1 && (emotionClassic = this.mEmotionClassicList.get(str)) != null) {
                return emotionClassic.file;
            }
            return null;
        }
        return (File) invokeLL.objValue;
    }

    @Nullable
    public String getEmotionIdByName(EmotionType emotionType, String str) {
        InterceptResult invokeLL;
        EmotionClassic emotionClassic;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, emotionType, str)) == null) {
            if (AnonymousClass2.$SwitchMap$com$baidu$spswitch$emotion$EmotionType[emotionType.ordinal()] != 1) {
                emotionClassic = null;
            } else {
                emotionClassic = this.mEmotionClassicList.get(str);
            }
            if (emotionClassic == null) {
                return "";
            }
            return emotionClassic.id;
        }
        return (String) invokeLL.objValue;
    }

    @Nullable
    public String getEmotionUriByName(EmotionType emotionType, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, emotionType, str)) == null) {
            File emotionFileByName = getEmotionFileByName(emotionType, str);
            if (emotionFileByName != null && emotionFileByName.exists()) {
                return Uri.fromFile(emotionFileByName).toString();
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public List<String> getPanelOftenEmotionList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            List<String> emotionUsageList = EmotionUsageUtil.getEmotionUsageList(this.mEmotionClassicList, this.mEmotionPanelList);
            if (emotionUsageList == null) {
                emotionUsageList = new ArrayList<>();
            }
            int i = 0;
            int size = this.mRecommendEmotionPanelList.size();
            while (emotionUsageList.size() < 7 && size > 0) {
                int i2 = i + 1;
                String str = this.mRecommendEmotionPanelList.get(i);
                Map<String, EmotionClassic> map = this.mEmotionClassicList;
                if (map != null && map.containsKey(str) && !TextUtils.isEmpty(str) && !emotionUsageList.contains(str)) {
                    emotionUsageList.add(str);
                }
                size--;
                i = i2;
            }
            try {
                if (emotionUsageList.size() > this.mFixedEmotionPanelList.size()) {
                    int size2 = emotionUsageList.size() - this.mFixedEmotionPanelList.size();
                    for (String str2 : this.mFixedEmotionPanelList) {
                        if (size2 < 0 || size2 >= emotionUsageList.size()) {
                            break;
                        }
                        int i3 = size2 + 1;
                        emotionUsageList.set(size2, str2);
                        size2 = i3;
                    }
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            return emotionUsageList;
        }
        return (List) invokeV.objValue;
    }

    public boolean loadEmotionInfo(IResourceProvider iResourceProvider) {
        InterceptResult invokeL;
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, iResourceProvider)) == null) {
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
            } catch (JSONException e) {
                e.printStackTrace();
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
                try {
                    if (this.mRecommendEmotionPanelList.size() > 2) {
                        this.mFixedEmotionPanelList.clear();
                        for (String str : this.mRecommendEmotionPanelList) {
                            int indexOf = this.mRecommendEmotionPanelList.indexOf(str);
                            if (indexOf >= this.mRecommendEmotionPanelList.size() - 2 && indexOf > 0 && indexOf < this.mRecommendEmotionPanelList.size()) {
                                this.mFixedEmotionPanelList.add(str);
                            }
                        }
                    }
                } catch (Exception e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
                initEmotionSound(iResourceProvider);
                initEmotionBitmapCache();
                loadEmotionEffectInfo(iResourceProvider);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
