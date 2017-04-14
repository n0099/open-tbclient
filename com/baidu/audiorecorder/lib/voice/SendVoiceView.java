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
    private TextView KK;
    private int KL;
    private com.baidu.tbadk.editortools.j KM;
    private FloatRecordView KN;
    private WindowManager KO;
    private WindowManager.LayoutParams KP;

    public SendVoiceView(Context context) {
        super(context);
        this.KK = null;
        this.KL = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(w.j.send_voice_view, this);
            this.KK = (TextView) findViewById(w.h.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            mq();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.KK.setBackgroundResource(w.g.but_talk_s);
            this.KK.setText(TbadkCoreApplication.m9getInst().getContext().getString(w.l.msglist_no_push));
            return;
        }
        this.KK.setBackgroundResource(w.g.but_talk_n);
        this.KK.setText(TbadkCoreApplication.m9getInst().getContext().getString(w.l.msglist_push_talk));
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
        return this.KL;
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
        if (this.KM != null) {
            this.KM.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.KM = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.KL = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
    }

    private void mq() {
        this.KN = new FloatRecordView(getContext());
        this.KO = (WindowManager) TbadkCoreApplication.m9getInst().getContext().getSystemService("window");
        this.KP = new WindowManager.LayoutParams();
        this.KP.type = 2002;
        this.KP.format = 1;
        this.KP.flags = 56;
        this.KP.gravity = 17;
        this.KP.x = 0;
        this.KP.y = 0;
        this.KP.width = getContext().getResources().getDimensionPixelSize(w.f.ds360);
        this.KP.height = getContext().getResources().getDimensionPixelSize(w.f.ds360);
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
                mk();
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
        if (this.KN != null && this.KO != null && this.KP != null) {
            this.KN.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordCancel() {
        if (this.KN != null && this.KO != null && this.KP != null) {
            this.KN.closeRecordCancel();
            LinearLayout mj = this.KN.mj();
            if (mj != null && mj.getParent() != null) {
                this.KO.removeView(mj);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordTooShort() {
        if (this.KN != null && this.KO != null && this.KP != null) {
            this.KN.closeRecordTooShort();
            LinearLayout mi = this.KN.mi();
            if (mi != null && mi.getParent() != null) {
                this.KO.removeView(mi);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void showRecordCancel() {
        LinearLayout mj;
        if (this.KN != null && this.KO != null && this.KP != null && (mj = this.KN.mj()) != null && mj.getParent() == null) {
            this.KO.addView(mj, this.KP);
            this.KN.showRecordCancel();
        }
    }

    public void mk() {
        LinearLayout mi;
        if (this.KN != null && this.KO != null && this.KP != null && (mi = this.KN.mi()) != null && mi.getParent() == null) {
            this.KO.addView(mi, this.KP);
            this.KN.mk();
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void startRecordVoice() {
        LinearLayout mh;
        if (this.KN != null && this.KO != null && this.KP != null && (mh = this.KN.mh()) != null && mh.getParent() == null) {
            this.KO.addView(mh, this.KP);
            this.KN.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void stopRecordVoice() {
        if (this.KN != null && this.KO != null && this.KP != null) {
            this.KN.stopRecordVoice();
            LinearLayout mh = this.KN.mh();
            if (mh != null && mh.getParent() != null) {
                this.KO.removeView(mh);
            }
        }
    }
}
