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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes11.dex */
public class NewVoiceRecordButton extends LinearLayout implements com.baidu.adp.lib.voice.f, m {
    private FrameLayout Zo;
    private ImageView Zp;
    private RecordingAnimView Zq;
    private TextView Zr;
    private TextView Zs;
    private EditorTools Zt;
    private int Zu;
    private boolean Zv;
    private com.baidu.tbadk.core.dialog.a Zw;
    private VoiceData.VoiceModel mModel;
    private PermissionJudgePolicy mPermissionJudgePolicy;

    public NewVoiceRecordButton(Context context) {
        super(context);
        this.Zu = 0;
        initView();
    }

    private void initView() {
        inflate(getContext(), R.layout.layou_new_record_button, this);
        this.Zo = (FrameLayout) findViewById(R.id.layout_record_button);
        this.Zp = (ImageView) findViewById(R.id.iv_record_init);
        this.Zq = (RecordingAnimView) findViewById(R.id.record_anim_view);
        this.Zq.setCertainColumnCount(8);
        this.Zq.setColumnColor(R.color.cp_cont_g);
        this.Zq.setColumnWidth(getResources().getDimensionPixelSize(R.dimen.ds4));
        this.Zr = (TextView) findViewById(R.id.tv_duration);
        this.Zs = (TextView) findViewById(R.id.tv_tip);
        this.Zo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton.1
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
                        NewVoiceRecordButton.this.qt();
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
    public void qt() {
        if (this.Zw == null) {
            this.Zw = new com.baidu.tbadk.core.dialog.a(i.G(getContext()).getPageActivity());
            this.Zw.vO(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    NewVoiceRecordButton.this.b(new com.baidu.tbadk.editortools.a(11, -1, null));
                }
            }).b(getContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(i.G(getContext()));
        }
        this.Zw.aST();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecord() {
        if (getContext() instanceof Activity) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission((Activity) getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
            this.mPermissionJudgePolicy.appendRequestPermission((Activity) getContext(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            if (this.mPermissionJudgePolicy.startRequestPermission((Activity) getContext())) {
                return;
            }
        }
        if (this.mModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.wY(this.mModel.voiceId));
        }
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (recorderManager != null && recorderManager.qw()) {
            this.Zv = recorderManager.a(this, -1);
            this.Zr.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopRecord() {
        this.Zp.setVisibility(0);
        this.Zq.qA();
        this.Zq.setVisibility(4);
        this.Zs.setText(getResources().getText(R.string.voice_record_press_to_record));
        this.Zr.setVisibility(4);
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Zv && recorderManager != null) {
            recorderManager.stopRecord();
        }
        this.Zv = false;
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
                        this.Zs.setText(getResources().getText(R.string.voice_restart));
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
        this.Zs.setText(getResources().getText(R.string.voice_record_press_to_record));
        this.Zr.setText("");
        this.Zr.setVisibility(4);
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            this.Zp.setVisibility(4);
            this.Zq.setVisibility(0);
            this.Zq.start();
            this.Zs.setText(getResources().getText(R.string.voice_record_release_to_stop));
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStopingRecorder() {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        this.Zr.setVisibility(0);
        this.Zr.setText(str);
        postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton.4
            @Override // java.lang.Runnable
            public void run() {
                if (NewVoiceRecordButton.this.Zr != null && !NewVoiceRecordButton.this.Zv) {
                    NewVoiceRecordButton.this.Zr.setVisibility(4);
                    NewVoiceRecordButton.this.Zr.setText("");
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
            this.Zs.setText(getResources().getText(R.string.voice_restart));
            b(new com.baidu.tbadk.editortools.a(10, -1, this.mModel));
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onDeletedVoice(String str) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecordTime(int i) {
        this.Zr.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Zt = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Zt != null) {
            this.Zt.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Zu = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Zu;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.Zs, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.Zr, (int) R.color.common_color_10140);
        am.setBackgroundResource(this.Zp, R.drawable.ic_post_record);
        this.Zq.onChangeSkinType(i);
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
        if ((i.G(getContext()) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) i.G(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return null;
    }
}
