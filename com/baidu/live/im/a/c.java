package com.baidu.live.im.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.gift.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.view.c;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context) {
        super(context, com.baidu.live.im.a.beB);
    }

    @Override // com.baidu.live.im.a.b
    protected void Lh() {
        if (Li()) {
            Lj();
        } else {
            Lk();
        }
    }

    @Override // com.baidu.live.im.a.b
    protected int getColor() {
        if (Li()) {
            return -5864;
        }
        return TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_other_b);
    }

    @Override // com.baidu.live.im.a.b
    protected SpannableStringBuilder a(com.baidu.live.im.data.a aVar, final com.baidu.live.im.c cVar) {
        String str;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        JSONObject jSONObject = null;
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
            str = jSONObject.optString("content_type");
        } catch (JSONException e) {
            e.printStackTrace();
            str = null;
        } catch (Exception e2) {
            e2.printStackTrace();
            str = null;
        }
        if (str != null && jSONObject != null && str.equals("pk_send_props")) {
            String optString = jSONObject.optString("pk_image_url");
            String optString2 = jSONObject.optString("props_belong_text");
            String str2 = aVar.Lt().name_show;
            String optString3 = jSONObject.optString("gift_name");
            String optString4 = jSONObject.optString("gift_url");
            String optString5 = jSONObject.optString("props_text");
            if (!TextUtils.isEmpty(optString)) {
                AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                alaLiveMarkData.mark_pic = optString;
                alaLiveMarkData.isWidthAutoFit = true;
                com.baidu.live.view.c cVar2 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData, false, new c.a() { // from class: com.baidu.live.im.a.c.1
                    @Override // com.baidu.live.view.c.a
                    public void d(Bitmap bitmap) {
                        cVar.beR.forceLayout();
                    }

                    @Override // com.baidu.live.view.c.a
                    public void a(com.baidu.live.view.c cVar3, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("[img] ");
                spannableStringBuilder2.setSpan(cVar2, 0, spannableStringBuilder2.length() - 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
            SpannableString valueOf = SpannableString.valueOf(optString2 + str2);
            if (!TextUtils.isEmpty(valueOf)) {
                valueOf.setSpan(new ForegroundColorSpan(-7479041), 0, optString2.length(), 33);
                valueOf.setSpan(new ForegroundColorSpan(-5462), optString2.length(), optString2.length() + str2.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) valueOf);
            String string = this.mContext.getString(a.i.ala_pk_props);
            SpannableString valueOf2 = SpannableString.valueOf(string + optString3);
            if (!TextUtils.isEmpty(string)) {
                valueOf2.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf2.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) valueOf2);
            if (!TextUtils.isEmpty(optString4)) {
                AlaLiveMarkData alaLiveMarkData2 = new AlaLiveMarkData();
                alaLiveMarkData2.mark_pic = optString4;
                alaLiveMarkData2.isWidthAutoFit = true;
                com.baidu.live.view.c cVar3 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData2, false, new c.a() { // from class: com.baidu.live.im.a.c.2
                    @Override // com.baidu.live.view.c.a
                    public void d(Bitmap bitmap) {
                        cVar.beR.forceLayout();
                    }

                    @Override // com.baidu.live.view.c.a
                    public void a(com.baidu.live.view.c cVar4, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder3.setSpan(cVar3, 1, spannableStringBuilder3.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
            }
            SpannableString valueOf3 = SpannableString.valueOf(Constants.ACCEPT_TIME_SEPARATOR_SP + optString5);
            if (!TextUtils.isEmpty(valueOf3)) {
                valueOf3.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf3.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) valueOf3);
        } else {
            a(spannableStringBuilder, aVar.Lt(), cVar, false, false);
            a s = s(aVar);
            String format = String.format(this.mContext.getString(a.i.ala_rec_gift), (s == null || TextUtils.isEmpty(s.giftName)) ? this.mContext.getString(a.i.sdk_gift) : s.giftName);
            SpannableString valueOf4 = SpannableString.valueOf(format);
            if (format != null) {
                valueOf4.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf4.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) valueOf4);
            if (s != null && !TextUtils.isEmpty(s.aTl)) {
                AlaLiveMarkData alaLiveMarkData3 = new AlaLiveMarkData();
                alaLiveMarkData3.mark_pic = s.aTl;
                alaLiveMarkData3.isWidthAutoFit = true;
                com.baidu.live.view.c cVar4 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData3, false, new c.a() { // from class: com.baidu.live.im.a.c.3
                    @Override // com.baidu.live.view.c.a
                    public void d(Bitmap bitmap) {
                        cVar.beR.forceLayout();
                    }

                    @Override // com.baidu.live.view.c.a
                    public void a(com.baidu.live.view.c cVar5, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder4.setSpan(cVar4, 1, spannableStringBuilder4.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder4);
            }
            a(spannableStringBuilder, s);
        }
        return spannableStringBuilder;
    }

    private void a(SpannableStringBuilder spannableStringBuilder, a aVar) {
        if (aVar != null) {
            String str = aVar.bih;
            String str2 = aVar.bii;
            if (!TextUtils.isEmpty(str)) {
                SpannableString valueOf = SpannableString.valueOf("×" + str);
                valueOf.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf);
            }
            if (this.bhV && !aVar.bhl && !TextUtils.isEmpty(str2)) {
                SpannableString valueOf2 = SpannableString.valueOf(String.format(this.mContext.getString(a.i.ala_rec_gift_charm_value), str2));
                valueOf2.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf2);
            }
            if (w.gQ(aVar.giftId) && !w.gO(aVar.giftId) && w.gP(aVar.giftId)) {
                SpannableString valueOf3 = SpannableString.valueOf(this.mContext.getString(a.i.ala_dynamic_gift_downloading));
                valueOf3.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf3.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf3);
            }
            if (!aVar.bhl && aVar.bij != 0.0d && !TextUtils.isEmpty(aVar.bik)) {
                com.baidu.live.im.view.a aVar2 = new com.baidu.live.im.view.a(this.mContext, aVar.bij + "倍" + aVar.bik, false, true, aVar.bil, aVar.bim, aVar.bin, true);
                SpannableString spannableString = new SpannableString(" raterate");
                spannableString.setSpan(aVar2, 1, spannableString.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableString);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00c7 A[Catch: JSONException -> 0x00f6, TryCatch #0 {JSONException -> 0x00f6, blocks: (B:3:0x0003, B:5:0x000b, B:6:0x0012, B:8:0x0021, B:9:0x004e, B:11:0x007b, B:12:0x0095, B:15:0x009f, B:17:0x00af, B:19:0x00b5, B:20:0x00bf, B:22:0x00c7, B:24:0x00d2, B:26:0x00da, B:33:0x00fb, B:29:0x00f0, B:28:0x00e4), top: B:35:0x0003 }] */
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
            JSONObject optJSONObject = jSONObject.optJSONObject("pk_info");
            if (optJSONObject != null) {
                aVar2.bij = optJSONObject.optDouble("pk_honer_buff_multiple");
                aVar2.bik = optJSONObject.optString("pk_honer_buff_text");
                aVar2.bil = optJSONObject.optString("pk_honer_buff_text_color_start");
                aVar2.bim = optJSONObject.optString("pk_honer_buff_text_color_end");
                aVar2.bin = optJSONObject.optString("pk_honer_buff_text_font_color");
            }
            aVar2.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            aVar2.bih = aVar.LB() + "";
            if (aVar.LD() > 0) {
                aVar2.bii = aVar.LD() + "";
            } else {
                aVar2.bii = "";
            }
            aVar2.bhl = jSONObject.optInt("is_free") == 1;
            aVar2.bhk = aVar.LC();
            com.baidu.live.gift.g gM = w.gM(aVar2.giftId);
            if (gM != null) {
                if (gM.Fk()) {
                    aVar2.giftName = this.mContext.getString(a.i.sdk_text_gift_graffiti);
                    if (TextUtils.isEmpty(aVar2.giftName)) {
                        aVar2.giftName = jSONObject.optString("gift_name");
                    }
                    if (z && TextUtils.isEmpty(aVar2.aTl)) {
                        aVar2.aTl = jSONObject.optString("gift_url");
                        return aVar2;
                    }
                }
                aVar2.giftName = gM.Fe();
                aVar2.aTl = gM.getThumbnail_url();
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
    /* loaded from: classes4.dex */
    public static class a {
        public String aTl;
        public double bhk;
        public boolean bhl;
        public String bih;
        public String bii;
        public double bij;
        public String bik;
        public String bil;
        public String bim;
        public String bin;
        public String giftId;
        public String giftName;

        private a() {
        }
    }
}
