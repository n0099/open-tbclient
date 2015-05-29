package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes.dex */
public class u extends com.baidu.tieba.tbadkCore.voice.b implements View.OnClickListener, com.baidu.adp.lib.voice.j, com.baidu.tbadk.core.voice.i {
    private final int KA;
    private final int KB;
    private final int KC;
    private int KD;
    private int KE;
    private int KF;
    private int KG;
    private int KH;
    private int KI;
    private int KJ;
    private int KK;
    private Paint KL;
    private Paint KM;
    private Paint KN;
    private Paint KO;
    private int KP;
    private int KQ;
    private int KR;
    private int KS;
    private int KT;
    private int KU;
    private int KV;
    private int KW;
    private final BitmapDrawable KX;
    private final Paint KY;
    private final Rect KZ;
    private int Kh;
    private long Ki;
    private final int[] Kv;
    private int Kw;
    private int Kx;
    private final int Ky;
    private final int Kz;
    private final RectF La;
    private TextView Lb;
    private TextView Lc;
    private TextView Ld;
    private TextView Le;
    private VoiceButton Lf;
    private ImageView Lg;
    private TextView Lh;
    private float Li;
    private float Lj;
    private com.baidu.tieba.tbadkCore.voice.c Lk;
    private com.baidu.tbadk.core.dialog.a Ll;
    private long Lm;
    private long Ln;
    private final int[] Lo;
    private final ab Lp;
    private SweepGradient Lq;
    private int Lr;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;

    public static u Q(Context context) {
        return new u(context);
    }

    public u(Context context) {
        this(context, null);
    }

    public u(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ki = 0L;
        this.Kv = new int[4];
        this.KD = 0;
        this.KE = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.KF = 0;
        this.KG = 0;
        this.KH = 0;
        this.KI = 0;
        this.KJ = 0;
        this.KK = 0;
        this.KP = -1724676609;
        this.KQ = 1546880511;
        this.KR = 674465279;
        this.KS = 255034879;
        this.KT = -1725669966;
        this.KU = 1545887154;
        this.KV = 673471922;
        this.KW = 254041522;
        this.KY = new Paint(1);
        this.KZ = new Rect();
        this.La = new RectF();
        this.Lo = new int[2];
        this.Lp = new ab(this, null);
        this.Kh = 0;
        this.Lr = 0;
        this.Kv[0] = context.getResources().getDimensionPixelSize(com.baidu.tieba.o.record_voice_btn_marginleft);
        this.Kv[1] = context.getResources().getDimensionPixelSize(com.baidu.tieba.o.record_voice_btn_margintop);
        this.Kv[2] = context.getResources().getDimensionPixelSize(com.baidu.tieba.o.record_voice_btn_marginright);
        this.Kv[3] = context.getResources().getDimensionPixelSize(com.baidu.tieba.o.record_voice_btn_marginbottom);
        this.KF = context.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds134);
        this.KG = this.KF + context.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds14);
        this.KH = this.KG + context.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds16);
        this.KI = this.KH + context.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds18);
        this.KJ = context.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds70);
        this.KK = context.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds210);
        this.Kw = context.getResources().getDimensionPixelSize(com.baidu.tieba.o.record_voice_btn_paddingtop);
        this.Kx = context.getResources().getDimensionPixelSize(com.baidu.tieba.o.record_voice_btn_restart_button_paddingleft);
        this.Ky = context.getResources().getDimensionPixelSize(com.baidu.tieba.o.record_voice_btn_restart_button_paddingbottom);
        this.Kz = context.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds4);
        this.KA = context.getResources().getDimensionPixelSize(com.baidu.tieba.o.record_voice_btn_dot_glow_padding);
        this.KB = context.getResources().getDimensionPixelSize(com.baidu.tieba.o.record_voice_btn_paint_stroke_width);
        this.KC = context.getResources().getDimensionPixelSize(com.baidu.tieba.o.record_voice_btn_progress_padding);
        this.KY.setStyle(Paint.Style.STROKE);
        this.KY.setStrokeWidth(this.KB);
        this.KX = (BitmapDrawable) getResources().getDrawable(com.baidu.tieba.p.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        R(context);
        ox();
        this.Lo[0] = ay.getColor(com.baidu.tieba.n.record_voice_progress_start);
        this.Lo[1] = ay.getColor(com.baidu.tieba.n.record_voice_progress_end);
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
        this.Kw = ((i4 - getContext().getResources().getDimensionPixelSize(com.baidu.tieba.o.pb_editor_faceview_height)) / 2) + getContext().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.Lf.getMeasuredWidth();
        int measuredHeight = this.Lf.getMeasuredHeight();
        int measuredWidth2 = this.Lc.getMeasuredWidth();
        this.Lc.layout((i5 - measuredWidth2) >> 1, this.Kw + i2, (measuredWidth2 + i5) >> 1, this.Lc.getMeasuredHeight() + this.Kw + i2);
        int bottom = this.Lc.getBottom();
        this.Lf.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Le.getMeasuredWidth();
        int measuredHeight2 = this.Le.getMeasuredHeight();
        int top = this.Lf.getTop();
        this.Le.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Lb.getMeasuredWidth();
        int measuredHeight3 = this.Lb.getMeasuredHeight();
        int right = this.Lf.getRight() - this.Kx;
        int bottom2 = this.Lf.getBottom() - this.Ky;
        this.Lb.layout(this.KJ + i6, this.KK + bottom, measuredWidth4 + i6 + this.KJ, measuredHeight3 + this.KK + bottom);
        int measuredWidth5 = this.Lg.getMeasuredWidth();
        this.Lg.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Lg.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Lh.getMeasuredWidth();
        this.Lh.layout((i5 - measuredWidth6) >> 1, (this.Lb.getTop() - this.Lh.getMeasuredHeight()) - this.Kz, (measuredWidth6 + i5) >> 1, (this.Lb.getTop() + i2) - this.Kz);
        this.Lf.getLeft();
        this.Lf.getRight();
        int measuredWidth7 = this.Ld.getMeasuredWidth();
        int measuredHeight4 = this.Ld.getMeasuredHeight();
        int bottom3 = this.Lf.getBottom();
        this.Ld.layout((i5 - measuredWidth7) >> 1, this.Kv[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.Kv[3]);
        this.KZ.set((i5 - this.KX.getIntrinsicWidth()) >> 1, this.Lg.getTop() - this.KA, (i5 + this.KX.getIntrinsicHeight()) >> 1, (this.Lg.getTop() + this.KX.getIntrinsicHeight()) - this.KA);
        this.KX.setBounds(this.KZ);
        this.La.set(this.Lg.getLeft() + (this.KB >> 1) + this.KC, this.Lg.getTop() + (this.KB >> 1) + this.KC, (this.Lg.getRight() - (this.KB >> 1)) - this.KC, (this.Lg.getBottom() - (this.KB >> 1)) - this.KC);
        if (this.Lq == null) {
            this.Lq = new SweepGradient(this.La.centerX(), this.La.centerY(), this.Lo, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Lq.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.La.centerX(), this.La.centerY());
            this.Lq.setLocalMatrix(matrix);
            this.KY.setShader(this.Lq);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    private void oq() {
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Ll == null) {
            this.Ll = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.n.D(getContext()).getPageActivity());
            this.Ll.cn(getContext().getString(com.baidu.tieba.t.voice_restart_tip)).a(getContext().getString(com.baidu.tieba.t.voice_restart), new v(this, recorderManager)).b(getContext().getString(com.baidu.tieba.t.cancel), new w(this)).b(com.baidu.adp.base.n.D(getContext()));
        }
        try {
            this.Ll.rL();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bO(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void R(Context context) {
        com.baidu.adp.lib.g.b.hr().a(context, com.baidu.tieba.r.record_voice_area, this, true);
        setClickable(true);
        this.Lc = (TextView) findViewById(com.baidu.tieba.q.tip_error);
        ay.b(this.Lc, com.baidu.tieba.n.cp_cont_i, 1);
        this.Ld = (TextView) findViewById(com.baidu.tieba.q.tip_operator);
        this.Le = (TextView) findViewById(com.baidu.tieba.q.tip_time_out);
        this.Lf = (VoiceButton) findViewById(com.baidu.tieba.q.voice_bnt);
        this.Lb = (TextView) findViewById(com.baidu.tieba.q.restart);
        this.Lg = (ImageView) findViewById(com.baidu.tieba.q.play_img);
        this.Lh = (TextView) findViewById(com.baidu.tieba.q.play_time);
        this.Lb.setOnClickListener(this);
        this.Lg.setOnClickListener(this);
        this.Lf.setRecorderView(this);
        os();
    }

    private void or() {
        this.Lf.setVisibility(4);
        this.Lh.setVisibility(0);
        this.Lb.setVisibility(0);
        ay.b(this.Lh, com.baidu.tieba.n.cp_cont_f, 1);
        ay.b(this.Lb, com.baidu.tieba.n.cp_cont_f, 1);
        ay.i((View) this.Lb, com.baidu.tieba.p.but_posts_record_again_selector);
        this.Lg.setVisibility(0);
        if (this.mModel != null) {
            this.Lh.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            ay.c(this.Lg, com.baidu.tieba.p.but_posts_record_play_selector);
        }
        ay.b(this.Ld, com.baidu.tieba.n.cp_cont_c, 1);
        this.Ld.setText(getContext().getString(com.baidu.tieba.t.voice_play_tip));
    }

    public void os() {
        ay.c(this.Lf, com.baidu.tieba.p.but_posts_record_zero_selector);
        this.Lf.setVisibility(0);
        this.KD = 0;
        this.Lg.setVisibility(4);
        this.Lh.setVisibility(4);
        this.Lb.setVisibility(4);
        this.Le.setVisibility(4);
        ay.b(this.Ld, com.baidu.tieba.n.cp_cont_c, 1);
        this.Ld.setText(getContext().getString(com.baidu.tieba.t.voice_record_press_to_record));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.b
    public void reset() {
        os();
        this.mModel = null;
        this.KD = 0;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.b
    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Lc.setText("");
        this.Lc.setVisibility(4);
        this.KD = 0;
        or();
        if (this.Lk != null) {
            this.Lk.anM();
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
        if (z) {
            os();
            this.Ld.setText(getContext().getString(com.baidu.tieba.t.voice_record_release_to_stop));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    @Override // com.baidu.tieba.tbadkCore.voice.b, com.baidu.adp.lib.voice.j
    public void onStopingRecorder() {
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void b(VoiceData.VoiceModel voiceModel) {
        if (this.Lg != null && this.Lh != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    ay.b(this.Lh, com.baidu.tieba.n.cp_cont_f, 1);
                    this.Lh.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ay.c(this.Lg, com.baidu.tieba.p.but_posts_record_play_selector);
                    this.Ld.setText(getContext().getString(com.baidu.tieba.t.voice_play_tip));
                    ou();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    ay.b(this.Lh, com.baidu.tieba.n.cp_cont_f, 1);
                    ay.c(this.Lg, com.baidu.tieba.p.but_posts_record_stop_selector);
                    this.Ld.setText(getContext().getString(com.baidu.tieba.t.voice_stop_tip));
                    ot();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
        ay.b(this.Le, com.baidu.tieba.n.cp_cont_i, 1);
        ay.b(this.Lc, com.baidu.tieba.n.cp_cont_i, 1);
        ay.b(this.Ld, com.baidu.tieba.n.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Le.setVisibility(0);
                this.Le.setText(str);
                postDelayed(new x(this), 2000L);
            } else if (i == 2) {
                this.Lc.setVisibility(0);
                this.Lc.setText(str);
                this.Ld.setText(com.baidu.tieba.t.voice_record_press_to_record);
                postDelayed(new y(this), 2000L);
            } else if (i == 5) {
                this.Lc.setVisibility(0);
                this.Lc.setText(str);
                postDelayed(new z(this), 2000L);
            } else {
                os();
                this.Lc.setVisibility(0);
                this.Lc.setText(str);
                postDelayed(new aa(this), 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
        this.Lc.setVisibility(4);
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
        if (this.Lk != null) {
            this.Lk.OV();
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecordTime(int i) {
        ay.b(this.Lc, com.baidu.tieba.n.cp_cont_i, 1);
        this.Lc.setVisibility(0);
        this.Lc.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.Kh = Math.max(i, this.Kh);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Ki > 200) {
            this.Kh = 0;
            this.Ki = uptimeMillis;
        }
        if (this.Kh < 10) {
            this.KD = 1;
            invalidate();
        } else if (this.Kh < 20) {
            this.KD = 2;
            invalidate();
        } else if (this.Kh < 30) {
            this.KD = 3;
            invalidate();
        } else if (this.Kh < 40) {
            this.KD = 4;
            invalidate();
        } else if (this.Kh < 50) {
            this.KD = 5;
            invalidate();
        } else {
            this.KD = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void aG(int i) {
        if (this.mModel != null && this.Lh != null) {
            int i2 = i / 1000;
            if (this.Lr != i2) {
                this.Lh.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Lr = i2;
        }
    }

    private void ot() {
        if (this.mModel != null) {
            this.KD = 0;
            this.Li = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Lm = SystemClock.uptimeMillis();
            this.Ln = this.Lm + 200;
            this.Lp.sendEmptyMessageAtTime(1, this.Ln);
            invalidate();
        }
    }

    private void ou() {
        this.KD = 0;
        this.KE = 0;
        this.Li = 0.0f;
        this.Lj = 0.0f;
        this.Lp.removeMessages(1);
        ((ViewGroup) getParent()).invalidate();
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof com.baidu.tbadk.core.voice.j) {
            return ((com.baidu.tbadk.core.voice.j) context).getVoiceManager();
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
            if (id == com.baidu.tieba.q.restart) {
                voiceManager.stopPlay();
                oq();
            } else if (id == com.baidu.tieba.q.play_img && this.mModel != null) {
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

    @Override // com.baidu.tieba.tbadkCore.voice.b, com.baidu.tbadk.core.voice.i
    public VoiceData.VoiceModel getVoiceModel() {
        return this.mModel;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.b
    public void ov() {
        os();
        if (getVoiceManager() != null && getVoiceManager().getRecorderManager() != null && this.mModel != null) {
            getVoiceManager().getRecorderManager().bO(this.mModel.voiceId);
            this.mModel = null;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.b
    public void setCallback(com.baidu.tieba.tbadkCore.voice.c cVar) {
        this.Lk = cVar;
    }

    @Override // com.baidu.tbadk.core.voice.i
    public com.baidu.tbadk.core.voice.i getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void ow() {
    }

    public void ox() {
        this.KL = new Paint();
        this.KL.setAntiAlias(true);
        this.KL.setStyle(Paint.Style.STROKE);
        this.KL.setStrokeWidth(2.0f);
        this.KM = new Paint();
        this.KM.setAntiAlias(true);
        this.KM.setStyle(Paint.Style.STROKE);
        this.KM.setStrokeWidth(2.0f);
        this.KN = new Paint();
        this.KN.setAntiAlias(true);
        this.KN.setStyle(Paint.Style.STROKE);
        this.KN.setStrokeWidth(2.0f);
        this.KO = new Paint();
        this.KO.setAntiAlias(true);
        this.KO.setStyle(Paint.Style.STROKE);
        this.KO.setStrokeWidth(2.0f);
    }

    public void c(Canvas canvas) {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.KL.setColor(this.KT);
            this.KM.setColor(this.KU);
            this.KN.setColor(this.KV);
            this.KO.setColor(this.KW);
        } else {
            this.KL.setColor(this.KP);
            this.KM.setColor(this.KQ);
            this.KN.setColor(this.KR);
            this.KO.setColor(this.KS);
        }
        if (this.KD == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.KF, this.KL);
        } else if (this.KD == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.KF, this.KL);
            canvas.drawCircle(this.centerX, this.centerY, this.KG, this.KM);
        } else if (this.KD == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.KF, this.KL);
            canvas.drawCircle(this.centerX, this.centerY, this.KG, this.KM);
            canvas.drawCircle(this.centerX, this.centerY, this.KH, this.KN);
        } else if (this.KD == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.KF, this.KL);
            canvas.drawCircle(this.centerX, this.centerY, this.KG, this.KM);
            canvas.drawCircle(this.centerX, this.centerY, this.KH, this.KN);
            canvas.drawCircle(this.centerX, this.centerY, this.KI, this.KO);
        }
    }
}
