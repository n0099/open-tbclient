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
    private TextView IZ;
    private int Ja;
    private i Jb;
    private FloatRecordView Jc;
    private WindowManager Jd;
    private WindowManager.LayoutParams Je;

    public SendVoiceView(Context context) {
        super(context);
        this.IZ = null;
        this.Ja = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(d.h.send_voice_view, this);
            this.IZ = (TextView) findViewById(d.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            lH();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.IZ.setBackgroundResource(d.f.but_talk_s);
            this.IZ.setText(TbadkCoreApplication.getInst().getContext().getString(d.j.msglist_no_push));
            return;
        }
        this.IZ.setBackgroundResource(d.f.but_talk_n);
        this.IZ.setText(TbadkCoreApplication.getInst().getContext().getString(d.j.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lG() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Ja;
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
        if (this.Jb != null) {
            this.Jb.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Jb = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Ja = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }

    private void lH() {
        this.Jc = new FloatRecordView(getContext());
        this.Jd = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.Je = new WindowManager.LayoutParams();
        this.Je.type = 2002;
        this.Je.format = 1;
        this.Je.flags = 56;
        this.Je.gravity = 17;
        this.Je.x = 0;
        this.Je.y = 0;
        this.Je.width = getContext().getResources().getDimensionPixelSize(d.e.ds360);
        this.Je.height = getContext().getResources().getDimensionPixelSize(d.e.ds360);
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
                lC();
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
        if (this.Jc != null && this.Jd != null && this.Je != null) {
            this.Jc.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.Jc != null && this.Jd != null && this.Je != null) {
            this.Jc.closeRecordCancel();
            LinearLayout lB = this.Jc.lB();
            if (lB != null && lB.getParent() != null) {
                this.Jd.removeView(lB);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.Jc != null && this.Jd != null && this.Je != null) {
            this.Jc.closeRecordTooShort();
            LinearLayout lA = this.Jc.lA();
            if (lA != null && lA.getParent() != null) {
                this.Jd.removeView(lA);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout lB;
        if (this.Jc != null && this.Jd != null && this.Je != null && (lB = this.Jc.lB()) != null && lB.getParent() == null) {
            this.Jd.addView(lB, this.Je);
            this.Jc.showRecordCancel();
        }
    }

    public void lC() {
        LinearLayout lA;
        if (this.Jc != null && this.Jd != null && this.Je != null && (lA = this.Jc.lA()) != null && lA.getParent() == null) {
            this.Jd.addView(lA, this.Je);
            this.Jc.lC();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout lz;
        if (this.Jc != null && this.Jd != null && this.Je != null && (lz = this.Jc.lz()) != null && lz.getParent() == null) {
            this.Jd.addView(lz, this.Je);
            this.Jc.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.Jc != null && this.Jd != null && this.Je != null) {
            this.Jc.stopRecordVoice();
            LinearLayout lz = this.Jc.lz();
            if (lz != null && lz.getParent() != null) {
                this.Jd.removeView(lz);
            }
        }
    }
}
