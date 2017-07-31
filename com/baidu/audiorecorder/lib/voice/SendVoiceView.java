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
    private TextView Lp;
    private int Lq;
    private i Lr;
    private FloatRecordView Ls;
    private WindowManager Lt;
    private WindowManager.LayoutParams Lu;

    public SendVoiceView(Context context) {
        super(context);
        this.Lp = null;
        this.Lq = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(d.j.send_voice_view, this);
            this.Lp = (TextView) findViewById(d.h.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            lU();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.Lp.setBackgroundResource(d.g.but_talk_s);
            this.Lp.setText(TbadkCoreApplication.getInst().getContext().getString(d.l.msglist_no_push));
            return;
        }
        this.Lp.setBackgroundResource(d.g.but_talk_n);
        this.Lp.setText(TbadkCoreApplication.getInst().getContext().getString(d.l.msglist_push_talk));
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
        return this.Lq;
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
        if (this.Lr != null) {
            this.Lr.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Lr = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Lq = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }

    private void lU() {
        this.Ls = new FloatRecordView(getContext());
        this.Lt = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.Lu = new WindowManager.LayoutParams();
        this.Lu.type = 2002;
        this.Lu.format = 1;
        this.Lu.flags = 56;
        this.Lu.gravity = 17;
        this.Lu.x = 0;
        this.Lu.y = 0;
        this.Lu.width = getContext().getResources().getDimensionPixelSize(d.f.ds360);
        this.Lu.height = getContext().getResources().getDimensionPixelSize(d.f.ds360);
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
        if (this.Ls != null && this.Lt != null && this.Lu != null) {
            this.Ls.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.Ls != null && this.Lt != null && this.Lu != null) {
            this.Ls.closeRecordCancel();
            LinearLayout lO = this.Ls.lO();
            if (lO != null && lO.getParent() != null) {
                this.Lt.removeView(lO);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.Ls != null && this.Lt != null && this.Lu != null) {
            this.Ls.closeRecordTooShort();
            LinearLayout lN = this.Ls.lN();
            if (lN != null && lN.getParent() != null) {
                this.Lt.removeView(lN);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout lO;
        if (this.Ls != null && this.Lt != null && this.Lu != null && (lO = this.Ls.lO()) != null && lO.getParent() == null) {
            this.Lt.addView(lO, this.Lu);
            this.Ls.showRecordCancel();
        }
    }

    public void lP() {
        LinearLayout lN;
        if (this.Ls != null && this.Lt != null && this.Lu != null && (lN = this.Ls.lN()) != null && lN.getParent() == null) {
            this.Lt.addView(lN, this.Lu);
            this.Ls.lP();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout lM;
        if (this.Ls != null && this.Lt != null && this.Lu != null && (lM = this.Ls.lM()) != null && lM.getParent() == null) {
            this.Lt.addView(lM, this.Lu);
            this.Ls.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.Ls != null && this.Lt != null && this.Lu != null) {
            this.Ls.stopRecordVoice();
            LinearLayout lM = this.Ls.lM();
            if (lM != null && lM.getParent() != null) {
                this.Lt.removeView(lM);
            }
        }
    }
}
