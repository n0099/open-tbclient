package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class j {
    public String VP;
    public long VQ;
    public int VR;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.VP = bookThread.book_id;
            this.VQ = bookThread.chapter_id.longValue();
            this.VR = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.VP = jSONObject.optString("book_id", "0");
                this.VQ = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.VR = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
