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
    private EditorTools CJ;
    private int CK;
    private TextView Dm;
    private FloatRecordView Dn;
    private WindowManager Do;
    private WindowManager.LayoutParams Dp;

    public SendVoiceView(Context context) {
        super(context);
        this.Dm = null;
        this.CK = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.Dm = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            lm();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.Dm.setBackgroundResource(R.drawable.but_talk_s);
            this.Dm.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.Dm.setBackgroundResource(R.drawable.but_talk_n);
        this.Dm.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
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
        return this.CK;
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
        if (this.CJ != null) {
            this.CJ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.CJ = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.CK = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }

    private void lm() {
        this.Dn = new FloatRecordView(getContext());
        this.Do = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.Dp = new WindowManager.LayoutParams();
        this.Dp.type = com.baidu.tieba.t.c.AG(2002);
        this.Dp.format = 1;
        this.Dp.flags = 56;
        this.Dp.gravity = 17;
        this.Dp.x = 0;
        this.Dp.y = 0;
        this.Dp.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.Dp.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
        if (this.Dn != null && this.Do != null && this.Dp != null) {
            this.Dn.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.Dn != null && this.Do != null && this.Dp != null) {
            this.Dn.closeRecordCancel();
            LinearLayout lb = this.Dn.lb();
            if (lb != null && lb.getParent() != null) {
                this.Do.removeView(lb);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.Dn != null && this.Do != null && this.Dp != null) {
            this.Dn.closeRecordTooShort();
            LinearLayout la = this.Dn.la();
            if (la != null && la.getParent() != null) {
                this.Do.removeView(la);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout lb;
        if (this.Dn != null && this.Do != null && this.Dp != null && (lb = this.Dn.lb()) != null && lb.getParent() == null) {
            this.Do.addView(lb, this.Dp);
            this.Dn.showRecordCancel();
        }
    }

    public void lc() {
        LinearLayout la;
        if (this.Dn != null && this.Do != null && this.Dp != null && (la = this.Dn.la()) != null && la.getParent() == null) {
            this.Do.addView(la, this.Dp);
            this.Dn.lc();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout kZ;
        if (this.Dn != null && this.Do != null && this.Dp != null && (kZ = this.Dn.kZ()) != null && kZ.getParent() == null) {
            this.Do.addView(kZ, this.Dp);
            this.Dn.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.Dn != null && this.Do != null && this.Dp != null) {
            this.Dn.stopRecordVoice();
            LinearLayout kZ = this.Dn.kZ();
            if (kZ != null && kZ.getParent() != null) {
                this.Do.removeView(kZ);
            }
        }
    }
}
