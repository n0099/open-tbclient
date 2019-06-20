package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class b extends k {
    public b(Context context) {
        super(context, TbadkCoreApplication.getInst().getResources().getString(R.string.msglist_voice), 6);
        this.cru = R.drawable.btn_pb_add_microphone;
        this.crx = 6;
        this.cry = true;
        this.cqF = new NewVoiceRecordButton(context);
        this.crz = new int[]{1, 9};
    }

    @Override // com.baidu.tbadk.editortools.k
    public boolean qd() {
        if (TbadkCoreApplication.getInst().isAudioRecorderOpen()) {
            return super.qd();
        }
        String uegVoiceWarning = TbadkCoreApplication.getInst().getUegVoiceWarning();
        if (StringUtils.isNull(uegVoiceWarning)) {
            uegVoiceWarning = TbadkCoreApplication.getInst().getString(R.string.ueg_voice_warning);
        }
        UtilHelper.showToast(TbadkCoreApplication.getInst(), uegVoiceWarning);
        return false;
    }
}
