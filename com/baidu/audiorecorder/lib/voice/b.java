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
                kVar20 = a.Ki;
                if (kVar20 != null) {
                    kVar21 = a.Ki;
                    str = a.Kh;
                    kVar21.j(str, message.arg1);
                    a.Ki = null;
                    break;
                }
                break;
            case 1:
            case 3:
                kVar9 = a.Ki;
                if (kVar9 != null) {
                    if (com.baidu.adp.lib.util.e.iA()) {
                        kVar11 = a.Ki;
                        kVar11.m(message.what, com.baidu.adp.lib.voice.l.getString(n.i.voice_err_create_file_fail));
                    } else {
                        kVar10 = a.Ki;
                        kVar10.m(message.what, com.baidu.adp.lib.voice.l.getString(n.i.voice_err_sdcard_nospace));
                    }
                    a.Ki = null;
                    break;
                }
                break;
            case 2:
                kVar3 = a.Ki;
                if (kVar3 != null) {
                    kVar4 = a.Ki;
                    kVar4.m(message.what, com.baidu.adp.lib.voice.l.getString(n.i.voice_err_file_fail));
                    a.Ki = null;
                    break;
                }
                break;
            case 4:
                kVar18 = a.Ki;
                if (kVar18 != null) {
                    kVar19 = a.Ki;
                    kVar19.ak(message.arg1);
                    break;
                }
                break;
            case 5:
                kVar5 = a.Ki;
                if (kVar5 != null) {
                    kVar6 = a.Ki;
                    kVar6.m(message.what, com.baidu.adp.lib.voice.l.getString(n.i.voice_err_load_lib_fail));
                    a.Ki = null;
                    break;
                }
                break;
            case 6:
                kVar = a.Ki;
                if (kVar != null) {
                    kVar2 = a.Ki;
                    kVar2.m(message.what, com.baidu.adp.lib.voice.l.getString(n.i.voice_err_init_fail));
                    a.Ki = null;
                    break;
                }
                break;
            case 7:
                kVar14 = a.Ki;
                if (kVar14 != null) {
                    kVar15 = a.Ki;
                    kVar15.m(message.what, com.baidu.adp.lib.voice.l.getString(n.i.voice_record_timeout_tip));
                    a.Ki = null;
                    break;
                }
                break;
            case 8:
                kVar12 = a.Ki;
                if (kVar12 != null) {
                    kVar13 = a.Ki;
                    kVar13.m(message.what, com.baidu.adp.lib.voice.l.getString(n.i.voice_record_short_tip));
                    a.Ki = null;
                    break;
                }
                break;
            case 9:
                kVar16 = a.Ki;
                if (kVar16 != null) {
                    kVar17 = a.Ki;
                    kVar17.al(message.arg1);
                    break;
                }
                break;
            case 100:
                kVar7 = a.Ki;
                if (kVar7 != null) {
                    kVar8 = a.Ki;
                    kVar8.js();
                    break;
                }
                break;
            default:
                kVar22 = a.Ki;
                if (kVar22 != null) {
                    kVar23 = a.Ki;
                    kVar23.m(message.what, com.baidu.adp.lib.voice.l.getString(n.i.voice_err_other));
                    a.Ki = null;
                    break;
                }
                break;
        }
        a.Kf = 0;
        return false;
    }
}
