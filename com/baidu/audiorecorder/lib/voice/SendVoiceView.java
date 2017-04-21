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
/* loaded from: classes.dex */
public class SendVoiceView extends LinearLayout implements com.baidu.tbadk.editortools.y, ISendVoiceView, aj {
    private TextView KM;
    private int KN;
    private com.baidu.tbadk.editortools.j KO;
    private FloatRecordView KP;
    private WindowManager KQ;
    private WindowManager.LayoutParams KR;

    public SendVoiceView(Context context) {
        super(context);
        this.KM = null;
        this.KN = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(w.j.send_voice_view, this);
            this.KM = (TextView) findViewById(w.h.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            mq();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.KM.setBackgroundResource(w.g.but_talk_s);
            this.KM.setText(TbadkCoreApplication.m9getInst().getContext().getString(w.l.msglist_no_push));
            return;
        }
        this.KM.setBackgroundResource(w.g.but_talk_n);
        this.KM.setText(TbadkCoreApplication.m9getInst().getContext().getString(w.l.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void mp() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.KN;
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
        if (this.KO != null) {
            this.KO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.KO = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.KN = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
    }

    private void mq() {
        this.KP = new FloatRecordView(getContext());
        this.KQ = (WindowManager) TbadkCoreApplication.m9getInst().getContext().getSystemService("window");
        this.KR = new WindowManager.LayoutParams();
        this.KR.type = 2002;
        this.KR.format = 1;
        this.KR.flags = 56;
        this.KR.gravity = 17;
        this.KR.x = 0;
        this.KR.y = 0;
        this.KR.width = getContext().getResources().getDimensionPixelSize(w.f.ds360);
        this.KR.height = getContext().getResources().getDimensionPixelSize(w.f.ds360);
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
                ml();
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
        if (this.KP != null && this.KQ != null && this.KR != null) {
            this.KP.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordCancel() {
        if (this.KP != null && this.KQ != null && this.KR != null) {
            this.KP.closeRecordCancel();
            LinearLayout mk = this.KP.mk();
            if (mk != null && mk.getParent() != null) {
                this.KQ.removeView(mk);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordTooShort() {
        if (this.KP != null && this.KQ != null && this.KR != null) {
            this.KP.closeRecordTooShort();
            LinearLayout mj = this.KP.mj();
            if (mj != null && mj.getParent() != null) {
                this.KQ.removeView(mj);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void showRecordCancel() {
        LinearLayout mk;
        if (this.KP != null && this.KQ != null && this.KR != null && (mk = this.KP.mk()) != null && mk.getParent() == null) {
            this.KQ.addView(mk, this.KR);
            this.KP.showRecordCancel();
        }
    }

    public void ml() {
        LinearLayout mj;
        if (this.KP != null && this.KQ != null && this.KR != null && (mj = this.KP.mj()) != null && mj.getParent() == null) {
            this.KQ.addView(mj, this.KR);
            this.KP.ml();
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void startRecordVoice() {
        LinearLayout mi;
        if (this.KP != null && this.KQ != null && this.KR != null && (mi = this.KP.mi()) != null && mi.getParent() == null) {
            this.KQ.addView(mi, this.KR);
            this.KP.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void stopRecordVoice() {
        if (this.KP != null && this.KQ != null && this.KR != null) {
            this.KP.stopRecordVoice();
            LinearLayout mi = this.KP.mi();
            if (mi != null && mi.getParent() != null) {
                this.KQ.removeView(mi);
            }
        }
    }
}
