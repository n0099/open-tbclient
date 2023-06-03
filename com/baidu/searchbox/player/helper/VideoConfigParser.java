package com.baidu.searchbox.player.helper;

import com.baidu.searchbox.player.model.VideoSceneEnvModel;
import com.baidu.searchbox.player.model.VideoSceneModel;
import com.baidu.searchbox.player.utils.BdVideoLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u001a$\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"TAG", "", "parseVideoAbTestConfig", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "abTestConfig", "parseVideoScenexConfig", "Lcom/baidu/searchbox/player/model/VideoSceneEnvModel;", "scenexConfig", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "VideoConfigParser")
/* loaded from: classes4.dex */
public final class VideoConfigParser {
    public static final String TAG = "VideoScenexConfigParser";

    /* JADX WARN: Removed duplicated region for block: B:12:0x0011 A[Catch: JSONException -> 0x000c, TryCatch #0 {JSONException -> 0x000c, blocks: (B:4:0x0003, B:12:0x0011, B:14:0x0021, B:15:0x002f), top: B:20:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ArrayList<String> parseVideoAbTestConfig(String str) {
        boolean z;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    z = false;
                    if (z) {
                        ArrayList<Integer> arrayList = new ArrayList<>();
                        JSONArray jSONArray = new JSONArray(str);
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            arrayList.add(Integer.valueOf(jSONArray.optInt(i)));
                        }
                        return AbTestSidHelper.Companion.get().getSidsFromTids(arrayList);
                    }
                    return null;
                }
            } catch (JSONException e) {
                BdVideoLog.e(TAG, e.getMessage());
                return null;
            }
        }
        z = true;
        if (z) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0014 A[Catch: JSONException -> 0x000f, TryCatch #0 {JSONException -> 0x000f, blocks: (B:4:0x0006, B:12:0x0014, B:14:0x0028), top: B:20:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ArrayList<VideoSceneEnvModel> parseVideoScenexConfig(String str) {
        boolean z;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    z = false;
                    if (z) {
                        JSONArray jSONArray = new JSONArray(str);
                        ArrayList<VideoSceneEnvModel> arrayList = new ArrayList<>(jSONArray.length());
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            String optString = jSONObject.optString("from");
                            String optString2 = jSONObject.optString("page");
                            String optString3 = jSONObject.optString("source");
                            String scenex = jSONObject.optString(PlayerUrlParamsManager.SCENEX);
                            VideoSceneModel videoSceneModel = new VideoSceneModel(optString, optString2, optString3, null, 8, null);
                            Intrinsics.checkNotNullExpressionValue(scenex, "scenex");
                            arrayList.add(new VideoSceneEnvModel(videoSceneModel, scenex));
                        }
                        return arrayList;
                    }
                    return null;
                }
            } catch (JSONException e) {
                BdVideoLog.e(TAG, e.getMessage());
                return null;
            }
        }
        z = true;
        if (z) {
        }
    }
}
