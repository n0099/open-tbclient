package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context) {
        super(context, TbadkCoreApplication.getInst().getResources().getString(e.j.msglist_voice), 6);
        this.aYV = e.f.btn_pb_add_microphone;
        this.aYY = 6;
        this.aYZ = true;
        this.aYi = new NewVoiceRecordButton(context);
        this.aZa = new int[]{1, 9};
    }

    @Override // com.baidu.tbadk.editortools.k
    public boolean qb() {
        if (TbadkCoreApplication.getInst().isAudioRecorderOpen()) {
            return super.qb();
        }
        String uegVoiceWarning = TbadkCoreApplication.getInst().getUegVoiceWarning();
        if (StringUtils.isNull(uegVoiceWarning)) {
            uegVoiceWarning = TbadkCoreApplication.getInst().getString(e.j.ueg_voice_warning);
        }
        UtilHelper.showToast(TbadkCoreApplication.getInst(), uegVoiceWarning);
        return false;
    }
}
