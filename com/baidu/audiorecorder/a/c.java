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
        this.dxz = R.drawable.icon_pure_post_voice_n_svg;
        this.dxA = R.drawable.icon_mask_post_voice24_selection_svg;
        this.dxB = true;
        this.dxE = 6;
        this.dxF = true;
        this.dwN = VoiceRecordButton.ae(context);
        this.dxG = new int[]{1, 9};
    }

    @Override // com.baidu.tbadk.editortools.l
    public boolean lZ() {
        if (TbadkCoreApplication.getInst().isAudioRecorderOpen()) {
            return super.lZ();
        }
        String uegVoiceWarning = TbadkCoreApplication.getInst().getUegVoiceWarning();
        if (StringUtils.isNull(uegVoiceWarning)) {
            uegVoiceWarning = TbadkCoreApplication.getInst().getString(R.string.ueg_voice_warning);
        }
        UtilHelper.showToast(TbadkCoreApplication.getInst(), uegVoiceWarning);
        return false;
    }
}
