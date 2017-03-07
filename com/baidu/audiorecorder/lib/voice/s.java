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
/* loaded from: classes.dex */
public class s extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.j, VoiceManager.b, com.baidu.tbadk.editortools.y {
    private int KW;
    private long KX;
    private int LA;
    private int LB;
    private int LC;
    private int LD;
    private int LE;
    private Paint LF;
    private Paint LG;
    private Paint LH;
    private Paint LI;
    private int LJ;
    private int LK;
    private int LL;
    private int LM;
    private int LN;
    private int LO;
    private int LP;
    private int LQ;
    private final BitmapDrawable LR;
    private final Paint LS;
    private final Rect LT;
    private final RectF LU;
    private TextView LV;
    private TextView LW;
    private TextView LX;
    private TextView LY;
    private VoiceButton LZ;
    private int Lk;
    private com.baidu.tbadk.editortools.j Ll;
    private final int[] Lp;
    private int Lq;
    private int Lr;
    private final int Ls;
    private final int Lt;
    private final int Lu;
    private final int Lv;
    private final int Lw;
    private int Lx;
    private int Ly;
    private int Lz;
    private ImageView Ma;
    private TextView Mb;
    private float Mc;
    private float Md;
    private r Me;
    private com.baidu.tbadk.core.dialog.a Mf;
    private long Mg;
    private long Mh;
    private final int[] Mi;
    private final a Mj;
    private SweepGradient Mk;
    private int Ml;
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
                if (s.this.Md >= 360.0f) {
                    s.this.Md = 360.0f;
                    s.this.Ly = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    s.this.Mg = uptimeMillis;
                    s.this.Mh = uptimeMillis + 200;
                    s.this.Md += (((float) (uptimeMillis - s.this.Mg)) / 1000.0f) * s.this.Mc;
                    sendEmptyMessageAtTime(1, s.this.Mh);
                    s.this.Ly++;
                }
                s.this.Lx = s.this.Ly % 6;
                s.this.invalidate();
            }
        }
    }

    public static s ak(Context context) {
        return new s(context);
    }

    public s(Context context) {
        this(context, null);
    }

    public s(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.KX = 0L;
        this.Lp = new int[4];
        this.Lx = 0;
        this.Ly = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.Lz = 0;
        this.LA = 0;
        this.LB = 0;
        this.LC = 0;
        this.LD = 0;
        this.LE = 0;
        this.LJ = -1724676609;
        this.LK = 1546880511;
        this.LL = 674465279;
        this.LM = 255034879;
        this.LN = -1725669966;
        this.LO = 1545887154;
        this.LP = 673471922;
        this.LQ = 254041522;
        this.LS = new Paint(1);
        this.LT = new Rect();
        this.LU = new RectF();
        this.Lk = 0;
        this.Mi = new int[2];
        this.Mj = new a(this, null);
        this.KW = 0;
        this.Ml = 0;
        this.Lp[0] = context.getResources().getDimensionPixelSize(w.f.ds24);
        this.Lp[1] = context.getResources().getDimensionPixelSize(w.f.ds8);
        this.Lp[2] = context.getResources().getDimensionPixelSize(w.f.ds22);
        this.Lp[3] = context.getResources().getDimensionPixelSize(w.f.ds36);
        this.Lz = context.getResources().getDimensionPixelSize(w.f.ds134);
        this.LA = this.Lz + context.getResources().getDimensionPixelSize(w.f.ds14);
        this.LB = this.LA + context.getResources().getDimensionPixelSize(w.f.ds16);
        this.LC = this.LB + context.getResources().getDimensionPixelSize(w.f.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.LD = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.LE = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.LD = context.getResources().getDimensionPixelSize(w.f.ds70);
            this.LE = context.getResources().getDimensionPixelSize(w.f.ds210);
        }
        this.Lq = context.getResources().getDimensionPixelSize(w.f.ds26);
        this.Lr = context.getResources().getDimensionPixelSize(w.f.ds10);
        this.Ls = context.getResources().getDimensionPixelSize(w.f.ds14);
        this.Lt = context.getResources().getDimensionPixelSize(w.f.ds4);
        this.Lu = context.getResources().getDimensionPixelSize(w.f.ds4);
        this.Lv = context.getResources().getDimensionPixelSize(w.f.ds12);
        this.Lw = context.getResources().getDimensionPixelSize(w.f.ds2);
        this.LS.setStyle(Paint.Style.STROKE);
        this.LS.setStrokeWidth(this.Lv);
        this.LR = (BitmapDrawable) getResources().getDrawable(w.g.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        al(context);
        mt();
        this.Mi[0] = aq.getColor(w.e.common_color_10151);
        this.Mi[1] = aq.getColor(w.e.common_color_10152);
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
        this.Lq = ((i4 - getContext().getResources().getDimensionPixelSize(w.f.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(w.f.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.LZ.getMeasuredWidth();
        int measuredHeight = this.LZ.getMeasuredHeight();
        int measuredWidth2 = this.LW.getMeasuredWidth();
        this.LW.layout((i5 - measuredWidth2) >> 1, this.Lq + i2, (measuredWidth2 + i5) >> 1, this.LW.getMeasuredHeight() + this.Lq + i2);
        int bottom = this.LW.getBottom();
        this.LZ.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.LY.getMeasuredWidth();
        int measuredHeight2 = this.LY.getMeasuredHeight();
        int top = this.LZ.getTop();
        this.LY.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.LV.getMeasuredWidth();
        int measuredHeight3 = this.LV.getMeasuredHeight();
        int right = this.LZ.getRight() - this.Lr;
        int bottom2 = this.LZ.getBottom() - this.Ls;
        this.LV.layout(this.LD + i6, this.LE + bottom, measuredWidth4 + i6 + this.LD, measuredHeight3 + this.LE + bottom);
        int measuredWidth5 = this.Ma.getMeasuredWidth();
        this.Ma.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Ma.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Mb.getMeasuredWidth();
        this.Mb.layout((i5 - measuredWidth6) >> 1, (this.LV.getTop() - this.Mb.getMeasuredHeight()) - this.Lt, (measuredWidth6 + i5) >> 1, (this.LV.getTop() + i2) - this.Lt);
        this.LZ.getLeft();
        this.LZ.getRight();
        int measuredWidth7 = this.LX.getMeasuredWidth();
        int measuredHeight4 = this.LX.getMeasuredHeight();
        int bottom3 = this.LZ.getBottom();
        this.LX.layout((i5 - measuredWidth7) >> 1, this.Lp[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.Lp[3]);
        this.LT.set((i5 - this.LR.getIntrinsicWidth()) >> 1, this.Ma.getTop() - this.Lu, (i5 + this.LR.getIntrinsicHeight()) >> 1, (this.Ma.getTop() + this.LR.getIntrinsicHeight()) - this.Lu);
        this.LR.setBounds(this.LT);
        this.LU.set(this.Ma.getLeft() + (this.Lv >> 1) + this.Lw, this.Ma.getTop() + (this.Lv >> 1) + this.Lw, (this.Ma.getRight() - (this.Lv >> 1)) - this.Lw, (this.Ma.getBottom() - (this.Lv >> 1)) - this.Lw);
        if (this.Mk == null) {
            this.Mk = new SweepGradient(this.LU.centerX(), this.LU.centerY(), this.Mi, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Mk.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.LU.centerX(), this.LU.centerY());
            this.Mk.setLocalMatrix(matrix);
            this.LS.setShader(this.Mk);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        d(canvas);
        super.dispatchDraw(canvas);
    }

    private void mn() {
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Mf == null) {
            this.Mf = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.k.aa(getContext()).getPageActivity());
            this.Mf.cx(getContext().getString(w.l.voice_restart_tip)).a(getContext().getString(w.l.voice_restart), new t(this, recorderManager)).b(getContext().getString(w.l.cancel), new u(this)).b(com.baidu.adp.base.k.aa(getContext()));
        }
        try {
            this.Mf.ts();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bE(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void al(Context context) {
        LayoutInflater.from(context).inflate(w.j.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.LW = (TextView) findViewById(w.h.tip_error);
        aq.c(this.LW, w.e.cp_cont_i, 1);
        this.LX = (TextView) findViewById(w.h.tip_operator);
        this.LY = (TextView) findViewById(w.h.tip_time_out);
        this.LZ = (VoiceButton) findViewById(w.h.voice_bnt);
        this.LV = (TextView) findViewById(w.h.restart);
        this.Ma = (ImageView) findViewById(w.h.play_img);
        this.Mb = (TextView) findViewById(w.h.play_time);
        this.Mb.setClickable(false);
        this.LV.setOnClickListener(this);
        this.Ma.setOnClickListener(this);
        this.LZ.setRecorderView(this);
        mp();
    }

    private void mo() {
        this.LZ.setVisibility(4);
        this.Mb.setVisibility(0);
        this.LV.setVisibility(0);
        aq.c(this.Mb, w.e.cp_cont_f, 1);
        aq.c(this.LV, w.e.cp_cont_f, 1);
        aq.j(this.LV, w.g.but_posts_record_again_selector);
        this.Ma.setVisibility(0);
        if (this.mModel != null) {
            this.Mb.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Ma.setContentDescription(String.format(getContext().getString(w.l.listen_time), Integer.valueOf(this.mModel.duration)));
            aq.c(this.Ma, w.g.but_posts_record_play_selector);
        }
        aq.c(this.LX, w.e.cp_cont_c, 1);
        this.LX.setText(getContext().getString(w.l.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mp() {
        aq.c(this.LZ, w.g.but_posts_record_zero_selector);
        this.LZ.setVisibility(0);
        this.Lx = 0;
        this.Ma.setVisibility(4);
        this.Mb.setVisibility(4);
        this.LV.setVisibility(4);
        this.LY.setVisibility(4);
        aq.c(this.LX, w.e.cp_cont_c, 1);
        this.LX.setText(getContext().getString(w.l.voice_record_press_to_record));
    }

    public void reset() {
        mp();
        this.mModel = null;
        this.Lx = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.LW.setText("");
        this.LW.setVisibility(4);
        this.Lx = 0;
        mo();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
        if (z) {
            mp();
            this.LX.setText(getContext().getString(w.l.voice_record_release_to_stop));
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
        if (this.Ma != null && this.Mb != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    aq.c(this.Mb, w.e.cp_cont_f, 1);
                    this.Mb.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    aq.c(this.Ma, w.g.but_posts_record_play_selector);
                    this.Ma.setContentDescription(String.format(getContext().getString(w.l.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.LX.setText(getContext().getString(w.l.voice_play_tip));
                    mr();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    aq.c(this.Mb, w.e.cp_cont_f, 1);
                    aq.c(this.Ma, w.g.but_posts_record_stop_selector);
                    this.Ma.setContentDescription(getContext().getString(w.l.pause));
                    this.LX.setText(getContext().getString(w.l.voice_stop_tip));
                    mq();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
        aq.c(this.LY, w.e.cp_cont_i, 1);
        aq.c(this.LW, w.e.cp_cont_i, 1);
        aq.c(this.LX, w.e.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.LY.setVisibility(0);
                this.LY.setText(str);
                postDelayed(new v(this), 2000L);
            } else if (i == 2) {
                this.LW.setVisibility(0);
                this.LW.setText(str);
                this.LX.setText(w.l.voice_record_press_to_record);
                postDelayed(new w(this), 2000L);
            } else if (i == 5) {
                this.LW.setVisibility(0);
                this.LW.setText(str);
                postDelayed(new x(this), 2000L);
            } else {
                mp();
                this.LW.setVisibility(0);
                this.LW.setText(str);
                postDelayed(new y(this), 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
        this.LW.setVisibility(4);
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
        aq.c(this.LW, w.e.cp_cont_i, 1);
        this.LW.setVisibility(0);
        this.LW.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.KW = Math.max(i, this.KW);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.KX > 200) {
            this.KW = 0;
            this.KX = uptimeMillis;
        }
        if (this.KW < 10) {
            this.Lx = 1;
            invalidate();
        } else if (this.KW < 20) {
            this.Lx = 2;
            invalidate();
        } else if (this.KW < 30) {
            this.Lx = 3;
            invalidate();
        } else if (this.KW < 40) {
            this.Lx = 4;
            invalidate();
        } else {
            this.Lx = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (this.mModel != null && this.Mb != null) {
            int i2 = i / 1000;
            if (this.Ml != i2) {
                this.Mb.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Ml = i2;
        }
    }

    private void mq() {
        if (this.mModel != null) {
            this.Lx = 0;
            this.Mc = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Mg = SystemClock.uptimeMillis();
            this.Mh = this.Mg + 200;
            this.Mj.sendEmptyMessageAtTime(1, this.Mh);
            invalidate();
        }
    }

    private void mr() {
        this.Lx = 0;
        this.Ly = 0;
        this.Mc = 0.0f;
        this.Md = 0.0f;
        this.Mj.removeMessages(1);
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
                mn();
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
        this.Me = rVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void ms() {
    }

    public void mt() {
        this.LF = new Paint();
        this.LF.setAntiAlias(true);
        this.LF.setStyle(Paint.Style.STROKE);
        this.LF.setStrokeWidth(2.0f);
        this.LG = new Paint();
        this.LG.setAntiAlias(true);
        this.LG.setStyle(Paint.Style.STROKE);
        this.LG.setStrokeWidth(2.0f);
        this.LH = new Paint();
        this.LH.setAntiAlias(true);
        this.LH.setStyle(Paint.Style.STROKE);
        this.LH.setStrokeWidth(2.0f);
        this.LI = new Paint();
        this.LI.setAntiAlias(true);
        this.LI.setStyle(Paint.Style.STROKE);
        this.LI.setStrokeWidth(2.0f);
    }

    public void d(Canvas canvas) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            this.LF.setColor(this.LN);
            this.LG.setColor(this.LO);
            this.LH.setColor(this.LP);
            this.LI.setColor(this.LQ);
        } else {
            this.LF.setColor(this.LJ);
            this.LG.setColor(this.LK);
            this.LH.setColor(this.LL);
            this.LI.setColor(this.LM);
        }
        if (this.Lx == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.Lz, this.LF);
        } else if (this.Lx == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.Lz, this.LF);
            canvas.drawCircle(this.centerX, this.centerY, this.LA, this.LG);
        } else if (this.Lx == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.Lz, this.LF);
            canvas.drawCircle(this.centerX, this.centerY, this.LA, this.LG);
            canvas.drawCircle(this.centerX, this.centerY, this.LB, this.LH);
        } else if (this.Lx == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.Lz, this.LF);
            canvas.drawCircle(this.centerX, this.centerY, this.LA, this.LG);
            canvas.drawCircle(this.centerX, this.centerY, this.LB, this.LH);
            canvas.drawCircle(this.centerX, this.centerY, this.LC, this.LI);
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
    public void ml() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.Lk;
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
        if (this.Ll != null) {
            this.Ll.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.Ll = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.Lk = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
    }
}
