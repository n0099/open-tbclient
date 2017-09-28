package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.ISendVoiceView;
/* loaded from: classes2.dex */
public class SendVoiceView extends LinearLayout implements s, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private TextView JE;
    private int JF;
    private i JG;
    private FloatRecordView JH;
    private WindowManager JI;
    private WindowManager.LayoutParams JJ;

    public SendVoiceView(Context context) {
        super(context);
        this.JE = null;
        this.JF = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(d.j.send_voice_view, this);
            this.JE = (TextView) findViewById(d.h.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            lN();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.JE.setBackgroundResource(d.g.but_talk_s);
            this.JE.setText(TbadkCoreApplication.getInst().getContext().getString(d.l.msglist_no_push));
            return;
        }
        this.JE.setBackgroundResource(d.g.but_talk_n);
        this.JE.setText(TbadkCoreApplication.getInst().getContext().getString(d.l.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lM() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.JF;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JG != null) {
            this.JG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.JG = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.JF = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }

    private void lN() {
        this.JH = new FloatRecordView(getContext());
        this.JI = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.JJ = new WindowManager.LayoutParams();
        this.JJ.type = 2002;
        this.JJ.format = 1;
        this.JJ.flags = 56;
        this.JJ.gravity = 17;
        this.JJ.x = 0;
        this.JJ.y = 0;
        this.JJ.width = getContext().getResources().getDimensionPixelSize(d.f.ds360);
        this.JJ.height = getContext().getResources().getDimensionPixelSize(d.f.ds360);
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
                lI();
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
        if (this.JH != null && this.JI != null && this.JJ != null) {
            this.JH.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.JH != null && this.JI != null && this.JJ != null) {
            this.JH.closeRecordCancel();
            LinearLayout lH = this.JH.lH();
            if (lH != null && lH.getParent() != null) {
                this.JI.removeView(lH);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.JH != null && this.JI != null && this.JJ != null) {
            this.JH.closeRecordTooShort();
            LinearLayout lG = this.JH.lG();
            if (lG != null && lG.getParent() != null) {
                this.JI.removeView(lG);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout lH;
        if (this.JH != null && this.JI != null && this.JJ != null && (lH = this.JH.lH()) != null && lH.getParent() == null) {
            this.JI.addView(lH, this.JJ);
            this.JH.showRecordCancel();
        }
    }

    public void lI() {
        LinearLayout lG;
        if (this.JH != null && this.JI != null && this.JJ != null && (lG = this.JH.lG()) != null && lG.getParent() == null) {
            this.JI.addView(lG, this.JJ);
            this.JH.lI();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout lF;
        if (this.JH != null && this.JI != null && this.JJ != null && (lF = this.JH.lF()) != null && lF.getParent() == null) {
            this.JI.addView(lF, this.JJ);
            this.JH.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.JH != null && this.JI != null && this.JJ != null) {
            this.JH.stopRecordVoice();
            LinearLayout lF = this.JH.lF();
            if (lF != null && lF.getParent() != null) {
                this.JI.removeView(lF);
            }
        }
    }
}
