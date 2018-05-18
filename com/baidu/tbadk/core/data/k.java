package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class k {
    public String WT;
    public long WU;
    public int WV;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.WT = bookThread.book_id;
            this.WU = bookThread.chapter_id.longValue();
            this.WV = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.WT = jSONObject.optString("book_id", "0");
                this.WU = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.WV = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
