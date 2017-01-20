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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class SendVoiceView extends LinearLayout implements com.baidu.tbadk.editortools.y, ISendVoiceView, aj {
    private TextView DV;
    private int DW;
    private com.baidu.tbadk.editortools.j DX;
    private FloatRecordView DY;
    private WindowManager DZ;
    private WindowManager.LayoutParams Ea;

    public SendVoiceView(Context context) {
        super(context);
        this.DV = null;
        this.DW = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(r.j.send_voice_view, this);
            this.DV = (TextView) findViewById(r.h.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            ls();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.DV.setBackgroundResource(r.g.but_talk_s);
            this.DV.setText(TbadkCoreApplication.m9getInst().getContext().getString(r.l.msglist_no_push));
            return;
        }
        this.DV.setBackgroundResource(r.g.but_talk_n);
        this.DV.setText(TbadkCoreApplication.m9getInst().getContext().getString(r.l.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lr() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.DW;
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
        if (this.DX != null) {
            this.DX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.DX = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.DW = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
    }

    private void ls() {
        this.DY = new FloatRecordView(getContext());
        this.DZ = (WindowManager) TbadkCoreApplication.m9getInst().getContext().getSystemService("window");
        this.Ea = new WindowManager.LayoutParams();
        this.Ea.type = 2002;
        this.Ea.format = 1;
        this.Ea.flags = 56;
        this.Ea.gravity = 17;
        this.Ea.x = 0;
        this.Ea.y = 0;
        this.Ea.width = getContext().getResources().getDimensionPixelSize(r.f.ds360);
        this.Ea.height = getContext().getResources().getDimensionPixelSize(r.f.ds360);
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
                lm();
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
        if (this.DY != null && this.DZ != null && this.Ea != null) {
            this.DY.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordCancel() {
        if (this.DY != null && this.DZ != null && this.Ea != null) {
            this.DY.closeRecordCancel();
            LinearLayout ll = this.DY.ll();
            if (ll != null && ll.getParent() != null) {
                this.DZ.removeView(ll);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordTooShort() {
        if (this.DY != null && this.DZ != null && this.Ea != null) {
            this.DY.closeRecordTooShort();
            LinearLayout lk = this.DY.lk();
            if (lk != null && lk.getParent() != null) {
                this.DZ.removeView(lk);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void showRecordCancel() {
        LinearLayout ll;
        if (this.DY != null && this.DZ != null && this.Ea != null && (ll = this.DY.ll()) != null && ll.getParent() == null) {
            this.DZ.addView(ll, this.Ea);
            this.DY.showRecordCancel();
        }
    }

    public void lm() {
        LinearLayout lk;
        if (this.DY != null && this.DZ != null && this.Ea != null && (lk = this.DY.lk()) != null && lk.getParent() == null) {
            this.DZ.addView(lk, this.Ea);
            this.DY.lm();
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void startRecordVoice() {
        LinearLayout lj;
        if (this.DY != null && this.DZ != null && this.Ea != null && (lj = this.DY.lj()) != null && lj.getParent() == null) {
            this.DZ.addView(lj, this.Ea);
            this.DY.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void stopRecordVoice() {
        if (this.DY != null && this.DZ != null && this.Ea != null) {
            this.DY.stopRecordVoice();
            LinearLayout lj = this.DY.lj();
            if (lj != null && lj.getParent() != null) {
                this.DZ.removeView(lj);
            }
        }
    }
}
