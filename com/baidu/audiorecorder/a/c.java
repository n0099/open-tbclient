package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.audiorecorder.lib.voice.VoiceRecordButton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class c extends k {
    public c(Context context) {
        super(context, TbadkCoreApplication.getInst().getResources().getString(f.j.msglist_voice), 6);
        this.aMP = f.C0146f.btn_pb_add_microphone;
        this.aMS = 6;
        this.aMT = true;
        this.aMc = VoiceRecordButton.ap(context);
        this.aMU = new int[]{1, 9};
    }

    @Override // com.baidu.tbadk.editortools.k
    public boolean oR() {
        if (TbadkCoreApplication.getInst().isAudioRecorderOpen()) {
            return super.oR();
        }
        String uegVoiceWarning = TbadkCoreApplication.getInst().getUegVoiceWarning();
        if (StringUtils.isNull(uegVoiceWarning)) {
            uegVoiceWarning = TbadkCoreApplication.getInst().getString(f.j.ueg_voice_warning);
        }
        UtilHelper.showToast(TbadkCoreApplication.getInst(), uegVoiceWarning);
        return false;
    }
}
