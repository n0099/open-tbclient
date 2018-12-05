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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class NewVoiceRecordButton extends LinearLayout implements com.baidu.adp.lib.voice.f, l {
    private FrameLayout SV;
    private ImageView SW;
    private RecordingAnimView SX;
    private TextView SY;
    private TextView SZ;
    private EditorTools Ta;
    private int Tb;
    private boolean Tc;
    private com.baidu.tbadk.core.dialog.a Td;
    private VoiceData.VoiceModel mModel;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public NewVoiceRecordButton(Context context) {
        super(context);
        this.Tb = 0;
        initView();
    }

    private void initView() {
        inflate(getContext(), e.h.layou_new_record_button, this);
        this.SV = (FrameLayout) findViewById(e.g.layout_record_button);
        this.SW = (ImageView) findViewById(e.g.iv_record_init);
        this.SX = (RecordingAnimView) findViewById(e.g.record_anim_view);
        this.SX.setCertainColumnCount(8);
        this.SX.setColumnColor(e.d.cp_cont_g);
        this.SX.setColumnWidth(getResources().getDimensionPixelSize(e.C0210e.ds4));
        this.SY = (TextView) findViewById(e.g.tv_duration);
        this.SZ = (TextView) findViewById(e.g.tv_tip);
        this.SV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton.1
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
                        NewVoiceRecordButton.this.pM();
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
    public void pM() {
        if (this.Td == null) {
            this.Td = new com.baidu.tbadk.core.dialog.a(i.aK(getContext()).getPageActivity());
            this.Td.eB(getContext().getString(e.j.voice_restart_tip)).a(getContext().getString(e.j.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    NewVoiceRecordButton.this.b(new com.baidu.tbadk.editortools.a(11, -1, null));
                }
            }).b(getContext().getString(e.j.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(i.aK(getContext()));
        }
        this.Td.BF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecord() {
        if (getContext() instanceof Activity) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.Et();
            this.mPermissionJudgePolicy.c((Activity) getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
            this.mPermissionJudgePolicy.c((Activity) getContext(), "android.permission.RECORD_AUDIO");
            if (this.mPermissionJudgePolicy.A((Activity) getContext())) {
                return;
            }
        }
        if (this.mModel != null) {
            com.baidu.tbadk.core.voice.a.bo(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mModel.voiceId));
        }
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (recorderManager != null && recorderManager.pQ()) {
            this.Tc = recorderManager.a(this, -1);
            this.SY.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopRecord() {
        this.SW.setVisibility(0);
        this.SX.pT();
        this.SX.setVisibility(4);
        this.SZ.setText(getResources().getText(e.j.voice_record_press_to_record));
        this.SY.setVisibility(4);
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Tc && recorderManager != null) {
            recorderManager.stopRecord();
        }
        this.Tc = false;
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
                        this.SZ.setText(getResources().getText(e.j.voice_restart));
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
        this.SZ.setText(getResources().getText(e.j.voice_record_press_to_record));
        this.SY.setText("");
        this.SY.setVisibility(4);
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            this.SW.setVisibility(4);
            this.SX.setVisibility(0);
            this.SX.start();
            this.SZ.setText(getResources().getText(e.j.voice_record_release_to_stop));
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStopingRecorder() {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        this.SY.setVisibility(0);
        this.SY.setText(str);
        postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton.4
            @Override // java.lang.Runnable
            public void run() {
                if (NewVoiceRecordButton.this.SY != null && !NewVoiceRecordButton.this.Tc) {
                    NewVoiceRecordButton.this.SY.setVisibility(4);
                    NewVoiceRecordButton.this.SY.setText("");
                }
            }
        }, SystemScreenshotManager.DELAY_TIME);
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        if (!TextUtils.isEmpty(str) && i > 0) {
            this.mModel = new VoiceData.VoiceModel();
            this.mModel.duration = i;
            this.mModel.isLocal = true;
            this.mModel.voiceId = str;
            this.mModel.voice_status = 1;
            this.SZ.setText(getResources().getText(e.j.voice_restart));
            b(new com.baidu.tbadk.editortools.a(10, -1, this.mModel));
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onDeletedVoice(String str) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecordTime(int i) {
        this.SY.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Ta = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Ta != null) {
            this.Ta.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Tb = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Tb;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pN() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.h(this.SZ, e.d.cp_cont_f);
        al.h(this.SY, e.d.common_color_10140);
        al.i(this.SW, e.f.ic_post_record);
        this.SX.onChangeSkinType(i);
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
        if ((i.aK(getContext()) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) i.aK(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return null;
    }
}
