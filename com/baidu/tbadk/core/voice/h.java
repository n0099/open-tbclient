package com.baidu.tbadk.core.voice;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.lib.f.c<com.baidu.tbadk.core.voice.a.a> {
    final /* synthetic */ VoiceManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(VoiceManager voiceManager) {
        this.this$0 = voiceManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.tbadk.core.voice.a.a aVar, String str, int i) {
        VoiceData.VoiceModel voiceModel;
        m mVar;
        m mVar2;
        VoiceData.VoiceModel voiceModel2;
        m mVar3;
        VoiceData.VoiceModel voiceModel3;
        VoiceData.VoiceModel voiceModel4;
        VoiceData.VoiceModel voiceModel5;
        super.a((h) aVar, str, i);
        voiceModel = this.this$0.mCurPlayModel;
        if (voiceModel == null) {
            return;
        }
        mVar = this.this$0.sPlayView;
        if (mVar != null && aVar != null) {
            String str2 = aVar.path;
            String str3 = aVar.md5;
            int i2 = aVar.error_code;
            String str4 = aVar.error_msg;
            if (StringUtils.isNull(str2) || StringUtils.isNull(str3)) {
                TiebaStatic.voiceError("", 1, this.this$0.context.getString(y.voice_cache_error_internal), str2);
                if (i2 <= 0 || StringUtils.isNull(str4) || (i2 != 2 && i2 != 4 && i2 != 3 && i2 != 7)) {
                    mVar2 = this.this$0.sPlayView;
                    mVar2.onShowErr(5, com.baidu.adp.lib.voice.q.getString(y.voice_err_load_fail));
                } else {
                    mVar3 = this.this$0.sPlayView;
                    mVar3.onShowErr(5, str4);
                }
                VoiceManager voiceManager = this.this$0;
                voiceModel2 = this.this$0.mCurPlayModel;
                voiceManager.setPlayWaiting(voiceModel2);
                return;
            }
            voiceModel3 = this.this$0.mCurPlayModel;
            if (!voiceModel3.voiceId.equals(str3)) {
                return;
            }
            voiceModel4 = this.this$0.mCurPlayModel;
            if (VoiceManager.isVoiceDownloading(voiceModel4.voice_status.intValue())) {
                VoiceManager voiceManager2 = this.this$0;
                voiceModel5 = this.this$0.mCurPlayModel;
                voiceManager2.setPlaying(voiceModel5, str2);
            }
        }
    }
}
