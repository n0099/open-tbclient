package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.audiorecorder.lib.voice.g;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends r {
    public b(Context context) {
        super(context, TbadkCoreApplication.getInst().getResources().getString(d.l.editor_record), 6);
        this.aCP = d.g.btn_pb_add_microphone;
        this.aCS = 6;
        this.aCT = true;
        this.aCe = g.ak(context);
        this.aCU = new int[]{1, 9};
    }

    @Override // com.baidu.tbadk.editortools.r
    public boolean mb() {
        if (TbadkCoreApplication.getInst().isAudioRecorderOpen()) {
            return super.mb();
        }
        String uegVoiceWarning = TbadkCoreApplication.getInst().getUegVoiceWarning();
        if (StringUtils.isNull(uegVoiceWarning)) {
            uegVoiceWarning = TbadkCoreApplication.getInst().getString(d.l.ueg_voice_warning);
        }
        UtilHelper.showToast(TbadkCoreApplication.getInst(), uegVoiceWarning);
        return false;
    }
}
