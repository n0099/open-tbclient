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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes.dex */
public class s extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.j, VoiceManager.b, ab {
    private int EI;
    private com.baidu.tbadk.editortools.l EJ;
    private final int[] EN;
    private int EO;
    private int EP;
    private final int EQ;
    private final int ER;
    private final int ES;
    private final int ET;
    private final int EU;
    private int EV;
    private int EW;
    private int EX;
    private int EY;
    private int EZ;
    private int Eu;
    private long Ev;
    private float FA;
    private float FB;
    private r FC;
    private com.baidu.tbadk.core.dialog.a FD;
    private long FE;
    private long FF;
    private final int[] FG;
    private final a FH;
    private SweepGradient FI;
    private int FJ;
    private int Fa;
    private int Fb;
    private int Fc;
    private Paint Fd;
    private Paint Fe;
    private Paint Ff;
    private Paint Fg;
    private int Fh;
    private int Fi;
    private int Fj;
    private int Fk;
    private int Fl;
    private int Fm;
    private int Fn;
    private int Fo;
    private final BitmapDrawable Fp;
    private final Paint Fq;
    private final Rect Fr;
    private final RectF Fs;
    private TextView Ft;
    private TextView Fu;
    private TextView Fv;
    private TextView Fw;
    private VoiceButton Fx;
    private ImageView Fy;
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
                if (s.this.FB >= 360.0f) {
                    s.this.FB = 360.0f;
                    s.this.EW = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    s.this.FE = uptimeMillis;
                    s.this.FF = uptimeMillis + 200;
                    s.this.FB += (((float) (uptimeMillis - s.this.FE)) / 1000.0f) * s.this.FA;
                    sendEmptyMessageAtTime(1, s.this.FF);
                    s.this.EW++;
                }
                s.this.EV = s.this.EW % 6;
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
        this.Ev = 0L;
        this.EN = new int[4];
        this.EV = 0;
        this.EW = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.EX = 0;
        this.EY = 0;
        this.EZ = 0;
        this.Fa = 0;
        this.Fb = 0;
        this.Fc = 0;
        this.Fh = -1724676609;
        this.Fi = 1546880511;
        this.Fj = 674465279;
        this.Fk = 255034879;
        this.Fl = -1725669966;
        this.Fm = 1545887154;
        this.Fn = 673471922;
        this.Fo = 254041522;
        this.Fq = new Paint(1);
        this.Fr = new Rect();
        this.Fs = new RectF();
        this.EI = 0;
        this.FG = new int[2];
        this.FH = new a(this, null);
        this.Eu = 0;
        this.FJ = 0;
        this.EN[0] = context.getResources().getDimensionPixelSize(t.e.ds24);
        this.EN[1] = context.getResources().getDimensionPixelSize(t.e.ds8);
        this.EN[2] = context.getResources().getDimensionPixelSize(t.e.ds22);
        this.EN[3] = context.getResources().getDimensionPixelSize(t.e.ds36);
        this.EX = context.getResources().getDimensionPixelSize(t.e.ds134);
        this.EY = this.EX + context.getResources().getDimensionPixelSize(t.e.ds14);
        this.EZ = this.EY + context.getResources().getDimensionPixelSize(t.e.ds16);
        this.Fa = this.EZ + context.getResources().getDimensionPixelSize(t.e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.Fb = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.Fc = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.Fb = context.getResources().getDimensionPixelSize(t.e.ds70);
            this.Fc = context.getResources().getDimensionPixelSize(t.e.ds210);
        }
        this.EO = context.getResources().getDimensionPixelSize(t.e.ds26);
        this.EP = context.getResources().getDimensionPixelSize(t.e.ds10);
        this.EQ = context.getResources().getDimensionPixelSize(t.e.ds14);
        this.ER = context.getResources().getDimensionPixelSize(t.e.ds4);
        this.ES = context.getResources().getDimensionPixelSize(t.e.ds4);
        this.ET = context.getResources().getDimensionPixelSize(t.e.ds12);
        this.EU = context.getResources().getDimensionPixelSize(t.e.ds2);
        this.Fq.setStyle(Paint.Style.STROKE);
        this.Fq.setStrokeWidth(this.ET);
        this.Fp = (BitmapDrawable) getResources().getDrawable(t.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        P(context);
        lE();
        this.FG[0] = av.getColor(t.d.common_color_10151);
        this.FG[1] = av.getColor(t.d.common_color_10152);
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
        this.EO = ((i4 - getContext().getResources().getDimensionPixelSize(t.e.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(t.e.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.Fx.getMeasuredWidth();
        int measuredHeight = this.Fx.getMeasuredHeight();
        int measuredWidth2 = this.Fu.getMeasuredWidth();
        this.Fu.layout((i5 - measuredWidth2) >> 1, this.EO + i2, (measuredWidth2 + i5) >> 1, this.Fu.getMeasuredHeight() + this.EO + i2);
        int bottom = this.Fu.getBottom();
        this.Fx.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Fw.getMeasuredWidth();
        int measuredHeight2 = this.Fw.getMeasuredHeight();
        int top = this.Fx.getTop();
        this.Fw.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Ft.getMeasuredWidth();
        int measuredHeight3 = this.Ft.getMeasuredHeight();
        int right = this.Fx.getRight() - this.EP;
        int bottom2 = this.Fx.getBottom() - this.EQ;
        this.Ft.layout(this.Fb + i6, this.Fc + bottom, measuredWidth4 + i6 + this.Fb, measuredHeight3 + this.Fc + bottom);
        int measuredWidth5 = this.Fy.getMeasuredWidth();
        this.Fy.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Fy.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Fz.getMeasuredWidth();
        this.Fz.layout((i5 - measuredWidth6) >> 1, (this.Ft.getTop() - this.Fz.getMeasuredHeight()) - this.ER, (measuredWidth6 + i5) >> 1, (this.Ft.getTop() + i2) - this.ER);
        this.Fx.getLeft();
        this.Fx.getRight();
        int measuredWidth7 = this.Fv.getMeasuredWidth();
        int measuredHeight4 = this.Fv.getMeasuredHeight();
        int bottom3 = this.Fx.getBottom();
        this.Fv.layout((i5 - measuredWidth7) >> 1, this.EN[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.EN[3]);
        this.Fr.set((i5 - this.Fp.getIntrinsicWidth()) >> 1, this.Fy.getTop() - this.ES, (i5 + this.Fp.getIntrinsicHeight()) >> 1, (this.Fy.getTop() + this.Fp.getIntrinsicHeight()) - this.ES);
        this.Fp.setBounds(this.Fr);
        this.Fs.set(this.Fy.getLeft() + (this.ET >> 1) + this.EU, this.Fy.getTop() + (this.ET >> 1) + this.EU, (this.Fy.getRight() - (this.ET >> 1)) - this.EU, (this.Fy.getBottom() - (this.ET >> 1)) - this.EU);
        if (this.FI == null) {
            this.FI = new SweepGradient(this.Fs.centerX(), this.Fs.centerY(), this.FG, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.FI.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Fs.centerX(), this.Fs.centerY());
            this.FI.setLocalMatrix(matrix);
            this.Fq.setShader(this.FI);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        d(canvas);
        super.dispatchDraw(canvas);
    }

    private void ly() {
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.FD == null) {
            this.FD = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.l.C(getContext()).getPageActivity());
            this.FD.cB(getContext().getString(t.j.voice_restart_tip)).a(getContext().getString(t.j.voice_restart), new t(this, recorderManager)).b(getContext().getString(t.j.cancel), new u(this)).b(com.baidu.adp.base.l.C(getContext()));
        }
        try {
            this.FD.sX();
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
        LayoutInflater.from(context).inflate(t.h.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.Fu = (TextView) findViewById(t.g.tip_error);
        av.c(this.Fu, t.d.cp_cont_i, 1);
        this.Fv = (TextView) findViewById(t.g.tip_operator);
        this.Fw = (TextView) findViewById(t.g.tip_time_out);
        this.Fx = (VoiceButton) findViewById(t.g.voice_bnt);
        this.Ft = (TextView) findViewById(t.g.restart);
        this.Fy = (ImageView) findViewById(t.g.play_img);
        this.Fz = (TextView) findViewById(t.g.play_time);
        this.Fz.setClickable(false);
        this.Ft.setOnClickListener(this);
        this.Fy.setOnClickListener(this);
        this.Fx.setRecorderView(this);
        lA();
    }

    private void lz() {
        this.Fx.setVisibility(4);
        this.Fz.setVisibility(0);
        this.Ft.setVisibility(0);
        av.c(this.Fz, t.d.cp_cont_f, 1);
        av.c(this.Ft, t.d.cp_cont_f, 1);
        av.k(this.Ft, t.f.but_posts_record_again_selector);
        this.Fy.setVisibility(0);
        if (this.mModel != null) {
            this.Fz.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Fy.setContentDescription(String.format(getContext().getString(t.j.listen_time), Integer.valueOf(this.mModel.duration)));
            av.c(this.Fy, t.f.but_posts_record_play_selector);
        }
        av.c(this.Fv, t.d.cp_cont_c, 1);
        this.Fv.setText(getContext().getString(t.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lA() {
        av.c(this.Fx, t.f.but_posts_record_zero_selector);
        this.Fx.setVisibility(0);
        this.EV = 0;
        this.Fy.setVisibility(4);
        this.Fz.setVisibility(4);
        this.Ft.setVisibility(4);
        this.Fw.setVisibility(4);
        av.c(this.Fv, t.d.cp_cont_c, 1);
        this.Fv.setText(getContext().getString(t.j.voice_record_press_to_record));
    }

    public void reset() {
        lA();
        this.mModel = null;
        this.EV = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Fu.setText("");
        this.Fu.setVisibility(4);
        this.EV = 0;
        lz();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
        if (z) {
            lA();
            this.Fv.setText(getContext().getString(t.j.voice_record_release_to_stop));
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
        if (this.Fy != null && this.Fz != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    av.c(this.Fz, t.d.cp_cont_f, 1);
                    this.Fz.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    av.c(this.Fy, t.f.but_posts_record_play_selector);
                    this.Fy.setContentDescription(String.format(getContext().getString(t.j.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Fv.setText(getContext().getString(t.j.voice_play_tip));
                    lC();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    av.c(this.Fz, t.d.cp_cont_f, 1);
                    av.c(this.Fy, t.f.but_posts_record_stop_selector);
                    this.Fy.setContentDescription(getContext().getString(t.j.pause));
                    this.Fv.setText(getContext().getString(t.j.voice_stop_tip));
                    lB();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
        av.c(this.Fw, t.d.cp_cont_i, 1);
        av.c(this.Fu, t.d.cp_cont_i, 1);
        av.c(this.Fv, t.d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Fw.setVisibility(0);
                this.Fw.setText(str);
                postDelayed(new v(this), 2000L);
            } else if (i == 2) {
                this.Fu.setVisibility(0);
                this.Fu.setText(str);
                this.Fv.setText(t.j.voice_record_press_to_record);
                postDelayed(new w(this), 2000L);
            } else if (i == 5) {
                this.Fu.setVisibility(0);
                this.Fu.setText(str);
                postDelayed(new x(this), 2000L);
            } else {
                lA();
                this.Fu.setVisibility(0);
                this.Fu.setText(str);
                postDelayed(new y(this), 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
        this.Fu.setVisibility(4);
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
        av.c(this.Fu, t.d.cp_cont_i, 1);
        this.Fu.setVisibility(0);
        this.Fu.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.Eu = Math.max(i, this.Eu);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Ev > 200) {
            this.Eu = 0;
            this.Ev = uptimeMillis;
        }
        if (this.Eu < 10) {
            this.EV = 1;
            invalidate();
        } else if (this.Eu < 20) {
            this.EV = 2;
            invalidate();
        } else if (this.Eu < 30) {
            this.EV = 3;
            invalidate();
        } else if (this.Eu < 40) {
            this.EV = 4;
            invalidate();
        } else {
            this.EV = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (this.mModel != null && this.Fz != null) {
            int i2 = i / 1000;
            if (this.FJ != i2) {
                this.Fz.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.FJ = i2;
        }
    }

    private void lB() {
        if (this.mModel != null) {
            this.EV = 0;
            this.FA = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.FE = SystemClock.uptimeMillis();
            this.FF = this.FE + 200;
            this.FH.sendEmptyMessageAtTime(1, this.FF);
            invalidate();
        }
    }

    private void lC() {
        this.EV = 0;
        this.EW = 0;
        this.FA = 0.0f;
        this.FB = 0.0f;
        this.FH.removeMessages(1);
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
                ly();
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
        this.FC = rVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lD() {
    }

    public void lE() {
        this.Fd = new Paint();
        this.Fd.setAntiAlias(true);
        this.Fd.setStyle(Paint.Style.STROKE);
        this.Fd.setStrokeWidth(2.0f);
        this.Fe = new Paint();
        this.Fe.setAntiAlias(true);
        this.Fe.setStyle(Paint.Style.STROKE);
        this.Fe.setStrokeWidth(2.0f);
        this.Ff = new Paint();
        this.Ff.setAntiAlias(true);
        this.Ff.setStyle(Paint.Style.STROKE);
        this.Ff.setStrokeWidth(2.0f);
        this.Fg = new Paint();
        this.Fg.setAntiAlias(true);
        this.Fg.setStyle(Paint.Style.STROKE);
        this.Fg.setStrokeWidth(2.0f);
    }

    public void d(Canvas canvas) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            this.Fd.setColor(this.Fl);
            this.Fe.setColor(this.Fm);
            this.Ff.setColor(this.Fn);
            this.Fg.setColor(this.Fo);
        } else {
            this.Fd.setColor(this.Fh);
            this.Fe.setColor(this.Fi);
            this.Ff.setColor(this.Fj);
            this.Fg.setColor(this.Fk);
        }
        if (this.EV == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.EX, this.Fd);
        } else if (this.EV == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.EX, this.Fd);
            canvas.drawCircle(this.centerX, this.centerY, this.EY, this.Fe);
        } else if (this.EV == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.EX, this.Fd);
            canvas.drawCircle(this.centerX, this.centerY, this.EY, this.Fe);
            canvas.drawCircle(this.centerX, this.centerY, this.EZ, this.Ff);
        } else if (this.EV == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.EX, this.Fd);
            canvas.drawCircle(this.centerX, this.centerY, this.EY, this.Fe);
            canvas.drawCircle(this.centerX, this.centerY, this.EZ, this.Ff);
            canvas.drawCircle(this.centerX, this.centerY, this.Fa, this.Fg);
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
    public void lw() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.EI;
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
        if (this.EJ != null) {
            this.EJ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.EJ = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.EI = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
    }
}
