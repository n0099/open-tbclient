package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class k {
    public String Qo;
    public long Qp;
    public int Qq;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.Qo = bookThread.book_id;
            this.Qp = bookThread.chapter_id.longValue();
            this.Qq = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Qo = jSONObject.optString("book_id", "0");
                this.Qp = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.Qq = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
