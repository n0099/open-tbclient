package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.ISendVoiceView;
/* loaded from: classes3.dex */
public class SendVoiceView extends LinearLayout implements l, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private EditorTools SG;
    private int SH;
    private TextView Tk;
    private FloatRecordView Tl;
    private WindowManager Tm;
    private WindowManager.LayoutParams Tn;

    public SendVoiceView(Context context) {
        super(context);
        this.Tk = null;
        this.SH = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(e.h.send_voice_view, this);
            this.Tk = (TextView) findViewById(e.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            pQ();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.Tk.setBackgroundResource(e.f.but_talk_s);
            this.Tk.setText(TbadkCoreApplication.getInst().getContext().getString(e.j.msglist_no_push));
            return;
        }
        this.Tk.setBackgroundResource(e.f.but_talk_n);
        this.Tk.setText(TbadkCoreApplication.getInst().getContext().getString(e.j.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pI() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.SH;
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
        if (this.SG != null) {
            this.SG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.SG = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.SH = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }

    private void pQ() {
        this.Tl = new FloatRecordView(getContext());
        this.Tm = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.Tn = new WindowManager.LayoutParams();
        this.Tn.type = com.baidu.tieba.t.b.uV(2002);
        this.Tn.format = 1;
        this.Tn.flags = 56;
        this.Tn.gravity = 17;
        this.Tn.x = 0;
        this.Tn.y = 0;
        this.Tn.width = getContext().getResources().getDimensionPixelSize(e.C0141e.ds360);
        this.Tn.height = getContext().getResources().getDimensionPixelSize(e.C0141e.ds360);
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
                pG();
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
        if (this.Tl != null && this.Tm != null && this.Tn != null) {
            this.Tl.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.Tl != null && this.Tm != null && this.Tn != null) {
            this.Tl.closeRecordCancel();
            LinearLayout pF = this.Tl.pF();
            if (pF != null && pF.getParent() != null) {
                this.Tm.removeView(pF);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.Tl != null && this.Tm != null && this.Tn != null) {
            this.Tl.closeRecordTooShort();
            LinearLayout pE = this.Tl.pE();
            if (pE != null && pE.getParent() != null) {
                this.Tm.removeView(pE);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout pF;
        if (this.Tl != null && this.Tm != null && this.Tn != null && (pF = this.Tl.pF()) != null && pF.getParent() == null) {
            this.Tm.addView(pF, this.Tn);
            this.Tl.showRecordCancel();
        }
    }

    public void pG() {
        LinearLayout pE;
        if (this.Tl != null && this.Tm != null && this.Tn != null && (pE = this.Tl.pE()) != null && pE.getParent() == null) {
            this.Tm.addView(pE, this.Tn);
            this.Tl.pG();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout pD;
        if (this.Tl != null && this.Tm != null && this.Tn != null && (pD = this.Tl.pD()) != null && pD.getParent() == null) {
            this.Tm.addView(pD, this.Tn);
            this.Tl.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.Tl != null && this.Tm != null && this.Tn != null) {
            this.Tl.stopRecordVoice();
            LinearLayout pD = this.Tl.pD();
            if (pD != null && pD.getParent() != null) {
                this.Tm.removeView(pD);
            }
        }
    }
}
