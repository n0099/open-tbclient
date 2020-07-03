package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class b extends l {
    public b(Context context) {
        super(context, TbadkCoreApplication.getInst().getResources().getString(R.string.msglist_voice), 6);
        this.eut = R.drawable.icon_pure_post_voice_n_svg;
        this.euu = R.drawable.icon_mask_post_voice24_selection_svg;
        this.euw = true;
        this.euz = 6;
        this.euA = true;
        this.etH = new NewVoiceRecordButton(context);
        this.euB = new int[]{1, 9};
    }

    @Override // com.baidu.tbadk.editortools.l
    public boolean qY() {
        if (TbadkCoreApplication.getInst().isAudioRecorderOpen()) {
            return super.qY();
        }
        String uegVoiceWarning = TbadkCoreApplication.getInst().getUegVoiceWarning();
        if (StringUtils.isNull(uegVoiceWarning)) {
            uegVoiceWarning = TbadkCoreApplication.getInst().getString(R.string.ueg_voice_warning);
        }
        UtilHelper.showToast(TbadkCoreApplication.getInst(), uegVoiceWarning);
        return false;
    }
}
