package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.ISendVoiceView;
/* loaded from: classes11.dex */
public class SendVoiceView extends LinearLayout implements m, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private EditorTools FO;
    private int FP;
    private TextView Gn;
    private FloatRecordView Go;
    private WindowManager Gp;
    private WindowManager.LayoutParams Gq;

    public SendVoiceView(Context context) {
        super(context);
        this.Gn = null;
        this.FP = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.Gn = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            lT();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.Gn.setBackgroundResource(R.drawable.but_talk_s);
            this.Gn.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.Gn.setBackgroundResource(R.drawable.but_talk_n);
        this.Gn.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.FP;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.FO != null) {
            this.FO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.FO = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.FP = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
    }

    private void lT() {
        this.Go = new FloatRecordView(getContext());
        this.Gp = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.Gq = new WindowManager.LayoutParams();
        this.Gq.type = com.baidu.tieba.v.c.Dn(2002);
        this.Gq.format = 1;
        this.Gq.flags = 56;
        this.Gq.gravity = 17;
        this.Gq.x = 0;
        this.Gq.y = 0;
        this.Gq.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.Gq.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
                lK();
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
        if (this.Go != null && this.Gp != null && this.Gq != null) {
            this.Go.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.Go != null && this.Gp != null && this.Gq != null) {
            this.Go.closeRecordCancel();
            LinearLayout lJ = this.Go.lJ();
            if (lJ != null && lJ.getParent() != null) {
                this.Gp.removeView(lJ);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.Go != null && this.Gp != null && this.Gq != null) {
            this.Go.closeRecordTooShort();
            LinearLayout lI = this.Go.lI();
            if (lI != null && lI.getParent() != null) {
                this.Gp.removeView(lI);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout lJ;
        if (this.Go != null && this.Gp != null && this.Gq != null && (lJ = this.Go.lJ()) != null && lJ.getParent() == null) {
            this.Gp.addView(lJ, this.Gq);
            this.Go.showRecordCancel();
        }
    }

    public void lK() {
        LinearLayout lI;
        if (this.Go != null && this.Gp != null && this.Gq != null && (lI = this.Go.lI()) != null && lI.getParent() == null) {
            this.Gp.addView(lI, this.Gq);
            this.Go.lK();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout lH;
        if (this.Go != null && this.Gp != null && this.Gq != null && (lH = this.Go.lH()) != null && lH.getParent() == null) {
            this.Gp.addView(lH, this.Gq);
            this.Go.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.Go != null && this.Gp != null && this.Gq != null) {
            this.Go.stopRecordVoice();
            LinearLayout lH = this.Go.lH();
            if (lH != null && lH.getParent() != null) {
                this.Gp.removeView(lH);
            }
        }
    }
}
