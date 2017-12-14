package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class j {
    public String VM;
    public long VN;
    public int VO;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.VM = bookThread.book_id;
            this.VN = bookThread.chapter_id.longValue();
            this.VO = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.VM = jSONObject.optString("book_id", "0");
                this.VN = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.VO = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
