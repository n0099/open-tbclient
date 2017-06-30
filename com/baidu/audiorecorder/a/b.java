package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.audiorecorder.lib.voice.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.x;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class b extends x {
    public b(Context context) {
        super(context, TbadkCoreApplication.m9getInst().getResources().getString(w.l.editor_record), 6);
        this.aAw = w.g.btn_pb_add_microphone;
        this.aAz = 6;
        this.aAA = true;
        this.azL = s.aj(context);
        this.aAB = new int[]{1, 9};
    }

    @Override // com.baidu.tbadk.editortools.x
    public boolean lV() {
        if (TbadkCoreApplication.m9getInst().isAudioRecorderOpen()) {
            return super.lV();
        }
        String uegVoiceWarning = TbadkCoreApplication.m9getInst().getUegVoiceWarning();
        if (StringUtils.isNull(uegVoiceWarning)) {
            uegVoiceWarning = TbadkCoreApplication.m9getInst().getString(w.l.ueg_voice_warning);
        }
        UtilHelper.showToast(TbadkCoreApplication.m9getInst(), uegVoiceWarning);
        return false;
    }
}
