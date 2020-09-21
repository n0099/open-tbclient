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
/* loaded from: classes23.dex */
public class SendVoiceView extends LinearLayout implements n, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private EditorTools aaS;
    private int aaT;
    private TextView abr;
    private FloatRecordView abt;
    private WindowManager abu;
    private WindowManager.LayoutParams abv;

    public SendVoiceView(Context context) {
        super(context);
        this.abr = null;
        this.aaT = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.abr = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            sz();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.abr.setBackgroundResource(R.drawable.but_talk_s);
            this.abr.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.abr.setBackgroundResource(R.drawable.but_talk_n);
        this.abr.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aaT;
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
        if (this.aaS != null) {
            this.aaS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.aaS = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aaT = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }

    private void sz() {
        this.abt = new FloatRecordView(getContext());
        this.abu = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.abv = new WindowManager.LayoutParams();
        this.abv.type = com.baidu.tieba.v.c.Jk(2002);
        this.abv.format = 1;
        this.abv.flags = 56;
        this.abv.gravity = 17;
        this.abv.x = 0;
        this.abv.y = 0;
        this.abv.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.abv.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
                sq();
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
        if (this.abt != null && this.abu != null && this.abv != null) {
            this.abt.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.abt != null && this.abu != null && this.abv != null) {
            this.abt.closeRecordCancel();
            LinearLayout sp = this.abt.sp();
            if (sp != null && sp.getParent() != null) {
                this.abu.removeView(sp);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.abt != null && this.abu != null && this.abv != null) {
            this.abt.closeRecordTooShort();
            LinearLayout so = this.abt.so();
            if (so != null && so.getParent() != null) {
                this.abu.removeView(so);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout sp;
        if (this.abt != null && this.abu != null && this.abv != null && (sp = this.abt.sp()) != null && sp.getParent() == null) {
            this.abu.addView(sp, this.abv);
            this.abt.showRecordCancel();
        }
    }

    public void sq() {
        LinearLayout so;
        if (this.abt != null && this.abu != null && this.abv != null && (so = this.abt.so()) != null && so.getParent() == null) {
            this.abu.addView(so, this.abv);
            this.abt.sq();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout sn;
        if (this.abt != null && this.abu != null && this.abv != null && (sn = this.abt.sn()) != null && sn.getParent() == null) {
            this.abu.addView(sn, this.abv);
            this.abt.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.abt != null && this.abu != null && this.abv != null) {
            this.abt.stopRecordVoice();
            LinearLayout sn = this.abt.sn();
            if (sn != null && sn.getParent() != null) {
                this.abu.removeView(sn);
            }
        }
    }
}
