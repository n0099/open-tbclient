package com.baidu.swan.apps.setting.oauth;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppScopeDetailActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.p;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.setting.oauth.e;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f implements com.baidu.swan.apps.adaptation.a.h {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.runtime.e cfX;
    private e cqK;
    private DialogInterface.OnClickListener csC;
    private JSONObject csD;
    private g.a csE;
    private TextView csF;
    private TextView csG;
    private TextView csH;
    protected Context mContext;
    private View mCustomView;
    private View mRootView;

    @Override // com.baidu.swan.apps.adaptation.a.h
    public g.a a(Context context, com.baidu.swan.apps.runtime.e eVar, e eVar2, JSONObject jSONObject, DialogInterface.OnClickListener onClickListener) {
        if (context == null || eVar == null || eVar2 == null) {
            return null;
        }
        this.csE = new g.a(context);
        this.mContext = context;
        this.cfX = eVar;
        this.cqK = eVar2;
        this.csD = jSONObject;
        this.csC = onClickListener;
        this.csE.ey(true);
        this.csE.ao(amA());
        this.csE.a(new com.baidu.swan.apps.view.c.a());
        this.csE.gi(a.e.aiapps_action_sheet_bg);
        this.csE.eD(false);
        this.csE.akv();
        this.csE.ez(false);
        return this.csE;
    }

    public View amA() {
        this.mRootView = View.inflate(this.mContext, a.g.swan_app_auth_dialog_content_common, null);
        amB();
        amC();
        amD();
        return this.mRootView;
    }

    public void amB() {
        Bitmap a;
        boolean z = (TextUtils.isEmpty(this.cqK.csw) || TextUtils.isEmpty(this.cqK.csx)) ? false : true;
        SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) this.mRootView.findViewById(a.f.swan_app_icon);
        if (swanAppRoundedImageView != null) {
            if (z) {
                a = ai.m(this.cqK.csx, "SwanAppAuthDialog", false);
            } else {
                a = ai.a((com.baidu.swan.apps.x.b.b) this.cfX.Ow(), "SwanAppAuthDialog", false);
            }
            swanAppRoundedImageView.setImageDrawable(new BitmapDrawable(this.mContext.getResources(), a));
            swanAppRoundedImageView.setBorderColor(this.mContext.getResources().getColor(a.c.swan_app_auth_icon_border));
        }
        ((TextView) this.mRootView.findViewById(a.f.swan_app_name)).setText(z ? this.cqK.csw : this.cfX.getName());
        this.csF = (TextView) this.mRootView.findViewById(a.f.permission_name);
        if (this.csF != null) {
            this.csF.setText(this.cqK.name);
        }
        this.csG = (TextView) this.mRootView.findViewById(a.f.auth_negative_button);
        this.csH = (TextView) this.mRootView.findViewById(a.f.auth_positive_button);
        this.csE.a(this.csG, -2, this.csC);
        this.csE.a(this.csH, -1, this.csC);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0060, code lost:
        if (r3.equals("snsapi_userinfo") != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void amC() {
        boolean z = false;
        FrameLayout frameLayout = (FrameLayout) this.mRootView.findViewById(a.f.auth_custom_layout);
        if (frameLayout != null) {
            if (d(this.cqK)) {
                this.mCustomView = View.inflate(this.mContext, a.g.swan_app_auth_scope_detail, null);
                this.cqK.amz();
                a(false, this.mCustomView, this.csH, this.cqK);
            } else {
                this.mCustomView = a(this.mContext, this.cqK, this.csD);
                String str = this.cqK.id;
                switch (str.hashCode()) {
                    case -1068855134:
                        if (str.equals("mobile")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -977063690:
                        break;
                    default:
                        z = true;
                        break;
                }
                switch (z) {
                    case false:
                        if (this.csD != null) {
                            a(this.mContext, this.mCustomView, this.csD);
                            break;
                        } else {
                            b(this.mCustomView, this.cqK);
                            break;
                        }
                    case true:
                        a(this.mCustomView, this.cqK);
                        break;
                    default:
                        b(this.mCustomView, this.cqK);
                        break;
                }
            }
            frameLayout.addView(this.mCustomView);
        }
    }

    public void amD() {
        final TextView textView;
        if (!TextUtils.isEmpty(this.cqK.css) && (textView = (TextView) this.mRootView.findViewById(a.f.permission_detail)) != null) {
            if (this.cfX != null && this.cfX.Ow() != null && TextUtils.equals(this.cfX.Ow().adB(), "11010020") && TextUtils.equals(this.cqK.id, "mobile")) {
                a(this.cqK, this.csF, this.mRootView, textView, this.csD, this.mCustomView);
                textView.setTextColor(com.baidu.swan.support.v4.a.a.getColor(this.mContext, a.c.aiapps_black));
                return;
            }
            com.baidu.swan.apps.view.b bVar = new com.baidu.swan.apps.view.b(this.mContext, a.e.swan_app_auth_question_mark_pressed);
            SpannableString spannableString = new SpannableString(" # ");
            spannableString.setSpan(bVar, 1, 2, 33);
            spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.swan.apps.setting.oauth.f.1
                @Override // android.text.style.ClickableSpan
                public void onClick(@NonNull View view) {
                    f.this.a(f.this.cqK, f.this.csF, f.this.mRootView, textView, f.this.csD, f.this.mCustomView);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setUnderlineText(false);
                }
            }, 0, spannableString.length(), 33);
            this.csF.setHighlightColor(com.baidu.swan.support.v4.a.a.getColor(this.mContext, a.c.aiapps_transparent));
            this.csF.setMovementMethod(LinkMovementMethod.getInstance());
            this.csF.setLongClickable(false);
            this.csF.append(spannableString);
        }
    }

    public boolean d(e eVar) {
        if (eVar == null) {
            return false;
        }
        return TextUtils.equals(eVar.id, "scope_multi_authorize");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, TextView textView, View view, TextView textView2, JSONObject jSONObject, View view2) {
        if (eVar != null) {
            if (eVar.css != null) {
                textView2.setText(Html.fromHtml(eVar.css));
            }
            textView.setText(eVar.name);
            ((LinearLayout) view.findViewById(a.f.permission_detail_layout)).setVisibility(0);
            if (((TextUtils.equals(eVar.id, "snsapi_userinfo") && jSONObject != null) || TextUtils.equals(eVar.id, "mobile")) && view2 != null) {
                view2.findViewById(a.f.auth_divider1).setVisibility(8);
            }
        }
    }

    private View a(Context context, e eVar, JSONObject jSONObject) {
        int i;
        if (context == null || eVar == null || TextUtils.isEmpty(eVar.id)) {
            return null;
        }
        String str = eVar.id;
        char c = 65535;
        switch (str.hashCode()) {
            case -1068855134:
                if (str.equals("mobile")) {
                    c = 1;
                    break;
                }
                break;
            case -977063690:
                if (str.equals("snsapi_userinfo")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (jSONObject != null) {
                    i = a.g.swan_app_auth_level1_userinfo_custom;
                    break;
                } else {
                    i = a.g.swan_app_auth_level2_custom;
                    break;
                }
            case 1:
                i = a.g.swan_app_auth_level1_mobile_custom;
                break;
            default:
                i = a.g.swan_app_auth_level2_custom;
                break;
        }
        return View.inflate(context, i, null);
    }

    private void a(final Context context, View view, JSONObject jSONObject) {
        if (context != null && view != null && jSONObject != null) {
            final SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) view.findViewById(a.f.user_icon);
            TextView textView = (TextView) view.findViewById(a.f.user_name);
            Pair<String, String> bc = bc(jSONObject);
            if (bc != null) {
                p.a((String) bc.second, new p.a() { // from class: com.baidu.swan.apps.setting.oauth.f.2
                    @Override // com.baidu.swan.apps.as.p.a
                    public void h(String str, Bitmap bitmap) {
                        if (bitmap == null) {
                            bitmap = BitmapFactory.decodeResource(context.getResources(), a.e.swan_app_user_portrait_pressed);
                        }
                        if (swanAppRoundedImageView != null) {
                            swanAppRoundedImageView.setImageBitmap(bitmap);
                            swanAppRoundedImageView.setBorderColor(context.getResources().getColor(a.c.swan_app_auth_icon_border));
                        }
                    }
                });
                if (textView != null) {
                    textView.setText((CharSequence) bc.first);
                }
            }
        }
    }

    protected Pair<String, String> bc(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(TableDefine.DB_TABLE_USERINFO);
        if (optJSONObject == null) {
            return null;
        }
        return new Pair<>(optJSONObject.optString("nickname"), optJSONObject.optString("headimgurl"));
    }

    private void a(View view, e eVar) {
        if (view != null && eVar != null) {
            TextView textView = (TextView) view.findViewById(a.f.user_phone_number);
            StringBuilder sb = new StringBuilder();
            for (String str : eVar.csq) {
                sb.append(str);
            }
            if (textView != null) {
                textView.setText(sb.toString());
            }
        }
    }

    private void b(View view, e eVar) {
        TextView textView;
        if (view != null && eVar != null && (textView = (TextView) view.findViewById(a.f.permission_function)) != null) {
            textView.setText(eVar.cst);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final View view, final TextView textView, final e eVar) {
        Drawable drawable;
        if (view != null && eVar != null && eVar.csu != null) {
            final e.a aVar = eVar.csu;
            TextView textView2 = (TextView) view.findViewById(a.f.auth_scope_detail);
            if (textView2 != null && !TextUtils.isEmpty(aVar.csy)) {
                if (!aVar.csy.startsWith("XXXX   ")) {
                    aVar.csy = "XXXX   " + aVar.csy;
                }
                textView2.setText(aVar.csy);
                try {
                    textView2.setTextColor(Color.parseColor(aVar.csz));
                } catch (RuntimeException e) {
                    if (DEBUG) {
                        throw e;
                    }
                }
                SpannableString spannableString = new SpannableString(textView2.getText());
                textView.setEnabled(z);
                if (z) {
                    drawable = view.getResources().getDrawable(a.e.swanapp_scope_selected);
                } else {
                    drawable = view.getResources().getDrawable(a.e.swanapp_scope_unselected);
                }
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                spannableString.setSpan(new ImageSpan(drawable) { // from class: com.baidu.swan.apps.setting.oauth.f.3
                    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
                    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
                        Drawable drawable2 = getDrawable();
                        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                        int i6 = fontMetricsInt.ascent;
                        canvas.save();
                        canvas.translate(f, ((i6 + ((fontMetricsInt.descent + i4) + i4)) / 2) - (drawable2.getBounds().bottom / 2));
                        drawable2.draw(canvas);
                        canvas.restore();
                    }
                }, 0, 4, 33);
                spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.swan.apps.setting.oauth.f.4
                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(@NonNull TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setUnderlineText(false);
                    }

                    @Override // android.text.style.ClickableSpan
                    public void onClick(@NonNull View view2) {
                        f.this.a(!textView.isEnabled(), view, textView, eVar);
                    }
                }, 0, 7, 33);
                int length = TextUtils.isEmpty(aVar.csA) ? 0 : aVar.csA.length();
                int indexOf = aVar.csy.indexOf(aVar.csA);
                int i = indexOf + length;
                try {
                    spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(aVar.csB)), indexOf, i, 33);
                } catch (RuntimeException e2) {
                    if (DEBUG) {
                        throw e2;
                    }
                }
                spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.swan.apps.setting.oauth.f.5
                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(@NonNull TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setUnderlineText(false);
                    }

                    @Override // android.text.style.ClickableSpan
                    public void onClick(@NonNull View view2) {
                        f.this.ai(view.getContext(), aVar.detailUrl);
                    }
                }, indexOf, i, 33);
                textView2.setText(spannableString);
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
                textView2.setHighlightColor(textView2.getResources().getColor(a.c.aiapps_transparent));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(Context context, String str) {
        if (context instanceof SwanAppActivity) {
            SwanAppActivity swanAppActivity = (SwanAppActivity) context;
            ActivityResultDispatcher resultDispatcher = swanAppActivity.getResultDispatcher();
            Intent intent = new Intent(context, SwanAppScopeDetailActivity.class);
            intent.putExtra("url", str);
            resultDispatcher.addConsumer(new ActivityResultConsumer() { // from class: com.baidu.swan.apps.setting.oauth.f.6
                @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
                public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent2) {
                    com.baidu.swan.apps.y.f.aeK().aem();
                    return true;
                }
            });
            com.baidu.swan.apps.y.f.aeK().ael();
            resultDispatcher.startActivityForResult(intent);
            swanAppActivity.overridePendingTransition(a.C0227a.aiapps_slide_in_from_right, a.C0227a.aiapps_hold);
        }
    }
}
