package com.baidu.tbadk.core.voice;

import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ab implements l {
    final /* synthetic */ VoiceManager a;

    private ab(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ab(VoiceManager voiceManager, byte b) {
        this(voiceManager);
    }

    @Override // com.baidu.tbadk.core.voice.l
    public final void a(String str, int i) {
        this.a.q();
        this.a.E = 1;
        if (this.a.b == null || str == null) {
            com.baidu.adp.lib.util.f.b("VoiceManager", "RecoreCallback.succ", "data err:" + str + " d:" + i);
            com.baidu.tbadk.core.util.v vVar = new com.baidu.tbadk.core.util.v();
            vVar.a("file", str);
            vVar.a("dur", Integer.valueOf(i));
            TiebaStatic.b("", -1103, "RecoreCallback.succ: file is null", vVar.toString());
        } else if (this.a.a != null) {
            if (i <= 1000) {
                this.a.a.a(2, ae.a(com.baidu.tbadk.l.voice_record_short_tip));
                com.baidu.adp.lib.util.f.b("VoiceManager", "RecoreCallback.succ", "voice too short f:" + str + " d:" + i);
                com.baidu.tbadk.core.util.v vVar2 = new com.baidu.tbadk.core.util.v();
                vVar2.a("file", str);
                vVar2.a("dur", Integer.valueOf(i));
                TiebaStatic.b("", -1105, "voice too short", vVar2.toString());
            } else if (!str.endsWith(this.a.b)) {
                com.baidu.adp.lib.util.f.b("VoiceManager", "RecoreCallback.succ", "filename error f:" + str + " v:" + this.a.b);
                com.baidu.tbadk.core.util.v vVar3 = new com.baidu.tbadk.core.util.v();
                vVar3.a("file", str);
                vVar3.a("dur", Integer.valueOf(i));
                TiebaStatic.b("", -1106, "RecoreCallback.succ: filename error", vVar3.toString());
            } else {
                com.baidu.adp.lib.util.f.d("========start submit voice f:" + str + " d:" + i);
                VoiceManager.a(this.a, this.a.b, (int) Math.round((i * 1.0d) / 1000.0d));
                this.a.b = null;
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.l
    public final void a(int i, String str) {
        this.a.q();
        com.baidu.adp.lib.util.f.b(getClass().getName(), "RecoreCallback.error", "error: " + str);
        TiebaStatic.b("", i, "RecoreCallback.error: " + str, "");
        if (this.a.a == null) {
            this.a.E = 1;
        } else if (i != 7) {
            this.a.E = 1;
            if (i == 8) {
                i = 2;
            }
            this.a.a.a(i, str);
            com.baidu.adp.lib.util.f.b("VoiceManager", "RecoreCallback.error", "err:" + i + " " + str);
            TiebaStatic.b("", i, "RecoreCallback.err: " + str, "");
        } else if (this.a.b == null) {
            com.baidu.adp.lib.util.f.b("VoiceManager", "RecoreCallback.error", "data err");
            TiebaStatic.b("", i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
        } else {
            VoiceManager.a(this.a, this.a.b, com.baidu.adp.lib.voice.a.a / LocationClientOption.MIN_SCAN_SPAN);
            this.a.b = null;
            this.a.a.a(3, this.a.d.getString(com.baidu.tbadk.l.voice_record_timeout_tip));
        }
    }

    @Override // com.baidu.tbadk.core.voice.l
    public final void a(int i) {
        if (this.a.a != null) {
            this.a.a.c(i);
        }
    }

    @Override // com.baidu.tbadk.core.voice.l
    public final void b(int i) {
        if (this.a.a != null) {
            this.a.a.b(i / LocationClientOption.MIN_SCAN_SPAN);
        }
    }

    @Override // com.baidu.tbadk.core.voice.l
    public final void a() {
        this.a.E = 1;
    }
}
