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
                kVar20 = a.Bk;
                if (kVar20 != null) {
                    kVar21 = a.Bk;
                    str = a.Bj;
                    kVar21.k(str, message.arg1);
                    a.Bk = null;
                    break;
                }
                break;
            case 1:
            case 3:
                kVar9 = a.Bk;
                if (kVar9 != null) {
                    if (com.baidu.adp.lib.util.e.fa()) {
                        kVar11 = a.Bk;
                        kVar11.f(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_err_create_file_fail));
                    } else {
                        kVar10 = a.Bk;
                        kVar10.f(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_err_sdcard_nospace));
                    }
                    a.Bk = null;
                    break;
                }
                break;
            case 2:
                kVar3 = a.Bk;
                if (kVar3 != null) {
                    kVar4 = a.Bk;
                    kVar4.f(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_err_file_fail));
                    a.Bk = null;
                    break;
                }
                break;
            case 4:
                kVar18 = a.Bk;
                if (kVar18 != null) {
                    kVar19 = a.Bk;
                    kVar19.ai(message.arg1);
                    break;
                }
                break;
            case 5:
                kVar5 = a.Bk;
                if (kVar5 != null) {
                    kVar6 = a.Bk;
                    kVar6.f(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_err_load_lib_fail));
                    a.Bk = null;
                    break;
                }
                break;
            case 6:
                kVar = a.Bk;
                if (kVar != null) {
                    kVar2 = a.Bk;
                    kVar2.f(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_err_init_fail));
                    a.Bk = null;
                    break;
                }
                break;
            case 7:
                kVar14 = a.Bk;
                if (kVar14 != null) {
                    kVar15 = a.Bk;
                    kVar15.f(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_record_timeout_tip));
                    a.Bk = null;
                    break;
                }
                break;
            case 8:
                kVar12 = a.Bk;
                if (kVar12 != null) {
                    kVar13 = a.Bk;
                    kVar13.f(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_record_short_tip));
                    a.Bk = null;
                    break;
                }
                break;
            case 9:
                kVar16 = a.Bk;
                if (kVar16 != null) {
                    kVar17 = a.Bk;
                    kVar17.aj(message.arg1);
                    break;
                }
                break;
            case 100:
                kVar7 = a.Bk;
                if (kVar7 != null) {
                    kVar8 = a.Bk;
                    kVar8.fV();
                    break;
                }
                break;
            default:
                kVar22 = a.Bk;
                if (kVar22 != null) {
                    kVar23 = a.Bk;
                    kVar23.f(message.what, com.baidu.adp.lib.voice.l.getString(t.j.voice_err_other));
                    a.Bk = null;
                    break;
                }
                break;
        }
        a.Bh = 0;
        return false;
    }
}
