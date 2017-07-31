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
    private int LD;
    private int LE;
    private int LF;
    private int LG;
    private int LH;
    private int LI;
    private int LJ;
    private int LK;
    private Paint LL;
    private Paint LM;
    private Paint LN;
    private Paint LO;
    private int LP;
    private int LQ;
    private int LR;
    private int LS;
    private int LT;
    private int LU;
    private int LV;
    private int LW;
    private final BitmapDrawable LX;
    private final Paint LY;
    private final Rect LZ;
    private int Lc;
    private long Ld;
    private int Lq;
    private i Lr;
    private final int[] Lv;
    private int Lw;
    private int Lx;
    private final int Ly;
    private final int Lz;
    private final RectF Ma;
    private TextView Mb;
    private TextView Mc;
    private TextView Md;
    private TextView Me;
    private VoiceButton Mf;
    private ImageView Mg;
    private TextView Mh;
    private float Mi;
    private float Mj;
    private f Mk;
    private com.baidu.tbadk.core.dialog.a Ml;
    private long Mm;
    private long Mn;
    private final int[] Mo;
    private final a Mp;
    private SweepGradient Mq;
    private int Mr;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;

    static /* synthetic */ int e(g gVar) {
        int i = gVar.LE;
        gVar.LE = i + 1;
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
                if (g.this.Mj >= 360.0f) {
                    g.this.Mj = 360.0f;
                    g.this.LE = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    g.this.Mm = uptimeMillis;
                    g.this.Mn = uptimeMillis + 200;
                    g.this.Mj += (((float) (uptimeMillis - g.this.Mm)) / 1000.0f) * g.this.Mi;
                    sendEmptyMessageAtTime(1, g.this.Mn);
                    g.e(g.this);
                }
                g.this.LD = g.this.LE % 6;
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
        this.Ld = 0L;
        this.Lv = new int[4];
        this.LD = 0;
        this.LE = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.LF = 0;
        this.LG = 0;
        this.LH = 0;
        this.LI = 0;
        this.LJ = 0;
        this.LK = 0;
        this.LP = -1724676609;
        this.LQ = 1546880511;
        this.LR = 674465279;
        this.LS = 255034879;
        this.LT = -1725669966;
        this.LU = 1545887154;
        this.LV = 673471922;
        this.LW = 254041522;
        this.LY = new Paint(1);
        this.LZ = new Rect();
        this.Ma = new RectF();
        this.Lq = 0;
        this.Mo = new int[2];
        this.Mp = new a();
        this.Lc = 0;
        this.Mr = 0;
        this.Lv[0] = context.getResources().getDimensionPixelSize(d.f.ds24);
        this.Lv[1] = context.getResources().getDimensionPixelSize(d.f.ds8);
        this.Lv[2] = context.getResources().getDimensionPixelSize(d.f.ds22);
        this.Lv[3] = context.getResources().getDimensionPixelSize(d.f.ds36);
        this.LF = context.getResources().getDimensionPixelSize(d.f.ds134);
        this.LG = this.LF + context.getResources().getDimensionPixelSize(d.f.ds14);
        this.LH = this.LG + context.getResources().getDimensionPixelSize(d.f.ds16);
        this.LI = this.LH + context.getResources().getDimensionPixelSize(d.f.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.LJ = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.LK = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.LJ = context.getResources().getDimensionPixelSize(d.f.ds70);
            this.LK = context.getResources().getDimensionPixelSize(d.f.ds210);
        }
        this.Lw = context.getResources().getDimensionPixelSize(d.f.ds26);
        this.Lx = context.getResources().getDimensionPixelSize(d.f.ds10);
        this.Ly = context.getResources().getDimensionPixelSize(d.f.ds14);
        this.Lz = context.getResources().getDimensionPixelSize(d.f.ds4);
        this.LA = context.getResources().getDimensionPixelSize(d.f.ds4);
        this.LB = context.getResources().getDimensionPixelSize(d.f.ds12);
        this.LC = context.getResources().getDimensionPixelSize(d.f.ds2);
        this.LY.setStyle(Paint.Style.STROKE);
        this.LY.setStrokeWidth(this.LB);
        this.LX = (BitmapDrawable) getResources().getDrawable(d.g.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        al(context);
        mb();
        this.Mo[0] = ai.getColor(d.e.common_color_10151);
        this.Mo[1] = ai.getColor(d.e.common_color_10152);
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
        this.Lw = ((i4 - getContext().getResources().getDimensionPixelSize(d.f.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(d.f.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.Mf.getMeasuredWidth();
        int measuredHeight = this.Mf.getMeasuredHeight();
        int measuredWidth2 = this.Mc.getMeasuredWidth();
        this.Mc.layout((i5 - measuredWidth2) >> 1, this.Lw + i2, (measuredWidth2 + i5) >> 1, this.Mc.getMeasuredHeight() + this.Lw + i2);
        int bottom = this.Mc.getBottom();
        this.Mf.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Me.getMeasuredWidth();
        int measuredHeight2 = this.Me.getMeasuredHeight();
        int top = this.Mf.getTop();
        this.Me.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Mb.getMeasuredWidth();
        int measuredHeight3 = this.Mb.getMeasuredHeight();
        int right = this.Mf.getRight() - this.Lx;
        int bottom2 = this.Mf.getBottom() - this.Ly;
        this.Mb.layout(this.LJ + i6, this.LK + bottom, measuredWidth4 + i6 + this.LJ, measuredHeight3 + this.LK + bottom);
        int measuredWidth5 = this.Mg.getMeasuredWidth();
        this.Mg.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Mg.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Mh.getMeasuredWidth();
        this.Mh.layout((i5 - measuredWidth6) >> 1, (this.Mb.getTop() - this.Mh.getMeasuredHeight()) - this.Lz, (measuredWidth6 + i5) >> 1, (this.Mb.getTop() + i2) - this.Lz);
        this.Mf.getLeft();
        this.Mf.getRight();
        int measuredWidth7 = this.Md.getMeasuredWidth();
        int measuredHeight4 = this.Md.getMeasuredHeight();
        int bottom3 = this.Mf.getBottom();
        this.Md.layout((i5 - measuredWidth7) >> 1, this.Lv[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.Lv[3]);
        this.LZ.set((i5 - this.LX.getIntrinsicWidth()) >> 1, this.Mg.getTop() - this.LA, (i5 + this.LX.getIntrinsicHeight()) >> 1, (this.Mg.getTop() + this.LX.getIntrinsicHeight()) - this.LA);
        this.LX.setBounds(this.LZ);
        this.Ma.set(this.Mg.getLeft() + (this.LB >> 1) + this.LC, this.Mg.getTop() + (this.LB >> 1) + this.LC, (this.Mg.getRight() - (this.LB >> 1)) - this.LC, (this.Mg.getBottom() - (this.LB >> 1)) - this.LC);
        if (this.Mq == null) {
            this.Mq = new SweepGradient(this.Ma.centerX(), this.Ma.centerY(), this.Mo, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Mq.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Ma.centerX(), this.Ma.centerY());
            this.Mq.setLocalMatrix(matrix);
            this.LY.setShader(this.Mq);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        d(canvas);
        super.dispatchDraw(canvas);
    }

    private void lV() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Ml == null) {
            this.Ml = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.i.aa(getContext()).getPageActivity());
            this.Ml.cT(getContext().getString(d.l.voice_restart_tip)).a(getContext().getString(d.l.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.g.2
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
            this.Ml.tr();
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
        this.Mc = (TextView) findViewById(d.h.tip_error);
        ai.c(this.Mc, d.e.cp_cont_i, 1);
        this.Md = (TextView) findViewById(d.h.tip_operator);
        this.Me = (TextView) findViewById(d.h.tip_time_out);
        this.Mf = (VoiceButton) findViewById(d.h.voice_bnt);
        this.Mb = (TextView) findViewById(d.h.restart);
        this.Mg = (ImageView) findViewById(d.h.play_img);
        this.Mh = (TextView) findViewById(d.h.play_time);
        this.Mh.setClickable(false);
        this.Mb.setOnClickListener(this);
        this.Mg.setOnClickListener(this);
        this.Mf.setRecorderView(this);
        lX();
    }

    private void lW() {
        this.Mf.setVisibility(4);
        this.Mh.setVisibility(0);
        this.Mb.setVisibility(0);
        ai.c(this.Mh, d.e.cp_cont_f, 1);
        ai.c(this.Mb, d.e.cp_cont_f, 1);
        ai.j(this.Mb, d.g.but_posts_record_again_selector);
        this.Mg.setVisibility(0);
        if (this.mModel != null) {
            this.Mh.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Mg.setContentDescription(String.format(getContext().getString(d.l.listen_time), Integer.valueOf(this.mModel.duration)));
            ai.c(this.Mg, d.g.but_posts_record_play_selector);
        }
        ai.c(this.Md, d.e.cp_cont_c, 1);
        this.Md.setText(getContext().getString(d.l.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lX() {
        ai.c(this.Mf, d.g.but_posts_record_zero_selector);
        this.Mf.setVisibility(0);
        this.LD = 0;
        this.Mg.setVisibility(4);
        this.Mh.setVisibility(4);
        this.Mb.setVisibility(4);
        this.Me.setVisibility(4);
        ai.c(this.Md, d.e.cp_cont_c, 1);
        this.Md.setText(getContext().getString(d.l.voice_record_press_to_record));
    }

    public void reset() {
        lX();
        this.mModel = null;
        this.LD = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Mc.setText("");
        this.Mc.setVisibility(4);
        this.LD = 0;
        lW();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            lX();
            this.Md.setText(getContext().getString(d.l.voice_record_release_to_stop));
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
        if (this.Mg != null && this.Mh != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    ai.c(this.Mh, d.e.cp_cont_f, 1);
                    this.Mh.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ai.c(this.Mg, d.g.but_posts_record_play_selector);
                    this.Mg.setContentDescription(String.format(getContext().getString(d.l.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Md.setText(getContext().getString(d.l.voice_play_tip));
                    lZ();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    ai.c(this.Mh, d.e.cp_cont_f, 1);
                    ai.c(this.Mg, d.g.but_posts_record_stop_selector);
                    this.Mg.setContentDescription(getContext().getString(d.l.pause));
                    this.Md.setText(getContext().getString(d.l.voice_stop_tip));
                    lY();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        ai.c(this.Me, d.e.cp_cont_i, 1);
        ai.c(this.Mc, d.e.cp_cont_i, 1);
        ai.c(this.Md, d.e.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Me.setVisibility(0);
                this.Me.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.Me != null) {
                            g.this.Me.setVisibility(4);
                            g.this.Me.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.Mc.setVisibility(0);
                this.Mc.setText(str);
                this.Md.setText(d.l.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.Mc != null) {
                            g.this.Mc.setVisibility(4);
                            g.this.Mc.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.Mc.setVisibility(0);
                this.Mc.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.Mc != null) {
                            g.this.Mc.setVisibility(4);
                            g.this.Mc.setText("");
                        }
                    }
                }, 2000L);
            } else {
                lX();
                this.Mc.setVisibility(0);
                this.Mc.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.Mc != null) {
                            g.this.Mc.setVisibility(4);
                            g.this.Mc.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.Mc.setVisibility(4);
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
        ai.c(this.Mc, d.e.cp_cont_i, 1);
        this.Mc.setVisibility(0);
        this.Mc.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Lc = Math.max(i, this.Lc);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Ld > 200) {
            this.Lc = 0;
            this.Ld = uptimeMillis;
        }
        if (this.Lc < 10) {
            this.LD = 1;
            invalidate();
        } else if (this.Lc < 20) {
            this.LD = 2;
            invalidate();
        } else if (this.Lc < 30) {
            this.LD = 3;
            invalidate();
        } else if (this.Lc < 40) {
            this.LD = 4;
            invalidate();
        } else {
            this.LD = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aQ(int i) {
        if (this.mModel != null && this.Mh != null) {
            int i2 = i / 1000;
            if (this.Mr != i2) {
                this.Mh.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Mr = i2;
        }
    }

    private void lY() {
        if (this.mModel != null) {
            this.LD = 0;
            this.Mi = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Mm = SystemClock.uptimeMillis();
            this.Mn = this.Mm + 200;
            this.Mp.sendEmptyMessageAtTime(1, this.Mn);
            invalidate();
        }
    }

    private void lZ() {
        this.LD = 0;
        this.LE = 0;
        this.Mi = 0.0f;
        this.Mj = 0.0f;
        this.Mp.removeMessages(1);
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
        this.Mk = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void ma() {
    }

    public void mb() {
        this.LL = new Paint();
        this.LL.setAntiAlias(true);
        this.LL.setStyle(Paint.Style.STROKE);
        this.LL.setStrokeWidth(2.0f);
        this.LM = new Paint();
        this.LM.setAntiAlias(true);
        this.LM.setStyle(Paint.Style.STROKE);
        this.LM.setStrokeWidth(2.0f);
        this.LN = new Paint();
        this.LN.setAntiAlias(true);
        this.LN.setStyle(Paint.Style.STROKE);
        this.LN.setStrokeWidth(2.0f);
        this.LO = new Paint();
        this.LO.setAntiAlias(true);
        this.LO.setStyle(Paint.Style.STROKE);
        this.LO.setStrokeWidth(2.0f);
    }

    public void d(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.LL.setColor(this.LT);
            this.LM.setColor(this.LU);
            this.LN.setColor(this.LV);
            this.LO.setColor(this.LW);
        } else {
            this.LL.setColor(this.LP);
            this.LM.setColor(this.LQ);
            this.LN.setColor(this.LR);
            this.LO.setColor(this.LS);
        }
        if (this.LD == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.LF, this.LL);
        } else if (this.LD == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.LF, this.LL);
            canvas.drawCircle(this.centerX, this.centerY, this.LG, this.LM);
        } else if (this.LD == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.LF, this.LL);
            canvas.drawCircle(this.centerX, this.centerY, this.LG, this.LM);
            canvas.drawCircle(this.centerX, this.centerY, this.LH, this.LN);
        } else if (this.LD == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.LF, this.LL);
            canvas.drawCircle(this.centerX, this.centerY, this.LG, this.LM);
            canvas.drawCircle(this.centerX, this.centerY, this.LH, this.LN);
            canvas.drawCircle(this.centerX, this.centerY, this.LI, this.LO);
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
        return this.Lq;
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
        if (this.Lr != null) {
            this.Lr.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Lr = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Lq = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }
}
