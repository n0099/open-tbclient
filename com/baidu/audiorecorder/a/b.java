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
        this.ctI = R.drawable.icon_pure_post_voice_n_svg;
        this.ctJ = R.drawable.icon_mask_post_voice_h_svg;
        this.ctK = true;
        this.ctN = 6;
        this.ctO = true;
        this.csV = new NewVoiceRecordButton(context);
        this.ctP = new int[]{1, 9};
    }

    @Override // com.baidu.tbadk.editortools.k
    public boolean qA() {
        if (TbadkCoreApplication.getInst().isAudioRecorderOpen()) {
            return super.qA();
        }
        String uegVoiceWarning = TbadkCoreApplication.getInst().getUegVoiceWarning();
        if (StringUtils.isNull(uegVoiceWarning)) {
            uegVoiceWarning = TbadkCoreApplication.getInst().getString(R.string.ueg_voice_warning);
        }
        UtilHelper.showToast(TbadkCoreApplication.getInst(), uegVoiceWarning);
        return false;
    }
}
