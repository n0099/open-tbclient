package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.audiorecorder.lib.voice.VoiceRecordButton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class c extends k {
    public c(Context context) {
        super(context, TbadkCoreApplication.getInst().getResources().getString(d.j.msglist_voice), 6);
        this.cjk = d.f.btn_pb_add_microphone;
        this.cjn = 6;
        this.cjo = true;
        this.ciw = VoiceRecordButton.aV(context);
        this.cjp = new int[]{1, 9};
    }

    @Override // com.baidu.tbadk.editortools.k
    public boolean ri() {
        if (TbadkCoreApplication.getInst().isAudioRecorderOpen()) {
            return super.ri();
        }
        String uegVoiceWarning = TbadkCoreApplication.getInst().getUegVoiceWarning();
        if (StringUtils.isNull(uegVoiceWarning)) {
            uegVoiceWarning = TbadkCoreApplication.getInst().getString(d.j.ueg_voice_warning);
        }
        UtilHelper.showToast(TbadkCoreApplication.getInst(), uegVoiceWarning);
        return false;
    }
}
