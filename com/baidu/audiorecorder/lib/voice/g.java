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
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes2.dex */
public class g extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, s {
    private int JE;
    private long JF;
    private int JS;
    private i JT;
    private final int[] JX;
    private int JY;
    private int JZ;
    private final Paint KA;
    private final Rect KB;
    private final RectF KC;
    private TextView KD;
    private TextView KE;
    private TextView KF;
    private TextView KG;
    private VoiceButton KH;
    private ImageView KI;
    private TextView KJ;
    private float KK;
    private float KL;
    private f KM;
    private com.baidu.tbadk.core.dialog.a KN;
    private long KO;
    private long KP;
    private final int[] KQ;
    private final a KR;
    private SweepGradient KS;
    private int KT;
    private final int Ka;
    private final int Kb;
    private final int Kc;
    private final int Kd;
    private final int Ke;
    private int Kf;
    private int Kg;
    private int Kh;
    private int Ki;
    private int Kj;
    private int Kk;
    private int Kl;
    private int Km;
    private Paint Kn;
    private Paint Ko;
    private Paint Kp;
    private Paint Kq;
    private int Kr;
    private int Ks;
    private int Kt;
    private int Ku;
    private int Kv;
    private int Kw;
    private int Kx;
    private int Ky;
    private final BitmapDrawable Kz;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;

    static /* synthetic */ int e(g gVar) {
        int i = gVar.Kg;
        gVar.Kg = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (g.this.KL >= 360.0f) {
                    g.this.KL = 360.0f;
                    g.this.Kg = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    g.this.KO = uptimeMillis;
                    g.this.KP = uptimeMillis + 200;
                    g.this.KL += (((float) (uptimeMillis - g.this.KO)) / 1000.0f) * g.this.KK;
                    sendEmptyMessageAtTime(1, g.this.KP);
                    g.e(g.this);
                }
                g.this.Kf = g.this.Kg % 6;
                g.this.invalidate();
            }
        }
    }

    public static g aj(Context context) {
        return new g(context);
    }

    public g(Context context) {
        this(context, null);
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.JF = 0L;
        this.JX = new int[4];
        this.Kf = 0;
        this.Kg = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.Kh = 0;
        this.Ki = 0;
        this.Kj = 0;
        this.Kk = 0;
        this.Kl = 0;
        this.Km = 0;
        this.Kr = -1724676609;
        this.Ks = 1546880511;
        this.Kt = 674465279;
        this.Ku = 255034879;
        this.Kv = -1725669966;
        this.Kw = 1545887154;
        this.Kx = 673471922;
        this.Ky = 254041522;
        this.KA = new Paint(1);
        this.KB = new Rect();
        this.KC = new RectF();
        this.JS = 0;
        this.KQ = new int[2];
        this.KR = new a();
        this.JE = 0;
        this.KT = 0;
        this.JX[0] = context.getResources().getDimensionPixelSize(d.f.ds24);
        this.JX[1] = context.getResources().getDimensionPixelSize(d.f.ds8);
        this.JX[2] = context.getResources().getDimensionPixelSize(d.f.ds22);
        this.JX[3] = context.getResources().getDimensionPixelSize(d.f.ds36);
        this.Kh = context.getResources().getDimensionPixelSize(d.f.ds134);
        this.Ki = this.Kh + context.getResources().getDimensionPixelSize(d.f.ds14);
        this.Kj = this.Ki + context.getResources().getDimensionPixelSize(d.f.ds16);
        this.Kk = this.Kj + context.getResources().getDimensionPixelSize(d.f.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.Kl = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.Km = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.Kl = context.getResources().getDimensionPixelSize(d.f.ds70);
            this.Km = context.getResources().getDimensionPixelSize(d.f.ds210);
        }
        this.JY = context.getResources().getDimensionPixelSize(d.f.ds26);
        this.JZ = context.getResources().getDimensionPixelSize(d.f.ds10);
        this.Ka = context.getResources().getDimensionPixelSize(d.f.ds14);
        this.Kb = context.getResources().getDimensionPixelSize(d.f.ds4);
        this.Kc = context.getResources().getDimensionPixelSize(d.f.ds4);
        this.Kd = context.getResources().getDimensionPixelSize(d.f.ds12);
        this.Ke = context.getResources().getDimensionPixelSize(d.f.ds2);
        this.KA.setStyle(Paint.Style.STROKE);
        this.KA.setStrokeWidth(this.Kd);
        this.Kz = (BitmapDrawable) getResources().getDrawable(d.g.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        ak(context);
        lR();
        this.KQ[0] = ai.getColor(d.e.common_color_10151);
        this.KQ[1] = ai.getColor(d.e.common_color_10152);
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
                measureChild(childAt, i3 + ExploreByTouchHelper.INVALID_ID, i4 + ExploreByTouchHelper.INVALID_ID);
            }
        }
        setMeasuredDimension(i3, i4);
        this.JY = ((i4 - getContext().getResources().getDimensionPixelSize(d.f.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(d.f.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.KH.getMeasuredWidth();
        int measuredHeight = this.KH.getMeasuredHeight();
        int measuredWidth2 = this.KE.getMeasuredWidth();
        this.KE.layout((i5 - measuredWidth2) >> 1, this.JY + i2, (measuredWidth2 + i5) >> 1, this.KE.getMeasuredHeight() + this.JY + i2);
        int bottom = this.KE.getBottom();
        this.KH.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.KG.getMeasuredWidth();
        int measuredHeight2 = this.KG.getMeasuredHeight();
        int top = this.KH.getTop();
        this.KG.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.KD.getMeasuredWidth();
        int measuredHeight3 = this.KD.getMeasuredHeight();
        int right = this.KH.getRight() - this.JZ;
        int bottom2 = this.KH.getBottom() - this.Ka;
        this.KD.layout(this.Kl + i6, this.Km + bottom, measuredWidth4 + i6 + this.Kl, measuredHeight3 + this.Km + bottom);
        int measuredWidth5 = this.KI.getMeasuredWidth();
        this.KI.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.KI.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.KJ.getMeasuredWidth();
        this.KJ.layout((i5 - measuredWidth6) >> 1, (this.KD.getTop() - this.KJ.getMeasuredHeight()) - this.Kb, (measuredWidth6 + i5) >> 1, (this.KD.getTop() + i2) - this.Kb);
        this.KH.getLeft();
        this.KH.getRight();
        int measuredWidth7 = this.KF.getMeasuredWidth();
        int measuredHeight4 = this.KF.getMeasuredHeight();
        int bottom3 = this.KH.getBottom();
        this.KF.layout((i5 - measuredWidth7) >> 1, this.JX[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.JX[3]);
        this.KB.set((i5 - this.Kz.getIntrinsicWidth()) >> 1, this.KI.getTop() - this.Kc, (i5 + this.Kz.getIntrinsicHeight()) >> 1, (this.KI.getTop() + this.Kz.getIntrinsicHeight()) - this.Kc);
        this.Kz.setBounds(this.KB);
        this.KC.set(this.KI.getLeft() + (this.Kd >> 1) + this.Ke, this.KI.getTop() + (this.Kd >> 1) + this.Ke, (this.KI.getRight() - (this.Kd >> 1)) - this.Ke, (this.KI.getBottom() - (this.Kd >> 1)) - this.Ke);
        if (this.KS == null) {
            this.KS = new SweepGradient(this.KC.centerX(), this.KC.centerY(), this.KQ, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.KS.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.KC.centerX(), this.KC.centerY());
            this.KS.setLocalMatrix(matrix);
            this.KA.setShader(this.KS);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        d(canvas);
        super.dispatchDraw(canvas);
    }

    private void lL() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.KN == null) {
            this.KN = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.i.Z(getContext()).getPageActivity());
            this.KN.cN(getContext().getString(d.l.voice_restart_tip)).a(getContext().getString(d.l.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.g.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    g.this.lN();
                    if (g.this.getVoiceManager() != null && g.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.bG(g.this.mModel.voiceId);
                        }
                        g.this.mModel = null;
                    }
                }
            }).b(getContext().getString(d.l.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.g.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(com.baidu.adp.base.i.Z(getContext()));
        }
        try {
            this.KN.th();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bG(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void ak(Context context) {
        LayoutInflater.from(context).inflate(d.j.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.KE = (TextView) findViewById(d.h.tip_error);
        ai.c(this.KE, d.e.cp_cont_i, 1);
        this.KF = (TextView) findViewById(d.h.tip_operator);
        this.KG = (TextView) findViewById(d.h.tip_time_out);
        this.KH = (VoiceButton) findViewById(d.h.voice_bnt);
        this.KD = (TextView) findViewById(d.h.restart);
        this.KI = (ImageView) findViewById(d.h.play_img);
        this.KJ = (TextView) findViewById(d.h.play_time);
        this.KJ.setClickable(false);
        this.KD.setOnClickListener(this);
        this.KI.setOnClickListener(this);
        this.KH.setRecorderView(this);
        lN();
    }

    private void lM() {
        this.KH.setVisibility(4);
        this.KJ.setVisibility(0);
        this.KD.setVisibility(0);
        ai.c(this.KJ, d.e.cp_cont_f, 1);
        ai.c(this.KD, d.e.cp_cont_f, 1);
        ai.j(this.KD, d.g.but_posts_record_again_selector);
        this.KI.setVisibility(0);
        if (this.mModel != null) {
            this.KJ.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.KI.setContentDescription(String.format(getContext().getString(d.l.listen_time), Integer.valueOf(this.mModel.duration)));
            ai.c(this.KI, d.g.but_posts_record_play_selector);
        }
        ai.c(this.KF, d.e.cp_cont_c, 1);
        this.KF.setText(getContext().getString(d.l.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lN() {
        ai.c(this.KH, d.g.but_posts_record_zero_selector);
        this.KH.setVisibility(0);
        this.Kf = 0;
        this.KI.setVisibility(4);
        this.KJ.setVisibility(4);
        this.KD.setVisibility(4);
        this.KG.setVisibility(4);
        ai.c(this.KF, d.e.cp_cont_c, 1);
        this.KF.setText(getContext().getString(d.l.voice_record_press_to_record));
    }

    public void reset() {
        lN();
        this.mModel = null;
        this.Kf = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.KE.setText("");
        this.KE.setVisibility(4);
        this.Kf = 0;
        lM();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            lN();
            this.KF.setText(getContext().getString(d.l.voice_record_release_to_stop));
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
        if (this.KI != null && this.KJ != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    ai.c(this.KJ, d.e.cp_cont_f, 1);
                    this.KJ.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ai.c(this.KI, d.g.but_posts_record_play_selector);
                    this.KI.setContentDescription(String.format(getContext().getString(d.l.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.KF.setText(getContext().getString(d.l.voice_play_tip));
                    lP();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    ai.c(this.KJ, d.e.cp_cont_f, 1);
                    ai.c(this.KI, d.g.but_posts_record_stop_selector);
                    this.KI.setContentDescription(getContext().getString(d.l.pause));
                    this.KF.setText(getContext().getString(d.l.voice_stop_tip));
                    lO();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        ai.c(this.KG, d.e.cp_cont_i, 1);
        ai.c(this.KE, d.e.cp_cont_i, 1);
        ai.c(this.KF, d.e.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.KG.setVisibility(0);
                this.KG.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.KG != null) {
                            g.this.KG.setVisibility(4);
                            g.this.KG.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.KE.setVisibility(0);
                this.KE.setText(str);
                this.KF.setText(d.l.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.KE != null) {
                            g.this.KE.setVisibility(4);
                            g.this.KE.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.KE.setVisibility(0);
                this.KE.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.KE != null) {
                            g.this.KE.setVisibility(4);
                            g.this.KE.setText("");
                        }
                    }
                }, 2000L);
            } else {
                lN();
                this.KE.setVisibility(0);
                this.KE.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.KE != null) {
                            g.this.KE.setVisibility(4);
                            g.this.KE.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.KE.setVisibility(4);
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
        ai.c(this.KE, d.e.cp_cont_i, 1);
        this.KE.setVisibility(0);
        this.KE.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.JE = Math.max(i, this.JE);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.JF > 200) {
            this.JE = 0;
            this.JF = uptimeMillis;
        }
        if (this.JE < 10) {
            this.Kf = 1;
            invalidate();
        } else if (this.JE < 20) {
            this.Kf = 2;
            invalidate();
        } else if (this.JE < 30) {
            this.Kf = 3;
            invalidate();
        } else if (this.JE < 40) {
            this.Kf = 4;
            invalidate();
        } else {
            this.Kf = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aO(int i) {
        if (this.mModel != null && this.KJ != null) {
            int i2 = i / 1000;
            if (this.KT != i2) {
                this.KJ.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.KT = i2;
        }
    }

    private void lO() {
        if (this.mModel != null) {
            this.Kf = 0;
            this.KK = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.KO = SystemClock.uptimeMillis();
            this.KP = this.KO + 200;
            this.KR.sendEmptyMessageAtTime(1, this.KP);
            invalidate();
        }
    }

    private void lP() {
        this.Kf = 0;
        this.Kg = 0;
        this.KK = 0.0f;
        this.KL = 0.0f;
        this.KR.removeMessages(1);
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
            if (id == d.h.restart) {
                voiceManager.stopPlay();
                lL();
            } else if (id == d.h.play_img && this.mModel != null) {
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
        this.KM = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lQ() {
    }

    public void lR() {
        this.Kn = new Paint();
        this.Kn.setAntiAlias(true);
        this.Kn.setStyle(Paint.Style.STROKE);
        this.Kn.setStrokeWidth(2.0f);
        this.Ko = new Paint();
        this.Ko.setAntiAlias(true);
        this.Ko.setStyle(Paint.Style.STROKE);
        this.Ko.setStrokeWidth(2.0f);
        this.Kp = new Paint();
        this.Kp.setAntiAlias(true);
        this.Kp.setStyle(Paint.Style.STROKE);
        this.Kp.setStrokeWidth(2.0f);
        this.Kq = new Paint();
        this.Kq.setAntiAlias(true);
        this.Kq.setStyle(Paint.Style.STROKE);
        this.Kq.setStrokeWidth(2.0f);
    }

    public void d(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.Kn.setColor(this.Kv);
            this.Ko.setColor(this.Kw);
            this.Kp.setColor(this.Kx);
            this.Kq.setColor(this.Ky);
        } else {
            this.Kn.setColor(this.Kr);
            this.Ko.setColor(this.Ks);
            this.Kp.setColor(this.Kt);
            this.Kq.setColor(this.Ku);
        }
        if (this.Kf == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.Kh, this.Kn);
        } else if (this.Kf == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.Kh, this.Kn);
            canvas.drawCircle(this.centerX, this.centerY, this.Ki, this.Ko);
        } else if (this.Kf == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.Kh, this.Kn);
            canvas.drawCircle(this.centerX, this.centerY, this.Ki, this.Ko);
            canvas.drawCircle(this.centerX, this.centerY, this.Kj, this.Kp);
        } else if (this.Kf == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.Kh, this.Kn);
            canvas.drawCircle(this.centerX, this.centerY, this.Ki, this.Ko);
            canvas.drawCircle(this.centerX, this.centerY, this.Kj, this.Kp);
            canvas.drawCircle(this.centerX, this.centerY, this.Kk, this.Kq);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.code == 9) {
            reset();
            b(new com.baidu.tbadk.editortools.a(2, 6, null));
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lJ() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.JS;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JT != null) {
            this.JT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.JT = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.JS = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }
}
