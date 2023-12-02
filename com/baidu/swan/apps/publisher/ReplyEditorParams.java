package com.baidu.swan.apps.publisher;

import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tieba.R;
import com.baidu.tieba.n33;
import com.baidu.tieba.rp2;
import com.baidu.tieba.vm1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ReplyEditorParams implements Parcelable {
    public static final String MODULE_EMOJI = "emoji";
    public static final String MODULE_PICTURE = "image";
    public final String callback;
    public final String contentHint;
    public final String emojiPath;
    public final String sendText;
    public final int sendTextBgColor;
    public final int sendTextColor;
    public List<String> showList;
    public static final List<String> DEFAULT_LIST = Collections.emptyList();
    public static final Parcelable.Creator<ReplyEditorParams> CREATOR = new a();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean supportEmoji() {
        List<String> list = this.showList;
        if (list != null && list.contains("emoji")) {
            return true;
        }
        return false;
    }

    public boolean supportNoModule() {
        List<String> list = this.showList;
        if (list != null && !list.isEmpty() && (this.showList.contains("emoji") || this.showList.contains("image"))) {
            return false;
        }
        return true;
    }

    public boolean supportPicture() {
        List<String> list = this.showList;
        if (list != null && list.contains("image")) {
            return true;
        }
        return false;
    }

    /* loaded from: classes4.dex */
    public static class a implements Parcelable.Creator<ReplyEditorParams> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ReplyEditorParams createFromParcel(Parcel parcel) {
            return new ReplyEditorParams(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ReplyEditorParams[] newArray(int i) {
            return new ReplyEditorParams[i];
        }
    }

    public ReplyEditorParams(Parcel parcel) {
        this.contentHint = parcel.readString();
        this.sendText = parcel.readString();
        this.sendTextColor = parcel.readInt();
        this.sendTextBgColor = parcel.readInt();
        this.emojiPath = parcel.readString();
        this.callback = parcel.readString();
        this.showList = parcel.createStringArrayList();
    }

    public ReplyEditorParams(String str, String str2, String str3, String str4, int i, int i2, List<String> list) {
        this.contentHint = str;
        this.emojiPath = str2;
        this.callback = str3;
        this.sendText = str4;
        this.sendTextColor = i;
        this.sendTextBgColor = i2;
        this.showList = list;
    }

    public static ReplyEditorParams fromJson(JSONObject jSONObject) {
        int i;
        int i2;
        if (jSONObject == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(DEFAULT_LIST);
        JSONArray optJSONArray = jSONObject.optJSONArray("moduleList");
        if (optJSONArray != null) {
            arrayList.clear();
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                String optString = optJSONArray.optString(i3);
                if (optString != null && !arrayList.contains(optString)) {
                    arrayList.add(optString);
                }
            }
        }
        String c = n33.c(jSONObject, "sendText", "发表");
        if (c.length() > 2) {
            c = c.substring(0, 2);
        }
        String str = c;
        try {
            i = SwanAppConfigData.t(n33.c(jSONObject, "sendTextColor", "#FFFFFF"));
        } catch (Exception e) {
            if (vm1.a) {
                e.printStackTrace();
            }
            i = -1;
        }
        Application c2 = rp2.c();
        String c3 = n33.c(jSONObject, "sendBackgroundColor", "#3388FF");
        int color = c2.getResources().getColor(R.color.obfuscated_res_0x7f060b18);
        try {
            i2 = SwanAppConfigData.t(c3);
        } catch (Exception e2) {
            if (vm1.a) {
                e2.printStackTrace();
            }
            i2 = color;
        }
        String d = n33.d(jSONObject.optString("contentPlaceholder", c2.getResources().getString(R.string.obfuscated_res_0x7f0f15b5)), 20, "...");
        String optString2 = jSONObject.optString("emojiPath");
        if (TextUtils.isEmpty(optString2)) {
            arrayList.remove("emoji");
        }
        return new ReplyEditorParams(d, optString2, jSONObject.optString("cb"), str, i, i2, arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.contentHint);
        parcel.writeString(this.sendText);
        parcel.writeInt(this.sendTextColor);
        parcel.writeInt(this.sendTextBgColor);
        parcel.writeString(this.emojiPath);
        parcel.writeString(this.callback);
        parcel.writeStringList(this.showList);
    }
}
