package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes6.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, l {
    private int TK;
    private long TL;
    private EditorTools TT;
    private int TU;
    private com.baidu.tbadk.core.dialog.a TW;
    private final int UB;
    private final int UC;
    private final int UD;
    private final int UE;
    private final int UF;
    private int UG;
    private int UH;
    private int UI;
    private int UJ;
    private int UK;
    private int UL;
    private int UM;
    private int UN;
    private int UO;
    private int UQ;
    private Paint UR;
    private Paint US;
    private Paint UT;
    private Paint UU;
    private int UV;
    private int UW;
    private int UX;
    private int UY;
    private int UZ;
    private final int[] Uy;
    private int Uz;
    private int Va;
    private int Vb;
    private int Vc;
    private final BitmapDrawable Vd;
    private final Paint Ve;
    private final Rect Vf;
    private final RectF Vg;
    private TextView Vh;
    private TextView Vi;
    private TextView Vj;
    private TextView Vk;
    private VoiceButton Vl;
    private ImageView Vm;
    private TextView Vn;
    private float Vo;
    private float Vp;
    private f Vq;
    private long Vr;
    private long Vs;
    private final int[] Vt;
    private final a Vu;
    private SweepGradient Vv;
    private int Vw;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.UH;
        voiceRecordButton.UH = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (VoiceRecordButton.this.Vp >= 360.0f) {
                    VoiceRecordButton.this.Vp = 360.0f;
                    VoiceRecordButton.this.UH = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.Vr = uptimeMillis;
                    VoiceRecordButton.this.Vs = uptimeMillis + 200;
                    VoiceRecordButton.this.Vp += (((float) (uptimeMillis - VoiceRecordButton.this.Vr)) / 1000.0f) * VoiceRecordButton.this.Vo;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.Vs);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.UG = VoiceRecordButton.this.UH % 6;
                VoiceRecordButton.this.invalidate();
            }
        }
    }

    public static VoiceRecordButton an(Context context) {
        return new VoiceRecordButton(context);
    }

    public VoiceRecordButton(Context context) {
        this(context, null);
    }

    public VoiceRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TL = 0L;
        this.Uy = new int[4];
        this.UG = 0;
        this.UH = 0;
        this.UI = 0;
        this.UJ = 0;
        this.UK = 0;
        this.UL = 0;
        this.UM = 0;
        this.UN = 0;
        this.UO = 0;
        this.UQ = 0;
        this.UV = -1724676609;
        this.UW = 1546880511;
        this.UX = 674465279;
        this.UY = 255034879;
        this.UZ = -1725669966;
        this.Va = 1545887154;
        this.Vb = 673471922;
        this.Vc = 254041522;
        this.Ve = new Paint(1);
        this.Vf = new Rect();
        this.Vg = new RectF();
        this.TU = 0;
        this.Vt = new int[2];
        this.Vu = new a();
        this.TK = 0;
        this.Vw = 0;
        this.Uy[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.Uy[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.Uy[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.Uy[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.UK = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.UL = this.UK + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.UM = this.UL + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.UN = this.UM + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.UO = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.UQ = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.UO = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.UQ = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.Uz = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.UB = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.UC = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.UD = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.UE = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.UF = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.Ve.setStyle(Paint.Style.STROKE);
        this.Ve.setStrokeWidth(this.UE);
        this.Vd = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        ao(context);
        qz();
        this.Vt[0] = am.getColor(R.color.common_color_10151);
        this.Vt[1] = am.getColor(R.color.common_color_10152);
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager != null) {
            voiceManager.setAllowChangeVoiceMode(false);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = i & 1073741823;
        int i4 = i2 & 1073741823;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                measureChild(childAt, i3 - 2147483648, i4 - 2147483648);
            }
        }
        setMeasuredDimension(i3, i4);
        this.mPaddingTop = ((i4 - getContext().getResources().getDimensionPixelSize(R.dimen.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(R.dimen.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.Vl.getMeasuredWidth();
        int measuredHeight = this.Vl.getMeasuredHeight();
        int measuredWidth2 = this.Vi.getMeasuredWidth();
        this.Vi.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.Vi.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.Vi.getBottom();
        this.Vl.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.UI = (measuredWidth / 2) + i6;
        this.UJ = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Vk.getMeasuredWidth();
        int measuredHeight2 = this.Vk.getMeasuredHeight();
        int top = this.Vl.getTop();
        this.Vk.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Vh.getMeasuredWidth();
        int measuredHeight3 = this.Vh.getMeasuredHeight();
        int right = this.Vl.getRight() - this.Uz;
        int bottom2 = this.Vl.getBottom() - this.UB;
        this.Vh.layout(this.UO + i6, this.UQ + bottom, measuredWidth4 + i6 + this.UO, measuredHeight3 + this.UQ + bottom);
        int measuredWidth5 = this.Vm.getMeasuredWidth();
        this.Vm.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Vm.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Vn.getMeasuredWidth();
        this.Vn.layout((i5 - measuredWidth6) >> 1, (this.Vh.getTop() - this.Vn.getMeasuredHeight()) - this.UC, (measuredWidth6 + i5) >> 1, (this.Vh.getTop() + i2) - this.UC);
        this.Vl.getLeft();
        this.Vl.getRight();
        int measuredWidth7 = this.Vj.getMeasuredWidth();
        int measuredHeight4 = this.Vj.getMeasuredHeight();
        int bottom3 = this.Vl.getBottom();
        this.Vj.layout((i5 - measuredWidth7) >> 1, this.Uy[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.Uy[3]);
        this.Vf.set((i5 - this.Vd.getIntrinsicWidth()) >> 1, this.Vm.getTop() - this.UD, (i5 + this.Vd.getIntrinsicHeight()) >> 1, (this.Vm.getTop() + this.Vd.getIntrinsicHeight()) - this.UD);
        this.Vd.setBounds(this.Vf);
        this.Vg.set(this.Vm.getLeft() + (this.UE >> 1) + this.UF, this.Vm.getTop() + (this.UE >> 1) + this.UF, (this.Vm.getRight() - (this.UE >> 1)) - this.UF, (this.Vm.getBottom() - (this.UE >> 1)) - this.UF);
        if (this.Vv == null) {
            this.Vv = new SweepGradient(this.Vg.centerX(), this.Vg.centerY(), this.Vt, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Vv.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Vg.centerX(), this.Vg.centerY());
            this.Vv.setLocalMatrix(matrix);
            this.Ve.setShader(this.Vv);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void qk() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.TW == null) {
            this.TW = new com.baidu.tbadk.core.dialog.a(i.ab(getContext()).getPageActivity());
            this.TW.mQ(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.qv();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.cf(VoiceRecordButton.this.mModel.voiceId);
                        }
                        VoiceRecordButton.this.mModel = null;
                    }
                }
            }).b(getContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(i.ab(getContext()));
        }
        try {
            this.TW.agO();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.cf(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void ao(Context context) {
        LayoutInflater.from(context).inflate(R.layout.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.Vi = (TextView) findViewById(R.id.tip_error);
        am.f(this.Vi, R.color.cp_cont_a, 1);
        this.Vj = (TextView) findViewById(R.id.tip_operator);
        this.Vk = (TextView) findViewById(R.id.tip_time_out);
        this.Vl = (VoiceButton) findViewById(R.id.voice_bnt);
        this.Vh = (TextView) findViewById(R.id.restart);
        this.Vm = (ImageView) findViewById(R.id.play_img);
        this.Vn = (TextView) findViewById(R.id.play_time);
        this.Vn.setClickable(false);
        this.Vh.setOnClickListener(this);
        this.Vm.setOnClickListener(this);
        this.Vl.setRecorderView(this);
        qv();
    }

    private void qu() {
        this.Vl.setVisibility(4);
        this.Vn.setVisibility(0);
        this.Vh.setVisibility(0);
        am.f(this.Vn, R.color.cp_cont_f, 1);
        am.f(this.Vh, R.color.cp_cont_f, 1);
        am.k(this.Vh, R.drawable.but_posts_record_again_selector);
        this.Vm.setVisibility(0);
        if (this.mModel != null) {
            this.Vn.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Vm.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            am.c(this.Vm, (int) R.drawable.but_posts_record_play_selector);
        }
        am.f(this.Vj, R.color.cp_cont_c, 1);
        this.Vj.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qv() {
        am.c(this.Vl, (int) R.drawable.but_posts_record_zero_selector);
        this.Vl.setVisibility(0);
        this.UG = 0;
        this.Vm.setVisibility(4);
        this.Vn.setVisibility(4);
        this.Vh.setVisibility(4);
        this.Vk.setVisibility(4);
        am.f(this.Vj, R.color.cp_cont_c, 1);
        this.Vj.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        qv();
        this.mModel = null;
        this.UG = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Vi.setText("");
        this.Vi.setVisibility(4);
        this.UG = 0;
        qu();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            qv();
            this.Vj.setText(getContext().getString(R.string.voice_record_release_to_stop));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStopingRecorder() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (this.Vm != null && this.Vn != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    am.f(this.Vn, R.color.cp_cont_f, 1);
                    this.Vn.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    am.c(this.Vm, (int) R.drawable.but_posts_record_play_selector);
                    this.Vm.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Vj.setText(getContext().getString(R.string.voice_play_tip));
                    qx();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    am.f(this.Vn, R.color.cp_cont_f, 1);
                    am.c(this.Vm, (int) R.drawable.but_posts_record_stop_selector);
                    this.Vm.setContentDescription(getContext().getString(R.string.pause_load));
                    this.Vj.setText(getContext().getString(R.string.voice_stop_tip));
                    qw();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        am.f(this.Vk, R.color.cp_cont_a, 1);
        am.f(this.Vi, R.color.cp_cont_a, 1);
        am.f(this.Vj, R.color.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Vk.setVisibility(0);
                this.Vk.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Vk != null) {
                            VoiceRecordButton.this.Vk.setVisibility(4);
                            VoiceRecordButton.this.Vk.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.Vi.setVisibility(0);
                this.Vi.setText(str);
                this.Vj.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Vi != null) {
                            VoiceRecordButton.this.Vi.setVisibility(4);
                            VoiceRecordButton.this.Vi.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.Vi.setVisibility(0);
                this.Vi.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Vi != null) {
                            VoiceRecordButton.this.Vi.setVisibility(4);
                            VoiceRecordButton.this.Vi.setText("");
                        }
                    }
                }, 2000L);
            } else {
                qv();
                this.Vi.setVisibility(0);
                this.Vi.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Vi != null) {
                            VoiceRecordButton.this.Vi.setVisibility(4);
                            VoiceRecordButton.this.Vi.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.Vi.setVisibility(4);
        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
        voiceModel.duration = i;
        voiceModel.isLocal = true;
        voiceModel.voiceId = str;
        voiceModel.voice_status = 1;
        a(voiceModel);
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onDeletedVoice(String str) {
        this.mModel = null;
        b(new com.baidu.tbadk.editortools.a(11, -1, str));
        b(new com.baidu.tbadk.editortools.a(2, 6, null));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecordTime(int i) {
        am.f(this.Vi, R.color.cp_cont_a, 1);
        this.Vi.setVisibility(0);
        this.Vi.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.TK = Math.max(i, this.TK);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.TL > 200) {
            this.TK = 0;
            this.TL = uptimeMillis;
        }
        if (this.TK < 10) {
            this.UG = 1;
            invalidate();
        } else if (this.TK < 20) {
            this.UG = 2;
            invalidate();
        } else if (this.TK < 30) {
            this.UG = 3;
            invalidate();
        } else if (this.TK < 40) {
            this.UG = 4;
            invalidate();
        } else {
            this.UG = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bl(int i) {
        if (this.mModel != null && this.Vn != null) {
            int i2 = i / 1000;
            if (this.Vw != i2) {
                this.Vn.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Vw = i2;
        }
    }

    private void qw() {
        if (this.mModel != null) {
            this.UG = 0;
            this.Vo = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Vr = SystemClock.uptimeMillis();
            this.Vs = this.Vr + 200;
            this.Vu.sendEmptyMessageAtTime(1, this.Vs);
            invalidate();
        }
    }

    private void qx() {
        this.UG = 0;
        this.UH = 0;
        this.Vo = 0.0f;
        this.Vp = 0.0f;
        this.Vu.removeMessages(1);
        ((ViewGroup) getParent()).invalidate();
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        return null;
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager == null || voiceManager.getRecorderManager() == null) {
            return null;
        }
        return voiceManager.getRecorderManager();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (view != null && (voiceManager = getVoiceManager()) != null) {
            int id = view.getId();
            if (id == R.id.restart) {
                voiceManager.stopPlay();
                qk();
            } else if (id == R.id.play_img && this.mModel != null) {
                if (this.mModel.voice_status.intValue() == 3) {
                    voiceManager.stopPlay();
                } else if (this.mModel.voice_status.intValue() == 1) {
                    voiceManager.setAllowChangeVoiceMode(false);
                    voiceManager.startPlay(this);
                }
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (getVisibility() == 0 && (i == 4 || i == 8)) {
            if (getVoiceManager() != null) {
                getVoiceManager().stopPlay();
            } else {
                return;
            }
        }
        super.setVisibility(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (getVoiceManager() != null) {
            getVoiceManager().stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.mModel;
    }

    public void setCallback(f fVar) {
        this.Vq = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qy() {
    }

    public void qz() {
        this.UR = new Paint();
        this.UR.setAntiAlias(true);
        this.UR.setStyle(Paint.Style.STROKE);
        this.UR.setStrokeWidth(2.0f);
        this.US = new Paint();
        this.US.setAntiAlias(true);
        this.US.setStyle(Paint.Style.STROKE);
        this.US.setStrokeWidth(2.0f);
        this.UT = new Paint();
        this.UT.setAntiAlias(true);
        this.UT.setStyle(Paint.Style.STROKE);
        this.UT.setStrokeWidth(2.0f);
        this.UU = new Paint();
        this.UU.setAntiAlias(true);
        this.UU.setStyle(Paint.Style.STROKE);
        this.UU.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.UR.setColor(this.UZ);
            this.US.setColor(this.Va);
            this.UT.setColor(this.Vb);
            this.UU.setColor(this.Vc);
        } else {
            this.UR.setColor(this.UV);
            this.US.setColor(this.UW);
            this.UT.setColor(this.UX);
            this.UU.setColor(this.UY);
        }
        if (this.UG == 2) {
            canvas.drawCircle(this.UI, this.UJ, this.UK, this.UR);
        } else if (this.UG == 3) {
            canvas.drawCircle(this.UI, this.UJ, this.UK, this.UR);
            canvas.drawCircle(this.UI, this.UJ, this.UL, this.US);
        } else if (this.UG == 4) {
            canvas.drawCircle(this.UI, this.UJ, this.UK, this.UR);
            canvas.drawCircle(this.UI, this.UJ, this.UL, this.US);
            canvas.drawCircle(this.UI, this.UJ, this.UM, this.UT);
        } else if (this.UG == 5) {
            canvas.drawCircle(this.UI, this.UJ, this.UK, this.UR);
            canvas.drawCircle(this.UI, this.UJ, this.UL, this.US);
            canvas.drawCircle(this.UI, this.UJ, this.UM, this.UT);
            canvas.drawCircle(this.UI, this.UJ, this.UN, this.UU);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            if (aVar.code == 9) {
                reset();
                b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            if (aVar.code == 52) {
                if (aVar.data instanceof VoiceData.VoiceModel) {
                    qu();
                    b((VoiceData.VoiceModel) aVar.data);
                    this.mModel = (VoiceData.VoiceModel) aVar.data;
                    return;
                }
                reset();
                b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void ql() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TU;
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
        if (this.TT != null) {
            this.TT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TT = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TU = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }
}
