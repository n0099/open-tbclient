package com.baidu.live.im.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.baidu.live.adp.widget.CenterImageSpan;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends b {
    public e(Context context) {
        super(context, com.baidu.live.im.a.aPi);
    }

    @Override // com.baidu.live.im.a.b
    protected void Db() {
        if (Dc()) {
            Dd();
        } else {
            De();
        }
    }

    @Override // com.baidu.live.im.a.b
    protected int getColor() {
        return TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_other_b);
    }

    @Override // com.baidu.live.im.a.b
    protected SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar) {
        Drawable drawable;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        a m = m(aVar);
        if (m != null) {
            String str = m.shareText;
            SpannableString valueOf = SpannableString.valueOf(str);
            if (Dc()) {
                if (m.shareType != 3) {
                    valueOf.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf.length(), 33);
                } else {
                    valueOf.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf.length(), 33);
                }
            } else {
                valueOf.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) valueOf);
            String string = this.mContext.getString(a.i.sdk_share_blue_zhuan);
            if (m.shareType == 2 && str.contains(string) && (drawable = TbadkCoreApplication.getInst().getResources().getDrawable(a.f.sdk_icon_live_blue_diamond)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                CenterImageSpan centerImageSpan = new CenterImageSpan(drawable, 1);
                SpannableString spannableString = new SpannableString(" [img]");
                spannableString.setSpan(centerImageSpan, 1, spannableString.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableString);
            }
            if (m.shareType != 3) {
                a(spannableStringBuilder, aVar.DB(), cVar, false, false);
                if (Dc()) {
                    Dd();
                }
            }
            cVar.aPv.setText(spannableStringBuilder);
        }
        return spannableStringBuilder;
    }

    private a m(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
            a aVar2 = new a();
            aVar2.shareText = jSONObject.optString("share_content");
            aVar2.shareType = jSONObject.optInt("share_type", 1);
            return aVar2;
        } catch (JSONException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        public String shareText;
        public int shareType;

        private a() {
        }
    }
}
