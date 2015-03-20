package com.baidu.tbadk.core.voice;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.n;
import java.io.FileNotFoundException;
import java.io.FileReader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ VoiceManager this$0;

    private h(VoiceManager voiceManager) {
        this.this$0 = voiceManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(VoiceManager voiceManager, h hVar) {
        this(voiceManager);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1287=4, 1288=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
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
                    this.this$0.b_HEADSET_PLUG = Integer.valueOf(new String(cArr, 0, fileReader.read(cArr, 0, 1024)).trim()).intValue() != 0;
                    if (this.this$0.b_HEADSET_PLUG) {
                        this.this$0.setSpeakerphone(false);
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e) {
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    n nVar = new n();
                    nVar.h("path", "/sys/class/switch/h2w/state");
                    TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_HEADSET, "CheckHeadsetPlugAsyncTask exception: " + e.getMessage(), nVar.toString());
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e3) {
                        }
                    }
                    return null;
                } catch (Exception e4) {
                    e = e4;
                    n nVar2 = new n();
                    nVar2.h("path", "/sys/class/switch/h2w/state");
                    TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_HEADSET, "CheckHeadsetPlugAsyncTask exception: " + e.getMessage(), nVar2.toString());
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
