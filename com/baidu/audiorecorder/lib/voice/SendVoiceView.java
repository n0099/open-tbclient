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
    private TextView Lj;
    private int Lk;
    private com.baidu.tbadk.editortools.j Ll;
    private FloatRecordView Lm;
    private WindowManager Ln;
    private WindowManager.LayoutParams Lo;

    public SendVoiceView(Context context) {
        super(context);
        this.Lj = null;
        this.Lk = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(w.j.send_voice_view, this);
            this.Lj = (TextView) findViewById(w.h.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            mm();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.Lj.setBackgroundResource(w.g.but_talk_s);
            this.Lj.setText(TbadkCoreApplication.m9getInst().getContext().getString(w.l.msglist_no_push));
            return;
        }
        this.Lj.setBackgroundResource(w.g.but_talk_n);
        this.Lj.setText(TbadkCoreApplication.m9getInst().getContext().getString(w.l.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void ml() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.Lk;
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
        if (this.Ll != null) {
            this.Ll.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.Ll = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.Lk = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
    }

    private void mm() {
        this.Lm = new FloatRecordView(getContext());
        this.Ln = (WindowManager) TbadkCoreApplication.m9getInst().getContext().getSystemService("window");
        this.Lo = new WindowManager.LayoutParams();
        this.Lo.type = 2002;
        this.Lo.format = 1;
        this.Lo.flags = 56;
        this.Lo.gravity = 17;
        this.Lo.x = 0;
        this.Lo.y = 0;
        this.Lo.width = getContext().getResources().getDimensionPixelSize(w.f.ds360);
        this.Lo.height = getContext().getResources().getDimensionPixelSize(w.f.ds360);
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
                mg();
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
        if (this.Lm != null && this.Ln != null && this.Lo != null) {
            this.Lm.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordCancel() {
        if (this.Lm != null && this.Ln != null && this.Lo != null) {
            this.Lm.closeRecordCancel();
            LinearLayout mf = this.Lm.mf();
            if (mf != null && mf.getParent() != null) {
                this.Ln.removeView(mf);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordTooShort() {
        if (this.Lm != null && this.Ln != null && this.Lo != null) {
            this.Lm.closeRecordTooShort();
            LinearLayout me = this.Lm.me();
            if (me != null && me.getParent() != null) {
                this.Ln.removeView(me);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void showRecordCancel() {
        LinearLayout mf;
        if (this.Lm != null && this.Ln != null && this.Lo != null && (mf = this.Lm.mf()) != null && mf.getParent() == null) {
            this.Ln.addView(mf, this.Lo);
            this.Lm.showRecordCancel();
        }
    }

    public void mg() {
        LinearLayout me;
        if (this.Lm != null && this.Ln != null && this.Lo != null && (me = this.Lm.me()) != null && me.getParent() == null) {
            this.Ln.addView(me, this.Lo);
            this.Lm.mg();
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void startRecordVoice() {
        LinearLayout md;
        if (this.Lm != null && this.Ln != null && this.Lo != null && (md = this.Lm.md()) != null && md.getParent() == null) {
            this.Ln.addView(md, this.Lo);
            this.Lm.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void stopRecordVoice() {
        if (this.Lm != null && this.Ln != null && this.Lo != null) {
            this.Lm.stopRecordVoice();
            LinearLayout md = this.Lm.md();
            if (md != null && md.getParent() != null) {
                this.Ln.removeView(md);
            }
        }
    }
}
