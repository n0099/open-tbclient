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
    private i axH;
    private int axI;
    private TextView ayi;
    private FloatRecordView ayj;
    private WindowManager ayk;
    private WindowManager.LayoutParams ayl;

    public SendVoiceView(Context context) {
        super(context);
        this.ayi = null;
        this.axI = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(d.h.send_voice_view, this);
            this.ayi = (TextView) findViewById(d.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            to();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.ayi.setBackgroundResource(d.f.but_talk_s);
            this.ayi.setText(TbadkCoreApplication.getInst().getContext().getString(d.j.msglist_no_push));
            return;
        }
        this.ayi.setBackgroundResource(d.f.but_talk_n);
        this.ayi.setText(TbadkCoreApplication.getInst().getContext().getString(d.j.msglist_push_talk));
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
        return this.axI;
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
        if (this.axH != null) {
            this.axH.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axH = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axI = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }

    private void to() {
        this.ayj = new FloatRecordView(getContext());
        this.ayk = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.ayl = new WindowManager.LayoutParams();
        this.ayl.type = 2002;
        this.ayl.format = 1;
        this.ayl.flags = 56;
        this.ayl.gravity = 17;
        this.ayl.x = 0;
        this.ayl.y = 0;
        this.ayl.width = getContext().getResources().getDimensionPixelSize(d.e.ds360);
        this.ayl.height = getContext().getResources().getDimensionPixelSize(d.e.ds360);
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
        if (this.ayj != null && this.ayk != null && this.ayl != null) {
            this.ayj.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.ayj != null && this.ayk != null && this.ayl != null) {
            this.ayj.closeRecordCancel();
            LinearLayout te = this.ayj.te();
            if (te != null && te.getParent() != null) {
                this.ayk.removeView(te);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.ayj != null && this.ayk != null && this.ayl != null) {
            this.ayj.closeRecordTooShort();
            LinearLayout td = this.ayj.td();
            if (td != null && td.getParent() != null) {
                this.ayk.removeView(td);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout te;
        if (this.ayj != null && this.ayk != null && this.ayl != null && (te = this.ayj.te()) != null && te.getParent() == null) {
            this.ayk.addView(te, this.ayl);
            this.ayj.showRecordCancel();
        }
    }

    public void tf() {
        LinearLayout td;
        if (this.ayj != null && this.ayk != null && this.ayl != null && (td = this.ayj.td()) != null && td.getParent() == null) {
            this.ayk.addView(td, this.ayl);
            this.ayj.tf();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout tc;
        if (this.ayj != null && this.ayk != null && this.ayl != null && (tc = this.ayj.tc()) != null && tc.getParent() == null) {
            this.ayk.addView(tc, this.ayl);
            this.ayj.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.ayj != null && this.ayk != null && this.ayl != null) {
            this.ayj.stopRecordVoice();
            LinearLayout tc = this.ayj.tc();
            if (tc != null && tc.getParent() != null) {
                this.ayk.removeView(tc);
            }
        }
    }
}
