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
    private int KL;
    private com.baidu.tbadk.editortools.j KM;
    private final int[] KQ;
    private int KR;
    private int KS;
    private final int KT;
    private final int KU;
    private final int KV;
    private final int KW;
    private final int KX;
    private int KY;
    private int KZ;
    private int Kx;
    private long Ky;
    private VoiceButton LA;
    private ImageView LB;
    private TextView LC;
    private float LD;
    private float LE;
    private r LF;
    private com.baidu.tbadk.core.dialog.a LG;
    private long LH;
    private long LI;
    private final int[] LJ;
    private final a LK;
    private SweepGradient LL;
    private int LM;
    private int La;
    private int Lb;
    private int Lc;
    private int Ld;
    private int Le;
    private int Lf;
    private Paint Lg;
    private Paint Lh;
    private Paint Li;
    private Paint Lj;
    private int Lk;
    private int Ll;
    private int Lm;
    private int Ln;
    private int Lo;
    private int Lp;
    private int Lq;
    private int Lr;
    private final BitmapDrawable Ls;
    private final Paint Lt;
    private final Rect Lu;
    private final RectF Lv;
    private TextView Lw;
    private TextView Lx;
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
                if (s.this.LE >= 360.0f) {
                    s.this.LE = 360.0f;
                    s.this.KZ = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    s.this.LH = uptimeMillis;
                    s.this.LI = uptimeMillis + 200;
                    s.this.LE += (((float) (uptimeMillis - s.this.LH)) / 1000.0f) * s.this.LD;
                    sendEmptyMessageAtTime(1, s.this.LI);
                    s.this.KZ++;
                }
                s.this.KY = s.this.KZ % 6;
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
        this.Ky = 0L;
        this.KQ = new int[4];
        this.KY = 0;
        this.KZ = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.La = 0;
        this.Lb = 0;
        this.Lc = 0;
        this.Ld = 0;
        this.Le = 0;
        this.Lf = 0;
        this.Lk = -1724676609;
        this.Ll = 1546880511;
        this.Lm = 674465279;
        this.Ln = 255034879;
        this.Lo = -1725669966;
        this.Lp = 1545887154;
        this.Lq = 673471922;
        this.Lr = 254041522;
        this.Lt = new Paint(1);
        this.Lu = new Rect();
        this.Lv = new RectF();
        this.KL = 0;
        this.LJ = new int[2];
        this.LK = new a(this, null);
        this.Kx = 0;
        this.LM = 0;
        this.KQ[0] = context.getResources().getDimensionPixelSize(w.f.ds24);
        this.KQ[1] = context.getResources().getDimensionPixelSize(w.f.ds8);
        this.KQ[2] = context.getResources().getDimensionPixelSize(w.f.ds22);
        this.KQ[3] = context.getResources().getDimensionPixelSize(w.f.ds36);
        this.La = context.getResources().getDimensionPixelSize(w.f.ds134);
        this.Lb = this.La + context.getResources().getDimensionPixelSize(w.f.ds14);
        this.Lc = this.Lb + context.getResources().getDimensionPixelSize(w.f.ds16);
        this.Ld = this.Lc + context.getResources().getDimensionPixelSize(w.f.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.Le = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.Lf = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.Le = context.getResources().getDimensionPixelSize(w.f.ds70);
            this.Lf = context.getResources().getDimensionPixelSize(w.f.ds210);
        }
        this.KR = context.getResources().getDimensionPixelSize(w.f.ds26);
        this.KS = context.getResources().getDimensionPixelSize(w.f.ds10);
        this.KT = context.getResources().getDimensionPixelSize(w.f.ds14);
        this.KU = context.getResources().getDimensionPixelSize(w.f.ds4);
        this.KV = context.getResources().getDimensionPixelSize(w.f.ds4);
        this.KW = context.getResources().getDimensionPixelSize(w.f.ds12);
        this.KX = context.getResources().getDimensionPixelSize(w.f.ds2);
        this.Lt.setStyle(Paint.Style.STROKE);
        this.Lt.setStrokeWidth(this.KW);
        this.Ls = (BitmapDrawable) getResources().getDrawable(w.g.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        ak(context);
        mx();
        this.LJ[0] = aq.getColor(w.e.common_color_10151);
        this.LJ[1] = aq.getColor(w.e.common_color_10152);
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
        this.KR = ((i4 - getContext().getResources().getDimensionPixelSize(w.f.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(w.f.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.LA.getMeasuredWidth();
        int measuredHeight = this.LA.getMeasuredHeight();
        int measuredWidth2 = this.Lx.getMeasuredWidth();
        this.Lx.layout((i5 - measuredWidth2) >> 1, this.KR + i2, (measuredWidth2 + i5) >> 1, this.Lx.getMeasuredHeight() + this.KR + i2);
        int bottom = this.Lx.getBottom();
        this.LA.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Lz.getMeasuredWidth();
        int measuredHeight2 = this.Lz.getMeasuredHeight();
        int top = this.LA.getTop();
        this.Lz.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Lw.getMeasuredWidth();
        int measuredHeight3 = this.Lw.getMeasuredHeight();
        int right = this.LA.getRight() - this.KS;
        int bottom2 = this.LA.getBottom() - this.KT;
        this.Lw.layout(this.Le + i6, this.Lf + bottom, measuredWidth4 + i6 + this.Le, measuredHeight3 + this.Lf + bottom);
        int measuredWidth5 = this.LB.getMeasuredWidth();
        this.LB.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.LB.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.LC.getMeasuredWidth();
        this.LC.layout((i5 - measuredWidth6) >> 1, (this.Lw.getTop() - this.LC.getMeasuredHeight()) - this.KU, (measuredWidth6 + i5) >> 1, (this.Lw.getTop() + i2) - this.KU);
        this.LA.getLeft();
        this.LA.getRight();
        int measuredWidth7 = this.Ly.getMeasuredWidth();
        int measuredHeight4 = this.Ly.getMeasuredHeight();
        int bottom3 = this.LA.getBottom();
        this.Ly.layout((i5 - measuredWidth7) >> 1, this.KQ[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.KQ[3]);
        this.Lu.set((i5 - this.Ls.getIntrinsicWidth()) >> 1, this.LB.getTop() - this.KV, (i5 + this.Ls.getIntrinsicHeight()) >> 1, (this.LB.getTop() + this.Ls.getIntrinsicHeight()) - this.KV);
        this.Ls.setBounds(this.Lu);
        this.Lv.set(this.LB.getLeft() + (this.KW >> 1) + this.KX, this.LB.getTop() + (this.KW >> 1) + this.KX, (this.LB.getRight() - (this.KW >> 1)) - this.KX, (this.LB.getBottom() - (this.KW >> 1)) - this.KX);
        if (this.LL == null) {
            this.LL = new SweepGradient(this.Lv.centerX(), this.Lv.centerY(), this.LJ, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.LL.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Lv.centerX(), this.Lv.centerY());
            this.LL.setLocalMatrix(matrix);
            this.Lt.setShader(this.LL);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        d(canvas);
        super.dispatchDraw(canvas);
    }

    private void mr() {
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.LG == null) {
            this.LG = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.k.Z(getContext()).getPageActivity());
            this.LG.cE(getContext().getString(w.l.voice_restart_tip)).a(getContext().getString(w.l.voice_restart), new t(this, recorderManager)).b(getContext().getString(w.l.cancel), new u(this)).b(com.baidu.adp.base.k.Z(getContext()));
        }
        try {
            this.LG.tQ();
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
        this.Lx = (TextView) findViewById(w.h.tip_error);
        aq.c(this.Lx, w.e.cp_cont_i, 1);
        this.Ly = (TextView) findViewById(w.h.tip_operator);
        this.Lz = (TextView) findViewById(w.h.tip_time_out);
        this.LA = (VoiceButton) findViewById(w.h.voice_bnt);
        this.Lw = (TextView) findViewById(w.h.restart);
        this.LB = (ImageView) findViewById(w.h.play_img);
        this.LC = (TextView) findViewById(w.h.play_time);
        this.LC.setClickable(false);
        this.Lw.setOnClickListener(this);
        this.LB.setOnClickListener(this);
        this.LA.setRecorderView(this);
        mt();
    }

    private void ms() {
        this.LA.setVisibility(4);
        this.LC.setVisibility(0);
        this.Lw.setVisibility(0);
        aq.c(this.LC, w.e.cp_cont_f, 1);
        aq.c(this.Lw, w.e.cp_cont_f, 1);
        aq.j(this.Lw, w.g.but_posts_record_again_selector);
        this.LB.setVisibility(0);
        if (this.mModel != null) {
            this.LC.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.LB.setContentDescription(String.format(getContext().getString(w.l.listen_time), Integer.valueOf(this.mModel.duration)));
            aq.c(this.LB, w.g.but_posts_record_play_selector);
        }
        aq.c(this.Ly, w.e.cp_cont_c, 1);
        this.Ly.setText(getContext().getString(w.l.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mt() {
        aq.c(this.LA, w.g.but_posts_record_zero_selector);
        this.LA.setVisibility(0);
        this.KY = 0;
        this.LB.setVisibility(4);
        this.LC.setVisibility(4);
        this.Lw.setVisibility(4);
        this.Lz.setVisibility(4);
        aq.c(this.Ly, w.e.cp_cont_c, 1);
        this.Ly.setText(getContext().getString(w.l.voice_record_press_to_record));
    }

    public void reset() {
        mt();
        this.mModel = null;
        this.KY = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Lx.setText("");
        this.Lx.setVisibility(4);
        this.KY = 0;
        ms();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
        if (z) {
            mt();
            this.Ly.setText(getContext().getString(w.l.voice_record_release_to_stop));
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
        if (this.LB != null && this.LC != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    aq.c(this.LC, w.e.cp_cont_f, 1);
                    this.LC.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    aq.c(this.LB, w.g.but_posts_record_play_selector);
                    this.LB.setContentDescription(String.format(getContext().getString(w.l.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Ly.setText(getContext().getString(w.l.voice_play_tip));
                    mv();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    aq.c(this.LC, w.e.cp_cont_f, 1);
                    aq.c(this.LB, w.g.but_posts_record_stop_selector);
                    this.LB.setContentDescription(getContext().getString(w.l.pause));
                    this.Ly.setText(getContext().getString(w.l.voice_stop_tip));
                    mu();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
        aq.c(this.Lz, w.e.cp_cont_i, 1);
        aq.c(this.Lx, w.e.cp_cont_i, 1);
        aq.c(this.Ly, w.e.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Lz.setVisibility(0);
                this.Lz.setText(str);
                postDelayed(new v(this), 2000L);
            } else if (i == 2) {
                this.Lx.setVisibility(0);
                this.Lx.setText(str);
                this.Ly.setText(w.l.voice_record_press_to_record);
                postDelayed(new w(this), 2000L);
            } else if (i == 5) {
                this.Lx.setVisibility(0);
                this.Lx.setText(str);
                postDelayed(new x(this), 2000L);
            } else {
                mt();
                this.Lx.setVisibility(0);
                this.Lx.setText(str);
                postDelayed(new y(this), 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
        this.Lx.setVisibility(4);
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
        aq.c(this.Lx, w.e.cp_cont_i, 1);
        this.Lx.setVisibility(0);
        this.Lx.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.Kx = Math.max(i, this.Kx);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Ky > 200) {
            this.Kx = 0;
            this.Ky = uptimeMillis;
        }
        if (this.Kx < 10) {
            this.KY = 1;
            invalidate();
        } else if (this.Kx < 20) {
            this.KY = 2;
            invalidate();
        } else if (this.Kx < 30) {
            this.KY = 3;
            invalidate();
        } else if (this.Kx < 40) {
            this.KY = 4;
            invalidate();
        } else {
            this.KY = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aR(int i) {
        if (this.mModel != null && this.LC != null) {
            int i2 = i / 1000;
            if (this.LM != i2) {
                this.LC.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.LM = i2;
        }
    }

    private void mu() {
        if (this.mModel != null) {
            this.KY = 0;
            this.LD = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.LH = SystemClock.uptimeMillis();
            this.LI = this.LH + 200;
            this.LK.sendEmptyMessageAtTime(1, this.LI);
            invalidate();
        }
    }

    private void mv() {
        this.KY = 0;
        this.KZ = 0;
        this.LD = 0.0f;
        this.LE = 0.0f;
        this.LK.removeMessages(1);
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
        this.LF = rVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void mw() {
    }

    public void mx() {
        this.Lg = new Paint();
        this.Lg.setAntiAlias(true);
        this.Lg.setStyle(Paint.Style.STROKE);
        this.Lg.setStrokeWidth(2.0f);
        this.Lh = new Paint();
        this.Lh.setAntiAlias(true);
        this.Lh.setStyle(Paint.Style.STROKE);
        this.Lh.setStrokeWidth(2.0f);
        this.Li = new Paint();
        this.Li.setAntiAlias(true);
        this.Li.setStyle(Paint.Style.STROKE);
        this.Li.setStrokeWidth(2.0f);
        this.Lj = new Paint();
        this.Lj.setAntiAlias(true);
        this.Lj.setStyle(Paint.Style.STROKE);
        this.Lj.setStrokeWidth(2.0f);
    }

    public void d(Canvas canvas) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            this.Lg.setColor(this.Lo);
            this.Lh.setColor(this.Lp);
            this.Li.setColor(this.Lq);
            this.Lj.setColor(this.Lr);
        } else {
            this.Lg.setColor(this.Lk);
            this.Lh.setColor(this.Ll);
            this.Li.setColor(this.Lm);
            this.Lj.setColor(this.Ln);
        }
        if (this.KY == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.La, this.Lg);
        } else if (this.KY == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.La, this.Lg);
            canvas.drawCircle(this.centerX, this.centerY, this.Lb, this.Lh);
        } else if (this.KY == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.La, this.Lg);
            canvas.drawCircle(this.centerX, this.centerY, this.Lb, this.Lh);
            canvas.drawCircle(this.centerX, this.centerY, this.Lc, this.Li);
        } else if (this.KY == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.La, this.Lg);
            canvas.drawCircle(this.centerX, this.centerY, this.Lb, this.Lh);
            canvas.drawCircle(this.centerX, this.centerY, this.Lc, this.Li);
            canvas.drawCircle(this.centerX, this.centerY, this.Ld, this.Lj);
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
        return this.KL;
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
        if (this.KM != null) {
            this.KM.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.KM = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.KL = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
    }
}
