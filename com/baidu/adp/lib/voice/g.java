package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
class g implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        p pVar;
        p pVar2;
        p pVar3;
        p pVar4;
        p pVar5;
        p pVar6;
        p pVar7;
        p pVar8;
        p pVar9;
        p pVar10;
        p pVar11;
        p pVar12;
        p pVar13;
        p pVar14;
        p pVar15;
        p pVar16;
        p pVar17;
        p pVar18;
        p pVar19;
        p pVar20;
        p pVar21;
        String str;
        p pVar22;
        p pVar23;
        switch (message.what) {
            case 0:
                pVar20 = f.oq;
                if (pVar20 != null) {
                    pVar21 = f.oq;
                    str = f.oo;
                    pVar21.j(str, message.arg1);
                    f.oq = null;
                    break;
                }
                break;
            case 1:
            case 3:
                pVar9 = f.oq;
                if (pVar9 != null) {
                    if (com.baidu.adp.lib.util.d.eU()) {
                        pVar11 = f.oq;
                        pVar11.error(message.what, q.getString(R.string.voice_err_create_file_fail));
                    } else {
                        pVar10 = f.oq;
                        pVar10.error(message.what, q.getString(R.string.voice_err_sdcard_nospace));
                    }
                    f.oq = null;
                    break;
                }
                break;
            case 2:
                pVar3 = f.oq;
                if (pVar3 != null) {
                    pVar4 = f.oq;
                    pVar4.error(message.what, q.getString(R.string.voice_err_file_fail));
                    f.oq = null;
                    break;
                }
                break;
            case 4:
                pVar18 = f.oq;
                if (pVar18 != null) {
                    pVar19 = f.oq;
                    pVar19.ah(message.arg1);
                    break;
                }
                break;
            case 5:
                pVar5 = f.oq;
                if (pVar5 != null) {
                    pVar6 = f.oq;
                    pVar6.error(message.what, q.getString(R.string.voice_err_load_lib_fail));
                    f.oq = null;
                    break;
                }
                break;
            case 6:
                pVar = f.oq;
                if (pVar != null) {
                    pVar2 = f.oq;
                    pVar2.error(message.what, q.getString(R.string.voice_err_init_fail));
                    f.oq = null;
                    break;
                }
                break;
            case 7:
                pVar14 = f.oq;
                if (pVar14 != null) {
                    pVar15 = f.oq;
                    pVar15.error(message.what, q.getString(R.string.voice_record_timeout_tip));
                    f.oq = null;
                    break;
                }
                break;
            case 8:
                pVar12 = f.oq;
                if (pVar12 != null) {
                    pVar13 = f.oq;
                    pVar13.error(message.what, q.getString(R.string.voice_record_short_tip));
                    f.oq = null;
                    break;
                }
                break;
            case 9:
                pVar16 = f.oq;
                if (pVar16 != null) {
                    pVar17 = f.oq;
                    pVar17.aj(message.arg1);
                    break;
                }
                break;
            case 100:
                pVar7 = f.oq;
                if (pVar7 != null) {
                    pVar8 = f.oq;
                    pVar8.fK();
                    break;
                }
                break;
            default:
                pVar22 = f.oq;
                if (pVar22 != null) {
                    pVar23 = f.oq;
                    pVar23.error(message.what, q.getString(R.string.voice_err_other));
                    f.oq = null;
                    break;
                }
                break;
        }
        f.ol = 0;
        return false;
    }
}
