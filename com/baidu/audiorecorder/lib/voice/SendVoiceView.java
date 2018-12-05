package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.ISendVoiceView;
/* loaded from: classes3.dex */
public class SendVoiceView extends LinearLayout implements l, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private TextView TA;
    private FloatRecordView TB;
    private WindowManager TC;
    private WindowManager.LayoutParams TD;
    private EditorTools Ta;
    private int Tb;

    public SendVoiceView(Context context) {
        super(context);
        this.TA = null;
        this.Tb = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(e.h.send_voice_view, this);
            this.TA = (TextView) findViewById(e.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            pU();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.TA.setBackgroundResource(e.f.but_talk_s);
            this.TA.setText(TbadkCoreApplication.getInst().getContext().getString(e.j.msglist_no_push));
            return;
        }
        this.TA.setBackgroundResource(e.f.but_talk_n);
        this.TA.setText(TbadkCoreApplication.getInst().getContext().getString(e.j.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pN() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Tb;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Ta != null) {
            this.Ta.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Ta = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Tb = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }

    private void pU() {
        this.TB = new FloatRecordView(getContext());
        this.TC = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService(WindowConfig.JSON_WINDOW_KEY);
        this.TD = new WindowManager.LayoutParams();
        this.TD.type = com.baidu.tieba.t.b.wi(2002);
        this.TD.format = 1;
        this.TD.flags = 56;
        this.TD.gravity = 17;
        this.TD.x = 0;
        this.TD.y = 0;
        this.TD.width = getContext().getResources().getDimensionPixelSize(e.C0210e.ds360);
        this.TD.height = getContext().getResources().getDimensionPixelSize(e.C0210e.ds360);
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStopingRecorder() {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                stopRecordVoice();
            } else if (i == 2) {
                closeRecordCancel();
                closeRecordTooShort();
                pL();
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onDeletedVoice(String str) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecordTime(int i) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        if (this.TB != null && this.TC != null && this.TD != null) {
            this.TB.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.TB != null && this.TC != null && this.TD != null) {
            this.TB.closeRecordCancel();
            LinearLayout pK = this.TB.pK();
            if (pK != null && pK.getParent() != null) {
                this.TC.removeView(pK);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.TB != null && this.TC != null && this.TD != null) {
            this.TB.closeRecordTooShort();
            LinearLayout pJ = this.TB.pJ();
            if (pJ != null && pJ.getParent() != null) {
                this.TC.removeView(pJ);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout pK;
        if (this.TB != null && this.TC != null && this.TD != null && (pK = this.TB.pK()) != null && pK.getParent() == null) {
            this.TC.addView(pK, this.TD);
            this.TB.showRecordCancel();
        }
    }

    public void pL() {
        LinearLayout pJ;
        if (this.TB != null && this.TC != null && this.TD != null && (pJ = this.TB.pJ()) != null && pJ.getParent() == null) {
            this.TC.addView(pJ, this.TD);
            this.TB.pL();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout pI;
        if (this.TB != null && this.TC != null && this.TD != null && (pI = this.TB.pI()) != null && pI.getParent() == null) {
            this.TC.addView(pI, this.TD);
            this.TB.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.TB != null && this.TC != null && this.TD != null) {
            this.TB.stopRecordVoice();
            LinearLayout pI = this.TB.pI();
            if (pI != null && pI.getParent() != null) {
                this.TC.removeView(pI);
            }
        }
    }
}
