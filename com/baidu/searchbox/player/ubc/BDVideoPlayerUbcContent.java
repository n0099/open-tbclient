package com.baidu.searchbox.player.ubc;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.util.TiebaStatic;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BDVideoPlayerUbcContent {
    public Builder mBuilder;
    public final JSONObject mExtStatisticsLog;
    public final String mFrom;
    public final String mPage;
    public final long mPlayerPrepareTime;
    public final IUbcPlayerStatusFetcher mPlayerStatusFetcher;
    public final String mPoster;
    public final int mSelectType;
    public final String mTitle;
    public final String mVid;

    /* loaded from: classes2.dex */
    public static class Builder {
        public String extLog;
        public String from;
        public String page;
        public long playerPrepareTime;
        public IUbcPlayerStatusFetcher playerStatusFetcher = new PlayerStatusEmptyFetcher();
        public String poster;
        public int selectType;
        public String title;
        public String url;
        public String vid;

        public BDVideoPlayerUbcContent build() {
            return new BDVideoPlayerUbcContent(this);
        }

        public BDVideoPlayerUbcContent buildEmpty() {
            return new BDVideoPlayerUbcContent(new Builder().extLog(""));
        }

        public Builder extLog(String str) {
            this.extLog = str;
            return this;
        }

        public Builder from(String str) {
            this.from = str;
            return this;
        }

        public Builder id(String str) {
            this.vid = str;
            return this;
        }

        public Builder page(String str) {
            this.page = str;
            return this;
        }

        public Builder playerPrepareTime(long j) {
            this.playerPrepareTime = j;
            return this;
        }

        public Builder playerStatusFetcher(IUbcPlayerStatusFetcher iUbcPlayerStatusFetcher) {
            this.playerStatusFetcher = iUbcPlayerStatusFetcher;
            return this;
        }

        public Builder poster(String str) {
            this.poster = str;
            return this;
        }

        public Builder selectType(int i) {
            this.selectType = i;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }
    }

    @NonNull
    public JSONObject createExtStatisticsLog(@NonNull Builder builder) {
        JSONObject jSONObject;
        try {
            if (!TextUtils.isEmpty(builder.extLog)) {
                jSONObject = new JSONObject(builder.extLog);
            } else {
                jSONObject = new JSONObject();
            }
            jSONObject.put(TiebaStatic.Params.VID, builder.vid);
            jSONObject.put("url", builder.url);
            jSONObject.put("netType", BDVideoPlayerUbcHelper.getNetType());
            if (TextUtils.isEmpty(jSONObject.optString("pdRec"))) {
                jSONObject.put("pdRec", "unKnow");
            }
            return jSONObject;
        } catch (Exception e2) {
            e2.printStackTrace();
            return new JSONObject();
        }
    }

    @NonNull
    public JSONObject getExtStatisticsLog() {
        return this.mExtStatisticsLog;
    }

    @NonNull
    public JSONObject getExtStatisticsLogClone() {
        return createExtStatisticsLog(this.mBuilder);
    }

    @NonNull
    public String getFrom() {
        return this.mFrom;
    }

    @NonNull
    public String getPage() {
        return this.mPage;
    }

    @NonNull
    public IUbcPlayerStatusFetcher getPlayerFetcher() {
        return this.mPlayerStatusFetcher;
    }

    @NonNull
    public long getPlayerPrepareTime() {
        return this.mPlayerPrepareTime;
    }

    @NonNull
    public String getPoster() {
        return this.mPoster;
    }

    @NonNull
    public int getSelectType() {
        return this.mSelectType;
    }

    @NonNull
    public String getTitle() {
        return this.mTitle;
    }

    @NonNull
    public String getVid() {
        return this.mVid;
    }

    public BDVideoPlayerUbcContent(@NonNull Builder builder) {
        this.mBuilder = builder;
        this.mExtStatisticsLog = createExtStatisticsLog(builder);
        this.mVid = builder.vid;
        this.mFrom = builder.from;
        this.mPage = builder.page;
        this.mPoster = builder.poster;
        this.mTitle = builder.title;
        this.mPlayerPrepareTime = builder.playerPrepareTime;
        this.mPlayerStatusFetcher = builder.playerStatusFetcher;
        this.mSelectType = builder.selectType;
    }
}
