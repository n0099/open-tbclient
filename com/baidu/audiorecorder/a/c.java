package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.audiorecorder.lib.voice.VoiceRecordButton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c extends k {
    public c(Context context) {
        super(context, TbadkCoreApplication.getInst().getResources().getString(R.string.msglist_voice), 6);
        this.cFR = R.drawable.icon_pure_post_voice_n_svg;
        this.cFS = R.drawable.icon_mask_post_voice_h_svg;
        this.cFT = true;
        this.cFW = 6;
        this.cFX = true;
        this.cFe = VoiceRecordButton.ae(context);
        this.cFY = new int[]{1, 9};
    }

    @Override // com.baidu.tbadk.editortools.k
    public boolean lt() {
        if (TbadkCoreApplication.getInst().isAudioRecorderOpen()) {
            return super.lt();
        }
        String uegVoiceWarning = TbadkCoreApplication.getInst().getUegVoiceWarning();
        if (StringUtils.isNull(uegVoiceWarning)) {
            uegVoiceWarning = TbadkCoreApplication.getInst().getString(R.string.ueg_voice_warning);
        }
        UtilHelper.showToast(TbadkCoreApplication.getInst(), uegVoiceWarning);
        return false;
    }
}
