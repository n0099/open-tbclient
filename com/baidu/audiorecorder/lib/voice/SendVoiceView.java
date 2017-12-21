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
    private i IS;
    private int IT;
    private TextView Ju;
    private FloatRecordView Jv;
    private WindowManager Jw;
    private WindowManager.LayoutParams Jx;

    public SendVoiceView(Context context) {
        super(context);
        this.Ju = null;
        this.IT = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(d.h.send_voice_view, this);
            this.Ju = (TextView) findViewById(d.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            lL();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.Ju.setBackgroundResource(d.f.but_talk_s);
            this.Ju.setText(TbadkCoreApplication.getInst().getContext().getString(d.j.msglist_no_push));
            return;
        }
        this.Ju.setBackgroundResource(d.f.but_talk_n);
        this.Ju.setText(TbadkCoreApplication.getInst().getContext().getString(d.j.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lE() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.IT;
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
        if (this.IS != null) {
            this.IS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.IS = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.IT = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }

    private void lL() {
        this.Jv = new FloatRecordView(getContext());
        this.Jw = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.Jx = new WindowManager.LayoutParams();
        this.Jx.type = 2002;
        this.Jx.format = 1;
        this.Jx.flags = 56;
        this.Jx.gravity = 17;
        this.Jx.x = 0;
        this.Jx.y = 0;
        this.Jx.width = getContext().getResources().getDimensionPixelSize(d.e.ds360);
        this.Jx.height = getContext().getResources().getDimensionPixelSize(d.e.ds360);
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
        if (this.Jv != null && this.Jw != null && this.Jx != null) {
            this.Jv.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.Jv != null && this.Jw != null && this.Jx != null) {
            this.Jv.closeRecordCancel();
            LinearLayout lB = this.Jv.lB();
            if (lB != null && lB.getParent() != null) {
                this.Jw.removeView(lB);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.Jv != null && this.Jw != null && this.Jx != null) {
            this.Jv.closeRecordTooShort();
            LinearLayout lA = this.Jv.lA();
            if (lA != null && lA.getParent() != null) {
                this.Jw.removeView(lA);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout lB;
        if (this.Jv != null && this.Jw != null && this.Jx != null && (lB = this.Jv.lB()) != null && lB.getParent() == null) {
            this.Jw.addView(lB, this.Jx);
            this.Jv.showRecordCancel();
        }
    }

    public void lC() {
        LinearLayout lA;
        if (this.Jv != null && this.Jw != null && this.Jx != null && (lA = this.Jv.lA()) != null && lA.getParent() == null) {
            this.Jw.addView(lA, this.Jx);
            this.Jv.lC();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout lz;
        if (this.Jv != null && this.Jw != null && this.Jx != null && (lz = this.Jv.lz()) != null && lz.getParent() == null) {
            this.Jw.addView(lz, this.Jx);
            this.Jv.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.Jv != null && this.Jw != null && this.Jx != null) {
            this.Jv.stopRecordVoice();
            LinearLayout lz = this.Jv.lz();
            if (lz != null && lz.getParent() != null) {
                this.Jw.removeView(lz);
            }
        }
    }
}
