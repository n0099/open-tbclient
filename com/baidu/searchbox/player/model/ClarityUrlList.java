package com.baidu.searchbox.player.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.live.interfaces.defaultimpl.utils.MultiRatePlayUrlHelper;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.helper.NetUtils;
import com.baidu.searchbox.player.model.ClaritySelectModel;
import com.baidu.searchbox.player.utils.AuthParser;
import com.baidu.searchbox.player.utils.ClarityDependManager;
import com.baidu.tieba.R;
import com.fun.ad.sdk.FunAdSdk;
import com.tencent.connect.share.QzonePublish;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ClarityUrlList extends ArrayList<ClarityUrl> {
    public static final int DEFAULT_PREFERRED_RANK = -1;
    public static final String UNKNOWN_CLARITY_KEY = "unkown";
    public String mClarityInfoStr;
    public ClarityStrategyModel mClarityStrategyModel;
    public ClarityUrl mCurrentClarityUrl;
    public int mDefaultClarity;
    public int mFullScreen;
    public int mMultiRateSwitchRank;
    public int mPreferredClarityRank;
    public VideoSceneModel mSceneModel;
    public int mSelectType;
    public String selectStrategy;

    /* loaded from: classes4.dex */
    public class AutoClarity extends ClarityUrl {
        public static final String KEY_AUTO_LOG_VALUE = "auto_p";
        public int currentRealRank;

        public AutoClarity() {
            this.mTitle = "自动";
            this.mKey = "auto";
            this.mRank = -1;
            this.mOriginRank = -1;
            this.currentRealRank = -1;
        }
    }

    public ClarityUrlList() {
        this.mFullScreen = 0;
        this.mPreferredClarityRank = -1;
        this.mClarityStrategyModel = null;
    }

    private int getPreferredClarityRank() {
        return this.mPreferredClarityRank;
    }

    @Nullable
    public AutoClarity getAutoClarity() {
        for (int i = 0; i < size(); i++) {
            ClarityUrl clarityUrl = get(i);
            if (clarityUrl instanceof AutoClarity) {
                return (AutoClarity) clarityUrl;
            }
        }
        return null;
    }

    @Nullable
    public ClarityUrl getClarityByIndex() {
        int i = this.mDefaultClarity;
        if (i >= 0 && i < size()) {
            return get(this.mDefaultClarity);
        }
        return null;
    }

    public String getClarityInfoStr() {
        return this.mClarityInfoStr;
    }

    @Nullable
    public ClarityStrategyModel getClarityStrategyModel() {
        return this.mClarityStrategyModel;
    }

    public float getCurrentClarityScore() {
        ClarityUrl clarityUrl = this.mCurrentClarityUrl;
        if (clarityUrl == null) {
            return 0.0f;
        }
        return clarityUrl.getVideoClarityScore();
    }

    @Nullable
    public ClarityUrl getCurrentClarityUrl() {
        return this.mCurrentClarityUrl;
    }

    @NonNull
    public String getCurrentKey() {
        ClarityUrl clarityUrl = this.mCurrentClarityUrl;
        if (clarityUrl != null) {
            String key = clarityUrl.getKey();
            if (!TextUtils.isEmpty(key)) {
                return key;
            }
            return key;
        }
        return "sd";
    }

    public int getCurrentRank() {
        for (int i = 0; i < size(); i++) {
            ClarityUrl clarityUrl = get(i);
            if (clarityUrl != null && clarityUrl.compareTo(this.mCurrentClarityUrl) == 0) {
                return clarityUrl.mRank;
            }
        }
        return this.mDefaultClarity;
    }

    public int getDefaultClarity() {
        return this.mDefaultClarity;
    }

    public String getDefaultTitle() {
        return get(this.mDefaultClarity).getTitle();
    }

    public int getFullscreenType() {
        return this.mFullScreen;
    }

    public ClarityUrl getHighestClarity() {
        return getAvailableHighClarity(true);
    }

    public int getMpdStrategyPreferredClarityRank() {
        ClarityStrategyModel clarityStrategyModel = this.mClarityStrategyModel;
        if (clarityStrategyModel != null) {
            return clarityStrategyModel.getPreferredClarityRank();
        }
        return -1;
    }

    public int getMultiRateSwitchRank() {
        return this.mMultiRateSwitchRank;
    }

    @NonNull
    public String getSelectStrategy() {
        if (TextUtils.isEmpty(this.selectStrategy)) {
            return ClaritySelectModel.Strategy.UNKNOW.value;
        }
        return this.selectStrategy;
    }

    public int getSelectType() {
        return this.mSelectType;
    }

    @Nullable
    public VideoSceneModel getVideoSceneModel() {
        return this.mSceneModel;
    }

    /* loaded from: classes4.dex */
    public static class ClarityUrl implements Comparable<ClarityUrl> {
        public static final String KEY_1080P = "1080p";
        public static final String KEY_1080P_HDR = "1080p_hdr";
        public static final String KEY_AUTO = "auto";
        public static final String KEY_HD = "hd";
        public static final String KEY_SC = "sc";
        public static final String KEY_SD = "sd";
        public static final int RANK_1080P = 3;
        public static final int RANK_1080P_HDR = 4;
        public static final int RANK_AUTO_CLARITY = -1;
        public static final int RANK_HD = 1;
        public static final int RANK_SC = 2;
        public static final int RANK_SD = 0;
        public boolean isWaterMark;
        public String mAirPlayUrl;
        public AuthStrategyModel mAuthModel;
        public long mExpireDate;
        public int mHDR;
        public boolean mHasRealDownloadUrl;
        public int mHeight;
        public String mInteractUrl;
        public String mKey;
        public int mMoovSize;
        public int mOriginRank;
        public int mPrefetchSize;
        public int mRank;
        public String mRealDownloadUrl;
        public String mTitle;
        public String mUrl;
        public int mVideoBps;
        public float mVideoClarityScore;
        public HashMap<String, String> mVideoOption;
        public float mVideoSize;
        public int mWidth;
        public static final String TEXT_SD = BDPlayerConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f17e7);
        public static final String TEXT_HD = BDPlayerConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f17e5);
        public static final String TEXT_SC = BDPlayerConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f17e6);
        public static final String TEXT_1080P = BDPlayerConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f17e3);
        public static final String TEXT_AUTO = BDPlayerConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f17e4);

        public ClarityUrl() {
            this.mOriginRank = -1;
            this.mRank = -1;
            this.mVideoSize = -1.0f;
            this.isWaterMark = false;
        }

        public String getAirPlayUrl() {
            return this.mAirPlayUrl;
        }

        public AuthStrategyModel getAuthModel() {
            return this.mAuthModel;
        }

        public String getDownloadUrl() {
            if (TextUtils.isEmpty(this.mRealDownloadUrl)) {
                return this.mUrl;
            }
            return this.mRealDownloadUrl;
        }

        public long getExpireDate() {
            return this.mExpireDate;
        }

        public boolean getHasRealDownloadUrl() {
            return this.mHasRealDownloadUrl;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public String getInteractUrl() {
            return this.mInteractUrl;
        }

        public String getKey() {
            return this.mKey;
        }

        public int getMoovSize() {
            return this.mMoovSize;
        }

        public int getOriginRank() {
            return this.mOriginRank;
        }

        public int getPrefetchSize() {
            return this.mPrefetchSize;
        }

        public int getRank() {
            return this.mRank;
        }

        public String getRealDownloadUrl() {
            return this.mRealDownloadUrl;
        }

        public String getTitle() {
            return this.mTitle;
        }

        public String getUrl() {
            return this.mUrl;
        }

        public int getVideoBps() {
            return this.mVideoBps;
        }

        public float getVideoClarityScore() {
            return this.mVideoClarityScore;
        }

        public HashMap<String, String> getVideoOption() {
            return this.mVideoOption;
        }

        public float getVideoSize() {
            return this.mVideoSize;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public boolean isHDR() {
            if (this.mHDR == 1) {
                return true;
            }
            return false;
        }

        public boolean isWaterMark() {
            return this.isWaterMark;
        }

        public String toString() {
            return "ClarityUrl{mKey='" + this.mKey + "', mTitle='" + this.mTitle + "'}";
        }

        public ClarityUrl(JSONObject jSONObject, int i) {
            this.mOriginRank = -1;
            this.mRank = -1;
            this.mVideoSize = -1.0f;
            this.isWaterMark = false;
            this.mKey = jSONObject.optString("key");
            int optInt = jSONObject.optInt(MultiRatePlayUrlHelper.RANK, i);
            this.mOriginRank = optInt;
            this.mRank = (i - 1) - optInt;
            this.mTitle = jSONObject.optString("title");
            this.mUrl = jSONObject.optString("url");
            this.mWidth = jSONObject.optInt("width");
            this.mHeight = jSONObject.optInt("height");
            this.mHasRealDownloadUrl = jSONObject.has("download_url");
            this.mRealDownloadUrl = jSONObject.optString("download_url");
            this.mAirPlayUrl = jSONObject.optString("airPlay_url");
            this.mVideoSize = (float) jSONObject.optDouble(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, -1.0d);
            this.mVideoClarityScore = (float) jSONObject.optDouble("video_clarity_score", -1.0d);
            String optString = jSONObject.optString("h265Url", "");
            if (!TextUtils.isEmpty(optString) && jSONObject.has("h265VideoSize")) {
                this.mUrl = optString;
                this.mVideoSize = (float) jSONObject.optDouble("h265VideoSize");
            }
            if (jSONObject.has("cache_buffer") && jSONObject.has("min") && jSONObject.has(FunAdSdk.PLATFORM_MAX)) {
                HashMap<String, String> hashMap = new HashMap<>(3);
                this.mVideoOption = hashMap;
                hashMap.put("max-buffer-size", jSONObject.optString("cache_buffer"));
                this.mVideoOption.put(CyberPlayerManager.OPT_FILE_MIN_SIZE, jSONObject.optString("min"));
                this.mVideoOption.put(CyberPlayerManager.OPT_FILE_MAX_SIZE, jSONObject.optString(FunAdSdk.PLATFORM_MAX));
            } else {
                this.mVideoOption = null;
            }
            this.mVideoBps = jSONObject.optInt("videoBps");
            this.mMoovSize = jSONObject.optInt("vodMoovSize");
            this.mAuthModel = AuthParser.parseAuthStrategy(jSONObject.optString("auth"));
            this.mExpireDate = jSONObject.optLong("expire_date");
            this.mInteractUrl = jSONObject.optString("interact_url");
            this.mPrefetchSize = jSONObject.optInt("prefetch_size");
            this.mHDR = jSONObject.optInt("hdr");
            this.isWaterMark = jSONObject.optInt("watermark", 0) == 1;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(ClarityUrl clarityUrl) {
            int i = this.mRank;
            int i2 = clarityUrl.mRank;
            if (i == i2) {
                return 0;
            }
            if (i > i2) {
                return 1;
            }
            return -1;
        }

        public boolean isSelected(@NonNull String str) {
            return str.equals(getKey());
        }

        public void setKey(String str) {
            this.mKey = str;
        }

        public void setRank(int i) {
            this.mRank = i;
        }

        public void setRealDownloadUrl(String str) {
            this.mRealDownloadUrl = str;
        }

        public void setTitle(String str) {
            this.mTitle = str;
        }

        public void setUrl(String str) {
            this.mUrl = str;
        }

        public void setVideoClarityScore(float f) {
            this.mVideoClarityScore = f;
        }

        public void setVideoOption(HashMap<String, String> hashMap) {
            this.mVideoOption = hashMap;
        }

        public void setVideoSize(float f) {
            this.mVideoSize = f;
        }
    }

    public ClarityUrlList(JSONArray jSONArray) {
        this.mFullScreen = 0;
        this.mPreferredClarityRank = -1;
        this.mClarityStrategyModel = null;
        if (jSONArray == null) {
            return;
        }
        this.mClarityInfoStr = jSONArray.toString();
        convert(jSONArray);
        updateClarityUrlParams(null);
    }

    @Nullable
    public ClarityUrl getClarityByOriginRank(int i) {
        for (int i2 = 0; i2 < size(); i2++) {
            ClarityUrl clarityUrl = get(i2);
            if (clarityUrl.getOriginRank() == i) {
                return clarityUrl;
            }
        }
        return null;
    }

    public void setClarityStrategyModel(ClarityStrategyModel clarityStrategyModel) {
        this.mClarityStrategyModel = clarityStrategyModel;
    }

    public void setCurrentClarityUrl(ClarityUrl clarityUrl) {
        this.mCurrentClarityUrl = clarityUrl;
    }

    public void setDefaultClarity(int i) {
        if (i >= 0 && i < size()) {
            this.mDefaultClarity = i;
        } else {
            this.mDefaultClarity = 0;
        }
    }

    public void setMultiRateSwitchRank(int i) {
        this.mMultiRateSwitchRank = i;
    }

    public void setPreferredClarityRank(int i) {
        this.mPreferredClarityRank = i;
    }

    public void updateClarityUrlParams(@Nullable VideoSceneModel videoSceneModel) {
        Iterator<ClarityUrl> it = iterator();
        while (it.hasNext()) {
            ClarityUrl next = it.next();
            next.setUrl(NetUtils.appendCDNStatParams(next.getUrl(), 1, ClarityDependManager.get().getDeviceScore(), videoSceneModel));
        }
    }

    public ClarityUrlList(JSONArray jSONArray, boolean z, @Nullable VideoSceneModel videoSceneModel) {
        this.mFullScreen = 0;
        this.mPreferredClarityRank = -1;
        this.mClarityStrategyModel = null;
        if (jSONArray == null) {
            return;
        }
        this.mFullScreen = z ? 1 : 0;
        this.mSceneModel = videoSceneModel;
        this.mClarityInfoStr = jSONArray.toString();
        convert(jSONArray);
        updateClarityUrlParams(videoSceneModel);
    }

    public ClarityUrlList(JSONArray jSONArray, boolean z, @Nullable VideoSceneModel videoSceneModel, @Nullable ClarityStrategyModel clarityStrategyModel) {
        this.mFullScreen = 0;
        this.mPreferredClarityRank = -1;
        this.mClarityStrategyModel = null;
        if (jSONArray == null) {
            return;
        }
        this.mFullScreen = z ? 1 : 0;
        this.mSceneModel = videoSceneModel;
        this.mClarityInfoStr = jSONArray.toString();
        this.mClarityStrategyModel = clarityStrategyModel;
        convert(jSONArray);
        updateClarityUrlParams(videoSceneModel);
    }

    private void convert(@NonNull JSONArray jSONArray) {
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                add(new ClarityUrl(optJSONObject, length));
            }
        }
        if (size() <= 0) {
            return;
        }
        Collections.sort(this);
        ClaritySelectModel shortVideoVideoClarityStrategy = ClarityDependManager.get().getShortVideoVideoClarityStrategy(this, get(size() - 1).getVideoClarityScore(), getPreferredClarityRank());
        if (shortVideoVideoClarityStrategy != null) {
            this.mSelectType = shortVideoVideoClarityStrategy.selectType;
            this.selectStrategy = shortVideoVideoClarityStrategy.selectStrategy;
            int i2 = shortVideoVideoClarityStrategy.selectClarity;
            this.mDefaultClarity = i2;
            ClarityUrl clarityUrl = get(i2);
            this.mCurrentClarityUrl = clarityUrl;
            this.mMultiRateSwitchRank = clarityUrl.mRank;
        }
    }

    @NonNull
    public String getClarityInfo(VideoSceneModel videoSceneModel) {
        if (TextUtils.isEmpty(this.mClarityInfoStr)) {
            return "";
        }
        String deviceScore = ClarityDependManager.get().getDeviceScore();
        try {
            JSONArray jSONArray = new JSONArray(this.mClarityInfoStr);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    optJSONObject.put("url", NetUtils.appendCDNStatParams(optJSONObject.optString("url"), 1, deviceScore, videoSceneModel));
                }
            }
            return jSONArray.toString();
        } catch (JSONException e) {
            if (BDPlayerConfig.isDebug()) {
                e.printStackTrace();
            }
            return "";
        }
    }

    @Nullable
    public ClarityUrl getAvailableHighClarity(boolean z) {
        for (int i = 0; i < size(); i++) {
            ClarityUrl clarityUrl = get(i);
            if (!clarityUrl.mKey.equals("auto") && ((!clarityUrl.mKey.equals(ClarityUrl.KEY_1080P) && !clarityUrl.mKey.equals(ClarityUrl.KEY_1080P_HDR)) || z)) {
                return clarityUrl;
            }
        }
        return null;
    }

    public String getDefaultUrl() {
        int i;
        if (this.mDefaultClarity < size() && (i = this.mDefaultClarity) >= 0) {
            if (!"auto".equals(get(i).getKey())) {
                return get(this.mDefaultClarity).getUrl();
            }
            return get(0).getUrl();
        }
        return "";
    }

    public void updateCurrentClarityToLowest() {
        if (isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this);
        Collections.sort(arrayList, new Comparator<ClarityUrl>() { // from class: com.baidu.searchbox.player.model.ClarityUrlList.1
            private int calcValueBy(String str) {
                char c;
                int hashCode = str.hashCode();
                if (hashCode != -974239824) {
                    if (hashCode != 3324) {
                        if (hashCode != 46737913) {
                            if (hashCode != 3664) {
                                if (hashCode == 3665 && str.equals("sd")) {
                                    c = 0;
                                }
                                c = 65535;
                            } else {
                                if (str.equals("sc")) {
                                    c = 2;
                                }
                                c = 65535;
                            }
                        } else {
                            if (str.equals(ClarityUrl.KEY_1080P)) {
                                c = 3;
                            }
                            c = 65535;
                        }
                    } else {
                        if (str.equals(ClarityUrl.KEY_HD)) {
                            c = 1;
                        }
                        c = 65535;
                    }
                } else {
                    if (str.equals(ClarityUrl.KEY_1080P_HDR)) {
                        c = 4;
                    }
                    c = 65535;
                }
                if (c == 0) {
                    return 1;
                }
                if (c == 1) {
                    return 2;
                }
                if (c == 2) {
                    return 3;
                }
                if (c == 3) {
                    return 4;
                }
                if (c != 4) {
                    return Integer.MAX_VALUE;
                }
                return 5;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(ClarityUrl clarityUrl, ClarityUrl clarityUrl2) {
                return calcValueBy(clarityUrl.getKey()) - calcValueBy(clarityUrl2.getKey());
            }
        });
        setCurrentClarityUrl((ClarityUrl) arrayList.get(0));
        if (ClarityDependManager.get().getMultiRateSwitchEnable()) {
            setMultiRateSwitchRank(((ClarityUrl) arrayList.get(0)).mRank);
        }
    }
}
