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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class s extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.j, VoiceManager.b, ab {
    private final int[] CA;
    private int CB;
    private int CC;
    private final int CD;
    private final int CE;
    private final int CF;
    private final int CG;
    private final int CH;
    private int CI;
    private int CJ;
    private int CK;
    private int CL;
    private int CM;
    private int CN;
    private int CO;
    private int CP;
    private Paint CQ;
    private Paint CR;
    private Paint CS;
    private Paint CT;
    private int CU;
    private int CV;
    private int CW;
    private int CX;
    private int CY;
    private int CZ;
    private int Ch;
    private long Ci;
    private int Cv;
    private com.baidu.tbadk.editortools.l Cw;
    private int Da;
    private int Db;
    private final BitmapDrawable Dc;
    private final Paint Dd;
    private final Rect De;
    private final RectF Df;
    private TextView Dg;
    private TextView Dh;
    private TextView Di;
    private TextView Dj;
    private VoiceButton Dk;
    private ImageView Dl;
    private TextView Dm;
    private float Dn;
    private float Do;
    private r Dp;
    private com.baidu.tbadk.core.dialog.a Dq;
    private long Dr;
    private long Ds;
    private final int[] Dt;
    private final a Du;
    private SweepGradient Dv;
    private int Dw;
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
                if (s.this.Do >= 360.0f) {
                    s.this.Do = 360.0f;
                    s.this.CJ = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    s.this.Dr = uptimeMillis;
                    s.this.Ds = uptimeMillis + 200;
                    s.this.Do += (((float) (uptimeMillis - s.this.Dr)) / 1000.0f) * s.this.Dn;
                    sendEmptyMessageAtTime(1, s.this.Ds);
                    s.this.CJ++;
                }
                s.this.CI = s.this.CJ % 6;
                s.this.invalidate();
            }
        }
    }

    public static s E(Context context) {
        return new s(context);
    }

    public s(Context context) {
        this(context, null);
    }

    public s(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ci = 0L;
        this.CA = new int[4];
        this.CI = 0;
        this.CJ = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.CK = 0;
        this.CL = 0;
        this.CM = 0;
        this.CN = 0;
        this.CO = 0;
        this.CP = 0;
        this.CU = -1724676609;
        this.CV = 1546880511;
        this.CW = 674465279;
        this.CX = 255034879;
        this.CY = -1725669966;
        this.CZ = 1545887154;
        this.Da = 673471922;
        this.Db = 254041522;
        this.Dd = new Paint(1);
        this.De = new Rect();
        this.Df = new RectF();
        this.Cv = 0;
        this.Dt = new int[2];
        this.Du = new a(this, null);
        this.Ch = 0;
        this.Dw = 0;
        this.CA[0] = context.getResources().getDimensionPixelSize(u.e.ds24);
        this.CA[1] = context.getResources().getDimensionPixelSize(u.e.ds8);
        this.CA[2] = context.getResources().getDimensionPixelSize(u.e.ds22);
        this.CA[3] = context.getResources().getDimensionPixelSize(u.e.ds36);
        this.CK = context.getResources().getDimensionPixelSize(u.e.ds134);
        this.CL = this.CK + context.getResources().getDimensionPixelSize(u.e.ds14);
        this.CM = this.CL + context.getResources().getDimensionPixelSize(u.e.ds16);
        this.CN = this.CM + context.getResources().getDimensionPixelSize(u.e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.CO = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.CP = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.CO = context.getResources().getDimensionPixelSize(u.e.ds70);
            this.CP = context.getResources().getDimensionPixelSize(u.e.ds210);
        }
        this.CB = context.getResources().getDimensionPixelSize(u.e.ds26);
        this.CC = context.getResources().getDimensionPixelSize(u.e.ds10);
        this.CD = context.getResources().getDimensionPixelSize(u.e.ds14);
        this.CE = context.getResources().getDimensionPixelSize(u.e.ds4);
        this.CF = context.getResources().getDimensionPixelSize(u.e.ds4);
        this.CG = context.getResources().getDimensionPixelSize(u.e.ds12);
        this.CH = context.getResources().getDimensionPixelSize(u.e.ds2);
        this.Dd.setStyle(Paint.Style.STROKE);
        this.Dd.setStrokeWidth(this.CG);
        this.Dc = (BitmapDrawable) getResources().getDrawable(u.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        F(context);
        kJ();
        this.Dt[0] = av.getColor(u.d.common_color_10151);
        this.Dt[1] = av.getColor(u.d.common_color_10152);
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
        this.CB = ((i4 - getContext().getResources().getDimensionPixelSize(u.e.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(u.e.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.Dk.getMeasuredWidth();
        int measuredHeight = this.Dk.getMeasuredHeight();
        int measuredWidth2 = this.Dh.getMeasuredWidth();
        this.Dh.layout((i5 - measuredWidth2) >> 1, this.CB + i2, (measuredWidth2 + i5) >> 1, this.Dh.getMeasuredHeight() + this.CB + i2);
        int bottom = this.Dh.getBottom();
        this.Dk.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Dj.getMeasuredWidth();
        int measuredHeight2 = this.Dj.getMeasuredHeight();
        int top = this.Dk.getTop();
        this.Dj.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Dg.getMeasuredWidth();
        int measuredHeight3 = this.Dg.getMeasuredHeight();
        int right = this.Dk.getRight() - this.CC;
        int bottom2 = this.Dk.getBottom() - this.CD;
        this.Dg.layout(this.CO + i6, this.CP + bottom, measuredWidth4 + i6 + this.CO, measuredHeight3 + this.CP + bottom);
        int measuredWidth5 = this.Dl.getMeasuredWidth();
        this.Dl.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Dl.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Dm.getMeasuredWidth();
        this.Dm.layout((i5 - measuredWidth6) >> 1, (this.Dg.getTop() - this.Dm.getMeasuredHeight()) - this.CE, (measuredWidth6 + i5) >> 1, (this.Dg.getTop() + i2) - this.CE);
        this.Dk.getLeft();
        this.Dk.getRight();
        int measuredWidth7 = this.Di.getMeasuredWidth();
        int measuredHeight4 = this.Di.getMeasuredHeight();
        int bottom3 = this.Dk.getBottom();
        this.Di.layout((i5 - measuredWidth7) >> 1, this.CA[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.CA[3]);
        this.De.set((i5 - this.Dc.getIntrinsicWidth()) >> 1, this.Dl.getTop() - this.CF, (i5 + this.Dc.getIntrinsicHeight()) >> 1, (this.Dl.getTop() + this.Dc.getIntrinsicHeight()) - this.CF);
        this.Dc.setBounds(this.De);
        this.Df.set(this.Dl.getLeft() + (this.CG >> 1) + this.CH, this.Dl.getTop() + (this.CG >> 1) + this.CH, (this.Dl.getRight() - (this.CG >> 1)) - this.CH, (this.Dl.getBottom() - (this.CG >> 1)) - this.CH);
        if (this.Dv == null) {
            this.Dv = new SweepGradient(this.Df.centerX(), this.Df.centerY(), this.Dt, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Dv.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Df.centerX(), this.Df.centerY());
            this.Dv.setLocalMatrix(matrix);
            this.Dd.setShader(this.Dv);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        d(canvas);
        super.dispatchDraw(canvas);
    }

    private void kD() {
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Dq == null) {
            this.Dq = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.l.s(getContext()).getPageActivity());
            this.Dq.cz(getContext().getString(u.j.voice_restart_tip)).a(getContext().getString(u.j.voice_restart), new t(this, recorderManager)).b(getContext().getString(u.j.cancel), new u(this)).b(com.baidu.adp.base.l.s(getContext()));
        }
        try {
            this.Dq.rS();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bL(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void F(Context context) {
        LayoutInflater.from(context).inflate(u.h.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.Dh = (TextView) findViewById(u.g.tip_error);
        av.c(this.Dh, u.d.cp_cont_i, 1);
        this.Di = (TextView) findViewById(u.g.tip_operator);
        this.Dj = (TextView) findViewById(u.g.tip_time_out);
        this.Dk = (VoiceButton) findViewById(u.g.voice_bnt);
        this.Dg = (TextView) findViewById(u.g.restart);
        this.Dl = (ImageView) findViewById(u.g.play_img);
        this.Dm = (TextView) findViewById(u.g.play_time);
        this.Dm.setClickable(false);
        this.Dg.setOnClickListener(this);
        this.Dl.setOnClickListener(this);
        this.Dk.setRecorderView(this);
        kF();
    }

    private void kE() {
        this.Dk.setVisibility(4);
        this.Dm.setVisibility(0);
        this.Dg.setVisibility(0);
        av.c(this.Dm, u.d.cp_cont_f, 1);
        av.c(this.Dg, u.d.cp_cont_f, 1);
        av.k(this.Dg, u.f.but_posts_record_again_selector);
        this.Dl.setVisibility(0);
        if (this.mModel != null) {
            this.Dm.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Dl.setContentDescription(String.format(getContext().getString(u.j.listen_time), Integer.valueOf(this.mModel.duration)));
            av.c(this.Dl, u.f.but_posts_record_play_selector);
        }
        av.c(this.Di, u.d.cp_cont_c, 1);
        this.Di.setText(getContext().getString(u.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kF() {
        av.c(this.Dk, u.f.but_posts_record_zero_selector);
        this.Dk.setVisibility(0);
        this.CI = 0;
        this.Dl.setVisibility(4);
        this.Dm.setVisibility(4);
        this.Dg.setVisibility(4);
        this.Dj.setVisibility(4);
        av.c(this.Di, u.d.cp_cont_c, 1);
        this.Di.setText(getContext().getString(u.j.voice_record_press_to_record));
    }

    public void reset() {
        kF();
        this.mModel = null;
        this.CI = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Dh.setText("");
        this.Dh.setVisibility(4);
        this.CI = 0;
        kE();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
        if (z) {
            kF();
            this.Di.setText(getContext().getString(u.j.voice_record_release_to_stop));
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
        if (this.Dl != null && this.Dm != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    av.c(this.Dm, u.d.cp_cont_f, 1);
                    this.Dm.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    av.c(this.Dl, u.f.but_posts_record_play_selector);
                    this.Dl.setContentDescription(String.format(getContext().getString(u.j.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Di.setText(getContext().getString(u.j.voice_play_tip));
                    kH();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    av.c(this.Dm, u.d.cp_cont_f, 1);
                    av.c(this.Dl, u.f.but_posts_record_stop_selector);
                    this.Dl.setContentDescription(getContext().getString(u.j.pause));
                    this.Di.setText(getContext().getString(u.j.voice_stop_tip));
                    kG();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
        av.c(this.Dj, u.d.cp_cont_i, 1);
        av.c(this.Dh, u.d.cp_cont_i, 1);
        av.c(this.Di, u.d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Dj.setVisibility(0);
                this.Dj.setText(str);
                postDelayed(new v(this), 2000L);
            } else if (i == 2) {
                this.Dh.setVisibility(0);
                this.Dh.setText(str);
                this.Di.setText(u.j.voice_record_press_to_record);
                postDelayed(new w(this), 2000L);
            } else if (i == 5) {
                this.Dh.setVisibility(0);
                this.Dh.setText(str);
                postDelayed(new x(this), 2000L);
            } else {
                kF();
                this.Dh.setVisibility(0);
                this.Dh.setText(str);
                postDelayed(new y(this), 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
        this.Dh.setVisibility(4);
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
        av.c(this.Dh, u.d.cp_cont_i, 1);
        this.Dh.setVisibility(0);
        this.Dh.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.Ch = Math.max(i, this.Ch);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Ci > 200) {
            this.Ch = 0;
            this.Ci = uptimeMillis;
        }
        if (this.Ch < 10) {
            this.CI = 1;
            invalidate();
        } else if (this.Ch < 20) {
            this.CI = 2;
            invalidate();
        } else if (this.Ch < 30) {
            this.CI = 3;
            invalidate();
        } else if (this.Ch < 40) {
            this.CI = 4;
            invalidate();
        } else {
            this.CI = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aF(int i) {
        if (this.mModel != null && this.Dm != null) {
            int i2 = i / 1000;
            if (this.Dw != i2) {
                this.Dm.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Dw = i2;
        }
    }

    private void kG() {
        if (this.mModel != null) {
            this.CI = 0;
            this.Dn = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Dr = SystemClock.uptimeMillis();
            this.Ds = this.Dr + 200;
            this.Du.sendEmptyMessageAtTime(1, this.Ds);
            invalidate();
        }
    }

    private void kH() {
        this.CI = 0;
        this.CJ = 0;
        this.Dn = 0.0f;
        this.Do = 0.0f;
        this.Du.removeMessages(1);
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
            if (id == u.g.restart) {
                voiceManager.stopPlay();
                kD();
            } else if (id == u.g.play_img && this.mModel != null) {
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
        this.Dp = rVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void kI() {
    }

    public void kJ() {
        this.CQ = new Paint();
        this.CQ.setAntiAlias(true);
        this.CQ.setStyle(Paint.Style.STROKE);
        this.CQ.setStrokeWidth(2.0f);
        this.CR = new Paint();
        this.CR.setAntiAlias(true);
        this.CR.setStyle(Paint.Style.STROKE);
        this.CR.setStrokeWidth(2.0f);
        this.CS = new Paint();
        this.CS.setAntiAlias(true);
        this.CS.setStyle(Paint.Style.STROKE);
        this.CS.setStrokeWidth(2.0f);
        this.CT = new Paint();
        this.CT.setAntiAlias(true);
        this.CT.setStyle(Paint.Style.STROKE);
        this.CT.setStrokeWidth(2.0f);
    }

    public void d(Canvas canvas) {
        if (TbadkCoreApplication.m10getInst().getSkinType() == 1) {
            this.CQ.setColor(this.CY);
            this.CR.setColor(this.CZ);
            this.CS.setColor(this.Da);
            this.CT.setColor(this.Db);
        } else {
            this.CQ.setColor(this.CU);
            this.CR.setColor(this.CV);
            this.CS.setColor(this.CW);
            this.CT.setColor(this.CX);
        }
        if (this.CI == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.CK, this.CQ);
        } else if (this.CI == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.CK, this.CQ);
            canvas.drawCircle(this.centerX, this.centerY, this.CL, this.CR);
        } else if (this.CI == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.CK, this.CQ);
            canvas.drawCircle(this.centerX, this.centerY, this.CL, this.CR);
            canvas.drawCircle(this.centerX, this.centerY, this.CM, this.CS);
        } else if (this.CI == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.CK, this.CQ);
            canvas.drawCircle(this.centerX, this.centerY, this.CL, this.CR);
            canvas.drawCircle(this.centerX, this.centerY, this.CM, this.CS);
            canvas.drawCircle(this.centerX, this.centerY, this.CN, this.CT);
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
    public void kB() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.Cv;
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
        if (this.Cw != null) {
            this.Cw.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.Cw = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.Cv = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
    }
}
