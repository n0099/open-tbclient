package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class l {
    public String bFY;
    public long bFZ;
    public int bGa;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.bFY = bookThread.book_id;
            this.bFZ = bookThread.chapter_id.longValue();
            this.bGa = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bFY = jSONObject.optString("book_id", "0");
                this.bFZ = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.bGa = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
