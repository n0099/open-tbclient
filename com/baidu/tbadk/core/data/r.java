package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.CartoonThread;
/* loaded from: classes2.dex */
public class r {
    private long cartoonId;
    private int chapterId;

    public void a(CartoonThread cartoonThread) {
        if (cartoonThread != null) {
            this.cartoonId = cartoonThread.cartoon_id.longValue();
            this.chapterId = cartoonThread.chapter_id.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cartoonId = jSONObject.optLong("cartoon_id");
                this.chapterId = jSONObject.optInt(MangaBrowserActivityConfig.CHAPTER_ID);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public long getCartoonId() {
        return this.cartoonId;
    }

    public int getChapterId() {
        return this.chapterId;
    }
}
