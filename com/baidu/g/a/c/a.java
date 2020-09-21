package com.baidu.g.a.c;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.crius.CriusAlign;
import com.baidu.crius.CriusConstants;
import com.baidu.crius.CriusDisplay;
import com.baidu.crius.CriusEdge;
import com.baidu.crius.CriusFlexDirection;
import com.baidu.crius.CriusJustify;
import com.baidu.crius.CriusMeasureFunction;
import com.baidu.crius.CriusMeasureMode;
import com.baidu.crius.CriusMeasureOutput;
import com.baidu.crius.CriusNode;
import com.baidu.crius.CriusPositionType;
import com.baidu.g.a.e.c;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
@TargetApi(23)
/* loaded from: classes25.dex */
public class a {
    public final int aog;
    public final int aoh;
    public String atS;
    protected int atX;
    protected int atY;
    protected int atZ;
    private double auA;
    private double auB;
    private double auC;
    private double auD;
    private double auE;
    private double auF;
    private double auG;
    private double auH;
    private double auI;
    private double auJ;
    private double auK;
    private double auL;
    private double auM;
    private double auN;
    private double auO;
    private double auP;
    private double auQ;
    private double auR;
    private double auS;
    private double auT;
    public String auU;
    public double auV;
    public double auW;
    public double auX;
    public double auY;
    public double auZ;
    private CriusNode aua;
    public final CriusNode aub;
    public final float auc;
    private TextView aud;
    private final CriusMeasureFunction aue;
    public String auf;
    public String aug;
    public String auh;
    public String aui;
    public String auj;
    public int auk;
    public int aul;
    public int aum;
    public String aun;
    public String auo;
    public double aup;
    public double auq;
    private String aur;
    private String aus;
    private String aut;
    private String auu;
    private String auv;
    private String auw;
    private double aux;
    private double auy;
    private double auz;
    public String ava;
    public String avb;
    public Typeface avc;
    public String avd;
    public String ave;
    public String avf;
    public String avg;
    public String avh;
    public String avi;
    public String avj;
    public String avk;
    public String avl;
    public double avm;
    public String avn;
    public String avo;
    public String avp;
    public String avq;
    public String avr;
    public final List<a> avs;
    public String backgroundColor;
    public String borderColor;
    public double borderRadius;
    private InterfaceC0129a businessConverter;
    public String color;
    public double fontSize;
    public int gravity;
    private double height;
    public String id;
    public int maxLines;
    public String name;
    public double opacity;
    private String position;
    public String poster;
    public String shareContent;
    public String shareTitle;
    public String src;
    public String text;
    public String type;
    public int videoDuration;
    private double width;

    /* renamed from: com.baidu.g.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0129a {
        String fn(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"PrivateApi"})
    public void a(@NonNull StaticLayout.Builder builder, boolean z) {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                Method declaredMethod = builder.getClass().getDeclaredMethod("setUseLineSpacingFromFallbacks", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(builder, Boolean.valueOf(z));
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, a aVar) {
        if (!TextUtils.isEmpty(aVar.text)) {
            if (aVar.maxLines > 0) {
                if (aVar.maxLines == 1) {
                    textView.setSingleLine(true);
                } else {
                    textView.setSingleLine(false);
                }
                textView.setMaxLines(aVar.maxLines);
            }
            textView.setEllipsize(TextUtils.TruncateAt.END);
            if (Double.compare(aVar.zk(), 0.0d) > 0) {
                textView.setTextSize(0, (float) (aVar.zk() * textView.getContext().getResources().getDisplayMetrics().density));
            }
            textView.setIncludeFontPadding(false);
            textView.setTypeface(aVar.avc);
            textView.setGravity(aVar.gravity);
            float n = aVar.aup > 0.0d ? n(aVar.aup) : 0.0f;
            float f = aVar.auq > 0.0d ? (float) aVar.auq : 1.0f;
            if (n > 0.0f || f > 0.0f) {
                textView.setLineSpacing(n, f);
            }
        }
    }

    public static boolean fj(String str) {
        return Pattern.compile("[^一-龥]").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float p(float f) {
        if (Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) {
            return (1.12f * f) + 0.5f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float q(float f) {
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && fj(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void j(JSONObject jSONObject) {
        this.id = c.l(jSONObject, "id");
        this.name = c.l(jSONObject, "name");
        this.type = c.l(jSONObject, "type");
        if (zP()) {
            this.aub.setMeasureFunction(this.aue);
        }
        this.auf = c.l(jSONObject, "component");
        this.src = c.l(jSONObject, "src");
        this.poster = c.l(jSONObject, "poster");
        this.aug = c.l(jSONObject, "href");
        this.text = c.l(jSONObject, "text");
        if ("time".equalsIgnoreCase(this.auf) && this.businessConverter != null) {
            this.text = this.businessConverter.fn(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.aup = c.m(jSONObject, "line-space");
        this.auq = c.m(jSONObject, "line-multi");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.auh = jSONObject.optString("data-als-stat");
        this.aui = jSONObject.optString("data-url-stat");
        this.auj = jSONObject.optString("data-href-pop");
        this.auk = c.n(jSONObject, "data-share-num");
        this.aul = c.n(jSONObject, "data-reply-num");
        this.aum = c.n(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.aun = jSONObject.optString("data-share-image");
        this.auo = jSONObject.optString("data-share-link");
    }

    private void k(JSONObject jSONObject) {
        this.aur = c.l(jSONObject, "display");
        zH();
        this.aus = c.l(jSONObject, "flex-direction");
        zO();
        this.aut = c.l(jSONObject, "justify-content");
        zN();
        this.auu = c.l(jSONObject, "align-items");
        zM();
        this.auv = c.l(jSONObject, "align-self");
        zL();
        this.auw = c.l(jSONObject, "align-content");
        zK();
        this.aux = c.m(jSONObject, "flex");
        zG();
        this.auy = c.m(jSONObject, "flex-grow");
        zF();
        this.auz = c.m(jSONObject, "flex-shrink");
        zE();
        this.auA = c.m(jSONObject, "flex-basis");
        zD();
        this.position = c.l(jSONObject, "position");
        zJ();
        this.auB = c.m(jSONObject, "left");
        this.auC = c.m(jSONObject, VerticalTranslateLayout.TOP);
        this.auD = c.m(jSONObject, HorizontalTranslateLayout.DIRECTION_RIGHT);
        this.auE = c.m(jSONObject, VerticalTranslateLayout.BOTTOM);
        zI();
        this.auF = c.m(jSONObject, "margin");
        zC();
        this.auG = c.m(jSONObject, "margin-left");
        zy();
        this.auH = c.m(jSONObject, "margin-top");
        zB();
        this.auI = c.m(jSONObject, "margin-right");
        zA();
        this.auJ = c.m(jSONObject, "margin-bottom");
        zz();
        this.auK = c.m(jSONObject, "padding");
        initPadding();
        this.auL = c.m(jSONObject, "padding-left");
        zu();
        this.auM = c.m(jSONObject, "padding-top");
        zx();
        this.auN = c.m(jSONObject, "padding-right");
        zw();
        this.auO = c.m(jSONObject, "padding-bottom");
        zv();
        this.width = c.m(jSONObject, "width");
        zt();
        this.height = c.m(jSONObject, "height");
        zs();
        this.auP = c.m(jSONObject, "min-width");
        zr();
        this.auQ = c.m(jSONObject, "min-height");
        zq();
        this.auR = c.m(jSONObject, "max-width");
        zn();
        this.auS = c.m(jSONObject, "max-height");
        zp();
        this.auT = c.m(jSONObject, "aspect-ratio");
        zo();
    }

    private void l(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.avo = c.l(optJSONObject, "background-image");
            this.avp = c.l(optJSONObject, "background-color");
            this.avq = c.l(optJSONObject, "border-color");
            this.avr = c.l(optJSONObject, "color");
        }
    }

    private void m(JSONObject jSONObject) {
        this.avj = c.l(jSONObject, "background-image");
        this.avk = c.l(jSONObject, "background-color");
        this.avl = c.l(jSONObject, "border-color");
        this.avm = c.m(jSONObject, "opacity");
        this.avn = c.l(jSONObject, "color");
    }

    private void n(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.avf = c.l(optJSONObject, "background-image");
            this.avg = c.l(optJSONObject, "background-color");
            this.avh = c.l(optJSONObject, "border-color");
            this.avi = c.l(optJSONObject, "color");
        }
    }

    private void o(JSONObject jSONObject) {
        this.auU = c.l(jSONObject, "background-image");
        this.backgroundColor = c.l(jSONObject, "background-color");
        this.borderColor = c.l(jSONObject, "border-color");
        this.opacity = c.m(jSONObject, "opacity");
        this.color = c.l(jSONObject, "color");
        this.auV = c.m(jSONObject, "border-width");
        this.borderRadius = c.m(jSONObject, "border-radius");
        this.auW = c.m(jSONObject, "border-top-left-radius");
        this.auX = c.m(jSONObject, "border-bottom-left-radius");
        this.auY = c.m(jSONObject, "border-top-right-radius");
        this.auZ = c.m(jSONObject, "border-bottom-right-radius");
        this.ava = c.l(jSONObject, "font-style");
        this.avb = c.l(jSONObject, "font-weight");
        this.avc = Typeface.create(Typeface.DEFAULT, zl());
        this.fontSize = jSONObject.optDouble("font-size", 12.0d);
        this.avd = c.l(jSONObject, "text-align");
        this.ave = c.l(jSONObject, "vertical-align");
        this.gravity = zm();
        this.atS = c.l(jSONObject, "download-style");
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0129a interfaceC0129a, boolean z) {
        this.atX = Build.VERSION.SDK_INT < 23 ? 0 : 1;
        if (Build.VERSION.SDK_INT < 23) {
        }
        this.atY = 0;
        if (Build.VERSION.SDK_INT < 26) {
        }
        this.atZ = 0;
        this.aue = new CriusMeasureFunction() { // from class: com.baidu.g.a.c.a.1
            @Override // com.baidu.crius.CriusMeasureFunction
            @SuppressLint({"WrongConstant"})
            public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
                float f3;
                boolean z2;
                Layout build;
                Layout build2;
                SpannableString spannableString = new SpannableString(a.this.text);
                a.this.a(a.this.aud, a.this);
                TextPaint paint = a.this.aud.getPaint();
                BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, paint);
                float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, paint) : Float.NaN;
                if (a.this.aup > 0.0d) {
                    f3 = a.this.n(a.this.aup);
                } else {
                    f3 = 0.0f;
                }
                float f4 = a.this.auq > 0.0d ? (float) a.this.auq : 1.0f;
                boolean z3 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
                if (isBoring == null && (z3 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                    int ceil = (int) Math.ceil(desiredWidth);
                    if (Build.VERSION.SDK_INT < 23) {
                        build2 = new StaticLayout(spannableString, paint, ceil, Layout.Alignment.ALIGN_NORMAL, f4, f3, false);
                    } else {
                        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, ceil).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.atX).setHyphenationFrequency(a.this.atY);
                        if (Build.VERSION.SDK_INT >= 26) {
                            hyphenationFrequency.setJustificationMode(a.this.atZ);
                        }
                        a.this.a(hyphenationFrequency, true);
                        build2 = hyphenationFrequency.build();
                    }
                    z2 = false;
                    build = build2;
                } else if (isBoring != null && (z3 || isBoring.width <= f)) {
                    build = BoringLayout.make(spannableString, paint, isBoring.width, Layout.Alignment.ALIGN_NORMAL, f4, f3, isBoring, false);
                    z2 = true;
                } else if (Build.VERSION.SDK_INT < 23) {
                    Layout staticLayout = new StaticLayout(spannableString, paint, (int) f, Layout.Alignment.ALIGN_NORMAL, f4, f3, false);
                    z2 = false;
                    build = staticLayout;
                } else {
                    StaticLayout.Builder hyphenationFrequency2 = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, (int) f).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.atX).setHyphenationFrequency(a.this.atY);
                    if (Build.VERSION.SDK_INT >= 26) {
                        hyphenationFrequency2.setJustificationMode(a.this.atZ);
                    }
                    a.this.a(hyphenationFrequency2, true);
                    z2 = false;
                    build = hyphenationFrequency2.build();
                }
                if (build != null && a.this.maxLines < build.getLineCount()) {
                    return CriusMeasureOutput.make(a.this.q(build.getWidth()), a.this.p(build.getLineBottom(a.this.maxLines - 1)) - f3);
                }
                if (build != null) {
                    float q = a.this.q(build.getWidth());
                    float p = a.this.p(build.getHeight());
                    if (!z2) {
                        boolean z4 = false;
                        if (TbadkCoreApplication.getInst().isMIUIRom()) {
                            if (Build.VERSION.SDK_INT < 23) {
                                z4 = true;
                            }
                        } else {
                            z4 = true;
                        }
                        if (z4) {
                            float lineDescent = (build.getLineDescent(0) - build.getLineAscent(0)) - f3;
                            float lineCount = ((build.getLineCount() - 1) * f3) + (build.getLineCount() * lineDescent);
                            if (lineDescent > 0.0f && p > lineCount) {
                                p -= f3;
                            }
                        }
                    }
                    return CriusMeasureOutput.make(q, p);
                }
                return CriusMeasureOutput.make(f, f2);
            }
        };
        this.avm = -10000.0d;
        this.aub = new CriusNode();
        this.businessConverter = interfaceC0129a;
        this.auc = context.getResources().getDisplayMetrics().density;
        this.aog = context.getResources().getDisplayMetrics().widthPixels;
        this.aoh = context.getResources().getDisplayMetrics().heightPixels;
        this.aud = new TextView(context);
        j(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject != null) {
            k(optJSONObject);
            o(optJSONObject);
            n(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("night-style");
        if (optJSONObject2 != null) {
            m(optJSONObject2);
            l(optJSONObject2);
        }
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.avs = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0129a, false);
                    this.avs.add(aVar);
                    this.aub.addChildAt(aVar.aub, i);
                }
            } else {
                this.avs = null;
            }
        } else {
            this.avs = null;
        }
        if (z) {
            this.aua = new CriusNode();
            this.aua.addChildAt(this.aub, 0);
            this.aua.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    public double zk() {
        return this.fontSize;
    }

    private int zl() {
        return "italic".equalsIgnoreCase(this.ava) ? (TextUtils.isEmpty(this.avb) || "normal".equalsIgnoreCase(this.avb) || !"bold".equalsIgnoreCase(this.avb)) ? 2 : 3 : (TextUtils.isEmpty(this.avb) || "normal".equalsIgnoreCase(this.avb) || !"bold".equalsIgnoreCase(this.avb)) ? 0 : 1;
    }

    private int zm() {
        int i;
        if ("left".equalsIgnoreCase(this.avd)) {
            i = 3;
        } else if (HorizontalTranslateLayout.DIRECTION_RIGHT.equalsIgnoreCase(this.avd)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.avd)) {
            i = 1;
        } else {
            i = 0;
        }
        if (VerticalTranslateLayout.TOP.equalsIgnoreCase(this.ave)) {
            return i | 48;
        }
        if (VerticalTranslateLayout.BOTTOM.equalsIgnoreCase(this.ave)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.ave)) {
            return i | 16;
        }
        return i | 0;
    }

    private void zn() {
        if (this.auR >= 0.0d) {
            this.aub.setMaxWidth(n(this.auR));
        } else if (this.auR > -10000.0d) {
            this.aub.setMaxWidth(this.aog);
        }
    }

    private void zo() {
        if (this.auT > 0.0d) {
            this.aub.setAspectRatio((float) this.auT);
        }
    }

    private void zp() {
        if (this.auS >= 0.0d) {
            this.aub.setMaxHeight(n(this.auS));
        } else if (this.auS > -10000.0d) {
            this.aub.setMaxHeight(this.aoh);
        }
    }

    private void zq() {
        if (this.auQ >= 0.0d) {
            this.aub.setMinHeight(n(this.auQ));
        } else if (this.auQ > -10000.0d) {
            this.aub.setMinHeight(this.aoh);
        }
    }

    private void zr() {
        if (this.auP >= 0.0d) {
            this.aub.setMinWidth(n(this.auP));
        } else if (this.auP > -10000.0d) {
            this.aub.setMinWidth(this.aog);
        }
    }

    private void zs() {
        if (this.height >= 0.0d) {
            this.aub.setHeight(n(this.height));
        } else if (this.height > -10000.0d) {
            this.aub.setHeight(this.aoh);
        }
    }

    private void zt() {
        if (this.width >= 0.0d) {
            this.aub.setWidth(n(this.width));
        } else if (this.width > -10000.0d) {
            this.aub.setWidth(this.aog);
        }
    }

    private void zu() {
        if (this.auL >= -1.0d) {
            this.aub.setPadding(CriusEdge.LEFT, n(this.auL));
        }
    }

    private void zv() {
        if (this.auO >= -1.0d) {
            this.aub.setPadding(CriusEdge.BOTTOM, n(this.auO));
        }
    }

    private void zw() {
        if (this.auN >= -1.0d) {
            this.aub.setPadding(CriusEdge.RIGHT, n(this.auN));
        }
    }

    private void zx() {
        if (this.auM >= -1.0d) {
            this.aub.setPadding(CriusEdge.TOP, n(this.auM));
        }
    }

    private void initPadding() {
        if (this.auK >= -1.0d) {
            this.aub.setPadding(CriusEdge.ALL, n(this.auK));
        }
    }

    private void zy() {
        if (this.auG >= -1.0d) {
            this.aub.setMargin(CriusEdge.LEFT, n(this.auG));
        }
    }

    private void zz() {
        if (this.auJ >= -1.0d) {
            this.aub.setMargin(CriusEdge.BOTTOM, n(this.auJ));
        }
    }

    private void zA() {
        if (this.auI >= -1.0d) {
            this.aub.setMargin(CriusEdge.RIGHT, n(this.auI));
        }
    }

    private void zB() {
        if (this.auH >= -1.0d) {
            this.aub.setMargin(CriusEdge.TOP, n(this.auH));
        }
    }

    private void zC() {
        if (this.auF >= -1.0d) {
            this.aub.setMargin(CriusEdge.ALL, n(this.auF));
        }
    }

    private void zD() {
        if (this.auA >= -1.0d) {
            this.aub.setFlexBasis(n(this.auA));
        }
    }

    private void zE() {
        if (this.auz >= -1.0d) {
            this.aub.setFlexShrink((float) this.auz);
        }
    }

    private void zF() {
        if (this.auy >= -1.0d) {
            this.aub.setFlexGrow((float) this.auy);
        }
    }

    private void zG() {
        if (this.aux >= -1.0d) {
            this.aub.setFlex((float) this.aux);
        }
    }

    private void zH() {
        if (!TextUtils.isEmpty(this.aur)) {
            if ("flex".equalsIgnoreCase(this.aur)) {
                this.aub.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.aur)) {
                this.aub.setDisplay(CriusDisplay.NONE);
            } else {
                this.aub.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void zI() {
        if (!c.b(this.auB, -10000.0d)) {
            this.aub.setPosition(CriusEdge.LEFT, n(this.auB));
        }
        if (!c.b(this.auC, -10000.0d)) {
            this.aub.setPosition(CriusEdge.TOP, n(this.auC));
        }
        if (!c.b(this.auD, -10000.0d)) {
            this.aub.setPosition(CriusEdge.RIGHT, n(this.auD));
        }
        if (!c.b(this.auE, -10000.0d)) {
            this.aub.setPosition(CriusEdge.BOTTOM, n(this.auE));
        }
    }

    private void zJ() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.aub.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.aub.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void zK() {
        if (!TextUtils.isEmpty(this.auw)) {
            if ("flex-start".equalsIgnoreCase(this.auw)) {
                this.aub.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.auw)) {
                this.aub.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.auw)) {
                this.aub.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.auw)) {
                this.aub.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.auw)) {
                this.aub.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.auw)) {
                this.aub.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.aub.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void zL() {
        if (!TextUtils.isEmpty(this.auv)) {
            if ("auto".equalsIgnoreCase(this.auv)) {
                this.aub.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.auv)) {
                this.aub.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.auv)) {
                this.aub.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.auv)) {
                this.aub.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.auv)) {
                this.aub.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.aub.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void zM() {
        if (!TextUtils.isEmpty(this.auu)) {
            if ("flex-start".equalsIgnoreCase(this.auu)) {
                this.aub.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.auu)) {
                this.aub.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.auu)) {
                this.aub.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.auu)) {
                this.aub.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.aub.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void zN() {
        if (!TextUtils.isEmpty(this.aut)) {
            if ("flex-start".equalsIgnoreCase(this.aut)) {
                this.aub.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.aut)) {
                this.aub.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.aut)) {
                this.aub.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.aut)) {
                this.aub.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.aut)) {
                this.aub.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.aub.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void zO() {
        if (!TextUtils.isEmpty(this.aus)) {
            if ("column".equalsIgnoreCase(this.aus)) {
                this.aub.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.aus)) {
                this.aub.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.aus)) {
                this.aub.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.aus)) {
                this.aub.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.aub.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean zP() {
        return "text".equals(this.type);
    }

    public a fk(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.avs != null && this.avs.size() > 0) {
                for (a aVar : this.avs) {
                    a fk = aVar.fk(str);
                    if (fk != null) {
                        return fk;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a fl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.auf)) {
            if (this.avs != null && this.avs.size() > 0) {
                for (a aVar : this.avs) {
                    a fl = aVar.fl(str);
                    if (fl != null) {
                        return fl;
                    }
                }
            }
            return null;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n(double d) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (this.auc * d);
    }

    public static float a(double d, float f) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (f * d);
    }

    public boolean fm(String str) {
        a fl;
        if (this.aua == null || (fl = fl(str)) == null || fl.aub == null) {
            return false;
        }
        fl.aub.setDisplay(CriusDisplay.NONE);
        fl.aub.dirty();
        this.aua.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void c(String str, float f) {
        a fk;
        if (this.aua != null && (fk = fk(str)) != null && fk.aub != null) {
            fk.fontSize = f;
            fk.aub.dirty();
            this.aua.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
