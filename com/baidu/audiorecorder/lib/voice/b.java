package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
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
                kVar20 = a.JM;
                if (kVar20 != null) {
                    kVar21 = a.JM;
                    str = a.JL;
                    kVar21.i(str, message.arg1);
                    a.JM = null;
                    break;
                }
                break;
            case 1:
            case 3:
                kVar9 = a.JM;
                if (kVar9 != null) {
                    if (com.baidu.adp.lib.util.f.iN()) {
                        kVar11 = a.JM;
                        kVar11.error(message.what, com.baidu.adp.lib.voice.l.getString(com.baidu.tieba.t.voice_err_create_file_fail));
                    } else {
                        kVar10 = a.JM;
                        kVar10.error(message.what, com.baidu.adp.lib.voice.l.getString(com.baidu.tieba.t.voice_err_sdcard_nospace));
                    }
                    a.JM = null;
                    break;
                }
                break;
            case 2:
                kVar3 = a.JM;
                if (kVar3 != null) {
                    kVar4 = a.JM;
                    kVar4.error(message.what, com.baidu.adp.lib.voice.l.getString(com.baidu.tieba.t.voice_err_file_fail));
                    a.JM = null;
                    break;
                }
                break;
            case 4:
                kVar18 = a.JM;
                if (kVar18 != null) {
                    kVar19 = a.JM;
                    kVar19.ah(message.arg1);
                    break;
                }
                break;
            case 5:
                kVar5 = a.JM;
                if (kVar5 != null) {
                    kVar6 = a.JM;
                    kVar6.error(message.what, com.baidu.adp.lib.voice.l.getString(com.baidu.tieba.t.voice_err_load_lib_fail));
                    a.JM = null;
                    break;
                }
                break;
            case 6:
                kVar = a.JM;
                if (kVar != null) {
                    kVar2 = a.JM;
                    kVar2.error(message.what, com.baidu.adp.lib.voice.l.getString(com.baidu.tieba.t.voice_err_init_fail));
                    a.JM = null;
                    break;
                }
                break;
            case 7:
                kVar14 = a.JM;
                if (kVar14 != null) {
                    kVar15 = a.JM;
                    kVar15.error(message.what, com.baidu.adp.lib.voice.l.getString(com.baidu.tieba.t.voice_record_timeout_tip));
                    a.JM = null;
                    break;
                }
                break;
            case 8:
                kVar12 = a.JM;
                if (kVar12 != null) {
                    kVar13 = a.JM;
                    kVar13.error(message.what, com.baidu.adp.lib.voice.l.getString(com.baidu.tieba.t.voice_record_short_tip));
                    a.JM = null;
                    break;
                }
                break;
            case 9:
                kVar16 = a.JM;
                if (kVar16 != null) {
                    kVar17 = a.JM;
                    kVar17.ai(message.arg1);
                    break;
                }
                break;
            case 100:
                kVar7 = a.JM;
                if (kVar7 != null) {
                    kVar8 = a.JM;
                    kVar8.jz();
                    break;
                }
                break;
            default:
                kVar22 = a.JM;
                if (kVar22 != null) {
                    kVar23 = a.JM;
                    kVar23.error(message.what, com.baidu.adp.lib.voice.l.getString(com.baidu.tieba.t.voice_err_other));
                    a.JM = null;
                    break;
                }
                break;
        }
        a.JJ = 0;
        return false;
    }
}
