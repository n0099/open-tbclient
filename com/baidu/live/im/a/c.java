package com.baidu.live.im.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.gift.ac;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.utils.l;
import com.baidu.live.view.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.live.im.a.b {
    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context) {
        super(context, com.baidu.live.im.a.blt);
    }

    @Override // com.baidu.live.im.a.b
    protected void MW() {
        if (MX()) {
            MY();
        } else {
            MZ();
        }
    }

    @Override // com.baidu.live.im.a.b
    protected int getColor() {
        if (MX()) {
            return -5864;
        }
        return TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_other_b);
    }

    @Override // com.baidu.live.im.a.b
    protected SpannableStringBuilder b(com.baidu.live.im.data.b bVar, final com.baidu.live.im.c cVar) {
        String str;
        JSONObject jSONObject;
        String optString;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        JSONObject jSONObject2 = null;
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject2 = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject2 = new JSONObject(bVar.getContent());
            }
            str = jSONObject2.optString("content_type");
            jSONObject = jSONObject2;
        } catch (JSONException e) {
            e.printStackTrace();
            str = null;
            jSONObject = jSONObject2;
        } catch (Exception e2) {
            e2.printStackTrace();
            str = null;
            jSONObject = jSONObject2;
        }
        if (str != null && jSONObject != null && str.equals("pk_send_props")) {
            String optString2 = jSONObject.optString("pk_image_url");
            String optString3 = jSONObject.optString("props_belong_text");
            String str2 = bVar.Nw().name_show;
            String optString4 = jSONObject.optString("gift_name");
            String optString5 = jSONObject.optString("gift_url");
            String optString6 = jSONObject.optString("props_text");
            if (!TextUtils.isEmpty(optString2)) {
                AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                alaLiveMarkData.mark_pic = optString2;
                alaLiveMarkData.isWidthAutoFit = true;
                com.baidu.live.view.b bVar2 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, false, new b.a() { // from class: com.baidu.live.im.a.c.1
                    @Override // com.baidu.live.view.b.a
                    public void e(Bitmap bitmap) {
                        cVar.blJ.forceLayout();
                    }

                    @Override // com.baidu.live.view.b.a
                    public void a(com.baidu.live.view.b bVar3, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("[img] ");
                spannableStringBuilder2.setSpan(bVar2, 0, spannableStringBuilder2.length() - 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
            SpannableString valueOf = SpannableString.valueOf(optString3 + str2);
            if (!TextUtils.isEmpty(valueOf)) {
                valueOf.setSpan(new ForegroundColorSpan(-7479041), 0, optString3.length(), 33);
                valueOf.setSpan(new ForegroundColorSpan(-5462), optString3.length(), optString3.length() + str2.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) valueOf);
            String string = this.mContext.getString(a.h.ala_pk_props);
            SpannableString valueOf2 = SpannableString.valueOf(string + optString4);
            if (!TextUtils.isEmpty(string)) {
                valueOf2.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf2.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) valueOf2);
            if (!TextUtils.isEmpty(optString5)) {
                AlaLiveMarkData alaLiveMarkData2 = new AlaLiveMarkData();
                alaLiveMarkData2.mark_pic = optString5;
                alaLiveMarkData2.isWidthAutoFit = true;
                com.baidu.live.view.b bVar3 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData2, false, new b.a() { // from class: com.baidu.live.im.a.c.2
                    @Override // com.baidu.live.view.b.a
                    public void e(Bitmap bitmap) {
                        cVar.blJ.forceLayout();
                    }

                    @Override // com.baidu.live.view.b.a
                    public void a(com.baidu.live.view.b bVar4, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder3.setSpan(bVar3, 1, spannableStringBuilder3.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
            }
            SpannableString valueOf3 = SpannableString.valueOf("," + optString6);
            if (!TextUtils.isEmpty(valueOf3)) {
                valueOf3.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf3.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) valueOf3);
        } else if (str != null && jSONObject != null && str.equals(UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT)) {
            jSONObject.optString("pay_username");
            String optString7 = jSONObject.optString("tying_gift_name");
            int optInt = jSONObject.optInt("tying_status");
            JSONArray optJSONArray = jSONObject.optJSONArray("gift_member");
            a(spannableStringBuilder, bVar.Nw(), cVar, false, false);
            if (optJSONArray != null) {
                int i = 0;
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    String optString8 = optJSONArray.optJSONObject(i2).optString(LogConfig.VALUE_IM_GIFT);
                    if (optString8 != null && optString8.equals("1")) {
                        i++;
                    }
                }
                if (optInt == 0) {
                    String string2 = this.mContext.getString(a.h.ala_middle_context);
                    SpannableString valueOf4 = SpannableString.valueOf(" " + string2);
                    if (!TextUtils.isEmpty(valueOf4)) {
                        valueOf4.setSpan(new ForegroundColorSpan(-5864), 0, string2.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf4);
                    SpannableString valueOf5 = SpannableString.valueOf(" " + optString7 + " ");
                    if (!TextUtils.isEmpty(valueOf5)) {
                        valueOf5.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf5.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf5);
                    SpannableString valueOf6 = SpannableString.valueOf(this.mContext.getString(a.h.ala_tying_gift));
                    if (!TextUtils.isEmpty(valueOf6)) {
                        valueOf6.setSpan(new ForegroundColorSpan(-5864), 0, valueOf6.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf6);
                    SpannableString valueOf7 = SpannableString.valueOf(i + "/" + optJSONArray.length());
                    if (!TextUtils.isEmpty(valueOf7)) {
                        valueOf7.setSpan(new ForegroundColorSpan(-5864), 0, valueOf7.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf7);
                } else {
                    String string3 = this.mContext.getString(a.h.ala_tying_gift_middle);
                    SpannableString valueOf8 = SpannableString.valueOf(string3);
                    if (!TextUtils.isEmpty(valueOf8)) {
                        valueOf8.setSpan(new ForegroundColorSpan(-5864), 0, string3.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf8);
                    SpannableString valueOf9 = SpannableString.valueOf(" " + optString7 + " ");
                    if (!TextUtils.isEmpty(valueOf9)) {
                        valueOf9.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf9.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf9);
                    SpannableString valueOf10 = SpannableString.valueOf(this.mContext.getString(a.h.ala_tying_gift_behind));
                    if (!TextUtils.isEmpty(valueOf10)) {
                        valueOf10.setSpan(new ForegroundColorSpan(-5864), 0, valueOf10.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf10);
                }
            }
        } else if (str != null && jSONObject != null && str.equals("luckybag_send")) {
            a(spannableStringBuilder, bVar.Nw(), cVar, false, false);
            jSONObject.optString("user_nickname");
            jSONObject.optString("user_name");
            com.baidu.live.gift.g hc = ac.hc(jSONObject.optString(LogConfig.LOG_GIFT_ID));
            if (hc != null) {
                optString = hc.getThumbnail_url();
            } else {
                optString = jSONObject.optString("gift_url");
            }
            String optString9 = jSONObject.optString("gift_name");
            String optString10 = jSONObject.optString("gift_count");
            String format = String.format(this.mContext.getString(a.h.ala_rec_gift), optString9);
            SpannableString valueOf11 = SpannableString.valueOf(format);
            if (format != null) {
                valueOf11.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf11.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) valueOf11);
            if (optString != null) {
                AlaLiveMarkData alaLiveMarkData3 = new AlaLiveMarkData();
                alaLiveMarkData3.mark_pic = optString;
                alaLiveMarkData3.isWidthAutoFit = true;
                com.baidu.live.view.b bVar4 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData3, false, new b.a() { // from class: com.baidu.live.im.a.c.3
                    @Override // com.baidu.live.view.b.a
                    public void e(Bitmap bitmap) {
                        cVar.blJ.forceLayout();
                    }

                    @Override // com.baidu.live.view.b.a
                    public void a(com.baidu.live.view.b bVar5, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder4.setSpan(bVar4, 1, spannableStringBuilder4.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder4);
            }
            if (!TextUtils.isEmpty(optString10)) {
                SpannableString valueOf12 = SpannableString.valueOf("×" + optString10);
                valueOf12.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf12.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf12);
            }
        } else {
            a(spannableStringBuilder, bVar.Nw(), cVar, false, false);
            b w = w(bVar);
            String format2 = String.format(this.mContext.getString(a.h.ala_rec_gift), (w == null || TextUtils.isEmpty(w.giftName)) ? this.mContext.getString(a.h.sdk_gift) : w.giftName);
            SpannableString valueOf13 = SpannableString.valueOf(format2);
            if (format2 != null) {
                valueOf13.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf13.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) valueOf13);
            if (w != null && !TextUtils.isEmpty(w.aYy)) {
                AlaLiveMarkData alaLiveMarkData4 = new AlaLiveMarkData();
                alaLiveMarkData4.mark_pic = w.aYy;
                alaLiveMarkData4.isWidthAutoFit = true;
                com.baidu.live.view.b bVar5 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData4, false, new b.a() { // from class: com.baidu.live.im.a.c.4
                    @Override // com.baidu.live.view.b.a
                    public void e(Bitmap bitmap) {
                        cVar.blJ.forceLayout();
                    }

                    @Override // com.baidu.live.view.b.a
                    public void a(com.baidu.live.view.b bVar6, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder5.setSpan(bVar5, 1, spannableStringBuilder5.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder5);
            }
            a(spannableStringBuilder, w);
        }
        return spannableStringBuilder;
    }

    private void a(SpannableStringBuilder spannableStringBuilder, b bVar) {
        if (bVar != null) {
            String str = bVar.bpq;
            String str2 = bVar.bpr;
            if (!TextUtils.isEmpty(str)) {
                SpannableString valueOf = SpannableString.valueOf("×" + str);
                valueOf.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf);
            }
            if (!TextUtils.isEmpty(bVar.beN) && (!bVar.aLE || !TextUtils.equals(bVar.bpz, "luckybag"))) {
                SpannableString valueOf2 = SpannableString.valueOf("（" + bVar.beN + "）");
                valueOf2.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf2);
            }
            if (this.bpb && !bVar.boc && !TextUtils.isEmpty(str2)) {
                SpannableString valueOf3 = SpannableString.valueOf(String.format(this.mContext.getString(a.h.ala_rec_gift_charm_value), str2));
                valueOf3.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf3.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf3);
            }
            if (ac.hg(bVar.giftId) && !ac.he(bVar.giftId) && ac.hf(bVar.giftId)) {
                SpannableString valueOf4 = SpannableString.valueOf(this.mContext.getString(a.h.ala_dynamic_gift_downloading));
                valueOf4.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf4.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf4);
                l.d(bVar.giftId, bVar.bpp, bVar.msgId);
            }
            if (!bVar.boc && bVar.bpt != 0.0d && !TextUtils.isEmpty(bVar.bpu)) {
                com.baidu.live.im.view.b bVar2 = new com.baidu.live.im.view.b(this.mContext, bVar.bpt + "倍" + bVar.bpu, false, true, bVar.bpv, bVar.bpw, bVar.bpx, true);
                SpannableString spannableString = new SpannableString(" raterate");
                spannableString.setSpan(bVar2, 1, spannableString.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableString);
            }
            if (bVar.bpy != null) {
                for (int i = 0; i < bVar.bpy.length; i++) {
                    com.baidu.live.im.view.b bVar3 = new com.baidu.live.im.view.b(this.mContext, bVar.bpy[i].Na(), false, true, bVar.bpy[i].Nc(), bVar.bpy[i].Nd(), bVar.bpy[i].Nb());
                    SpannableString spannableString2 = new SpannableString(" raterate");
                    spannableString2.setSpan(bVar3, 1, spannableString2.length(), 33);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x011b A[Catch: JSONException -> 0x0160, TryCatch #0 {JSONException -> 0x0160, blocks: (B:3:0x0002, B:5:0x000a, B:6:0x0011, B:8:0x001f, B:9:0x004c, B:11:0x0055, B:12:0x008b, B:14:0x009a, B:15:0x00a2, B:17:0x00cf, B:18:0x00e9, B:21:0x00f3, B:23:0x0103, B:25:0x0109, B:26:0x0113, B:28:0x011b, B:30:0x0126, B:32:0x012e, B:33:0x0137, B:40:0x0165, B:36:0x015a, B:35:0x014e), top: B:42:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private b w(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        boolean z = true;
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject = new JSONObject(bVar.getContent());
            }
            b bVar2 = new b();
            JSONObject optJSONObject = jSONObject.optJSONObject("pk_info");
            if (optJSONObject != null) {
                bVar2.bpt = optJSONObject.optDouble("pk_honer_buff_multiple");
                bVar2.bpu = optJSONObject.optString("pk_honer_buff_text");
                bVar2.bpv = optJSONObject.optString("pk_honer_buff_text_color_start");
                bVar2.bpw = optJSONObject.optString("pk_honer_buff_text_color_end");
                bVar2.bpx = optJSONObject.optString("pk_honer_buff_text_font_color");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("headline_info");
            if (optJSONObject2 != null) {
                bVar2.bps = optJSONObject2.optString("second_text");
                bVar2.bpt = optJSONObject2.optDouble("headline_buff_multiple");
                bVar2.bpu = optJSONObject2.optString("headline_buff_text");
                bVar2.bpv = optJSONObject2.optString("headline_buff_text_color_start");
                bVar2.bpw = optJSONObject2.optString("headline_buff_text_color_end");
                bVar2.bpx = optJSONObject2.optString("headline_buff_text_font_color");
            }
            bVar2.parserJson(jSONObject);
            bVar2.msgId = bVar.getMsgId();
            if (bVar.Nw() != null) {
                bVar2.bpp = bVar.Nw().userId;
            }
            bVar2.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            bVar2.bpq = bVar.NE() + "";
            if (bVar.NG() > 0) {
                bVar2.bpr = bVar.NG() + "";
            } else {
                bVar2.bpr = "";
            }
            bVar2.boc = jSONObject.optInt("is_free") == 1;
            bVar2.bob = bVar.NF();
            com.baidu.live.gift.g hc = ac.hc(bVar2.giftId);
            if (hc != null) {
                if (hc.GG()) {
                    bVar2.giftName = this.mContext.getString(a.h.sdk_text_gift_graffiti);
                    if (TextUtils.isEmpty(bVar2.giftName)) {
                        bVar2.giftName = jSONObject.optString("gift_name");
                    }
                    if (!z && TextUtils.isEmpty(bVar2.aYy)) {
                        bVar2.aYy = jSONObject.optString("gift_url");
                    }
                    bVar2.beN = jSONObject.optString("gift_source_text");
                    bVar2.bpz = jSONObject.optString("gift_source");
                    bVar2.aLE = bVar.aLE;
                    return bVar2;
                }
                bVar2.giftName = hc.Gy();
                bVar2.aYy = hc.getThumbnail_url();
            }
            z = false;
            if (TextUtils.isEmpty(bVar2.giftName)) {
            }
            if (!z) {
                bVar2.aYy = jSONObject.optString("gift_url");
            }
            bVar2.beN = jSONObject.optString("gift_source_text");
            bVar2.bpz = jSONObject.optString("gift_source");
            bVar2.aLE = bVar.aLE;
            return bVar2;
        } catch (JSONException e) {
            return null;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public boolean aLE = false;
        public String aYy;
        public String beN;
        public double bob;
        public boolean boc;
        public String bpp;
        public String bpq;
        public String bpr;
        public String bps;
        public double bpt;
        public String bpu;
        public String bpv;
        public String bpw;
        public String bpx;
        public a[] bpy;
        public String bpz;
        public String giftId;
        public String giftName;
        public long msgId;

        public void parserJson(JSONObject jSONObject) {
            JSONArray optJSONArray;
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("im_icon_conf")) != null) {
                this.bpy = new a[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        this.bpy[i] = new a(optJSONArray.getJSONObject(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        public String bpl;
        public String bpm;
        public String bpn;
        public String bpo;

        public a(JSONObject jSONObject) {
            this.bpl = jSONObject.optString("text");
            this.bpm = jSONObject.optString("text_color");
            this.bpn = jSONObject.optString("bg_color_start");
            this.bpo = jSONObject.optString("bg_color_end");
        }

        public String Na() {
            return this.bpl;
        }

        public String Nb() {
            return this.bpm;
        }

        public String Nc() {
            return this.bpn;
        }

        public String Nd() {
            return this.bpo;
        }
    }
}
