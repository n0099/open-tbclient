package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class k {
    public String Ql;
    public long Qm;
    public int Qn;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.Ql = bookThread.book_id;
            this.Qm = bookThread.chapter_id.longValue();
            this.Qn = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Ql = jSONObject.optString("book_id", "0");
                this.Qm = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.Qn = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
