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
/* loaded from: classes20.dex */
public class a {
    public final int anE;
    public final int anF;
    public final float atA;
    private TextView atB;
    private final CriusMeasureFunction atC;
    public String atD;
    public String atE;
    public String atF;
    public String atG;
    public String atH;
    public int atI;
    public int atJ;
    public int atK;
    public String atL;
    public String atM;
    public double atN;
    public double atO;
    private String atP;
    private String atQ;
    private String atR;
    private String atS;
    private String atT;
    private String atU;
    private double atV;
    private double atW;
    private double atX;
    private double atY;
    private double atZ;
    public String atq;
    protected int atv;
    protected int atw;
    protected int atx;
    private CriusNode aty;
    public final CriusNode atz;
    public Typeface auA;
    public String auB;
    public String auC;
    public String auD;
    public String auE;
    public String auF;
    public String auG;
    public String auH;
    public String auI;
    public String auJ;
    public double auK;
    public String auL;
    public String auM;
    public String auN;
    public String auO;
    public String auP;
    public final List<a> auQ;
    private double aua;
    private double aub;
    private double auc;
    private double aud;
    private double aue;
    private double auf;
    private double aug;
    private double auh;
    private double aui;
    private double auj;
    private double auk;
    private double aul;
    private double aum;
    private double aun;
    private double auo;
    private double aup;
    private double auq;
    private double aur;
    public String aus;
    public double aut;
    public double auu;
    public double auv;
    public double auw;
    public double aux;
    public String auy;
    public String auz;
    public String backgroundColor;
    public String borderColor;
    public double borderRadius;
    private InterfaceC0128a businessConverter;
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
    /* loaded from: classes20.dex */
    public interface InterfaceC0128a {
        String fl(String str);
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
            if (Double.compare(aVar.yW(), 0.0d) > 0) {
                textView.setTextSize(0, (float) (aVar.yW() * textView.getContext().getResources().getDisplayMetrics().density));
            }
            textView.setIncludeFontPadding(false);
            textView.setTypeface(aVar.auA);
            textView.setGravity(aVar.gravity);
            float n = aVar.atN > 0.0d ? n(aVar.atN) : 0.0f;
            float f = aVar.atO > 0.0d ? (float) aVar.atO : 1.0f;
            if (n > 0.0f || f > 0.0f) {
                textView.setLineSpacing(n, f);
            }
        }
    }

    public static boolean fh(String str) {
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
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && fh(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void j(JSONObject jSONObject) {
        this.id = c.l(jSONObject, "id");
        this.name = c.l(jSONObject, "name");
        this.type = c.l(jSONObject, "type");
        if (zB()) {
            this.atz.setMeasureFunction(this.atC);
        }
        this.atD = c.l(jSONObject, "component");
        this.src = c.l(jSONObject, "src");
        this.poster = c.l(jSONObject, "poster");
        this.atE = c.l(jSONObject, "href");
        this.text = c.l(jSONObject, "text");
        if ("time".equalsIgnoreCase(this.atD) && this.businessConverter != null) {
            this.text = this.businessConverter.fl(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.atN = c.m(jSONObject, "line-space");
        this.atO = c.m(jSONObject, "line-multi");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.atF = jSONObject.optString("data-als-stat");
        this.atG = jSONObject.optString("data-url-stat");
        this.atH = jSONObject.optString("data-href-pop");
        this.atI = c.n(jSONObject, "data-share-num");
        this.atJ = c.n(jSONObject, "data-reply-num");
        this.atK = c.n(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.atL = jSONObject.optString("data-share-image");
        this.atM = jSONObject.optString("data-share-link");
    }

    private void k(JSONObject jSONObject) {
        this.atP = c.l(jSONObject, "display");
        zt();
        this.atQ = c.l(jSONObject, "flex-direction");
        zA();
        this.atR = c.l(jSONObject, "justify-content");
        zz();
        this.atS = c.l(jSONObject, "align-items");
        zy();
        this.atT = c.l(jSONObject, "align-self");
        zx();
        this.atU = c.l(jSONObject, "align-content");
        zw();
        this.atV = c.m(jSONObject, "flex");
        zs();
        this.atW = c.m(jSONObject, "flex-grow");
        zr();
        this.atX = c.m(jSONObject, "flex-shrink");
        zq();
        this.atY = c.m(jSONObject, "flex-basis");
        zp();
        this.position = c.l(jSONObject, "position");
        zv();
        this.atZ = c.m(jSONObject, "left");
        this.aua = c.m(jSONObject, VerticalTranslateLayout.TOP);
        this.aub = c.m(jSONObject, HorizontalTranslateLayout.DIRECTION_RIGHT);
        this.auc = c.m(jSONObject, VerticalTranslateLayout.BOTTOM);
        zu();
        this.aud = c.m(jSONObject, "margin");
        zo();
        this.aue = c.m(jSONObject, "margin-left");
        zk();
        this.auf = c.m(jSONObject, "margin-top");
        zn();
        this.aug = c.m(jSONObject, "margin-right");
        zm();
        this.auh = c.m(jSONObject, "margin-bottom");
        zl();
        this.aui = c.m(jSONObject, "padding");
        initPadding();
        this.auj = c.m(jSONObject, "padding-left");
        zg();
        this.auk = c.m(jSONObject, "padding-top");
        zj();
        this.aul = c.m(jSONObject, "padding-right");
        zi();
        this.aum = c.m(jSONObject, "padding-bottom");
        zh();
        this.width = c.m(jSONObject, "width");
        zf();
        this.height = c.m(jSONObject, "height");
        ze();
        this.aun = c.m(jSONObject, "min-width");
        zd();
        this.auo = c.m(jSONObject, "min-height");
        zc();
        this.aup = c.m(jSONObject, "max-width");
        yZ();
        this.auq = c.m(jSONObject, "max-height");
        zb();
        this.aur = c.m(jSONObject, "aspect-ratio");
        za();
    }

    private void l(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.auM = c.l(optJSONObject, "background-image");
            this.auN = c.l(optJSONObject, "background-color");
            this.auO = c.l(optJSONObject, "border-color");
            this.auP = c.l(optJSONObject, "color");
        }
    }

    private void m(JSONObject jSONObject) {
        this.auH = c.l(jSONObject, "background-image");
        this.auI = c.l(jSONObject, "background-color");
        this.auJ = c.l(jSONObject, "border-color");
        this.auK = c.m(jSONObject, "opacity");
        this.auL = c.l(jSONObject, "color");
    }

    private void n(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.auD = c.l(optJSONObject, "background-image");
            this.auE = c.l(optJSONObject, "background-color");
            this.auF = c.l(optJSONObject, "border-color");
            this.auG = c.l(optJSONObject, "color");
        }
    }

    private void o(JSONObject jSONObject) {
        this.aus = c.l(jSONObject, "background-image");
        this.backgroundColor = c.l(jSONObject, "background-color");
        this.borderColor = c.l(jSONObject, "border-color");
        this.opacity = c.m(jSONObject, "opacity");
        this.color = c.l(jSONObject, "color");
        this.aut = c.m(jSONObject, "border-width");
        this.borderRadius = c.m(jSONObject, "border-radius");
        this.auu = c.m(jSONObject, "border-top-left-radius");
        this.auv = c.m(jSONObject, "border-bottom-left-radius");
        this.auw = c.m(jSONObject, "border-top-right-radius");
        this.aux = c.m(jSONObject, "border-bottom-right-radius");
        this.auy = c.l(jSONObject, "font-style");
        this.auz = c.l(jSONObject, "font-weight");
        this.auA = Typeface.create(Typeface.DEFAULT, yX());
        this.fontSize = jSONObject.optDouble("font-size", 12.0d);
        this.auB = c.l(jSONObject, "text-align");
        this.auC = c.l(jSONObject, "vertical-align");
        this.gravity = yY();
        this.atq = c.l(jSONObject, "download-style");
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0128a interfaceC0128a, boolean z) {
        this.atv = Build.VERSION.SDK_INT < 23 ? 0 : 1;
        if (Build.VERSION.SDK_INT < 23) {
        }
        this.atw = 0;
        if (Build.VERSION.SDK_INT < 26) {
        }
        this.atx = 0;
        this.atC = new CriusMeasureFunction() { // from class: com.baidu.g.a.c.a.1
            @Override // com.baidu.crius.CriusMeasureFunction
            @SuppressLint({"WrongConstant"})
            public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
                float f3;
                boolean z2;
                Layout build;
                Layout build2;
                SpannableString spannableString = new SpannableString(a.this.text);
                a.this.a(a.this.atB, a.this);
                TextPaint paint = a.this.atB.getPaint();
                BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, paint);
                float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, paint) : Float.NaN;
                if (a.this.atN > 0.0d) {
                    f3 = a.this.n(a.this.atN);
                } else {
                    f3 = 0.0f;
                }
                float f4 = a.this.atO > 0.0d ? (float) a.this.atO : 1.0f;
                boolean z3 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
                if (isBoring == null && (z3 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                    int ceil = (int) Math.ceil(desiredWidth);
                    if (Build.VERSION.SDK_INT < 23) {
                        build2 = new StaticLayout(spannableString, paint, ceil, Layout.Alignment.ALIGN_NORMAL, f4, f3, false);
                    } else {
                        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, ceil).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.atv).setHyphenationFrequency(a.this.atw);
                        if (Build.VERSION.SDK_INT >= 26) {
                            hyphenationFrequency.setJustificationMode(a.this.atx);
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
                    StaticLayout.Builder hyphenationFrequency2 = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, (int) f).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.atv).setHyphenationFrequency(a.this.atw);
                    if (Build.VERSION.SDK_INT >= 26) {
                        hyphenationFrequency2.setJustificationMode(a.this.atx);
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
        this.auK = -10000.0d;
        this.atz = new CriusNode();
        this.businessConverter = interfaceC0128a;
        this.atA = context.getResources().getDisplayMetrics().density;
        this.anE = context.getResources().getDisplayMetrics().widthPixels;
        this.anF = context.getResources().getDisplayMetrics().heightPixels;
        this.atB = new TextView(context);
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
                this.auQ = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0128a, false);
                    this.auQ.add(aVar);
                    this.atz.addChildAt(aVar.atz, i);
                }
            } else {
                this.auQ = null;
            }
        } else {
            this.auQ = null;
        }
        if (z) {
            this.aty = new CriusNode();
            this.aty.addChildAt(this.atz, 0);
            this.aty.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    public double yW() {
        return this.fontSize;
    }

    private int yX() {
        return "italic".equalsIgnoreCase(this.auy) ? (TextUtils.isEmpty(this.auz) || "normal".equalsIgnoreCase(this.auz) || !"bold".equalsIgnoreCase(this.auz)) ? 2 : 3 : (TextUtils.isEmpty(this.auz) || "normal".equalsIgnoreCase(this.auz) || !"bold".equalsIgnoreCase(this.auz)) ? 0 : 1;
    }

    private int yY() {
        int i;
        if ("left".equalsIgnoreCase(this.auB)) {
            i = 3;
        } else if (HorizontalTranslateLayout.DIRECTION_RIGHT.equalsIgnoreCase(this.auB)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.auB)) {
            i = 1;
        } else {
            i = 0;
        }
        if (VerticalTranslateLayout.TOP.equalsIgnoreCase(this.auC)) {
            return i | 48;
        }
        if (VerticalTranslateLayout.BOTTOM.equalsIgnoreCase(this.auC)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.auC)) {
            return i | 16;
        }
        return i | 0;
    }

    private void yZ() {
        if (this.aup >= 0.0d) {
            this.atz.setMaxWidth(n(this.aup));
        } else if (this.aup > -10000.0d) {
            this.atz.setMaxWidth(this.anE);
        }
    }

    private void za() {
        if (this.aur > 0.0d) {
            this.atz.setAspectRatio((float) this.aur);
        }
    }

    private void zb() {
        if (this.auq >= 0.0d) {
            this.atz.setMaxHeight(n(this.auq));
        } else if (this.auq > -10000.0d) {
            this.atz.setMaxHeight(this.anF);
        }
    }

    private void zc() {
        if (this.auo >= 0.0d) {
            this.atz.setMinHeight(n(this.auo));
        } else if (this.auo > -10000.0d) {
            this.atz.setMinHeight(this.anF);
        }
    }

    private void zd() {
        if (this.aun >= 0.0d) {
            this.atz.setMinWidth(n(this.aun));
        } else if (this.aun > -10000.0d) {
            this.atz.setMinWidth(this.anE);
        }
    }

    private void ze() {
        if (this.height >= 0.0d) {
            this.atz.setHeight(n(this.height));
        } else if (this.height > -10000.0d) {
            this.atz.setHeight(this.anF);
        }
    }

    private void zf() {
        if (this.width >= 0.0d) {
            this.atz.setWidth(n(this.width));
        } else if (this.width > -10000.0d) {
            this.atz.setWidth(this.anE);
        }
    }

    private void zg() {
        if (this.auj >= -1.0d) {
            this.atz.setPadding(CriusEdge.LEFT, n(this.auj));
        }
    }

    private void zh() {
        if (this.aum >= -1.0d) {
            this.atz.setPadding(CriusEdge.BOTTOM, n(this.aum));
        }
    }

    private void zi() {
        if (this.aul >= -1.0d) {
            this.atz.setPadding(CriusEdge.RIGHT, n(this.aul));
        }
    }

    private void zj() {
        if (this.auk >= -1.0d) {
            this.atz.setPadding(CriusEdge.TOP, n(this.auk));
        }
    }

    private void initPadding() {
        if (this.aui >= -1.0d) {
            this.atz.setPadding(CriusEdge.ALL, n(this.aui));
        }
    }

    private void zk() {
        if (this.aue >= -1.0d) {
            this.atz.setMargin(CriusEdge.LEFT, n(this.aue));
        }
    }

    private void zl() {
        if (this.auh >= -1.0d) {
            this.atz.setMargin(CriusEdge.BOTTOM, n(this.auh));
        }
    }

    private void zm() {
        if (this.aug >= -1.0d) {
            this.atz.setMargin(CriusEdge.RIGHT, n(this.aug));
        }
    }

    private void zn() {
        if (this.auf >= -1.0d) {
            this.atz.setMargin(CriusEdge.TOP, n(this.auf));
        }
    }

    private void zo() {
        if (this.aud >= -1.0d) {
            this.atz.setMargin(CriusEdge.ALL, n(this.aud));
        }
    }

    private void zp() {
        if (this.atY >= -1.0d) {
            this.atz.setFlexBasis(n(this.atY));
        }
    }

    private void zq() {
        if (this.atX >= -1.0d) {
            this.atz.setFlexShrink((float) this.atX);
        }
    }

    private void zr() {
        if (this.atW >= -1.0d) {
            this.atz.setFlexGrow((float) this.atW);
        }
    }

    private void zs() {
        if (this.atV >= -1.0d) {
            this.atz.setFlex((float) this.atV);
        }
    }

    private void zt() {
        if (!TextUtils.isEmpty(this.atP)) {
            if ("flex".equalsIgnoreCase(this.atP)) {
                this.atz.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.atP)) {
                this.atz.setDisplay(CriusDisplay.NONE);
            } else {
                this.atz.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void zu() {
        if (!c.b(this.atZ, -10000.0d)) {
            this.atz.setPosition(CriusEdge.LEFT, n(this.atZ));
        }
        if (!c.b(this.aua, -10000.0d)) {
            this.atz.setPosition(CriusEdge.TOP, n(this.aua));
        }
        if (!c.b(this.aub, -10000.0d)) {
            this.atz.setPosition(CriusEdge.RIGHT, n(this.aub));
        }
        if (!c.b(this.auc, -10000.0d)) {
            this.atz.setPosition(CriusEdge.BOTTOM, n(this.auc));
        }
    }

    private void zv() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.atz.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.atz.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void zw() {
        if (!TextUtils.isEmpty(this.atU)) {
            if ("flex-start".equalsIgnoreCase(this.atU)) {
                this.atz.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.atU)) {
                this.atz.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.atU)) {
                this.atz.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.atU)) {
                this.atz.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.atU)) {
                this.atz.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.atU)) {
                this.atz.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.atz.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void zx() {
        if (!TextUtils.isEmpty(this.atT)) {
            if ("auto".equalsIgnoreCase(this.atT)) {
                this.atz.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.atT)) {
                this.atz.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.atT)) {
                this.atz.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.atT)) {
                this.atz.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.atT)) {
                this.atz.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.atz.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void zy() {
        if (!TextUtils.isEmpty(this.atS)) {
            if ("flex-start".equalsIgnoreCase(this.atS)) {
                this.atz.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.atS)) {
                this.atz.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.atS)) {
                this.atz.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.atS)) {
                this.atz.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.atz.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void zz() {
        if (!TextUtils.isEmpty(this.atR)) {
            if ("flex-start".equalsIgnoreCase(this.atR)) {
                this.atz.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.atR)) {
                this.atz.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.atR)) {
                this.atz.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.atR)) {
                this.atz.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.atR)) {
                this.atz.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.atz.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void zA() {
        if (!TextUtils.isEmpty(this.atQ)) {
            if ("column".equalsIgnoreCase(this.atQ)) {
                this.atz.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.atQ)) {
                this.atz.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.atQ)) {
                this.atz.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.atQ)) {
                this.atz.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.atz.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean zB() {
        return "text".equals(this.type);
    }

    public a fi(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.auQ != null && this.auQ.size() > 0) {
                for (a aVar : this.auQ) {
                    a fi = aVar.fi(str);
                    if (fi != null) {
                        return fi;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a fj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.atD)) {
            if (this.auQ != null && this.auQ.size() > 0) {
                for (a aVar : this.auQ) {
                    a fj = aVar.fj(str);
                    if (fj != null) {
                        return fj;
                    }
                }
            }
            return null;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n(double d) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (this.atA * d);
    }

    public static float a(double d, float f) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (f * d);
    }

    public boolean fk(String str) {
        a fj;
        if (this.aty == null || (fj = fj(str)) == null || fj.atz == null) {
            return false;
        }
        fj.atz.setDisplay(CriusDisplay.NONE);
        fj.atz.dirty();
        this.aty.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void c(String str, float f) {
        a fi;
        if (this.aty != null && (fi = fi(str)) != null && fi.atz != null) {
            fi.fontSize = f;
            fi.atz.dirty();
            this.aty.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
