package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class b implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        com.baidu.adp.lib.voice.k kVar;
        com.baidu.adp.lib.voice.k kVar2;
        com.baidu.adp.lib.voice.k kVar3;
        com.baidu.adp.lib.voice.k kVar4;
        com.baidu.adp.lib.voice.k kVar5;
        com.baidu.adp.lib.voice.k kVar6;
        com.baidu.adp.lib.voice.k kVar7;
        com.baidu.adp.lib.voice.k kVar8;
        com.baidu.adp.lib.voice.k kVar9;
        com.baidu.adp.lib.voice.k kVar10;
        com.baidu.adp.lib.voice.k kVar11;
        com.baidu.adp.lib.voice.k kVar12;
        com.baidu.adp.lib.voice.k kVar13;
        com.baidu.adp.lib.voice.k kVar14;
        com.baidu.adp.lib.voice.k kVar15;
        com.baidu.adp.lib.voice.k kVar16;
        com.baidu.adp.lib.voice.k kVar17;
        com.baidu.adp.lib.voice.k kVar18;
        com.baidu.adp.lib.voice.k kVar19;
        com.baidu.adp.lib.voice.k kVar20;
        com.baidu.adp.lib.voice.k kVar21;
        String str;
        com.baidu.adp.lib.voice.k kVar22;
        com.baidu.adp.lib.voice.k kVar23;
        switch (message.what) {
            case 0:
                kVar20 = a.Ky;
                if (kVar20 != null) {
                    kVar21 = a.Ky;
                    str = a.Kx;
                    kVar21.j(str, message.arg1);
                    a.Ky = null;
                    break;
                }
                break;
            case 1:
            case 3:
                kVar9 = a.Ky;
                if (kVar9 != null) {
                    if (com.baidu.adp.lib.util.e.iA()) {
                        kVar11 = a.Ky;
                        kVar11.m(message.what, com.baidu.adp.lib.voice.l.getString(n.j.voice_err_create_file_fail));
                    } else {
                        kVar10 = a.Ky;
                        kVar10.m(message.what, com.baidu.adp.lib.voice.l.getString(n.j.voice_err_sdcard_nospace));
                    }
                    a.Ky = null;
                    break;
                }
                break;
            case 2:
                kVar3 = a.Ky;
                if (kVar3 != null) {
                    kVar4 = a.Ky;
                    kVar4.m(message.what, com.baidu.adp.lib.voice.l.getString(n.j.voice_err_file_fail));
                    a.Ky = null;
                    break;
                }
                break;
            case 4:
                kVar18 = a.Ky;
                if (kVar18 != null) {
                    kVar19 = a.Ky;
                    kVar19.ak(message.arg1);
                    break;
                }
                break;
            case 5:
                kVar5 = a.Ky;
                if (kVar5 != null) {
                    kVar6 = a.Ky;
                    kVar6.m(message.what, com.baidu.adp.lib.voice.l.getString(n.j.voice_err_load_lib_fail));
                    a.Ky = null;
                    break;
                }
                break;
            case 6:
                kVar = a.Ky;
                if (kVar != null) {
                    kVar2 = a.Ky;
                    kVar2.m(message.what, com.baidu.adp.lib.voice.l.getString(n.j.voice_err_init_fail));
                    a.Ky = null;
                    break;
                }
                break;
            case 7:
                kVar14 = a.Ky;
                if (kVar14 != null) {
                    kVar15 = a.Ky;
                    kVar15.m(message.what, com.baidu.adp.lib.voice.l.getString(n.j.voice_record_timeout_tip));
                    a.Ky = null;
                    break;
                }
                break;
            case 8:
                kVar12 = a.Ky;
                if (kVar12 != null) {
                    kVar13 = a.Ky;
                    kVar13.m(message.what, com.baidu.adp.lib.voice.l.getString(n.j.voice_record_short_tip));
                    a.Ky = null;
                    break;
                }
                break;
            case 9:
                kVar16 = a.Ky;
                if (kVar16 != null) {
                    kVar17 = a.Ky;
                    kVar17.al(message.arg1);
                    break;
                }
                break;
            case 100:
                kVar7 = a.Ky;
                if (kVar7 != null) {
                    kVar8 = a.Ky;
                    kVar8.jt();
                    break;
                }
                break;
            default:
                kVar22 = a.Ky;
                if (kVar22 != null) {
                    kVar23 = a.Ky;
                    kVar23.m(message.what, com.baidu.adp.lib.voice.l.getString(n.j.voice_err_other));
                    a.Ky = null;
                    break;
                }
                break;
        }
        a.Kv = 0;
        return false;
    }
}
