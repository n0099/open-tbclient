package com.baidu.searchbox.player.ubc;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BDVideoPlayerUbcContent {
    public final String mClarityKey;
    public final JSONObject mExtStatisticsLog;
    public final String mFrom;
    public final String mPage;
    public final long mPlayerPrepareTime;
    public final IUbcPlayerStatusFetcher mPlayerStatusFetcher;
    public final String mPoster;
    public final int mSelectType;
    public final String mTitle;
    public final String mType;
    public final String mVid;

    /* loaded from: classes2.dex */
    public static class Builder {
        public String clarityKey;
        public String extLog;
        public String from;
        public String page;
        public long playerPrepareTime;
        public IUbcPlayerStatusFetcher playerStatusFetcher = new PlayerStatusEmptyFetcher();
        public String poster;
        public int selectType;
        public String title;
        public String type;
        public String url;
        public String vid;

        public BDVideoPlayerUbcContent build() {
            return new BDVideoPlayerUbcContent(this);
        }

        public BDVideoPlayerUbcContent buildEmpty() {
            return new BDVideoPlayerUbcContent(new Builder().extLog(""));
        }

        public Builder clarityKey(@Nullable String str) {
            this.clarityKey = str;
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
    }

    public BDVideoPlayerUbcContent(@NonNull Builder builder) {
        this.mExtStatisticsLog = createExtStatisticsLog(builder.extLog, builder.vid, builder.url);
        this.mVid = builder.vid;
        this.mFrom = builder.from;
        this.mPage = builder.page;
        this.mPoster = builder.poster;
        this.mTitle = builder.title;
        this.mPlayerPrepareTime = builder.playerPrepareTime;
        this.mPlayerStatusFetcher = builder.playerStatusFetcher;
        this.mSelectType = builder.selectType;
        this.mType = builder.type;
        this.mClarityKey = builder.clarityKey;
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
            jSONObject.put(TiebaStatic.Params.VID, str2);
            jSONObject.put("url", str3);
            jSONObject.put("netType", BDVideoPlayerUbcHelper.getNetType());
            if (TextUtils.isEmpty(jSONObject.optString("pdRec"))) {
                jSONObject.put("pdRec", "unKnow");
            }
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    @Nullable
    public String getClarityKey() {
        return this.mClarityKey;
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
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    @Nullable
    public String getFrom() {
        return this.mFrom;
    }

    @NonNull
    public String getPage() {
        return this.mPage;
    }

    @Nullable
    public IUbcPlayerStatusFetcher getPlayerFetcher() {
        return this.mPlayerStatusFetcher;
    }

    @Nullable
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
}
