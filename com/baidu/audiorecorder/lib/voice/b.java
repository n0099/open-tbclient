package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.w;
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
                kVar20 = a.KA;
                if (kVar20 != null) {
                    kVar21 = a.KA;
                    str = a.Kz;
                    kVar21.k(str, message.arg1);
                    a.KA = null;
                    break;
                }
                break;
            case 1:
            case 3:
                kVar9 = a.KA;
                if (kVar9 != null) {
                    if (com.baidu.adp.lib.util.e.gO()) {
                        kVar11 = a.KA;
                        kVar11.f(message.what, com.baidu.adp.lib.voice.l.getString(w.l.voice_err_create_file_fail));
                    } else {
                        kVar10 = a.KA;
                        kVar10.f(message.what, com.baidu.adp.lib.voice.l.getString(w.l.voice_err_sdcard_nospace));
                    }
                    a.KA = null;
                    break;
                }
                break;
            case 2:
                kVar3 = a.KA;
                if (kVar3 != null) {
                    kVar4 = a.KA;
                    kVar4.f(message.what, com.baidu.adp.lib.voice.l.getString(w.l.voice_err_file_fail));
                    a.KA = null;
                    break;
                }
                break;
            case 4:
                kVar18 = a.KA;
                if (kVar18 != null) {
                    kVar19 = a.KA;
                    kVar19.az(message.arg1);
                    break;
                }
                break;
            case 5:
                kVar5 = a.KA;
                if (kVar5 != null) {
                    kVar6 = a.KA;
                    kVar6.f(message.what, com.baidu.adp.lib.voice.l.getString(w.l.voice_err_load_lib_fail));
                    a.KA = null;
                    break;
                }
                break;
            case 6:
                kVar = a.KA;
                if (kVar != null) {
                    kVar2 = a.KA;
                    kVar2.f(message.what, com.baidu.adp.lib.voice.l.getString(w.l.voice_err_init_fail));
                    a.KA = null;
                    break;
                }
                break;
            case 7:
                kVar14 = a.KA;
                if (kVar14 != null) {
                    kVar15 = a.KA;
                    kVar15.f(message.what, com.baidu.adp.lib.voice.l.getString(w.l.voice_record_timeout_tip));
                    a.KA = null;
                    break;
                }
                break;
            case 8:
                kVar12 = a.KA;
                if (kVar12 != null) {
                    kVar13 = a.KA;
                    kVar13.f(message.what, com.baidu.adp.lib.voice.l.getString(w.l.voice_record_short_tip));
                    a.KA = null;
                    break;
                }
                break;
            case 9:
                kVar16 = a.KA;
                if (kVar16 != null) {
                    kVar17 = a.KA;
                    kVar17.aA(message.arg1);
                    break;
                }
                break;
            case 100:
                kVar7 = a.KA;
                if (kVar7 != null) {
                    kVar8 = a.KA;
                    kVar8.hJ();
                    break;
                }
                break;
            default:
                kVar22 = a.KA;
                if (kVar22 != null) {
                    kVar23 = a.KA;
                    kVar23.f(message.what, com.baidu.adp.lib.voice.l.getString(w.l.voice_err_other));
                    a.KA = null;
                    break;
                }
                break;
        }
        a.Kx = 0;
        return false;
    }
}
