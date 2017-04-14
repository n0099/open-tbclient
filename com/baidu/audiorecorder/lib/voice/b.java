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
                kVar20 = a.Kb;
                if (kVar20 != null) {
                    kVar21 = a.Kb;
                    str = a.Ka;
                    kVar21.k(str, message.arg1);
                    a.Kb = null;
                    break;
                }
                break;
            case 1:
            case 3:
                kVar9 = a.Kb;
                if (kVar9 != null) {
                    if (com.baidu.adp.lib.util.e.gT()) {
                        kVar11 = a.Kb;
                        kVar11.f(message.what, com.baidu.adp.lib.voice.l.getString(w.l.voice_err_create_file_fail));
                    } else {
                        kVar10 = a.Kb;
                        kVar10.f(message.what, com.baidu.adp.lib.voice.l.getString(w.l.voice_err_sdcard_nospace));
                    }
                    a.Kb = null;
                    break;
                }
                break;
            case 2:
                kVar3 = a.Kb;
                if (kVar3 != null) {
                    kVar4 = a.Kb;
                    kVar4.f(message.what, com.baidu.adp.lib.voice.l.getString(w.l.voice_err_file_fail));
                    a.Kb = null;
                    break;
                }
                break;
            case 4:
                kVar18 = a.Kb;
                if (kVar18 != null) {
                    kVar19 = a.Kb;
                    kVar19.ay(message.arg1);
                    break;
                }
                break;
            case 5:
                kVar5 = a.Kb;
                if (kVar5 != null) {
                    kVar6 = a.Kb;
                    kVar6.f(message.what, com.baidu.adp.lib.voice.l.getString(w.l.voice_err_load_lib_fail));
                    a.Kb = null;
                    break;
                }
                break;
            case 6:
                kVar = a.Kb;
                if (kVar != null) {
                    kVar2 = a.Kb;
                    kVar2.f(message.what, com.baidu.adp.lib.voice.l.getString(w.l.voice_err_init_fail));
                    a.Kb = null;
                    break;
                }
                break;
            case 7:
                kVar14 = a.Kb;
                if (kVar14 != null) {
                    kVar15 = a.Kb;
                    kVar15.f(message.what, com.baidu.adp.lib.voice.l.getString(w.l.voice_record_timeout_tip));
                    a.Kb = null;
                    break;
                }
                break;
            case 8:
                kVar12 = a.Kb;
                if (kVar12 != null) {
                    kVar13 = a.Kb;
                    kVar13.f(message.what, com.baidu.adp.lib.voice.l.getString(w.l.voice_record_short_tip));
                    a.Kb = null;
                    break;
                }
                break;
            case 9:
                kVar16 = a.Kb;
                if (kVar16 != null) {
                    kVar17 = a.Kb;
                    kVar17.az(message.arg1);
                    break;
                }
                break;
            case 100:
                kVar7 = a.Kb;
                if (kVar7 != null) {
                    kVar8 = a.Kb;
                    kVar8.hO();
                    break;
                }
                break;
            default:
                kVar22 = a.Kb;
                if (kVar22 != null) {
                    kVar23 = a.Kb;
                    kVar23.f(message.what, com.baidu.adp.lib.voice.l.getString(w.l.voice_err_other));
                    a.Kb = null;
                    break;
                }
                break;
        }
        a.JY = 0;
        return false;
    }
}
