package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.ak;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class SendVoiceView extends LinearLayout implements ab, ISendVoiceView, ak {
    private TextView BU;
    private int BV;
    private com.baidu.tbadk.editortools.l BW;
    private FloatRecordView BX;
    private WindowManager BY;
    private WindowManager.LayoutParams BZ;

    public SendVoiceView(Context context) {
        super(context);
        this.BU = null;
        this.BV = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(u.h.send_voice_view, this);
            this.BU = (TextView) findViewById(u.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            kG();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.BU.setBackgroundResource(u.f.but_talk_s);
            this.BU.setText(TbadkCoreApplication.m9getInst().getContext().getString(u.j.msglist_no_push));
            return;
        }
        this.BU.setBackgroundResource(u.f.but_talk_n);
        this.BU.setText(TbadkCoreApplication.m9getInst().getContext().getString(u.j.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void kF() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.BV;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.BW != null) {
            this.BW.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.BW = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.BV = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
    }

    private void kG() {
        this.BX = new FloatRecordView(getContext());
        this.BY = (WindowManager) TbadkCoreApplication.m9getInst().getContext().getSystemService("window");
        this.BZ = new WindowManager.LayoutParams();
        this.BZ.type = 2002;
        this.BZ.format = 1;
        this.BZ.flags = 56;
        this.BZ.gravity = 17;
        this.BZ.x = 0;
        this.BZ.y = 0;
        this.BZ.width = getContext().getResources().getDimensionPixelSize(u.e.ds360);
        this.BZ.height = getContext().getResources().getDimensionPixelSize(u.e.ds360);
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
                kA();
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
        if (this.BX != null && this.BY != null && this.BZ != null) {
            this.BX.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordCancel() {
        if (this.BX != null && this.BY != null && this.BZ != null) {
            this.BX.closeRecordCancel();
            LinearLayout kz = this.BX.kz();
            if (kz != null && kz.getParent() != null) {
                this.BY.removeView(kz);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordTooShort() {
        if (this.BX != null && this.BY != null && this.BZ != null) {
            this.BX.closeRecordTooShort();
            LinearLayout ky = this.BX.ky();
            if (ky != null && ky.getParent() != null) {
                this.BY.removeView(ky);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordCancel() {
        LinearLayout kz;
        if (this.BX != null && this.BY != null && this.BZ != null && (kz = this.BX.kz()) != null && kz.getParent() == null) {
            this.BY.addView(kz, this.BZ);
            this.BX.showRecordCancel();
        }
    }

    public void kA() {
        LinearLayout ky;
        if (this.BX != null && this.BY != null && this.BZ != null && (ky = this.BX.ky()) != null && ky.getParent() == null) {
            this.BY.addView(ky, this.BZ);
            this.BX.kA();
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void startRecordVoice() {
        LinearLayout kx;
        if (this.BX != null && this.BY != null && this.BZ != null && (kx = this.BX.kx()) != null && kx.getParent() == null) {
            this.BY.addView(kx, this.BZ);
            this.BX.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void stopRecordVoice() {
        if (this.BX != null && this.BY != null && this.BZ != null) {
            this.BX.stopRecordVoice();
            LinearLayout kx = this.BX.kx();
            if (kx != null && kx.getParent() != null) {
                this.BY.removeView(kx);
            }
        }
    }
}
