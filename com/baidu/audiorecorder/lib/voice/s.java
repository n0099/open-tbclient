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
    private int BH;
    private long BI;
    private int BV;
    private com.baidu.tbadk.editortools.l BW;
    private int CA;
    private int CB;
    private final BitmapDrawable CC;
    private final Paint CD;
    private final Rect CE;
    private final RectF CF;
    private TextView CG;
    private TextView CH;
    private TextView CI;
    private TextView CJ;
    private VoiceButton CK;
    private ImageView CL;
    private TextView CM;
    private float CN;
    private float CO;
    private r CP;
    private com.baidu.tbadk.core.dialog.a CQ;
    private long CR;
    private long CS;
    private final int[] CT;
    private final a CU;
    private SweepGradient CV;
    private int CW;
    private final int[] Ca;
    private int Cb;
    private int Cc;
    private final int Cd;
    private final int Ce;
    private final int Cf;
    private final int Cg;
    private final int Ch;
    private int Ci;
    private int Cj;
    private int Ck;
    private int Cl;
    private int Cm;
    private int Cn;
    private int Co;
    private int Cp;
    private Paint Cq;
    private Paint Cr;
    private Paint Cs;
    private Paint Ct;
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
                if (s.this.CO >= 360.0f) {
                    s.this.CO = 360.0f;
                    s.this.Cj = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    s.this.CR = uptimeMillis;
                    s.this.CS = uptimeMillis + 200;
                    s.this.CO += (((float) (uptimeMillis - s.this.CR)) / 1000.0f) * s.this.CN;
                    sendEmptyMessageAtTime(1, s.this.CS);
                    s.this.Cj++;
                }
                s.this.Ci = s.this.Cj % 6;
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
        this.BI = 0L;
        this.Ca = new int[4];
        this.Ci = 0;
        this.Cj = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.Ck = 0;
        this.Cl = 0;
        this.Cm = 0;
        this.Cn = 0;
        this.Co = 0;
        this.Cp = 0;
        this.Cu = -1724676609;
        this.Cv = 1546880511;
        this.Cw = 674465279;
        this.Cx = 255034879;
        this.Cy = -1725669966;
        this.Cz = 1545887154;
        this.CA = 673471922;
        this.CB = 254041522;
        this.CD = new Paint(1);
        this.CE = new Rect();
        this.CF = new RectF();
        this.BV = 0;
        this.CT = new int[2];
        this.CU = new a(this, null);
        this.BH = 0;
        this.CW = 0;
        this.Ca[0] = context.getResources().getDimensionPixelSize(u.e.ds24);
        this.Ca[1] = context.getResources().getDimensionPixelSize(u.e.ds8);
        this.Ca[2] = context.getResources().getDimensionPixelSize(u.e.ds22);
        this.Ca[3] = context.getResources().getDimensionPixelSize(u.e.ds36);
        this.Ck = context.getResources().getDimensionPixelSize(u.e.ds134);
        this.Cl = this.Ck + context.getResources().getDimensionPixelSize(u.e.ds14);
        this.Cm = this.Cl + context.getResources().getDimensionPixelSize(u.e.ds16);
        this.Cn = this.Cm + context.getResources().getDimensionPixelSize(u.e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.Co = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.Cp = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.Co = context.getResources().getDimensionPixelSize(u.e.ds70);
            this.Cp = context.getResources().getDimensionPixelSize(u.e.ds210);
        }
        this.Cb = context.getResources().getDimensionPixelSize(u.e.ds26);
        this.Cc = context.getResources().getDimensionPixelSize(u.e.ds10);
        this.Cd = context.getResources().getDimensionPixelSize(u.e.ds14);
        this.Ce = context.getResources().getDimensionPixelSize(u.e.ds4);
        this.Cf = context.getResources().getDimensionPixelSize(u.e.ds4);
        this.Cg = context.getResources().getDimensionPixelSize(u.e.ds12);
        this.Ch = context.getResources().getDimensionPixelSize(u.e.ds2);
        this.CD.setStyle(Paint.Style.STROKE);
        this.CD.setStrokeWidth(this.Cg);
        this.CC = (BitmapDrawable) getResources().getDrawable(u.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        F(context);
        kN();
        this.CT[0] = av.getColor(u.d.common_color_10151);
        this.CT[1] = av.getColor(u.d.common_color_10152);
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
        this.Cb = ((i4 - getContext().getResources().getDimensionPixelSize(u.e.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(u.e.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.CK.getMeasuredWidth();
        int measuredHeight = this.CK.getMeasuredHeight();
        int measuredWidth2 = this.CH.getMeasuredWidth();
        this.CH.layout((i5 - measuredWidth2) >> 1, this.Cb + i2, (measuredWidth2 + i5) >> 1, this.CH.getMeasuredHeight() + this.Cb + i2);
        int bottom = this.CH.getBottom();
        this.CK.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.CJ.getMeasuredWidth();
        int measuredHeight2 = this.CJ.getMeasuredHeight();
        int top = this.CK.getTop();
        this.CJ.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.CG.getMeasuredWidth();
        int measuredHeight3 = this.CG.getMeasuredHeight();
        int right = this.CK.getRight() - this.Cc;
        int bottom2 = this.CK.getBottom() - this.Cd;
        this.CG.layout(this.Co + i6, this.Cp + bottom, measuredWidth4 + i6 + this.Co, measuredHeight3 + this.Cp + bottom);
        int measuredWidth5 = this.CL.getMeasuredWidth();
        this.CL.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.CL.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.CM.getMeasuredWidth();
        this.CM.layout((i5 - measuredWidth6) >> 1, (this.CG.getTop() - this.CM.getMeasuredHeight()) - this.Ce, (measuredWidth6 + i5) >> 1, (this.CG.getTop() + i2) - this.Ce);
        this.CK.getLeft();
        this.CK.getRight();
        int measuredWidth7 = this.CI.getMeasuredWidth();
        int measuredHeight4 = this.CI.getMeasuredHeight();
        int bottom3 = this.CK.getBottom();
        this.CI.layout((i5 - measuredWidth7) >> 1, this.Ca[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.Ca[3]);
        this.CE.set((i5 - this.CC.getIntrinsicWidth()) >> 1, this.CL.getTop() - this.Cf, (i5 + this.CC.getIntrinsicHeight()) >> 1, (this.CL.getTop() + this.CC.getIntrinsicHeight()) - this.Cf);
        this.CC.setBounds(this.CE);
        this.CF.set(this.CL.getLeft() + (this.Cg >> 1) + this.Ch, this.CL.getTop() + (this.Cg >> 1) + this.Ch, (this.CL.getRight() - (this.Cg >> 1)) - this.Ch, (this.CL.getBottom() - (this.Cg >> 1)) - this.Ch);
        if (this.CV == null) {
            this.CV = new SweepGradient(this.CF.centerX(), this.CF.centerY(), this.CT, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.CV.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.CF.centerX(), this.CF.centerY());
            this.CV.setLocalMatrix(matrix);
            this.CD.setShader(this.CV);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        d(canvas);
        super.dispatchDraw(canvas);
    }

    private void kH() {
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.CQ == null) {
            this.CQ = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.l.s(getContext()).getPageActivity());
            this.CQ.cz(getContext().getString(u.j.voice_restart_tip)).a(getContext().getString(u.j.voice_restart), new t(this, recorderManager)).b(getContext().getString(u.j.cancel), new u(this)).b(com.baidu.adp.base.l.s(getContext()));
        }
        try {
            this.CQ.rT();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bK(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void F(Context context) {
        LayoutInflater.from(context).inflate(u.h.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.CH = (TextView) findViewById(u.g.tip_error);
        av.c(this.CH, u.d.cp_cont_i, 1);
        this.CI = (TextView) findViewById(u.g.tip_operator);
        this.CJ = (TextView) findViewById(u.g.tip_time_out);
        this.CK = (VoiceButton) findViewById(u.g.voice_bnt);
        this.CG = (TextView) findViewById(u.g.restart);
        this.CL = (ImageView) findViewById(u.g.play_img);
        this.CM = (TextView) findViewById(u.g.play_time);
        this.CM.setClickable(false);
        this.CG.setOnClickListener(this);
        this.CL.setOnClickListener(this);
        this.CK.setRecorderView(this);
        kJ();
    }

    private void kI() {
        this.CK.setVisibility(4);
        this.CM.setVisibility(0);
        this.CG.setVisibility(0);
        av.c(this.CM, u.d.cp_cont_f, 1);
        av.c(this.CG, u.d.cp_cont_f, 1);
        av.k(this.CG, u.f.but_posts_record_again_selector);
        this.CL.setVisibility(0);
        if (this.mModel != null) {
            this.CM.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.CL.setContentDescription(String.format(getContext().getString(u.j.listen_time), Integer.valueOf(this.mModel.duration)));
            av.c(this.CL, u.f.but_posts_record_play_selector);
        }
        av.c(this.CI, u.d.cp_cont_c, 1);
        this.CI.setText(getContext().getString(u.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kJ() {
        av.c(this.CK, u.f.but_posts_record_zero_selector);
        this.CK.setVisibility(0);
        this.Ci = 0;
        this.CL.setVisibility(4);
        this.CM.setVisibility(4);
        this.CG.setVisibility(4);
        this.CJ.setVisibility(4);
        av.c(this.CI, u.d.cp_cont_c, 1);
        this.CI.setText(getContext().getString(u.j.voice_record_press_to_record));
    }

    public void reset() {
        kJ();
        this.mModel = null;
        this.Ci = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.CH.setText("");
        this.CH.setVisibility(4);
        this.Ci = 0;
        kI();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
        if (z) {
            kJ();
            this.CI.setText(getContext().getString(u.j.voice_record_release_to_stop));
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
        if (this.CL != null && this.CM != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    av.c(this.CM, u.d.cp_cont_f, 1);
                    this.CM.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    av.c(this.CL, u.f.but_posts_record_play_selector);
                    this.CL.setContentDescription(String.format(getContext().getString(u.j.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.CI.setText(getContext().getString(u.j.voice_play_tip));
                    kL();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    av.c(this.CM, u.d.cp_cont_f, 1);
                    av.c(this.CL, u.f.but_posts_record_stop_selector);
                    this.CL.setContentDescription(getContext().getString(u.j.pause));
                    this.CI.setText(getContext().getString(u.j.voice_stop_tip));
                    kK();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
        av.c(this.CJ, u.d.cp_cont_i, 1);
        av.c(this.CH, u.d.cp_cont_i, 1);
        av.c(this.CI, u.d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.CJ.setVisibility(0);
                this.CJ.setText(str);
                postDelayed(new v(this), 2000L);
            } else if (i == 2) {
                this.CH.setVisibility(0);
                this.CH.setText(str);
                this.CI.setText(u.j.voice_record_press_to_record);
                postDelayed(new w(this), 2000L);
            } else if (i == 5) {
                this.CH.setVisibility(0);
                this.CH.setText(str);
                postDelayed(new x(this), 2000L);
            } else {
                kJ();
                this.CH.setVisibility(0);
                this.CH.setText(str);
                postDelayed(new y(this), 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
        this.CH.setVisibility(4);
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
        av.c(this.CH, u.d.cp_cont_i, 1);
        this.CH.setVisibility(0);
        this.CH.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.BH = Math.max(i, this.BH);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.BI > 200) {
            this.BH = 0;
            this.BI = uptimeMillis;
        }
        if (this.BH < 10) {
            this.Ci = 1;
            invalidate();
        } else if (this.BH < 20) {
            this.Ci = 2;
            invalidate();
        } else if (this.BH < 30) {
            this.Ci = 3;
            invalidate();
        } else if (this.BH < 40) {
            this.Ci = 4;
            invalidate();
        } else {
            this.Ci = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aC(int i) {
        if (this.mModel != null && this.CM != null) {
            int i2 = i / 1000;
            if (this.CW != i2) {
                this.CM.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.CW = i2;
        }
    }

    private void kK() {
        if (this.mModel != null) {
            this.Ci = 0;
            this.CN = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.CR = SystemClock.uptimeMillis();
            this.CS = this.CR + 200;
            this.CU.sendEmptyMessageAtTime(1, this.CS);
            invalidate();
        }
    }

    private void kL() {
        this.Ci = 0;
        this.Cj = 0;
        this.CN = 0.0f;
        this.CO = 0.0f;
        this.CU.removeMessages(1);
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
                kH();
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
        this.CP = rVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void kM() {
    }

    public void kN() {
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
        this.Ct = new Paint();
        this.Ct.setAntiAlias(true);
        this.Ct.setStyle(Paint.Style.STROKE);
        this.Ct.setStrokeWidth(2.0f);
    }

    public void d(Canvas canvas) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            this.Cq.setColor(this.Cy);
            this.Cr.setColor(this.Cz);
            this.Cs.setColor(this.CA);
            this.Ct.setColor(this.CB);
        } else {
            this.Cq.setColor(this.Cu);
            this.Cr.setColor(this.Cv);
            this.Cs.setColor(this.Cw);
            this.Ct.setColor(this.Cx);
        }
        if (this.Ci == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.Ck, this.Cq);
        } else if (this.Ci == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.Ck, this.Cq);
            canvas.drawCircle(this.centerX, this.centerY, this.Cl, this.Cr);
        } else if (this.Ci == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.Ck, this.Cq);
            canvas.drawCircle(this.centerX, this.centerY, this.Cl, this.Cr);
            canvas.drawCircle(this.centerX, this.centerY, this.Cm, this.Cs);
        } else if (this.Ci == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.Ck, this.Cq);
            canvas.drawCircle(this.centerX, this.centerY, this.Cl, this.Cr);
            canvas.drawCircle(this.centerX, this.centerY, this.Cm, this.Cs);
            canvas.drawCircle(this.centerX, this.centerY, this.Cn, this.Ct);
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
    public void kF() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.BV;
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
        if (this.BW != null) {
            this.BW.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.BW = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.BV = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
    }
}
