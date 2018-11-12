package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.audiorecorder.lib.voice.VoiceRecordButton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class c extends k {
    public c(Context context) {
        super(context, TbadkCoreApplication.getInst().getResources().getString(e.j.msglist_voice), 6);
        this.aVy = e.f.btn_pb_add_microphone;
        this.aVB = 6;
        this.aVC = true;
        this.aUL = VoiceRecordButton.aV(context);
        this.aVD = new int[]{1, 9};
    }

    @Override // com.baidu.tbadk.editortools.k
    public boolean qc() {
        if (TbadkCoreApplication.getInst().isAudioRecorderOpen()) {
            return super.qc();
        }
        String uegVoiceWarning = TbadkCoreApplication.getInst().getUegVoiceWarning();
        if (StringUtils.isNull(uegVoiceWarning)) {
            uegVoiceWarning = TbadkCoreApplication.getInst().getString(e.j.ueg_voice_warning);
        }
        UtilHelper.showToast(TbadkCoreApplication.getInst(), uegVoiceWarning);
        return false;
    }
}
