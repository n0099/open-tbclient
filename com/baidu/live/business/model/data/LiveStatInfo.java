package com.baidu.live.business.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveStatInfo implements Parcelable {
    public static final Parcelable.Creator<LiveStatInfo> CREATOR = new Parcelable.Creator<LiveStatInfo>() { // from class: com.baidu.live.business.model.data.LiveStatInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveStatInfo createFromParcel(Parcel parcel) {
            return new LiveStatInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveStatInfo[] newArray(int i) {
            return new LiveStatInfo[i];
        }
    };
    public boolean isYY;
    public String sid;
    public String ssid;
    public int templateId;
    public String tpl;
    public String yyuid;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LiveStatInfo() {
    }

    public LiveStatInfo(Parcel parcel) {
        boolean z;
        if (parcel.readByte() == 3) {
            z = true;
        } else {
            z = false;
        }
        this.isYY = z;
        this.yyuid = parcel.readString();
        this.sid = parcel.readString();
        this.ssid = parcel.readString();
        this.tpl = parcel.readString();
        this.templateId = parcel.readInt();
    }

    public void parserJson(JSONObject jSONObject) {
        boolean z;
        if (jSONObject == null) {
            return;
        }
        if (jSONObject.optInt("live_type") == 3) {
            z = true;
        } else {
            z = false;
        }
        this.isYY = z;
        this.yyuid = jSONObject.optString(TiebaStatic.YYParams.YYUID, "");
        this.sid = jSONObject.optString("sid", "");
        this.ssid = jSONObject.optString(YyLiveRoomConfig.KEY_SSID, "");
        this.tpl = jSONObject.optString("tpl", "");
        this.templateId = jSONObject.optInt("template_id", 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        if (this.isYY) {
            i2 = 3;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(this.yyuid);
        parcel.writeString(this.sid);
        parcel.writeString(this.ssid);
        parcel.writeString(this.tpl);
        parcel.writeInt(this.templateId);
    }
}
