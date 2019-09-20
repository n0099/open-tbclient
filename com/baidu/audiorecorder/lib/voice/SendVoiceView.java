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
    private EditorTools TT;
    private int TU;
    private TextView Uu;
    private FloatRecordView Uv;
    private WindowManager Uw;
    private WindowManager.LayoutParams Ux;

    public SendVoiceView(Context context) {
        super(context);
        this.Uu = null;
        this.TU = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.Uu = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            qt();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.Uu.setBackgroundResource(R.drawable.but_talk_s);
            this.Uu.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.Uu.setBackgroundResource(R.drawable.but_talk_n);
        this.Uu.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void ql() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TU;
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
        if (this.TT != null) {
            this.TT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TT = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TU = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }

    private void qt() {
        this.Uv = new FloatRecordView(getContext());
        this.Uw = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.Ux = new WindowManager.LayoutParams();
        this.Ux.type = com.baidu.tieba.t.c.Cb(2002);
        this.Ux.format = 1;
        this.Ux.flags = 56;
        this.Ux.gravity = 17;
        this.Ux.x = 0;
        this.Ux.y = 0;
        this.Ux.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.Ux.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
                qj();
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
        if (this.Uv != null && this.Uw != null && this.Ux != null) {
            this.Uv.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.Uv != null && this.Uw != null && this.Ux != null) {
            this.Uv.closeRecordCancel();
            LinearLayout qi = this.Uv.qi();
            if (qi != null && qi.getParent() != null) {
                this.Uw.removeView(qi);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.Uv != null && this.Uw != null && this.Ux != null) {
            this.Uv.closeRecordTooShort();
            LinearLayout qh = this.Uv.qh();
            if (qh != null && qh.getParent() != null) {
                this.Uw.removeView(qh);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout qi;
        if (this.Uv != null && this.Uw != null && this.Ux != null && (qi = this.Uv.qi()) != null && qi.getParent() == null) {
            this.Uw.addView(qi, this.Ux);
            this.Uv.showRecordCancel();
        }
    }

    public void qj() {
        LinearLayout qh;
        if (this.Uv != null && this.Uw != null && this.Ux != null && (qh = this.Uv.qh()) != null && qh.getParent() == null) {
            this.Uw.addView(qh, this.Ux);
            this.Uv.qj();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout qg;
        if (this.Uv != null && this.Uw != null && this.Ux != null && (qg = this.Uv.qg()) != null && qg.getParent() == null) {
            this.Uw.addView(qg, this.Ux);
            this.Uv.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.Uv != null && this.Uw != null && this.Ux != null) {
            this.Uv.stopRecordVoice();
            LinearLayout qg = this.Uv.qg();
            if (qg != null && qg.getParent() != null) {
                this.Uw.removeView(qg);
            }
        }
    }
}
