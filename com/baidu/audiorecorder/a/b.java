package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b extends l {
    public b(Context context) {
        super(context, TbadkCoreApplication.getInst().getResources().getString(R.string.msglist_voice), 6);
        this.dtf = R.drawable.icon_pure_post_voice_n_svg;
        this.dtg = R.drawable.icon_mask_post_voice24_selection_svg;
        this.dth = true;
        this.dtk = 6;
        this.dtl = true;
        this.dss = new NewVoiceRecordButton(context);
        this.dtm = new int[]{1, 9};
    }

    @Override // com.baidu.tbadk.editortools.l
    public boolean lK() {
        if (TbadkCoreApplication.getInst().isAudioRecorderOpen()) {
            return super.lK();
        }
        String uegVoiceWarning = TbadkCoreApplication.getInst().getUegVoiceWarning();
        if (StringUtils.isNull(uegVoiceWarning)) {
            uegVoiceWarning = TbadkCoreApplication.getInst().getString(R.string.ueg_voice_warning);
        }
        UtilHelper.showToast(TbadkCoreApplication.getInst(), uegVoiceWarning);
        return false;
    }
}
