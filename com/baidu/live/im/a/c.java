package com.baidu.live.im.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.gift.v;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.view.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context) {
        super(context, com.baidu.live.im.a.aYu);
    }

    @Override // com.baidu.live.im.a.b
    protected void Jy() {
        if (Jz()) {
            JA();
        } else {
            JB();
        }
    }

    @Override // com.baidu.live.im.a.b
    protected int getColor() {
        if (Jz()) {
            return -5864;
        }
        return TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_other_b);
    }

    @Override // com.baidu.live.im.a.b
    protected SpannableStringBuilder a(com.baidu.live.im.data.a aVar, final com.baidu.live.im.c cVar) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        a(spannableStringBuilder, aVar.JK(), cVar, false, false);
        a s = s(aVar);
        String format = String.format(this.mContext.getString(a.i.ala_rec_gift), (s == null || TextUtils.isEmpty(s.giftName)) ? this.mContext.getString(a.i.sdk_gift) : s.giftName);
        SpannableString valueOf = SpannableString.valueOf(format);
        if (format != null) {
            valueOf.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) valueOf);
        if (s != null && !TextUtils.isEmpty(s.aOc)) {
            AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
            alaLiveMarkData.mark_pic = s.aOc;
            alaLiveMarkData.isWidthAutoFit = true;
            com.baidu.live.view.c cVar2 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData, false, new c.a() { // from class: com.baidu.live.im.a.c.1
                @Override // com.baidu.live.view.c.a
                public void d(Bitmap bitmap) {
                    cVar.aYK.forceLayout();
                }

                @Override // com.baidu.live.view.c.a
                public void a(com.baidu.live.view.c cVar3, Bitmap bitmap) {
                }
            });
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" [img]");
            spannableStringBuilder2.setSpan(cVar2, 1, spannableStringBuilder2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        }
        a(spannableStringBuilder, s);
        return spannableStringBuilder;
    }

    private void a(SpannableStringBuilder spannableStringBuilder, a aVar) {
        if (aVar != null) {
            String str = aVar.bbU;
            String str2 = aVar.bbV;
            if (!TextUtils.isEmpty(str)) {
                SpannableString valueOf = SpannableString.valueOf("×" + str);
                valueOf.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf);
            }
            if (this.bbK && !aVar.bbb && !TextUtils.isEmpty(str2)) {
                SpannableString valueOf2 = SpannableString.valueOf(String.format(this.mContext.getString(a.i.ala_rec_gift_charm_value), str2));
                valueOf2.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf2);
            }
            if (v.gr(aVar.giftId) && !v.gp(aVar.giftId) && v.gq(aVar.giftId)) {
                SpannableString valueOf3 = SpannableString.valueOf(this.mContext.getString(a.i.ala_dynamic_gift_downloading));
                valueOf3.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf3.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf3);
            }
            if (!aVar.bbb && aVar.bba > 0.0d) {
                com.baidu.live.im.view.a aVar2 = new com.baidu.live.im.view.a(this.mContext, aVar.bba + "倍");
                SpannableString spannableString = new SpannableString(" rate");
                spannableString.setSpan(aVar2, 1, spannableString.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableString);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0091 A[Catch: JSONException -> 0x00c0, TryCatch #0 {JSONException -> 0x00c0, blocks: (B:3:0x0003, B:5:0x000b, B:6:0x0012, B:8:0x0045, B:9:0x005f, B:12:0x0069, B:14:0x0079, B:16:0x007f, B:17:0x0089, B:19:0x0091, B:21:0x009c, B:23:0x00a4, B:30:0x00c5, B:26:0x00ba, B:25:0x00ae), top: B:32:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private a s(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        boolean z = true;
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
            a aVar2 = new a();
            aVar2.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            aVar2.bbU = aVar.JS() + "";
            if (aVar.JU() > 0) {
                aVar2.bbV = aVar.JU() + "";
            } else {
                aVar2.bbV = "";
            }
            aVar2.bbb = jSONObject.optInt("is_free") == 1;
            aVar2.bba = aVar.JT();
            com.baidu.live.gift.g go = v.go(aVar2.giftId);
            if (go != null) {
                if (go.DY()) {
                    aVar2.giftName = this.mContext.getString(a.i.sdk_text_gift_graffiti);
                    if (TextUtils.isEmpty(aVar2.giftName)) {
                        aVar2.giftName = jSONObject.optString("gift_name");
                    }
                    if (z && TextUtils.isEmpty(aVar2.aOc)) {
                        aVar2.aOc = jSONObject.optString("gift_url");
                        return aVar2;
                    }
                }
                aVar2.giftName = go.DS();
                aVar2.aOc = go.getThumbnail_url();
            }
            z = false;
            if (TextUtils.isEmpty(aVar2.giftName)) {
            }
            return z ? aVar2 : aVar2;
        } catch (JSONException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        public String aOc;
        public String bbU;
        public String bbV;
        public double bba;
        public boolean bbb;
        public String giftId;
        public String giftName;

        private a() {
        }
    }
}
