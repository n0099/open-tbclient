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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes.dex */
public class s extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.j, VoiceManager.b, ab {
    private int BG;
    private long BH;
    private int BU;
    private com.baidu.tbadk.editortools.l BV;
    private final int[] BZ;
    private int CA;
    private final BitmapDrawable CB;
    private final Paint CC;
    private final Rect CD;
    private final RectF CE;
    private TextView CF;
    private TextView CG;
    private TextView CH;
    private TextView CI;
    private VoiceButton CJ;
    private ImageView CK;
    private TextView CL;
    private float CM;
    private float CN;
    private r CO;
    private com.baidu.tbadk.core.dialog.a CP;
    private long CQ;
    private long CR;
    private final int[] CS;
    private final a CT;
    private SweepGradient CU;
    private int CV;
    private int Ca;
    private int Cb;
    private final int Cc;
    private final int Cd;
    private final int Ce;
    private final int Cf;
    private final int Cg;
    private int Ch;
    private int Ci;
    private int Cj;
    private int Ck;
    private int Cl;
    private int Cm;
    private int Cn;
    private int Co;
    private Paint Cp;
    private Paint Cq;
    private Paint Cr;
    private Paint Cs;
    private int Ct;
    private int Cu;
    private int Cv;
    private int Cw;
    private int Cx;
    private int Cy;
    private int Cz;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        private a() {
        }

        /* synthetic */ a(s sVar, a aVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (s.this.CN >= 360.0f) {
                    s.this.CN = 360.0f;
                    s.this.Ci = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    s.this.CQ = uptimeMillis;
                    s.this.CR = uptimeMillis + 200;
                    s.this.CN += (((float) (uptimeMillis - s.this.CQ)) / 1000.0f) * s.this.CM;
                    sendEmptyMessageAtTime(1, s.this.CR);
                    s.this.Ci++;
                }
                s.this.Ch = s.this.Ci % 6;
                s.this.invalidate();
            }
        }
    }

    public static s F(Context context) {
        return new s(context);
    }

    public s(Context context) {
        this(context, null);
    }

    public s(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.BH = 0L;
        this.BZ = new int[4];
        this.Ch = 0;
        this.Ci = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.Cj = 0;
        this.Ck = 0;
        this.Cl = 0;
        this.Cm = 0;
        this.Cn = 0;
        this.Co = 0;
        this.Ct = -1724676609;
        this.Cu = 1546880511;
        this.Cv = 674465279;
        this.Cw = 255034879;
        this.Cx = -1725669966;
        this.Cy = 1545887154;
        this.Cz = 673471922;
        this.CA = 254041522;
        this.CC = new Paint(1);
        this.CD = new Rect();
        this.CE = new RectF();
        this.BU = 0;
        this.CS = new int[2];
        this.CT = new a(this, null);
        this.BG = 0;
        this.CV = 0;
        this.BZ[0] = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_marginleft);
        this.BZ[1] = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_margintop);
        this.BZ[2] = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_marginright);
        this.BZ[3] = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_marginbottom);
        this.Cj = context.getResources().getDimensionPixelSize(t.e.ds134);
        this.Ck = this.Cj + context.getResources().getDimensionPixelSize(t.e.ds14);
        this.Cl = this.Ck + context.getResources().getDimensionPixelSize(t.e.ds16);
        this.Cm = this.Cl + context.getResources().getDimensionPixelSize(t.e.ds18);
        this.Cn = context.getResources().getDimensionPixelSize(t.e.ds70);
        this.Co = context.getResources().getDimensionPixelSize(t.e.ds210);
        this.Ca = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_paddingtop);
        this.Cb = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_restart_button_paddingleft);
        this.Cc = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_restart_button_paddingbottom);
        this.Cd = context.getResources().getDimensionPixelSize(t.e.ds4);
        this.Ce = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_dot_glow_padding);
        this.Cf = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_paint_stroke_width);
        this.Cg = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_progress_padding);
        this.CC.setStyle(Paint.Style.STROKE);
        this.CC.setStrokeWidth(this.Cf);
        this.CB = (BitmapDrawable) getResources().getDrawable(t.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        G(context);
        kK();
        this.CS[0] = at.getColor(t.d.record_voice_progress_start);
        this.CS[1] = at.getColor(t.d.record_voice_progress_end);
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
        this.Ca = ((i4 - getContext().getResources().getDimensionPixelSize(t.e.pb_editor_faceview_height)) / 2) + getContext().getResources().getDimensionPixelSize(t.e.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.CJ.getMeasuredWidth();
        int measuredHeight = this.CJ.getMeasuredHeight();
        int measuredWidth2 = this.CG.getMeasuredWidth();
        this.CG.layout((i5 - measuredWidth2) >> 1, this.Ca + i2, (measuredWidth2 + i5) >> 1, this.CG.getMeasuredHeight() + this.Ca + i2);
        int bottom = this.CG.getBottom();
        this.CJ.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.CI.getMeasuredWidth();
        int measuredHeight2 = this.CI.getMeasuredHeight();
        int top = this.CJ.getTop();
        this.CI.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.CF.getMeasuredWidth();
        int measuredHeight3 = this.CF.getMeasuredHeight();
        int right = this.CJ.getRight() - this.Cb;
        int bottom2 = this.CJ.getBottom() - this.Cc;
        this.CF.layout(this.Cn + i6, this.Co + bottom, measuredWidth4 + i6 + this.Cn, measuredHeight3 + this.Co + bottom);
        int measuredWidth5 = this.CK.getMeasuredWidth();
        this.CK.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.CK.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.CL.getMeasuredWidth();
        this.CL.layout((i5 - measuredWidth6) >> 1, (this.CF.getTop() - this.CL.getMeasuredHeight()) - this.Cd, (measuredWidth6 + i5) >> 1, (this.CF.getTop() + i2) - this.Cd);
        this.CJ.getLeft();
        this.CJ.getRight();
        int measuredWidth7 = this.CH.getMeasuredWidth();
        int measuredHeight4 = this.CH.getMeasuredHeight();
        int bottom3 = this.CJ.getBottom();
        this.CH.layout((i5 - measuredWidth7) >> 1, this.BZ[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.BZ[3]);
        this.CD.set((i5 - this.CB.getIntrinsicWidth()) >> 1, this.CK.getTop() - this.Ce, (i5 + this.CB.getIntrinsicHeight()) >> 1, (this.CK.getTop() + this.CB.getIntrinsicHeight()) - this.Ce);
        this.CB.setBounds(this.CD);
        this.CE.set(this.CK.getLeft() + (this.Cf >> 1) + this.Cg, this.CK.getTop() + (this.Cf >> 1) + this.Cg, (this.CK.getRight() - (this.Cf >> 1)) - this.Cg, (this.CK.getBottom() - (this.Cf >> 1)) - this.Cg);
        if (this.CU == null) {
            this.CU = new SweepGradient(this.CE.centerX(), this.CE.centerY(), this.CS, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.CU.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.CE.centerX(), this.CE.centerY());
            this.CU.setLocalMatrix(matrix);
            this.CC.setShader(this.CU);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        d(canvas);
        super.dispatchDraw(canvas);
    }

    private void kE() {
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.CP == null) {
            this.CP = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.l.s(getContext()).getPageActivity());
            this.CP.cA(getContext().getString(t.j.voice_restart_tip)).a(getContext().getString(t.j.voice_restart), new t(this, recorderManager)).b(getContext().getString(t.j.cancel), new u(this)).b(com.baidu.adp.base.l.s(getContext()));
        }
        try {
            this.CP.rV();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bK(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void G(Context context) {
        LayoutInflater.from(context).inflate(t.h.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.CG = (TextView) findViewById(t.g.tip_error);
        at.c(this.CG, t.d.cp_cont_i, 1);
        this.CH = (TextView) findViewById(t.g.tip_operator);
        this.CI = (TextView) findViewById(t.g.tip_time_out);
        this.CJ = (VoiceButton) findViewById(t.g.voice_bnt);
        this.CF = (TextView) findViewById(t.g.restart);
        this.CK = (ImageView) findViewById(t.g.play_img);
        this.CL = (TextView) findViewById(t.g.play_time);
        this.CL.setClickable(false);
        this.CF.setOnClickListener(this);
        this.CK.setOnClickListener(this);
        this.CJ.setRecorderView(this);
        kG();
    }

    private void kF() {
        this.CJ.setVisibility(4);
        this.CL.setVisibility(0);
        this.CF.setVisibility(0);
        at.c(this.CL, t.d.cp_cont_f, 1);
        at.c(this.CF, t.d.cp_cont_f, 1);
        at.k(this.CF, t.f.but_posts_record_again_selector);
        this.CK.setVisibility(0);
        if (this.mModel != null) {
            this.CL.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.CK.setContentDescription(String.format(getContext().getString(t.j.listen_time), Integer.valueOf(this.mModel.duration)));
            at.c(this.CK, t.f.but_posts_record_play_selector);
        }
        at.c(this.CH, t.d.cp_cont_c, 1);
        this.CH.setText(getContext().getString(t.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kG() {
        at.c(this.CJ, t.f.but_posts_record_zero_selector);
        this.CJ.setVisibility(0);
        this.Ch = 0;
        this.CK.setVisibility(4);
        this.CL.setVisibility(4);
        this.CF.setVisibility(4);
        this.CI.setVisibility(4);
        at.c(this.CH, t.d.cp_cont_c, 1);
        this.CH.setText(getContext().getString(t.j.voice_record_press_to_record));
    }

    public void reset() {
        kG();
        this.mModel = null;
        this.Ch = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.CG.setText("");
        this.CG.setVisibility(4);
        this.Ch = 0;
        kF();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
        if (z) {
            kG();
            this.CH.setText(getContext().getString(t.j.voice_record_release_to_stop));
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
        if (this.CK != null && this.CL != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    at.c(this.CL, t.d.cp_cont_f, 1);
                    this.CL.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    at.c(this.CK, t.f.but_posts_record_play_selector);
                    this.CK.setContentDescription(String.format(getContext().getString(t.j.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.CH.setText(getContext().getString(t.j.voice_play_tip));
                    kI();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    at.c(this.CL, t.d.cp_cont_f, 1);
                    at.c(this.CK, t.f.but_posts_record_stop_selector);
                    this.CK.setContentDescription(getContext().getString(t.j.pause));
                    this.CH.setText(getContext().getString(t.j.voice_stop_tip));
                    kH();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
        at.c(this.CI, t.d.cp_cont_i, 1);
        at.c(this.CG, t.d.cp_cont_i, 1);
        at.c(this.CH, t.d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.CI.setVisibility(0);
                this.CI.setText(str);
                postDelayed(new v(this), 2000L);
            } else if (i == 2) {
                this.CG.setVisibility(0);
                this.CG.setText(str);
                this.CH.setText(t.j.voice_record_press_to_record);
                postDelayed(new w(this), 2000L);
            } else if (i == 5) {
                this.CG.setVisibility(0);
                this.CG.setText(str);
                postDelayed(new x(this), 2000L);
            } else {
                kG();
                this.CG.setVisibility(0);
                this.CG.setText(str);
                postDelayed(new y(this), 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
        this.CG.setVisibility(4);
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
        at.c(this.CG, t.d.cp_cont_i, 1);
        this.CG.setVisibility(0);
        this.CG.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.BG = Math.max(i, this.BG);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.BH > 200) {
            this.BG = 0;
            this.BH = uptimeMillis;
        }
        if (this.BG < 10) {
            this.Ch = 1;
            invalidate();
        } else if (this.BG < 20) {
            this.Ch = 2;
            invalidate();
        } else if (this.BG < 30) {
            this.Ch = 3;
            invalidate();
        } else if (this.BG < 40) {
            this.Ch = 4;
            invalidate();
        } else {
            this.Ch = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aB(int i) {
        if (this.mModel != null && this.CL != null) {
            int i2 = i / 1000;
            if (this.CV != i2) {
                this.CL.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.CV = i2;
        }
    }

    private void kH() {
        if (this.mModel != null) {
            this.Ch = 0;
            this.CM = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.CQ = SystemClock.uptimeMillis();
            this.CR = this.CQ + 200;
            this.CT.sendEmptyMessageAtTime(1, this.CR);
            invalidate();
        }
    }

    private void kI() {
        this.Ch = 0;
        this.Ci = 0;
        this.CM = 0.0f;
        this.CN = 0.0f;
        this.CT.removeMessages(1);
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
            if (id == t.g.restart) {
                voiceManager.stopPlay();
                kE();
            } else if (id == t.g.play_img && this.mModel != null) {
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
        this.CO = rVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void kJ() {
    }

    public void kK() {
        this.Cp = new Paint();
        this.Cp.setAntiAlias(true);
        this.Cp.setStyle(Paint.Style.STROKE);
        this.Cp.setStrokeWidth(2.0f);
        this.Cq = new Paint();
        this.Cq.setAntiAlias(true);
        this.Cq.setStyle(Paint.Style.STROKE);
        this.Cq.setStrokeWidth(2.0f);
        this.Cr = new Paint();
        this.Cr.setAntiAlias(true);
        this.Cr.setStyle(Paint.Style.STROKE);
        this.Cr.setStrokeWidth(2.0f);
        this.Cs = new Paint();
        this.Cs.setAntiAlias(true);
        this.Cs.setStyle(Paint.Style.STROKE);
        this.Cs.setStrokeWidth(2.0f);
    }

    public void d(Canvas canvas) {
        if (TbadkCoreApplication.m11getInst().getSkinType() == 1) {
            this.Cp.setColor(this.Cx);
            this.Cq.setColor(this.Cy);
            this.Cr.setColor(this.Cz);
            this.Cs.setColor(this.CA);
        } else {
            this.Cp.setColor(this.Ct);
            this.Cq.setColor(this.Cu);
            this.Cr.setColor(this.Cv);
            this.Cs.setColor(this.Cw);
        }
        if (this.Ch == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.Cj, this.Cp);
        } else if (this.Ch == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.Cj, this.Cp);
            canvas.drawCircle(this.centerX, this.centerY, this.Ck, this.Cq);
        } else if (this.Ch == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.Cj, this.Cp);
            canvas.drawCircle(this.centerX, this.centerY, this.Ck, this.Cq);
            canvas.drawCircle(this.centerX, this.centerY, this.Cl, this.Cr);
        } else if (this.Ch == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.Cj, this.Cp);
            canvas.drawCircle(this.centerX, this.centerY, this.Ck, this.Cq);
            canvas.drawCircle(this.centerX, this.centerY, this.Cl, this.Cr);
            canvas.drawCircle(this.centerX, this.centerY, this.Cm, this.Cs);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.code == 9) {
            reset();
            b(new com.baidu.tbadk.editortools.a(2, 6, null));
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void kC() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.BU;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.BV != null) {
            this.BV.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.BV = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.BU = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
    }
}
