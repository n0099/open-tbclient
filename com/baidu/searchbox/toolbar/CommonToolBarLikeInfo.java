package com.baidu.searchbox.toolbar;

import android.text.TextUtils;
import com.baidu.android.util.io.JSONUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CommonToolBarLikeInfo implements Serializable {
    public String ext;
    public boolean isLiked;
    public String likeCount;
    public String likeSyncData;
    public String nid;

    public void updateLikeSyncData() {
        if (TextUtils.isEmpty(this.likeSyncData)) {
            return;
        }
        JSONObject parseString = JSONUtils.parseString(this.likeSyncData);
        try {
            parseString.put("likeNum", this.likeCount);
            parseString.put("isLiked", this.isLiked);
            this.likeSyncData = parseString.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
