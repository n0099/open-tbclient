package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
class b implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        j jVar;
        j jVar2;
        j jVar3;
        j jVar4;
        j jVar5;
        j jVar6;
        String str;
        j jVar7;
        j jVar8;
        switch (message.what) {
            case 0:
                jVar5 = a.ob;
                if (jVar5 != null) {
                    jVar6 = a.ob;
                    str = a.mFileName;
                    jVar6.j(str, message.arg1);
                    break;
                }
                break;
            case 1:
                jVar3 = a.ob;
                if (jVar3 != null) {
                    jVar4 = a.ob;
                    jVar4.error(message.what, q.getString(R.string.voice_err_no_file));
                    break;
                }
                break;
            case 6:
                jVar = a.ob;
                if (jVar != null) {
                    jVar2 = a.ob;
                    jVar2.ag(message.arg1);
                }
                return true;
            default:
                jVar7 = a.ob;
                if (jVar7 != null) {
                    jVar8 = a.ob;
                    jVar8.error(message.what, q.getString(R.string.voice_err_play));
                    break;
                }
                break;
        }
        a.nZ = 0;
        a.ob = null;
        return false;
    }
}
