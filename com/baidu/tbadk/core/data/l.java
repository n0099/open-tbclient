package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class l {
    public String bxK;
    public long bxL;
    public int bxM;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.bxK = bookThread.book_id;
            this.bxL = bookThread.chapter_id.longValue();
            this.bxM = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bxK = jSONObject.optString("book_id", "0");
                this.bxL = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.bxM = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
