package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
class b implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        f fVar;
        f fVar2;
        f fVar3;
        f fVar4;
        f fVar5;
        f fVar6;
        String str;
        f fVar7;
        f fVar8;
        switch (message.what) {
            case 0:
                fVar5 = a.pR;
                if (fVar5 != null) {
                    fVar6 = a.pR;
                    str = a.mFileName;
                    fVar6.k(str, message.arg1);
                    break;
                }
                break;
            case 1:
                fVar3 = a.pR;
                if (fVar3 != null) {
                    fVar4 = a.pR;
                    fVar4.f(message.what, l.getString(R.string.voice_err_no_file));
                    break;
                }
                break;
            case 6:
                fVar = a.pR;
                if (fVar != null) {
                    fVar2 = a.pR;
                    fVar2.ah(message.arg1);
                }
                return true;
            default:
                fVar7 = a.pR;
                if (fVar7 != null) {
                    fVar8 = a.pR;
                    fVar8.f(message.what, l.getString(R.string.voice_err_play));
                    break;
                }
                break;
        }
        a.pP = 0;
        a.pR = null;
        return false;
    }
}
