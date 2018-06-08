package com.baidu.audiorecorder.lib.voice;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class NewVoiceRecordButton extends LinearLayout implements com.baidu.adp.lib.voice.f, l {
    private FrameLayout Qc;
    private ImageView Qd;
    private RecordingAnimView Qe;
    private TextView Qf;
    private TextView Qg;
    private EditorTools Qh;
    private int Qi;
    private boolean Qj;
    private com.baidu.tbadk.core.dialog.a Qk;
    private VoiceData.VoiceModel mModel;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public NewVoiceRecordButton(Context context) {
        super(context);
        this.Qi = 0;
        initView();
    }

    private void initView() {
        inflate(getContext(), d.i.layou_new_record_button, this);
        this.Qc = (FrameLayout) findViewById(d.g.layout_record_button);
        this.Qd = (ImageView) findViewById(d.g.iv_record_init);
        this.Qe = (RecordingAnimView) findViewById(d.g.record_anim_view);
        this.Qe.setCertainColumnCount(8);
        this.Qe.setColumnColor(d.C0141d.cp_cont_g);
        this.Qe.setColumnWidth(getResources().getDimensionPixelSize(d.e.ds4));
        this.Qf = (TextView) findViewById(d.g.tv_duration);
        this.Qg = (TextView) findViewById(d.g.tv_tip);
        this.Qc.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        if (NewVoiceRecordButton.this.mModel == null) {
                            NewVoiceRecordButton.this.startRecord();
                            return true;
                        }
                        return true;
                    case 1:
                        if (NewVoiceRecordButton.this.mModel == null) {
                            NewVoiceRecordButton.this.stopRecord();
                            return true;
                        }
                        NewVoiceRecordButton.this.oC();
                        return true;
                    default:
                        return true;
                }
            }
        });
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (recorderManager != null) {
            recorderManager.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oC() {
        if (this.Qk == null) {
            this.Qk = new com.baidu.tbadk.core.dialog.a(i.ad(getContext()).getPageActivity());
            this.Qk.dB(getContext().getString(d.k.voice_restart_tip)).a(getContext().getString(d.k.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    NewVoiceRecordButton.this.b(new com.baidu.tbadk.editortools.a(11, -1, null));
                }
            }).b(getContext().getString(d.k.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(i.ad(getContext()));
        }
        this.Qk.xa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecord() {
        if (getContext() instanceof Activity) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.zU();
            this.mPermissionJudgePolicy.c((Activity) getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
            this.mPermissionJudgePolicy.c((Activity) getContext(), "android.permission.RECORD_AUDIO");
            if (this.mPermissionJudgePolicy.u((Activity) getContext())) {
                return;
            }
        }
        if (this.mModel != null) {
            com.baidu.tbadk.core.voice.a.aV(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mModel.voiceId));
        }
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (recorderManager != null && recorderManager.oG()) {
            this.Qj = recorderManager.a(this, -1);
            this.Qf.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopRecord() {
        this.Qd.setVisibility(0);
        this.Qe.oJ();
        this.Qe.setVisibility(4);
        this.Qg.setText(getResources().getText(d.k.voice_record_press_to_record));
        this.Qf.setVisibility(4);
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Qj && recorderManager != null) {
            recorderManager.stopRecord();
        }
        this.Qj = false;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    reset();
                    return;
                case 52:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.mModel = (VoiceData.VoiceModel) aVar.data;
                        this.Qg.setText(getResources().getText(d.k.voice_restart));
                        return;
                    }
                    reset();
                    return;
                default:
                    return;
            }
        }
    }

    private void reset() {
        this.mModel = null;
        this.Qg.setText(getResources().getText(d.k.voice_record_press_to_record));
        this.Qf.setText("");
        this.Qf.setVisibility(4);
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            this.Qd.setVisibility(4);
            this.Qe.setVisibility(0);
            this.Qe.start();
            this.Qg.setText(getResources().getText(d.k.voice_record_release_to_stop));
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStopingRecorder() {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        this.Qf.setVisibility(0);
        this.Qf.setText(str);
        postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton.4
            @Override // java.lang.Runnable
            public void run() {
                if (NewVoiceRecordButton.this.Qf != null && !NewVoiceRecordButton.this.Qj) {
                    NewVoiceRecordButton.this.Qf.setVisibility(4);
                    NewVoiceRecordButton.this.Qf.setText("");
                }
            }
        }, 2000L);
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        if (!TextUtils.isEmpty(str) && i > 0) {
            this.mModel = new VoiceData.VoiceModel();
            this.mModel.duration = i;
            this.mModel.isLocal = true;
            this.mModel.voiceId = str;
            this.mModel.voice_status = 1;
            this.Qg.setText(getResources().getText(d.k.voice_restart));
            b(new com.baidu.tbadk.editortools.a(10, -1, this.mModel));
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onDeletedVoice(String str) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecordTime(int i) {
        this.Qf.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qh = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qh != null) {
            this.Qh.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qi = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qi;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oD() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.h(this.Qg, d.C0141d.cp_cont_f);
        al.h(this.Qf, d.C0141d.common_color_10140);
        al.i(this.Qd, d.f.ic_post_record);
        this.Qe.onChangeSkinType(i);
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager == null || voiceManager.getRecorderManager() == null) {
            return null;
        }
        return voiceManager.getRecorderManager();
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.ad(getContext()) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) i.ad(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return null;
    }
}
