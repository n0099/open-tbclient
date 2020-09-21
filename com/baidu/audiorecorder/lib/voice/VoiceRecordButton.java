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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes23.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, n {
    private int aaK;
    private long aaL;
    private EditorTools aaS;
    private int aaT;
    private com.baidu.tbadk.core.dialog.a aaV;
    private final int abA;
    private final int abB;
    private final int abC;
    private int abD;
    private int abE;
    private int abF;
    private int abG;
    private int abH;
    private int abI;
    private int abJ;
    private int abK;
    private int abL;
    private int abM;
    private Paint abN;
    private Paint abO;
    private Paint abP;
    private Paint abQ;
    private int abR;
    private int abS;
    private int abT;
    private int abU;
    private int abV;
    private int abW;
    private int abX;
    private int abY;
    private final BitmapDrawable abZ;
    private final int[] abw;
    private int abx;
    private final int aby;
    private final int abz;
    private final Paint aca;
    private final Rect acb;
    private final RectF acc;
    private TextView acd;
    private TextView ace;
    private TextView acf;
    private TextView acg;
    private VoiceButton ach;
    private ImageView aci;
    private TextView acj;
    private float acm;
    private float acn;
    private f aco;
    private long acp;
    private long acq;
    private final int[] acr;
    private final a acs;
    private SweepGradient act;
    private int acu;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.abE;
        voiceRecordButton.abE = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (VoiceRecordButton.this.acn >= 360.0f) {
                    VoiceRecordButton.this.acn = 360.0f;
                    VoiceRecordButton.this.abE = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.acp = uptimeMillis;
                    VoiceRecordButton.this.acq = uptimeMillis + 200;
                    VoiceRecordButton.this.acn += (((float) (uptimeMillis - VoiceRecordButton.this.acp)) / 1000.0f) * VoiceRecordButton.this.acm;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.acq);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.abD = VoiceRecordButton.this.abE % 6;
                VoiceRecordButton.this.invalidate();
            }
        }
    }

    public static VoiceRecordButton L(Context context) {
        return new VoiceRecordButton(context);
    }

    public VoiceRecordButton(Context context) {
        this(context, null);
    }

    public VoiceRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aaL = 0L;
        this.abw = new int[4];
        this.abD = 0;
        this.abE = 0;
        this.abF = 0;
        this.abG = 0;
        this.abH = 0;
        this.abI = 0;
        this.abJ = 0;
        this.abK = 0;
        this.abL = 0;
        this.abM = 0;
        this.abR = -1724676609;
        this.abS = 1546880511;
        this.abT = 674465279;
        this.abU = 255034879;
        this.abV = -1725669966;
        this.abW = 1545887154;
        this.abX = 673471922;
        this.abY = 254041522;
        this.aca = new Paint(1);
        this.acb = new Rect();
        this.acc = new RectF();
        this.aaT = 0;
        this.acr = new int[2];
        this.acs = new a();
        this.aaK = 0;
        this.acu = 0;
        this.abw[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.abw[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.abw[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.abw[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.abH = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.abI = this.abH + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.abJ = this.abI + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.abK = this.abJ + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.abL = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.abM = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.abL = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.abM = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.abx = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.aby = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.abz = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.abA = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.abB = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.abC = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.aca.setStyle(Paint.Style.STROKE);
        this.aca.setStrokeWidth(this.abB);
        this.abZ = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        M(context);
        sD();
        this.acr[0] = ap.getColor(R.color.common_color_10151);
        this.acr[1] = ap.getColor(R.color.common_color_10152);
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
        int measuredWidth = this.ach.getMeasuredWidth();
        int measuredHeight = this.ach.getMeasuredHeight();
        int measuredWidth2 = this.ace.getMeasuredWidth();
        this.ace.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.ace.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.ace.getBottom();
        this.ach.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.abF = (measuredWidth / 2) + i6;
        this.abG = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.acg.getMeasuredWidth();
        int measuredHeight2 = this.acg.getMeasuredHeight();
        int top = this.ach.getTop();
        this.acg.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.acd.getMeasuredWidth();
        int measuredHeight3 = this.acd.getMeasuredHeight();
        int right = this.ach.getRight() - this.abx;
        int bottom2 = this.ach.getBottom() - this.aby;
        this.acd.layout(this.abL + i6, this.abM + bottom, measuredWidth4 + i6 + this.abL, measuredHeight3 + this.abM + bottom);
        int measuredWidth5 = this.aci.getMeasuredWidth();
        this.aci.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.aci.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.acj.getMeasuredWidth();
        this.acj.layout((i5 - measuredWidth6) >> 1, (this.acd.getTop() - this.acj.getMeasuredHeight()) - this.abz, (measuredWidth6 + i5) >> 1, (this.acd.getTop() + i2) - this.abz);
        this.ach.getLeft();
        this.ach.getRight();
        int measuredWidth7 = this.acf.getMeasuredWidth();
        int measuredHeight4 = this.acf.getMeasuredHeight();
        int bottom3 = this.ach.getBottom();
        this.acf.layout((i5 - measuredWidth7) >> 1, this.abw[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.abw[3]);
        this.acb.set((i5 - this.abZ.getIntrinsicWidth()) >> 1, this.aci.getTop() - this.abA, (i5 + this.abZ.getIntrinsicHeight()) >> 1, (this.aci.getTop() + this.abZ.getIntrinsicHeight()) - this.abA);
        this.abZ.setBounds(this.acb);
        this.acc.set(this.aci.getLeft() + (this.abB >> 1) + this.abC, this.aci.getTop() + (this.abB >> 1) + this.abC, (this.aci.getRight() - (this.abB >> 1)) - this.abC, (this.aci.getBottom() - (this.abB >> 1)) - this.abC);
        if (this.act == null) {
            this.act = new SweepGradient(this.acc.centerX(), this.acc.centerY(), this.acr, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.act.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.acc.centerX(), this.acc.centerY());
            this.act.setLocalMatrix(matrix);
            this.aca.setShader(this.act);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void sr() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.aaV == null) {
            this.aaV = new com.baidu.tbadk.core.dialog.a(i.I(getContext()).getPageActivity());
            this.aaV.zV(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.sB();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.cW(VoiceRecordButton.this.mModel.voiceId);
                        }
                        VoiceRecordButton.this.mModel = null;
                    }
                }
            }).b(getContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(i.I(getContext()));
        }
        try {
            this.aaV.bia();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.cW(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void M(Context context) {
        LayoutInflater.from(context).inflate(R.layout.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.ace = (TextView) findViewById(R.id.tip_error);
        ap.setViewTextColor(this.ace, R.color.cp_cont_a, 1);
        this.acf = (TextView) findViewById(R.id.tip_operator);
        this.acg = (TextView) findViewById(R.id.tip_time_out);
        this.ach = (VoiceButton) findViewById(R.id.voice_bnt);
        this.acd = (TextView) findViewById(R.id.restart);
        this.aci = (ImageView) findViewById(R.id.play_img);
        this.acj = (TextView) findViewById(R.id.play_time);
        this.acj.setClickable(false);
        this.acd.setOnClickListener(this);
        this.aci.setOnClickListener(this);
        this.ach.setRecorderView(this);
        sB();
    }

    private void sA() {
        this.ach.setVisibility(4);
        this.acj.setVisibility(0);
        this.acd.setVisibility(0);
        ap.setViewTextColor(this.acj, R.color.cp_cont_f, 1);
        ap.setViewTextColor(this.acd, R.color.cp_cont_f, 1);
        ap.setBackgroundResource(this.acd, R.drawable.but_posts_record_again_selector);
        this.aci.setVisibility(0);
        if (this.mModel != null) {
            this.acj.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.aci.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            ap.setImageResource(this.aci, R.drawable.but_posts_record_play_selector);
        }
        ap.setViewTextColor(this.acf, R.color.cp_cont_c, 1);
        this.acf.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sB() {
        ap.setImageResource(this.ach, R.drawable.but_posts_record_zero_selector);
        this.ach.setVisibility(0);
        this.abD = 0;
        this.aci.setVisibility(4);
        this.acj.setVisibility(4);
        this.acd.setVisibility(4);
        this.acg.setVisibility(4);
        ap.setViewTextColor(this.acf, R.color.cp_cont_c, 1);
        this.acf.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        sB();
        this.mModel = null;
        this.abD = 0;
    }

    public void c(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.ace.setText("");
        this.ace.setVisibility(4);
        this.abD = 0;
        sA();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            sB();
            this.acf.setText(getContext().getString(R.string.voice_record_release_to_stop));
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
        if (this.aci != null && this.acj != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    ap.setViewTextColor(this.acj, R.color.cp_cont_f, 1);
                    this.acj.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ap.setImageResource(this.aci, R.drawable.but_posts_record_play_selector);
                    this.aci.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.acf.setText(getContext().getString(R.string.voice_play_tip));
                    stopProgress();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    ap.setViewTextColor(this.acj, R.color.cp_cont_f, 1);
                    ap.setImageResource(this.aci, R.drawable.but_posts_record_stop_selector);
                    this.aci.setContentDescription(getContext().getString(R.string.pause_load));
                    this.acf.setText(getContext().getString(R.string.voice_stop_tip));
                    sC();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        ap.setViewTextColor(this.acg, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.ace, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.acf, R.color.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.acg.setVisibility(0);
                this.acg.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.acg != null) {
                            VoiceRecordButton.this.acg.setVisibility(4);
                            VoiceRecordButton.this.acg.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.ace.setVisibility(0);
                this.ace.setText(str);
                this.acf.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.ace != null) {
                            VoiceRecordButton.this.ace.setVisibility(4);
                            VoiceRecordButton.this.ace.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.ace.setVisibility(0);
                this.ace.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.ace != null) {
                            VoiceRecordButton.this.ace.setVisibility(4);
                            VoiceRecordButton.this.ace.setText("");
                        }
                    }
                }, 2000L);
            } else {
                sB();
                this.ace.setVisibility(0);
                this.ace.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.ace != null) {
                            VoiceRecordButton.this.ace.setVisibility(4);
                            VoiceRecordButton.this.ace.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.ace.setVisibility(4);
        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
        voiceModel.duration = i;
        voiceModel.isLocal = true;
        voiceModel.voiceId = str;
        voiceModel.voice_status = 1;
        c(voiceModel);
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onDeletedVoice(String str) {
        this.mModel = null;
        b(new com.baidu.tbadk.editortools.a(11, -1, str));
        b(new com.baidu.tbadk.editortools.a(2, 6, null));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecordTime(int i) {
        ap.setViewTextColor(this.ace, R.color.cp_cont_a, 1);
        this.ace.setVisibility(0);
        this.ace.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.aaK = Math.max(i, this.aaK);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.aaL > 200) {
            this.aaK = 0;
            this.aaL = uptimeMillis;
        }
        if (this.aaK < 10) {
            this.abD = 1;
            invalidate();
        } else if (this.aaK < 20) {
            this.abD = 2;
            invalidate();
        } else if (this.aaK < 30) {
            this.abD = 3;
            invalidate();
        } else if (this.aaK < 40) {
            this.abD = 4;
            invalidate();
        } else {
            this.abD = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bf(int i) {
        if (this.mModel != null && this.acj != null) {
            int i2 = i / 1000;
            if (this.acu != i2) {
                this.acj.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.acu = i2;
        }
    }

    private void sC() {
        if (this.mModel != null) {
            this.abD = 0;
            this.acm = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.acp = SystemClock.uptimeMillis();
            this.acq = this.acp + 200;
            this.acs.sendEmptyMessageAtTime(1, this.acq);
            invalidate();
        }
    }

    private void stopProgress() {
        this.abD = 0;
        this.abE = 0;
        this.acm = 0.0f;
        this.acn = 0.0f;
        this.acs.removeMessages(1);
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
                sr();
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
        this.aco = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void sg() {
    }

    public void sD() {
        this.abN = new Paint();
        this.abN.setAntiAlias(true);
        this.abN.setStyle(Paint.Style.STROKE);
        this.abN.setStrokeWidth(2.0f);
        this.abO = new Paint();
        this.abO.setAntiAlias(true);
        this.abO.setStyle(Paint.Style.STROKE);
        this.abO.setStrokeWidth(2.0f);
        this.abP = new Paint();
        this.abP.setAntiAlias(true);
        this.abP.setStyle(Paint.Style.STROKE);
        this.abP.setStrokeWidth(2.0f);
        this.abQ = new Paint();
        this.abQ.setAntiAlias(true);
        this.abQ.setStyle(Paint.Style.STROKE);
        this.abQ.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.abN.setColor(this.abV);
            this.abO.setColor(this.abW);
            this.abP.setColor(this.abX);
            this.abQ.setColor(this.abY);
        } else {
            this.abN.setColor(this.abR);
            this.abO.setColor(this.abS);
            this.abP.setColor(this.abT);
            this.abQ.setColor(this.abU);
        }
        if (this.abD == 2) {
            canvas.drawCircle(this.abF, this.abG, this.abH, this.abN);
        } else if (this.abD == 3) {
            canvas.drawCircle(this.abF, this.abG, this.abH, this.abN);
            canvas.drawCircle(this.abF, this.abG, this.abI, this.abO);
        } else if (this.abD == 4) {
            canvas.drawCircle(this.abF, this.abG, this.abH, this.abN);
            canvas.drawCircle(this.abF, this.abG, this.abI, this.abO);
            canvas.drawCircle(this.abF, this.abG, this.abJ, this.abP);
        } else if (this.abD == 5) {
            canvas.drawCircle(this.abF, this.abG, this.abH, this.abN);
            canvas.drawCircle(this.abF, this.abG, this.abI, this.abO);
            canvas.drawCircle(this.abF, this.abG, this.abJ, this.abP);
            canvas.drawCircle(this.abF, this.abG, this.abK, this.abQ);
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
                    sA();
                    b((VoiceData.VoiceModel) aVar.data);
                    this.mModel = (VoiceData.VoiceModel) aVar.data;
                    return;
                }
                reset();
                b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
        }
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
}
