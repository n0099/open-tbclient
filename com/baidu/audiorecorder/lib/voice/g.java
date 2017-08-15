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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes2.dex */
public class g extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, s {
    private final int LA;
    private final int LB;
    private final int LC;
    private final int LD;
    private final int LE;
    private int LF;
    private int LG;
    private int LH;
    private int LI;
    private int LJ;
    private int LK;
    private int LL;
    private int LM;
    private Paint LN;
    private Paint LO;
    private Paint LP;
    private Paint LQ;
    private int LR;
    private int LS;
    private int LT;
    private int LU;
    private int LV;
    private int LW;
    private int LX;
    private int LY;
    private final BitmapDrawable LZ;
    private int Le;
    private long Lf;
    private int Ls;
    private i Lt;
    private final int[] Lx;
    private int Ly;
    private int Lz;
    private final Paint Ma;
    private final Rect Mb;
    private final RectF Mc;
    private TextView Md;
    private TextView Me;
    private TextView Mf;
    private TextView Mg;
    private VoiceButton Mh;
    private ImageView Mi;
    private TextView Mj;
    private float Mk;
    private float Ml;
    private f Mm;
    private com.baidu.tbadk.core.dialog.a Mn;
    private long Mo;
    private long Mp;
    private final int[] Mq;
    private final a Mr;
    private SweepGradient Ms;
    private int Mt;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;

    static /* synthetic */ int e(g gVar) {
        int i = gVar.LG;
        gVar.LG = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (g.this.Ml >= 360.0f) {
                    g.this.Ml = 360.0f;
                    g.this.LG = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    g.this.Mo = uptimeMillis;
                    g.this.Mp = uptimeMillis + 200;
                    g.this.Ml += (((float) (uptimeMillis - g.this.Mo)) / 1000.0f) * g.this.Mk;
                    sendEmptyMessageAtTime(1, g.this.Mp);
                    g.e(g.this);
                }
                g.this.LF = g.this.LG % 6;
                g.this.invalidate();
            }
        }
    }

    public static g ak(Context context) {
        return new g(context);
    }

    public g(Context context) {
        this(context, null);
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Lf = 0L;
        this.Lx = new int[4];
        this.LF = 0;
        this.LG = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.LH = 0;
        this.LI = 0;
        this.LJ = 0;
        this.LK = 0;
        this.LL = 0;
        this.LM = 0;
        this.LR = -1724676609;
        this.LS = 1546880511;
        this.LT = 674465279;
        this.LU = 255034879;
        this.LV = -1725669966;
        this.LW = 1545887154;
        this.LX = 673471922;
        this.LY = 254041522;
        this.Ma = new Paint(1);
        this.Mb = new Rect();
        this.Mc = new RectF();
        this.Ls = 0;
        this.Mq = new int[2];
        this.Mr = new a();
        this.Le = 0;
        this.Mt = 0;
        this.Lx[0] = context.getResources().getDimensionPixelSize(d.f.ds24);
        this.Lx[1] = context.getResources().getDimensionPixelSize(d.f.ds8);
        this.Lx[2] = context.getResources().getDimensionPixelSize(d.f.ds22);
        this.Lx[3] = context.getResources().getDimensionPixelSize(d.f.ds36);
        this.LH = context.getResources().getDimensionPixelSize(d.f.ds134);
        this.LI = this.LH + context.getResources().getDimensionPixelSize(d.f.ds14);
        this.LJ = this.LI + context.getResources().getDimensionPixelSize(d.f.ds16);
        this.LK = this.LJ + context.getResources().getDimensionPixelSize(d.f.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.LL = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.LM = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.LL = context.getResources().getDimensionPixelSize(d.f.ds70);
            this.LM = context.getResources().getDimensionPixelSize(d.f.ds210);
        }
        this.Ly = context.getResources().getDimensionPixelSize(d.f.ds26);
        this.Lz = context.getResources().getDimensionPixelSize(d.f.ds10);
        this.LA = context.getResources().getDimensionPixelSize(d.f.ds14);
        this.LB = context.getResources().getDimensionPixelSize(d.f.ds4);
        this.LC = context.getResources().getDimensionPixelSize(d.f.ds4);
        this.LD = context.getResources().getDimensionPixelSize(d.f.ds12);
        this.LE = context.getResources().getDimensionPixelSize(d.f.ds2);
        this.Ma.setStyle(Paint.Style.STROKE);
        this.Ma.setStrokeWidth(this.LD);
        this.LZ = (BitmapDrawable) getResources().getDrawable(d.g.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        al(context);
        mb();
        this.Mq[0] = ai.getColor(d.e.common_color_10151);
        this.Mq[1] = ai.getColor(d.e.common_color_10152);
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
        this.Ly = ((i4 - getContext().getResources().getDimensionPixelSize(d.f.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(d.f.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.Mh.getMeasuredWidth();
        int measuredHeight = this.Mh.getMeasuredHeight();
        int measuredWidth2 = this.Me.getMeasuredWidth();
        this.Me.layout((i5 - measuredWidth2) >> 1, this.Ly + i2, (measuredWidth2 + i5) >> 1, this.Me.getMeasuredHeight() + this.Ly + i2);
        int bottom = this.Me.getBottom();
        this.Mh.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Mg.getMeasuredWidth();
        int measuredHeight2 = this.Mg.getMeasuredHeight();
        int top = this.Mh.getTop();
        this.Mg.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Md.getMeasuredWidth();
        int measuredHeight3 = this.Md.getMeasuredHeight();
        int right = this.Mh.getRight() - this.Lz;
        int bottom2 = this.Mh.getBottom() - this.LA;
        this.Md.layout(this.LL + i6, this.LM + bottom, measuredWidth4 + i6 + this.LL, measuredHeight3 + this.LM + bottom);
        int measuredWidth5 = this.Mi.getMeasuredWidth();
        this.Mi.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Mi.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Mj.getMeasuredWidth();
        this.Mj.layout((i5 - measuredWidth6) >> 1, (this.Md.getTop() - this.Mj.getMeasuredHeight()) - this.LB, (measuredWidth6 + i5) >> 1, (this.Md.getTop() + i2) - this.LB);
        this.Mh.getLeft();
        this.Mh.getRight();
        int measuredWidth7 = this.Mf.getMeasuredWidth();
        int measuredHeight4 = this.Mf.getMeasuredHeight();
        int bottom3 = this.Mh.getBottom();
        this.Mf.layout((i5 - measuredWidth7) >> 1, this.Lx[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.Lx[3]);
        this.Mb.set((i5 - this.LZ.getIntrinsicWidth()) >> 1, this.Mi.getTop() - this.LC, (i5 + this.LZ.getIntrinsicHeight()) >> 1, (this.Mi.getTop() + this.LZ.getIntrinsicHeight()) - this.LC);
        this.LZ.setBounds(this.Mb);
        this.Mc.set(this.Mi.getLeft() + (this.LD >> 1) + this.LE, this.Mi.getTop() + (this.LD >> 1) + this.LE, (this.Mi.getRight() - (this.LD >> 1)) - this.LE, (this.Mi.getBottom() - (this.LD >> 1)) - this.LE);
        if (this.Ms == null) {
            this.Ms = new SweepGradient(this.Mc.centerX(), this.Mc.centerY(), this.Mq, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Ms.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Mc.centerX(), this.Mc.centerY());
            this.Ms.setLocalMatrix(matrix);
            this.Ma.setShader(this.Ms);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        d(canvas);
        super.dispatchDraw(canvas);
    }

    private void lV() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Mn == null) {
            this.Mn = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.i.aa(getContext()).getPageActivity());
            this.Mn.cT(getContext().getString(d.l.voice_restart_tip)).a(getContext().getString(d.l.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.g.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    g.this.lX();
                    if (g.this.getVoiceManager() != null && g.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.bM(g.this.mModel.voiceId);
                        }
                        g.this.mModel = null;
                    }
                }
            }).b(getContext().getString(d.l.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.g.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(com.baidu.adp.base.i.aa(getContext()));
        }
        try {
            this.Mn.tr();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bM(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void al(Context context) {
        LayoutInflater.from(context).inflate(d.j.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.Me = (TextView) findViewById(d.h.tip_error);
        ai.c(this.Me, d.e.cp_cont_i, 1);
        this.Mf = (TextView) findViewById(d.h.tip_operator);
        this.Mg = (TextView) findViewById(d.h.tip_time_out);
        this.Mh = (VoiceButton) findViewById(d.h.voice_bnt);
        this.Md = (TextView) findViewById(d.h.restart);
        this.Mi = (ImageView) findViewById(d.h.play_img);
        this.Mj = (TextView) findViewById(d.h.play_time);
        this.Mj.setClickable(false);
        this.Md.setOnClickListener(this);
        this.Mi.setOnClickListener(this);
        this.Mh.setRecorderView(this);
        lX();
    }

    private void lW() {
        this.Mh.setVisibility(4);
        this.Mj.setVisibility(0);
        this.Md.setVisibility(0);
        ai.c(this.Mj, d.e.cp_cont_f, 1);
        ai.c(this.Md, d.e.cp_cont_f, 1);
        ai.j(this.Md, d.g.but_posts_record_again_selector);
        this.Mi.setVisibility(0);
        if (this.mModel != null) {
            this.Mj.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Mi.setContentDescription(String.format(getContext().getString(d.l.listen_time), Integer.valueOf(this.mModel.duration)));
            ai.c(this.Mi, d.g.but_posts_record_play_selector);
        }
        ai.c(this.Mf, d.e.cp_cont_c, 1);
        this.Mf.setText(getContext().getString(d.l.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lX() {
        ai.c(this.Mh, d.g.but_posts_record_zero_selector);
        this.Mh.setVisibility(0);
        this.LF = 0;
        this.Mi.setVisibility(4);
        this.Mj.setVisibility(4);
        this.Md.setVisibility(4);
        this.Mg.setVisibility(4);
        ai.c(this.Mf, d.e.cp_cont_c, 1);
        this.Mf.setText(getContext().getString(d.l.voice_record_press_to_record));
    }

    public void reset() {
        lX();
        this.mModel = null;
        this.LF = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Me.setText("");
        this.Me.setVisibility(4);
        this.LF = 0;
        lW();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            lX();
            this.Mf.setText(getContext().getString(d.l.voice_record_release_to_stop));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStopingRecorder() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (this.Mi != null && this.Mj != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    ai.c(this.Mj, d.e.cp_cont_f, 1);
                    this.Mj.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ai.c(this.Mi, d.g.but_posts_record_play_selector);
                    this.Mi.setContentDescription(String.format(getContext().getString(d.l.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Mf.setText(getContext().getString(d.l.voice_play_tip));
                    lZ();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    ai.c(this.Mj, d.e.cp_cont_f, 1);
                    ai.c(this.Mi, d.g.but_posts_record_stop_selector);
                    this.Mi.setContentDescription(getContext().getString(d.l.pause));
                    this.Mf.setText(getContext().getString(d.l.voice_stop_tip));
                    lY();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        ai.c(this.Mg, d.e.cp_cont_i, 1);
        ai.c(this.Me, d.e.cp_cont_i, 1);
        ai.c(this.Mf, d.e.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Mg.setVisibility(0);
                this.Mg.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.Mg != null) {
                            g.this.Mg.setVisibility(4);
                            g.this.Mg.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.Me.setVisibility(0);
                this.Me.setText(str);
                this.Mf.setText(d.l.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.Me != null) {
                            g.this.Me.setVisibility(4);
                            g.this.Me.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.Me.setVisibility(0);
                this.Me.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.Me != null) {
                            g.this.Me.setVisibility(4);
                            g.this.Me.setText("");
                        }
                    }
                }, 2000L);
            } else {
                lX();
                this.Me.setVisibility(0);
                this.Me.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.Me != null) {
                            g.this.Me.setVisibility(4);
                            g.this.Me.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.Me.setVisibility(4);
        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
        voiceModel.duration = i;
        voiceModel.isLocal = true;
        voiceModel.voiceId = str;
        voiceModel.voice_status = 1;
        a(voiceModel);
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onDeletedVoice(String str) {
        this.mModel = null;
        b(new com.baidu.tbadk.editortools.a(11, -1, str));
        b(new com.baidu.tbadk.editortools.a(2, 6, null));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecordTime(int i) {
        ai.c(this.Me, d.e.cp_cont_i, 1);
        this.Me.setVisibility(0);
        this.Me.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Le = Math.max(i, this.Le);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Lf > 200) {
            this.Le = 0;
            this.Lf = uptimeMillis;
        }
        if (this.Le < 10) {
            this.LF = 1;
            invalidate();
        } else if (this.Le < 20) {
            this.LF = 2;
            invalidate();
        } else if (this.Le < 30) {
            this.LF = 3;
            invalidate();
        } else if (this.Le < 40) {
            this.LF = 4;
            invalidate();
        } else {
            this.LF = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aQ(int i) {
        if (this.mModel != null && this.Mj != null) {
            int i2 = i / 1000;
            if (this.Mt != i2) {
                this.Mj.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Mt = i2;
        }
    }

    private void lY() {
        if (this.mModel != null) {
            this.LF = 0;
            this.Mk = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Mo = SystemClock.uptimeMillis();
            this.Mp = this.Mo + 200;
            this.Mr.sendEmptyMessageAtTime(1, this.Mp);
            invalidate();
        }
    }

    private void lZ() {
        this.LF = 0;
        this.LG = 0;
        this.Mk = 0.0f;
        this.Ml = 0.0f;
        this.Mr.removeMessages(1);
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
            if (id == d.h.restart) {
                voiceManager.stopPlay();
                lV();
            } else if (id == d.h.play_img && this.mModel != null) {
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

    public void setCallback(f fVar) {
        this.Mm = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void ma() {
    }

    public void mb() {
        this.LN = new Paint();
        this.LN.setAntiAlias(true);
        this.LN.setStyle(Paint.Style.STROKE);
        this.LN.setStrokeWidth(2.0f);
        this.LO = new Paint();
        this.LO.setAntiAlias(true);
        this.LO.setStyle(Paint.Style.STROKE);
        this.LO.setStrokeWidth(2.0f);
        this.LP = new Paint();
        this.LP.setAntiAlias(true);
        this.LP.setStyle(Paint.Style.STROKE);
        this.LP.setStrokeWidth(2.0f);
        this.LQ = new Paint();
        this.LQ.setAntiAlias(true);
        this.LQ.setStyle(Paint.Style.STROKE);
        this.LQ.setStrokeWidth(2.0f);
    }

    public void d(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.LN.setColor(this.LV);
            this.LO.setColor(this.LW);
            this.LP.setColor(this.LX);
            this.LQ.setColor(this.LY);
        } else {
            this.LN.setColor(this.LR);
            this.LO.setColor(this.LS);
            this.LP.setColor(this.LT);
            this.LQ.setColor(this.LU);
        }
        if (this.LF == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.LH, this.LN);
        } else if (this.LF == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.LH, this.LN);
            canvas.drawCircle(this.centerX, this.centerY, this.LI, this.LO);
        } else if (this.LF == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.LH, this.LN);
            canvas.drawCircle(this.centerX, this.centerY, this.LI, this.LO);
            canvas.drawCircle(this.centerX, this.centerY, this.LJ, this.LP);
        } else if (this.LF == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.LH, this.LN);
            canvas.drawCircle(this.centerX, this.centerY, this.LI, this.LO);
            canvas.drawCircle(this.centerX, this.centerY, this.LJ, this.LP);
            canvas.drawCircle(this.centerX, this.centerY, this.LK, this.LQ);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.code == 9) {
            reset();
            b(new com.baidu.tbadk.editortools.a(2, 6, null));
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lT() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Ls;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Lt != null) {
            this.Lt.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Lt = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Ls = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }
}
