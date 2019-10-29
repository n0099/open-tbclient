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
    private TextView DN;
    private FloatRecordView DO;
    private WindowManager DQ;
    private WindowManager.LayoutParams DR;
    private EditorTools Dl;
    private int Dm;

    public SendVoiceView(Context context) {
        super(context);
        this.DN = null;
        this.Dm = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.DN = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            lm();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.DN.setBackgroundResource(R.drawable.but_talk_s);
            this.DN.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.DN.setBackgroundResource(R.drawable.but_talk_n);
        this.DN.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void le() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Dm;
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
        if (this.Dl != null) {
            this.Dl.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Dl = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Dm = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }

    private void lm() {
        this.DO = new FloatRecordView(getContext());
        this.DQ = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.DR = new WindowManager.LayoutParams();
        this.DR.type = com.baidu.tieba.t.c.AH(2002);
        this.DR.format = 1;
        this.DR.flags = 56;
        this.DR.gravity = 17;
        this.DR.x = 0;
        this.DR.y = 0;
        this.DR.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.DR.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
                lc();
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
        if (this.DO != null && this.DQ != null && this.DR != null) {
            this.DO.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.DO != null && this.DQ != null && this.DR != null) {
            this.DO.closeRecordCancel();
            LinearLayout lb = this.DO.lb();
            if (lb != null && lb.getParent() != null) {
                this.DQ.removeView(lb);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.DO != null && this.DQ != null && this.DR != null) {
            this.DO.closeRecordTooShort();
            LinearLayout la = this.DO.la();
            if (la != null && la.getParent() != null) {
                this.DQ.removeView(la);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout lb;
        if (this.DO != null && this.DQ != null && this.DR != null && (lb = this.DO.lb()) != null && lb.getParent() == null) {
            this.DQ.addView(lb, this.DR);
            this.DO.showRecordCancel();
        }
    }

    public void lc() {
        LinearLayout la;
        if (this.DO != null && this.DQ != null && this.DR != null && (la = this.DO.la()) != null && la.getParent() == null) {
            this.DQ.addView(la, this.DR);
            this.DO.lc();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout kZ;
        if (this.DO != null && this.DQ != null && this.DR != null && (kZ = this.DO.kZ()) != null && kZ.getParent() == null) {
            this.DQ.addView(kZ, this.DR);
            this.DO.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.DO != null && this.DQ != null && this.DR != null) {
            this.DO.stopRecordVoice();
            LinearLayout kZ = this.DO.kZ();
            if (kZ != null && kZ.getParent() != null) {
                this.DQ.removeView(kZ);
            }
        }
    }
}
