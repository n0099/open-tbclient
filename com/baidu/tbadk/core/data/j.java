package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class j {
    public String aeD;
    public long aeE;
    public int aeF;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.aeD = bookThread.book_id;
            this.aeE = bookThread.chapter_id.longValue();
            this.aeF = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aeD = jSONObject.optString("book_id", "0");
                this.aeE = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.aeF = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
