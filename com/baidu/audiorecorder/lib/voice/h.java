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
    private int axH;
    private long axI;
    private i axP;
    private int axQ;
    private com.baidu.tbadk.core.dialog.a axS;
    private final int ayA;
    private int ayB;
    private int ayC;
    private int ayD;
    private int ayE;
    private int ayF;
    private int ayG;
    private int ayH;
    private int ayI;
    private Paint ayJ;
    private Paint ayK;
    private Paint ayL;
    private Paint ayM;
    private int ayN;
    private int ayO;
    private int ayP;
    private int ayQ;
    private int ayR;
    private int ayS;
    private int ayT;
    private int ayU;
    private final BitmapDrawable ayV;
    private final Paint ayW;
    private final Rect ayX;
    private final RectF ayY;
    private TextView ayZ;
    private final int[] ayu;
    private int ayv;
    private final int ayw;
    private final int ayx;
    private final int ayy;
    private final int ayz;
    private TextView aza;
    private TextView azb;
    private TextView azc;
    private VoiceButton azd;
    private ImageView aze;
    private TextView azf;
    private float azg;
    private float azh;
    private g azi;
    private long azj;
    private long azk;
    private final int[] azl;
    private final a azm;
    private SweepGradient azn;
    private int azo;
    private int centerX;
    private int centerY;
    private int kq;
    VoiceData.VoiceModel mModel;

    static /* synthetic */ int e(h hVar) {
        int i = hVar.ayC;
        hVar.ayC = i + 1;
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
                if (h.this.azh >= 360.0f) {
                    h.this.azh = 360.0f;
                    h.this.ayC = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    h.this.azj = uptimeMillis;
                    h.this.azk = uptimeMillis + 200;
                    h.this.azh += (((float) (uptimeMillis - h.this.azj)) / 1000.0f) * h.this.azg;
                    sendEmptyMessageAtTime(1, h.this.azk);
                    h.e(h.this);
                }
                h.this.ayB = h.this.ayC % 6;
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
        this.axI = 0L;
        this.ayu = new int[4];
        this.ayB = 0;
        this.ayC = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.ayD = 0;
        this.ayE = 0;
        this.ayF = 0;
        this.ayG = 0;
        this.ayH = 0;
        this.ayI = 0;
        this.ayN = -1724676609;
        this.ayO = 1546880511;
        this.ayP = 674465279;
        this.ayQ = 255034879;
        this.ayR = -1725669966;
        this.ayS = 1545887154;
        this.ayT = 673471922;
        this.ayU = 254041522;
        this.ayW = new Paint(1);
        this.ayX = new Rect();
        this.ayY = new RectF();
        this.axQ = 0;
        this.azl = new int[2];
        this.azm = new a();
        this.axH = 0;
        this.azo = 0;
        this.ayu[0] = context.getResources().getDimensionPixelSize(d.e.ds24);
        this.ayu[1] = context.getResources().getDimensionPixelSize(d.e.ds8);
        this.ayu[2] = context.getResources().getDimensionPixelSize(d.e.ds22);
        this.ayu[3] = context.getResources().getDimensionPixelSize(d.e.ds36);
        this.ayD = context.getResources().getDimensionPixelSize(d.e.ds134);
        this.ayE = this.ayD + context.getResources().getDimensionPixelSize(d.e.ds14);
        this.ayF = this.ayE + context.getResources().getDimensionPixelSize(d.e.ds16);
        this.ayG = this.ayF + context.getResources().getDimensionPixelSize(d.e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.ayH = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.ayI = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.ayH = context.getResources().getDimensionPixelSize(d.e.ds70);
            this.ayI = context.getResources().getDimensionPixelSize(d.e.ds210);
        }
        this.kq = context.getResources().getDimensionPixelSize(d.e.ds26);
        this.ayv = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.ayw = context.getResources().getDimensionPixelSize(d.e.ds14);
        this.ayx = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.ayy = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.ayz = context.getResources().getDimensionPixelSize(d.e.ds12);
        this.ayA = context.getResources().getDimensionPixelSize(d.e.ds2);
        this.ayW.setStyle(Paint.Style.STROKE);
        this.ayW.setStrokeWidth(this.ayz);
        this.ayV = (BitmapDrawable) getResources().getDrawable(d.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        av(context);
        tu();
        this.azl[0] = aj.getColor(d.C0140d.common_color_10151);
        this.azl[1] = aj.getColor(d.C0140d.common_color_10152);
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
        int measuredWidth = this.azd.getMeasuredWidth();
        int measuredHeight = this.azd.getMeasuredHeight();
        int measuredWidth2 = this.aza.getMeasuredWidth();
        this.aza.layout((i5 - measuredWidth2) >> 1, this.kq + i2, (measuredWidth2 + i5) >> 1, this.aza.getMeasuredHeight() + this.kq + i2);
        int bottom = this.aza.getBottom();
        this.azd.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.azc.getMeasuredWidth();
        int measuredHeight2 = this.azc.getMeasuredHeight();
        int top = this.azd.getTop();
        this.azc.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.ayZ.getMeasuredWidth();
        int measuredHeight3 = this.ayZ.getMeasuredHeight();
        int right = this.azd.getRight() - this.ayv;
        int bottom2 = this.azd.getBottom() - this.ayw;
        this.ayZ.layout(this.ayH + i6, this.ayI + bottom, measuredWidth4 + i6 + this.ayH, measuredHeight3 + this.ayI + bottom);
        int measuredWidth5 = this.aze.getMeasuredWidth();
        this.aze.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.aze.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.azf.getMeasuredWidth();
        this.azf.layout((i5 - measuredWidth6) >> 1, (this.ayZ.getTop() - this.azf.getMeasuredHeight()) - this.ayx, (measuredWidth6 + i5) >> 1, (this.ayZ.getTop() + i2) - this.ayx);
        this.azd.getLeft();
        this.azd.getRight();
        int measuredWidth7 = this.azb.getMeasuredWidth();
        int measuredHeight4 = this.azb.getMeasuredHeight();
        int bottom3 = this.azd.getBottom();
        this.azb.layout((i5 - measuredWidth7) >> 1, this.ayu[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.ayu[3]);
        this.ayX.set((i5 - this.ayV.getIntrinsicWidth()) >> 1, this.aze.getTop() - this.ayy, (i5 + this.ayV.getIntrinsicHeight()) >> 1, (this.aze.getTop() + this.ayV.getIntrinsicHeight()) - this.ayy);
        this.ayV.setBounds(this.ayX);
        this.ayY.set(this.aze.getLeft() + (this.ayz >> 1) + this.ayA, this.aze.getTop() + (this.ayz >> 1) + this.ayA, (this.aze.getRight() - (this.ayz >> 1)) - this.ayA, (this.aze.getBottom() - (this.ayz >> 1)) - this.ayA);
        if (this.azn == null) {
            this.azn = new SweepGradient(this.ayY.centerX(), this.ayY.centerY(), this.azl, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.azn.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.ayY.centerX(), this.ayY.centerY());
            this.azn.setLocalMatrix(matrix);
            this.ayW.setShader(this.azn);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        i(canvas);
        super.dispatchDraw(canvas);
    }

    private void tg() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.axS == null) {
            this.axS = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.i.ak(getContext()).getPageActivity());
            this.axS.dk(getContext().getString(d.j.voice_restart_tip)).a(getContext().getString(d.j.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.h.2
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
            this.axS.AU();
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
        this.aza = (TextView) findViewById(d.g.tip_error);
        aj.e(this.aza, d.C0140d.cp_cont_i, 1);
        this.azb = (TextView) findViewById(d.g.tip_operator);
        this.azc = (TextView) findViewById(d.g.tip_time_out);
        this.azd = (VoiceButton) findViewById(d.g.voice_bnt);
        this.ayZ = (TextView) findViewById(d.g.restart);
        this.aze = (ImageView) findViewById(d.g.play_img);
        this.azf = (TextView) findViewById(d.g.play_time);
        this.azf.setClickable(false);
        this.ayZ.setOnClickListener(this);
        this.aze.setOnClickListener(this);
        this.azd.setRecorderView(this);
        tq();
    }

    private void tp() {
        this.azd.setVisibility(4);
        this.azf.setVisibility(0);
        this.ayZ.setVisibility(0);
        aj.e(this.azf, d.C0140d.cp_cont_f, 1);
        aj.e(this.ayZ, d.C0140d.cp_cont_f, 1);
        aj.s(this.ayZ, d.f.but_posts_record_again_selector);
        this.aze.setVisibility(0);
        if (this.mModel != null) {
            this.azf.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.aze.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(this.mModel.duration)));
            aj.c(this.aze, d.f.but_posts_record_play_selector);
        }
        aj.e(this.azb, d.C0140d.cp_cont_c, 1);
        this.azb.setText(getContext().getString(d.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tq() {
        aj.c(this.azd, d.f.but_posts_record_zero_selector);
        this.azd.setVisibility(0);
        this.ayB = 0;
        this.aze.setVisibility(4);
        this.azf.setVisibility(4);
        this.ayZ.setVisibility(4);
        this.azc.setVisibility(4);
        aj.e(this.azb, d.C0140d.cp_cont_c, 1);
        this.azb.setText(getContext().getString(d.j.voice_record_press_to_record));
    }

    public void reset() {
        tq();
        this.mModel = null;
        this.ayB = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.aza.setText("");
        this.aza.setVisibility(4);
        this.ayB = 0;
        tp();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            tq();
            this.azb.setText(getContext().getString(d.j.voice_record_release_to_stop));
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
        if (this.aze != null && this.azf != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    aj.e(this.azf, d.C0140d.cp_cont_f, 1);
                    this.azf.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    aj.c(this.aze, d.f.but_posts_record_play_selector);
                    this.aze.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.azb.setText(getContext().getString(d.j.voice_play_tip));
                    ts();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    aj.e(this.azf, d.C0140d.cp_cont_f, 1);
                    aj.c(this.aze, d.f.but_posts_record_stop_selector);
                    this.aze.setContentDescription(getContext().getString(d.j.pause_load));
                    this.azb.setText(getContext().getString(d.j.voice_stop_tip));
                    tr();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        aj.e(this.azc, d.C0140d.cp_cont_i, 1);
        aj.e(this.aza, d.C0140d.cp_cont_i, 1);
        aj.e(this.azb, d.C0140d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.azc.setVisibility(0);
                this.azc.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.azc != null) {
                            h.this.azc.setVisibility(4);
                            h.this.azc.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.aza.setVisibility(0);
                this.aza.setText(str);
                this.azb.setText(d.j.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.aza != null) {
                            h.this.aza.setVisibility(4);
                            h.this.aza.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.aza.setVisibility(0);
                this.aza.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.aza != null) {
                            h.this.aza.setVisibility(4);
                            h.this.aza.setText("");
                        }
                    }
                }, 2000L);
            } else {
                tq();
                this.aza.setVisibility(0);
                this.aza.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.aza != null) {
                            h.this.aza.setVisibility(4);
                            h.this.aza.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.aza.setVisibility(4);
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
        aj.e(this.aza, d.C0140d.cp_cont_i, 1);
        this.aza.setVisibility(0);
        this.aza.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.axH = Math.max(i, this.axH);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.axI > 200) {
            this.axH = 0;
            this.axI = uptimeMillis;
        }
        if (this.axH < 10) {
            this.ayB = 1;
            invalidate();
        } else if (this.axH < 20) {
            this.ayB = 2;
            invalidate();
        } else if (this.axH < 30) {
            this.ayB = 3;
            invalidate();
        } else if (this.axH < 40) {
            this.ayB = 4;
            invalidate();
        } else {
            this.ayB = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void dU(int i) {
        if (this.mModel != null && this.azf != null) {
            int i2 = i / 1000;
            if (this.azo != i2) {
                this.azf.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.azo = i2;
        }
    }

    private void tr() {
        if (this.mModel != null) {
            this.ayB = 0;
            this.azg = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.azj = SystemClock.uptimeMillis();
            this.azk = this.azj + 200;
            this.azm.sendEmptyMessageAtTime(1, this.azk);
            invalidate();
        }
    }

    private void ts() {
        this.ayB = 0;
        this.ayC = 0;
        this.azg = 0.0f;
        this.azh = 0.0f;
        this.azm.removeMessages(1);
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
        this.azi = gVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void tt() {
    }

    public void tu() {
        this.ayJ = new Paint();
        this.ayJ.setAntiAlias(true);
        this.ayJ.setStyle(Paint.Style.STROKE);
        this.ayJ.setStrokeWidth(2.0f);
        this.ayK = new Paint();
        this.ayK.setAntiAlias(true);
        this.ayK.setStyle(Paint.Style.STROKE);
        this.ayK.setStrokeWidth(2.0f);
        this.ayL = new Paint();
        this.ayL.setAntiAlias(true);
        this.ayL.setStyle(Paint.Style.STROKE);
        this.ayL.setStrokeWidth(2.0f);
        this.ayM = new Paint();
        this.ayM.setAntiAlias(true);
        this.ayM.setStyle(Paint.Style.STROKE);
        this.ayM.setStrokeWidth(2.0f);
    }

    public void i(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.ayJ.setColor(this.ayR);
            this.ayK.setColor(this.ayS);
            this.ayL.setColor(this.ayT);
            this.ayM.setColor(this.ayU);
        } else {
            this.ayJ.setColor(this.ayN);
            this.ayK.setColor(this.ayO);
            this.ayL.setColor(this.ayP);
            this.ayM.setColor(this.ayQ);
        }
        if (this.ayB == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayD, this.ayJ);
        } else if (this.ayB == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayD, this.ayJ);
            canvas.drawCircle(this.centerX, this.centerY, this.ayE, this.ayK);
        } else if (this.ayB == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayD, this.ayJ);
            canvas.drawCircle(this.centerX, this.centerY, this.ayE, this.ayK);
            canvas.drawCircle(this.centerX, this.centerY, this.ayF, this.ayL);
        } else if (this.ayB == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayD, this.ayJ);
            canvas.drawCircle(this.centerX, this.centerY, this.ayE, this.ayK);
            canvas.drawCircle(this.centerX, this.centerY, this.ayF, this.ayL);
            canvas.drawCircle(this.centerX, this.centerY, this.ayG, this.ayM);
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
        return this.axQ;
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
        if (this.axP != null) {
            this.axP.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axP = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axQ = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }
}
