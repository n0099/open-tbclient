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
                fVar5 = a.yV;
                if (fVar5 != null) {
                    fVar6 = a.yV;
                    str = a.mFileName;
                    fVar6.j(str, message.arg1);
                    break;
                }
                break;
            case 1:
                fVar3 = a.yV;
                if (fVar3 != null) {
                    fVar4 = a.yV;
                    fVar4.m(message.what, l.getString(R.string.voice_err_no_file));
                    break;
                }
                break;
            case 6:
                fVar = a.yV;
                if (fVar != null) {
                    fVar2 = a.yV;
                    fVar2.ai(message.arg1);
                }
                return true;
            default:
                fVar7 = a.yV;
                if (fVar7 != null) {
                    fVar8 = a.yV;
                    fVar8.m(message.what, l.getString(R.string.voice_err_play));
                    break;
                }
                break;
        }
        a.mPlayingState = 0;
        a.yV = null;
        return false;
    }
}
