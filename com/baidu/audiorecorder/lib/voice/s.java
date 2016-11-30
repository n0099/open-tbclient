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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes.dex */
public class s extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.j, VoiceManager.b, ab {
    private int EK;
    private com.baidu.tbadk.editortools.l EL;
    private final int[] EP;
    private int EQ;
    private int ER;
    private final int ES;
    private final int ET;
    private final int EU;
    private final int EV;
    private final int EW;
    private int EX;
    private int EY;
    private int EZ;
    private int Ew;
    private long Ex;
    private ImageView FA;
    private TextView FB;
    private float FC;
    private float FD;
    private r FE;
    private com.baidu.tbadk.core.dialog.a FF;
    private long FG;
    private long FH;
    private final int[] FI;
    private final a FJ;
    private SweepGradient FK;
    private int FL;
    private int Fa;
    private int Fb;
    private int Fc;
    private int Fd;
    private int Fe;
    private Paint Ff;
    private Paint Fg;
    private Paint Fh;
    private Paint Fi;
    private int Fj;
    private int Fk;
    private int Fl;
    private int Fm;
    private int Fn;
    private int Fo;
    private int Fp;
    private int Fq;
    private final BitmapDrawable Fr;
    private final Paint Fs;
    private final Rect Ft;
    private final RectF Fu;
    private TextView Fv;
    private TextView Fw;
    private TextView Fx;
    private TextView Fy;
    private VoiceButton Fz;
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
                if (s.this.FD >= 360.0f) {
                    s.this.FD = 360.0f;
                    s.this.EY = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    s.this.FG = uptimeMillis;
                    s.this.FH = uptimeMillis + 200;
                    s.this.FD += (((float) (uptimeMillis - s.this.FG)) / 1000.0f) * s.this.FC;
                    sendEmptyMessageAtTime(1, s.this.FH);
                    s.this.EY++;
                }
                s.this.EX = s.this.EY % 6;
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
        this.Ex = 0L;
        this.EP = new int[4];
        this.EX = 0;
        this.EY = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.EZ = 0;
        this.Fa = 0;
        this.Fb = 0;
        this.Fc = 0;
        this.Fd = 0;
        this.Fe = 0;
        this.Fj = -1724676609;
        this.Fk = 1546880511;
        this.Fl = 674465279;
        this.Fm = 255034879;
        this.Fn = -1725669966;
        this.Fo = 1545887154;
        this.Fp = 673471922;
        this.Fq = 254041522;
        this.Fs = new Paint(1);
        this.Ft = new Rect();
        this.Fu = new RectF();
        this.EK = 0;
        this.FI = new int[2];
        this.FJ = new a(this, null);
        this.Ew = 0;
        this.FL = 0;
        this.EP[0] = context.getResources().getDimensionPixelSize(r.e.ds24);
        this.EP[1] = context.getResources().getDimensionPixelSize(r.e.ds8);
        this.EP[2] = context.getResources().getDimensionPixelSize(r.e.ds22);
        this.EP[3] = context.getResources().getDimensionPixelSize(r.e.ds36);
        this.EZ = context.getResources().getDimensionPixelSize(r.e.ds134);
        this.Fa = this.EZ + context.getResources().getDimensionPixelSize(r.e.ds14);
        this.Fb = this.Fa + context.getResources().getDimensionPixelSize(r.e.ds16);
        this.Fc = this.Fb + context.getResources().getDimensionPixelSize(r.e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.Fd = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.Fe = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.Fd = context.getResources().getDimensionPixelSize(r.e.ds70);
            this.Fe = context.getResources().getDimensionPixelSize(r.e.ds210);
        }
        this.EQ = context.getResources().getDimensionPixelSize(r.e.ds26);
        this.ER = context.getResources().getDimensionPixelSize(r.e.ds10);
        this.ES = context.getResources().getDimensionPixelSize(r.e.ds14);
        this.ET = context.getResources().getDimensionPixelSize(r.e.ds4);
        this.EU = context.getResources().getDimensionPixelSize(r.e.ds4);
        this.EV = context.getResources().getDimensionPixelSize(r.e.ds12);
        this.EW = context.getResources().getDimensionPixelSize(r.e.ds2);
        this.Fs.setStyle(Paint.Style.STROKE);
        this.Fs.setStrokeWidth(this.EV);
        this.Fr = (BitmapDrawable) getResources().getDrawable(r.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        P(context);
        lH();
        this.FI[0] = at.getColor(r.d.common_color_10151);
        this.FI[1] = at.getColor(r.d.common_color_10152);
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
        this.EQ = ((i4 - getContext().getResources().getDimensionPixelSize(r.e.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(r.e.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.Fz.getMeasuredWidth();
        int measuredHeight = this.Fz.getMeasuredHeight();
        int measuredWidth2 = this.Fw.getMeasuredWidth();
        this.Fw.layout((i5 - measuredWidth2) >> 1, this.EQ + i2, (measuredWidth2 + i5) >> 1, this.Fw.getMeasuredHeight() + this.EQ + i2);
        int bottom = this.Fw.getBottom();
        this.Fz.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Fy.getMeasuredWidth();
        int measuredHeight2 = this.Fy.getMeasuredHeight();
        int top = this.Fz.getTop();
        this.Fy.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Fv.getMeasuredWidth();
        int measuredHeight3 = this.Fv.getMeasuredHeight();
        int right = this.Fz.getRight() - this.ER;
        int bottom2 = this.Fz.getBottom() - this.ES;
        this.Fv.layout(this.Fd + i6, this.Fe + bottom, measuredWidth4 + i6 + this.Fd, measuredHeight3 + this.Fe + bottom);
        int measuredWidth5 = this.FA.getMeasuredWidth();
        this.FA.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.FA.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.FB.getMeasuredWidth();
        this.FB.layout((i5 - measuredWidth6) >> 1, (this.Fv.getTop() - this.FB.getMeasuredHeight()) - this.ET, (measuredWidth6 + i5) >> 1, (this.Fv.getTop() + i2) - this.ET);
        this.Fz.getLeft();
        this.Fz.getRight();
        int measuredWidth7 = this.Fx.getMeasuredWidth();
        int measuredHeight4 = this.Fx.getMeasuredHeight();
        int bottom3 = this.Fz.getBottom();
        this.Fx.layout((i5 - measuredWidth7) >> 1, this.EP[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.EP[3]);
        this.Ft.set((i5 - this.Fr.getIntrinsicWidth()) >> 1, this.FA.getTop() - this.EU, (i5 + this.Fr.getIntrinsicHeight()) >> 1, (this.FA.getTop() + this.Fr.getIntrinsicHeight()) - this.EU);
        this.Fr.setBounds(this.Ft);
        this.Fu.set(this.FA.getLeft() + (this.EV >> 1) + this.EW, this.FA.getTop() + (this.EV >> 1) + this.EW, (this.FA.getRight() - (this.EV >> 1)) - this.EW, (this.FA.getBottom() - (this.EV >> 1)) - this.EW);
        if (this.FK == null) {
            this.FK = new SweepGradient(this.Fu.centerX(), this.Fu.centerY(), this.FI, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.FK.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Fu.centerX(), this.Fu.centerY());
            this.FK.setLocalMatrix(matrix);
            this.Fs.setShader(this.FK);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        d(canvas);
        super.dispatchDraw(canvas);
    }

    private void lB() {
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.FF == null) {
            this.FF = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.l.C(getContext()).getPageActivity());
            this.FF.cF(getContext().getString(r.j.voice_restart_tip)).a(getContext().getString(r.j.voice_restart), new t(this, recorderManager)).b(getContext().getString(r.j.cancel), new u(this)).b(com.baidu.adp.base.l.C(getContext()));
        }
        try {
            this.FF.tq();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bM(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void P(Context context) {
        LayoutInflater.from(context).inflate(r.h.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.Fw = (TextView) findViewById(r.g.tip_error);
        at.c(this.Fw, r.d.cp_cont_i, 1);
        this.Fx = (TextView) findViewById(r.g.tip_operator);
        this.Fy = (TextView) findViewById(r.g.tip_time_out);
        this.Fz = (VoiceButton) findViewById(r.g.voice_bnt);
        this.Fv = (TextView) findViewById(r.g.restart);
        this.FA = (ImageView) findViewById(r.g.play_img);
        this.FB = (TextView) findViewById(r.g.play_time);
        this.FB.setClickable(false);
        this.Fv.setOnClickListener(this);
        this.FA.setOnClickListener(this);
        this.Fz.setRecorderView(this);
        lD();
    }

    private void lC() {
        this.Fz.setVisibility(4);
        this.FB.setVisibility(0);
        this.Fv.setVisibility(0);
        at.c(this.FB, r.d.cp_cont_f, 1);
        at.c(this.Fv, r.d.cp_cont_f, 1);
        at.k(this.Fv, r.f.but_posts_record_again_selector);
        this.FA.setVisibility(0);
        if (this.mModel != null) {
            this.FB.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.FA.setContentDescription(String.format(getContext().getString(r.j.listen_time), Integer.valueOf(this.mModel.duration)));
            at.c(this.FA, r.f.but_posts_record_play_selector);
        }
        at.c(this.Fx, r.d.cp_cont_c, 1);
        this.Fx.setText(getContext().getString(r.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lD() {
        at.c(this.Fz, r.f.but_posts_record_zero_selector);
        this.Fz.setVisibility(0);
        this.EX = 0;
        this.FA.setVisibility(4);
        this.FB.setVisibility(4);
        this.Fv.setVisibility(4);
        this.Fy.setVisibility(4);
        at.c(this.Fx, r.d.cp_cont_c, 1);
        this.Fx.setText(getContext().getString(r.j.voice_record_press_to_record));
    }

    public void reset() {
        lD();
        this.mModel = null;
        this.EX = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Fw.setText("");
        this.Fw.setVisibility(4);
        this.EX = 0;
        lC();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
        if (z) {
            lD();
            this.Fx.setText(getContext().getString(r.j.voice_record_release_to_stop));
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
        if (this.FA != null && this.FB != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    at.c(this.FB, r.d.cp_cont_f, 1);
                    this.FB.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    at.c(this.FA, r.f.but_posts_record_play_selector);
                    this.FA.setContentDescription(String.format(getContext().getString(r.j.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Fx.setText(getContext().getString(r.j.voice_play_tip));
                    lF();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    at.c(this.FB, r.d.cp_cont_f, 1);
                    at.c(this.FA, r.f.but_posts_record_stop_selector);
                    this.FA.setContentDescription(getContext().getString(r.j.pause));
                    this.Fx.setText(getContext().getString(r.j.voice_stop_tip));
                    lE();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
        at.c(this.Fy, r.d.cp_cont_i, 1);
        at.c(this.Fw, r.d.cp_cont_i, 1);
        at.c(this.Fx, r.d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Fy.setVisibility(0);
                this.Fy.setText(str);
                postDelayed(new v(this), 2000L);
            } else if (i == 2) {
                this.Fw.setVisibility(0);
                this.Fw.setText(str);
                this.Fx.setText(r.j.voice_record_press_to_record);
                postDelayed(new w(this), 2000L);
            } else if (i == 5) {
                this.Fw.setVisibility(0);
                this.Fw.setText(str);
                postDelayed(new x(this), 2000L);
            } else {
                lD();
                this.Fw.setVisibility(0);
                this.Fw.setText(str);
                postDelayed(new y(this), 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
        this.Fw.setVisibility(4);
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
        at.c(this.Fw, r.d.cp_cont_i, 1);
        this.Fw.setVisibility(0);
        this.Fw.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.Ew = Math.max(i, this.Ew);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Ex > 200) {
            this.Ew = 0;
            this.Ex = uptimeMillis;
        }
        if (this.Ew < 10) {
            this.EX = 1;
            invalidate();
        } else if (this.Ew < 20) {
            this.EX = 2;
            invalidate();
        } else if (this.Ew < 30) {
            this.EX = 3;
            invalidate();
        } else if (this.Ew < 40) {
            this.EX = 4;
            invalidate();
        } else {
            this.EX = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (this.mModel != null && this.FB != null) {
            int i2 = i / 1000;
            if (this.FL != i2) {
                this.FB.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.FL = i2;
        }
    }

    private void lE() {
        if (this.mModel != null) {
            this.EX = 0;
            this.FC = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.FG = SystemClock.uptimeMillis();
            this.FH = this.FG + 200;
            this.FJ.sendEmptyMessageAtTime(1, this.FH);
            invalidate();
        }
    }

    private void lF() {
        this.EX = 0;
        this.EY = 0;
        this.FC = 0.0f;
        this.FD = 0.0f;
        this.FJ.removeMessages(1);
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
            if (id == r.g.restart) {
                voiceManager.stopPlay();
                lB();
            } else if (id == r.g.play_img && this.mModel != null) {
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
        this.FE = rVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lG() {
    }

    public void lH() {
        this.Ff = new Paint();
        this.Ff.setAntiAlias(true);
        this.Ff.setStyle(Paint.Style.STROKE);
        this.Ff.setStrokeWidth(2.0f);
        this.Fg = new Paint();
        this.Fg.setAntiAlias(true);
        this.Fg.setStyle(Paint.Style.STROKE);
        this.Fg.setStrokeWidth(2.0f);
        this.Fh = new Paint();
        this.Fh.setAntiAlias(true);
        this.Fh.setStyle(Paint.Style.STROKE);
        this.Fh.setStrokeWidth(2.0f);
        this.Fi = new Paint();
        this.Fi.setAntiAlias(true);
        this.Fi.setStyle(Paint.Style.STROKE);
        this.Fi.setStrokeWidth(2.0f);
    }

    public void d(Canvas canvas) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            this.Ff.setColor(this.Fn);
            this.Fg.setColor(this.Fo);
            this.Fh.setColor(this.Fp);
            this.Fi.setColor(this.Fq);
        } else {
            this.Ff.setColor(this.Fj);
            this.Fg.setColor(this.Fk);
            this.Fh.setColor(this.Fl);
            this.Fi.setColor(this.Fm);
        }
        if (this.EX == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.EZ, this.Ff);
        } else if (this.EX == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.EZ, this.Ff);
            canvas.drawCircle(this.centerX, this.centerY, this.Fa, this.Fg);
        } else if (this.EX == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.EZ, this.Ff);
            canvas.drawCircle(this.centerX, this.centerY, this.Fa, this.Fg);
            canvas.drawCircle(this.centerX, this.centerY, this.Fb, this.Fh);
        } else if (this.EX == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.EZ, this.Ff);
            canvas.drawCircle(this.centerX, this.centerY, this.Fa, this.Fg);
            canvas.drawCircle(this.centerX, this.centerY, this.Fb, this.Fh);
            canvas.drawCircle(this.centerX, this.centerY, this.Fc, this.Fi);
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
    public void lz() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.EK;
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
        if (this.EL != null) {
            this.EL.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.EL = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.EK = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
    }
}
