package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.r;
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
                kVar20 = a.Eb;
                if (kVar20 != null) {
                    kVar21 = a.Eb;
                    str = a.Ea;
                    kVar21.k(str, message.arg1);
                    a.Eb = null;
                    break;
                }
                break;
            case 1:
            case 3:
                kVar9 = a.Eb;
                if (kVar9 != null) {
                    if (com.baidu.adp.lib.util.e.fV()) {
                        kVar11 = a.Eb;
                        kVar11.e(message.what, com.baidu.adp.lib.voice.l.getString(r.j.voice_err_create_file_fail));
                    } else {
                        kVar10 = a.Eb;
                        kVar10.e(message.what, com.baidu.adp.lib.voice.l.getString(r.j.voice_err_sdcard_nospace));
                    }
                    a.Eb = null;
                    break;
                }
                break;
            case 2:
                kVar3 = a.Eb;
                if (kVar3 != null) {
                    kVar4 = a.Eb;
                    kVar4.e(message.what, com.baidu.adp.lib.voice.l.getString(r.j.voice_err_file_fail));
                    a.Eb = null;
                    break;
                }
                break;
            case 4:
                kVar18 = a.Eb;
                if (kVar18 != null) {
                    kVar19 = a.Eb;
                    kVar19.az(message.arg1);
                    break;
                }
                break;
            case 5:
                kVar5 = a.Eb;
                if (kVar5 != null) {
                    kVar6 = a.Eb;
                    kVar6.e(message.what, com.baidu.adp.lib.voice.l.getString(r.j.voice_err_load_lib_fail));
                    a.Eb = null;
                    break;
                }
                break;
            case 6:
                kVar = a.Eb;
                if (kVar != null) {
                    kVar2 = a.Eb;
                    kVar2.e(message.what, com.baidu.adp.lib.voice.l.getString(r.j.voice_err_init_fail));
                    a.Eb = null;
                    break;
                }
                break;
            case 7:
                kVar14 = a.Eb;
                if (kVar14 != null) {
                    kVar15 = a.Eb;
                    kVar15.e(message.what, com.baidu.adp.lib.voice.l.getString(r.j.voice_record_timeout_tip));
                    a.Eb = null;
                    break;
                }
                break;
            case 8:
                kVar12 = a.Eb;
                if (kVar12 != null) {
                    kVar13 = a.Eb;
                    kVar13.e(message.what, com.baidu.adp.lib.voice.l.getString(r.j.voice_record_short_tip));
                    a.Eb = null;
                    break;
                }
                break;
            case 9:
                kVar16 = a.Eb;
                if (kVar16 != null) {
                    kVar17 = a.Eb;
                    kVar17.aA(message.arg1);
                    break;
                }
                break;
            case 100:
                kVar7 = a.Eb;
                if (kVar7 != null) {
                    kVar8 = a.Eb;
                    kVar8.gR();
                    break;
                }
                break;
            default:
                kVar22 = a.Eb;
                if (kVar22 != null) {
                    kVar23 = a.Eb;
                    kVar23.e(message.what, com.baidu.adp.lib.voice.l.getString(r.j.voice_err_other));
                    a.Eb = null;
                    break;
                }
                break;
        }
        a.DY = 0;
        return false;
    }
}
