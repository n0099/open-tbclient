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
        this.aQh = e.f.btn_pb_add_microphone;
        this.aQk = 6;
        this.aQl = true;
        this.aPu = VoiceRecordButton.aV(context);
        this.aQm = new int[]{1, 9};
    }

    @Override // com.baidu.tbadk.editortools.k
    public boolean pX() {
        if (TbadkCoreApplication.getInst().isAudioRecorderOpen()) {
            return super.pX();
        }
        String uegVoiceWarning = TbadkCoreApplication.getInst().getUegVoiceWarning();
        if (StringUtils.isNull(uegVoiceWarning)) {
            uegVoiceWarning = TbadkCoreApplication.getInst().getString(e.j.ueg_voice_warning);
        }
        UtilHelper.showToast(TbadkCoreApplication.getInst(), uegVoiceWarning);
        return false;
    }
}
