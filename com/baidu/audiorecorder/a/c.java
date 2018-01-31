package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.audiorecorder.lib.voice.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends r {
    public c(Context context) {
        super(context, TbadkCoreApplication.getInst().getResources().getString(d.j.msglist_voice), 6);
        this.bqW = d.f.btn_pb_add_microphone;
        this.bqZ = 6;
        this.bra = true;
        this.bqj = h.au(context);
        this.brb = new int[]{1, 9};
    }

    @Override // com.baidu.tbadk.editortools.r
    public boolean tw() {
        if (TbadkCoreApplication.getInst().isAudioRecorderOpen()) {
            return super.tw();
        }
        String uegVoiceWarning = TbadkCoreApplication.getInst().getUegVoiceWarning();
        if (StringUtils.isNull(uegVoiceWarning)) {
            uegVoiceWarning = TbadkCoreApplication.getInst().getString(d.j.ueg_voice_warning);
        }
        UtilHelper.showToast(TbadkCoreApplication.getInst(), uegVoiceWarning);
        return false;
    }
}
