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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes.dex */
public class s extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.j, VoiceManager.b, com.baidu.tbadk.editortools.y {
    private int EL;
    private com.baidu.tbadk.editortools.j EM;
    private final int[] EQ;
    private int ER;
    private int ES;
    private final int ET;
    private final int EU;
    private final int EV;
    private final int EW;
    private final int EX;
    private int EY;
    private int EZ;
    private int Ex;
    private long Ey;
    private VoiceButton FA;
    private ImageView FB;
    private TextView FC;
    private float FD;
    private float FE;
    private r FF;
    private com.baidu.tbadk.core.dialog.a FG;
    private long FH;
    private long FI;
    private final int[] FJ;
    private final a FK;
    private SweepGradient FL;
    private int FM;
    private int Fa;
    private int Fb;
    private int Fc;
    private int Fd;
    private int Fe;
    private int Ff;
    private Paint Fg;
    private Paint Fh;
    private Paint Fi;
    private Paint Fj;
    private int Fk;
    private int Fl;
    private int Fm;
    private int Fn;
    private int Fo;
    private int Fp;
    private int Fq;
    private int Fr;
    private final BitmapDrawable Fs;
    private final Paint Ft;
    private final Rect Fu;
    private final RectF Fv;
    private TextView Fw;
    private TextView Fx;
    private TextView Fy;
    private TextView Fz;
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
                if (s.this.FE >= 360.0f) {
                    s.this.FE = 360.0f;
                    s.this.EZ = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    s.this.FH = uptimeMillis;
                    s.this.FI = uptimeMillis + 200;
                    s.this.FE += (((float) (uptimeMillis - s.this.FH)) / 1000.0f) * s.this.FD;
                    sendEmptyMessageAtTime(1, s.this.FI);
                    s.this.EZ++;
                }
                s.this.EY = s.this.EZ % 6;
                s.this.invalidate();
            }
        }
    }

    public static s M(Context context) {
        return new s(context);
    }

    public s(Context context) {
        this(context, null);
    }

    public s(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ey = 0L;
        this.EQ = new int[4];
        this.EY = 0;
        this.EZ = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.Fa = 0;
        this.Fb = 0;
        this.Fc = 0;
        this.Fd = 0;
        this.Fe = 0;
        this.Ff = 0;
        this.Fk = -1724676609;
        this.Fl = 1546880511;
        this.Fm = 674465279;
        this.Fn = 255034879;
        this.Fo = -1725669966;
        this.Fp = 1545887154;
        this.Fq = 673471922;
        this.Fr = 254041522;
        this.Ft = new Paint(1);
        this.Fu = new Rect();
        this.Fv = new RectF();
        this.EL = 0;
        this.FJ = new int[2];
        this.FK = new a(this, null);
        this.Ex = 0;
        this.FM = 0;
        this.EQ[0] = context.getResources().getDimensionPixelSize(r.e.ds24);
        this.EQ[1] = context.getResources().getDimensionPixelSize(r.e.ds8);
        this.EQ[2] = context.getResources().getDimensionPixelSize(r.e.ds22);
        this.EQ[3] = context.getResources().getDimensionPixelSize(r.e.ds36);
        this.Fa = context.getResources().getDimensionPixelSize(r.e.ds134);
        this.Fb = this.Fa + context.getResources().getDimensionPixelSize(r.e.ds14);
        this.Fc = this.Fb + context.getResources().getDimensionPixelSize(r.e.ds16);
        this.Fd = this.Fc + context.getResources().getDimensionPixelSize(r.e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.Fe = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.Ff = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.Fe = context.getResources().getDimensionPixelSize(r.e.ds70);
            this.Ff = context.getResources().getDimensionPixelSize(r.e.ds210);
        }
        this.ER = context.getResources().getDimensionPixelSize(r.e.ds26);
        this.ES = context.getResources().getDimensionPixelSize(r.e.ds10);
        this.ET = context.getResources().getDimensionPixelSize(r.e.ds14);
        this.EU = context.getResources().getDimensionPixelSize(r.e.ds4);
        this.EV = context.getResources().getDimensionPixelSize(r.e.ds4);
        this.EW = context.getResources().getDimensionPixelSize(r.e.ds12);
        this.EX = context.getResources().getDimensionPixelSize(r.e.ds2);
        this.Ft.setStyle(Paint.Style.STROKE);
        this.Ft.setStrokeWidth(this.EW);
        this.Fs = (BitmapDrawable) getResources().getDrawable(r.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        N(context);
        lH();
        this.FJ[0] = ar.getColor(r.d.common_color_10151);
        this.FJ[1] = ar.getColor(r.d.common_color_10152);
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
        this.ER = ((i4 - getContext().getResources().getDimensionPixelSize(r.e.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(r.e.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.FA.getMeasuredWidth();
        int measuredHeight = this.FA.getMeasuredHeight();
        int measuredWidth2 = this.Fx.getMeasuredWidth();
        this.Fx.layout((i5 - measuredWidth2) >> 1, this.ER + i2, (measuredWidth2 + i5) >> 1, this.Fx.getMeasuredHeight() + this.ER + i2);
        int bottom = this.Fx.getBottom();
        this.FA.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Fz.getMeasuredWidth();
        int measuredHeight2 = this.Fz.getMeasuredHeight();
        int top = this.FA.getTop();
        this.Fz.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Fw.getMeasuredWidth();
        int measuredHeight3 = this.Fw.getMeasuredHeight();
        int right = this.FA.getRight() - this.ES;
        int bottom2 = this.FA.getBottom() - this.ET;
        this.Fw.layout(this.Fe + i6, this.Ff + bottom, measuredWidth4 + i6 + this.Fe, measuredHeight3 + this.Ff + bottom);
        int measuredWidth5 = this.FB.getMeasuredWidth();
        this.FB.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.FB.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.FC.getMeasuredWidth();
        this.FC.layout((i5 - measuredWidth6) >> 1, (this.Fw.getTop() - this.FC.getMeasuredHeight()) - this.EU, (measuredWidth6 + i5) >> 1, (this.Fw.getTop() + i2) - this.EU);
        this.FA.getLeft();
        this.FA.getRight();
        int measuredWidth7 = this.Fy.getMeasuredWidth();
        int measuredHeight4 = this.Fy.getMeasuredHeight();
        int bottom3 = this.FA.getBottom();
        this.Fy.layout((i5 - measuredWidth7) >> 1, this.EQ[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.EQ[3]);
        this.Fu.set((i5 - this.Fs.getIntrinsicWidth()) >> 1, this.FB.getTop() - this.EV, (i5 + this.Fs.getIntrinsicHeight()) >> 1, (this.FB.getTop() + this.Fs.getIntrinsicHeight()) - this.EV);
        this.Fs.setBounds(this.Fu);
        this.Fv.set(this.FB.getLeft() + (this.EW >> 1) + this.EX, this.FB.getTop() + (this.EW >> 1) + this.EX, (this.FB.getRight() - (this.EW >> 1)) - this.EX, (this.FB.getBottom() - (this.EW >> 1)) - this.EX);
        if (this.FL == null) {
            this.FL = new SweepGradient(this.Fv.centerX(), this.Fv.centerY(), this.FJ, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.FL.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Fv.centerX(), this.Fv.centerY());
            this.FL.setLocalMatrix(matrix);
            this.Ft.setShader(this.FL);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        d(canvas);
        super.dispatchDraw(canvas);
    }

    private void lB() {
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.FG == null) {
            this.FG = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.l.C(getContext()).getPageActivity());
            this.FG.cG(getContext().getString(r.j.voice_restart_tip)).a(getContext().getString(r.j.voice_restart), new t(this, recorderManager)).b(getContext().getString(r.j.cancel), new u(this)).b(com.baidu.adp.base.l.C(getContext()));
        }
        try {
            this.FG.tb();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bM(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void N(Context context) {
        LayoutInflater.from(context).inflate(r.h.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.Fx = (TextView) findViewById(r.g.tip_error);
        ar.c(this.Fx, r.d.cp_cont_i, 1);
        this.Fy = (TextView) findViewById(r.g.tip_operator);
        this.Fz = (TextView) findViewById(r.g.tip_time_out);
        this.FA = (VoiceButton) findViewById(r.g.voice_bnt);
        this.Fw = (TextView) findViewById(r.g.restart);
        this.FB = (ImageView) findViewById(r.g.play_img);
        this.FC = (TextView) findViewById(r.g.play_time);
        this.FC.setClickable(false);
        this.Fw.setOnClickListener(this);
        this.FB.setOnClickListener(this);
        this.FA.setRecorderView(this);
        lD();
    }

    private void lC() {
        this.FA.setVisibility(4);
        this.FC.setVisibility(0);
        this.Fw.setVisibility(0);
        ar.c(this.FC, r.d.cp_cont_f, 1);
        ar.c(this.Fw, r.d.cp_cont_f, 1);
        ar.k(this.Fw, r.f.but_posts_record_again_selector);
        this.FB.setVisibility(0);
        if (this.mModel != null) {
            this.FC.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.FB.setContentDescription(String.format(getContext().getString(r.j.listen_time), Integer.valueOf(this.mModel.duration)));
            ar.c(this.FB, r.f.but_posts_record_play_selector);
        }
        ar.c(this.Fy, r.d.cp_cont_c, 1);
        this.Fy.setText(getContext().getString(r.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lD() {
        ar.c(this.FA, r.f.but_posts_record_zero_selector);
        this.FA.setVisibility(0);
        this.EY = 0;
        this.FB.setVisibility(4);
        this.FC.setVisibility(4);
        this.Fw.setVisibility(4);
        this.Fz.setVisibility(4);
        ar.c(this.Fy, r.d.cp_cont_c, 1);
        this.Fy.setText(getContext().getString(r.j.voice_record_press_to_record));
    }

    public void reset() {
        lD();
        this.mModel = null;
        this.EY = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Fx.setText("");
        this.Fx.setVisibility(4);
        this.EY = 0;
        lC();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
        if (z) {
            lD();
            this.Fy.setText(getContext().getString(r.j.voice_record_release_to_stop));
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
        if (this.FB != null && this.FC != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    ar.c(this.FC, r.d.cp_cont_f, 1);
                    this.FC.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ar.c(this.FB, r.f.but_posts_record_play_selector);
                    this.FB.setContentDescription(String.format(getContext().getString(r.j.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Fy.setText(getContext().getString(r.j.voice_play_tip));
                    lF();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    ar.c(this.FC, r.d.cp_cont_f, 1);
                    ar.c(this.FB, r.f.but_posts_record_stop_selector);
                    this.FB.setContentDescription(getContext().getString(r.j.pause));
                    this.Fy.setText(getContext().getString(r.j.voice_stop_tip));
                    lE();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
        ar.c(this.Fz, r.d.cp_cont_i, 1);
        ar.c(this.Fx, r.d.cp_cont_i, 1);
        ar.c(this.Fy, r.d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Fz.setVisibility(0);
                this.Fz.setText(str);
                postDelayed(new v(this), 2000L);
            } else if (i == 2) {
                this.Fx.setVisibility(0);
                this.Fx.setText(str);
                this.Fy.setText(r.j.voice_record_press_to_record);
                postDelayed(new w(this), 2000L);
            } else if (i == 5) {
                this.Fx.setVisibility(0);
                this.Fx.setText(str);
                postDelayed(new x(this), 2000L);
            } else {
                lD();
                this.Fx.setVisibility(0);
                this.Fx.setText(str);
                postDelayed(new y(this), 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
        this.Fx.setVisibility(4);
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
        ar.c(this.Fx, r.d.cp_cont_i, 1);
        this.Fx.setVisibility(0);
        this.Fx.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.Ex = Math.max(i, this.Ex);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Ey > 200) {
            this.Ex = 0;
            this.Ey = uptimeMillis;
        }
        if (this.Ex < 10) {
            this.EY = 1;
            invalidate();
        } else if (this.Ex < 20) {
            this.EY = 2;
            invalidate();
        } else if (this.Ex < 30) {
            this.EY = 3;
            invalidate();
        } else if (this.Ex < 40) {
            this.EY = 4;
            invalidate();
        } else {
            this.EY = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aT(int i) {
        if (this.mModel != null && this.FC != null) {
            int i2 = i / 1000;
            if (this.FM != i2) {
                this.FC.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.FM = i2;
        }
    }

    private void lE() {
        if (this.mModel != null) {
            this.EY = 0;
            this.FD = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.FH = SystemClock.uptimeMillis();
            this.FI = this.FH + 200;
            this.FK.sendEmptyMessageAtTime(1, this.FI);
            invalidate();
        }
    }

    private void lF() {
        this.EY = 0;
        this.EZ = 0;
        this.FD = 0.0f;
        this.FE = 0.0f;
        this.FK.removeMessages(1);
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
        this.FF = rVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lG() {
    }

    public void lH() {
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
        this.Fj = new Paint();
        this.Fj.setAntiAlias(true);
        this.Fj.setStyle(Paint.Style.STROKE);
        this.Fj.setStrokeWidth(2.0f);
    }

    public void d(Canvas canvas) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            this.Fg.setColor(this.Fo);
            this.Fh.setColor(this.Fp);
            this.Fi.setColor(this.Fq);
            this.Fj.setColor(this.Fr);
        } else {
            this.Fg.setColor(this.Fk);
            this.Fh.setColor(this.Fl);
            this.Fi.setColor(this.Fm);
            this.Fj.setColor(this.Fn);
        }
        if (this.EY == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.Fa, this.Fg);
        } else if (this.EY == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.Fa, this.Fg);
            canvas.drawCircle(this.centerX, this.centerY, this.Fb, this.Fh);
        } else if (this.EY == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.Fa, this.Fg);
            canvas.drawCircle(this.centerX, this.centerY, this.Fb, this.Fh);
            canvas.drawCircle(this.centerX, this.centerY, this.Fc, this.Fi);
        } else if (this.EY == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.Fa, this.Fg);
            canvas.drawCircle(this.centerX, this.centerY, this.Fb, this.Fh);
            canvas.drawCircle(this.centerX, this.centerY, this.Fc, this.Fi);
            canvas.drawCircle(this.centerX, this.centerY, this.Fd, this.Fj);
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
    public void lz() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.EL;
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
        if (this.EM != null) {
            this.EM.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.EM = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.EL = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
    }
}
