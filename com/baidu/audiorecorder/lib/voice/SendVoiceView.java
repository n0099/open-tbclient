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
    private TextView Cu;
    private int Cv;
    private com.baidu.tbadk.editortools.l Cw;
    private FloatRecordView Cx;
    private WindowManager Cy;
    private WindowManager.LayoutParams Cz;

    public SendVoiceView(Context context) {
        super(context);
        this.Cu = null;
        this.Cv = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(u.h.send_voice_view, this);
            this.Cu = (TextView) findViewById(u.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            kC();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.Cu.setBackgroundResource(u.f.but_talk_s);
            this.Cu.setText(TbadkCoreApplication.m10getInst().getContext().getString(u.j.msglist_no_push));
            return;
        }
        this.Cu.setBackgroundResource(u.f.but_talk_n);
        this.Cu.setText(TbadkCoreApplication.m10getInst().getContext().getString(u.j.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void kB() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.Cv;
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
        if (this.Cw != null) {
            this.Cw.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.Cw = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.Cv = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
    }

    private void kC() {
        this.Cx = new FloatRecordView(getContext());
        this.Cy = (WindowManager) TbadkCoreApplication.m10getInst().getContext().getSystemService("window");
        this.Cz = new WindowManager.LayoutParams();
        this.Cz.type = 2002;
        this.Cz.format = 1;
        this.Cz.flags = 56;
        this.Cz.gravity = 17;
        this.Cz.x = 0;
        this.Cz.y = 0;
        this.Cz.width = getContext().getResources().getDimensionPixelSize(u.e.ds360);
        this.Cz.height = getContext().getResources().getDimensionPixelSize(u.e.ds360);
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
                kw();
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
        if (this.Cx != null && this.Cy != null && this.Cz != null) {
            this.Cx.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordCancel() {
        if (this.Cx != null && this.Cy != null && this.Cz != null) {
            this.Cx.closeRecordCancel();
            LinearLayout kv = this.Cx.kv();
            if (kv != null && kv.getParent() != null) {
                this.Cy.removeView(kv);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordTooShort() {
        if (this.Cx != null && this.Cy != null && this.Cz != null) {
            this.Cx.closeRecordTooShort();
            LinearLayout ku = this.Cx.ku();
            if (ku != null && ku.getParent() != null) {
                this.Cy.removeView(ku);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordCancel() {
        LinearLayout kv;
        if (this.Cx != null && this.Cy != null && this.Cz != null && (kv = this.Cx.kv()) != null && kv.getParent() == null) {
            this.Cy.addView(kv, this.Cz);
            this.Cx.showRecordCancel();
        }
    }

    public void kw() {
        LinearLayout ku;
        if (this.Cx != null && this.Cy != null && this.Cz != null && (ku = this.Cx.ku()) != null && ku.getParent() == null) {
            this.Cy.addView(ku, this.Cz);
            this.Cx.kw();
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void startRecordVoice() {
        LinearLayout kt;
        if (this.Cx != null && this.Cy != null && this.Cz != null && (kt = this.Cx.kt()) != null && kt.getParent() == null) {
            this.Cy.addView(kt, this.Cz);
            this.Cx.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void stopRecordVoice() {
        if (this.Cx != null && this.Cy != null && this.Cz != null) {
            this.Cx.stopRecordVoice();
            LinearLayout kt = this.Cx.kt();
            if (kt != null && kt.getParent() != null) {
                this.Cy.removeView(kt);
            }
        }
    }
}
