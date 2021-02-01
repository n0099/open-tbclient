package com.baidu.minivideo.plugin.capture.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.tencent.connect.share.QzonePublish;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class VideoPlayData implements Parcelable, Jsonable, Serializable {
    public static final Parcelable.Creator<VideoPlayData> CREATOR = new Parcelable.Creator<VideoPlayData>() { // from class: com.baidu.minivideo.plugin.capture.bean.VideoPlayData.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoPlayData createFromParcel(Parcel parcel) {
            return new VideoPlayData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoPlayData[] newArray(int i) {
            return new VideoPlayData[i];
        }
    };
    public int end;
    public int height;
    public int insertIndex;
    public boolean isOriginal;
    public String mMaterialId;
    public VideoPlayData next;
    public int offset;
    public int rotation;
    public int start;
    public String videoPath;
    public int width;

    public VideoPlayData() {
    }

    public VideoPlayData(String str, int i, int i2, boolean z) {
        this.videoPath = str;
        this.start = i;
        this.end = i2;
        this.isOriginal = z;
    }

    protected VideoPlayData(Parcel parcel) {
        this.videoPath = parcel.readString();
        this.offset = parcel.readInt();
        this.start = parcel.readInt();
        this.end = parcel.readInt();
        this.next = (VideoPlayData) parcel.readParcelable(VideoPlayData.class.getClassLoader());
        this.isOriginal = parcel.readByte() != 0;
        this.insertIndex = parcel.readInt();
        this.rotation = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.mMaterialId = parcel.readString();
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, this.videoPath);
            jSONObject.put("offset", this.offset);
            jSONObject.put("start", this.start);
            jSONObject.put("end", this.end);
            jSONObject.put(UnitedSchemeConstants.UNITED_SCHEME_NEXT, this.next.toJson().toString());
            jSONObject.put("isOriginal", this.isOriginal);
            jSONObject.put("insertIndex", this.insertIndex);
            jSONObject.put("rotation", this.rotation);
            jSONObject.put("width", this.width);
            jSONObject.put("height", this.height);
            jSONObject.put("mMaterialId", this.mMaterialId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public boolean parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.videoPath = jSONObject.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            this.offset = jSONObject.optInt("offset");
            this.start = jSONObject.optInt("start");
            this.end = jSONObject.optInt("end");
            String optString = jSONObject.optString(UnitedSchemeConstants.UNITED_SCHEME_NEXT);
            if (!TextUtils.isEmpty(optString)) {
                VideoPlayData videoPlayData = new VideoPlayData();
                videoPlayData.parse(optString);
                this.next = videoPlayData;
            }
            this.isOriginal = jSONObject.optBoolean("isOriginal");
            this.insertIndex = jSONObject.optInt("insertIndex");
            this.rotation = jSONObject.optInt("rotation");
            this.width = jSONObject.optInt("width");
            this.height = jSONObject.optInt("height");
            this.mMaterialId = jSONObject.optString("mMaterialId");
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    public void setInsertIndex(int i) {
        this.insertIndex = i;
    }

    public void setMaterialId(String str) {
        this.mMaterialId = str;
    }

    public boolean equals(VideoPlayData videoPlayData) {
        if (videoPlayData == null) {
            return false;
        }
        if (TextUtils.isEmpty(this.videoPath)) {
            if (!TextUtils.isEmpty(videoPlayData.videoPath)) {
                return false;
            }
        } else if (!this.videoPath.equals(videoPlayData.videoPath)) {
            return false;
        }
        return this.start == videoPlayData.start && this.end == videoPlayData.end;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.videoPath);
        parcel.writeInt(this.offset);
        parcel.writeInt(this.start);
        parcel.writeInt(this.end);
        parcel.writeParcelable(this.next, i);
        parcel.writeByte(this.isOriginal ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.insertIndex);
        parcel.writeInt(this.rotation);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeString(this.mMaterialId);
    }
}
