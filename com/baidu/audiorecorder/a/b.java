package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context) {
        super(context, TbadkCoreApplication.getInst().getResources().getString(d.k.msglist_voice), 6);
        this.aDA = d.f.btn_pb_add_microphone;
        this.aDD = 6;
        this.aDE = true;
        this.aCN = new NewVoiceRecordButton(context);
        this.aDF = new int[]{1, 9};
    }

    @Override // com.baidu.tbadk.editortools.k
    public boolean ma() {
        if (TbadkCoreApplication.getInst().isAudioRecorderOpen()) {
            return super.ma();
        }
        String uegVoiceWarning = TbadkCoreApplication.getInst().getUegVoiceWarning();
        if (StringUtils.isNull(uegVoiceWarning)) {
            uegVoiceWarning = TbadkCoreApplication.getInst().getString(d.k.ueg_voice_warning);
        }
        UtilHelper.showToast(TbadkCoreApplication.getInst(), uegVoiceWarning);
        return false;
    }
}
