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
    private i axN;
    private int axO;
    private TextView ayo;
    private FloatRecordView ayp;
    private WindowManager ayq;
    private WindowManager.LayoutParams ayr;

    public SendVoiceView(Context context) {
        super(context);
        this.ayo = null;
        this.axO = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(d.h.send_voice_view, this);
            this.ayo = (TextView) findViewById(d.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            to();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.ayo.setBackgroundResource(d.f.but_talk_s);
            this.ayo.setText(TbadkCoreApplication.getInst().getContext().getString(d.j.msglist_no_push));
            return;
        }
        this.ayo.setBackgroundResource(d.f.but_talk_n);
        this.ayo.setText(TbadkCoreApplication.getInst().getContext().getString(d.j.msglist_push_talk));
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
        return this.axO;
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
        if (this.axN != null) {
            this.axN.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axN = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axO = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }

    private void to() {
        this.ayp = new FloatRecordView(getContext());
        this.ayq = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.ayr = new WindowManager.LayoutParams();
        this.ayr.type = 2002;
        this.ayr.format = 1;
        this.ayr.flags = 56;
        this.ayr.gravity = 17;
        this.ayr.x = 0;
        this.ayr.y = 0;
        this.ayr.width = getContext().getResources().getDimensionPixelSize(d.e.ds360);
        this.ayr.height = getContext().getResources().getDimensionPixelSize(d.e.ds360);
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
        if (this.ayp != null && this.ayq != null && this.ayr != null) {
            this.ayp.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.ayp != null && this.ayq != null && this.ayr != null) {
            this.ayp.closeRecordCancel();
            LinearLayout te = this.ayp.te();
            if (te != null && te.getParent() != null) {
                this.ayq.removeView(te);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.ayp != null && this.ayq != null && this.ayr != null) {
            this.ayp.closeRecordTooShort();
            LinearLayout td = this.ayp.td();
            if (td != null && td.getParent() != null) {
                this.ayq.removeView(td);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout te;
        if (this.ayp != null && this.ayq != null && this.ayr != null && (te = this.ayp.te()) != null && te.getParent() == null) {
            this.ayq.addView(te, this.ayr);
            this.ayp.showRecordCancel();
        }
    }

    public void tf() {
        LinearLayout td;
        if (this.ayp != null && this.ayq != null && this.ayr != null && (td = this.ayp.td()) != null && td.getParent() == null) {
            this.ayq.addView(td, this.ayr);
            this.ayp.tf();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout tc;
        if (this.ayp != null && this.ayq != null && this.ayr != null && (tc = this.ayp.tc()) != null && tc.getParent() == null) {
            this.ayq.addView(tc, this.ayr);
            this.ayp.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.ayp != null && this.ayq != null && this.ayr != null) {
            this.ayp.stopRecordVoice();
            LinearLayout tc = this.ayp.tc();
            if (tc != null && tc.getParent() != null) {
                this.ayq.removeView(tc);
            }
        }
    }
}
