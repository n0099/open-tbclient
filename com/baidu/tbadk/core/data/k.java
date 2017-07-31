package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class k {
    public String VL;
    public long VM;
    public int VN;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.VL = bookThread.book_id;
            this.VM = bookThread.chapter_id.longValue();
            this.VN = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.VL = jSONObject.optString("book_id", "0");
                this.VM = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.VN = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
