package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.ISendVoiceView;
/* loaded from: classes6.dex */
public class SendVoiceView extends LinearLayout implements l, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private EditorTools TU;
    private int TV;
    private TextView Uv;
    private FloatRecordView Uw;
    private WindowManager Ux;
    private WindowManager.LayoutParams Uy;

    public SendVoiceView(Context context) {
        super(context);
        this.Uv = null;
        this.TV = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.Uv = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            qs();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.Uv.setBackgroundResource(R.drawable.but_talk_s);
            this.Uv.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.Uv.setBackgroundResource(R.drawable.but_talk_n);
        this.Uv.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void qk() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TV;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TU != null) {
            this.TU.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TU = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TV = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }

    private void qs() {
        this.Uw = new FloatRecordView(getContext());
        this.Ux = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.Uy = new WindowManager.LayoutParams();
        this.Uy.type = com.baidu.tieba.t.c.BV(2002);
        this.Uy.format = 1;
        this.Uy.flags = 56;
        this.Uy.gravity = 17;
        this.Uy.x = 0;
        this.Uy.y = 0;
        this.Uy.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.Uy.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
                qi();
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
        if (this.Uw != null && this.Ux != null && this.Uy != null) {
            this.Uw.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.Uw != null && this.Ux != null && this.Uy != null) {
            this.Uw.closeRecordCancel();
            LinearLayout qh = this.Uw.qh();
            if (qh != null && qh.getParent() != null) {
                this.Ux.removeView(qh);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.Uw != null && this.Ux != null && this.Uy != null) {
            this.Uw.closeRecordTooShort();
            LinearLayout qg = this.Uw.qg();
            if (qg != null && qg.getParent() != null) {
                this.Ux.removeView(qg);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout qh;
        if (this.Uw != null && this.Ux != null && this.Uy != null && (qh = this.Uw.qh()) != null && qh.getParent() == null) {
            this.Ux.addView(qh, this.Uy);
            this.Uw.showRecordCancel();
        }
    }

    public void qi() {
        LinearLayout qg;
        if (this.Uw != null && this.Ux != null && this.Uy != null && (qg = this.Uw.qg()) != null && qg.getParent() == null) {
            this.Ux.addView(qg, this.Uy);
            this.Uw.qi();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout qf;
        if (this.Uw != null && this.Ux != null && this.Uy != null && (qf = this.Uw.qf()) != null && qf.getParent() == null) {
            this.Ux.addView(qf, this.Uy);
            this.Uw.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.Uw != null && this.Ux != null && this.Uy != null) {
            this.Uw.stopRecordVoice();
            LinearLayout qf = this.Uw.qf();
            if (qf != null && qf.getParent() != null) {
                this.Ux.removeView(qf);
            }
        }
    }
}
