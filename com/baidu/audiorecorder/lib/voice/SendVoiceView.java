package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.aj;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class SendVoiceView extends LinearLayout implements com.baidu.tbadk.editortools.y, ISendVoiceView, aj {
    private TextView JR;
    private int JS;
    private com.baidu.tbadk.editortools.j JT;
    private FloatRecordView JU;
    private WindowManager JV;
    private WindowManager.LayoutParams JW;

    public SendVoiceView(Context context) {
        super(context);
        this.JR = null;
        this.JS = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(w.j.send_voice_view, this);
            this.JR = (TextView) findViewById(w.h.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            lN();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.JR.setBackgroundResource(w.g.but_talk_s);
            this.JR.setText(TbadkCoreApplication.m9getInst().getContext().getString(w.l.msglist_no_push));
            return;
        }
        this.JR.setBackgroundResource(w.g.but_talk_n);
        this.JR.setText(TbadkCoreApplication.m9getInst().getContext().getString(w.l.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lM() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.JS;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JT != null) {
            this.JT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.JT = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.JS = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
    }

    private void lN() {
        this.JU = new FloatRecordView(getContext());
        this.JV = (WindowManager) TbadkCoreApplication.m9getInst().getContext().getSystemService("window");
        this.JW = new WindowManager.LayoutParams();
        this.JW.type = 2002;
        this.JW.format = 1;
        this.JW.flags = 56;
        this.JW.gravity = 17;
        this.JW.x = 0;
        this.JW.y = 0;
        this.JW.width = getContext().getResources().getDimensionPixelSize(w.f.ds360);
        this.JW.height = getContext().getResources().getDimensionPixelSize(w.f.ds360);
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStopingRecorder() {
    }

    @Override // com.baidu.adp.lib.voice.j
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

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onDeletedVoice(String str) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecordTime(int i) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        if (this.JU != null && this.JV != null && this.JW != null) {
            this.JU.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordCancel() {
        if (this.JU != null && this.JV != null && this.JW != null) {
            this.JU.closeRecordCancel();
            LinearLayout lH = this.JU.lH();
            if (lH != null && lH.getParent() != null) {
                this.JV.removeView(lH);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordTooShort() {
        if (this.JU != null && this.JV != null && this.JW != null) {
            this.JU.closeRecordTooShort();
            LinearLayout lG = this.JU.lG();
            if (lG != null && lG.getParent() != null) {
                this.JV.removeView(lG);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void showRecordCancel() {
        LinearLayout lH;
        if (this.JU != null && this.JV != null && this.JW != null && (lH = this.JU.lH()) != null && lH.getParent() == null) {
            this.JV.addView(lH, this.JW);
            this.JU.showRecordCancel();
        }
    }

    public void lI() {
        LinearLayout lG;
        if (this.JU != null && this.JV != null && this.JW != null && (lG = this.JU.lG()) != null && lG.getParent() == null) {
            this.JV.addView(lG, this.JW);
            this.JU.lI();
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void startRecordVoice() {
        LinearLayout lF;
        if (this.JU != null && this.JV != null && this.JW != null && (lF = this.JU.lF()) != null && lF.getParent() == null) {
            this.JV.addView(lF, this.JW);
            this.JU.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void stopRecordVoice() {
        if (this.JU != null && this.JV != null && this.JW != null) {
            this.JU.stopRecordVoice();
            LinearLayout lF = this.JU.lF();
            if (lF != null && lF.getParent() != null) {
                this.JV.removeView(lF);
            }
        }
    }
}
