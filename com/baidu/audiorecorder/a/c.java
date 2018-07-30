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
        super(context, TbadkCoreApplication.getInst().getResources().getString(d.j.msglist_voice), 6);
        this.aMS = d.f.btn_pb_add_microphone;
        this.aMV = 6;
        this.aMW = true;
        this.aMf = VoiceRecordButton.ap(context);
        this.aMX = new int[]{1, 9};
    }

    @Override // com.baidu.tbadk.editortools.k
    public boolean oU() {
        if (TbadkCoreApplication.getInst().isAudioRecorderOpen()) {
            return super.oU();
        }
        String uegVoiceWarning = TbadkCoreApplication.getInst().getUegVoiceWarning();
        if (StringUtils.isNull(uegVoiceWarning)) {
            uegVoiceWarning = TbadkCoreApplication.getInst().getString(d.j.ueg_voice_warning);
        }
        UtilHelper.showToast(TbadkCoreApplication.getInst(), uegVoiceWarning);
        return false;
    }
}
