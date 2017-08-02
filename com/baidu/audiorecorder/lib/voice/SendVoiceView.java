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
    private TextView JR;
    private int JS;
    private i JT;
    private FloatRecordView JU;
    private WindowManager JV;
    private WindowManager.LayoutParams JW;

    public SendVoiceView(Context context) {
        super(context);
        this.JR = null;
        this.JS = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(d.j.send_voice_view, this);
            this.JR = (TextView) findViewById(d.h.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            lK();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.JR.setBackgroundResource(d.g.but_talk_s);
            this.JR.setText(TbadkCoreApplication.getInst().getContext().getString(d.l.msglist_no_push));
            return;
        }
        this.JR.setBackgroundResource(d.g.but_talk_n);
        this.JR.setText(TbadkCoreApplication.getInst().getContext().getString(d.l.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lJ() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.JS;
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
        if (this.JT != null) {
            this.JT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.JT = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.JS = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }

    private void lK() {
        this.JU = new FloatRecordView(getContext());
        this.JV = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.JW = new WindowManager.LayoutParams();
        this.JW.type = 2002;
        this.JW.format = 1;
        this.JW.flags = 56;
        this.JW.gravity = 17;
        this.JW.x = 0;
        this.JW.y = 0;
        this.JW.width = getContext().getResources().getDimensionPixelSize(d.f.ds360);
        this.JW.height = getContext().getResources().getDimensionPixelSize(d.f.ds360);
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
                lF();
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
        if (this.JU != null && this.JV != null && this.JW != null) {
            this.JU.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.JU != null && this.JV != null && this.JW != null) {
            this.JU.closeRecordCancel();
            LinearLayout lE = this.JU.lE();
            if (lE != null && lE.getParent() != null) {
                this.JV.removeView(lE);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.JU != null && this.JV != null && this.JW != null) {
            this.JU.closeRecordTooShort();
            LinearLayout lD = this.JU.lD();
            if (lD != null && lD.getParent() != null) {
                this.JV.removeView(lD);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout lE;
        if (this.JU != null && this.JV != null && this.JW != null && (lE = this.JU.lE()) != null && lE.getParent() == null) {
            this.JV.addView(lE, this.JW);
            this.JU.showRecordCancel();
        }
    }

    public void lF() {
        LinearLayout lD;
        if (this.JU != null && this.JV != null && this.JW != null && (lD = this.JU.lD()) != null && lD.getParent() == null) {
            this.JV.addView(lD, this.JW);
            this.JU.lF();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout lC;
        if (this.JU != null && this.JV != null && this.JW != null && (lC = this.JU.lC()) != null && lC.getParent() == null) {
            this.JV.addView(lC, this.JW);
            this.JU.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.JU != null && this.JV != null && this.JW != null) {
            this.JU.stopRecordVoice();
            LinearLayout lC = this.JU.lC();
            if (lC != null && lC.getParent() != null) {
                this.JV.removeView(lC);
            }
        }
    }
}
