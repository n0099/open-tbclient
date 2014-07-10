package com.baidu.tbadk.core.voice;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class g implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        l lVar5;
        l lVar6;
        l lVar7;
        l lVar8;
        l lVar9;
        l lVar10;
        l lVar11;
        l lVar12;
        l lVar13;
        l lVar14;
        l lVar15;
        l lVar16;
        l lVar17;
        l lVar18;
        l lVar19;
        l lVar20;
        l lVar21;
        String str;
        l lVar22;
        l lVar23;
        switch (message.what) {
            case 0:
                lVar20 = f.d;
                if (lVar20 != null) {
                    lVar21 = f.d;
                    str = f.c;
                    lVar21.a(str, message.arg1);
                    f.d = null;
                    break;
                }
                break;
            case 1:
            case 3:
                lVar9 = f.d;
                if (lVar9 != null) {
                    if (com.baidu.adp.lib.util.c.c()) {
                        lVar11 = f.d;
                        lVar11.a(message.what, ae.a(com.baidu.tieba.y.voice_err_create_file_fail));
                    } else {
                        lVar10 = f.d;
                        lVar10.a(message.what, ae.a(com.baidu.tieba.y.voice_err_sdcard_nospace));
                    }
                    f.d = null;
                    break;
                }
                break;
            case 2:
                lVar3 = f.d;
                if (lVar3 != null) {
                    lVar4 = f.d;
                    lVar4.a(message.what, ae.a(com.baidu.tieba.y.voice_err_file_fail));
                    f.d = null;
                    break;
                }
                break;
            case 4:
                lVar18 = f.d;
                if (lVar18 != null) {
                    lVar19 = f.d;
                    lVar19.a(message.arg1);
                    break;
                }
                break;
            case 5:
                lVar5 = f.d;
                if (lVar5 != null) {
                    lVar6 = f.d;
                    lVar6.a(message.what, ae.a(com.baidu.tieba.y.voice_err_load_lib_fail));
                    f.d = null;
                    break;
                }
                break;
            case 6:
                lVar = f.d;
                if (lVar != null) {
                    lVar2 = f.d;
                    lVar2.a(message.what, ae.a(com.baidu.tieba.y.voice_err_init_fail));
                    f.d = null;
                    break;
                }
                break;
            case 7:
                lVar14 = f.d;
                if (lVar14 != null) {
                    lVar15 = f.d;
                    lVar15.a(message.what, ae.a(com.baidu.tieba.y.voice_record_timeout_tip));
                    f.d = null;
                    break;
                }
                break;
            case 8:
                lVar12 = f.d;
                if (lVar12 != null) {
                    lVar13 = f.d;
                    lVar13.a(message.what, ae.a(com.baidu.tieba.y.voice_record_short_tip));
                    f.d = null;
                    break;
                }
                break;
            case 9:
                lVar16 = f.d;
                if (lVar16 != null) {
                    lVar17 = f.d;
                    lVar17.b(message.arg1);
                    break;
                }
                break;
            case 100:
                lVar7 = f.d;
                if (lVar7 != null) {
                    lVar8 = f.d;
                    lVar8.a();
                    break;
                }
                break;
            default:
                lVar22 = f.d;
                if (lVar22 != null) {
                    lVar23 = f.d;
                    lVar23.a(message.what, ae.a(com.baidu.tieba.y.voice_err_other));
                    f.d = null;
                    break;
                }
                break;
        }
        f.a = 0;
        return false;
    }
}
