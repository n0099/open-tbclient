package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.audiorecorder.lib.voice.VoiceRecordButton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class c extends m {
    public c(Context context) {
        super(context, TbadkCoreApplication.getInst().getResources().getString(R.string.msglist_voice), 6);
        this.fuO = R.drawable.icon_pure_post_voice_n_svg;
        this.fuP = R.drawable.icon_mask_post_voice24_selection_svg;
        this.fuR = true;
        this.fuV = 6;
        this.fuW = true;
        this.fub = VoiceRecordButton.M(context);
        this.fuX = new int[]{1, 9};
    }

    @Override // com.baidu.tbadk.editortools.m
    public boolean sH() {
        if (TbadkCoreApplication.getInst().isAudioRecorderOpen()) {
            return super.sH();
        }
        String uegVoiceWarning = TbadkCoreApplication.getInst().getUegVoiceWarning();
        if (StringUtils.isNull(uegVoiceWarning)) {
            uegVoiceWarning = TbadkCoreApplication.getInst().getString(R.string.ueg_voice_warning);
        }
        UtilHelper.showToast(TbadkCoreApplication.getInst(), uegVoiceWarning);
        return false;
    }
}
