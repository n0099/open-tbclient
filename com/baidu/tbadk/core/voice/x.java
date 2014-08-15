package com.baidu.tbadk.core.voice;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.FileNotFoundException;
import java.io.FileReader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ VoiceManager a;

    private x(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ x(VoiceManager voiceManager, x xVar) {
        this(voiceManager);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1730=4, 1731=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Void doInBackground(Void... voidArr) {
        FileReader fileReader;
        FileReader fileReader2 = null;
        try {
            try {
                fileReader = new FileReader("/sys/class/switch/h2w/state");
                try {
                    char[] cArr = new char[1024];
                    this.a.b_HEADSET_PLUG = Integer.valueOf(new String(cArr, 0, fileReader.read(cArr, 0, 1024)).trim()).intValue() != 0;
                    if (this.a.b_HEADSET_PLUG) {
                        this.a.setSpeakerphone(false);
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e) {
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    com.baidu.tbadk.core.util.r rVar = new com.baidu.tbadk.core.util.r();
                    rVar.a("path", "/sys/class/switch/h2w/state");
                    TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_HEADSET, "CheckHeadsetPlugAsyncTask exception: " + e.getMessage(), rVar.toString());
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e3) {
                        }
                    }
                    return null;
                } catch (Exception e4) {
                    e = e4;
                    com.baidu.tbadk.core.util.r rVar2 = new com.baidu.tbadk.core.util.r();
                    rVar2.a("path", "/sys/class/switch/h2w/state");
                    TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_HEADSET, "CheckHeadsetPlugAsyncTask exception: " + e.getMessage(), rVar2.toString());
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e5) {
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        fileReader2.close();
                    } catch (Exception e6) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            fileReader = null;
        } catch (Exception e8) {
            e = e8;
            fileReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        return null;
    }
}
