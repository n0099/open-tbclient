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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes2.dex */
public class h extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, s {
    private int axF;
    private long axG;
    private i axN;
    private int axO;
    private com.baidu.tbadk.core.dialog.a axQ;
    private int ayA;
    private int ayB;
    private int ayC;
    private int ayD;
    private int ayE;
    private int ayF;
    private int ayG;
    private Paint ayH;
    private Paint ayI;
    private Paint ayJ;
    private Paint ayK;
    private int ayL;
    private int ayM;
    private int ayN;
    private int ayO;
    private int ayP;
    private int ayQ;
    private int ayR;
    private int ayS;
    private final BitmapDrawable ayT;
    private final Paint ayU;
    private final Rect ayV;
    private final RectF ayW;
    private TextView ayX;
    private TextView ayY;
    private TextView ayZ;
    private final int[] ays;
    private int ayt;
    private final int ayu;
    private final int ayv;
    private final int ayw;
    private final int ayx;
    private final int ayy;
    private int ayz;
    private TextView aza;
    private VoiceButton azb;
    private ImageView azc;
    private TextView azd;
    private float aze;
    private float azf;
    private g azg;
    private long azh;
    private long azi;
    private final int[] azj;
    private final a azk;
    private SweepGradient azl;
    private int azm;
    private int centerX;
    private int centerY;
    private int kq;
    VoiceData.VoiceModel mModel;

    static /* synthetic */ int e(h hVar) {
        int i = hVar.ayA;
        hVar.ayA = i + 1;
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
                if (h.this.azf >= 360.0f) {
                    h.this.azf = 360.0f;
                    h.this.ayA = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    h.this.azh = uptimeMillis;
                    h.this.azi = uptimeMillis + 200;
                    h.this.azf += (((float) (uptimeMillis - h.this.azh)) / 1000.0f) * h.this.aze;
                    sendEmptyMessageAtTime(1, h.this.azi);
                    h.e(h.this);
                }
                h.this.ayz = h.this.ayA % 6;
                h.this.invalidate();
            }
        }
    }

    public static h au(Context context) {
        return new h(context);
    }

    public h(Context context) {
        this(context, null);
    }

    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axG = 0L;
        this.ays = new int[4];
        this.ayz = 0;
        this.ayA = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.ayB = 0;
        this.ayC = 0;
        this.ayD = 0;
        this.ayE = 0;
        this.ayF = 0;
        this.ayG = 0;
        this.ayL = -1724676609;
        this.ayM = 1546880511;
        this.ayN = 674465279;
        this.ayO = 255034879;
        this.ayP = -1725669966;
        this.ayQ = 1545887154;
        this.ayR = 673471922;
        this.ayS = 254041522;
        this.ayU = new Paint(1);
        this.ayV = new Rect();
        this.ayW = new RectF();
        this.axO = 0;
        this.azj = new int[2];
        this.azk = new a();
        this.axF = 0;
        this.azm = 0;
        this.ays[0] = context.getResources().getDimensionPixelSize(d.e.ds24);
        this.ays[1] = context.getResources().getDimensionPixelSize(d.e.ds8);
        this.ays[2] = context.getResources().getDimensionPixelSize(d.e.ds22);
        this.ays[3] = context.getResources().getDimensionPixelSize(d.e.ds36);
        this.ayB = context.getResources().getDimensionPixelSize(d.e.ds134);
        this.ayC = this.ayB + context.getResources().getDimensionPixelSize(d.e.ds14);
        this.ayD = this.ayC + context.getResources().getDimensionPixelSize(d.e.ds16);
        this.ayE = this.ayD + context.getResources().getDimensionPixelSize(d.e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.ayF = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.ayG = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.ayF = context.getResources().getDimensionPixelSize(d.e.ds70);
            this.ayG = context.getResources().getDimensionPixelSize(d.e.ds210);
        }
        this.kq = context.getResources().getDimensionPixelSize(d.e.ds26);
        this.ayt = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.ayu = context.getResources().getDimensionPixelSize(d.e.ds14);
        this.ayv = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.ayw = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.ayx = context.getResources().getDimensionPixelSize(d.e.ds12);
        this.ayy = context.getResources().getDimensionPixelSize(d.e.ds2);
        this.ayU.setStyle(Paint.Style.STROKE);
        this.ayU.setStrokeWidth(this.ayx);
        this.ayT = (BitmapDrawable) getResources().getDrawable(d.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        av(context);
        tu();
        this.azj[0] = aj.getColor(d.C0107d.common_color_10151);
        this.azj[1] = aj.getColor(d.C0107d.common_color_10152);
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
                measureChild(childAt, i3 - 2147483648, i4 - 2147483648);
            }
        }
        setMeasuredDimension(i3, i4);
        this.kq = ((i4 - getContext().getResources().getDimensionPixelSize(d.e.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(d.e.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.azb.getMeasuredWidth();
        int measuredHeight = this.azb.getMeasuredHeight();
        int measuredWidth2 = this.ayY.getMeasuredWidth();
        this.ayY.layout((i5 - measuredWidth2) >> 1, this.kq + i2, (measuredWidth2 + i5) >> 1, this.ayY.getMeasuredHeight() + this.kq + i2);
        int bottom = this.ayY.getBottom();
        this.azb.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.aza.getMeasuredWidth();
        int measuredHeight2 = this.aza.getMeasuredHeight();
        int top = this.azb.getTop();
        this.aza.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.ayX.getMeasuredWidth();
        int measuredHeight3 = this.ayX.getMeasuredHeight();
        int right = this.azb.getRight() - this.ayt;
        int bottom2 = this.azb.getBottom() - this.ayu;
        this.ayX.layout(this.ayF + i6, this.ayG + bottom, measuredWidth4 + i6 + this.ayF, measuredHeight3 + this.ayG + bottom);
        int measuredWidth5 = this.azc.getMeasuredWidth();
        this.azc.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.azc.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.azd.getMeasuredWidth();
        this.azd.layout((i5 - measuredWidth6) >> 1, (this.ayX.getTop() - this.azd.getMeasuredHeight()) - this.ayv, (measuredWidth6 + i5) >> 1, (this.ayX.getTop() + i2) - this.ayv);
        this.azb.getLeft();
        this.azb.getRight();
        int measuredWidth7 = this.ayZ.getMeasuredWidth();
        int measuredHeight4 = this.ayZ.getMeasuredHeight();
        int bottom3 = this.azb.getBottom();
        this.ayZ.layout((i5 - measuredWidth7) >> 1, this.ays[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.ays[3]);
        this.ayV.set((i5 - this.ayT.getIntrinsicWidth()) >> 1, this.azc.getTop() - this.ayw, (i5 + this.ayT.getIntrinsicHeight()) >> 1, (this.azc.getTop() + this.ayT.getIntrinsicHeight()) - this.ayw);
        this.ayT.setBounds(this.ayV);
        this.ayW.set(this.azc.getLeft() + (this.ayx >> 1) + this.ayy, this.azc.getTop() + (this.ayx >> 1) + this.ayy, (this.azc.getRight() - (this.ayx >> 1)) - this.ayy, (this.azc.getBottom() - (this.ayx >> 1)) - this.ayy);
        if (this.azl == null) {
            this.azl = new SweepGradient(this.ayW.centerX(), this.ayW.centerY(), this.azj, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.azl.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.ayW.centerX(), this.ayW.centerY());
            this.azl.setLocalMatrix(matrix);
            this.ayU.setShader(this.azl);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        i(canvas);
        super.dispatchDraw(canvas);
    }

    private void tg() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.axQ == null) {
            this.axQ = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.i.ak(getContext()).getPageActivity());
            this.axQ.cZ(getContext().getString(d.j.voice_restart_tip)).a(getContext().getString(d.j.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.h.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    h.this.tq();
                    if (h.this.getVoiceManager() != null && h.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.bR(h.this.mModel.voiceId);
                        }
                        h.this.mModel = null;
                    }
                }
            }).b(getContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.h.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(com.baidu.adp.base.i.ak(getContext()));
        }
        try {
            this.axQ.AA();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bR(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void av(Context context) {
        LayoutInflater.from(context).inflate(d.h.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.ayY = (TextView) findViewById(d.g.tip_error);
        aj.e(this.ayY, d.C0107d.cp_cont_i, 1);
        this.ayZ = (TextView) findViewById(d.g.tip_operator);
        this.aza = (TextView) findViewById(d.g.tip_time_out);
        this.azb = (VoiceButton) findViewById(d.g.voice_bnt);
        this.ayX = (TextView) findViewById(d.g.restart);
        this.azc = (ImageView) findViewById(d.g.play_img);
        this.azd = (TextView) findViewById(d.g.play_time);
        this.azd.setClickable(false);
        this.ayX.setOnClickListener(this);
        this.azc.setOnClickListener(this);
        this.azb.setRecorderView(this);
        tq();
    }

    private void tp() {
        this.azb.setVisibility(4);
        this.azd.setVisibility(0);
        this.ayX.setVisibility(0);
        aj.e(this.azd, d.C0107d.cp_cont_f, 1);
        aj.e(this.ayX, d.C0107d.cp_cont_f, 1);
        aj.s(this.ayX, d.f.but_posts_record_again_selector);
        this.azc.setVisibility(0);
        if (this.mModel != null) {
            this.azd.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.azc.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(this.mModel.duration)));
            aj.c(this.azc, d.f.but_posts_record_play_selector);
        }
        aj.e(this.ayZ, d.C0107d.cp_cont_c, 1);
        this.ayZ.setText(getContext().getString(d.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tq() {
        aj.c(this.azb, d.f.but_posts_record_zero_selector);
        this.azb.setVisibility(0);
        this.ayz = 0;
        this.azc.setVisibility(4);
        this.azd.setVisibility(4);
        this.ayX.setVisibility(4);
        this.aza.setVisibility(4);
        aj.e(this.ayZ, d.C0107d.cp_cont_c, 1);
        this.ayZ.setText(getContext().getString(d.j.voice_record_press_to_record));
    }

    public void reset() {
        tq();
        this.mModel = null;
        this.ayz = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.ayY.setText("");
        this.ayY.setVisibility(4);
        this.ayz = 0;
        tp();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            tq();
            this.ayZ.setText(getContext().getString(d.j.voice_record_release_to_stop));
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
        if (this.azc != null && this.azd != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    aj.e(this.azd, d.C0107d.cp_cont_f, 1);
                    this.azd.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    aj.c(this.azc, d.f.but_posts_record_play_selector);
                    this.azc.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.ayZ.setText(getContext().getString(d.j.voice_play_tip));
                    ts();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    aj.e(this.azd, d.C0107d.cp_cont_f, 1);
                    aj.c(this.azc, d.f.but_posts_record_stop_selector);
                    this.azc.setContentDescription(getContext().getString(d.j.pause_load));
                    this.ayZ.setText(getContext().getString(d.j.voice_stop_tip));
                    tr();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        aj.e(this.aza, d.C0107d.cp_cont_i, 1);
        aj.e(this.ayY, d.C0107d.cp_cont_i, 1);
        aj.e(this.ayZ, d.C0107d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.aza.setVisibility(0);
                this.aza.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.aza != null) {
                            h.this.aza.setVisibility(4);
                            h.this.aza.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.ayY.setVisibility(0);
                this.ayY.setText(str);
                this.ayZ.setText(d.j.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.ayY != null) {
                            h.this.ayY.setVisibility(4);
                            h.this.ayY.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.ayY.setVisibility(0);
                this.ayY.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.ayY != null) {
                            h.this.ayY.setVisibility(4);
                            h.this.ayY.setText("");
                        }
                    }
                }, 2000L);
            } else {
                tq();
                this.ayY.setVisibility(0);
                this.ayY.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.ayY != null) {
                            h.this.ayY.setVisibility(4);
                            h.this.ayY.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.ayY.setVisibility(4);
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
        aj.e(this.ayY, d.C0107d.cp_cont_i, 1);
        this.ayY.setVisibility(0);
        this.ayY.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.axF = Math.max(i, this.axF);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.axG > 200) {
            this.axF = 0;
            this.axG = uptimeMillis;
        }
        if (this.axF < 10) {
            this.ayz = 1;
            invalidate();
        } else if (this.axF < 20) {
            this.ayz = 2;
            invalidate();
        } else if (this.axF < 30) {
            this.ayz = 3;
            invalidate();
        } else if (this.axF < 40) {
            this.ayz = 4;
            invalidate();
        } else {
            this.ayz = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void dT(int i) {
        if (this.mModel != null && this.azd != null) {
            int i2 = i / 1000;
            if (this.azm != i2) {
                this.azd.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.azm = i2;
        }
    }

    private void tr() {
        if (this.mModel != null) {
            this.ayz = 0;
            this.aze = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.azh = SystemClock.uptimeMillis();
            this.azi = this.azh + 200;
            this.azk.sendEmptyMessageAtTime(1, this.azi);
            invalidate();
        }
    }

    private void ts() {
        this.ayz = 0;
        this.ayA = 0;
        this.aze = 0.0f;
        this.azf = 0.0f;
        this.azk.removeMessages(1);
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
            if (id == d.g.restart) {
                voiceManager.stopPlay();
                tg();
            } else if (id == d.g.play_img && this.mModel != null) {
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

    public void setCallback(g gVar) {
        this.azg = gVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void tt() {
    }

    public void tu() {
        this.ayH = new Paint();
        this.ayH.setAntiAlias(true);
        this.ayH.setStyle(Paint.Style.STROKE);
        this.ayH.setStrokeWidth(2.0f);
        this.ayI = new Paint();
        this.ayI.setAntiAlias(true);
        this.ayI.setStyle(Paint.Style.STROKE);
        this.ayI.setStrokeWidth(2.0f);
        this.ayJ = new Paint();
        this.ayJ.setAntiAlias(true);
        this.ayJ.setStyle(Paint.Style.STROKE);
        this.ayJ.setStrokeWidth(2.0f);
        this.ayK = new Paint();
        this.ayK.setAntiAlias(true);
        this.ayK.setStyle(Paint.Style.STROKE);
        this.ayK.setStrokeWidth(2.0f);
    }

    public void i(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.ayH.setColor(this.ayP);
            this.ayI.setColor(this.ayQ);
            this.ayJ.setColor(this.ayR);
            this.ayK.setColor(this.ayS);
        } else {
            this.ayH.setColor(this.ayL);
            this.ayI.setColor(this.ayM);
            this.ayJ.setColor(this.ayN);
            this.ayK.setColor(this.ayO);
        }
        if (this.ayz == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayB, this.ayH);
        } else if (this.ayz == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayB, this.ayH);
            canvas.drawCircle(this.centerX, this.centerY, this.ayC, this.ayI);
        } else if (this.ayz == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayB, this.ayH);
            canvas.drawCircle(this.centerX, this.centerY, this.ayC, this.ayI);
            canvas.drawCircle(this.centerX, this.centerY, this.ayD, this.ayJ);
        } else if (this.ayz == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayB, this.ayH);
            canvas.drawCircle(this.centerX, this.centerY, this.ayC, this.ayI);
            canvas.drawCircle(this.centerX, this.centerY, this.ayD, this.ayJ);
            canvas.drawCircle(this.centerX, this.centerY, this.ayE, this.ayK);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            if (aVar.code == 9) {
                reset();
                b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            if (aVar.code == 52) {
                if (aVar.data instanceof VoiceData.VoiceModel) {
                    tp();
                    b((VoiceData.VoiceModel) aVar.data);
                    this.mModel = (VoiceData.VoiceModel) aVar.data;
                    return;
                }
                reset();
                b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axO;
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
        if (this.axN != null) {
            this.axN.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axN = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axO = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }
}
