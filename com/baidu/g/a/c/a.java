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
/* loaded from: classes26.dex */
public class a {
    public final int aoQ;
    public final int aoR;
    public String auC;
    protected int auH;
    protected int auI;
    protected int auJ;
    private CriusNode auK;
    public final CriusNode auL;
    public final float auM;
    private TextView auN;
    private final CriusMeasureFunction auO;
    public String auP;
    public String auQ;
    public String auR;
    public String auS;
    public String auT;
    public int auU;
    public int auV;
    public int auW;
    public String auX;
    public String auY;
    public double auZ;
    private double avA;
    private double avB;
    private double avC;
    private double avD;
    public String avE;
    public double avF;
    public double avG;
    public double avH;
    public double avI;
    public double avJ;
    public String avK;
    public String avL;
    public Typeface avM;
    public String avN;
    public String avO;
    public String avP;
    public String avQ;
    public String avR;
    public String avS;
    public String avT;
    public String avU;
    public String avV;
    public double avW;
    public String avX;
    public String avY;
    public String avZ;
    public double ava;
    private String avb;
    private String avc;
    private String avd;
    private String ave;
    private String avf;
    private String avg;
    private double avh;
    private double avi;
    private double avj;
    private double avk;
    private double avl;
    private double avm;
    private double avn;
    private double avo;
    private double avp;
    private double avq;
    private double avr;
    private double avs;
    private double avt;
    private double avu;
    private double avv;
    private double avw;
    private double avx;
    private double avy;
    private double avz;
    public String awa;
    public String awb;
    public final List<a> awc;
    public String backgroundColor;
    public String borderColor;
    public double borderRadius;
    private InterfaceC0133a businessConverter;
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
    /* loaded from: classes26.dex */
    public interface InterfaceC0133a {
        String fs(String str);
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
            if (Double.compare(aVar.zs(), 0.0d) > 0) {
                textView.setTextSize(0, (float) (aVar.zs() * textView.getContext().getResources().getDisplayMetrics().density));
            }
            textView.setIncludeFontPadding(false);
            textView.setTypeface(aVar.avM);
            textView.setGravity(aVar.gravity);
            float n = aVar.auZ > 0.0d ? n(aVar.auZ) : 0.0f;
            float f = aVar.ava > 0.0d ? (float) aVar.ava : 1.0f;
            if (n > 0.0f || f > 0.0f) {
                textView.setLineSpacing(n, f);
            }
        }
    }

    public static boolean fo(String str) {
        return Pattern.compile("[^一-龥]").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float q(float f) {
        if (Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) {
            return (1.12f * f) + 0.5f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float r(float f) {
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && fo(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void j(JSONObject jSONObject) {
        this.id = c.l(jSONObject, "id");
        this.name = c.l(jSONObject, "name");
        this.type = c.l(jSONObject, "type");
        if (zX()) {
            this.auL.setMeasureFunction(this.auO);
        }
        this.auP = c.l(jSONObject, "component");
        this.src = c.l(jSONObject, "src");
        this.poster = c.l(jSONObject, "poster");
        this.auQ = c.l(jSONObject, "href");
        this.text = c.l(jSONObject, "text");
        if ("time".equalsIgnoreCase(this.auP) && this.businessConverter != null) {
            this.text = this.businessConverter.fs(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.auZ = c.m(jSONObject, "line-space");
        this.ava = c.m(jSONObject, "line-multi");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.auR = jSONObject.optString("data-als-stat");
        this.auS = jSONObject.optString("data-url-stat");
        this.auT = jSONObject.optString("data-href-pop");
        this.auU = c.n(jSONObject, "data-share-num");
        this.auV = c.n(jSONObject, "data-reply-num");
        this.auW = c.n(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.auX = jSONObject.optString("data-share-image");
        this.auY = jSONObject.optString("data-share-link");
    }

    private void k(JSONObject jSONObject) {
        this.avb = c.l(jSONObject, "display");
        zP();
        this.avc = c.l(jSONObject, "flex-direction");
        zW();
        this.avd = c.l(jSONObject, "justify-content");
        zV();
        this.ave = c.l(jSONObject, "align-items");
        zU();
        this.avf = c.l(jSONObject, "align-self");
        zT();
        this.avg = c.l(jSONObject, "align-content");
        zS();
        this.avh = c.m(jSONObject, "flex");
        zO();
        this.avi = c.m(jSONObject, "flex-grow");
        zN();
        this.avj = c.m(jSONObject, "flex-shrink");
        zM();
        this.avk = c.m(jSONObject, "flex-basis");
        zL();
        this.position = c.l(jSONObject, "position");
        zR();
        this.avl = c.m(jSONObject, "left");
        this.avm = c.m(jSONObject, VerticalTranslateLayout.TOP);
        this.avn = c.m(jSONObject, HorizontalTranslateLayout.DIRECTION_RIGHT);
        this.avo = c.m(jSONObject, VerticalTranslateLayout.BOTTOM);
        zQ();
        this.avp = c.m(jSONObject, "margin");
        zK();
        this.avq = c.m(jSONObject, "margin-left");
        zG();
        this.avr = c.m(jSONObject, "margin-top");
        zJ();
        this.avs = c.m(jSONObject, "margin-right");
        zI();
        this.avt = c.m(jSONObject, "margin-bottom");
        zH();
        this.avu = c.m(jSONObject, "padding");
        initPadding();
        this.avv = c.m(jSONObject, "padding-left");
        zC();
        this.avw = c.m(jSONObject, "padding-top");
        zF();
        this.avx = c.m(jSONObject, "padding-right");
        zE();
        this.avy = c.m(jSONObject, "padding-bottom");
        zD();
        this.width = c.m(jSONObject, "width");
        zB();
        this.height = c.m(jSONObject, "height");
        zA();
        this.avz = c.m(jSONObject, "min-width");
        zz();
        this.avA = c.m(jSONObject, "min-height");
        zy();
        this.avB = c.m(jSONObject, "max-width");
        zv();
        this.avC = c.m(jSONObject, "max-height");
        zx();
        this.avD = c.m(jSONObject, "aspect-ratio");
        zw();
    }

    private void l(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.avY = c.l(optJSONObject, "background-image");
            this.avZ = c.l(optJSONObject, "background-color");
            this.awa = c.l(optJSONObject, "border-color");
            this.awb = c.l(optJSONObject, "color");
        }
    }

    private void m(JSONObject jSONObject) {
        this.avT = c.l(jSONObject, "background-image");
        this.avU = c.l(jSONObject, "background-color");
        this.avV = c.l(jSONObject, "border-color");
        this.avW = c.m(jSONObject, "opacity");
        this.avX = c.l(jSONObject, "color");
    }

    private void n(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.avP = c.l(optJSONObject, "background-image");
            this.avQ = c.l(optJSONObject, "background-color");
            this.avR = c.l(optJSONObject, "border-color");
            this.avS = c.l(optJSONObject, "color");
        }
    }

    private void o(JSONObject jSONObject) {
        this.avE = c.l(jSONObject, "background-image");
        this.backgroundColor = c.l(jSONObject, "background-color");
        this.borderColor = c.l(jSONObject, "border-color");
        this.opacity = c.m(jSONObject, "opacity");
        this.color = c.l(jSONObject, "color");
        this.avF = c.m(jSONObject, "border-width");
        this.borderRadius = c.m(jSONObject, "border-radius");
        this.avG = c.m(jSONObject, "border-top-left-radius");
        this.avH = c.m(jSONObject, "border-bottom-left-radius");
        this.avI = c.m(jSONObject, "border-top-right-radius");
        this.avJ = c.m(jSONObject, "border-bottom-right-radius");
        this.avK = c.l(jSONObject, "font-style");
        this.avL = c.l(jSONObject, "font-weight");
        this.avM = Typeface.create(Typeface.DEFAULT, zt());
        this.fontSize = jSONObject.optDouble("font-size", 12.0d);
        this.avN = c.l(jSONObject, "text-align");
        this.avO = c.l(jSONObject, "vertical-align");
        this.gravity = zu();
        this.auC = c.l(jSONObject, "download-style");
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0133a interfaceC0133a, boolean z) {
        this.auH = Build.VERSION.SDK_INT < 23 ? 0 : 1;
        if (Build.VERSION.SDK_INT < 23) {
        }
        this.auI = 0;
        if (Build.VERSION.SDK_INT < 26) {
        }
        this.auJ = 0;
        this.auO = new CriusMeasureFunction() { // from class: com.baidu.g.a.c.a.1
            @Override // com.baidu.crius.CriusMeasureFunction
            @SuppressLint({"WrongConstant"})
            public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
                float f3;
                boolean z2;
                Layout build;
                Layout build2;
                SpannableString spannableString = new SpannableString(a.this.text);
                a.this.a(a.this.auN, a.this);
                TextPaint paint = a.this.auN.getPaint();
                BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, paint);
                float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, paint) : Float.NaN;
                if (a.this.auZ > 0.0d) {
                    f3 = a.this.n(a.this.auZ);
                } else {
                    f3 = 0.0f;
                }
                float f4 = a.this.ava > 0.0d ? (float) a.this.ava : 1.0f;
                boolean z3 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
                if (isBoring == null && (z3 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                    int ceil = (int) Math.ceil(desiredWidth);
                    if (Build.VERSION.SDK_INT < 23) {
                        build2 = new StaticLayout(spannableString, paint, ceil, Layout.Alignment.ALIGN_NORMAL, f4, f3, false);
                    } else {
                        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, ceil).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.auH).setHyphenationFrequency(a.this.auI);
                        if (Build.VERSION.SDK_INT >= 26) {
                            hyphenationFrequency.setJustificationMode(a.this.auJ);
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
                    StaticLayout.Builder hyphenationFrequency2 = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, (int) f).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.auH).setHyphenationFrequency(a.this.auI);
                    if (Build.VERSION.SDK_INT >= 26) {
                        hyphenationFrequency2.setJustificationMode(a.this.auJ);
                    }
                    a.this.a(hyphenationFrequency2, true);
                    z2 = false;
                    build = hyphenationFrequency2.build();
                }
                if (build != null && a.this.maxLines < build.getLineCount()) {
                    return CriusMeasureOutput.make(a.this.r(build.getWidth()), a.this.q(build.getLineBottom(a.this.maxLines - 1)) - f3);
                }
                if (build != null) {
                    float r = a.this.r(build.getWidth());
                    float q = a.this.q(build.getHeight());
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
                            if (lineDescent > 0.0f && q > lineCount) {
                                q -= f3;
                            }
                        }
                    }
                    return CriusMeasureOutput.make(r, q);
                }
                return CriusMeasureOutput.make(f, f2);
            }
        };
        this.avW = -10000.0d;
        this.auL = new CriusNode();
        this.businessConverter = interfaceC0133a;
        this.auM = context.getResources().getDisplayMetrics().density;
        this.aoQ = context.getResources().getDisplayMetrics().widthPixels;
        this.aoR = context.getResources().getDisplayMetrics().heightPixels;
        this.auN = new TextView(context);
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
                this.awc = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0133a, false);
                    this.awc.add(aVar);
                    this.auL.addChildAt(aVar.auL, i);
                }
            } else {
                this.awc = null;
            }
        } else {
            this.awc = null;
        }
        if (z) {
            this.auK = new CriusNode();
            this.auK.addChildAt(this.auL, 0);
            this.auK.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    public double zs() {
        return this.fontSize;
    }

    private int zt() {
        return "italic".equalsIgnoreCase(this.avK) ? (TextUtils.isEmpty(this.avL) || "normal".equalsIgnoreCase(this.avL) || !"bold".equalsIgnoreCase(this.avL)) ? 2 : 3 : (TextUtils.isEmpty(this.avL) || "normal".equalsIgnoreCase(this.avL) || !"bold".equalsIgnoreCase(this.avL)) ? 0 : 1;
    }

    private int zu() {
        int i;
        if ("left".equalsIgnoreCase(this.avN)) {
            i = 3;
        } else if (HorizontalTranslateLayout.DIRECTION_RIGHT.equalsIgnoreCase(this.avN)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.avN)) {
            i = 1;
        } else {
            i = 0;
        }
        if (VerticalTranslateLayout.TOP.equalsIgnoreCase(this.avO)) {
            return i | 48;
        }
        if (VerticalTranslateLayout.BOTTOM.equalsIgnoreCase(this.avO)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.avO)) {
            return i | 16;
        }
        return i | 0;
    }

    private void zv() {
        if (this.avB >= 0.0d) {
            this.auL.setMaxWidth(n(this.avB));
        } else if (this.avB > -10000.0d) {
            this.auL.setMaxWidth(this.aoQ);
        }
    }

    private void zw() {
        if (this.avD > 0.0d) {
            this.auL.setAspectRatio((float) this.avD);
        }
    }

    private void zx() {
        if (this.avC >= 0.0d) {
            this.auL.setMaxHeight(n(this.avC));
        } else if (this.avC > -10000.0d) {
            this.auL.setMaxHeight(this.aoR);
        }
    }

    private void zy() {
        if (this.avA >= 0.0d) {
            this.auL.setMinHeight(n(this.avA));
        } else if (this.avA > -10000.0d) {
            this.auL.setMinHeight(this.aoR);
        }
    }

    private void zz() {
        if (this.avz >= 0.0d) {
            this.auL.setMinWidth(n(this.avz));
        } else if (this.avz > -10000.0d) {
            this.auL.setMinWidth(this.aoQ);
        }
    }

    private void zA() {
        if (this.height >= 0.0d) {
            this.auL.setHeight(n(this.height));
        } else if (this.height > -10000.0d) {
            this.auL.setHeight(this.aoR);
        }
    }

    private void zB() {
        if (this.width >= 0.0d) {
            this.auL.setWidth(n(this.width));
        } else if (this.width > -10000.0d) {
            this.auL.setWidth(this.aoQ);
        }
    }

    private void zC() {
        if (this.avv >= -1.0d) {
            this.auL.setPadding(CriusEdge.LEFT, n(this.avv));
        }
    }

    private void zD() {
        if (this.avy >= -1.0d) {
            this.auL.setPadding(CriusEdge.BOTTOM, n(this.avy));
        }
    }

    private void zE() {
        if (this.avx >= -1.0d) {
            this.auL.setPadding(CriusEdge.RIGHT, n(this.avx));
        }
    }

    private void zF() {
        if (this.avw >= -1.0d) {
            this.auL.setPadding(CriusEdge.TOP, n(this.avw));
        }
    }

    private void initPadding() {
        if (this.avu >= -1.0d) {
            this.auL.setPadding(CriusEdge.ALL, n(this.avu));
        }
    }

    private void zG() {
        if (this.avq >= -1.0d) {
            this.auL.setMargin(CriusEdge.LEFT, n(this.avq));
        }
    }

    private void zH() {
        if (this.avt >= -1.0d) {
            this.auL.setMargin(CriusEdge.BOTTOM, n(this.avt));
        }
    }

    private void zI() {
        if (this.avs >= -1.0d) {
            this.auL.setMargin(CriusEdge.RIGHT, n(this.avs));
        }
    }

    private void zJ() {
        if (this.avr >= -1.0d) {
            this.auL.setMargin(CriusEdge.TOP, n(this.avr));
        }
    }

    private void zK() {
        if (this.avp >= -1.0d) {
            this.auL.setMargin(CriusEdge.ALL, n(this.avp));
        }
    }

    private void zL() {
        if (this.avk >= -1.0d) {
            this.auL.setFlexBasis(n(this.avk));
        }
    }

    private void zM() {
        if (this.avj >= -1.0d) {
            this.auL.setFlexShrink((float) this.avj);
        }
    }

    private void zN() {
        if (this.avi >= -1.0d) {
            this.auL.setFlexGrow((float) this.avi);
        }
    }

    private void zO() {
        if (this.avh >= -1.0d) {
            this.auL.setFlex((float) this.avh);
        }
    }

    private void zP() {
        if (!TextUtils.isEmpty(this.avb)) {
            if ("flex".equalsIgnoreCase(this.avb)) {
                this.auL.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.avb)) {
                this.auL.setDisplay(CriusDisplay.NONE);
            } else {
                this.auL.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void zQ() {
        if (!c.b(this.avl, -10000.0d)) {
            this.auL.setPosition(CriusEdge.LEFT, n(this.avl));
        }
        if (!c.b(this.avm, -10000.0d)) {
            this.auL.setPosition(CriusEdge.TOP, n(this.avm));
        }
        if (!c.b(this.avn, -10000.0d)) {
            this.auL.setPosition(CriusEdge.RIGHT, n(this.avn));
        }
        if (!c.b(this.avo, -10000.0d)) {
            this.auL.setPosition(CriusEdge.BOTTOM, n(this.avo));
        }
    }

    private void zR() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.auL.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.auL.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void zS() {
        if (!TextUtils.isEmpty(this.avg)) {
            if ("flex-start".equalsIgnoreCase(this.avg)) {
                this.auL.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.avg)) {
                this.auL.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.avg)) {
                this.auL.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.avg)) {
                this.auL.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.avg)) {
                this.auL.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.avg)) {
                this.auL.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.auL.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void zT() {
        if (!TextUtils.isEmpty(this.avf)) {
            if ("auto".equalsIgnoreCase(this.avf)) {
                this.auL.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.avf)) {
                this.auL.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.avf)) {
                this.auL.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.avf)) {
                this.auL.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.avf)) {
                this.auL.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.auL.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void zU() {
        if (!TextUtils.isEmpty(this.ave)) {
            if ("flex-start".equalsIgnoreCase(this.ave)) {
                this.auL.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.ave)) {
                this.auL.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.ave)) {
                this.auL.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.ave)) {
                this.auL.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.auL.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void zV() {
        if (!TextUtils.isEmpty(this.avd)) {
            if ("flex-start".equalsIgnoreCase(this.avd)) {
                this.auL.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.avd)) {
                this.auL.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.avd)) {
                this.auL.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.avd)) {
                this.auL.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.avd)) {
                this.auL.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.auL.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void zW() {
        if (!TextUtils.isEmpty(this.avc)) {
            if ("column".equalsIgnoreCase(this.avc)) {
                this.auL.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.avc)) {
                this.auL.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.avc)) {
                this.auL.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.avc)) {
                this.auL.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.auL.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean zX() {
        return "text".equals(this.type);
    }

    public a fp(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.awc != null && this.awc.size() > 0) {
                for (a aVar : this.awc) {
                    a fp = aVar.fp(str);
                    if (fp != null) {
                        return fp;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a fq(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.auP)) {
            if (this.awc != null && this.awc.size() > 0) {
                for (a aVar : this.awc) {
                    a fq = aVar.fq(str);
                    if (fq != null) {
                        return fq;
                    }
                }
            }
            return null;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n(double d) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (this.auM * d);
    }

    public static float a(double d, float f) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (f * d);
    }

    public boolean fr(String str) {
        a fq;
        if (this.auK == null || (fq = fq(str)) == null || fq.auL == null) {
            return false;
        }
        fq.auL.setDisplay(CriusDisplay.NONE);
        fq.auL.dirty();
        this.auK.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void c(String str, float f) {
        a fp;
        if (this.auK != null && (fp = fp(str)) != null && fp.auL != null) {
            fp.fontSize = f;
            fp.auL.dirty();
            this.auK.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
