package com.baidu.tbadk.core.voice.a;

import com.baidu.adp.lib.voice.q;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class a {
    public String md5 = null;
    public String path = null;
    public int error_code = 0;
    public String error_msg = null;

    public static String bQ(int i) {
        switch (i) {
            case 0:
                return "";
            case 1:
                return q.getString(y.voice_cache_error_internal);
            case 2:
                return q.getString(y.voice_cache_error_no_space);
            case 3:
                return q.getString(y.neterror);
            case 4:
                return q.getString(y.voice_cache_error_no_file);
            case 5:
                return q.getString(y.voice_cache_error_md5);
            case 6:
                return q.getString(y.voice_cache_error_no_input);
            case 7:
                return q.getString(y.voice_cache_error_no_dir);
            default:
                return "";
        }
    }
}
