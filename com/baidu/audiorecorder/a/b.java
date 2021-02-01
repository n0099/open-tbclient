package com.baidu.audiorecorder.a;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class b extends m {
    public b(Context context) {
        super(context, TbadkCoreApplication.getInst().getResources().getString(R.string.msglist_voice), 6);
        this.fCb = R.drawable.icon_pure_post_voice24;
        this.fCc = R.drawable.icon_pure_post_voice24_selection;
        this.fCe = false;
        this.fCf = true;
        this.fCi = 6;
        this.fCj = true;
        this.fBo = new NewVoiceRecordButton(context);
        this.fCk = new int[]{1, 9};
    }

    @Override // com.baidu.tbadk.editortools.m
    public boolean sg() {
        if (TbadkCoreApplication.getInst().isAudioRecorderOpen()) {
            return super.sg();
        }
        String uegVoiceWarning = TbadkCoreApplication.getInst().getUegVoiceWarning();
        if (StringUtils.isNull(uegVoiceWarning)) {
            uegVoiceWarning = TbadkCoreApplication.getInst().getString(R.string.ueg_voice_warning);
        }
        UtilHelper.showToast(TbadkCoreApplication.getInst(), uegVoiceWarning);
        return false;
    }
}
