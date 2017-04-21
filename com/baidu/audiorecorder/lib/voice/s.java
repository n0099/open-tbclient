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
    private long KA;
    private int KN;
    private com.baidu.tbadk.editortools.j KO;
    private final int[] KS;
    private int KT;
    private int KU;
    private final int KV;
    private final int KW;
    private final int KX;
    private final int KY;
    private final int KZ;
    private int Kz;
    private TextView LA;
    private TextView LB;
    private VoiceButton LC;
    private ImageView LD;
    private TextView LE;
    private float LF;
    private float LG;
    private r LH;
    private com.baidu.tbadk.core.dialog.a LI;
    private long LJ;
    private long LK;
    private final int[] LL;
    private final a LM;
    private SweepGradient LN;
    private int LO;
    private int La;
    private int Lb;
    private int Lc;
    private int Ld;
    private int Le;
    private int Lf;
    private int Lg;
    private int Lh;
    private Paint Li;
    private Paint Lj;
    private Paint Lk;
    private Paint Ll;
    private int Lm;
    private int Ln;
    private int Lo;
    private int Lp;
    private int Lq;
    private int Lr;
    private int Ls;
    private int Lt;
    private final BitmapDrawable Lu;
    private final Paint Lv;
    private final Rect Lw;
    private final RectF Lx;
    private TextView Ly;
    private TextView Lz;
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
                if (s.this.LG >= 360.0f) {
                    s.this.LG = 360.0f;
                    s.this.Lb = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    s.this.LJ = uptimeMillis;
                    s.this.LK = uptimeMillis + 200;
                    s.this.LG += (((float) (uptimeMillis - s.this.LJ)) / 1000.0f) * s.this.LF;
                    sendEmptyMessageAtTime(1, s.this.LK);
                    s.this.Lb++;
                }
                s.this.La = s.this.Lb % 6;
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
        this.KA = 0L;
        this.KS = new int[4];
        this.La = 0;
        this.Lb = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.Lc = 0;
        this.Ld = 0;
        this.Le = 0;
        this.Lf = 0;
        this.Lg = 0;
        this.Lh = 0;
        this.Lm = -1724676609;
        this.Ln = 1546880511;
        this.Lo = 674465279;
        this.Lp = 255034879;
        this.Lq = -1725669966;
        this.Lr = 1545887154;
        this.Ls = 673471922;
        this.Lt = 254041522;
        this.Lv = new Paint(1);
        this.Lw = new Rect();
        this.Lx = new RectF();
        this.KN = 0;
        this.LL = new int[2];
        this.LM = new a(this, null);
        this.Kz = 0;
        this.LO = 0;
        this.KS[0] = context.getResources().getDimensionPixelSize(w.f.ds24);
        this.KS[1] = context.getResources().getDimensionPixelSize(w.f.ds8);
        this.KS[2] = context.getResources().getDimensionPixelSize(w.f.ds22);
        this.KS[3] = context.getResources().getDimensionPixelSize(w.f.ds36);
        this.Lc = context.getResources().getDimensionPixelSize(w.f.ds134);
        this.Ld = this.Lc + context.getResources().getDimensionPixelSize(w.f.ds14);
        this.Le = this.Ld + context.getResources().getDimensionPixelSize(w.f.ds16);
        this.Lf = this.Le + context.getResources().getDimensionPixelSize(w.f.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.Lg = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.Lh = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.Lg = context.getResources().getDimensionPixelSize(w.f.ds70);
            this.Lh = context.getResources().getDimensionPixelSize(w.f.ds210);
        }
        this.KT = context.getResources().getDimensionPixelSize(w.f.ds26);
        this.KU = context.getResources().getDimensionPixelSize(w.f.ds10);
        this.KV = context.getResources().getDimensionPixelSize(w.f.ds14);
        this.KW = context.getResources().getDimensionPixelSize(w.f.ds4);
        this.KX = context.getResources().getDimensionPixelSize(w.f.ds4);
        this.KY = context.getResources().getDimensionPixelSize(w.f.ds12);
        this.KZ = context.getResources().getDimensionPixelSize(w.f.ds2);
        this.Lv.setStyle(Paint.Style.STROKE);
        this.Lv.setStrokeWidth(this.KY);
        this.Lu = (BitmapDrawable) getResources().getDrawable(w.g.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        ak(context);
        mx();
        this.LL[0] = aq.getColor(w.e.common_color_10151);
        this.LL[1] = aq.getColor(w.e.common_color_10152);
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
        this.KT = ((i4 - getContext().getResources().getDimensionPixelSize(w.f.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(w.f.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.LC.getMeasuredWidth();
        int measuredHeight = this.LC.getMeasuredHeight();
        int measuredWidth2 = this.Lz.getMeasuredWidth();
        this.Lz.layout((i5 - measuredWidth2) >> 1, this.KT + i2, (measuredWidth2 + i5) >> 1, this.Lz.getMeasuredHeight() + this.KT + i2);
        int bottom = this.Lz.getBottom();
        this.LC.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.LB.getMeasuredWidth();
        int measuredHeight2 = this.LB.getMeasuredHeight();
        int top = this.LC.getTop();
        this.LB.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Ly.getMeasuredWidth();
        int measuredHeight3 = this.Ly.getMeasuredHeight();
        int right = this.LC.getRight() - this.KU;
        int bottom2 = this.LC.getBottom() - this.KV;
        this.Ly.layout(this.Lg + i6, this.Lh + bottom, measuredWidth4 + i6 + this.Lg, measuredHeight3 + this.Lh + bottom);
        int measuredWidth5 = this.LD.getMeasuredWidth();
        this.LD.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.LD.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.LE.getMeasuredWidth();
        this.LE.layout((i5 - measuredWidth6) >> 1, (this.Ly.getTop() - this.LE.getMeasuredHeight()) - this.KW, (measuredWidth6 + i5) >> 1, (this.Ly.getTop() + i2) - this.KW);
        this.LC.getLeft();
        this.LC.getRight();
        int measuredWidth7 = this.LA.getMeasuredWidth();
        int measuredHeight4 = this.LA.getMeasuredHeight();
        int bottom3 = this.LC.getBottom();
        this.LA.layout((i5 - measuredWidth7) >> 1, this.KS[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.KS[3]);
        this.Lw.set((i5 - this.Lu.getIntrinsicWidth()) >> 1, this.LD.getTop() - this.KX, (i5 + this.Lu.getIntrinsicHeight()) >> 1, (this.LD.getTop() + this.Lu.getIntrinsicHeight()) - this.KX);
        this.Lu.setBounds(this.Lw);
        this.Lx.set(this.LD.getLeft() + (this.KY >> 1) + this.KZ, this.LD.getTop() + (this.KY >> 1) + this.KZ, (this.LD.getRight() - (this.KY >> 1)) - this.KZ, (this.LD.getBottom() - (this.KY >> 1)) - this.KZ);
        if (this.LN == null) {
            this.LN = new SweepGradient(this.Lx.centerX(), this.Lx.centerY(), this.LL, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.LN.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Lx.centerX(), this.Lx.centerY());
            this.LN.setLocalMatrix(matrix);
            this.Lv.setShader(this.LN);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        d(canvas);
        super.dispatchDraw(canvas);
    }

    private void mr() {
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.LI == null) {
            this.LI = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.k.Z(getContext()).getPageActivity());
            this.LI.cE(getContext().getString(w.l.voice_restart_tip)).a(getContext().getString(w.l.voice_restart), new t(this, recorderManager)).b(getContext().getString(w.l.cancel), new u(this)).b(com.baidu.adp.base.k.Z(getContext()));
        }
        try {
            this.LI.tQ();
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
        this.Lz = (TextView) findViewById(w.h.tip_error);
        aq.c(this.Lz, w.e.cp_cont_i, 1);
        this.LA = (TextView) findViewById(w.h.tip_operator);
        this.LB = (TextView) findViewById(w.h.tip_time_out);
        this.LC = (VoiceButton) findViewById(w.h.voice_bnt);
        this.Ly = (TextView) findViewById(w.h.restart);
        this.LD = (ImageView) findViewById(w.h.play_img);
        this.LE = (TextView) findViewById(w.h.play_time);
        this.LE.setClickable(false);
        this.Ly.setOnClickListener(this);
        this.LD.setOnClickListener(this);
        this.LC.setRecorderView(this);
        mt();
    }

    private void ms() {
        this.LC.setVisibility(4);
        this.LE.setVisibility(0);
        this.Ly.setVisibility(0);
        aq.c(this.LE, w.e.cp_cont_f, 1);
        aq.c(this.Ly, w.e.cp_cont_f, 1);
        aq.j(this.Ly, w.g.but_posts_record_again_selector);
        this.LD.setVisibility(0);
        if (this.mModel != null) {
            this.LE.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.LD.setContentDescription(String.format(getContext().getString(w.l.listen_time), Integer.valueOf(this.mModel.duration)));
            aq.c(this.LD, w.g.but_posts_record_play_selector);
        }
        aq.c(this.LA, w.e.cp_cont_c, 1);
        this.LA.setText(getContext().getString(w.l.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mt() {
        aq.c(this.LC, w.g.but_posts_record_zero_selector);
        this.LC.setVisibility(0);
        this.La = 0;
        this.LD.setVisibility(4);
        this.LE.setVisibility(4);
        this.Ly.setVisibility(4);
        this.LB.setVisibility(4);
        aq.c(this.LA, w.e.cp_cont_c, 1);
        this.LA.setText(getContext().getString(w.l.voice_record_press_to_record));
    }

    public void reset() {
        mt();
        this.mModel = null;
        this.La = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Lz.setText("");
        this.Lz.setVisibility(4);
        this.La = 0;
        ms();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
        if (z) {
            mt();
            this.LA.setText(getContext().getString(w.l.voice_record_release_to_stop));
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
        if (this.LD != null && this.LE != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    aq.c(this.LE, w.e.cp_cont_f, 1);
                    this.LE.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    aq.c(this.LD, w.g.but_posts_record_play_selector);
                    this.LD.setContentDescription(String.format(getContext().getString(w.l.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.LA.setText(getContext().getString(w.l.voice_play_tip));
                    mv();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    aq.c(this.LE, w.e.cp_cont_f, 1);
                    aq.c(this.LD, w.g.but_posts_record_stop_selector);
                    this.LD.setContentDescription(getContext().getString(w.l.pause));
                    this.LA.setText(getContext().getString(w.l.voice_stop_tip));
                    mu();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
        aq.c(this.LB, w.e.cp_cont_i, 1);
        aq.c(this.Lz, w.e.cp_cont_i, 1);
        aq.c(this.LA, w.e.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.LB.setVisibility(0);
                this.LB.setText(str);
                postDelayed(new v(this), 2000L);
            } else if (i == 2) {
                this.Lz.setVisibility(0);
                this.Lz.setText(str);
                this.LA.setText(w.l.voice_record_press_to_record);
                postDelayed(new w(this), 2000L);
            } else if (i == 5) {
                this.Lz.setVisibility(0);
                this.Lz.setText(str);
                postDelayed(new x(this), 2000L);
            } else {
                mt();
                this.Lz.setVisibility(0);
                this.Lz.setText(str);
                postDelayed(new y(this), 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
        this.Lz.setVisibility(4);
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
        aq.c(this.Lz, w.e.cp_cont_i, 1);
        this.Lz.setVisibility(0);
        this.Lz.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.Kz = Math.max(i, this.Kz);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.KA > 200) {
            this.Kz = 0;
            this.KA = uptimeMillis;
        }
        if (this.Kz < 10) {
            this.La = 1;
            invalidate();
        } else if (this.Kz < 20) {
            this.La = 2;
            invalidate();
        } else if (this.Kz < 30) {
            this.La = 3;
            invalidate();
        } else if (this.Kz < 40) {
            this.La = 4;
            invalidate();
        } else {
            this.La = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aR(int i) {
        if (this.mModel != null && this.LE != null) {
            int i2 = i / 1000;
            if (this.LO != i2) {
                this.LE.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.LO = i2;
        }
    }

    private void mu() {
        if (this.mModel != null) {
            this.La = 0;
            this.LF = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.LJ = SystemClock.uptimeMillis();
            this.LK = this.LJ + 200;
            this.LM.sendEmptyMessageAtTime(1, this.LK);
            invalidate();
        }
    }

    private void mv() {
        this.La = 0;
        this.Lb = 0;
        this.LF = 0.0f;
        this.LG = 0.0f;
        this.LM.removeMessages(1);
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
                mr();
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
        this.LH = rVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void mw() {
    }

    public void mx() {
        this.Li = new Paint();
        this.Li.setAntiAlias(true);
        this.Li.setStyle(Paint.Style.STROKE);
        this.Li.setStrokeWidth(2.0f);
        this.Lj = new Paint();
        this.Lj.setAntiAlias(true);
        this.Lj.setStyle(Paint.Style.STROKE);
        this.Lj.setStrokeWidth(2.0f);
        this.Lk = new Paint();
        this.Lk.setAntiAlias(true);
        this.Lk.setStyle(Paint.Style.STROKE);
        this.Lk.setStrokeWidth(2.0f);
        this.Ll = new Paint();
        this.Ll.setAntiAlias(true);
        this.Ll.setStyle(Paint.Style.STROKE);
        this.Ll.setStrokeWidth(2.0f);
    }

    public void d(Canvas canvas) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            this.Li.setColor(this.Lq);
            this.Lj.setColor(this.Lr);
            this.Lk.setColor(this.Ls);
            this.Ll.setColor(this.Lt);
        } else {
            this.Li.setColor(this.Lm);
            this.Lj.setColor(this.Ln);
            this.Lk.setColor(this.Lo);
            this.Ll.setColor(this.Lp);
        }
        if (this.La == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.Lc, this.Li);
        } else if (this.La == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.Lc, this.Li);
            canvas.drawCircle(this.centerX, this.centerY, this.Ld, this.Lj);
        } else if (this.La == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.Lc, this.Li);
            canvas.drawCircle(this.centerX, this.centerY, this.Ld, this.Lj);
            canvas.drawCircle(this.centerX, this.centerY, this.Le, this.Lk);
        } else if (this.La == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.Lc, this.Li);
            canvas.drawCircle(this.centerX, this.centerY, this.Ld, this.Lj);
            canvas.drawCircle(this.centerX, this.centerY, this.Le, this.Lk);
            canvas.drawCircle(this.centerX, this.centerY, this.Lf, this.Ll);
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
    public void mp() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.KN;
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
        if (this.KO != null) {
            this.KO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.KO = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.KN = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
    }
}
