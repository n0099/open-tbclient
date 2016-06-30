package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class i {
    public String Nt;
    public long Nu;
    public int Nv;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.Nt = bookThread.book_id;
            this.Nu = bookThread.chapter_id.longValue();
            this.Nv = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Nt = jSONObject.optString("book_id", "0");
                this.Nu = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.Nv = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
