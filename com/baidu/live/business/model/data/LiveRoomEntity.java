package com.baidu.live.business.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.searchbox.live.interfaces.defaultimpl.utils.MultiRatePlayUrlHelper;
import com.baidu.searchbox.live.interfaces.service.bd.IFavorStateServiceKt;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveRoomEntity implements Parcelable {
    public static final Parcelable.Creator<LiveRoomEntity> CREATOR = new Parcelable.Creator<LiveRoomEntity>() { // from class: com.baidu.live.business.model.data.LiveRoomEntity.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveRoomEntity createFromParcel(Parcel parcel) {
            return new LiveRoomEntity(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveRoomEntity[] newArray(int i) {
            return new LiveRoomEntity[i];
        }
    };
    public int audienceCount;
    public int autoPlay;
    public List<LiveBannerEntity> bannerList;
    public String beginTime;
    public String belongSubTab;
    public String belongThirdTab;
    public String cmd;
    public String cover;
    public String feedId;
    public String feedTag;
    public boolean fromReserve;
    public String grExt;
    public boolean hasInterest;
    public boolean hasInterestClick;
    public LiveHostInfo hostInfo;
    public LeftLableInfo leftLabel;
    public int liveStatus;
    public String liveTag;
    public boolean needLogShow;
    public String nid;
    public String playUrl;
    public int rank;
    public LiveFeedReserveHeaderInfo reserveHeaderInfo;
    public long reserveStartTime;
    public RightLableInfo rightLabel;
    public String roomId;
    public String sessionId;
    public int showTpl;
    public LiveStatInfo statInfo;
    public int templateId;
    public ThirdLabelInfo thirdLabel;
    public String title;
    public String topicId;
    public List<LiveRoomEntity> topicRoomList;
    public String videoScreen;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LiveRoomEntity() {
        this.needLogShow = true;
        this.fromReserve = false;
        this.hasInterest = false;
        this.hasInterestClick = false;
    }

    public boolean canAutoPlay() {
        if (this.autoPlay == 1 && !TextUtils.isEmpty(this.playUrl)) {
            return true;
        }
        return false;
    }

    public String getTopicId() {
        if (TextUtils.isEmpty(this.topicId)) {
            return "0";
        }
        return this.topicId;
    }

    public int getTopicItemShowTpl() {
        if (!isTopicRoom()) {
            return 0;
        }
        return this.topicRoomList.get(0).showTpl;
    }

    public boolean isHorizontalScreen() {
        return "1".equals(this.videoScreen);
    }

    public boolean isStatusLiving() {
        if (this.liveStatus == 1) {
            return true;
        }
        return false;
    }

    public boolean isTopicRoom() {
        List<LiveRoomEntity> list = this.topicRoomList;
        if (list != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isYYShow() {
        return "6".equals(String.valueOf(this.templateId));
    }

    public LiveRoomEntity(Parcel parcel) {
        boolean z;
        this.needLogShow = true;
        this.fromReserve = false;
        this.hasInterest = false;
        this.hasInterestClick = false;
        this.rank = parcel.readInt();
        this.nid = parcel.readString();
        this.feedId = parcel.readString();
        this.roomId = parcel.readString();
        this.title = parcel.readString();
        this.cover = parcel.readString();
        this.liveStatus = parcel.readInt();
        this.audienceCount = parcel.readInt();
        this.cmd = parcel.readString();
        this.showTpl = parcel.readInt();
        this.templateId = parcel.readInt();
        this.playUrl = parcel.readString();
        this.autoPlay = parcel.readInt();
        this.videoScreen = parcel.readString();
        this.hostInfo = (LiveHostInfo) parcel.readParcelable(LiveHostInfo.class.getClassLoader());
        this.leftLabel = (LeftLableInfo) parcel.readParcelable(LeftLableInfo.class.getClassLoader());
        this.rightLabel = (RightLableInfo) parcel.readParcelable(RightLableInfo.class.getClassLoader());
        this.statInfo = (LiveStatInfo) parcel.readParcelable(LiveStatInfo.class.getClassLoader());
        if (parcel.readByte() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.needLogShow = z;
        this.grExt = parcel.readString();
        this.thirdLabel = (ThirdLabelInfo) parcel.readParcelable(ThirdLabelInfo.class.getClassLoader());
        this.reserveStartTime = parcel.readLong();
        this.fromReserve = parcel.readByte() == 1;
        this.topicRoomList = parcel.createTypedArrayList(CREATOR);
    }

    public String formatReserveStartTime() {
        long currentTimeMillis = this.reserveStartTime - (System.currentTimeMillis() / 1000);
        if (currentTimeMillis <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int ceil = (int) Math.ceil((currentTimeMillis * 1.0d) / 60.0d);
        int i = ceil / 60;
        int i2 = ceil - (i * 60);
        if (i >= 1) {
            sb.append(i);
            sb.append("小时");
            if (i2 > 0) {
                sb.append(i2);
                sb.append("分钟后");
            } else {
                sb.append("后开播");
            }
        } else {
            sb.append(i2);
            sb.append("分钟后开播");
        }
        return sb.toString();
    }

    public void parseSearchJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.rank = jSONObject.optInt(MultiRatePlayUrlHelper.RANK);
        this.nid = jSONObject.optString("nid");
        this.feedId = jSONObject.optString("feed_id");
        this.title = jSONObject.optString("title");
        this.roomId = jSONObject.optString("room_id");
        this.audienceCount = jSONObject.optInt("audience_count");
        this.liveStatus = jSONObject.optInt(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS);
        this.cover = jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
        this.cmd = jSONObject.optString("cmd");
        this.showTpl = jSONObject.optInt("show_tpl");
        JSONObject optJSONObject = jSONObject.optJSONObject("host");
        if (optJSONObject != null) {
            LiveHostInfo liveHostInfo = new LiveHostInfo();
            this.hostInfo = liveHostInfo;
            liveHostInfo.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("left_label");
        if (optJSONObject2 != null) {
            LeftLableInfo leftLableInfo = new LeftLableInfo();
            this.leftLabel = leftLableInfo;
            leftLableInfo.parserJson(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("right_label");
        if (optJSONObject3 != null) {
            RightLableInfo rightLableInfo = new RightLableInfo();
            this.rightLabel = rightLableInfo;
            rightLableInfo.parserJson(optJSONObject3);
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("third_label");
        if (optJSONObject4 != null) {
            ThirdLabelInfo thirdLabelInfo = new ThirdLabelInfo();
            this.thirdLabel = thirdLabelInfo;
            thirdLabelInfo.parserJson(optJSONObject4);
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("stat");
        if (optJSONObject5 != null) {
            LiveStatInfo liveStatInfo = new LiveStatInfo();
            this.statInfo = liveStatInfo;
            liveStatInfo.parserJson(optJSONObject5);
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("gr_ext");
        if (optJSONObject6 != null) {
            this.grExt = optJSONObject6.toString();
        } else {
            this.grExt = "";
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.rank = jSONObject.optInt(MultiRatePlayUrlHelper.RANK);
        this.nid = jSONObject.optString("nid");
        this.feedId = jSONObject.optString("feed_id");
        this.roomId = jSONObject.optString("room_id");
        this.title = jSONObject.optString("title");
        this.cover = jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
        this.liveStatus = jSONObject.optInt(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS);
        this.audienceCount = jSONObject.optInt("audience_count");
        this.cmd = jSONObject.optString("cmd");
        this.showTpl = jSONObject.optInt("show_tpl");
        this.templateId = jSONObject.optInt("template_id");
        this.playUrl = jSONObject.optString("play_url");
        this.autoPlay = jSONObject.optInt("auto_play");
        this.videoScreen = jSONObject.optString("screen");
        JSONObject optJSONObject = jSONObject.optJSONObject("host");
        if (optJSONObject != null) {
            LiveHostInfo liveHostInfo = new LiveHostInfo();
            this.hostInfo = liveHostInfo;
            liveHostInfo.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("left_label");
        if (optJSONObject2 != null) {
            LeftLableInfo leftLableInfo = new LeftLableInfo();
            this.leftLabel = leftLableInfo;
            leftLableInfo.parserJson(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("right_label");
        if (optJSONObject3 != null) {
            RightLableInfo rightLableInfo = new RightLableInfo();
            this.rightLabel = rightLableInfo;
            rightLableInfo.parserJson(optJSONObject3);
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("third_label");
        if (optJSONObject4 != null) {
            ThirdLabelInfo thirdLabelInfo = new ThirdLabelInfo();
            this.thirdLabel = thirdLabelInfo;
            thirdLabelInfo.parserJson(optJSONObject4);
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("stat");
        if (optJSONObject5 != null) {
            LiveStatInfo liveStatInfo = new LiveStatInfo();
            this.statInfo = liveStatInfo;
            liveStatInfo.parserJson(optJSONObject5);
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("gr_ext");
        if (optJSONObject6 != null) {
            this.grExt = optJSONObject6.toString();
        } else {
            this.grExt = "";
        }
        this.reserveStartTime = jSONObject.optLong("start_time_set");
        this.liveTag = jSONObject.optString("live_tag");
        this.feedTag = jSONObject.optString("feed_tag");
        if (optJSONObject6 != null && optJSONObject6.has("session_id")) {
            this.sessionId = optJSONObject6.optString("session_id");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("banners");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.bannerList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject7 = optJSONArray.optJSONObject(i);
                if (optJSONObject7 != null) {
                    LiveBannerEntity liveBannerEntity = new LiveBannerEntity();
                    liveBannerEntity.parserJson(optJSONObject7);
                    if (liveBannerEntity.isValid()) {
                        liveBannerEntity.position = this.bannerList.size();
                        this.bannerList.add(liveBannerEntity);
                    }
                }
            }
        }
        this.topicId = jSONObject.optString("topic_id");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("topic");
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            this.topicRoomList = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                JSONObject optJSONObject8 = optJSONArray2.optJSONObject(i2);
                if (optJSONObject8 != null) {
                    LiveRoomEntity liveRoomEntity = new LiveRoomEntity();
                    liveRoomEntity.parserJson(optJSONObject8);
                    if (TextUtils.isEmpty(liveRoomEntity.topicId)) {
                        liveRoomEntity.topicId = this.topicId;
                    }
                    this.topicRoomList.add(liveRoomEntity);
                }
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.rank);
        parcel.writeString(this.nid);
        parcel.writeString(this.feedId);
        parcel.writeString(this.roomId);
        parcel.writeString(this.title);
        parcel.writeString(this.cover);
        parcel.writeInt(this.liveStatus);
        parcel.writeInt(this.audienceCount);
        parcel.writeString(this.cmd);
        parcel.writeInt(this.showTpl);
        parcel.writeInt(this.templateId);
        parcel.writeString(this.playUrl);
        parcel.writeInt(this.autoPlay);
        parcel.writeString(this.videoScreen);
        parcel.writeParcelable(this.hostInfo, i);
        parcel.writeParcelable(this.leftLabel, i);
        parcel.writeParcelable(this.rightLabel, i);
        parcel.writeParcelable(this.statInfo, i);
        parcel.writeByte(this.needLogShow ? (byte) 1 : (byte) 0);
        parcel.writeString(this.grExt);
        parcel.writeParcelable(this.thirdLabel, i);
        parcel.writeLong(this.reserveStartTime);
        parcel.writeByte(this.fromReserve ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.topicRoomList);
    }
}
