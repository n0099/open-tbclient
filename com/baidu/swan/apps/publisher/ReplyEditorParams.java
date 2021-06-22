package com.baidu.swan.apps.publisher;

import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tbadk.core.util.StringHelper;
import d.a.m0.a.c;
import d.a.m0.a.h;
import d.a.m0.a.k;
import d.a.m0.a.w1.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ReplyEditorParams implements Parcelable {
    public static final String MODULE_EMOJI = "emoji";
    public static final String MODULE_PICTURE = "image";

    /* renamed from: e  reason: collision with root package name */
    public final String f11141e;

    /* renamed from: f  reason: collision with root package name */
    public final String f11142f;

    /* renamed from: g  reason: collision with root package name */
    public final int f11143g;

    /* renamed from: h  reason: collision with root package name */
    public final int f11144h;

    /* renamed from: i  reason: collision with root package name */
    public final String f11145i;
    public final String j;
    public List<String> showList;
    public static final List<String> DEFAULT_LIST = Collections.emptyList();
    public static final Parcelable.Creator<ReplyEditorParams> CREATOR = new a();

    /* loaded from: classes3.dex */
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
        public ReplyEditorParams[] newArray(int i2) {
            return new ReplyEditorParams[i2];
        }
    }

    public ReplyEditorParams(String str, String str2, String str3, String str4, int i2, int i3, List<String> list) {
        this.f11141e = str;
        this.f11145i = str2;
        this.j = str3;
        this.f11142f = str4;
        this.f11143g = i2;
        this.f11144h = i3;
        this.showList = list;
    }

    public static ReplyEditorParams a(JSONObject jSONObject) {
        int i2;
        int i3;
        if (jSONObject == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(DEFAULT_LIST);
        JSONArray optJSONArray = jSONObject.optJSONArray("moduleList");
        if (optJSONArray != null) {
            arrayList.clear();
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                String optString = optJSONArray.optString(i4);
                if (optString != null && !arrayList.contains(optString)) {
                    arrayList.add(optString);
                }
            }
        }
        String c2 = b.c(jSONObject, "sendText", "发表");
        if (c2.length() > 2) {
            c2 = c2.substring(0, 2);
        }
        String str = c2;
        try {
            i2 = SwanAppConfigData.s(b.c(jSONObject, "sendTextColor", "#FFFFFF"));
        } catch (Exception e2) {
            if (k.f46983a) {
                e2.printStackTrace();
            }
            i2 = -1;
        }
        Application b2 = d.a.m0.a.c1.a.b();
        String c3 = b.c(jSONObject, "sendBackgroundColor", "#3388FF");
        int color = b2.getResources().getColor(c.swanapp_publish_btn_enable_color);
        try {
            i3 = SwanAppConfigData.s(c3);
        } catch (Exception e3) {
            if (k.f46983a) {
                e3.printStackTrace();
            }
            i3 = color;
        }
        String d2 = b.d(jSONObject.optString("contentPlaceholder", b2.getResources().getString(h.swanapp_reply_editor_place_holder)), 20, StringHelper.STRING_MORE);
        String optString2 = jSONObject.optString("emojiPath");
        if (TextUtils.isEmpty(optString2)) {
            arrayList.remove(MODULE_EMOJI);
        }
        return new ReplyEditorParams(d2, optString2, jSONObject.optString("cb"), str, i2, i3, arrayList);
    }

    public boolean b() {
        List<String> list = this.showList;
        return list != null && list.contains(MODULE_EMOJI);
    }

    public boolean c() {
        List<String> list = this.showList;
        return list == null || list.isEmpty() || !(this.showList.contains(MODULE_EMOJI) || this.showList.contains("image"));
    }

    public boolean d() {
        List<String> list = this.showList;
        return list != null && list.contains("image");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f11141e);
        parcel.writeString(this.f11142f);
        parcel.writeInt(this.f11143g);
        parcel.writeInt(this.f11144h);
        parcel.writeString(this.f11145i);
        parcel.writeString(this.j);
        parcel.writeStringList(this.showList);
    }

    public ReplyEditorParams(Parcel parcel) {
        this.f11141e = parcel.readString();
        this.f11142f = parcel.readString();
        this.f11143g = parcel.readInt();
        this.f11144h = parcel.readInt();
        this.f11145i = parcel.readString();
        this.j = parcel.readString();
        this.showList = parcel.createStringArrayList();
    }
}
