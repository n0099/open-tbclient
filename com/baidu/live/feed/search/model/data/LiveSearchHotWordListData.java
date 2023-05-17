package com.baidu.live.feed.search.model.data;

import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000B\u0019\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001¢\u0006\u0004\b\u001a\u0010\u0019J\u0018\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0006\u001a\u00020\u00002\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R*\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/baidu/live/feed/search/model/data/LiveSearchHotWordListData;", "", "", "component1", "()Ljava/util/List;", "hotWordList", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(Ljava/util/List;)Lcom/baidu/live/feed/search/model/data/LiveSearchHotWordListData;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "data", "", "parseJson", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getHotWordList", "setHotWordList", "(Ljava/util/List;)V", "<init>", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class LiveSearchHotWordListData {
    public List<String> hotWordList;

    public LiveSearchHotWordListData() {
        this(null, 1, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.live.feed.search.model.data.LiveSearchHotWordListData */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveSearchHotWordListData copy$default(LiveSearchHotWordListData liveSearchHotWordListData, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = liveSearchHotWordListData.hotWordList;
        }
        return liveSearchHotWordListData.copy(list);
    }

    public final List<String> component1() {
        return this.hotWordList;
    }

    public final LiveSearchHotWordListData copy(List<String> list) {
        return new LiveSearchHotWordListData(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof LiveSearchHotWordListData) && Intrinsics.areEqual(this.hotWordList, ((LiveSearchHotWordListData) obj).hotWordList);
        }
        return true;
    }

    public int hashCode() {
        List<String> list = this.hotWordList;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "LiveSearchHotWordListData(hotWordList=" + this.hotWordList + SmallTailInfo.EMOTION_SUFFIX;
    }

    public LiveSearchHotWordListData(List<String> list) {
        this.hotWordList = list;
    }

    public final void setHotWordList(List<String> list) {
        this.hotWordList = list;
    }

    public /* synthetic */ LiveSearchHotWordListData(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public final List<String> getHotWordList() {
        return this.hotWordList;
    }

    public final void parseJson(String str) {
        JSONArray optJSONArray;
        if (str != null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("hot_word")) != null) {
                    if (this.hotWordList == null) {
                        this.hotWordList = new ArrayList();
                    }
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        List<String> list = this.hotWordList;
                        if (list != null) {
                            String optString = optJSONArray.optString(i);
                            Intrinsics.checkExpressionValueIsNotNull(optString, "this.optString(i)");
                            list.add(optString);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
