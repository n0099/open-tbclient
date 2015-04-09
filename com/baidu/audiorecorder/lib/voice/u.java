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
    private final int[] KD;
    private int KE;
    private int KF;
    private final int KG;
    private final int KH;
    private final int KI;
    private final int KJ;
    private final int KK;
    private int KL;
    private int KM;
    private int KN;
    private int KO;
    private int KP;
    private int KQ;
    private int KR;
    private int KS;
    private Paint KT;
    private Paint KU;
    private Paint KV;
    private Paint KW;
    private int KX;
    private int KY;
    private int KZ;
    private int Kp;
    private long Kq;
    private int La;
    private int Lb;
    private int Lc;
    private int Ld;
    private int Le;
    private final BitmapDrawable Lf;
    private final Paint Lg;
    private final Rect Lh;
    private final RectF Li;
    private TextView Lj;
    private TextView Lk;
    private TextView Ll;
    private TextView Lm;
    private VoiceButton Ln;
    private ImageView Lo;
    private TextView Lp;
    private float Lq;
    private float Lr;
    private com.baidu.tieba.tbadkCore.voice.c Ls;
    private com.baidu.tbadk.core.dialog.a Lt;
    private long Lu;
    private long Lv;
    private final int[] Lw;
    private final ab Lx;
    private SweepGradient Ly;
    private int Lz;
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
        this.Kq = 0L;
        this.KD = new int[4];
        this.KL = 0;
        this.KM = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.KN = 0;
        this.KO = 0;
        this.KP = 0;
        this.KQ = 0;
        this.KR = 0;
        this.KS = 0;
        this.KX = -1724676609;
        this.KY = 1546880511;
        this.KZ = 674465279;
        this.La = 255034879;
        this.Lb = -1725669966;
        this.Lc = 1545887154;
        this.Ld = 673471922;
        this.Le = 254041522;
        this.Lg = new Paint(1);
        this.Lh = new Rect();
        this.Li = new RectF();
        this.Lw = new int[2];
        this.Lx = new ab(this, null);
        this.Kp = 0;
        this.Lz = 0;
        this.KD[0] = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.record_voice_btn_marginleft);
        this.KD[1] = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.record_voice_btn_margintop);
        this.KD[2] = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.record_voice_btn_marginright);
        this.KD[3] = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.record_voice_btn_marginbottom);
        this.KN = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds134);
        this.KO = this.KN + context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds14);
        this.KP = this.KO + context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds16);
        this.KQ = this.KP + context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds18);
        this.KR = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds70);
        this.KS = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds210);
        this.KE = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.record_voice_btn_paddingtop);
        this.KF = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.record_voice_btn_restart_button_paddingleft);
        this.KG = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.record_voice_btn_restart_button_paddingbottom);
        this.KH = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds4);
        this.KI = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.record_voice_btn_dot_glow_padding);
        this.KJ = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.record_voice_btn_paint_stroke_width);
        this.KK = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.record_voice_btn_progress_padding);
        this.Lg.setStyle(Paint.Style.STROKE);
        this.Lg.setStrokeWidth(this.KJ);
        this.Lf = (BitmapDrawable) getResources().getDrawable(com.baidu.tieba.u.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        R(context);
        oh();
        this.Lw[0] = ba.getColor(com.baidu.tieba.s.record_voice_progress_start);
        this.Lw[1] = ba.getColor(com.baidu.tieba.s.record_voice_progress_end);
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
        this.KE = ((i4 - getContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_editor_faceview_height)) / 2) + getContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.Ln.getMeasuredWidth();
        int measuredHeight = this.Ln.getMeasuredHeight();
        int measuredWidth2 = this.Lk.getMeasuredWidth();
        this.Lk.layout((i5 - measuredWidth2) >> 1, this.KE + i2, (measuredWidth2 + i5) >> 1, this.Lk.getMeasuredHeight() + this.KE + i2);
        int bottom = this.Lk.getBottom();
        this.Ln.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Lm.getMeasuredWidth();
        int measuredHeight2 = this.Lm.getMeasuredHeight();
        int top = this.Ln.getTop();
        this.Lm.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Lj.getMeasuredWidth();
        int measuredHeight3 = this.Lj.getMeasuredHeight();
        int right = this.Ln.getRight() - this.KF;
        int bottom2 = this.Ln.getBottom() - this.KG;
        this.Lj.layout(this.KR + i6, this.KS + bottom, measuredWidth4 + i6 + this.KR, measuredHeight3 + this.KS + bottom);
        int measuredWidth5 = this.Lo.getMeasuredWidth();
        this.Lo.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Lo.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Lp.getMeasuredWidth();
        this.Lp.layout((i5 - measuredWidth6) >> 1, (this.Lj.getTop() - this.Lp.getMeasuredHeight()) - this.KH, (measuredWidth6 + i5) >> 1, (this.Lj.getTop() + i2) - this.KH);
        this.Ln.getLeft();
        this.Ln.getRight();
        int measuredWidth7 = this.Ll.getMeasuredWidth();
        int measuredHeight4 = this.Ll.getMeasuredHeight();
        int bottom3 = this.Ln.getBottom();
        this.Ll.layout((i5 - measuredWidth7) >> 1, this.KD[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.KD[3]);
        this.Lh.set((i5 - this.Lf.getIntrinsicWidth()) >> 1, this.Lo.getTop() - this.KI, (i5 + this.Lf.getIntrinsicHeight()) >> 1, (this.Lo.getTop() + this.Lf.getIntrinsicHeight()) - this.KI);
        this.Lf.setBounds(this.Lh);
        this.Li.set(this.Lo.getLeft() + (this.KJ >> 1) + this.KK, this.Lo.getTop() + (this.KJ >> 1) + this.KK, (this.Lo.getRight() - (this.KJ >> 1)) - this.KK, (this.Lo.getBottom() - (this.KJ >> 1)) - this.KK);
        if (this.Ly == null) {
            this.Ly = new SweepGradient(this.Li.centerX(), this.Li.centerY(), this.Lw, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Ly.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Li.centerX(), this.Li.centerY());
            this.Ly.setLocalMatrix(matrix);
            this.Lg.setShader(this.Ly);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    private void oa() {
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Lt == null) {
            this.Lt = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.m.D(getContext()).getPageActivity());
            this.Lt.ca(getContext().getString(com.baidu.tieba.y.voice_restart_tip)).a(getContext().getString(com.baidu.tieba.y.voice_restart), new v(this, recorderManager)).b(getContext().getString(com.baidu.tieba.y.cancel), new w(this)).b(com.baidu.adp.base.m.D(getContext()));
        }
        try {
            this.Lt.re();
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
        this.Lk = (TextView) findViewById(com.baidu.tieba.v.tip_error);
        ba.b(this.Lk, com.baidu.tieba.s.cp_cont_i, 1);
        this.Ll = (TextView) findViewById(com.baidu.tieba.v.tip_operator);
        this.Lm = (TextView) findViewById(com.baidu.tieba.v.tip_time_out);
        this.Ln = (VoiceButton) findViewById(com.baidu.tieba.v.voice_bnt);
        this.Lj = (TextView) findViewById(com.baidu.tieba.v.restart);
        this.Lo = (ImageView) findViewById(com.baidu.tieba.v.play_img);
        this.Lp = (TextView) findViewById(com.baidu.tieba.v.play_time);
        this.Lj.setOnClickListener(this);
        this.Lo.setOnClickListener(this);
        this.Ln.setRecorderView(this);
        oc();
    }

    private void ob() {
        this.Ln.setVisibility(4);
        this.Lp.setVisibility(0);
        this.Lj.setVisibility(0);
        ba.b(this.Lp, com.baidu.tieba.s.cp_cont_f, 1);
        ba.b(this.Lj, com.baidu.tieba.s.cp_cont_f, 1);
        ba.i((View) this.Lj, com.baidu.tieba.u.but_posts_record_again_selector);
        this.Lo.setVisibility(0);
        if (this.mModel != null) {
            this.Lp.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            ba.c(this.Lo, com.baidu.tieba.u.but_posts_record_play_selector);
        }
        ba.b(this.Ll, com.baidu.tieba.s.cp_cont_c, 1);
        this.Ll.setText(getContext().getString(com.baidu.tieba.y.voice_play_tip));
    }

    public void oc() {
        ba.c(this.Ln, com.baidu.tieba.u.but_posts_record_zero_selector);
        this.Ln.setVisibility(0);
        this.KL = 0;
        this.Lo.setVisibility(4);
        this.Lp.setVisibility(4);
        this.Lj.setVisibility(4);
        this.Lm.setVisibility(4);
        ba.b(this.Ll, com.baidu.tieba.s.cp_cont_c, 1);
        this.Ll.setText(getContext().getString(com.baidu.tieba.y.voice_record_press_to_record));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.b
    public void reset() {
        oc();
        this.mModel = null;
        this.KL = 0;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.b
    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Lk.setText("");
        this.Lk.setVisibility(4);
        this.KL = 0;
        ob();
        if (this.Ls != null) {
            this.Ls.ama();
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
        if (z) {
            oc();
            this.Ll.setText(getContext().getString(com.baidu.tieba.y.voice_record_release_to_stop));
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
        if (this.Lo != null && this.Lp != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    ba.b(this.Lp, com.baidu.tieba.s.cp_cont_f, 1);
                    this.Lp.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ba.c(this.Lo, com.baidu.tieba.u.but_posts_record_play_selector);
                    this.Ll.setText(getContext().getString(com.baidu.tieba.y.voice_play_tip));
                    oe();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    ba.b(this.Lp, com.baidu.tieba.s.cp_cont_f, 1);
                    ba.c(this.Lo, com.baidu.tieba.u.but_posts_record_stop_selector);
                    this.Ll.setText(getContext().getString(com.baidu.tieba.y.voice_stop_tip));
                    od();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
        ba.b(this.Lm, com.baidu.tieba.s.cp_cont_i, 1);
        ba.b(this.Lk, com.baidu.tieba.s.cp_cont_i, 1);
        ba.b(this.Ll, com.baidu.tieba.s.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Lm.setVisibility(0);
                this.Lm.setText(str);
                postDelayed(new x(this), 2000L);
            } else if (i == 2) {
                this.Lk.setVisibility(0);
                this.Lk.setText(str);
                this.Ll.setText(com.baidu.tieba.y.voice_record_press_to_record);
                postDelayed(new y(this), 2000L);
            } else if (i == 5) {
                this.Lk.setVisibility(0);
                this.Lk.setText(str);
                postDelayed(new z(this), 2000L);
            } else {
                oc();
                this.Lk.setVisibility(0);
                this.Lk.setText(str);
                postDelayed(new aa(this), 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
        this.Lk.setVisibility(4);
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
        if (this.Ls != null) {
            this.Ls.NG();
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecordTime(int i) {
        ba.b(this.Lk, com.baidu.tieba.s.cp_cont_i, 1);
        this.Lk.setVisibility(0);
        this.Lk.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.Kp = Math.max(i, this.Kp);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Kq > 200) {
            this.Kp = 0;
            this.Kq = uptimeMillis;
        }
        if (this.Kp < 10) {
            this.KL = 1;
            invalidate();
        } else if (this.Kp < 20) {
            this.KL = 2;
            invalidate();
        } else if (this.Kp < 30) {
            this.KL = 3;
            invalidate();
        } else if (this.Kp < 40) {
            this.KL = 4;
            invalidate();
        } else if (this.Kp < 50) {
            this.KL = 5;
            invalidate();
        } else {
            this.KL = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void aI(int i) {
        if (this.mModel != null && this.Lp != null) {
            int i2 = i / 1000;
            if (this.Lz != i2) {
                this.Lp.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Lz = i2;
        }
    }

    private void od() {
        if (this.mModel != null) {
            this.KL = 0;
            this.Lq = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Lu = SystemClock.uptimeMillis();
            this.Lv = this.Lu + 200;
            this.Lx.sendEmptyMessageAtTime(1, this.Lv);
            invalidate();
        }
    }

    private void oe() {
        this.KL = 0;
        this.KM = 0;
        this.Lq = 0.0f;
        this.Lr = 0.0f;
        this.Lx.removeMessages(1);
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
        this.Ls = cVar;
    }

    @Override // com.baidu.tbadk.core.voice.i
    public com.baidu.tbadk.core.voice.i getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void og() {
    }

    public void oh() {
        this.KT = new Paint();
        this.KT.setAntiAlias(true);
        this.KT.setStyle(Paint.Style.STROKE);
        this.KT.setStrokeWidth(2.0f);
        this.KU = new Paint();
        this.KU.setAntiAlias(true);
        this.KU.setStyle(Paint.Style.STROKE);
        this.KU.setStrokeWidth(2.0f);
        this.KV = new Paint();
        this.KV.setAntiAlias(true);
        this.KV.setStyle(Paint.Style.STROKE);
        this.KV.setStrokeWidth(2.0f);
        this.KW = new Paint();
        this.KW.setAntiAlias(true);
        this.KW.setStyle(Paint.Style.STROKE);
        this.KW.setStrokeWidth(2.0f);
    }

    public void c(Canvas canvas) {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.KT.setColor(this.Lb);
            this.KU.setColor(this.Lc);
            this.KV.setColor(this.Ld);
            this.KW.setColor(this.Le);
        } else {
            this.KT.setColor(this.KX);
            this.KU.setColor(this.KY);
            this.KV.setColor(this.KZ);
            this.KW.setColor(this.La);
        }
        if (this.KL == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.KN, this.KT);
        } else if (this.KL == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.KN, this.KT);
            canvas.drawCircle(this.centerX, this.centerY, this.KO, this.KU);
        } else if (this.KL == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.KN, this.KT);
            canvas.drawCircle(this.centerX, this.centerY, this.KO, this.KU);
            canvas.drawCircle(this.centerX, this.centerY, this.KP, this.KV);
        } else if (this.KL == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.KN, this.KT);
            canvas.drawCircle(this.centerX, this.centerY, this.KO, this.KU);
            canvas.drawCircle(this.centerX, this.centerY, this.KP, this.KV);
            canvas.drawCircle(this.centerX, this.centerY, this.KQ, this.KW);
        }
    }
}
