package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes.dex */
public class u extends com.baidu.tieba.tbadkCore.voice.b implements View.OnClickListener, com.baidu.adp.lib.voice.j, com.baidu.tbadk.core.voice.i {
    private final int[] KB;
    private int KC;
    private int KD;
    private final int KE;
    private final int KF;
    private final int KG;
    private final int KH;
    private final int KI;
    private int KJ;
    private int KK;
    private int KL;
    private int KM;
    private int KN;
    private int KO;
    private int KP;
    private int KQ;
    private Paint KR;
    private Paint KS;
    private Paint KT;
    private Paint KU;
    private int KV;
    private int KW;
    private int KX;
    private int KY;
    private int KZ;
    private int Kn;
    private long Ko;
    private int La;
    private int Lb;
    private int Lc;
    private final BitmapDrawable Ld;
    private final Paint Le;
    private final Rect Lf;
    private final RectF Lg;
    private TextView Lh;
    private TextView Li;
    private TextView Lj;
    private TextView Lk;
    private VoiceButton Ll;
    private ImageView Lm;
    private TextView Ln;
    private float Lo;
    private float Lp;
    private com.baidu.tieba.tbadkCore.voice.c Lq;
    private com.baidu.tbadk.core.dialog.a Lr;
    private long Ls;
    private long Lt;
    private final int[] Lu;
    private final ab Lv;
    private SweepGradient Lw;
    private int Lx;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;

    public static u Q(Context context) {
        return new u(context);
    }

    public u(Context context) {
        this(context, null);
    }

    public u(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ko = 0L;
        this.KB = new int[4];
        this.KJ = 0;
        this.KK = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.KL = 0;
        this.KM = 0;
        this.KN = 0;
        this.KO = 0;
        this.KP = 0;
        this.KQ = 0;
        this.KV = -1724676609;
        this.KW = 1546880511;
        this.KX = 674465279;
        this.KY = 255034879;
        this.KZ = -1725669966;
        this.La = 1545887154;
        this.Lb = 673471922;
        this.Lc = 254041522;
        this.Le = new Paint(1);
        this.Lf = new Rect();
        this.Lg = new RectF();
        this.Lu = new int[2];
        this.Lv = new ab(this, null);
        this.Kn = 0;
        this.Lx = 0;
        this.KB[0] = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.record_voice_btn_marginleft);
        this.KB[1] = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.record_voice_btn_margintop);
        this.KB[2] = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.record_voice_btn_marginright);
        this.KB[3] = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.record_voice_btn_marginbottom);
        this.KL = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds134);
        this.KM = this.KL + context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds14);
        this.KN = this.KM + context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds16);
        this.KO = this.KN + context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds18);
        this.KP = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds70);
        this.KQ = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds210);
        this.KC = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.record_voice_btn_paddingtop);
        this.KD = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.record_voice_btn_restart_button_paddingleft);
        this.KE = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.record_voice_btn_restart_button_paddingbottom);
        this.KF = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds4);
        this.KG = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.record_voice_btn_dot_glow_padding);
        this.KH = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.record_voice_btn_paint_stroke_width);
        this.KI = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.record_voice_btn_progress_padding);
        this.Le.setStyle(Paint.Style.STROKE);
        this.Le.setStrokeWidth(this.KH);
        this.Ld = (BitmapDrawable) getResources().getDrawable(com.baidu.tieba.u.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        R(context);
        oh();
        this.Lu[0] = ba.getColor(com.baidu.tieba.s.record_voice_progress_start);
        this.Lu[1] = ba.getColor(com.baidu.tieba.s.record_voice_progress_end);
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
        this.KC = ((i4 - getContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_editor_faceview_height)) / 2) + getContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.Ll.getMeasuredWidth();
        int measuredHeight = this.Ll.getMeasuredHeight();
        int measuredWidth2 = this.Li.getMeasuredWidth();
        this.Li.layout((i5 - measuredWidth2) >> 1, this.KC + i2, (measuredWidth2 + i5) >> 1, this.Li.getMeasuredHeight() + this.KC + i2);
        int bottom = this.Li.getBottom();
        this.Ll.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Lk.getMeasuredWidth();
        int measuredHeight2 = this.Lk.getMeasuredHeight();
        int top = this.Ll.getTop();
        this.Lk.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Lh.getMeasuredWidth();
        int measuredHeight3 = this.Lh.getMeasuredHeight();
        int right = this.Ll.getRight() - this.KD;
        int bottom2 = this.Ll.getBottom() - this.KE;
        this.Lh.layout(this.KP + i6, this.KQ + bottom, measuredWidth4 + i6 + this.KP, measuredHeight3 + this.KQ + bottom);
        int measuredWidth5 = this.Lm.getMeasuredWidth();
        this.Lm.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Lm.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Ln.getMeasuredWidth();
        this.Ln.layout((i5 - measuredWidth6) >> 1, (this.Lh.getTop() - this.Ln.getMeasuredHeight()) - this.KF, (measuredWidth6 + i5) >> 1, (this.Lh.getTop() + i2) - this.KF);
        this.Ll.getLeft();
        this.Ll.getRight();
        int measuredWidth7 = this.Lj.getMeasuredWidth();
        int measuredHeight4 = this.Lj.getMeasuredHeight();
        int bottom3 = this.Ll.getBottom();
        this.Lj.layout((i5 - measuredWidth7) >> 1, this.KB[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.KB[3]);
        this.Lf.set((i5 - this.Ld.getIntrinsicWidth()) >> 1, this.Lm.getTop() - this.KG, (i5 + this.Ld.getIntrinsicHeight()) >> 1, (this.Lm.getTop() + this.Ld.getIntrinsicHeight()) - this.KG);
        this.Ld.setBounds(this.Lf);
        this.Lg.set(this.Lm.getLeft() + (this.KH >> 1) + this.KI, this.Lm.getTop() + (this.KH >> 1) + this.KI, (this.Lm.getRight() - (this.KH >> 1)) - this.KI, (this.Lm.getBottom() - (this.KH >> 1)) - this.KI);
        if (this.Lw == null) {
            this.Lw = new SweepGradient(this.Lg.centerX(), this.Lg.centerY(), this.Lu, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Lw.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Lg.centerX(), this.Lg.centerY());
            this.Lw.setLocalMatrix(matrix);
            this.Le.setShader(this.Lw);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    private void oa() {
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Lr == null) {
            this.Lr = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.m.D(getContext()).getPageActivity());
            this.Lr.ca(getContext().getString(com.baidu.tieba.y.voice_restart_tip)).a(getContext().getString(com.baidu.tieba.y.voice_restart), new v(this, recorderManager)).b(getContext().getString(com.baidu.tieba.y.cancel), new w(this)).b(com.baidu.adp.base.m.D(getContext()));
        }
        try {
            this.Lr.re();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bE(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void R(Context context) {
        com.baidu.adp.lib.g.b.hH().a(context, com.baidu.tieba.w.record_voice_area, this, true);
        setClickable(true);
        this.Li = (TextView) findViewById(com.baidu.tieba.v.tip_error);
        ba.b(this.Li, com.baidu.tieba.s.cp_cont_i, 1);
        this.Lj = (TextView) findViewById(com.baidu.tieba.v.tip_operator);
        this.Lk = (TextView) findViewById(com.baidu.tieba.v.tip_time_out);
        this.Ll = (VoiceButton) findViewById(com.baidu.tieba.v.voice_bnt);
        this.Lh = (TextView) findViewById(com.baidu.tieba.v.restart);
        this.Lm = (ImageView) findViewById(com.baidu.tieba.v.play_img);
        this.Ln = (TextView) findViewById(com.baidu.tieba.v.play_time);
        this.Lh.setOnClickListener(this);
        this.Lm.setOnClickListener(this);
        this.Ll.setRecorderView(this);
        oc();
    }

    private void ob() {
        this.Ll.setVisibility(4);
        this.Ln.setVisibility(0);
        this.Lh.setVisibility(0);
        ba.b(this.Ln, com.baidu.tieba.s.cp_cont_f, 1);
        ba.b(this.Lh, com.baidu.tieba.s.cp_cont_f, 1);
        ba.i((View) this.Lh, com.baidu.tieba.u.but_posts_record_again_selector);
        this.Lm.setVisibility(0);
        if (this.mModel != null) {
            this.Ln.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            ba.c(this.Lm, com.baidu.tieba.u.but_posts_record_play_selector);
        }
        ba.b(this.Lj, com.baidu.tieba.s.cp_cont_c, 1);
        this.Lj.setText(getContext().getString(com.baidu.tieba.y.voice_play_tip));
    }

    public void oc() {
        ba.c(this.Ll, com.baidu.tieba.u.but_posts_record_zero_selector);
        this.Ll.setVisibility(0);
        this.KJ = 0;
        this.Lm.setVisibility(4);
        this.Ln.setVisibility(4);
        this.Lh.setVisibility(4);
        this.Lk.setVisibility(4);
        ba.b(this.Lj, com.baidu.tieba.s.cp_cont_c, 1);
        this.Lj.setText(getContext().getString(com.baidu.tieba.y.voice_record_press_to_record));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.b
    public void reset() {
        oc();
        this.mModel = null;
        this.KJ = 0;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.b
    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Li.setText("");
        this.Li.setVisibility(4);
        this.KJ = 0;
        ob();
        if (this.Lq != null) {
            this.Lq.alL();
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
        if (z) {
            oc();
            this.Lj.setText(getContext().getString(com.baidu.tieba.y.voice_record_release_to_stop));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    @Override // com.baidu.tieba.tbadkCore.voice.b, com.baidu.adp.lib.voice.j
    public void onStopingRecorder() {
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void b(VoiceData.VoiceModel voiceModel) {
        if (this.Lm != null && this.Ln != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    ba.b(this.Ln, com.baidu.tieba.s.cp_cont_f, 1);
                    this.Ln.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ba.c(this.Lm, com.baidu.tieba.u.but_posts_record_play_selector);
                    this.Lj.setText(getContext().getString(com.baidu.tieba.y.voice_play_tip));
                    oe();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    ba.b(this.Ln, com.baidu.tieba.s.cp_cont_f, 1);
                    ba.c(this.Lm, com.baidu.tieba.u.but_posts_record_stop_selector);
                    this.Lj.setText(getContext().getString(com.baidu.tieba.y.voice_stop_tip));
                    od();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
        ba.b(this.Lk, com.baidu.tieba.s.cp_cont_i, 1);
        ba.b(this.Li, com.baidu.tieba.s.cp_cont_i, 1);
        ba.b(this.Lj, com.baidu.tieba.s.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Lk.setVisibility(0);
                this.Lk.setText(str);
                postDelayed(new x(this), 2000L);
            } else if (i == 2) {
                this.Li.setVisibility(0);
                this.Li.setText(str);
                this.Lj.setText(com.baidu.tieba.y.voice_record_press_to_record);
                postDelayed(new y(this), 2000L);
            } else if (i == 5) {
                this.Li.setVisibility(0);
                this.Li.setText(str);
                postDelayed(new z(this), 2000L);
            } else {
                oc();
                this.Li.setVisibility(0);
                this.Li.setText(str);
                postDelayed(new aa(this), 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
        this.Li.setVisibility(4);
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
        if (this.Lq != null) {
            this.Lq.Nt();
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecordTime(int i) {
        ba.b(this.Li, com.baidu.tieba.s.cp_cont_i, 1);
        this.Li.setVisibility(0);
        this.Li.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.Kn = Math.max(i, this.Kn);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Ko > 200) {
            this.Kn = 0;
            this.Ko = uptimeMillis;
        }
        if (this.Kn < 10) {
            this.KJ = 1;
            invalidate();
        } else if (this.Kn < 20) {
            this.KJ = 2;
            invalidate();
        } else if (this.Kn < 30) {
            this.KJ = 3;
            invalidate();
        } else if (this.Kn < 40) {
            this.KJ = 4;
            invalidate();
        } else if (this.Kn < 50) {
            this.KJ = 5;
            invalidate();
        } else {
            this.KJ = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void aI(int i) {
        if (this.mModel != null && this.Ln != null) {
            int i2 = i / 1000;
            if (this.Lx != i2) {
                this.Ln.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Lx = i2;
        }
    }

    private void od() {
        if (this.mModel != null) {
            this.KJ = 0;
            this.Lo = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Ls = SystemClock.uptimeMillis();
            this.Lt = this.Ls + 200;
            this.Lv.sendEmptyMessageAtTime(1, this.Lt);
            invalidate();
        }
    }

    private void oe() {
        this.KJ = 0;
        this.KK = 0;
        this.Lo = 0.0f;
        this.Lp = 0.0f;
        this.Lv.removeMessages(1);
        ((ViewGroup) getParent()).invalidate();
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof com.baidu.tbadk.core.voice.j) {
            return ((com.baidu.tbadk.core.voice.j) context).getVoiceManager();
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
            if (id == com.baidu.tieba.v.restart) {
                voiceManager.stopPlay();
                oa();
            } else if (id == com.baidu.tieba.v.play_img && this.mModel != null) {
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

    @Override // com.baidu.tieba.tbadkCore.voice.b, com.baidu.tbadk.core.voice.i
    public VoiceData.VoiceModel getVoiceModel() {
        return this.mModel;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.b
    public void of() {
        oc();
        if (getVoiceManager() != null && getVoiceManager().getRecorderManager() != null && this.mModel != null) {
            getVoiceManager().getRecorderManager().bE(this.mModel.voiceId);
            this.mModel = null;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.b
    public void setCallback(com.baidu.tieba.tbadkCore.voice.c cVar) {
        this.Lq = cVar;
    }

    @Override // com.baidu.tbadk.core.voice.i
    public com.baidu.tbadk.core.voice.i getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void og() {
    }

    public void oh() {
        this.KR = new Paint();
        this.KR.setAntiAlias(true);
        this.KR.setStyle(Paint.Style.STROKE);
        this.KR.setStrokeWidth(2.0f);
        this.KS = new Paint();
        this.KS.setAntiAlias(true);
        this.KS.setStyle(Paint.Style.STROKE);
        this.KS.setStrokeWidth(2.0f);
        this.KT = new Paint();
        this.KT.setAntiAlias(true);
        this.KT.setStyle(Paint.Style.STROKE);
        this.KT.setStrokeWidth(2.0f);
        this.KU = new Paint();
        this.KU.setAntiAlias(true);
        this.KU.setStyle(Paint.Style.STROKE);
        this.KU.setStrokeWidth(2.0f);
    }

    public void c(Canvas canvas) {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.KR.setColor(this.KZ);
            this.KS.setColor(this.La);
            this.KT.setColor(this.Lb);
            this.KU.setColor(this.Lc);
        } else {
            this.KR.setColor(this.KV);
            this.KS.setColor(this.KW);
            this.KT.setColor(this.KX);
            this.KU.setColor(this.KY);
        }
        if (this.KJ == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.KL, this.KR);
        } else if (this.KJ == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.KL, this.KR);
            canvas.drawCircle(this.centerX, this.centerY, this.KM, this.KS);
        } else if (this.KJ == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.KL, this.KR);
            canvas.drawCircle(this.centerX, this.centerY, this.KM, this.KS);
            canvas.drawCircle(this.centerX, this.centerY, this.KN, this.KT);
        } else if (this.KJ == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.KL, this.KR);
            canvas.drawCircle(this.centerX, this.centerY, this.KM, this.KS);
            canvas.drawCircle(this.centerX, this.centerY, this.KN, this.KT);
            canvas.drawCircle(this.centerX, this.centerY, this.KO, this.KU);
        }
    }
}
