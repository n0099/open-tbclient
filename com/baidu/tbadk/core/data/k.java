package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class k {
    public String WS;
    public long WT;
    public int WU;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.WS = bookThread.book_id;
            this.WT = bookThread.chapter_id.longValue();
            this.WU = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.WS = jSONObject.optString("book_id", "0");
                this.WT = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.WU = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
