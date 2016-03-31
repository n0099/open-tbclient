package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.t;
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
                kVar20 = a.KT;
                if (kVar20 != null) {
                    kVar21 = a.KT;
                    str = a.KS;
                    kVar21.k(str, message.arg1);
                    a.KT = null;
                    break;
                }
                break;
            case 1:
            case 3:
                kVar9 = a.KT;
                if (kVar9 != null) {
                    if (com.baidu.adp.lib.util.e.iP()) {
                        kVar11 = a.KT;
                        kVar11.f(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_err_create_file_fail));
                    } else {
                        kVar10 = a.KT;
                        kVar10.f(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_err_sdcard_nospace));
                    }
                    a.KT = null;
                    break;
                }
                break;
            case 2:
                kVar3 = a.KT;
                if (kVar3 != null) {
                    kVar4 = a.KT;
                    kVar4.f(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_err_file_fail));
                    a.KT = null;
                    break;
                }
                break;
            case 4:
                kVar18 = a.KT;
                if (kVar18 != null) {
                    kVar19 = a.KT;
                    kVar19.au(message.arg1);
                    break;
                }
                break;
            case 5:
                kVar5 = a.KT;
                if (kVar5 != null) {
                    kVar6 = a.KT;
                    kVar6.f(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_err_load_lib_fail));
                    a.KT = null;
                    break;
                }
                break;
            case 6:
                kVar = a.KT;
                if (kVar != null) {
                    kVar2 = a.KT;
                    kVar2.f(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_err_init_fail));
                    a.KT = null;
                    break;
                }
                break;
            case 7:
                kVar14 = a.KT;
                if (kVar14 != null) {
                    kVar15 = a.KT;
                    kVar15.f(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_record_timeout_tip));
                    a.KT = null;
                    break;
                }
                break;
            case 8:
                kVar12 = a.KT;
                if (kVar12 != null) {
                    kVar13 = a.KT;
                    kVar13.f(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_record_short_tip));
                    a.KT = null;
                    break;
                }
                break;
            case 9:
                kVar16 = a.KT;
                if (kVar16 != null) {
                    kVar17 = a.KT;
                    kVar17.av(message.arg1);
                    break;
                }
                break;
            case 100:
                kVar7 = a.KT;
                if (kVar7 != null) {
                    kVar8 = a.KT;
                    kVar8.jI();
                    break;
                }
                break;
            default:
                kVar22 = a.KT;
                if (kVar22 != null) {
                    kVar23 = a.KT;
                    kVar23.f(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_err_other));
                    a.KT = null;
                    break;
                }
                break;
        }
        a.KQ = 0;
        return false;
    }
}
