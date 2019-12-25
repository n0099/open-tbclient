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
/* loaded from: classes8.dex */
public class SendVoiceView extends LinearLayout implements m, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private TextView FO;
    private FloatRecordView FP;
    private WindowManager FQ;
    private WindowManager.LayoutParams FR;
    private EditorTools Fq;
    private int Fr;

    public SendVoiceView(Context context) {
        super(context);
        this.FO = null;
        this.Fr = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.FO = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            lE();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.FO.setBackgroundResource(R.drawable.but_talk_s);
            this.FO.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.FO.setBackgroundResource(R.drawable.but_talk_n);
        this.FO.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void lw() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Fr;
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
        if (this.Fq != null) {
            this.Fq.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Fq = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Fr = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
    }

    private void lE() {
        this.FP = new FloatRecordView(getContext());
        this.FQ = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.FR = new WindowManager.LayoutParams();
        this.FR.type = com.baidu.tieba.u.c.Db(2002);
        this.FR.format = 1;
        this.FR.flags = 56;
        this.FR.gravity = 17;
        this.FR.x = 0;
        this.FR.y = 0;
        this.FR.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.FR.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
                lu();
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
        if (this.FP != null && this.FQ != null && this.FR != null) {
            this.FP.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.FP != null && this.FQ != null && this.FR != null) {
            this.FP.closeRecordCancel();
            LinearLayout lt = this.FP.lt();
            if (lt != null && lt.getParent() != null) {
                this.FQ.removeView(lt);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.FP != null && this.FQ != null && this.FR != null) {
            this.FP.closeRecordTooShort();
            LinearLayout ls = this.FP.ls();
            if (ls != null && ls.getParent() != null) {
                this.FQ.removeView(ls);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout lt;
        if (this.FP != null && this.FQ != null && this.FR != null && (lt = this.FP.lt()) != null && lt.getParent() == null) {
            this.FQ.addView(lt, this.FR);
            this.FP.showRecordCancel();
        }
    }

    public void lu() {
        LinearLayout ls;
        if (this.FP != null && this.FQ != null && this.FR != null && (ls = this.FP.ls()) != null && ls.getParent() == null) {
            this.FQ.addView(ls, this.FR);
            this.FP.lu();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout lr;
        if (this.FP != null && this.FQ != null && this.FR != null && (lr = this.FP.lr()) != null && lr.getParent() == null) {
            this.FQ.addView(lr, this.FR);
            this.FP.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.FP != null && this.FQ != null && this.FR != null) {
            this.FP.stopRecordVoice();
            LinearLayout lr = this.FP.lr();
            if (lr != null && lr.getParent() != null) {
                this.FQ.removeView(lr);
            }
        }
    }
}
