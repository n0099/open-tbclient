package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class l {
    public String bFZ;
    public long bGa;
    public int bGb;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.bFZ = bookThread.book_id;
            this.bGa = bookThread.chapter_id.longValue();
            this.bGb = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bFZ = jSONObject.optString("book_id", "0");
                this.bGa = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.bGb = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
