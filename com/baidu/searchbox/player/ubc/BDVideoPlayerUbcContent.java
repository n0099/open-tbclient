package com.baidu.searchbox.player.ubc;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.searchbox.player.model.StringArrayBundle;
import com.baidu.searchbox.player.utils.BasicVideoParserKt;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BDVideoPlayerUbcContent {
    public final String mClarityKey;
    public final float mClarityScore;
    public final String mClaritySelectStrategy;
    public final JSONObject mExtStatisticsLog;
    public final String mFrom;
    public final String mHighestKey;
    public final int mKernelType;
    public final String mPage;
    public StringArrayBundle mParams;
    public final long mPlayerPrepareTime;
    public final IUbcPlayerStatusFetcher mPlayerStatusFetcher;
    public final String mPoster;
    public final int mSelectType;
    public final String mSource;
    public final String mTitle;
    public final String mType;
    public final String mVid;
    public final int mVideoBps;
    public final int mVideoHeight;
    public final String mVideoSize;
    public final int mVideoWidth;

    /* loaded from: classes4.dex */
    public static class Builder {
        public String clarityKey;
        public float clarityScore;
        public String claritySelectStrategy;
        public String extLog;
        public String from;
        public String highestKey;
        public String kernelType;
        public String page;
        public long playerPrepareTime;
        public IUbcPlayerStatusFetcher playerStatusFetcher = new PlayerStatusEmptyFetcher();
        public String poster;
        public int selectType;
        public String source;
        public String title;
        public String type;
        public String url;
        public String vid;
        public int videoBps;
        public int videoHeight;
        public String videoSize;
        public int videoWidth;

        public BDVideoPlayerUbcContent build() {
            return new BDVideoPlayerUbcContent(this);
        }

        public BDVideoPlayerUbcContent buildEmpty() {
            return new BDVideoPlayerUbcContent(new Builder().extLog(""));
        }

        public Builder clarityHighestKey(@Nullable String str) {
            this.highestKey = str;
            return this;
        }

        public Builder clarityKey(@Nullable String str) {
            this.clarityKey = str;
            return this;
        }

        public Builder clarityScore(float f) {
            this.clarityScore = f;
            return this;
        }

        public Builder claritySelectStrategy(@Nullable String str) {
            this.claritySelectStrategy = str;
            return this;
        }

        public Builder extLog(@Nullable String str) {
            this.extLog = str;
            return this;
        }

        public Builder from(@Nullable String str) {
            this.from = str;
            return this;
        }

        public Builder id(@Nullable String str) {
            this.vid = str;
            return this;
        }

        public Builder kernelType(String str) {
            this.kernelType = str;
            return this;
        }

        public Builder page(@Nullable String str) {
            this.page = str;
            return this;
        }

        public Builder playerPrepareTime(long j) {
            this.playerPrepareTime = j;
            return this;
        }

        public Builder playerStatusFetcher(@Nullable IUbcPlayerStatusFetcher iUbcPlayerStatusFetcher) {
            this.playerStatusFetcher = iUbcPlayerStatusFetcher;
            return this;
        }

        public Builder poster(@Nullable String str) {
            this.poster = str;
            return this;
        }

        public Builder selectType(int i) {
            this.selectType = i;
            return this;
        }

        public Builder source(@Nullable String str) {
            this.source = str;
            return this;
        }

        public Builder title(@Nullable String str) {
            this.title = str;
            return this;
        }

        public Builder type(@Nullable String str) {
            this.type = str;
            return this;
        }

        public Builder url(@Nullable String str) {
            this.url = str;
            return this;
        }

        public Builder videoBps(int i) {
            this.videoBps = i;
            return this;
        }

        public Builder videoHeight(int i) {
            this.videoHeight = i;
            return this;
        }

        public Builder videoSize(@Nullable String str) {
            this.videoSize = str;
            return this;
        }

        public Builder videoWidth(int i) {
            this.videoWidth = i;
            return this;
        }
    }

    public BDVideoPlayerUbcContent(@NonNull Builder builder) {
        this.mParams = new StringArrayBundle();
        this.mExtStatisticsLog = createExtStatisticsLog(builder.extLog, builder.vid, builder.url);
        this.mVid = builder.vid;
        this.mFrom = builder.from;
        this.mPage = builder.page;
        this.mSource = builder.source;
        this.mPoster = builder.poster;
        this.mTitle = builder.title;
        this.mPlayerPrepareTime = builder.playerPrepareTime;
        this.mPlayerStatusFetcher = builder.playerStatusFetcher;
        this.mSelectType = builder.selectType;
        this.mType = builder.type;
        this.mClarityKey = builder.clarityKey;
        this.mClaritySelectStrategy = builder.claritySelectStrategy;
        this.mHighestKey = builder.highestKey;
        this.mClarityScore = builder.clarityScore;
        this.mVideoSize = builder.videoSize;
        this.mVideoBps = builder.videoBps;
        this.mVideoWidth = builder.videoWidth;
        this.mVideoHeight = builder.videoHeight;
        this.mKernelType = kernelTypeMapping(builder.kernelType);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int kernelTypeMapping(@Nullable String str) {
        char c;
        if (str == null) {
            return -1;
        }
        switch (str.hashCode()) {
            case -1843224545:
                if (str.equals("InlineVideoKernel")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1026184943:
                if (str.equals(AbsVideoKernel.NORMAL_PLAYER)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 313531039:
                if (str.equals(AbsVideoKernel.CYBER_PLAYER)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 471763062:
                if (str.equals("InteractiveVideoKernel")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 704943164:
                if (str.equals("VRVideoKernel")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
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
            return -1;
        }
        return 5;
    }

    public void putExtra(@Nullable String str, @Nullable Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mParams.putExtra(str, obj);
    }

    @NonNull
    private JSONObject createExtStatisticsLog(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        JSONObject jSONObject;
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject(str);
            } else {
                jSONObject = new JSONObject();
            }
            jSONObject.put("vid", str2);
            jSONObject.put("url", str3);
            jSONObject.put("netType", BDVideoPlayerUbcHelper.getNetType());
            if (TextUtils.isEmpty(jSONObject.optString(BasicVideoParserKt.PD_REC))) {
                jSONObject.put(BasicVideoParserKt.PD_REC, "unKnow");
            }
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    @Nullable
    public String getClarityHighestKey() {
        return this.mHighestKey;
    }

    @Nullable
    public String getClarityKey() {
        return this.mClarityKey;
    }

    public float getClarityScore() {
        return this.mClarityScore;
    }

    @NonNull
    public String getClaritySelectStrategy() {
        if (TextUtils.isEmpty(this.mClaritySelectStrategy)) {
            return DownloadStatisticConstants.UBC_VALUE_UNKNOW;
        }
        return this.mClaritySelectStrategy;
    }

    @NonNull
    public JSONObject getExtStatisticsLog() {
        return this.mExtStatisticsLog;
    }

    @NonNull
    public JSONObject getExtStatisticsLogClone() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = this.mExtStatisticsLog;
        if (jSONObject2 == null) {
            return jSONObject;
        }
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                jSONObject.put(next, this.mExtStatisticsLog.optString(next));
            } catch (JSONException e) {
                if (BDPlayerConfig.isDebug()) {
                    e.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    @Nullable
    public String getFrom() {
        return this.mFrom;
    }

    public int getKernelType() {
        return this.mKernelType;
    }

    @NonNull
    public String getPage() {
        return this.mPage;
    }

    @Nullable
    public IUbcPlayerStatusFetcher getPlayerFetcher() {
        return this.mPlayerStatusFetcher;
    }

    public long getPlayerPrepareTime() {
        return this.mPlayerPrepareTime;
    }

    @Nullable
    public String getPoster() {
        return this.mPoster;
    }

    public int getSelectType() {
        return this.mSelectType;
    }

    @Nullable
    public String getSource() {
        return this.mSource;
    }

    @Nullable
    public String getTitle() {
        return this.mTitle;
    }

    @Nullable
    public String getType() {
        return this.mType;
    }

    @Nullable
    public String getVid() {
        return this.mVid;
    }

    public int getVideoBps() {
        return this.mVideoBps;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    @Nullable
    public String getVideoSize() {
        return this.mVideoSize;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public JSONObject putPublicParams(@NonNull JSONObject jSONObject) {
        StringArrayBundle stringArrayBundle = this.mParams;
        if (stringArrayBundle != null && stringArrayBundle.size() >= 1) {
            for (String str : this.mParams.keySet()) {
                try {
                    jSONObject.put(str, this.mParams.get(str));
                } catch (JSONException e) {
                    if (BDPlayerConfig.isDebug()) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return jSONObject;
    }
}
