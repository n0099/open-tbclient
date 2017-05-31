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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class s extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.j, VoiceManager.b, com.baidu.tbadk.editortools.y {
    private int JF;
    private long JG;
    private int JT;
    private com.baidu.tbadk.editortools.j JU;
    private final int[] JY;
    private int JZ;
    private final BitmapDrawable KA;
    private final Paint KB;
    private final Rect KC;
    private final RectF KD;
    private TextView KE;
    private TextView KF;
    private TextView KG;
    private TextView KH;
    private VoiceButton KI;
    private ImageView KJ;
    private TextView KK;
    private float KL;
    private float KM;
    private r KN;
    private com.baidu.tbadk.core.dialog.a KO;
    private long KP;
    private long KQ;
    private final int[] KR;
    private final a KS;
    private SweepGradient KT;
    private int KU;
    private int Ka;
    private final int Kb;
    private final int Kc;
    private final int Kd;
    private final int Ke;
    private final int Kf;
    private int Kg;
    private int Kh;
    private int Ki;
    private int Kj;
    private int Kk;
    private int Kl;
    private int Km;
    private int Kn;
    private Paint Ko;
    private Paint Kp;
    private Paint Kq;
    private Paint Kr;
    private int Ks;
    private int Kt;
    private int Ku;
    private int Kv;
    private int Kw;
    private int Kx;
    private int Ky;
    private int Kz;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends Handler {
        private a() {
        }

        /* synthetic */ a(s sVar, a aVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (s.this.KM >= 360.0f) {
                    s.this.KM = 360.0f;
                    s.this.Kh = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    s.this.KP = uptimeMillis;
                    s.this.KQ = uptimeMillis + 200;
                    s.this.KM += (((float) (uptimeMillis - s.this.KP)) / 1000.0f) * s.this.KL;
                    sendEmptyMessageAtTime(1, s.this.KQ);
                    s.this.Kh++;
                }
                s.this.Kg = s.this.Kh % 6;
                s.this.invalidate();
            }
        }
    }

    public static s aj(Context context) {
        return new s(context);
    }

    public s(Context context) {
        this(context, null);
    }

    public s(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.JG = 0L;
        this.JY = new int[4];
        this.Kg = 0;
        this.Kh = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.Ki = 0;
        this.Kj = 0;
        this.Kk = 0;
        this.Kl = 0;
        this.Km = 0;
        this.Kn = 0;
        this.Ks = -1724676609;
        this.Kt = 1546880511;
        this.Ku = 674465279;
        this.Kv = 255034879;
        this.Kw = -1725669966;
        this.Kx = 1545887154;
        this.Ky = 673471922;
        this.Kz = 254041522;
        this.KB = new Paint(1);
        this.KC = new Rect();
        this.KD = new RectF();
        this.JT = 0;
        this.KR = new int[2];
        this.KS = new a(this, null);
        this.JF = 0;
        this.KU = 0;
        this.JY[0] = context.getResources().getDimensionPixelSize(w.f.ds24);
        this.JY[1] = context.getResources().getDimensionPixelSize(w.f.ds8);
        this.JY[2] = context.getResources().getDimensionPixelSize(w.f.ds22);
        this.JY[3] = context.getResources().getDimensionPixelSize(w.f.ds36);
        this.Ki = context.getResources().getDimensionPixelSize(w.f.ds134);
        this.Kj = this.Ki + context.getResources().getDimensionPixelSize(w.f.ds14);
        this.Kk = this.Kj + context.getResources().getDimensionPixelSize(w.f.ds16);
        this.Kl = this.Kk + context.getResources().getDimensionPixelSize(w.f.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.Km = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.Kn = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.Km = context.getResources().getDimensionPixelSize(w.f.ds70);
            this.Kn = context.getResources().getDimensionPixelSize(w.f.ds210);
        }
        this.JZ = context.getResources().getDimensionPixelSize(w.f.ds26);
        this.Ka = context.getResources().getDimensionPixelSize(w.f.ds10);
        this.Kb = context.getResources().getDimensionPixelSize(w.f.ds14);
        this.Kc = context.getResources().getDimensionPixelSize(w.f.ds4);
        this.Kd = context.getResources().getDimensionPixelSize(w.f.ds4);
        this.Ke = context.getResources().getDimensionPixelSize(w.f.ds12);
        this.Kf = context.getResources().getDimensionPixelSize(w.f.ds2);
        this.KB.setStyle(Paint.Style.STROKE);
        this.KB.setStrokeWidth(this.Ke);
        this.KA = (BitmapDrawable) getResources().getDrawable(w.g.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        ak(context);
        lW();
        this.KR[0] = aq.getColor(w.e.common_color_10151);
        this.KR[1] = aq.getColor(w.e.common_color_10152);
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
        this.JZ = ((i4 - getContext().getResources().getDimensionPixelSize(w.f.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(w.f.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.KI.getMeasuredWidth();
        int measuredHeight = this.KI.getMeasuredHeight();
        int measuredWidth2 = this.KF.getMeasuredWidth();
        this.KF.layout((i5 - measuredWidth2) >> 1, this.JZ + i2, (measuredWidth2 + i5) >> 1, this.KF.getMeasuredHeight() + this.JZ + i2);
        int bottom = this.KF.getBottom();
        this.KI.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.KH.getMeasuredWidth();
        int measuredHeight2 = this.KH.getMeasuredHeight();
        int top = this.KI.getTop();
        this.KH.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.KE.getMeasuredWidth();
        int measuredHeight3 = this.KE.getMeasuredHeight();
        int right = this.KI.getRight() - this.Ka;
        int bottom2 = this.KI.getBottom() - this.Kb;
        this.KE.layout(this.Km + i6, this.Kn + bottom, measuredWidth4 + i6 + this.Km, measuredHeight3 + this.Kn + bottom);
        int measuredWidth5 = this.KJ.getMeasuredWidth();
        this.KJ.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.KJ.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.KK.getMeasuredWidth();
        this.KK.layout((i5 - measuredWidth6) >> 1, (this.KE.getTop() - this.KK.getMeasuredHeight()) - this.Kc, (measuredWidth6 + i5) >> 1, (this.KE.getTop() + i2) - this.Kc);
        this.KI.getLeft();
        this.KI.getRight();
        int measuredWidth7 = this.KG.getMeasuredWidth();
        int measuredHeight4 = this.KG.getMeasuredHeight();
        int bottom3 = this.KI.getBottom();
        this.KG.layout((i5 - measuredWidth7) >> 1, this.JY[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.JY[3]);
        this.KC.set((i5 - this.KA.getIntrinsicWidth()) >> 1, this.KJ.getTop() - this.Kd, (i5 + this.KA.getIntrinsicHeight()) >> 1, (this.KJ.getTop() + this.KA.getIntrinsicHeight()) - this.Kd);
        this.KA.setBounds(this.KC);
        this.KD.set(this.KJ.getLeft() + (this.Ke >> 1) + this.Kf, this.KJ.getTop() + (this.Ke >> 1) + this.Kf, (this.KJ.getRight() - (this.Ke >> 1)) - this.Kf, (this.KJ.getBottom() - (this.Ke >> 1)) - this.Kf);
        if (this.KT == null) {
            this.KT = new SweepGradient(this.KD.centerX(), this.KD.centerY(), this.KR, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.KT.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.KD.centerX(), this.KD.centerY());
            this.KT.setLocalMatrix(matrix);
            this.KB.setShader(this.KT);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        d(canvas);
        super.dispatchDraw(canvas);
    }

    private void lQ() {
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.KO == null) {
            this.KO = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.k.Z(getContext()).getPageActivity());
            this.KO.cB(getContext().getString(w.l.voice_restart_tip)).a(getContext().getString(w.l.voice_restart), new t(this, recorderManager)).b(getContext().getString(w.l.cancel), new u(this)).b(com.baidu.adp.base.k.Z(getContext()));
        }
        try {
            this.KO.tc();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bz(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void ak(Context context) {
        LayoutInflater.from(context).inflate(w.j.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.KF = (TextView) findViewById(w.h.tip_error);
        aq.c(this.KF, w.e.cp_cont_i, 1);
        this.KG = (TextView) findViewById(w.h.tip_operator);
        this.KH = (TextView) findViewById(w.h.tip_time_out);
        this.KI = (VoiceButton) findViewById(w.h.voice_bnt);
        this.KE = (TextView) findViewById(w.h.restart);
        this.KJ = (ImageView) findViewById(w.h.play_img);
        this.KK = (TextView) findViewById(w.h.play_time);
        this.KK.setClickable(false);
        this.KE.setOnClickListener(this);
        this.KJ.setOnClickListener(this);
        this.KI.setRecorderView(this);
        lS();
    }

    private void lR() {
        this.KI.setVisibility(4);
        this.KK.setVisibility(0);
        this.KE.setVisibility(0);
        aq.c(this.KK, w.e.cp_cont_f, 1);
        aq.c(this.KE, w.e.cp_cont_f, 1);
        aq.j(this.KE, w.g.but_posts_record_again_selector);
        this.KJ.setVisibility(0);
        if (this.mModel != null) {
            this.KK.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.KJ.setContentDescription(String.format(getContext().getString(w.l.listen_time), Integer.valueOf(this.mModel.duration)));
            aq.c(this.KJ, w.g.but_posts_record_play_selector);
        }
        aq.c(this.KG, w.e.cp_cont_c, 1);
        this.KG.setText(getContext().getString(w.l.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lS() {
        aq.c(this.KI, w.g.but_posts_record_zero_selector);
        this.KI.setVisibility(0);
        this.Kg = 0;
        this.KJ.setVisibility(4);
        this.KK.setVisibility(4);
        this.KE.setVisibility(4);
        this.KH.setVisibility(4);
        aq.c(this.KG, w.e.cp_cont_c, 1);
        this.KG.setText(getContext().getString(w.l.voice_record_press_to_record));
    }

    public void reset() {
        lS();
        this.mModel = null;
        this.Kg = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.KF.setText("");
        this.KF.setVisibility(4);
        this.Kg = 0;
        lR();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
        if (z) {
            lS();
            this.KG.setText(getContext().getString(w.l.voice_record_release_to_stop));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStopingRecorder() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (this.KJ != null && this.KK != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    aq.c(this.KK, w.e.cp_cont_f, 1);
                    this.KK.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    aq.c(this.KJ, w.g.but_posts_record_play_selector);
                    this.KJ.setContentDescription(String.format(getContext().getString(w.l.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.KG.setText(getContext().getString(w.l.voice_play_tip));
                    lU();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    aq.c(this.KK, w.e.cp_cont_f, 1);
                    aq.c(this.KJ, w.g.but_posts_record_stop_selector);
                    this.KJ.setContentDescription(getContext().getString(w.l.pause));
                    this.KG.setText(getContext().getString(w.l.voice_stop_tip));
                    lT();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
        aq.c(this.KH, w.e.cp_cont_i, 1);
        aq.c(this.KF, w.e.cp_cont_i, 1);
        aq.c(this.KG, w.e.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.KH.setVisibility(0);
                this.KH.setText(str);
                postDelayed(new v(this), 2000L);
            } else if (i == 2) {
                this.KF.setVisibility(0);
                this.KF.setText(str);
                this.KG.setText(w.l.voice_record_press_to_record);
                postDelayed(new w(this), 2000L);
            } else if (i == 5) {
                this.KF.setVisibility(0);
                this.KF.setText(str);
                postDelayed(new x(this), 2000L);
            } else {
                lS();
                this.KF.setVisibility(0);
                this.KF.setText(str);
                postDelayed(new y(this), 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
        this.KF.setVisibility(4);
        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
        voiceModel.duration = i;
        voiceModel.isLocal = true;
        voiceModel.voiceId = str;
        voiceModel.voice_status = 1;
        a(voiceModel);
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onDeletedVoice(String str) {
        this.mModel = null;
        b(new com.baidu.tbadk.editortools.a(11, -1, str));
        b(new com.baidu.tbadk.editortools.a(2, 6, null));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecordTime(int i) {
        aq.c(this.KF, w.e.cp_cont_i, 1);
        this.KF.setVisibility(0);
        this.KF.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.JF = Math.max(i, this.JF);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.JG > 200) {
            this.JF = 0;
            this.JG = uptimeMillis;
        }
        if (this.JF < 10) {
            this.Kg = 1;
            invalidate();
        } else if (this.JF < 20) {
            this.Kg = 2;
            invalidate();
        } else if (this.JF < 30) {
            this.Kg = 3;
            invalidate();
        } else if (this.JF < 40) {
            this.Kg = 4;
            invalidate();
        } else {
            this.Kg = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aP(int i) {
        if (this.mModel != null && this.KK != null) {
            int i2 = i / 1000;
            if (this.KU != i2) {
                this.KK.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.KU = i2;
        }
    }

    private void lT() {
        if (this.mModel != null) {
            this.Kg = 0;
            this.KL = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.KP = SystemClock.uptimeMillis();
            this.KQ = this.KP + 200;
            this.KS.sendEmptyMessageAtTime(1, this.KQ);
            invalidate();
        }
    }

    private void lU() {
        this.Kg = 0;
        this.Kh = 0;
        this.KL = 0.0f;
        this.KM = 0.0f;
        this.KS.removeMessages(1);
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
            if (id == w.h.restart) {
                voiceManager.stopPlay();
                lQ();
            } else if (id == w.h.play_img && this.mModel != null) {
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

    public void setCallback(r rVar) {
        this.KN = rVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lV() {
    }

    public void lW() {
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
        this.Kr = new Paint();
        this.Kr.setAntiAlias(true);
        this.Kr.setStyle(Paint.Style.STROKE);
        this.Kr.setStrokeWidth(2.0f);
    }

    public void d(Canvas canvas) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            this.Ko.setColor(this.Kw);
            this.Kp.setColor(this.Kx);
            this.Kq.setColor(this.Ky);
            this.Kr.setColor(this.Kz);
        } else {
            this.Ko.setColor(this.Ks);
            this.Kp.setColor(this.Kt);
            this.Kq.setColor(this.Ku);
            this.Kr.setColor(this.Kv);
        }
        if (this.Kg == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.Ki, this.Ko);
        } else if (this.Kg == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.Ki, this.Ko);
            canvas.drawCircle(this.centerX, this.centerY, this.Kj, this.Kp);
        } else if (this.Kg == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.Ki, this.Ko);
            canvas.drawCircle(this.centerX, this.centerY, this.Kj, this.Kp);
            canvas.drawCircle(this.centerX, this.centerY, this.Kk, this.Kq);
        } else if (this.Kg == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.Ki, this.Ko);
            canvas.drawCircle(this.centerX, this.centerY, this.Kj, this.Kp);
            canvas.drawCircle(this.centerX, this.centerY, this.Kk, this.Kq);
            canvas.drawCircle(this.centerX, this.centerY, this.Kl, this.Kr);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.code == 9) {
            reset();
            b(new com.baidu.tbadk.editortools.a(2, 6, null));
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lO() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.JT;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JU != null) {
            this.JU.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.JU = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.JT = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
    }
}
