package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class j {
    public String VS;
    public long VT;
    public int VU;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.VS = bookThread.book_id;
            this.VT = bookThread.chapter_id.longValue();
            this.VU = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.VS = jSONObject.optString("book_id", "0");
                this.VT = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.VU = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
