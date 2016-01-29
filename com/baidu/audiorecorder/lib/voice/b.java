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
                kVar20 = a.KN;
                if (kVar20 != null) {
                    kVar21 = a.KN;
                    str = a.KM;
                    kVar21.k(str, message.arg1);
                    a.KN = null;
                    break;
                }
                break;
            case 1:
            case 3:
                kVar9 = a.KN;
                if (kVar9 != null) {
                    if (com.baidu.adp.lib.util.e.iJ()) {
                        kVar11 = a.KN;
                        kVar11.m(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_err_create_file_fail));
                    } else {
                        kVar10 = a.KN;
                        kVar10.m(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_err_sdcard_nospace));
                    }
                    a.KN = null;
                    break;
                }
                break;
            case 2:
                kVar3 = a.KN;
                if (kVar3 != null) {
                    kVar4 = a.KN;
                    kVar4.m(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_err_file_fail));
                    a.KN = null;
                    break;
                }
                break;
            case 4:
                kVar18 = a.KN;
                if (kVar18 != null) {
                    kVar19 = a.KN;
                    kVar19.av(message.arg1);
                    break;
                }
                break;
            case 5:
                kVar5 = a.KN;
                if (kVar5 != null) {
                    kVar6 = a.KN;
                    kVar6.m(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_err_load_lib_fail));
                    a.KN = null;
                    break;
                }
                break;
            case 6:
                kVar = a.KN;
                if (kVar != null) {
                    kVar2 = a.KN;
                    kVar2.m(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_err_init_fail));
                    a.KN = null;
                    break;
                }
                break;
            case 7:
                kVar14 = a.KN;
                if (kVar14 != null) {
                    kVar15 = a.KN;
                    kVar15.m(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_record_timeout_tip));
                    a.KN = null;
                    break;
                }
                break;
            case 8:
                kVar12 = a.KN;
                if (kVar12 != null) {
                    kVar13 = a.KN;
                    kVar13.m(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_record_short_tip));
                    a.KN = null;
                    break;
                }
                break;
            case 9:
                kVar16 = a.KN;
                if (kVar16 != null) {
                    kVar17 = a.KN;
                    kVar17.aw(message.arg1);
                    break;
                }
                break;
            case 100:
                kVar7 = a.KN;
                if (kVar7 != null) {
                    kVar8 = a.KN;
                    kVar8.jC();
                    break;
                }
                break;
            default:
                kVar22 = a.KN;
                if (kVar22 != null) {
                    kVar23 = a.KN;
                    kVar23.m(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_err_other));
                    a.KN = null;
                    break;
                }
                break;
        }
        a.KK = 0;
        return false;
    }
}
