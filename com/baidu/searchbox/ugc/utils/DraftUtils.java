package com.baidu.searchbox.ugc.utils;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.draft.DraftData;
import com.baidu.searchbox.ugc.draft.DraftSPWrapper;
import com.baidu.searchbox.ugc.model.PublishType;
import com.baidu.searchbox.ugc.model.UGCTarget;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class DraftUtils {
    public static String generateSPKey(String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void saveDraft(String str, DraftData draftData) {
        DraftSPWrapper.getInstance().putString(str, new Gson().toJson(draftData));
    }

    public static DraftData getDraft(String str) {
        return (DraftData) new Gson().fromJson(DraftSPWrapper.getInstance().getString(str, ""), (Class<Object>) DraftData.class);
    }

    public static void deleteDraft(String str) {
        DraftData draft;
        if (!TextUtils.isEmpty(str) && (draft = getDraft(str)) != null) {
            if (draft.images != null && draft.images.size() > 0) {
                FileUtils.deleteDraftFile(draft.images);
            }
            if (!TextUtils.isEmpty(draft.video)) {
                if (!TextUtils.isEmpty(draft.videoCover)) {
                    FileUtils.deleteDraftFile(draft.videoCover);
                }
                FileUtils.deleteDraftFile(draft.video);
            }
            DraftSPWrapper.getInstance().remove(str);
        }
    }

    public static boolean checkDraftExpired(String str, long j) {
        if (((int) ((System.currentTimeMillis() - j) / 86400000)) > 5) {
            deleteDraft(str);
            return false;
        }
        return true;
    }

    public static boolean isShowDraft(String str, String str2) {
        DraftData draft = getDraft(str);
        if (draft == null) {
            return false;
        }
        char c = 65535;
        switch (str2.hashCode()) {
            case 48:
                if (str2.equals("0")) {
                    c = 1;
                    break;
                }
                break;
            case 49:
                if (str2.equals("1")) {
                    c = 5;
                    break;
                }
                break;
            case 51:
                if (str2.equals("3")) {
                    c = 6;
                    break;
                }
                break;
            case 52:
                if (str2.equals("4")) {
                    c = 4;
                    break;
                }
                break;
            case 53:
                if (str2.equals("5")) {
                    c = 2;
                    break;
                }
                break;
            case 56:
                if (str2.equals("8")) {
                    c = 0;
                    break;
                }
                break;
            case 1568:
                if (str2.equals("11")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
                return !TextUtils.isEmpty(draft.content) && checkDraftExpired(str, draft.timestamp);
            case 3:
            case 4:
                return (!TextUtils.isEmpty(draft.content) || (draft.images != null && draft.images.size() > 0)) && checkDraftExpired(str, draft.timestamp);
            case 5:
            case 6:
                return !(TextUtils.isEmpty(draft.content) && TextUtils.isEmpty(draft.video)) && checkDraftExpired(str, draft.timestamp);
            default:
                return false;
        }
    }

    public static String getDraftKey(UgcSchemeModel ugcSchemeModel) {
        JSONObject jSONObject;
        String str = ugcSchemeModel.publishType;
        char c = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c = 1;
                    break;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    c = 3;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c = 4;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c = 2;
                    break;
                }
                break;
            case 53:
                if (str.equals("5")) {
                    c = 5;
                    break;
                }
                break;
            case 56:
                if (str.equals("8")) {
                    c = 0;
                    break;
                }
                break;
            case 57:
                if (str.equals(PublishType.TYPE_VIDEO_SHARE)) {
                    c = 6;
                    break;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    c = 7;
                    break;
                }
                break;
            case 1568:
                if (str.equals("11")) {
                    c = '\b';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                UGCTarget uGCTarget = (UGCTarget) new Gson().fromJson(ugcSchemeModel.target, (Class<Object>) UGCTarget.class);
                if (uGCTarget != null && uGCTarget.mUgcPKInfo != null) {
                    String str2 = uGCTarget.mUgcPKInfo.pkID;
                    if (!TextUtils.isEmpty(str2)) {
                        return generateSPKey(UgcLoginUtils.getUK(), ugcSchemeModel.publishType, str2);
                    }
                }
                if (TextUtils.isEmpty(ugcSchemeModel.topic)) {
                    return generateSPKey(UgcLoginUtils.getUK(), ugcSchemeModel.publishType);
                }
                try {
                    jSONObject = new JSONObject(ugcSchemeModel.topic);
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONObject = null;
                }
                String optString = jSONObject != null ? jSONObject.optString("id") : null;
                if (uGCTarget != null && uGCTarget.mUserInfoList != null && uGCTarget.mUserInfoList.size() > 0) {
                    String str3 = uGCTarget.mUserInfoList.get(0).uk;
                    if (!TextUtils.isEmpty(str3)) {
                        return generateSPKey(UgcLoginUtils.getUK(), ugcSchemeModel.publishType, optString, str3);
                    }
                }
                return generateSPKey(UgcLoginUtils.getUK(), ugcSchemeModel.publishType, optString);
            case 5:
                return generateSPKey(UgcLoginUtils.getUK(), ugcSchemeModel.publishType, ugcSchemeModel.referenceDt);
            case 6:
                return null;
            case 7:
                UGCTarget uGCTarget2 = (UGCTarget) new Gson().fromJson(ugcSchemeModel.target, (Class<Object>) UGCTarget.class);
                if (uGCTarget2 != null && uGCTarget2.tagList != null && uGCTarget2.tagList.size() > 0) {
                    String str4 = uGCTarget2.tagList.get(0).postId;
                    if (!TextUtils.isEmpty(str4)) {
                        return generateSPKey(UgcLoginUtils.getUK(), ugcSchemeModel.publishType, str4);
                    }
                }
                return generateSPKey(UgcLoginUtils.getUK(), ugcSchemeModel.publishType);
            case '\b':
                return generateSPKey(UgcLoginUtils.getUK(), ugcSchemeModel.publishType);
            default:
                return null;
        }
    }
}
