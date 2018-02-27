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
    private i axG;
    private int axH;
    private TextView ayh;
    private FloatRecordView ayi;
    private WindowManager ayj;
    private WindowManager.LayoutParams ayk;

    public SendVoiceView(Context context) {
        super(context);
        this.ayh = null;
        this.axH = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(d.h.send_voice_view, this);
            this.ayh = (TextView) findViewById(d.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            to();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.ayh.setBackgroundResource(d.f.but_talk_s);
            this.ayh.setText(TbadkCoreApplication.getInst().getContext().getString(d.j.msglist_no_push));
            return;
        }
        this.ayh.setBackgroundResource(d.f.but_talk_n);
        this.ayh.setText(TbadkCoreApplication.getInst().getContext().getString(d.j.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axH;
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
        if (this.axG != null) {
            this.axG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axG = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axH = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }

    private void to() {
        this.ayi = new FloatRecordView(getContext());
        this.ayj = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.ayk = new WindowManager.LayoutParams();
        this.ayk.type = 2002;
        this.ayk.format = 1;
        this.ayk.flags = 56;
        this.ayk.gravity = 17;
        this.ayk.x = 0;
        this.ayk.y = 0;
        this.ayk.width = getContext().getResources().getDimensionPixelSize(d.e.ds360);
        this.ayk.height = getContext().getResources().getDimensionPixelSize(d.e.ds360);
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
                tf();
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
        if (this.ayi != null && this.ayj != null && this.ayk != null) {
            this.ayi.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.ayi != null && this.ayj != null && this.ayk != null) {
            this.ayi.closeRecordCancel();
            LinearLayout te = this.ayi.te();
            if (te != null && te.getParent() != null) {
                this.ayj.removeView(te);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.ayi != null && this.ayj != null && this.ayk != null) {
            this.ayi.closeRecordTooShort();
            LinearLayout td = this.ayi.td();
            if (td != null && td.getParent() != null) {
                this.ayj.removeView(td);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout te;
        if (this.ayi != null && this.ayj != null && this.ayk != null && (te = this.ayi.te()) != null && te.getParent() == null) {
            this.ayj.addView(te, this.ayk);
            this.ayi.showRecordCancel();
        }
    }

    public void tf() {
        LinearLayout td;
        if (this.ayi != null && this.ayj != null && this.ayk != null && (td = this.ayi.td()) != null && td.getParent() == null) {
            this.ayj.addView(td, this.ayk);
            this.ayi.tf();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout tc;
        if (this.ayi != null && this.ayj != null && this.ayk != null && (tc = this.ayi.tc()) != null && tc.getParent() == null) {
            this.ayj.addView(tc, this.ayk);
            this.ayi.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.ayi != null && this.ayj != null && this.ayk != null) {
            this.ayi.stopRecordVoice();
            LinearLayout tc = this.ayi.tc();
            if (tc != null && tc.getParent() != null) {
                this.ayj.removeView(tc);
            }
        }
    }
}
