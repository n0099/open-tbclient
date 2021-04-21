package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import d.b.j0.x.e0.m;
import d.b.j0.x.e0.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes3.dex */
public class RecommendTopicData {

    /* renamed from: a  reason: collision with root package name */
    public String f12892a;

    /* renamed from: b  reason: collision with root package name */
    public List<RecommendTopicListData> f12893b = new ArrayList();

    /* loaded from: classes3.dex */
    public static class RecommendTopicListData implements Serializable, Parcelable {
        public static final Parcelable.Creator<RecommendTopicListData> CREATOR = new a();
        public long discussNum;
        public int tag;
        public String topicDesc;
        public long topicId;
        public String topicName;
        public String topicPic;
        public int type;

        /* loaded from: classes3.dex */
        public static class a implements Parcelable.Creator<RecommendTopicListData> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public RecommendTopicListData createFromParcel(Parcel parcel) {
                return new RecommendTopicListData(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public RecommendTopicListData[] newArray(int i) {
                return new RecommendTopicListData[i];
            }
        }

        public RecommendTopicListData() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public m getConvertedCardData() {
            m mVar = new m();
            mVar.f64216c = this.tag;
            mVar.f64214a = this.topicId;
            mVar.f64215b = this.topicName;
            return mVar;
        }

        public long getDiscussNum() {
            return this.discussNum;
        }

        public int getTag() {
            return this.tag;
        }

        public String getTopicDesc() {
            return this.topicDesc;
        }

        public long getTopicId() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.topicName;
        }

        public String getTopicPic() {
            return this.topicPic;
        }

        public int getType() {
            return this.type;
        }

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.topicId = jSONObject.optLong("topic_id");
            this.topicName = jSONObject.optString(IntentConfig.TOPIC_NAME);
            this.type = jSONObject.optInt("type");
            this.discussNum = jSONObject.optLong("discuss_num");
            this.tag = jSONObject.optInt("tag");
            this.topicDesc = jSONObject.optString("topic_desc");
            this.topicPic = jSONObject.optString("topic_pic");
        }

        public void parserProtoBuf(RecomTopicList recomTopicList) {
            if (recomTopicList == null) {
                return;
            }
            this.topicId = recomTopicList.topic_id.longValue();
            this.topicName = recomTopicList.topic_name;
            this.type = recomTopicList.type.intValue();
            this.discussNum = recomTopicList.discuss_num.longValue();
            this.tag = recomTopicList.tag.intValue();
            this.topicDesc = recomTopicList.topic_desc;
            this.topicPic = recomTopicList.topic_pic;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.topicId);
            parcel.writeString(this.topicName);
            parcel.writeInt(this.type);
            parcel.writeLong(this.discussNum);
            parcel.writeInt(this.tag);
            parcel.writeString(this.topicDesc);
            parcel.writeString(this.topicPic);
        }

        public RecommendTopicListData(Parcel parcel) {
            this.topicId = parcel.readLong();
            this.topicName = parcel.readString();
            this.type = parcel.readInt();
            this.discussNum = parcel.readLong();
            this.tag = parcel.readInt();
            this.topicDesc = parcel.readString();
            this.topicPic = parcel.readString();
        }
    }

    public n a() {
        ArrayList arrayList;
        n nVar = new n();
        nVar.f64219g = b();
        if (this.f12893b != null) {
            arrayList = new ArrayList();
            for (RecommendTopicListData recommendTopicListData : this.f12893b) {
                if (recommendTopicListData != null) {
                    arrayList.add(recommendTopicListData.getConvertedCardData());
                }
            }
        } else {
            arrayList = null;
        }
        nVar.f64220h = arrayList;
        return nVar;
    }

    public String b() {
        if (StringUtils.isNull(this.f12892a)) {
            return TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title);
        }
        return this.f12892a;
    }

    public final boolean c(RecommendTopicListData recommendTopicListData) {
        return recommendTopicListData == null || StringUtils.isNull(recommendTopicListData.getTopicName()) || recommendTopicListData.getTopicId() <= 0;
    }

    public void d(RecomTopicInfo recomTopicInfo) {
        if (recomTopicInfo == null) {
            return;
        }
        this.f12892a = recomTopicInfo.recom_title;
        if (ListUtils.getCount(recomTopicInfo.topic_list) > 0) {
            for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                if (recomTopicList != null) {
                    RecommendTopicListData recommendTopicListData = new RecommendTopicListData();
                    recommendTopicListData.parserProtoBuf(recomTopicList);
                    if (!c(recommendTopicListData)) {
                        this.f12893b.add(recommendTopicListData);
                    }
                }
            }
        }
    }
}
