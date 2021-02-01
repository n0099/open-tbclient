package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class q {
    public String eMA;
    public long eMB;
    public int eMC;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.eMA = bookThread.book_id;
            this.eMB = bookThread.chapter_id.longValue();
            this.eMC = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eMA = jSONObject.optString("book_id", "0");
                this.eMB = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.eMC = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
