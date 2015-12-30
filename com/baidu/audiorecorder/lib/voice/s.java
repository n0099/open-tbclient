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
    private int KT;
    private long KU;
    private int LA;
    private int LB;
    private Paint LD;
    private Paint LE;
    private Paint LF;
    private Paint LG;
    private int LH;
    private int LI;
    private int LJ;
    private int LK;
    private int LL;
    private int LM;
    private int LN;
    private int LO;
    private final BitmapDrawable LP;
    private final Paint LQ;
    private final Rect LR;
    private final RectF LS;
    private TextView LT;
    private TextView LU;
    private TextView LV;
    private TextView LW;
    private VoiceButton LX;
    private ImageView LY;
    private TextView LZ;
    private int Lh;
    private com.baidu.tbadk.editortools.k Li;
    private final int[] Lm;
    private int Ln;
    private int Lo;
    private final int Lp;
    private final int Lq;
    private final int Lr;
    private final int Ls;
    private final int Lt;
    private int Lu;
    private int Lv;
    private int Lw;
    private int Lx;
    private int Ly;
    private int Lz;
    private float Ma;
    private float Mb;
    private r Mc;
    private com.baidu.tbadk.core.dialog.a Md;
    private long Me;
    private long Mf;
    private final int[] Mg;
    private final a Mh;
    private SweepGradient Mi;
    private int Mj;
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
                if (s.this.Mb >= 360.0f) {
                    s.this.Mb = 360.0f;
                    s.this.Lv = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    s.this.Me = uptimeMillis;
                    s.this.Mf = uptimeMillis + 200;
                    s.this.Mb += (((float) (uptimeMillis - s.this.Me)) / 1000.0f) * s.this.Ma;
                    sendEmptyMessageAtTime(1, s.this.Mf);
                    s.this.Lv++;
                }
                s.this.Lu = s.this.Lv % 6;
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
        this.KU = 0L;
        this.Lm = new int[4];
        this.Lu = 0;
        this.Lv = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.Lw = 0;
        this.Lx = 0;
        this.Ly = 0;
        this.Lz = 0;
        this.LA = 0;
        this.LB = 0;
        this.LH = -1724676609;
        this.LI = 1546880511;
        this.LJ = 674465279;
        this.LK = 255034879;
        this.LL = -1725669966;
        this.LM = 1545887154;
        this.LN = 673471922;
        this.LO = 254041522;
        this.LQ = new Paint(1);
        this.LR = new Rect();
        this.LS = new RectF();
        this.Lh = 0;
        this.Mg = new int[2];
        this.Mh = new a(this, null);
        this.KT = 0;
        this.Mj = 0;
        this.Lm[0] = context.getResources().getDimensionPixelSize(n.e.record_voice_btn_marginleft);
        this.Lm[1] = context.getResources().getDimensionPixelSize(n.e.record_voice_btn_margintop);
        this.Lm[2] = context.getResources().getDimensionPixelSize(n.e.record_voice_btn_marginright);
        this.Lm[3] = context.getResources().getDimensionPixelSize(n.e.record_voice_btn_marginbottom);
        this.Lw = context.getResources().getDimensionPixelSize(n.e.ds134);
        this.Lx = this.Lw + context.getResources().getDimensionPixelSize(n.e.ds14);
        this.Ly = this.Lx + context.getResources().getDimensionPixelSize(n.e.ds16);
        this.Lz = this.Ly + context.getResources().getDimensionPixelSize(n.e.ds18);
        this.LA = context.getResources().getDimensionPixelSize(n.e.ds70);
        this.LB = context.getResources().getDimensionPixelSize(n.e.ds210);
        this.Ln = context.getResources().getDimensionPixelSize(n.e.record_voice_btn_paddingtop);
        this.Lo = context.getResources().getDimensionPixelSize(n.e.record_voice_btn_restart_button_paddingleft);
        this.Lp = context.getResources().getDimensionPixelSize(n.e.record_voice_btn_restart_button_paddingbottom);
        this.Lq = context.getResources().getDimensionPixelSize(n.e.ds4);
        this.Lr = context.getResources().getDimensionPixelSize(n.e.record_voice_btn_dot_glow_padding);
        this.Ls = context.getResources().getDimensionPixelSize(n.e.record_voice_btn_paint_stroke_width);
        this.Lt = context.getResources().getDimensionPixelSize(n.e.record_voice_btn_progress_padding);
        this.LQ.setStyle(Paint.Style.STROKE);
        this.LQ.setStrokeWidth(this.Ls);
        this.LP = (BitmapDrawable) getResources().getDrawable(n.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        P(context);
        oj();
        this.Mg[0] = as.getColor(n.d.record_voice_progress_start);
        this.Mg[1] = as.getColor(n.d.record_voice_progress_end);
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
        this.Ln = ((i4 - getContext().getResources().getDimensionPixelSize(n.e.pb_editor_faceview_height)) / 2) + getContext().getResources().getDimensionPixelSize(n.e.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.LX.getMeasuredWidth();
        int measuredHeight = this.LX.getMeasuredHeight();
        int measuredWidth2 = this.LU.getMeasuredWidth();
        this.LU.layout((i5 - measuredWidth2) >> 1, this.Ln + i2, (measuredWidth2 + i5) >> 1, this.LU.getMeasuredHeight() + this.Ln + i2);
        int bottom = this.LU.getBottom();
        this.LX.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.LW.getMeasuredWidth();
        int measuredHeight2 = this.LW.getMeasuredHeight();
        int top = this.LX.getTop();
        this.LW.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.LT.getMeasuredWidth();
        int measuredHeight3 = this.LT.getMeasuredHeight();
        int right = this.LX.getRight() - this.Lo;
        int bottom2 = this.LX.getBottom() - this.Lp;
        this.LT.layout(this.LA + i6, this.LB + bottom, measuredWidth4 + i6 + this.LA, measuredHeight3 + this.LB + bottom);
        int measuredWidth5 = this.LY.getMeasuredWidth();
        this.LY.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.LY.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.LZ.getMeasuredWidth();
        this.LZ.layout((i5 - measuredWidth6) >> 1, (this.LT.getTop() - this.LZ.getMeasuredHeight()) - this.Lq, (measuredWidth6 + i5) >> 1, (this.LT.getTop() + i2) - this.Lq);
        this.LX.getLeft();
        this.LX.getRight();
        int measuredWidth7 = this.LV.getMeasuredWidth();
        int measuredHeight4 = this.LV.getMeasuredHeight();
        int bottom3 = this.LX.getBottom();
        this.LV.layout((i5 - measuredWidth7) >> 1, this.Lm[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.Lm[3]);
        this.LR.set((i5 - this.LP.getIntrinsicWidth()) >> 1, this.LY.getTop() - this.Lr, (i5 + this.LP.getIntrinsicHeight()) >> 1, (this.LY.getTop() + this.LP.getIntrinsicHeight()) - this.Lr);
        this.LP.setBounds(this.LR);
        this.LS.set(this.LY.getLeft() + (this.Ls >> 1) + this.Lt, this.LY.getTop() + (this.Ls >> 1) + this.Lt, (this.LY.getRight() - (this.Ls >> 1)) - this.Lt, (this.LY.getBottom() - (this.Ls >> 1)) - this.Lt);
        if (this.Mi == null) {
            this.Mi = new SweepGradient(this.LS.centerX(), this.LS.centerY(), this.Mg, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Mi.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.LS.centerX(), this.LS.centerY());
            this.Mi.setLocalMatrix(matrix);
            this.LQ.setShader(this.Mi);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        d(canvas);
        super.dispatchDraw(canvas);
    }

    private void od() {
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Md == null) {
            this.Md = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.l.C(getContext()).getPageActivity());
            this.Md.cF(getContext().getString(n.j.voice_restart_tip)).a(getContext().getString(n.j.voice_restart), new t(this, recorderManager)).b(getContext().getString(n.j.cancel), new u(this)).b(com.baidu.adp.base.l.C(getContext()));
        }
        try {
            this.Md.tf();
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
        LayoutInflater.from(context).inflate(n.h.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.LU = (TextView) findViewById(n.g.tip_error);
        as.b(this.LU, n.d.cp_cont_i, 1);
        this.LV = (TextView) findViewById(n.g.tip_operator);
        this.LW = (TextView) findViewById(n.g.tip_time_out);
        this.LX = (VoiceButton) findViewById(n.g.voice_bnt);
        this.LT = (TextView) findViewById(n.g.restart);
        this.LY = (ImageView) findViewById(n.g.play_img);
        this.LZ = (TextView) findViewById(n.g.play_time);
        this.LT.setOnClickListener(this);
        this.LY.setOnClickListener(this);
        this.LX.setRecorderView(this);
        of();
    }

    private void oe() {
        this.LX.setVisibility(4);
        this.LZ.setVisibility(0);
        this.LT.setVisibility(0);
        as.b(this.LZ, n.d.cp_cont_f, 1);
        as.b(this.LT, n.d.cp_cont_f, 1);
        as.i((View) this.LT, n.f.but_posts_record_again_selector);
        this.LY.setVisibility(0);
        if (this.mModel != null) {
            this.LZ.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            as.c(this.LY, n.f.but_posts_record_play_selector);
        }
        as.b(this.LV, n.d.cp_cont_c, 1);
        this.LV.setText(getContext().getString(n.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void of() {
        as.c(this.LX, n.f.but_posts_record_zero_selector);
        this.LX.setVisibility(0);
        this.Lu = 0;
        this.LY.setVisibility(4);
        this.LZ.setVisibility(4);
        this.LT.setVisibility(4);
        this.LW.setVisibility(4);
        as.b(this.LV, n.d.cp_cont_c, 1);
        this.LV.setText(getContext().getString(n.j.voice_record_press_to_record));
    }

    public void reset() {
        of();
        this.mModel = null;
        this.Lu = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.LU.setText("");
        this.LU.setVisibility(4);
        this.Lu = 0;
        oe();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
        if (z) {
            of();
            this.LV.setText(getContext().getString(n.j.voice_record_release_to_stop));
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
        if (this.LY != null && this.LZ != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    as.b(this.LZ, n.d.cp_cont_f, 1);
                    this.LZ.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    as.c(this.LY, n.f.but_posts_record_play_selector);
                    this.LV.setText(getContext().getString(n.j.voice_play_tip));
                    oh();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    as.b(this.LZ, n.d.cp_cont_f, 1);
                    as.c(this.LY, n.f.but_posts_record_stop_selector);
                    this.LV.setText(getContext().getString(n.j.voice_stop_tip));
                    og();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
        as.b(this.LW, n.d.cp_cont_i, 1);
        as.b(this.LU, n.d.cp_cont_i, 1);
        as.b(this.LV, n.d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.LW.setVisibility(0);
                this.LW.setText(str);
                postDelayed(new v(this), 2000L);
            } else if (i == 2) {
                this.LU.setVisibility(0);
                this.LU.setText(str);
                this.LV.setText(n.j.voice_record_press_to_record);
                postDelayed(new w(this), 2000L);
            } else if (i == 5) {
                this.LU.setVisibility(0);
                this.LU.setText(str);
                postDelayed(new x(this), 2000L);
            } else {
                of();
                this.LU.setVisibility(0);
                this.LU.setText(str);
                postDelayed(new y(this), 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
        this.LU.setVisibility(4);
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
        as.b(this.LU, n.d.cp_cont_i, 1);
        this.LU.setVisibility(0);
        this.LU.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.KT = Math.max(i, this.KT);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.KU > 200) {
            this.KT = 0;
            this.KU = uptimeMillis;
        }
        if (this.KT < 10) {
            this.Lu = 1;
            invalidate();
        } else if (this.KT < 20) {
            this.Lu = 2;
            invalidate();
        } else if (this.KT < 30) {
            this.Lu = 3;
            invalidate();
        } else if (this.KT < 40) {
            this.Lu = 4;
            invalidate();
        } else if (this.KT < 50) {
            this.Lu = 5;
            invalidate();
        } else {
            this.Lu = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aC(int i) {
        if (this.mModel != null && this.LZ != null) {
            int i2 = i / 1000;
            if (this.Mj != i2) {
                this.LZ.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Mj = i2;
        }
    }

    private void og() {
        if (this.mModel != null) {
            this.Lu = 0;
            this.Ma = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Me = SystemClock.uptimeMillis();
            this.Mf = this.Me + 200;
            this.Mh.sendEmptyMessageAtTime(1, this.Mf);
            invalidate();
        }
    }

    private void oh() {
        this.Lu = 0;
        this.Lv = 0;
        this.Ma = 0.0f;
        this.Mb = 0.0f;
        this.Mh.removeMessages(1);
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
            if (id == n.g.restart) {
                voiceManager.stopPlay();
                od();
            } else if (id == n.g.play_img && this.mModel != null) {
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
        this.Mc = rVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oi() {
    }

    public void oj() {
        this.LD = new Paint();
        this.LD.setAntiAlias(true);
        this.LD.setStyle(Paint.Style.STROKE);
        this.LD.setStrokeWidth(2.0f);
        this.LE = new Paint();
        this.LE.setAntiAlias(true);
        this.LE.setStyle(Paint.Style.STROKE);
        this.LE.setStrokeWidth(2.0f);
        this.LF = new Paint();
        this.LF.setAntiAlias(true);
        this.LF.setStyle(Paint.Style.STROKE);
        this.LF.setStrokeWidth(2.0f);
        this.LG = new Paint();
        this.LG.setAntiAlias(true);
        this.LG.setStyle(Paint.Style.STROKE);
        this.LG.setStrokeWidth(2.0f);
    }

    public void d(Canvas canvas) {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.LD.setColor(this.LL);
            this.LE.setColor(this.LM);
            this.LF.setColor(this.LN);
            this.LG.setColor(this.LO);
        } else {
            this.LD.setColor(this.LH);
            this.LE.setColor(this.LI);
            this.LF.setColor(this.LJ);
            this.LG.setColor(this.LK);
        }
        if (this.Lu == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.Lw, this.LD);
        } else if (this.Lu == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.Lw, this.LD);
            canvas.drawCircle(this.centerX, this.centerY, this.Lx, this.LE);
        } else if (this.Lu == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.Lw, this.LD);
            canvas.drawCircle(this.centerX, this.centerY, this.Lx, this.LE);
            canvas.drawCircle(this.centerX, this.centerY, this.Ly, this.LF);
        } else if (this.Lu == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.Lw, this.LD);
            canvas.drawCircle(this.centerX, this.centerY, this.Lx, this.LE);
            canvas.drawCircle(this.centerX, this.centerY, this.Ly, this.LF);
            canvas.drawCircle(this.centerX, this.centerY, this.Lz, this.LG);
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
    public void ob() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.z
    public int getToolId() {
        return this.Lh;
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
        if (this.Li != null) {
            this.Li.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setEditorTools(com.baidu.tbadk.editortools.k kVar) {
        this.Li = kVar;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setToolId(int i) {
        this.Lh = i;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void onChangeSkinType(int i) {
    }
}
