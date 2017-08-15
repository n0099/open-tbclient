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
    private TextView Lr;
    private int Ls;
    private i Lt;
    private FloatRecordView Lu;
    private WindowManager Lv;
    private WindowManager.LayoutParams Lw;

    public SendVoiceView(Context context) {
        super(context);
        this.Lr = null;
        this.Ls = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(d.j.send_voice_view, this);
            this.Lr = (TextView) findViewById(d.h.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            lU();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.Lr.setBackgroundResource(d.g.but_talk_s);
            this.Lr.setText(TbadkCoreApplication.getInst().getContext().getString(d.l.msglist_no_push));
            return;
        }
        this.Lr.setBackgroundResource(d.g.but_talk_n);
        this.Lr.setText(TbadkCoreApplication.getInst().getContext().getString(d.l.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lT() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Ls;
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
        if (this.Lt != null) {
            this.Lt.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Lt = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Ls = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }

    private void lU() {
        this.Lu = new FloatRecordView(getContext());
        this.Lv = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.Lw = new WindowManager.LayoutParams();
        this.Lw.type = 2002;
        this.Lw.format = 1;
        this.Lw.flags = 56;
        this.Lw.gravity = 17;
        this.Lw.x = 0;
        this.Lw.y = 0;
        this.Lw.width = getContext().getResources().getDimensionPixelSize(d.f.ds360);
        this.Lw.height = getContext().getResources().getDimensionPixelSize(d.f.ds360);
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
                lP();
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
        if (this.Lu != null && this.Lv != null && this.Lw != null) {
            this.Lu.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.Lu != null && this.Lv != null && this.Lw != null) {
            this.Lu.closeRecordCancel();
            LinearLayout lO = this.Lu.lO();
            if (lO != null && lO.getParent() != null) {
                this.Lv.removeView(lO);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.Lu != null && this.Lv != null && this.Lw != null) {
            this.Lu.closeRecordTooShort();
            LinearLayout lN = this.Lu.lN();
            if (lN != null && lN.getParent() != null) {
                this.Lv.removeView(lN);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout lO;
        if (this.Lu != null && this.Lv != null && this.Lw != null && (lO = this.Lu.lO()) != null && lO.getParent() == null) {
            this.Lv.addView(lO, this.Lw);
            this.Lu.showRecordCancel();
        }
    }

    public void lP() {
        LinearLayout lN;
        if (this.Lu != null && this.Lv != null && this.Lw != null && (lN = this.Lu.lN()) != null && lN.getParent() == null) {
            this.Lv.addView(lN, this.Lw);
            this.Lu.lP();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout lM;
        if (this.Lu != null && this.Lv != null && this.Lw != null && (lM = this.Lu.lM()) != null && lM.getParent() == null) {
            this.Lv.addView(lM, this.Lw);
            this.Lu.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.Lu != null && this.Lv != null && this.Lw != null) {
            this.Lu.stopRecordVoice();
            LinearLayout lM = this.Lu.lM();
            if (lM != null && lM.getParent() != null) {
                this.Lv.removeView(lM);
            }
        }
    }
}
