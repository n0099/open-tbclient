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
    public final int anC;
    public final int anD;
    private final CriusMeasureFunction atA;
    public String atB;
    public String atC;
    public String atD;
    public String atE;
    public String atF;
    public int atG;
    public int atH;
    public int atI;
    public String atJ;
    public String atK;
    public double atL;
    public double atM;
    private String atN;
    private String atO;
    private String atP;
    private String atQ;
    private String atR;
    private String atS;
    private double atT;
    private double atU;
    private double atV;
    private double atW;
    private double atX;
    private double atY;
    private double atZ;
    public String ato;
    protected int att;
    protected int atu;
    protected int atv;
    private CriusNode atw;
    public final CriusNode atx;
    public final float aty;
    private TextView atz;
    public String auA;
    public String auB;
    public String auC;
    public String auD;
    public String auE;
    public String auF;
    public String auG;
    public String auH;
    public double auI;
    public String auJ;
    public String auK;
    public String auL;
    public String auM;
    public String auN;
    public final List<a> auO;
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
    public String auq;
    public double aur;
    public double aus;
    public double aut;
    public double auu;
    public double auv;
    public String auw;
    public String aux;
    public Typeface auy;
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
        String fk(String str);
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
            textView.setTypeface(aVar.auy);
            textView.setGravity(aVar.gravity);
            float n = aVar.atL > 0.0d ? n(aVar.atL) : 0.0f;
            float f = aVar.atM > 0.0d ? (float) aVar.atM : 1.0f;
            if (n > 0.0f || f > 0.0f) {
                textView.setLineSpacing(n, f);
            }
        }
    }

    public static boolean fg(String str) {
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
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && fg(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void j(JSONObject jSONObject) {
        this.id = c.l(jSONObject, "id");
        this.name = c.l(jSONObject, "name");
        this.type = c.l(jSONObject, "type");
        if (zB()) {
            this.atx.setMeasureFunction(this.atA);
        }
        this.atB = c.l(jSONObject, "component");
        this.src = c.l(jSONObject, "src");
        this.poster = c.l(jSONObject, "poster");
        this.atC = c.l(jSONObject, "href");
        this.text = c.l(jSONObject, "text");
        if ("time".equalsIgnoreCase(this.atB) && this.businessConverter != null) {
            this.text = this.businessConverter.fk(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.atL = c.m(jSONObject, "line-space");
        this.atM = c.m(jSONObject, "line-multi");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.atD = jSONObject.optString("data-als-stat");
        this.atE = jSONObject.optString("data-url-stat");
        this.atF = jSONObject.optString("data-href-pop");
        this.atG = c.n(jSONObject, "data-share-num");
        this.atH = c.n(jSONObject, "data-reply-num");
        this.atI = c.n(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.atJ = jSONObject.optString("data-share-image");
        this.atK = jSONObject.optString("data-share-link");
    }

    private void k(JSONObject jSONObject) {
        this.atN = c.l(jSONObject, "display");
        zt();
        this.atO = c.l(jSONObject, "flex-direction");
        zA();
        this.atP = c.l(jSONObject, "justify-content");
        zz();
        this.atQ = c.l(jSONObject, "align-items");
        zy();
        this.atR = c.l(jSONObject, "align-self");
        zx();
        this.atS = c.l(jSONObject, "align-content");
        zw();
        this.atT = c.m(jSONObject, "flex");
        zs();
        this.atU = c.m(jSONObject, "flex-grow");
        zr();
        this.atV = c.m(jSONObject, "flex-shrink");
        zq();
        this.atW = c.m(jSONObject, "flex-basis");
        zp();
        this.position = c.l(jSONObject, "position");
        zv();
        this.atX = c.m(jSONObject, "left");
        this.atY = c.m(jSONObject, VerticalTranslateLayout.TOP);
        this.atZ = c.m(jSONObject, HorizontalTranslateLayout.DIRECTION_RIGHT);
        this.aua = c.m(jSONObject, VerticalTranslateLayout.BOTTOM);
        zu();
        this.aub = c.m(jSONObject, "margin");
        zo();
        this.auc = c.m(jSONObject, "margin-left");
        zk();
        this.aud = c.m(jSONObject, "margin-top");
        zn();
        this.aue = c.m(jSONObject, "margin-right");
        zm();
        this.auf = c.m(jSONObject, "margin-bottom");
        zl();
        this.aug = c.m(jSONObject, "padding");
        initPadding();
        this.auh = c.m(jSONObject, "padding-left");
        zg();
        this.aui = c.m(jSONObject, "padding-top");
        zj();
        this.auj = c.m(jSONObject, "padding-right");
        zi();
        this.auk = c.m(jSONObject, "padding-bottom");
        zh();
        this.width = c.m(jSONObject, "width");
        zf();
        this.height = c.m(jSONObject, "height");
        ze();
        this.aul = c.m(jSONObject, "min-width");
        zd();
        this.aum = c.m(jSONObject, "min-height");
        zc();
        this.aun = c.m(jSONObject, "max-width");
        yZ();
        this.auo = c.m(jSONObject, "max-height");
        zb();
        this.aup = c.m(jSONObject, "aspect-ratio");
        za();
    }

    private void l(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.auK = c.l(optJSONObject, "background-image");
            this.auL = c.l(optJSONObject, "background-color");
            this.auM = c.l(optJSONObject, "border-color");
            this.auN = c.l(optJSONObject, "color");
        }
    }

    private void m(JSONObject jSONObject) {
        this.auF = c.l(jSONObject, "background-image");
        this.auG = c.l(jSONObject, "background-color");
        this.auH = c.l(jSONObject, "border-color");
        this.auI = c.m(jSONObject, "opacity");
        this.auJ = c.l(jSONObject, "color");
    }

    private void n(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.auB = c.l(optJSONObject, "background-image");
            this.auC = c.l(optJSONObject, "background-color");
            this.auD = c.l(optJSONObject, "border-color");
            this.auE = c.l(optJSONObject, "color");
        }
    }

    private void o(JSONObject jSONObject) {
        this.auq = c.l(jSONObject, "background-image");
        this.backgroundColor = c.l(jSONObject, "background-color");
        this.borderColor = c.l(jSONObject, "border-color");
        this.opacity = c.m(jSONObject, "opacity");
        this.color = c.l(jSONObject, "color");
        this.aur = c.m(jSONObject, "border-width");
        this.borderRadius = c.m(jSONObject, "border-radius");
        this.aus = c.m(jSONObject, "border-top-left-radius");
        this.aut = c.m(jSONObject, "border-bottom-left-radius");
        this.auu = c.m(jSONObject, "border-top-right-radius");
        this.auv = c.m(jSONObject, "border-bottom-right-radius");
        this.auw = c.l(jSONObject, "font-style");
        this.aux = c.l(jSONObject, "font-weight");
        this.auy = Typeface.create(Typeface.DEFAULT, yX());
        this.fontSize = jSONObject.optDouble("font-size", 12.0d);
        this.auz = c.l(jSONObject, "text-align");
        this.auA = c.l(jSONObject, "vertical-align");
        this.gravity = yY();
        this.ato = c.l(jSONObject, "download-style");
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0128a interfaceC0128a, boolean z) {
        this.att = Build.VERSION.SDK_INT < 23 ? 0 : 1;
        if (Build.VERSION.SDK_INT < 23) {
        }
        this.atu = 0;
        if (Build.VERSION.SDK_INT < 26) {
        }
        this.atv = 0;
        this.atA = new CriusMeasureFunction() { // from class: com.baidu.g.a.c.a.1
            @Override // com.baidu.crius.CriusMeasureFunction
            @SuppressLint({"WrongConstant"})
            public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
                float f3;
                boolean z2;
                Layout build;
                Layout build2;
                SpannableString spannableString = new SpannableString(a.this.text);
                a.this.a(a.this.atz, a.this);
                TextPaint paint = a.this.atz.getPaint();
                BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, paint);
                float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, paint) : Float.NaN;
                if (a.this.atL > 0.0d) {
                    f3 = a.this.n(a.this.atL);
                } else {
                    f3 = 0.0f;
                }
                float f4 = a.this.atM > 0.0d ? (float) a.this.atM : 1.0f;
                boolean z3 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
                if (isBoring == null && (z3 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                    int ceil = (int) Math.ceil(desiredWidth);
                    if (Build.VERSION.SDK_INT < 23) {
                        build2 = new StaticLayout(spannableString, paint, ceil, Layout.Alignment.ALIGN_NORMAL, f4, f3, false);
                    } else {
                        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, ceil).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.att).setHyphenationFrequency(a.this.atu);
                        if (Build.VERSION.SDK_INT >= 26) {
                            hyphenationFrequency.setJustificationMode(a.this.atv);
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
                    StaticLayout.Builder hyphenationFrequency2 = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, (int) f).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.att).setHyphenationFrequency(a.this.atu);
                    if (Build.VERSION.SDK_INT >= 26) {
                        hyphenationFrequency2.setJustificationMode(a.this.atv);
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
        this.auI = -10000.0d;
        this.atx = new CriusNode();
        this.businessConverter = interfaceC0128a;
        this.aty = context.getResources().getDisplayMetrics().density;
        this.anC = context.getResources().getDisplayMetrics().widthPixels;
        this.anD = context.getResources().getDisplayMetrics().heightPixels;
        this.atz = new TextView(context);
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
                this.auO = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0128a, false);
                    this.auO.add(aVar);
                    this.atx.addChildAt(aVar.atx, i);
                }
            } else {
                this.auO = null;
            }
        } else {
            this.auO = null;
        }
        if (z) {
            this.atw = new CriusNode();
            this.atw.addChildAt(this.atx, 0);
            this.atw.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    public double yW() {
        return this.fontSize;
    }

    private int yX() {
        return "italic".equalsIgnoreCase(this.auw) ? (TextUtils.isEmpty(this.aux) || "normal".equalsIgnoreCase(this.aux) || !"bold".equalsIgnoreCase(this.aux)) ? 2 : 3 : (TextUtils.isEmpty(this.aux) || "normal".equalsIgnoreCase(this.aux) || !"bold".equalsIgnoreCase(this.aux)) ? 0 : 1;
    }

    private int yY() {
        int i;
        if ("left".equalsIgnoreCase(this.auz)) {
            i = 3;
        } else if (HorizontalTranslateLayout.DIRECTION_RIGHT.equalsIgnoreCase(this.auz)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.auz)) {
            i = 1;
        } else {
            i = 0;
        }
        if (VerticalTranslateLayout.TOP.equalsIgnoreCase(this.auA)) {
            return i | 48;
        }
        if (VerticalTranslateLayout.BOTTOM.equalsIgnoreCase(this.auA)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.auA)) {
            return i | 16;
        }
        return i | 0;
    }

    private void yZ() {
        if (this.aun >= 0.0d) {
            this.atx.setMaxWidth(n(this.aun));
        } else if (this.aun > -10000.0d) {
            this.atx.setMaxWidth(this.anC);
        }
    }

    private void za() {
        if (this.aup > 0.0d) {
            this.atx.setAspectRatio((float) this.aup);
        }
    }

    private void zb() {
        if (this.auo >= 0.0d) {
            this.atx.setMaxHeight(n(this.auo));
        } else if (this.auo > -10000.0d) {
            this.atx.setMaxHeight(this.anD);
        }
    }

    private void zc() {
        if (this.aum >= 0.0d) {
            this.atx.setMinHeight(n(this.aum));
        } else if (this.aum > -10000.0d) {
            this.atx.setMinHeight(this.anD);
        }
    }

    private void zd() {
        if (this.aul >= 0.0d) {
            this.atx.setMinWidth(n(this.aul));
        } else if (this.aul > -10000.0d) {
            this.atx.setMinWidth(this.anC);
        }
    }

    private void ze() {
        if (this.height >= 0.0d) {
            this.atx.setHeight(n(this.height));
        } else if (this.height > -10000.0d) {
            this.atx.setHeight(this.anD);
        }
    }

    private void zf() {
        if (this.width >= 0.0d) {
            this.atx.setWidth(n(this.width));
        } else if (this.width > -10000.0d) {
            this.atx.setWidth(this.anC);
        }
    }

    private void zg() {
        if (this.auh >= -1.0d) {
            this.atx.setPadding(CriusEdge.LEFT, n(this.auh));
        }
    }

    private void zh() {
        if (this.auk >= -1.0d) {
            this.atx.setPadding(CriusEdge.BOTTOM, n(this.auk));
        }
    }

    private void zi() {
        if (this.auj >= -1.0d) {
            this.atx.setPadding(CriusEdge.RIGHT, n(this.auj));
        }
    }

    private void zj() {
        if (this.aui >= -1.0d) {
            this.atx.setPadding(CriusEdge.TOP, n(this.aui));
        }
    }

    private void initPadding() {
        if (this.aug >= -1.0d) {
            this.atx.setPadding(CriusEdge.ALL, n(this.aug));
        }
    }

    private void zk() {
        if (this.auc >= -1.0d) {
            this.atx.setMargin(CriusEdge.LEFT, n(this.auc));
        }
    }

    private void zl() {
        if (this.auf >= -1.0d) {
            this.atx.setMargin(CriusEdge.BOTTOM, n(this.auf));
        }
    }

    private void zm() {
        if (this.aue >= -1.0d) {
            this.atx.setMargin(CriusEdge.RIGHT, n(this.aue));
        }
    }

    private void zn() {
        if (this.aud >= -1.0d) {
            this.atx.setMargin(CriusEdge.TOP, n(this.aud));
        }
    }

    private void zo() {
        if (this.aub >= -1.0d) {
            this.atx.setMargin(CriusEdge.ALL, n(this.aub));
        }
    }

    private void zp() {
        if (this.atW >= -1.0d) {
            this.atx.setFlexBasis(n(this.atW));
        }
    }

    private void zq() {
        if (this.atV >= -1.0d) {
            this.atx.setFlexShrink((float) this.atV);
        }
    }

    private void zr() {
        if (this.atU >= -1.0d) {
            this.atx.setFlexGrow((float) this.atU);
        }
    }

    private void zs() {
        if (this.atT >= -1.0d) {
            this.atx.setFlex((float) this.atT);
        }
    }

    private void zt() {
        if (!TextUtils.isEmpty(this.atN)) {
            if ("flex".equalsIgnoreCase(this.atN)) {
                this.atx.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.atN)) {
                this.atx.setDisplay(CriusDisplay.NONE);
            } else {
                this.atx.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void zu() {
        if (!c.b(this.atX, -10000.0d)) {
            this.atx.setPosition(CriusEdge.LEFT, n(this.atX));
        }
        if (!c.b(this.atY, -10000.0d)) {
            this.atx.setPosition(CriusEdge.TOP, n(this.atY));
        }
        if (!c.b(this.atZ, -10000.0d)) {
            this.atx.setPosition(CriusEdge.RIGHT, n(this.atZ));
        }
        if (!c.b(this.aua, -10000.0d)) {
            this.atx.setPosition(CriusEdge.BOTTOM, n(this.aua));
        }
    }

    private void zv() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.atx.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.atx.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void zw() {
        if (!TextUtils.isEmpty(this.atS)) {
            if ("flex-start".equalsIgnoreCase(this.atS)) {
                this.atx.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.atS)) {
                this.atx.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.atS)) {
                this.atx.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.atS)) {
                this.atx.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.atS)) {
                this.atx.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.atS)) {
                this.atx.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.atx.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void zx() {
        if (!TextUtils.isEmpty(this.atR)) {
            if ("auto".equalsIgnoreCase(this.atR)) {
                this.atx.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.atR)) {
                this.atx.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.atR)) {
                this.atx.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.atR)) {
                this.atx.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.atR)) {
                this.atx.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.atx.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void zy() {
        if (!TextUtils.isEmpty(this.atQ)) {
            if ("flex-start".equalsIgnoreCase(this.atQ)) {
                this.atx.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.atQ)) {
                this.atx.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.atQ)) {
                this.atx.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.atQ)) {
                this.atx.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.atx.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void zz() {
        if (!TextUtils.isEmpty(this.atP)) {
            if ("flex-start".equalsIgnoreCase(this.atP)) {
                this.atx.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.atP)) {
                this.atx.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.atP)) {
                this.atx.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.atP)) {
                this.atx.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.atP)) {
                this.atx.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.atx.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void zA() {
        if (!TextUtils.isEmpty(this.atO)) {
            if ("column".equalsIgnoreCase(this.atO)) {
                this.atx.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.atO)) {
                this.atx.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.atO)) {
                this.atx.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.atO)) {
                this.atx.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.atx.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean zB() {
        return "text".equals(this.type);
    }

    public a fh(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.auO != null && this.auO.size() > 0) {
                for (a aVar : this.auO) {
                    a fh = aVar.fh(str);
                    if (fh != null) {
                        return fh;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a fi(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.atB)) {
            if (this.auO != null && this.auO.size() > 0) {
                for (a aVar : this.auO) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public float n(double d) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (this.aty * d);
    }

    public static float a(double d, float f) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (f * d);
    }

    public boolean fj(String str) {
        a fi;
        if (this.atw == null || (fi = fi(str)) == null || fi.atx == null) {
            return false;
        }
        fi.atx.setDisplay(CriusDisplay.NONE);
        fi.atx.dirty();
        this.atw.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void c(String str, float f) {
        a fh;
        if (this.atw != null && (fh = fh(str)) != null && fh.atx != null) {
            fh.fontSize = f;
            fh.atx.dirty();
            this.atw.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
