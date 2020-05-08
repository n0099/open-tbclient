package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.audiorecorder.lib.voice.VoiceRecordButton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class c extends l {
    public c(Context context) {
        super(context, TbadkCoreApplication.getInst().getResources().getString(R.string.msglist_voice), 6);
        this.dXy = R.drawable.icon_pure_post_voice_n_svg;
        this.dXz = R.drawable.icon_mask_post_voice24_selection_svg;
        this.dXA = true;
        this.dXD = 6;
        this.dXE = true;
        this.dWM = VoiceRecordButton.I(context);
        this.dXF = new int[]{1, 9};
    }

    @Override // com.baidu.tbadk.editortools.l
    public boolean qB() {
        if (TbadkCoreApplication.getInst().isAudioRecorderOpen()) {
            return super.qB();
        }
        String uegVoiceWarning = TbadkCoreApplication.getInst().getUegVoiceWarning();
        if (StringUtils.isNull(uegVoiceWarning)) {
            uegVoiceWarning = TbadkCoreApplication.getInst().getString(R.string.ueg_voice_warning);
        }
        UtilHelper.showToast(TbadkCoreApplication.getInst(), uegVoiceWarning);
        return false;
    }
}
