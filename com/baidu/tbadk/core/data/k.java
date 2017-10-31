package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class k {
    public String Vl;
    public long Vm;
    public int Vn;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.Vl = bookThread.book_id;
            this.Vm = bookThread.chapter_id.longValue();
            this.Vn = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Vl = jSONObject.optString("book_id", "0");
                this.Vm = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.Vn = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
