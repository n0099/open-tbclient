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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.z;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes.dex */
public class s extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.j, VoiceManager.b, z {
    private int KD;
    private long KE;
    private int KR;
    private com.baidu.tbadk.editortools.k KS;
    private final int[] KW;
    private int KX;
    private int KY;
    private final int KZ;
    private final Rect LA;
    private final RectF LB;
    private TextView LD;
    private TextView LE;
    private TextView LF;
    private TextView LG;
    private VoiceButton LH;
    private ImageView LI;
    private TextView LJ;
    private float LK;
    private float LL;
    private r LM;
    private com.baidu.tbadk.core.dialog.a LN;
    private long LO;
    private long LP;
    private final int[] LQ;
    private final a LR;
    private SweepGradient LS;
    private int LT;
    private final int La;
    private final int Lb;
    private final int Lc;
    private final int Ld;
    private int Le;
    private int Lf;
    private int Lg;
    private int Lh;
    private int Li;
    private int Lj;
    private int Lk;
    private int Ll;
    private Paint Lm;
    private Paint Ln;
    private Paint Lo;
    private Paint Lp;
    private int Lq;
    private int Lr;
    private int Ls;
    private int Lt;
    private int Lu;
    private int Lv;
    private int Lw;
    private int Lx;
    private final BitmapDrawable Ly;
    private final Paint Lz;
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
                if (s.this.LL >= 360.0f) {
                    s.this.LL = 360.0f;
                    s.this.Lf = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    s.this.LO = uptimeMillis;
                    s.this.LP = uptimeMillis + 200;
                    s.this.LL += (((float) (uptimeMillis - s.this.LO)) / 1000.0f) * s.this.LK;
                    sendEmptyMessageAtTime(1, s.this.LP);
                    s.this.Lf++;
                }
                s.this.Le = s.this.Lf % 6;
                s.this.invalidate();
            }
        }
    }

    public static s O(Context context) {
        return new s(context);
    }

    public s(Context context) {
        this(context, null);
    }

    public s(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.KE = 0L;
        this.KW = new int[4];
        this.Le = 0;
        this.Lf = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.Lg = 0;
        this.Lh = 0;
        this.Li = 0;
        this.Lj = 0;
        this.Lk = 0;
        this.Ll = 0;
        this.Lq = -1724676609;
        this.Lr = 1546880511;
        this.Ls = 674465279;
        this.Lt = 255034879;
        this.Lu = -1725669966;
        this.Lv = 1545887154;
        this.Lw = 673471922;
        this.Lx = 254041522;
        this.Lz = new Paint(1);
        this.LA = new Rect();
        this.LB = new RectF();
        this.KR = 0;
        this.LQ = new int[2];
        this.LR = new a(this, null);
        this.KD = 0;
        this.LT = 0;
        this.KW[0] = context.getResources().getDimensionPixelSize(n.d.record_voice_btn_marginleft);
        this.KW[1] = context.getResources().getDimensionPixelSize(n.d.record_voice_btn_margintop);
        this.KW[2] = context.getResources().getDimensionPixelSize(n.d.record_voice_btn_marginright);
        this.KW[3] = context.getResources().getDimensionPixelSize(n.d.record_voice_btn_marginbottom);
        this.Lg = context.getResources().getDimensionPixelSize(n.d.ds134);
        this.Lh = this.Lg + context.getResources().getDimensionPixelSize(n.d.ds14);
        this.Li = this.Lh + context.getResources().getDimensionPixelSize(n.d.ds16);
        this.Lj = this.Li + context.getResources().getDimensionPixelSize(n.d.ds18);
        this.Lk = context.getResources().getDimensionPixelSize(n.d.ds70);
        this.Ll = context.getResources().getDimensionPixelSize(n.d.ds210);
        this.KX = context.getResources().getDimensionPixelSize(n.d.record_voice_btn_paddingtop);
        this.KY = context.getResources().getDimensionPixelSize(n.d.record_voice_btn_restart_button_paddingleft);
        this.KZ = context.getResources().getDimensionPixelSize(n.d.record_voice_btn_restart_button_paddingbottom);
        this.La = context.getResources().getDimensionPixelSize(n.d.ds4);
        this.Lb = context.getResources().getDimensionPixelSize(n.d.record_voice_btn_dot_glow_padding);
        this.Lc = context.getResources().getDimensionPixelSize(n.d.record_voice_btn_paint_stroke_width);
        this.Ld = context.getResources().getDimensionPixelSize(n.d.record_voice_btn_progress_padding);
        this.Lz.setStyle(Paint.Style.STROKE);
        this.Lz.setStrokeWidth(this.Lc);
        this.Ly = (BitmapDrawable) getResources().getDrawable(n.e.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        P(context);
        oL();
        this.LQ[0] = as.getColor(n.c.record_voice_progress_start);
        this.LQ[1] = as.getColor(n.c.record_voice_progress_end);
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
        this.KX = ((i4 - getContext().getResources().getDimensionPixelSize(n.d.pb_editor_faceview_height)) / 2) + getContext().getResources().getDimensionPixelSize(n.d.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.LH.getMeasuredWidth();
        int measuredHeight = this.LH.getMeasuredHeight();
        int measuredWidth2 = this.LE.getMeasuredWidth();
        this.LE.layout((i5 - measuredWidth2) >> 1, this.KX + i2, (measuredWidth2 + i5) >> 1, this.LE.getMeasuredHeight() + this.KX + i2);
        int bottom = this.LE.getBottom();
        this.LH.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.LG.getMeasuredWidth();
        int measuredHeight2 = this.LG.getMeasuredHeight();
        int top = this.LH.getTop();
        this.LG.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.LD.getMeasuredWidth();
        int measuredHeight3 = this.LD.getMeasuredHeight();
        int right = this.LH.getRight() - this.KY;
        int bottom2 = this.LH.getBottom() - this.KZ;
        this.LD.layout(this.Lk + i6, this.Ll + bottom, measuredWidth4 + i6 + this.Lk, measuredHeight3 + this.Ll + bottom);
        int measuredWidth5 = this.LI.getMeasuredWidth();
        this.LI.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.LI.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.LJ.getMeasuredWidth();
        this.LJ.layout((i5 - measuredWidth6) >> 1, (this.LD.getTop() - this.LJ.getMeasuredHeight()) - this.La, (measuredWidth6 + i5) >> 1, (this.LD.getTop() + i2) - this.La);
        this.LH.getLeft();
        this.LH.getRight();
        int measuredWidth7 = this.LF.getMeasuredWidth();
        int measuredHeight4 = this.LF.getMeasuredHeight();
        int bottom3 = this.LH.getBottom();
        this.LF.layout((i5 - measuredWidth7) >> 1, this.KW[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.KW[3]);
        this.LA.set((i5 - this.Ly.getIntrinsicWidth()) >> 1, this.LI.getTop() - this.Lb, (i5 + this.Ly.getIntrinsicHeight()) >> 1, (this.LI.getTop() + this.Ly.getIntrinsicHeight()) - this.Lb);
        this.Ly.setBounds(this.LA);
        this.LB.set(this.LI.getLeft() + (this.Lc >> 1) + this.Ld, this.LI.getTop() + (this.Lc >> 1) + this.Ld, (this.LI.getRight() - (this.Lc >> 1)) - this.Ld, (this.LI.getBottom() - (this.Lc >> 1)) - this.Ld);
        if (this.LS == null) {
            this.LS = new SweepGradient(this.LB.centerX(), this.LB.centerY(), this.LQ, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.LS.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.LB.centerX(), this.LB.centerY());
            this.LS.setLocalMatrix(matrix);
            this.Lz.setShader(this.LS);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        d(canvas);
        super.dispatchDraw(canvas);
    }

    private void oF() {
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.LN == null) {
            this.LN = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.l.C(getContext()).getPageActivity());
            this.LN.cC(getContext().getString(n.i.voice_restart_tip)).a(getContext().getString(n.i.voice_restart), new t(this, recorderManager)).b(getContext().getString(n.i.cancel), new u(this)).b(com.baidu.adp.base.l.C(getContext()));
        }
        try {
            this.LN.tv();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bR(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void P(Context context) {
        LayoutInflater.from(context).inflate(n.g.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.LE = (TextView) findViewById(n.f.tip_error);
        as.b(this.LE, n.c.cp_cont_i, 1);
        this.LF = (TextView) findViewById(n.f.tip_operator);
        this.LG = (TextView) findViewById(n.f.tip_time_out);
        this.LH = (VoiceButton) findViewById(n.f.voice_bnt);
        this.LD = (TextView) findViewById(n.f.restart);
        this.LI = (ImageView) findViewById(n.f.play_img);
        this.LJ = (TextView) findViewById(n.f.play_time);
        this.LD.setOnClickListener(this);
        this.LI.setOnClickListener(this);
        this.LH.setRecorderView(this);
        oH();
    }

    private void oG() {
        this.LH.setVisibility(4);
        this.LJ.setVisibility(0);
        this.LD.setVisibility(0);
        as.b(this.LJ, n.c.cp_cont_f, 1);
        as.b(this.LD, n.c.cp_cont_f, 1);
        as.i((View) this.LD, n.e.but_posts_record_again_selector);
        this.LI.setVisibility(0);
        if (this.mModel != null) {
            this.LJ.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            as.c(this.LI, n.e.but_posts_record_play_selector);
        }
        as.b(this.LF, n.c.cp_cont_c, 1);
        this.LF.setText(getContext().getString(n.i.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oH() {
        as.c(this.LH, n.e.but_posts_record_zero_selector);
        this.LH.setVisibility(0);
        this.Le = 0;
        this.LI.setVisibility(4);
        this.LJ.setVisibility(4);
        this.LD.setVisibility(4);
        this.LG.setVisibility(4);
        as.b(this.LF, n.c.cp_cont_c, 1);
        this.LF.setText(getContext().getString(n.i.voice_record_press_to_record));
    }

    public void reset() {
        oH();
        this.mModel = null;
        this.Le = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.LE.setText("");
        this.LE.setVisibility(4);
        this.Le = 0;
        oG();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
        if (z) {
            oH();
            this.LF.setText(getContext().getString(n.i.voice_record_release_to_stop));
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
        if (this.LI != null && this.LJ != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    as.b(this.LJ, n.c.cp_cont_f, 1);
                    this.LJ.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    as.c(this.LI, n.e.but_posts_record_play_selector);
                    this.LF.setText(getContext().getString(n.i.voice_play_tip));
                    oJ();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    as.b(this.LJ, n.c.cp_cont_f, 1);
                    as.c(this.LI, n.e.but_posts_record_stop_selector);
                    this.LF.setText(getContext().getString(n.i.voice_stop_tip));
                    oI();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
        as.b(this.LG, n.c.cp_cont_i, 1);
        as.b(this.LE, n.c.cp_cont_i, 1);
        as.b(this.LF, n.c.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.LG.setVisibility(0);
                this.LG.setText(str);
                postDelayed(new v(this), 2000L);
            } else if (i == 2) {
                this.LE.setVisibility(0);
                this.LE.setText(str);
                this.LF.setText(n.i.voice_record_press_to_record);
                postDelayed(new w(this), 2000L);
            } else if (i == 5) {
                this.LE.setVisibility(0);
                this.LE.setText(str);
                postDelayed(new x(this), 2000L);
            } else {
                oH();
                this.LE.setVisibility(0);
                this.LE.setText(str);
                postDelayed(new y(this), 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
        this.LE.setVisibility(4);
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
        as.b(this.LE, n.c.cp_cont_i, 1);
        this.LE.setVisibility(0);
        this.LE.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.KD = Math.max(i, this.KD);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.KE > 200) {
            this.KD = 0;
            this.KE = uptimeMillis;
        }
        if (this.KD < 10) {
            this.Le = 1;
            invalidate();
        } else if (this.KD < 20) {
            this.Le = 2;
            invalidate();
        } else if (this.KD < 30) {
            this.Le = 3;
            invalidate();
        } else if (this.KD < 40) {
            this.Le = 4;
            invalidate();
        } else if (this.KD < 50) {
            this.Le = 5;
            invalidate();
        } else {
            this.Le = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aJ(int i) {
        if (this.mModel != null && this.LJ != null) {
            int i2 = i / 1000;
            if (this.LT != i2) {
                this.LJ.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.LT = i2;
        }
    }

    private void oI() {
        if (this.mModel != null) {
            this.Le = 0;
            this.LK = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.LO = SystemClock.uptimeMillis();
            this.LP = this.LO + 200;
            this.LR.sendEmptyMessageAtTime(1, this.LP);
            invalidate();
        }
    }

    private void oJ() {
        this.Le = 0;
        this.Lf = 0;
        this.LK = 0.0f;
        this.LL = 0.0f;
        this.LR.removeMessages(1);
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
            if (id == n.f.restart) {
                voiceManager.stopPlay();
                oF();
            } else if (id == n.f.play_img && this.mModel != null) {
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
        this.LM = rVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oK() {
    }

    public void oL() {
        this.Lm = new Paint();
        this.Lm.setAntiAlias(true);
        this.Lm.setStyle(Paint.Style.STROKE);
        this.Lm.setStrokeWidth(2.0f);
        this.Ln = new Paint();
        this.Ln.setAntiAlias(true);
        this.Ln.setStyle(Paint.Style.STROKE);
        this.Ln.setStrokeWidth(2.0f);
        this.Lo = new Paint();
        this.Lo.setAntiAlias(true);
        this.Lo.setStyle(Paint.Style.STROKE);
        this.Lo.setStrokeWidth(2.0f);
        this.Lp = new Paint();
        this.Lp.setAntiAlias(true);
        this.Lp.setStyle(Paint.Style.STROKE);
        this.Lp.setStrokeWidth(2.0f);
    }

    public void d(Canvas canvas) {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.Lm.setColor(this.Lu);
            this.Ln.setColor(this.Lv);
            this.Lo.setColor(this.Lw);
            this.Lp.setColor(this.Lx);
        } else {
            this.Lm.setColor(this.Lq);
            this.Ln.setColor(this.Lr);
            this.Lo.setColor(this.Ls);
            this.Lp.setColor(this.Lt);
        }
        if (this.Le == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.Lg, this.Lm);
        } else if (this.Le == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.Lg, this.Lm);
            canvas.drawCircle(this.centerX, this.centerY, this.Lh, this.Ln);
        } else if (this.Le == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.Lg, this.Lm);
            canvas.drawCircle(this.centerX, this.centerY, this.Lh, this.Ln);
            canvas.drawCircle(this.centerX, this.centerY, this.Li, this.Lo);
        } else if (this.Le == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.Lg, this.Lm);
            canvas.drawCircle(this.centerX, this.centerY, this.Lh, this.Ln);
            canvas.drawCircle(this.centerX, this.centerY, this.Li, this.Lo);
            canvas.drawCircle(this.centerX, this.centerY, this.Lj, this.Lp);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.code == 9) {
            reset();
            b(new com.baidu.tbadk.editortools.a(2, 6, null));
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void oD() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.z
    public int getToolId() {
        return this.KR;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.z
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KS != null) {
            this.KS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setEditorTools(com.baidu.tbadk.editortools.k kVar) {
        this.KS = kVar;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setToolId(int i) {
        this.KR = i;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void onChangeSkinType(int i) {
    }
}
