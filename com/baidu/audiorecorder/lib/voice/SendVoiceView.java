package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.ISendVoiceView;
/* loaded from: classes24.dex */
public class SendVoiceView extends LinearLayout implements n, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private TextView acM;
    private FloatRecordView acN;
    private WindowManager acO;
    private WindowManager.LayoutParams acP;
    private EditorTools acn;
    private int aco;

    public SendVoiceView(Context context) {
        super(context);
        this.acM = null;
        this.aco = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.acM = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            sC();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.acM.setBackgroundResource(R.drawable.but_talk_s);
            this.acM.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.acM.setBackgroundResource(R.drawable.but_talk_n);
        this.acM.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void su() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aco;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acn != null) {
            this.acn.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acn = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aco = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }

    private void sC() {
        this.acN = new FloatRecordView(getContext());
        this.acO = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.acP = new WindowManager.LayoutParams();
        this.acP.type = com.baidu.tieba.w.c.LQ(2002);
        this.acP.format = 1;
        this.acP.flags = 56;
        this.acP.gravity = 17;
        this.acP.x = 0;
        this.acP.y = 0;
        this.acP.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.acP.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
                ss();
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
        if (this.acN != null && this.acO != null && this.acP != null) {
            this.acN.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.acN != null && this.acO != null && this.acP != null) {
            this.acN.closeRecordCancel();
            LinearLayout sr = this.acN.sr();
            if (sr != null && sr.getParent() != null) {
                this.acO.removeView(sr);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.acN != null && this.acO != null && this.acP != null) {
            this.acN.closeRecordTooShort();
            LinearLayout sq = this.acN.sq();
            if (sq != null && sq.getParent() != null) {
                this.acO.removeView(sq);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout sr;
        if (this.acN != null && this.acO != null && this.acP != null && (sr = this.acN.sr()) != null && sr.getParent() == null) {
            this.acO.addView(sr, this.acP);
            this.acN.showRecordCancel();
        }
    }

    public void ss() {
        LinearLayout sq;
        if (this.acN != null && this.acO != null && this.acP != null && (sq = this.acN.sq()) != null && sq.getParent() == null) {
            this.acO.addView(sq, this.acP);
            this.acN.ss();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout sp;
        if (this.acN != null && this.acO != null && this.acP != null && (sp = this.acN.sp()) != null && sp.getParent() == null) {
            this.acO.addView(sp, this.acP);
            this.acN.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.acN != null && this.acO != null && this.acP != null) {
            this.acN.stopRecordVoice();
            LinearLayout sp = this.acN.sp();
            if (sp != null && sp.getParent() != null) {
                this.acO.removeView(sp);
            }
        }
    }
}
