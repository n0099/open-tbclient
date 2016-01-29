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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.z;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes.dex */
public class s extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.j, VoiceManager.b, z {
    private final int[] LB;
    private int LD;
    private int LE;
    private final int LF;
    private final int LG;
    private final int LH;
    private final int LI;
    private final int LJ;
    private int LK;
    private int LL;
    private int LM;
    private int LN;
    private int LO;
    private int LP;
    private int LQ;
    private int LR;
    private Paint LS;
    private Paint LT;
    private Paint LU;
    private Paint LV;
    private int LW;
    private int LX;
    private int LY;
    private int LZ;
    private int Li;
    private long Lj;
    private int Lw;
    private com.baidu.tbadk.editortools.k Lx;
    private int Ma;
    private int Mb;
    private int Mc;
    private int Md;
    private final BitmapDrawable Me;
    private final Paint Mf;
    private final Rect Mg;
    private final RectF Mh;
    private TextView Mi;
    private TextView Mj;
    private TextView Mk;
    private TextView Ml;
    private VoiceButton Mm;
    private ImageView Mn;
    private TextView Mo;
    private float Mp;
    private float Mq;
    private r Mr;
    private com.baidu.tbadk.core.dialog.a Ms;
    private long Mt;
    private long Mu;
    private final int[] Mv;
    private final a Mw;
    private SweepGradient Mx;
    private int My;
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
                if (s.this.Mq >= 360.0f) {
                    s.this.Mq = 360.0f;
                    s.this.LL = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    s.this.Mt = uptimeMillis;
                    s.this.Mu = uptimeMillis + 200;
                    s.this.Mq += (((float) (uptimeMillis - s.this.Mt)) / 1000.0f) * s.this.Mp;
                    sendEmptyMessageAtTime(1, s.this.Mu);
                    s.this.LL++;
                }
                s.this.LK = s.this.LL % 6;
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
        this.Lj = 0L;
        this.LB = new int[4];
        this.LK = 0;
        this.LL = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.LM = 0;
        this.LN = 0;
        this.LO = 0;
        this.LP = 0;
        this.LQ = 0;
        this.LR = 0;
        this.LW = -1724676609;
        this.LX = 1546880511;
        this.LY = 674465279;
        this.LZ = 255034879;
        this.Ma = -1725669966;
        this.Mb = 1545887154;
        this.Mc = 673471922;
        this.Md = 254041522;
        this.Mf = new Paint(1);
        this.Mg = new Rect();
        this.Mh = new RectF();
        this.Lw = 0;
        this.Mv = new int[2];
        this.Mw = new a(this, null);
        this.Li = 0;
        this.My = 0;
        this.LB[0] = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_marginleft);
        this.LB[1] = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_margintop);
        this.LB[2] = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_marginright);
        this.LB[3] = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_marginbottom);
        this.LM = context.getResources().getDimensionPixelSize(t.e.ds134);
        this.LN = this.LM + context.getResources().getDimensionPixelSize(t.e.ds14);
        this.LO = this.LN + context.getResources().getDimensionPixelSize(t.e.ds16);
        this.LP = this.LO + context.getResources().getDimensionPixelSize(t.e.ds18);
        this.LQ = context.getResources().getDimensionPixelSize(t.e.ds70);
        this.LR = context.getResources().getDimensionPixelSize(t.e.ds210);
        this.LD = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_paddingtop);
        this.LE = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_restart_button_paddingleft);
        this.LF = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_restart_button_paddingbottom);
        this.LG = context.getResources().getDimensionPixelSize(t.e.ds4);
        this.LH = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_dot_glow_padding);
        this.LI = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_paint_stroke_width);
        this.LJ = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_progress_padding);
        this.Mf.setStyle(Paint.Style.STROKE);
        this.Mf.setStrokeWidth(this.LI);
        this.Me = (BitmapDrawable) getResources().getDrawable(t.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        P(context);
        oE();
        this.Mv[0] = ar.getColor(t.d.record_voice_progress_start);
        this.Mv[1] = ar.getColor(t.d.record_voice_progress_end);
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
        this.LD = ((i4 - getContext().getResources().getDimensionPixelSize(t.e.pb_editor_faceview_height)) / 2) + getContext().getResources().getDimensionPixelSize(t.e.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.Mm.getMeasuredWidth();
        int measuredHeight = this.Mm.getMeasuredHeight();
        int measuredWidth2 = this.Mj.getMeasuredWidth();
        this.Mj.layout((i5 - measuredWidth2) >> 1, this.LD + i2, (measuredWidth2 + i5) >> 1, this.Mj.getMeasuredHeight() + this.LD + i2);
        int bottom = this.Mj.getBottom();
        this.Mm.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Ml.getMeasuredWidth();
        int measuredHeight2 = this.Ml.getMeasuredHeight();
        int top = this.Mm.getTop();
        this.Ml.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Mi.getMeasuredWidth();
        int measuredHeight3 = this.Mi.getMeasuredHeight();
        int right = this.Mm.getRight() - this.LE;
        int bottom2 = this.Mm.getBottom() - this.LF;
        this.Mi.layout(this.LQ + i6, this.LR + bottom, measuredWidth4 + i6 + this.LQ, measuredHeight3 + this.LR + bottom);
        int measuredWidth5 = this.Mn.getMeasuredWidth();
        this.Mn.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Mn.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Mo.getMeasuredWidth();
        this.Mo.layout((i5 - measuredWidth6) >> 1, (this.Mi.getTop() - this.Mo.getMeasuredHeight()) - this.LG, (measuredWidth6 + i5) >> 1, (this.Mi.getTop() + i2) - this.LG);
        this.Mm.getLeft();
        this.Mm.getRight();
        int measuredWidth7 = this.Mk.getMeasuredWidth();
        int measuredHeight4 = this.Mk.getMeasuredHeight();
        int bottom3 = this.Mm.getBottom();
        this.Mk.layout((i5 - measuredWidth7) >> 1, this.LB[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.LB[3]);
        this.Mg.set((i5 - this.Me.getIntrinsicWidth()) >> 1, this.Mn.getTop() - this.LH, (i5 + this.Me.getIntrinsicHeight()) >> 1, (this.Mn.getTop() + this.Me.getIntrinsicHeight()) - this.LH);
        this.Me.setBounds(this.Mg);
        this.Mh.set(this.Mn.getLeft() + (this.LI >> 1) + this.LJ, this.Mn.getTop() + (this.LI >> 1) + this.LJ, (this.Mn.getRight() - (this.LI >> 1)) - this.LJ, (this.Mn.getBottom() - (this.LI >> 1)) - this.LJ);
        if (this.Mx == null) {
            this.Mx = new SweepGradient(this.Mh.centerX(), this.Mh.centerY(), this.Mv, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Mx.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Mh.centerX(), this.Mh.centerY());
            this.Mx.setLocalMatrix(matrix);
            this.Mf.setShader(this.Mx);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        d(canvas);
        super.dispatchDraw(canvas);
    }

    private void oy() {
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Ms == null) {
            this.Ms = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.l.C(getContext()).getPageActivity());
            this.Ms.cE(getContext().getString(t.j.voice_restart_tip)).a(getContext().getString(t.j.voice_restart), new t(this, recorderManager)).b(getContext().getString(t.j.cancel), new u(this)).b(com.baidu.adp.base.l.C(getContext()));
        }
        try {
            this.Ms.uj();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bT(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void P(Context context) {
        LayoutInflater.from(context).inflate(t.h.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.Mj = (TextView) findViewById(t.g.tip_error);
        ar.b(this.Mj, t.d.cp_cont_i, 1);
        this.Mk = (TextView) findViewById(t.g.tip_operator);
        this.Ml = (TextView) findViewById(t.g.tip_time_out);
        this.Mm = (VoiceButton) findViewById(t.g.voice_bnt);
        this.Mi = (TextView) findViewById(t.g.restart);
        this.Mn = (ImageView) findViewById(t.g.play_img);
        this.Mo = (TextView) findViewById(t.g.play_time);
        this.Mi.setOnClickListener(this);
        this.Mn.setOnClickListener(this);
        this.Mm.setRecorderView(this);
        oA();
    }

    private void oz() {
        this.Mm.setVisibility(4);
        this.Mo.setVisibility(0);
        this.Mi.setVisibility(0);
        ar.b(this.Mo, t.d.cp_cont_f, 1);
        ar.b(this.Mi, t.d.cp_cont_f, 1);
        ar.k(this.Mi, t.f.but_posts_record_again_selector);
        this.Mn.setVisibility(0);
        if (this.mModel != null) {
            this.Mo.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            ar.c(this.Mn, t.f.but_posts_record_play_selector);
        }
        ar.b(this.Mk, t.d.cp_cont_c, 1);
        this.Mk.setText(getContext().getString(t.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oA() {
        ar.c(this.Mm, t.f.but_posts_record_zero_selector);
        this.Mm.setVisibility(0);
        this.LK = 0;
        this.Mn.setVisibility(4);
        this.Mo.setVisibility(4);
        this.Mi.setVisibility(4);
        this.Ml.setVisibility(4);
        ar.b(this.Mk, t.d.cp_cont_c, 1);
        this.Mk.setText(getContext().getString(t.j.voice_record_press_to_record));
    }

    public void reset() {
        oA();
        this.mModel = null;
        this.LK = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Mj.setText("");
        this.Mj.setVisibility(4);
        this.LK = 0;
        oz();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
        if (z) {
            oA();
            this.Mk.setText(getContext().getString(t.j.voice_record_release_to_stop));
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
        if (this.Mn != null && this.Mo != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    ar.b(this.Mo, t.d.cp_cont_f, 1);
                    this.Mo.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ar.c(this.Mn, t.f.but_posts_record_play_selector);
                    this.Mk.setText(getContext().getString(t.j.voice_play_tip));
                    oC();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    ar.b(this.Mo, t.d.cp_cont_f, 1);
                    ar.c(this.Mn, t.f.but_posts_record_stop_selector);
                    this.Mk.setText(getContext().getString(t.j.voice_stop_tip));
                    oB();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
        ar.b(this.Ml, t.d.cp_cont_i, 1);
        ar.b(this.Mj, t.d.cp_cont_i, 1);
        ar.b(this.Mk, t.d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Ml.setVisibility(0);
                this.Ml.setText(str);
                postDelayed(new v(this), 2000L);
            } else if (i == 2) {
                this.Mj.setVisibility(0);
                this.Mj.setText(str);
                this.Mk.setText(t.j.voice_record_press_to_record);
                postDelayed(new w(this), 2000L);
            } else if (i == 5) {
                this.Mj.setVisibility(0);
                this.Mj.setText(str);
                postDelayed(new x(this), 2000L);
            } else {
                oA();
                this.Mj.setVisibility(0);
                this.Mj.setText(str);
                postDelayed(new y(this), 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
        this.Mj.setVisibility(4);
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
        ar.b(this.Mj, t.d.cp_cont_i, 1);
        this.Mj.setVisibility(0);
        this.Mj.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.Li = Math.max(i, this.Li);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Lj > 200) {
            this.Li = 0;
            this.Lj = uptimeMillis;
        }
        if (this.Li < 10) {
            this.LK = 1;
            invalidate();
        } else if (this.Li < 20) {
            this.LK = 2;
            invalidate();
        } else if (this.Li < 30) {
            this.LK = 3;
            invalidate();
        } else if (this.Li < 40) {
            this.LK = 4;
            invalidate();
        } else if (this.Li < 50) {
            this.LK = 5;
            invalidate();
        } else {
            this.LK = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aP(int i) {
        if (this.mModel != null && this.Mo != null) {
            int i2 = i / 1000;
            if (this.My != i2) {
                this.Mo.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.My = i2;
        }
    }

    private void oB() {
        if (this.mModel != null) {
            this.LK = 0;
            this.Mp = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Mt = SystemClock.uptimeMillis();
            this.Mu = this.Mt + 200;
            this.Mw.sendEmptyMessageAtTime(1, this.Mu);
            invalidate();
        }
    }

    private void oC() {
        this.LK = 0;
        this.LL = 0;
        this.Mp = 0.0f;
        this.Mq = 0.0f;
        this.Mw.removeMessages(1);
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
                oy();
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
        this.Mr = rVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oD() {
    }

    public void oE() {
        this.LS = new Paint();
        this.LS.setAntiAlias(true);
        this.LS.setStyle(Paint.Style.STROKE);
        this.LS.setStrokeWidth(2.0f);
        this.LT = new Paint();
        this.LT.setAntiAlias(true);
        this.LT.setStyle(Paint.Style.STROKE);
        this.LT.setStrokeWidth(2.0f);
        this.LU = new Paint();
        this.LU.setAntiAlias(true);
        this.LU.setStyle(Paint.Style.STROKE);
        this.LU.setStrokeWidth(2.0f);
        this.LV = new Paint();
        this.LV.setAntiAlias(true);
        this.LV.setStyle(Paint.Style.STROKE);
        this.LV.setStrokeWidth(2.0f);
    }

    public void d(Canvas canvas) {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.LS.setColor(this.Ma);
            this.LT.setColor(this.Mb);
            this.LU.setColor(this.Mc);
            this.LV.setColor(this.Md);
        } else {
            this.LS.setColor(this.LW);
            this.LT.setColor(this.LX);
            this.LU.setColor(this.LY);
            this.LV.setColor(this.LZ);
        }
        if (this.LK == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.LM, this.LS);
        } else if (this.LK == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.LM, this.LS);
            canvas.drawCircle(this.centerX, this.centerY, this.LN, this.LT);
        } else if (this.LK == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.LM, this.LS);
            canvas.drawCircle(this.centerX, this.centerY, this.LN, this.LT);
            canvas.drawCircle(this.centerX, this.centerY, this.LO, this.LU);
        } else if (this.LK == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.LM, this.LS);
            canvas.drawCircle(this.centerX, this.centerY, this.LN, this.LT);
            canvas.drawCircle(this.centerX, this.centerY, this.LO, this.LU);
            canvas.drawCircle(this.centerX, this.centerY, this.LP, this.LV);
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
    public void ow() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.z
    public int getToolId() {
        return this.Lw;
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
        if (this.Lx != null) {
            this.Lx.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setEditorTools(com.baidu.tbadk.editortools.k kVar) {
        this.Lx = kVar;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setToolId(int i) {
        this.Lw = i;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void onChangeSkinType(int i) {
    }
}
