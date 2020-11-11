package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class TempletMsg extends NormalMsg {
    public static final Parcelable.Creator<TempletMsg> CREATOR = new Parcelable.Creator<TempletMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.TempletMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TempletMsg createFromParcel(Parcel parcel) {
            return new TempletMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TempletMsg[] newArray(int i) {
            return new TempletMsg[i];
        }
    };
    public static final int IMAGE = 2;
    public static final int LINK = 1;
    public static final int NO_FOOT = 0;
    public static final int VIDEO = 3;
    protected Commodity[] mCommodity;
    private String mDetailurl;
    private String mFirstColor;
    private String mFirstName;
    private Image mImage;
    private String mImageDetail;
    private String mKeywords;
    private ArrayList<Link> mLinks;
    private int mMode;
    private String mRemarkColor;
    private String mRemarkName;
    private String mTitle;
    private Video mVideo;

    public TempletMsg() {
        this.mMode = 0;
        this.mLinks = new ArrayList<>();
        setMsgType(12);
    }

    public TempletMsg(Parcel parcel) {
        super(parcel);
        this.mMode = 0;
        this.mLinks = new ArrayList<>();
        this.mTitle = parcel.readString();
        this.mDetailurl = parcel.readString();
        this.mFirstName = parcel.readString();
        this.mFirstColor = parcel.readString();
        this.mRemarkName = parcel.readString();
        this.mRemarkColor = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.mCommodity = new Commodity[readInt];
            parcel.readTypedArray(this.mCommodity, Commodity.CREATOR);
        }
        this.mMode = parcel.readInt();
        this.mLinks = parcel.createTypedArrayList(Link.CREATOR);
        this.mImage = (Image) parcel.readParcelable(Image.class.getClassLoader());
        this.mVideo = (Video) parcel.readParcelable(Video.class.getClassLoader());
    }

    public int getMode() {
        return this.mMode;
    }

    public ArrayList<Link> getLinks() {
        return this.mLinks;
    }

    public Image getImage() {
        return this.mImage;
    }

    public Video getVideo() {
        return this.mVideo;
    }

    public String getDetail() {
        return this.mDetailurl;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getFirstName() {
        return this.mFirstName;
    }

    public String getFirstColor() {
        return this.mFirstColor;
    }

    public String getRemarkName() {
        return this.mRemarkName;
    }

    public String getRemarkColor() {
        return this.mRemarkColor;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        int i2 = 0;
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mDetailurl);
        parcel.writeString(this.mFirstName);
        parcel.writeString(this.mFirstColor);
        parcel.writeString(this.mRemarkName);
        parcel.writeString(this.mRemarkColor);
        if (this.mCommodity != null) {
            i2 = this.mCommodity.length;
        }
        parcel.writeInt(i2);
        if (i2 > 0) {
            parcel.writeTypedArray(this.mCommodity, i);
        }
        parcel.writeInt(this.mMode);
        parcel.writeTypedList(this.mLinks);
        parcel.writeParcelable(this.mImage, i);
        parcel.writeParcelable(this.mVideo, i);
    }

    public Commodity[] getCommodity() {
        return this.mCommodity;
    }

    public String getKeywords() {
        return this.mKeywords;
    }

    public String getImageDetail() {
        return this.mImageDetail;
    }

    public boolean setJsonContent(String str, String str2, String str3, String str4, String str5, Commodity[] commodityArr, String str6) {
        if (TextUtils.isEmpty(str) || str2 == null || str4 == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject.put("title", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("value", str2);
            jSONObject2.put("color", str3);
            jSONObject.put(Config.TRACE_VISIT_FIRST, jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("value", str4);
            jSONObject3.put("color", str5);
            jSONObject.put("remark", jSONObject3);
            if (commodityArr != null && commodityArr.length > 0) {
                for (Commodity commodity : commodityArr) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("name", commodity.getName());
                    jSONObject4.put("color", commodity.getColor());
                    jSONObject4.put("value", commodity.getValue());
                    jSONArray.put(jSONObject4);
                }
            }
            jSONObject.put("keywords", jSONArray);
            jSONObject.put("detail_url", str6);
            return setMsgContent(jSONObject.toString());
        } catch (Exception e) {
            LogUtils.e("TempletMsg", "content error!");
            return false;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        boolean z;
        JSONObject jSONObject;
        JSONArray jSONArray;
        int length;
        try {
            jSONObject = new JSONObject(getJsonContent());
            this.mTitle = jSONObject.optString("title");
        } catch (JSONException e) {
            LogUtils.e("TempletMsg", "parseJsonString JSONException", e);
            z = false;
        }
        if (TextUtils.isEmpty(this.mTitle)) {
            return false;
        }
        this.mDetailurl = jSONObject.optString("detail_url");
        JSONObject optJSONObject = jSONObject.optJSONObject(Config.TRACE_VISIT_FIRST);
        if (optJSONObject != null) {
            this.mFirstName = optJSONObject.optString("value");
            this.mFirstColor = optJSONObject.optString("color");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("remark");
        if (optJSONObject2 != null) {
            this.mRemarkName = optJSONObject2.optString("value");
            this.mRemarkColor = optJSONObject2.optString("color");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("keywords");
        if (optJSONArray != null) {
            this.mKeywords = optJSONArray.toString();
            int length2 = optJSONArray.length();
            if (length2 > 0) {
                this.mCommodity = new Commodity[length2];
            }
            LogUtils.d("TempletMsg", "size is " + length2);
            for (int i = 0; i < length2; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                Commodity commodity = new Commodity();
                commodity.setName(jSONObject2.getString("name"));
                commodity.setValue(jSONObject2.optString("value", ""));
                commodity.setColor(jSONObject2.optString("color", "#000000"));
                this.mCommodity[i] = commodity;
            }
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("image");
        if (optJSONObject3 != null) {
            this.mImageDetail = optJSONObject3.toString();
        }
        if (jSONObject.has("footer") && (length = (jSONArray = jSONObject.getJSONArray("footer")).length()) > 0) {
            String string = jSONArray.getJSONObject(0).getString("type");
            char c = 65535;
            switch (string.hashCode()) {
                case 3321850:
                    if (string.equals("link")) {
                        c = 0;
                        break;
                    }
                    break;
                case 100313435:
                    if (string.equals("image")) {
                        c = 1;
                        break;
                    }
                    break;
                case 112202875:
                    if (string.equals("video")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.mMode = 1;
                    this.mLinks.clear();
                    int i2 = length <= 3 ? length : 3;
                    for (int i3 = 0; i3 < i2; i3++) {
                        Link link = new Link();
                        link.content = jSONArray.getJSONObject(i3).getString("content");
                        link.title = jSONArray.getJSONObject(i3).optString("detail_title");
                        link.url = jSONArray.getJSONObject(i3).getString("detail_url");
                        this.mLinks.add(link);
                    }
                    break;
                case 1:
                    this.mMode = 2;
                    this.mImage = new Image();
                    this.mImage.image = jSONArray.getJSONObject(0).getString("image");
                    this.mImage.url = jSONArray.getJSONObject(0).getString("url");
                    this.mImage.title = jSONArray.getJSONObject(0).getString("title");
                    this.mImage.description = jSONArray.getJSONObject(0).getString("description");
                    break;
                default:
                    this.mMode = 3;
                    this.mVideo = new Video();
                    this.mVideo.cover = jSONArray.getJSONObject(0).getString("cover");
                    this.mVideo.url = jSONArray.getJSONObject(0).getString("url");
                    this.mVideo.title = jSONArray.getJSONObject(0).getString("title");
                    this.mVideo.description = jSONArray.getJSONObject(0).getString("description");
                    this.mVideo.duration = jSONArray.getJSONObject(0).getString("duration");
                    break;
            }
        }
        z = true;
        return z;
    }

    /* loaded from: classes18.dex */
    public static class Commodity implements Parcelable, NoProGuard {
        public static final Parcelable.Creator<Commodity> CREATOR = new Parcelable.Creator<Commodity>() { // from class: com.baidu.android.imsdk.chatmessage.messages.TempletMsg.Commodity.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Commodity createFromParcel(Parcel parcel) {
                return new Commodity(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Commodity[] newArray(int i) {
                return new Commodity[i];
            }
        };
        private String mColor;
        private String mName;
        private String mValue;

        public Commodity() {
        }

        public Commodity(Parcel parcel) {
            this.mName = parcel.readString();
            this.mValue = parcel.readString();
            this.mColor = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mName);
            parcel.writeString(this.mValue);
            parcel.writeString(this.mColor);
        }

        public String getColor() {
            return this.mColor;
        }

        public void setColor(String str) {
            this.mColor = str;
        }

        public String getName() {
            return this.mName;
        }

        public void setName(String str) {
            this.mName = str;
        }

        public String getValue() {
            return this.mValue;
        }

        public void setValue(String str) {
            this.mValue = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return !TextUtils.isEmpty(this.mTitle) ? this.mTitle : "";
    }

    /* loaded from: classes18.dex */
    public static class Link implements Parcelable {
        public static final Parcelable.Creator<Link> CREATOR = new Parcelable.Creator<Link>() { // from class: com.baidu.android.imsdk.chatmessage.messages.TempletMsg.Link.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Link createFromParcel(Parcel parcel) {
                return new Link(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Link[] newArray(int i) {
                return new Link[i];
            }
        };
        String content;
        String title;
        String url;

        public String getContent() {
            return this.content;
        }

        public String getTitle() {
            return this.title;
        }

        public String getUrl() {
            return this.url;
        }

        Link() {
        }

        protected Link(Parcel parcel) {
            this.content = parcel.readString();
            this.title = parcel.readString();
            this.url = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.content);
            parcel.writeString(this.title);
            parcel.writeString(this.url);
        }
    }

    /* loaded from: classes18.dex */
    public static class Image implements Parcelable {
        public static final Parcelable.Creator<Image> CREATOR = new Parcelable.Creator<Image>() { // from class: com.baidu.android.imsdk.chatmessage.messages.TempletMsg.Image.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Image createFromParcel(Parcel parcel) {
                return new Image(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Image[] newArray(int i) {
                return new Image[i];
            }
        };
        private String description;
        private String image;
        private String title;
        private String url;

        public String getImage() {
            return this.image;
        }

        public String getUrl() {
            return this.url;
        }

        public String getTitle() {
            return this.title;
        }

        public String getDescription() {
            return this.description;
        }

        Image() {
        }

        protected Image(Parcel parcel) {
            this.image = parcel.readString();
            this.url = parcel.readString();
            this.title = parcel.readString();
            this.description = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.image);
            parcel.writeString(this.url);
            parcel.writeString(this.title);
            parcel.writeString(this.description);
        }
    }

    /* loaded from: classes18.dex */
    public static class Video implements Parcelable {
        public static final Parcelable.Creator<Video> CREATOR = new Parcelable.Creator<Video>() { // from class: com.baidu.android.imsdk.chatmessage.messages.TempletMsg.Video.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Video createFromParcel(Parcel parcel) {
                return new Video(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Video[] newArray(int i) {
                return new Video[i];
            }
        };
        private String cover;
        private String description;
        private String duration;
        private String title;
        private String url;

        public String getCover() {
            return this.cover;
        }

        public String getUrl() {
            return this.url;
        }

        public String getTitle() {
            return this.title;
        }

        public String getDescription() {
            return this.description;
        }

        public String getDuration() {
            return this.duration;
        }

        Video() {
        }

        protected Video(Parcel parcel) {
            this.cover = parcel.readString();
            this.url = parcel.readString();
            this.title = parcel.readString();
            this.description = parcel.readString();
            this.duration = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.cover);
            parcel.writeString(this.url);
            parcel.writeString(this.title);
            parcel.writeString(this.description);
            parcel.writeString(this.duration);
        }
    }
}
