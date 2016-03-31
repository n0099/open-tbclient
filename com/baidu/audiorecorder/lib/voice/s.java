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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes.dex */
public class s extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.j, VoiceManager.b, ab {
    private int LD;
    private com.baidu.tbadk.editortools.l LE;
    private final int[] LI;
    private int LJ;
    private int LK;
    private final int LL;
    private final int LM;
    private final int LN;
    private final int LO;
    private final int LP;
    private int LQ;
    private int LR;
    private int LS;
    private int LT;
    private int LU;
    private int LV;
    private int LW;
    private int LX;
    private Paint LY;
    private Paint LZ;
    private int Lp;
    private long Lq;
    private long MA;
    private final int[] MB;
    private final a MC;
    private SweepGradient MD;
    private int ME;
    private Paint Ma;
    private Paint Mb;
    private int Mc;
    private int Md;
    private int Me;
    private int Mf;
    private int Mg;
    private int Mh;
    private int Mi;
    private int Mj;
    private final BitmapDrawable Mk;
    private final Paint Ml;
    private final Rect Mm;
    private final RectF Mn;
    private TextView Mo;
    private TextView Mp;
    private TextView Mq;
    private TextView Mr;
    private VoiceButton Ms;
    private ImageView Mt;
    private TextView Mu;
    private float Mv;
    private float Mw;
    private r Mx;
    private com.baidu.tbadk.core.dialog.a My;
    private long Mz;
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
                if (s.this.Mw >= 360.0f) {
                    s.this.Mw = 360.0f;
                    s.this.LR = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    s.this.Mz = uptimeMillis;
                    s.this.MA = uptimeMillis + 200;
                    s.this.Mw += (((float) (uptimeMillis - s.this.Mz)) / 1000.0f) * s.this.Mv;
                    sendEmptyMessageAtTime(1, s.this.MA);
                    s.this.LR++;
                }
                s.this.LQ = s.this.LR % 6;
                s.this.invalidate();
            }
        }
    }

    public static s F(Context context) {
        return new s(context);
    }

    public s(Context context) {
        this(context, null);
    }

    public s(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Lq = 0L;
        this.LI = new int[4];
        this.LQ = 0;
        this.LR = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.LS = 0;
        this.LT = 0;
        this.LU = 0;
        this.LV = 0;
        this.LW = 0;
        this.LX = 0;
        this.Mc = -1724676609;
        this.Md = 1546880511;
        this.Me = 674465279;
        this.Mf = 255034879;
        this.Mg = -1725669966;
        this.Mh = 1545887154;
        this.Mi = 673471922;
        this.Mj = 254041522;
        this.Ml = new Paint(1);
        this.Mm = new Rect();
        this.Mn = new RectF();
        this.LD = 0;
        this.MB = new int[2];
        this.MC = new a(this, null);
        this.Lp = 0;
        this.ME = 0;
        this.LI[0] = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_marginleft);
        this.LI[1] = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_margintop);
        this.LI[2] = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_marginright);
        this.LI[3] = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_marginbottom);
        this.LS = context.getResources().getDimensionPixelSize(t.e.ds134);
        this.LT = this.LS + context.getResources().getDimensionPixelSize(t.e.ds14);
        this.LU = this.LT + context.getResources().getDimensionPixelSize(t.e.ds16);
        this.LV = this.LU + context.getResources().getDimensionPixelSize(t.e.ds18);
        this.LW = context.getResources().getDimensionPixelSize(t.e.ds70);
        this.LX = context.getResources().getDimensionPixelSize(t.e.ds210);
        this.LJ = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_paddingtop);
        this.LK = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_restart_button_paddingleft);
        this.LL = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_restart_button_paddingbottom);
        this.LM = context.getResources().getDimensionPixelSize(t.e.ds4);
        this.LN = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_dot_glow_padding);
        this.LO = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_paint_stroke_width);
        this.LP = context.getResources().getDimensionPixelSize(t.e.record_voice_btn_progress_padding);
        this.Ml.setStyle(Paint.Style.STROKE);
        this.Ml.setStrokeWidth(this.LO);
        this.Mk = (BitmapDrawable) getResources().getDrawable(t.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        G(context);
        ox();
        this.MB[0] = at.getColor(t.d.record_voice_progress_start);
        this.MB[1] = at.getColor(t.d.record_voice_progress_end);
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
        this.LJ = ((i4 - getContext().getResources().getDimensionPixelSize(t.e.pb_editor_faceview_height)) / 2) + getContext().getResources().getDimensionPixelSize(t.e.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.Ms.getMeasuredWidth();
        int measuredHeight = this.Ms.getMeasuredHeight();
        int measuredWidth2 = this.Mp.getMeasuredWidth();
        this.Mp.layout((i5 - measuredWidth2) >> 1, this.LJ + i2, (measuredWidth2 + i5) >> 1, this.Mp.getMeasuredHeight() + this.LJ + i2);
        int bottom = this.Mp.getBottom();
        this.Ms.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Mr.getMeasuredWidth();
        int measuredHeight2 = this.Mr.getMeasuredHeight();
        int top = this.Ms.getTop();
        this.Mr.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Mo.getMeasuredWidth();
        int measuredHeight3 = this.Mo.getMeasuredHeight();
        int right = this.Ms.getRight() - this.LK;
        int bottom2 = this.Ms.getBottom() - this.LL;
        this.Mo.layout(this.LW + i6, this.LX + bottom, measuredWidth4 + i6 + this.LW, measuredHeight3 + this.LX + bottom);
        int measuredWidth5 = this.Mt.getMeasuredWidth();
        this.Mt.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Mt.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Mu.getMeasuredWidth();
        this.Mu.layout((i5 - measuredWidth6) >> 1, (this.Mo.getTop() - this.Mu.getMeasuredHeight()) - this.LM, (measuredWidth6 + i5) >> 1, (this.Mo.getTop() + i2) - this.LM);
        this.Ms.getLeft();
        this.Ms.getRight();
        int measuredWidth7 = this.Mq.getMeasuredWidth();
        int measuredHeight4 = this.Mq.getMeasuredHeight();
        int bottom3 = this.Ms.getBottom();
        this.Mq.layout((i5 - measuredWidth7) >> 1, this.LI[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.LI[3]);
        this.Mm.set((i5 - this.Mk.getIntrinsicWidth()) >> 1, this.Mt.getTop() - this.LN, (i5 + this.Mk.getIntrinsicHeight()) >> 1, (this.Mt.getTop() + this.Mk.getIntrinsicHeight()) - this.LN);
        this.Mk.setBounds(this.Mm);
        this.Mn.set(this.Mt.getLeft() + (this.LO >> 1) + this.LP, this.Mt.getTop() + (this.LO >> 1) + this.LP, (this.Mt.getRight() - (this.LO >> 1)) - this.LP, (this.Mt.getBottom() - (this.LO >> 1)) - this.LP);
        if (this.MD == null) {
            this.MD = new SweepGradient(this.Mn.centerX(), this.Mn.centerY(), this.MB, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.MD.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Mn.centerX(), this.Mn.centerY());
            this.MD.setLocalMatrix(matrix);
            this.Ml.setShader(this.MD);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        d(canvas);
        super.dispatchDraw(canvas);
    }

    private void or() {
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.My == null) {
            this.My = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.l.s(getContext()).getPageActivity());
            this.My.cC(getContext().getString(t.j.voice_restart_tip)).a(getContext().getString(t.j.voice_restart), new t(this, recorderManager)).b(getContext().getString(t.j.cancel), new u(this)).b(com.baidu.adp.base.l.s(getContext()));
        }
        try {
            this.My.up();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bR(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void G(Context context) {
        LayoutInflater.from(context).inflate(t.h.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.Mp = (TextView) findViewById(t.g.tip_error);
        at.b(this.Mp, t.d.cp_cont_i, 1);
        this.Mq = (TextView) findViewById(t.g.tip_operator);
        this.Mr = (TextView) findViewById(t.g.tip_time_out);
        this.Ms = (VoiceButton) findViewById(t.g.voice_bnt);
        this.Mo = (TextView) findViewById(t.g.restart);
        this.Mt = (ImageView) findViewById(t.g.play_img);
        this.Mu = (TextView) findViewById(t.g.play_time);
        this.Mu.setClickable(false);
        this.Mo.setOnClickListener(this);
        this.Mt.setOnClickListener(this);
        this.Ms.setRecorderView(this);
        ot();
    }

    private void os() {
        this.Ms.setVisibility(4);
        this.Mu.setVisibility(0);
        this.Mo.setVisibility(0);
        at.b(this.Mu, t.d.cp_cont_f, 1);
        at.b(this.Mo, t.d.cp_cont_f, 1);
        at.k(this.Mo, t.f.but_posts_record_again_selector);
        this.Mt.setVisibility(0);
        if (this.mModel != null) {
            this.Mu.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            at.c(this.Mt, t.f.but_posts_record_play_selector);
        }
        at.b(this.Mq, t.d.cp_cont_c, 1);
        this.Mq.setText(getContext().getString(t.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ot() {
        at.c(this.Ms, t.f.but_posts_record_zero_selector);
        this.Ms.setVisibility(0);
        this.LQ = 0;
        this.Mt.setVisibility(4);
        this.Mu.setVisibility(4);
        this.Mo.setVisibility(4);
        this.Mr.setVisibility(4);
        at.b(this.Mq, t.d.cp_cont_c, 1);
        this.Mq.setText(getContext().getString(t.j.voice_record_press_to_record));
    }

    public void reset() {
        ot();
        this.mModel = null;
        this.LQ = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Mp.setText("");
        this.Mp.setVisibility(4);
        this.LQ = 0;
        os();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
        if (z) {
            ot();
            this.Mq.setText(getContext().getString(t.j.voice_record_release_to_stop));
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
        if (this.Mt != null && this.Mu != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    at.b(this.Mu, t.d.cp_cont_f, 1);
                    this.Mu.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    at.c(this.Mt, t.f.but_posts_record_play_selector);
                    this.Mq.setText(getContext().getString(t.j.voice_play_tip));
                    ov();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    at.b(this.Mu, t.d.cp_cont_f, 1);
                    at.c(this.Mt, t.f.but_posts_record_stop_selector);
                    this.Mq.setText(getContext().getString(t.j.voice_stop_tip));
                    ou();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
        at.b(this.Mr, t.d.cp_cont_i, 1);
        at.b(this.Mp, t.d.cp_cont_i, 1);
        at.b(this.Mq, t.d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Mr.setVisibility(0);
                this.Mr.setText(str);
                postDelayed(new v(this), 2000L);
            } else if (i == 2) {
                this.Mp.setVisibility(0);
                this.Mp.setText(str);
                this.Mq.setText(t.j.voice_record_press_to_record);
                postDelayed(new w(this), 2000L);
            } else if (i == 5) {
                this.Mp.setVisibility(0);
                this.Mp.setText(str);
                postDelayed(new x(this), 2000L);
            } else {
                ot();
                this.Mp.setVisibility(0);
                this.Mp.setText(str);
                postDelayed(new y(this), 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
        this.Mp.setVisibility(4);
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
        at.b(this.Mp, t.d.cp_cont_i, 1);
        this.Mp.setVisibility(0);
        this.Mp.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.Lp = Math.max(i, this.Lp);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Lq > 200) {
            this.Lp = 0;
            this.Lq = uptimeMillis;
        }
        if (this.Lp < 10) {
            this.LQ = 1;
            invalidate();
        } else if (this.Lp < 20) {
            this.LQ = 2;
            invalidate();
        } else if (this.Lp < 30) {
            this.LQ = 3;
            invalidate();
        } else if (this.Lp < 40) {
            this.LQ = 4;
            invalidate();
        } else {
            this.LQ = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aO(int i) {
        if (this.mModel != null && this.Mu != null) {
            int i2 = i / 1000;
            if (this.ME != i2) {
                this.Mu.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.ME = i2;
        }
    }

    private void ou() {
        if (this.mModel != null) {
            this.LQ = 0;
            this.Mv = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Mz = SystemClock.uptimeMillis();
            this.MA = this.Mz + 200;
            this.MC.sendEmptyMessageAtTime(1, this.MA);
            invalidate();
        }
    }

    private void ov() {
        this.LQ = 0;
        this.LR = 0;
        this.Mv = 0.0f;
        this.Mw = 0.0f;
        this.MC.removeMessages(1);
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
                or();
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
        this.Mx = rVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void ow() {
    }

    public void ox() {
        this.LY = new Paint();
        this.LY.setAntiAlias(true);
        this.LY.setStyle(Paint.Style.STROKE);
        this.LY.setStrokeWidth(2.0f);
        this.LZ = new Paint();
        this.LZ.setAntiAlias(true);
        this.LZ.setStyle(Paint.Style.STROKE);
        this.LZ.setStrokeWidth(2.0f);
        this.Ma = new Paint();
        this.Ma.setAntiAlias(true);
        this.Ma.setStyle(Paint.Style.STROKE);
        this.Ma.setStrokeWidth(2.0f);
        this.Mb = new Paint();
        this.Mb.setAntiAlias(true);
        this.Mb.setStyle(Paint.Style.STROKE);
        this.Mb.setStrokeWidth(2.0f);
    }

    public void d(Canvas canvas) {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.LY.setColor(this.Mg);
            this.LZ.setColor(this.Mh);
            this.Ma.setColor(this.Mi);
            this.Mb.setColor(this.Mj);
        } else {
            this.LY.setColor(this.Mc);
            this.LZ.setColor(this.Md);
            this.Ma.setColor(this.Me);
            this.Mb.setColor(this.Mf);
        }
        if (this.LQ == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.LS, this.LY);
        } else if (this.LQ == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.LS, this.LY);
            canvas.drawCircle(this.centerX, this.centerY, this.LT, this.LZ);
        } else if (this.LQ == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.LS, this.LY);
            canvas.drawCircle(this.centerX, this.centerY, this.LT, this.LZ);
            canvas.drawCircle(this.centerX, this.centerY, this.LU, this.Ma);
        } else if (this.LQ == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.LS, this.LY);
            canvas.drawCircle(this.centerX, this.centerY, this.LT, this.LZ);
            canvas.drawCircle(this.centerX, this.centerY, this.LU, this.Ma);
            canvas.drawCircle(this.centerX, this.centerY, this.LV, this.Mb);
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
    public void op() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.LD;
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
        if (this.LE != null) {
            this.LE.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.LE = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.LD = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
    }
}
