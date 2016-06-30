package com.baidu.tbadk.core.voice;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.voice.l;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.lib.g.b<com.baidu.tbadk.core.voice.a.a> {
    final /* synthetic */ VoiceManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(VoiceManager voiceManager) {
        this.this$0 = voiceManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.tbadk.core.voice.a.a aVar, String str, int i) {
        super.a((h) aVar, str, i);
        if (this.this$0.mCurPlayModel != null && this.this$0.sPlayView != null && aVar != null) {
            String str2 = aVar.path;
            String str3 = aVar.md5;
            int i2 = aVar.error_code;
            String str4 = aVar.error_msg;
            if (StringUtils.isNull(str2) || StringUtils.isNull(str3)) {
                TiebaStatic.voiceError(1, this.this$0.context.getString(u.j.voice_cache_error_internal), str2);
                if (i2 <= 0 || StringUtils.isNull(str4) || (i2 != 2 && i2 != 4 && i2 != 3 && i2 != 7)) {
                    this.this$0.sPlayView.onShowErr(5, l.getString(u.j.voice_err_load_fail));
                } else {
                    this.this$0.sPlayView.onShowErr(5, str4);
                }
                this.this$0.setPlayWaiting(this.this$0.mCurPlayModel);
            } else if (!this.this$0.mCurPlayModel.voiceId.equals(str3) || !VoiceManager.isVoiceDownloading(this.this$0.mCurPlayModel.voice_status.intValue())) {
            } else {
                this.this$0.setPlaying(this.this$0.mCurPlayModel, str2);
            }
        }
    }
}
