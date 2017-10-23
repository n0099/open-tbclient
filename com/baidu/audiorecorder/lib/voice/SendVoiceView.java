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
    private TextView JF;
    private int JG;
    private i JH;
    private FloatRecordView JI;
    private WindowManager JJ;
    private WindowManager.LayoutParams JK;

    public SendVoiceView(Context context) {
        super(context);
        this.JF = null;
        this.JG = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(d.j.send_voice_view, this);
            this.JF = (TextView) findViewById(d.h.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            lN();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.JF.setBackgroundResource(d.g.but_talk_s);
            this.JF.setText(TbadkCoreApplication.getInst().getContext().getString(d.l.msglist_no_push));
            return;
        }
        this.JF.setBackgroundResource(d.g.but_talk_n);
        this.JF.setText(TbadkCoreApplication.getInst().getContext().getString(d.l.msglist_push_talk));
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
        return this.JG;
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
        if (this.JH != null) {
            this.JH.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.JH = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.JG = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }

    private void lN() {
        this.JI = new FloatRecordView(getContext());
        this.JJ = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.JK = new WindowManager.LayoutParams();
        this.JK.type = 2002;
        this.JK.format = 1;
        this.JK.flags = 56;
        this.JK.gravity = 17;
        this.JK.x = 0;
        this.JK.y = 0;
        this.JK.width = getContext().getResources().getDimensionPixelSize(d.f.ds360);
        this.JK.height = getContext().getResources().getDimensionPixelSize(d.f.ds360);
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
        if (this.JI != null && this.JJ != null && this.JK != null) {
            this.JI.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.JI != null && this.JJ != null && this.JK != null) {
            this.JI.closeRecordCancel();
            LinearLayout lH = this.JI.lH();
            if (lH != null && lH.getParent() != null) {
                this.JJ.removeView(lH);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.JI != null && this.JJ != null && this.JK != null) {
            this.JI.closeRecordTooShort();
            LinearLayout lG = this.JI.lG();
            if (lG != null && lG.getParent() != null) {
                this.JJ.removeView(lG);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout lH;
        if (this.JI != null && this.JJ != null && this.JK != null && (lH = this.JI.lH()) != null && lH.getParent() == null) {
            this.JJ.addView(lH, this.JK);
            this.JI.showRecordCancel();
        }
    }

    public void lI() {
        LinearLayout lG;
        if (this.JI != null && this.JJ != null && this.JK != null && (lG = this.JI.lG()) != null && lG.getParent() == null) {
            this.JJ.addView(lG, this.JK);
            this.JI.lI();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout lF;
        if (this.JI != null && this.JJ != null && this.JK != null && (lF = this.JI.lF()) != null && lF.getParent() == null) {
            this.JJ.addView(lF, this.JK);
            this.JI.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.JI != null && this.JJ != null && this.JK != null) {
            this.JI.stopRecordVoice();
            LinearLayout lF = this.JI.lF();
            if (lF != null && lF.getParent() != null) {
                this.JJ.removeView(lF);
            }
        }
    }
}
