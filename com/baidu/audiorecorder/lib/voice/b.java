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
                kVar20 = a.JV;
                if (kVar20 != null) {
                    kVar21 = a.JV;
                    str = a.JU;
                    kVar21.i(str, message.arg1);
                    a.JV = null;
                    break;
                }
                break;
            case 1:
            case 3:
                kVar9 = a.JV;
                if (kVar9 != null) {
                    if (com.baidu.adp.lib.util.f.iw()) {
                        kVar11 = a.JV;
                        kVar11.error(message.what, com.baidu.adp.lib.voice.l.getString(com.baidu.tieba.y.voice_err_create_file_fail));
                    } else {
                        kVar10 = a.JV;
                        kVar10.error(message.what, com.baidu.adp.lib.voice.l.getString(com.baidu.tieba.y.voice_err_sdcard_nospace));
                    }
                    a.JV = null;
                    break;
                }
                break;
            case 2:
                kVar3 = a.JV;
                if (kVar3 != null) {
                    kVar4 = a.JV;
                    kVar4.error(message.what, com.baidu.adp.lib.voice.l.getString(com.baidu.tieba.y.voice_err_file_fail));
                    a.JV = null;
                    break;
                }
                break;
            case 4:
                kVar18 = a.JV;
                if (kVar18 != null) {
                    kVar19 = a.JV;
                    kVar19.aj(message.arg1);
                    break;
                }
                break;
            case 5:
                kVar5 = a.JV;
                if (kVar5 != null) {
                    kVar6 = a.JV;
                    kVar6.error(message.what, com.baidu.adp.lib.voice.l.getString(com.baidu.tieba.y.voice_err_load_lib_fail));
                    a.JV = null;
                    break;
                }
                break;
            case 6:
                kVar = a.JV;
                if (kVar != null) {
                    kVar2 = a.JV;
                    kVar2.error(message.what, com.baidu.adp.lib.voice.l.getString(com.baidu.tieba.y.voice_err_init_fail));
                    a.JV = null;
                    break;
                }
                break;
            case 7:
                kVar14 = a.JV;
                if (kVar14 != null) {
                    kVar15 = a.JV;
                    kVar15.error(message.what, com.baidu.adp.lib.voice.l.getString(com.baidu.tieba.y.voice_record_timeout_tip));
                    a.JV = null;
                    break;
                }
                break;
            case 8:
                kVar12 = a.JV;
                if (kVar12 != null) {
                    kVar13 = a.JV;
                    kVar13.error(message.what, com.baidu.adp.lib.voice.l.getString(com.baidu.tieba.y.voice_record_short_tip));
                    a.JV = null;
                    break;
                }
                break;
            case 9:
                kVar16 = a.JV;
                if (kVar16 != null) {
                    kVar17 = a.JV;
                    kVar17.ak(message.arg1);
                    break;
                }
                break;
            case 100:
                kVar7 = a.JV;
                if (kVar7 != null) {
                    kVar8 = a.JV;
                    kVar8.ji();
                    break;
                }
                break;
            default:
                kVar22 = a.JV;
                if (kVar22 != null) {
                    kVar23 = a.JV;
                    kVar23.error(message.what, com.baidu.adp.lib.voice.l.getString(com.baidu.tieba.y.voice_err_other));
                    a.JV = null;
                    break;
                }
                break;
        }
        a.JS = 0;
        return false;
    }
}
