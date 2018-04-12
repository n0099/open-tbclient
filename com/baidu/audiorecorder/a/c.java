package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.audiorecorder.lib.voice.VoiceRecordButton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends k {
    public c(Context context) {
        super(context, TbadkCoreApplication.getInst().getResources().getString(d.k.msglist_voice), 6);
        this.aDz = d.f.btn_pb_add_microphone;
        this.aDC = 6;
        this.aDD = true;
        this.aCM = VoiceRecordButton.al(context);
        this.aDE = new int[]{1, 9};
    }

    @Override // com.baidu.tbadk.editortools.k
    public boolean mb() {
        if (TbadkCoreApplication.getInst().isAudioRecorderOpen()) {
            return super.mb();
        }
        String uegVoiceWarning = TbadkCoreApplication.getInst().getUegVoiceWarning();
        if (StringUtils.isNull(uegVoiceWarning)) {
            uegVoiceWarning = TbadkCoreApplication.getInst().getString(d.k.ueg_voice_warning);
        }
        UtilHelper.showToast(TbadkCoreApplication.getInst(), uegVoiceWarning);
        return false;
    }
}
