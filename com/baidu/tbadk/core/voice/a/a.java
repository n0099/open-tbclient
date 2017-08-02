package com.baidu.tbadk.core.voice.a;

import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a {
    public String md5 = null;
    public String path = null;
    public int error_code = 0;
    public String error_msg = null;

    public static String dB(int i) {
        switch (i) {
            case 0:
                return "";
            case 1:
                return h.getString(d.l.voice_cache_error_internal);
            case 2:
                return h.getString(d.l.voice_cache_error_no_space);
            case 3:
                return h.getString(d.l.neterror);
            case 4:
                return h.getString(d.l.voice_cache_error_no_file);
            case 5:
                return h.getString(d.l.voice_cache_error_md5);
            case 6:
                return h.getString(d.l.voice_cache_error_no_input);
            case 7:
                return h.getString(d.l.voice_cache_error_no_dir);
            default:
                return "";
        }
    }
}
