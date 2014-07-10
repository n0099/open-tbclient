package com.baidu.tbadk.core.voice;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends com.baidu.adp.lib.resourceLoader.c<com.baidu.tbadk.core.voice.a.a> {
    final /* synthetic */ VoiceManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.resourceLoader.c
    public void a(com.baidu.tbadk.core.voice.a.a aVar, String str, int i) {
        VoiceData.VoiceModel voiceModel;
        y yVar;
        y yVar2;
        VoiceData.VoiceModel voiceModel2;
        y yVar3;
        VoiceData.VoiceModel voiceModel3;
        VoiceData.VoiceModel voiceModel4;
        VoiceData.VoiceModel voiceModel5;
        super.a((t) aVar, str, i);
        voiceModel = this.a.mCurPlayModel;
        if (voiceModel == null) {
            return;
        }
        yVar = this.a.sPlayView;
        if (yVar != null) {
            String str2 = aVar.b;
            String str3 = aVar.a;
            int i2 = aVar.c;
            String str4 = aVar.d;
            if (StringUtils.isNull(str2) || StringUtils.isNull(str3)) {
                TiebaStatic.voiceError("", 1, this.a.context.getString(com.baidu.tieba.y.voice_cache_error_internal), str2);
                if (i2 <= 0 || StringUtils.isNull(str4) || (i2 != 2 && i2 != 4 && i2 != 3 && i2 != 7)) {
                    yVar2 = this.a.sPlayView;
                    yVar2.a(5, ae.a(com.baidu.tieba.y.voice_err_load_fail));
                } else {
                    yVar3 = this.a.sPlayView;
                    yVar3.a(5, str4);
                }
                VoiceManager voiceManager = this.a;
                voiceModel2 = this.a.mCurPlayModel;
                voiceManager.setPlayWaiting(voiceModel2);
                return;
            }
            voiceModel3 = this.a.mCurPlayModel;
            if (!voiceModel3.voiceId.equals(str3)) {
                return;
            }
            voiceModel4 = this.a.mCurPlayModel;
            if (VoiceManager.isVoiceDownloading(voiceModel4.voice_status.intValue())) {
                VoiceManager voiceManager2 = this.a;
                voiceModel5 = this.a.mCurPlayModel;
                voiceManager2.setPlaying(voiceModel5, str2);
            }
        }
    }
}
