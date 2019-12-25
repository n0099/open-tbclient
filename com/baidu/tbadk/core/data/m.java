package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class m {
    public String cJK;
    public long cJL;
    public int cJM;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.cJK = bookThread.book_id;
            this.cJL = bookThread.chapter_id.longValue();
            this.cJM = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cJK = jSONObject.optString("book_id", "0");
                this.cJL = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.cJM = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
