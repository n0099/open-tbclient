package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class k {
    public String VO;
    public long VP;
    public int VQ;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.VO = bookThread.book_id;
            this.VP = bookThread.chapter_id.longValue();
            this.VQ = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.VO = jSONObject.optString("book_id", "0");
                this.VP = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.VQ = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
