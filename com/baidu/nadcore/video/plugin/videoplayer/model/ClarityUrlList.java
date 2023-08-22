package com.baidu.nadcore.video.plugin.videoplayer.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.live.interfaces.defaultimpl.utils.MultiRatePlayUrlHelper;
import com.baidu.searchbox.player.model.ClarityUrlList;
import com.baidu.tieba.R;
import com.baidu.tieba.i01;
import com.baidu.tieba.pu0;
import com.baidu.tieba.sj0;
import com.baidu.tieba.tu0;
import com.baidu.tieba.uu0;
import com.baidu.tieba.v11;
import com.tencent.connect.share.QzonePublish;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ClarityUrlList extends ArrayList<c> {
    public String mClarityInfoStr;
    public c mCurrentClarityUrl;
    public int mDefaultClarity;
    public int mMultiRateSwitchRank;
    public int mSelectType;

    /* loaded from: classes3.dex */
    public class b extends c {
    }

    /* loaded from: classes3.dex */
    public class a implements Comparator<c> {
        public a() {
        }

        public final int a(String str) {
            char c;
            int hashCode = str.hashCode();
            if (hashCode != 3324) {
                if (hashCode != 46737913) {
                    if (hashCode != 3664) {
                        if (hashCode == 3665 && str.equals("sd")) {
                            c = 0;
                        }
                        c = 65535;
                    } else {
                        if (str.equals("sc")) {
                            c = 2;
                        }
                        c = 65535;
                    }
                } else {
                    if (str.equals(ClarityUrlList.ClarityUrl.KEY_1080P)) {
                        c = 3;
                    }
                    c = 65535;
                }
            } else {
                if (str.equals(ClarityUrlList.ClarityUrl.KEY_HD)) {
                    c = 1;
                }
                c = 65535;
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
            if (c != 3) {
                return Integer.MAX_VALUE;
            }
            return 4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(c cVar, c cVar2) {
            return a(cVar.c()) - a(cVar2.c());
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Comparable<c> {
        public String a;
        public int b;
        public int c;
        public String d;
        public String e;
        public float f;
        public HashMap<String, String> g;
        public float h;
        public int i;
        public int j;
        public tu0 k;

        static {
            sj0.b().getString(R.string.nad_videoplayer_clarity_text_sd);
            sj0.b().getString(R.string.nad_videoplayer_clarity_text_hd);
            sj0.b().getString(R.string.nad_videoplayer_clarity_text_sc);
            sj0.b().getString(R.string.nad_videoplayer_clarity_text_1080p);
            sj0.b().getString(R.string.nad_videoplayer_clarity_text_auto);
        }

        public c() {
            this.b = -1;
            this.c = -1;
            this.f = -1.0f;
        }

        public tu0 b() {
            return this.k;
        }

        public String c() {
            return this.a;
        }

        public int d() {
            return this.j;
        }

        public int e() {
            return this.b;
        }

        public String f() {
            return this.d;
        }

        public String g() {
            return this.e;
        }

        public int h() {
            return this.i;
        }

        public float i() {
            return this.h;
        }

        public HashMap<String, String> j() {
            return this.g;
        }

        public float k() {
            return this.f;
        }

        public String toString() {
            return "ClarityUrl{mKey='" + this.a + "', mTitle='" + this.d + "'}";
        }

        public c(JSONObject jSONObject, int i) {
            this.b = -1;
            this.c = -1;
            this.f = -1.0f;
            this.a = jSONObject.optString("key");
            int optInt = jSONObject.optInt(MultiRatePlayUrlHelper.RANK, i);
            this.b = optInt;
            this.c = (i - 1) - optInt;
            this.d = jSONObject.optString("title");
            this.e = jSONObject.optString("url");
            jSONObject.optInt("width");
            jSONObject.optInt("height");
            jSONObject.has("download_url");
            jSONObject.optString("download_url");
            jSONObject.optString("airPlay_url");
            this.f = (float) jSONObject.optDouble(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, -1.0d);
            this.h = (float) jSONObject.optDouble("video_clarity_score", -1.0d);
            String optString = jSONObject.optString("h265Url", "");
            if (!TextUtils.isEmpty(optString) && jSONObject.has("h265VideoSize")) {
                this.e = optString;
                this.f = (float) jSONObject.optDouble("h265VideoSize");
            }
            this.g = null;
            this.i = jSONObject.optInt("videoBps");
            this.j = jSONObject.optInt("vodMoovSize");
            this.k = uu0.b(jSONObject.optString("auth"));
            jSONObject.optLong("expire_date");
            jSONObject.optString("interact_url");
            jSONObject.optInt("prefetch_size");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(c cVar) {
            int i = this.c;
            int i2 = cVar.c;
            if (i == i2) {
                return 0;
            }
            if (i > i2) {
                return 1;
            }
            return -1;
        }
    }

    public ClarityUrlList() {
    }

    @Nullable
    public b getAutoClarity() {
        for (int i = 0; i < size(); i++) {
            c cVar = get(i);
            if (cVar instanceof b) {
                return (b) cVar;
            }
        }
        return null;
    }

    @Nullable
    public c getClarityByIndex() {
        int i = this.mDefaultClarity;
        if (i >= 0 && i < size()) {
            return get(this.mDefaultClarity);
        }
        return null;
    }

    public String getClarityInfoStr() {
        return this.mClarityInfoStr;
    }

    public c getCurrentClarityUrl() {
        return this.mCurrentClarityUrl;
    }

    @NonNull
    public String getCurrentKey() {
        c cVar = this.mCurrentClarityUrl;
        if (cVar != null) {
            String c2 = cVar.c();
            if (!TextUtils.isEmpty(c2)) {
                return c2;
            }
            return c2;
        }
        return "sd";
    }

    public int getCurrentRank() {
        for (int i = 0; i < size(); i++) {
            c cVar = get(i);
            if (cVar != null && cVar.compareTo(this.mCurrentClarityUrl) == 0) {
                return cVar.c;
            }
        }
        return this.mDefaultClarity;
    }

    public int getDefaultClarity() {
        return this.mDefaultClarity;
    }

    public String getDefaultTitle() {
        return get(this.mDefaultClarity).f();
    }

    public int getMultiRateSwitchRank() {
        return this.mMultiRateSwitchRank;
    }

    public int getSelectType() {
        return this.mSelectType;
    }

    public void updateCurrentClarityToLowest() {
        if (isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this);
        Collections.sort(arrayList, new a());
        setCurrentClarityUrl((c) arrayList.get(0));
        if (pu0.b()) {
            setMultiRateSwitchRank(((c) arrayList.get(0)).c);
        }
    }

    public ClarityUrlList(JSONArray jSONArray) {
        convert(jSONArray, false);
    }

    private void convert(@NonNull JSONArray jSONArray) {
        convert(jSONArray, false);
    }

    public c getClarityByOriginRank(int i) {
        for (int i2 = 0; i2 < size(); i2++) {
            c cVar = get(i2);
            if (cVar.e() == i) {
                return cVar;
            }
        }
        return null;
    }

    public void setCurrentClarityUrl(c cVar) {
        this.mCurrentClarityUrl = cVar;
    }

    public void setDefaultClarity(int i) {
        if (i >= 0 && i < size()) {
            this.mDefaultClarity = i;
        } else {
            this.mDefaultClarity = 0;
        }
    }

    public void setMultiRateSwitchRank(int i) {
        this.mMultiRateSwitchRank = i;
    }

    public ClarityUrlList(JSONArray jSONArray, boolean z) {
        if (jSONArray == null) {
            return;
        }
        this.mClarityInfoStr = jSONArray.toString();
        if (z) {
            convert(jSONArray, true);
        } else {
            convert(jSONArray);
        }
    }

    private void convert(@NonNull JSONArray jSONArray, boolean z) {
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                add(new c(optJSONObject, length));
            }
        }
        if (size() <= 0) {
            return;
        }
        Collections.sort(this);
        i01 b2 = v11.b(this, get(size() - 1).i());
        this.mSelectType = b2.b;
        int i2 = b2.a;
        this.mDefaultClarity = i2;
        c cVar = get(i2);
        this.mCurrentClarityUrl = cVar;
        this.mMultiRateSwitchRank = cVar.c;
    }

    public String getDefaultUrl() {
        int i;
        if (this.mDefaultClarity < size() && (i = this.mDefaultClarity) >= 0) {
            if (!"auto".equals(get(i).c())) {
                return get(this.mDefaultClarity).g();
            }
            return get(0).g();
        }
        return "";
    }
}
