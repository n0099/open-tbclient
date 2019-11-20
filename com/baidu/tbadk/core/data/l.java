package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class l {
    public String bXr;
    public long bXs;
    public int bXt;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.bXr = bookThread.book_id;
            this.bXs = bookThread.chapter_id.longValue();
            this.bXt = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bXr = jSONObject.optString("book_id", "0");
                this.bXs = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.bXt = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
