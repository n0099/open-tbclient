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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.b.a.j;
import d.b.b.e.q.f;
import d.b.h0.r.s.a;
import d.b.h0.w.n;
/* loaded from: classes2.dex */
public class NewVoiceRecordButton extends LinearLayout implements f, n {

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f4238e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f4239f;

    /* renamed from: g  reason: collision with root package name */
    public RecordingAnimView f4240g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f4241h;
    public TextView i;
    public EditorTools j;
    public int k;
    public VoiceData$VoiceModel l;
    public boolean m;
    public d.b.h0.r.s.a n;
    public PermissionJudgePolicy o;

    /* loaded from: classes2.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    if (NewVoiceRecordButton.this.l == null) {
                        NewVoiceRecordButton.this.n();
                    } else {
                        NewVoiceRecordButton.this.l();
                    }
                }
            } else if (NewVoiceRecordButton.this.l == null) {
                NewVoiceRecordButton.this.m();
            }
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            NewVoiceRecordButton.this.d(new d.b.h0.w.a(11, -1, null));
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NewVoiceRecordButton.this.f4241h == null || NewVoiceRecordButton.this.m) {
                return;
            }
            NewVoiceRecordButton.this.f4241h.setVisibility(4);
            NewVoiceRecordButton.this.f4241h.setText("");
        }
    }

    public NewVoiceRecordButton(Context context) {
        super(context);
        this.k = 0;
        j();
    }

    @Override // d.b.h0.w.n
    public void b() {
        setVisibility(0);
    }

    @Override // d.b.h0.w.n
    public void d(d.b.h0.w.a aVar) {
        EditorTools editorTools = this.j;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    public d.b.i0.c3.p0.a getRecorderManager() {
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager == null || voiceManager.getRecorderManager() == null) {
            return null;
        }
        return voiceManager.getRecorderManager();
    }

    @Override // d.b.h0.w.n
    public int getToolId() {
        return this.k;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.j) {
            return ((VoiceManager.j) context).getVoiceManager();
        }
        if ((j.a(getContext()) instanceof d.b.b.a.f) && (tbPageContext = (TbPageContext) j.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) {
            return ((VoiceManager.j) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return null;
    }

    @Override // d.b.h0.w.n
    public void hide() {
        setVisibility(8);
    }

    @Override // d.b.h0.w.n
    public void init() {
    }

    public final void j() {
        LinearLayout.inflate(getContext(), R.layout.layou_new_record_button, this);
        this.f4238e = (FrameLayout) findViewById(R.id.layout_record_button);
        this.f4239f = (ImageView) findViewById(R.id.iv_record_init);
        RecordingAnimView recordingAnimView = (RecordingAnimView) findViewById(R.id.record_anim_view);
        this.f4240g = recordingAnimView;
        recordingAnimView.setCertainColumnCount(8);
        this.f4240g.setColumnColor(R.color.CAM_X0111);
        this.f4240g.setColumnWidth(getResources().getDimensionPixelSize(R.dimen.ds4));
        this.f4241h = (TextView) findViewById(R.id.tv_duration);
        this.i = (TextView) findViewById(R.id.tv_tip);
        this.f4238e.setOnTouchListener(new a());
        d.b.i0.c3.p0.a recorderManager = getRecorderManager();
        if (recorderManager != null) {
            recorderManager.b(this);
        }
    }

    public final void k() {
        this.l = null;
        this.i.setText(getResources().getText(R.string.voice_record_press_to_record));
        this.f4241h.setText("");
        this.f4241h.setVisibility(4);
    }

    public final void l() {
        if (this.n == null) {
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(j.a(getContext()).getPageActivity());
            this.n = aVar;
            aVar.setMessage(getContext().getString(R.string.voice_restart_tip)).setPositiveButton(getContext().getString(R.string.voice_restart), new c()).setNegativeButton(getContext().getString(R.string.cancel), new b()).create(j.a(getContext()));
        }
        this.n.show();
    }

    public final void m() {
        if (getContext() instanceof Activity) {
            if (this.o == null) {
                this.o = new PermissionJudgePolicy();
            }
            this.o.clearRequestPermissionList();
            this.o.appendRequestPermission((Activity) getContext(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            this.o.appendRequestPermission((Activity) getContext(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            if (this.o.startRequestPermission((Activity) getContext())) {
                return;
            }
        }
        VoiceData$VoiceModel voiceData$VoiceModel = this.l;
        if (voiceData$VoiceModel != null) {
            d.b.h0.r.g0.a.a(d.b.h0.r.g0.a.b(voiceData$VoiceModel.voiceId));
        }
        d.b.i0.c3.p0.a recorderManager = getRecorderManager();
        if (recorderManager == null || !recorderManager.d()) {
            return;
        }
        this.m = recorderManager.c(this, -1);
        this.f4241h.setVisibility(0);
    }

    public final void n() {
        this.f4239f.setVisibility(0);
        this.f4240g.g();
        this.f4240g.setVisibility(4);
        this.i.setText(getResources().getText(R.string.voice_record_press_to_record));
        this.f4241h.setVisibility(4);
        d.b.i0.c3.p0.a recorderManager = getRecorderManager();
        if (this.m && recorderManager != null) {
            recorderManager.stopRecord();
        }
        this.m = false;
    }

    @Override // d.b.h0.w.b
    public void onAction(d.b.h0.w.a aVar) {
        if (aVar == null) {
            return;
        }
        int i = aVar.f51523a;
        if (i == 1) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 6));
        } else if (i == 9) {
            k();
        } else if (i != 52) {
        } else {
            Object obj = aVar.f51525c;
            if (obj instanceof VoiceData$VoiceModel) {
                this.l = (VoiceData$VoiceModel) obj;
                this.i.setText(getResources().getText(R.string.voice_restart));
                return;
            }
            k();
        }
    }

    @Override // d.b.h0.w.n
    public void onChangeSkinType(int i) {
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0106, 1, i);
        SkinManager.setViewTextColor(this.f4241h, R.color.CAM_X0302, 1, i);
        SkinManager.setBackgroundResource(this.f4239f, R.drawable.ic_post_record, i);
        this.f4240g.f(i);
    }

    @Override // d.b.b.e.q.f
    public void onDeletedVoice(String str) {
    }

    @Override // d.b.b.e.q.f
    public void onSendVoice(String str, int i) {
        if (TextUtils.isEmpty(str) || i <= 0) {
            return;
        }
        VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
        this.l = voiceData$VoiceModel;
        voiceData$VoiceModel.duration = i;
        voiceData$VoiceModel.isLocal = true;
        voiceData$VoiceModel.voiceId = str;
        voiceData$VoiceModel.voice_status = 1;
        this.i.setText(getResources().getText(R.string.voice_restart));
        d(new d.b.h0.w.a(10, -1, this.l));
    }

    @Override // d.b.b.e.q.f
    public void onShowErr(int i, String str) {
        this.f4241h.setVisibility(0);
        this.f4241h.setText(str);
        postDelayed(new d(), 2000L);
    }

    @Override // d.b.b.e.q.f
    public void onShowRecordTime(int i) {
        this.f4241h.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // d.b.b.e.q.f
    public void onShowRecording(int i) {
    }

    @Override // d.b.b.e.q.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            this.f4239f.setVisibility(4);
            this.f4240g.setVisibility(0);
            this.f4240g.h();
            this.i.setText(getResources().getText(R.string.voice_record_release_to_stop));
        }
    }

    @Override // d.b.b.e.q.f
    public void onStopingRecorder() {
    }

    @Override // d.b.h0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.j = editorTools;
    }

    @Override // d.b.h0.w.n
    public void setToolId(int i) {
        this.k = i;
    }
}
