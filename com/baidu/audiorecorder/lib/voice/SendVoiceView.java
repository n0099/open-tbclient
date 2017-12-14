package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.activity.FastRegActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.ISendVoiceView;
/* loaded from: classes2.dex */
public class SendVoiceView extends LinearLayout implements s, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private i IR;
    private int IS;
    private TextView Jt;
    private FloatRecordView Ju;
    private WindowManager Jv;
    private WindowManager.LayoutParams Jw;

    public SendVoiceView(Context context) {
        super(context);
        this.Jt = null;
        this.IS = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(d.h.send_voice_view, this);
            this.Jt = (TextView) findViewById(d.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            lL();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.Jt.setBackgroundResource(d.f.but_talk_s);
            this.Jt.setText(TbadkCoreApplication.getInst().getContext().getString(d.j.msglist_no_push));
            return;
        }
        this.Jt.setBackgroundResource(d.f.but_talk_n);
        this.Jt.setText(TbadkCoreApplication.getInst().getContext().getString(d.j.msglist_push_talk));
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
        return this.IS;
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
        if (this.IR != null) {
            this.IR.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.IR = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.IS = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }

    private void lL() {
        this.Ju = new FloatRecordView(getContext());
        this.Jv = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.Jw = new WindowManager.LayoutParams();
        this.Jw.type = FastRegActivity.EXTRA_PARAM_FROM_PASS_SDK_ENTER;
        this.Jw.format = 1;
        this.Jw.flags = 56;
        this.Jw.gravity = 17;
        this.Jw.x = 0;
        this.Jw.y = 0;
        this.Jw.width = getContext().getResources().getDimensionPixelSize(d.e.ds360);
        this.Jw.height = getContext().getResources().getDimensionPixelSize(d.e.ds360);
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
        if (this.Ju != null && this.Jv != null && this.Jw != null) {
            this.Ju.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.Ju != null && this.Jv != null && this.Jw != null) {
            this.Ju.closeRecordCancel();
            LinearLayout lB = this.Ju.lB();
            if (lB != null && lB.getParent() != null) {
                this.Jv.removeView(lB);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.Ju != null && this.Jv != null && this.Jw != null) {
            this.Ju.closeRecordTooShort();
            LinearLayout lA = this.Ju.lA();
            if (lA != null && lA.getParent() != null) {
                this.Jv.removeView(lA);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout lB;
        if (this.Ju != null && this.Jv != null && this.Jw != null && (lB = this.Ju.lB()) != null && lB.getParent() == null) {
            this.Jv.addView(lB, this.Jw);
            this.Ju.showRecordCancel();
        }
    }

    public void lC() {
        LinearLayout lA;
        if (this.Ju != null && this.Jv != null && this.Jw != null && (lA = this.Ju.lA()) != null && lA.getParent() == null) {
            this.Jv.addView(lA, this.Jw);
            this.Ju.lC();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout lz;
        if (this.Ju != null && this.Jv != null && this.Jw != null && (lz = this.Ju.lz()) != null && lz.getParent() == null) {
            this.Jv.addView(lz, this.Jw);
            this.Ju.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.Ju != null && this.Jv != null && this.Jw != null) {
            this.Ju.stopRecordVoice();
            LinearLayout lz = this.Ju.lz();
            if (lz != null && lz.getParent() != null) {
                this.Jv.removeView(lz);
            }
        }
    }
}
