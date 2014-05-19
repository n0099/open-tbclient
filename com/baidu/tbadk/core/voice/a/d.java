package com.baidu.tbadk.core.voice.a;

import com.baidu.tbadk.core.voice.ae;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class d {
    public String a = null;
    public String b = null;
    public int c = 0;
    public String d = null;

    public static String a(int i) {
        switch (i) {
            case 0:
                return "";
            case 1:
                return ae.a(u.voice_cache_error_internal);
            case 2:
                return ae.a(u.voice_cache_error_no_space);
            case 3:
                return ae.a(u.sync_mark_fail_con);
            case 4:
                return ae.a(u.voice_cache_error_no_file);
            case 5:
                return ae.a(u.voice_cache_error_md5);
            case 6:
                return ae.a(u.voice_cache_error_no_input);
            case 7:
                return ae.a(u.voice_cache_error_no_dir);
            default:
                return "";
        }
    }
}
